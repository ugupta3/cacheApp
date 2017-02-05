package com.cache;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by umam on 2/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class) @ContextConfiguration(classes = {
                  CacheManager.class }) public class InMemoryCacheTest {

   @Autowired CacheManager cacheManager;

   @Before public void setUp() {

      cacheManager.evictAll();
   }

   @Test public void testPut() {

      cacheManager.put("uma", 123);
      Assert.assertEquals(1, cacheManager.size());
   }

   @Test public void testGet() {
      cacheManager.put("abc", 456);
      Assert.assertEquals(456, cacheManager.get("abc"));

   }

   @Test public void testEvict() {
      cacheManager.put("uma", 123);
      Assert.assertEquals(1, cacheManager.size());
      cacheManager.evict("uma");
      Assert.assertEquals(0, cacheManager.size());
   }

   @Test public void testConcurrency() {
      List<Callable<Integer>> callables = new ArrayList<>();

      for (int i = 1; i < 21; i++) {
         callables.add(() -> {
            String threadName = Thread.currentThread().getName();
            cacheManager.put(UUID.randomUUID(), System.currentTimeMillis());
            return cacheManager.size();
         });
      }
      ExecutorService executor = Executors.newWorkStealingPool();
      try {

         executor.invokeAll(callables);
         executor.awaitTermination(10, TimeUnit.SECONDS);
      } catch (Throwable throwable) {
         throwable.printStackTrace();
      }
      Assert.assertEquals(20, cacheManager.size());
   }

}
