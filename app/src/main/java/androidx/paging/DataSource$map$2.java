package androidx.paging;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00018\u00008\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00018\u00028\u0002H\n"}, d2 = {"", "ToValue", "Key", "Value", "kotlin.jvm.PlatformType", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class DataSource$map$2<I, O> implements Function {
    final /* synthetic */ Function1<Value, ToValue> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Type inference failed for: r3v1, types: [ToValue, java.lang.Object] */
    @Override // androidx.arch.core.util.Function
    public final ToValue getAuthRequestContext(Value value) {
        Function1<Value, ToValue> function1 = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(value, "");
        return function1.invoke(value);
    }
}
