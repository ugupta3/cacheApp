package com.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class InMemoryCache<K, V> {

   private ConcurrentMap cache;
   private CacheCleaner cleaner;
   private long timeToLive;

   public InMemoryCache(int initialCapacity, int concurrencyLevel, long timeToLive, int cleanUpFrequency,
                     float loadFactor, TimeUnit timeUnit) {

      cache = new ConcurrentHashMap(initialCapacity, loadFactor, concurrencyLevel);
      cleaner = new CacheCleaner(cache, cleanUpFrequency, timeToLive, timeUnit);
      this.timeToLive = timeToLive;
      cleaner.start();
   }

   public void put(K key, V value) {
      CacheObject<V> cacheObject = new CacheObject<V>();
      cacheObject.setValue(value);
      cache.putIfAbsent(key, cacheObject);
   }

   public V get(K key) {
      CacheObject<V> c = (CacheObject) cache.get(key);
      if (c == null || c.isExpired(timeToLive))
         return null;
      else {
         c.setLastAccessed(System.currentTimeMillis());
         return c.getValue();
      }
   }

   public void evict(K key) {
      cache.remove(key);
   }

   public int size() {
      return cache.size();
   }

   public void evictAll() {
      cache.clear();
   }

}