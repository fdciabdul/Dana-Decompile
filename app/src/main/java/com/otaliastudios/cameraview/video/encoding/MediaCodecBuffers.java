package com.otaliastudios.cameraview.video.encoding;

import android.media.MediaCodec;
import android.os.Build;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
class MediaCodecBuffers {
    final MediaCodec BuiltInFictitiousFunctionClassFactory;
    ByteBuffer[] KClassImpl$Data$declaredNonStaticMembers$2;
    final ByteBuffer[] MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaCodecBuffers(MediaCodec mediaCodec) {
        this.BuiltInFictitiousFunctionClassFactory = mediaCodec;
        if (Build.VERSION.SDK_INT < 21) {
            this.MyBillsEntityDataFactory = mediaCodec.getInputBuffers();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = mediaCodec.getOutputBuffers();
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.MyBillsEntityDataFactory = null;
    }
}
