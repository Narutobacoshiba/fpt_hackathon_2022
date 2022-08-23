package mvc.backend_server.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import mvc.backend_server.algorithms.GeneticAlgorithmsImplementer;
import mvc.backend_server.dto.Data;
import mvc.backend_server.dto.Solution;
import mvc.backend_server.entity.Distance;
import mvc.backend_server.entity.POI;
import mvc.backend_server.entity.Tour;
import mvc.backend_server.repository.DistanceRepo;
import mvc.backend_server.repository.POIRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    @GetMapping("/generate/{startDate}/{endDate}")
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

        return  tour;


    }
}