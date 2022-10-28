package org.Online_Shop;

import org.Online_Shop.dao.UserDao;
import org.Online_Shop.dao.impl.MySqlJdbcUserDao;
import org.Online_Shop.dto.UserDto;
import org.Online_Shop.menu.Impl.MainMenu;
import org.Online_Shop.menu.Impl.SignInMenu;
import org.Online_Shop.menu.Menu;

import java.math.BigDecimal;

public class Main {

    public static final String EXIT_COMMAND = "exit";

        public static void main(String[] args) {
//            Menu mainMenu = new MainMenu();
//            mainMenu.start();
//            System.out.println("Nothing happens !");

            UserDao userDao = new MySqlJdbcUserDao();
            UserDto user = userDao.getUserById(42);
//
//            System.out.println(user);
          // System.out.println(userDao.getUserByEmail(user.getEmail()));

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
//            SignInMenu signInMenu = new SignInMenu();
//            signInMenu.printMenuHeader();

        }
    }
