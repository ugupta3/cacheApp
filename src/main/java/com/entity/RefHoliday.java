package com.entity;

import java.util.Date;

/**
 * Created by umam on 2/6/17.
 */

public class RefHoliday {

   private int holidayId;
   private String holidayCd;
   private String holidayName;
   private Date holidayDt;
   private int statusInd;
   private Date lastModifyDt;
   private int modifyPersonNum;

   public RefHoliday(int holidayId, String holidayCd, String holidayName, Date holidayDt, int statusInd,
                     Date lastModifyDt, int modifyPersonNum) {
      this.holidayId = holidayId;
      this.holidayCd = holidayCd;
      this.holidayName = holidayName;
      this.holidayDt = holidayDt;
      this.statusInd = statusInd;
      this.lastModifyDt = lastModifyDt;
      this.modifyPersonNum = modifyPersonNum;
   }

   public int getHolidayId() {
      return holidayId;
   }

   public String getHolidayCd() {
      return holidayCd;
   }

   public String getHolidayName() {
      return holidayName;
   }

   public Date getHolidayDt() {
      return holidayDt;
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
      return "REF_HOLIDAY_" + holidayId;
   }

   @Override public String toString() {
      return "RefHoliday{" + "holidayId=" + holidayId + ", holidayCd='" + holidayCd + '\'' + ", holidayName='"
                        + holidayName + '\'' + ", holidayDt=" + holidayDt + ", statusInd=" + statusInd
                        + ", lastModifyDt=" + lastModifyDt + ", modifyPersonNum=" + modifyPersonNum + '}';
   }
}
