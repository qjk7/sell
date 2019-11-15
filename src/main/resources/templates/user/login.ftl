<html>
<#include "../common/header.ftl">

<body>

<div class="container" style="margin-top: 20px;">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" method="post" action="/sell/seller/login">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户名</label><input type="text" class="form-control" name="username" value="${username!''}" />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label><input type="password" class="form-control" name="password" />
                </div>

                 <button type="submit" class="btn btn-default">确定</button>
            </form>
        </div>
    </div>
</div>


</body>

</html>

