package hk.ust.cse.com4521.escort_app.apiservices.model;

/**
 * Created by SGHAIER on 25/04/16.
 * Modified by TANG on 08/05/16.
 */


        import java.util.ArrayList;
        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;
        import com.squareup.okhttp.Credentials;


public class UserAccount {

        @SerializedName("userId")
        @Expose
        private String userId;


        @SerializedName("password")
        @Expose
        private String password;

        @SerializedName("bankAccountNum")
        @Expose
        private String bankAccountNum;
        @SerializedName("chineseName")
        @Expose
        private String chineseName;
        @SerializedName("dateOfBirth")
        @Expose
        private String dateOfBirth;
        @SerializedName("dialect")
        @Expose
        private List<Integer> dialect = new ArrayList<Integer>();
        @SerializedName("escortAvaiTimeSlot")
        @Expose
        private List<Integer> escortAvaiTimeSlot = new ArrayList<Integer>();
        @SerializedName("escortPreferLocation")
        @Expose
        private String escortPreferLocation;
        @SerializedName("experience")
        @Expose
        private String experience;
        @SerializedName("firstAidCert")
        @Expose
        private Boolean firstAidCert;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("gender")
        @Expose
        private Integer gender;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("membershipNum")
        @Expose
        private String membershipNum;
        @SerializedName("occupation")
        @Expose
        private String occupation;
        @SerializedName("profilePicName")
        @Expose
        private String profilePicName;
        @SerializedName("residentialAddress")
        @Expose
        private String residentialAddress;
        @SerializedName("skills")
        @Expose
        private String skills;
        @SerializedName("telephoneNum")
        @Expose
        private String telephoneNum;
        @SerializedName("userRole")
        @Expose
        private Integer userRole;
        @SerializedName("userValidated")
        @Expose
        private Boolean userValidated;
        @SerializedName("weight")
        @Expose
        private Integer weight;
        @SerializedName("wheelChair")
        @Expose
        private Boolean wheelChair;
        @SerializedName("escortPreferLocationDistrict")
        @Expose
        private Integer escortPreferLocationDistrict;
        @SerializedName("realm")
        @Expose
        private String realm;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("credentials")
        @Expose
        private Credentials credentials;
        @SerializedName("challenges")
        @Expose
        private Challenges challenges;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("emailVerified")
        @Expose
        private Boolean emailVerified;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created")
        @Expose
        private String created;
        @SerializedName("lastUpdated")
        @Expose
        private String lastUpdated;
        @SerializedName("id")
        @Expose
        private String id;

        /**
         *
         * @return
         * The bankAccountNum
         */
        public String getBankAccountNum() {
            return bankAccountNum;
        }

        /**
         *
         * @param bankAccountNum
         * The bankAccountNum
         */
        public void setBankAccountNum(String bankAccountNum) {
            this.bankAccountNum = bankAccountNum;
        }

        /**
         *
         * @return
         * The chineseName
         */
        public String getChineseName() {
            return chineseName;
        }

        /**
         *
         * @param chineseName
         * The chineseName
         */
        public void setChineseName(String chineseName) {
            this.chineseName = chineseName;
        }

        /**
         *
         * @return
         * The dateOfBirth
         */
        public String getDateOfBirth() {
            return dateOfBirth;
        }

        /**
         *
         * @param dateOfBirth
         * The dateOfBirth
         */
        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
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
         * The escortAvaiTimeSlot
         */
        public List<Integer> getEscortAvaiTimeSlot() {
            return escortAvaiTimeSlot;
        }

        /**
         *
         * @param escortAvaiTimeSlot
         * The escortAvaiTimeSlot
         */
        public void setEscortAvaiTimeSlot(List<Integer> escortAvaiTimeSlot) {
            this.escortAvaiTimeSlot = escortAvaiTimeSlot;
        }

        /**
         *
         * @return
         * The escortPreferLocation
         */
        public String getEscortPreferLocation() {
            return escortPreferLocation;
        }

        /**
         *
         * @param escortPreferLocation
         * The escortPreferLocation
         */
        public void setEscortPreferLocation(String escortPreferLocation) {
            this.escortPreferLocation = escortPreferLocation;
        }

        /**
         *
         * @return
         * The experience
         */
        public String getExperience() {
            return experience;
        }

        /**
         *
         * @param experience
         * The experience
         */
        public void setExperience(String experience) {
            this.experience = experience;
        }

        /**
         *
         * @return
         * The firstAidCert
         */
        public Boolean getFirstAidCert() {
            return firstAidCert;
        }

        /**
         *
         * @param firstAidCert
         * The firstAidCert
         */
        public void setFirstAidCert(Boolean firstAidCert) {
            this.firstAidCert = firstAidCert;
        }

        /**
         *
         * @return
         * The firstName
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         *
         * @param firstName
         * The firstName
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         *
         * @return
         * The gender
         */
        public Integer getGender() {
            return gender;
        }

        /**
         *
         * @param gender
         * The gender
         */
        public void setGender(Integer gender) {
            this.gender = gender;
        }

        /**
         *
         * @return
         * The height
         */
        public Integer getHeight() {
            return height;
        }

        /**
         *
         * @param height
         * The height
         */
        public void setHeight(Integer height) {
            this.height = height;
        }

