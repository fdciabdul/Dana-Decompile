package id.dana.showcase;

import android.app.Activity;
import android.view.View;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.DanaVizPromptShowcaseView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BO\b\u0010\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b"}, d2 = {"Lid/dana/showcase/DanaVizPromptShowcase;", "Lid/dana/showcase/BaseShowcase;", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "Lid/dana/showcase/target/Target;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/showcase/target/Target;", "", "moveToNextValue", "()V", "Lid/dana/showcase/target/Target;", "MyBillsEntityDataFactory", "Lid/dana/showcase/TextOnlyParams;", "p0", "Landroid/app/Activity;", "p1", "p2", "Lid/dana/showcase/OnShowcaseStateListener;", "p3", "", "p4", "p5", "p6", "p7", "<init>", "(Lid/dana/showcase/TextOnlyParams;Landroid/app/Activity;Lid/dana/showcase/target/Target;Lid/dana/showcase/OnShowcaseStateListener;ZZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaVizPromptShowcase extends BaseShowcase {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Target MyBillsEntityDataFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaVizPromptShowcase(TextOnlyParams textOnlyParams, Activity activity, Target target, OnShowcaseStateListener onShowcaseStateListener, boolean z, boolean z2, boolean z3, boolean z4) {
        super(textOnlyParams, activity, onShowcaseStateListener, z, z2, z3, z4);
        Intrinsics.checkNotNullParameter(target, "");
        this.MyBillsEntityDataFactory = target;
    }

    @Override // id.dana.showcase.BaseShowcase
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    protected final Target getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final void moveToNextValue() {
        KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.showcase.BaseShowcase
    protected final View KClassImpl$Data$declaredNonStaticMembers$2() {
        Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Intrinsics.checkNotNullExpressionValue(activity, "");
        DanaVizPromptShowcaseView danaVizPromptShowcaseView = new DanaVizPromptShowcaseView(activity, null, 0, 6, null);
        Params params = this.PlaceComponentResult;
        if (params != null) {
            danaVizPromptShowcaseView.setText(((TextOnlyParams) params).PlaceComponentResult);
            return danaVizPromptShowcaseView;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.showcase.TextOnlyParams");
    }
}
