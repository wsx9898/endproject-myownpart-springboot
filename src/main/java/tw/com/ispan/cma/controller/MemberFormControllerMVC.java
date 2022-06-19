package tw.com.ispan.cma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.ispan.cma.domain.MembersBean;
import tw.com.ispan.cma.service.MembersService;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

@RestController
public class MemberFormControllerMVC {
    private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
    String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
    @Autowired
    private MembersService membersService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(path = {"/pages/register/registerForm.controller"})
    public String handlerMethod(String memberIdTemp, String memberAccouuntTemp, String memberPasswordTemp, String memberLastnameTemp,
                              String memberFirstnameTemp, String memberGenderTemp, String memberNicknameTemp
                              , String memberEmailTemp, String memberTelTemp, String memberAddrTemp, String memberBirthTemp
                              , String prodaction, Model model, HttpSession session){
        System.out.println("MemberFormController有被呼叫到");
//接收資料
//驗證資料
        Map<String, String> errors = new HashMap<String, String>();
        model.addAttribute("errors", errors);

        if(prodaction!=null) {
            if(prodaction.equals("Insert") || prodaction.equals("Update") || prodaction.equals("Delete")) {
                if(memberIdTemp==null || memberIdTemp.length()==0) {
                    System.out.println("Please enter memberId for "+prodaction);
                    errors.put("memberId", "Please enter memberId for "+prodaction);
                }
            }
        }
        //轉換資料
//		String memberIdTemp = request.getParameter("memberId");
        int memberId = 0;
        if(memberIdTemp!=null && memberIdTemp.length()!=0) {
            try {
                memberId = Integer.parseInt(memberIdTemp);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("memberId must be an integer");
                errors.put("memberId", "memberId must be an integer");
            }
        }
//		String memberAccouuntTemp = request.getParameter("memberAccouunt");
        String memberAccouunt = "";
        if(memberAccouuntTemp!=null && memberAccouuntTemp.length()!=0) {
            try {
                memberAccouunt = memberAccouuntTemp;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("memberAccouunt has something wrong");
                errors.put("memberAccouunt", "memberAccouunt has something wrong");
            }
        }else {
            System.out.println("帳戶不可以為空值");
            errors.put("memberAccouunt", "帳戶不可以為空值");
        }
//		String memberPasswordTemp = request.getParameter("memberPassword");
        String memberPassword = "";
        if(memberPasswordTemp!=null && memberPasswordTemp.length()!=0) {
            try {
                memberPassword = memberPasswordTemp;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("memberPassword has something wrong");
                errors.put("memberPaˋ４ssword", "memberPassword has something wrong");
            }
        }else {
            System.out.println("密碼不可以為空值");
            errors.put("memberPassword", "密碼不可以為空值");
        }
//		String memberLastnameTemp = request.getParameter("memberLastname");
        String memberLastname = "";
        if(memberLastnameTemp!=null && memberLastnameTemp.length()!=0) {
            try {
                memberLastname = memberLastnameTemp;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("memberLastname has something wrong");
                errors.put("memberLastname", "memberLastname has something wrong");
            }
        }else {
            System.out.println("姓氏不可以為空值");
            errors.put("memberLastname", "姓氏不可以為空值");
        }
//		String memberFirstnameTemp = request.getParameter("memberFirstname");
        String memberFirstname = "";
        if(memberFirstnameTemp!=null && memberFirstnameTemp.length()!=0) {
            try {
                memberFirstname = memberFirstnameTemp;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("memberFirstname has something wrong");
                errors.put("memberFirstname", "memberFirstname has something wrong");
            }
        }else {
            System.out.println("名字不可以為空值");
            errors.put("memberFirstname", "名字不可以為空值");
        }
//		String memberGenderTemp = request.getParameter("memberGender");
        String memberGender = "";
        if(memberGenderTemp!=null && memberGenderTemp.length()!=0) {
            try {
                memberGender = memberGenderTemp;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("memberGender has something wrong");
                errors.put("memberGender", "memberGender has something wrong");
            }
        }
//		String memberNicknameTemp = request.getParameter("memberNickname");
        String memberNickname = "";
        if(memberNicknameTemp!=null && memberNicknameTemp.length()!=0) {
            try {
                memberNickname = memberNicknameTemp;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("memberNickname has something wrong");
                errors.put("memberNickname", "memberNickname has something wrong");
            }
        }
//		String memberEmailTemp = request.getParameter("memberEmail");
        String memberEmail = "";
        if(memberEmailTemp!=null && memberEmailTemp.length()!=0) {
            if(patternMatches(memberEmailTemp)) {
                memberEmail = memberEmailTemp;
            }
            else {
                System.out.println("Email必須是有效的格式");
                errors.put("memberEmail", "Email必須是有效的格式");
            }
        }else {
            System.out.println("Email為必填欄位");
            errors.put("memberEmail", "Email為必填欄位");
        }
//		String memberAddrTemp = request.getParameter("memberAddr");
        String memberAddr = "";
        if(memberAddrTemp!=null && memberAddrTemp.length()!=0) {
            try {
                memberAddr = memberAddrTemp;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("memberAddr has something wrong");
                errors.put("memberAddr", "memberAddr has something wrong");
            }
        }
        String createUser = "";
        String updateUser = "";
//		String memberTelTempTemp = request.getParameter("memberTel");
        String memberTel = "";
        if(memberTelTemp !=null && memberTelTemp.length()!=0) {
            try {
                memberTel = memberTelTemp;
                int temp = Integer.parseInt(memberTelTemp);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("電話號碼必須是數字");
                errors.put("memberTel", "memberTel must be a number");
            }
        }
//		String memberBirthTemp = request.getParameter("memberBirth");
        Date memberBirth = new Date(82, 8, 11);
        if(memberBirthTemp!=null && memberBirthTemp.length()!=0) {
            try {
                memberBirth = sFormat.parse(memberBirthTemp);
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("日期格式必須為YYYY-MM-DD");
                errors.put("memberBirth", "日期格式必須為YYYY-MM-DD");
            }
        }
//		String createDateTemp = request.getParameter("createDate");
        Date createDate = Calendar.getInstance().getTime();
//		String updateDateTemp = request.getParameter("updateDate");
        Date updateDate = Calendar.getInstance().getTime();

        if(errors!=null && !errors.isEmpty()) {
            System.out.println("錯誤數量:"+errors.size());
            System.out.println("有錯誤，再丟入填寫頁面顯示");
            return "有錯誤，再丟入填寫頁面顯示";
        }


        //呼叫model
        MembersBean bean = new MembersBean();
        bean.setMemberId(memberId);
        bean.setMemberAccouunt(memberAccouunt);
        bean.setMemberPassword(memberPassword);
        bean.setMemberLastname(memberLastname);
        bean.setMemberFirstname(memberFirstname);
        bean.setMemberGender(memberGender);
        bean.setMemberNickname(memberNickname);
        bean.setMemberEmail(memberEmail);
        bean.setMemberTel(memberTel+"");
        bean.setMemberAddr(memberAddr);
        bean.setMemberBirth(memberBirth);
        bean.setCreateUser(createUser);
        bean.setCreateDate(createDate);
        bean.setUpdateUser(updateUser);
        bean.setUpdateDate(updateDate);

        //根據Model執行結果導向View
        if(prodaction!=null && prodaction.equals("Select")) {
            List<MembersBean> result = membersService.select(bean);
            session.setAttribute("select", result);
                    return "選取成功";
        } else if(prodaction!=null && prodaction.equals("提交")) {
            MembersBean result = membersService.insert(bean);
            if(result==null) {
                errors.put("action", "Insert fail");
            } else {
                session.setAttribute("insert", result);
            }
            return "提交成功";
        } else if(prodaction!=null && prodaction.equals("Update")) {
            MembersBean result = membersService.update(bean);
            if(result==null) {
                errors.put("action", "Update fail");
            } else {
                session.setAttribute("update", result);
            }
            return "更新成功";
        }else  {
            errors.put("action", "Unknown Action:"+prodaction);
//            return "/pages/register/registerForm";
            return "新增失敗";
        }
    }
    //Email Regex Function
    public static boolean patternMatches(String emailAddress) {
        String regexPattern = "^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern).matcher(emailAddress).matches();
    }
}
