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
        <p>Below is a list of charts that will be exported when the 'Generate Report' button is pressed.</p>
    </div>
</div>
<div class="row" id = "progressBarOverview">
    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar"
                 aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width:100%">
                Loading
            </div>
        </div>
    </div></div>
<div class="row" >
    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
        
            <div id = "reportList">
               
            </div>
       
    </div></div>
<div class="row" >
    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
        
            <div id = "generateReport">
               
            </div>
       
    </div></div>
<script>
 $(document).ready(function () {

            $.ajax({
                type: "POST",
                url: "/StudentAnalytics/ReportList",
                
                dataType:'json',
                success: function (data, textStatus, request) {
                  console.log("This is the response "+data['pdfChartList']);
                  $.each(data['pdfChartList'],function(index, value){
                      imageElem = '<div class="row"><input type="checkbox" id="listCheckBox'+index+'"><img src="'+value+'" id="listImage'+index+'" height="40%" width="40%"></div>';
                      $('#reportList').append(imageElem);
                      
                  });
                  $('#generateReport').html('<button id="generateReportButton" onclick="generateReport();" class="btn btn-default"><span><img src="images/glyphicons-151-edit.png" height="15px" width="15px" style="margin-right: 6px"></span>  Generate Report!</button>')
                  $('#progressBarOverview').hide();
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    $('#progressBarOverview').hide();
                    console.log(xhr.status);
                    console.log(thrownError);
                }
            });

        
    });
    

    
    function generateReport()
    {
        console.log("Pass selected checkbox images to the report generator pdf");
    }

</script>
