package Dao.Answer;

import Dao.DaoException;
import javabean.Answer;
import javabean.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AnswerDaoImpl implements AnswerDao{
    public ArrayList<Answer> findallanswer()throws DaoException {
        String sql = "SELECT id,time,answer.content,questionid,answer.tno,answer.cno,cname from answer,course where answer.cno=course.cno order by time";
        ArrayList<Answer> answers = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Answer answer = new Answer();
                    answer.setId(rst.getInt("id"));
                    answer.setTime(rst.getString("time"));
                    answer.setContent(rst.getString("content"));
                    answer.setQuestionid(rst.getInt("questionid"));
                    answer.setTno(rst.getString("tno"));
                    answer.setCno(rst.getInt("cno"));
                    answer.setCname(rst.getString("cname"));
                    answers.add(answer);
                }
                return answers;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Answer> findmyanswer(String tno) throws DaoException {
        String sql = "SELECT id,time,answer.content,questionid,answer.tno,answer.cno,cname from answer,course where answer.tno=? and answer.cno=course.cno order by time";
        ArrayList<Answer> answers = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,tno);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Answer answer = new Answer();
                    answer.setId(rst.getInt("id"));
                    answer.setTime(rst.getString("time"));
                    answer.setContent(rst.getString("content"));
                    answer.setQuestionid(rst.getInt("questionid"));
                    answer.setTno(rst.getString("tno"));
                    answer.setCno(rst.getInt("cno"));
                    answer.setCname(rst.getString("cname"));
                    answers.add(answer);
                }
                return answers;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Answer> findanswer(int cno) throws DaoException {
        String sql = "SELECT id,time,answer.content,questionid,answer.tno,answer.cno,cname from answer,course where answer.cno=? and answer.cno=course.cno order by time";
        ArrayList<Answer> answers = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,cno);
            try (ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    Answer answer = new Answer();
                    answer.setId(rst.getInt("id"));
                    answer.setTime(rst.getString("time"));
                    answer.setContent(rst.getString("content"));
                    answer.setQuestionid(rst.getInt("questionid"));
                    answer.setTno(rst.getString("tno"));
                    answer.setCno(rst.getInt("cno"));
                    answer.setCname(rst.getString("cname"));
                    answers.add(answer);
                }
                return answers;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addanswer(Answer answer) throws DaoException {
        String sql = "INSERT INTO answer VALUES(null,?,?,?,?,?,0)";
        String sql1 = "alter table answer auto_increment = 1";
        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(sql1);
             PreparedStatement pstmt = conn.prepareStatement(sql);){
            pstmt.setString(1,answer.getTime());
            pstmt.setString(2,answer.getContent());
            pstmt.setString(3,answer.getTno());
            pstmt.setInt(4,answer.getQuestionid());
            pstmt.setInt(5,answer.getCno());
            pstmt1.executeUpdate();
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateanswer(int id,String content,String time) throws DaoException {
        String sql = "UPDATE answer SET content=?,time=? where id =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, content);
            pstmt.setString(2, time);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Answer quaryanswer(int questionid) throws DaoException {
        String sql = "SELECT id,time,answer.content,questionid,answer.tno,answer.cno,cname from answer,course where answer.questionid=? and answer.cno=course.cno order by time";
        String sql1 = "UPDATE  answer SET state=1 WHERE questionid=?";
        Answer answer = new Answer();
        try (
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                PreparedStatement pstmt1 = conn.prepareStatement(sql1)){
            pstmt.setInt(1,questionid);
            pstmt1.setInt(1,questionid);
            pstmt1.executeUpdate();
            try (ResultSet rst = pstmt.executeQuery()) {
                if(rst.next()) {
                    answer.setId(rst.getInt("id"));
                    answer.setTime(rst.getString("time"));
                    answer.setContent(rst.getString("content"));
                    answer.setQuestionid(rst.getInt("questionid"));
                    answer.setTno(rst.getString("tno"));
                    answer.setCno(rst.getInt("cno"));
                    answer.setCname(rst.getString("cname"));
                    return answer;
                }else{
                    return null;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteanswer(int id) throws DaoException {
        String sql = "DELETE FROM answer where id =?";
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
