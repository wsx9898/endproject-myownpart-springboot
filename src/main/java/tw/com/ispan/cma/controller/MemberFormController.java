package tw.com.ispan.cma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tw.com.ispan.cma.domain.MembersBean;
import tw.com.ispan.cma.service.MembersService;


import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MemberFormController {
    private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private MembersService membersService;

    @GetMapping("/member/{memberId}")
    public ResponseEntity<?> findMember(@PathVariable("memberId") int id) {
        MembersBean bean = new MembersBean();
        bean.setMemberId(id);
        var res = membersService.select(bean).get(0);
        if(res!=null){
            return ResponseEntity.ok(res.toString());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/member/new")
    public ResponseEntity<?> insert(@RequestBody MembersBean bean, HttpSession session){
        System.out.println("新增會員方法insert有被呼叫到");
        bean.setUpdateUser((String) session.getAttribute("login"));
        bean.setCreateUser((String) session.getAttribute("login"));
        bean.setCreateDate(new Date());
        bean.setUpdateDate(new Date());
        System.out.println("我要測試的membersBean值為："+bean);
        MembersBean res = membersService.insert(bean);
        if(res!=null){
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
    //Email Regex Function
    public static boolean patternMatches(String emailAddress) {
        String regexPattern = "^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern).matcher(emailAddress).matches();
    }
}