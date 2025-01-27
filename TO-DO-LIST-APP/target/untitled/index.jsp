<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/CSS/Index.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Comic+Neue:ital,wght@0,300;0,400;0,700;1,300;1,400;1,700&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listify</title>
</head>
<body>

<div class="Header">
    <div class="Logo">
        <h2>
            <span class="flet">List</span>ify
        </h2>
    </div>
    <div class="tabs">
        <a href="Addtask.html">Add-task</a>
        <a href="EditTask.jsp">Edit-Task</a>
    </div>
</div>
<!-- start of Head-content  -->
<div class="bodyContent">
    <div class="Para1">
        <p class="para">
            <span class="hide1"> "Your journey to success begins with the small steps you take today.<br></span> <span class="txt">Plan, act, and celebrate every milestone...!</span><br><span class="hide2">: Because every effort brings you closer to your dreams...!"</span>
        </p>
        <!-- date And Time Display -->
        <br><br>
        <div class="DateTime">
            <p>
                    <span>
                        today :
                    </span>
            </p>
            <div id="dateTime"></div>
            <script>
                function updateDateTime() {
                    const now = new Date();
                    const options = {
                        weekday: 'long',
                        year: 'numeric',
                        month: 'long',
                        day: 'numeric',
                        hour: '2-digit',
                        minute: '2-digit',
                    };
                    document.getElementById('dateTime').textContent = now.toLocaleString('en-US', options);
                }

                // Update date and time every second
                setInterval(updateDateTime, 1000);

                // Initial call to display the date and time immediately
                updateDateTime();
            </script>
        </div>
    </div>
    <div class="Avtar">
        <img src="https://png.pngtree.com/png-clipart/20240612/original/pngtree-a-man-and-woman-are-smiling-for-picture-of-png-image_15314235.png" alt="avtar1"  class="img">
    </div>
</div>
</body>
<!-- start of footer -->
<Footer>
    <div class="FLogo">
        <h2>
            <span class="flet">List</span>ify
        </h2>
    </div>
    <div class="contact">
        <p class="foot">
        <h4>contact📞 :+91 9075059555</h4>
        <h4>Mail📧 : Listify.in@gmail.com</h4>
        <h4>Helpline no.☎️ :+91 9922564994</h4>
        <h4>Website🌐 :WWW.Listify.com</h4>
        </p>
    </div>
    <div class="Follow">
        <h3>Follow us on :</h3>
        <br>
        <a href="Twitter" class="a1">Twitter </a>
        <a href="Instagram" class="a2">Instagram</a>
        <a href="Facebook" class="a3">Facebook </a>
    </div>
</Footer>
</html>