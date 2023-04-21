package miniproject;

public class UserPojo 
{
	int uId;
	String uName;
	String pwd;
	String type;
	
	
	public UserPojo()
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public UserPojo(int uId, String uName, String pwd, String type) 
	{
		super();
		this.uId = uId;
		this.uName = uName;
		this.pwd = pwd;
		this.type = type;
	}


	public int getuId() {
		return uId;
	}


	public void setuId(int uId) {
		this.uId = uId;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "UserPojo [uId=" + uId + ", uName=" + uName + ", pwd=" + pwd + ", type=" + type + "]";
	}
	
	
	
	
	
}
