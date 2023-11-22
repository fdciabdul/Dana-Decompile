package com.otaliastudios.cameraview.picture;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.engine.Camera2Engine;
import com.otaliastudios.cameraview.engine.action.Action;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.Actions;
import com.otaliastudios.cameraview.engine.action.BaseAction;
import com.otaliastudios.cameraview.engine.action.CompletionCallback;
import com.otaliastudios.cameraview.engine.lock.LockAction;
import com.otaliastudios.cameraview.preview.GlCameraPreview;
import com.otaliastudios.cameraview.size.AspectRatio;

/* loaded from: classes8.dex */
public class Snapshot2PictureRecorder extends SnapshotGlPictureRecorder {
    private Integer DatabaseTableConfigUtil;
    private final Action GetContactSyncConfig;
    private final ActionHolder NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Integer NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final boolean initRecordTimeStamp;

    /* loaded from: classes8.dex */
    class FlashAction extends BaseAction {
        private FlashAction() {
        }

        /* synthetic */ FlashAction(Snapshot2PictureRecorder snapshot2PictureRecorder, byte b) {
            this();
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction
        public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
            super.MyBillsEntityDataFactory(actionHolder);
            SnapshotPictureRecorder.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(1, "FlashAction:", "Parameters locked, opening torch.");
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.FLASH_MODE, 2);
            actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2().set(CaptureRequest.CONTROL_AE_MODE, 1);
            actionHolder.PlaceComponentResult();
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
        public final void getAuthRequestContext(ActionHolder actionHolder, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            super.getAuthRequestContext(actionHolder, captureRequest, totalCaptureResult);
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
            if (num != null) {
                if (num.intValue() == 3) {
                    SnapshotPictureRecorder.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(1, "FlashAction:", "Waiting flash and we have FIRED state!", "Taking snapshot.");
                    MyBillsEntityDataFactory(Integer.MAX_VALUE);
                    return;
                }
                SnapshotPictureRecorder.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(1, "FlashAction:", "Waiting flash but flashState is", num, ". Waiting...");
                return;
            }
            SnapshotPictureRecorder.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(2, "FlashAction:", "Waiting flash, but flashState is null!", "Taking snapshot.");
            MyBillsEntityDataFactory(Integer.MAX_VALUE);
        }
    }

    /* loaded from: classes8.dex */
    class ResetFlashAction extends BaseAction {
        private ResetFlashAction() {
        }

        /* synthetic */ ResetFlashAction(Snapshot2PictureRecorder snapshot2PictureRecorder, byte b) {
            this();
        }

        @Override // com.otaliastudios.cameraview.engine.action.BaseAction
        public final void MyBillsEntityDataFactory(ActionHolder actionHolder) {
            super.MyBillsEntityDataFactory(actionHolder);
            try {
                SnapshotPictureRecorder.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(1, "ResetFlashAction:", "Reverting the flash changes.");
                CaptureRequest.Builder NetworkUserEntityData$$ExternalSyntheticLambda2 = actionHolder.NetworkUserEntityData$$ExternalSyntheticLambda2();
                NetworkUserEntityData$$ExternalSyntheticLambda2.set(CaptureRequest.CONTROL_AE_MODE, 1);
                NetworkUserEntityData$$ExternalSyntheticLambda2.set(CaptureRequest.FLASH_MODE, 0);
                actionHolder.MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda2);
                NetworkUserEntityData$$ExternalSyntheticLambda2.set(CaptureRequest.CONTROL_AE_MODE, Snapshot2PictureRecorder.this.DatabaseTableConfigUtil);
                NetworkUserEntityData$$ExternalSyntheticLambda2.set(CaptureRequest.FLASH_MODE, Snapshot2PictureRecorder.this.NetworkUserEntityData$$ExternalSyntheticLambda7);
                actionHolder.PlaceComponentResult();
            } catch (CameraAccessException unused) {
            }
        }
    }

    public Snapshot2PictureRecorder(PictureResult.Stub stub, Camera2Engine camera2Engine, GlCameraPreview glCameraPreview, AspectRatio aspectRatio) {
        super(stub, camera2Engine, glCameraPreview, aspectRatio);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = camera2Engine;
        boolean z = false;
        z = false;
        z = false;
        BaseAction authRequestContext = Actions.getAuthRequestContext(Actions.KClassImpl$Data$declaredNonStaticMembers$2(2500L, new LockAction()), new FlashAction(this, z ? (byte) 1 : (byte) 0));
        this.GetContactSyncConfig = authRequestContext;
        authRequestContext.PlaceComponentResult(new CompletionCallback() { // from class: com.otaliastudios.cameraview.picture.Snapshot2PictureRecorder.1
            @Override // com.otaliastudios.cameraview.engine.action.CompletionCallback
            public final void getAuthRequestContext() {
                SnapshotPictureRecorder.NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(1, "Taking picture with super.take().");
                Snapshot2PictureRecorder.super.PlaceComponentResult();
            }
        });
        TotalCaptureResult GetContactSyncConfig = camera2Engine.GetContactSyncConfig();
        if (GetContactSyncConfig == null) {
            NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(2, "Picture snapshot requested very early, before the first preview frame.", "Metering might not work as intended.");
        }
        Integer num = GetContactSyncConfig != null ? (Integer) GetContactSyncConfig.get(CaptureResult.CONTROL_AE_STATE) : null;
        if (camera2Engine.getValueOfTouchPositionAbsolute() && num != null && num.intValue() == 4) {
            z = true;
        }
        this.initRecordTimeStamp = z;
        this.DatabaseTableConfigUtil = (Integer) camera2Engine.NetworkUserEntityData$$ExternalSyntheticLambda2().get(CaptureRequest.CONTROL_AE_MODE);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (Integer) camera2Engine.NetworkUserEntityData$$ExternalSyntheticLambda2().get(CaptureRequest.FLASH_MODE);
    }

    @Override // com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder, com.otaliastudios.cameraview.picture.PictureRecorder
    public final void PlaceComponentResult() {
        if (!this.initRecordTimeStamp) {
            NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(1, "take:", "Engine does no metering or needs no flash.", "Taking fast snapshot.");
            super.PlaceComponentResult();
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda2.KClassImpl$Data$declaredNonStaticMembers$2(1, "take:", "Engine needs flash. Starting action");
        this.GetContactSyncConfig.PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.picture.SnapshotGlPictureRecorder, com.otaliastudios.cameraview.picture.PictureRecorder
    public final void MyBillsEntityDataFactory() {
        new ResetFlashAction(this, (byte) 0).PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        super.MyBillsEntityDataFactory();
    }
}
