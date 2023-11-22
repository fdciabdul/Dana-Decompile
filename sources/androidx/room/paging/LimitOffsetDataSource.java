package androidx.room.paging;

import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import java.util.Set;

/* loaded from: classes6.dex */
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {

    /* renamed from: androidx.room.paging.LimitOffsetDataSource$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 extends InvalidationTracker.Observer {
        final /* synthetic */ LimitOffsetDataSource getAuthRequestContext;

        @Override // androidx.room.InvalidationTracker.Observer
        public final void PlaceComponentResult(Set<String> set) {
            this.getAuthRequestContext.MyBillsEntityDataFactory();
        }
    }
}
