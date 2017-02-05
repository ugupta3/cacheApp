package com.cache;

import java.util.concurrent.TimeUnit;

/**
 * Created by umam on 2/5/17.
 */
public class CacheBuilder<K, V> {

   private static final int DEFAULT_INITIAL_CAPACITY = 16;
   private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
   private static final int DEFAULT_EXPIRATION_MILLI = 10;
   private static final int DEFAULT_CLEANUP_FREQUENCY = 5;
   private static final float LOAD_FACTOR = 0.75f;
   private int initialCapacity;
   private int concurrencyLevel;
   private long timeToLive;
   private int cleanUpFrequency;
   private float loadFactor;
   private TimeUnit timeUnit;

   public CacheBuilder() {
      concurrencyLevel = DEFAULT_CONCURRENCY_LEVEL;
      initialCapacity = DEFAULT_INITIAL_CAPACITY;
      timeToLive = DEFAULT_EXPIRATION_MILLI;
      cleanUpFrequency = DEFAULT_CLEANUP_FREQUENCY;
      loadFactor = LOAD_FACTOR;
      timeUnit = TimeUnit.SECONDS;
   }

   public CacheBuilder<K, V> initialCapacity(int initialCapacity) {

      if (initialCapacity > 0) {
         this.initialCapacity = initialCapacity;
      }
      return this;
   }

   public CacheBuilder<K, V> concurrencyLevel(int concurrencyLevel) {

      if (concurrencyLevel > 0) {
         this.concurrencyLevel = concurrencyLevel;
      }
      return this;
   }

   CacheBuilder<K, V> timeToLive(long duration) {

      if (duration > 0) {
         this.timeToLive = timeUnit.toMillis(duration);
      }
      return this;

   }

   CacheBuilder<K, V> loadFactor(float loadFactor) {

      if (loadFactor > 0.0f) {
         this.loadFactor = loadFactor;
      }
      return this;
   }

   CacheBuilder<K, V> timUnit(TimeUnit timeUnit) {

      if (timeUnit != null) {
         this.timeUnit = timeUnit;
      }
      return this;
   }

   CacheBuilder<K, V> cleanUpFrequency(int cleanUpFrequency) {

      if (cleanUpFrequency > 0) {
         this.cleanUpFrequency = cleanUpFrequency;
      }
      return this;
   }

   public InMemoryCache<K, V> build() {

      return new InMemoryCache<K, V>(initialCapacity, concurrencyLevel, timeToLive, cleanUpFrequency, loadFactor,
                        timeUnit);

   }
}
