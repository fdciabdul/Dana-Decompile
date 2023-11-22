package id.dana.lib.gcontainer.app.bridge.contact;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.collection.ArrayMap;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.lib.logger.DANALog;
import id.dana.sendmoney.contact.provider.ContactProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001e\u0010\u0018J/\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001d"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/contact/ContactBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "event", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "contact", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "Landroid/net/Uri;", "uri", "Lcom/alibaba/fastjson/JSONObject;", "createSuccessResult", "(Landroid/net/Uri;)Lcom/alibaba/fastjson/JSONObject;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "sendFailResult", "()V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Ljava/lang/String;", "<init>", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactBridge extends BaseBridge {
    private static final String MOBILE = "mobile";
    private static final String NAME = "name";
    private static final String TAG = "ContactBridge";
    private Activity activity;
    private BridgeCallback bridgeCallback;
    private String event;

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void contact(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) final String event, @BindingCallback final BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        this.event = event;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        requestPermissions(activity, new String[]{"android.permission.READ_CONTACTS"}, new PermissionCallback() { // from class: id.dana.lib.gcontainer.app.bridge.contact.ContactBridge$contact$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult result, boolean fromSystemDialog) {
                Activity activity2;
                Intrinsics.checkNotNullParameter(result, "");
                if (result.MyBillsEntityDataFactory()) {
                    if (Intrinsics.areEqual(event, "get")) {
                        ContactBridge contactBridge = this;
                        ContactBridge contactBridge2 = contactBridge;
                        activity2 = contactBridge.activity;
                        if (activity2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            activity2 = null;
                        }
                        BaseBridge.startActivityForResult$default(contactBridge2, activity2, new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 0, 4, null);
                        return;
                    }
                    return;
                }
                BridgeCallback bridgeCallback2 = bridgeCallback;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = jSONObject;
                jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                jSONObject2.put((JSONObject) "errorMessage", "Contact permission denied");
                Unit unit = Unit.INSTANCE;
                bridgeCallback2.sendJSONResponse(jSONObject);
            }
        });
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {
            if ((data == null ? null : data.getData()) != null) {
                Uri data2 = data.getData();
                if (data2 == null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(getIoScope(), null, null, new ContactBridge$onActivityResult$1(data2, this, null), 3, null);
                return;
            }
        }
        sendFailResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendFailResult() {
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "errorMessage", "Failed to retrieve contact");
        Unit unit = Unit.INSTANCE;
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject createSuccessResult(Uri uri) {
        Exception e;
        String str;
        String str2;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
        ArrayMap arrayMap = new ArrayMap();
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        Cursor query = activity.getContentResolver().query(uri, new String[]{ContactProvider.Column.PHONENUMBER, ContactProvider.Column.DISPLAY_NAME}, null, null, null);
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                while (cursor2.moveToNext()) {
                    try {
                        str = cursor2.getString(0);
                        Intrinsics.checkNotNullExpressionValue(str, "");
                        try {
                            str2 = cursor2.getString(1);
                            Intrinsics.checkNotNullExpressionValue(str2, "");
                        } catch (Exception e2) {
                            e = e2;
                            DANALog.PlaceComponentResult(TAG, "createSuccessResult", e);
                            str2 = "";
                            arrayMap.put("mobile", str);
                            arrayMap.put("name", str2);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str = "";
                    }
                    arrayMap.put("mobile", str);
                    arrayMap.put("name", str2);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } finally {
            }
        }
        jSONObject2.put((JSONObject) "info", (String) arrayMap);
        return jSONObject;
    }
}
