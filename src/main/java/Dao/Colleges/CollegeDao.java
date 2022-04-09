package Dao.Colleges;

import Dao.BaseDao;
import Dao.DaoException;
import javabean.College;

import java.util.ArrayList;

public interface CollegeDao extends BaseDao {
    public boolean addcollege(College college)throws DaoException;
    public College findBycollegeNum(int num)throws DaoException;
    public boolean updatecollege(College college,String oldname)throws DaoException;
    public ArrayList<College> findAllcollege()throws DaoException;
    public boolean deletecollege(College college)throws DaoException;
}
