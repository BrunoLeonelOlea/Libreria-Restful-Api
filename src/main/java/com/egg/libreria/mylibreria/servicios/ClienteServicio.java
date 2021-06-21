package com.egg.libreria.mylibreria.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.libreria.mylibreria.entidades.Cliente;
import com.egg.libreria.mylibreria.excepciones.ExcepcionServicio;
import com.egg.libreria.mylibreria.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public void crearCliente(long documento, String nombre, String apellido, String domicilio, String telefono) throws Exception {

        validar(documento, nombre, apellido, domicilio, telefono);

        Cliente cliente = new Cliente();

        cliente.setDocumento(documento);
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setDomicilio(domicilio);
        cliente.setTelefono(telefono);

        clienteRepositorio.save(cliente);

    }

    public void modificarCliente(long documento, String nombre, String apellido, String domicilio, String telefono) throws ExcepcionServicio {

        validar(documento, nombre, apellido, domicilio, telefono);

        Optional<Cliente> oCliente = clienteRepositorio.findById(documento);
        if (oCliente.isPresent()) {
            Cliente cliente = oCliente.get();
            
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDomicilio(domicilio);
            cliente.setTelefono(telefono);

            clienteRepositorio.save(cliente);
        } else {
            throw new ExcepcionServicio("El id no esta relacionado a ningun cliente en la base de datos");
        }

    }
    
    public void eliminarCliente(long documento) throws ExcepcionServicio{
        
        Optional<Cliente> oCliente = clienteRepositorio.findById(documento);
        if (oCliente.isPresent()) {
            Cliente cliente = oCliente.get();

            clienteRepositorio.delete(cliente);
        } else {
            throw new ExcepcionServicio("El id no esta relacionado a ningun cliente en la base de datos");
        }

    }

    // por el ID
    public Cliente buscarCliente(long documento) throws ExcepcionServicio{
        
        Optional<Cliente> oCliente = clienteRepositorio.findById(documento);
        if (oCliente.isPresent()) {
            Cliente cliente = oCliente.get();
            return cliente;
        } else{
            throw new ExcepcionServicio("El id no esta relacionado a ningun cliente en la base de datos");
        }
    }


    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    public void validar(long documento, String nombre, String apellido, String domicilio, String telefono) throws ExcepcionServicio {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ExcepcionServicio("debe ingresar un nombre");
        }

        if (apellido == null || apellido.trim().isEmpty()) {
            throw new ExcepcionServicio("debe ingresar un apellido");
        }

        if (domicilio == null || domicilio.trim().isEmpty()) {
            throw new ExcepcionServicio("debe ingresar un domicilio");
        }
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new ExcepcionServicio("debe ingresar un telefono");
        }
        if (buscarCliente(documento) != null) {
            throw new ExcepcionServicio("El cliente ya existe");
        }

    }
}