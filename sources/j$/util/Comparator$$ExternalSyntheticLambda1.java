package j$.util;

import j$.util.function.Function;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final /* synthetic */ class Comparator$$ExternalSyntheticLambda1 implements java.util.Comparator, Serializable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ java.util.Comparator f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Comparator$$ExternalSyntheticLambda1(java.util.Comparator comparator, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = comparator;
        this.f$1 = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (this.$r8$classId != 0) {
            java.util.Comparator comparator = this.f$0;
            Function function = (Function) this.f$1;
            return comparator.compare(function.apply(obj), function.apply(obj2));
        }
        java.util.Comparator comparator2 = this.f$0;
        java.util.Comparator comparator3 = (java.util.Comparator) this.f$1;
        int compare = comparator2.compare(obj, obj2);
        return compare == 0 ? comparator3.compare(obj, obj2) : compare;
    }
}
