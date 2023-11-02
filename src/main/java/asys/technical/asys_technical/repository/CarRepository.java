package asys.technical.asys_technical.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import asys.technical.asys_technical.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, UUID> {
};