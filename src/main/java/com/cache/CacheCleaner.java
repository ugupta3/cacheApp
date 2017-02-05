package com.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

class CacheCleaner<K, V> extends Thread {

   private ConcurrentMap<K, V> cache;
   private long cleanUpFrequency;
   private long timeToLive;
   private TimeUnit timeUnit;
   private static final Logger logger = LoggerFactory.getLogger(CacheCleaner.class);

   public CacheCleaner(ConcurrentMap<K, V> map, long cleanUpFrequency, long timeToLive, TimeUnit timeUnit) {
      this.cache = map;
      this.cleanUpFrequency = cleanUpFrequency;
      this.timeToLive = timeToLive;
      this.timeUnit = timeUnit;
      setDaemon(true);
   }

   public void run() {
      if (this.timeToLive > 0 && this.cleanUpFrequency > 0) {
         while (true) {
            try {
               evictStaleData();
               logger.info("Sleeping for " + timeUnit.toMillis(cleanUpFrequency) +"millis");
               Thread.sleep(timeUnit.toMillis(cleanUpFrequency));
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }

         }
      }
   }

   public void evictStaleData() {

      logger.info("Evicting Stale Data");
      cache.keySet().parallelStream().forEach(key -> {
         CacheObject<V> cacheObject = (CacheObject) cache.get(key);
         if (cacheObject.isExpired(timeToLive)) {
            logger.info("Removing..." + cacheObject);
            cache.remove(key);
         }
      });
   }

}

