package con.stone.dto;

import con.stone.entity.BaseEntity;
import con.stone.entity.Laptop;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LaptopDto extends BaseEntity<Integer> {
    private String brand;
    private String description;

    public LaptopDto(Laptop laptop) {
        super.setId(laptop.getId());
        this.brand=laptop.getBrand();
        this.description=laptop.getDescription();
    }
    public Laptop getEntity(){
        Laptop laptop=new Laptop();
        laptop.setId(super.getId());
        laptop.setBrand(this.brand);
        laptop.setDescription(this.description);
        return laptop;
    }
}
