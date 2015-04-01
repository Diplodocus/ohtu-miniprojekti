package miniprojekti.service;



import java.util.List;
import miniprojekti.model.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {
    
    public void addPerson(Person person);
    public List<Person> listPeople();
    public void removePerson(Integer id);
}
