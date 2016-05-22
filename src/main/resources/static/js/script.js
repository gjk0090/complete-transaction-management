var app = angular.module('mainApp',['ngRoute']);
app.controller('mainCtrl',function($rootScope, $scope, $http, $location){

	$http.get('rest/initInfo').then(
		function(result){
			$rootScope.userId = result.data.userId;
			//alert(JSON.stringify(result.data));
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