package me.tanjay.chordx;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tanushajayasinghe on 4/17/17.
 */

public class ChrodXConfig {
    private static final ChrodXConfig ourInstance = new ChrodXConfig();
    public static final String BACKEND_SERVER_URL = "http://";
    public static final String SHARED_DATA_POINT = "CHORDX";
    public static final String LOGIN_URL = BACKEND_SERVER_URL + "/login";
    public static final String LISTEN_URL = BACKEND_SERVER_URL + "/listen";
    public static final String LIST_URL = BACKEND_SERVER_URL + "/list";
    public static final String ARTIST_URL = BACKEND_SERVER_URL + "/artist";
    public static final String SEARCH_AUTHOR_URL = BACKEND_SERVER_URL + "/search/artist";
    public static final String SEARCH_SONG_URL = BACKEND_SERVER_URL + "/search/song";
    public static final String SEARCH_GENRE_URL = BACKEND_SERVER_URL + "/search/genre";
    public static String API_KEY = null;


    public static ChrodXConfig getInstance() {
        return ourInstance;
    }

    private ChrodXConfig() {
    }

    public static boolean setAPIKEY(Context context){
        SharedPreferences preferences = context.getSharedPreferences(SHARED_DATA_POINT, Context.MODE_PRIVATE);
        API_KEY = preferences.getString("API_KEY", null);
        if(API_KEY == null){
            return false;
        }else{
            return true;
        }
    }






}
