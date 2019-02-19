// JavaScript Document

function commit(to){
    alert(to);
	$("input.input").attr("disabled","disabled");
	var d = JSON.stringify($('form').serializeObject());
	alert(d);
	jQuery.ajax({
		url:to,
		type:'POST',
		async:false,
		contentType : 'application/json',
		datatype:'json',
		data:d,
		success:function(data){
			alert(data);
			$("input.input").remove("disabled");
		},
		error:function(response, ajaxOptions, thrownError){
			alert("error");
		}
	})
}