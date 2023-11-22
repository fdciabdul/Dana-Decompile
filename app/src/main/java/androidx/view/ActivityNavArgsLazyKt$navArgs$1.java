package androidx.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavArgs;", "Args", "Landroid/os/Bundle;", BridgeDSL.INVOKE, "()Landroid/os/Bundle;"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes6.dex */
public final class ActivityNavArgsLazyKt$navArgs$1 extends Lambda implements Function0<Bundle> {
    final /* synthetic */ Activity $$this_navArgs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityNavArgsLazyKt$navArgs$1(Activity activity) {
        super(0);
        this.$$this_navArgs = activity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Bundle invoke() {
        Bundle bundle;
        Intent intent = this.$$this_navArgs.getIntent();
        if (intent != null) {
            Activity activity = this.$$this_navArgs;
            bundle = intent.getExtras();
            if (bundle == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Activity ");
                sb.append(activity);
                sb.append(" has null extras in ");
                sb.append(intent);
                throw new IllegalStateException(sb.toString());
            }
        } else {
            bundle = null;
        }
        if (bundle != null) {
            return bundle;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Activity ");
        sb2.append(this.$$this_navArgs);
        sb2.append(" has a null Intent");
        throw new IllegalStateException(sb2.toString());
    }
}