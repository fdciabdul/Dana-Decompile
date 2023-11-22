package id.dana.danah5.twilioverifysecurityproduct;

import android.app.Application;
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
import id.dana.danah5.constant.BridgeName;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J7\u0010\u000e\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/danah5/twilioverifysecurityproduct/TwilioVerifySecurityProductBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", "onFinalized", "()V", "onInitialized", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", BridgeName.TWILIO_VERIFY_SECURITY_PRODUCT, "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Lid/dana/danah5/twilioverifysecurityproduct/TwilioVerifySecurityProductManager;", "twilioVerifySecurityProductManager", "Lid/dana/danah5/twilioverifysecurityproduct/TwilioVerifySecurityProductManager;", "getTwilioVerifySecurityProductManager", "()Lid/dana/danah5/twilioverifysecurityproduct/TwilioVerifySecurityProductManager;", "setTwilioVerifySecurityProductManager", "(Lid/dana/danah5/twilioverifysecurityproduct/TwilioVerifySecurityProductManager;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TwilioVerifySecurityProductBridge extends BaseBridge {
    private static final String SECURITY_ID = "securityId";
    private static final String TIMEOUT = "timeout";
    private static final String VERIFICATION_METHOD = "verificationMethod";
    @Inject
    public TwilioVerifySecurityProductManager twilioVerifySecurityProductManager;

    @JvmName(name = "getTwilioVerifySecurityProductManager")
    public final TwilioVerifySecurityProductManager getTwilioVerifySecurityProductManager() {
        TwilioVerifySecurityProductManager twilioVerifySecurityProductManager = this.twilioVerifySecurityProductManager;
        if (twilioVerifySecurityProductManager != null) {
            return twilioVerifySecurityProductManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTwilioVerifySecurityProductManager")
    public final void setTwilioVerifySecurityProductManager(TwilioVerifySecurityProductManager twilioVerifySecurityProductManager) {
        Intrinsics.checkNotNullParameter(twilioVerifySecurityProductManager, "");
        this.twilioVerifySecurityProductManager = twilioVerifySecurityProductManager;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void twilioVerifySecurityProduct(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(info, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        String string = info.getString("securityId");
        String string2 = info.getString("verificationMethod");
        Integer integer = info.getInteger("timeout");
        TwilioVerifySecurityProductManager twilioVerifySecurityProductManager = getTwilioVerifySecurityProductManager();
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullExpressionValue(string2, "");
        Intrinsics.checkNotNullExpressionValue(integer, "");
        twilioVerifySecurityProductManager.doVerify(eventName, bridgeCallback, string, string2, integer.intValue(), page);
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(this);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        getTwilioVerifySecurityProductManager().disposeAllObservable();
    }
}
