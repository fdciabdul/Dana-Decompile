package com.alipay.imobile.magenerator.a;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    private final n f7023a;
    private final List b;

    public x(n nVar) {
        this.f7023a = nVar;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new o(nVar, new int[]{1}));
    }

    private o a(int i) {
        if (i >= this.b.size()) {
            List list = this.b;
            o oVar = (o) list.get(list.size() - 1);
            for (int size = this.b.size(); size <= i; size++) {
                n nVar = this.f7023a;
                oVar = oVar.b(new o(nVar, new int[]{1, nVar.a((size - 1) + nVar.b())}));
                this.b.add(oVar);
            }
        }
        return (o) this.b.get(i);
    }

    public final void a(int[] iArr, int i) {
        if (i == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        o a2 = a(i);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] a3 = new o(this.f7023a, iArr2).a(i, 1).c(a2)[1].a();
        int length2 = i - a3.length;
        for (int i2 = 0; i2 < length2; i2++) {
            iArr[length + i2] = 0;
        }
        System.arraycopy(a3, 0, iArr, length + length2, a3.length);
    }
}
