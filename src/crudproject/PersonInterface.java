/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package crudproject;

import java.util.List;

/**
 *
 * @author Seth
 */
public interface PersonInterface {
    public void save(Person person);
    public void update(Person person);
    public void delete(Person person);
    //public Person get(int id);
    public List<Person> list();
}
