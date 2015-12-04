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
        <h1 class="page-header">Bar Chart</h1>

    </div>
    <!-- /.col-lg-12 -->
</div>
<link href="css/cmu-dropdowns.css" rel="stylesheet" type="text/css">

<div class="row">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group">
            <div class="dropdown">
                
                <select class="selectpicker cmu-dropdown" style="width: 123px;" name=""  id="datasourceDropdown">
                   
                    <option value="OriginalData"><a href="#">Original Data</a></option>
                    <option value="UploadedData"><a href="#">Uploaded Data</a></option>
                    <option value="MergedData"><a href="#">Merged Data</a></option>
                </select>
            
           
            
              
                <select  class="selectpicker cmu-dropdown" style="width: 123px;" name="" value="Select2" id="presetDropdown">
                   
                    <option value="attendanceType" ><a href="#">Attendance Type</a></option>
                <option value="courseInformation"><a href="#">Course Information</a></option>
                    <option value="modeOfAttendance"><a href="#">Attendance Mode</a></option>
                        <option value="basisAdmission"><a href="#">Basis for Admission</a></option>
                            <option value="degreeLevel_gender"><a href="#">Degree by Gender</a></option>
                             <option value="modeOfAttendance_attendanceType"><a href="#">Mode of Attendance by Type Attendance</a></option>
                </select>
                <div class="btn-group bootstrap-select cmu-dropdown">
                    <button id="generateBar"  class="btn btn-default"><span><img src="images/glyphicons-42-charts.png" height="15px" width="15px" style="margin-right: 6px"></span>  Generate Bar!</button>
                </div>
                </div>
            
     

            </div>
         </div>
    </div>


</div>

<div id ="chartDiv" class="row" >

           
</div>

<script>
    
    $( document ).ready(function() {
        $('.selectpicker').selectpicker();
        
    $('#generateBar').click(function(){
        $('#chartDiv').html('');
        console.log("generate button clicked!");
        console.log($('#datasourceDropdown').val());
        console.log($('#presetDropdown').val());
        datasource = $('#datasourceDropdown').val();
        preset = $('#presetDropdown').val();

        $.ajax({
  type: "POST",
  url: "/StudentAnalytics/BarChart",
  data: {datasource:datasource, preset:preset},
  cache: false,
  datatype: "application/json",
  success: function(data, textStatus, request){
      
      $('#chartDiv').html('<img src="'+data.chart+'" />');},
  error: function (xhr, ajaxOptions, thrownError) {
        console.log(xhr.status);
        console.log(thrownError);
      }
});
         
    }); 
     
  }); 
    </script>
<!-- /.row -->

