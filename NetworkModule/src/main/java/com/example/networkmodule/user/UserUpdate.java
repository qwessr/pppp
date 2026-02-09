package com.example.networkmodule.user;

import com.example.networkmodule.common.CheckInternet;
import com.example.networkmodule.common.MyAsyncTask;
import com.example.networkmodule.common.MyResponseCollback;
import com.example.networkmodule.common.Settings;
import com.example.networkmodule.models.User;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserUpdate extends MyAsyncTask {
    String token;
    User user;
    public UserUpdate(String token, User user,CheckInternet checkInternet, MyResponseCollback collback) {
        super(checkInternet, collback);
        this.token = token;
        this.user = user;
    }

    @Override
    protected String doInbackground(Void... voids) {
        if (!checkInternet.isWiFiConnection() && !checkInternet.isMobileConnection())
            return "Error: no connection internet";
        Map<String,String> Params = new HashMap<>();
        Params.put("Email",user.email);
        Params.put("Password",user.password);
        Params.put("Firstname",user.firstname);
        Params.put("Lastname",user.lastname);
        Params.put("Surname",user.surname);
        Params.put("DateOfBirth",user.dateOfBirth);
        Params.put("Gender",user.gender.toString());

        try {
            Connection.Response response = Jsoup.connect(Settings.Url + "user/update")
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .data(Params)
                    .method(Connection.Method.PUT)
                    .header("token", token)
                    .execute();

            if (response.statusCode() == 200)
                return response.body();
            else return "Error " + response.body();
        } catch (IOException e) {
            return "Error " + e.getMessage();
        }
    }
}
