package com.example.networkmodule.user;

import com.example.networkmodule.common.CheckInternet;
import com.example.networkmodule.common.MyAsyncTask;
import com.example.networkmodule.common.MyResponseCollback;
import com.example.networkmodule.common.Settings;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class UserGet extends MyAsyncTask {
    String token;
    public UserGet(String token, CheckInternet checkInternet, MyResponseCollback collback) {
        super(checkInternet, collback);
        this.token = token;
    }

    @Override
    protected String doInbackground(Void... voids) {
    if (!checkInternet.isWiFiConnection()&&!checkInternet.isMobileConnection())
        return "Error: no connection internet";

        try{
            Connection.Response response = Jsoup.connect(Settings.Url+"user/get")
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .method(Connection.Method.GET)
                    .header("token",token)
                    .execute();

            if (response.statusCode()==200)
                return response.body();
            else return "Error "+response.body();
        }catch (IOException e){
            return "Error "+e.getMessage();
        }
    }
}
