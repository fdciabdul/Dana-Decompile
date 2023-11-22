package id.dana.challenge;

import android.content.Intent;
import id.dana.base.BaseFragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r"}, d2 = {"Lid/dana/challenge/FragmentChallengeControl;", "Lid/dana/challenge/ChallengeControlFacade;", "Ljava/lang/Class;", "p0", "Landroid/content/Intent;", "PlaceComponentResult", "(Ljava/lang/Class;)Landroid/content/Intent;", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Intent;I)V", "Lid/dana/base/BaseFragment;", "Lid/dana/base/BaseFragment;", "<init>", "(Lid/dana/base/BaseFragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FragmentChallengeControl implements ChallengeControlFacade {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final BaseFragment PlaceComponentResult;

    public FragmentChallengeControl(BaseFragment baseFragment) {
        this.PlaceComponentResult = baseFragment;
    }

    @Override // id.dana.challenge.ChallengeControlFacade
    public final Intent PlaceComponentResult(Class<?> p0) {
        BaseFragment baseFragment = this.PlaceComponentResult;
        return new Intent(baseFragment != null ? baseFragment.getBaseActivity() : null, p0);
    }

    @Override // id.dana.challenge.ChallengeControlFacade
    public final void BuiltInFictitiousFunctionClassFactory(Intent p0, int p1) {
        BaseFragment baseFragment = this.PlaceComponentResult;
        if (baseFragment != null) {
            baseFragment.startActivityForResult(p0, p1);
        }
    }
}
