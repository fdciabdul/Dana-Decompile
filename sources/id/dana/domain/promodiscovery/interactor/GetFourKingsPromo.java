package id.dana.domain.promodiscovery.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.promodiscovery.model.FourKingsPromoModel;
import id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/domain/promodiscovery/interactor/GetFourKingsPromo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "", "fourKingsTypes", "Ljava/util/List;", "Lid/dana/domain/promodiscovery/repository/PromoDiscoveryRepository;", "promoDiscoveryRepository", "Lid/dana/domain/promodiscovery/repository/PromoDiscoveryRepository;", "<init>", "(Lid/dana/domain/promodiscovery/repository/PromoDiscoveryRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetFourKingsPromo extends BaseUseCase<List<? extends FourKingsPromoModel>, NoParams> {
    private final List<String> fourKingsTypes;
    private PromoDiscoveryRepository promoDiscoveryRepository;

    @Inject
    public GetFourKingsPromo(PromoDiscoveryRepository promoDiscoveryRepository) {
        Intrinsics.checkNotNullParameter(promoDiscoveryRepository, "");
        this.promoDiscoveryRepository = promoDiscoveryRepository;
        this.fourKingsTypes = CollectionsKt.listOf((Object[]) new String[]{"POINT", "VOUCHER", "LOYALTY", "QUEST"});
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<FourKingsPromoModel>> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.promoDiscoveryRepository.getFourKingsPromo(this.fourKingsTypes);
    }
}
