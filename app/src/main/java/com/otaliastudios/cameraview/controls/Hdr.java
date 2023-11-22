package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum Hdr implements Control {
    OFF(0),
    ON(1);

    private int value;
    static final Hdr DEFAULT = OFF;

    Hdr(int i) {
        this.value = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    public static Hdr fromValue(int i) {
        for (Hdr hdr : values()) {
            if (hdr.value() == i) {
                return hdr;
            }
        }
        return DEFAULT;
    }
}
