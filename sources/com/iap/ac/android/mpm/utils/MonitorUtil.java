package com.iap.ac.android.mpm.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.common.log.ACLog;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class MonitorUtil {
    public static final String BIZ_GRIVER_TYPE = "GriverAppContainer";
    public static final String EVENT_TRADE_PAY = "mini_trade_pay";
    public static final String EVENT_TRADE_PAY_START = "mini_trade_pay_start";
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_ORDER_STR = "orderStr";
    public static final String KEY_PAYMENT_URL = "paymentUrl";
    public static final String KEY_SOURCE_INFO = "sourceInfo";
    public static final String KEY_TRADE_INFO = "tradeInfo";
    public static final String KEY_TRADE_NO = "tradeNO";
    public static final String KEY_TRADE_TYPE = "tradeType";
    public static final String KEY_VERSION = "version";
    public static final String error = "error";
    public static final String result = "result";
    public static final String status = "status";
    public static final String success = "success";

    public static void monitorTradePay(Map<String, String> map, JSONObject jSONObject) {
        if (isGriver()) {
            ACLog.d(Constants.TAG, "MonitorUtil#monitorTradePay");
            ACLogEvent newLogger = ACLogEvent.newLogger("GriverAppContainer", "mini_trade_pay");
            handleTradePayMonitor(newLogger, map);
            if (jSONObject.isNull("error")) {
                newLogger.addParams("status", "error");
            } else {
                newLogger.addParams("status", "success");
            }
            newLogger.addParams("result", jSONObject.toString());
            newLogger.event();
        }
    }

    public static void monitorTradePayStart(Map<String, String> map) {
        if (isGriver()) {
            ACLog.d(Constants.TAG, "MonitorUtil#monitorTradePayStart");
            ACLogEvent newLogger = ACLogEvent.newLogger("GriverAppContainer", "mini_trade_pay_start");
            handleTradePayMonitor(newLogger, map);
            newLogger.event();
        }
    }

    private static void handleTradePayMonitor(ACLogEvent aCLogEvent, Map<String, String> map) {
        aCLogEvent.addParams("appId", map.containsKey("appId") ? map.get("appId") : "");
        aCLogEvent.addParams("sourceInfo", map.containsKey("sourceInfo") ? Uri.encode(map.get("sourceInfo")) : "");
        aCLogEvent.addParams("version", map.containsKey("version") ? map.get("version") : "");
        String str = map.containsKey(KEY_TRADE_NO) ? map.get(KEY_TRADE_NO) : "";
        String str2 = map.containsKey("paymentUrl") ? map.get("paymentUrl") : "";
        String str3 = map.containsKey(KEY_ORDER_STR) ? map.get(KEY_ORDER_STR) : "";
        if (!TextUtils.isEmpty(str2)) {
            aCLogEvent.addParams(KEY_TRADE_TYPE, "paymentUrl").addParams(KEY_TRADE_INFO, str2);
        } else if (!TextUtils.isEmpty(str3)) {
            aCLogEvent.addParams(KEY_TRADE_TYPE, KEY_ORDER_STR).addParams(KEY_TRADE_INFO, str3);
        } else if (TextUtils.isEmpty(str)) {
        } else {
            aCLogEvent.addParams(KEY_TRADE_TYPE, KEY_TRADE_NO).addParams(KEY_TRADE_INFO, str);
        }
    }

    private static boolean isGriver() {
        return Utils.checkClassExist("com.iap.ac.android.container.adapter.griver.GriverContainerImpl");
    }
}
