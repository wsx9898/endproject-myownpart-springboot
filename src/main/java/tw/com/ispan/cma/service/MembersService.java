package tw.com.ispan.cma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tw.com.ispan.cma.dao.MembersDAO;
import tw.com.ispan.cma.domain.CustomerBean;
import tw.com.ispan.cma.domain.MembersBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public class MembersService {
	@Autowired
	private MembersDAO membersDao;


	@Transactional(readOnly = true)
	public MembersBean login(String memberAccount, String password) {
		System.out.println("現在被KevinLoginController呼叫到了");
		MembersBean bean = membersDao.selectByAccount(memberAccount);//這行目前有問屜
		System.out.println("bean.getMemberAccouunt() = " + bean.getMemberAccouunt());//現在寫死固定拿第一個帳號apple123
		if(bean!=null) {
			if(password!=null && password.length()!=0) {
				String pass = bean.getMemberPassword();
				if(pass == password) {
					return bean;
				}
			}
		}
		return null;
	}

	
	public List<MembersBean> select(MembersBean bean){
		List<MembersBean> result = null;
		if(bean!=null && bean.getMemberId()!=null && !bean.getMemberId().equals(0)) {
			MembersBean temp = membersDao.select(bean.getMemberId());
			if(temp!=null) {
				result = new ArrayList<MembersBean>();
				result.add(temp);
			}
		}else {
			result = membersDao.select();
		}	
		return result;
	};
	public MembersBean insert(MembersBean bean){
		MembersBean result = null;
		if(bean!=null && bean.getMemberId()!=null) {

			System.out.println(bean.getMemberId() + " from Members service");
			result = membersDao.insert(bean);
		}	
		return result;
	};
	
	public MembersBean update(MembersBean bean){
		MembersBean result = null;
		if(bean!=null && bean.getMemberId()!=null) {	
			result = membersDao.update(bean.getMemberLastname(),
					bean.getMemberFirstname(),
					bean.getMemberNickname(),
					bean.getMemberEmail(),
					bean.getMemberTel(),
					bean.getMemberAddr(),
					bean.getMemberBirth(),
					bean.getMemberId());				
		}	
		return result;
	};
	
	public boolean delete(MembersBean bean) {
		boolean result = false;
		if(bean!=null && bean.getMemberId()!=null) {
			result = membersDao.delete(bean.getMemberId());
		}
		return result;
	};
	

}
