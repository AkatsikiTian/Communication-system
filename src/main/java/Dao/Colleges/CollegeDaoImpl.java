package Dao.Colleges;

import Dao.DaoException;
import javabean.College;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CollegeDaoImpl implements CollegeDao {
        @Override
        public boolean addcollege (College college) throws DaoException {
            String sql = "INSERT INTO college VALUES(null,?)";
            String sql1 = "alter table college auto_increment = 1";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                 PreparedStatement pstmt = conn.prepareStatement(sql);) {
                System.out.println(college.getName());
                pstmt.setString(1, college.getName());
                pstmt1.executeUpdate();
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        public College findBycollegeNum ( int num) throws DaoException {
            String sql = "SELECT * FROM college WHERE number =?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, num);
                College college = new College();
                try (ResultSet rst = pstmt.executeQuery()) {
                    if (rst.next()) {
                        college.setName(rst.getString("name"));
                        college.setNumber(rst.getInt("number"));
                        return college;
                    } else {
                        return null;
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public boolean updatecollege (College college, String oldname) throws DaoException {
            String sql = "UPDATE college SET name=? where name =?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, college.getName());
                pstmt.setString(2, oldname);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        public ArrayList<College> findAllcollege () throws DaoException {
            String sql = "SELECT * FROM college order by number";
            ArrayList<College> colleges = new ArrayList<>();
            try (
                    Connection conn = getConnection();
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    ResultSet rst = pstmt.executeQuery()) {
                while (rst.next()) {
                    College college = new College();
                    college.setNumber(rst.getInt("number"));
                    college.setName(rst.getString("name"));
                    System.out.println(rst.getInt("number"));
                    System.out.println(rst.getString("name"));
                    colleges.add(college);
                }
                return colleges;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public boolean deletecollege (College college) throws DaoException {
            String sql = "DELETE FROM college where name =?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, college.getName());
                pstmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

