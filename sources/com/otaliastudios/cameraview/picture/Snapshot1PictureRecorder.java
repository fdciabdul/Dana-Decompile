package com.otaliastudios.cameraview.picture;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.engine.Camera1Engine;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.internal.utils.CropHelper;
import com.otaliastudios.cameraview.internal.utils.RotationHelper;
import com.otaliastudios.cameraview.internal.utils.WorkerHandler;
import com.otaliastudios.cameraview.picture.PictureRecorder;
import com.otaliastudios.cameraview.size.AspectRatio;
import com.otaliastudios.cameraview.size.Size;
import java.io.ByteArrayOutputStream;

/* loaded from: classes8.dex */
public class Snapshot1PictureRecorder extends SnapshotPictureRecorder {
    private Camera KClassImpl$Data$declaredNonStaticMembers$2;
    private int MyBillsEntityDataFactory;
    private Camera1Engine PlaceComponentResult;
    private AspectRatio lookAheadTest;

    public Snapshot1PictureRecorder(PictureResult.Stub stub, Camera1Engine camera1Engine, Camera camera, AspectRatio aspectRatio) {
        super(stub, camera1Engine);
        this.PlaceComponentResult = camera1Engine;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = camera;
        this.lookAheadTest = aspectRatio;
        this.MyBillsEntityDataFactory = camera.getParameters().getPreviewFormat();
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOneShotPreviewCallback(new Camera.PreviewCallback() { // from class: com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.1
            {
                Snapshot1PictureRecorder.this = this;
            }

            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(final byte[] bArr, Camera camera) {
                PictureRecorder.PictureResultListener pictureResultListener = Snapshot1PictureRecorder.this.getAuthRequestContext;
                if (pictureResultListener != null) {
                    pictureResultListener.PlaceComponentResult(false);
                }
                final int i = Snapshot1PictureRecorder.this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0;
                final Size size = Snapshot1PictureRecorder.this.moveToNextValue.scheduleImpl;
                final Size BuiltInFictitiousFunctionClassFactory = Snapshot1PictureRecorder.this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(Reference.SENSOR);
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    throw new IllegalStateException("Preview stream size should never be null here.");
                }
                WorkerHandler.KClassImpl$Data$declaredNonStaticMembers$2(new Runnable() { // from class: com.otaliastudios.cameraview.picture.Snapshot1PictureRecorder.1.1
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        YuvImage yuvImage = new YuvImage(RotationHelper.BuiltInFictitiousFunctionClassFactory(bArr, BuiltInFictitiousFunctionClassFactory, i), Snapshot1PictureRecorder.this.MyBillsEntityDataFactory, size.BuiltInFictitiousFunctionClassFactory, size.getAuthRequestContext, null);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        Rect BuiltInFictitiousFunctionClassFactory2 = CropHelper.BuiltInFictitiousFunctionClassFactory(size, Snapshot1PictureRecorder.this.lookAheadTest);
                        yuvImage.compressToJpeg(BuiltInFictitiousFunctionClassFactory2, 90, byteArrayOutputStream);
                        Snapshot1PictureRecorder.this.moveToNextValue.BuiltInFictitiousFunctionClassFactory = byteArrayOutputStream.toByteArray();
                        Snapshot1PictureRecorder.this.moveToNextValue.scheduleImpl = new Size(BuiltInFictitiousFunctionClassFactory2.width(), BuiltInFictitiousFunctionClassFactory2.height());
                        Snapshot1PictureRecorder.this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
                        Snapshot1PictureRecorder.this.MyBillsEntityDataFactory();
                    }
                });
                camera.setPreviewCallbackWithBuffer(null);
                camera.setPreviewCallbackWithBuffer(Snapshot1PictureRecorder.this.PlaceComponentResult);
                Snapshot1PictureRecorder.this.PlaceComponentResult.PlaceComponentResult().PlaceComponentResult(Snapshot1PictureRecorder.this.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory);
            }
        });
    }

    @Override // com.otaliastudios.cameraview.picture.PictureRecorder
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.lookAheadTest = null;
        this.MyBillsEntityDataFactory = 0;
        super.MyBillsEntityDataFactory();
    }
}
