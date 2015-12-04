
<%-- 
    Document   : overview
    Created on : Nov 25, 2015, 1:47:47 AM
    Author     : Madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Dashboard</h1>
        <p>Welcome to the Carnegie Mellon University College Student Index!</p>

        <p>This is a visualization and analytics tool for the examination of current and prospective student data.</p>
        <p>The following features are currently implemented in this system:</p>
        <ul><li>Data upload to AWS S3 bucket</li>
            <li>Pie chart generation</li>
            <li>Bar chart generation</li>
            <li>Predictive analytics (prediction of prospective student GPA)</li>
            <li>Summary .pdf report generation</li></ul>

        <p>In order to upload a .csv file to the database, please use the file upload widget on the sidebar. If uploaded data is to be merged with existing data in AWS S3, please check the 'Merge into database' checkbox.</p>
    </div>
</div>
<div class="row" id = "progressBarOverview">
    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
        <div class="progress">
            <div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar"
                 aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:100%">
                Loading
            </div>
        </div>
    </div></div>

<div class="row"><div class="col-lg-12">
        <div  id="chartPanel">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Bar Chart Visualization
                        <div class="pull-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                    Actions
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu pull-right" role="menu">
                                    <li id="barChoiceOne" value="basisAdmission"><a href="javascript:;" onclick = "generateOveriewBar('basisAdmission');">Basis for Admission</a></li>
                                    <li id="barChoiceTwo" value="degreeLevel_gender"><a href="javascript:;" onclick = "generateOveriewBar('degreeLevel_gender');">Degree by Gender</a></li>

                                    <li class="divider"></li>
                                    <li><a href="javascript:;" onclick="addToReport('barChart');">Add to Report</a>
                                    </li>

                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div id ="chartDiv" class="row" style="margin-left: 8%;">
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div  id="pieChartPanel" >
            <div class="col-lg-6">
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
                                    <li id="pieChoiceOne" value="disability_regionalRemote_womenNonTraditionalRole_lowIncome"><a href="javascript:;" onclick = "generateOveriewPie('disability_regionalRemote_womenNonTraditionalRole_lowIncome');">Enrollment by equity data</a></li>
                                    <li id="pieChoiceTwo" value="gender"><a href="javascript:;" onclick = "generateOveriewPie('gender');">Enrollment by gender</a></li>

                                    <li class="divider"></li>

                                    <li><a href="javascript:;" onclick="addToReport('pieChart');">Add to Report</a>
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
    </div></div>    

<script>

    $(document).ready(function () {
        $('#chartPanel').hide();
        $('#pieChartPanel').hide();
        $('.selectpicker').selectpicker();
        console.log();


        preset = $('#barChoiceOne').attr('value');

        //bar chart ajax
        $.ajax({
            type: "POST",
            url: "/StudentAnalytics/BarChart",
            data: {datasource: 'OriginalData', preset: preset},
            cache: false,
            datatype: "application/json",
            success: function (data, textStatus, request) {
                $('#progressBarOverview').hide();
                $('#chartPanel').fadeIn("fast", function () {
                    $(this).show();
                });
                $('#chartDiv').html('<img src="' + data.chart + '" height="300" width="400" id="barChart" />');
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(thrownError);
            }
        });
        //pie chart ajax  
        presetPie = $('#pieChoiceOne').attr('value');
        $.ajax({
            type: "POST",
            url: "/StudentAnalytics/PieChart",
            data: {datasource: 'OriginalData', preset: presetPie},
            cache: false,
            datatype: "application/json",
            success: function (data, textStatus, request) {
                $('#pieChartPanel').fadeIn("fast", function () {
                    $(this).show();
                });
                $('#pieChartDiv').html('<img src="' + data.chart + '" height="300" width="400" id="pieChart" />');
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(thrownError);
            }

        });

    });

    function generateOveriewBar(value)
    {

        $('#chartDiv').fadeTo("fast", 0.0);
        console.log(value);
        $.ajax({
            type: "POST",
            url: "BarChart",
            data: {datasource: 'OriginalData', preset: value},
            cache: false,
            datatype: "application/json",
            success: function (data, textStatus, request) {

                $('#chartDiv').fadeTo("slow", 1.0);
                $('#chartDiv').html('<img src="' + data.chart + '" height="300" width="400" id="barChart"/>');
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(thrownError);
            }

        });
    }

    function generateOveriewPie(value)
    {

        $('#pieChartDiv').fadeTo("fast", 0.0);
        console.log(value);
        $.ajax({
            type: "POST",
            url: "PieChart",
            data: {datasource: 'OriginalData', preset: value},
            cache: false,
            datatype: "application/json",
            success: function (data, textStatus, request) {

                $('#pieChartDiv').fadeTo("slow", 1.0);
                $('#pieChartDiv').html('<img src="' + data.chart + '" height="300" width="400" id="pieChart" />');
            },
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(thrownError);
            }

        });
    }

    function addToReport(value)
    {
        console.log('add to report');
        console.log(value);
        var filePath = document.getElementById(value).getAttribute('src');
        console.log("File Path =" + filePath);

        $.ajax({
            type: "POST",
            url: "PDFReportCreator",
            data: {filePath: filePath},
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