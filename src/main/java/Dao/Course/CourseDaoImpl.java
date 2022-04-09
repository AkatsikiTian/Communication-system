package Dao.Course;

import Dao.DaoException;
import javabean.Course;
import javabean.SC;
import javabean.TC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDaoImpl implements CourseDao{
    @Override
    public boolean addCourse(Course course) throws DaoException {
        String sql = "INSERT INTO course VALUES(null,?,?,?,?)";
        String sql1 = "alter table course auto_increment = 1";
        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql1);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, course.getCname());
            pstmt.setInt(2,course.getCollege());
            pstmt.setString(3,course.getContent());
            pstmt.setString(4,course.getTno());
            pstmt1.executeUpdate();
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<TC> findCourse(String tno) throws DaoException {
        String sql = "SELECT Cno,Cname,college,content,course.tno,Tname,name FROM course,teacher,college where course.tno=? and teacher.Tno=course.tno and college=college.number order by Cno";
        ArrayList<TC> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tno);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    TC course = new TC();
                    course.setCno(rst.getInt("Cno"));
                    course.setCname(rst.getString("Cname"));
                    course.setCollege(rst.getInt("college"));
                    course.setContent(rst.getString("content"));
                    course.setTno(rst.getString("tno"));
                    course.setTname(rst.getString("Tname"));
                    course.setName(rst.getString("name"));
                    courses.add(course);
                }
                return courses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public ArrayList<TC> findAllCourse() throws DaoException {
        String sql = "SELECT Cno,Cname,college,content,course.tno,Tname,name FROM course,teacher,college where teacher.Tno=course.tno and college=college.number order by Cno";
        ArrayList<TC> courses = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()) {
            while (rst.next()) {
                TC course = new TC();
                course.setCno(rst.getInt("Cno"));
                course.setCname(rst.getString("Cname"));
                course.setCollege(rst.getInt("college"));
                course.setContent(rst.getString("content"));
                course.setTno(rst.getString("tno"));
                course.setTname(rst.getString("Tname"));
                course.setName(rst.getString("name"));
                courses.add(course);
            }
            return courses;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deletecourse(Course course) throws DaoException {
        String sql = "DELETE FROM course where Cno =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, course.getCno());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatecourse(Course course) throws DaoException {
        String sql = "UPDATE course SET Cname=?,college=?,content=?,tno=? where Cno =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, course.getCname());
            pstmt.setInt(2, course.getCollege());
            pstmt.setString(3, course.getContent());
            pstmt.setString(4, course.getTno());
            pstmt.setInt(5, course.getCno());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<TC> findStudentCourse(String sno) throws DaoException {
        String sql = "SELECT course.Cno,Cname,college,content,course.tno,Tname,name FROM course,teacher,college,sc where sc.Sno=? and teacher.Tno=course.tno and college=college.number and sc.Cno=course.Cno order by Cno";
        ArrayList<TC> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sno);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    TC course = new TC();
                    course.setCno(rst.getInt("Cno"));
                    course.setCname(rst.getString("Cname"));
                    course.setCollege(rst.getInt("college"));
                    course.setContent(rst.getString("content"));
                    course.setTno(rst.getString("tno"));
                    course.setTname(rst.getString("Tname"));
                    course.setName(rst.getString("name"));
                    courses.add(course);
                }
                return courses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<TC> findStudentCourse1(String sno, String tno) throws DaoException {
        String sql = "SELECT course.Cno,Cname,college,content,course.tno,Tname,name FROM course,teacher,college,sc where sc.Sno=? and teacher.Tno=course.tno and college=college.number and sc.Cno=course.Cno and teacher.tno=? order by Cno";
        ArrayList<TC> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sno);
            System.out.println(sno+" "+tno);
            pstmt.setString(2, tno);
            System.out.println("执行中2");
            try (ResultSet rst = pstmt.executeQuery()) {
                System.out.println("执行中3");
                while (rst.next()) {
                    TC course = new TC();
                    course.setCno(rst.getInt("Cno"));
                    course.setCname(rst.getString("Cname"));
                    course.setCollege(rst.getInt("college"));
                    course.setContent(rst.getString("content"));
                    course.setTno(rst.getString("tno"));
                    course.setTname(rst.getString("Tname"));
                    course.setName(rst.getString("name"));
                    courses.add(course);
                    System.out.println(course.getCno()+course.getCollege());
                }
                return courses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<TC> findStudentCourse2(String sno, String name) throws DaoException {
        String sql = "SELECT course.Cno,Cname,college,content,course.tno,Tname,college.name FROM course,teacher,college,sc where sc.Sno=? and teacher.Tno=course.tno and course.college=college.number and sc.Cno=course.Cno and college.name=? order by Cno";
        ArrayList<TC> courses = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sno);
            pstmt.setString(2, name);
            System.out.println("执行中1");
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    TC course = new TC();
                    course.setCno(rst.getInt("Cno"));
                    course.setCname(rst.getString("Cname"));
                    course.setCollege(rst.getInt("college"));
                    course.setContent(rst.getString("content"));
                    course.setTno(rst.getString("tno"));
                    course.setTname(rst.getString("Tname"));
                    course.setName(rst.getString("name"));
                    courses.add(course);
                }
                return courses;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
