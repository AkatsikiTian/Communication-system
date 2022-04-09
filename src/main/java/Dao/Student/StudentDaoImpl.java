package Dao.Student;

import Dao.DaoException;
import javabean.Question;
import javabean.Student;
import javabean.TC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao{
    @Override
    public boolean addstudent(Student student) throws DaoException {
        String sql = "INSERT INTO student VALUES(?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1,student.getSno());
            pstmt.setString(2,student.getName());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addstudentcourse(String sno, int cno)throws DaoException {
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
    public ArrayList<Question> findmyquestion(String sno) throws DaoException {
        String sql = "SELECT id,time,question.content,sno,question.cno,title,cname FROM course,question where course.cno=question.cno and sno=? order by time";
        ArrayList<Question> questions = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, sno);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Question question = new Question();
                    question.setId(rst.getInt("id"));
                    question.setCno(rst.getInt("cno"));
                    question.setTime(rst.getString("time"));
                    question.setContent(rst.getString("content"));
                    question.setSno(rst.getString("sno"));
                    question.setTitle(rst.getString("title"));
                    question.setCname(rst.getString("cname"));
                    questions.add(question);
                }
                return questions;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updatequestion(String title, String content,String time, int id) throws DaoException {
        String sql = "UPDATE question SET title=?,content=?,time=? where id =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, time);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletequestion(int id) throws DaoException {
        String sql = "DELETE FROM question where id =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
