package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GstModel {

	public String code;
	public String name;
	@JsonProperty("SGST Rate (%)")
	public String sGSTRate;
	@JsonProperty("CGST Rate (%)")
	public String cGSTRate;
	@JsonProperty("IGST Rate (%)")
	public String iGSTRate;
	@JsonProperty("UTGST Rate (%)")
	public String uTGSTRate;

}
