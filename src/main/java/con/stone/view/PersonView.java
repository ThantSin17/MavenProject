package con.stone.view;

import con.stone.entity.Person;

public class PersonView extends AbstractViewImpl<Person> {
    @Override
    public void printDetails(Person model) {
        StringBuilder builder=new StringBuilder();
        builder.append("Person id= ");
        builder.append(model.getId());
        builder.append(", age= ");
        builder.append(model.getAge());
        builder.append(", Laptop id=");
        try {
            builder.append(model.getLaptop().getId());
        }catch (NullPointerException e){
            builder.append("No Laptop");
        }finally {
            System.out.println(builder.toString());
        }
    }
}
