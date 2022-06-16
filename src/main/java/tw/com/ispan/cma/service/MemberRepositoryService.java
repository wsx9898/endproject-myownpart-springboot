package tw.com.ispan.cma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.com.ispan.cma.dao.MemberRepository;
import tw.com.ispan.cma.domain.MembersBean;
import tw.com.ispan.cma.domain.ProductBean;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberRepositoryService {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<MembersBean> select(MembersBean bean){
        List<MembersBean> result = null;
        if(bean!=null && bean.getMemberId()!=null && !bean.getMemberId().equals(0)) {
            Optional<MembersBean> optional = memberRepository.findById(bean.getMemberId());
            if(optional.isPresent()) {
                result = new ArrayList<MembersBean>();
                MembersBean temp = optional.get();
                result.add(temp);
            }
        } else {
            result = memberRepository.findAll();
        }
        return result;
    }

    public MembersBean insert(MembersBean bean) {
        MembersBean result = null;
        if(bean!=null && bean.getMemberId()!=null) {
            Optional<MembersBean> optional = memberRepository.findById(bean.getMemberId());
            if(optional.isEmpty()) {
                return memberRepository.save(bean);
            }
        }
        return result;
    }
    public MembersBean update(MembersBean bean) {
        MembersBean result = null;
        if(bean!=null && bean.getMemberId()!=null) {
            Optional<MembersBean> optional = memberRepository.findById(bean.getMemberId());
            if(optional.isPresent()) {
                return memberRepository.save(bean);
            }
        }
        return result;
    }
    public boolean delete(MembersBean bean) {
        boolean result = false;
        if(bean!=null && bean.getMemberId()!=null) {
            Optional<MembersBean> optional = memberRepository.findById(bean.getMemberId());
            if(optional.isPresent()) {
                MembersBean temp = optional.get();
                memberRepository.delete(temp);
                return true;
            }
        }
        return result;
    }
}
