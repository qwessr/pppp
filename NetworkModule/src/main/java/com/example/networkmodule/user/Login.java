package com.example.networkmodule.user;

import com.example.networkmodule.common.CheckInternet;
import com.example.networkmodule.common.MyAsyncTask;
import com.example.networkmodule.common.MyResponseCollback;
import com.example.networkmodule.common.Settings;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login extends MyAsyncTask {
    String email,password;
    public Login(String email,String password, CheckInternet checkInternet, MyResponseCollback collback) {
        super(checkInternet, collback);
        this.email = email;
        this.password = password;
    }

    @Override
    protected String doInbackground(Void... voids) {
        if(!checkInternet.isMobileConnection()&& checkInternet.isWiFiConnection())
        return "Error: no connection internet";

        Map<String,String>Params= new HashMap<>();
        Params.put("email",email);
        Params.put("password",password);

        try {
            Connection.Response response = Jsoup.connect(Settings.Url+"user/login")
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .method(Connection.Method.POST)
                    .data(Params)
                    .execute();

            if (response.statusCode()==200)
                return response.body();
            else return "Error "+response.body();
        }catch (IOException e){
            return "Error "+ e.getMessage();
        }


    }
}
