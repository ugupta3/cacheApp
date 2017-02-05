package com.util;

import com.cache.CacheManager;
import com.entity.RefCountry;
import com.entity.RefCurrency;
import com.entity.RefHoliday;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by umam on 2/6/17.
 */
@Component public class DataLoader {

   private CacheManager cacheManager;
   private static final Logger logger = LoggerFactory.getLogger(DataLoader.class);

   @Autowired public DataLoader(CacheManager cacheManager) {
      this.cacheManager = cacheManager;
   }

   public void loadDataIntoCache() {
      logger.info("loading ref table data");
      loadCountries();
      loadCurrency();
      loadHolidays();
   }

   private void loadCountries() {
      RefCountry refCountry = new RefCountry(1, "countryCd", "IND", 1, new Date(), 222);
      cacheManager.put(refCountry.getCacheKey(), refCountry);
   }

   private void loadCurrency() {

      RefCurrency refCurrency = new RefCurrency(11, "currCd", "USR", "$", 1, new Date(), 222);
      cacheManager.put(refCurrency.getCacheKey(), refCurrency);

   }

   private void loadHolidays() {
      RefHoliday refHoliday = new RefHoliday(111, "holidayCd", "New Year", new Date(), 1, new Date(), 222);
      cacheManager.put(refHoliday.getCacheKey(), refHoliday);
   }

}
