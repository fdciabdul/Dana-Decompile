package id.dana.data.paymentsetting;

import android.text.TextUtils;
import android.view.View;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.model.PopupConfig;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.paymentsetting.repository.source.PaymentSettingPreferenceEntityDataFactory;
import id.dana.data.paymentsetting.repository.source.session.PreferencePaymentSettingEntityData;
import id.dana.data.userconfig.model.PopupConfigStoreConfig;
import id.dana.data.userconfig.model.PopupUserConfig;
import id.dana.data.userconfig.repository.UserConfigRepository;
import id.dana.domain.paymentsetting.PaymentSettingRepository;
import id.dana.domain.userconfig.model.QueryConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.getCallingPid;

@Singleton
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u0006*\u00020\u00060\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0005J'\u0010\u000f\u001a\u001a\u0012\b\u0012\u0006*\u00020\u000e0\u000e*\f\u0012\b\u0012\u0006*\u00020\u000e0\u000e0\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0005R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\u000f\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0014\u0010\n\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0014\u0010\r\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0019"}, d2 = {"Lid/dana/data/paymentsetting/PaymentSettingEntityRepository;", "Lid/dana/domain/paymentsetting/PaymentSettingRepository;", "Lio/reactivex/Observable;", "", "checkPaymentSetting", "()Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityData;", "PlaceComponentResult", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/paymentsetting/repository/source/session/PreferencePaymentSettingEntityData;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/data/paymentsetting/repository/source/session/PreferencePaymentSettingEntityData;", "", "getAuthRequestContext", "Lid/dana/data/userconfig/model/PopupUserConfig;", "MyBillsEntityDataFactory", "savePaymentSettingCheck", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/paymentsetting/repository/source/PaymentSettingPreferenceEntityDataFactory;", "Lid/dana/data/paymentsetting/repository/source/PaymentSettingPreferenceEntityDataFactory;", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "Lid/dana/data/userconfig/repository/UserConfigRepository;", "Lid/dana/data/userconfig/repository/UserConfigRepository;", "p0", "p1", "p2", "p3", "<init>", "(Lid/dana/data/paymentsetting/repository/source/PaymentSettingPreferenceEntityDataFactory;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/config/source/split/SplitConfigEntityData;Lid/dana/data/userconfig/repository/UserConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentSettingEntityRepository implements PaymentSettingRepository {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    private static char[] getAuthRequestContext = {37264, 37280, 37281, 37289, 37286, 37306, 37311, 37292, 37288};
    private static int moveToNextValue = 1;
    private static char scheduleImpl = 42070;
    private final SplitConfigEntityData BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final UserConfigRepository getAuthRequestContext;
    private final PaymentSettingPreferenceEntityDataFactory MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final AccountEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    public static /* synthetic */ Observable BuiltInFictitiousFunctionClassFactory(PaymentSettingEntityRepository paymentSettingEntityRepository, PopupUserConfig popupUserConfig) {
        int i = moveToNextValue + 107;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        Observable KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(paymentSettingEntityRepository, popupUserConfig);
        int i3 = moveToNextValue + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public static /* synthetic */ ObservableSource BuiltInFictitiousFunctionClassFactory(PaymentSettingEntityRepository paymentSettingEntityRepository, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        ObservableSource PlaceComponentResult = PlaceComponentResult(paymentSettingEntityRepository, str);
        try {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
            moveToNextValue = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 5 / 0;
                return PlaceComponentResult;
            }
            return PlaceComponentResult;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ Observable KClassImpl$Data$declaredNonStaticMembers$2(PaymentSettingEntityRepository paymentSettingEntityRepository, Throwable th) {
        try {
            int i = moveToNextValue + 89;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            Observable BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(paymentSettingEntityRepository, th);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
            moveToNextValue = i3 % 128;
            if (i3 % 2 != 0) {
                return BuiltInFictitiousFunctionClassFactory;
            }
            int i4 = 91 / 0;
            return BuiltInFictitiousFunctionClassFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(PaymentSettingEntityRepository paymentSettingEntityRepository, PopupConfig popupConfig) {
        int i = moveToNextValue + 61;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        ObservableSource authRequestContext = getAuthRequestContext(paymentSettingEntityRepository, popupConfig);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 65;
        moveToNextValue = i3 % 128;
        int i4 = i3 % 2;
        return authRequestContext;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(PaymentSettingEntityRepository paymentSettingEntityRepository, String str) {
        int i = moveToNextValue + 111;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        ObservableSource authRequestContext = getAuthRequestContext(paymentSettingEntityRepository, str);
        int i3 = moveToNextValue + 57;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 != 0 ? InputCardNumberView.DIVIDER : '^') != '^') {
            Object obj = null;
            obj.hashCode();
            return authRequestContext;
        }
        return authRequestContext;
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(PaymentSettingEntityRepository paymentSettingEntityRepository, Observable observable) {
        try {
            int i = moveToNextValue + 117;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            ObservableSource BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(paymentSettingEntityRepository, observable);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 9;
            moveToNextValue = i3 % 128;
            if ((i3 % 2 == 0 ? '9' : '\b') != '9') {
                return BuiltInFictitiousFunctionClassFactory;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return BuiltInFictitiousFunctionClassFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ String PlaceComponentResult(AccountEntity accountEntity) {
        int i = moveToNextValue + 77;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        char c = i % 2 != 0 ? '(' : (char) 19;
        String authRequestContext = getAuthRequestContext(accountEntity);
        if (c != 19) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 61;
        moveToNextValue = i2 % 128;
        int i3 = i2 % 2;
        return authRequestContext;
    }

    public static /* synthetic */ Observable getAuthRequestContext(Throwable th) {
        Observable PlaceComponentResult;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 21;
        moveToNextValue = i % 128;
        if (i % 2 != 0) {
            PlaceComponentResult = PlaceComponentResult(th);
        } else {
            try {
                PlaceComponentResult = PlaceComponentResult(th);
                int i2 = 80 / 0;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i3 = moveToNextValue + 69;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return PlaceComponentResult;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return PlaceComponentResult;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ Boolean getAuthRequestContext(PopupConfig popupConfig, PopupUserConfig popupUserConfig) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
            moveToNextValue = i % 128;
            int i2 = i % 2;
            Boolean MyBillsEntityDataFactory = MyBillsEntityDataFactory(popupConfig, popupUserConfig);
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 67;
            moveToNextValue = i3 % 128;
            int i4 = i3 % 2;
            return MyBillsEntityDataFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public PaymentSettingEntityRepository(PaymentSettingPreferenceEntityDataFactory paymentSettingPreferenceEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, SplitConfigEntityData splitConfigEntityData, UserConfigRepository userConfigRepository) {
        Intrinsics.checkNotNullParameter(paymentSettingPreferenceEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(splitConfigEntityData, "");
        Intrinsics.checkNotNullParameter(userConfigRepository, "");
        this.MyBillsEntityDataFactory = paymentSettingPreferenceEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = accountEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = splitConfigEntityData;
        this.getAuthRequestContext = userConfigRepository;
    }

    @Override // id.dana.domain.paymentsetting.PaymentSettingRepository
    public final Observable<Boolean> checkPaymentSetting() {
        try {
            try {
                Observable<Boolean> onErrorResumeNext = this.BuiltInFictitiousFunctionClassFactory.getPopupConfig().flatMap(new Function() { // from class: id.dana.data.paymentsetting.PaymentSettingEntityRepository$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return PaymentSettingEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(PaymentSettingEntityRepository.this, (PopupConfig) obj);
                    }
                }).onErrorResumeNext(new Function() { // from class: id.dana.data.paymentsetting.PaymentSettingEntityRepository$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return PaymentSettingEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(PaymentSettingEntityRepository.this, (Throwable) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 37;
                moveToNextValue = i % 128;
                int i2 = i % 2;
                return onErrorResumeNext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final ObservableSource getAuthRequestContext(PaymentSettingEntityRepository paymentSettingEntityRepository, final PopupConfig popupConfig) {
        Intrinsics.checkNotNullParameter(paymentSettingEntityRepository, "");
        Intrinsics.checkNotNullParameter(popupConfig, "");
        ObservableSource map = paymentSettingEntityRepository.MyBillsEntityDataFactory().map(new Function() { // from class: id.dana.data.paymentsetting.PaymentSettingEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PaymentSettingEntityRepository.getAuthRequestContext(PopupConfig.this, (PopupUserConfig) obj);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 113;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        return map;
    }

    private static final Boolean MyBillsEntityDataFactory(PopupConfig popupConfig, PopupUserConfig popupUserConfig) {
        Intrinsics.checkNotNullParameter(popupConfig, "");
        Intrinsics.checkNotNullParameter(popupUserConfig, "");
        boolean z = false;
        if (!(!popupConfig.getHomePaymentSettingDialog())) {
            if ((!popupUserConfig.getHomePaymentSettingShown() ? 'E' : (char) 29) != 29) {
                int i = moveToNextValue + 61;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 97;
                moveToNextValue = i3 % 128;
                int i4 = i3 % 2;
                z = true;
            }
        }
        return Boolean.valueOf(z);
    }

    private static final Observable BuiltInFictitiousFunctionClassFactory(final PaymentSettingEntityRepository paymentSettingEntityRepository, Throwable th) {
        Intrinsics.checkNotNullParameter(paymentSettingEntityRepository, "");
        Intrinsics.checkNotNullParameter(th, "");
        Observable<R> flatMap = paymentSettingEntityRepository.getAuthRequestContext().flatMap(new Function() { // from class: id.dana.data.paymentsetting.PaymentSettingEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PaymentSettingEntityRepository.MyBillsEntityDataFactory(PaymentSettingEntityRepository.this, (String) obj);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    private static final ObservableSource getAuthRequestContext(PaymentSettingEntityRepository paymentSettingEntityRepository, String str) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 99;
            moveToNextValue = i % 128;
            if (!(i % 2 == 0)) {
                Intrinsics.checkNotNullParameter(paymentSettingEntityRepository, "");
                Intrinsics.checkNotNullParameter(str, "");
                PreferencePaymentSettingEntityData BuiltInFictitiousFunctionClassFactory = paymentSettingEntityRepository.BuiltInFictitiousFunctionClassFactory();
                Intrinsics.checkNotNullParameter(str, "");
                Observable just = Observable.just(Boolean.valueOf(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.getAuthRequestContext(str)));
                Intrinsics.checkNotNullExpressionValue(just, "");
                return just;
            }
            Intrinsics.checkNotNullParameter(paymentSettingEntityRepository, "");
            Intrinsics.checkNotNullParameter(str, "");
            PreferencePaymentSettingEntityData BuiltInFictitiousFunctionClassFactory2 = paymentSettingEntityRepository.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter(str, "");
            Observable just2 = Observable.just(Boolean.valueOf(BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.getAuthRequestContext(str)));
            Intrinsics.checkNotNullExpressionValue(just2, "");
            int i2 = 75 / 0;
            return just2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.domain.paymentsetting.PaymentSettingRepository
    public final Observable<Boolean> savePaymentSettingCheck() {
        Observable<Boolean> flatMap = MyBillsEntityDataFactory().map(new Function() { // from class: id.dana.data.paymentsetting.PaymentSettingEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PaymentSettingEntityRepository.BuiltInFictitiousFunctionClassFactory(PaymentSettingEntityRepository.this, (PopupUserConfig) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.data.paymentsetting.PaymentSettingEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PaymentSettingEntityRepository.PlaceComponentResult(PaymentSettingEntityRepository.this, (Observable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = moveToNextValue + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    private static final Observable KClassImpl$Data$declaredNonStaticMembers$2(PaymentSettingEntityRepository paymentSettingEntityRepository, PopupUserConfig popupUserConfig) {
        Intrinsics.checkNotNullParameter(paymentSettingEntityRepository, "");
        Intrinsics.checkNotNullParameter(popupUserConfig, "");
        UserConfigRepository userConfigRepository = paymentSettingEntityRepository.getAuthRequestContext;
        popupUserConfig.setHomePaymentSettingShown(true);
        Observable<Boolean> saveUserSpecificConfig = userConfigRepository.saveUserSpecificConfig(new PopupConfigStoreConfig(popupUserConfig));
        int i = moveToNextValue + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return saveUserSpecificConfig;
    }

    private static final ObservableSource BuiltInFictitiousFunctionClassFactory(final PaymentSettingEntityRepository paymentSettingEntityRepository, Observable observable) {
        Intrinsics.checkNotNullParameter(paymentSettingEntityRepository, "");
        Intrinsics.checkNotNullParameter(observable, "");
        ObservableSource flatMap = paymentSettingEntityRepository.getAuthRequestContext().flatMap(new Function() { // from class: id.dana.data.paymentsetting.PaymentSettingEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PaymentSettingEntityRepository.BuiltInFictitiousFunctionClassFactory(PaymentSettingEntityRepository.this, (String) obj);
            }
        });
        int i = moveToNextValue + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    private static final ObservableSource PlaceComponentResult(PaymentSettingEntityRepository paymentSettingEntityRepository, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(paymentSettingEntityRepository, "");
            Intrinsics.checkNotNullParameter(str, "");
            PreferencePaymentSettingEntityData BuiltInFictitiousFunctionClassFactory = paymentSettingEntityRepository.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullParameter(str, "");
            Observable just = Observable.just(Boolean.valueOf(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.MyBillsEntityDataFactory(str)));
            Intrinsics.checkNotNullExpressionValue(just, "");
            Observable observable = just;
            int i3 = moveToNextValue + 113;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if ((i3 % 2 != 0 ? '0' : '3') != '3') {
                int i4 = 47 / 0;
                return observable;
            }
            return observable;
        } catch (Exception e) {
            throw e;
        }
    }

    private final Observable<PopupUserConfig> MyBillsEntityDataFactory() {
        UserConfigRepository userConfigRepository = this.getAuthRequestContext;
        Object[] objArr = new Object[1];
        a(new char[]{7, 0, '\b', 3, 0, 3, 1, 4, 0, 5, 5, 7}, (byte) (View.MeasureSpec.getMode(0) + 97), TextUtils.indexOf("", "") + 12, objArr);
        Observable<PopupUserConfig> onErrorResumeNext = userConfigRepository.getUserSpecificConfig(new QueryConfig(((String) objArr[0]).intern(), PopupUserConfig.class)).onErrorResumeNext(new Function() { // from class: id.dana.data.paymentsetting.PaymentSettingEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PaymentSettingEntityRepository.getAuthRequestContext((Throwable) obj);
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 39;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        return onErrorResumeNext;
    }

    private static final Observable PlaceComponentResult(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        Observable just = Observable.just(new PopupUserConfig(false, 1, null));
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 73;
        moveToNextValue = i % 128;
        if ((i % 2 == 0 ? '^' : 'F') != 'F') {
            int i2 = 6 / 0;
            return just;
        }
        return just;
    }

    private final PreferencePaymentSettingEntityData BuiltInFictitiousFunctionClassFactory() {
        PreferencePaymentSettingEntityData preferencePaymentSettingEntityData = new PreferencePaymentSettingEntityData(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        try {
            int i = moveToNextValue + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            return preferencePaymentSettingEntityData;
        } catch (Exception e) {
            throw e;
        }
    }

    private final AccountEntityData PlaceComponentResult() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 97;
        moveToNextValue = i % 128;
        if ((i % 2 == 0 ? (char) 6 : (char) 29) == 29) {
            try {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local");
            } catch (Exception e) {
                throw e;
            }
        }
        AccountEntityData createData2 = this.KClassImpl$Data$declaredNonStaticMembers$2.createData2("local");
        Object[] objArr = null;
        int length = objArr.length;
        return createData2;
    }

    private final Observable<String> getAuthRequestContext() {
        try {
            try {
                Observable map = PlaceComponentResult().getAccount().map(new Function() { // from class: id.dana.data.paymentsetting.PaymentSettingEntityRepository$$ExternalSyntheticLambda8
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return PaymentSettingEntityRepository.PlaceComponentResult((AccountEntity) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(map, "");
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 119;
                moveToNextValue = i % 128;
                if ((i % 2 == 0 ? '(' : (char) 15) != '(') {
                    return map;
                }
                Object obj = null;
                obj.hashCode();
                return map;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final String getAuthRequestContext(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        String phoneNumber = accountEntity.getPhoneNumber();
        if ((phoneNumber == null ? (char) 24 : 'L') != 'L') {
            int i = moveToNextValue + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if ((i % 2 != 0 ? Typography.less : 'K') == '<') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = moveToNextValue + 11;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            int i3 = i2 % 2;
            return "";
        }
        return phoneNumber;
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = getAuthRequestContext;
        if (cArr2 != null) {
            try {
                int i3 = $10 + 71;
                $11 = i3 % 128;
                int i4 = i3 % 2;
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                for (int i5 = 0; i5 < length; i5++) {
                    cArr3[i5] = (char) (cArr2[i5] ^ (-1549216646985767851L));
                }
                cArr2 = cArr3;
            } catch (Exception e) {
                throw e;
            }
        }
        char c = (char) ((-1549216646985767851L) ^ scheduleImpl);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                int i6 = $11 + 97;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if ((getcallingpid.scheduleImpl == getcallingpid.lookAheadTest ? (char) 3 : '[') != '[') {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                        try {
                            int i10 = $10 + 7;
                            $11 = i10 % 128;
                            int i11 = i10 % 2;
                        } catch (Exception e2) {
                            throw e2;
                        }
                    } else if ((getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 ? 'C' : 'E') != 'E') {
                        int i12 = $11 + 97;
                        $10 = i12 % 128;
                        int i13 = i12 % 2;
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i14 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i15 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i14];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i15];
                    } else {
                        int i16 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i17 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i16];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i17];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        int i18 = 0;
        while (true) {
            if ((i18 < i ? 'D' : '_') != 'D') {
                String str = new String(cArr4);
                int i19 = $11 + 11;
                $10 = i19 % 128;
                int i20 = i19 % 2;
                objArr[0] = str;
                return;
            }
            cArr4[i18] = (char) (cArr4[i18] ^ 13722);
            i18++;
        }
    }
}
