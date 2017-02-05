package com.entity;

import java.util.Date;

/**
 * Created by umam on 2/6/17.
 */
public class RefCountry {
   private int countryId;
   private String countryCd;
   private String countryName;
   private int statusInd;
   private Date lastModifyDt;
   private int modifyPersonNum;

   public RefCountry(int countryId, String countryCd, String countryName, int statusInd, Date lastModifyDt,
                     int modifyPersonNum) {
      this.countryId = countryId;
      this.countryCd = countryCd;
      this.countryName = countryName;
      this.statusInd = statusInd;
      this.lastModifyDt = lastModifyDt;
      this.modifyPersonNum = modifyPersonNum;
   }

   public int getCountryId() {
      return countryId;
   }

   public String getCountryCd() {
      return countryCd;
   }

   public String getCountryName() {
      return countryName;
   }

   public int getStatusInd() {
      return statusInd;
   }

   public Date getLastModifyDt() {
      return lastModifyDt;
   }

   public int getModifyPersonNum() {
      return modifyPersonNum;
   }

   public String getCacheKey() {
      return "REF_COUNTRY" + "_" + countryId;
   }

   @Override public String toString() {
      return "RefCountry{" + "countryId=" + countryId + ", countryCd='" + countryCd + '\'' + ", countryName='"
                        + countryName + '\'' + ", statusInd=" + statusInd + ", lastModifyDt=" + lastModifyDt
                        + ", modifyPersonNum=" + modifyPersonNum + '}';
   }
}
