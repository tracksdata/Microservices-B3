package com.cts.brownfield.pss.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.brownfield.pss.entity.AirlineInfo;
import com.cts.brownfield.pss.entity.BookingRecord;
import com.cts.brownfield.pss.entity.CheckIn;
import com.cts.brownfield.pss.entity.CoPassenger;
import com.cts.brownfield.pss.entity.Fares;
import com.cts.brownfield.pss.entity.Flight;
import com.cts.brownfield.pss.entity.Passenger;
import com.cts.brownfield.pss.entity.User;
import com.cts.brownfield.pss.service.AirlineService;
import com.cts.brownfield.pss.service.BookingRecordService;
import com.cts.brownfield.pss.service.BookingService;
import com.cts.brownfield.pss.service.CheckinService;
import com.cts.brownfield.pss.service.FareService;
import com.cts.brownfield.pss.service.PassengerService;
import com.cts.brownfield.pss.service.SearchFlightService;
import com.cts.brownfield.pss.service.SearchQuery;
import com.cts.brownfield.pss.service.UserService;

@RestController
@RequestMapping("/api/pss")
public class BookingRestController {

	@Autowired
	private SearchFlightService flightService;
	@Autowired
	private UserService userService;
	@Autowired
	private PassengerService passengerService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private BookingRecordService bookingRecordService;
	@Autowired
	private CheckinService checkinService;
	@Autowired
	private AirlineService airlineService;
	@Autowired
	private FareService fareService;

	@GetMapping("/flights")
	public List<Flight> allFlights() {
		return flightService.findAll();
	}

	@PostMapping("/flights/scheduleFlights")
	public List<Flight> saveAllFlights(@RequestBody List<Flight> flights) {
		return flightService.saveAll(flights);
	}

	@GetMapping("/airline/listAllAirlines")
	public List<AirlineInfo> listAllAirlines() {
		return airlineService.findAllAirlines();
	}

	@PostMapping("/airline/addAirlines")
	public List<AirlineInfo> addAllAirlines(@RequestBody List<AirlineInfo> airLines) {
		return airlineService.saveAirlines(airLines);
	}

	@PostMapping("/fare/update/{id}")
	public Fares updateFare(@RequestBody Fares fare,@PathVariable("id") long id) {
		Fares fares = fareService.getFareById(id);
		if (fares != null) {
			
			fares.setFare(fare.getFare());
			if(fare.getCurrency()!=null)
				fares.setCurrency(fare.getCurrency());
			return fareService.updateNewFare(fares);
		}
		else
		return null;
	}

	@GetMapping("/fare/getFare/{id}")
	public Fares findFareById(@PathVariable("id") long id) {
		return fareService.getFareById(id);
	}
	
	@GetMapping("/fare/getFare/{flightNumber}/{flightDate}")
	public double findFareByFlightNumberAndFlightDate(@PathVariable("flightNumber") String flightNumber,@PathVariable("flightDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flightDate) {
		return flightService.getFare(flightNumber, flightDate);
	}


	@GetMapping("/find/{origin}/{destination}/{flightDate}/{numberofPassengers}")
	public List<Flight> listSearchedFlights(@PathVariable("origin") String origin,
			@PathVariable("destination") String destination,
			@PathVariable("flightDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate flightDate,
			@PathVariable("numberofPassengers") int numberofPassengers) {

		SearchQuery searchQuery = new SearchQuery(origin, destination, flightDate, numberofPassengers);
		List<Flight> flights = flightService.search(searchQuery).collect(Collectors.toList());
		return flights;
	}

	@GetMapping("/find/{id}/{numberofPassengers}")
	public Flight findFlight(@PathVariable("id") long id, @PathVariable("numberofPassengers") int numberofPassengers) {

		Flight flight = flightService.findById(id);
		if (numberofPassengers <= flight.getInventory().getCount())
			return flight;
		else
			return null;
	}

	@PostMapping("/book/{id}/{numberofPassengers}")
	public Passenger bookFlight(@RequestBody Passenger passenger, @PathVariable("id") long id,
			@PathVariable("numberofPassengers") int numberofPassengers) {
		Passenger bookedPassenger = bookingService.book(passenger, id, numberofPassengers);
		List<CoPassenger> coPassengers = passenger.getCoPassengers();
		if (coPassengers != null && passenger.getCoPassengers().size() == numberofPassengers - 1) {

			return bookedPassenger;
		}

		return null;
	}

	@PostMapping("/checkin/{bookingId}")
	public CheckIn checkInProcess(Model data, @PathVariable("bookingId") long bookingId) {

		CheckIn checkinObj = null;

		if (checkinService.existsByBookingId(bookingId)) {
			System.out.println("===========>>  ++++ <<===========");
			CheckIn checkInInfo = checkinService.findByBookingId(bookingId);
			return checkInInfo;
		}

		BookingRecord bookingRecord = bookingRecordService.findByBookingId(bookingId);
		if (bookingRecord == null) {
			return null;
		}
		Passenger pass = passengerService.findByBookingRecord(bookingRecord);
		if (pass != null) {
			checkinObj = new CheckIn();
			checkinObj.setBookingId(bookingId);
			checkinObj.setCheckinTime(LocalDateTime.now());
			checkinObj.setFlightNumber(pass.getBookingRecord().getFlightNumber());
			checkinObj.setPassenger(pass);
			checkinObj.setSeatNumber("F4");

			checkinService.save(checkinObj);

		}
		return checkinObj;
	}
	
	@GetMapping("/login")
	public User findUser(@RequestBody User user) {
		
		User usr=userService.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if(usr!=null) {
			return usr;
		}
		
		return null;
	}
	
	@GetMapping("/validate/{userName}/{password}")
	public Boolean validateUser(@PathVariable("userName")String userName,@PathVariable("password")String password) {
		boolean status=userService.existsByUserNameAndPassword(userName, password);
		return status;
	}
	

}
