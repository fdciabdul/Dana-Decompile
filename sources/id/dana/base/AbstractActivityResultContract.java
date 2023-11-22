package id.dana.base;

import android.content.Context;
import android.content.Intent;
import androidx.view.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/base/AbstractActivityResultContract;", "I", "O", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Context;", "p0", "p1", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/Object;)Landroid/content/Intent;", "Lid/dana/base/BaseActivity;", "PlaceComponentResult", "(Lid/dana/base/BaseActivity;Ljava/lang/Object;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AbstractActivityResultContract<I, O> extends ActivityResultContract<I, O> {
    public abstract Intent PlaceComponentResult(BaseActivity p0, I p1);

    @Override // androidx.view.result.contract.ActivityResultContract
    public Intent createIntent(Context p0, I p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        return PlaceComponentResult((BaseActivity) p0, p1);
    }
}
