package swe.group_one.warehouse.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swe.group_one.warehouse.domain.Order;

import java.util.List;

/*
    all resources for the API Layer
 */

@RestController
@RequestMapping(path = "swe/firstgroup/warehouse")
public class PackageController {

    private final PackageService packageService;

    @Autowired
    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    // list everything
    @GetMapping(path = "/packages")
    public List<Order> getPackages() {
        return packageService.getPackages();
    }

    @GetMapping()
    public Order getPackageByParam(@RequestParam("id") Integer id) {
        return packageService.getPackage(id);
    }

    @GetMapping("{id}")
    public Order getPackageByVar(@PathVariable("id") Integer id) {
        return packageService.getPackage(id);
    }

    @DeleteMapping(path = "{packageId}")
    public void deletePackage(@PathVariable("packageId") Integer id) {
        packageService.deletePackage(id);
    }

    // update with the help of an id
    @PutMapping(path = "{packageId}")
    public void updatePackage(@PathVariable("packageId") Integer id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        packageService.updatePackage(id, name, email);
    }

    // shopfloor asks if the order is already stored/available
    @PostMapping(path = "stored")
    public Boolean productStored(@RequestBody Order pack) {
        return packageService.isStored(pack);
    }

    // shopfloor checkes the availability of a material and needed amount
    @GetMapping(path = "/{type}/{amount}")
    public Boolean materialAvailable(@PathVariable String type, @PathVariable String amount) {
        return packageService.isAvailable(type, amount);
    }

    // shopfloor gives the command to store the order
    @PostMapping(path = "/store")
    public void storeProduct(@RequestBody Order pack) {
        packageService.addNewPackage(pack);
    }

}
