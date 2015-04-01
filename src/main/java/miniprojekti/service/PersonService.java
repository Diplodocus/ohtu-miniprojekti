package java.com.miniprojekti.service;


import java.com.miniprojekti.model.Person;
import java.util.List;



public interface PersonService {
    
    public void addPerson(Person person);
    public List<Person> listPeople();
    public void removePerson(Integer id);
}
