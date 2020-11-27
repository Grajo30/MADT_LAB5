package com.example.madt1116;

import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public abstract class DataLoader extends AsyncTask<String, Void, ArrayList<String>> {

    protected ArrayList<String> doInBackground(String... params) {

        try {
            return DataManager.getRateFromECB();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            //return sw.toString();
        }
        return null;
    }

    public abstract void onPostExecute(ArrayList<String> result);
}