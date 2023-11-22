package com.alipay.imobile.network.quake.transport.storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class ByteArrayPool {
    protected static final Comparator<byte[]> e = new a();

    /* renamed from: a  reason: collision with root package name */
    private List<byte[]> f7071a = new LinkedList();
    private List<byte[]> b = new ArrayList(64);
    private int c = 0;
    private final int d;

    /* loaded from: classes3.dex */
    class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a  reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public ByteArrayPool(int i) {
        this.d = i;
    }

    private void a() {
        synchronized (this) {
            while (this.c > this.d) {
                byte[] remove = this.f7071a.remove(0);
                this.b.remove(remove);
                this.c -= remove.length;
            }
        }
    }

    public byte[] getBuf(int i) {
        synchronized (this) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                byte[] bArr = this.b.get(i2);
                if (bArr.length >= i) {
                    this.c -= bArr.length;
                    this.b.remove(i2);
                    this.f7071a.remove(bArr);
                    return bArr;
                }
            }
            return new byte[i];
        }
    }

    public void returnBuf(byte[] bArr) {
        synchronized (this) {
            if (bArr != null) {
                if (bArr.length <= this.d) {
                    this.f7071a.add(bArr);
                    int binarySearch = Collections.binarySearch(this.b, bArr, e);
                    if (binarySearch < 0) {
                        binarySearch = (-binarySearch) - 1;
                    }
                    this.b.add(binarySearch, bArr);
                    this.c += bArr.length;
                    a();
                }
            }
        }
    }
}
