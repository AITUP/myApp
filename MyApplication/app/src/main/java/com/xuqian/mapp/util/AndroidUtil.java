package com.xuqian.mapp.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by xuqian on 2015/8/17.
 */
public class AndroidUtil {

    public static String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context
                .TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }
}
