package androidx.view.result.contract;

import android.content.Context;
import android.content.Intent;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContract;", "I", "O", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "input", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Ljava/lang/Object;)Landroid/content/Intent;", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "getSynchronousResult", "(Landroid/content/Context;Ljava/lang/Object;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "", "resultCode", "intent", "parseResult", "(ILandroid/content/Intent;)Ljava/lang/Object;", "<init>", "()V", "SynchronousResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {
    public abstract Intent createIntent(Context context, I input);

    public SynchronousResult<O> getSynchronousResult(Context context, I input) {
        Intrinsics.checkNotNullParameter(context, "");
        return null;
    }

    public abstract O parseResult(int resultCode, Intent intent);

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00028\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "T", "", "PlaceComponentResult", "Ljava/lang/Object;", "p0", "<init>", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SynchronousResult<T> {
        public final T PlaceComponentResult;

        public SynchronousResult(T t) {
            this.PlaceComponentResult = t;
        }
    }
}
