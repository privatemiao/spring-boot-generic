materialAdmin.controller('RoleController', function($scope, UserService) {
	// 本地全局变量
	var variables = {
		ALL_NODES : [],
		NODE_INDEX : {},
		nodeTree : undefined
	};

	// 本地全局服务对象
	var service = {
		indexNodes : function() {
			var nodes = angular.copy(variables.ALL_NODES);
			(function _parse(nodes) {
				nodes.forEach(function(node) {
					variables.NODE_INDEX[node.uri] = node;
					if (node.nodes && node.nodes.length > 0) {
						_parse(node.nodes);
					}
				});
			})(nodes);
		},

	};

	// 页面交互变量
	$scope.variables = {
		/* 页面操作类型 listRole, newRole, editRole */
		operate : 'listRole',
		/* 用户新增、变更角色的对象 */
		role : {}
	};

	/*--------------------------------------------
	 |       I  N  I  T  I  A  L  I  Z  E        |
	 ============================================*/
	(function() {
		UserService.getAllMenu().then(function(response) {
			variables.ALL_NODES = response;
			service.indexNodes();
		}, function(response) {
			console.log("Error", response);
		});
	})();

	// var nodeTree;
	//
	// var service = {
	// initNodeTree : function(data) {
	// nodeTree = new dhtmlXTreeObject("nodeTree-div", "100%", "100%", 0);
	// nodeTree.setImagesPath("vendors/dhtmlxTree_v50_std/sources/dhtmlxTree/codebase/imgs/dhxtree_skyblue/");
	// console.log(JSON.stringify(data));
	// nodeTree.parse({
	// id : 0,
	// item : data
	// }, 'json');
	// },
	// convertNode2AllTreeData : function(nodes) {
	// var level = 0;
	// var data = [];
	//
	// (function _convert(nodes) {
	// var num = 10000 * ++level;
	//
	// nodes.forEach(function(node, index) {
	// node.id = num + index;
	// node.text = node.name;
	// node.item = node.nodes;
	// if (node.type === 'BUTTON'){
	// node.im0 = node.im1 = node.im2 = node.css + '.gif';
	// console.log(node);
	// }
	//					
	// if (node.item && node.item.length > 0) {
	// _convert(node.item);
	// }
	// });
	// })(nodes);
	//
	// return nodes;
	// }
	// };
	//
	// UserService.getAllMenu().then(function(response) {
	// service.initNodeTree(service.convertNode2AllTreeData(response));
	// }, function(response) {
	// console.log("Error", response);
	// });
	//
	/*--------------------------------------------
	 |            D  E  S  T  R  O  Y            |
	 ============================================*/
	$scope.$on('$destroy', function() {
		if (variables.nodeTree && variables.nodeTree.destructor) {
			variables.nodeTree.destructor();
		}
	});
});