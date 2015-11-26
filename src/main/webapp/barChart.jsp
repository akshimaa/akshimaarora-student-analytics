<%-- 
    Document   : pieChart
    Created on : Nov 24, 2015, 8:44:41 PM
    Author     : Melissa, Akshima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Bar Chart</h1>

    </div>
    <!-- /.col-lg-12 -->
</div>
 <script src="js/barChart.js"></script>
 
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
                   
                    <option value="age" ><a href="#">Age</a></option>
                <option value="courseInformation"><a href="#">Course Information</a></option>
                    <option value="gpa"><a href="#">GPA</a></option>
                    <option value="gender"><a href="#">Gender</a></option>
                </select>
            </div>
         </div>
    </div>
</div>
 <div class="row">
     <button id="generateBar"  class="btn btn-default">Generate Bar!</button>
 </div>

<div class="row" id="actualcharts" style="display:none">

</div>

<form id="barChartForm" action="BarChart" name="BarChart" method="POST" style="display:none;">
  <input type="hidden" name="datasource" id="datasource" />
<input type="hidden" name="preset" id="preset" />
</form>
<script>
    
    $( document ).ready(function() {
    $('#generateBar').click(function(){
        console.log("generate button clicked!");
        console.log($('#datasourceDropdown').val());
        console.log($('#presetDropdown').val());
        datasource = $('#datasourceDropdown').val();
        preset = $('#presetDropdown').val();
        $('#datasource').attr('value',datasource);
        $('#preset').attr('value', preset);
        $('#barChartForm').submit();
         
    }); 
     
  }); 
    </script>
<!-- /.row -->