package com.google.android.play.core.ktx;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B*\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\u0019\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0002\b\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R*\u0010\t\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\u0002\b\b8\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00018\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lcom/google/android/play/core/ktx/AppUpdatePassthroughListener;", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "Lcom/google/android/play/core/install/InstallState;", "state", "", "onStateUpdate", "(Lcom/google/android/play/core/install/InstallState;)V", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "disposeAction", "Lkotlin/jvm/functions/Function1;", "getDisposeAction", "()Lkotlin/jvm/functions/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "getListener", "()Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "<init>", "(Lcom/google/android/play/core/install/InstallStateUpdatedListener;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
final class AppUpdatePassthroughListener implements InstallStateUpdatedListener {
    private final Function1<AppUpdatePassthroughListener, Unit> disposeAction;
    private final InstallStateUpdatedListener listener;

    @JvmName(name = "getListener")
    public final InstallStateUpdatedListener getListener() {
        return this.listener;
    }

    @JvmName(name = "getDisposeAction")
    public final Function1<AppUpdatePassthroughListener, Unit> getDisposeAction() {
        return this.disposeAction;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppUpdatePassthroughListener(InstallStateUpdatedListener installStateUpdatedListener, Function1<? super AppUpdatePassthroughListener, Unit> function1) {
        Intrinsics.checkNotNullParameter(installStateUpdatedListener, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.listener = installStateUpdatedListener;
        this.disposeAction = function1;
    }

    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public final void onStateUpdate(InstallState state) {
        Intrinsics.checkNotNullParameter(state, "");
        this.listener.onStateUpdate(state);
        int installStatus = state.installStatus();
        if (installStatus == 0 || installStatus == 11 || installStatus == 5 || installStatus == 6) {
            this.disposeAction.invoke(this);
        }
    }
}
