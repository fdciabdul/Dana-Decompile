package androidx.view.viewmodel;

import androidx.view.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0005\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0005\u0010\t"}, d2 = {"Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "T", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "p0", "PlaceComponentResult", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "p1", "", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;Ljava/lang/Object;)V", "<init>", "(Landroidx/lifecycle/viewmodel/CreationExtras;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.lifecycle.viewmodel.CreationExtras, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MutableCreationExtras() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.viewmodel.MutableCreationExtras.<init>():void");
    }

    public MutableCreationExtras(CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter(creationExtras, "");
        this.MyBillsEntityDataFactory.putAll(creationExtras.MyBillsEntityDataFactory);
    }

    public /* synthetic */ MutableCreationExtras(CreationExtras.Empty empty, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CreationExtras.Empty.INSTANCE : empty);
    }

    @Override // androidx.view.viewmodel.CreationExtras
    public final <T> T PlaceComponentResult(CreationExtras.Key<T> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return (T) this.MyBillsEntityDataFactory.get(p0);
    }

    public final <T> void PlaceComponentResult(CreationExtras.Key<T> p0, T p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.put(p0, p1);
    }
}
