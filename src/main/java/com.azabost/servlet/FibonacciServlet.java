package com.azabost.servlet;

import com.azabost.core.Fibonacci;
import com.azabost.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet("/fibonacci")
public class FibonacciServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(FibonacciServlet.class.getName());

    @Inject
    TemplateProvider templateProvider;

    @Inject
    Fibonacci fibonacci;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        if (req.getAttribute("result") == null) {
            Template template = templateProvider.getTemplate(getServletContext(), "fibonacci.ftlh");
            Map<String, Object> model = new HashMap<>();

            if (req.getParameter("result") != null && !req.getParameter("result").isEmpty()) {
                Integer result = Integer.valueOf(req.getParameter("result"));
                model.put("result", fibonacci.getNthElementOfSequence(result));
                model.put("list", fibonacci.getAllSequence(result));
            }
            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                logger.severe(e.getMessage());
            }
        } else {
            Template template = templateProvider.getTemplate(getServletContext(), "error.ftlh");
            Map<String, Object> model = new HashMap<>();

            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                logger.severe(e.getMessage());
            }
        }
    }
}

