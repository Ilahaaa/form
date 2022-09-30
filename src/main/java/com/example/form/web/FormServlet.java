package com.example.form.web;

import java.io.*;
import java.sql.SQLException;

import com.example.form.dao.DbConnection;
import com.example.form.dao.UserDao;
import com.example.form.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/register")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String applicationPath = getServletContext().getRealPath(""),
                uploadPath = applicationPath + File.separator + "images";
        if (fileName == null || fileName.equals("")) {
            resp.getWriter().print("Choose file");


        } else {
            for (Part part : req.getParts()) {
                part.write(uploadPath+"/" + fileName);
            }
            resp.getWriter().print("Successfully");

        }
        User user=new User(name,surname,email,fileName);


        try {
            UserDao dao = new UserDao(DbConnection.connectDb());
            dao.addUser(user);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        PrintWriter out = resp.getWriter();
//        out.println("uploadpath"+uploadPath);
//        out.println("apppath"+applicationPath);





    }


}