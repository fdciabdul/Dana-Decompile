package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public class MotionTiming {
    private long delay;
    private long duration;
    private TimeInterpolator interpolator;
    private int repeatCount;
    private int repeatMode;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {104, -68, 0, 44, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int BuiltInFictitiousFunctionClassFactory = 141;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r9 = r9 * 15
            int r9 = r9 + 4
            int r8 = r8 + 105
            byte[] r0 = com.google.android.material.animation.MotionTiming.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r4 = r0[r9]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L36:
            int r9 = -r9
            int r10 = r10 + 1
            int r7 = r7 + r9
            int r7 = r7 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.animation.MotionTiming.a(short, byte, short, java.lang.Object[]):void");
    }

    public MotionTiming(long j, long j2) {
        this.interpolator = null;
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = j;
        this.duration = j2;
    }

    public MotionTiming(long j, long j2, TimeInterpolator timeInterpolator) {
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = j;
        this.duration = j2;
        this.interpolator = timeInterpolator;
    }

    public void apply(Animator animator) {
        animator.setStartDelay(getDelay());
        animator.setDuration(getDuration());
        animator.setInterpolator(getInterpolator());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(getRepeatCount());
            valueAnimator.setRepeatMode(getRepeatMode());
        }
    }

    public long getDelay() {
        return this.delay;
    }

    public long getDuration() {
        return this.duration;
    }

    public TimeInterpolator getInterpolator() {
        TimeInterpolator timeInterpolator = this.interpolator;
        return timeInterpolator == null ? AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR : timeInterpolator;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MotionTiming createFromAnimator(ValueAnimator valueAnimator) {
        MotionTiming motionTiming = new MotionTiming(valueAnimator.getStartDelay(), valueAnimator.getDuration(), getInterpolatorCompat(valueAnimator));
        motionTiming.repeatCount = valueAnimator.getRepeatCount();
        motionTiming.repeatMode = valueAnimator.getRepeatMode();
        return motionTiming;
    }

    private static TimeInterpolator getInterpolatorCompat(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        }
        return interpolator instanceof DecelerateInterpolator ? AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR : interpolator;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MotionTiming) {
            MotionTiming motionTiming = (MotionTiming) obj;
            if (getDelay() == motionTiming.getDelay() && getDuration() == motionTiming.getDuration() && getRepeatCount() == motionTiming.getRepeatCount() && getRepeatMode() == motionTiming.getRepeatMode()) {
                return getInterpolator().getClass().equals(motionTiming.getInterpolator().getClass());
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int delay = (int) (getDelay() ^ (getDelay() >>> 32));
        int duration = (int) (getDuration() ^ (getDuration() >>> 32));
        return (((((((delay * 31) + duration) * 31) + getInterpolator().getClass().hashCode()) * 31) + getRepeatCount()) * 31) + getRepeatMode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        sb.append(getClass().getName());
        sb.append('{');
        try {
            Object[] objArr = {this};
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[2];
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[2];
            byte b4 = b3;
            Object[] objArr3 = new Object[1];
            a(b3, b4, b4, objArr3);
            sb.append(Integer.toHexString(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue()));
            sb.append(" delay: ");
            sb.append(getDelay());
            sb.append(" duration: ");
            sb.append(getDuration());
            sb.append(" interpolator: ");
            sb.append(getInterpolator().getClass());
            sb.append(" repeatCount: ");
            sb.append(getRepeatCount());
            sb.append(" repeatMode: ");
            sb.append(getRepeatMode());
            sb.append("}\n");
            return sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
