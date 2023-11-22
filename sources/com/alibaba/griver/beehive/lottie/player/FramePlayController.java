package com.alibaba.griver.beehive.lottie.player;

import android.animation.Animator;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* loaded from: classes6.dex */
public class FramePlayController implements Animator.AnimatorListener {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {11, Ascii.GS, 107, 8, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -4, 13, -35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int PlaceComponentResult = 5;
    private static final String TAG = "LottiePlayer:FramePlayController";
    private AbstractPlayCommand[] framePlayCommands;
    private FrameAnimationListener listener;
    private ICorePlayer lottiePlayer;
    private int currentCommandIndex = 0;
    private boolean stop = false;

    /* loaded from: classes6.dex */
    public interface FrameAnimationListener {
        void onAnimationFrameControlEnd();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 99
            byte[] r0 = com.alibaba.griver.beehive.lottie.player.FramePlayController.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 * 12
            int r8 = 28 - r8
            int r6 = r6 * 3
            int r6 = r6 + 13
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r4 = r7
            r3 = 0
            r7 = r6
            goto L2c
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r8 = r8 + 1
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.player.FramePlayController.a(byte, short, short, java.lang.Object[]):void");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public FramePlayController(AbstractPlayCommand[] abstractPlayCommandArr, ICorePlayer iCorePlayer) {
        this.lottiePlayer = iCorePlayer;
        iCorePlayer.addAnimatorListener(this);
        this.framePlayCommands = abstractPlayCommandArr;
        StringBuilder sb = new StringBuilder();
        sb.append("FramePlayController初始化完成");
        sb.append(this.lottiePlayer.getLottieSource());
        GriverLogger.d(TAG, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FramePlayCommand ->");
        sb2.append(Arrays.toString(this.framePlayCommands));
        GriverLogger.d(TAG, sb2.toString());
    }

    public void play() {
        StringBuilder sb = new StringBuilder();
        sb.append("play.");
        sb.append(this.lottiePlayer.getLottieSource());
        GriverLogger.d(TAG, sb.toString());
        this.lottiePlayer.setRepeatCount(0);
        if (this.currentCommandIndex >= this.framePlayCommands.length) {
            stop();
        }
        AbstractPlayCommand abstractPlayCommand = this.framePlayCommands[this.currentCommandIndex];
        this.stop = false;
        abstractPlayCommand.play();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("play...");
        sb2.append(this.lottiePlayer.getLottieSource());
        GriverLogger.d(TAG, sb2.toString());
    }

    public void stop() {
        if (this.stop) {
            return;
        }
        this.stop = true;
        int i = 0;
        this.currentCommandIndex = 0;
        AbstractPlayCommand[] abstractPlayCommandArr = this.framePlayCommands;
        if (abstractPlayCommandArr == null || abstractPlayCommandArr.length <= 0) {
            return;
        }
        while (true) {
            AbstractPlayCommand[] abstractPlayCommandArr2 = this.framePlayCommands;
            if (i >= abstractPlayCommandArr2.length) {
                return;
            }
            abstractPlayCommandArr2[i].reset();
            i++;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationEnd stop=");
        sb.append(this.stop);
        sb.append(",commandIndex=");
        sb.append(this.currentCommandIndex);
        sb.append(",");
        sb.append(this.lottiePlayer.getLottieSource());
        GriverLogger.d(TAG, sb.toString());
        AbstractPlayCommand[] abstractPlayCommandArr = this.framePlayCommands;
        if (abstractPlayCommandArr == null || this.stop) {
            return;
        }
        if (abstractPlayCommandArr[this.currentCommandIndex].continueToRePlay()) {
            this.framePlayCommands[this.currentCommandIndex].repeatPlay();
            return;
        }
        int i = this.currentCommandIndex + 1;
        this.currentCommandIndex = i;
        if (!this.stop) {
            AbstractPlayCommand[] abstractPlayCommandArr2 = this.framePlayCommands;
            if (i < abstractPlayCommandArr2.length) {
                abstractPlayCommandArr2[i].play();
                return;
            }
        }
        stop();
        FrameAnimationListener frameAnimationListener = this.listener;
        if (frameAnimationListener != null) {
            frameAnimationListener.onAnimationFrameControlEnd();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAnimationCancel.");
        sb.append("detach");
        sb.append(",");
        sb.append(this.lottiePlayer.getLottieSource());
        GriverLogger.d(TAG, sb.toString());
        try {
            boolean z = true;
            Object[] objArr = new Object[1];
            a(BuiltInFictitiousFunctionClassFactory[15], BuiltInFictitiousFunctionClassFactory[8], BuiltInFictitiousFunctionClassFactory[21], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = BuiltInFictitiousFunctionClassFactory[21];
            Object[] objArr2 = new Object[1];
            a(b, b, (byte) (-BuiltInFictitiousFunctionClassFactory[6]), objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                Object[] objArr3 = new Object[1];
                a(BuiltInFictitiousFunctionClassFactory[15], BuiltInFictitiousFunctionClassFactory[8], BuiltInFictitiousFunctionClassFactory[21], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a(BuiltInFictitiousFunctionClassFactory[21], BuiltInFictitiousFunctionClassFactory[9], BuiltInFictitiousFunctionClassFactory[15], objArr4);
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null);
                if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
                    return;
                }
                int length = stackTraceElementArr.length;
                int i = 4;
                if (length > 25) {
                    length = 25;
                }
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTraceElementArr[i];
                    if ("onDetachedFromWindow".equals(stackTraceElement.getMethodName())) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onAnimationCancel.");
                        sb2.append(stackTraceElement.getMethodName());
                        GriverLogger.d(TAG, sb2.toString());
                        break;
                    }
                    i++;
                }
                if (z) {
                    return;
                }
                stop();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    public void setListener(FrameAnimationListener frameAnimationListener) {
        this.listener = frameAnimationListener;
    }
}
