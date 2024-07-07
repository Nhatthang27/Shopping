/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.model.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import sample.utils.DBContext;

/**
 *
 * @author Nhatthang
 */
public class UserDAO implements Serializable {

    private ServletContext sc = null;

    public UserDAO(ServletContext sc) {
        this.sc = sc;
    }

    public boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
        //1. Create SQL String
        String sql = "SELECT [username]\n"
                + "FROM [dbo].[User]\n"
                + "WHERE [username] = ? AND [password] = ?";
        //2. Connect DB and PreparedStatement
        try ( Connection con = DBContext.getConnection(sc);  PreparedStatement ps = con.prepareStatement(sql);) {

            //3. Assign PreparedStatement param
            ps.setString(1, username);
            ps.setString(2, password);
            //4. Execute Query
            try ( ResultSet rs = ps.executeQuery()) {
                //5. Process Result
                if (rs.next()) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<UserDTO> searchByFullName(String searchValue) throws ClassNotFoundException, SQLException {
        String sql = "SELECT [userId]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[firstName]\n"
                + "      ,[lastName]\n"
                + "      ,[phone]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[User]\n"
                + "  WHERE firstName LIKE ? OR lastName LIKE ?";
        List<UserDTO> userList = null;
        try ( Connection con = DBContext.getConnection(sc);  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, "%" + searchValue + "%");
            ps.setString(2, "%" + searchValue + "%");
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (userList == null) {
                        userList = new ArrayList<>();
                    }
                    int userId = rs.getInt("userId");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String phone = rs.getString("phone");
                    boolean role = rs.getBoolean("role");
                    userList.add(new UserDTO(userId, username, password, firstName, lastName, phone, role));
                }
            }
        }
        return userList;
    }

    public int delete(int userId) throws ClassNotFoundException, SQLException {
        String sql = " DELETE FROM [dbo].[User]\n"
                + " WHERE userId = ?";
        int result = 0;
        try ( Connection con = DBContext.getConnection(sc);  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, userId);
            result = ps.executeUpdate();
        }
        return result;
    }

    public int insert(UserDTO newUser) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[firstName])\n"
                + "     VALUES\n"
                + "           (?, ?, ?)";
        int result = 0;
        try ( Connection con = DBContext.getConnection(sc);  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, newUser.getUsername());
            ps.setString(2, newUser.getPassword());
            ps.setString(3, newUser.getFirstName());
            result = ps.executeUpdate();
        }
        return result;
    }
}
