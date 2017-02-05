package com.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by umam on 2/5/17.
 */

@Component public class CacheManager<K, V> {

   private InMemoryCache<K, V> inMemoryCache;

   private Logger logger = LoggerFactory.getLogger(CacheManager.class);

   @Autowired public CacheManager() {
      this.inMemoryCache = new CacheBuilder().timUnit(TimeUnit.SECONDS).cleanUpFrequency(5).timeToLive(10).build();
   }

   public void put(K key, V value) {
      logger.info("adding cache" + key, value);
      inMemoryCache.put(key, value);
   }

   public V get(K key) {
      return inMemoryCache.get(key);
   }

   public int size() {
      return inMemoryCache.size();
   }

   public void evict(K key) {
      inMemoryCache.evict(key);
   }

   public void evictAll() {
      inMemoryCache.evictAll();
   }

}
