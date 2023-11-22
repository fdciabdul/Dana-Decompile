package androidx.paging;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\b\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u000b\u001a\u00020\u00038WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/paging/ItemSnapshotList;", "T", "Lkotlin/collections/AbstractList;", "", "p0", "get", "(I)Ljava/lang/Object;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "I", "PlaceComponentResult", "getSize", "()I", "p1", "p2", "<init>", "(IILjava/util/List;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ItemSnapshotList<T> extends AbstractList<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<T> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemSnapshotList(int i, int i2, List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    @JvmName(name = "getSize")
    /* renamed from: getSize */
    public final int get_size() {
        return this.PlaceComponentResult + this.KClassImpl$Data$declaredNonStaticMembers$2.size() + this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final T get(int p0) {
        if (p0 >= 0 && p0 < this.PlaceComponentResult) {
            return null;
        }
        int i = this.PlaceComponentResult;
        if (p0 < this.KClassImpl$Data$declaredNonStaticMembers$2.size() + i && i <= p0) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2.get(p0 - this.PlaceComponentResult);
        }
        if (p0 < size() && this.PlaceComponentResult + this.KClassImpl$Data$declaredNonStaticMembers$2.size() <= p0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal attempt to access index ");
        sb.append(p0);
        sb.append(" in ItemSnapshotList of size ");
        sb.append(size());
        throw new IndexOutOfBoundsException(sb.toString());
    }
}
