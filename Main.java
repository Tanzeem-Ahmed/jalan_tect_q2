import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Service {
    HashMap<String, Integer> serviceAmount;

    Service(int BS01, int EF01, int CF01, int BF01, int GF01) {
        serviceAmount = new HashMap<>();
        serviceAmount.put("BS01", BS01);
        serviceAmount.put("EF01", EF01);
        serviceAmount.put("CF01", CF01);
        serviceAmount.put("BF01", BF01);
        serviceAmount.put("GF01", GF01);
    }

    public int getAmount(String code) {
        if (this.serviceAmount.get(code) == null) {
            System.out.println("Please enter valid code...");
            return 0;
        }

        return this.serviceAmount.get(code);
    }
}

class ServiceStation {
    String carName;
    ArrayList<String> serviceCodes;
    HashMap<String, String> serviceName;
    HashMap<String, Service> carType;

    ServiceStation(String carName, ArrayList<String> serviceCodes) {
        this.carName = carName;
        this.serviceCodes = new ArrayList<>();
        for (String service : serviceCodes) {
            this.serviceCodes.add(service);
        }

        serviceName = new HashMap<>();
        carType = new HashMap<>();

        serviceName.put("BS01", "Basic Servicing");
        serviceName.put("EF01", "Engine Fixing");
        serviceName.put("CF01", "Clutch Fixing");
        serviceName.put("BF01", "Brake Fixing");
        serviceName.put("GF01", "Gear Fixing");
        carType.put("HatchBack", new Service(2000, 5000, 2000, 1000, 3000));
        carType.put("Sedan", new Service(4000, 8000, 4000, 1500, 6000));
        carType.put("SUV", new Service(5000, 10000, 6000, 2500, 8000));
    }

    public void generateBill() {
        int billAmount = 0;
        Service carService = carType.get(carName);

        for (String code : serviceCodes) {
            System.out.println("Charges for " + this.serviceName.get(code) + " - Rs. " + carService.getAmount(code));
            billAmount += carService.getAmount(code);
        }

        System.out.println("Total Bill " + " - Rs. " + billAmount);
        if (billAmount >= 10000) {
            System.out.println("Complimentary cleaning has been done for free");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter car name : ");
        String carType = sc.next();
        System.out.println("Enter the service codes");
        ArrayList<String> serviceCodes = new ArrayList<>();
        serviceCodes.add("BS01");
        serviceCodes.add("EF01");
        serviceCodes.add("CF01");

        ServiceStation billAmount = new ServiceStation(carType, serviceCodes);
        billAmount.generateBill();
    }
}