package com.stoxckbid.payumoney.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Attribute {

	public boolean attributeDefault;
	public List<AttributeOptionValue> attributeOptionValues;
	public String language;
	public String optionCode;
	public int optionId;
	public boolean readOnly;
	public String type;

}
