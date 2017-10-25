package us.dot.its.jpo.ode.plugin.j2735;

import us.dot.its.jpo.ode.plugin.asn1.Asn1Object;

public class DdsAdvisoryDetails extends Asn1Object {
   private static final long serialVersionUID = 8964772115424427026L;

   public enum AdvisoryBroadcastType {
      spatAggregate, //  (0),
      map,           //  (1),
      tim,           //  (2),
      ev             //  (3),
   }

   public enum DistributionType {
      none, //(0),  "00000000", not intended for redistribution
      rsu,  //(1),  "00000001", intended for redistribution over DSRC
      ip    //(2),  "00000010"  intended for redistribution over IP
   }
   
   String asdmID;                   //         DSRC.TemporaryID,
   AdvisoryBroadcastType asdmType;  //    AdvisoryBroadcastType,
   int distType;                    //0, 1 or 2    ,
   J2735DFullTime startTime;        //OPTIONAL,
   J2735DFullTime stopTime;         //OPTIONAL,
   String advisoryMessage;          //  OCTET STRING (SIZE(0..1400))  -- Encoded advisory message


   public DdsAdvisoryDetails() {
      super();
   }

   
   public String getAsdmID() {
      return asdmID;
   }
   
   public DdsAdvisoryDetails(String asdmID, AdvisoryBroadcastType asdmType, int distType, J2735DFullTime startTime,
         J2735DFullTime stopTime, String advisoryMessage) {
      super();
      this.asdmID = asdmID;
      this.asdmType = asdmType;
      this.distType = distType;
      this.startTime = startTime;
      this.stopTime = stopTime;
      this.advisoryMessage = advisoryMessage;
   }

   public DdsAdvisoryDetails(String id, AdvisoryBroadcastType tim, byte[] distroType, J2735DFullTime dStartTime,
         J2735DFullTime dStopTime, String advisoryMessage2) {
      // TODO Auto-generated constructor stub
   }


   public void setAsdmID(String asdmID) {
      this.asdmID = asdmID;
   }
   public AdvisoryBroadcastType getAsdmType() {
      return asdmType;
   }
   public void setAsdmType(AdvisoryBroadcastType asdmType) {
      this.asdmType = asdmType;
   }
   public int getDistType() {
      return distType;
   }
   public void setDistType(int distType) {
      this.distType = distType;
   }
   public J2735DFullTime getStartTime() {
      return startTime;
   }
   public void setStartTime(J2735DFullTime startTime) {
      this.startTime = startTime;
   }
   public J2735DFullTime getStopTime() {
      return stopTime;
   }
   public void setStopTime(J2735DFullTime stopTime) {
      this.stopTime = stopTime;
   }
   public String getAdvisoryMessage() {
      return advisoryMessage;
   }
   public void setAdvisoryMessage(String advisoryMessage) {
      this.advisoryMessage = advisoryMessage;
   }
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((advisoryMessage == null) ? 0 : advisoryMessage.hashCode());
      result = prime * result + ((asdmID == null) ? 0 : asdmID.hashCode());
      result = prime * result + ((asdmType == null) ? 0 : asdmType.hashCode());
      result = prime * result + distType;
      result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
      result = prime * result + ((stopTime == null) ? 0 : stopTime.hashCode());
      return result;
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      DdsAdvisoryDetails other = (DdsAdvisoryDetails) obj;
      if (advisoryMessage == null) {
         if (other.advisoryMessage != null)
            return false;
      } else if (!advisoryMessage.equals(other.advisoryMessage))
         return false;
      if (asdmID == null) {
         if (other.asdmID != null)
            return false;
      } else if (!asdmID.equals(other.asdmID))
         return false;
      if (asdmType != other.asdmType)
         return false;
      if (distType != other.distType)
         return false;
      if (startTime == null) {
         if (other.startTime != null)
            return false;
      } else if (!startTime.equals(other.startTime))
         return false;
      if (stopTime == null) {
         if (other.stopTime != null)
            return false;
      } else if (!stopTime.equals(other.stopTime))
         return false;
      return true;
   }
   
   
}
