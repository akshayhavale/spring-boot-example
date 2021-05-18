package com.stoxckbid.payumoney.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Category {
	
	public List<Object> children;
    public String code;
    public int depth;
    public Description description;
    public boolean featured;
    public int id;
    public String lineage;
    public Parent parent;
    public int productCount;
    public int sortOrder;
    public boolean visible;

}
