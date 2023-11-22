package com.otaliastudios.cameraview.picture;

import android.hardware.Camera;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.engine.Camera1Engine;
import com.otaliastudios.cameraview.internal.utils.ExifHelper;
import com.otaliastudios.cameraview.picture.PictureRecorder;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* loaded from: classes8.dex */
public class Full1PictureRecorder extends FullPictureRecorder {
    private final Camera lookAheadTest;
    private final Camera1Engine scheduleImpl;
    public static final byte[] PlaceComponentResult = {111, 16, 84, -34, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 231;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r6 = r6 * 3
            int r6 = r6 + 13
            int r8 = r8 * 12
            int r8 = r8 + 4
            byte[] r0 = com.otaliastudios.cameraview.picture.Full1PictureRecorder.PlaceComponentResult
            byte[] r1 = new byte[r6]
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
            int r3 = r3 + 1
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r0[r8]
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
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.picture.Full1PictureRecorder.a(short, short, short, java.lang.Object[]):void");
    }

    public Full1PictureRecorder(PictureResult.Stub stub, Camera1Engine camera1Engine, Camera camera) {
        super(stub, camera1Engine);
        this.scheduleImpl = camera1Engine;
        this.lookAheadTest = camera;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0);
        camera.setParameters(parameters);
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public final void PlaceComponentResult() {
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "take() called.");
        this.lookAheadTest.setPreviewCallbackWithBuffer(null);
        this.lookAheadTest.takePicture(new Camera.ShutterCallback() { // from class: com.otaliastudios.cameraview.picture.Full1PictureRecorder.1
            @Override // android.hardware.Camera.ShutterCallback
            public void onShutter() {
                FullPictureRecorder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "take(): got onShutter callback.");
                PictureRecorder.PictureResultListener pictureResultListener = Full1PictureRecorder.this.getAuthRequestContext;
                if (pictureResultListener != null) {
                    pictureResultListener.PlaceComponentResult(true);
                }
            }
        }, null, null, new Camera.PictureCallback() { // from class: com.otaliastudios.cameraview.picture.Full1PictureRecorder.2
            public static final byte[] PlaceComponentResult = {Ascii.ESC, 47, Ascii.SUB, Ascii.GS, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
            public static final int MyBillsEntityDataFactory = 108;

            /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private static void a(short r7, int r8, byte r9, java.lang.Object[] r10) {
                /*
                    byte[] r0 = com.otaliastudios.cameraview.picture.Full1PictureRecorder.AnonymousClass2.PlaceComponentResult
                    int r7 = r7 + 4
                    int r8 = r8 * 7
                    int r8 = r8 + 99
                    int r9 = r9 * 3
                    int r9 = r9 + 13
                    byte[] r1 = new byte[r9]
                    r2 = 0
                    if (r0 != 0) goto L17
                    r3 = r1
                    r5 = 0
                    r1 = r0
                    r0 = r10
                    r10 = r9
                    goto L31
                L17:
                    r3 = 0
                L18:
                    byte r4 = (byte) r8
                    int r5 = r3 + 1
                    r1[r3] = r4
                    if (r5 != r9) goto L27
                    java.lang.String r7 = new java.lang.String
                    r7.<init>(r1, r2)
                    r10[r2] = r7
                    return
                L27:
                    int r7 = r7 + 1
                    r3 = r0[r7]
                    r6 = r10
                    r10 = r9
                    r9 = r3
                    r3 = r1
                    r1 = r0
                    r0 = r6
                L31:
                    int r9 = -r9
                    int r8 = r8 + r9
                    int r8 = r8 + 2
                    r9 = r10
                    r10 = r0
                    r0 = r1
                    r1 = r3
                    r3 = r5
                    goto L18
                */
                throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.picture.Full1PictureRecorder.AnonymousClass2.a(short, int, byte, java.lang.Object[]):void");
            }

            @Override // android.hardware.Camera.PictureCallback
            public void onPictureTaken(byte[] bArr, Camera camera) {
                int i;
                FullPictureRecorder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "take(): got picture callback.");
                try {
                    i = ExifHelper.getAuthRequestContext(new ExifInterface(new ByteArrayInputStream(bArr)).getAuthRequestContext("Orientation"));
                } catch (IOException unused) {
                    i = 0;
                }
                Full1PictureRecorder.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory = bArr;
                Full1PictureRecorder.this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
                CameraLogger cameraLogger = FullPictureRecorder.MyBillsEntityDataFactory;
                Object[] objArr = new Object[2];
                objArr[0] = "take(): starting preview again. ";
                try {
                    byte b = PlaceComponentResult[16];
                    byte b2 = (byte) (-PlaceComponentResult[15]);
                    Object[] objArr2 = new Object[1];
                    a(b, b2, b2, objArr2);
                    Class<?> cls = Class.forName((String) objArr2[0]);
                    byte b3 = PlaceComponentResult[15];
                    byte b4 = (byte) (b3 + 1);
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    objArr[1] = cls.getMethod((String) objArr3[0], null).invoke(null, null);
                    cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, objArr);
                    camera.setPreviewCallbackWithBuffer(Full1PictureRecorder.this.scheduleImpl);
                    camera.startPreview();
                    Full1PictureRecorder.this.MyBillsEntityDataFactory();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        });
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "take() returned.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public final void MyBillsEntityDataFactory() {
        CameraLogger cameraLogger = MyBillsEntityDataFactory;
        Object[] objArr = new Object[2];
        objArr[0] = "dispatching result. Thread:";
        try {
            byte b = PlaceComponentResult[15];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b3 = (byte) (PlaceComponentResult[15] - 1);
            byte b4 = b3;
            Object[] objArr3 = new Object[1];
            a(b3, b4, b4, objArr3);
            objArr[1] = cls.getMethod((String) objArr3[0], null).invoke(null, null);
            cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(1, objArr);
            super.MyBillsEntityDataFactory();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }
}
