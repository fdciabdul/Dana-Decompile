package id.dana.danah5.cashier;

import android.app.Application;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.base.common.env.GriverEnv;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.cashier.CashierEventHandler;
import id.dana.danah5.base.UrlTransportEventHandler;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\rJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/danah5/cashier/CashierUrlEventHandler;", "Lid/dana/danah5/base/UrlTransportEventHandler;", "Lcom/alibaba/ariver/app/api/Page;", "page", "", "url", "", "interceptUrl", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;)Z", "isCashierUrl", "(Ljava/lang/String;)Z", "", "onInitialized", "()V", "Lid/dana/cashier/CashierEventHandler;", "cashierEventHandler", "Lid/dana/cashier/CashierEventHandler;", "getCashierEventHandler", "()Lid/dana/cashier/CashierEventHandler;", "setCashierEventHandler", "(Lid/dana/cashier/CashierEventHandler;)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CashierUrlEventHandler extends UrlTransportEventHandler {
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

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.ariver.kernel.api.extension.Extension
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

    @Override // id.dana.danah5.base.UrlTransportEventHandler, com.alibaba.griver.api.common.page.GriverInterceptUrlEvent
    public final boolean interceptUrl(Page page, String url) {
        if (!isCashierUrl(url) || page == null) {
            return false;
        }
        CashierEventHandler cashierEventHandler = getCashierEventHandler();
        if (url == null) {
            url = "";
        }
        cashierEventHandler.KClassImpl$Data$declaredNonStaticMembers$2(page, url, null, null, "portrait", true, "", 0L);
        return false;
    }

    private final boolean isCashierUrl(String url) {
        if (url != null) {
            return StringsKt.startsWith$default(url, "https://m.dana.id/m/portal/cashier", false, 2, (Object) null);
        }
        return false;
    }
}
