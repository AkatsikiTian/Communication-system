package Dao.Course;

import Dao.BaseDao;
import Dao.DaoException;
import javabean.College;
import javabean.Course;
import javabean.SC;
import javabean.TC;

import java.util.ArrayList;

public interface CourseDao extends BaseDao {
    public boolean addCourse(Course course)throws DaoException;
    public ArrayList<TC> findCourse(String tno)throws DaoException;
    public ArrayList<TC> findAllCourse()throws DaoException;
    public boolean deletecourse(Course course)throws DaoException;
    public boolean updatecourse(Course course)throws DaoException;
    public ArrayList<TC> findStudentCourse(String sno)throws DaoException;
    public ArrayList<TC> findStudentCourse1(String sno,String tno)throws DaoException;
    public ArrayList<TC> findStudentCourse2(String sno,String name)throws DaoException;
}
