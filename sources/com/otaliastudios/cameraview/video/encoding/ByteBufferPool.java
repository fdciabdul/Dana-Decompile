package com.otaliastudios.cameraview.video.encoding;

import com.otaliastudios.cameraview.internal.utils.Pool;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class ByteBufferPool extends Pool<ByteBuffer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteBufferPool(final int i, int i2) {
        super(i2, new Pool.Factory<ByteBuffer>() { // from class: com.otaliastudios.cameraview.video.encoding.ByteBufferPool.1
            @Override // com.otaliastudios.cameraview.internal.utils.Pool.Factory
            public final /* synthetic */ ByteBuffer getAuthRequestContext() {
                return ByteBuffer.allocateDirect(i);
            }
        });
    }
}
