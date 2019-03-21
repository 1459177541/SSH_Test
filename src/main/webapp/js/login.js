// JavaScript Document
function commit() {
    var d = JSON.stringify({id:$("#user_id").val(),password:$.sha1($("#user_pwd").val())});
    $(".submit").attr("disabled","disabled");
    $.ajax({
        url: "/loginTo",
        method: "POST",
        async: false,
        contentType: "application/json",
        datatype: "json",
        cache: false,
        data: d,
        success: function (data) {
            alert(data);
            var result = eval("("+data+")");
            alert(result);
            if (result.status === 'SUCCESS') {
                window.location.href = "/index";
            } else {
                $("#error").html(result.status+":"+result.info);
                $(".submit").removeAttr("disabled");
            }
        }
    });
}
$(document).ready(function() {
    $(".submit").click(commit);
});