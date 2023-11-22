package com.otaliastudios.cameraview.controls;

/* loaded from: classes2.dex */
public enum Preview implements Control {
    SURFACE(0),
    TEXTURE(1),
    GL_SURFACE(2);

    private int value;
    static final Preview DEFAULT = GL_SURFACE;

    Preview(int i) {
        this.value = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    public static Preview fromValue(int i) {
        for (Preview preview : values()) {
            if (preview.value() == i) {
                return preview;
            }
        }
        return DEFAULT;
    }
}
