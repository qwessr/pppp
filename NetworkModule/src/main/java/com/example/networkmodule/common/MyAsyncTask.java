package com.example.networkmodule.common;

import android.os.AsyncTask;

public abstract class MyAsyncTask extends AsyncTask<Void,Void,String> {
    public MyResponseCollback collback;
    public CheckInternet checkInternet;
    public MyAsyncTask(CheckInternet checkInternet,MyResponseCollback collback){
        this.checkInternet = checkInternet;
        this.collback = collback;
    }

    @Override
    protected String doInBackground(Void... voids) {
        return "";
    }

    @Override
    public void onPostExecute(String result){
        super.onPostExecute(result);

        if (collback != null){

            if (result != null && !result.startsWith("Error"))
                collback.onConpile(result);
            else collback.onError(result);
        }
    }

    protected abstract String doInbackground(Void... voids);
}
