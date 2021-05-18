package com.stoxckbid.payumoney.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductList {

	public int number;
	public List<Product> products;
	public int recordsFiltered;
	public int recordsTotal;
	public int totalPages;

}
