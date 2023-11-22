package com.alibaba.griver.unify;

import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.util.Locale;

/* loaded from: classes6.dex */
public class LocaleHelper {
    public static final int FLAG_CHINA = 1;
    private static final int FLAG_ERROR = -1;
    public static final int FLAG_TAIWAN = 2;
    public static final int FLAG_US = 4;
    private static final String SPKEY_FLAG = "flag";
    private static final String TAG = "LocaleHelper";
    private static LocaleHelper instance;

    public static LocaleHelper getInstance() {
        if (instance == null) {
            synchronized (LocaleHelper.class) {
                if (instance == null) {
                    instance = new LocaleHelper();
                }
            }
        }
        return instance;
    }

    public int getAlipayLocaleFlag() {
        Locale locale;
        try {
            locale = GriverEnv.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception e) {
            GriverLogger.w(TAG, "getAlipayLocaleFlag", e);
            locale = null;
        }
        int flagByLocale = getFlagByLocale(locale);
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("getAlipayLocaleFlag: ");
        sb.append(flagByLocale);
        GriverLogger.d(str, sb.toString());
        return flagByLocale;
    }

    private int getFlagByLocale(Locale locale) {
        if (locale == null) {
            return -1;
        }
        String language = locale.getLanguage();
        if (Locale.CHINA.getLanguage().equals(language)) {
            return 1;
        }
        if (Locale.TAIWAN.getLanguage().equals(language)) {
            return 2;
        }
        if (Locale.US.getLanguage().equals(language)) {
            return 4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("incorrect locale: ");
        sb.append(locale);
        GriverLogger.w(TAG, "getFlagByLocale", new Exception(sb.toString()));
        return -1;
    }
}
