<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    <title>卖家管理平台</title>
    <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        function login() {
            $.ajax({
                //几个参数需要注意一下
                type: "POST",//方法类型
                dataType: "json",//预期服务器返回的数据类型
                url: "localhost:8080/myUser/user/login" ,
                data: $('#form').serialize(),
                success: function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
                    }
                    ;
                },
                error : function() {
                    alert("登录异常！");
                }
            });
        }
    </script>
</head>
<body>
<div class="container">
    <#include "head.ftl">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row clearfix">
                <div class="col-md-10 column">
                    <#--<form role="form" action="/user/login">-->
                    <#--<form role="form" action="localhost:8080/myUser/user/login" >无法正常访问到-->
                    <form role="form">
                        用户名<input type="text" name="userName" width="100px"/>
                        密 码<input type="password" name="password"/>
                        <button type="button" class="btn btn-default" onclick="login()">提交</button>
                    ${msg!}
                    </form>
                </div>
            </div>
        </div>
    </div>
    <#include "foot.ftl">
</div>
</body>
</html>