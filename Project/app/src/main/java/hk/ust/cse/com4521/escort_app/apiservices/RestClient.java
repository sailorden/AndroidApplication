package hk.ust.cse.com4521.escort_app.apiservices;

import java.util.List;

import hk.ust.cse.com4521.escort_app.apiservices.service.APIService;

/**
 * Created by SGHAIER on 25/04/16.
 */
public class RestClient {
    private static RestClient instance = null;

    //private ResultReadyCallback callback;

    private static final String BASE_URL = "http://....";
    private APIService service;




    public static RestClient getInstance() {
        if(instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    /*public interface ResultReadyCallback {
        public void resultReady(List<User> users);
    }*/

}
