package id.dana.cashier.presenter;

import android.content.Context;
import dagger.Lazy;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.CashierCardBindingContract;
import id.dana.cashier.OneklikAnnotations;
import id.dana.cashier.domain.interactor.AddAssetCardForUser;
import id.dana.cashier.domain.interactor.GetOneklikRedirectUrl;
import id.dana.cashier.domain.interactor.GetQueryCardPolicy;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.PerActivity;
import id.dana.lib.gcontainer.util.UserAgentFactory;
import id.dana.utils.TextUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBW\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\t\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\t\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\t\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00100\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00140\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\f"}, d2 = {"Lid/dana/cashier/presenter/CashierCardBindingPresenter;", "Lid/dana/cashier/CashierCardBindingContract$Presenter;", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "", "onDestroy", "()V", "Ldagger/Lazy;", "Lid/dana/cashier/domain/interactor/AddAssetCardForUser;", "getAuthRequestContext", "Ldagger/Lazy;", "PlaceComponentResult", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/data/config/DeviceInformationProvider;", "MyBillsEntityDataFactory", "Lid/dana/cashier/domain/interactor/GetOneklikRedirectUrl;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/domain/interactor/GetQueryCardPolicy;", "Lid/dana/cashier/CashierCardBindingContract$View;", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "<init>", "(Landroid/content/Context;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class CashierCardBindingPresenter implements CashierCardBindingContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Lazy<GetQueryCardPolicy> MyBillsEntityDataFactory;
    public final Lazy<GetOneklikRedirectUrl> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Lazy<DeviceInformationProvider> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Context getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Lazy<AddAssetCardForUser> PlaceComponentResult;
    public final Lazy<CashierCardBindingContract.View> lookAheadTest;

    @Inject
    public CashierCardBindingPresenter(Context context, Lazy<CashierCardBindingContract.View> lazy, Lazy<GetQueryCardPolicy> lazy2, Lazy<AddAssetCardForUser> lazy3, Lazy<DeviceInformationProvider> lazy4, Lazy<GetOneklikRedirectUrl> lazy5) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        this.getAuthRequestContext = context;
        this.lookAheadTest = lazy;
        this.MyBillsEntityDataFactory = lazy2;
        this.PlaceComponentResult = lazy3;
        this.BuiltInFictitiousFunctionClassFactory = lazy4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy5;
    }

    public static String BuiltInFictitiousFunctionClassFactory(String p0) {
        String authRequestContext = TextUtil.getAuthRequestContext(p0, UserAgentFactory.getUserAgent(), OneklikAnnotations.ONEKLIK_STATIC_IP);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.PlaceComponentResult.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
    }
}
