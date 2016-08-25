var data = {
  pageSize : 10,
  pageNumber : 0
};

$.ajax({
	url : 'generic/auth/user',
	method : 'POST',
	contentType : 'application/json',
	data : JSON.stringify(data),
	success : function(response) {
		console.log(response);
	},
	error : function(response) {
		console.error(response);
	}
});