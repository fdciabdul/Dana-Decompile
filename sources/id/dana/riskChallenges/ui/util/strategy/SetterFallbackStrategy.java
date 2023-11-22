package id.dana.riskChallenges.ui.util.strategy;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.ui.util.model.HistoryFallbackModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/ui/util/strategy/SetterFallbackStrategy;", "", "setterFromArgs", "", "currentVerificationMethod", "", "fallbackStrategy", "Lid/dana/riskChallenges/ui/util/strategy/FallbackStrategy;", HummerConstants.BUNDLE, "Landroid/os/Bundle;", "feature-risk-challenges_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SetterFallbackStrategy {

    /* renamed from: id.dana.riskChallenges.ui.util.strategy.SetterFallbackStrategy$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [android.os.Parcelable] */
        public static void KClassImpl$Data$declaredNonStaticMembers$2(@RiskChallengeKey String str, FallbackStrategy fallbackStrategy, Bundle bundle) {
            HistoryFallbackModel historyFallbackModel;
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(fallbackStrategy, "");
            fallbackStrategy.BuiltInFictitiousFunctionClassFactory(str);
            String string = bundle != null ? bundle.getString("KEY_FALLBACK_VERIFICATION_METHOD") : null;
            fallbackStrategy.KClassImpl$Data$declaredNonStaticMembers$2(string != null ? string : "");
            if (bundle != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    historyFallbackModel = (Parcelable) bundle.getParcelable("KEY_HISTORY_FALLBACK_MODEL", HistoryFallbackModel.class);
                } else {
                    ?? parcelable = bundle.getParcelable("KEY_HISTORY_FALLBACK_MODEL");
                    historyFallbackModel = parcelable instanceof HistoryFallbackModel ? parcelable : null;
                }
                r3 = (HistoryFallbackModel) historyFallbackModel;
            }
            fallbackStrategy.PlaceComponentResult(r3);
        }
    }
}
