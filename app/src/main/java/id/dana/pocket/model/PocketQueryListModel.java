package id.dana.pocket.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B+\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0012\u0010\f\u001a\u00020\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/pocket/model/PocketQueryListModel;", "T", "", "", "MyBillsEntityDataFactory", "Z", "", "getAuthRequestContext", "Ljava/util/List;", "PlaceComponentResult", "", "I", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "p2", "<init>", "(ZLjava/util/List;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PocketQueryListModel<T> {
    public boolean MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<T> PlaceComponentResult;

    public PocketQueryListModel() {
        this(false, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PocketQueryListModel(boolean z, List<? extends T> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        this.MyBillsEntityDataFactory = z;
        this.PlaceComponentResult = list;
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    public /* synthetic */ PocketQueryListModel(boolean z, ArrayList arrayList, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? new ArrayList() : arrayList, (i2 & 4) != 0 ? -1 : i);
    }
}
