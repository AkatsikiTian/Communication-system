package Dao.Question;

import Dao.BaseDao;
import Dao.DaoException;
import javabean.Question;
import javabean.TC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionDaoImpl implements QuestionDao {
    public ArrayList<Question> findallquestion()throws DaoException{
        String sql = "SELECT id,time,question.content,question.sno,question.cno,title,cname,sname FROM course,question,student where course.cno=question.cno and question.sno=student.sno order by time";
        ArrayList<Question> questions = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
                    question.setSname(rst.getString("sname"));
                    questions.add(question);
                }
                return questions;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean addquestion(Question question) throws DaoException {
        String sql = "INSERT INTO question VALUES(null,?,?,?,?,?,0)";
        String sql1 = "alter table question auto_increment = 1";
        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql1);
             PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1,question.getTime());
            pstmt.setString(2,question.getContent());
            pstmt.setString(3,question.getSno());
            pstmt.setInt(4,question.getCno());
            pstmt.setString(5,question.getTitle());
            pstmt1.executeUpdate();
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Question> findquestion(int cno)throws DaoException{
        String sql = "SELECT id,time,question.content,question.sno,question.cno,title,cname,sname,state FROM course,question,student where course.cno=question.cno and question.sno=student.sno and question.cno=? order by time";
        ArrayList<Question> questions = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1,cno);
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
                    question.setSname(rst.getString("sname"));
                    question.setState(rst.getInt("state"));
                    questions.add(question);
                }
                return questions;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Question> findquestiontoanswer(String tno)throws DaoException{
        String sql = "SELECT id,time,question.content,question.sno,question.cno,title,cname,sname,state FROM course,question,student where course.cno=question.cno and question.sno=student.sno and course.tno=? and question.state=0 order by time";
        ArrayList<Question> questions = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,tno);
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
                    question.setSname(rst.getString("sname"));
                    question.setState(rst.getInt("state"));
                    questions.add(question);
                }
                return questions;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Question> findquestiontoanswer1(String tno)throws DaoException{
        String sql = "SELECT id,time,question.content,question.sno,question.cno,title,cname,sname,state FROM course,question,student where course.cno=question.cno and question.sno=student.sno and course.tno=? and question.state=1 order by time";
        ArrayList<Question> questions = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,tno);
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
                    question.setSname(rst.getString("sname"));
                    question.setState(rst.getInt("state"));
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
    public ArrayList<Question> findquestiontoanswer2(String sno) throws DaoException {
        String sql = "SELECT question.id,question.time,question.content,question.sno,question.cno,title,cname,sname,question.state FROM course,question,student,answer where course.cno=question.cno and question.sno=student.sno and question.sno=? and question.state=1 and answer.questionid=question.id and answer.state=0  order by time";
        ArrayList<Question> questions = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,sno);
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
                    question.setSname(rst.getString("sname"));
                    question.setState(rst.getInt("state"));
                    questions.add(question);
                }
                return questions;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
