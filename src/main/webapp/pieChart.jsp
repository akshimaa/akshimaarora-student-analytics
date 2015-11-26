<%-- 
    Document   : pieChart
    Created on : Nov 24, 2015, 8:44:41 PM
    Author     : Melissa, Akshima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
   

    
    </script>
 <script src="js/pieChart.js"></script>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Pie Chart</h1>

    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group"><div class="dropdown">
                
                <select style="width: 123px;" name="" value="Select1" id="Select1">
                   
                    <option value="200"><a href="#">Original Data</a></option>
                    <option ><a href="#">Uploaded Data</a></option>
                    <option><a href="#">Merged Data</a></option>
                </select>
            </div>
        </div><div class="btn-group">
            <div class="dropdown">
              
                <select style="width: 123px;" name="" value="Select2" id="Select2">
                   
                    <option value="100"><a href="#">Age</a></option>
                    <option ><a href="#">GPA</a></option>
                    <option ><a href="#">Gender</a></option>
                </ol>
            </div></div>
    </div>
</div>

<input type="button" value="Generate Charts" onclick="generateCharts();">

<div id="data"></div>
<div class="row" id="actualcharts" style="display:none">
    <img src="PieChart" width="300" height="300">
</div>
<!-- /.row -->



