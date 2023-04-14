package com.example.mongodbreactive.util;

import com.example.mongodbreactive.model.AddressModel;
import com.example.mongodbreactive.model.CustomerModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class TemplateDatabaseLoader {
//    @Bean
    CommandLineRunner initialize(MongoOperations mongo) {
        return args -> {
            mongo.save(new CustomerModel(null, "SOLT",
                    "solt@gmail.com", "S13",
                    new AddressModel("line1", "1113", "Ygn")));
            mongo.save(new CustomerModel(null, "LOLT",
                    "solt@gmail.com", "S33",
                    new AddressModel("line2", "1111", "mdy")));
            mongo.save(new CustomerModel(null, "POLT",
                    "solt@gmail.com", "S43",
                    new AddressModel("line3", "11311", "Tgn")));
        };
    }
}