        /**
         *
         * @return
         * The lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         *
         * @param lastName
         * The lastName
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         *
         * @return
         * The membershipNum
         */
        public String getMembershipNum() {
            return membershipNum;
        }

        /**
         *
         * @param membershipNum
         * The membershipNum
         */
        public void setMembershipNum(String membershipNum) {
            this.membershipNum = membershipNum;
        }

        /**
         *
         * @return
         * The occupation
         */
        public String getOccupation() {
            return occupation;
        }

        /**
         *
         * @param occupation
         * The occupation
         */
        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        /**
         *
         * @return
         * The profilePicName
         */
        public String getProfilePicName() {
            return profilePicName;
        }

        /**
         *
         * @param profilePicName
         * The profilePicName
         */
        public void setProfilePicName(String profilePicName) {
            this.profilePicName = profilePicName;
        }

        /**
         *
         * @return
         * The residentialAddress
         */
        public String getResidentialAddress() {
            return residentialAddress;
        }

        /**
         *
         * @param residentialAddress
         * The residentialAddress
         */
        public void setResidentialAddress(String residentialAddress) {
            this.residentialAddress = residentialAddress;
        }

        /**
         *
         * @return
         * The skills
         */
        public String getSkills() {
            return skills;
        }

        /**
         *
         * @param skills
         * The skills
         */
        public void setSkills(String skills) {
            this.skills = skills;
        }

        /**
         *
         * @return
         * The telephoneNum
         */
        public String getTelephoneNum() {
            return telephoneNum;
        }

        /**
         *
         * @param telephoneNum
         * The telephoneNum
         */
        public void setTelephoneNum(String telephoneNum) {
            this.telephoneNum = telephoneNum;
        }

        /**
         *
         * @return
         * The userRole
         */
        public Integer getUserRole() {
            return userRole;
        }

        /**
         *
         * @param userRole
         * The userRole
         */
        public void setUserRole(Integer userRole) {
            this.userRole = userRole;
        }

        /**
         *
         * @return
         * The userValidated
         */
        public Boolean getUserValidated() {
            return userValidated;
        }

        /**
         *
         * @param userValidated
         * The userValidated
         */
        public void setUserValidated(Boolean userValidated) {
            this.userValidated = userValidated;
        }

        /**
         *
         * @return
         * The weight
         */
        public Integer getWeight() {
            return weight;
        }

        /**
         *
         * @param weight
         * The weight
         */
        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        /**
         *
         * @return
         * The wheelChair
         */
        public Boolean getWheelChair() {
            return wheelChair;
        }

        /**
         *
         * @param wheelChair
         * The wheelChair
         */
        public void setWheelChair(Boolean wheelChair) {
            this.wheelChair = wheelChair;
        }

        /**
         *
         * @return
         * The escortPreferLocationDistrict
         */
        public Integer getEscortPreferLocationDistrict() {
            return escortPreferLocationDistrict;
        }

        /**
         *
         * @param escortPreferLocationDistrict
         * The escortPreferLocationDistrict
         */
        public void setEscortPreferLocationDistrict(Integer escortPreferLocationDistrict) {
            this.escortPreferLocationDistrict = escortPreferLocationDistrict;
        }

        /**
         *
         * @return
         * The realm
         */
        public String getRealm() {
            return realm;
        }

        /**
         *
         * @param realm
         * The realm
         */
        public void setRealm(String realm) {
            this.realm = realm;
        }

        /**
         *
         * @return
         * The username
         */
        public String getUsername() {
            return username;
        }

        /**
         *
         * @param username
         * The username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         *
         * @return
         * The credentials
         */
        public Credentials getCredentials() {
            return credentials;
        }

        /**
         *
         * @param credentials
         * The credentials
         */
        public void setCredentials(Credentials credentials) {
            this.credentials = credentials;
        }

        /**
         *
         * @return
         * The challenges
         */
        public Challenges getChallenges() {
            return challenges;
        }

        /**
         *
         * @param challenges
         * The challenges
         */
        public void setChallenges(Challenges challenges) {
            this.challenges = challenges;
        }

        /**
         *
         * @return
         * The email
         */
        public String getEmail() {
            return email;
        }

        /**
         *
         * @param email
         * The email
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         *
         * @return
         * The emailVerified
         */
        public Boolean getEmailVerified() {
            return emailVerified;
        }

        /**
         *
         * @param emailVerified
         * The emailVerified
         */
        public void setEmailVerified(Boolean emailVerified) {
            this.emailVerified = emailVerified;
        }

        /**
         *
         * @return
         * The status
         */
        public String getStatus() {
            return status;
        }

        /**
         *
         * @param status
         * The status
         */
        public void setStatus(String status) {
            this.status = status;
        }

        /**
         *
         * @return
         * The created
         */
        public String getCreated() {
            return created;
        }

        /**
         *
         * @param created
         * The created
         */
        public void setCreated(String created) {
            this.created = created;
        }

        /**
         *
         * @return
         * The lastUpdated
         */
        public String getLastUpdated() {
            return lastUpdated;
        }

        /**
         *
         * @param lastUpdated
         * The lastUpdated
         */
        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
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


    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }

        //for login
        public String getuserId() { return userId; }
}


