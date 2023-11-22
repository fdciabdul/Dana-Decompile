package androidx.core.transition;

import android.transition.Transition;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/transition/Transition;", "it", "", BridgeDSL.INVOKE, "(Landroid/transition/Transition;)V"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes6.dex */
public final class TransitionKt$addListener$2 extends Lambda implements Function1<Transition, Unit> {
    public static final TransitionKt$addListener$2 INSTANCE = new TransitionKt$addListener$2();

    public TransitionKt$addListener$2() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Transition transition) {
        Intrinsics.checkNotNullParameter(transition, "");
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
        invoke2(transition);
        return Unit.INSTANCE;
    }
}
