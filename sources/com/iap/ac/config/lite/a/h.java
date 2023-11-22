package com.iap.ac.config.lite.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private f f7621a;
    private List<k>[] b;

    private h(f fVar) {
        this.b = new List[4];
        this.f7621a = fVar;
    }

    public static h a(k kVar) {
        h hVar = new h();
        hVar.f7621a.f(0);
        hVar.f7621a.d(7);
        hVar.a(kVar, 0);
        return hVar;
    }

    public k b() {
        List<k> list = this.b[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public byte[] c() {
        c cVar = new c();
        a(cVar);
        return cVar.a();
    }

    public h() {
        this(new f());
    }

    h(b bVar) throws Exception {
        this(new f(bVar));
        boolean z = this.f7621a.b() == 5;
        boolean b = this.f7621a.b(6);
        for (int i = 0; i < 2; i++) {
            try {
                int a2 = this.f7621a.a(i);
                if (a2 > 0) {
                    this.b[i] = new ArrayList(a2);
                }
                for (int i2 = 0; i2 < a2; i2++) {
                    this.b[i].add(k.a(bVar, i, z));
                }
            } catch (a e) {
                if (!b) {
                    throw e;
                }
                return;
            }
        }
    }

    public f a() {
        return this.f7621a;
    }

    public void a(k kVar, int i) {
        List<k>[] listArr = this.b;
        if (listArr[i] == null) {
            listArr[i] = new LinkedList();
        }
        this.f7621a.c(i);
        this.b[i].add(kVar);
    }

    public List<k> a(int i) {
        List<k> list = this.b[i];
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    private void a(c cVar, int i) {
        int size = this.b[i].size();
        for (int i2 = 0; i2 < size; i2++) {
            this.b[i].get(i2).a(cVar);
        }
    }

    private void a(c cVar) {
        this.f7621a.a(cVar);
        for (int i = 0; i < 4; i++) {
            if (this.b[i] != null) {
                a(cVar, i);
            }
        }
    }

    public h(byte[] bArr) throws Exception {
        this(new b(bArr));
    }
}
