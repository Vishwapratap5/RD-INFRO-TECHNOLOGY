<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/index.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <title>Calculator</title>
</head>
<body>

<form action="Calculate" method="get">
    <h1 class="Title">Calculator</h1>
    <br>
    <label for="num1">Enter First Number:</label>
    <input type="number" id="num1" name="num1" required><br><br>

    <label for="num2">Enter Second Number:</label>
    <input type="number" id="num2" name="num2" required><br><br>

    <label class="op">Select Operation:</label><br><br>
    <input type="radio" id="add" name="Add" value="Addition  (+)" required>
    <label for="add">Addition (+)</label><br>

    <input type="radio" id="sub" name="Add" value="Substraction  (-)">
    <label for="sub">Subtraction (-)</label><br>

    <input type="radio" id="mul" name="Add" value="Multiplication  (*)">
    <label for="mul">Multiplication (*)</label><br>

    <input type="radio" id="div" name="Add" value="Division (/)">
    <label for="div">Division (/)</label><br>

    <input type="radio" id="rem" name="Add" value="Reminder (%)">
    <label for="rem">Remainder (%)</label><br><br>

    <input type="submit" value="Calculate" class="submit">
    <input type="reset" value="clear" class="clear">
</form>
<!-- Display result -->
</body>
</html>
