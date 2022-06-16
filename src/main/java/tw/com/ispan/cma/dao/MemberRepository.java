package tw.com.ispan.cma.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.com.ispan.cma.domain.MembersBean;

public interface MemberRepository extends JpaRepository<MembersBean, Integer> {
}
