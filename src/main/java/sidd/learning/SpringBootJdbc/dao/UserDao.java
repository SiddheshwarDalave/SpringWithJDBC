package sidd.learning.SpringBootJdbc.dao;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sidd.learning.SpringBootJdbc.entity.User;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertUser(User user){
        boolean status=false;
        try{
            String INSERT_USER_QUERY="INSERT INTO users (name,email, gender, city) VALUES (?,?,?,?)";
            int count=jdbcTemplate.update(INSERT_USER_QUERY,user.getName(), user.getEmail(),user.getGender(),user.getCity());
            if(count>0){
                status=true;
            }
        }catch (Exception e){
            status=false;
            e.printStackTrace();
        }
        return status;
    }
    public boolean updateUser(User user){
        boolean status=false;
        try{
            String Update_USER_QUERY="UPDATE users SET name=?,gender=?,city=? where email=?";
            int count=jdbcTemplate.update(Update_USER_QUERY,user.getName(),user.getGender(),user.getCity(), user.getEmail());
            if(count>0){
                status=true;
            }
        }catch (Exception e){
            status=false;
            e.printStackTrace();
        }
        return status;
    }
    public boolean deleteUser(User user){
        boolean status=false;
        try{
            String Update_USER_QUERY="DELETE from users where email=?";
            int count=jdbcTemplate.update(Update_USER_QUERY,user.getEmail());
            if(count>0){
                status=true;
            }
        }catch (Exception e){
            status=false;
            e.printStackTrace();
        }
        return status;
    }
}
