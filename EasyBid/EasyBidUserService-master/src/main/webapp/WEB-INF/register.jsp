Welcome to EasyBid, Please Register Below.

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    form{
        background-color: lavenderblush;
        width: 500px;
        height: 500px;
        border-style: double;
        border-color: blue;
        padding: 10px;
    }
</style>

<div>
    <form action="/registerUser" method="post">
        <div><br></div>
        <div>Username: <input type="text" name="userName" value=""> </div>
        <div><br></div>
        <div> Password: <input type="text" name="password1" value=""> </div>
        <div><br></div>
        <div> Confirm Password: <input type="text" name="password2" value=""> </div>
        <div><br></div>
        <div> Name: <input type="text" name="name" value=""> </div>
        <div><br></div>
        <div> Date of Birth: <input type="text" name="dob" value=""> </div>
        <div><br></div>
        <div> Phone Number: <input type="text" name="phoneNum" value=""> </div>
        <div><br></div>
        <div> Address: <input type="text" name="address" value=""> </div>
        <div><br></div>
        <div><input type="submit" value="Register" style="background-color: lightblue"> </div>
        <div><br></div>
        <div><input type="button" value="Back" onclick="goToLoginPage()" style="background-color: lightcoral"> </div>
    </form>
</div>

<script type="text/javascript">
    function goToLoginPage() {
        window.location.href="/backLogin";
    }
</script>