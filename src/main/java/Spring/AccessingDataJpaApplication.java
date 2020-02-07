//package Spring;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootApplication
//public class AccessingDataJpaApplication {
//
//    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
//
//    public static void main(String[] args) {
//        SpringApplication.run(AccessingDataJpaApplication.class, args);
//    }
//
//    @Bean
//    public CommandLineRunner demo(BuddyInfoRepository repository) {
//        return (args) -> {
//            // save a few customers
//            repository.save(new BuddyInfo("123 hi st.","joe",123));
//            repository.save(new BuddyInfo("321 bye st.","fred",321));
//            repository.save(new BuddyInfo("456 no st.","bill",456));
//
//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (BuddyInfo buddyInfo : repository.findAll()) {
//                log.info(buddyInfo.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            BuddyInfo buddyInfo = repository.findById(1);
//            log.info("Customer found with findById(1):");
//            log.info("--------------------------------");
//            log.info(buddyInfo.toString());
//            log.info("");
//
//            // fetch an individual customer by name
//            BuddyInfo buddyInfo2 = repository.findByName("bill");
//            log.info("Customer found with findByName(bill):");
//            log.info("--------------------------------");
//            log.info(buddyInfo2.toString());
//            log.info("");
//
//            // for (Customer bauer : repository.findByLastName("Bauer")) {
//            //  log.info(bauer.toString());
//            // }
//            log.info("");
//        };
//    }
//
//}
