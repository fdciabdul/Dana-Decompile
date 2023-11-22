package com.otaliastudios.cameraview.preview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraLogger;

/* loaded from: classes2.dex */
public abstract class CameraPreview<T extends View, Output> {
    CropCallback BuiltInFictitiousFunctionClassFactory;
    int MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    boolean PlaceComponentResult;
    int getAuthRequestContext;
    public int getErrorConfigVersion;
    public T lookAheadTest;
    SurfaceCallback moveToNextValue;
    public int scheduleImpl;
    public static final byte[] GetContactSyncConfig = {110, -41, 63, 58, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda1 = 150;
    protected static final CameraLogger KClassImpl$Data$declaredNonStaticMembers$2 = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("CameraPreview");

    /* loaded from: classes8.dex */
    protected interface CropCallback {
    }

    /* loaded from: classes8.dex */
    public interface SurfaceCallback {
        void N();

        void S();

        void X();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.otaliastudios.cameraview.preview.CameraPreview.GetContactSyncConfig
            int r8 = r8 * 3
            int r8 = 16 - r8
            int r7 = r7 * 7
            int r7 = 106 - r7
            int r6 = r6 * 12
            int r6 = 15 - r6
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1b:
            r3 = 0
        L1c:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.preview.CameraPreview.a(int, short, int, java.lang.Object[]):void");
    }

    public abstract Class<Output> KClassImpl$Data$declaredNonStaticMembers$2();

    abstract View MyBillsEntityDataFactory();

    public void NetworkUserEntityData$$ExternalSyntheticLambda0() {
    }

    protected abstract T PlaceComponentResult(Context context, ViewGroup viewGroup);

    protected void PlaceComponentResult(CropCallback cropCallback) {
    }

    public abstract Output getAuthRequestContext();

    public void lookAheadTest() {
    }

    public boolean scheduleImpl() {
        return false;
    }

    public CameraPreview(Context context, ViewGroup viewGroup) {
        this.lookAheadTest = PlaceComponentResult(context, viewGroup);
    }

    public final void getAuthRequestContext(SurfaceCallback surfaceCallback) {
        SurfaceCallback surfaceCallback2;
        SurfaceCallback surfaceCallback3;
        if (PlaceComponentResult() && (surfaceCallback3 = this.moveToNextValue) != null) {
            surfaceCallback3.X();
        }
        this.moveToNextValue = surfaceCallback;
        if (!PlaceComponentResult() || (surfaceCallback2 = this.moveToNextValue) == null) {
            return;
        }
        surfaceCallback2.S();
    }

    public final void PlaceComponentResult(int i, int i2) {
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "setStreamSize:", "desiredW=", Integer.valueOf(i), "desiredH=", Integer.valueOf(i2));
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.getAuthRequestContext = i2;
        if (i <= 0 || i2 <= 0) {
            return;
        }
        PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
    }

    public final boolean PlaceComponentResult() {
        return this.getErrorConfigVersion > 0 && this.scheduleImpl > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void BuiltInFictitiousFunctionClassFactory(int i, int i2) {
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnSurfaceAvailable:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        this.getErrorConfigVersion = i;
        this.scheduleImpl = i2;
        if (i > 0 && i2 > 0) {
            PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
        }
        SurfaceCallback surfaceCallback = this.moveToNextValue;
        if (surfaceCallback != null) {
            surfaceCallback.S();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(int i, int i2) {
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(1, "dispatchOnSurfaceSizeChanged:", "w=", Integer.valueOf(i), "h=", Integer.valueOf(i2));
        if (i == this.getErrorConfigVersion && i2 == this.scheduleImpl) {
            return;
        }
        this.getErrorConfigVersion = i;
        this.scheduleImpl = i2;
        if (i > 0 && i2 > 0) {
            PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory);
        }
        SurfaceCallback surfaceCallback = this.moveToNextValue;
        if (surfaceCallback != null) {
            surfaceCallback.N();
        }
    }

    public void moveToNextValue() {
        try {
            byte b = (byte) (GetContactSyncConfig[15] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = GetContactSyncConfig[15];
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != Looper.getMainLooper().getThread()) {
                Handler handler = new Handler(Looper.getMainLooper());
                final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                handler.post(new Runnable() { // from class: com.otaliastudios.cameraview.preview.CameraPreview.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View MyBillsEntityDataFactory = CameraPreview.this.MyBillsEntityDataFactory();
                        ViewParent parent = MyBillsEntityDataFactory.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(MyBillsEntityDataFactory);
                        }
                        taskCompletionSource.setResult(null);
                    }
                });
                try {
                    Tasks.await(taskCompletionSource.getTask());
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            View MyBillsEntityDataFactory = MyBillsEntityDataFactory();
            ViewParent parent = MyBillsEntityDataFactory.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(MyBillsEntityDataFactory);
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult;
    }

    public void MyBillsEntityDataFactory(int i) {
        this.MyBillsEntityDataFactory = i;
    }
}
