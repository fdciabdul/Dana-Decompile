package id.dana.contract.deeplink;

import android.app.Activity;
import android.os.SystemClock;
import dagger.Lazy;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.tracker.AbstractDeeplinkTrackerFactory;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.deeplink.interactor.GetDeepLinkPayload;
import id.dana.domain.deeplink.interactor.InitSessionDeepLink;
import id.dana.domain.deeplink.interactor.RemoveDeepLinkPayload;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001Bc\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003¢\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lid/dana/contract/deeplink/DeepLinkPresenter;", "Lid/dana/contract/deeplink/DeepLinkContract$Presenter;", "view", "Ldagger/Lazy;", "Lid/dana/contract/deeplink/DeepLinkContract$View;", "initSessionDeepLink", "Lid/dana/domain/deeplink/interactor/InitSessionDeepLink;", "getDeepLinkPayload", "Lid/dana/domain/deeplink/interactor/GetDeepLinkPayload;", "getPhoneNumber", "Lid/dana/domain/account/interactor/GetPhoneNumber;", "deepLinkPayloadModelMapper", "Lid/dana/mapper/DeepLinkPayloadModelMapper;", "removeDeepLinkPayload", "Lid/dana/domain/deeplink/interactor/RemoveDeepLinkPayload;", "deeplinkTrackerFactory", "Lid/dana/contract/deeplink/tracker/AbstractDeeplinkTrackerFactory;", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Lid/dana/mapper/DeepLinkPayloadModelMapper;Ldagger/Lazy;Ldagger/Lazy;)V", "fetchPayload", "", "fromRoot", "", "phoneNumber", "", "getPayload", "initSession", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "onDestroy", "reInitSession", "removePayload", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public final class DeepLinkPresenter implements DeepLinkContract.Presenter {
    private final DeepLinkPayloadModelMapper BuiltInFictitiousFunctionClassFactory;
    private final Lazy<GetDeepLinkPayload> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<AbstractDeeplinkTrackerFactory> MyBillsEntityDataFactory;
    private final Lazy<DeepLinkContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Lazy<GetPhoneNumber> PlaceComponentResult;
    private final Lazy<InitSessionDeepLink> getAuthRequestContext;
    private final Lazy<RemoveDeepLinkPayload> moveToNextValue;

    @Inject
    public DeepLinkPresenter(Lazy<DeepLinkContract.View> lazy, Lazy<InitSessionDeepLink> lazy2, Lazy<GetDeepLinkPayload> lazy3, Lazy<GetPhoneNumber> lazy4, DeepLinkPayloadModelMapper deepLinkPayloadModelMapper, Lazy<RemoveDeepLinkPayload> lazy5, Lazy<AbstractDeeplinkTrackerFactory> lazy6) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(deepLinkPayloadModelMapper, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy;
        this.getAuthRequestContext = lazy2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy3;
        this.PlaceComponentResult = lazy4;
        this.BuiltInFictitiousFunctionClassFactory = deepLinkPayloadModelMapper;
        this.moveToNextValue = lazy5;
        this.MyBillsEntityDataFactory = lazy6;
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.Presenter
    public final void PlaceComponentResult(final boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().showProgress();
        this.PlaceComponentResult.get().execute(new DefaultObserver<String>() { // from class: id.dana.contract.deeplink.DeepLinkPresenter$getPayload$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                String str = (String) obj;
                Intrinsics.checkNotNullParameter(str, "");
                DeepLinkPresenter.this.MyBillsEntityDataFactory(z, str);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DEEPLINK_TAG, "Fail to get phone number from session, probably not exist", p0);
                DeepLinkPresenter.this.MyBillsEntityDataFactory(z, null);
            }
        });
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.Presenter
    public final void getAuthRequestContext(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().showProgress();
        DeeplinkLoadTimeTracker.lookAheadTest();
        this.getAuthRequestContext.get().execute(new DeepLinkObserver(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), true, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().KClassImpl$Data$declaredNonStaticMembers$2(), this.BuiltInFictitiousFunctionClassFactory), InitSessionDeepLink.Params.forInitSession(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(boolean z, String str) {
        DeeplinkLoadTimeTracker.BuiltInFictitiousFunctionClassFactory = SystemClock.elapsedRealtime();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new DeepLinkObserver(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().KClassImpl$Data$declaredNonStaticMembers$2(), str, this.BuiltInFictitiousFunctionClassFactory), GetDeepLinkPayload.Params.fromRoot(z));
    }

    @Override // id.dana.contract.deeplink.DeepLinkContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().showProgress();
        DeeplinkLoadTimeTracker.lookAheadTest();
        this.getAuthRequestContext.get().execute(new DeepLinkObserver(this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), false, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().KClassImpl$Data$declaredNonStaticMembers$2(), this.BuiltInFictitiousFunctionClassFactory), InitSessionDeepLink.Params.forInitSession(activity));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.getAuthRequestContext.get().dispose();
    }
}
