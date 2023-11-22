package com.otaliastudios.cameraview.video;

import android.hardware.camera2.CaptureRequest;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.view.Surface;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.engine.Camera2Engine;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import com.otaliastudios.cameraview.engine.action.CompletionCallback;
import com.otaliastudios.cameraview.internal.utils.CamcorderProfiles;
import com.otaliastudios.cameraview.size.Size;

/* loaded from: classes8.dex */
public class Full2VideoRecorder extends FullVideoRecorder {
    public Surface BuiltInFictitiousFunctionClassFactory;
    private ActionHolder getErrorConfigVersion;
    private final String moveToNextValue;

    public Full2VideoRecorder(Camera2Engine camera2Engine, String str) {
        super(camera2Engine);
        this.getErrorConfigVersion = camera2Engine;
        this.moveToNextValue = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder, com.otaliastudios.cameraview.video.VideoRecorder
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        BaseAction baseAction = new BaseAction() { // from class: com.otaliastudios.cameraview.video.Full2VideoRecorder.1
            @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
            public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest) {
                super.getAuthRequestContext(actionHolder, captureRequest);
                Object tag = actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().build().getTag();
                Object tag2 = captureRequest.getTag();
                if (tag == null) {
                    if (tag2 != null) {
                        return;
                    }
                } else if (!tag.equals(tag2)) {
                    return;
                }
                MyBillsEntityDataFactory(Integer.MAX_VALUE);
            }
        };
        baseAction.PlaceComponentResult(new CompletionCallback() { // from class: com.otaliastudios.cameraview.video.Full2VideoRecorder.2
            @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
            public final void getAuthRequestContext() {
                Full2VideoRecorder.super.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        baseAction.PlaceComponentResult(this.getErrorConfigVersion);
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    protected final void MyBillsEntityDataFactory(MediaRecorder mediaRecorder) {
        mediaRecorder.setVideoSource(2);
    }

    @Override // com.otaliastudios.cameraview.video.FullVideoRecorder
    protected final CamcorderProfile KClassImpl$Data$declaredNonStaticMembers$2(VideoResult.Stub stub) {
        int i = stub.initRecordTimeStamp;
        Size size = stub.DatabaseTableConfigUtil;
        if (i % 180 != 0) {
            size = new Size(size.getAuthRequestContext, size.BuiltInFictitiousFunctionClassFactory);
        }
        return CamcorderProfiles.MyBillsEntityDataFactory(this.moveToNextValue, size);
    }

    public final Surface getAuthRequestContext(VideoResult.Stub stub) throws PrepareException {
        if (!MyBillsEntityDataFactory(stub)) {
            throw new PrepareException(this.lookAheadTest);
        }
        Surface surface = this.getAuthRequestContext.getSurface();
        this.BuiltInFictitiousFunctionClassFactory = surface;
        return surface;
    }

    /* loaded from: classes8.dex */
    public class PrepareException extends Exception {
        private PrepareException(Throwable th) {
            super(th);
        }
    }
}
