materialAdmin.controller('RoleController', function($scope, UserService) {
	var nodeTree = undefined;

	var service = {
		initNodeTree : function(data) {
			nodeTree = new dhtmlXTreeObject("nodeTree-div", "100%", "100%", 0);
			nodeTree.setImagesPath("vendors/dhtmlxTree_v50_std/sources/dhtmlxTree/codebase/imgs/dhxtree_skyblue/");
			console.log(JSON.stringify(data));
			nodeTree.parse({
				id : 0,
				item : data
			}, 'json');
		},
		convertNode2AllTreeData : function(nodes) {
			var level = 0;
			var data = [];

			(function _convert(nodes) {
				var num = 10000 * ++level;

				nodes.forEach(function(node, index) {
					node.id = num + index;
					node.text = node.name;
					node.item = node.nodes;
					if (node.type === 'BUTTON'){
						node.im0 = node.im1 = node.im2 = node.css + '.gif';
						console.log(node);
					}
					
					if (node.item && node.item.length > 0) {
						_convert(node.item);
					}
				});
			})(nodes);

			return nodes;
		}
	};

	UserService.getAllMenu().then(function(response) {
		service.initNodeTree(service.convertNode2AllTreeData(response));
	}, function(response) {
		console.log("Error", response);
	});

	$scope.$on('$destroy', function() {
		if (nodeTree && nodeTree.destructor) {
			nodeTree.destructor();
		}
	});
});