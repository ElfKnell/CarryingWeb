package ua.carrying.controller;

import ua.carrying.dao.entities.User;
import ua.carrying.dao.repository.UserRepository;
import ua.carrying.view.IndexSingleton;
import ua.carrying.view.MainView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainServlet", urlPatterns = ("/car"), loadOnStartup = 1)
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        if ( request.getParameter("email") != null ) {
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getUserByEmailByPassword(request.getParameter("email"),
                    request.getParameter("password"));
            if ( user == null ) {
                out.write("<h2>Please Login Again</h2>");
            } else {
                session.setAttribute("user", user);
                response.sendRedirect("/order/");
            }

        }

        MainView view = new MainView();
        out.println(view.getHtml());
    }

    @Override
    public void init() throws ServletException {
        super.init();
        //set path
        String path = getServletContext().getRealPath("/html/");
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        indexSingleton.setHtmlPath(path);
        indexSingleton.setPage("index.html");
    }
}
