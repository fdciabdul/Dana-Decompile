package fsimpl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class fh extends WeakReference {

    /* renamed from: a  reason: collision with root package name */
    int f7987a;
    boolean b;
    int c;
    fh d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(Object obj, int i, ReferenceQueue referenceQueue) {
        super(obj, referenceQueue);
        boolean z = obj == null;
        this.b = z;
        this.f7987a = z ? 0 : obj.hashCode();
        this.c = i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.get());
        sb.append("=");
        sb.append(this.c);
        return sb.toString();
    }
}
