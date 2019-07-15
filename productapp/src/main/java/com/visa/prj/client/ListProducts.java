package com.visa.prj.client;

import java.util.List;

import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;

public class ListProducts {

	public static void main(String[] args) {
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			List<Product> prds = productDao.getProducts();
			for (Product p : prds) {
				System.out.println(p.getName() + " : " + p.getPrice());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
