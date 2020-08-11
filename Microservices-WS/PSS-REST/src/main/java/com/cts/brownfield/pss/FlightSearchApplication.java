package com.cts.brownfield.pss;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cts.brownfield.pss.dao.FlightInfo;
import com.cts.brownfield.pss.dao.FlightRepository;
import com.cts.brownfield.pss.entity.Fares;
import com.cts.brownfield.pss.entity.Flight;
import com.cts.brownfield.pss.entity.AirlineInfo;
import com.cts.brownfield.pss.entity.Inventory;

@SpringBootApplication
public class FlightSearchApplication {

	public static void main(String[] args) {
		
		ApplicationContext ac = SpringApplication.run(FlightSearchApplication.class, args);
		FlightRepository flightRepository = ac.getBean(FlightRepository.class);
		//AirlineDao airlineDao = ac.getBean(AirlineDao.class);

		List<Flight> flights = new ArrayList<>();
		List<AirlineInfo> airlines = new ArrayList<>();



		AirlineInfo a1 = new AirlineInfo("Air India", "airindia.png");
		AirlineInfo a2 = new AirlineInfo("Indigo", "indigo.png");
		AirlineInfo a3 = new AirlineInfo("Air Asia", "air-asia.png");
		AirlineInfo a4 = new AirlineInfo("Spicejet", "spicejet.png");
		AirlineInfo a5 = new AirlineInfo("Vistara", "vistara.png");
		AirlineInfo a6 = new AirlineInfo("Trujet", "truejet.png");
		AirlineInfo a7 = new AirlineInfo("GoAir", "goair.png");
		
		airlines.add(a1);
		airlines.add(a2);
		airlines.add(a3);
		airlines.add(a4);
		airlines.add(a5);
		airlines.add(a6);
		airlines.add(a7);
		
		
	
		
		FlightInfo f1=new FlightInfo("AI-840", "Airbus", 150);
		FlightInfo f2=new FlightInfo("AI-850", "Airbus", 150);
		FlightInfo f3=new FlightInfo("AI-860", "Airbus", 150);
		FlightInfo f4=new FlightInfo("AI-870", "Airbus", 150);
		
		FlightInfo f5=new FlightInfo("6E-6684", "Airbus", 150);
		FlightInfo f6=new FlightInfo("6E-6685", "Airbus", 150);
		FlightInfo f7=new FlightInfo("6E-6686", "Airbus", 150);
		FlightInfo f8=new FlightInfo("6E-6687", "Airbus", 150);
		
		FlightInfo f9=new FlightInfo("I5-755", "Airbus", 150);
		FlightInfo f10=new FlightInfo("I5-756", "Airbus", 150);
		FlightInfo f11=new FlightInfo("I5-757", "Airbus", 150);
		FlightInfo f12=new FlightInfo("I5-758", "Airbus", 150);
		
		FlightInfo f13=new FlightInfo("SG-432", "Airbus", 150);
		FlightInfo f14=new FlightInfo("SG-433", "Airbus", 150);
		FlightInfo f15=new FlightInfo("SG-434", "Airbus", 150);
		FlightInfo f16=new FlightInfo("SG-435", "Airbus", 150);
		
		FlightInfo f17=new FlightInfo("UK-830", "Airbus", 150);
		FlightInfo f18=new FlightInfo("UK-831", "Airbus", 150);
		FlightInfo f19=new FlightInfo("UK-832", "Airbus", 150);
		FlightInfo f20=new FlightInfo("UK-833", "Airbus", 150);
		
		FlightInfo f21=new FlightInfo("2T-518", "Airbus", 150);
		FlightInfo f22=new FlightInfo("2T-519", "Airbus", 150);
		FlightInfo f23=new FlightInfo("2T-520", "Airbus", 150);
		FlightInfo f24=new FlightInfo("2T-521", "Airbus", 150);
		
		FlightInfo f25=new FlightInfo("G8-424", "Airbus", 150);
		FlightInfo f26=new FlightInfo("G8-425", "Airbus", 150);
		FlightInfo f27=new FlightInfo("G8-426", "Airbus", 150);
		FlightInfo f28=new FlightInfo("G8-427", "Airbus", 150);
		
		
		a1.getInfo().add(f1);
		a1.getInfo().add(f2);
		a1.getInfo().add(f3);
		a1.getInfo().add(f4);
		
		a2.getInfo().add(f5);
		a2.getInfo().add(f6);
		a2.getInfo().add(f7);
		a2.getInfo().add(f8);
		
		a3.getInfo().add(f9);
		a3.getInfo().add(f10);
		a3.getInfo().add(f11);
		a3.getInfo().add(f12);
		
		a4.getInfo().add(f13);
		a4.getInfo().add(f14);
		a4.getInfo().add(f15);
		a4.getInfo().add(f16);
		
		
		a5.getInfo().add(f17);
		a5.getInfo().add(f18);
		a5.getInfo().add(f19);
		a5.getInfo().add(f20);
		
		a6.getInfo().add(f21);
		a6.getInfo().add(f22);
		a6.getInfo().add(f23);
		a6.getInfo().add(f24);
		
		a7.getInfo().add(f25);
		a7.getInfo().add(f26);
		a7.getInfo().add(f27);
		a7.getInfo().add(f28);
		
		
		//airlineDao.saveAll(airlines);
		

		flights.add(new Flight(f1.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2020, 8, 21),LocalTime.of(2, 12), new Fares(4500, "INR"),
				new Inventory(100),f1));
		flights.add(new Flight(f2.getFlightNumber(), "DELHI", "HYDERABAD","2 hrs 45 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(1, 15), new Fares(3500, "INR"),
				new Inventory(100),f2));
		flights.add(new Flight(f3.getFlightNumber(), "CHENNAI", "MUMBAI","2 hrs 50 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(2, 30), new Fares(5000, "INR"),
				new Inventory(100),f3));
		flights.add(new Flight(f4.getFlightNumber(), "PUNE", "HYDERABAD","1 hrs 45 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(2, 45), new Fares(2546, "INR"),
				new Inventory(100),f4));
		flights.add(new Flight(f5.getFlightNumber(), "CHENNAI", "PORTBLAIR","3 hrs 00 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(3, 00), new Fares(7500, "INR"),
				new Inventory(100),f5));
		flights.add(new Flight(f6.getFlightNumber(), "BENGULURU", "DELHI","3 hrs 15 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(3, 15), new Fares(10000, "INR"),
				new Inventory(100),f6));
		flights.add(new Flight(f7.getFlightNumber(), "DELHI", "PUNE","4 hrs 07 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(3, 15), new Fares(7438, "INR"),
				new Inventory(100),f7));
		flights.add(new Flight(f8.getFlightNumber(), "HYDERABAD", "MANGALORE","3 hrs 30 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(3, 15), new Fares(8743, "INR"),
				new Inventory(100),f8));
		flights.add(new Flight(f9.getFlightNumber(), "MUMBAI", "AHMADABAD","6 hrs 00 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(4, 30), new Fares(1955, "INR"),
				new Inventory(100),f9));
		flights.add(new Flight(f10.getFlightNumber(), "HYDERABAD", "KOLKATA","3 hrs 15 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(4, 45), new Fares(2500, "INR"),
				new Inventory(100),f10));
		flights.add(new Flight(f11.getFlightNumber(), "KOLKATA", "DELHI","1 hrs 00 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(7, 45), new Fares(4943, "INR"),
				new Inventory(100),f11));
		flights.add(new Flight(f15.getFlightNumber(), "DELHI", "MUMBAI","1 hrs 00 mins",  LocalDate.of(2020, 8, 21),LocalTime.of(11, 45), new Fares(4943, "INR"),
				new Inventory(100),f15));
		
