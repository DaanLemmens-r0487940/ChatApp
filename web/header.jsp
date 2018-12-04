<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
<img alt="Books" src="images/atcute.png">
<h1><span>Chat App</span></h1>
<nav>
<ul>
<c:choose>
    <c:when test="${param.title=='Chat Page'}">
        <li  id="actual"><a href="Controller">Home</a></li>
        <li  id="actual"><a href="Controller?action=BlogPage">Blog Page</a></li>
    </c:when>
    <c:when test="${param.title=='Home'}">
        <li  id="actual"><a href="Controller?action=ChatPage">Chat Page</a></li>
        <li  id="actual"><a href="Controller?action=BlogPage">Blog Page</a></li>
    </c:when>
    <c:when test="${param.title=='Blog Page'}">
        <li  id="actual"><a href="Controller">Home</a></li>
        <li  id="actual"><a href="Controller?action=ChatPage">Chat Page</a></li>
    </c:when>
<c:otherwise>
<li><a href="Controller">Home</a></li>
</c:otherwise>
</c:choose>


</ul>
</nav>
<h2>
${param.title}
</h2>

</header>