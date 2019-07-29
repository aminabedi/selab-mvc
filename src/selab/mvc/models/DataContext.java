package selab.mvc.models;

import selab.mvc.models.entities.Course;
import selab.mvc.models.entities.Registration;
import selab.mvc.models.entities.Student;
import selab.mvc.models.entities.Weekday;

import java.util.ArrayList;

public class DataContext {
    public DataContext() {
        seed();
    }

    private DataSet<Student> students = new DataSet<>();
    private DataSet<Course> courses = new DataSet<>();
    private DataSet<Registration> registrations = new DataSet<>();

    public DataSet<Student> getStudents() {
        ArrayList<Student> allStudents = this.students.getAll();
        ArrayList<Registration> allRegs = this.registrations.getAll();
        DataSet<Student> ret = new DataSet<>();
        for(int i= 0;i<allStudents.size();i++){
            Student s = allStudents.get(i);
            DataSet<Registration> myRegs = new DataSet<>();
            for(int j = 0;j<allRegs.size();j++) {
                Registration r = allRegs.get(j);
                if (r.getStudentNo().equals( s.getStudentNo())) {
                    System.out.println("MATCHED FOUND in getStudents");
                    myRegs.add(r);
                }
            }
            s.setRegistrations(myRegs);
            ret.add(s);
        }
        return ret;
    }
    public DataSet<Course> getCourses() {
        ArrayList<Course> allCourses = this.courses.getAll();
        ArrayList<Registration> allRegs = this.registrations.getAll();
        System.out.println("getting courses:");
        System.out.println(allRegs.size());
        DataSet<Course> ret = new DataSet<>();
        for(int i= 0;i<allCourses.size();i++){
            Course c = allCourses.get(i);
            DataSet<Registration> myRegs = new DataSet<>();
            for(int j = 0;j<allRegs.size();j++) {
                Registration r = allRegs.get(j);
                if (r.getCourseNo().equals(c.getCourseNo())) {
                    System.out.println("MATCH FOUND in getCourses");
                    myRegs.add(r);
                }
            }
            c.setRegistrations(myRegs);
            ret.add(c);
        }
        return ret;
    }
    public DataSet<Registration> getRegistrations() {return this.registrations;}

    /**
     * Adding some initial data to the context
     */
    public void seed() {
        Student student1 = new Student();
        student1.setName("Ahmadreza");
        student1.setStudentNo("96209547");
        students.add(student1);

        Student student2 = new Student();
        student2.setName("Alireza");
        student2.setStudentNo("96102345");
        students.add(student2);

        Student student3 = new Student();
        student3.setName("Mina");
        student3.setStudentNo("97456789");
        students.add(student3);

        Course course1 = new Course();
        course1.setTitle("SE Lab");
        course1.setCourseNo("40444-1");
        course1.setStartTime("16:30");
        course1.setEndTime("19:00");
        course1.setWeekday(Weekday.Sunday);
        courses.add(course1);

        Course course2 = new Course();
        course2.setTitle("Advanced Programming");
        course2.setCourseNo("40466-1");
        course2.setStartTime("14:30");
        course2.setEndTime("16:30");
        course2.setWeekday(Weekday.Monday);
        courses.add(course2);
    }
}
