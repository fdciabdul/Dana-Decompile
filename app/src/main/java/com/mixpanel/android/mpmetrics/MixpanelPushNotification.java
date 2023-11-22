package com.mixpanel.android.mpmetrics;

import android.app.Notification;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.mixpanel.android.mpmetrics.MixpanelNotificationData;
import com.mixpanel.android.mpmetrics.ResourceReader;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.MPLog;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MixpanelPushNotification {
    int BuiltInFictitiousFunctionClassFactory;
    MixpanelNotificationData KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    private Notification.Builder NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected final int PlaceComponentResult;
    private final String getAuthRequestContext;
    private long getErrorConfigVersion;
    private Context moveToNextValue;
    private ResourceIds scheduleImpl;

    public MixpanelPushNotification(Context context) {
        this(context, new Notification.Builder(context), System.currentTimeMillis());
    }

    private MixpanelPushNotification(Context context, Notification.Builder builder, long j) {
        this.getAuthRequestContext = "MixpanelAPI.MixpanelPushNotification";
        this.MyBillsEntityDataFactory = false;
        this.moveToNextValue = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder;
        String str = MPConfig.getAuthRequestContext(context).NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.scheduleImpl = new ResourceReader.Drawables(str == null ? context.getPackageName() : str, context);
        this.getErrorConfigVersion = j;
        int i = (int) j;
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    private List<MixpanelNotificationData.MixpanelNotificationButtonData> MyBillsEntityDataFactory(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("lbl");
                    MixpanelNotificationData.PushTapAction authRequestContext = getAuthRequestContext(jSONObject.getString("ontap"));
                    String string2 = jSONObject.getString("id");
                    if (authRequestContext == null || string == null || string2 == null) {
                        MPLog.PlaceComponentResult("MixpanelAPI.MixpanelPushNotification", "Null button data received. No buttons will be rendered.");
                    } else {
                        arrayList.add(new MixpanelNotificationData.MixpanelNotificationButtonData(string, authRequestContext, string2));
                    }
                }
            } catch (JSONException e) {
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.MixpanelPushNotification", "Exception parsing buttons payload", e);
            }
        }
        return arrayList;
    }

    private MixpanelNotificationData.PushTapAction getAuthRequestContext(String str) {
        MixpanelNotificationData.PushTapAction pushTapAction;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                if (!string.equals(MixpanelNotificationData.PushTapActionType.HOMESCREEN.toString())) {
                    pushTapAction = new MixpanelNotificationData.PushTapAction(MixpanelNotificationData.PushTapActionType.fromString(string), jSONObject.getString("uri"));
                } else {
                    pushTapAction = new MixpanelNotificationData.PushTapAction(MixpanelNotificationData.PushTapActionType.fromString(string));
                }
                if (pushTapAction.getAuthRequestContext.toString().equals(MixpanelNotificationData.PushTapActionType.ERROR.toString())) {
                    this.MyBillsEntityDataFactory = true;
                    return new MixpanelNotificationData.PushTapAction(MixpanelNotificationData.PushTapActionType.HOMESCREEN);
                }
                return pushTapAction;
            } catch (JSONException unused) {
                MPLog.PlaceComponentResult("MixpanelAPI.MixpanelPushNotification", "Exception occurred while parsing ontap");
                return null;
            }
        }
        return null;
    }

    private Bundle KClassImpl$Data$declaredNonStaticMembers$2(MixpanelNotificationData.PushTapAction pushTapAction) {
        String num;
        Bundle bundle = new Bundle();
        bundle.putCharSequence("mp_tap_target", "notification");
        bundle.putCharSequence("mp_tap_action_type", pushTapAction.getAuthRequestContext.toString());
        bundle.putCharSequence("mp_tap_action_uri", pushTapAction.BuiltInFictitiousFunctionClassFactory);
        bundle.putCharSequence("mp_message_id", this.KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig);
        bundle.putCharSequence("mp_campaign_id", this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
        bundle.putInt("mp_notification_id", this.BuiltInFictitiousFunctionClassFactory);
        bundle.putBoolean("mp_is_sticky", this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory());
        bundle.putCharSequence("mp_tag", this.KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance);
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance == null) {
            num = Integer.toString(this.BuiltInFictitiousFunctionClassFactory);
        } else {
            num = this.KClassImpl$Data$declaredNonStaticMembers$2.newProxyInstance;
        }
        bundle.putCharSequence("mp_canonical_notification_id", num);
        bundle.putCharSequence("mp", this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl);
        return bundle;
    }

    private ApplicationInfo PlaceComponentResult() {
        try {
            return this.moveToNextValue.getPackageManager().getApplicationInfo(this.moveToNextValue.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 == null || this.MyBillsEntityDataFactory) ? false : true;
    }

    private static Date BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
            if (str.equals("yyyy-MM-dd'T'HH:mm:ss'Z'")) {
                simpleDateFormat.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC"));
            }
            return simpleDateFormat.parse(str2);
        } catch (ParseException unused) {
            return null;
        }
    }

    private Bitmap PlaceComponentResult(String str) {
        try {
            return new ImageStore(this.moveToNextValue, "MixpanelPushNotification").KClassImpl$Data$declaredNonStaticMembers$2(str);
        } catch (ImageStore.CantGetImageException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x00e8, code lost:
    
        if (r4 < 0) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0274 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0221  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.app.Notification PlaceComponentResult(android.content.Intent r29) {
        /*
            Method dump skipped, instructions count: 1457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MixpanelPushNotification.PlaceComponentResult(android.content.Intent):android.app.Notification");
    }
}
