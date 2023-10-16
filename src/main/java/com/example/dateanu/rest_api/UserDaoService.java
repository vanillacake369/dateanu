// REST API using SPRING BOOT

package com.example.dateanu.rest_api;

import com.example.dateanu.rest_api.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    public static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(User.builder()
                .id(1)
                .name("Alice")
                .joinDate(new Date())
                .password("asdf")
                .ssn("97120-120")
                .build()
        );
        users.add(User.builder()
                .id(2)
                .name("Eliza")
                .joinDate(new Date())
                .password("eliqiqw")
                .build()
        );
        users.add(User.builder()
                .id(3)
                .name("Aranud")
                .joinDate(new Date())
                .password("meiqpa")
                .build()
        );
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if(user.getId() == null){

        }
        users.add(user);
        return user;
    }

    public User findOne(int id){
        for (User user:users) {
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();

        while(iterator.hasNext()){
            User user = iterator.next();

            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }

        return null;
    }

    // PUT ⇒ Create if not existed, or Update Entire Resource
    public User replace(Integer id,User requestUser){
        boolean isUserExisted = false;

        for (int i = 0; i < users.size() ; i++) {
            User u = users.get(i);
            if(u.getId() == id){
                requestUser.setId(id);
                users.set(i, requestUser);
                isUserExisted = true;
            }
        }

        // create
        if(isUserExisted == false){
            this.save(requestUser);
        }

        return requestUser;
    }

    // PATCH ⇒ Update Part of Resource
    public User update(Integer id,User requestUser){
        // for every user
        for (int i = 0; i < users.size() ; i++) {
            User u = users.get(i);
            // if there is corresponding user, update by request payload
            // NOTE : Size of request payload != Size of Entity
            if(u.getId() == id){
                if(u.getName() != requestUser.getName() && requestUser.getName() != null){
                    u.setName(requestUser.getName());
                }
                if(u.getJoinDate() != requestUser.getJoinDate() && requestUser.getJoinDate() != null){
                    u.setJoinDate(requestUser.getJoinDate());
                }
                users.set(i,u);
                return u;
            }
        }
        return null;
    }
}
