<%-- 
    Document   : pieChart
    Created on : Nov 24, 2015, 8:44:41 PM
    Author     : Melissa, Akshima
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Pie Chart</h1>

    </div>
  
</div>

 
<div class="row">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <div class="dropdown">
                
                <select style="width: 123px;" name=""  id="datasourceDropdown">
                   
                    <option value="OriginalData"><a href="#">OriginalData</a></option>
                    <option value="UploadedData"><a href="#">UploadedData</a></option>
                    <option value="MergedData"><a href="#">MergedData</a></option>
                </select>
            </div>
           
                <select style="width: 123px;" name="" value="Select2" id="presetDropdown">
                   <option value="attendanceType"><a href="#">Attendance Type</a></option>
                    <option value="courseInformation"><a href="#">Course Information</a></option>
                    <option value="degreeLevel"><a href="#">Degree Level</a></option>
                    <option value="gender" ><a href="#">Gender</a></option>
                    <option value="highestEducationLevel"><a href="#">Degree Earned</a></option>
                    <option value="languageSpokenAtHome"><a href="#">Language</a></option>
                    <option value="entranceExam"><a href="#">Entrance Exam</a></option>
                    <option value="disability_regionalRemote_womenNonTraditionalRole_lowIncome"><a href="#">Equity Data</a></option>
                             
                </select>
            </div>
         </div>
    </div>

 <div class="row">
     <button id="generatePie"  class="btn btn-default">Generate Pie!</button>
 </div>

<div id ="pieChartDiv" class="row" >

           
</div>

<form id="pieChartForm" action="PieChart" name="PieChart" method="POST" style="display:none;">
  <input type="hidden" name="datasource" id="datasource" />
<input type="hidden" name="preset" id="preset" />
</form>
<script>
    $( document ).ready(function() {
    $('#generatePie').click(function(){
        $('#pieChartDiv').html('');
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
                console.log(data);
                        $('#pieChartDiv').html('<img src="'+data.chart+'" />');},
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.status);
                console.log(thrownError);
         }
        });
         
    }); 
     
  }); 
</script>
<!-- /.row -->



