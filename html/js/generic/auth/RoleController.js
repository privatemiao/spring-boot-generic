materialAdmin.controller('RoleController', function($scope, UserService) {
	UserService.getAllMenu().then(function(response) {
		$scope.nodes = response;
		console.log($scope.nodes);
	}, function(response) {
		console.log("Error", response);
	});
});