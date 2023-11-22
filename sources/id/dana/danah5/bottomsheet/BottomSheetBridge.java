package id.dana.danah5.bottomsheet;

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
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.bottomsheet.service.ServicesBottomSheetManager;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0017\u0010\u000eJ;\u0010\u000b\u001a\u00020\n2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\"\u0010\u0011\u001a\u00020\u00108\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/danah5/bottomsheet/BottomSheetBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/app/api/Page;", "page", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "bottomSheet", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/app/api/Page;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "onFinalized", "()V", "onInitialized", "Lid/dana/danah5/bottomsheet/service/ServicesBottomSheetManager;", "servicesBottomSheetManager", "Lid/dana/danah5/bottomsheet/service/ServicesBottomSheetManager;", "getServicesBottomSheetManager", "()Lid/dana/danah5/bottomsheet/service/ServicesBottomSheetManager;", "setServicesBottomSheetManager", "(Lid/dana/danah5/bottomsheet/service/ServicesBottomSheetManager;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomSheetBridge extends BaseBridge {
    public static final String EVENT_NAME_SERVICES = "services";
    @Inject
    public ServicesBottomSheetManager servicesBottomSheetManager;

    @JvmName(name = "getServicesBottomSheetManager")
    public final ServicesBottomSheetManager getServicesBottomSheetManager() {
        ServicesBottomSheetManager servicesBottomSheetManager = this.servicesBottomSheetManager;
        if (servicesBottomSheetManager != null) {
            return servicesBottomSheetManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setServicesBottomSheetManager")
    public final void setServicesBottomSheetManager(ServicesBottomSheetManager servicesBottomSheetManager) {
        Intrinsics.checkNotNullParameter(servicesBottomSheetManager, "");
        this.servicesBottomSheetManager = servicesBottomSheetManager;
    }

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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void bottomSheet(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        if (Intrinsics.areEqual(eventName, "services")) {
            ServicesBottomSheetManager servicesBottomSheetManager = getServicesBottomSheetManager();
            Activity activity = BridgeExtensionExtKt.getActivity(page);
            FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
            if (fragmentActivity == null) {
                return;
            }
            servicesBottomSheetManager.showServicesBottomSheetDialog(fragmentActivity, info, bridgeCallback);
        }
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        getServicesBottomSheetManager().dismissBottomSheetDialog();
        super.onFinalized();
    }
}
