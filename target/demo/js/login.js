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
            var result = eval("("+data+")");
            if (result.status === 'LOGIN_SUCCESS' || result.status === 'WAIT_ADOPT') {
                alert($.session.get('user'));
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