package id.dana.data.promodiscovery.repository.source.local;

import id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData;
import id.dana.data.promodiscovery.repository.source.network.response.ProductInfoResponse;
import id.dana.data.promodiscovery.repository.source.network.response.PromoFourKingsResponse;
import id.dana.data.promodiscovery.repository.source.split.model.PromoDiscoveryEntity;
import id.dana.domain.promodiscovery.model.FourKingsPromoModel;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/local/LocalPromoDiscoveryEntityData;", "Lid/dana/data/promodiscovery/repository/PromoDiscoveryEntityData;", "", "userId", "Lio/reactivex/Observable;", "", "Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "getFourKingsLocal", "(Ljava/lang/String;)Lio/reactivex/Observable;", "fourKingsTypes", "Lid/dana/data/promodiscovery/repository/source/network/response/PromoFourKingsResponse;", "getFourKingsPromo", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "searchCriteriaMap", "Lid/dana/data/promodiscovery/repository/source/network/response/ProductInfoResponse;", "getPromoDanaDeals", "(Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/data/promodiscovery/repository/source/split/model/PromoDiscoveryEntity;", "getPromoDiscoveryConfig", "()Lio/reactivex/Observable;", "fourKingsPromo", "", "setFourKingsLocal", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/data/promodiscovery/repository/source/local/FourKingsDiscoveryPreferences;", "fourKingsDiscoveryPreferences", "Lid/dana/data/promodiscovery/repository/source/local/FourKingsDiscoveryPreferences;", "<init>", "(Lid/dana/data/promodiscovery/repository/source/local/FourKingsDiscoveryPreferences;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalPromoDiscoveryEntityData implements PromoDiscoveryEntityData {
    private final FourKingsDiscoveryPreferences fourKingsDiscoveryPreferences;

    @Inject
    public LocalPromoDiscoveryEntityData(FourKingsDiscoveryPreferences fourKingsDiscoveryPreferences) {
        Intrinsics.checkNotNullParameter(fourKingsDiscoveryPreferences, "");
        this.fourKingsDiscoveryPreferences = fourKingsDiscoveryPreferences;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<PromoDiscoveryEntity> getPromoDiscoveryConfig() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<ProductInfoResponse> getPromoDanaDeals(Map<String, String> searchCriteriaMap) {
        Intrinsics.checkNotNullParameter(searchCriteriaMap, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<PromoFourKingsResponse> getFourKingsPromo(List<String> fourKingsTypes) {
        Intrinsics.checkNotNullParameter(fourKingsTypes, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<List<FourKingsPromoModel>> getFourKingsLocal(String userId) {
        Intrinsics.checkNotNullParameter(userId, "");
        return this.fourKingsDiscoveryPreferences.getFourKingsDiscoveryData(userId);
    }

    @Override // id.dana.data.promodiscovery.repository.PromoDiscoveryEntityData
    public final Observable<Unit> setFourKingsLocal(String userId, List<FourKingsPromoModel> fourKingsPromo) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(fourKingsPromo, "");
        return this.fourKingsDiscoveryPreferences.setFourKingsDiscoveryData(userId, fourKingsPromo);
    }
}
