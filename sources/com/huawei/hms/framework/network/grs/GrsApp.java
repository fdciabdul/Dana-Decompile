package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;

/* loaded from: classes7.dex */
public class GrsApp {
    private static final String BRAND;
    private static final GrsApp INSTANCE = new GrsApp();
    private static final String TAG = "GrsApp";
    private String appConfigName;

    static {
        String str;
        String name = GrsApp.class.getPackage().getName();
        if ("com.huawei.hms.framework.network.grs".equals(name)) {
            str = "";
        } else {
            String[] split = name.split("\\.");
            StringBuilder sb = new StringBuilder();
            sb.append("current brand is:");
            sb.append(split[1]);
            Logger.v(TAG, sb.toString());
            str = split[1];
        }
        BRAND = str;
    }

    private GrsApp() {
    }

    public static GrsApp getInstance() {
        return INSTANCE;
    }

    public String getAppConfigName() {
        return this.appConfigName;
    }

    public String getBrand(String str) {
        String str2 = BRAND;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    public String getIssueCountryCode(Context context) {
        return a.PlaceComponentResult(context, false).getCountryCode();
    }

    public void setAppConfigName(String str) {
        this.appConfigName = str;
    }
}
