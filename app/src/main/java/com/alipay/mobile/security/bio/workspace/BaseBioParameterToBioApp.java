package com.alipay.mobile.security.bio.workspace;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.security.bio.api.BioParameter;
import com.alipay.mobile.security.bio.service.BioAppDescription;
import com.alipay.mobile.security.bio.utils.SignHelper;
import id.dana.wallet_v3.identity.presenter.PersonalPresenter;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public abstract class BaseBioParameterToBioApp {
    protected static final String TAG_TGCONFIG = "\"ui\":992";
    final BioTransfer bioTransfer;
    protected final Context mContext;

    public abstract BioAppDescription toBioApp(BioParameter bioParameter);

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseBioParameterToBioApp(Context context, BioTransfer bioTransfer) {
        this.bioTransfer = bioTransfer;
        this.mContext = context;
    }

    public static String getUniqueTag() {
        UUID randomUUID = UUID.randomUUID();
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(Math.random() * 10000.0d);
        sb.append(randomUUID.toString());
        return SignHelper.MD5(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String parseIDProtocol(JSONObject jSONObject, boolean z) {
        String string = jSONObject.getString("paperGuideUrl");
        String string2 = jSONObject.getString("showPaperGuide");
        String string3 = jSONObject.getString(PersonalPresenter.CERT_TYPE);
        int intValue = jSONObject.getIntValue("paperStartPage");
        int intValue2 = jSONObject.getIntValue("paperTotalPage");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("showPaperGuide", (Object) string2);
        jSONObject2.put("paperGuideUrl", (Object) string);
        jSONObject2.put(PersonalPresenter.CERT_TYPE, (Object) string3);
        jSONObject2.put("paperStartPage", (Object) Integer.valueOf(intValue));
        jSONObject2.put("paperTotalPage", (Object) Integer.valueOf(intValue2));
        jSONObject2.put("fcToken", (Object) this.bioTransfer.fcToken);
        this.bioTransfer.mFcSpecialData = jSONObject2;
        if (z) {
            return jSONObject.getString("papersCfg");
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("content", (Object) jSONObject.getString("papersCfg"));
        return jSONObject3.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String parseFaceProtocol(JSONObject jSONObject, boolean z) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(f.f7258a, (Object) "fc");
        jSONObject2.put("fcToken", (Object) this.bioTransfer.fcToken);
        this.bioTransfer.mFcSpecialData = jSONObject2;
        if (z) {
            return jSONObject.getString("faceCfg");
        }
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("content", (Object) jSONObject.getString("faceCfg"));
        return jSONObject3.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getUi(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            Matcher matcher = Pattern.compile("(?<=\\\"ui\\\":\\s?\"?)(\\d+)(?=\"?,)").matcher(str);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group()) + 1000;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getEnv(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            Matcher matcher = Pattern.compile("(?<=\\\"env\\\":\\s?\"?)(\\d+)(?=\"?,)").matcher(str);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group());
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
