package id.dana.core.ui.showcase;

import android.app.Activity;
import android.view.View;
import id.dana.core.ui.showcase.target.Target;
import id.dana.core.ui.showcase.view.SkipShowCaseView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/core/ui/showcase/SkipShowCase;", "Lid/dana/core/ui/showcase/SimpleShowcase;", "Landroid/view/View;", "getAuthRequestContext", "()Landroid/view/View;", "Lid/dana/core/ui/showcase/Params;", "p0", "Landroid/app/Activity;", "p1", "Lid/dana/core/ui/showcase/target/Target;", "p2", "Lid/dana/core/ui/showcase/OnShowcaseStateListener;", "p3", "<init>", "(Lid/dana/core/ui/showcase/Params;Landroid/app/Activity;Lid/dana/core/ui/showcase/target/Target;Lid/dana/core/ui/showcase/OnShowcaseStateListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SkipShowCase extends SimpleShowcase {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkipShowCase(Params params, Activity activity, Target target, OnShowcaseStateListener onShowcaseStateListener) {
        super(params, activity, target, onShowcaseStateListener, false, true);
        Intrinsics.checkNotNullParameter(target, "");
    }

    @Override // id.dana.core.ui.showcase.SimpleShowcase, id.dana.core.ui.showcase.BaseShowcase
    protected final View getAuthRequestContext() {
        Activity activity = this.PlaceComponentResult.get();
        Intrinsics.checkNotNullExpressionValue(activity, "");
        return new SkipShowCaseView(activity, null, 0, 6, null);
    }
}
