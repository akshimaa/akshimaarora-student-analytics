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
<div class="input-group custom-search-form">
    <form action="Histogram" method="post" enctype="multipart/form-data">
        <input id="upload-input" class="form-control" type="file" name="file" accept=".csv" style="width: 250px"/>
        <input type="hidden" name="classifier" id="classifier" />
        <span class="input-group-btn">
            <button class="btn btn-default" id="submit" value="upload">
                <i class="fa fa-upload"></i>
            </button>
        </span>
        
        
    </form>
</div>

<div class="dropdown">
    <select style="width: 180px;" name="" value="dropmenu" id="dropmenu">
        <option value="1"><a href="#">MultilayerPerceptron</a></option>
        <option value="2"><a href="#">LinearRegression</a></option>
    </select>
</div>
<p></p>
<div class="row">
    <c:set var="chart" scope="request" value="${requestScope.chart}" /> 
    <c:set var="contextPath" scope="request" value="${requestScope.contextPath}"/>
    <c:choose>
        <c:when test="${chart != null}">
            <img src="${contextPath}/images/${chart}">
        </c:when>
    </c:choose>
</div>



<script>
$('#submit').click(function(){
    
    $('#classifier').attr('value',$('#dropmenu').val());
    
});
</script>
