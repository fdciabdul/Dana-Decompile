package id.dana.danah5.akulaku;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.H5Event;
import com.alipay.iap.android.lbs.LBSLocationErrorCode;
import id.dana.danah5.constant.BridgeName;
import id.dana.dialog.DialogPermission;
import id.dana.dialog.DialogPermissionFactory;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.utils.foundation.facede.LbsFacade;
import id.dana.utils.permission.ManifestPermission;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0007¢\u0006\u0004\b/\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u001b\u001a\u00020\t2\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u000bJ'\u0010#\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010\u0012J/\u0010%\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010(R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010)R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u0005\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010.R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010."}, d2 = {"Lid/dana/danah5/akulaku/AkuLocationGuideBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lid/dana/danah5/akulaku/AkuEventSyncResult;", "", "status", "errorCode", "Lcom/alibaba/fastjson/JSONObject;", "assembleLocationStatus", "(II)Lcom/alibaba/fastjson/JSONObject;", "", "checkLBSLocation", "()V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", LocationGuideParamsKey.KEY_FAIL_TITLE, LocationGuideParamsKey.KEY_FAIL_MESSAGE, "handerLBSLocationStatus", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "", "isLBSLocationSuccess", "()Z", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.LOCATION_PERMISSION_GUIDE, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "openLocationDialog", "(Lcom/alibaba/ariver/app/api/Page;)V", "requestPermission", "sendBridgeResult", "title", "message", "sendFailEvent", "action", "sendGuideEvent", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "syncAkuEventResult", "(I)V", "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/dialog/DialogPermission;", "dialogPermission", "Lid/dana/dialog/DialogPermission;", "I", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AkuLocationGuideBridge extends SimpleBridgeExtension implements AkuEventSyncResult {
    private static final int RESULT_ERRORCODE_TIMEOUT = 1100;
    private Activity activity;
    private BridgeCallback bridgeCallback;
    private DialogPermission dialogPermission;
    private int errorCode = 1100;
    private int status = 1;

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void locationPermissionGuide(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        Activity activity2 = null;
        String string = info != null ? info.getString(LocationGuideParamsKey.KEY_FAIL_TITLE) : null;
        if (string == null) {
            string = "";
        }
        String string2 = info != null ? info.getString(LocationGuideParamsKey.KEY_FAIL_MESSAGE) : null;
        if (string2 == null) {
            string2 = "";
        }
        String string3 = info != null ? info.getString(LocationGuideParamsKey.KEY_GUIDE_TITLE) : null;
        if (string3 == null) {
            string3 = "";
        }
        String string4 = info != null ? info.getString(LocationGuideParamsKey.KEY_GUIDE_MESSAGE) : null;
        if (string4 == null) {
            string4 = "";
        }
        String string5 = info != null ? info.getString("action") : null;
        if (string5 == null) {
            string5 = "";
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Activity activity3 = this.activity;
            if (activity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity3 = null;
            }
            if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(activity3, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                checkLBSLocation();
                Activity activity4 = this.activity;
                if (activity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    activity2 = activity4;
                }
                handerLBSLocationStatus(activity2, string, string2);
                return;
            }
            openLocationDialog(page);
            Activity activity5 = this.activity;
            if (activity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                activity2 = activity5;
            }
            sendGuideEvent(activity2, string3, string4, string5);
            return;
        }
        checkLBSLocation();
        Activity activity6 = this.activity;
        if (activity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            activity2 = activity6;
        }
        handerLBSLocationStatus(activity2, string, string2);
    }

    private final void checkLBSLocation() {
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        this.errorCode = LbsFacade.getAuthRequestContext(activity).getErrorCode();
        this.status = !isLBSLocationSuccess();
    }

    private final boolean isLBSLocationSuccess() {
        return this.errorCode == LBSLocationErrorCode.LocationErrorSuccess.getErrorCode() || this.errorCode == LBSLocationErrorCode.LocationErrorExpired.getErrorCode();
    }

    private final void handerLBSLocationStatus(Activity activity, String failTitle, String failMessage) {
        if (this.status != 0 && (!StringsKt.isBlank(failTitle)) != false && (!StringsKt.isBlank(failMessage)) != false) {
            sendFailEvent(activity, failTitle, failMessage);
        } else {
            sendBridgeResult();
        }
    }

    private final void sendBridgeResult() {
        BridgeCallback bridgeCallback = null;
        try {
            BridgeCallback bridgeCallback2 = this.bridgeCallback;
            if (bridgeCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bridgeCallback2 = null;
            }
            bridgeCallback2.sendJSONResponse(assembleLocationStatus(this.status, this.errorCode));
        } catch (JSONException unused) {
            BridgeCallback bridgeCallback3 = this.bridgeCallback;
            if (bridgeCallback3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                bridgeCallback = bridgeCallback3;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = jSONObject;
            jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
            jSONObject2.put((JSONObject) "message", "unknown error!");
            jSONObject2.put((JSONObject) "error", (String) H5Event.Error.UNKNOWN_ERROR);
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }

    private final void sendFailEvent(Activity activity, String title, String message) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("title", title);
        linkedHashMap.put("message", message);
        linkedHashMap.put(AkuEventParamsKey.KEY_ACTIVITY, activity);
        linkedHashMap.put(AkuEventParamsKey.KEY_AKUEVENT_SYNC_RESULT, this);
    }

    private final JSONObject assembleLocationStatus(int status, int errorCode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", (Object) Integer.valueOf(status));
        jSONObject.put("errorCode", (Object) Integer.valueOf(errorCode));
        return jSONObject;
    }

    private final void sendGuideEvent(Activity activity, String title, String message, String action) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("title", title);
        linkedHashMap.put("message", message);
        linkedHashMap.put("action", action);
        linkedHashMap.put(AkuEventParamsKey.KEY_ACTIVITY, activity);
        linkedHashMap.put(AkuEventParamsKey.KEY_AKUEVENT_SYNC_RESULT, this);
    }

    private final void openLocationDialog(final Page page) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: id.dana.danah5.akulaku.AkuLocationGuideBridge$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AkuLocationGuideBridge.m631openLocationDialog$lambda2(AkuLocationGuideBridge.this, page);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: openLocationDialog$lambda-2  reason: not valid java name */
    public static final void m631openLocationDialog$lambda2(final AkuLocationGuideBridge akuLocationGuideBridge, final Page page) {
        Intrinsics.checkNotNullParameter(akuLocationGuideBridge, "");
        Intrinsics.checkNotNullParameter(page, "");
        DialogPermission BuiltInFictitiousFunctionClassFactory = DialogPermissionFactory.BuiltInFictitiousFunctionClassFactory(BridgeExtensionExtKt.getActivity(page), "location", new DialogPermission.DialogListener() { // from class: id.dana.danah5.akulaku.AkuLocationGuideBridge$openLocationDialog$1$1
            @Override // id.dana.dialog.DialogPermission.DialogListener
            public final void onDialogDismissed() {
            }

            @Override // id.dana.dialog.DialogPermission.DialogListener
            public final void onPositiveButtonClicked() {
                DialogPermission dialogPermission;
                AkuLocationGuideBridge.this.requestPermission(page);
                dialogPermission = AkuLocationGuideBridge.this.dialogPermission;
                if (dialogPermission != null) {
                    dialogPermission.getAuthRequestContext();
                }
            }

            @Override // id.dana.dialog.DialogPermission.DialogListener
            public final void onNegativeButtonClicked() {
                DialogPermission dialogPermission;
                dialogPermission = AkuLocationGuideBridge.this.dialogPermission;
                if (dialogPermission != null) {
                    dialogPermission.getAuthRequestContext();
                }
            }
        });
        akuLocationGuideBridge.dialogPermission = BuiltInFictitiousFunctionClassFactory;
        if (BuiltInFictitiousFunctionClassFactory != null) {
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestPermission(Page page) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        arrayList.add(ManifestPermission.ACCESS_COARSE_LOCATION);
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        Intrinsics.checkNotNull(activity);
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            ActivityCompat.BuiltInFictitiousFunctionClassFactory(activity, (String[]) array, 1);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // id.dana.danah5.akulaku.AkuEventSyncResult
    public final void syncAkuEventResult(int status) {
        this.status = status;
        if (status == 0) {
            checkLBSLocation();
        }
        sendBridgeResult();
    }
}
