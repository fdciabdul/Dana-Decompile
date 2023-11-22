package id.dana.domain.nearbyme.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyme.model.MerchantInfo;
import id.dana.domain.nearbyme.model.NearbyShopsPromo;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/nearbyme/model/NearbyShopsPromo;", "Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/nearbyme/NearbyMeRepository;", "nearbyMeRepository", "Lid/dana/domain/nearbyme/NearbyMeRepository;", "<init>", "(Lid/dana/domain/nearbyme/NearbyMeRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetNearbyShopsPromo extends BaseUseCase<List<NearbyShopsPromo>, Params> {
    private final NearbyMeRepository nearbyMeRepository;

    @Inject
    public GetNearbyShopsPromo(NearbyMeRepository nearbyMeRepository) {
        Intrinsics.checkNotNullParameter(nearbyMeRepository, "");
        this.nearbyMeRepository = nearbyMeRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<List<NearbyShopsPromo>> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.nearbyMeRepository.getNearbyShopsPromo(params.getMerchantInfos());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/nearbyme/interactor/GetNearbyShopsPromo$Params;", "", "", "Lid/dana/domain/nearbyme/model/MerchantInfo;", "merchantInfos", "Ljava/util/List;", "getMerchantInfos", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final List<MerchantInfo> merchantInfos;

        public Params(List<MerchantInfo> list) {
            Intrinsics.checkNotNullParameter(list, "");
            this.merchantInfos = list;
        }

        @JvmName(name = "getMerchantInfos")
        public final List<MerchantInfo> getMerchantInfos() {
            return this.merchantInfos;
        }
    }
}
