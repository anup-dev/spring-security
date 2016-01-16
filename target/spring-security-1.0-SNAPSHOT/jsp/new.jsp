<html lang="en">
<head>
<title>Hello</title>
</head>
<body>
    <h1>This is new page Spring Security</h1>

    <form action="/logout" method="post">
                    <input type="hidden"
                    		name="${_csrf.parameterName}"
                    		value="${_csrf.token}"/>
                    <button type="submit">Log Out</button>
                </form>
</body>