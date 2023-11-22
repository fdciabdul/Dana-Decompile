package id.dana.contract.promotion;

import android.content.Context;
import dagger.Lazy;
import id.dana.contract.promotion.InterstitialPromotionBannerContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckInterstitialBannerFeature;
import id.dana.domain.promotion.interactor.GetInterstitialPromotionBanner;
import id.dana.domain.promotion.interactor.ReadInterstitialPromotionBanner;
import id.dana.domain.promotion.interactor.SaveInterstitialBannerGapTime;
import id.dana.domain.promotion.interactor.SaveInterstitialBannerResetTime;
import id.dana.domain.promotion.model.BannerCollection;
import id.dana.mapper.BannerModelMapperKt;
import id.dana.utils.ErrorUtil;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@PerActivity
/* loaded from: classes4.dex */
public class InterstitialPromotionBannerPresenter implements InterstitialPromotionBannerContract.Presenter {
    Lazy<SaveInterstitialBannerResetTime> BuiltInFictitiousFunctionClassFactory;
    final Lazy<GetInterstitialPromotionBanner> KClassImpl$Data$declaredNonStaticMembers$2;
    Lazy<CheckInterstitialBannerFeature> MyBillsEntityDataFactory;
    private final Lazy<ReadInterstitialPromotionBanner> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final Context PlaceComponentResult;
    Lazy<SaveInterstitialBannerGapTime> getAuthRequestContext;
    final Lazy<InterstitialPromotionBannerContract.View> moveToNextValue;

    @Inject
    public InterstitialPromotionBannerPresenter(Lazy<InterstitialPromotionBannerContract.View> lazy, Lazy<GetInterstitialPromotionBanner> lazy2, Lazy<ReadInterstitialPromotionBanner> lazy3, Context context) {
        this.moveToNextValue = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy3;
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.contract.promotion.InterstitialPromotionBannerContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.moveToNextValue.get().showProgress();
        this.MyBillsEntityDataFactory.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.promotion.InterstitialPromotionBannerPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                final InterstitialPromotionBannerPresenter interstitialPromotionBannerPresenter = InterstitialPromotionBannerPresenter.this;
                if (!((Boolean) obj).booleanValue()) {
                    interstitialPromotionBannerPresenter.moveToNextValue.get().MyBillsEntityDataFactory();
                } else {
                    interstitialPromotionBannerPresenter.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.promotion.InterstitialPromotionBannerPresenter$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            InterstitialPromotionBannerPresenter interstitialPromotionBannerPresenter2 = InterstitialPromotionBannerPresenter.this;
                            interstitialPromotionBannerPresenter2.moveToNextValue.get().dismissProgress();
                            interstitialPromotionBannerPresenter2.moveToNextValue.get().PlaceComponentResult(BannerModelMapperKt.getAuthRequestContext((BannerCollection) obj2));
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: id.dana.contract.promotion.InterstitialPromotionBannerPresenter$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            InterstitialPromotionBannerPresenter interstitialPromotionBannerPresenter2 = InterstitialPromotionBannerPresenter.this;
                            interstitialPromotionBannerPresenter2.moveToNextValue.get().dismissProgress();
                            interstitialPromotionBannerPresenter2.moveToNextValue.get().onError(ErrorUtil.PlaceComponentResult((Throwable) obj2, interstitialPromotionBannerPresenter2.PlaceComponentResult));
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.promotion.InterstitialPromotionBannerPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                InterstitialPromotionBannerPresenter interstitialPromotionBannerPresenter = InterstitialPromotionBannerPresenter.this;
                interstitialPromotionBannerPresenter.moveToNextValue.get().dismissProgress();
                interstitialPromotionBannerPresenter.moveToNextValue.get().onError(ErrorUtil.PlaceComponentResult((Throwable) obj, interstitialPromotionBannerPresenter.PlaceComponentResult));
                interstitialPromotionBannerPresenter.moveToNextValue.get().MyBillsEntityDataFactory();
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.contract.promotion.InterstitialPromotionBannerContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.promotion.InterstitialPromotionBannerPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                InterstitialPromotionBannerContract.View view = (InterstitialPromotionBannerContract.View) InterstitialPromotionBannerPresenter.this.moveToNextValue.get();
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                ((InterstitialPromotionBannerContract.View) InterstitialPromotionBannerPresenter.this.moveToNextValue.get()).onError("");
            }
        }, ReadInterstitialPromotionBanner.Params.forReadInterstitialPromotionBanner(str));
    }

    @Override // id.dana.contract.promotion.InterstitialPromotionBannerContract.Presenter
    public final void getAuthRequestContext() {
        this.getAuthRequestContext.get().execute(new DefaultObserver(), SaveInterstitialBannerGapTime.Params.forSaveInterstitialBannerGapTime(System.currentTimeMillis()));
    }

    @Override // id.dana.contract.promotion.InterstitialPromotionBannerContract.Presenter
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(new DefaultObserver(), SaveInterstitialBannerResetTime.Params.forSaveInterstitialBannerResetTime(Long.valueOf(System.currentTimeMillis())));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
    }
}
