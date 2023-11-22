package androidx.paging;

import androidx.paging.PageEvent;
import androidx.paging.ViewportHint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001e*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\u001e\u001fB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u0004*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R$\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0017@RX\u0096\u000e¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\f\u0010\u0018R$\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0017@RX\u0097\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\n\u0010\u0018R\u0014\u0010\n\u001a\u00020\u00048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0017@RX\u0097\u000e¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001a\u0010\u0018"}, d2 = {"Landroidx/paging/PagePresenter;", "", "T", "Landroidx/paging/NullPaddedList;", "", "p0", "Landroidx/paging/ViewportHint$Access;", "PlaceComponentResult", "(I)Landroidx/paging/ViewportHint$Access;", "Lkotlin/ranges/IntRange;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/ranges/IntRange;)I", "getAuthRequestContext", "(I)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "", "Landroidx/paging/TransformablePage;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)I", "", "Ljava/util/List;", "I", "()I", "MyBillsEntityDataFactory", "scheduleImpl", "Landroidx/paging/PageEvent$Insert;", "<init>", "(Landroidx/paging/PageEvent$Insert;)V", "Companion", "ProcessPageEventCallback"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PagePresenter<T> implements NullPaddedList<T> {
    private static final PagePresenter<Object> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    int PlaceComponentResult;
    int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final List<TransformablePage<T>> BuiltInFictitiousFunctionClassFactory;
    int getAuthRequestContext;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007J!\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "", "", "p0", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(II)V", "MyBillsEntityDataFactory", "getAuthRequestContext", "Landroidx/paging/LoadStates;", "PlaceComponentResult", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "Landroidx/paging/LoadType;", "", "Landroidx/paging/LoadState;", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface ProcessPageEventCallback {
        void BuiltInFictitiousFunctionClassFactory(int p0, int p1);

        void KClassImpl$Data$declaredNonStaticMembers$2(LoadType loadType, LoadState loadState);

        void MyBillsEntityDataFactory(int p0, int p1);

        void PlaceComponentResult(LoadStates p0, LoadStates p1);

        void getAuthRequestContext(int p0, int p1);
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.REFRESH.ordinal()] = 1;
            iArr[LoadType.PREPEND.ordinal()] = 2;
            iArr[LoadType.APPEND.ordinal()] = 3;
            getAuthRequestContext = iArr;
        }
    }

    public PagePresenter(PageEvent.Insert<T> insert) {
        Intrinsics.checkNotNullParameter(insert, "");
        this.BuiltInFictitiousFunctionClassFactory = CollectionsKt.toMutableList((Collection) insert.getAuthRequestContext);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory(insert.getAuthRequestContext);
        this.MyBillsEntityDataFactory = insert.KClassImpl$Data$declaredNonStaticMembers$2;
        this.PlaceComponentResult = insert.PlaceComponentResult;
    }

    @Override // androidx.paging.NullPaddedList
    @JvmName(name = "scheduleImpl")
    /* renamed from: scheduleImpl  reason: from getter */
    public final int getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // androidx.paging.NullPaddedList
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final int getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // androidx.paging.NullPaddedList
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final int getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // androidx.paging.NullPaddedList
    public final T getAuthRequestContext(int p0) {
        int size = this.BuiltInFictitiousFunctionClassFactory.size();
        int i = 0;
        while (i < size) {
            int size2 = this.BuiltInFictitiousFunctionClassFactory.get(i).PlaceComponentResult.size();
            if (size2 > p0) {
                break;
            }
            p0 -= size2;
            i++;
        }
        return this.BuiltInFictitiousFunctionClassFactory.get(i).PlaceComponentResult.get(p0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int BuiltInFictitiousFunctionClassFactory(List<TransformablePage<T>> list) {
        Iterator<T> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((TransformablePage) it.next()).PlaceComponentResult.size();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int KClassImpl$Data$declaredNonStaticMembers$2(IntRange p0) {
        boolean z;
        Iterator<TransformablePage<T>> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        int i = 0;
        while (it.hasNext()) {
            TransformablePage<T> next = it.next();
            int[] iArr = next.MyBillsEntityDataFactory;
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                } else if (p0.contains(iArr[i2])) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                i += next.PlaceComponentResult.size();
                it.remove();
            }
        }
        return i;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\b\b\u0001\u0010\u0002*\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/paging/PagePresenter$Companion;", "", "T", "Landroidx/paging/PagePresenter;", "MyBillsEntityDataFactory", "()Landroidx/paging/PagePresenter;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/PagePresenter;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static <T> PagePresenter<T> MyBillsEntityDataFactory() {
            return PagePresenter.BuiltInFictitiousFunctionClassFactory;
        }
    }

    static {
        PageEvent.Insert.Companion companion = PageEvent.Insert.INSTANCE;
        BuiltInFictitiousFunctionClassFactory = new PagePresenter<>(PageEvent.Insert.Companion.getAuthRequestContext());
    }

    public final ViewportHint.Access PlaceComponentResult(int p0) {
        int i = 0;
        int i2 = p0 - this.MyBillsEntityDataFactory;
        while (i2 >= this.BuiltInFictitiousFunctionClassFactory.get(i).PlaceComponentResult.size() && i < CollectionsKt.getLastIndex(this.BuiltInFictitiousFunctionClassFactory)) {
            i2 -= this.BuiltInFictitiousFunctionClassFactory.get(i).PlaceComponentResult.size();
            i++;
        }
        TransformablePage<T> transformablePage = this.BuiltInFictitiousFunctionClassFactory.get(i);
        int i3 = this.MyBillsEntityDataFactory;
        int i4 = this.getAuthRequestContext + i3;
        int i5 = this.PlaceComponentResult;
        Integer minOrNull = ArraysKt.minOrNull(((TransformablePage) CollectionsKt.first((List) this.BuiltInFictitiousFunctionClassFactory)).MyBillsEntityDataFactory);
        Intrinsics.checkNotNull(minOrNull);
        int intValue = minOrNull.intValue();
        Integer maxOrNull = ArraysKt.maxOrNull(((TransformablePage) CollectionsKt.last((List) this.BuiltInFictitiousFunctionClassFactory)).MyBillsEntityDataFactory);
        Intrinsics.checkNotNull(maxOrNull);
        return transformablePage.BuiltInFictitiousFunctionClassFactory(i2, p0 - i3, (((i4 + i5) - p0) - i5) - 1, intValue, maxOrNull.intValue());
    }

    @Override // androidx.paging.NullPaddedList
    @JvmName(name = "MyBillsEntityDataFactory")
    public final int MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory + this.getAuthRequestContext + this.PlaceComponentResult;
    }

    public final String toString() {
        int i = this.getAuthRequestContext;
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(getAuthRequestContext(i2));
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
        StringBuilder sb = new StringBuilder();
        sb.append("[(");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(" placeholders), ");
        sb.append(joinToString$default);
        sb.append(", (");
        sb.append(this.PlaceComponentResult);
        sb.append(" placeholders)]");
        return sb.toString();
    }
}
