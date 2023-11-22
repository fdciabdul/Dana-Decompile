package androidx.paging;

import androidx.paging.LegacyPageFetcher;
import androidx.paging.PagingSource;
import id.dana.cashier.view.InputCardNumberView;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\n\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00010\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005:\u0001.B\t\b\u0016¢\u0006\u0004\b+\u0010,B\u0017\b\u0012\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b+\u0010-J\u001a\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJG\u0010\n\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\n\u0010\u0014JA\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0010\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u001aJ%\u0010\n\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ/\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0019\u0010\u001fR\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\"R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00018WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010#R$\u0010\u0017\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u000b0$8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010%R$\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0017@RX\u0097\u000e¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b\n\u0010&R$\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0017@RX\u0097\u000e¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b\u0015\u0010&R\u001c\u0010'\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006@BX\u0087\n¢\u0006\u0006\n\u0004\b\u0015\u0010\"R\u0016\u0010(\u001a\u0004\u0018\u00010\u00018WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010#R\u0014\u0010)\u001a\u00020\u00068WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010&R$\u0010*\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0017@RX\u0097\u000e¢\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b'\u0010&"}, d2 = {"Landroidx/paging/PagedStorage;", "", "T", "Ljava/util/AbstractList;", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "Landroidx/paging/NullPaddedList;", "", "p0", "get", "(I)Ljava/lang/Object;", "getAuthRequestContext", "Landroidx/paging/PagingSource$LoadResult$Page;", "p1", "p2", "p3", "Landroidx/paging/PagedStorage$Callback;", "p4", "", "p5", "", "(ILandroidx/paging/PagingSource$LoadResult$Page;IILandroidx/paging/PagedStorage$Callback;Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILandroidx/paging/PagingSource$LoadResult$Page;IIZ)V", "MyBillsEntityDataFactory", "(III)Z", "BuiltInFictitiousFunctionClassFactory", "(II)Z", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "(ZIILandroidx/paging/PagedStorage$Callback;)Z", "getErrorConfigVersion", "Z", "I", "()Ljava/lang/Object;", "", "Ljava/util/List;", "()I", "scheduleImpl", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "<init>", "()V", "(Landroidx/paging/PagedStorage;)V", "Callback"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class PagedStorage<T> extends AbstractList<T> implements LegacyPageFetcher.KeyProvider<Object>, NullPaddedList<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final List<PagingSource.LoadResult.Page<?, T>> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int scheduleImpl;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    int getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    int PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    int lookAheadTest;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\nJ\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u000b"}, d2 = {"Landroidx/paging/PagedStorage$Callback;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(I)V", "p1", "p2", "getAuthRequestContext", "(III)V", "(II)V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Callback {
        void BuiltInFictitiousFunctionClassFactory(int p0);

        void BuiltInFictitiousFunctionClassFactory(int p0, int p1, int p2);

        void KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1);

        void getAuthRequestContext(int p0, int p1);

        void getAuthRequestContext(int p0, int p1, int p2);
    }

    @Override // androidx.paging.NullPaddedList
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final int getGetErrorConfigVersion() {
        return this.getErrorConfigVersion;
    }

    @Override // androidx.paging.NullPaddedList
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final int getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // androidx.paging.NullPaddedList
    @JvmName(name = "scheduleImpl")
    /* renamed from: scheduleImpl  reason: from getter */
    public final int getLookAheadTest() {
        return this.lookAheadTest;
    }

    public PagedStorage() {
        this.MyBillsEntityDataFactory = new ArrayList();
        this.BuiltInFictitiousFunctionClassFactory = true;
    }

    public PagedStorage(PagedStorage<T> pagedStorage) {
        ArrayList arrayList = new ArrayList();
        this.MyBillsEntityDataFactory = arrayList;
        this.BuiltInFictitiousFunctionClassFactory = true;
        arrayList.addAll(pagedStorage.MyBillsEntityDataFactory);
        this.getErrorConfigVersion = pagedStorage.getErrorConfigVersion;
        this.PlaceComponentResult = pagedStorage.PlaceComponentResult;
        this.scheduleImpl = pagedStorage.scheduleImpl;
        this.BuiltInFictitiousFunctionClassFactory = pagedStorage.BuiltInFictitiousFunctionClassFactory;
        this.lookAheadTest = pagedStorage.lookAheadTest;
        this.getAuthRequestContext = pagedStorage.getAuthRequestContext;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, PagingSource.LoadResult.Page<?, T> p1, int p2, int p3, boolean p4) {
        this.getErrorConfigVersion = p0;
        this.MyBillsEntityDataFactory.clear();
        this.MyBillsEntityDataFactory.add(p1);
        this.PlaceComponentResult = p2;
        this.scheduleImpl = p3;
        this.lookAheadTest = p1.MyBillsEntityDataFactory.size();
        this.BuiltInFictitiousFunctionClassFactory = p4;
        this.getAuthRequestContext = p1.MyBillsEntityDataFactory.size() / 2;
    }

    public final void getAuthRequestContext(int p0, PagingSource.LoadResult.Page<?, T> p1, int p2, int p3, Callback p4, boolean p5) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p4, "");
        KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, p2, p3, p5);
        p4.BuiltInFictitiousFunctionClassFactory(size());
    }

    @Override // androidx.paging.LegacyPageFetcher.KeyProvider
    @JvmName(name = "PlaceComponentResult")
    public final Object PlaceComponentResult() {
        if (!this.BuiltInFictitiousFunctionClassFactory || this.getErrorConfigVersion + this.scheduleImpl > 0) {
            return ((PagingSource.LoadResult.Page) CollectionsKt.first((List) this.MyBillsEntityDataFactory)).getAuthRequestContext;
        }
        return null;
    }

    @Override // androidx.paging.LegacyPageFetcher.KeyProvider
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final Object BuiltInFictitiousFunctionClassFactory() {
        if (!this.BuiltInFictitiousFunctionClassFactory || this.PlaceComponentResult > 0) {
            return ((PagingSource.LoadResult.Page) CollectionsKt.last((List) this.MyBillsEntityDataFactory)).KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return null;
    }

    private final boolean MyBillsEntityDataFactory(int p0, int p1, int p2) {
        return this.lookAheadTest > p0 && this.MyBillsEntityDataFactory.size() > 2 && this.lookAheadTest - this.MyBillsEntityDataFactory.get(p2).MyBillsEntityDataFactory.size() >= p1;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
        return MyBillsEntityDataFactory(p0, p1, 0);
    }

    private boolean BuiltInFictitiousFunctionClassFactory(int p0, int p1) {
        return MyBillsEntityDataFactory(p0, p1, this.MyBillsEntityDataFactory.size() - 1);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(boolean p0, int p1, int p2, Callback p3) {
        Intrinsics.checkNotNullParameter(p3, "");
        int i = 0;
        while (KClassImpl$Data$declaredNonStaticMembers$2(p1, p2)) {
            int size = this.MyBillsEntityDataFactory.remove(0).MyBillsEntityDataFactory.size();
            i += size;
            this.lookAheadTest -= size;
        }
        this.getAuthRequestContext = RangesKt.coerceAtLeast(this.getAuthRequestContext - i, 0);
        if (i > 0) {
            if (!p0) {
                this.scheduleImpl += i;
                p3.getAuthRequestContext(this.getErrorConfigVersion, i);
            } else {
                int i2 = this.getErrorConfigVersion;
                this.getErrorConfigVersion = i2 + i;
                p3.KClassImpl$Data$declaredNonStaticMembers$2(i2, i);
            }
        }
        return i > 0;
    }

    public final boolean PlaceComponentResult(boolean p0, int p1, int p2, Callback p3) {
        Intrinsics.checkNotNullParameter(p3, "");
        int i = 0;
        while (BuiltInFictitiousFunctionClassFactory(p1, p2)) {
            List<PagingSource.LoadResult.Page<?, T>> list = this.MyBillsEntityDataFactory;
            int size = list.remove(list.size() - 1).MyBillsEntityDataFactory.size();
            i += size;
            this.lookAheadTest -= size;
        }
        this.getAuthRequestContext = RangesKt.coerceAtMost(this.getAuthRequestContext, this.lookAheadTest - 1);
        if (i > 0) {
            int i2 = this.getErrorConfigVersion + this.lookAheadTest;
            if (p0) {
                this.PlaceComponentResult += i;
                p3.KClassImpl$Data$declaredNonStaticMembers$2(i2, i);
            } else {
                p3.getAuthRequestContext(i2, i);
            }
        }
        return i > 0;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("leading ");
        sb.append(this.getErrorConfigVersion);
        sb.append(", storage ");
        sb.append(this.lookAheadTest);
        sb.append(", trailing ");
        sb.append(this.PlaceComponentResult);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(CollectionsKt.joinToString$default(this.MyBillsEntityDataFactory, " ", null, null, 0, null, null, 62, null));
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final T get(int p0) {
        int i = p0 - this.getErrorConfigVersion;
        if (p0 < 0 || p0 >= size()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index: ");
            sb.append(p0);
            sb.append(", Size: ");
            sb.append(size());
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i < 0 || i >= this.lookAheadTest) {
            return null;
        } else {
            return getAuthRequestContext(i);
        }
    }

    @Override // androidx.paging.NullPaddedList
    public final T getAuthRequestContext(int p0) {
        int size = this.MyBillsEntityDataFactory.size();
        int i = 0;
        while (i < size) {
            int size2 = this.MyBillsEntityDataFactory.get(i).MyBillsEntityDataFactory.size();
            if (size2 > p0) {
                break;
            }
            p0 -= size2;
            i++;
        }
        return this.MyBillsEntityDataFactory.get(i).MyBillsEntityDataFactory.get(p0);
    }

    @Override // androidx.paging.NullPaddedList
    @JvmName(name = "MyBillsEntityDataFactory")
    public final int MyBillsEntityDataFactory() {
        return this.getErrorConfigVersion + this.lookAheadTest + this.PlaceComponentResult;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int i) {
        return (T) super.remove(i);
    }

    public final boolean getAuthRequestContext(int p0, int p1, int p2) {
        return this.lookAheadTest + p2 > p0 && this.MyBillsEntityDataFactory.size() > 1 && this.lookAheadTest >= p1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return this.getErrorConfigVersion + this.lookAheadTest + this.PlaceComponentResult;
    }
}
