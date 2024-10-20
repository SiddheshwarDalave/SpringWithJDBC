package sidd.learning.SpringBootJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sidd.learning.SpringBootJdbc.dao.UserDao;
import sidd.learning.SpringBootJdbc.entity.User;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		User user= new User("Ajay Dalave","ajdalave@gmail.com","male","Mohol");
		boolean state=userDao.insertUser(user);
		if(state){
			System.out.println("User Created sucessfulluy");
		}else{
			System.out.println("Issue");
		}

		User user1= new User("Siddheshwar Dalave","siddd@gmail.com","male","Pune");
		boolean state1=userDao.updateUser(user1);
		if(state1){
			System.out.println("User Updated successfully");
		}else{
			System.out.println("Issue");
		}
		User user2= new User("Siddheshwar Dalave","siddd@gmail.com","male","Pune");
		boolean state2=userDao.deleteUser(user2);
		if(state1){
			System.out.println("User Deleted successfully");
		}else{
			System.out.println("Issue");
		}

	}
}
