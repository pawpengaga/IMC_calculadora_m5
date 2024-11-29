<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/style.css">
</head>
<body>
  
  <%@ include file="menu.jsp"  %>

  <section>
    <div class="container mt-5">
      <div class="card">
        <div class="card-body">
          <form action="/IMC/ImcServlet" method="POST">
            <input type="hidden" name="userId" value="${userId}" />
            <div class="form-group">
              <label for="peso" class="form-label">Peso: </label>
              <input class="form-control" type="number" step="any" name="peso" id="peso" required />
            </div>
            <div class="form-group">
              <label for="altura" class="form-label">Altura: </label>
              <input class="form-control" type="number" step="any" name="altura" id="altura" required />
            </div>
            <button class="btn btn-primary" type="submit">Calcular IMC</button>
          </form>
          <c:if test="${not empty mensaje}">
            <p style="font-size: 1.5rem; color: orange;">${mensaje}</p>
          </c:if>
        </div>
      </div>
    </div>
  </section>

  <%@ include file="footer.jsp"  %>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>