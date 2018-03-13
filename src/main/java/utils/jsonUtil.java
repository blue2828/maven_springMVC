package utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class jsonUtil {
    public static void writer(HttpServletResponse response,Object obj){
        response.setHeader("content-type","application/json;charset=utf-8");
        PrintWriter out=null;
        try{
            out=response.getWriter();
            out.println(obj);
            out.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(null!=out) out.close();
        }
    }
}
