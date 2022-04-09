package Dao.Accout;

import Dao.Accout.AccountDAO;
import Dao.DaoException;
import javabean.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDAO {
    public boolean addaccount(Account account) throws DaoException {
        String sql = "INSERT INTO account VALUES(?,?,?,?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){
            System.out.println(account.getUsername());
            pstmt.setString(1,account.getUsername());
            pstmt.setString(2,account.getPassword());
            pstmt.setString(3,account.getPosition());
            pstmt.setString(4,account.getName());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public Account findByUsername(String username,String password,String position) throws DaoException{
        String sql = "SELECT * FROM account WHERE username=? AND password=? AND position=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,position);
            Account account = new Account();
            try (ResultSet rst= pstmt.executeQuery()){
                if (rst.next()){
                    System.out.println(rst.getString("username"));
                    System.out.println(rst.getString("password"));
                    System.out.println(rst.getString("position"));
                    account.setName(rst.getString("name"));
                    account.setUsername(rst.getString("username"));
                    account.setPosition(rst.getString("position"));
                    account.setPassword(rst.getString("password"));
                    return account;
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
    public boolean updateaccount(Account account) throws DaoException {
        String sql = "UPDATE account SET password=? where username=?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){
            System.out.println(account.getUsername());
            pstmt.setString(1,account.getPassword());
            pstmt.setString(2,account.getUsername());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteaccount(Account account) throws DaoException {
        String sql = "DELETE FROM account where username =?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,account.getUsername());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
