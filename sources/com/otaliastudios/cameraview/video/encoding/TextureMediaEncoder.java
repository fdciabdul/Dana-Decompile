package com.otaliastudios.cameraview.video.encoding;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.google.common.primitives.SignedBytes;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.internal.egl.EglCore;
import com.otaliastudios.cameraview.internal.egl.EglViewport;
import com.otaliastudios.cameraview.internal.egl.EglWindowSurface;
import com.otaliastudios.cameraview.internal.utils.Pool;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;

/* loaded from: classes8.dex */
public class TextureMediaEncoder extends VideoMediaEncoder<TextureConfig> {
    private EglViewport GetContactSyncConfig;
    public Pool<Frame> MyBillsEntityDataFactory;
    private long NetworkUserEntityData$$ExternalSyntheticLambda1;
    private int NetworkUserEntityData$$ExternalSyntheticLambda2;
    private EglWindowSurface PrepareContext;
    private EglCore initRecordTimeStamp;
    public static final byte[] lookAheadTest = {SignedBytes.MAX_POWER_OF_TWO, 19, 79, -17, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 246;
    private static final CameraLogger DatabaseTableConfigUtil = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("TextureMediaEncoder");

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 12
            int r7 = 15 - r7
            int r8 = r8 * 7
            int r8 = 106 - r8
            int r9 = r9 * 3
            int r9 = r9 + 13
            byte[] r0 = com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.lookAheadTest
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L37
        L1a:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r6
        L1e:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            int r8 = r8 + 1
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L37:
            int r7 = r7 + r9
            int r7 = r7 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.a(int, byte, byte, java.lang.Object[]):void");
    }

    /* loaded from: classes8.dex */
    public static class Frame {
        public float[] BuiltInFictitiousFunctionClassFactory;
        public long PlaceComponentResult;
        public long getAuthRequestContext;

        /* synthetic */ Frame(byte b) {
            this();
        }

        private Frame() {
            this.BuiltInFictitiousFunctionClassFactory = new float[16];
        }

