package com.otaliastudios.cameraview.video.encoding;

import com.otaliastudios.cameraview.internal.utils.Pool;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class InputBufferPool extends Pool<InputBuffer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public InputBufferPool() {
        super(Integer.MAX_VALUE, new Pool.Factory<InputBuffer>() { // from class: com.otaliastudios.cameraview.video.encoding.InputBufferPool.1
            @Override // com.otaliastudios.cameraview.internal.utils.Pool.Factory
            public final /* synthetic */ InputBuffer getAuthRequestContext() {
                return new InputBuffer();
            }
        });
    }
}
