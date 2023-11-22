package com.otaliastudios.cameraview.internal.utils;

import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;

/* loaded from: classes8.dex */
public class ExifHelper {
    public static int getAuthRequestContext(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int MyBillsEntityDataFactory(int i) {
        int i2 = (i + AUScreenAdaptTool.WIDTH_BASE) % AUScreenAdaptTool.WIDTH_BASE;
        if (i2 != 0) {
            if (i2 != 90) {
                if (i2 != 180) {
                    if (i2 == 270) {
                        return 8;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid orientation: ");
                    sb.append(i);
                    throw new IllegalArgumentException(sb.toString());
                }
                return 3;
            }
            return 6;
        }
        return 1;
    }
}
