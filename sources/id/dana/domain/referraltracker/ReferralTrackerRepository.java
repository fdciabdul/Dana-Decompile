package id.dana.domain.referraltracker;

import id.dana.domain.referraltracker.model.ReferralTracker;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface ReferralTrackerRepository {
    Observable<ReferralTracker> getReferralTracker(int i, int i2);
}
