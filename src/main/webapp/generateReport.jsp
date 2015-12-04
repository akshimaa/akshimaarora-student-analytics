<%-- 
    Document   : generateReport
    Created on : Nov 23, 2015, 8:15:25 PM
    Author     : Akshima, madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Report Generator</h1>
    </div>
</div>
<div class="row" id = "progressBarOverview">
    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
        <div class="progress">
            <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar"
                 aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:100%">
                Loading
            </div>
        </div>
    </div></div>
<script>
 $(document).ready(function () {

            $.ajax({
                type: "POST",
                url: "/StudentAnalytics/ReportList",
                data: "",
                dataType:'application/json',
                success: function (data) {
                  console.log("This is the response "+data);
                  $('#progressBarOverview').hide();
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    $('#progressBarOverview').hide();
                    console.log(xhr.status);
                    console.log(thrownError);
                }
            });

        
    });

   
</script>
