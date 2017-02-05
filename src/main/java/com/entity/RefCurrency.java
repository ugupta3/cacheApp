package com.entity;

import java.util.Date;

/**
 * Created by umam on 2/6/17.
 */
public class RefCurrency {
   private int currId;
   private String currCd;
   private String currName;
   private String currencySymbol;
   private int statusInd;
   private Date lastModifyDt;
   private int modifyPersonNum;

   public RefCurrency(int currId, String currCd, String currName, String currencySymbol, int statusInd,
                     Date lastModifyDt, int modifyPersonNum) {
      this.currId = currId;
      this.currCd = currCd;
      this.currName = currName;
      this.currencySymbol = currencySymbol;
      this.statusInd = statusInd;
      this.lastModifyDt = lastModifyDt;
      this.modifyPersonNum = modifyPersonNum;
   }

   public int getCurrId() {
      return currId;
   }

   public String getCurrCd() {
      return currCd;
   }

   public String getCurrName() {
      return currName;
   }

   public String getCurrencySymbol() {
      return currencySymbol;
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

   public  String getCacheKey()
   {
      return  "REF_CURRENCY_"+currId;
   }

   @Override public String toString() {
      return "RefCurrency{" + "currId=" + currId + ", currCd='" + currCd + '\'' + ", currName='" + currName + '\''
                        + ", currencySymbol='" + currencySymbol + '\'' + ", statusInd=" + statusInd + ", lastModifyDt="
                        + lastModifyDt + ", modifyPersonNum=" + modifyPersonNum + '}';
   }
}
