<%-- 
    Document   : generateReport
    Created on : Nov 23, 2015, 8:15:25 PM
    Author     : Akshima, madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Generate PDF Report!</h1>
        <form action="ReportGenerator" method="POST">
            <input type="button" value="Show Added Charts" id="showChart" name="showChart">
        </form>
    </body>
   </html>

<div id="chartDiv">
    
</div>
<script>
 $(document).ready(function () {

            console.log("showChart button clicked!");

            showChart = "showChart";
            $.ajax({
                type: "POST",
                url: "/StudentAnalytics/ReportListServlet",
                data: {},
                dataType:'json',
                cache: false,
                datatype: "application/json",
                success: function (data) {
                  console.log(data);
                  
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    console.log(xhr.status);
                    console.log(thrownError);
                }
            });

        
    });

   
</script>
