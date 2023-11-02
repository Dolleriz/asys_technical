package asys.technical.asys_technical.model;

import java.time.*;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.*;

@Entity
@Table(name = "CAR")
@DynamicUpdate
public class Car {

    @Id
    @Column(name = "VIN", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID vin;

    @Column(name = "MAKE")
    private String make;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "MILEAGE")
    private int mileage = -1;

    @Column(name = "CREATION_DATE", updatable = false, nullable = false)
    @CreationTimestamp
    private OffsetDateTime creation_Date;

    public Car() {
    }

    public Car(String make, String model, int mileage) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
    }

    public UUID getVIN() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public OffsetDateTime getCreation_Date() {
        return creation_Date;
    }
}
