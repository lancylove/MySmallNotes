package qingfengmy.mvp1.model;

import qingfengmy.mvp1.bean.UserBean;

/**
 * ModelҲ��Ҫ���������ֶν��ж�д���������洢��ĳ��������(�ⲻ�����������ĵģ����Դ����ڴ桢�ļ������ݿ����Զ�̷�������
 * ������Presenter��View��Ӱ��)
 * 
 * @author Administrator
 * 
 */
public interface IUserModel {
	void setID(int id);

	void setFirstName(String firstName);

	void setLastName(String lastName);

	int getID();

	UserBean load(int id);// ͨ��id��ȡuser��Ϣ,����һ��UserBean
}
