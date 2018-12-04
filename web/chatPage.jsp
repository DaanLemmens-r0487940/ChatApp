<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Chat"/>
    </jsp:include>
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Chat Page"/>
    </jsp:include>

    <body onload="friendList()">
        <main>

            <div id="currentStatus">
                <p>${user.getStatus()}</p>
            </div>

            <div id="friendsTable">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Username</th>
                            <th scope="col">Status</th>
                        </tr>
                    </thead>
                    <tbody id="friendListBody">

                    </tbody>
                </table>
            </div>

            <div id="newStatus">
                <p>Change Status</p>
                <input list="options" type="text" id="status" name="status" placeholder="AFK"/>
                <datalist id="options">
                    <option value="Online">
                    <option value="Offline">
                    <option value="Away">
                </datalist>
                <input type="button" id="changeStatus" value="Change Status" onclick="changeStatus();"/>
            </div>

            <div id="newFriend">
                <p>Add Friend</p>
                <input type="text" id="friendUserId" name="friendUserId" placeholder="user@ucll.be"/>
                <input type="button" id="addFriend" value="Add Friend"  /><!-- onclick="addFriend();"-->
            </div>


        </main>
    </body>
    <script type="text/javascript" src="js/status.js"></script>
    <script type="text/javascript" src="js/friends.js"></script>
    <script type="text/javascript" src="js/addFriend.js"></script>
</html>
