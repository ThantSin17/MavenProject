package con.stone.dto;

import con.stone.entity.BaseEntity;
import con.stone.entity.FullName;
import con.stone.entity.Laptop;
import con.stone.entity.Person;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PersonDto extends BaseEntity<Integer> {
    private int age;
    private String firstName,lastName;
    private Laptop laptop;
    public PersonDto(Person person){
        super.setId(person.getId());
        this.age=person.getAge();
        this.firstName=person.getFullName().getFirstName();
        this.lastName=person.getFullName().getLastName();
        this.laptop=person.getLaptop();
    }
    public Person getEntity(){
        Person person=new Person();
        person.setId(super.getId());
        person.setAge(this.age);
        person.setLaptop(this.laptop);
        person.setFullName(new FullName(this.firstName,this.lastName));
        return person;
    }

}
