package com.lura.location;

import android.content.Context;
import android.location.Location;
import android.preference.PreferenceManager;
import android.util.Log;
import java.text.DateFormat;
import java.util.Date;

class Utils {

    static final String KEY_REQUESTING_LOCATION_UPDATES = "requesting_locaction_updates";


    static boolean requestingLocationUpdates(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_REQUESTING_LOCATION_UPDATES, false);
    }

    static void setRequestingLocationUpdates(Context context, boolean requestingLocationUpdates) {
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(KEY_REQUESTING_LOCATION_UPDATES, requestingLocationUpdates)
                .apply();
    }

    static String getLocationText(Location location) {
        return location == null ? "Unknown location" :
                "( Date" + DateFormat.getDateTimeInstance().format(location.getTime()) + ", Lat" + location.getLatitude() + " Long" + location.getLongitude() + ")";
    }

    static String getLocationTitle(Context context) {
        return context.getString(R.string.location_updated,
                DateFormat.getDateTimeInstance().format(new Date()));
    }

    static float getFloat(String distance) {
        float distanceFloat;
        try {
            distanceFloat = Float.valueOf(distance.trim()).floatValue();
        } catch (NumberFormatException nfe) {
            distanceFloat = 5f;
            Log.e("NumberFormatException: ", nfe.getMessage());
        }
        return distanceFloat;
    }
}
