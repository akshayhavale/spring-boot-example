package com.example.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class GstModels {
	
	private List<GstModel> models = new ArrayList<>();

}
