package hk.ust.cse.com4521.escort_app.apiservices.model;

/**
 * Created by SGHAIER on 25/04/16.
 */


        import java.util.ArrayList;
        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;


public class UserAccount {

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
                @SerializedName("emailAddress")
                @Expose
                private String emailAddress;
                @SerializedName("emailValidated")
                @Expose
                private Boolean emailValidated;
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
                @SerializedName("password")
                @Expose
                private String password;
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
                @SerializedName("loginName")
                @Expose
                private String loginName;
                @SerializedName("escortPreferLocationDistrict")
                @Expose
                private Integer escortPreferLocationDistrict;
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
                 * The emailAddress
                 */
                public String getEmailAddress() {
                        return emailAddress;
                }

                /**
                 *
                 * @param emailAddress
                 * The emailAddress
                 */
                public void setEmailAddress(String emailAddress) {
                        this.emailAddress = emailAddress;
                }

                /**
                 *
                 * @return
                 * The emailValidated
                 */
                public Boolean getEmailValidated() {
                        return emailValidated;
                }

                /**
                 *
                 * @param emailValidated
                 * The emailValidated
                 */
                public void setEmailValidated(Boolean emailValidated) {
                        this.emailValidated = emailValidated;
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
                 * The password
                 */
                public String getPassword() {
                        return password;
                }

                /**
                 *
                 * @param password
                 * The password
                 */
                public void setPassword(String password) {
                        this.password = password;
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
                 * The loginName
                 */
                public String getLoginName() {
                        return loginName;
                }

                /**
                 *
                 * @param loginName
                 * The loginName
                 */
                public void setLoginName(String loginName) {
                        this.loginName = loginName;
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


