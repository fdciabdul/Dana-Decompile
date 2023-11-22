package com.otaliastudios.cameraview.video.encoding;

import android.media.MediaCodec;
import com.otaliastudios.cameraview.internal.utils.Pool;

/* loaded from: classes8.dex */
class OutputBufferPool extends Pool<OutputBuffer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputBufferPool(final int i) {
        super(Integer.MAX_VALUE, new Pool.Factory<OutputBuffer>() { // from class: com.otaliastudios.cameraview.video.encoding.OutputBufferPool.1
            @Override // com.otaliastudios.cameraview.internal.utils.Pool.Factory
            public final /* synthetic */ OutputBuffer getAuthRequestContext() {
                OutputBuffer outputBuffer = new OutputBuffer();
                outputBuffer.BuiltInFictitiousFunctionClassFactory = i;
                outputBuffer.KClassImpl$Data$declaredNonStaticMembers$2 = new MediaCodec.BufferInfo();
                return outputBuffer;
            }
        });
    }
}
