package id.dana.showcase;

import android.app.Activity;
import android.view.View;
import id.dana.showcase.target.Target;
import id.dana.showcase.view.InfoContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B/\b\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/showcase/InfoShowcase;", "Lid/dana/showcase/SimpleShowcase;", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "Lid/dana/showcase/Params;", "p0", "Landroid/app/Activity;", "p1", "Lid/dana/showcase/target/Target;", "p2", "Lid/dana/showcase/OnShowcaseStateListener;", "p3", "<init>", "(Lid/dana/showcase/Params;Landroid/app/Activity;Lid/dana/showcase/target/Target;Lid/dana/showcase/OnShowcaseStateListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class InfoShowcase extends SimpleShowcase {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoShowcase(Params params, Activity activity, Target target, OnShowcaseStateListener onShowcaseStateListener) {
        super(params, activity, target, onShowcaseStateListener);
        Intrinsics.checkNotNullParameter(target, "");
    }

    @Override // id.dana.showcase.SimpleShowcase, id.dana.showcase.BaseShowcase
    protected final View KClassImpl$Data$declaredNonStaticMembers$2() {
        Activity activity = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        Intrinsics.checkNotNullExpressionValue(activity, "");
        return new InfoContentView(activity, null, 0, 6, null);
    }
}
