package ua.carrying.controller;

import ua.carrying.dao.etities.User;
import ua.carrying.dao.repository.UserRepository;
import ua.carrying.formsvalidator.RegisterFormValidator;
import ua.carrying.view.UserView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", urlPatterns = {"/user/*"})
    public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String rol;

        if (request.getParameter("email") != null) {
            RegisterFormValidator registerFormValidator =
                    new RegisterFormValidator(
                            request.getParameter("userName"),
                            request.getParameter("email"),
                            request.getParameter("password"),
                            request.getParameter("phone"));

            if (!registerFormValidator.isFormValid()) {
                out.println(registerFormValidator.getMessageError());

            } else {
                UserRepository userRepository = new UserRepository();
                User user = new User();
                user.setUserName(request.getParameter("userName"));
                user.setEmail(request.getParameter("email"));
                user.setPassword(request.getParameter("password"));
                user.setPhone(request.getParameter("phone"));
                rol = request.getParameter("inlineRadioOptions");
                if (rol.equals("option1")) {
                    user.setRole(3);
                } else {
                    user.setRole(4);
                }
                userRepository.saveUser(user);
                out.println(rol);
            }

            switch (request.getPathInfo()) {

                case "/register/":
                case "/register":
                    UserView userView = new UserView();
                    out.println(userView.getHtml());
                    break;
                default:
                    out.println("<html><head><title>MyServlet</title></head><body>");
                    out.write("<H1>Hello Servlet World! User!</H1>");
                    out.write("URI   \t" + request.getPathInfo());
                    out.println("</body>");
                    out.println("</html>");
            }
        }

    }

}


