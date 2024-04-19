//package co.ke.emtechhouse.Atm;
//
//import co.ke.emtechhouse.Atm.AtmRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Service;
//
//import java.net.InetAddress;
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//
//@Service
//public class IPStatusChecker {
//
//    private final AtmRepository atmRepository;
//
//    @Autowired
//    public IPStatusChecker(AtmRepository atmRepository) {
//        this.atmRepository = atmRepository;
//    }
//
//    public void checkAndUpdateStatus() {
//        while (true) {
//            try {
//                List<String> ipAddresses = atmRepository.findByIPAddresses();
//
//                for (String ipAddress : ipAddresses) {
//                    InetAddress inetAddress = InetAddress.getByName(ipAddress);
//                    boolean isOnline = inetAddress.isReachable(5000); // Timeout in milliseconds
//                    String status = isOnline ? "Online" : "Offline";
//
//                    updateStatusInDatabase(ipAddress, status);
//
//                    System.out.println(ipAddress + " is " + status);
//                }
//
//                TimeUnit.SECONDS.sleep(10); // Wait for 10 seconds before checking again
//            } catch (IOException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void updateStatusInDatabase(String ipAddress, String status) {
//        atmRepository.updateStatus(ipAddress, status);
//        System.out.println("Updating status in the database for " + ipAddress + " to " + status);
//    }
//
////    public static void main(String[] args) {
////        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
////        IPStatusChecker ipStatusChecker = context.getBean(IPStatusChecker.class);
////        ipStatusChecker.checkAndUpdateStatus();
////    }
//}
//
