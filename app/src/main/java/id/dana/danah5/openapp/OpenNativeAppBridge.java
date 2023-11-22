package id.dana.danah5.openapp;

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
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.deeplink.DeeplinkResolver;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.lib.gcontainer.extension.ContentExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/danah5/openapp/OpenNativeAppBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.OPEN_NATIVE_APP, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "Landroid/content/Context;", HummerConstants.CONTEXT, "", "openPlayStore", "(Ljava/lang/String;Landroid/content/Context;)Z", OpenNativeAppBridge.URI_SCHEME_KEY, "packagename", "resolveLink", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OpenNativeAppBridge extends SimpleBridgeExtension {
    private static final String MARKET_DETAILS_URL_SCHEME = "market://details";
    private static final String PACKAGE_NAME_KEY = "packagename";
    private static final String URI_HANDLER_NOT_FOUND = "Uri handler not found";
    private static final String URI_SCHEME_KEY = "urischeme";

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void openNativeApp(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Unit unit = null;
        String string = info != null ? info.getString(URI_SCHEME_KEY) : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        String string2 = info != null ? info.getString("packagename") : null;
        String str = string2 != null ? string2 : "";
        if (str.length() == 0) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.INVALID_PARAM);
            return;
        }
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity != null && (applicationContext = activity.getApplicationContext()) != null) {
            if (resolveLink(applicationContext, string, str)) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            } else {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = jSONObject;
                jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
                jSONObject2.put((JSONObject) "message", URI_HANDLER_NOT_FOUND);
                bridgeCallback.sendJSONResponse(jSONObject);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.NATIVE_NODE_NULL);
        }
    }

    private final boolean resolveLink(Context context, String urischeme, String packagename) {
        return DeeplinkResolver.resolveUrl(context, urischeme) || openPlayStore(packagename, context);
    }

    private final boolean openPlayStore(String packageName, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(packageName);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()));
        if (ContentExtKt.hasActivityHandler(intent, context)) {
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            return true;
        }
        return false;
    }
}
