package tw.com.ispan.cma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tw.com.ispan.cma.dao.MemberRepository;
import tw.com.ispan.cma.domain.MembersBean;
import tw.com.ispan.cma.service.MemberRepositoryService;

import java.util.List;

@Controller
@RequestMapping(path = {"/public/api"})
public class MemberRestController {

    @Autowired
    MemberRepositoryService memberRepositoryService;

    @GetMapping( path = {"/products"} )
    public ResponseEntity<List<MembersBean>> findAll() {
//		成功：200 (OK)、message body包含所有resource資料
        List<MembersBean> beans = memberRepositoryService.select(null);
        return ResponseEntity.ok().body(beans);
    }
}
