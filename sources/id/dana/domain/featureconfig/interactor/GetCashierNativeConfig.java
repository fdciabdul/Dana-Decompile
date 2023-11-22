package id.dana.domain.featureconfig.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.CashierMerchantWhitelistConfig;
import id.dana.domain.featureconfig.model.CashierNativeConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function4;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/featureconfig/interactor/GetCashierNativeConfig;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/featureconfig/model/CashierNativeConfig;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetCashierNativeConfig extends BaseUseCase<CashierNativeConfig, NoParams> {
    private final FeatureConfigRepository featureConfigRepository;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3$lambda-0  reason: not valid java name */
    public static final CashierMerchantWhitelistConfig m2329buildUseCase$lambda3$lambda0(CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig, Throwable th) {
        Intrinsics.checkNotNullParameter(cashierMerchantWhitelistConfig, "");
        Intrinsics.checkNotNullParameter(th, "");
        return cashierMerchantWhitelistConfig;
    }

    @Inject
    public GetCashierNativeConfig(FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.featureConfigRepository = featureConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<CashierNativeConfig> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        final CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig = new CashierMerchantWhitelistConfig("", CollectionsKt.emptyList());
        Observable flatMap = this.featureConfigRepository.isFeatureCashierEnable().flatMap(new Function() { // from class: id.dana.domain.featureconfig.interactor.GetCashierNativeConfig$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2328buildUseCase$lambda3;
                m2328buildUseCase$lambda3 = GetCashierNativeConfig.m2328buildUseCase$lambda3(GetCashierNativeConfig.this, cashierMerchantWhitelistConfig, (Boolean) obj);
                return m2328buildUseCase$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3  reason: not valid java name */
    public static final ObservableSource m2328buildUseCase$lambda3(GetCashierNativeConfig getCashierNativeConfig, final CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig, Boolean bool) {
        Observable just;
        Intrinsics.checkNotNullParameter(getCashierNativeConfig, "");
        Intrinsics.checkNotNullParameter(cashierMerchantWhitelistConfig, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            just = Observable.zip(getCashierNativeConfig.featureConfigRepository.isFeatureCashierDeeplinkKybEnabled(), getCashierNativeConfig.featureConfigRepository.isFeaturePaymentKeyboardEnable(), getCashierNativeConfig.featureConfigRepository.getCashierMerchantWhitelistConfig().onErrorReturn(new Function() { // from class: id.dana.domain.featureconfig.interactor.GetCashierNativeConfig$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    CashierMerchantWhitelistConfig m2329buildUseCase$lambda3$lambda0;
                    m2329buildUseCase$lambda3$lambda0 = GetCashierNativeConfig.m2329buildUseCase$lambda3$lambda0(CashierMerchantWhitelistConfig.this, (Throwable) obj);
                    return m2329buildUseCase$lambda3$lambda0;
                }
            }), getCashierNativeConfig.featureConfigRepository.getCashierNativeEntryPoints().onErrorReturn(new Function() { // from class: id.dana.domain.featureconfig.interactor.GetCashierNativeConfig$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    List m2330buildUseCase$lambda3$lambda1;
                    m2330buildUseCase$lambda3$lambda1 = GetCashierNativeConfig.m2330buildUseCase$lambda3$lambda1((Throwable) obj);
                    return m2330buildUseCase$lambda3$lambda1;
                }
            }), new Function4() { // from class: id.dana.domain.featureconfig.interactor.GetCashierNativeConfig$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function4
                public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                    CashierNativeConfig m2331buildUseCase$lambda3$lambda2;
                    m2331buildUseCase$lambda3$lambda2 = GetCashierNativeConfig.m2331buildUseCase$lambda3$lambda2((Boolean) obj, (Boolean) obj2, (CashierMerchantWhitelistConfig) obj3, (List) obj4);
                    return m2331buildUseCase$lambda3$lambda2;
                }
            });
        } else {
            just = Observable.just(new CashierNativeConfig(false, false, false, cashierMerchantWhitelistConfig, CollectionsKt.emptyList()));
        }
        return just;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3$lambda-1  reason: not valid java name */
    public static final List m2330buildUseCase$lambda3$lambda1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3$lambda-2  reason: not valid java name */
    public static final CashierNativeConfig m2331buildUseCase$lambda3$lambda2(Boolean bool, Boolean bool2, CashierMerchantWhitelistConfig cashierMerchantWhitelistConfig, List list) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        Intrinsics.checkNotNullParameter(cashierMerchantWhitelistConfig, "");
        Intrinsics.checkNotNullParameter(list, "");
        return new CashierNativeConfig(true, bool.booleanValue(), bool2.booleanValue(), cashierMerchantWhitelistConfig, list);
    }
}
