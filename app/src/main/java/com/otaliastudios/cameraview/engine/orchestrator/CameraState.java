package com.otaliastudios.cameraview.engine.orchestrator;

/* loaded from: classes2.dex */
public enum CameraState {
    OFF(0),
    ENGINE(1),
    BIND(2),
    PREVIEW(3);

    private int mState;

    CameraState(int i) {
        this.mState = i;
    }

    public final boolean isAtLeast(CameraState cameraState) {
        return this.mState >= cameraState.mState;
    }
}
