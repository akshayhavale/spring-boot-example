package com.stoxckbid.payumoney.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttributeOptionValue {
	
	 public ArticleSpecification articleSpecification;
	    public String attiributeDescription;
	    public int attributeId;
	    public int attributePrice;
	    public int attributeQuantity;
	    public String colorCode;
	    public String ean;
	    public List<Image> images;
	    public String item_sku;
	    public String optionValueCode;
	    public boolean optionValueDefault;
	    public int optionValueId;
	    public int priceFinal;
	    public int productWithAttrPrice;
	    public String styleCode;
	    public String styleDescription;
	    public int tradeDisCount;

}
