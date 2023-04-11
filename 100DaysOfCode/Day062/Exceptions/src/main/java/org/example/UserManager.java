package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<User>();

    public void addUser(User user) throws AlreadyExistsException {
        if (users.contains(user)) throw new AlreadyExistsException("User " + user.getName());
        users.add(user);
    }

    public void removeUser(User user) throws NotFoundException {
        if (!users.contains(user)) throw new NotFoundException("User " + user.getName());
        users.remove(user);
    }

    public Iterator<User> listUsers() {
        return users.iterator();
    }
}
