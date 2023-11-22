package androidx.paging;

import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0012\u0010\f\u001a\u00020\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0012\u0010\r\u001a\u00020\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b"}, d2 = {"Landroidx/paging/MutableLoadStateCollection;", "", "Landroidx/paging/LoadType;", "p0", "Landroidx/paging/LoadState;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/LoadType;)Landroidx/paging/LoadState;", "p1", "", "getAuthRequestContext", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)V", "Landroidx/paging/LoadState;", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MutableLoadStateCollection {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public LoadState PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public LoadState MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public LoadState BuiltInFictitiousFunctionClassFactory;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.REFRESH.ordinal()] = 1;
            iArr[LoadType.APPEND.ordinal()] = 2;
            iArr[LoadType.PREPEND.ordinal()] = 3;
            MyBillsEntityDataFactory = iArr;
        }
    }

    public MutableLoadStateCollection() {
        LoadState.NotLoading notLoading;
        LoadState.NotLoading notLoading2;
        LoadState.NotLoading notLoading3;
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
        notLoading = LoadState.NotLoading.getAuthRequestContext;
        this.PlaceComponentResult = notLoading;
        LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
        notLoading2 = LoadState.NotLoading.getAuthRequestContext;
        this.MyBillsEntityDataFactory = notLoading2;
        LoadState.NotLoading.Companion companion3 = LoadState.NotLoading.INSTANCE;
        notLoading3 = LoadState.NotLoading.getAuthRequestContext;
        this.BuiltInFictitiousFunctionClassFactory = notLoading3;
    }

    public final LoadState KClassImpl$Data$declaredNonStaticMembers$2(LoadType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int i = WhenMappings.MyBillsEntityDataFactory[p0.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return this.MyBillsEntityDataFactory;
                }
                throw new NoWhenBranchMatchedException();
            }
            return this.BuiltInFictitiousFunctionClassFactory;
        }
        return this.PlaceComponentResult;
    }

    public final void getAuthRequestContext(LoadType p0, LoadState p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        int i = WhenMappings.MyBillsEntityDataFactory[p0.ordinal()];
        if (i == 1) {
            this.PlaceComponentResult = p1;
        } else if (i == 2) {
            this.BuiltInFictitiousFunctionClassFactory = p1;
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.MyBillsEntityDataFactory = p1;
        }
    }
}
