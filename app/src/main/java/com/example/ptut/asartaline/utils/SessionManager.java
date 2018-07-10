package com.example.ptut.asartaline.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    @SuppressLint("StaticFieldLeak")
    private static SessionManager sessionManager;
    private final String PREF_NAME="ASarTaLine_APP";
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private int PRIVATE_MODE=0;
    private Context _context;
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private boolean mLoggedIn;

    public static SessionManager getSessionManager(Context context) {
       if(sessionManager==null){
           sessionManager=new SessionManager(context);
       }
       return sessionManager;
    }

    @SuppressLint("CommitPrefEdits")
    private SessionManager(Context context){
        this._context = context;
        mPref = _context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        mEditor = mPref.edit();
    }

    public void setLoginUser(String username,String password){
        mEditor.putString(USERNAME, username).apply();
        mEditor.putString(PASSWORD,password).apply();
    }


    public String getUsername(){
        return mPref.getString(USERNAME,null);
    }

    public String getPassword(){
        return mPref.getString(PASSWORD,null);
    }

    public void clearData(){
        mEditor.clear();
        mEditor.commit();
    }


    public boolean isLoggedIn() {
        return mLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        mLoggedIn = loggedIn;
    }
}
