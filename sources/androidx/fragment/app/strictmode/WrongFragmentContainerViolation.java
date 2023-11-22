package androidx.fragment.app.strictmode;

import android.view.ViewGroup;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/fragment/app/strictmode/WrongFragmentContainerViolation;", "Landroidx/fragment/app/strictmode/Violation;", "Landroid/view/ViewGroup;", BranchLinkConstant.PathTarget.CONTAINER, "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WrongFragmentContainerViolation extends Violation {
    private final ViewGroup container;

    @JvmName(name = "getContainer")
    public final ViewGroup getContainer() {
        return this.container;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public WrongFragmentContainerViolation(androidx.fragment.app.Fragment r3, android.view.ViewGroup r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Attempting to add fragment "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = " to container "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = " which is not a FragmentContainerView"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.<init>(r3, r0)
            r2.container = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.strictmode.WrongFragmentContainerViolation.<init>(androidx.fragment.app.Fragment, android.view.ViewGroup):void");
    }
}
