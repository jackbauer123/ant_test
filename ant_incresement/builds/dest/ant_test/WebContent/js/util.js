var modulus = null, exponent = null;
$.ajax({
	url : "getPublicKey.do",
	type : "get",
	async : false,
	success : function(data) {
		var obj = JSON.parse(data)
		modulus = obj.modulus;
		exponent = obj.exponent;

	}

});

$("#buttons").on('click', function() {
	var epwd = $('#test').val();
	if (epwd.length != 256) {
		var publicKey = RSAUtils.getKeyPair(exponent, '', modulus);
		$('#test').val(RSAUtils.encryptedString(publicKey, epwd));
	}
	var passwd = $("#test").val();
	$.ajax({
		url : "login.do",
		type : "get",
		data : {
			'test' : passwd
		},
		success : function(data) {
			console.info(data);
		}

	});
});