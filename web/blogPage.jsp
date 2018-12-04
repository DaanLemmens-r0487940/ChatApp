<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="Blog Page" />
    </jsp:include>
<body id="blogBody">
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Blog Page" />
    </jsp:include>
    <main>

        <div class="danger">
            <ul id="error">
            </ul>
        </div>



        <div>
            <p>Comment on topic: </p>
            <div>
                <label for="commentTopic">Choose Topic:  </label>
                <select id="commentTopic" name="commentTopic">
                    <c:forEach var="topic" items="(1)Projectweek,(2)Planning,(3)Muziek,(4)Examenvragen,(5)Films">
                        <option value="${ topic }">${ topic }</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="comment">Your name:  </label>
                <input type="text" id="name" name="name">
            </div>
            <div>
                <label for="name">Your comment:  </label>
                <input type="text" id="comment" name="comment">
            </div>
            <div>
                <label for="rating">Give the topic a rating:  </label>
             <input type="number" id="rating" name="rating" min="1" max="5">
            </div>
            <input type="button" id="addComment" name="addComment" value="Add Comment" onclick="send()">

        </div>

        <div class="review">
            <p>1. Was het een interessante projectweek?</p>
            <div id="comment1"></div>
            <p>2. Wat ben je van plan om te doen vandaag?</p>
            <div id="comment2"></div>
            <p>3. Naar welke muziek ben je momenteel aan het luisteren?</p>
            <div id="comment3"></div>
            <p>4. Wat zijn de examenvragen voor het vak web4?</p>
            <div id="comment4"></div>
            <p>5. Wat is je laatst bekeken film?</p>
            <div id="comment5"></div>
        </div>
        <script type="text/javascript" src="js/blog.js"></script>



    </main>

</body>
</html>