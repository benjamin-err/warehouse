package swe.group_one.warehouse.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swe.group_one.warehouse.domain.Delivery;
import swe.group_one.warehouse.domain.Order;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // defines PackageService as a Spring Bean (or @Component)
public class PackageService {

    @Autowired
    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<Order> getPackages() {
        return packageRepository.findAll();
    }

    public Order getPackage(Integer id) {
        Optional<Order> optionalPackage = packageRepository.findById(id);
        if (optionalPackage.isEmpty()) {
            System.out.println("Package with id:" + id + " doesn't exist!");
        }
        return optionalPackage.get();
    }

    public void deletePackage(Integer id) {
        if (packageRepository.existsById(id)) {
            packageRepository.deleteById(id);
        } else {
            System.out.println("Package with id:" + id + " doesn't exist!");
        }
    }

    @Transactional // saves us a delete query in PackageRepository
    public void updatePackage(Integer id, String name, String email) {
        Order pack = packageRepository.findById(id).orElseThrow(() -> {
            throw new IllegalStateException("Package with id: " + id + " does not exist!");
        });

        if (name != null && name.length() > 0 && !Objects.equals(pack.getBillAddr().getName(), name)) {
            pack.getBillAddr().getName();
        }

        if (email != null && email.length() > 0 && !Objects.equals(pack.getBillAddr().getEmail(), email)) {
            Optional<Order> packageOptional = packageRepository.findPackageByEmail(email);
            if (packageOptional.isPresent()) {
                throw new IllegalStateException("Customer package with email: " + email + " does not exist!");
            }

            pack.getBillAddr().setEmail(email);
        }
    }

    public Boolean isStored(Order pack) {
        Optional<Order> op = packageRepository.findPackageByName(pack.getBillAddr().getName());
        if (op.isPresent()) {
            Delivery.prepareForDelivery(pack);
            return true;
        }
        else return false;

    }

    public void addNewPackage(Order pack) {
        Optional<Order> packageByEmail = packageRepository.findPackageByEmail(pack.getBillAddr().getEmail());
        if (packageByEmail.isPresent()) {
            System.out.println("Customer with the billing email address: " + " is already present!");
        }
        packageRepository.save(pack);

        Delivery.prepareForDelivery(pack);
    }

    // this method and its implementation logic is left fot the future
    public Boolean isAvailable(String type, String amount) {
        return true;
    }
}
