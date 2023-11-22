package com.otaliastudios.cameraview.controls;

import android.content.Context;
import com.otaliastudios.cameraview.CameraUtils;

/* loaded from: classes2.dex */
public enum Facing implements Control {
    BACK(0),
    FRONT(1);

    private int value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Facing DEFAULT(Context context) {
        if (context == null) {
            return BACK;
        }
        Facing facing = BACK;
        if (CameraUtils.MyBillsEntityDataFactory(facing)) {
            return facing;
        }
        Facing facing2 = FRONT;
        return CameraUtils.MyBillsEntityDataFactory(facing2) ? facing2 : facing;
    }

    Facing(int i) {
        this.value = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int value() {
        return this.value;
    }

    public static Facing fromValue(int i) {
        for (Facing facing : values()) {
            if (facing.value() == i) {
                return facing;
            }
        }
        return null;
    }
}
