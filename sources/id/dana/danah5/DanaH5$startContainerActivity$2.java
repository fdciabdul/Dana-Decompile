package id.dana.danah5;

import android.os.Bundle;
import androidx.view.Lifecycle;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import id.dana.lib.gcontainer.ContainerLifecycleCallback;
import id.dana.lib.gcontainer.GContainer;
import id.dana.utils.danah5.DanaH5Listener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DanaH5$startContainerActivity$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Bundle $$bundle;
    final /* synthetic */ DanaH5Listener $$danaH5Listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaH5$startContainerActivity$2(Bundle bundle, DanaH5Listener danaH5Listener) {
        super(0);
        this.$$bundle = bundle;
        this.$$danaH5Listener = danaH5Listener;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke */
    public final void invoke2() {
        final Bundle bundle = this.$$bundle;
        final DanaH5Listener danaH5Listener = this.$$danaH5Listener;
        GContainer.openUrl$default(bundle, null, new ContainerLifecycleCallback() { // from class: id.dana.danah5.DanaH5$startContainerActivity$2$$ExternalSyntheticLambda0
            @Override // id.dana.lib.gcontainer.ContainerLifecycleCallback
            public final void onContainerActivityLifecycleEvent(Lifecycle.Event event, GriverBaseActivity griverBaseActivity) {
                DanaH5$startContainerActivity$2.m627invoke$lambda0(DanaH5Listener.this, bundle, event, griverBaseActivity);
            }
        }, 2, null);
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m627invoke$lambda0(DanaH5Listener danaH5Listener, Bundle bundle, Lifecycle.Event event, GriverBaseActivity griverBaseActivity) {
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(event, "");
        Intrinsics.checkNotNullParameter(griverBaseActivity, "");
        if (event == Lifecycle.Event.ON_CREATE) {
            if (danaH5Listener != null) {
                danaH5Listener.onContainerCreated(bundle);
            }
        } else if (event != Lifecycle.Event.ON_DESTROY || danaH5Listener == null) {
        } else {
            danaH5Listener.onContainerDestroyed(bundle);
        }
    }
}
