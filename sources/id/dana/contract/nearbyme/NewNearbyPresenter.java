package id.dana.contract.nearbyme;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import dagger.Lazy;
import id.dana.contract.nearbyme.NewNearbyMeContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.interactor.CheckNearbyMeMapFeature;
import id.dana.domain.nearbyme.interactor.GetAutoSearchConfig;
import id.dana.domain.nearbyme.interactor.GetDistrictNameByLocation;
import id.dana.domain.nearbyme.interactor.GetNearbyConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyRankingConfig;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsFromCache;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithPagination;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsWithRadius;
import id.dana.domain.nearbyme.interactor.GetNearbyWidgetVisibility;
import id.dana.domain.nearbyme.interactor.IsNeedToShowOnboardingToolTip;
import id.dana.domain.nearbyme.interactor.SaveShowOnboardingTooltip;
import id.dana.domain.nearbyme.model.MerchantInfo;
import id.dana.domain.nearbyme.model.NearbyConfig;
import id.dana.domain.nearbyme.model.ShopListRequest;
import id.dana.domain.nearbyme.model.ShopsPage;
import id.dana.drawable.ShopRankingCalculator;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.mapper.NearbyShopsModelMapper;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.nearbyme.model.SearchConfigModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ErrorUtil;
import id.dana.utils.LocationUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.log.CrashlyticsLogUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class NewNearbyPresenter implements NewNearbyMeContract.Presenter, Disposable {
    final Lazy<GetNearbyConfig> BuiltInFictitiousFunctionClassFactory;
    PublishSubject<Location> DatabaseTableConfigUtil;
    private final Lazy<GetNearbyRankingConfig> FragmentBottomSheetPaymentSettingBinding;
    List<Double> GetContactSyncConfig;
    Location NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Lazy<GetNearbyShopsPromo> NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final Lazy<GetNearbyShopsFromCache> NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final Lazy<GetNearbyShopsWithPagination> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final Lazy<GetNearbyWidgetVisibility> NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Lazy<GetAutoSearchConfig> NetworkUserEntityData$$ExternalSyntheticLambda7;
    final NewNearbyMeContract.View NetworkUserEntityData$$ExternalSyntheticLambda8;
    final Context PlaceComponentResult;
    final Lazy<ShopRankingCalculator> PrepareContext;
    final Lazy<CheckNearbyMeMapFeature> getAuthRequestContext;
    private final Lazy<IsNeedToShowOnboardingToolTip> getCallingPid;
    private Disposable getSupportButtonTintMode;
    final Lazy<NearbyShopsModelMapper> initRecordTimeStamp;
    final Lazy<NearbyPromoModelMapper> moveToNextValue;
    private final Lazy<GetDistrictNameByLocation> newProxyInstance;
    final Lazy<GetNearbyShopsWithRadius> scheduleImpl;
    private final Lazy<SaveShowOnboardingTooltip> whenAvailable;
    final PublishSubject<List<ShopModel>> NetworkUserEntityData$$ExternalSyntheticLambda1 = PublishSubject.PlaceComponentResult();
    final PublishSubject<List<MerchantCategoryModel>> NetworkUserEntityData$$ExternalSyntheticLambda2 = PublishSubject.PlaceComponentResult();
    private int isLayoutRequested = 0;
    private int readMicros = 0;
    PublishSubject<Boolean> MyBillsEntityDataFactory = PublishSubject.PlaceComponentResult();
    PublishSubject<Boolean> lookAheadTest = PublishSubject.PlaceComponentResult();
    boolean getErrorConfigVersion = false;
    final CompositeDisposable KClassImpl$Data$declaredNonStaticMembers$2 = new CompositeDisposable();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource PlaceComponentResult(Observable observable) throws Exception {
        return observable;
    }

    @Inject
    public NewNearbyPresenter(Context context, NewNearbyMeContract.View view, Lazy<GetNearbyWidgetVisibility> lazy, Lazy<CheckNearbyMeMapFeature> lazy2, Lazy<GetNearbyRankingConfig> lazy3, Lazy<GetNearbyShopsWithPagination> lazy4, Lazy<NearbyShopsModelMapper> lazy5, Lazy<GetNearbyShopsWithRadius> lazy6, Lazy<GetNearbyShopsPromo> lazy7, Lazy<NearbyPromoModelMapper> lazy8, Lazy<IsNeedToShowOnboardingToolTip> lazy9, Lazy<GetDistrictNameByLocation> lazy10, Lazy<SaveShowOnboardingTooltip> lazy11, Lazy<GetAutoSearchConfig> lazy12, Lazy<GetNearbyConfig> lazy13, Lazy<ShopRankingCalculator> lazy14, Lazy<GetNearbyShopsFromCache> lazy15) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = lazy4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = lazy;
        this.getAuthRequestContext = lazy2;
        this.FragmentBottomSheetPaymentSettingBinding = lazy3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = view;
        this.initRecordTimeStamp = lazy5;
        this.PlaceComponentResult = context;
        this.scheduleImpl = lazy6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = lazy7;
        this.newProxyInstance = lazy10;
        this.moveToNextValue = lazy8;
        this.getCallingPid = lazy9;
        this.whenAvailable = lazy11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = lazy12;
        this.BuiltInFictitiousFunctionClassFactory = lazy13;
        this.PrepareContext = lazy14;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = lazy15;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (!isDisposed()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        }
        this.getAuthRequestContext.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.get().dispose();
        this.FragmentBottomSheetPaymentSettingBinding.get().dispose();
        this.scheduleImpl.get().dispose();
        this.whenAvailable.get().dispose();
        this.getCallingPid.get().dispose();
        this.newProxyInstance.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7.get().dispose();
        Disposable disposable = this.getSupportButtonTintMode;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.isDisposed();
    }

    @Override // id.dana.contract.nearbyme.NewNearbyMeContract.Presenter
    public final void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda6.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                final NewNearbyPresenter newNearbyPresenter = NewNearbyPresenter.this;
                Pair pair = (Pair) obj;
                newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2(((Boolean) pair.getFirst()).booleanValue(), ((Boolean) pair.getSecond()).booleanValue());
                if (((Boolean) pair.getFirst()).booleanValue()) {
                    newNearbyPresenter.getAuthRequestContext.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            NewNearbyPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext(((Boolean) obj2).booleanValue());
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit unit;
                            Throwable th = (Throwable) obj2;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    });
                    newNearbyPresenter.BuiltInFictitiousFunctionClassFactory.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            NewNearbyPresenter newNearbyPresenter2 = NewNearbyPresenter.this;
                            NearbyConfig nearbyConfig = (NearbyConfig) obj2;
                            newNearbyPresenter2.PrepareContext.get().MyBillsEntityDataFactory = nearbyConfig.getNearbyRevamp();
                            newNearbyPresenter2.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2(nearbyConfig.getNearbyRevamp());
                            return Unit.INSTANCE;
                        }
                    }, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit unit;
                            Throwable th = (Throwable) obj2;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit unit;
                Throwable th = (Throwable) obj;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("onError: ");
        sb.append(th.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", sb.toString());
        return Unit.INSTANCE;
    }

    @Override // id.dana.contract.nearbyme.NewNearbyMeContract.Presenter
    public final void getAuthRequestContext(Location location) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda5.get().executeJava1(new GetNearbyShopsWithPagination.Params(new ShopListRequest(location.getLatitude(), location.getLongitude(), 1, 7, "", false, "home")), new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewNearbyPresenter newNearbyPresenter = NewNearbyPresenter.this;
                ShopsPage shopsPage = (ShopsPage) obj;
                newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.dismissProgress();
                if (shopsPage.getShops() != null) {
                    newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.MyBillsEntityDataFactory(newNearbyPresenter.initRecordTimeStamp.get().apply(shopsPage));
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewNearbyPresenter newNearbyPresenter = NewNearbyPresenter.this;
                newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.dismissProgress();
                newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.onError(ErrorUtil.PlaceComponentResult((Throwable) obj, newNearbyPresenter.PlaceComponentResult));
                return newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.BuiltInFictitiousFunctionClassFactory();
            }
        }, this.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    @Override // id.dana.contract.nearbyme.NewNearbyMeContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final List<ShopModel> list) {
        int i = 0;
        this.isLayoutRequested = 0;
        this.readMicros = 0;
        while (true) {
            if (i > (KClassImpl$Data$declaredNonStaticMembers$2(list) ? list.size() / 5 : (list.size() / 5) - 1)) {
                return;
            }
            int i2 = this.isLayoutRequested + 5;
            this.readMicros = i2;
            List<ShopModel> subList = list.subList(this.isLayoutRequested, Math.min(i2, list.size()));
            this.isLayoutRequested = this.readMicros;
            ArrayList arrayList = new ArrayList();
            for (ShopModel shopModel : subList) {
                arrayList.add(new MerchantInfo(shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3, shopModel.BottomSheetCardBindingView$watcherCardNumberView$1));
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.get().execute(new GetNearbyShopsPromo.Params(arrayList), new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    NewNearbyPresenter newNearbyPresenter = NewNearbyPresenter.this;
                    newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.PlaceComponentResult(newNearbyPresenter.moveToNextValue.get().BuiltInFictitiousFunctionClassFactory(list, (List) obj));
                    return Unit.INSTANCE;
                }
            }, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NewNearbyPresenter.getAuthRequestContext((Throwable) obj);
                }
            });
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit MyBillsEntityDataFactory(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("onError: ");
        sb.append(th.getMessage());
        DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", sb.toString());
        return Unit.INSTANCE;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(List<ShopModel> list) {
        return list.size() % 5 > 0;
    }

    /* renamed from: id.dana.contract.nearbyme.NewNearbyPresenter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 extends DefaultObserver<Boolean> {
        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(DanaLogConstants.Prefix.SAVE_SHOW_TOOLTIP_PREFIX);
            sb.append(getClass().getName());
            sb.append("on Error");
            DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", sb.toString(), th);
        }
    }

    /* renamed from: id.dana.contract.nearbyme.NewNearbyPresenter$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 extends DefaultObserver<Boolean> {
        final /* synthetic */ NewNearbyPresenter KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public /* synthetic */ void onNext(Object obj) {
            Boolean bool = (Boolean) obj;
            this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8.dismissProgress();
            NewNearbyMeContract.View unused = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }

        @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
        public void onError(Throwable th) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8.dismissProgress();
            NewNearbyMeContract.View unused = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8;
            StringBuilder sb = new StringBuilder();
            sb.append(DanaLogConstants.Prefix.IS_NEED_TO_SHOW_TOOLTIP_PREFIX);
            sb.append(getClass().getName());
            sb.append("on Error");
            DanaLog.BuiltInFictitiousFunctionClassFactory("Nearby", sb.toString(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit getAuthRequestContext(Throwable th) {
        CrashlyticsLogUtil.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, DanaLogConstants.Prefix.GET_NEARBY_PROMO, th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(Throwable th) {
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, th.getMessage(), th);
        return Unit.INSTANCE;
    }

    @Override // id.dana.contract.nearbyme.NewNearbyMeContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        Disposable subscribe = Observable.combineLatest(this.MyBillsEntityDataFactory, this.lookAheadTest, new BiFunction() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                valueOf = Boolean.valueOf(r0.booleanValue() && r1.booleanValue());
                return valueOf;
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new Consumer() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NewNearbyPresenter newNearbyPresenter = NewNearbyPresenter.this;
                if (((Boolean) obj).booleanValue()) {
                    newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.MyBillsEntityDataFactory();
                }
            }
        });
        if (subscribe != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(subscribe);
        }
    }

    @Override // id.dana.contract.nearbyme.NewNearbyMeContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.onNext(Boolean.TRUE);
    }

    @Override // id.dana.contract.nearbyme.NewNearbyMeContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.showProgress();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4.get().execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewNearbyPresenter newNearbyPresenter = NewNearbyPresenter.this;
                ShopsPage shopsPage = (ShopsPage) obj;
                if (shopsPage == null || shopsPage.getShops() == null || shopsPage.getShops().isEmpty()) {
                    newNearbyPresenter.getErrorConfigVersion = true;
                } else {
                    newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.dismissProgress();
                    newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8.MyBillsEntityDataFactory(newNearbyPresenter.initRecordTimeStamp.get().apply(shopsPage));
                }
                newNearbyPresenter.lookAheadTest.onNext(Boolean.TRUE);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.nearbyme.NewNearbyPresenter$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NewNearbyPresenter newNearbyPresenter = NewNearbyPresenter.this;
                Throwable th = (Throwable) obj;
                newNearbyPresenter.getErrorConfigVersion = true;
                newNearbyPresenter.lookAheadTest.onNext(Boolean.TRUE);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean MyBillsEntityDataFactory(SearchConfigModel searchConfigModel, Location location) throws Exception {
        Location location2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return location2 == null || LocationUtil.MyBillsEntityDataFactory(location, location2) * 1000.0d >= ((double) searchConfigModel.getThreshold());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean BuiltInFictitiousFunctionClassFactory(ShopModel shopModel, String str) {
        return TextUtils.isEmpty(str) || (!TextUtils.isEmpty(shopModel.newProxyInstance) && shopModel.newProxyInstance.toLowerCase().contains(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean MyBillsEntityDataFactory(ShopModel shopModel, List<MerchantCategoryModel> list) {
        if (list.contains(MerchantCategoryModel.BuiltInFictitiousFunctionClassFactory)) {
            return true;
        }
        return shopModel.PlaceComponentResult(list);
    }

    public static /* synthetic */ void PlaceComponentResult(NewNearbyPresenter newNearbyPresenter, LocationSettingsResult locationSettingsResult) {
        Status status = locationSettingsResult.getStatus();
        if (status == null) {
            NewNearbyMeContract.View view = newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8;
            return;
        }
        int statusCode = status.getStatusCode();
        if (statusCode != 6) {
            if (statusCode != 8502) {
                NewNearbyMeContract.View view2 = newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8;
            }
        } else if (status.getResolution() != null) {
            NewNearbyMeContract.View view3 = newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8;
            status.getResolution().getIntentSender();
        } else {
            NewNearbyMeContract.View view4 = newNearbyPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8;
        }
    }
}
