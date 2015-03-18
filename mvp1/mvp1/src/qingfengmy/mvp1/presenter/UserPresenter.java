package qingfengmy.mvp1.presenter;

import qingfengmy.mvp1.bean.UserBean;
import qingfengmy.mvp1.model.IUserModel;
import qingfengmy.mvp1.model.impl.UserModel;
import qingfengmy.mvp1.view.IUserView;
/**
 * Presenter����ͨ���ӿ���View��Model���н���
 * @author Administrator
 *
 */
public class UserPresenter {
	private IUserView mUserView;
	private IUserModel mUserModel;

	public UserPresenter(IUserView view) {
		mUserView = view;
		mUserModel = new UserModel();
	}

	public void saveUser(int id, String firstName, String lastName) {
		mUserModel.setID(id);
		mUserModel.setFirstName(firstName);
		mUserModel.setLastName(lastName);
	}

	public void loadUser(int id) {
		UserBean user = mUserModel.load(id);
		mUserView.setFirstName(user.getFirstName());// ͨ������IUserView�ķ�����������ʾ
		mUserView.setLastName(user.getLastName());
	}
}
