package com.alibaba.griver.beehive.lottie.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes6.dex */
public class TouchDetector {
    private static final int MAX_CLICK_DISTANCE = 2;
    private static final int MAX_CLICK_DURATION = 200;
    private Callback callback;
    private long clickStartTime;
    private int lastX;
    private int lastY;
    private Runnable longPressCallback;
    private float pressDownX;
    private float pressDownY;
    private boolean stayedWithinClickDistance;
    private Handler uiHandler = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public interface Callback {
        void onClick(View view, MotionEvent motionEvent);

        void onLongClick(View view, MotionEvent motionEvent);
    }

    public TouchDetector(Callback callback) {
        this.callback = callback;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        if (r2 != 3) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(final android.view.View r11, final android.view.MotionEvent r12) {
        /*
            r10 = this;
            float r0 = r12.getRawX()
            int r0 = (int) r0
            float r1 = r12.getRawY()
            int r1 = (int) r1
            int r2 = r12.getAction()
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 1
            if (r2 == 0) goto L63
            if (r2 == r3) goto L47
            r0 = 2
            if (r2 == r0) goto L1d
            r0 = 3
            if (r2 == r0) goto L47
            goto L8f
        L1d:
            boolean r0 = r10.stayedWithinClickDistance
            if (r0 == 0) goto L3f
            android.content.Context r5 = r11.getContext()
            float r6 = r10.pressDownX
            float r7 = r10.pressDownY
            float r8 = r12.getX()
            float r9 = r12.getY()
            r4 = r10
            float r11 = r4.distance(r5, r6, r7, r8, r9)
            r12 = 1073741824(0x40000000, float:2.0)
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 <= 0) goto L3f
            r11 = 0
            r10.stayedWithinClickDistance = r11
        L3f:
            boolean r11 = r10.stayedWithinClickDistance
            if (r11 != 0) goto L8f
            r10.cancelLongClick()
            goto L8f
        L47:
            r10.cancelLongClick()
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r10.clickStartTime
            long r0 = r0 - r4
            r4 = 200(0xc8, double:9.9E-322)
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 >= 0) goto L8f
            boolean r0 = r10.stayedWithinClickDistance
            if (r0 == 0) goto L8f
            if (r2 != r3) goto L8f
            com.alibaba.griver.beehive.lottie.util.TouchDetector$Callback r0 = r10.callback
            r0.onClick(r11, r12)
            goto L8f
        L63:
            float r2 = r12.getX()
            r10.pressDownX = r2
            float r2 = r12.getY()
            r10.pressDownY = r2
            long r4 = java.lang.System.currentTimeMillis()
            r10.clickStartTime = r4
            r10.stayedWithinClickDistance = r3
            r10.lastX = r0
            r10.lastY = r1
            java.lang.Runnable r0 = r10.longPressCallback
            if (r0 != 0) goto L86
            com.alibaba.griver.beehive.lottie.util.TouchDetector$1 r0 = new com.alibaba.griver.beehive.lottie.util.TouchDetector$1
            r0.<init>()
            r10.longPressCallback = r0
        L86:
            android.os.Handler r11 = r10.uiHandler
            java.lang.Runnable r12 = r10.longPressCallback
            r0 = 300(0x12c, double:1.48E-321)
            r11.postDelayed(r12, r0)
        L8f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.util.TouchDetector.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void cancelLongClick() {
        Runnable runnable = this.longPressCallback;
        if (runnable != null) {
            this.uiHandler.removeCallbacks(runnable);
            this.longPressCallback = null;
        }
    }

    private float distance(Context context, float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return px2dip(context, (float) Math.sqrt((f5 * f5) + (f6 * f6)));
    }

    private int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
