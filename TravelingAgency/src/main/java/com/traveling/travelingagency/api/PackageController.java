package com.traveling.travelingagency.api;

import com.traveling.travelingagency.models.Package;
import com.traveling.travelingagency.models.Base;
import com.traveling.travelingagency.services.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
public class PackageController {
    @Autowired
    private PackageService packageService;

    @CrossOrigin
    @GetMapping("/api/package/retrieveall")
    public ArrayList<Base> retrievePackages(){
        return packageService.retrieveAll();
    }

    @GetMapping("/api/package/retrievebyid")
    public Base retrievePackageById(@RequestParam int id){
        return packageService.retrieveById(id);
    }
    @PostMapping("/api/package/create")
    public void createPackage(@RequestBody Package pack){
        packageService.create(pack);
    }
    @PutMapping("/api/package/update")
    public void updatePackage(@RequestBody Package pack){
        packageService.update(pack);
    }
    @DeleteMapping("/api/package/delete")
    public void deletePackage(@RequestParam int id){
        packageService.delete(id);
    }


}
