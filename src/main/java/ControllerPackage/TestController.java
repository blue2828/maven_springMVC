package ControllerPackage;

import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import utils.jsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class TestController {
    @RequestMapping("/testInfo")
   public void testMethod(HttpServletRequest request,HttpServletResponse response) {
        JSONObject jb=new JSONObject();
        JSONArray array=new JSONArray();
        JSONObject tempJb=new JSONObject();
        tempJb.put("id",1);
        tempJb.put("name","stephy");
        tempJb.put("sex","女");
        array.add(tempJb);
        tempJb=new JSONObject();tempJb.put("id",2);tempJb.put("name","theresa");tempJb.put("sex","女");array.add(tempJb);
        jb.put("code",0);
        jb.put("msg","");
        jb.put("count",2);
        jb.put("data",array);
        jsonUtil.writer(response,jb);
   }
   @RequestMapping("/toTest")
   public String testRedirect()throws Exception{
       return "index";
   }
}
