package com.alfred.controllers;

import com.alfred.model.Beacon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeaconsController {
    private List<Beacon> beacons;

    @RequestMapping(value="/beacons",method= RequestMethod.POST)
    public void createInstructionFromSemantics(@RequestBody List<Beacon> beacons){
        this.beacons=beacons;
        System.out.println(beacons);
    }

    @RequestMapping(value="/beacons",method = RequestMethod.GET)
    public List<Beacon> getBeacons(){
        return this.beacons;
    }
}
