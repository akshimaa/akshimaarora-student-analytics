<%-- 
    Document   : upload
    Created on : Nov 26, 2015, 12:50:23 PM
    Author     : madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script src="js/jquery-2.1.4.js" type="text/js"></script>

<li class="sidebar-search">
    <div class="input-group custom-search-form">

        <form id="uploadForm" action="upload" method="post" enctype="multipart/form-data">
            <input id="upload-input" class="form-control" type="file" name="file" accept=".csv" style="width: 181px"/>
            <span class="input-group-btn">
                <button class="btn btn-default" id="uploadToS3Button" value="upload">
                    <i class="fa fa-upload"></i>
                </button>
            </span>
            <input type="hidden" name="merge" id="hiddenMergeFlag" value="0"/>
            <input type="checkbox" name="checkbox" id="uploadMergeCheckbox" value="1"/> Merge into database
        </form> 

    </div>
    <!-- /input-group -->
</li>