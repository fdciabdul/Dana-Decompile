package id.dana.danah5.openallshop;

import android.app.Activity;
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
import id.dana.danah5.constant.BridgeName;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.nearbyme.OtherStoreListActivity;
import id.dana.nearbyme.enums.SearchType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/danah5/openallshop/OpenAllShopBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.OPEN_ALL_SHOP, "(Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "", "data", "errorMessage", "", "paramNotNullCheck", "(Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)Z", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OpenAllShopBridge extends SimpleBridgeExtension {
    private static final String MERCHANT_ID_KEY = "merchantid";
    private static final String MERCHANT_ID_PARAM_NOT_FOUND = "merchantid param must not be null or empty";
    private static final String MERCHANT_NAME_KEY = "merchantname";
    private static final String MERCHANT_NAME_PARAM_NOT_FOUND = "merchantname param must not be null or empty";
    private static final String SEARCH_KEYWORD_KEY = "searchkeyword";
    private static final String SEARCH_TYPE_KEY = "searchtype";
    private static final String SOURCE_KEY = "source";

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void openAllShop(@BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Unit unit = null;
        if (paramNotNullCheck(info != null ? info.getString(MERCHANT_ID_KEY) : null, MERCHANT_ID_PARAM_NOT_FOUND, bridgeCallback)) {
            return;
        }
        if (paramNotNullCheck(info != null ? info.getString(MERCHANT_NAME_KEY) : null, MERCHANT_NAME_PARAM_NOT_FOUND, bridgeCallback)) {
            return;
        }
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity != null) {
            if (info != null) {
                OtherStoreListActivity.Companion companion = OtherStoreListActivity.INSTANCE;
                Activity activity2 = activity;
                String string = info.getString(MERCHANT_ID_KEY);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String string2 = info.getString(MERCHANT_NAME_KEY);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                String string3 = info.getString(SEARCH_TYPE_KEY);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                SearchType valueOf = SearchType.valueOf(string3);
                String string4 = info.getString(SEARCH_KEYWORD_KEY);
                Intrinsics.checkNotNullExpressionValue(string4, "");
                String string5 = info.getString("source");
                OtherStoreListActivity.Companion.BuiltInFictitiousFunctionClassFactory(activity2, string, string2, valueOf, string4, string5 == null ? "" : string5);
            }
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.NATIVE_NODE_NULL);
        }
    }

    private final boolean paramNotNullCheck(String data, String errorMessage, BridgeCallback bridgeCallback) {
        String str = data;
        if (str == null || str.length() == 0) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = jSONObject;
            jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
            jSONObject2.put((JSONObject) "message", errorMessage);
            bridgeCallback.sendJSONResponse(jSONObject);
            return true;
        }
        return false;
    }
}
