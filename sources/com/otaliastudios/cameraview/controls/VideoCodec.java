package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum VideoCodec implements Control {
    DEVICE_DEFAULT(0),
    H_263(1),
    H_264(2);

    private int value;
    static final VideoCodec DEFAULT = DEVICE_DEFAULT;

    VideoCodec(int i) {
        this.value = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    public static VideoCodec fromValue(int i) {
        for (VideoCodec videoCodec : values()) {
            if (videoCodec.value() == i) {
                return videoCodec;
            }
        }
        return DEFAULT;
    }
}
