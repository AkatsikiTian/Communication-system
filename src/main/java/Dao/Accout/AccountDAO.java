package Dao.Accout;

import Dao.BaseDao;
import Dao.DaoException;
import javabean.Account;
import javabean.College;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface AccountDAO extends BaseDao {
    public boolean addaccount(Account account)throws DaoException;
    public Account findByUsername(String username,String password,String position)throws DaoException;
    public boolean updateaccount(Account account)throws DaoException;
    public boolean deleteaccount(Account account)throws DaoException;
}
