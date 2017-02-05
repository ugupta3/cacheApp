package com.cache;

/**
 * Created by umam on 2/5/17.
 */
class CacheObject<V> {
   private long lastAccessed;
   private V value;

   protected CacheObject() {
      this.lastAccessed = System.currentTimeMillis();
   }

   public void setValue(V value) {
      this.value = value;
   }

   public void setLastAccessed(long lastAccessed) {
      this.lastAccessed = lastAccessed;
   }

   public long getLastAccessed() {
      return lastAccessed;
   }

   public V getValue() {
      return value;
   }

   public boolean isExpired(long timeToLive) {
      return System.currentTimeMillis() - getLastAccessed() >= timeToLive;
   }
}
