package id.dana.sync_engine.permission;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.util.permission.ManifestPermission;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sync_engine/permission/PermissionUtil;", "", "", "p0", "Landroid/content/Context;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Landroid/content/Context;)Z", "", "PlaceComponentResult", "(Landroid/content/Context;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionUtil {
    public static final PermissionUtil INSTANCE = new PermissionUtil();

    private PermissionUtil() {
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0, Context p1) {
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p1, p0) == 0;
    }

    public static void PlaceComponentResult(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        for (Map.Entry entry : MapsKt.mapOf(new Pair("android.permission.ACCESS_FINE_LOCATION", "User Location Permission"), new Pair("android.permission.CALL_PHONE", TrackerDataKey.Event.USER_PHONE_CALL_PERMISSION), new Pair(ManifestPermission.RECORD_AUDIO, TrackerDataKey.Event.USER_MICROPHONE_PERMISSION), new Pair("android.permission.READ_CONTACTS", TrackerDataKey.Event.USER_CONTACT_PERMISSION), new Pair("android.permission.CAMERA", TrackerDataKey.Event.USER_CAMERA_PERMISSION), new Pair("android.permission.READ_EXTERNAL_STORAGE", TrackerDataKey.Event.USER_FILE_PERMISSION)).entrySet()) {
            String str = (String) entry.getValue();
            boolean KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2((String) entry.getKey(), p0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, KClassImpl$Data$declaredNonStaticMembers$2);
            MixPanelDataTracker.BuiltInFictitiousFunctionClassFactory(p0, jSONObject);
            String str2 = (String) entry.getValue();
            boolean KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2((String) entry.getKey(), p0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str2, KClassImpl$Data$declaredNonStaticMembers$22);
            MixPanelDataTracker.getAuthRequestContext(p0, jSONObject2);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            boolean KClassImpl$Data$declaredNonStaticMembers$23 = KClassImpl$Data$declaredNonStaticMembers$2("android.permission.ACCESS_MEDIA_LOCATION", p0);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(TrackerDataKey.Event.USER_PHOTOS_AND_MEDIA_PERMISSION, KClassImpl$Data$declaredNonStaticMembers$23);
            MixPanelDataTracker.BuiltInFictitiousFunctionClassFactory(p0, jSONObject3);
            boolean KClassImpl$Data$declaredNonStaticMembers$24 = KClassImpl$Data$declaredNonStaticMembers$2("android.permission.ACCESS_MEDIA_LOCATION", p0);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(TrackerDataKey.Event.USER_PHOTOS_AND_MEDIA_PERMISSION, KClassImpl$Data$declaredNonStaticMembers$24);
            MixPanelDataTracker.getAuthRequestContext(p0, jSONObject4);
        } else {
            boolean KClassImpl$Data$declaredNonStaticMembers$25 = KClassImpl$Data$declaredNonStaticMembers$2("android.permission.READ_EXTERNAL_STORAGE", p0);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(TrackerDataKey.Event.USER_PHOTOS_AND_MEDIA_PERMISSION, KClassImpl$Data$declaredNonStaticMembers$25);
            MixPanelDataTracker.BuiltInFictitiousFunctionClassFactory(p0, jSONObject5);
            boolean KClassImpl$Data$declaredNonStaticMembers$26 = KClassImpl$Data$declaredNonStaticMembers$2("android.permission.READ_EXTERNAL_STORAGE", p0);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(TrackerDataKey.Event.USER_PHOTOS_AND_MEDIA_PERMISSION, KClassImpl$Data$declaredNonStaticMembers$26);
            MixPanelDataTracker.getAuthRequestContext(p0, jSONObject6);
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(p0);
        boolean z = defaultAdapter != null;
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put(TrackerDataKey.Event.USER_NFC_PERMISSION, z);
        MixPanelDataTracker.BuiltInFictitiousFunctionClassFactory(p0, jSONObject7);
        boolean z2 = defaultAdapter != null;
        JSONObject jSONObject8 = new JSONObject();
        jSONObject8.put(TrackerDataKey.Event.USER_NFC_PERMISSION, z2);
        MixPanelDataTracker.getAuthRequestContext(p0, jSONObject8);
        boolean BuiltInFictitiousFunctionClassFactory = NotificationManagerCompat.MyBillsEntityDataFactory(p0).BuiltInFictitiousFunctionClassFactory();
        JSONObject jSONObject9 = new JSONObject();
        jSONObject9.put(TrackerDataKey.Event.USER_PUSH_NOTIFICATION_PERMISSION, BuiltInFictitiousFunctionClassFactory);
        MixPanelDataTracker.BuiltInFictitiousFunctionClassFactory(p0, jSONObject9);
        JSONObject jSONObject10 = new JSONObject();
        jSONObject10.put(TrackerDataKey.Event.USER_PUSH_NOTIFICATION_PERMISSION, BuiltInFictitiousFunctionClassFactory);
        MixPanelDataTracker.getAuthRequestContext(p0, jSONObject10);
    }
}
