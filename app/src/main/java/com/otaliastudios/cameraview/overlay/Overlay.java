package com.otaliastudios.cameraview.overlay;

import android.graphics.Canvas;

/* loaded from: classes8.dex */
public interface Overlay {

    /* loaded from: classes8.dex */
    public enum Target {
        PREVIEW,
        PICTURE_SNAPSHOT,
        VIDEO_SNAPSHOT
    }

    void drawOn(Target target, Canvas canvas);

    boolean drawsOn(Target target);
}
