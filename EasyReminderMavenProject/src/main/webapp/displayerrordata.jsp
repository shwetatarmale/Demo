<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="org.json.JSONArray" %>
<%@ page import="org.json.JSONObject" %>

<!DOCTYPE html>
<html>
<head>
    <title>Error Data</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function() {
            // Make an AJAX request to the servlet
            $.ajax({
                url: 'ErrorDataServlet',
                type: 'GET',
                dataType: 'json',
                success: function(response) {
                    // Initialize the DataTable
                    $('#data-table').DataTable({
                        data: response,
                        columns: [
                            { title: 'IDTXN', data: 'idtxn' },
                            { title: 'DESCRIPTION', data: 'description' },
                            { title: 'ERRORCODE', data: 'errorcode' }
                        ]
                    });
                },
                error: function(xhr, status, error) {
                    console.log(error);
                    // Handle the error condition
                }
            });
        });
    </script>
</head>
<body>
    <h1>Error Data</h1>
    <table id="data-table" class="display" style="width:100%"></table>
    <div style="text-align: center;">

<form method="Post" action="Export">
 <input type="submit" value="Download" formaction="Export"  style="display: inline;" /> 
</form>
<br>
<form method="get" action="DatabaseToPDFExporter">
 <input type="submit" value="Download PDF" formaction="DatabaseToPDFExporter"  style="display: inline;" /> 
</form>
</div>
</body>
</html>