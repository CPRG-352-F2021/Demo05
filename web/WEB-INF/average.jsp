<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Average Number Calculator</title>
    </head>
    <body>
        <h2>Average Numbers</h2>
        <form method="get" action="average">
            <label>Enter a number:</label>
            <input type="number" name="incoming_number" value="">
            <input type="submit" value="Average Numbers">
        </form>
        <!-- you must keep your forms separate -->
        <form method="get" action="average">
            <input type="submit" value="Reset Average">
            <input type="hidden" name="operation" value="reset">
        </form>
        <p>Average: ${average}</p>
    </body>
</html>
