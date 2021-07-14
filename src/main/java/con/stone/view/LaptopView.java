package con.stone.view;

import con.stone.entity.Laptop;

public class LaptopView extends AbstractViewImpl<Laptop> {
    @Override
    public void printDetails(Laptop model) {
        StringBuilder builder=new StringBuilder();
        builder.append("Laptop id= ");
        builder.append(model.getId());
        builder.append("Brand = ");
        builder.append(model.getBrand());
        builder.append("Description = ");
        builder.append(model.getDescription());
        System.out.println(builder);
    }
}
