package id.dana.contract.shortener;

import dagger.Lazy;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.shortener.interactor.RestoreUrl;
import id.dana.network.exception.NetworkException;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

@PerActivity
/* loaded from: classes4.dex */
public class RestoreUrlPresenter implements RestoreUrlContract.Presenter {
    private final Lazy<RestoreUrlContract.View> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<RestoreUrl> getAuthRequestContext;

    @Inject
    public RestoreUrlPresenter(Lazy<RestoreUrlContract.View> lazy, Lazy<RestoreUrl> lazy2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.getAuthRequestContext = lazy2;
    }

    @Override // id.dana.contract.shortener.RestoreUrlContract.Presenter
    public final void getAuthRequestContext(String str, final String str2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().showProgress();
        this.getAuthRequestContext.get().execute(new DefaultObserver<String>() { // from class: id.dana.contract.shortener.RestoreUrlPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ((RestoreUrlContract.View) RestoreUrlPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.get()).dismissProgress();
                ((RestoreUrlContract.View) RestoreUrlPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.get()).PlaceComponentResult((String) obj, str2);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                if (th instanceof NetworkException) {
                    Crashlytics BuiltInFictitiousFunctionClassFactory = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                    Intrinsics.checkNotNullParameter("case", "");
                    Intrinsics.checkNotNullParameter("RestoreUrl Error", "");
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setCustomKey("case", "RestoreUrl Error");
                    StringBuilder sb = new StringBuilder();
                    sb.append("errorCode: ");
                    NetworkException networkException = (NetworkException) th;
                    sb.append(networkException.getErrorCode());
                    String obj = sb.toString();
                    Intrinsics.checkNotNullParameter(obj, "");
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("errorMessage: ");
                    sb2.append(th.getMessage());
                    String obj2 = sb2.toString();
                    Intrinsics.checkNotNullParameter(obj2, "");
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj2);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("traceId: ");
                    sb3.append(networkException.getTraceId());
                    String obj3 = sb3.toString();
                    Intrinsics.checkNotNullParameter(obj3, "");
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.log(obj3);
                    Intrinsics.checkNotNullParameter(th, "");
                    BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.recordException(th);
                }
                ((RestoreUrlContract.View) RestoreUrlPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.get()).dismissProgress();
                ((RestoreUrlContract.View) RestoreUrlPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.get()).onError(th.getMessage());
            }
        }, RestoreUrl.Params.forRestoreUrl(str));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.get().dispose();
    }
}
