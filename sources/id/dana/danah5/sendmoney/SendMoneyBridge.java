package id.dana.danah5.sendmoney;

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
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;
import id.dana.sendmoney_v2.recipient.SendMoneyEventHandler;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0014\u0010\fJ/\u0010\t\u001a\u00020\b2\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/danah5/sendmoney/SendMoneyBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", "destination", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", BridgeName.SEND_MONEY, "(Ljava/lang/String;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "onInitialized", "()V", "Lid/dana/sendmoney_v2/recipient/SendMoneyEventHandler;", "sendMoneyEventHandler", "Lid/dana/sendmoney_v2/recipient/SendMoneyEventHandler;", "getSendMoneyEventHandler", "()Lid/dana/sendmoney_v2/recipient/SendMoneyEventHandler;", "setSendMoneyEventHandler", "(Lid/dana/sendmoney_v2/recipient/SendMoneyEventHandler;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendMoneyBridge extends SimpleBridgeExtension {
    private static final String DESTINATION = "destination";
    private static final String X2B = "X2B";
    @Inject
    public SendMoneyEventHandler sendMoneyEventHandler;

    @JvmName(name = "getSendMoneyEventHandler")
    public final SendMoneyEventHandler getSendMoneyEventHandler() {
        SendMoneyEventHandler sendMoneyEventHandler = this.sendMoneyEventHandler;
        if (sendMoneyEventHandler != null) {
            return sendMoneyEventHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyEventHandler")
    public final void setSendMoneyEventHandler(SendMoneyEventHandler sendMoneyEventHandler) {
        Intrinsics.checkNotNullParameter(sendMoneyEventHandler, "");
        this.sendMoneyEventHandler = sendMoneyEventHandler;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void callSendMoney(@BindingParam(name = {"destination"}) String destination, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        if (Intrinsics.areEqual(destination, X2B)) {
            SendMoneyEventHandler sendMoneyEventHandler = getSendMoneyEventHandler();
            Intrinsics.checkNotNullParameter(page, "");
            sendMoneyEventHandler.getAuthRequestContext = page;
            sendMoneyEventHandler.BuiltInFictitiousFunctionClassFactory = BridgeExtensionExtKt.getActivity(page);
            sendMoneyEventHandler.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.SourceType.JS_API;
            Activity activity = sendMoneyEventHandler.BuiltInFictitiousFunctionClassFactory;
            if (activity != null) {
                Intent intent = new Intent(activity, SendMoneyActivity.class);
                intent.putExtra("is_from_payroll", true);
                intent.putExtra("source", sendMoneyEventHandler.KClassImpl$Data$declaredNonStaticMembers$2);
                intent.putExtra("recipientType", BranchLinkConstant.ActionTarget.SEND_MONEY_BANK);
                activity.startActivity(intent);
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
        bridgeCallback.sendJSONResponse(jSONObject);
    }

    @Override // com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this);
    }
}
