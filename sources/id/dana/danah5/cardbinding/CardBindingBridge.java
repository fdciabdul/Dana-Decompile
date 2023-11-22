package id.dana.danah5.cardbinding;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
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
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.contract.deeplink.path.FeatureCardBinding;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010\u000bJ)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ-\u0010\u0013\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\u0010\u001a\u00020\u000f2\b\b\u0001\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u000bR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!"}, d2 = {"Lid/dana/danah5/cardbinding/CardBindingBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "onFinalized", "()V", "onInitialized", "Lcom/alibaba/ariver/app/api/Page;", "page", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", BridgeName.OCR_CARD_BINDING_OCR, "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "sendEmptyFailedResult", "sendEmptySuccessResult", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/contract/deeplink/path/FeatureCardBinding;", "featureCardBinding", "Lid/dana/contract/deeplink/path/FeatureCardBinding;", "getFeatureCardBinding", "()Lid/dana/contract/deeplink/path/FeatureCardBinding;", "setFeatureCardBinding", "(Lid/dana/contract/deeplink/path/FeatureCardBinding;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CardBindingBridge extends BaseBridge {
    private Activity activity;
    private BridgeCallback bridgeCallback;
    @Inject
    public FeatureCardBinding featureCardBinding;

    @JvmName(name = "getFeatureCardBinding")
    public final FeatureCardBinding getFeatureCardBinding() {
        FeatureCardBinding featureCardBinding = this.featureCardBinding;
        if (featureCardBinding != null) {
            return featureCardBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFeatureCardBinding")
    public final void setFeatureCardBinding(FeatureCardBinding featureCardBinding) {
        Intrinsics.checkNotNullParameter(featureCardBinding, "");
        this.featureCardBinding = featureCardBinding;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void openCardBindingOCR(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) String eventName, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        FeatureCardBinding featureCardBinding = getFeatureCardBinding();
        Activity activity2 = this.activity;
        if (activity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity2 = null;
        }
        featureCardBinding.BuiltInFictitiousFunctionClassFactory(activity2, TrackerKey.SourceType.JS_API);
        sendEmptySuccessResult();
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(this);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 || data != null) {
            return;
        }
        sendEmptyFailedResult();
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        getFeatureCardBinding().MyBillsEntityDataFactory.dispose();
    }

    private final void sendEmptySuccessResult() {
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    private final void sendEmptyFailedResult() {
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "success", (String) Boolean.FALSE);
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
