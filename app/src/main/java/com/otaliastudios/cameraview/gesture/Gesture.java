package com.otaliastudios.cameraview.gesture;

/* loaded from: classes2.dex */
public enum Gesture {
    PINCH(GestureType.CONTINUOUS),
    TAP(GestureType.ONE_SHOT),
    LONG_TAP(GestureType.ONE_SHOT),
    SCROLL_HORIZONTAL(GestureType.CONTINUOUS),
    SCROLL_VERTICAL(GestureType.CONTINUOUS);

    private GestureType type;

    Gesture(GestureType gestureType) {
        this.type = gestureType;
    }

    public final boolean isAssignableTo(GestureAction gestureAction) {
        return gestureAction == GestureAction.NONE || gestureAction.type() == this.type;
    }
}
