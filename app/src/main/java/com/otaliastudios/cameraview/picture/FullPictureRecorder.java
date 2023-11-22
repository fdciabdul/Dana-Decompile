package com.otaliastudios.cameraview.picture;

import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.picture.PictureRecorder;

/* loaded from: classes8.dex */
public abstract class FullPictureRecorder extends PictureRecorder {
    protected static final CameraLogger MyBillsEntityDataFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("FullPictureRecorder");

    public FullPictureRecorder(PictureResult.Stub stub, PictureRecorder.PictureResultListener pictureResultListener) {
        super(stub, pictureResultListener);
    }
}
