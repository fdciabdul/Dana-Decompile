package id.dana.riskChallenges.di.component;

import android.content.Context;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/Context;", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)Lid/dana/riskChallenges/di/component/RiskChallengesComponent;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RiskChallengesComponentKt {
    public static final RiskChallengesComponent BuiltInFictitiousFunctionClassFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.riskChallenges.di.provider.RiskChallengesProvider");
        }
        return ((RiskChallengesProvider) applicationContext).provideRiskChallengesComponent().BuiltInFictitiousFunctionClassFactory();
    }
}
