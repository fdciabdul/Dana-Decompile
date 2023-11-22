package com.otaliastudios.cameraview.picture;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.DngCreator;
import android.hardware.camera2.TotalCaptureResult;
import android.media.ImageReader;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.engine.Camera2Engine;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import com.otaliastudios.cameraview.internal.utils.ExifHelper;
import com.otaliastudios.cameraview.internal.utils.WorkerHandler;
import com.otaliastudios.cameraview.picture.PictureRecorder;

/* loaded from: classes8.dex */
public class Full2PictureRecorder extends FullPictureRecorder implements ImageReader.OnImageAvailableListener {
    private DngCreator KClassImpl$Data$declaredNonStaticMembers$2;
    private final ImageReader NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Action PlaceComponentResult;
    private final ActionHolder lookAheadTest;
    private final CaptureRequest.Builder scheduleImpl;

    public Full2PictureRecorder(PictureResult.Stub stub, Camera2Engine camera2Engine, CaptureRequest.Builder builder, ImageReader imageReader) {
        super(stub, camera2Engine);
        this.lookAheadTest = camera2Engine;
        this.scheduleImpl = builder;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = imageReader;
        imageReader.setOnImageAvailableListener(this, WorkerHandler.PlaceComponentResult().BuiltInFictitiousFunctionClassFactory);
        this.PlaceComponentResult = new BaseAction() { // from class: com.otaliastudios.cameraview.picture.Full2PictureRecorder.1
            @Override // com.otaliastudios.cameraview.engine.action.BaseAction
            public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
                super.MyBillsEntityDataFactory(actionHolder);
                Full2PictureRecorder.this.scheduleImpl.addTarget(Full2PictureRecorder.this.NetworkUserEntityData$$ExternalSyntheticLambda0.getSurface());
                if (Full2PictureRecorder.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 == PictureFormat.JPEG) {
                    Full2PictureRecorder.this.scheduleImpl.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(Full2PictureRecorder.this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0));
                }
                Full2PictureRecorder.this.scheduleImpl.setTag(2);
                try {
                    actionHolder.MyBillsEntityDataFactory(Full2PictureRecorder.this.scheduleImpl);
                } catch (CameraAccessException e) {
                    Full2PictureRecorder.this.moveToNextValue = null;
                    Full2PictureRecorder.this.BuiltInFictitiousFunctionClassFactory = e;
                    Full2PictureRecorder.this.MyBillsEntityDataFactory();
                    MyBillsEntityDataFactory(Integer.MAX_VALUE);
                }
            }

