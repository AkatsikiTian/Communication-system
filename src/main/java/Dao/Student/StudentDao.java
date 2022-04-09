package Dao.Student;

import Dao.BaseDao;
import Dao.DaoException;
import javabean.Question;
import javabean.Student;

import java.util.ArrayList;

public interface StudentDao extends BaseDao {
    public boolean addstudent(Student student)throws DaoException;
    public boolean addstudentcourse(String sno,int cno)throws DaoException;
    public ArrayList<Question> findmyquestion(String sno)throws DaoException;
    public boolean updatequestion(String title,String content,String time,int id)throws DaoException;
    public boolean deletequestion(int id)throws DaoException;
}
