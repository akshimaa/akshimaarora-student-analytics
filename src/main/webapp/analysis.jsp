<%-- 
    Document   : analysis
    Created on : Nov 25, 2015, 5:24:25 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Predictive Analytics</title>
    </head>
    <body>
        <h1>PREDICTIVE ANALYTICS FTW!</h1>

        <form action="histogram" method="post" enctype="multipart/form-data">
            <input id="upload-input" class="form-control" type="file" name="file" accept=".csv" style="width: 250px"/>
            <span class="input-group-btn">
                <button class="btn btn-default" type="submit" value="upload">
                    <i class="fa fa-histogram"></i>
                </button>
            </span>
        </form> 
    </body>
</html>
