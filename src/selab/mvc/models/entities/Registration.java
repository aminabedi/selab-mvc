
package selab.mvc.models.entities;

        import selab.mvc.models.Model;

        import java.util.regex.Pattern;

public class Registration implements Model {
    private String courseNo;
    private String studentNo;
    private Integer points;

    @Override
    public String getPrimaryKey() {
        return this.courseNo + '-' + this.studentNo;
    }

    public void setPoints(Integer p) { System.out.println("COME ON!!");
    this.points = p; }
    public Integer getPoints() { return this.points; }

    public void setStudentNo(String value) {
        this.studentNo = value;
    }
    public void setCourseNo(String value) {
        this.courseNo = value;
    }
    public String getStudentNo() { return this.studentNo; }
    public String getCourseNo() { return this.courseNo; }


}
