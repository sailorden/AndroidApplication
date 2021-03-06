package hk.ust.cse.com4521.escort_app.apiservices.model;
/**
 * Created by SGHAIER on 26/04/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;



public class PatientMeetingPosting {

    @SerializedName("userID")
    @Expose
    private String userID;
    @SerializedName("meetingDate")
    @Expose
    private String meetingDate;
    @SerializedName("meetingTimeStart")
    @Expose
    private Integer meetingTimeStart;
    @SerializedName("meetingDuration")
    @Expose
    private Integer meetingDuration;
    @SerializedName("district")
    @Expose
    private Integer district;
    @SerializedName("specialNeeds")
    @Expose
    private String specialNeeds;
    @SerializedName("dialect")
    @Expose
    private List<Integer> dialect = new ArrayList<Integer>();
    @SerializedName("wheelchair")
    @Expose
    private Boolean wheelchair;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     *
     * @return
     * The userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     *
     * @param userID
     * The userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
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



