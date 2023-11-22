package j$.util;

import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;

/* loaded from: classes.dex */
public final /* synthetic */ class Comparator$$ExternalSyntheticLambda0 implements java.util.Comparator, Serializable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Comparator$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = this.$r8$classId;
        if (i == 0) {
            ToDoubleFunction toDoubleFunction = (ToDoubleFunction) this.f$0;
            return Double.compare(toDoubleFunction.applyAsDouble(obj), toDoubleFunction.applyAsDouble(obj2));
        } else if (i == 1) {
            ToIntFunction toIntFunction = (ToIntFunction) this.f$0;
            return Integer.compare(toIntFunction.MyBillsEntityDataFactory(obj), toIntFunction.MyBillsEntityDataFactory(obj2));
        } else if (i != 2) {
            Function function = (Function) this.f$0;
            return ((Comparable) function.apply(obj)).compareTo(function.apply(obj2));
        } else {
            ToLongFunction toLongFunction = (ToLongFunction) this.f$0;
            return Long.compare(toLongFunction.KClassImpl$Data$declaredNonStaticMembers$2(obj), toLongFunction.KClassImpl$Data$declaredNonStaticMembers$2(obj2));
        }
    }
}
