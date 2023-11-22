package com.google.android.play.core.install;

/* loaded from: classes7.dex */
final class NativeInstallStateUpdateListener implements InstallStateUpdatedListener {
    NativeInstallStateUpdateListener() {
    }

    @Override // com.google.android.play.core.listener.StateUpdatedListener
    public final native void onStateUpdate(InstallState installState);
}
