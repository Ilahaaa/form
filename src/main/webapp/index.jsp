<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>

<style>

    button{
        background-color:mediumblue;
        color: white;
        padding: 8px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100px;
        opacity: 0.9;
        font-size: 18px;
        border-radius: 15%;
    }
    button:hover {
        opacity: 1;
    }

    h2{
        text-align: center;
        color: brown;
    }
    a{
        text-decoration: none;
    }
</style>

<a href="user.jsp">View Users</a>

<h2>Form</h2>
<form action="register"  method="post"  enctype="multipart/form-data">
    <label for="name"><b>Name</b></label>
    <input type="text" name="name"  id="name"></br> </br>
    <label for="surname"><b>Surname</b></label>
    <input type="text" name="surname" id="surname"></br></br>
    <label for="email"><b>Email</b></label>
    <input type="text" name="email" id="email"></br></br>

    <input type="file" name="file" />
    </br>
    </br>



    <button type="submit" value="submit">Submit</button>
</form>

</body>
</html>