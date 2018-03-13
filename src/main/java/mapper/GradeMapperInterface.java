package mapper;

import entity.Grade;
import entity.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface GradeMapperInterface {
   @Select("<script>select * from t_grade where 1=1 <when test='grade.id!=0'> and id like concat('%', #{grade.id},'%') </when> and gradeName like concat('%',#{grade.gradeName},'%') limit #{page.start},#{page.limit}</script>")
    public List<Grade> getGradeByCon( @Param("grade") Grade grade,@Param("page") Page page);
    @Select("select * from t_grade limit #{start},#{limit}")
    public List<Grade> getAllGrade(Page page);
    @Insert("insert into t_grade values(null,#{gradeName},#{gradeDesc})")
    public int addGrade(Grade grade);
    @Update("update t_grade set gradeName=#{gradeName},gradeDesc=#{gradeDesc} where id=#{id}")
    public int editGrade(Grade grade);
    @Delete("delete from t_grade where id in(#{delIds})")
    public void delGrade(String delIds );
}
