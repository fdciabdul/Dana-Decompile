package androidx.paging;

import androidx.arch.core.util.Function;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [Value, ToValue] */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "ToValue", "Key", "Value", "", "list", BridgeDSL.INVOKE, "(Ljava/util/List;)Ljava/util/List;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class DataSource$map$1<ToValue, Value> extends Lambda implements Function1<List<? extends Value>, List<? extends ToValue>> {
    final /* synthetic */ Function<Value, ToValue> $$function;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataSource$map$1(Function<Value, ToValue> function) {
        super(1);
        this.$$function = function;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke((List) ((List) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<ToValue> invoke(List<? extends Value> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<? extends Value> list2 = list;
        Function<Value, ToValue> function = this.$$function;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(function.getAuthRequestContext(it.next()));
        }
        return arrayList;
    }
}
