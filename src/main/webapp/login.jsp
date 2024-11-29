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
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="card" style="border-radius: 1rem;">
                        <div class="card-body p-3 text-center">
                            <!-- Aqui esta el form... -->
                            <form action="/IMC/usuario?accion=login" method="POST" class="row g-5 needs-validation" novalidate>
                                <div class="col-md-4">
                                  <label for="usuario" class="form-label">Usuario</label>
                                  <input type="email" class="form-control" id="usuario" name="usuario" placeholder="Usuario" required>
                                  <div class="valid-feedback">
                                    Aceptado!
                                  </div>
                                </div>
                                <div class="col-md-4">
                                  <label for="clave" class="form-label">Clave</label>
                                  <input type="password" class="form-control" id="clave" name="clave" placeholder="Clave" required>
                                  <div class="valid-feedback">
                                    Aceptado!
                                  </div>
                                </div>
                                <div class="col-12">
                                  <button class="btn btn-primary" type="submit">Iniciar sesion</button>
                                </div>
                              </form>
                              <!-- Aqui el form acaba... -->
                               <c:if test="${not empty error}">
                                <p style="color: red;">${error}</p>
                               </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Aqui va el footer -->
        <%@ include file="footer.jsp"  %>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script>
            // Example starter JavaScript for disabling form submissions if there are invalid fields
            (() => {
                'use strict'
            
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                const forms = document.querySelectorAll('.needs-validation')
            
                // Loop over them and prevent submission
                Array.from(forms).forEach(form => {
                form.addEventListener('submit', event => {
                    if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                    }
            
                    form.classList.add('was-validated')
                }, false)
                })
            })()
        </script>
    </body>
</html>