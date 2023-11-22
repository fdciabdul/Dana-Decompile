package id.dana.danah5.globalnetwork;

import android.app.Application;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.constant.BridgeName;
import id.dana.danah5.globalnetwork.manager.GlobalNetworkPluginManager;
import id.dana.danah5.globalnetwork.model.request.InquiryForexRateEntity;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0014\u0010\fJ/\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/danah5/globalnetwork/GlobalNetworkBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", BridgeName.FOREX, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "onInitialized", "()V", "Lid/dana/danah5/globalnetwork/manager/GlobalNetworkPluginManager;", "globalNetworkPluginManager", "Lid/dana/danah5/globalnetwork/manager/GlobalNetworkPluginManager;", "getGlobalNetworkPluginManager", "()Lid/dana/danah5/globalnetwork/manager/GlobalNetworkPluginManager;", "setGlobalNetworkPluginManager", "(Lid/dana/danah5/globalnetwork/manager/GlobalNetworkPluginManager;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalNetworkBridge extends SimpleBridgeExtension {
    public static final String BOTTOM_SHEET = "bottomSheet";
    public static final String GET_FOREX_BALANCE = "balance";
    public static final String INQUIRY_FOREX_RATE = "rate";
    @Inject
    public GlobalNetworkPluginManager globalNetworkPluginManager;

    @JvmName(name = "getGlobalNetworkPluginManager")
    public final GlobalNetworkPluginManager getGlobalNetworkPluginManager() {
        GlobalNetworkPluginManager globalNetworkPluginManager = this.globalNetworkPluginManager;
        if (globalNetworkPluginManager != null) {
            return globalNetworkPluginManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGlobalNetworkPluginManager")
    public final void setGlobalNetworkPluginManager(GlobalNetworkPluginManager globalNetworkPluginManager) {
        Intrinsics.checkNotNullParameter(globalNetworkPluginManager, "");
        this.globalNetworkPluginManager = globalNetworkPluginManager;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void forex(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        if (!Intrinsics.areEqual(eventName, "rate")) {
            if (Intrinsics.areEqual(eventName, "balance")) {
                getGlobalNetworkPluginManager().getForexBalance(bridgeCallback);
                return;
            }
            return;
        }
        GlobalNetworkPluginManager globalNetworkPluginManager = getGlobalNetworkPluginManager();
        if (info != null) {
            Object obj = null;
            try {
                obj = JSONObject.parseObject(info.toJSONString(), new TypeReference<InquiryForexRateEntity>() { // from class: id.dana.danah5.globalnetwork.GlobalNetworkBridge$forex$$inlined$toObject$default$1
                }, new Feature[0]);
            } catch (JSONException | NullPointerException unused) {
            }
            InquiryForexRateEntity inquiryForexRateEntity = (InquiryForexRateEntity) obj;
            if (inquiryForexRateEntity != null) {
                globalNetworkPluginManager.inquiryForexRate(bridgeCallback, inquiryForexRateEntity);
            }
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(this);
    }
}