		flights.add(new Flight(f16.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2020, 8, 21),LocalTime.of(2, 45), new Fares(4500, "INR"),
				new Inventory(100),f16));
		flights.add(new Flight(f17.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2020, 8, 21),LocalTime.of(10, 15), new Fares(6200, "INR"),
				new Inventory(100),f17));
		flights.add(new Flight(f18.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2020, 8, 21),LocalTime.of(11, 30), new Fares(5000, "INR"),
				new Inventory(100),f18));
		
		flights.add(new Flight(f19.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2020, 8, 21),LocalTime.of(11, 55), new Fares(1200, "INR"),
				new Inventory(120),f19));
		flights.add(new Flight(f20.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2020, 8, 21),LocalTime.of(11, 55), new Fares(1389, "INR"),
				new Inventory(100),f20));
		flights.add(new Flight(f21.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2020, 8, 21),LocalTime.of(10, 15), new Fares(11000, "INR"),
				new Inventory(100),f21));
		flights.add(new Flight(f22.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2020, 8, 21),LocalTime.of(19, 35), new Fares(15000, "INR"),
				new Inventory(100),f22));
		flights.add(new Flight(f22.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2020, 8, 24),LocalTime.of(6, 15), new Fares(3000, "INR"),
				new Inventory(100),f22));
		flights.add(new Flight(f23.getFlightNumber(), "DELHI", "CHENNAI","2 hrs 15 mins", LocalDate.of(2020, 8, 24),LocalTime.of(22, 45), new Fares(9000, "INR"),
				new Inventory(100),f23));
	//	flightRepository.saveAll(flights);

	}

}
