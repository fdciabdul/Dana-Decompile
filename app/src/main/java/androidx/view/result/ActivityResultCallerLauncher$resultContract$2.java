package androidx.view.result;

import android.content.Context;
import android.content.Intent;
import androidx.view.result.contract.ActivityResultContract;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"I", "O", "Landroidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1;", BridgeDSL.INVOKE, "()Landroidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final class ActivityResultCallerLauncher$resultContract$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher<I, O> activityResultCallerLauncher) {
        super(0);
        this.this$0 = activityResultCallerLauncher;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1] */
    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        final ActivityResultCallerLauncher<I, O> activityResultCallerLauncher = this.this$0;
        return new ActivityResultContract<Unit, O>() { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2.1
            @Override // androidx.view.result.contract.ActivityResultContract
            public final /* synthetic */ Intent createIntent(Context context, Unit unit) {
                Intrinsics.checkNotNullParameter(context, "");
                Intrinsics.checkNotNullParameter(unit, "");
                return activityResultCallerLauncher.BuiltInFictitiousFunctionClassFactory.createIntent(context, activityResultCallerLauncher.getAuthRequestContext);
            }

            @Override // androidx.view.result.contract.ActivityResultContract
            public final O parseResult(int p0, Intent p1) {
                return activityResultCallerLauncher.BuiltInFictitiousFunctionClassFactory.parseResult(p0, p1);
            }
        };
    }
}
