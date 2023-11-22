package id.dana.danah5.opennearbyme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import id.dana.danah5.constant.BridgeName;
import id.dana.drawable.NewNearbyMeActivity;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.nearbyme.NearbyMeActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\u00020\b*\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u00020\b*\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/danah5/opennearbyme/OpenNearbyMeBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.OPEN_NEARBY_ME_APP, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "source", "startNearbyActivity", "(Landroid/content/Context;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)V", "Landroid/content/Intent;", "composeExtras", "(Landroid/content/Intent;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;)V", "data", "key", "putNonNullNonEmptyDataToIntent", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OpenNearbyMeBridge extends SimpleBridgeExtension {
    private static final String CATEGORY_KEY = "category";
    private static final String KEYWORD_KEY = "keyword";
    private static final String LAT_KEY = "lat";
    private static final String LONG_KEY = "long";
    private static final String MERCHANT_ID_KEY = "merchantid";
    private static final String SHOP_ID_KEY = "shopid";
    private static final String SOURCE_KEY = "source";
    private static final String SOURCE_PARAM_NOT_FOUND = "source param must not be null or empty";

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void openNearbyMe(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Unit unit = null;
        String string = info != null ? info.getString("source") : null;
        String str = string;
        if (!(str == null || str.length() == 0)) {
            Activity activity = BridgeExtensionExtKt.getActivity(page);
            if (activity != null) {
                startNearbyActivity(activity, string, info);
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                bridgeCallback.sendBridgeResponse(BridgeResponse.NATIVE_NODE_NULL);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "message", SOURCE_PARAM_NOT_FOUND);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private final void startNearbyActivity(Context context, String source, JSONObject info) {
        String string = info.getString("shopid");
        Intent intent = new Intent(context, NewNearbyMeActivity.class);
        composeExtras(intent, source, info);
        if (string != null) {
            intent.putExtra(NewNearbyMeActivity.EXTRA_TARGET_SCREEN, NewNearbyMeActivity.NEARBY_DETAIL_BOTTOMSHEET);
        }
        context.startActivity(intent);
    }

    private final void composeExtras(Intent intent, String str, JSONObject jSONObject) {
        intent.putExtra("EXTRA_SOURCE", str);
        putNonNullNonEmptyDataToIntent(intent, jSONObject.getString("keyword"), NearbyMeActivity.EXTRA_SEARCH_KEYWORD);
        putNonNullNonEmptyDataToIntent(intent, jSONObject.getString("shopid"), "EXTRA_SHOP_ID");
        putNonNullNonEmptyDataToIntent(intent, jSONObject.getString(MERCHANT_ID_KEY), "EXTRA_MERCHANT_ID");
        putNonNullNonEmptyDataToIntent(intent, jSONObject.getString("category"), NearbyMeActivity.EXTRA_CATEGORY);
        Double d = jSONObject.getDouble("lat");
        if (d != null) {
            intent.putExtra(NearbyMeActivity.EXTRA_LOCATION_LAT, d.doubleValue());
        }
        Double d2 = jSONObject.getDouble("long");
        if (d2 != null) {
            intent.putExtra(NearbyMeActivity.EXTRA_LOCATION_LON, d2.doubleValue());
        }
    }

    private final void putNonNullNonEmptyDataToIntent(Intent intent, String str, String str2) {
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            return;
        }
        intent.putExtra(str2, str);
    }
}
