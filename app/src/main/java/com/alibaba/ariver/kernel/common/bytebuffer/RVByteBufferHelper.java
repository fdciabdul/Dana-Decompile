package com.alibaba.ariver.kernel.common.bytebuffer;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class RVByteBufferHelper {
    public static ByteBuffer wrap(byte[] bArr, int i) {
        return RVByteBufferPool.get(bArr, i, !"YES".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_notUseDirectBuffer", "YES")));
    }

    public static ByteBuffer wrapWithDirectBuffer(byte[] bArr, int i) {
        return RVByteBufferPool.get(bArr, i, true);
    }
}
