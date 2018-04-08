//criação do modulo principal da aplicação	       

var appCliente  = angular.module("appCliente",[]); 

//Criação de controllers
														
appCliente.controller("indexController",function($scope,$http){
	$scope.btnSal = true;
	$scope.clientes =[];
	$scope.cliente={};
	$scope.getClientes = function(){
		
		
		$http.get("http://localhost:8090/clientes")
	.then( function successCallback(response){

		$scope.clientes = response.data;
		
	}, function errorCallback(response){
		console.log(response.data);
		console.log(response.status);
		
	});
	
}
	$scope.getClientes();

	$scope.salvarCliente = function(){
		
		
		$http.post("http://localhost:8090/clientes",$scope.cliente).then( function successCallback(response){

			$scope.getClientes();
			$scope.cancelarEditar();
			
		}, function errorCallback(response){
			console.log(response.data);
			console.log(response.status);
			
		});
		
	}
	
	$scope.excluirCliente = function(cliente){
		
		
		$http.delete("http://localhost:8090/clientes/"+cliente.id).then( function successCallback(response){
			//Buscar posição do cliente no array
			
			pos = $scope.clientes.indexOf(cliente);
			
			$scope.clientes.splice(pos,1);
			
			
		}, function errorCallback(response){
			console.log(response.data);
			console.log(response.status);
			
		});
		
	}
	

	$scope.editarCliente = function(cliente){
		var clienteCopia = angular.copy(cliente) ;
	
		$scope.cliente = clienteCopia;
		$scope.btnAlt = true;
		$scope.btnSal = false;

	}
	
	$scope.cancelarEditar = function(){
		$scope.cliente = {};
		$scope.btnAlt = false;
		$scope.btnSal = true;
		
	}
	
	
	
	$scope.alterarCliente = function(){
		$http.put("http://localhost:8090/clientes/",$scope.cliente).then( function successCallback(response){

			$scope.getClientes();
			$scope.cancelarEditar();
			
			
			
		}, function errorCallback(response){
			console.log(response.data);
			console.log(response.status);
			
		});
		
	}
	
});