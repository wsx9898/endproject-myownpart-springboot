package tw.com.ispan.cma.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tw.com.ispan.cma.dao.MemberRepository;
import tw.com.ispan.cma.domain.MembersBean;
import tw.com.ispan.cma.domain.ProductBean;
import tw.com.ispan.cma.service.MemberRepositoryService;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
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

//work
    @PostMapping(path = {"/getAllMemberInfo"})
    public ResponseEntity<MembersBean> getMemberInfo(){
        MembersBean bean = memberRepositoryService.selectByID(1);
        //
        bean.setMemberPassword("");
        return ResponseEntity.ok().body(bean);
    }


    //前端restful
    //
    //{
    //    "memberId":"2"
    //}


    @PostMapping(path = {"/getMemberInfoById"})
    public ResponseEntity<MembersBean> getMemberInfo2(@RequestBody String body){
        String memberIdTemp="";
        Integer memberId=0;
        JSONObject jsonObject = new JSONObject(body);
        try {
            memberIdTemp = jsonObject.getString("memberId");
        }catch (Exception e){
            System.out.println("有錯誤碼："+e);
            e.printStackTrace();
        }
        try {
            memberId = Integer.parseInt(memberIdTemp);
        }catch (Exception e){
            System.out.println("有錯誤碼："+e);
            System.out.println("無法將memberIdTemp轉為數字");
            e.printStackTrace();
        }

        MembersBean bean = memberRepositoryService.selectByID(memberId);
        bean.setMemberPassword("");
        return ResponseEntity.ok().body(bean);
    }
}
