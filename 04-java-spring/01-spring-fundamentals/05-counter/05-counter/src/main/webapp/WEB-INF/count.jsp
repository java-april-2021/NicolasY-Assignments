<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>

    <head>
        <title>Count</title>
    </head>

    <body>
        <h1>You have visited
            <c:out value="${ count }" /> Times
        </h1>
        <a href="/">Test another visit?</a>
    </body>

    </html>