package id.dana.danah5.subapp;

import android.app.Application;
import android.os.Bundle;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.CashierEventHandler;
import id.dana.data.miniprogram.provider.DeeplinkServiceProvider;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.lib.gcontainer.GContainer;
import id.dana.utils.UrlUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u0014J]\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/danah5/subapp/CallSubAppBridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "", "url", "screenOrientation", "", "isReturnHome", "timerType", "", "timerDuration", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "callSubApp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "isCashierUrl", "(Ljava/lang/String;)Z", "onInitialized", "()V", "Lid/dana/cashier/CashierEventHandler;", "cashierEventHandler", "Lid/dana/cashier/CashierEventHandler;", "getCashierEventHandler", "()Lid/dana/cashier/CashierEventHandler;", "setCashierEventHandler", "(Lid/dana/cashier/CashierEventHandler;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CallSubAppBridge extends SimpleBridgeExtension {
    @Inject
    public CashierEventHandler cashierEventHandler;

    @JvmName(name = "getCashierEventHandler")
    public final CashierEventHandler getCashierEventHandler() {
        CashierEventHandler cashierEventHandler = this.cashierEventHandler;
        if (cashierEventHandler != null) {
            return cashierEventHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCashierEventHandler")
    public final void setCashierEventHandler(CashierEventHandler cashierEventHandler) {
        Intrinsics.checkNotNullParameter(cashierEventHandler, "");
        this.cashierEventHandler = cashierEventHandler;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void callSubApp(@BindingParam(name = {"url"}) String url, @BindingParam(name = {"screenOrientation"}) String screenOrientation, @BindingParam(name = {"isReturnHome"}) Boolean isReturnHome, @BindingParam(name = {"timerType"}) String timerType, @BindingParam(name = {"timerDuration"}) Long timerDuration, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(url, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        if (isCashierUrl(url)) {
            getCashierEventHandler().KClassImpl$Data$declaredNonStaticMembers$2(page, url, bridgeCallback, TrackerKey.SourceType.JS_API, screenOrientation, isReturnHome != null ? isReturnHome.booleanValue() : true, timerType == null ? "" : timerType, timerDuration != null ? timerDuration.longValue() : 0L);
        } else if (UrlUtil.getErrorConfigVersion(url)) {
            EventBus.getDefault().post(new DeeplinkServiceProvider.OpenDeeplinkMessageEvent(url));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("screenOrientation", screenOrientation == null ? "portrait" : screenOrientation);
            GContainer.openUrl$default(url, bundle, null, null, 12, null);
        }
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
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(this);
    }

    private final boolean isCashierUrl(String url) {
        if (url != null) {
            return StringsKt.startsWith$default(url, "https://m.dana.id/m/portal/cashier", false, 2, (Object) null);
        }
        return false;
    }
}
