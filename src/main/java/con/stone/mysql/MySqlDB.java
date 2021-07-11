package con.stone.mysql;

import con.stone.entity.Person;

import java.sql.*;

public class MySqlDB {


//    Connection con=null;
//    public void init(){
//        String url="jdbc:mysql://localhost:3306/Test";
//        String user="root";
//        String password="thantsinhtun";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Class found");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            con= DriverManager.getConnection(url,user,password);
//            System.out.println("Connection successful");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    public void insertPerson(Person person){
//        String sql="insert into User (name,age) values (?,?)";
//        try {
//            PreparedStatement statement=con.prepareStatement(sql);
//            statement.setString(1,person.getName());
//            statement.setInt(2,person.getAge());
//            int insertQuery=statement.executeUpdate();
//            if (insertQuery>0){
//                System.out.println("Insert Successful!");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//    public void selectAllPeople(){
//        String sql="select * from User";
//        try {
//            Statement statement=con.createStatement();
//            ResultSet rs=statement.executeQuery(sql);
//            while (rs.next()){
//                Person person=new Person();
//                person.setId(rs.getInt(1));
//                person.setName(rs.getString(2));
//                person.setAge(rs.getInt(3));
//                System.out.println(person.getId()+"->"+person.getName()+"->"+person.getAge());
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//    }
//    public void updateByPersonId(int id,Person person){
//        String sql="update User set name=?,age=? where id=?";
//        try {
//            PreparedStatement statement=con.prepareStatement(sql);
//            statement.setString(1,person.getName());
//            statement.setInt(2,person.getAge());
//            statement.setInt(3,id);
//            int updateCount=statement.executeUpdate();
//            if (updateCount>0){
//                System.out.println("Update Successful!");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//    public void deletePersonById(int id){
//        String sql="delete from User where id=?";
//        try {
//            PreparedStatement statement=con.prepareStatement(sql);
//
//            statement.setInt(1,id);
//            int deleteQuery=statement.executeUpdate();
//            if (deleteQuery>0){
//                System.out.println("deletion Successful!");
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
}
