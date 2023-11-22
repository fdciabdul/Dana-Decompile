package id.dana.cashier.domain.interactor;

import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0019\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/cashier/domain/interactor/GetCustomLoading3dsUrls;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/data/config/source/sharedpreference/SharedPrefCashierConfig;", "sharedPrefCashierConfig", "Lid/dana/data/config/source/sharedpreference/SharedPrefCashierConfig;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/data/config/source/sharedpreference/SharedPrefCashierConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetCustomLoading3dsUrls extends BaseUseCase<List<? extends String>, NoParams> {
    private final FeatureConfigRepository featureConfigRepository;
    private final SharedPrefCashierConfig sharedPrefCashierConfig;

    @Inject
    public GetCustomLoading3dsUrls(FeatureConfigRepository featureConfigRepository, SharedPrefCashierConfig sharedPrefCashierConfig) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(sharedPrefCashierConfig, "");
        this.featureConfigRepository = featureConfigRepository;
        this.sharedPrefCashierConfig = sharedPrefCashierConfig;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<String>> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<List<String>> customLoading3dsUrls = this.featureConfigRepository.getCustomLoading3dsUrls();
        final SharedPrefCashierConfig sharedPrefCashierConfig = this.sharedPrefCashierConfig;
        Observable<List<String>> onErrorReturn = customLoading3dsUrls.doOnNext(new Consumer() { // from class: id.dana.cashier.domain.interactor.GetCustomLoading3dsUrls$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SharedPrefCashierConfig.this.saveCustomLoading3dsUrls((List) obj);
            }
        }).onErrorReturn(new Function() { // from class: id.dana.cashier.domain.interactor.GetCustomLoading3dsUrls$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m577buildUseCase$lambda0;
                m577buildUseCase$lambda0 = GetCustomLoading3dsUrls.m577buildUseCase$lambda0((Throwable) obj);
                return m577buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final List m577buildUseCase$lambda0(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return CollectionsKt.emptyList();
    }
}
