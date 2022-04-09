package Dao.Teacher;

import Dao.BaseDao;
import Dao.DaoException;
import javabean.College;
import javabean.Student;
import javabean.Teacher;

import java.util.ArrayList;

public interface TeacherDao extends BaseDao {
    public boolean addteacher(Teacher teacher)throws DaoException;
    public ArrayList<Teacher> findAllteacher()throws DaoException;
    public boolean deleteteacher(Teacher teacher)throws DaoException;
    public boolean updateteacher(Teacher teacher,String oldTno)throws DaoException;
    public ArrayList<Student> quarystudent(int cno)throws DaoException;
    public boolean addstudent(String sno,int cno)throws DaoException;
    public boolean deletestudent(String sno,int cno)throws DaoException;
}
