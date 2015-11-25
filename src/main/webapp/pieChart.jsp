<%-- 
    Document   : pieChart
    Created on : Nov 24, 2015, 8:44:41 PM
    Author     : Melissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Pie Chart</h1>

    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="btn-toolbar" role="toolbar">
        <div class="btn-group"><div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Choose Datasource
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li class="dropdown-header">Datasource</li>
                    <li><a href="#">Original Data</a></li>
                    <li><a href="#">Uploaded Data</a></li>
                    <li><a href="#">Merged Data</a></li>
                </ul>
            </div>
        </div><div class="btn-group">
            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    Choose Y value
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
                    <li class="dropdown-header">Parameter</li>
                    <li><a href="#">Age</a></li>
                    <li><a href="#">GPA</a></li>
                    <li><a href="#">Gender</a></li>
                </ul>
            </div></div>
    </div>
</div>
<div class="row">
    <img src="PieChart" width="300" height="300">
</div>
<!-- /.row -->



