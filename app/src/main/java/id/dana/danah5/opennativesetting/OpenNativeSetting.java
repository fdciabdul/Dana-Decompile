package id.dana.danah5.opennativesetting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.danah5.constant.BridgeName;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.OSUtil;
import id.dana.utils.permission.PermissionHelper;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0014\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/danah5/opennativesetting/OpenNativeSetting;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", "errorMessage", "Lcom/alibaba/fastjson/JSONObject;", "getError", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.OPEN_NATIVE_SETTING, "(Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OpenNativeSetting extends BaseBridge {
    private static final String EVENT_LOCATION = "location";
    private static final String NOT_IMPLEMENT_ERROR = "not implemented!";
    private static final int REQUEST_APP_SETTINGS = 332288;
    private static final String UNKNOWN_ERROR = "unknown error";
    private static final String USER_ALLOWED_LOCATION = "user allowed location";
    private BridgeCallback bridgeCallback;
    private Context context;

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void openNativeSetting(@BindingParam(name = {"event"}) String eventName, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        this.bridgeCallback = bridgeCallback;
        this.context = BridgeExtensionExtKt.getContext(page);
        String lowerCase = eventName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        if (Intrinsics.areEqual("location", lowerCase)) {
            Activity activity = BridgeExtensionExtKt.getActivity(page);
            if (OSUtil.moveToNextValue() && activity != null && !PermissionHelper.MyBillsEntityDataFactory(activity, "android.permission.ACCESS_FINE_LOCATION")) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("package:");
                    Context context = this.context;
                    sb.append(context != null ? context.getPackageName() : null);
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(sb.toString()));
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    startActivityForResult(activity, intent, REQUEST_APP_SETTINGS);
                    return;
                } catch (Exception e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = "unknown error";
                    }
                    bridgeCallback.sendBridgeResponse(new BridgeResponse(getError(message)));
                    return;
                }
            }
            bridgeCallback.sendBridgeResponse(new BridgeResponse(getError(USER_ALLOWED_LOCATION)));
            return;
        }
        bridgeCallback.sendBridgeResponse(new BridgeResponse(getError("not implemented!")));
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        Context context;
        if (OSUtil.moveToNextValue() && (context = this.context) != null) {
            Intrinsics.checkNotNull(context);
            if (PermissionHelper.MyBillsEntityDataFactory(context, "android.permission.ACCESS_FINE_LOCATION")) {
                MixPanelTracker.KClassImpl$Data$declaredNonStaticMembers$2(this.context, true);
            }
        }
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
    }

    private final JSONObject getError(String errorMessage) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) errorMessage);
        return jSONObject;
    }
}
