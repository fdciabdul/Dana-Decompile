package id.dana.domain.globalnetwork.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.globalnetwork.interactor.IsMerchantBlockRegistration;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/globalnetwork/interactor/IsMerchantBlockRegistration;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/globalnetwork/interactor/IsMerchantBlockRegistration$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/globalnetwork/interactor/IsMerchantBlockRegistration$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/globalnetwork/GlobalNetworkRepository;", "repository", "Lid/dana/domain/globalnetwork/GlobalNetworkRepository;", "<init>", "(Lid/dana/domain/globalnetwork/GlobalNetworkRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IsMerchantBlockRegistration extends BaseUseCase<Boolean, Params> {
    private final GlobalNetworkRepository repository;

    @Inject
    public IsMerchantBlockRegistration(GlobalNetworkRepository globalNetworkRepository) {
        Intrinsics.checkNotNullParameter(globalNetworkRepository, "");
        this.repository = globalNetworkRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable map = this.repository.getMerchantBlockRegistration().map(new Function() { // from class: id.dana.domain.globalnetwork.interactor.IsMerchantBlockRegistration$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m2349buildUseCase$lambda0;
                m2349buildUseCase$lambda0 = IsMerchantBlockRegistration.m2349buildUseCase$lambda0(IsMerchantBlockRegistration.Params.this, (List) obj);
                return m2349buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final Boolean m2349buildUseCase$lambda0(Params params, List list) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(list, "");
        return Boolean.valueOf(list.contains(params.getSubMerchantId()));
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/globalnetwork/interactor/IsMerchantBlockRegistration$Params;", "", "", "subMerchantId", "Ljava/lang/String;", "getSubMerchantId$domain_productionRelease", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final String subMerchantId;

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.subMerchantId = str;
        }

        @JvmName(name = "getSubMerchantId$domain_productionRelease")
        /* renamed from: getSubMerchantId$domain_productionRelease  reason: from getter */
        public final String getSubMerchantId() {
            return this.subMerchantId;
        }
    }
}
