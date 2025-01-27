
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/Index.css">

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <title>Calculator</title>
</head>
<body>

<form action="Calculate" method="post">
    <h1 class="Title">Calculator</h1>
    <br>
    <label for="num1">Enter First Number:</label>
    <input type="number" id="num1" name="num1" required><br><br>

    <label for="num2">Enter Second Number:</label>
    <input type="number" id="num2" name="num2" required><br><br>

    <label for="operation" class="op">Select Operation:</label><br><br>
    <select id="operation" name="Opt" required>
        <option value="Addition  (+)">Addition (+)</option>
        <option value="Substraction  (-)">Subtraction (-)</option>
        <option value="Multiplication  (*)">Multiplication (*)</option>
        <option value="Division (/)">Division (/)</option>
        <option value="Reminder (%)">Remainder (%)</option>
    </select>
    <br><br>

    <input type="submit" value="Calculate" class="submit">
    <input type="reset" value="clear" class="clear">
</form>
</body>
</html>
