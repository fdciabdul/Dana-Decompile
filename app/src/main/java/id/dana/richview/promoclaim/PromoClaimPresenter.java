package id.dana.richview.promoclaim;

import android.content.Context;
import id.dana.danah5.DanaH5;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.GetPromoClaimConfig;
import id.dana.domain.promotion.Space;
import id.dana.domain.promotion.interactor.GetPromoClaimBanner;
import id.dana.mapper.LeaderboardMapper;
import id.dana.model.CdpContentModel;
import id.dana.model.LeaderboardModel;
import id.dana.richview.promoclaim.PromoClaimContract;
import id.dana.utils.ErrorUtil;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class PromoClaimPresenter implements PromoClaimContract.Presenter {
    String BuiltInFictitiousFunctionClassFactory;
    String KClassImpl$Data$declaredNonStaticMembers$2;
    final GetPromoClaimBanner MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;
    private final GetPromoClaimConfig getAuthRequestContext;
    private final LeaderboardMapper getErrorConfigVersion;
    private final PromoClaimContract.View moveToNextValue;

    @Inject
    public PromoClaimPresenter(Context context, PromoClaimContract.View view, GetPromoClaimBanner getPromoClaimBanner, GetPromoClaimConfig getPromoClaimConfig, LeaderboardMapper leaderboardMapper) {
        this.PlaceComponentResult = context;
        this.moveToNextValue = view;
        this.MyBillsEntityDataFactory = getPromoClaimBanner;
        this.getAuthRequestContext = getPromoClaimConfig;
        this.getErrorConfigVersion = leaderboardMapper;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.getAuthRequestContext.dispose();
    }

    @Override // id.dana.richview.promoclaim.PromoClaimContract.Presenter
    public final void PlaceComponentResult() {
        this.moveToNextValue.showProgress();
        this.getAuthRequestContext.execute(new DefaultObserver<Boolean>() { // from class: id.dana.richview.promoclaim.PromoClaimPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                PromoClaimPresenter.this.moveToNextValue.enableBanner(bool.booleanValue());
                if (Boolean.TRUE.equals(bool)) {
                    final PromoClaimPresenter promoClaimPresenter = PromoClaimPresenter.this;
                    promoClaimPresenter.MyBillsEntityDataFactory.execute(new DefaultObserver<Space>() { // from class: id.dana.richview.promoclaim.PromoClaimPresenter.2
                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public /* synthetic */ void onNext(Object obj2) {
                            PromoClaimPresenter.MyBillsEntityDataFactory(PromoClaimPresenter.this, (Space) obj2);
                        }

                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public void onError(Throwable th) {
                            super.onError(th);
                            PromoClaimPresenter.this.moveToNextValue.onError(ErrorUtil.PlaceComponentResult(th, PromoClaimPresenter.this.PlaceComponentResult));
                        }

                        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                        public void onComplete() {
                            if (PromoClaimPresenter.this.BuiltInFictitiousFunctionClassFactory == null || PromoClaimPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                                PromoClaimPresenter.this.moveToNextValue.enableBanner(false);
                            }
                        }
                    });
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                PromoClaimPresenter.this.moveToNextValue.enableBanner(false);
            }
        });
    }

    @Override // id.dana.richview.promoclaim.PromoClaimContract.Presenter
    public final void MyBillsEntityDataFactory() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        if (str != null) {
            DanaH5.startContainerFullUrl(str);
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(PromoClaimPresenter promoClaimPresenter, Space space) {
        LeaderboardModel apply;
        CdpContentModel cdpContentModel;
        if (space.getCdpContents() != null && (apply = promoClaimPresenter.getErrorConfigVersion.apply(space)) != null && (cdpContentModel = apply.BuiltInFictitiousFunctionClassFactory) != null) {
            promoClaimPresenter.BuiltInFictitiousFunctionClassFactory = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
            String str = cdpContentModel.GetContactSyncConfig;
            promoClaimPresenter.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            if (promoClaimPresenter.BuiltInFictitiousFunctionClassFactory != null && str != null) {
                promoClaimPresenter.moveToNextValue.onLoadBanner(str);
                promoClaimPresenter.moveToNextValue.dismissProgress();
                return;
            }
        }
        promoClaimPresenter.moveToNextValue.enableBanner(false);
    }
}
