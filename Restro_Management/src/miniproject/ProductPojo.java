package miniproject;

public class ProductPojo 
{
	int pId;
	String pName;
	String description;
	int price;
	
	
	
	public ProductPojo() 
	{
		super();
		// TODO Auto-generated constructor stub
	}



	public ProductPojo(int pId, String pName, String description, int price) 
	{
		super();
		this.pId = pId;
		this.pName = pName;
		this.description = description;
		this.price = price;
	}



	public int getpId() {
		return pId;
	}



	public void setpId(int pId) {
		this.pId = pId;
	}



	public String getpName() {
		return pName;
	}



	public void setpName(String pName) {
		this.pName = pName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "ProductPojo [pId=" + pId + ", pName=" + pName + ", description=" + description + ", price=" + price
				+ "]";
	}
	
	
	
	
	
	
	
	
	
}
