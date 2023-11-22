package com.otaliastudios.cameraview.video.encoding;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.video.encoding.MediaEncoderEngine;
import com.otaliastudios.cameraview.video.encoding.VideoConfig;
import java.io.IOException;

/* loaded from: classes8.dex */
public abstract class VideoMediaEncoder<C extends VideoConfig> extends MediaEncoder {
    private static final CameraLogger MyBillsEntityDataFactory = CameraLogger.KClassImpl$Data$declaredNonStaticMembers$2("VideoMediaEncoder");
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    protected int getErrorConfigVersion;
    protected Surface moveToNextValue;
    protected C scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoMediaEncoder(C c) {
        super("VideoEncoder");
        this.getErrorConfigVersion = -1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.scheduleImpl = c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    public void KClassImpl$Data$declaredNonStaticMembers$2(MediaEncoderEngine.Controller controller, long j) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda2, this.scheduleImpl.initRecordTimeStamp, this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda1);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", this.scheduleImpl.getErrorConfigVersion);
        createVideoFormat.setInteger("frame-rate", this.scheduleImpl.moveToNextValue);
        createVideoFormat.setInteger("i-frame-interval", 1);
        createVideoFormat.setInteger("rotation-degrees", this.scheduleImpl.DatabaseTableConfigUtil);
        try {
            if (this.scheduleImpl.scheduleImpl != null) {
                this.PlaceComponentResult = MediaCodec.createByCodecName(this.scheduleImpl.scheduleImpl);
            } else {
                this.PlaceComponentResult = MediaCodec.createEncoderByType(this.scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda2);
            }
            this.PlaceComponentResult.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.moveToNextValue = this.PlaceComponentResult.createInputSurface();
            this.PlaceComponentResult.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    protected final void getAuthRequestContext() {
        this.getErrorConfigVersion = 0;
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    protected final void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(1, "onStop", "setting mFrameNumber to 1 and signaling the end of input stream.");
        this.getErrorConfigVersion = -1;
        this.PlaceComponentResult.signalEndOfInputStream();
        KClassImpl$Data$declaredNonStaticMembers$2(true);
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    protected final void MyBillsEntityDataFactory(OutputBufferPool outputBufferPool, OutputBuffer outputBuffer) {
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            CameraLogger cameraLogger = MyBillsEntityDataFactory;
            cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "onWriteOutput:", "sync frame not found yet. Checking.");
            if ((outputBuffer.KClassImpl$Data$declaredNonStaticMembers$2.flags & 1) == 1) {
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "onWriteOutput:", "SYNC FRAME FOUND!");
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            } else {
                cameraLogger.KClassImpl$Data$declaredNonStaticMembers$2(2, "onWriteOutput:", "DROPPING FRAME and requesting a sync frame soon.");
                if (Build.VERSION.SDK_INT >= 19) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("request-sync", 0);
                    this.PlaceComponentResult.setParameters(bundle);
                }
                outputBufferPool.MyBillsEntityDataFactory(outputBuffer);
                return;
            }
        }
        super.MyBillsEntityDataFactory(outputBufferPool, outputBuffer);
    }

    @Override // com.otaliastudios.cameraview.video.encoding.MediaEncoder
    protected final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl.getErrorConfigVersion;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean BuiltInFictitiousFunctionClassFactory(long j) {
        if (j == 0 || this.getErrorConfigVersion < 0 || moveToNextValue()) {
            return false;
        }
        this.getErrorConfigVersion++;
        return true;
    }
}
