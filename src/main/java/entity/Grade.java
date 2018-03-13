package entity;

public class Grade {
    private String gradeName;
    private String gradeDesc;
    private int id;

    public String getGradeName() {
        return gradeName;
    }
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
    public String getGradeDesc() {
        return gradeDesc;
    }
    public void setGradeDesc(String gradeDesc) {
        this.gradeDesc = gradeDesc;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Grade() {
    }
    public Grade(String gradeName,String gradeDesc){
        this.gradeName=gradeName;
        this.gradeDesc=gradeDesc;
    }
}
