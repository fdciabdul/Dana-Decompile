package id.dana.contract.deeplink;

import android.content.Intent;
import android.os.SystemClock;
import dagger.Lazy;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class ReadLinkPropertiesPresenter implements ReadLinkPropertiesContract.Presenter {
    private final Lazy<DeepLinkContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<DeeplinkTracker> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<DeepLinkPayloadModelMapper> MyBillsEntityDataFactory;
    private final Lazy<GetUserId> PlaceComponentResult;
    private final Lazy<ReadDeepLinkProperties> getAuthRequestContext;

    @Inject
    public ReadLinkPropertiesPresenter(Lazy<DeepLinkContract.View> lazy, Lazy<ReadDeepLinkProperties> lazy2, Lazy<DeepLinkPayloadModelMapper> lazy3, Lazy<GetUserId> lazy4, Lazy<DeeplinkTracker> lazy5) {
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.getAuthRequestContext = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
        this.PlaceComponentResult = lazy4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy5;
    }

    /* renamed from: id.dana.contract.deeplink.ReadLinkPropertiesPresenter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 extends DefaultObserver<String> {
        final /* synthetic */ String MyBillsEntityDataFactory;
        final /* synthetic */ String getAuthRequestContext;

        AnonymousClass1(String str, String str2) {
            this.getAuthRequestContext = str;
            this.MyBillsEntityDataFactory = str2;
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            String str = (String) obj;
            ReadLinkPropertiesPresenter.MyBillsEntityDataFactory(ReadLinkPropertiesPresenter.this, this.getAuthRequestContext, this.MyBillsEntityDataFactory);
            ((GetUserId) ReadLinkPropertiesPresenter.this.PlaceComponentResult.get()).dispose();
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            super.onError(th);
            ReadLinkPropertiesPresenter.MyBillsEntityDataFactory(ReadLinkPropertiesPresenter.this, this.getAuthRequestContext, this.MyBillsEntityDataFactory);
        }
    }

    @Override // id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter
    public final void MyBillsEntityDataFactory(String str) {
        this.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        this.PlaceComponentResult.get().execute(new AnonymousClass1(str, this.BuiltInFictitiousFunctionClassFactory.get().KClassImpl$Data$declaredNonStaticMembers$2()));
    }

    @Override // id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        this.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        this.PlaceComponentResult.get().execute(new AnonymousClass1(str, str2));
    }

    @Override // id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter
    public final void MyBillsEntityDataFactory(String str, Intent intent) {
        this.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        DeeplinkLoadTimeTracker.BuiltInFictitiousFunctionClassFactory = SystemClock.elapsedRealtime();
        this.getAuthRequestContext.get().execute(new DeepLinkObserver(this.BuiltInFictitiousFunctionClassFactory.get(), this.BuiltInFictitiousFunctionClassFactory.get().KClassImpl$Data$declaredNonStaticMembers$2(), this.MyBillsEntityDataFactory.get(), intent, this.KClassImpl$Data$declaredNonStaticMembers$2.get()), ReadDeepLinkProperties.Params.forLinkRead(str));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().dismissProgress();
        this.getAuthRequestContext.get().dispose();
    }

    @Override // id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter
    public final void PlaceComponentResult(String str) {
        this.PlaceComponentResult.get().execute(new AnonymousClass1(str, this.BuiltInFictitiousFunctionClassFactory.get().KClassImpl$Data$declaredNonStaticMembers$2()));
    }

    static /* synthetic */ void MyBillsEntityDataFactory(ReadLinkPropertiesPresenter readLinkPropertiesPresenter, String str, String str2) {
        DeeplinkLoadTimeTracker.BuiltInFictitiousFunctionClassFactory = SystemClock.elapsedRealtime();
        readLinkPropertiesPresenter.getAuthRequestContext.get().execute(new DeepLinkObserver(readLinkPropertiesPresenter.BuiltInFictitiousFunctionClassFactory.get(), false, str2, readLinkPropertiesPresenter.MyBillsEntityDataFactory.get(), readLinkPropertiesPresenter.KClassImpl$Data$declaredNonStaticMembers$2.get()), ReadDeepLinkProperties.Params.forLinkRead(str));
    }
}
