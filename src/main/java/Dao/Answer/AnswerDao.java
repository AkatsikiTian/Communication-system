package Dao.Answer;

import Dao.BaseDao;
import Dao.DaoException;
import javabean.Answer;
import javabean.Question;

import java.util.ArrayList;

public interface AnswerDao extends BaseDao {
    public boolean addanswer(Answer answer) throws DaoException;
    public ArrayList<Answer> findallanswer()throws DaoException;
    public ArrayList<Answer> findmyanswer(String tno)throws DaoException;
    public ArrayList<Answer> findanswer(int cno)throws DaoException;
    public boolean deleteanswer(int id)throws DaoException;
    public boolean updateanswer(int id,String content,String time)throws DaoException;
    public Answer quaryanswer(int questionid)throws DaoException;
}
