package id.dana.base.extension;

import butterknife.Unbinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"tryUnbind", "", "Lbutterknife/Unbinder;", "finalAction", "Ljava/lang/Runnable;", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UnbinderKtx {
    public static /* synthetic */ void MyBillsEntityDataFactory() {
    }

    public static final void getAuthRequestContext(Unbinder unbinder, Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "");
        if (unbinder == null) {
            return;
        }
        try {
            try {
                unbinder.getAuthRequestContext();
            } catch (IllegalStateException e) {
                IllegalStateException illegalStateException = e;
            }
        } finally {
            runnable.run();
        }
    }

    public static final void MyBillsEntityDataFactory(Unbinder unbinder) {
        getAuthRequestContext(unbinder, new UnbinderKtx$$ExternalSyntheticLambda0());
    }
}
