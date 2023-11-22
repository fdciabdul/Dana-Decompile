package id.dana.cardbinding.view;

import androidx.transition.AutoTransition;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/transition/AutoTransition;", BridgeDSL.INVOKE, "()Landroidx/transition/AutoTransition;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
final class CardView$transition$2 extends Lambda implements Function0<AutoTransition> {
    public static final CardView$transition$2 INSTANCE = new CardView$transition$2();

    CardView$transition$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AutoTransition invoke() {
        AutoTransition autoTransition = new AutoTransition();
        new AutoTransition().setDuration(500L);
        return autoTransition;
    }
}
