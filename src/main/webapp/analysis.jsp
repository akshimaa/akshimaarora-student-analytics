<%-- 
    Document   : analysis
    Created on : Nov 25, 2015, 5:24:25 PM
    Author     : Dell
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <h1>PREDICTIVE ANALYTICS FTW!</h1>

        <form action="histogram" method="post" enctype="multipart/form-data">
            <input id="upload-input" class="form-control" type="file" name="file" accept=".csv" style="width: 250px"/>
            <span class="input-group-btn">
                <button class="btn btn-default" type="submit" value="upload">
                    <i class="fa fa-upload"></i>
                </button>
            </span>
        </form>
        
        <c:set var="chart" scope="request" value="${requestScope.chart}" /> 
        <c:set var="contextPath" scope="request" value="${requestScope.contextPath}"/>
        <c:choose>
            <c:when test="${chart != null}">
                <img src="${contextPath}/images/${chart}">
            </c:when>
        </c:choose>
        
                

