package id.dana.riskChallenges.ui.util.tracker;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.tracker.riskchallenges.RiskChallengeTracker;
import id.dana.riskChallenges.ui.util.model.TrackerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/ui/util/tracker/SetterRiskChallengeTracker;", "", "setterFromArgs", "", "riskChallengeTracker", "Lid/dana/analytics/tracker/riskchallenges/RiskChallengeTracker;", HummerConstants.BUNDLE, "Landroid/os/Bundle;", "feature-risk-challenges_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SetterRiskChallengeTracker {

    /* renamed from: id.dana.riskChallenges.ui.util.tracker.SetterRiskChallengeTracker$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static void BuiltInFictitiousFunctionClassFactory(RiskChallengeTracker riskChallengeTracker, Bundle bundle) {
            TrackerModel trackerModel;
            Parcelable parcelable;
            Intrinsics.checkNotNullParameter(riskChallengeTracker, "");
            if (bundle != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) bundle.getParcelable("KEY_TRACKER_MODEL", TrackerModel.class);
                } else {
                    Parcelable parcelable2 = bundle.getParcelable("KEY_TRACKER_MODEL");
                    if (!(parcelable2 instanceof TrackerModel)) {
                        parcelable2 = null;
                    }
                    parcelable = (TrackerModel) parcelable2;
                }
                trackerModel = (TrackerModel) parcelable;
            } else {
                trackerModel = null;
            }
            riskChallengeTracker.getAuthRequestContext(trackerModel != null ? trackerModel.KClassImpl$Data$declaredNonStaticMembers$2 : null);
            riskChallengeTracker.PlaceComponentResult(trackerModel != null ? trackerModel.BuiltInFictitiousFunctionClassFactory : null);
        }
    }
}
