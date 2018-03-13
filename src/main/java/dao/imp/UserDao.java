package dao.imp;

import dao.IUserDao;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;
import utils.mybatisUtil;

import java.io.InputStream;

@Repository("userDao")
public class UserDao implements IUserDao {
    @Override
    public User getUserInfo() throws Exception{
        mybatisUtil mybatisUtil=new mybatisUtil();
        SqlSession sqlSession=mybatisUtil.getSqlSession();
        String statement="entityMapping.UserMapper.getUser";
        User user=sqlSession.selectOne(statement,2);
        return user;
    }
}
