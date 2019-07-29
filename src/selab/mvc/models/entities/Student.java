package selab.mvc.models.entities;

import selab.mvc.models.DataSet;
import selab.mvc.models.Model;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Student implements Model {
    private String name;
    private String studentNo;
    private DataSet<Registration> registrations;

    @Override
    public String getPrimaryKey() {
        return this.studentNo;
    }

    public void setName(String value) { this.name = value; }
    public String getName() { return this.name; }
    public void setRegistrations(DataSet<Registration> regs){ registrations = regs;}
    public void setStudentNo(String value) {
        if (!validateStudentNo(value))
            throw new IllegalArgumentException("The format is not correct");

        this.studentNo = value;
    }
    public String getStudentNo() { return this.studentNo; }

    public float getAverage() {
        ArrayList<Registration> allRegs = registrations.getAll();
        int avg = 0;
        for(int i = 0;i<allRegs.size();i++){
            avg += allRegs.get(i).getPoints();
        }

        return avg/allRegs.size();
    }

    public String getCourses() {
        String str = "";
        ArrayList<Registration> allRegs = registrations.getAll();
        for(int i = 0;i<allRegs.size();i++) {
            str += allRegs.get(i).getCourseNo();
            if(i!=allRegs.size()-1)
                str+=" - ";
        }

        return str;
    }

    /**
     *
     * @param studentNo Student number to be checeked
     * @return true, if the format of the student number is correct
     */
    private boolean validateStudentNo(String studentNo) {
        Pattern pattern = Pattern.compile("^[8-9]\\d{7}$");
        return pattern.matcher(studentNo).find();
    }
}
