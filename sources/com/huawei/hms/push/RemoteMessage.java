package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.mobile.verifyidentity.base.message.RequestConstants;
import com.google.firebase.messaging.Constants;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.log.HMSLog;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import id.dana.domain.featureconfig.model.UgcConfig;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class RemoteMessage implements Parcelable {
    public static final int[] BuiltInFictitiousFunctionClassFactory;
    public static final Parcelable.Creator<RemoteMessage> CREATOR;
    public static final String[] KClassImpl$Data$declaredNonStaticMembers$2;
    public static final long[] MyBillsEntityDataFactory;
    public static final HashMap<String, Object> NetworkUserEntityData$$ExternalSyntheticLambda0;
    public static final HashMap<String, Object> PlaceComponentResult;
    public static final HashMap<String, Object> getAuthRequestContext;
    public static final HashMap<String, Object> getErrorConfigVersion;
    public static final HashMap<String, Object> scheduleImpl;
    public Bundle lookAheadTest;
    public Notification moveToNextValue;

    /* loaded from: classes8.dex */
    public static class Builder {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface MessagePriority {
    }

    /* loaded from: classes8.dex */
    public static class Notification implements Serializable {
        public final long[] A;
        public final String B;

        /* renamed from: a  reason: collision with root package name */
        public final String f7480a;
        public final String b;
        public final String[] c;
        public final String d;
        public final String e;
        public final String[] f;
        public final String g;
        public final String h;
        public final String i;
        public final String j;
        public final String k;
        public final String l;
        public final String m;
        public final Uri n;

        /* renamed from: o  reason: collision with root package name */
        public final int f7481o;
        public final String p;
        public final int q;
        public final int r;
        public final int s;
        public final int[] t;
        public final String u;
        public final int v;
        public final String w;
        public final int x;
        public final String y;
        public final String z;

        public /* synthetic */ Notification(Bundle bundle, b bVar) {
            this(bundle);
        }

        public final Integer a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("NumberFormatException: get ");
                    sb.append(str);
                    sb.append(" failed.");
                    HMSLog.w("RemoteMessage", sb.toString());
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return a(this.w);
        }

        public String getBody() {
            return this.d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.e;
        }

        public String getChannelId() {
            return this.m;
        }

        public String getClickAction() {
            return this.k;
        }

        public String getColor() {
            return this.j;
        }

        public String getIcon() {
            return this.g;
        }

        public Uri getImageUrl() {
            String str = this.p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return a(this.y);
        }

        public String getIntentUri() {
            return this.l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.n;
        }

        public int getNotifyId() {
            return this.f7481o;
        }

        public String getSound() {
            return this.h;
        }

        public String getTag() {
            return this.i;
        }

        public String getTicker() {
            return this.z;
        }

        public String getTitle() {
            return this.f7480a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return a(this.B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.u)) {
                try {
                    return Long.valueOf(DateUtil.PlaceComponentResult(this.u));
                } catch (StringIndexOutOfBoundsException unused) {
                    HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                } catch (ParseException unused2) {
                    HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.x == 1;
        }

        public boolean isDefaultLight() {
            return this.q == 1;
        }

        public boolean isDefaultSound() {
            return this.r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.s == 1;
        }

        public boolean isLocalOnly() {
            return this.v == 1;
        }

        public Notification(Bundle bundle) {
            this.f7480a = bundle.getString("notifyTitle");
            this.d = bundle.getString("content");
            this.b = bundle.getString("title_loc_key");
            this.e = bundle.getString("body_loc_key");
            this.c = bundle.getStringArray("title_loc_args");
            this.f = bundle.getStringArray("body_loc_args");
            this.g = bundle.getString("icon");
            this.j = bundle.getString("color");
            this.h = bundle.getString("sound");
            this.i = bundle.getString("tag");
            this.m = bundle.getString("channelId");
            this.k = bundle.getString("acn");
            this.l = bundle.getString("intentUri");
            this.f7481o = bundle.getInt("notifyId");
            String string = bundle.getString("url");
            this.n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.p = bundle.getString("notifyIcon");
            this.q = bundle.getInt("defaultLightSettings");
            this.r = bundle.getInt("defaultSound");
            this.s = bundle.getInt("defaultVibrateTimings");
            this.t = bundle.getIntArray("lightSettings");
            this.u = bundle.getString("when");
            this.v = bundle.getInt("localOnly");
            this.w = bundle.getString("badgeSetNum", null);
            this.x = bundle.getInt("autoCancel");
            this.y = bundle.getString("priority", null);
            this.z = bundle.getString("ticker");
            this.A = bundle.getLongArray("vibrateTimings");
            this.B = bundle.getString("visibility", null);
        }
    }

    public RemoteMessage(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(bundle);
        JSONObject optJSONObject = KClassImpl$Data$declaredNonStaticMembers$22 != null ? KClassImpl$Data$declaredNonStaticMembers$22.optJSONObject("msgContent") : null;
        String authRequestContext = JsonUtil.getAuthRequestContext(optJSONObject, "data", (String) null);
        bundle2.putString("analyticInfo", JsonUtil.getAuthRequestContext(optJSONObject, "analyticInfo", (String) null));
        bundle2.putString("device_token", bundle.getString("device_token"));
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("psContent") : null;
        JSONObject optJSONObject3 = optJSONObject2 != null ? optJSONObject2.optJSONObject("notifyDetail") : null;
        JSONObject optJSONObject4 = optJSONObject2 != null ? optJSONObject2.optJSONObject("param") : null;
        if (bundle.getInt(RequestConstants.Pin.INPUTTYPE) == 1 && s.MyBillsEntityDataFactory(optJSONObject, optJSONObject2, authRequestContext)) {
            bundle2.putString("data", w.getAuthRequestContext(bundle.getByteArray("message_body")));
        } else {
            String string = bundle.getString(LoginTrackingConstants.LoginParam.TO);
            String string2 = bundle.getString(Constants.MessagePayloadKeys.MESSAGE_TYPE);
            String authRequestContext2 = JsonUtil.getAuthRequestContext(optJSONObject, "msgId", (String) null);
            bundle2.putString(LoginTrackingConstants.LoginParam.TO, string);
            bundle2.putString("data", authRequestContext);
            bundle2.putString("msgId", authRequestContext2);
            bundle2.putString(Constants.MessagePayloadKeys.MESSAGE_TYPE, string2);
            JsonUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22, bundle2, getAuthRequestContext);
            Bundle bundle3 = new Bundle();
            JsonUtil.KClassImpl$Data$declaredNonStaticMembers$2(optJSONObject2, bundle3, PlaceComponentResult);
            JsonUtil.KClassImpl$Data$declaredNonStaticMembers$2(optJSONObject3, bundle3, scheduleImpl);
            JsonUtil.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22, bundle3, getErrorConfigVersion);
            JsonUtil.KClassImpl$Data$declaredNonStaticMembers$2(optJSONObject4, bundle3, NetworkUserEntityData$$ExternalSyntheticLambda0);
            bundle3.putInt("notifyId", JsonUtil.getAuthRequestContext(optJSONObject, "notifyId", 0));
            bundle2.putBundle("notification", bundle3);
        }
        this.lookAheadTest = bundle2;
    }

    private static JSONObject KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle) {
        try {
            return new JSONObject(w.getAuthRequestContext(bundle.getByteArray("message_body")));
        } catch (JSONException unused) {
            HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.lookAheadTest);
        parcel.writeSerializable(this.moveToNextValue);
    }

    public RemoteMessage(Parcel parcel) {
        this.lookAheadTest = parcel.readBundle();
        this.moveToNextValue = (Notification) parcel.readSerializable();
    }

    static {
        String[] strArr = new String[0];
        KClassImpl$Data$declaredNonStaticMembers$2 = strArr;
        int[] iArr = new int[0];
        BuiltInFictitiousFunctionClassFactory = iArr;
        long[] jArr = new long[0];
        MyBillsEntityDataFactory = jArr;
        HashMap<String, Object> hashMap = new HashMap<>(8);
        getAuthRequestContext = hashMap;
        hashMap.put("from", "");
        hashMap.put("collapseKey", "");
        hashMap.put("sendTime", "");
        hashMap.put("ttl", Integer.valueOf((int) UgcConfig.DEFAULT_UGC_INTERVAL));
        hashMap.put("urgency", 2);
        hashMap.put("oriUrgency", 2);
        hashMap.put("sendMode", 0);
        hashMap.put("receiptMode", 0);
        HashMap<String, Object> hashMap2 = new HashMap<>(8);
        PlaceComponentResult = hashMap2;
        hashMap2.put("title_loc_key", "");
        hashMap2.put("body_loc_key", "");
        hashMap2.put("notifyIcon", "");
        hashMap2.put("title_loc_args", strArr);
        hashMap2.put("body_loc_args", strArr);
        hashMap2.put("ticker", "");
        hashMap2.put("notifyTitle", "");
        hashMap2.put("content", "");
        HashMap<String, Object> hashMap3 = new HashMap<>(8);
        scheduleImpl = hashMap3;
        hashMap3.put("icon", "");
        hashMap3.put("color", "");
        hashMap3.put("sound", "");
        hashMap3.put("defaultLightSettings", 1);
        hashMap3.put("lightSettings", iArr);
        hashMap3.put("defaultSound", 1);
        hashMap3.put("defaultVibrateTimings", 1);
        hashMap3.put("vibrateTimings", jArr);
        HashMap<String, Object> hashMap4 = new HashMap<>(8);
        getErrorConfigVersion = hashMap4;
        hashMap4.put("tag", "");
        hashMap4.put("when", "");
        hashMap4.put("localOnly", 1);
        hashMap4.put("badgeSetNum", "");
        hashMap4.put("priority", "");
        hashMap4.put("autoCancel", 1);
        hashMap4.put("visibility", "");
        hashMap4.put("channelId", "");
        HashMap<String, Object> hashMap5 = new HashMap<>(3);
        NetworkUserEntityData$$ExternalSyntheticLambda0 = hashMap5;
        hashMap5.put("acn", "");
        hashMap5.put("intentUri", "");
        hashMap5.put("url", "");
        CREATOR = new b();
    }
}
