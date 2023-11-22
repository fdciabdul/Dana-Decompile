package com.alipay.zoloz.hardware.camera.widget.utils;

import android.graphics.Rect;
import android.hardware.Camera;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class FocusAreaUtils {
    public static List<Camera.Area> computeMeteringAreas(float f, float f2, int i, int i2, int i3) {
        double d = -i3;
        Double.isNaN(d);
        double d2 = (d * 3.141592653589793d) / 180.0d;
        double d3 = ((f / i) * 2000.0f) - 1000.0f;
        double cos = Math.cos(d2);
        double d4 = ((f2 / i2) * 2000.0f) - 1000.0f;
        double sin = Math.sin(d2);
        Double.isNaN(d3);
        Double.isNaN(d4);
        double d5 = (cos * d3) - (sin * d4);
        double sin2 = Math.sin(d2);
        double cos2 = Math.cos(d2);
        Double.isNaN(d3);
        Double.isNaN(d4);
        double d6 = (d4 * cos2) + (d3 * sin2);
        Rect computeMeteringArea = computeMeteringArea(d5, d6, 150.0d);
        Rect computeMeteringArea2 = computeMeteringArea(d5, d6, 300.0d);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new Camera.Area(computeMeteringArea, 1000));
        arrayList.add(new Camera.Area(computeMeteringArea2, 100));
        return arrayList;
    }

    private static Rect computeMeteringArea(double d, double d2, double d3) {
        double d4 = d3 / 2.0d;
        return new Rect((int) Math.max(d - d4, -1000.0d), (int) Math.max(d2 - d4, -1000.0d), (int) Math.min(d + d4, 1000.0d), (int) Math.min(d2 + d4, 1000.0d));
    }
}
