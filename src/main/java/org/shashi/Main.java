package org.shashi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();
            //        This is used to create the session object or produce the session object
            //        this is heavy wait it is not create again and again
        Session session = sessionFactory.openSession();
               // This is used for CRUD operation
                // It provides the all method for CRUD Operation
        Transaction transaction = session.beginTransaction();

                // This is use for transaction provide that is all operation is complete ya rollback
                // By default Hibernate support the transaction.


        // these three are required for use in hibernate.


        System.out.println("\n\tHello welcome to My First Hibernate CRUD Operations.......");

        while (true)
        {
            System.out.println("Press 1 Create User \t Press 2 Read User");
            System.out.println("Press 3 Update User \t Press 4 Delete User");
            System.out.println("Press 0 EXIT");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice:\t");
            int choice = scanner.nextInt();
            if (choice == 0)
            {
                System.out.print("\n Thanks for using our CRUD application \n");
                break;
            }
            if (choice == 1) {
                System.out.print("\n================Welcome in Create Operations==================\n");
                try {
                    User user = new User();
                    System.out.print("Enter your name:\t");
                    user.setName(scanner.next());
                    System.out.print("Enter your Email:\t");
                    user.setEmail(scanner.next());
                    System.out.print("Enter your Password:\t");
                    user.setPassword(scanner.next());
                    System.out.print("Enter your Gender:\t");
                    user.setGender(scanner.next());
                    System.out.print("Enter your City:\t");
                    user.setCity(scanner.next());
                    session.save(user);
                    transaction.commit();
                    System.out.println("User Create successfully..........");
                } catch (Exception e) {
                    transaction.rollback();
                    e.printStackTrace();
                    System.out.println("User save failed.........");
                }
            } else if (choice == 2)
            {
                System.out.print("\n===========Welcome In Read Operation====================\n");
                while (true)
                {
                    System.out.println("Press 1 Read One By One \t Press 2 Read All Users");
                    System.out.println("Press 0 EXIT");
                    Scanner sc = new Scanner(System.in);
                    System.out.print("Enter your choice:\t");
                    int ab = scanner.nextInt();
                    if (ab == 0) {
                        System.out.println("\t\tThank you for using our service ");
                        break;
                    }
                    if (ab == 1) {
                        try {
                            System.out.print("Enter your id: ");
                            int id = scanner.nextInt();
                            User obj = session.get(User.class, id);
                            if (obj != null) {
                                System.out.println(obj.getId());
                                System.out.println(obj.getName());
                                System.out.println(obj.getEmail());
                                System.out.println(obj.getPassword());
                                System.out.println(obj.getGender());
                                System.out.println(obj.getCity());
                            } else {
                                System.out.println("User not Found");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();

                        }
                    } else if (ab == 2) {
                        try
                        {
                            List<User> users = session.createQuery("FROM User", User.class).list();
                            if (users != null && !users.isEmpty()) {
                                System.out.println("\n================= All Users List =================");
                                for (User obj : users) {
                                    System.out.println("ID: " + obj.getId());
                                    System.out.println("Name: " + obj.getName());
                                    System.out.println("Email: " + obj.getEmail());
                                    System.out.println("Password: " + obj.getPassword());
                                    System.out.println("Gender: " + obj.getGender());
                                    System.out.println("City: " + obj.getCity());
                                    System.out.println("--------------------------------------------------");
                                }
                            } else
                            {
                                System.out.println("No users found in the database.");
                            }
                        }catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                    }
                }
            } else if (choice == 3) {
                try {
                    System.out.print("\n===============Welcome In Update Operation===============\n");
                    while (true) {
                        System.out.println("Press 1 Name Update   \t Press 2 Email Update \t Press 3 Password Update ");
                        System.out.println("Press 4 Gender Update \t Press 5 City Update  \t Press 0 EXIT");
                        Scanner sca = new Scanner(System.in);
                        System.out.print("Enter your choice:\t");
                        int ch = scanner.nextInt();
                        if (ch == 0) {
                            System.out.println("\t\tThank you for using our update service ");
                            break;
                        }
                        if (ch == 1) {
                            System.out.print("Enter your id: ");
                            int id = scanner.nextInt();
                            User obj = session.get(User.class, id);
                            System.out.print("Enter your name:\t");
                            String name = scanner.next();
                            obj.setName(name);
                            session.saveOrUpdate(obj);
                            transaction.commit();
                            System.out.println("User Name Update successfully..........");
                        } else if (ch == 2) {
                            System.out.print("Enter your id: ");
                            int id = scanner.nextInt();
                            User obj = session.get(User.class, id);
                            System.out.print("Enter your Email:\t");
                            String email = scanner.next();
                            obj.setEmail(email);
                            session.saveOrUpdate(obj);
                            transaction.commit();
                            System.out.println("User Email Update successfully..........");
                        } else if (ch == 3) {
                            System.out.print("Enter your id: ");
                            int id = scanner.nextInt();
                            User obj = session.get(User.class, id);
                            System.out.print("Enter your Password:\t");
                            String password = scanner.next();
                            obj.setPassword(password);
                            session.saveOrUpdate(obj);
                            transaction.commit();
                            System.out.println("User Password Update successfully..........");
                        } else if (ch == 4) {
                            System.out.print("Enter your id: ");
                            int id = scanner.nextInt();
                            User obj = session.get(User.class, id);
                            System.out.print("Enter your Gender:\t");
                            String gender = scanner.next();
                            obj.setGender(gender);
                            session.saveOrUpdate(obj);
                            transaction.commit();
                            System.out.println("User Gender Update successfully..........");
                        } else if (ch == 5) {
                            System.out.print("Enter your id: ");
                            int id = scanner.nextInt();
                            User obj = session.get(User.class, id);
                            System.out.print("Enter your City:\t");
                            String city = scanner.next();
                            obj.setCity(city);
                            session.saveOrUpdate(obj);
                            transaction.commit();
                            System.out.println("User City Update successfully..........");
                        } else {
                            System.out.println("Invalid choice");
                        }
                    }
                } catch (Exception e) {
                    transaction.rollback();
                    e.printStackTrace();
                    System.out.println("Uer Not Updated Sucessfully...");
                }
            } else if (choice == 4)
            {
                try {
                    System.out.print("\n===========Welcome In Delete Operation===========\n");
                    Scanner sca = new Scanner(System.in);
                    User newUser = new User();
                    System.out.print("Enter your id for Delete User:\t: ");
                    int id = scanner.nextInt();
                    if (id <= 0)
                    {
                        System.out.print("Wrong enter your id");
                        break;
                    }else {
                        newUser.setId(id);
                        session.delete(newUser);
                        transaction.commit();
                    }

                    System.out.println("User with ID " + newUser.getId() + " has been deleted");
                } catch (Exception e) {
                    e.printStackTrace();
                    transaction.rollback();
                    System.out.println("User not deleted");
                }
            }
        }

    }

}