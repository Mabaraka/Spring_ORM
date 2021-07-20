package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int series;

    @Column(name = "model")
    private String model;

    @OneToOne (mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car() {
    }
}
