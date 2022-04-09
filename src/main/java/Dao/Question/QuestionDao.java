package Dao.Question;

import Dao.BaseDao;
import Dao.DaoException;
import javabean.Question;

import java.util.ArrayList;

public interface QuestionDao extends BaseDao {
    public boolean addquestion(Question question) throws DaoException;
    public ArrayList<Question> findallquestion()throws DaoException;
    public ArrayList<Question> findquestion(int cno)throws DaoException;
    public ArrayList<Question> findquestiontoanswer(String tno)throws DaoException;
    public ArrayList<Question> findquestiontoanswer1(String tno)throws DaoException;
    public ArrayList<Question> findquestiontoanswer2(String sno)throws DaoException;
}
