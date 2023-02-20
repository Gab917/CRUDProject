/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

 */


package crudproject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Seth
 */
public class DBAccess implements PersonInterface{
    
    Connection connection;
    
    public DBAccess(String url) throws SQLException{
        this.connection = DriverManager.getConnection(url,"root","");
       
        
        
    }
    public List<Person> search(int id){
        List<Person> list = new ArrayList<Person>();
        
        try {
            String query = "SELECT * FROM personalinfo WHERE id=?";
            
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1, id);
            //st.executeUpdate();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Person person = new Person();
                person.setId(rs.getInt("ID"));
                person.setFname(rs.getString("firstname"));
                person.setLname(rs.getString("lastname"));
                person.setContact(rs.getString("contact"));
                person.setGender(rs.getString("gender"));
                
                list.add(person);
            
            }
            
        } catch (SQLException e){
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null,"Error");
        }
        
        return list;
    }
    
    public List<Person> list(){
        
        List<Person> list = new ArrayList<Person>();
        
        
        try {
            String query = "SELECT * FROM personalinfo";
            
            PreparedStatement st = connection.prepareStatement(query);
            //st.executeUpdate();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Person person = new Person();
                person.setId(rs.getInt("ID"));
                person.setFname(rs.getString("firstname"));
                person.setLname(rs.getString("lastname"));
                person.setContact(rs.getString("contact"));
                person.setGender(rs.getString("gender"));
                
                list.add(person);
            
            }
            
        } catch (SQLException e){
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null,"Error");
        }
        
        return list;
        
    }
    
    //save
    public void save(Person person){ 
        
        try {
            String query = "INSERT INTO personalinfo (firstname,lastname,contact,gender) VALUES (?,?,?,?)";
            
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1,person.getFname());
            st.setString(2,person.getLname());
            st.setString(3,person.getContact());
            st.setString(4,person.getGender());
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Saved");
            st.close();
            
        } catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    
    public void update(Person person){
        
        try{
            String query = "UPDATE personalinfo SET firstname=?,lastname=?,contact=?,gender=? WHERE id=?";
            
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1,person.getFname());
            st.setString(2,person.getLname());
            st.setString(3,person.getContact());
            st.setString(4,person.getGender());
            st.setInt(5,person.getId());
            // INSERT getID here
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Updated");
            st.close();
            
        } catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    
    public void delete(Person person){
        try{
            String query = "DELETE FROM personalinfo WHERE id=?";
            
            PreparedStatement st = connection.prepareStatement(query);
            
            st.setInt(1,person.getId());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Deleted");
            st.close();
            
        } catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
}