        static /* synthetic */ long PlaceComponentResult(Frame frame) {
            return frame.getAuthRequestContext / 1000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.video.encoding.VideoMediaEncoder, com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public final void KClassImpl$Data$declaredNonStaticMembers$2(MediaEncoderEngine.Controller controller, long j) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = ((TextureConfig) this.scheduleImpl).DatabaseTableConfigUtil;
        ((TextureConfig) this.scheduleImpl).DatabaseTableConfigUtil = 0;
        super.KClassImpl$Data$declaredNonStaticMembers$2(controller, j);
        this.initRecordTimeStamp = new EglCore(((TextureConfig) this.scheduleImpl).BuiltInFictitiousFunctionClassFactory, 1);
        EglWindowSurface eglWindowSurface = new EglWindowSurface(this.initRecordTimeStamp, this.moveToNextValue);
        this.PrepareContext = eglWindowSurface;
        eglWindowSurface.getAuthRequestContext();
        this.GetContactSyncConfig = new EglViewport();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.video.encoding.VideoMediaEncoder
    public final boolean BuiltInFictitiousFunctionClassFactory(long j) {
        if (super.BuiltInFictitiousFunctionClassFactory(j)) {
            if (this.getErrorConfigVersion > 10 && MyBillsEntityDataFactory("frame") > 2) {
                DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1, "shouldRenderFrame - Dropping, we already have too many pending events:", Integer.valueOf(MyBillsEntityDataFactory("frame")));
                return false;
            }
            return true;
        }
        DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(1, "shouldRenderFrame - Dropping frame because of super()");
        return false;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    protected final void getAuthRequestContext(String str, Object obj) {
        str.hashCode();
        if (str.equals("filter")) {
            this.GetContactSyncConfig.getAuthRequestContext = (Filter) obj;
        } else if (str.equals("frame")) {
            Frame frame = (Frame) obj;
            if (!BuiltInFictitiousFunctionClassFactory(Frame.PlaceComponentResult(frame))) {
                this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(frame);
                return;
            }
            if (this.getErrorConfigVersion == 1) {
                this.BuiltInFictitiousFunctionClassFactory = frame.PlaceComponentResult;
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == Long.MIN_VALUE) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = Frame.PlaceComponentResult(frame);
            }
            if (!moveToNextValue()) {
                if (Frame.PlaceComponentResult(frame) - this.NetworkUserEntityData$$ExternalSyntheticLambda1 > this.getAuthRequestContext) {
                    DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(2, "onEvent -", "frameNumber:", Integer.valueOf(this.getErrorConfigVersion), "timestampUs:", Long.valueOf(Frame.PlaceComponentResult(frame)), "firstTimeUs:", Long.valueOf(this.NetworkUserEntityData$$ExternalSyntheticLambda1), "- reached max length! deltaUs:", Long.valueOf(Frame.PlaceComponentResult(frame) - this.NetworkUserEntityData$$ExternalSyntheticLambda1));
                    getErrorConfigVersion();
                }
            }
            CameraLogger cameraLogger = DatabaseTableConfigUtil;
            Object[] objArr = new Object[10];
            objArr[0] = "onEvent -";
            objArr[1] = "frameNumber:";
            objArr[2] = Integer.valueOf(this.getErrorConfigVersion);
            objArr[3] = "timestampUs:";
            objArr[4] = Long.valueOf(Frame.PlaceComponentResult(frame));
            objArr[5] = "hasReachedMaxLength:";
            objArr[6] = Boolean.valueOf(moveToNextValue());
            objArr[7] = "thread:";
            try {
                byte b = (byte) (lookAheadTest[15] - 1);
                Object[] objArr2 = new Object[1];
                a(b, b, lookAheadTest[15], objArr2);
                Class<?> cls = Class.forName((String) objArr2[0]);
                byte b2 = lookAheadTest[15];
                byte b3 = b2;
                Object[] objArr3 = new Object[1];
                a(b2, b3, (byte) (b3 - 1), objArr3);
                objArr[8] = cls.getMethod((String) objArr3[0], null).invoke(null, null);
                objArr[9] = "- draining.";
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, objArr);
                KClassImpl$Data$declaredNonStaticMembers$2(false);
                Object[] objArr4 = new Object[10];
                objArr4[0] = "onEvent -";
                objArr4[1] = "frameNumber:";
                objArr4[2] = Integer.valueOf(this.getErrorConfigVersion);
                objArr4[3] = "timestampUs:";
                objArr4[4] = Long.valueOf(Frame.PlaceComponentResult(frame));
                objArr4[5] = "hasReachedMaxLength:";
                objArr4[6] = Boolean.valueOf(moveToNextValue());
                objArr4[7] = "thread:";
                try {
                    byte b4 = (byte) (lookAheadTest[15] - 1);
                    Object[] objArr5 = new Object[1];
                    a(b4, b4, lookAheadTest[15], objArr5);
                    Class<?> cls2 = Class.forName((String) objArr5[0]);
                    byte b5 = lookAheadTest[15];
                    byte b6 = b5;
                    Object[] objArr6 = new Object[1];
                    a(b5, b6, (byte) (b6 - 1), objArr6);
                    objArr4[8] = cls2.getMethod((String) objArr6[0], null).invoke(null, null);
                    objArr4[9] = "- drawing.";
                    cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, objArr4);
                    float[] fArr = frame.BuiltInFictitiousFunctionClassFactory;
                    float f = ((TextureConfig) this.scheduleImpl).MyBillsEntityDataFactory;
                    float f2 = ((TextureConfig) this.scheduleImpl).NetworkUserEntityData$$ExternalSyntheticLambda0;
                    Matrix.translateM(fArr, 0, (1.0f - f) / 2.0f, (1.0f - f2) / 2.0f, 0.0f);
                    Matrix.scaleM(fArr, 0, f, f2, 1.0f);
                    Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
                    Matrix.rotateM(fArr, 0, this.NetworkUserEntityData$$ExternalSyntheticLambda2, 0.0f, 0.0f, 1.0f);
                    Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
                    if (((TextureConfig) this.scheduleImpl).BuiltInFictitiousFunctionClassFactory()) {
                        ((TextureConfig) this.scheduleImpl).PlaceComponentResult.getAuthRequestContext(((TextureConfig) this.scheduleImpl).KClassImpl$Data$declaredNonStaticMembers$2);
                        Matrix.translateM(((TextureConfig) this.scheduleImpl).PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, 0, 0.5f, 0.5f, 0.0f);
                        Matrix.rotateM(((TextureConfig) this.scheduleImpl).PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, 0, ((TextureConfig) this.scheduleImpl).getAuthRequestContext, 0.0f, 0.0f, 1.0f);
                        Matrix.translateM(((TextureConfig) this.scheduleImpl).PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, 0, -0.5f, -0.5f, 0.0f);
                    }
                    Object[] objArr7 = new Object[10];
                    objArr7[0] = "onEvent -";
                    objArr7[1] = "frameNumber:";
                    objArr7[2] = Integer.valueOf(this.getErrorConfigVersion);
                    objArr7[3] = "timestampUs:";
                    objArr7[4] = Long.valueOf(Frame.PlaceComponentResult(frame));
                    objArr7[5] = "hasReachedMaxLength:";
                    objArr7[6] = Boolean.valueOf(moveToNextValue());
                    objArr7[7] = "thread:";
                    try {
                        byte b7 = (byte) (lookAheadTest[15] - 1);
                        Object[] objArr8 = new Object[1];
                        a(b7, b7, lookAheadTest[15], objArr8);
                        Class<?> cls3 = Class.forName((String) objArr8[0]);
                        byte b8 = lookAheadTest[15];
                        byte b9 = b8;
                        Object[] objArr9 = new Object[1];
                        a(b8, b9, (byte) (b9 - 1), objArr9);
                        objArr7[8] = cls3.getMethod((String) objArr9[0], null).invoke(null, null);
                        objArr7[9] = "- gl rendering.";
                        cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, objArr7);
                        this.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory(Frame.PlaceComponentResult(frame), ((TextureConfig) this.scheduleImpl).lookAheadTest, fArr);
                        if (((TextureConfig) this.scheduleImpl).BuiltInFictitiousFunctionClassFactory()) {
                            ((TextureConfig) this.scheduleImpl).PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(Frame.PlaceComponentResult(frame));
                        }
                        this.PrepareContext.MyBillsEntityDataFactory(frame.getAuthRequestContext);
                        this.PrepareContext.MyBillsEntityDataFactory();
                        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(frame);
                        Object[] objArr10 = new Object[10];
                        objArr10[0] = "onEvent -";
                        objArr10[1] = "frameNumber:";
                        objArr10[2] = Integer.valueOf(this.getErrorConfigVersion);
                        objArr10[3] = "timestampUs:";
                        objArr10[4] = Long.valueOf(Frame.PlaceComponentResult(frame));
                        objArr10[5] = "hasReachedMaxLength:";
                        objArr10[6] = Boolean.valueOf(moveToNextValue());
                        objArr10[7] = "thread:";
                        try {
                            byte b10 = (byte) (lookAheadTest[15] - 1);
                            Object[] objArr11 = new Object[1];
                            a(b10, b10, lookAheadTest[15], objArr11);
                            Class<?> cls4 = Class.forName((String) objArr11[0]);
                            byte b11 = lookAheadTest[15];
                            byte b12 = b11;
                            Object[] objArr12 = new Object[1];
                            a(b11, b12, (byte) (b12 - 1), objArr12);
                            objArr10[8] = cls4.getMethod((String) objArr12[0], null).invoke(null, null);
                            objArr10[9] = "- gl rendered.";
                            cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, objArr10);
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
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            } catch (Throwable th4) {
                Throwable cause4 = th4.getCause();
                if (cause4 == null) {
                    throw th4;
                }
                throw cause4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public final void PlaceComponentResult() {
        super.PlaceComponentResult();
        Pool<Frame> pool = this.MyBillsEntityDataFactory;
        synchronized (pool.MyBillsEntityDataFactory) {
            pool.getAuthRequestContext.clear();
        }
        EglWindowSurface eglWindowSurface = this.PrepareContext;
        if (eglWindowSurface != null) {
            eglWindowSurface.BuiltInFictitiousFunctionClassFactory();
            Surface surface = eglWindowSurface.MyBillsEntityDataFactory;
            if (surface != null) {
                if (eglWindowSurface.getAuthRequestContext) {
                    surface.release();
                }
                eglWindowSurface.MyBillsEntityDataFactory = null;
            }
            this.PrepareContext = null;
        }
        EglViewport eglViewport = this.GetContactSyncConfig;
        if (eglViewport != null) {
            if (eglViewport.PlaceComponentResult != -1) {
                eglViewport.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                GLES20.glDeleteProgram(eglViewport.PlaceComponentResult);
                eglViewport.PlaceComponentResult = -1;
            }
            this.GetContactSyncConfig = null;
        }
        EglCore eglCore = this.initRecordTimeStamp;
        if (eglCore != null) {
            eglCore.BuiltInFictitiousFunctionClassFactory();
            this.initRecordTimeStamp = null;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextureMediaEncoder(com.otaliastudios.cameraview.video.encoding.TextureConfig r3) {
        /*
            r2 = this;
            com.otaliastudios.cameraview.video.encoding.TextureConfig r0 = new com.otaliastudios.cameraview.video.encoding.TextureConfig
            r0.<init>()
            int r1 = r3.initRecordTimeStamp
            r0.initRecordTimeStamp = r1
            int r1 = r3.NetworkUserEntityData$$ExternalSyntheticLambda1
            r0.NetworkUserEntityData$$ExternalSyntheticLambda1 = r1
            int r1 = r3.getErrorConfigVersion
            r0.getErrorConfigVersion = r1
            int r1 = r3.moveToNextValue
            r0.moveToNextValue = r1
            int r1 = r3.DatabaseTableConfigUtil
            r0.DatabaseTableConfigUtil = r1
            java.lang.String r1 = r3.NetworkUserEntityData$$ExternalSyntheticLambda2
            r0.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            java.lang.String r1 = r3.scheduleImpl
            r0.scheduleImpl = r1
            int r1 = r3.lookAheadTest
            r0.lookAheadTest = r1
            com.otaliastudios.cameraview.overlay.OverlayDrawer r1 = r3.PlaceComponentResult
            r0.PlaceComponentResult = r1
            com.otaliastudios.cameraview.overlay.Overlay$Target r1 = r3.KClassImpl$Data$declaredNonStaticMembers$2
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r1 = r3.getAuthRequestContext
            r0.getAuthRequestContext = r1
            float r1 = r3.MyBillsEntityDataFactory
            r0.MyBillsEntityDataFactory = r1
            float r1 = r3.NetworkUserEntityData$$ExternalSyntheticLambda0
            r0.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            android.opengl.EGLContext r3 = r3.BuiltInFictitiousFunctionClassFactory
            r0.BuiltInFictitiousFunctionClassFactory = r3
            r2.<init>(r0)
            com.otaliastudios.cameraview.internal.utils.Pool r3 = new com.otaliastudios.cameraview.internal.utils.Pool
            com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder$1 r0 = new com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder$1
            r0.<init>()
            r1 = 2147483647(0x7fffffff, float:NaN)
            r3.<init>(r1, r0)
            r2.MyBillsEntityDataFactory = r3
            r0 = -9223372036854775808
            r2.NetworkUserEntityData$$ExternalSyntheticLambda1 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder.<init>(com.otaliastudios.cameraview.video.encoding.TextureConfig):void");
    }
}
