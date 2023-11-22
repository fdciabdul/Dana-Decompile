package id.dana.danah5.sendevent;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.collection.ArrayMap;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.aplog.monitor.analysis.diagnose.UploadTaskStatusCallback;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.extension.ContentExtKt;
import id.dana.sendmoney.contact.provider.ContactProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/danah5/sendevent/ContactEventManager;", "", "Lcom/alibaba/fastjson/JSONObject;", "createFailResult", "()Lcom/alibaba/fastjson/JSONObject;", "Landroid/content/Intent;", "data", "createSuccessResult", "(Landroid/content/Intent;)Lcom/alibaba/fastjson/JSONObject;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", RequestPermission.REQUEST_CODE, "", "onReceiveActivityResult", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;ILandroid/content/Intent;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "processEvent", "(Landroid/app/Activity;)V", "REQUEST_CODE_CONTACTS_PICKER", "I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactEventManager {
    public static final ContactEventManager INSTANCE = new ContactEventManager();
    public static final int REQUEST_CODE_CONTACTS_PICKER = 101;

    private ContactEventManager() {
    }

    public final void onReceiveActivityResult(BridgeCallback bridgeCallback, int requestCode, Intent data) {
        JSONObject createFailResult;
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        try {
            if (data != null && requestCode == 101) {
                createFailResult = createSuccessResult(data);
            } else {
                createFailResult = createFailResult();
            }
        } catch (Exception e) {
            createFailResult = createFailResult();
        }
        createFailResult.toJSONString();
        bridgeCallback.sendJSONResponse(createFailResult);
    }

    public final void processEvent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        ContentExtKt.startActivityForResultSafely(activity, 101, new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI));
    }

    private final JSONObject createSuccessResult(Intent data) {
        Uri data2;
        Cursor query;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
        ArrayMap arrayMap = new ArrayMap();
        if (data != null && (data2 = data.getData()) != null && (query = GContainer.getApplicationContext().getContentResolver().query(data2, new String[]{ContactProvider.Column.PHONENUMBER, ContactProvider.Column.DISPLAY_NAME}, null, null, null)) != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToNext()) {
                    arrayMap.put(UploadTaskStatusCallback.NETWORK_MOBILE, cursor2.getString(0));
                    arrayMap.put("name", cursor2.getString(1));
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } finally {
            }
        }
        jSONObject2.put((JSONObject) "info", (String) arrayMap);
        return jSONObject;
    }

    private final JSONObject createFailResult() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", "Failed to retrieve contact");
        return jSONObject;
    }
}
