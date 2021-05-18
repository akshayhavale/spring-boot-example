package com.stoxckbid.payumoney.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

	public List<Attribute> attributes;
	public String bargain;
	public String bargainEndDateTime;
	public String bargainStartDateTime;
	public String brandName;
	public boolean buyable;
	public List<Category> categories;
	public String collectionCategory;
	public String countryOfOrigin;
	public String creationDate;
	public String dateAvailable;
	public Description description;
	public boolean discounted;
	public String fashionGroup;
	public String finalPrice;
	public String hsn;
	public int id;
	public String originalPrice;
	public PackagingSpecifications packagingSpecifications;
	public int price;
	public String productGroup;
	public ProductUserDetail productUserDetail;
	public int quantity;
	public String season;
	public String seasonYear;
	public String sellItFaster;
	public String sku;
	public int taxRate;

}
