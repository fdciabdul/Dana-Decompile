package id.dana.domain.referralconfig;

import id.dana.domain.referralconfig.model.ReferralConfig;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface ReferralConfigRepository {
    Observable<ReferralConfig> getReferralHomeConfig();

    Observable<ReferralConfig> getReferralSendMoneyConfig();
}
