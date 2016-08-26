materialAdmin.controller('RoleController', function($scope, UserService) {
	UserService.getAllMenu().then(function(response) {
		$scope.nodes = response;
	}, function(response) {
		console.log("Error", response);
	});
});