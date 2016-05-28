var app = angular.module('mainApp',['ngRoute']);
app.controller('mainCtrl',function($rootScope, $scope, $http, $location){

	//get initial information
	$http.get('rest/initInfo').then(
		function(result){
			//alert(JSON.stringify(result.data, null, 4));
			
			//test error
			if(result.data.error){
				alert(result.data.message);
				window.location="/login?logout";
				return;
			}
			
			//get user bean
			$rootScope.userInfo = result.data.userInfo;
			
			//get first level app list
			$rootScope.appList = result.data.appList;

		}, 
		function(result){
			
		}
	);
	
	//get admin user
	$http.get('rest/isAdmin').then(
		function(result){
			$rootScope.isAdmin = true;
		}, 
		function(result){
			$rootScope.isAdmin = false;
		}
	);
	
	
	$http.get('rest/books').then(
		function(result){
			$scope.books = result.data;
		}, 
		function(result){
			
		}
	);
		
	
	$scope.logout = function() {
		$http.post('logout', {}).finally(function(){
			window.location="/login?logout";
		});
	};

});