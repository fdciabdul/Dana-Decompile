package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.bytedata.ByteOrderDataUtil;
import com.alibaba.ariver.kernel.api.extension.registry.NebulaConfigBase;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class NebulaConfigBase<T extends NebulaConfigBase<T>> {
    protected byte mFormatVersion;

    public NebulaConfigBase(byte b) {
        this.mFormatVersion = b;
    }

    public T serialize(BufferedOutputStream bufferedOutputStream) throws IOException {
        ByteOrderDataUtil.writeByte(bufferedOutputStream, this.mFormatVersion);
        return this;
    }

    public T deserialize(BufferedInputStream bufferedInputStream) throws IOException {
        this.mFormatVersion = ByteOrderDataUtil.readByte(bufferedInputStream);
        return this;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof NebulaConfigBase) && obj.hashCode() == hashCode();
    }
}
