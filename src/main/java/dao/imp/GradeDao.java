package dao.imp;

import dao.IGradeDao;
import entity.Grade;
import entity.Page;
import mapper.GradeMapperInterface;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import utils.mybatisUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("gradeDao")
public class GradeDao implements IGradeDao {
    @Override
    public List<Grade> getGradeInfo(Page page,Grade grade) {
        mybatisUtil mt=new mybatisUtil();
        SqlSession sqlSession=null;
        List<Grade> list=null;
        try{
            sqlSession=mt.getSqlSession();
            GradeMapperInterface mapper=sqlSession.getMapper(GradeMapperInterface.class);
            if(grade.getId()==0){
                if(!StringUtils.isNotEmpty(grade.getGradeName()))
                list=mapper.getAllGrade(page);
                else {
                    list=mapper.getGradeByCon(grade,page);
                }
            }else{
                list=mapper.getGradeByCon(grade,page);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null!=sqlSession) sqlSession.close();
        }
        return list;
    }

    @Override
    public int saveGrade(Grade grade) {
        mybatisUtil mt=new mybatisUtil();
        SqlSession sqlSession=null;
        int num=-1;
        try{
            sqlSession=mt.getSqlSession();
            GradeMapperInterface mapper=sqlSession.getMapper(GradeMapperInterface.class);
            if(grade.getId()==0)
            mapper.addGrade(grade);
            else mapper.editGrade(grade);
            num=1;
            sqlSession.commit();
        }catch(Exception e){
            num=0;
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null) sqlSession.close();
        }
        return num;
    }

    @Override
    public int delGrade(String delIds) {
        SqlSession sqlSession=null;
        int num=-1;
        try{
            mybatisUtil mt=new mybatisUtil();
            sqlSession=mt.getSqlSession();
            GradeMapperInterface mapper=sqlSession.getMapper(GradeMapperInterface.class);
            String strIds[]=delIds.split(",");
            for(String id:strIds){
                mapper.delGrade(id);
            }
            num=1;
            sqlSession.commit();
        }catch(Exception e){
            num=0;
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            if(sqlSession!=null) sqlSession.close();
        }
        return num;
    }
}
