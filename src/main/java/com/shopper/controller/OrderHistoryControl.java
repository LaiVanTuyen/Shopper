package com.shopper.controller;

import com.shopper.dao.OrderDao;
import com.shopper.entity.Account;
import com.shopper.entity.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderHistoryControl", value = "/order-history")
public class OrderHistoryControl extends HttpServlet {
    // Call DAO class to access with database.
    OrderDao orderDao = new OrderDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get account from session.
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        // Get order history of account from database.
        List<Order> orderList = orderDao.getOrderHistory(account.getId());

        request.setAttribute("order_list", orderList);
        // Set attribute active for order management tab.
        request.setAttribute("order_history_active", "active");
        // Get request dispatcher and render to order-management page.
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("order-history.jsp");
        requestDispatcher.forward(request, response);
    }
}
