package androidx.view;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {}, d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000H\n"}, d2 = {"X", "Y", "kotlin.jvm.PlatformType", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public final class TransformationsKt$map$1<I, O> implements Function {
    final /* synthetic */ Function1<X, Y> PlaceComponentResult;

    /* JADX WARN: Type inference failed for: r2v1, types: [Y, java.lang.Object] */
    @Override // androidx.arch.core.util.Function
    public final Y getAuthRequestContext(X x) {
        return this.PlaceComponentResult.invoke(x);
    }
}
