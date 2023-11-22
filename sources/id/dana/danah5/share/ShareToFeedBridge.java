package id.dana.danah5.share;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.danah5.bottomsheet.ShareFeedBottomSheetManager;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.mixpanel.StrictBaseBridge;
import id.dana.danah5.mixpanel.model.JSApiStatus;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.feeds.domain.share.interactor.GetPreviewActivity;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.utils.CustomToastUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001f\u0010\u000bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ]\u0010\u0016\u001a\u00020\t2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\b\u0003\u0010\u0013\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u00142\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\t*\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/danah5/share/ShareToFeedBridge;", "Lid/dana/danah5/mixpanel/StrictBaseBridge;", "Lid/dana/danah5/mixpanel/model/JSApiStatus;", "jsApiStatus", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "callback", "", "canShare", "(Lid/dana/danah5/mixpanel/model/JSApiStatus;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)Z", "", "onFinalized", "()V", "onInitialized", "", "contentType", "contentCode", "Lcom/alibaba/fastjson/JSONObject;", ShareToFeedBridge.CONTENT_FORMATTER, ShareToFeedBridge.WIDGET, "autoShare", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.SHARE_TO_FEEDS, "(Ljava/lang/String;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/fastjson/JSONObject;ZLcom/alibaba/ariver/app/api/Page;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "", "errorCode", "sendError", "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;I)V", "Lid/dana/danah5/bottomsheet/ShareFeedBottomSheetManager;", "bottomSheetManager", "Lid/dana/danah5/bottomsheet/ShareFeedBottomSheetManager;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareToFeedBridge extends StrictBaseBridge {
    public static final String AUTO_SHARE = "autoShare";
    public static final String CONTENT_CODE = "contentCode";
    public static final String CONTENT_FORMATTER = "contentFormatter";
    public static final String CONTENT_TYPE = "contentType";
    public static final String REDIRECT_VALUE = "redirectValue";
    public static final String WIDGET = "widget";
    private final ShareFeedBottomSheetManager bottomSheetManager = new ShareFeedBottomSheetManager();

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(this);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        this.bottomSheetManager.dispose();
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void shareToFeeds(@BindingParam(name = {"contentType"}) String str, @BindingParam(name = {"contentCode"}) String str2, @BindingParam(name = {"contentFormatter"}) JSONObject jSONObject, @BindingParam(name = {"widget"}) JSONObject jSONObject2, @BindingParam(name = {"autoShare"}) boolean z, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity != null && canShare(canUse(BridgeName.SHARE_TO_FEEDS, page), bridgeCallback)) {
            String str3 = str;
            if (!(str3 == null || str3.length() == 0)) {
                String str4 = str2;
                if (!(str4 == null || str4.length() == 0)) {
                    HashMap hashMap = new HashMap();
                    if (jSONObject != null) {
                        for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                            if (!StringsKt.equals(entry.getKey(), ExtendInfoUtilKt.ACTOR_KEY, true)) {
                                String key = entry.getKey();
                                Intrinsics.checkNotNullExpressionValue(key, "");
                                hashMap.put(key, MapsKt.mapOf(TuplesKt.to(ExtendInfoUtilKt.DISPLAY_NAME_KEY, entry.getValue().toString())));
                            }
                        }
                    }
                    HashMap hashMap2 = new HashMap();
                    if (jSONObject2 != null) {
                        for (Map.Entry<String, Object> entry2 : jSONObject2.entrySet()) {
                            String key2 = entry2.getKey();
                            Intrinsics.checkNotNullExpressionValue(key2, "");
                            hashMap2.put(key2, entry2.getValue().toString());
                        }
                    }
                    HashMap hashMap3 = hashMap;
                    hashMap3.put(WIDGET, hashMap2);
                    GetPreviewActivity.Params params = new GetPreviewActivity.Params("", str, str2, hashMap3, (String) hashMap2.get(REDIRECT_VALUE));
                    if (z) {
                        this.bottomSheetManager.autoSubmitFeed(fragmentActivity, params, bridgeCallback);
                        return;
                    } else {
                        this.bottomSheetManager.showServicesBottomSheetDialog(fragmentActivity, params, bridgeCallback);
                        return;
                    }
                }
            }
            CustomToastUtil customToastUtil = CustomToastUtil.MyBillsEntityDataFactory;
            CustomToastUtil.KClassImpl$Data$declaredNonStaticMembers$2(fragmentActivity, R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1, fragmentActivity.getApplicationContext().getString(R.string.share_to_feed_message_error));
            sendError(bridgeCallback, 5);
        }
    }

    private final boolean canShare(JSApiStatus jsApiStatus, BridgeCallback callback) {
        if (JSApiStatus.DISABLED == jsApiStatus) {
            sendError(callback, 3);
        } else if (JSApiStatus.NOT_WHITELIST != jsApiStatus) {
            return true;
        } else {
            sendError(callback, 4);
        }
        return false;
    }

    private final void sendError(BridgeCallback bridgeCallback, int i) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "errorCode", (String) Integer.valueOf(i));
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
