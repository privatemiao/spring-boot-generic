materialAdmin.service('UserService', [ '$http', '$q', function($http, $q) {
	var variables = {
		allMenu : undefined
	};
	return {
		getAllMenu : function() {
			var deferred = $q.defer();
			if (variables.allMenu) {
				deferred.resolve(angular.copy(variables.allMenu));
			} else {
				$http.get('generic/security/allmenu').then(function(response) {
					if (response.data) {
						variables.allMenu = response.data.data;
					}
					deferred.resolve(angular.copy(variables.allMenu));
				}, function(error) {
					deferred.reject(error);
				});
			}
			return deferred.promise;
		}
	};
} ])