package com.alipay.alipaysecuritysdk.rds.v2.b.a;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public final class d extends com.alipay.alipaysecuritysdk.rds.v2.b.b {

    /* renamed from: a  reason: collision with root package name */
    private List<com.alipay.alipaysecuritysdk.rds.v2.b.b> f6879a;

    public d() {
        this((byte) 0);
    }

    private d(byte b) {
        this.f6879a = new ArrayList();
    }

    public final void a(com.alipay.alipaysecuritysdk.rds.v2.b.b bVar) {
        this.f6879a.add(bVar);
    }

    public final void a(String str, boolean z, double d) {
        synchronized (this) {
            com.alipay.alipaysecuritysdk.rds.v2.b.b bVar = this.f6879a.get(r0.size() - 1);
            if (bVar instanceof a) {
                ((a) bVar).b();
            } else if (bVar instanceof b) {
                ((b) bVar).a(str);
            } else if (bVar instanceof c) {
                ((c) bVar).b(z);
            } else if (bVar instanceof f) {
                ((f) bVar).a(d);
            }
            this.f6879a.set(r3.size() - 1, bVar);
        }
    }

    @Override // com.alipay.alipaysecuritysdk.rds.v2.b.b
    public final /* synthetic */ Object a() {
        JSONArray jSONArray = new JSONArray();
        if (this.f6879a.size() > 15) {
            List<com.alipay.alipaysecuritysdk.rds.v2.b.b> list = this.f6879a;
            this.f6879a = list.subList(list.size() - 15, this.f6879a.size());
        }
        for (com.alipay.alipaysecuritysdk.rds.v2.b.b bVar : this.f6879a) {
            if (bVar != null && (bVar instanceof com.alipay.alipaysecuritysdk.rds.v2.b.b)) {
                jSONArray.put(bVar.a());
            }
        }
        return jSONArray;
    }
}
