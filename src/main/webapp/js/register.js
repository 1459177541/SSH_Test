// JavaScript Document
function commit() {
    if (!check_pass()) {
        return;
    }
    if ($("#user_pwd").val() === "") {
        $("#error").html("密码为空");
        return;
    }
    if ($("#user_name").val() === "") {
        $("#error").html("密码为空");
        return;
    }
    $(".submit").css("background", "white");
    $(".submit").attr("disabled","disabled");
    var d = JSON.stringify({
        id: $("#user_id").val(),
        name: $("#user_name").val(),
        password: $.sha1($("#user_pwd").val())
    });
    $.ajax({
        url: "/registerTo",
        method: "POST",
        async: false,
        contentType: "application/json",
        datatype: "json",
        cache: false,
        data: d,
        success: function (data) {
            var result = eval("("+data+")");
            if (result.result === 'success') {
                window.location.href = "/index";
            } else if (result.result === 'fail') {
                alert(result);
                $("#error").html(result.status + ":" + result.info);
            } else {
                alert(result);
            }
            $(".submit").css("background", "rgba(150, 255, 150, 0.7)");
            $(".submit").removeAttr("disabled");
        }
    });
}

function checkName() {
    if ($("#user_id").val() === "") {
        $("#user_pwd2").css("border-bottom", "red 3px solid");
        $("#error").html("请输入用户名");
    }
    var d = JSON.stringify({id:$("#user_id").val()});
    $.ajax({
        url: "/checkUserName",
        method: "POST",
        async: true,
        contentType: "application/json",
        datatype: "json",
        cache: false,
        data: d,
        success: function (data) {
            var result = eval("("+data+")");
            if (result.result === 'exist') {
                $("#user_id").css("border-bottom", "red 3px solid");
                $("#error").html("用户已存在");
            }else if (result.result === 'non-exist') {
                $("#user_id").css("border-bottom", "green 3px solid");
            }else {
                alert(result);
            }
        }
    });
}

function check_pass(){
    var ok = $("#user_pwd").val() === $("#user_pwd2").val();
    if (!ok) {
        $("#user_pwd").css("border-bottom", "red 3px solid");
        $("#user_pwd2").css("border-bottom", "red 3px solid");
        $("#error").html("两次输入密码不一样");
    } else {
        $("#error").html(" ");
        $("#user_pwd").css("border-bottom", "green 3px solid");
        $("#user_pwd2").css("border-bottom", "green 3px solid");
    }
    return ok;
}

function pass_blur(){
    check_pass();
    if ($("#user_pwd2").val() === "") {
        $("#error").html("密码为空");
        return;
    }
}

$(document).ready(function() {

    $(".submit").click(commit);

    $("#user_pwd").focus(function () {
        $("#user_pwd").css("border-bottom", "blue 3px solid");
        $("#user_pwd2").css("border-bottom", "white 3px solid");
        $("#error").html("");
    });

    $("#user_pwd2").focus(function () {
        $("#user_pwd").css("border-bottom", "white 3px solid");
        $("#user_pwd2").css("border-bottom", "blue 3px solid");
        $("#error").html("");
    });

    $("#user_pwd").blur(pass_blur);

    $("#user_pwd2").blur(pass_blur());

    $("#user_id").focus(function () {
        $("#user_id").css("border-bottom", "blue 3px solid");
    });

    $("#user_id").blur(checkName);

});