            @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
            public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest) {
                super.getAuthRequestContext(actionHolder, captureRequest);
                if (captureRequest.getTag() == 2) {
                    FullPictureRecorder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "onCaptureStarted:", "Dispatching picture shutter.");
                    PictureRecorder.PictureResultListener pictureResultListener = Full2PictureRecorder.this.getAuthRequestContext;
                    if (pictureResultListener != null) {
                        pictureResultListener.PlaceComponentResult(false);
                    }
                    MyBillsEntityDataFactory(Integer.MAX_VALUE);
                }
            }

            @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
            public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
                super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
                if (Full2PictureRecorder.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2 == PictureFormat.DNG) {
                    Full2PictureRecorder.this.KClassImpl$Data$declaredNonStaticMembers$2 = new DngCreator(actionHolder.DatabaseTableConfigUtil(), totalCaptureResult);
                    Full2PictureRecorder.this.KClassImpl$Data$declaredNonStaticMembers$2.setOrientation(ExifHelper.MyBillsEntityDataFactory(Full2PictureRecorder.this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0));
                    if (Full2PictureRecorder.this.moveToNextValue.MyBillsEntityDataFactory != null) {
                        Full2PictureRecorder.this.KClassImpl$Data$declaredNonStaticMembers$2.setLocation(Full2PictureRecorder.this.moveToNextValue.MyBillsEntityDataFactory);
                    }
                }
            }
        };
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public final void PlaceComponentResult() {
        this.PlaceComponentResult.PlaceComponentResult(this.lookAheadTest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cf  */
    @Override // android.media.ImageReader.OnImageAvailableListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onImageAvailable(android.media.ImageReader r8) {
        /*
            r7 = this;
            com.otaliastudios.cameraview.CameraLogger r0 = com.otaliastudios.cameraview.picture.Full2PictureRecorder.MyBillsEntityDataFactory
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "onImageAvailable started."
            r4 = 0
            r2[r4] = r3
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r1, r2)
            r0 = 0
            android.media.Image r8 = r8.acquireNextImage()     // Catch: java.lang.Throwable -> Lb9 java.lang.Exception -> Lbb
            int[] r2 = com.otaliastudios.cameraview.picture.Full2PictureRecorder.AnonymousClass2.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            com.otaliastudios.cameraview.PictureResult$Stub r3 = r7.moveToNextValue     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            com.otaliastudios.cameraview.controls.PictureFormat r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            int r3 = r3.ordinal()     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2 = r2[r3]     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            if (r2 == r1) goto L68
            r3 = 2
            if (r2 != r3) goto L4d
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2.<init>()     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r3.<init>(r2)     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            android.hardware.camera2.DngCreator r5 = r7.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.io.IOException -> L3e java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r5.writeImage(r3, r8)     // Catch: java.io.IOException -> L3e java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r3.flush()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            com.otaliastudios.cameraview.PictureResult$Stub r5 = r7.moveToNextValue     // Catch: java.io.IOException -> L3e java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            byte[] r2 = r2.toByteArray()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r5.BuiltInFictitiousFunctionClassFactory = r2     // Catch: java.io.IOException -> L3e java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            goto La1
        L3e:
            r1 = move-exception
            android.hardware.camera2.DngCreator r2 = r7.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2.close()     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r3.close()     // Catch: java.io.IOException -> L47 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
        L47:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2.<init>(r1)     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            throw r2     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
        L4d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2.<init>()     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            java.lang.String r3 = "Unknown format: "
            r2.append(r3)     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            com.otaliastudios.cameraview.PictureResult$Stub r3 = r7.moveToNextValue     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            com.otaliastudios.cameraview.controls.PictureFormat r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2.append(r3)     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            throw r1     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
        L68:
            android.media.Image$Plane[] r2 = r8.getPlanes()     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2 = r2[r4]     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            java.nio.ByteBuffer r2 = r2.getBuffer()     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            int r3 = r2.remaining()     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2.get(r3)     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            com.otaliastudios.cameraview.PictureResult$Stub r2 = r7.moveToNextValue     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2.BuiltInFictitiousFunctionClassFactory = r3     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            com.otaliastudios.cameraview.PictureResult$Stub r2 = r7.moveToNextValue     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4     // Catch: java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            androidx.exifinterface.media.ExifInterface r2 = new androidx.exifinterface.media.ExifInterface     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            com.otaliastudios.cameraview.PictureResult$Stub r5 = r7.moveToNextValue     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            byte[] r5 = r5.BuiltInFictitiousFunctionClassFactory     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r3.<init>(r5)     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r2.<init>(r3)     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            java.lang.String r3 = "Orientation"
            int r2 = r2.getAuthRequestContext(r3)     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            com.otaliastudios.cameraview.PictureResult$Stub r3 = r7.moveToNextValue     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            int r2 = com.otaliastudios.cameraview.internal.utils.ExifHelper.getAuthRequestContext(r2)     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            r3.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2     // Catch: java.io.IOException -> La0 java.lang.Throwable -> Lb5 java.lang.Exception -> Lb7
            goto La1
        La0:
        La1:
            if (r8 == 0) goto La6
            r8.close()
        La6:
            com.otaliastudios.cameraview.CameraLogger r8 = com.otaliastudios.cameraview.picture.Full2PictureRecorder.MyBillsEntityDataFactory
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r2 = "onImageAvailable ended."
            r0[r4] = r2
            r8.KClassImpl$Data$declaredNonStaticMembers$2(r1, r0)
            r7.MyBillsEntityDataFactory()
            return
        Lb5:
            r0 = move-exception
            goto Lca
        Lb7:
            r1 = move-exception
            goto Lbd
        Lb9:
            r8 = move-exception
            goto Lcd
        Lbb:
            r1 = move-exception
            r8 = r0
        Lbd:
            r7.moveToNextValue = r0     // Catch: java.lang.Throwable -> Lb5
            r7.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Throwable -> Lb5
            r7.MyBillsEntityDataFactory()     // Catch: java.lang.Throwable -> Lb5
            if (r8 == 0) goto Lc9
            r8.close()
        Lc9:
            return
        Lca:
            r6 = r0
            r0 = r8
            r8 = r6
        Lcd:
            if (r0 == 0) goto Ld2
            r0.close()
        Ld2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.picture.Full2PictureRecorder.onImageAvailable(android.media.ImageReader):void");
    }

    /* renamed from: com.otaliastudios.cameraview.picture.Full2PictureRecorder$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[PictureFormat.values().length];
            MyBillsEntityDataFactory = iArr;
            try {
                iArr[PictureFormat.JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                MyBillsEntityDataFactory[PictureFormat.DNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }
}
