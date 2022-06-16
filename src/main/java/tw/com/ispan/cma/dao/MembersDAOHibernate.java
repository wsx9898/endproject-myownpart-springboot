package tw.com.ispan.cma.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import tw.com.ispan.cma.domain.MembersBean;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;


@Repository
public class MembersDAOHibernate implements MembersDAO {
	@PersistenceContext
	private Session session = null;

	public Session getSession() {
		return session;
	}

	@Override
	public MembersBean select(Integer memberId) {
		if (memberId != null) {
			return this.getSession().get(MembersBean.class, memberId);
		}
		return null;
	}


	@Override
	public MembersBean selectByAccount(String memberAccount){
		if(memberAccount!=null && memberAccount.length()!=0){
			return  this.getSession().get(MembersBean.class, memberAccount);//這行有問題，方法裡面沒有用memberAccount撈
//			return  this.getSession().get(MembersBean.class, 1);//所以只能用id去資料庫撈bean嗎？
		}
		return null;
	}



	@Override
	public List<MembersBean> select() {
//		return this.getSession().createQuery(
//				"FROM MembersBean", MembersBean.class).list();
		
		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<MembersBean> criteriaQuery = criteriaBuilder.createQuery(MembersBean.class);
		
		
		Root<MembersBean> root = criteriaQuery.from(MembersBean.class);
		TypedQuery<MembersBean> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<MembersBean> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			return result;
		}
		return null;
	}

	@Override
	public MembersBean insert(MembersBean bean) {
		if (bean != null && bean.getMemberId() != null) {
			MembersBean temp = this.getSession().get(MembersBean.class, bean.getMemberId());
			if (temp == null) {
				if(bean.getMemberLastname()==null) {
					bean.setMemberLastname("");
				};
				if(bean.getMemberFirstname()==null) {
					bean.setMemberFirstname("");
				};
				if(bean.getMemberAddr()==null) {
					bean.setMemberAddr("");
				};
				if(bean.getMemberGender()==null) {
					bean.setMemberGender("female");
				};
				if(bean.getCreateDate()==null) {
					bean.setCreateDate(new Date(11, 11, 11));
				};
				if(bean.getUpdateDate()==null) {
					bean.setUpdateDate(new Date(11, 11, 11));
				};
				if(bean.getCreateUser()==null) {
					bean.setCreateUser("");
				};
				if(bean.getUpdateUser()==null) {
					bean.setUpdateUser("");
				};
				if(bean.getMemberAccouunt()==null) {
					bean.setMemberAccouunt("");
				};
				if(bean.getMemberBirth()==null) {
					bean.setMemberBirth(new Date(11, 11, 11));
				};
				if(bean.getMemberNickname()==null) {
					bean.setMemberNickname("");
				};
				if(bean.getMemberEmail()==null) {
					bean.setMemberEmail("");
				};
				if(bean.getMemberPassword()==null) {
					bean.setMemberPassword("");
				};
				if(bean.getMemberTel()==null) {
					bean.setMemberTel("");
				};
				
						
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	public MembersBean update(MembersBean bean) {
		if(bean!=null && bean.getMemberId()!=null) {
			MembersBean temp = this.getSession().get(MembersBean.class, bean.getMemberId());
			if(temp!=null) {
				return (MembersBean) this.getSession().merge(bean);
			}
		}
		return null;
	}
	@Override
	public MembersBean update(String memberLastname, String memberFirstname, String memberNickname, String memberEmail,
			String memberTel, String memberAddr, Date memberBirth,Integer memberId) {
		if (memberId != null) {
			MembersBean temp = this.getSession().get(MembersBean.class, memberId);
			if (temp != null) {
				temp.setMemberLastname(memberLastname);
				temp.setMemberFirstname(memberFirstname);
				temp.setMemberNickname(memberNickname);
				temp.setMemberTel(memberTel);
				temp.setMemberAddr(memberAddr);
				temp.setMemberBirth(memberBirth);
				
				return temp;
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer memberId) {
		if (memberId != null) {
			MembersBean temp = this.getSession().get(MembersBean.class, memberId);
			if (temp != null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}

}
