package com.otaliastudios.cameraview.video;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.engine.Camera1Engine;
import com.otaliastudios.cameraview.internal.utils.CamcorderProfiles;
import com.otaliastudios.cameraview.size.Size;

/* loaded from: classes8.dex */
public class Full1VideoRecorder extends FullVideoRecorder {
    private final Camera BuiltInFictitiousFunctionClassFactory;
    private final Camera1Engine NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final int moveToNextValue;

    public Full1VideoRecorder(Camera1Engine camera1Engine, Camera camera, int i) {
        super(camera1Engine);
        this.BuiltInFictitiousFunctionClassFactory = camera;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = camera1Engine;
        this.moveToNextValue = i;
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    protected final void MyBillsEntityDataFactory(MediaRecorder mediaRecorder) {
        mediaRecorder.setCamera(this.BuiltInFictitiousFunctionClassFactory);
        mediaRecorder.setVideoSource(1);
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    protected final CamcorderProfile KClassImpl$Data$declaredNonStaticMembers$2(VideoResult.Stub stub) {
        int i = stub.initRecordTimeStamp;
        Size size = stub.DatabaseTableConfigUtil;
        if (i % 180 != 0) {
            size = new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory);
        }
        return CamcorderProfiles.KClassImpl$Data$declaredNonStaticMembers$2(this.moveToNextValue, size);
    }

    @Override // com.otaliastudios.cameraview.video.VideoRecorder
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.setPreviewCallbackWithBuffer(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        super.BuiltInFictitiousFunctionClassFactory();
    }
}
