package com.geekbrains.app;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ThirdServlet", urlPatterns = "/show_page")
public class ThirdServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ThirdServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: First");
        ArrayList<Product> products = new ArrayList<>();

        Product product1 = new Product(1, "product_1", 500);
        products.add(product1);
        Product product2 = new Product(2, "product_2", 300);
        products.add(product2);
        Product product3 = new Product(3, "product_3", 600);
        products.add(product3);
        Product product4 = new Product(4, "product_4", 300.56);
        products.add(product4);
        Product product5 = new Product(5, "product_5", 250);
        products.add(product5);
        Product product6 = new Product(6, "product_6", 560);
        products.add(product6);
        Product product7 = new Product(7, "product_7", 300);
        products.add(product7);
        Product product8 = new Product(8, "product_8", 300);
        products.add(product8);
        Product product9 = new Product(9, "product_9", 300);
        products.add(product9);
        Product product10 = new Product(10, "product_10", 10_000);
        products.add(product10);


        resp.setContentType("text/html");
        resp.getWriter().printf("<html><body>");
        for (Product prod : products) {
            resp.getWriter().printf("<h1>" + "product id: " + prod.getId() + " " + "product title: " + prod.getTitle() +
                    " " + "product cost: " + prod.getCost() + "</h1>");
        }

        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();

    }
}
