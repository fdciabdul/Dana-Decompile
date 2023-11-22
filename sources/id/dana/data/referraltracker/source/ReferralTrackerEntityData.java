package id.dana.data.referraltracker.source;

import id.dana.data.referraltracker.source.network.result.ReferralTrackerRpcResult;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface ReferralTrackerEntityData {
    Observable<ReferralTrackerRpcResult> getReferralTracker(int i, int i2);
}
