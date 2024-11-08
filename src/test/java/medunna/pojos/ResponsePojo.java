package medunna.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsePojo implements Serializable {
	private int id;
	private String name;
	private String description;
	private String price;
	private String defaultValMin;
	private String defaultValMax;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setDefaultValMin(String defaultValMin){
		this.defaultValMin = defaultValMin;
	}

	public String getDefaultValMin(){
		return defaultValMin;
	}

	public void setDefaultValMax(String defaultValMax){
		this.defaultValMax = defaultValMax;
	}

	public String getDefaultValMax(){
		return defaultValMax;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePojo{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",price = '" + price + '\'' + 
			",defaultValMin = '" + defaultValMin + '\'' + 
			",defaultValMax = '" + defaultValMax + '\'' + 
			"}";
		}
}