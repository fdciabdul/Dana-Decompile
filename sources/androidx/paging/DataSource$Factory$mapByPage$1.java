package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: Add missing generic type declarations: [ToValue, Key] */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001b\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/paging/DataSource$Factory$mapByPage$1;", "Landroidx/paging/DataSource$Factory;", "Landroidx/paging/DataSource;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/paging/DataSource;"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DataSource$Factory$mapByPage$1<Key, ToValue> extends DataSource.Factory<Key, ToValue> {
    final /* synthetic */ Function<List<Value>, List<ToValue>> MyBillsEntityDataFactory;
    final /* synthetic */ DataSource.Factory<Key, Value> PlaceComponentResult;

    @Override // androidx.paging.DataSource.Factory
    public final DataSource<Key, ToValue> BuiltInFictitiousFunctionClassFactory() {
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory((Function) this.MyBillsEntityDataFactory);
    }
}
