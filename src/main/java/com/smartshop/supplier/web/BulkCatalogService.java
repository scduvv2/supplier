package com.smartshop.supplier.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.smartshop.store.Product;

public class BulkCatalogService {


	public List <Product>  processBulkform(File file) throws BulkCatalogProcessException{
		
		List<Product> newProducts =new ArrayList<Product>();
		try{
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br =
					new BufferedReader( new InputStreamReader(fis, "UTF-8" ));

			
			String line = "";
			while(( line = br.readLine()) != null ) {
					validateProductLine(line);
					Product product = createProduct(line);
					newProducts.add(product);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return newProducts;


	}

	private void validateProductLine(String line) throws InvalidDataException{
		
		
	}

	private Product createProduct(String line) {
		
		String[] lines  = line.split(",");
		
		Product product = new Product();
		product.setName(lines[0]);
		product.setBrand(lines[1]);
		product.setBarCode(lines[2]);
		
		return product;
	}


}
