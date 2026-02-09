package com.example.networkmodule;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

import com.example.networkmodule.common.CheckInternet;
import com.example.networkmodule.common.MyResponseCollback;
import com.example.networkmodule.models.User;
import com.example.networkmodule.user.UserCreate;

import java.util.concurrent.CountDownLatch;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExampleInstrumentedTest {
    static String TOKEN;
    static String PASS = "password123";
    private static String SAVED_EMAIL = null;
    private static String SAVED_TOKEN = null;

    CheckInternet getNet(){
        return new CheckInternet(InstrumentationRegistry.getInstrumentation().getTargetContext());
    }
    @Test
    public void Test_1_Login()throws Exception{
        SAVED_EMAIL = "user"+System.currentTimeMillis()+"@test.ru";


        User u = new User();
        u.email = SAVED_EMAIL;
        u.password = PASS;
        u.firstname = "Test";
        u.lastname = "User";
        u.surname = "Testovich";
        u.dateOfBirth = "2000-01-01T00:00:00";
        u.gender = 1;

        CountDownLatch signal = new CountDownLatch(1);
        final boolean[] success ={false};

        new UserCreate(u,getNet(),new MyResponseCollback(){
            @Override
            public void onConpile(String res) {
                success[0]=true;
                signal.countDown();}
            @Override
            public void onError(String err){signal.countDown();}
        }).execute();

        signal.await();


    }

}