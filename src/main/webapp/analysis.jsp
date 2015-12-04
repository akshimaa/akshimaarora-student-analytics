<%-- 
    Document   : analysis
    Created on : Nov 25, 2015, 5:24:25 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script src="js/jquery-2.1.4.js" type="text/js"></script>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Predictive Analysis</h1>
        <p>This is the predictive analytics tool to predict prospective student GPA values.
        <p>Please select a .csv file and a type of predictive algorithm then press the submit button to continue.</p>
    </div>
    <!-- /.col-lg-12 -->
</div>

<div class="row">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">


            <div class="dropdown" style="margin-bottom: 24px">
                <form id="analysisInput" action="" method="post" enctype="multipart/form-data">
                    <!--<div class="input-group custom-search-form">-->



                    <!--</div>-->

                    <input type="hidden" name="classifier" id="classifier" />
                    <input id="upload-input" class="form-control" value="file" type="file" name="file" accept=".csv" style="width: 250px;float: left;margin-right: 16px"/>
                    <select class="selectpicker cmu-dropdown" style="width: 123px;float: left;" name="" value="1" id="dropmenu">
                        <option value="1"><a href="#">MultilayerPerceptron</a></option>
                        <option value="2"><a href="#">LinearRegression</a></option>
                    </select>
                    

                    <div class="btn-group bootstrap-select cmu-dropdown">
                        <button id="analyseData"  class="btn btn-default" style="float: left;margin-left: 14px"><span><img src="images/glyphicons-42-charts.png" height="15px" width="15px" style="margin-right: 6px;"></span>  Analyze Data!</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>








<div class="input-group custom-search-form">
    <form id="analysisInput" action="" method="post" enctype="multipart/form-data">
        <input id="upload-input" class="form-control" value="file" type="file" name="file" accept=".csv" style="width: 250px"/>
        <input type="hidden" name="classifier" id="classifier" />
        <select style="width: 180px;" name=""  value="1" id="dropmenu">
            <option value="1"><a href="#">MultilayerPerceptron</a></option>
            <option value="2"><a href="#">LinearRegression</a></option>
        </select>
        <span class="input-group-btn">
            <button class="btn btn-default" id="analyseData" value="analyze" type="button">
                <i class="fa fa-upload"></i>
            </button>
        </span>
    </form>
</div>

<p></p>

<div id="analysisChartDiv" class="row">
    <c:set var="chart" scope="request" value="${requestScope.chart}" /> 
    <c:set var="contextPath" scope="request" value="${requestScope.contextPath}"/>
    <c:choose>
        <c:when test="${chart != null}">
            <img src="${contextPath}/images/${chart}">
        </c:when>
    </c:choose>
</div>



<script>
    $(document).ready(function () {

        $('#chartPanel').hide();
        $('.selectpicker').selectpicker();

        $('#analyseData').click(function () {
            $('#analysisChartDiv').html('');
            console.log("analyze button clicked!");

            var uploadFileName = $("#upload-input").val();
            console.log(uploadFileName);
            if (uploadFileName == "") { // returns true if the string is not empty
                $('#noFileSelectedError').show();
            } else {

                classifier = $('#dropmenu').val();
                $('#classifier').val(classifier);
                console.log(classifier);
                var form = $('#analysisInput')[0];
                var formData = new FormData(form);
                $.ajax({
                    type: "POST",
                    url: "/StudentAnalytics/Histogram",
                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (data, textStatus, request) {

                        $('#analysisChartDiv').html('<img src="' + data.chart + '" />');
                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        console.log(xhr.status);
                        console.log(thrownError);
                    }
                });
            }


        });

    });
</script>

