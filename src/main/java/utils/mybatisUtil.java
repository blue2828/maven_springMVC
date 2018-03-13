package utils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedInputStream;
public class mybatisUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    public static SqlSessionFactory getInstance()throws Exception{
        if(null==sqlSessionFactory){
            BufferedInputStream input=new BufferedInputStream(mybatisUtil.class.getClassLoader().getResourceAsStream("conf.xml"));
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(input);
        }
        return sqlSessionFactory;
    }
    public SqlSession getSqlSession()throws Exception{
        return getInstance().openSession();
    }
}
