package com.alibaba.griver.image.capture.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import id.dana.cashier.view.InputCardNumberView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class VideoUtils {
    public static final int BITRATE_1080 = 2048000;
    public static final int BITRATE_320 = 819200;
    public static final int BITRATE_540 = 1126400;
    public static final int BITRATE_720 = 1433600;
    public static final int BITRATE_DEFAULT = 1126400;
    public static final int MIN_VIDEO_BITERATE = 102400;

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f6568a;

    public static Point getScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        return point;
    }

    public static boolean isActivityLandscape(Activity activity) {
        int requestedOrientation = activity.getRequestedOrientation();
        boolean z = requestedOrientation == 0 || requestedOrientation == 8 || requestedOrientation == 6 || requestedOrientation == 11;
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        return z || (rotation == 1 || rotation == 3);
    }

    public static boolean previewRunning(Camera camera) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 27) {
            return true;
        }
        try {
            z = ((Boolean) camera.getClass().getDeclaredMethod("previewEnabled", new Class[0]).invoke(camera, new Object[0])).booleanValue();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("previewEnabled exception:");
            sb.append(e.getMessage());
            RVLogger.e("VideoUtils", sb.toString(), e);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("previewRunning enable: ");
        sb2.append(z);
        RVLogger.d("VideoUtils", sb2.toString());
        return z;
    }

    public static Point findBestPreviewSizeValue(Camera.Parameters parameters, Point point) {
        String str;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str2 = "Parameters contained no preview size!";
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize == null) {
                throw new IllegalStateException("Parameters contained no preview size!");
            }
            return new Point(previewSize.width, previewSize.height);
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.alibaba.griver.image.capture.utils.VideoUtils.1
            @Override // java.util.Comparator
            public final int compare(Camera.Size size, Camera.Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Camera.Size size : arrayList) {
            sb.append(size.width);
            sb.append('x');
            sb.append(size.height);
            sb.append(InputCardNumberView.DIVIDER);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Supported preview sizes: ");
        sb2.append((Object) sb);
        RVLogger.d("VideoUtils", sb2.toString());
        double d = point.x;
        double d2 = point.y;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        if (!(d3 < 1.0d)) {
            d3 = 1.0d / d3;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("screen size:");
        sb3.append(point.x);
        sb3.append("x");
        sb3.append(point.y);
        RVLogger.d("VideoUtils", sb3.toString());
        Point point2 = null;
        double d4 = Double.POSITIVE_INFINITY;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            int i = size2.width;
            int i2 = size2.height;
            int i3 = i * i2;
            if (i3 < 153600 || i3 > 1536000) {
                str = str2;
                it.remove();
            } else {
                boolean z = i > i2;
                int i4 = z ? i2 : i;
                int i5 = z ? i : i2;
                if (i4 == point.x && i5 == point.y) {
                    Point point3 = new Point(i, i2);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Found preview size exactly matching screen size: ");
                    sb4.append(point3);
                    RVLogger.d("VideoUtils", sb4.toString());
                    return point3;
                }
                double d5 = i4;
                str = str2;
                double d6 = i5;
                Double.isNaN(d5);
                Double.isNaN(d6);
                double abs = Math.abs((d5 / d6) - d3);
                if (abs < d4) {
                    point2 = new Point(i, i2);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("new update bestSize: ");
                    sb5.append(point2);
                    sb5.append(" --- diff = ");
                    sb5.append(d4);
                    sb5.append(" --- newDiff= ");
                    sb5.append(abs);
                    RVLogger.d("VideoUtils", sb5.toString());
                    d4 = abs;
                }
            }
            str2 = str;
        }
        String str3 = str2;
        if (point2 == null) {
            Camera.Size previewSize2 = parameters.getPreviewSize();
            if (previewSize2 == null) {
                throw new IllegalStateException(str3);
            }
            Point point4 = new Point(previewSize2.width, previewSize2.height);
            StringBuilder sb6 = new StringBuilder();
            sb6.append("No suitable preview sizes, using default: ");
            sb6.append(point4);
            RVLogger.d("VideoUtils", sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("default previewSize: ");
            sb7.append(previewSize2.width);
            sb7.append(",");
            sb7.append(previewSize2.height);
            RVLogger.d("VideoUtils", sb7.toString());
            return point4;
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append("bestSize is not null: ");
        sb8.append(point2);
        RVLogger.d("VideoUtils", sb8.toString());
        return point2;
    }
}
