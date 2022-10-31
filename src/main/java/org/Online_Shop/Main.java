package org.Online_Shop;

import org.Online_Shop.dao.UserDao;
import org.Online_Shop.dao.impl.MySqlJdbcUserDao;
import org.Online_Shop.dto.UserDto;

public class Main {

    public static final String EXIT_COMMAND = "exit";

        public static void main(String[] args) {
//            Menu mainMenu = new MainMenu();
//            mainMenu.start();
//            System.out.println("Nothing happens !");

            UserDao userDao = new MySqlJdbcUserDao();
            UserDto user = userDao.getUserById(42);
//            System.out.println(user);
//            System.out.println(userDao.getUserByEmail(user.getEmail()));
//
//            UserDto newUser = new UserDto();
//            newUser.setFirstName("Evheniy");
//            newUser.setLastName("Kachanov");
//            newUser.setEmail("e.kachanov@email.com");
//            newUser.setMoney(BigDecimal.valueOf(1000));
//
//            userDao.saveUser(newUser);

           // System.out.println(userDao.getUserByEmail("e.kachanov@email.com"));
            System.out.println(user.getEmail());
            System.out.println(user.getFirstName());

            UserDao userDao1 = new MySqlJdbcUserDao();
            UserDto user1 = userDao1.getUserByEmail("georgemalelis@yahoo.gr");


//            UserDto newUser1 = new UserDto();
//            newUser1.setFirstName("George");
//            newUser1.setLastName("Malelis");
//            newUser1.setEmail("georgemalelis@yahoo.gr");
//            newUser1.setMoney(BigDecimal.valueOf(3000));
//            userDao1.saveUser(newUser1);
//            SignInMenu signInMenu = new SignInMenu();
//            signInMenu.printMenuHeader();

            System.out.println(user1.getId());
            System.out.println(user1.getLastName());

        }
    }
