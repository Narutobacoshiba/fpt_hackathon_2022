package mvc.backend_server.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import mvc.backend_server.algorithms.GeneticAlgorithmsImplementer;
import mvc.backend_server.dto.Data;
import mvc.backend_server.dto.Solution;
import mvc.backend_server.entity.*;
import mvc.backend_server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


@RestController
@RequestMapping("/trip")

public class TripController {
    @Autowired
    POIRepo poiRepo;
    @Autowired
    DistanceRepo distanceRepo;
    @Autowired
    BusinessTourRepo tourRepo;
    @Autowired
    DayOfTripRepo dayOfTripRepo;
    @Autowired
    POIOfDayRepo poiOfDayRepo;
    @PostMapping("/generate/{startDate}/{endDate}")
    public Tour generateour(@PathVariable(required = false) String startDate, @PathVariable(required = false) String endDate) throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date parsed = format.parse(startDate);
        Date sDate = new Date(parsed.getTime());
        parsed = format.parse(endDate);
        Date eDate = new Date(parsed.getTime());
        ArrayList<POI> listPoi= (ArrayList<POI>) poiRepo.findAll();
        int numberOfPOI = listPoi.size();
        POI[] POIs = new POI[numberOfPOI];
        for(int i=0;i<listPoi.size();i++){
            POIs[i] = listPoi.get(i);
        }
        ArrayList<Distance> listDistance= (ArrayList<Distance>) distanceRepo.findAll();
        double[][] distanceOfPOI=new double[numberOfPOI][numberOfPOI];
        for(int i=0;i<listDistance.size();i++){
            distanceOfPOI[listDistance.get(i).getStartStation().getPOIId()][listDistance.get(i).getEndStation().getPOIId()]=listDistance.get(i).getDistance();
        }
        Data data = new Data(sDate,eDate,distanceOfPOI,POIs,numberOfPOI);

        GeneticAlgorithmsImplementer ga = new GeneticAlgorithmsImplementer(data);
        Solution s = ga.implementGA(data);
        Tour tour =s.toTour(data);
        //tourRepo.save(tour);
        Tour add = new Tour();
        add.setStartDate(sDate);
        add.setEndDate(eDate);
         int tourid =tourRepo.save(add).getId();
         tour.setId(tourid);
         tour.setStartDate(sDate);
         tour.setEndDate(eDate);
        for(DayOfTrip day :tour.getListDays()){
            DayOfTrip daysAdded = new DayOfTrip();
            daysAdded.setTour(tour);
            daysAdded.setDate(day.getDate());
            daysAdded.setNumber(day.getNumber());
            int dayid = dayOfTripRepo.save(daysAdded).getId();
            day.setId(dayid);
            for (POIOfDay poi: day.getListPOIs()) {
                poi.setDayOfTrip(daysAdded);

                poiOfDayRepo.save(poi);
            }
        }
        return  tour;


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTour(@PathVariable int id){
        try {
            tourRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<Tour> updateTour(@RequestBody Tour tour){
        try {
            Tour oldTour = tourRepo.findById(tour.getId()).get();
            for (DayOfTrip day:oldTour.getListDays()) {
                day.getListPOIs().clear();
            }
            for (DayOfTrip day: tour.getListDays()){
                for(POIOfDay poi : day.getListPOIs()){
                    POIOfDay ePoi = poiOfDayRepo.findPOIOfDayById(poi.getId());
                    ePoi.setStartTime(poi.getStartTime());
                    ePoi.setEndTime(poi.getEndTime());
                    ePoi.setNumber(poi.getNumber());
                    ePoi.setPoi(poi.getPoi());
                    ePoi.setDayOfTrip(poi.getDayOfTrip());
                    poiOfDayRepo.save(ePoi);
                }
            }

            return new ResponseEntity<>(tour, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
