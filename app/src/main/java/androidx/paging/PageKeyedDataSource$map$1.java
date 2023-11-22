package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0005*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00040\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00028\u0002 \u0005*\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00040\u0004H\n"}, d2 = {"", "ToValue", "Key", "Value", "", "kotlin.jvm.PlatformType", "list", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes2.dex */
final class PageKeyedDataSource$map$1<I, O> implements Function {
    final /* synthetic */ Function<Value, ToValue> PlaceComponentResult;

    @Override // androidx.arch.core.util.Function
    public final /* synthetic */ Object getAuthRequestContext(Object obj) {
        List list = (List) obj;
        Intrinsics.checkNotNullExpressionValue(list, "");
        List list2 = list;
        Function<Value, ToValue> function = this.PlaceComponentResult;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(function.getAuthRequestContext(it.next()));
        }
        return arrayList;
    }
}
