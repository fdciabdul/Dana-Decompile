package id.dana.contract.nearbyme;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import id.dana.contract.nearbyme.NearbyMeContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.account.Account;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckNearbyMeFeature;
import id.dana.domain.merchant.MerchantCategoryType;
import id.dana.domain.nearbyme.interactor.GetAutoSearchConfig;
import id.dana.domain.nearbyme.interactor.GetDistrictNameByLocation;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius;
import id.dana.domain.nearbyme.interactor.IsNearbyReviewPageEnabled;
import id.dana.domain.nearbyme.interactor.IsNeedToShowOnboardingToolTip;
import id.dana.domain.nearbyme.interactor.SaveShowOnboardingTooltip;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview;
import id.dana.domain.nearbyme.model.MerchantConsult;
import id.dana.domain.nearbyme.model.MerchantInfo;
import id.dana.domain.nearbyme.model.NearbyAutoSearchConfig;
import id.dana.domain.nearbyme.model.NearbyConfig;
import id.dana.domain.nearbyme.model.NearbyRankingConfig;
import id.dana.domain.nearbyme.model.ShopListRequest;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import id.dana.drawable.ShopRankingCalculator;
import id.dana.nearbyme.LocationSourceTrackerWrapper;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.extension.ShopModelExtKt;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.NearbyShopsModel;
import id.dana.nearbyme.model.SearchConfigModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ErrorUtil;
import id.dana.utils.LocationUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class NearbyPresenter implements NearbyMeContract.Presenter, Disposable {
    private final GetDistrictNameByLocation A;
    private final SaveShowOnboardingTooltip AppCompatEmojiTextHelper;
    private final GetAutoSearchConfig B;
    private final CheckNearbyMeFeature BottomSheetCardBindingView$watcherCardNumberView$1;
    private final GetAccount C;
    private final GetNearbyConfig D;
    private final GetNearbyShopsWithRadius E;
    private final IsNeedToShowOnboardingToolTip F;
    SearchConfigModel FragmentBottomSheetPaymentSettingBinding;
    private Disposable H;
    final Context KClassImpl$Data$declaredNonStaticMembers$2;
    Location NetworkUserEntityData$$ExternalSyntheticLambda2;
    final NearbyShopsModelMapper NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final ConsultMerchantReview VerifyPinStateManager$executeRiskChallenge$2$1;
    private final IsNearbyReviewPageEnabled VerifyPinStateManager$executeRiskChallenge$2$2;
    boolean getAuthRequestContext;
    final NearbyMeContract.View getCallingPid;
    final GetNearbyShopsPromo getErrorConfigVersion;
    private final GetNearbyShopsWithPagination getOnBoardingScenario;
    final ShopRankingCalculator getSupportButtonTintMode;
    private final GetNearbyRankingConfig getValueOfTouchPositionAbsolute;
    NearbyShopsModel initRecordTimeStamp;
    String isLayoutRequested;
    boolean lookAheadTest;
    DefaultObserver<LocationSourceTrackerWrapper> moveToNextValue;
    final NearbyPromoModelMapper newProxyInstance;
    final PublishSubject<LocationSourceTrackerWrapper> NetworkUserEntityData$$ExternalSyntheticLambda0 = PublishSubject.PlaceComponentResult();
    final PublishSubject<List<MerchantCategoryModel>> PrepareContext = PublishSubject.PlaceComponentResult();
    final PublishSubject<List<MerchantCategoryModel>> NetworkUserEntityData$$ExternalSyntheticLambda8 = PublishSubject.PlaceComponentResult();
    final PublishSubject<List<ShopModel>> NetworkUserEntityData$$ExternalSyntheticLambda7 = PublishSubject.PlaceComponentResult();
    final PublishSubject<Location> NetworkUserEntityData$$ExternalSyntheticLambda3 = PublishSubject.PlaceComponentResult();
    final PublishSubject<List<MerchantCategoryModel>> SubSequence = PublishSubject.PlaceComponentResult();
    boolean BuiltInFictitiousFunctionClassFactory = false;
    String scheduleImpl = "";
    int NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
    int DatabaseTableConfigUtil = 0;
    List<ShopModel> whenAvailable = new ArrayList();
    int MyBillsEntityDataFactory = 0;
    int GetContactSyncConfig = 0;
    List<ShopModel> NetworkUserEntityData$$ExternalSyntheticLambda6 = new ArrayList();
    int NetworkUserEntityData$$ExternalSyntheticLambda5 = 1;
    boolean readMicros = false;
    final CompositeDisposable PlaceComponentResult = new CompositeDisposable();

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(Observable observable) throws Exception {
        return observable;
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(Observable observable) throws Exception {
        return observable;
    }

    @Inject
    public NearbyPresenter(Context context, CheckNearbyMeFeature checkNearbyMeFeature, GetNearbyRankingConfig getNearbyRankingConfig, GetNearbyShopsWithPagination getNearbyShopsWithPagination, NearbyMeContract.View view, NearbyShopsModelMapper nearbyShopsModelMapper, GetNearbyShopsWithRadius getNearbyShopsWithRadius, GetNearbyShopsPromo getNearbyShopsPromo, NearbyPromoModelMapper nearbyPromoModelMapper, IsNeedToShowOnboardingToolTip isNeedToShowOnboardingToolTip, GetDistrictNameByLocation getDistrictNameByLocation, SaveShowOnboardingTooltip saveShowOnboardingTooltip, GetAutoSearchConfig getAutoSearchConfig, GetAccount getAccount, GetNearbyConfig getNearbyConfig, ShopRankingCalculator shopRankingCalculator, IsNearbyReviewPageEnabled isNearbyReviewPageEnabled, ConsultMerchantReview consultMerchantReview) {
        this.getOnBoardingScenario = getNearbyShopsWithPagination;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = checkNearbyMeFeature;
        this.getValueOfTouchPositionAbsolute = getNearbyRankingConfig;
        this.getCallingPid = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = nearbyShopsModelMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.E = getNearbyShopsWithRadius;
        this.getErrorConfigVersion = getNearbyShopsPromo;
        this.A = getDistrictNameByLocation;
        this.newProxyInstance = nearbyPromoModelMapper;
        this.F = isNeedToShowOnboardingToolTip;
        this.AppCompatEmojiTextHelper = saveShowOnboardingTooltip;
        this.B = getAutoSearchConfig;
        this.C = getAccount;
        this.D = getNearbyConfig;
        this.getSupportButtonTintMode = shopRankingCalculator;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = isNearbyReviewPageEnabled;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = consultMerchantReview;
        Observable<LocationSourceTrackerWrapper> observeOn = this.NetworkUserEntityData$$ExternalSyntheticLambda0.debounce(1500L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult());
        DefaultObserver<LocationSourceTrackerWrapper> defaultObserver = new DefaultObserver<LocationSourceTrackerWrapper>() { // from class: id.dana.contract.nearbyme.NearbyPresenter.4
            {
                NearbyPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                LocationSourceTrackerWrapper locationSourceTrackerWrapper = (LocationSourceTrackerWrapper) obj;
                NearbyPresenter.KClassImpl$Data$declaredNonStaticMembers$2(NearbyPresenter.this, locationSourceTrackerWrapper.BuiltInFictitiousFunctionClassFactory, locationSourceTrackerWrapper.KClassImpl$Data$declaredNonStaticMembers$2);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", sb.toString());
            }
        };
        this.moveToNextValue = defaultObserver;
        observeOn.subscribe(defaultObserver);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (!isDisposed()) {
            this.PlaceComponentResult.dispose();
        }
        this.BottomSheetCardBindingView$watcherCardNumberView$1.dispose();
        this.getValueOfTouchPositionAbsolute.dispose();
        this.getOnBoardingScenario.dispose();
        this.E.dispose();
        this.getErrorConfigVersion.dispose();
        this.AppCompatEmojiTextHelper.dispose();
        this.F.dispose();
        this.A.dispose();
        this.B.dispose();
        this.C.dispose();
        Disposable disposable = this.H;
        if (disposable != null) {
            disposable.dispose();
        }
        this.D.dispose();
        this.moveToNextValue.dispose();
        this.VerifyPinStateManager$executeRiskChallenge$2$2.dispose();
        this.VerifyPinStateManager$executeRiskChallenge$2$1.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.PlaceComponentResult.isDisposed();
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final String PlaceComponentResult() {
        return this.isLayoutRequested;
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void PlaceComponentResult(String str) {
        this.isLayoutRequested = str;
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.BottomSheetCardBindingView$watcherCardNumberView$1.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.nearbyme.NearbyPresenter.1
            {
                NearbyPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                NearbyMeContract.View unused = NearbyPresenter.this.getCallingPid;
                if (((Boolean) obj).booleanValue()) {
                    NearbyPresenter.KClassImpl$Data$declaredNonStaticMembers$2(NearbyPresenter.this);
                }
            }
        });
    }

    public static /* synthetic */ Unit getAuthRequestContext(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", th.getMessage(), th);
        return Unit.INSTANCE;
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void PlaceComponentResult(Location location) {
        this.getOnBoardingScenario.executeJava1(new GetNearbyShopsWithPagination.Params(new ShopListRequest(location.getLatitude(), location.getLongitude(), this.NetworkUserEntityData$$ExternalSyntheticLambda5, 20, this.scheduleImpl, this.getAuthRequestContext, "search")), new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NearbyPresenter nearbyPresenter = NearbyPresenter.this;
                nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda4.getAuthRequestContext = false;
                NearbyShopsModel apply = nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda4.apply((ShopsPage) obj);
                nearbyPresenter.initRecordTimeStamp = apply;
                List<ShopModel> list = apply.MyBillsEntityDataFactory;
                if (list == null) {
                    list = null;
                } else {
                    Collections.sort(list, new NearbyPresenter$$ExternalSyntheticLambda5(nearbyPresenter));
                }
                apply.MyBillsEntityDataFactory = ShopModelExtKt.PlaceComponentResult(list, nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1);
                nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 += nearbyPresenter.initRecordTimeStamp.MyBillsEntityDataFactory.size();
                if (nearbyPresenter.initRecordTimeStamp.PlaceComponentResult()) {
                    nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda5++;
                }
                nearbyPresenter.whenAvailable.addAll(nearbyPresenter.initRecordTimeStamp.MyBillsEntityDataFactory);
                nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda7.onNext(nearbyPresenter.initRecordTimeStamp.MyBillsEntityDataFactory);
                nearbyPresenter.getCallingPid.MyBillsEntityDataFactory(nearbyPresenter.initRecordTimeStamp.MyBillsEntityDataFactory);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NearbyPresenter nearbyPresenter = NearbyPresenter.this;
                Throwable th = (Throwable) obj;
                nearbyPresenter.getCallingPid.MyBillsEntityDataFactory(new ArrayList(), false);
                return nearbyPresenter.getCallingPid.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }, this.getCallingPid.getAuthRequestContext());
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void getAuthRequestContext(Location location, int i, boolean z) {
        if (!this.lookAheadTest) {
            this.getCallingPid.showProgress();
        }
        this.E.executeJava1(new GetNearbyShopsWithRadius.Params(location, i, this.NetworkUserEntityData$$ExternalSyntheticLambda5, 20, z, this.getAuthRequestContext, "", ""), new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                final NearbyPresenter nearbyPresenter = NearbyPresenter.this;
                ShopsPage shopsPage = (ShopsPage) obj;
                nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda4.getAuthRequestContext = nearbyPresenter.getAuthRequestContext;
                nearbyPresenter.getCallingPid.dismissProgress();
                int i2 = 0;
                if (shopsPage.getShops() != null) {
                    nearbyPresenter.DatabaseTableConfigUtil = shopsPage.getShops().size();
                } else {
                    nearbyPresenter.DatabaseTableConfigUtil = 0;
                }
                NearbyShopsModel apply = nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda4.apply(shopsPage);
                final List<ShopModel> list = apply.MyBillsEntityDataFactory;
                if (nearbyPresenter.isLayoutRequested != null) {
                    Collections.sort(list, new NearbyPresenter$$ExternalSyntheticLambda19());
                } else if (list != null) {
                    Collections.sort(list, new NearbyPresenter$$ExternalSyntheticLambda5(nearbyPresenter));
                }
                if (!nearbyPresenter.lookAheadTest) {
                    nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda6.clear();
                }
                nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda6.addAll(list);
                nearbyPresenter.initRecordTimeStamp = apply;
                nearbyPresenter.lookAheadTest = false;
                nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda7.onNext(list);
                nearbyPresenter.getCallingPid.MyBillsEntityDataFactory(list);
                nearbyPresenter.MyBillsEntityDataFactory = 0;
                nearbyPresenter.GetContactSyncConfig = 0;
                while (true) {
                    if (i2 > (NearbyPresenter.BuiltInFictitiousFunctionClassFactory(list) ? list.size() / 5 : (list.size() / 5) - 1)) {
                        return Unit.INSTANCE;
                    }
                    int i3 = nearbyPresenter.MyBillsEntityDataFactory + 5;
                    nearbyPresenter.GetContactSyncConfig = i3;
                    List<ShopModel> subList = list.subList(nearbyPresenter.MyBillsEntityDataFactory, Math.min(i3, list.size()));
                    nearbyPresenter.MyBillsEntityDataFactory = nearbyPresenter.GetContactSyncConfig;
                    ArrayList arrayList = new ArrayList();
                    for (ShopModel shopModel : subList) {
                        if (shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3 != null || shopModel.BottomSheetCardBindingView$watcherCardNumberView$1 != null) {
                            arrayList.add(new MerchantInfo(shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3, shopModel.BottomSheetCardBindingView$watcherCardNumberView$1));
                        }
                    }
                    nearbyPresenter.getErrorConfigVersion.execute(new GetNearbyShopsPromo.Params(arrayList), new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            NearbyPresenter nearbyPresenter2 = NearbyPresenter.this;
                            nearbyPresenter2.getCallingPid.PlaceComponentResult(nearbyPresenter2.newProxyInstance.BuiltInFictitiousFunctionClassFactory(list, (List) obj2));
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return NearbyPresenter.BuiltInFictitiousFunctionClassFactory((Throwable) obj2);
                        }
                    });
                    i2++;
                }
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NearbyPresenter nearbyPresenter = NearbyPresenter.this;
                nearbyPresenter.getCallingPid.dismissProgress();
                nearbyPresenter.DatabaseTableConfigUtil = 0;
                nearbyPresenter.getCallingPid.onError(ErrorUtil.PlaceComponentResult((Throwable) obj, nearbyPresenter.KClassImpl$Data$declaredNonStaticMembers$2));
                return nearbyPresenter.getCallingPid.PlaceComponentResult();
            }
        }, this.getCallingPid.getAuthRequestContext());
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void getAuthRequestContext(Location location) {
        if (scheduleImpl()) {
            return;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.onNext(location);
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void getAuthRequestContext(List<MerchantCategoryModel> list) {
        this.SubSequence.onNext(list);
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final List<ShopModel> PlaceComponentResult(List<ShopModel> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (ShopModel shopModel : list) {
            if (shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3.equals(str)) {
                arrayList.add(shopModel);
            }
        }
        return arrayList;
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void initRecordTimeStamp() {
        this.AppCompatEmojiTextHelper.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.nearbyme.NearbyPresenter.2
            {
                NearbyPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SAVE_SHOW_TOOLTIP_PREFIX);
                sb.append(getClass().getName());
                DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", sb.toString(), th);
            }
        }, NoParams.INSTANCE);
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void getErrorConfigVersion() {
        this.getCallingPid.showProgress();
        this.F.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.nearbyme.NearbyPresenter.3
            {
                NearbyPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                NearbyPresenter.this.getCallingPid.dismissProgress();
                NearbyPresenter.this.getCallingPid.getAuthRequestContext(((Boolean) obj).booleanValue());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                NearbyPresenter.this.getCallingPid.dismissProgress();
                NearbyPresenter.this.getCallingPid.getAuthRequestContext(false);
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.IS_NEED_TO_SHOW_TOOLTIP_PREFIX);
                sb.append(getClass().getName());
                DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", sb.toString(), th);
            }
        }, NoParams.INSTANCE);
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<ShopModel> list) {
        Collections.sort(list, new NearbyPresenter$$ExternalSyntheticLambda19());
    }

    public static /* synthetic */ Unit MyBillsEntityDataFactory(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", th.getMessage(), th);
        return Unit.INSTANCE;
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void getAuthRequestContext() {
        this.B.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                final NearbyPresenter nearbyPresenter = NearbyPresenter.this;
                SearchConfigModel.Companion companion = SearchConfigModel.INSTANCE;
                final SearchConfigModel PlaceComponentResult = SearchConfigModel.Companion.PlaceComponentResult((NearbyAutoSearchConfig) obj);
                nearbyPresenter.FragmentBottomSheetPaymentSettingBinding = PlaceComponentResult;
                if (PlaceComponentResult.getEnabled()) {
                    nearbyPresenter.PlaceComponentResult.getAuthRequestContext(nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda3.debounce(PlaceComponentResult.getInterval(), TimeUnit.MILLISECONDS).filter(new Predicate() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda24
                        @Override // io.reactivex.functions.Predicate
                        public final boolean test(Object obj2) {
                            return NearbyPresenter.this.getAuthRequestContext(PlaceComponentResult, (Location) obj2);
                        }
                    }).map(new Function() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda25
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            Location location = (Location) obj2;
                            NearbyPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = location;
                            return location;
                        }
                    }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda26
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj2) {
                            NearbyPresenter nearbyPresenter2 = NearbyPresenter.this;
                            Location location = (Location) obj2;
                            nearbyPresenter2.DatabaseTableConfigUtil();
                            nearbyPresenter2.getAuthRequestContext(location, nearbyPresenter2.getAuthRequestContext ? 5000 : 3000, false);
                        }
                    }));
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NearbyPresenter.PlaceComponentResult((Throwable) obj);
            }
        });
    }

    public static /* synthetic */ Unit PlaceComponentResult(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, th.getMessage(), th);
        return Unit.INSTANCE;
    }

    public final /* synthetic */ boolean getAuthRequestContext(SearchConfigModel searchConfigModel, Location location) throws Exception {
        Location location2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        return location2 == null || LocationUtil.MyBillsEntityDataFactory(location, location2) * 1000.0d >= ((double) searchConfigModel.getThreshold());
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.C.execute(new DefaultObserver<Account>() { // from class: id.dana.contract.nearbyme.NearbyPresenter.5
            {
                NearbyPresenter.this = this;
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                NearbyPresenter.this.getCallingPid.getAuthRequestContext((Account) obj);
            }
        });
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void GetContactSyncConfig() {
        PublishSubject<List<MerchantCategoryModel>> publishSubject = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        ArrayList arrayList = new ArrayList();
        arrayList.add(MerchantCategoryModel.BuiltInFictitiousFunctionClassFactory);
        Disposable subscribe = Observable.combineLatest(publishSubject.startWith((PublishSubject<List<MerchantCategoryModel>>) arrayList), this.PrepareContext.startWith((PublishSubject<List<MerchantCategoryModel>>) new ArrayList()), this.NetworkUserEntityData$$ExternalSyntheticLambda7, new Function3() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda33
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                NearbyPresenter nearbyPresenter = NearbyPresenter.this;
                final List list = (List) obj;
                final List list2 = (List) obj2;
                List<ShopModel> list3 = (List) obj3;
                if (nearbyPresenter.BuiltInFictitiousFunctionClassFactory) {
                    if (nearbyPresenter.readMicros) {
                        list3 = nearbyPresenter.whenAvailable;
                    }
                } else if (nearbyPresenter.readMicros) {
                    list3 = nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda6;
                }
                Single list4 = Observable.fromIterable(list3).filter(new Predicate() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda22
                    @Override // io.reactivex.functions.Predicate
                    public final boolean test(Object obj4) {
                        boolean PlaceComponentResult;
                        PlaceComponentResult = ShopModelExtKt.PlaceComponentResult((ShopModel) obj4, list2, list);
                        return PlaceComponentResult;
                    }
                }).toList();
                if (list4 instanceof FuseToObservable) {
                    return ((FuseToObservable) list4).getAuthRequestContext();
                }
                return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list4));
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).flatMap(new Function() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyPresenter.getAuthRequestContext((Observable) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ShopModelExtKt.BuiltInFictitiousFunctionClassFactory((List) obj, NearbyPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NearbyPresenter nearbyPresenter = NearbyPresenter.this;
                List<ShopModel> list = (List) obj;
                nearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 += list.size();
                nearbyPresenter.readMicros = false;
                if (nearbyPresenter.BuiltInFictitiousFunctionClassFactory) {
                    nearbyPresenter.getCallingPid.MyBillsEntityDataFactory(list, nearbyPresenter.initRecordTimeStamp.PlaceComponentResult());
                } else {
                    nearbyPresenter.getCallingPid.BuiltInFictitiousFunctionClassFactory(list);
                }
            }
        });
        if (subscribe != null) {
            this.PlaceComponentResult.getAuthRequestContext(subscribe);
        }
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(List<MerchantCategoryModel> list, MerchantCategoryType merchantCategoryType) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        this.readMicros = true;
        if (merchantCategoryType == MerchantCategoryType.LIST) {
            this.PrepareContext.onNext(list);
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.onNext(list);
        }
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.getAuthRequestContext = z;
        this.getSupportButtonTintMode.MyBillsEntityDataFactory = z;
        this.getValueOfTouchPositionAbsolute.execute(new GetNearbyRankingConfig.Params(z), new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NearbyRankingConfig nearbyRankingConfig = (NearbyRankingConfig) obj;
                NearbyPresenter.this.getSupportButtonTintMode.BuiltInFictitiousFunctionClassFactory(nearbyRankingConfig.getRadius(), Integer.valueOf(nearbyRankingConfig.getRating()), Integer.valueOf(nearbyRankingConfig.getReview()));
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NearbyPresenter.getAuthRequestContext((Throwable) obj);
            }
        });
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 2;
        this.scheduleImpl = str;
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final boolean lookAheadTest() {
        NearbyShopsModel nearbyShopsModel = this.initRecordTimeStamp;
        if (nearbyShopsModel == null) {
            return false;
        }
        return nearbyShopsModel.PlaceComponentResult();
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void MyBillsEntityDataFactory(boolean z) {
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(Location location) {
        if (lookAheadTest() && this.NetworkUserEntityData$$ExternalSyntheticLambda6.size() <= 100) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5++;
            this.lookAheadTest = true;
            getAuthRequestContext(location, 5000, false);
            return;
        }
        this.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2 = false;
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void DatabaseTableConfigUtil() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 1;
        this.lookAheadTest = false;
        this.BuiltInFictitiousFunctionClassFactory = false;
        this.readMicros = false;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = 0;
        this.initRecordTimeStamp = null;
        this.whenAvailable.clear();
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.clear();
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(NearbyShopsModel nearbyShopsModel) {
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.initRecordTimeStamp = nearbyShopsModel;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = nearbyShopsModel.MyBillsEntityDataFactory.size();
        this.whenAvailable.clear();
        this.whenAvailable.addAll(nearbyShopsModel.MyBillsEntityDataFactory);
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda5;
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final boolean scheduleImpl() {
        SearchConfigModel searchConfigModel = this.FragmentBottomSheetPaymentSettingBinding;
        return searchConfigModel == null || !searchConfigModel.getEnabled();
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.VerifyPinStateManager$executeRiskChallenge$2$2.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NearbyPresenter.this.getCallingPid.BuiltInFictitiousFunctionClassFactory(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                NearbyPresenter.this.getCallingPid.BuiltInFictitiousFunctionClassFactory(false);
                DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", th.getMessage(), th);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void moveToNextValue() {
        this.VerifyPinStateManager$executeRiskChallenge$2$1.execute(new ConsultMerchantReview.Param(), new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NearbyPresenter.this.getCallingPid.MyBillsEntityDataFactory(((MerchantConsult) obj).getShowRedDot());
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NearbyPresenter.BuiltInFictitiousFunctionClassFactory((Exception) obj);
            }
        });
    }

    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Exception exc) {
        DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", exc.getMessage(), exc);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Throwable th) {
        CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, DanaLogConstants.Prefix.GET_NEARBY_PROMO, th);
        return Unit.INSTANCE;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(List<ShopModel> list) {
        return list.size() % 5 > 0;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(ShopModel shopModel, String str) {
        return TextUtils.isEmpty(str) || (!TextUtils.isEmpty(shopModel.newProxyInstance) && shopModel.newProxyInstance.toLowerCase().contains(str));
    }

    public static boolean getAuthRequestContext(ShopModel shopModel, List<MerchantCategoryModel> list) {
        if (list.contains(MerchantCategoryModel.BuiltInFictitiousFunctionClassFactory)) {
            return true;
        }
        return shopModel.PlaceComponentResult(list);
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final List<ShopModel> MyBillsEntityDataFactory(List<ShopModel> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new NearbyPresenter$$ExternalSyntheticLambda5(this));
        return list;
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(LocationSourceTrackerWrapper locationSourceTrackerWrapper) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.onNext(locationSourceTrackerWrapper);
    }

    public static /* synthetic */ void PlaceComponentResult(NearbyPresenter nearbyPresenter, LocationSettingsResult locationSettingsResult) {
        Status status = locationSettingsResult.getStatus();
        if (status != null) {
            int statusCode = status.getStatusCode();
            if (statusCode != 6) {
                if (statusCode == 8502) {
                    return;
                }
            } else if (status.getResolution() != null) {
                nearbyPresenter.getCallingPid.BuiltInFictitiousFunctionClassFactory(status.getResolution().getIntentSender());
                return;
            }
        }
        nearbyPresenter.getCallingPid.MyBillsEntityDataFactory();
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NearbyPresenter nearbyPresenter) {
        nearbyPresenter.D.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NearbyPresenter nearbyPresenter2 = NearbyPresenter.this;
                NearbyConfig nearbyConfig = (NearbyConfig) obj;
                nearbyPresenter2.getSupportButtonTintMode.MyBillsEntityDataFactory = nearbyConfig.getNearbyRevamp();
                NearbyMeContract.View view = nearbyPresenter2.getCallingPid;
                nearbyConfig.getNearbyRevamp();
                view.BuiltInFictitiousFunctionClassFactory();
                nearbyPresenter2.NetworkUserEntityData$$ExternalSyntheticLambda4.BuiltInFictitiousFunctionClassFactory = Double.valueOf(nearbyConfig.getReviewCount());
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NearbyPresenter nearbyPresenter, Location location, String str) {
        HereMixPanelTrackerData hereMixPanelTrackerData = new HereMixPanelTrackerData();
        hereMixPanelTrackerData.setSource(str);
        nearbyPresenter.A.execute(new GetDistrictNameByLocation.Params(location, hereMixPanelTrackerData), new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NearbyPresenter.this.getCallingPid.PlaceComponentResult((String) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NearbyPresenter.MyBillsEntityDataFactory((Throwable) obj);
            }
        });
    }

    @Override // id.dana.contract.nearbyme.NearbyMeContract.Presenter
    public final void PlaceComponentResult(Observable<String> observable) {
        PublishSubject<List<MerchantCategoryModel>> publishSubject = this.SubSequence;
        ArrayList arrayList = new ArrayList();
        arrayList.add(MerchantCategoryModel.BuiltInFictitiousFunctionClassFactory);
        Observable flatMap = Observable.combineLatest(observable, publishSubject.startWith((PublishSubject<List<MerchantCategoryModel>>) arrayList), this.NetworkUserEntityData$$ExternalSyntheticLambda7, new Function3() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                final NearbyPresenter nearbyPresenter = NearbyPresenter.this;
                final String str = (String) obj;
                final List list = (List) obj2;
                Single list2 = Observable.fromIterable((List) obj3).filter(new Predicate() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda27
                    @Override // io.reactivex.functions.Predicate
                    public final boolean test(Object obj4) {
                        boolean BuiltInFictitiousFunctionClassFactory;
                        BuiltInFictitiousFunctionClassFactory = NearbyPresenter.BuiltInFictitiousFunctionClassFactory((ShopModel) obj4, str);
                        return BuiltInFictitiousFunctionClassFactory;
                    }
                }).filter(new Predicate() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda28
                    @Override // io.reactivex.functions.Predicate
                    public final boolean test(Object obj4) {
                        boolean authRequestContext;
                        authRequestContext = NearbyPresenter.getAuthRequestContext((ShopModel) obj4, list);
                        return authRequestContext;
                    }
                }).toList();
                if (list2 instanceof FuseToObservable) {
                    return ((FuseToObservable) list2).getAuthRequestContext();
                }
                return RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list2));
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).flatMap(new Function() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NearbyPresenter.KClassImpl$Data$declaredNonStaticMembers$2((Observable) obj);
            }
        });
        final NearbyMeContract.View view = this.getCallingPid;
        Objects.requireNonNull(view);
        Disposable subscribe = flatMap.subscribe(new Consumer() { // from class: id.dana.contract.nearbyme.NearbyPresenter$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NearbyMeContract.View.this.BuiltInFictitiousFunctionClassFactory((List) obj);
            }
        });
        if (subscribe != null) {
            this.PlaceComponentResult.getAuthRequestContext(subscribe);
        }
    }
}
