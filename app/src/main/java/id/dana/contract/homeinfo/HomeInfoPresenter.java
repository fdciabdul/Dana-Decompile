package id.dana.contract.homeinfo;

import android.text.TextUtils;
import dagger.Lazy;
import id.dana.contract.homeinfo.HomeInfoContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.domain.homeinfo.HomeData;
import id.dana.domain.homeinfo.HomeInfoResponse;
import id.dana.domain.homeinfo.ProcessingTransactionModel;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.interactor.GetPaylaterChannel;
import id.dana.domain.homeinfo.interactor.GetProcessingTransaction;
import id.dana.domain.homeinfo.interactor.GetSurveyInfo;
import id.dana.domain.homeinfo.interactor.GetUpdatedHomeData;
import id.dana.domain.homeinfo.interactor.GetUserConfig;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm;
import id.dana.domain.nearbyme.model.MerchantConsult;
import id.dana.domain.nearbyme.model.MerchantReviewSummary;
import id.dana.domain.nearbyme.model.Tag;
import id.dana.domain.paylater.interactor.SetPaylaterChannel;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.domain.wallet_v3.model.SurveyInfoModel;
import id.dana.mapper.HomeDataModelMapper;
import id.dana.mapper.HomeInfoMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantAverageRatingMapper;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import id.dana.sync_engine.domain.interactor.GetConfigRepeatBackgroundJobUseCase;
import id.dana.sync_engine.domain.interactor.GetIsSyncPermission;
import id.dana.sync_engine.domain.interactor.GetSyncPermissionConfigUseCase;
import id.dana.sync_engine.domain.interactor.SaveIsSyncPermission;
import id.dana.sync_engine.domain.model.SyncPermissionAndChangeConfig;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@PerActivity
/* loaded from: classes4.dex */
public class HomeInfoPresenter implements HomeInfoContract.Presenter {
    final Lazy<HomeInfoContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<GetSurveyInfo> DatabaseTableConfigUtil;
    private final Lazy<GetReviewableMerchantForm> GetContactSyncConfig;
    final Lazy<MerchantAverageRatingMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    final Lazy<SaveIsSyncPermission> MyBillsEntityDataFactory;
    private final Lazy<GetConfigRepeatBackgroundJobUseCase> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Lazy<GetUpdatedHomeData> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Lazy<GetSyncPermissionConfigUseCase> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Lazy<StartupConfigEntityData> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final Lazy<SetPaylaterChannel> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Lazy<SaveShowToolTip> NetworkUserEntityData$$ExternalSyntheticLambda8;
    final Lazy<NearbyShopsModelMapper> PlaceComponentResult;
    private final Lazy<IsNeedToShowToolTip> PrepareContext;
    final Lazy<GetMerchantReviewSummary> getAuthRequestContext;
    private final Lazy<GetIsSyncPermission> getErrorConfigVersion;
    private final Lazy<GetUserConfig> initRecordTimeStamp;
    private final Lazy<HomeInfoMapper> isLayoutRequested;
    private final Lazy<GetPaylaterChannel> lookAheadTest;
    private final Lazy<GetProcessingTransaction> moveToNextValue;
    private final Lazy<HomeDataModelMapper> newProxyInstance;
    private final Lazy<GetHomeInfo> scheduleImpl;

