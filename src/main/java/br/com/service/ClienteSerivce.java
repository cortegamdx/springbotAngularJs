package br.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.model.Cliente;
import br.com.repository.ClienteRepository;


@Service
public class ClienteSerivce {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public void cadastrar(Cliente cliente) {
	
		clienteRepository.save(cliente);
		
	}
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public void excluir(Cliente cliente) {
		
		clienteRepository.delete(cliente);
	}

	public Cliente buscarPorId(Integer id) throws Exception{
	
		Cliente cliente = clienteRepository.getOne(id);
		
		return cliente;
	}
	
	public Cliente alterar(Cliente client) {
		return clienteRepository.save(client);
	}
	
}
