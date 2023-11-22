package id.dana.richview.homereferral;

import android.text.TextUtils;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.promotion.Space;
import id.dana.domain.promotion.interactor.GetHomeReferralBanner;
import id.dana.domain.promotion.interactor.GetHomeReferralP2PBanner;
import id.dana.domain.referral.interactor.GetReferralStatusConsult;
import id.dana.domain.referral.model.ReferralStatusConsultResponse;
import id.dana.domain.referralconfig.interactor.GetReferralHomeConfig;
import id.dana.domain.referralconfig.interactor.GetReferralSendMoneyConfig;
import id.dana.domain.referralconfig.model.ReferralConfig;
import id.dana.mapper.LeaderboardMapper;
import id.dana.mapper.ReferralStatusMapper;
import id.dana.model.CdpContentModel;
import id.dana.model.LeaderboardModel;
import id.dana.richview.homereferral.HomeReferralContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes9.dex */
public class HomeReferralPresenter implements HomeReferralContract.Presenter {
    final HomeReferralContract.View BuiltInFictitiousFunctionClassFactory;
    private Space DatabaseTableConfigUtil;
    private final LeaderboardMapper GetContactSyncConfig;
    private final GetHomeReferralP2PBanner NetworkUserEntityData$$ExternalSyntheticLambda0;
    private ReferralConfig NetworkUserEntityData$$ExternalSyntheticLambda2;
    private String NetworkUserEntityData$$ExternalSyntheticLambda8;
    final ReferralStatusMapper PlaceComponentResult;
    private String PrepareContext;
    ReferralStatusConsultResponse getAuthRequestContext;
    private final GetHomeReferralBanner getErrorConfigVersion;
    private ReferralConfig initRecordTimeStamp;
    private final GetReferralSendMoneyConfig lookAheadTest;
    private final GetReferralStatusConsult moveToNextValue;
    private final GetReferralHomeConfig scheduleImpl;
    private final PublishSubject<Boolean> KClassImpl$Data$declaredNonStaticMembers$2 = PublishSubject.PlaceComponentResult();
    private final PublishSubject<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda1 = PublishSubject.PlaceComponentResult();
    private final CompositeDisposable MyBillsEntityDataFactory = new CompositeDisposable();

