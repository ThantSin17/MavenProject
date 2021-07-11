package con.stone.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class Person extends BaseEntity<Long>{
    @Embedded
    private FullName fullName;

    @Column(length = 3)
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;



}
