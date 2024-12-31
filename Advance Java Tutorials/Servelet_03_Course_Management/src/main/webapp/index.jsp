<html>
<head>
   <link rel="stylesheet" href="index.css">
</head>
<body>
    <form action="course" method="get" class="form">
        <table>
            <tr>
                <td>
                    <h4>Course Management App</h4>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="Name" >Enter Your name :</label>
                </td>
                <td>
                    <input id="Name" type="text" name="name" placeholder="Enter Your Name">
                </td>
            </tr>

            <tr>
                <td>
                    <label for="Course" >Enter Your Course Name :</label>
                </td>
                <td>
                    <input id="Course" type="text" name="Course" placeholder="Enter Your Course Name">
                </td>
            </tr>

            <tr>
                <td>
                    <label for="fees" >Enter Your Course Fees : :</label>
                </td>
                <td>
                    <input id="fees" type="number" name="Fees" placeholder="Enter Your Course fees">
                </td>
            </tr>

            <tr>
                <td>
                    <label for="Duration" >Enter Your Course Duration :</label>
                </td>
                <td>
                    <input id="Duration" type="text" name="Course" placeholder="Enter Your Course Duration">
                </td>
            </tr>

            <tr>
                <td>
                    <label for="comments">Your Description About Course:</label><br>
                </td>
                <td>
                     <textarea placeholder="Enter Your course Description Here :" id="comments" name="Description" rows="10" cols="30">
               </textarea>
                </td>
            </tr>

            <tr>
                <td>
                    <label for="clear">Clear</label>
                </td>
                <td>
                    <input type="reset" value="clear">
                </td>
            </tr>

            <tr>
                <td>
                    <input type="submit">
                </td>
            </tr>

            <tr>
                <td>
                    <a href="CourseList">Show Courses Inserted</a>
                </td>
            </tr>



        </table>
    </form>
</body>
</html>
