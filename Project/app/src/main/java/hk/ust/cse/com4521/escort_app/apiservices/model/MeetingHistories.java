package hk.ust.cse.com4521.escort_app.apiservices.model;

/**
 * Created by SGHAIER on 26/04/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class MeetingHistories {



        @SerializedName("escortUserId")
        @Expose
        private String escortUserId;
        @SerializedName("staffId")
        @Expose
        private String staffId;
        @SerializedName("receiptRefNum")
        @Expose
        private String receiptRefNum;
        @SerializedName("doctorAdvice")
        @Expose
        private String doctorAdvice;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("patientUserId")
        @Expose
        private String patientUserId;
        @SerializedName("PatientMeetingPostingID")
        @Expose
        private String PatientMeetingPostingID;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("specialNeeds")
        @Expose
        private String specialNeeds;
        @SerializedName("wheelchair")
        @Expose
        private Boolean wheelchair;
        @SerializedName("meetingDuration")
        @Expose
        private Integer meetingDuration;
        @SerializedName("meetingTimeStart")
        @Expose
        private Integer meetingTimeStart;
        @SerializedName("meetingDate")
        @Expose
        private String meetingDate;
        @SerializedName("district")
        @Expose
        private Integer district;
        @SerializedName("dialect")
        @Expose
        private List<Integer> dialect = new ArrayList<Integer>();
        @SerializedName("id")
        @Expose
        private String id;

        /**
         *
         * @return
         * The escortUserId
         */
        public String getEscortUserId() {
            return escortUserId;
        }

        /**
         *
         * @param escortUserId
         * The escortUserId
         */
        public void setEscortUserId(String escortUserId) {
            this.escortUserId = escortUserId;
        }

        /**
         *
         * @return
         * The staffId
         */
        public String getStaffId() {
            return staffId;
        }

        /**
         *
         * @param staffId
         * The staffId
         */
        public void setStaffId(String staffId) {
            this.staffId = staffId;
        }

        /**
         *
         * @return
         * The receiptRefNum
         */
        public String getReceiptRefNum() {
            return receiptRefNum;
        }

        /**
         *
         * @param receiptRefNum
         * The receiptRefNum
         */
        public void setReceiptRefNum(String receiptRefNum) {
            this.receiptRefNum = receiptRefNum;
        }

        /**
         *
         * @return
         * The doctorAdvice
         */
        public String getDoctorAdvice() {
            return doctorAdvice;
        }

        /**
         *
         * @param doctorAdvice
         * The doctorAdvice
         */
        public void setDoctorAdvice(String doctorAdvice) {
            this.doctorAdvice = doctorAdvice;
        }

        /**
         *
         * @return
         * The status
         */
        public Integer getStatus() {
            return status;
        }

        /**
         *
         * @param status
         * The status
         */
        public void setStatus(Integer status) {
            this.status = status;
        }

        /**
         *
         * @return
         * The patientUserId
         */
        public String getPatientUserId() {
            return patientUserId;
        }

        /**
         *
         * @param patientUserId
         * The patientUserId
         */
        public void setPatientUserId(String patientUserId) {
            this.patientUserId = patientUserId;
        }

        /**
         *
         * @return
         * The PatientMeetingPostingID
         */
        public String getPatientMeetingPostingID() {
            return PatientMeetingPostingID;
        }

        /**
         *
         * @param PatientMeetingPostingID
         * The PatientMeetingPostingID
         */
        public void setPatientMeetingPostingID(String PatientMeetingPostingID) {
            this.PatientMeetingPostingID = PatientMeetingPostingID;
        }

        /**
         *
         * @return
         * The location
         */
        public String getLocation() {
            return location;
        }

        /**
         *
         * @param location
         * The location
         */
        public void setLocation(String location) {
            this.location = location;
        }

        /**
         *
         * @return
         * The specialNeeds
         */
        public String getSpecialNeeds() {
            return specialNeeds;
        }

        /**
         *
         * @param specialNeeds
         * The specialNeeds
         */
        public void setSpecialNeeds(String specialNeeds) {
            this.specialNeeds = specialNeeds;
        }

        /**
         *
         * @return
         * The wheelchair
         */
        public Boolean getWheelchair() {
            return wheelchair;
        }

        /**
         *
         * @param wheelchair
         * The wheelchair
         */
        public void setWheelchair(Boolean wheelchair) {
            this.wheelchair = wheelchair;
        }

        /**
         *
         * @return
         * The meetingDuration
         */
        public Integer getMeetingDuration() {
            return meetingDuration;
        }

        /**
         *
         * @param meetingDuration
         * The meetingDuration
         */
        public void setMeetingDuration(Integer meetingDuration) {
            this.meetingDuration = meetingDuration;
        }

        /**
         *
         * @return
         * The meetingTimeStart
         */
        public Integer getMeetingTimeStart() {
            return meetingTimeStart;
        }

        /**
         *
         * @param meetingTimeStart
         * The meetingTimeStart
         */
        public void setMeetingTimeStart(Integer meetingTimeStart) {
            this.meetingTimeStart = meetingTimeStart;
        }

        /**
         *
         * @return
         * The meetingDate
         */
        public String getMeetingDate() {
            return meetingDate;
        }

        /**
         *
         * @param meetingDate
         * The meetingDate
         */
        public void setMeetingDate(String meetingDate) {
            this.meetingDate = meetingDate;
        }

        /**
         *
         * @return
         * The district
         */
        public Integer getDistrict() {
            return district;
        }

        /**
         *
         * @param district
         * The district
         */
        public void setDistrict(Integer district) {
            this.district = district;
        }

        /**
         *
         * @return
         * The dialect
         */
        public List<Integer> getDialect() {
            return dialect;
        }

        /**
         *
         * @param dialect
         * The dialect
         */
        public void setDialect(List<Integer> dialect) {
            this.dialect = dialect;
        }

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

  

}


