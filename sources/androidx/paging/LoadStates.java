package androidx.paging;

import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e"}, d2 = {"Landroidx/paging/LoadStates;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroidx/paging/LoadState;", "MyBillsEntityDataFactory", "Landroidx/paging/LoadState;", "PlaceComponentResult", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "<init>", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class LoadStates {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LoadStates KClassImpl$Data$declaredNonStaticMembers$2;
    final LoadState MyBillsEntityDataFactory;
    final LoadState PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final LoadState BuiltInFictitiousFunctionClassFactory;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.APPEND.ordinal()] = 1;
            iArr[LoadType.PREPEND.ordinal()] = 2;
            iArr[LoadType.REFRESH.ordinal()] = 3;
            MyBillsEntityDataFactory = iArr;
        }
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof LoadStates) {
            LoadStates loadStates = (LoadStates) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, loadStates.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, loadStates.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, loadStates.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoadStates(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public LoadStates(LoadState loadState, LoadState loadState2, LoadState loadState3) {
        Intrinsics.checkNotNullParameter(loadState, "");
        Intrinsics.checkNotNullParameter(loadState2, "");
        Intrinsics.checkNotNullParameter(loadState3, "");
        this.BuiltInFictitiousFunctionClassFactory = loadState;
        this.PlaceComponentResult = loadState2;
        this.MyBillsEntityDataFactory = loadState3;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/paging/LoadStates$Companion;", "", "Landroidx/paging/LoadStates;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/paging/LoadStates;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/paging/LoadStates;", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        public static LoadStates BuiltInFictitiousFunctionClassFactory() {
            return LoadStates.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    static {
        LoadState.NotLoading notLoading;
        LoadState.NotLoading notLoading2;
        LoadState.NotLoading notLoading3;
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
        notLoading = LoadState.NotLoading.getAuthRequestContext;
        LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
        notLoading2 = LoadState.NotLoading.getAuthRequestContext;
        LoadState.NotLoading.Companion companion3 = LoadState.NotLoading.INSTANCE;
        notLoading3 = LoadState.NotLoading.getAuthRequestContext;
        KClassImpl$Data$declaredNonStaticMembers$2 = new LoadStates(notLoading, notLoading2, notLoading3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ LoadStates BuiltInFictitiousFunctionClassFactory(LoadStates loadStates, LoadState loadState, LoadState loadState2, LoadState loadState3, int i) {
        if ((i & 1) != 0) {
            loadState = loadStates.BuiltInFictitiousFunctionClassFactory;
        }
        if ((i & 2) != 0) {
            loadState2 = loadStates.PlaceComponentResult;
        }
        if ((i & 4) != 0) {
            loadState3 = loadStates.MyBillsEntityDataFactory;
        }
        Intrinsics.checkNotNullParameter(loadState, "");
        Intrinsics.checkNotNullParameter(loadState2, "");
        Intrinsics.checkNotNullParameter(loadState3, "");
        return new LoadStates(loadState, loadState2, loadState3);
    }
}
