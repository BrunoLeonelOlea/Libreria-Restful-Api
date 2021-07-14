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
    
    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }


    public Cliente crearCliente(Cliente cliente) throws Exception {
    	try {
    		 return clienteRepositorio.save(cliente);
    		 
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
       
    }

    public Cliente modificarCliente(long documento, Cliente cliente) throws ExcepcionServicio {


        Optional<Cliente> oCliente = clienteRepositorio.findById(documento);
        if (oCliente.isPresent()) {
            Cliente cliente1 = oCliente.get();
            cliente1 = clienteRepositorio.save(cliente);
            return cliente1;
        } else {
            throw new ExcepcionServicio("El id no esta relacionado a ningun cliente en la base de datos");
        }

    }
    
    public Cliente eliminarCliente(long documento) throws ExcepcionServicio{
        
        Optional<Cliente> oCliente = clienteRepositorio.findById(documento);
        if (oCliente.isPresent()) {
            Cliente cliente = oCliente.get();

            clienteRepositorio.delete(cliente);
            return cliente;
        } else {
            throw new ExcepcionServicio("El id no esta relacionado a ningun cliente en la base de datos");
        }

    }

 
    public Cliente buscarCliente(long documento) throws ExcepcionServicio{
        
        Optional<Cliente> oCliente = clienteRepositorio.findById(documento);
        if (oCliente.isPresent()) {
            Cliente cliente = oCliente.get();
            return cliente;
        } else{
            throw new ExcepcionServicio("El id no esta relacionado a ningun cliente en la base de datos");
        }
    }


   
}