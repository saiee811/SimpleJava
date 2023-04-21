package miniproject;

public class OderPojo 
{
	int oId;
	int quantity;
	int uId;
	int pId;
	
	
	
	
	public OderPojo() 
	{
		super();
		// TODO Auto-generated constructor stub
	}




	public OderPojo(int oId, int quantity, int uId, int pId) 
	{
		super();
		this.oId = oId;
		this.quantity = quantity;
		this.uId = uId;
		this.pId = pId;
	}




	public int getoId() {
		return oId;
	}




	public void setoId(int oId) {
		this.oId = oId;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public int getuId() {
		return uId;
	}




	public void setuId(int uId) {
		this.uId = uId;
	}




	public int getpId() {
		return pId;
	}




	public void setpId(int pId) {
		this.pId = pId;
	}




	@Override
	public String toString() {
		return "OderPojo [oId=" + oId + ", quantity=" + quantity + ", uId=" + uId + ", pId=" + pId + "]";
	}
	
	
	
	
	
}