    @Inject
    public HomeReferralPresenter(GetReferralHomeConfig getReferralHomeConfig, GetReferralSendMoneyConfig getReferralSendMoneyConfig, GetReferralStatusConsult getReferralStatusConsult, GetHomeReferralP2PBanner getHomeReferralP2PBanner, GetHomeReferralBanner getHomeReferralBanner, LeaderboardMapper leaderboardMapper, ReferralStatusMapper referralStatusMapper, HomeReferralContract.View view) {
        this.scheduleImpl = getReferralHomeConfig;
        this.moveToNextValue = getReferralStatusConsult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = getHomeReferralP2PBanner;
        this.getErrorConfigVersion = getHomeReferralBanner;
        this.GetContactSyncConfig = leaderboardMapper;
        this.PlaceComponentResult = referralStatusMapper;
        this.lookAheadTest = getReferralSendMoneyConfig;
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.scheduleImpl.dispose();
        this.lookAheadTest.dispose();
        this.moveToNextValue.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.getErrorConfigVersion.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    @Override // id.dana.richview.homereferral.HomeReferralContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Disposable subscribe = Observable.zip(this.KClassImpl$Data$declaredNonStaticMembers$2, this.NetworkUserEntityData$$ExternalSyntheticLambda1, new BiFunction() { // from class: id.dana.richview.homereferral.HomeReferralPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                valueOf = Boolean.valueOf(r0.booleanValue() && r1.booleanValue());
                return valueOf;
            }
        }).subscribe(new Consumer() { // from class: id.dana.richview.homereferral.HomeReferralPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                HomeReferralPresenter homeReferralPresenter = HomeReferralPresenter.this;
                if (((Boolean) obj).booleanValue()) {
                    homeReferralPresenter.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                    homeReferralPresenter.BuiltInFictitiousFunctionClassFactory();
                    if (homeReferralPresenter.MyBillsEntityDataFactory() && homeReferralPresenter.getAuthRequestContext()) {
                        homeReferralPresenter.BuiltInFictitiousFunctionClassFactory.onGetReferralStatusConsultSuccess(homeReferralPresenter.PlaceComponentResult.apply(homeReferralPresenter.getAuthRequestContext));
                    }
                }
            }
        });
        if (subscribe != null) {
            this.MyBillsEntityDataFactory.getAuthRequestContext(subscribe);
        }
    }

    @Override // id.dana.richview.homereferral.HomeReferralContract.Presenter
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.scheduleImpl.execute(new DefaultObserver<ReferralConfig>() { // from class: id.dana.richview.homereferral.HomeReferralPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                HomeReferralPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = (ReferralConfig) obj;
                HomeReferralPresenter.KClassImpl$Data$declaredNonStaticMembers$2(HomeReferralPresenter.this);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.HOME_REFERRAL, sb.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2.isEnabled() || this.initRecordTimeStamp.isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory() {
        return (this.DatabaseTableConfigUtil == null || TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda8) || TextUtils.isEmpty(this.PrepareContext)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.enableEntryPoint(MyBillsEntityDataFactory() && getAuthRequestContext());
        this.BuiltInFictitiousFunctionClassFactory.enableBanner(MyBillsEntityDataFactory() && getAuthRequestContext());
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(HomeReferralPresenter homeReferralPresenter) {
        homeReferralPresenter.lookAheadTest.execute(new DefaultObserver<ReferralConfig>() { // from class: id.dana.richview.homereferral.HomeReferralPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                HomeReferralPresenter.this.initRecordTimeStamp = (ReferralConfig) obj;
                if (!HomeReferralPresenter.this.getAuthRequestContext()) {
                    HomeReferralPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                    HomeReferralPresenter.this.BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                HomeReferralPresenter.getAuthRequestContext(HomeReferralPresenter.this);
                HomeReferralPresenter.PlaceComponentResult(HomeReferralPresenter.this);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.HOME_REFERRAL, sb.toString());
            }
        });
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(HomeReferralPresenter homeReferralPresenter, Space space) {
        LeaderboardModel apply;
        CdpContentModel cdpContentModel;
        if (space.getCdpContents() != null && (apply = homeReferralPresenter.GetContactSyncConfig.apply(space)) != null && (cdpContentModel = apply.BuiltInFictitiousFunctionClassFactory) != null) {
            homeReferralPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8 = cdpContentModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
            homeReferralPresenter.PrepareContext = cdpContentModel.GetContactSyncConfig;
            if (!TextUtils.isEmpty(homeReferralPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8) && !TextUtils.isEmpty(homeReferralPresenter.PrepareContext)) {
                homeReferralPresenter.BuiltInFictitiousFunctionClassFactory.saveEntryPointUrl(homeReferralPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8);
                homeReferralPresenter.BuiltInFictitiousFunctionClassFactory.onLoadBanner(homeReferralPresenter.PrepareContext);
                homeReferralPresenter.KClassImpl$Data$declaredNonStaticMembers$2.onNext(Boolean.TRUE);
                return;
            }
        }
        homeReferralPresenter.BuiltInFictitiousFunctionClassFactory.dismissProgress();
        homeReferralPresenter.BuiltInFictitiousFunctionClassFactory();
    }

    static /* synthetic */ void getAuthRequestContext(HomeReferralPresenter homeReferralPresenter) {
        if (homeReferralPresenter.initRecordTimeStamp.isEnabled()) {
            homeReferralPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DefaultObserver<Space>() { // from class: id.dana.richview.homereferral.HomeReferralPresenter.4
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    Space space = (Space) obj;
                    HomeReferralPresenter.this.DatabaseTableConfigUtil = space;
                    HomeReferralPresenter.KClassImpl$Data$declaredNonStaticMembers$2(HomeReferralPresenter.this, space);
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public void onError(Throwable th) {
                    super.onError(th);
                    HomeReferralPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                    HomeReferralPresenter.this.BuiltInFictitiousFunctionClassFactory();
                    CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.REFERRAL_GET_HOME_REFERRAL_P2P_BANNER, DanaLogConstants.ExceptionType.PROMO_CENTER_EXCEPTION, th);
                }
            });
        } else {
            homeReferralPresenter.getErrorConfigVersion.execute(new DefaultObserver<Space>() { // from class: id.dana.richview.homereferral.HomeReferralPresenter.5
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    Space space = (Space) obj;
                    HomeReferralPresenter.this.DatabaseTableConfigUtil = space;
                    HomeReferralPresenter.KClassImpl$Data$declaredNonStaticMembers$2(HomeReferralPresenter.this, space);
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public void onError(Throwable th) {
                    super.onError(th);
                    HomeReferralPresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                    HomeReferralPresenter.this.BuiltInFictitiousFunctionClassFactory();
                    CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.REFERRAL_GET_HOME_REFERRAL_BANNER, DanaLogConstants.ExceptionType.PROMO_CENTER_EXCEPTION, th);
                }
            });
        }
    }

    static /* synthetic */ void PlaceComponentResult(HomeReferralPresenter homeReferralPresenter) {
        homeReferralPresenter.moveToNextValue.execute(new DefaultObserver<ReferralStatusConsultResponse>() { // from class: id.dana.richview.homereferral.HomeReferralPresenter.3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                HomeReferralPresenter.this.getAuthRequestContext = (ReferralStatusConsultResponse) obj;
                HomeReferralPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1.onNext(Boolean.TRUE);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.Prefix.REFERRAL_GET_REFERRAL_STATUS_CONSULT, DanaLogConstants.ExceptionType.PROMO_CENTER_EXCEPTION, th);
            }
        });
    }
}
