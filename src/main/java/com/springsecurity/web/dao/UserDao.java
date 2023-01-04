package springboot.hibernatemvcboot.web.dao;






import springboot.hibernatemvcboot.web.model.User;

import java.util.List;

public interface UserDao {
    public void save(User user);
    public void delete(User user);
    public void update(User user);
    public List<User> listAllUsers();
    public User getByUsername(String username);
}
