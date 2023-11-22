package id.dana.showcase;

import android.app.Activity;
import android.view.View;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.SimpleDismissibleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000e"}, d2 = {"Lid/dana/showcase/SimpleDismissibleShowcase;", "Lid/dana/showcase/BaseShowcase;", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "Lid/dana/showcase/target/Target;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/showcase/target/Target;", "", "lookAheadTest", "()Z", "", "moveToNextValue", "()V", "Lid/dana/showcase/target/Target;", "PlaceComponentResult", "Lid/dana/showcase/Params;", "p0", "Landroid/app/Activity;", "p1", "p2", "Lid/dana/showcase/OnShowcaseStateListener;", "p3", "p4", "p5", "", "p6", "p7", "<init>", "(Lid/dana/showcase/Params;Landroid/app/Activity;Lid/dana/showcase/target/Target;Lid/dana/showcase/OnShowcaseStateListener;ZZII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SimpleDismissibleShowcase extends BaseShowcase {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Target PlaceComponentResult;

    public SimpleDismissibleShowcase(Params params, Activity activity, Target target, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2, int i, int i2) {
        super(params, activity, onShowcaseStateListener, z, z2, i, i2);
        this.PlaceComponentResult = target;
    }

    @Override // id.dana.showcase.BaseShowcase
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    protected final Target getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final void moveToNextValue() {
        KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.showcase.BaseShowcase
    public final boolean lookAheadTest() {
        return super.lookAheadTest() || this.PlaceComponentResult == null;
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final View KClassImpl$Data$declaredNonStaticMembers$2() {
        Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Intrinsics.checkNotNullExpressionValue(activity, "");
        Activity activity2 = activity;
        Target target = this.PlaceComponentResult;
        return new SimpleDismissibleView(activity2, null, 0, target != null ? target.PlaceComponentResult : null, new SimpleDismissibleShowcase$getContentView$1(this), 6, null);
    }
}
