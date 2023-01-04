package springboot.hibernatemvcboot.web.service;






import springboot.hibernatemvcboot.web.model.User;

import java.util.List;

public interface UserService {
    public void save(User user);
    public void delete(User user);
    public void update(User user);
    public List<User> listAllUsers();
}
