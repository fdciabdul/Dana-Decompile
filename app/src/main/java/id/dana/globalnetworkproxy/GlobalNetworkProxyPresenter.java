package id.dana.globalnetworkproxy;

import com.iap.ac.android.common.rpc.model.HttpResponse;
import dagger.Lazy;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.GetGlobalNetworkProxyConfig;
import id.dana.domain.globalnetwork.interactor.GnConsult;
import id.dana.globalnetworkproxy.GlobalNetworkProxyContract;
import id.dana.globalnetworkproxy.mapper.GlobalNetworkProxyMapper;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00110\r\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016"}, d2 = {"Lid/dana/globalnetworkproxy/GlobalNetworkProxyPresenter;", "Lid/dana/globalnetworkproxy/GlobalNetworkProxyContract$Presenter;", "", "", "p0", "p1", "Lcom/iap/ac/android/common/rpc/model/HttpResponse;", "PlaceComponentResult", "(Ljava/util/Map;Ljava/lang/String;)Lcom/iap/ac/android/common/rpc/model/HttpResponse;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "onDestroy", "Ldagger/Lazy;", "Lid/dana/domain/featureconfig/interactor/GetGlobalNetworkProxyConfig;", "MyBillsEntityDataFactory", "Ldagger/Lazy;", "Lid/dana/domain/globalnetwork/interactor/GnConsult;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/globalnetworkproxy/GlobalNetworkProxyContract$View;", "Lid/dana/globalnetworkproxy/GlobalNetworkProxyContract$View;", "p2", "<init>", "(Lid/dana/globalnetworkproxy/GlobalNetworkProxyContract$View;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GlobalNetworkProxyPresenter implements GlobalNetworkProxyContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GlobalNetworkProxyContract.View PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<GnConsult> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<GetGlobalNetworkProxyConfig> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    @Inject
    public GlobalNetworkProxyPresenter(GlobalNetworkProxyContract.View view, Lazy<GnConsult> lazy, Lazy<GetGlobalNetworkProxyConfig> lazy2) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.PlaceComponentResult = view;
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.MyBillsEntityDataFactory = lazy2;
        this.getAuthRequestContext = Reflection.getOrCreateKotlinClass(GlobalNetworkProxyPresenter.class).getSimpleName();
    }

    @Override // id.dana.globalnetworkproxy.GlobalNetworkProxyContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.get().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.globalnetworkproxy.GlobalNetworkProxyPresenter$getGnProxyConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                GlobalNetworkProxyContract.View view;
                view = GlobalNetworkProxyPresenter.this.PlaceComponentResult;
                view.KClassImpl$Data$declaredNonStaticMembers$2(z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.globalnetworkproxy.GlobalNetworkProxyPresenter$getGnProxyConfig$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                GlobalNetworkProxyContract.View view;
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                view = GlobalNetworkProxyPresenter.this.PlaceComponentResult;
                view.KClassImpl$Data$declaredNonStaticMembers$2(false);
                str = GlobalNetworkProxyPresenter.this.getAuthRequestContext;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, th.getMessage());
            }
        });
    }

    @Override // id.dana.globalnetworkproxy.GlobalNetworkProxyContract.Presenter
    public final HttpResponse PlaceComponentResult(Map<String, String> p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return GlobalNetworkProxyMapper.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get().buildUseCase(new GnConsult.Params(p0, p1)));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.get().dispose();
    }
}
