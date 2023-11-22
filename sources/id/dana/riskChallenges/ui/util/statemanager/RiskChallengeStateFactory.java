package id.dana.riskChallenges.ui.util.statemanager;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import id.dana.riskChallenges.ui.util.RiskChallengeFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/riskChallenges/ui/util/statemanager/RiskChallengeStateFactory;", "Lid/dana/riskChallenges/ui/util/RiskChallengeFactory;", "Landroid/os/Bundle;", "Lid/dana/riskChallenges/ui/util/statemanager/ChallengeState;", "Landroidx/fragment/app/FragmentActivity;", "getAuthRequestContext", "Landroidx/fragment/app/FragmentActivity;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RiskChallengeStateFactory implements RiskChallengeFactory<Bundle, ChallengeState> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final FragmentActivity KClassImpl$Data$declaredNonStaticMembers$2;

    public RiskChallengeStateFactory(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentActivity;
    }
}
