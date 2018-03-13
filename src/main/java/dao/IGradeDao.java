package dao;

import entity.Grade;
import entity.Page;

import java.util.List;
public interface IGradeDao {
    public List<Grade> getGradeInfo(Page page,Grade grade);
    public int saveGrade(Grade grade);
    public int delGrade(String delIds);
}
