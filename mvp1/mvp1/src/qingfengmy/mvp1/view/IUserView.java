package qingfengmy.mvp1.view;

/**
 * ���������֪��View���Զ�ID��FirstName��LastName������EditText���ж���������FirstName��LastName����д����
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
