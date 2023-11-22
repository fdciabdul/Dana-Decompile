package androidx.view.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavArgs;", "Args", "Landroid/os/Bundle;", BridgeDSL.INVOKE, "()Landroid/os/Bundle;"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes6.dex */
public final class FragmentNavArgsLazyKt$navArgs$1 extends Lambda implements Function0<Bundle> {
    final /* synthetic */ Fragment $$this_navArgs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentNavArgsLazyKt$navArgs$1(Fragment fragment) {
        super(0);
        this.$$this_navArgs = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Bundle invoke() {
        Bundle arguments = this.$$this_navArgs.getArguments();
        if (arguments != null) {
            return arguments;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this.$$this_navArgs);
        sb.append(" has null arguments");
        throw new IllegalStateException(sb.toString());
    }
}
