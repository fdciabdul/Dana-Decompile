package id.dana.challenge;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\f\u0012\u001a\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\n\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\rR(\u0010\u0011\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/challenge/BridgeActivityChallengeControl;", "Lid/dana/challenge/ChallengeControlFacade;", "Ljava/lang/Class;", "p0", "Landroid/content/Intent;", "PlaceComponentResult", "(Ljava/lang/Class;)Landroid/content/Intent;", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Intent;I)V", "Landroid/app/Activity;", "Landroid/app/Activity;", "Lkotlin/Function2;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function2;", "getAuthRequestContext", "<init>", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BridgeActivityChallengeControl implements ChallengeControlFacade {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function2<Intent, Integer, Unit> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Activity BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public BridgeActivityChallengeControl(Activity activity, Function2<? super Intent, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(function2, "");
        this.BuiltInFictitiousFunctionClassFactory = activity;
        this.getAuthRequestContext = function2;
    }

    @Override // id.dana.challenge.ChallengeControlFacade
    public final Intent PlaceComponentResult(Class<?> p0) {
        return new Intent(this.BuiltInFictitiousFunctionClassFactory, p0);
    }

    @Override // id.dana.challenge.ChallengeControlFacade
    public final void BuiltInFictitiousFunctionClassFactory(Intent p0, int p1) {
        this.getAuthRequestContext.invoke(p0, Integer.valueOf(p1));
    }
}