    @Inject
    public HomeInfoPresenter(Lazy<HomeInfoContract.View> lazy, Lazy<GetHomeInfo> lazy2, Lazy<HomeInfoMapper> lazy3, Lazy<GetUpdatedHomeData> lazy4, Lazy<HomeDataModelMapper> lazy5, Lazy<IsNeedToShowToolTip> lazy6, Lazy<SaveShowToolTip> lazy7, Lazy<GetReviewableMerchantForm> lazy8, Lazy<NearbyShopsModelMapper> lazy9, Lazy<GetUserConfig> lazy10, Lazy<GetMerchantReviewSummary> lazy11, Lazy<GetSyncPermissionConfigUseCase> lazy12, Lazy<GetIsSyncPermission> lazy13, Lazy<SaveIsSyncPermission> lazy14, Lazy<GetConfigRepeatBackgroundJobUseCase> lazy15, Lazy<MerchantAverageRatingMapper> lazy16, Lazy<SetPaylaterChannel> lazy17, Lazy<StartupConfigEntityData> lazy18, Lazy<GetSurveyInfo> lazy19, Lazy<GetPaylaterChannel> lazy20, Lazy<GetProcessingTransaction> lazy21) {
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.scheduleImpl = lazy2;
        this.isLayoutRequested = lazy3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy4;
        this.newProxyInstance = lazy5;
        this.PrepareContext = lazy6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = lazy7;
        this.GetContactSyncConfig = lazy8;
        this.PlaceComponentResult = lazy9;
        this.initRecordTimeStamp = lazy10;
        this.getAuthRequestContext = lazy11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lazy12;
        this.getErrorConfigVersion = lazy13;
        this.MyBillsEntityDataFactory = lazy14;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy15;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy16;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = lazy17;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = lazy18;
        this.DatabaseTableConfigUtil = lazy19;
        this.lookAheadTest = lazy20;
        this.moveToNextValue = lazy21;
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        final QueryUserDataConfig queryUserDataConfig = this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().getQueryUserDataConfig();
        this.scheduleImpl.get().execute(new DefaultObserver<HomeInfoResponse>() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                HomeInfoResponse homeInfoResponse = (HomeInfoResponse) obj;
                if (!queryUserDataConfig.getSeperatePaylaterChannel()) {
                    ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).dismissProgress();
                    HomeInfoPresenter.this.MyBillsEntityDataFactory(homeInfoResponse.getPaylaterChannel());
                } else {
                    HomeInfoPresenter.BuiltInFictitiousFunctionClassFactory(HomeInfoPresenter.this);
                }
                ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).onGetHomeInfo(((HomeInfoMapper) HomeInfoPresenter.this.isLayoutRequested.get()).KClassImpl$Data$declaredNonStaticMembers$2(homeInfoResponse));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).dismissProgress();
                ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).onError(th.getMessage());
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.HOME_GETHOMEINFO_PREFIX);
                sb.append(getClass().getName());
                sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.HOME_TAG, sb.toString(), th);
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.Presenter
    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        this.DatabaseTableConfigUtil.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HomeInfoPresenter homeInfoPresenter = HomeInfoPresenter.this;
                homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().dismissProgress();
                homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().onGetSurveyInfo((SurveyInfoModel) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HomeInfoPresenter homeInfoPresenter = HomeInfoPresenter.this;
                homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().dismissProgress();
                homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().onError(((Throwable) obj).getMessage());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        this.moveToNextValue.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HomeInfoPresenter homeInfoPresenter = HomeInfoPresenter.this;
                homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().dismissProgress();
                homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().onGetProcessingTransaction((ProcessingTransactionModel) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HomeInfoPresenter homeInfoPresenter = HomeInfoPresenter.this;
                homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().dismissProgress();
                homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().onError(((Throwable) obj).getMessage());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().execute(new DefaultObserver<HomeData>() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).dismissProgress();
                ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).onGetHomeData(((HomeDataModelMapper) HomeInfoPresenter.this.newProxyInstance.get()).apply((HomeData) obj));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).dismissProgress();
            }
        }, NoParams.INSTANCE);
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        this.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        this.PrepareContext.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter.3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).dismissProgress();
                ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).onShowTooltip(((Boolean) obj).booleanValue());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).dismissProgress();
                ((HomeInfoContract.View) HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get()).onShowTooltip(false);
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.IS_NEED_TO_SHOW_TOOLTIP_PREFIX);
                sb.append(getClass().getName());
                sb.append("on Error");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), th);
            }
        }, IsNeedToShowToolTip.Params.forShowTooltip(str));
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.Presenter
    public final void getAuthRequestContext(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter.4
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SAVE_SHOW_TOOLTIP_PREFIX);
                sb.append(getClass().getName());
                sb.append("on Error");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), th);
            }
        }, SaveShowToolTip.Params.forSaveShowToolTip(true, str));
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.Presenter
    public final void PlaceComponentResult(final String str, String str2, boolean z) {
        this.BuiltInFictitiousFunctionClassFactory.get().showProgress();
        this.GetContactSyncConfig.get().execute(new GetReviewableMerchantForm.Param(str2, z), new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                final HomeInfoPresenter homeInfoPresenter = HomeInfoPresenter.this;
                String str3 = str;
                MerchantConsult merchantConsult = (MerchantConsult) obj;
                String merchantId = merchantConsult.getReviewableShop().getMerchantId();
                final MerchantConsultReviewModel merchantConsultReviewModel = new MerchantConsultReviewModel(homeInfoPresenter.PlaceComponentResult.get().PlaceComponentResult(merchantConsult.getReviewableShop()), HomeInfoPresenter.getAuthRequestContext(merchantConsult.getPositiveTags()), HomeInfoPresenter.getAuthRequestContext(merchantConsult.getNegativeSentiments()), "", !TextUtils.isEmpty(merchantId) ? merchantId : "", 0);
                Intrinsics.checkNotNullParameter(str3, "");
                merchantConsultReviewModel.scheduleImpl = str3;
                homeInfoPresenter.getAuthRequestContext.get().execute(new GetMerchantReviewSummary.Param(merchantConsultReviewModel.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda3, merchantConsultReviewModel.MyBillsEntityDataFactory.BottomSheetCardBindingView$watcherCardNumberView$1), new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        HomeInfoPresenter homeInfoPresenter2 = HomeInfoPresenter.this;
                        MerchantConsultReviewModel merchantConsultReviewModel2 = merchantConsultReviewModel;
                        homeInfoPresenter2.BuiltInFictitiousFunctionClassFactory.get().dismissProgress();
                        HomeInfoContract.View view = homeInfoPresenter2.BuiltInFictitiousFunctionClassFactory.get();
                        homeInfoPresenter2.KClassImpl$Data$declaredNonStaticMembers$2.get();
                        view.onShouldShowMerchant(merchantConsultReviewModel2, MerchantAverageRatingMapper.KClassImpl$Data$declaredNonStaticMembers$2((MerchantReviewSummary) obj2).MyBillsEntityDataFactory);
                        return null;
                    }
                }, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Exception exc = (Exception) obj2;
                        HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get().dismissProgress();
                        DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", exc.getMessage(), exc);
                        return null;
                    }
                });
                return null;
            }
        }, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HomeInfoPresenter homeInfoPresenter = HomeInfoPresenter.this;
                Exception exc = (Exception) obj;
                homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().dismissProgress();
                homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().onShowMerchantReviewCheckingError();
                DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", exc.getMessage(), exc);
                return null;
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.Presenter
    public final void getErrorConfigVersion() {
        this.initRecordTimeStamp.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter.5
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CONVERT_USER_CONFIG, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.Presenter
    public final void moveToNextValue() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get().onGetSyncPermissionConfig((SyncPermissionAndChangeConfig) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeInfoPresenter.getAuthRequestContext((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit getAuthRequestContext(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_SYNC_PERMISSION_CONFIG, th.getMessage(), th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_SYNC_CONTACT_CONFIG, th.getMessage(), th);
        return Unit.INSTANCE;
    }

    @Override // id.dana.contract.homeinfo.HomeInfoContract.Presenter
    public final void PlaceComponentResult() {
        this.getErrorConfigVersion.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HomeInfoPresenter homeInfoPresenter = HomeInfoPresenter.this;
                if (!((Boolean) obj).booleanValue()) {
                    homeInfoPresenter.BuiltInFictitiousFunctionClassFactory.get().onGetIsSyncPermission();
                    homeInfoPresenter.MyBillsEntityDataFactory.get().execute(Boolean.TRUE, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit unit;
                            Boolean bool = (Boolean) obj2;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    }, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return HomeInfoPresenter.KClassImpl$Data$declaredNonStaticMembers$2((Throwable) obj2);
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HomeInfoPresenter.PlaceComponentResult((Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit PlaceComponentResult(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_IS_SYNC_PERMISSION, th.getMessage(), th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_IS_SYNC_PERMISSION, th.getMessage(), th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<MerchantReviewTagModel> getAuthRequestContext(List<Tag> list) {
        ArrayList arrayList = new ArrayList();
        for (Tag tag : list) {
            MerchantReviewTagModel.Companion companion = MerchantReviewTagModel.INSTANCE;
            arrayList.add(MerchantReviewTagModel.Companion.PlaceComponentResult(tag));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().execute(str, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Boolean bool = (Boolean) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HomeInfoPresenter homeInfoPresenter = HomeInfoPresenter.this;
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.PAYLATER_CHANNEL);
                sb.append(homeInfoPresenter.getClass().getName());
                sb.append(DanaLogConstants.ExceptionType.GENERAL_ERROR_EXCEPTION);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.HOME_TAG, sb.toString(), (Throwable) obj);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().dispose();
        this.scheduleImpl.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().dispose();
        this.PrepareContext.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.get().dispose();
        this.GetContactSyncConfig.get().dispose();
        this.initRecordTimeStamp.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2.get().dispose();
        this.getErrorConfigVersion.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.DatabaseTableConfigUtil.get().dispose();
        this.lookAheadTest.get().dispose();
        this.moveToNextValue.get().dispose();
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final HomeInfoPresenter homeInfoPresenter) {
        homeInfoPresenter.lookAheadTest.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                HomeInfoPresenter homeInfoPresenter2 = HomeInfoPresenter.this;
                homeInfoPresenter2.BuiltInFictitiousFunctionClassFactory.get().dismissProgress();
                homeInfoPresenter2.MyBillsEntityDataFactory((String) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.homeinfo.HomeInfoPresenter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                HomeInfoPresenter.this.BuiltInFictitiousFunctionClassFactory.get().dismissProgress();
                return Unit.INSTANCE;
            }
        });
    }
}
