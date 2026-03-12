package com.example.hibernate;

public class MainApp {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();

        Product p1 = new Product("Laptop", "Gaming laptop", 1200.00, 10);
        Product p2 = new Product("Phone", "Smartphone", 800.00, 25);
        Product p3 = new Product("Headphones", "Noise cancelling", 150.00, 50);

        Long id1 = dao.save(p1);
        Long id2 = dao.save(p2);
        Long id3 = dao.save(p3);

        System.out.println("Inserted products with IDs: " + id1 + ", " + id2 + ", " + id3);

        Product fetched = dao.get(id2);
        System.out.println("Fetched product: " + fetched);

        if (fetched != null) {
            fetched.setPrice(750.00);
            fetched.setQuantity(30);
            dao.update(fetched);
            System.out.println("Updated product: " + dao.get(id2));
        }

        dao.delete(id3);
        Product deleted = dao.get(id3);
        System.out.println("After deletion, product with id " + id3 + " = " + deleted);

        HibernateUtil.shutdown();
    }
}