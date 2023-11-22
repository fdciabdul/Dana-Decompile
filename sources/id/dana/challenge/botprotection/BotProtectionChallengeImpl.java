package id.dana.challenge.botprotection;

import android.app.Activity;
import com.akamai.botman.CYFMonitor;
import id.dana.R;
import id.dana.utils.CustomToastUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/challenge/botprotection/BotProtectionChallengeImpl;", "Lid/dana/challenge/botprotection/BotProtectionChallenge;", "Landroid/app/Activity;", "p0", "", "p1", "Lkotlin/Function0;", "", "p2", "getAuthRequestContext", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BotProtectionChallengeImpl implements BotProtectionChallenge {
    @Inject
    public BotProtectionChallengeImpl() {
    }

    @Override // id.dana.challenge.botprotection.BotProtectionChallenge
    public final void getAuthRequestContext(final Activity p0, String p1, final Function0<Unit> p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if (p0 != null) {
            CYFMonitor.PlaceComponentResult(p0, p1, new CYFMonitor.ChallengeActionCallback() { // from class: id.dana.challenge.botprotection.BotProtectionChallengeImpl$botDetectionCallback$1
                @Override // com.akamai.botman.CYFMonitor.ChallengeActionCallback
                public final void BuiltInFictitiousFunctionClassFactory(String p02) {
                    Intrinsics.checkNotNullParameter(p02, "");
                    CustomToastUtil.PlaceComponentResult(p0, R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1, R.drawable.bg_rounded_toast_failed, p02, 48, 60, false, null, 384);
                }

                @Override // com.akamai.botman.CYFMonitor.ChallengeActionCallback
                public final void MyBillsEntityDataFactory() {
                    p2.invoke();
                }
            });
        }
    }
}
