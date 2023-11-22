package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;

/* loaded from: classes7.dex */
public class SingleRefDBInnerIter<T> extends DBInnerIter<T> {
    public SingleRefDBInnerIter(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.huawei.hms.common.data.DBInnerIter, java.util.Iterator
    public T next() {
        if (hasNext()) {
            int i = this.index + 1;
            this.index = i;
            if (i == 0) {
                boolean z = this.dataBuffer.get(0) instanceof DataBufferRef;
                StringBuilder sb = new StringBuilder();
                sb.append("DataBuffer reference of type ");
                sb.append(this.dataBuffer.get(0).getClass());
                sb.append(" is not movable");
                Preconditions.checkState(z, sb.toString());
                ((DataBufferRef) this.dataBuffer.get(0)).getWindowIndex(this.index);
            }
            return (T) this.dataBuffer.get(0);
        }
        return null;
    }
}
