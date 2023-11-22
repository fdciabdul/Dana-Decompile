package com.iap.ac.android.biz.common.multilanguage.network;

import android.content.Context;
import android.os.SystemClock;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.http.HttpClient;
import com.iap.ac.android.biz.common.model.http.HttpMethod;
import com.iap.ac.android.biz.common.model.http.HttpRequest;
import com.iap.ac.android.biz.common.model.http.HttpResponse;
import com.iap.ac.android.biz.common.model.multilanguage.resources.Metadata;
import com.iap.ac.android.biz.common.utils.log.ACLogEvent;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;

/* loaded from: classes8.dex */
public class MultiLanguageHttpClient {
    public static final String I18N = "i18n";
    public static final String JSON = ".json";
    public static final String META_DATA = "meta_data";
    public static final String TAG = "MultiLanguageHttpClient";
    public static String URL;
    public Context context;
    public HttpClient httpClient;

    public MultiLanguageHttpClient(Context context) {
        this.context = context;
        this.httpClient = new HttpClient(true, context).addInterceptor(new CacheInterceptor(context));
        URL = ACManager.getInstance().getCommonConfig().cdnUrl;
    }

    public String getI18nScene(String str, String str2, String str3, String str4) {
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("/");
        sb.append(I18N);
        sb.append("/");
        sb.append(str2);
        sb.append("/");
        sb.append(str3);
        sb.append("/");
        sb.append(str4);
        sb.append(".json");
        try {
            HttpResponse execute = this.httpClient.newCall(new HttpRequest(sb.toString(), HttpMethod.GET, "")).execute();
            if (isSuccess(execute)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getI18nScene time: ");
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                InstrumentInjector.log_e(TAG, sb2.toString());
                return new String(execute.data);
            }
        } catch (Throwable th) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("getI18nScene  exception, scene=");
            sb3.append(str2);
            sb3.append("version=");
            sb3.append(str3);
            sb3.append("locale=");
            sb3.append(str4);
            sb3.append(" errorCode is: ");
            ACLog.e(Constants.TAG, sb3.toString(), th);
            ACLogEvent.newLogger("iapconnect_center", LogConstants.MultiLanguage.EVENT_ID_AC_QUERY_BIZSCENE_FAIL).addParams(LogConstants.MultiLanguage.RESOURCES_NAME, str2).addParams("version", str3).addParams("locale", str4).addParams("resultMessage", th).event();
        }
        return "";
    }

    public Metadata getMetadata() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append(URL);
        sb.append("/");
        sb.append(META_DATA);
        sb.append(".json");
        try {
            HttpResponse execute = this.httpClient.newCall(new HttpRequest(sb.toString(), HttpMethod.GET, null)).execute();
            if (isSuccess(execute)) {
                Metadata metadata = (Metadata) JsonUtils.fromJson(new String(execute.data), Metadata.class);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getMetadata time: ");
                sb2.append(SystemClock.elapsedRealtime() - elapsedRealtime);
                ACLog.i(TAG, sb2.toString());
                return metadata;
            }
        } catch (Throwable th) {
            ACLog.e(Constants.TAG, "getMetadata  exception,  errorCode is: ", th);
            ACLogEvent.newLogger("iapconnect_center", LogConstants.MultiLanguage.EVENT_ID_AC_QUERY_BIZSCENE_FAIL).addParams(LogConstants.MultiLanguage.RESOURCES_NAME, "meta_data.json").addParams("resultMessage", th).event();
        }
        return null;
    }

    public boolean isSuccess(HttpResponse httpResponse) {
        int i;
        return httpResponse != null && ((i = httpResponse.statusCode) == 200 || i == 304) && httpResponse.data != null;
    }
}
