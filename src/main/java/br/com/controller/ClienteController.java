package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.model.Cliente;
import br.com.service.ClienteSerivce;



@RestController
public class ClienteController {
	
	@Autowired
	private ClienteSerivce clienteService;
	
	
	
	
	@RequestMapping(method = RequestMethod.POST, value="/clientes",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente){
		cliente.setId(0);
		clienteService.cadastrar(cliente);
		
		return new ResponseEntity<Cliente>(cliente,HttpStatus.CREATED);
	}
	@RequestMapping(method = RequestMethod.GET, value="/clientes",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List> buscarTodosClientes(){
		
		List<Cliente> clienteBuscados = clienteService.buscarTodos();
		
		return new ResponseEntity<>(clienteBuscados,HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.DELETE, value="/clientes/{id}")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable("id") Integer id) throws Exception{
		
		Cliente cliente  = clienteService.buscarPorId(id);
		
		clienteService.excluir(cliente);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/clientes",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente){
		clienteService.alterar(cliente);
		
		return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
	}
}
