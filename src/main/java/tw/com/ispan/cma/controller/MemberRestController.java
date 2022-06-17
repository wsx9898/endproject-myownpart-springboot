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
    @PostMapping(path = {"/getMemberInfo"})
    public ResponseEntity<MembersBean> getMemberInfo(){
        MembersBean bean = memberRepositoryService.selectByID(1);
        //
        bean.setMemberPassword("");
        return ResponseEntity.ok().body(bean);
    }



    @PostMapping(path = {"/getMemberInfo2"})
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

//這個複製老師來參考的而已
//    @PostMapping("/testReceiveJSON")
//    public ResponseEntity<?> create(@RequestBody String body) {
////		新增：POST message body包含需要新增的resource資料
////		成功：201 (Created)、Location header包含指向新增成功resource的URI、message body包含新增成功的resource資料
////		失敗：204 (No Content)
//        JSONObject jsonObj = new JSONObject(body);
//        Date date = null;
//        try {
//            String make = jsonObj.getString("make");
//            date = new SimpleDateFormat("yyyy-MM-dd").parse(make);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ProductBean bean = new ProductBean();
//        bean.setId(jsonObj.getInt("id"));
//        bean.setName(jsonObj.getString("name"));
//        bean.setPrice(jsonObj.getDouble("price"));
//        bean.setMake(date);
//        bean.setExpire(jsonObj.getInt("expire"));
//
//        ProductBean insert = productReositoryService.insert(bean);
//        if(insert!=null) {
//            URI uri = URI.create("/public/api/products/"+insert.getId());
//            ResponseEntity<ProductBean> entity = ResponseEntity.created(uri).body(insert);
//            return entity;
//        } else {
//            ResponseEntity<?> entity = ResponseEntity.noContent().build();
//            return entity;
//        }
//    }
    //這個複製老師來參考的而已
}
