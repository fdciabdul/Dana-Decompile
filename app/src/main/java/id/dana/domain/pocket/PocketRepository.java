package id.dana.domain.pocket;

import id.dana.domain.pocket.model.LoyaltyToken;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface PocketRepository {
    Observable<LoyaltyToken> getLoyaltyToken();
}
