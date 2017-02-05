package com;

import com.cache.CacheManager;
import com.entity.RefCountry;
import com.entity.RefCurrency;
import com.entity.RefHoliday;
import com.util.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication public class CacheAppApplication implements CommandLineRunner {

   @Autowired CacheManager cacheManager;
   @Autowired DataLoader dataLoader;
   private static final Logger logger = LoggerFactory.getLogger(CacheAppApplication.class);

   public static void main(String[] args) {
      SpringApplication.run(CacheAppApplication.class, args);
   }

   @Override public void run(String... args) throws Exception {
      dataLoader.loadDataIntoCache();
      logger.info("Country.." + cacheManager.get("REF_COUNTRY_1"));
      logger.info("Currency.." + cacheManager.get("REF_CURRENCY_11"));
      logger.info("Holiday.." + cacheManager.get("REF_HOLIDAY_111"));
      Thread.sleep(15000);
   }
}
