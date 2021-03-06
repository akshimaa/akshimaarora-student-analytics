<%-- 
    Document   : pieChart
    Created on : Nov 24, 2015, 8:44:41 PM
    Author     : Melissa Burns, Akshima Arora
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 <link href="css/cmu-dropdowns.css" rel="stylesheet" type="text/css">
    <div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Pie Chart</h1>
        <p>This is the pie chart generation tool to generate summary pie charts based on selected data.</p>
        <p>Please select a data source and the desired variable combination then press the submit button to continue.</p>
    </div>
  
</div>

<div class="row">
    <div class="col-lg-12">
                <div class="alert alert-danger" id="errorMessageOuterDiv" style="display:none;">
                    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <div id="errorStatusDiv"></div>
                </div>
                <div class="alert alert-success" id="successMessageOuterDiv" style="display:none">
                    <a href="#" class="close"  data-dismiss="alert" aria-label="close">&times;</a>
                    <div id="successStatusDiv"></div>

                </div>

    </div>
    <!-- /.col-lg-12 -->
</div> 
 
<div class="row">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <div class="dropdown" style="margin-bottom: 24px" >
                
                <select class="selectpicker cmu-dropdown" style="width: 123px;" name=""  id="datasourceDropdown">
                   
                    <option value="OriginalData"><a href="#">Original Data</a></option>
                    <option value="UploadedData"><a href="#">Uploaded Data</a></option>
                    <option value="MergedData"><a href="#">Merged Data</a></option>
                </select>
            
           
                <select class="selectpicker cmu-dropdown" style="width: 123px;" name="" id="presetDropdown">
                   <option value="attendanceType"><a href="#">Attendance Type</a></option>
                    <option value="courseInformation"><a href="#">Course Information</a></option>
                    <option value="degreeLevel"><a href="#">Degree Level</a></option>
                    <option value="gender" ><a href="#">Gender</a></option>
                    <option value="languageSpokenAtHome"><a href="#">Language</a></option>
                    <option value="entranceExam"><a href="#">Entrance Exam</a></option>
                    <option value="basisAdmission"><a href="#">Basis of Admission</a></option>
                    <option value="disability_regionalRemote_womenNonTraditionalRole_lowIncome"><a href="#">Equity Data</a></option>
                             
                </select>
                <div class="btn-group bootstrap-select cmu-dropdown">
                    <button id="generatePie"  class="btn btn-default"><span><img src="images/glyphicons-43-pie-chart.png" height="15px" width="15px" style="margin-right: 6px"></span> Generate Pie!</button>

                </div>
                </div>
            </div>
         </div>

     </div>

<div class="row" id = "progressBarOverview">
    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar"
                 aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:100%">
                Loading
            </div>
        </div>
    </div></div>
<div  id="chartPanel" class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Generated Pie Chart
                <div class="pull-right">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                            Actions
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu pull-right" role="menu">

                            <li><a href="javascript:;" onclick="addToReport();">Add to Report</a>
                            </li>

                        </ul>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <div id ="pieChartDiv" class="row" style="margin-left: 8%;">
                </div>
            </div>
        </div>

    </div>
</div>



<script>
    $( document ).ready(function() {
         $('#progressBarOverview').hide();
        $('#chartPanel').hide();
        $('.selectpicker').selectpicker();
    $('#generatePie').click(function(){
         $('#progressBarOverview').show();
        $('#pieChartDiv').html('');
        $('#chartPanel').hide();
        console.log("generate button clicked!");
        console.log($('#datasourceDropdown').val());
        console.log($('#presetDropdown').val());
        datasource = $('#datasourceDropdown').val();
        preset = $('#presetDropdown').val();

        $.ajax({
            type: "POST",
            url: "PieChart",
            data: {datasource:datasource, preset:preset},
            cache: false,
            datatype: "application/json",
            success: function(data, textStatus, request){
                $('#progressBarOverview').hide();
                        $('#chartPanel').fadeIn("slow", function () {
                        $(this).show();
                    });
                    $('#pieChartDiv').html('<img src="' + data.chart + '" id="pieChart" />');},
            error: function (xhr, ajaxOptions, thrownError) {
                 $('#progressBarOverview').hide();
                console.log(xhr.status);
                console.log(thrownError);
         }
        });
         
    }); 
     
  }); 
  function addToReport()
    {
        console.log('add to report');
         var filePath = document.getElementById('pieChart').getAttribute('src');
         console.log("File Path ="+ filePath);
        $.ajax({
            type: "POST",
            url: "PDFReportCreator",
           data: {filePath:filePath},
            cache: false,
            datatype: "application/json",
            success: function (data, textStatus, request) {
                $('#successMessageOuterDiv').fadeIn("slow", function () {
                    $('#successStatusDiv').html("<strong>SUCCESS!</strong>Sucessfully added the chart to report!");
                    $(this).show();
                });
            },
            error: function (xhr, ajaxOptions, thrownError) {
                $('#errorMessageOuterDiv').fadeIn("slow", function () {
                    $('#errorStatusDiv').html("<strong>ERROR!</strong> Error adding the chart to report!");
                    $(this).show();
                });
            }
        });
    }
</script>
<!-- /.row -->



