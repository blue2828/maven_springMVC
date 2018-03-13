package ControllerPackage;

import dao.IGradeDao;
import dao.IUserDao;
import entity.Grade;
import entity.Page;
import entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.jsonUtil;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
@Controller
@Scope("prototype")
public class getUserInfoController {
    @Resource
    private IUserDao userDao;
    @Resource
    private IGradeDao gradeDao;
    @RequestMapping("/getUserInfo")
    public void getUserInfo(HttpServletResponse response)throws Exception{
        User user=userDao.getUserInfo();
        JSONObject jb=new JSONObject();
        jb.put("user",user);
        jsonUtil.writer(response,jb);
    }
    @ResponseBody
    @RequestMapping(value="/getGradeInfo")
    public JSONObject getGradeInfo(int page,int limit,Grade grade)throws Exception{
        Page p=new Page(page,limit);
        List<Grade> list =gradeDao.getGradeInfo(p,grade);
        JSONArray array=JSONArray.fromObject(list);
        JSONObject jb=new JSONObject();
        jb.put("count",list.size());
        jb.put("msg","");
        jb.put("data",array);
        jb.put("code",0);
        return jb;
    }
    @ResponseBody
    @RequestMapping("/saveGrade")
    public JSONObject saveGradeInfo(Grade grade,String version){
        JSONObject jb=new JSONObject();
        int num=gradeDao.saveGrade(grade);
        if(num>0)jb.put("success",true);
        else{
            jb.put("success",false);
            jb.put("errMsg","保存失败");
        }
        return jb;
    }
    @ResponseBody
    @RequestMapping("/delGrade")
    public JSONObject delGrade(String delId){
        JSONObject jb=new JSONObject();
        int num=gradeDao.delGrade(delId);
        if(num>0) jb.put("success",true);
        else {
            jb.put("success",false);
            jb.put("errMsg","删除失败");
        }
        return jb;
    }
}
