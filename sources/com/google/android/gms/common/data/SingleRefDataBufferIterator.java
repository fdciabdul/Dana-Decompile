package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

/* loaded from: classes7.dex */
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private T zac;

    public SingleRefDataBufferIterator(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.google.android.gms.common.data.DataBufferIterator, java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            int i = this.zab;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Cannot advance the iterator beyond ");
            sb.append(i);
            throw new NoSuchElementException(sb.toString());
        }
        int i2 = this.zab + 1;
        this.zab = i2;
        if (i2 == 0) {
            T t = (T) Preconditions.checkNotNull(this.zaa.get(0));
            this.zac = t;
            if (!(t instanceof DataBufferRef)) {
                String valueOf = String.valueOf(t.getClass());
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 44);
                sb2.append("DataBuffer reference of type ");
                sb2.append(valueOf);
                sb2.append(" is not movable");
                throw new IllegalStateException(sb2.toString());
            }
        } else {
            ((DataBufferRef) Preconditions.checkNotNull(this.zac)).zaa(this.zab);
        }
        return this.zac;
    }
}
