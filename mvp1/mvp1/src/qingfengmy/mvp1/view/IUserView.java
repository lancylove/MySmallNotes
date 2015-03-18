package qingfengmy.mvp1.view;

/**
 * 根据需求可知，View可以对ID、FirstName、LastName这三个EditText进行读操作，对FirstName和LastName进行写操作
 * 
 * @author Administrator
 * 
 */
public interface IUserView {
	int getID();

	String getFristName();

	String getLastName();

	void setFirstName(String firstName);

	void setLastName(String lastName);
}
