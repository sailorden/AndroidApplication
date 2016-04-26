package hk.ust.cse.com4521.escort_app.apiservices.model;

/**
 * Created by SGHAIER on 26/04/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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
        @SerializedName("id")
        @Expose
        private String id;

        /**
         * @return The escortUserId
         */
        public String getEscortUserId() {
            return escortUserId;
        }

        /**
         * @param escortUserId The escortUserId
         */
        public void setEscortUserId(String escortUserId) {
            this.escortUserId = escortUserId;
        }

        /**
         * @return The staffId
         */
        public String getStaffId() {
            return staffId;
        }

        /**
         * @param staffId The staffId
         */
        public void setStaffId(String staffId) {
            this.staffId = staffId;
        }

        /**
         * @return The receiptRefNum
         */
        public String getReceiptRefNum() {
            return receiptRefNum;
        }

        /**
         * @param receiptRefNum The receiptRefNum
         */
        public void setReceiptRefNum(String receiptRefNum) {
            this.receiptRefNum = receiptRefNum;
        }

        /**
         * @return The doctorAdvice
         */
        public String getDoctorAdvice() {
            return doctorAdvice;
        }

        /**
         * @param doctorAdvice The doctorAdvice
         */
        public void setDoctorAdvice(String doctorAdvice) {
            this.doctorAdvice = doctorAdvice;
        }

        /**
         * @return The status
         */
        public Integer getStatus() {
            return status;
        }

        /**
         * @param status The status
         */
        public void setStatus(Integer status) {
            this.status = status;
        }

        /**
         * @return The patientUserId
         */
        public String getPatientUserId() {
            return patientUserId;
        }

        /**
         * @param patientUserId The patientUserId
         */
        public void setPatientUserId(String patientUserId) {
            this.patientUserId = patientUserId;
        }

        /**
         * @return The PatientMeetingPostingID
         */
        public String getPatientMeetingPostingID() {
            return PatientMeetingPostingID;
        }

        /**
         * @param PatientMeetingPostingID The PatientMeetingPostingID
         */
        public void setPatientMeetingPostingID(String PatientMeetingPostingID) {
            this.PatientMeetingPostingID = PatientMeetingPostingID;
        }

        /**
         * @return The id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(String id) {
            this.id = id;
        }

    }

