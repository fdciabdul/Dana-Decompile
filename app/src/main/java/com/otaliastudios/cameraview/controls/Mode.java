package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum Mode implements Control {
    PICTURE(0),
    VIDEO(1);

    private int value;
    static final Mode DEFAULT = PICTURE;

    Mode(int i) {
        this.value = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    public static Mode fromValue(int i) {
        for (Mode mode : values()) {
            if (mode.value() == i) {
                return mode;
            }
        }
        return DEFAULT;
    }
}
