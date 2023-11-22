package androidx.paging;

import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004R&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R#\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\tX\u0000¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Landroidx/paging/InvalidatingPagingSourceFactory;", "", "Key", "Value", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class InvalidatingPagingSourceFactory<Key, Value> implements Function0<PagingSource<Key, Value>> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function0<PagingSource<Key, Value>> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final CopyOnWriteArrayList<PagingSource<Key, Value>> BuiltInFictitiousFunctionClassFactory;

    @Override // kotlin.jvm.functions.Function0
    public final /* synthetic */ Object invoke() {
        PagingSource<Key, Value> invoke = this.getAuthRequestContext.invoke();
        this.BuiltInFictitiousFunctionClassFactory.add(invoke);
        return invoke;
    }
}
