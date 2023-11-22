package com.otaliastudios.cameraview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Handler;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.engine.mappers.Camera1Mapper;
import com.otaliastudios.cameraview.internal.utils.WorkerHandler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes8.dex */
public class CameraUtils {
    private static final CameraLogger BuiltInFictitiousFunctionClassFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("CameraUtils");

    public static boolean MyBillsEntityDataFactory(Facing facing) {
        Camera1Mapper.PlaceComponentResult();
        int MyBillsEntityDataFactory = Camera1Mapper.MyBillsEntityDataFactory(facing);
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == MyBillsEntityDataFactory) {
                return true;
            }
        }
        return false;
    }

    public static File getAuthRequestContext(byte[] bArr, File file) {
        if (file.exists() && !file.delete()) {
            return null;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                return file;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: com.otaliastudios.cameraview.CameraUtils$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ byte[] BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ FileCallback KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Handler MyBillsEntityDataFactory;
        final /* synthetic */ File PlaceComponentResult;

        @Override // java.lang.Runnable
        public final void run() {
            final File authRequestContext = CameraUtils.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
            this.MyBillsEntityDataFactory.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraUtils.1.1
                @Override // java.lang.Runnable
                public void run() {
                    FileCallback fileCallback = AnonymousClass1.this.KClassImpl$Data$declaredNonStaticMembers$2;
                }
            });
        }
    }

    public static void getAuthRequestContext(byte[] bArr, BitmapFactory.Options options, int i, BitmapCallback bitmapCallback) {
        WorkerHandler.KClassImpl$Data$declaredNonStaticMembers$2(new Runnable(bArr, -1, -1, options, i, new Handler(), bitmapCallback) { // from class: com.otaliastudios.cameraview.CameraUtils.2
            final /* synthetic */ int BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ BitmapCallback MyBillsEntityDataFactory;
            final /* synthetic */ BitmapFactory.Options getAuthRequestContext;
            final /* synthetic */ Handler moveToNextValue;
            final /* synthetic */ byte[] scheduleImpl;
            final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2 = -1;
            final /* synthetic */ int PlaceComponentResult = -1;

            {
                this.getAuthRequestContext = options;
                this.BuiltInFictitiousFunctionClassFactory = i;
                this.moveToNextValue = r6;
                this.MyBillsEntityDataFactory = bitmapCallback;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final Bitmap PlaceComponentResult = CameraUtils.PlaceComponentResult(this.scheduleImpl, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
                this.moveToNextValue.post(new Runnable() { // from class: com.otaliastudios.cameraview.CameraUtils.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2.this.MyBillsEntityDataFactory.onBitmapReady(PlaceComponentResult);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00af A[Catch: OutOfMemoryError -> 0x00f3, TryCatch #7 {OutOfMemoryError -> 0x00f3, blocks: (B:44:0x009b, B:59:0x00cf, B:45:0x00a1, B:47:0x00af, B:54:0x00bf, B:50:0x00b7, B:52:0x00bb), top: B:76:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap PlaceComponentResult(byte[] r20, int r21, int r22, android.graphics.BitmapFactory.Options r23, int r24) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.CameraUtils.PlaceComponentResult(byte[], int, int, android.graphics.BitmapFactory$Options, int):android.graphics.Bitmap");
    }
}
