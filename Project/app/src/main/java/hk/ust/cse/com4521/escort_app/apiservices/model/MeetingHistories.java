package hk.ust.cse.com4521.escort_app.apiservices.model;

/**
 * Created by SGHAIER on 26/04/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class MeetingHistories {

        @SerializedName("receiptRefNum")
        @Expose
        private String receiptRefNum;
        @SerializedName("doctorAdvice")
        @Expose
        private String doctorAdvice;
        @SerializedName("status")
        @Expose
        private Integer status;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("PatientMeetingPostingID")
        @Expose
        private String PatientMeetingPostingID;
        @SerializedName("staffID")
        @Expose
        private String staffID;
        @SerializedName("patientID")
        @Expose
        private String patientID;
        @SerializedName("escortID")
        @Expose
        private String escortID;
        public UserAccount patient;
        public UserAccount escort;
        public UserAccount staff;
        public PatientMeetingPosting PatientMeetingPosting;


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
         * The staffID
         */
        public String getStaffID() {
                return staffID;
        }

        /**
         *
         * @param staffID
         * The staffID
         */
        public void setStaffID(String staffID) {
                this.staffID = staffID;
        }

        /**
         *
         * @return
         * The patientID
         */
        public String getPatientID() {
                return patientID;
        }

        /**
         *
         * @param patientID
         * The patientID
         */
        public void setPatientID(String patientID) {
                this.patientID = patientID;
        }

        /**
         *
         * @return
         * The escortID
         */
        public String getEscortID() {
                return escortID;
        }

        /**
         *
         * @param escortID
         * The escortID
         */
        public void setEscortID(String escortID) {
                this.escortID = escortID;
        }

  

}


