var app = angular.module('mainApp',['ngRoute']);
app.controller('mainCtrl',function($rootScope, $scope, $http, $location){

	//get initial information
	$http.get('rest/initInfo').then(
		function(result){
			//alert(JSON.stringify(result.data));
			
			//test error
			if(result.data.error){
				alert(result.data.message);
				window.location="/login?logout";
				return;
			}
			
			//get user bean
			$rootScope.userInfo = result.data.userInfo;
			
			//build app list
			$rootScope.appList = [];
			result.data.appList.forEach(function(app){
				if(app.parentAppId === 0){
					app.childApps = [];
					$rootScope.appList.push(app);
				}
			});
			result.data.appList.forEach(function(app){
				$rootScope.appList.forEach(function(parentApp){
					if(parentApp.appId === app.parentAppId){
						parentApp.childApps.push(app);
					}
				});
			});
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