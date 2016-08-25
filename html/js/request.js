// ========================================
// ---------------Query User
// ========================================
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

// ========================================
// ---------------Create User
// ========================================
var data = {
	loginId : 'privatemiao',
	password : 'P@ssw0rd',
	userStatus : 'NORMAL',
	name : 'Mel Liu',
	mobile : '13451567003',
	email : 'privatemiao@gmail.com'
};

$.ajax({
	url : 'generic/auth/user/new',
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