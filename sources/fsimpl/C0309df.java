package fsimpl;

import java.util.ArrayList;
import java.util.List;

/* renamed from: fsimpl.df  reason: case insensitive filesystem */
/* loaded from: classes8.dex */
class C0309df {

    /* renamed from: a  reason: collision with root package name */
    private List f7933a = new ArrayList();
    private List b = new ArrayList();
    private List c = new ArrayList();

    private C0304da[] d(List list) {
        C0304da[] c0304daArr = new C0304da[0];
        return list == null ? c0304daArr : (C0304da[]) list.toArray(c0304daArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0307dd a() {
        return new C0307dd(d(this.f7933a), d(this.b), d(this.c));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0309df a(List list) {
        if (list != null) {
            this.f7933a.addAll(list);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0309df b(List list) {
        if (list != null) {
            this.b.addAll(list);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0309df c(List list) {
        if (list != null) {
            this.c.addAll(list);
        }
        return this;
    }
}
