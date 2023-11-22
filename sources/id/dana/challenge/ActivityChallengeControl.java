package id.dana.challenge;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/challenge/ActivityChallengeControl;", "Lid/dana/challenge/ChallengeControlFacade;", "Ljava/lang/Class;", "p0", "Landroid/content/Intent;", "PlaceComponentResult", "(Ljava/lang/Class;)Landroid/content/Intent;", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Intent;I)V", "Landroid/app/Activity;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/app/Activity;", "MyBillsEntityDataFactory", "<init>", "(Landroid/app/Activity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ActivityChallengeControl implements ChallengeControlFacade {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Activity MyBillsEntityDataFactory;

    public ActivityChallengeControl(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.MyBillsEntityDataFactory = activity;
    }

    @Override // id.dana.challenge.ChallengeControlFacade
    public final Intent PlaceComponentResult(Class<?> p0) {
        return new Intent(this.MyBillsEntityDataFactory, p0);
    }

    @Override // id.dana.challenge.ChallengeControlFacade
    public final void BuiltInFictitiousFunctionClassFactory(Intent p0, int p1) {
        this.MyBillsEntityDataFactory.startActivityForResult(p0, p1);
    }
}
