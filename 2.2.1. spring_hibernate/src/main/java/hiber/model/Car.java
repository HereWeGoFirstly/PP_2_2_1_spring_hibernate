package hiber.model;

import javax.persistence.*;

@Entity
@Table
public class Car {

    public Car() {
    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String model;

    @Column
    int series;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int user_id) {
        this.id = user_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
