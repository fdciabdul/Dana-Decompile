package com.alibaba.griver.beehive.lottie.player;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.adapter.impl.ApplicationAapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.alibaba.griver.beehive.lottie.downgrade.DowngradeRuler;
import com.alibaba.griver.beehive.lottie.player.QualifiedModel;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class BeeLottieQualifiedHelper {
    private static String BeeLottie_qualified_open = "BeeLottie_qualified_open";
    private static String BeeLottie_qualified_open_online = "BeeLottie_qualified_open_online";
    private static final String TAG = "BeeLottieQualifiedHelper";
    private static String currentClientVersion = "";
    private static Boolean isDebug;

    public static boolean isQulifiedOpenForDebug() {
        if (isDebuggable() && SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue(BeeLottie_qualified_open))) {
            GriverLogger.d(TAG, "isQulifiedOpenForDebug：true");
            return true;
        }
        return false;
    }

    public static boolean isQulifiedOpenForOnline() {
        if (isDebuggable() || !SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue(BeeLottie_qualified_open_online))) {
            return false;
        }
        GriverLogger.d(TAG, "isQulifiedOpenForOnline：true");
        return true;
    }

    public static boolean isDebuggable() {
        Boolean bool = isDebug;
        if (bool != null) {
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        try {
            Boolean valueOf = Boolean.valueOf((ApplicationAapter.getApplicationContext().getApplicationInfo().flags & 2) != 0);
            isDebug = valueOf;
            return valueOf.booleanValue();
        } catch (Throwable th) {
            GriverLogger.e(TAG, "是否debug开关判断异常：", th);
            return false;
        }
    }

    public static int compareVersion(String str, String str2) {
        if (str == str2) {
            return 0;
        }
        if (str == null || str2 == null) {
            return -1;
        }
        if (str.equals(str2)) {
            return 0;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int min = Math.min(split.length, split2.length);
        int i = 0;
        for (int i2 = 0; i2 < min; i2++) {
            i = split[i2].length() - split2[i2].length();
            if (i != 0 || (i = split[i2].compareTo(split2[i2])) != 0) {
                break;
            }
        }
        return i;
    }

    public static QualifiedModel parseQualifiedModel(JsonReader jsonReader) throws IOException {
        QualifiedModel qualifiedModel = new QualifiedModel();
        qualifiedModel.lottie = new QualifiedModel.Lottie();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals(LottieConstants.RENDER_TYPE_LOTTIE)) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    if (nextName.equals("result")) {
                        qualifiedModel.lottie.result = jsonReader.nextString();
                    } else if (nextName.equals("minVersion")) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            if (jsonReader.nextName().equals("android")) {
                                qualifiedModel.lottie.minVersion = jsonReader.nextString();
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return qualifiedModel;
    }

    public static boolean isPassQualifiedForDebug(QualifiedModel qualifiedModel, LottiePlayer lottiePlayer) {
        if (qualifiedModel == null || qualifiedModel.lottie == null || TextUtils.isEmpty(qualifiedModel.lottie.result)) {
            lottiePlayer.downgradeToPlaceholder();
            GriverLogger.e(TAG, "isPassQualifiedForDebug");
            return false;
        }
        return true;
    }

    public static boolean isPassQualifiedForOnline(QualifiedModel qualifiedModel, String str, DowngradeRuler downgradeRuler, LottiePlayer lottiePlayer) {
        if (qualifiedModel != null && qualifiedModel.lottie != null && !TextUtils.isEmpty(qualifiedModel.lottie.result)) {
            String clientVersion = getClientVersion();
            if (!TextUtils.isEmpty(qualifiedModel.lottie.minVersion) && !TextUtils.isEmpty(clientVersion) && compareVersion(clientVersion, qualifiedModel.lottie.minVersion) < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("json资源已打标，客户端版本为：");
                sb.append(clientVersion);
                sb.append(",打标的minVersion=");
                sb.append(qualifiedModel.lottie.minVersion);
                GriverLogger.d(TAG, sb.toString());
                downgradeRuler.setDowngradeLevel("L0");
                if (downgradeRuler.downgradeToPlaceholder()) {
                    downgrade(str, lottiePlayer);
                    return false;
                }
            }
            return true;
        }
        downgradeRuler.setDowngradeLevel("L0");
        if (downgradeRuler.downgradeToPlaceholder()) {
            downgrade(str, lottiePlayer);
            return false;
        }
        return true;
    }

    private static void downgrade(String str, LottiePlayer lottiePlayer) {
        if (!TextUtils.isEmpty(str)) {
            lottiePlayer.preparePlaceHolder(str, true);
            lottiePlayer.downgradeToPlaceholder();
            return;
        }
        lottiePlayer.processError("兜底图为空，Lolita打标降级失败.");
    }

    public static String getClientVersion() {
        if (TextUtils.isEmpty(currentClientVersion)) {
            try {
                Application applicationContext = ApplicationAapter.getApplicationContext();
                currentClientVersion = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
            } catch (Exception e) {
                GriverLogger.e(TAG, "getClientVersion error", e);
            }
        }
        return currentClientVersion;
    }

    public static void qualifiedLog(String str, String str2) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("referer_url", str);
        hashMap.put("__RENDER_TYPE_KEY__", str2);
        hashMap.put(ZdocRecordService.REASON, "打标检查未通过");
    }
}
