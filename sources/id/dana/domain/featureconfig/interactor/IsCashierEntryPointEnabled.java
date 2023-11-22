package id.dana.domain.featureconfig.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.interactor.IsCashierEntryPointEnabled;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/featureconfig/interactor/IsCashierEntryPointEnabled;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/featureconfig/interactor/IsCashierEntryPointEnabled$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/featureconfig/interactor/IsCashierEntryPointEnabled$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "<init>", "(Lid/dana/domain/featureconfig/FeatureConfigRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IsCashierEntryPointEnabled extends BaseUseCase<Boolean, Params> {
    private final FeatureConfigRepository featureConfigRepository;

    @Inject
    public IsCashierEntryPointEnabled(FeatureConfigRepository featureConfigRepository) {
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        this.featureConfigRepository = featureConfigRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.featureConfigRepository.isFeatureCashierEnable().flatMap(new Function() { // from class: id.dana.domain.featureconfig.interactor.IsCashierEntryPointEnabled$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2334buildUseCase$lambda2;
                m2334buildUseCase$lambda2 = IsCashierEntryPointEnabled.m2334buildUseCase$lambda2(IsCashierEntryPointEnabled.this, params, (Boolean) obj);
                return m2334buildUseCase$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final ObservableSource m2334buildUseCase$lambda2(IsCashierEntryPointEnabled isCashierEntryPointEnabled, final Params params, Boolean bool) {
        Intrinsics.checkNotNullParameter(isCashierEntryPointEnabled, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return bool.booleanValue() ? isCashierEntryPointEnabled.featureConfigRepository.getCashierNativeEntryPoints().map(new Function() { // from class: id.dana.domain.featureconfig.interactor.IsCashierEntryPointEnabled$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m2335buildUseCase$lambda2$lambda1;
                m2335buildUseCase$lambda2$lambda1 = IsCashierEntryPointEnabled.m2335buildUseCase$lambda2$lambda1(IsCashierEntryPointEnabled.Params.this, (List) obj);
                return m2335buildUseCase$lambda2$lambda1;
            }
        }) : Observable.just(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2$lambda-1  reason: not valid java name */
    public static final Boolean m2335buildUseCase$lambda2$lambda1(Params params, List list) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        boolean z = false;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual((String) it.next(), params.getEntryPoint())) {
                    z = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/featureconfig/interactor/IsCashierEntryPointEnabled$Params;", "", "", "entryPoint", "Ljava/lang/String;", "getEntryPoint$domain_productionRelease", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static class Params {
        private final String entryPoint;

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.entryPoint = str;
        }

        @JvmName(name = "getEntryPoint$domain_productionRelease")
        /* renamed from: getEntryPoint$domain_productionRelease  reason: from getter */
        public final String getEntryPoint() {
            return this.entryPoint;
        }
    }
}
