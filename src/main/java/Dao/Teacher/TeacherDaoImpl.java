package Dao.Teacher;

import Dao.DaoException;
import javabean.College;
import javabean.Student;
import javabean.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDaoImpl implements TeacherDao{
    @Override
    public boolean addteacher(Teacher teacher) throws DaoException {
        String sql = "INSERT INTO teacher VALUES(?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1,teacher.getTno());
            pstmt.setString(2,teacher.getTname());
            pstmt.setString(3,teacher.getProf());
            pstmt.setString(4,teacher.getIntroduction());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Teacher> findAllteacher() throws DaoException {
        String sql = "SELECT * FROM teacher order by Tno";
        ArrayList<Teacher>teachers = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst= pstmt.executeQuery()){
            while(rst.next()){
                Teacher teacher = new Teacher();
                teacher.setTno(rst.getString("Tno"));
                teacher.setTname(rst.getString("Tname"));
                teacher.setProf(rst.getString("Prof"));
                teacher.setIntroduction(rst.getString("Introduction"));
                teachers.add(teacher);
            }
            return teachers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteteacher(Teacher teacher) throws DaoException {
        String sql = "DELETE FROM teacher where Tno =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,teacher.getTno());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateteacher(Teacher teacher,String oldTno) throws DaoException {
        String sql = "UPDATE teacher SET Tno=?,Tname=?,Prof=?,introduction=? where Tno =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,teacher.getTno());
            pstmt.setString(2,teacher.getTname());
            pstmt.setString(3,teacher.getProf());
            pstmt.setString(4,teacher.getIntroduction());
            pstmt.setString(5,oldTno);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Student> quarystudent(int cno) throws DaoException {
        String sql = "SELECT sc.sno,student.sname FROM sc,student WHERE sc.sno=student.sno and cno=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cno);
            ArrayList<Student> students = new ArrayList<>();
            System.out.println("运行了2");
            try (ResultSet rst = pstmt.executeQuery()) {
                while(rst.next()) {
                    System.out.println("运行了3");
                    Student student = new Student();
                    student.setSno(rst.getString("sno"));
                    student.setName(rst.getString("sname"));
                    students.add(student);
                }
                    return students;
                }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addstudent(String sno,int cno) throws DaoException {
        String sql = "INSERT INTO sc VALUES(?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1,sno);
            pstmt.setInt(2,cno);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletestudent(String sno,int cno) throws DaoException {
        String sql = "DELETE FROM sc where Sno =? and Cno=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,sno);
            pstmt.setInt(2,cno);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
