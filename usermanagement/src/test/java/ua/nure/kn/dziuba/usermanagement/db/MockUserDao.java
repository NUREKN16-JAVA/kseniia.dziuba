package ua.nure.kn.dziuba.usermanagement.db;

import ua.nure.kn.dziuba.usermanagement.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MockUserDao implements UserDao {
    long id = 0;
    Map users = new HashMap();

    @Override
    public User create(User user) throws DatabaseException {
        Long currentId = new Long(++id);
        user.setId(currentId);
        users.put(currentId, user);
        return user;
    }

    @Override
    public void update(User user) throws DatabaseException {
        users.remove(user.getId());
        users.put(user.getId(), user);
    }

    @Override
    public void delete(User user) throws DatabaseException {
        users.remove(user.getId());
    }

    @Override
    public User find(Long id) throws DatabaseException {
        return (User) users.get(id);
    }

    @Override
    public Collection findAll() throws DatabaseException {
        return users.values();
    }

    @Override
    public void setConnectionFactory(ConnectionFactory connectionFactory) {

    }
}
