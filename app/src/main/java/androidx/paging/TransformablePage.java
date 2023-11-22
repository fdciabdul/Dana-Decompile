package androidx.paging;

import androidx.paging.ViewportHint;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0080\b\u0018\u0000  *\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001 B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u001d\u0010\u001eB5\u0012\u0006\u0010\u0003\u001a\u00020\u001b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0004\b\u001d\u0010\u001fJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R\u0011\u0010\u0018\u001a\u00020\u001bX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001c"}, d2 = {"Landroidx/paging/TransformablePage;", "", "T", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "p1", "p2", "p3", "p4", "Landroidx/paging/ViewportHint$Access;", "BuiltInFictitiousFunctionClassFactory", "(IIIII)Landroidx/paging/ViewportHint$Access;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "PlaceComponentResult", "MyBillsEntityDataFactory", "I", "getAuthRequestContext", "", "[I", "<init>", "(ILjava/util/List;)V", "([ILjava/util/List;ILjava/util/List;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TransformablePage<T> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final List<T> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final List<Integer> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final int[] MyBillsEntityDataFactory;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TransformablePage<Object> BuiltInFictitiousFunctionClassFactory = new TransformablePage<>(0, CollectionsKt.emptyList());

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransformablePage(MyBillsEntityDataFactory=");
        sb.append(Arrays.toString(this.MyBillsEntityDataFactory));
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransformablePage(int[] iArr, List<? extends T> list, int i, List<Integer> list2) {
        Intrinsics.checkNotNullParameter(iArr, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.MyBillsEntityDataFactory = iArr;
        this.PlaceComponentResult = list;
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = list2;
        if ((!(iArr.length == 0)) == false) {
            throw new IllegalArgumentException("originalPageOffsets cannot be empty when constructing TransformablePage".toString());
        }
        if (list2 == null || list2.size() == list.size()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("If originalIndices (size = ");
        List<Integer> list3 = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNull(list3);
        sb.append(list3.size());
        sb.append(") is provided, it must be same length as data (size = ");
        sb.append(this.PlaceComponentResult.size());
        sb.append(')');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TransformablePage(int i, List<? extends T> list) {
        this(new int[]{i}, list, i, null);
        Intrinsics.checkNotNullParameter(list, "");
    }

    public final ViewportHint.Access BuiltInFictitiousFunctionClassFactory(int p0, int p1, int p2, int p3, int p4) {
        IntRange indices;
        int i = this.getAuthRequestContext;
        List<Integer> list = this.BuiltInFictitiousFunctionClassFactory;
        if ((list == null || (indices = CollectionsKt.getIndices(list)) == null || !indices.contains(p0)) ? false : true) {
            p0 = this.BuiltInFictitiousFunctionClassFactory.get(p0).intValue();
        }
        return new ViewportHint.Access(i, p0, p1, p2, p3, p4);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), p0 == null ? null : p0.getClass())) {
            if (p0 != null) {
                TransformablePage transformablePage = (TransformablePage) p0;
                return Arrays.equals(this.MyBillsEntityDataFactory, transformablePage.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, transformablePage.PlaceComponentResult) && this.getAuthRequestContext == transformablePage.getAuthRequestContext && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, transformablePage.BuiltInFictitiousFunctionClassFactory);
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.TransformablePage<*>");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.MyBillsEntityDataFactory);
        int hashCode2 = this.PlaceComponentResult.hashCode();
        int i = this.getAuthRequestContext;
        List<Integer> list = this.BuiltInFictitiousFunctionClassFactory;
        return (((((hashCode * 31) + hashCode2) * 31) + i) * 31) + (list == null ? 0 : list.hashCode());
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/paging/TransformablePage$Companion;", "", "Landroidx/paging/TransformablePage;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/TransformablePage;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroidx/paging/TransformablePage;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
