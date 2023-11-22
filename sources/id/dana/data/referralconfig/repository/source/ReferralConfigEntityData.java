package id.dana.data.referralconfig.repository.source;

import id.dana.data.referralconfig.model.ReferralConfigEntity;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface ReferralConfigEntityData {
    Observable<ReferralConfigEntity> getReferralConfig(String str);
}
