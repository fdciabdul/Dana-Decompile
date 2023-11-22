package com.iap.ac.config.lite.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class m extends k {
    private List<byte[]> e;

    @Override // com.iap.ac.config.lite.a.k
    void a(b bVar) throws Exception {
        this.e = new ArrayList(2);
        while (bVar.g() > 0) {
            this.e.add(bVar.c());
        }
    }

    public List<String> c() {
        ArrayList arrayList = new ArrayList(this.e.size());
        Iterator<byte[]> it = this.e.iterator();
        while (it.hasNext()) {
            arrayList.add(k.a(it.next()));
        }
        return arrayList;
    }
}
