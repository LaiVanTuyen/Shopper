package com.shopper.controller;

import com.shopper.dao.ProductDao;
import com.shopper.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveProduct", value = "/remove-product")
public class RemoveProductControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the id of the product that need to remove from request.
        int productId = Integer.parseInt(request.getParameter("product-id"));
        // Remove product from database.
        ProductDao productDao = new ProductDao();
        Product product = productDao.getProduct(productId);
        productDao.removeProduct(product);

        response.sendRedirect("product-management");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
