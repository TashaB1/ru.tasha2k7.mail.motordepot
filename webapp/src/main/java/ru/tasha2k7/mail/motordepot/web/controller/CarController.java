package ru.tasha2k7.mail.motordepot.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.tasha2k7.mail.motordepot.datamodel.Car;
import ru.tasha2k7.mail.motordepot.services.CarService;
import ru.tasha2k7.mail.motordepot.web.model.CarModel;

@RestController
@RequestMapping("/car")
public class CarController {
	@Inject
	private CarService carService;
	
	@RequestMapping(value = "/{carId}", method = RequestMethod.GET)
	public ResponseEntity<CarModel> getById(@PathVariable Long carId) {
		Car car = carService.getById(carId);
		return new ResponseEntity<CarModel>(entity2model(car), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CarModel>> getAll() {
        List<Car> all = carService.getAll();

        List<CarModel> converted = new ArrayList<>();
        for (Car car : all) {
            converted.add(entity2model(car));
        }

        return new ResponseEntity<List<CarModel>>(converted,
                HttpStatus.OK);
    }
	
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createNewCar(
            @RequestBody CarModel carModel) {
        carService.save(model2entity(carModel));
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


//---
	private CarModel entity2model(Car car) {
		CarModel e = new CarModel();
		e.setMakeModel(car.getMakeModel());
		e.setNumberRegistration(car.getNumberRegistration());
		e.setCapacityCarryingKg(car.getCapacityCarryingKg());
		e.setLengthDimensionsM(car.getLengthDimensionsM());
		e.setWidthDimensionsM(car.getWidthDimensionsM());
		e.setHeigthDimensionsM(car.getHeigthDimensionsM());
		e.setConditionVehical(car.getConditionVehical());
		e.setInspectionDate(car.getInspectionDate());
		e.setDeleted(car.getDeleted());
		return e;
	}

	private Car model2entity(CarModel carModel) {
		Car e = new Car();
		e.setMakeModel(carModel.getMakeModel());
		e.setNumberRegistration(carModel.getNumberRegistration());
		e.setCapacityCarryingKg(carModel.getCapacityCarryingKg());
		e.setLengthDimensionsM(carModel.getLengthDimensionsM());
		e.setWidthDimensionsM(carModel.getWidthDimensionsM());
		e.setHeigthDimensionsM(carModel.getHeigthDimensionsM());
		e.setConditionVehical(carModel.getConditionVehical());
		e.setInspectionDate(carModel.getInspectionDate());
		e.setDeleted(carModel.getDeleted());
		return e;
	}



}
