Welcome to EasyBid, Please Log In Below.

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    form{
        background-color: palegreen;
        width: 300px;
        height: 300px;
        border-style: double;
        border-color: blue;
        padding: 10px;
    }
</style>

<div>
    <form action="/login" method="post">
        <div><br></div>
        <c:if test="${empty errorUserNotFound}">
            <div><h3>${errorUserNotFound}</h3></div>
            <div><br></div>
        </c:if>
        <c:if test="${empty registrationSuccess}">
            <div style="color: darkblue"><h3>${registrationSuccess}</h3></div>
            <div><br></div>
        </c:if>
        <c:if test="${empty registrationError}">
            <div style="color: darkred"><h3>${registrationError}</h3></div>
            <div><br></div>
        </c:if>
        <div>Username: <input type="text" name="userName" value=""> </div>
        <div><br></div>
        <div> Password: <input type="text" name="password" value=""> </div>
        <div><br></div>
        <div><input type="submit" value="Login" style="background-color: lightblue"> </div>
        <div><br></div>
        <div><input type="button" value="Register" onclick="goToRegisterPage()" style="background-color: lightcoral"> </div>
    </form>
</div>

<script type="text/javascript">
    function goToRegisterPage() {
        window.location.href="/register";
    }
</script>