package com.otaliastudios.cameraview.engine;

import android.content.Context;
import android.graphics.PointF;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Ascii;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.offset.Angles;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.engine.orchestrator.CameraStateOrchestrator;
import com.otaliastudios.cameraview.frame.Frame;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.internal.utils.WorkerHandler;
import com.otaliastudios.cameraview.metering.MeteringRegions;
import com.otaliastudios.cameraview.overlay.Overlay;
import com.otaliastudios.cameraview.picture.PictureRecorder;
import com.otaliastudios.cameraview.preview.CameraPreview;
import com.otaliastudios.cameraview.size.Size;
import com.otaliastudios.cameraview.size.SizeSelector;
import com.otaliastudios.cameraview.video.VideoRecorder;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class CameraEngine implements CameraPreview.SurfaceCallback, PictureRecorder.PictureResultListener, VideoRecorder.VideoResultListener {
    private WorkerHandler KClassImpl$Data$declaredNonStaticMembers$2;
    final Callback VerifyPinStateManager$executeRiskChallenge$2$2;
    public static final byte[] getOnBoardingScenario = {104, -1, -63, 36, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int D = 174;
    protected static final CameraLogger A = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("CameraEngine");
    public final CameraStateOrchestrator getValueOfTouchPositionAbsolute = new CameraStateOrchestrator(new CameraOrchestrator.Callback() { // from class: com.otaliastudios.cameraview.engine.CameraEngine.1
        {
            CameraEngine.this = this;
        }

        @Override // com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Callback
        public final WorkerHandler BuiltInFictitiousFunctionClassFactory() {
            return CameraEngine.this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // com.otaliastudios.cameraview.engine.orchestrator.CameraOrchestrator.Callback
        public final void PlaceComponentResult(Exception exc) {
            CameraEngine.MyBillsEntityDataFactory(CameraEngine.this, exc, false);
        }
    });
    Handler E = new Handler(Looper.getMainLooper());

    /* loaded from: classes2.dex */
    public interface Callback {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(CameraException cameraException);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(VideoResult.Stub stub);

        void KClassImpl$Data$declaredNonStaticMembers$2(Gesture gesture, PointF pointF);

        void KClassImpl$Data$declaredNonStaticMembers$2(Gesture gesture, boolean z, PointF pointF);

        Context MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(float f, float[] fArr, PointF[] pointFArr);

        void MyBillsEntityDataFactory(CameraOptions cameraOptions);

        void PlaceComponentResult();

        void PlaceComponentResult(float f, PointF[] pointFArr);

        void PlaceComponentResult(Frame frame);

        void getAuthRequestContext(PictureResult.Stub stub);

        void getAuthRequestContext(boolean z);

        void lookAheadTest();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002c -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 7
            int r6 = r6 + 99
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r0 = com.otaliastudios.cameraview.engine.CameraEngine.getOnBoardingScenario
            int r7 = r7 * 12
            int r7 = 15 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L36
        L1a:
            r3 = 0
        L1b:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + 2
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.engine.CameraEngine.b(byte, byte, byte, java.lang.Object[]):void");
    }

    public abstract Location A();

    public abstract VideoCodec AppCompatEmojiTextHelper();

    public abstract Overlay B();

    public abstract Hdr BottomSheetCardBindingView$watcherCardNumberView$1();

    public abstract Size BuiltInFictitiousFunctionClassFactory(Reference reference);

    public abstract void BuiltInFictitiousFunctionClassFactory(VideoResult.Stub stub, File file);

    public abstract void BuiltInFictitiousFunctionClassFactory(Flash flash);

    public abstract void BuiltInFictitiousFunctionClassFactory(boolean z);

    public abstract int C();

    public abstract boolean D();

    public abstract PictureFormat E();

    public abstract float F();

    public abstract int FragmentBottomSheetPaymentSettingBinding();

    public abstract int G();

    public abstract int H();

    public abstract int I();

    public abstract int J();

    public abstract long K();

    public abstract Size KClassImpl$Data$declaredNonStaticMembers$2(Reference reference);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(PictureResult.Stub stub);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(Hdr hdr);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(PictureFormat pictureFormat);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(VideoCodec videoCodec);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(Gesture gesture, MeteringRegions meteringRegions, PointF pointF);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(SizeSelector sizeSelector);

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

    public abstract float L();

    public abstract WhiteBalance M();

    public abstract void MyBillsEntityDataFactory(int i);

    public abstract void MyBillsEntityDataFactory(Facing facing);

    public abstract void MyBillsEntityDataFactory(SizeSelector sizeSelector);

    public abstract void MyBillsEntityDataFactory(boolean z);

    protected abstract Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda0();

    public abstract void NetworkUserEntityData$$ExternalSyntheticLambda0(int i);

    protected abstract Task<Void> NetworkUserEntityData$$ExternalSyntheticLambda1();

    public abstract Audio NetworkUserEntityData$$ExternalSyntheticLambda3();

    public abstract CameraOptions NetworkUserEntityData$$ExternalSyntheticLambda4();

    public abstract long NetworkUserEntityData$$ExternalSyntheticLambda5();

    public abstract float NetworkUserEntityData$$ExternalSyntheticLambda6();

    public abstract boolean P();

    public abstract Size PlaceComponentResult(Reference reference);

    public abstract void PlaceComponentResult(float f);

    public abstract void PlaceComponentResult(float f, PointF[] pointFArr, boolean z);

    public abstract void PlaceComponentResult(int i);

    public abstract void PlaceComponentResult(long j);

    public abstract void PlaceComponentResult(PictureResult.Stub stub);

    public abstract void PlaceComponentResult(VideoResult.Stub stub, File file, FileDescriptor fileDescriptor);

    public abstract void PlaceComponentResult(Audio audio);

    public abstract void PlaceComponentResult(WhiteBalance whiteBalance);

    public abstract void PlaceComponentResult(SizeSelector sizeSelector);

    public abstract boolean PlaceComponentResult(Facing facing);

    public abstract Angles PrepareContext();

    public abstract int SubSequence();

    public abstract boolean SummaryVoucherView$$ExternalSyntheticLambda0();

    public abstract Mode VerifyPinStateManager$executeRiskChallenge$2$1();

    public abstract SizeSelector VerifyPinStateManager$executeRiskChallenge$2$2();

    public abstract Size getAuthRequestContext(Reference reference);

    public abstract void getAuthRequestContext(float f, float[] fArr, PointF[] pointFArr, boolean z);

    public abstract void getAuthRequestContext(int i);

    public abstract void getAuthRequestContext(long j);

    public abstract void getAuthRequestContext(Location location);

    public abstract void getAuthRequestContext(Mode mode);

    public abstract void getAuthRequestContext(Overlay overlay);

    public abstract void getAuthRequestContext(CameraPreview cameraPreview);

    public abstract void getAuthRequestContext(boolean z);

    public abstract int getCallingPid();

    protected abstract Task<Void> getErrorConfigVersion();

    public abstract void getErrorConfigVersion(int i);

    public abstract SizeSelector getNameOrBuilderList();

    public abstract CameraPreview getOnBoardingScenario();

    public abstract int getSupportButtonTintMode();

    public abstract boolean getValueOfTouchPositionAbsolute();

    public abstract void initRecordTimeStamp(int i);

    public abstract void isAuth();

    protected abstract Task<CameraOptions> lookAheadTest();

    public abstract void lookAheadTest(int i);

    protected abstract Task<Void> moveToNextValue();

    public abstract void moveToNextValue(int i);

    public abstract Facing readMicros();

    protected abstract Task<Void> scheduleImpl();

    public abstract void scheduleImpl(int i);

    public abstract Flash whenAvailable();

    public CameraEngine(Callback callback) {
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = callback;
        moveToNextValue(false);
    }

    /* loaded from: classes8.dex */
    public class CrashExceptionHandler implements Thread.UncaughtExceptionHandler {
        private CrashExceptionHandler() {
            CameraEngine.this = r1;
        }

        /* synthetic */ CrashExceptionHandler(CameraEngine cameraEngine, byte b) {
            this();
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            CameraEngine.MyBillsEntityDataFactory(CameraEngine.this, th, true);
        }
    }

    /* loaded from: classes8.dex */
    public static class NoOpExceptionHandler implements Thread.UncaughtExceptionHandler {
        private NoOpExceptionHandler() {
        }

        /* synthetic */ NoOpExceptionHandler(byte b) {
            this();
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(2, "EXCEPTION:", "In the NoOpExceptionHandler, probably while destroying.", "Thread:", thread, "Error:", th);
        }
    }

    private void moveToNextValue(boolean z) {
        WorkerHandler workerHandler = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (workerHandler != null) {
            workerHandler.MyBillsEntityDataFactory();
        }
        WorkerHandler BuiltInFictitiousFunctionClassFactory = WorkerHandler.BuiltInFictitiousFunctionClassFactory("CameraViewEngine");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setUncaughtExceptionHandler(new CrashExceptionHandler(this, (byte) 0));
        if (z) {
            this.getValueOfTouchPositionAbsolute.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public final boolean R() {
        return this.getValueOfTouchPositionAbsolute.getAuthRequestContext();
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0(boolean z) {
        BuiltInFictitiousFunctionClassFactory(z, 0);
    }

    private void BuiltInFictitiousFunctionClassFactory(boolean z, int i) {
        CameraLogger cameraLogger = A;
        Object[] objArr = new Object[9];
        byte b = 0;
        objArr[0] = "DESTROY:";
        objArr[1] = "state:";
        objArr[2] = this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory;
        objArr[3] = "thread:";
        try {
            byte b2 = (byte) (-getOnBoardingScenario[1]);
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            b(b2, b3, b3, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b4 = (byte) (getOnBoardingScenario[1] + 1);
            byte b5 = (byte) (-getOnBoardingScenario[1]);
            Object[] objArr3 = new Object[1];
            b(b4, b5, b5, objArr3);
            objArr[4] = cls.getMethod((String) objArr3[0], null).invoke(null, null);
            objArr[5] = "depth:";
            objArr[6] = Integer.valueOf(i);
            objArr[7] = "unrecoverably:";
            objArr[8] = Boolean.valueOf(z);
            cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, objArr);
            if (z) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.setUncaughtExceptionHandler(new NoOpExceptionHandler(b));
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            lookAheadTest(true).addOnCompleteListener(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, new OnCompleteListener<Void>() { // from class: com.otaliastudios.cameraview.engine.CameraEngine.3
                {
                    CameraEngine.this = this;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task<Void> task) {
                    countDownLatch.countDown();
                }
            });
            try {
                if (countDownLatch.await(6L, TimeUnit.SECONDS)) {
                    return;
                }
                Object[] objArr4 = new Object[5];
                objArr4[0] = "DESTROY: Could not destroy synchronously after 6 seconds.";
                objArr4[1] = "Current thread:";
                try {
                    byte b6 = (byte) (-getOnBoardingScenario[1]);
                    byte b7 = (byte) (b6 - 1);
                    Object[] objArr5 = new Object[1];
                    b(b6, b7, b7, objArr5);
                    Class<?> cls2 = Class.forName((String) objArr5[0]);
                    byte b8 = (byte) (getOnBoardingScenario[1] + 1);
                    byte b9 = (byte) (-getOnBoardingScenario[1]);
                    Object[] objArr6 = new Object[1];
                    b(b8, b9, b9, objArr6);
                    objArr4[2] = cls2.getMethod((String) objArr6[0], null).invoke(null, null);
                    objArr4[3] = "Handler thread:";
                    objArr4[4] = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
                    cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(3, objArr4);
                    int i2 = i + 1;
                    if (i2 < 2) {
                        moveToNextValue(true);
                        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(3, "DESTROY: Trying again on thread:", this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory);
                        BuiltInFictitiousFunctionClassFactory(z, i2);
                        return;
                    }
                    cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "DESTROY: Giving up because DESTROY_RETRIES was reached.");
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (InterruptedException unused) {
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 == null) {
                throw th2;
            }
            throw cause2;
        }
    }

    public final void V() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "RESTART:", "scheduled. State:", this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory);
        lookAheadTest(false);
        U();
    }

    public final Task<Void> U() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "START:", "scheduled. State:", this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory);
        Task<Void> authRequestContext = getAuthRequestContext();
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.ENGINE, CameraState.BIND, true, new AnonymousClass8());
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.BIND, CameraState.PREVIEW, true, new AnonymousClass10());
        return authRequestContext;
    }

    public final Task<Void> lookAheadTest(boolean z) {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "STOP:", "scheduled. State:", this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory);
        boolean z2 = !z;
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.PREVIEW, CameraState.BIND, z2, new AnonymousClass11());
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.BIND, CameraState.ENGINE, z2, new AnonymousClass9());
        return getErrorConfigVersion(z);
    }

    public final Task<Void> W() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "RESTART BIND:", "scheduled. State:", this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory);
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.PREVIEW, CameraState.BIND, true, new AnonymousClass11());
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.BIND, CameraState.ENGINE, true, new AnonymousClass9());
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.ENGINE, CameraState.BIND, true, new AnonymousClass8());
        return this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.BIND, CameraState.PREVIEW, true, new AnonymousClass10());
    }

    public final Task<Void> T() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "RESTART PREVIEW:", "scheduled. State:", this.getValueOfTouchPositionAbsolute.MyBillsEntityDataFactory);
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.PREVIEW, CameraState.BIND, true, new AnonymousClass11());
        return this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.BIND, CameraState.PREVIEW, true, new AnonymousClass10());
    }

    private Task<Void> getAuthRequestContext() {
        return this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.OFF, CameraState.ENGINE, true, new Callable<Task<CameraOptions>>() { // from class: com.otaliastudios.cameraview.engine.CameraEngine.5
            {
                CameraEngine.this = this;
            }

            @Override // java.util.concurrent.Callable
            public /* synthetic */ Task<CameraOptions> call() throws Exception {
                CameraEngine cameraEngine = CameraEngine.this;
                if (cameraEngine.PlaceComponentResult(cameraEngine.readMicros())) {
                    return CameraEngine.this.lookAheadTest();
                }
                CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(3, "onStartEngine:", "No camera available for facing", CameraEngine.this.readMicros());
                throw new CameraException(6);
            }
        }).onSuccessTask(new SuccessContinuation<CameraOptions, Void>() { // from class: com.otaliastudios.cameraview.engine.CameraEngine.4
            {
                CameraEngine.this = this;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public /* synthetic */ Task<Void> then(CameraOptions cameraOptions) throws Exception {
                CameraOptions cameraOptions2 = cameraOptions;
                if (cameraOptions2 != null) {
                    CameraEngine.this.VerifyPinStateManager$executeRiskChallenge$2$2.MyBillsEntityDataFactory(cameraOptions2);
                    return Tasks.forResult(null);
                }
                throw new RuntimeException("Null options!");
            }
        });
    }

    private Task<Void> getErrorConfigVersion(boolean z) {
        return this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.ENGINE, CameraState.OFF, !z, new Callable<Task<Void>>() { // from class: com.otaliastudios.cameraview.engine.CameraEngine.7
            {
                CameraEngine.this = this;
            }

            @Override // java.util.concurrent.Callable
            public /* synthetic */ Task<Void> call() throws Exception {
                return CameraEngine.this.moveToNextValue();
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.otaliastudios.cameraview.engine.CameraEngine.6
            {
                CameraEngine.this = this;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public /* synthetic */ void onSuccess(Void r1) {
                CameraEngine.this.VerifyPinStateManager$executeRiskChallenge$2$2.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$8 */
    /* loaded from: classes2.dex */
    public class AnonymousClass8 implements Callable<Task<Void>> {
        AnonymousClass8() {
            CameraEngine.this = r1;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ Task<Void> call() throws Exception {
            if (CameraEngine.this.getOnBoardingScenario() != null && CameraEngine.this.getOnBoardingScenario().PlaceComponentResult()) {
                return CameraEngine.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
            return Tasks.forCanceled();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$9 */
    /* loaded from: classes2.dex */
    public class AnonymousClass9 implements Callable<Task<Void>> {
        AnonymousClass9() {
            CameraEngine.this = r1;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ Task<Void> call() throws Exception {
            return CameraEngine.this.scheduleImpl();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$10 */
    /* loaded from: classes2.dex */
    public class AnonymousClass10 implements Callable<Task<Void>> {
        AnonymousClass10() {
            CameraEngine.this = r1;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ Task<Void> call() throws Exception {
            return CameraEngine.this.getErrorConfigVersion();
        }
    }

    /* renamed from: com.otaliastudios.cameraview.engine.CameraEngine$11 */
    /* loaded from: classes2.dex */
    public class AnonymousClass11 implements Callable<Task<Void>> {
        AnonymousClass11() {
            CameraEngine.this = r1;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ Task<Void> call() throws Exception {
            return CameraEngine.this.NetworkUserEntityData$$ExternalSyntheticLambda1();
        }
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback
    public final void S() {
        CameraLogger cameraLogger = A;
        CameraPreview onBoardingScenario = getOnBoardingScenario();
        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, "onSurfaceAvailable:", "Size is", new Size(onBoardingScenario.getErrorConfigVersion, onBoardingScenario.scheduleImpl));
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.ENGINE, CameraState.BIND, true, new AnonymousClass8());
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.BIND, CameraState.PREVIEW, true, new AnonymousClass10());
    }

    @Override // com.otaliastudios.cameraview.preview.CameraPreview.SurfaceCallback
    public final void X() {
        A.KClassImpl$Data$declaredNonStaticMembers$2(1, "onSurfaceDestroyed");
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.PREVIEW, CameraState.BIND, true, new AnonymousClass11());
        this.getValueOfTouchPositionAbsolute.PlaceComponentResult(CameraState.BIND, CameraState.ENGINE, true, new AnonymousClass9());
    }

    static /* synthetic */ void MyBillsEntityDataFactory(CameraEngine cameraEngine, final Throwable th, boolean z) {
        if (z) {
            A.KClassImpl$Data$declaredNonStaticMembers$2(3, "EXCEPTION:", "Handler thread is gone. Replacing.");
            cameraEngine.moveToNextValue(false);
        }
        A.KClassImpl$Data$declaredNonStaticMembers$2(3, "EXCEPTION:", "Scheduling on the crash handler...");
        cameraEngine.E.post(new Runnable() { // from class: com.otaliastudios.cameraview.engine.CameraEngine.2
            {
                CameraEngine.this = cameraEngine;
            }

            @Override // java.lang.Runnable
            public void run() {
                Throwable th2 = th;
                if (th2 instanceof CameraException) {
                    CameraException cameraException = (CameraException) th2;
                    if (cameraException.isUnrecoverable()) {
                        CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(3, "EXCEPTION:", "Got CameraException. Since it is unrecoverable, executing destroy(false).");
                        CameraEngine.this.NetworkUserEntityData$$ExternalSyntheticLambda0(false);
                    }
                    CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(3, "EXCEPTION:", "Got CameraException. Dispatching to callback.");
                    CameraEngine.this.VerifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory(cameraException);
                    return;
                }
                CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(3, "EXCEPTION:", "Unexpected error! Executing destroy(true).");
                CameraEngine.this.NetworkUserEntityData$$ExternalSyntheticLambda0(true);
                CameraEngine.A.KClassImpl$Data$declaredNonStaticMembers$2(3, "EXCEPTION:", "Unexpected error! Throwing.");
                Throwable th3 = th;
                if (th3 instanceof RuntimeException) {
                    throw ((RuntimeException) th3);
                }
                throw new RuntimeException(th);
            }
        });
    }
}
