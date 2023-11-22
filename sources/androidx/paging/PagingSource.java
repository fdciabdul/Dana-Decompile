package androidx.paging;

import com.google.common.net.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\bH¦@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\n\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/PagingSource;", "", "Key", "Value", "Landroidx/paging/PagingState;", "p0", "PlaceComponentResult", "(Landroidx/paging/PagingState;)Ljava/lang/Object;", "Landroidx/paging/PagingSource$LoadParams;", "Landroidx/paging/PagingSource$LoadResult;", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "MyBillsEntityDataFactory", "()Z", "Landroidx/paging/InvalidateCallbackTracker;", "Lkotlin/Function0;", "", "Landroidx/paging/InvalidateCallbackTracker;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V", "LoadParams", "LoadResult"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PagingSource<Key, Value> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final InvalidateCallbackTracker<Function0<Unit>> MyBillsEntityDataFactory;

    public abstract Object BuiltInFictitiousFunctionClassFactory(LoadParams<Key> loadParams, Continuation<? super LoadResult<Key, Value>> continuation);

    public abstract Key PlaceComponentResult(PagingState<Key, Value> p0);

    @JvmName(name = "getAuthRequestContext")
    public boolean getAuthRequestContext() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
    public PagingSource() {
        ?? r2 = 0;
        this.MyBillsEntityDataFactory = new InvalidateCallbackTracker<>(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.paging.PagingSource$invalidateCallbackTracker$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                invoke2((Function0<Unit>) function0);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Function0<Unit> function0) {
                Intrinsics.checkNotNullParameter(function0, "");
                function0.invoke();
            }
        }, r2, 2, r2);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000 \u0011*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001:\u0004\u0012\u0011\u0013\u0014B\u0019\b\u0004\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00018\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0003\u0015\u0016\u0017"}, d2 = {"Landroidx/paging/PagingSource$LoadParams;", "", "Key", "PlaceComponentResult", "()Ljava/lang/Object;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getAuthRequestContext", "I", "", "Z", "MyBillsEntityDataFactory", "()Z", "p0", "p1", "<init>", "(IZ)V", "Companion", "Append", "Prepend", HttpHeaders.REFRESH, "Landroidx/paging/PagingSource$LoadParams$Refresh;", "Landroidx/paging/PagingSource$LoadParams$Append;", "Landroidx/paging/PagingSource$LoadParams$Prepend;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadParams<Key> {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean MyBillsEntityDataFactory;
        public final int getAuthRequestContext;

        public /* synthetic */ LoadParams(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z);
        }

        @JvmName(name = "PlaceComponentResult")
        public abstract Key PlaceComponentResult();

        private LoadParams(int i, boolean z) {
            this.getAuthRequestContext = i;
            this.MyBillsEntityDataFactory = z;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00030\u0003B!\u0012\b\u0010\b\u001a\u0004\u0018\u00018\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00018\u00038\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Refresh;", "", "Key", "Landroidx/paging/PagingSource$LoadParams;", "PlaceComponentResult", "Ljava/lang/Object;", "()Ljava/lang/Object;", "getAuthRequestContext", "p0", "", "p1", "", "p2", "<init>", "(Ljava/lang/Object;IZ)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Refresh<Key> extends LoadParams<Key> {

            /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
            private final Key getAuthRequestContext;

            @Override // androidx.paging.PagingSource.LoadParams
            @JvmName(name = "PlaceComponentResult")
            public final Key PlaceComponentResult() {
                return this.getAuthRequestContext;
            }

            public Refresh(Key key, int i, boolean z) {
                super(i, z, null);
                this.getAuthRequestContext = key;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00030\u0003B\u001f\u0012\u0006\u0010\b\u001a\u00028\u0003\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00028\u00038\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Append;", "", "Key", "Landroidx/paging/PagingSource$LoadParams;", "PlaceComponentResult", "Ljava/lang/Object;", "()Ljava/lang/Object;", "BuiltInFictitiousFunctionClassFactory", "p0", "", "p1", "", "p2", "<init>", "(Ljava/lang/Object;IZ)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Append<Key> extends LoadParams<Key> {

            /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
            private final Key BuiltInFictitiousFunctionClassFactory;

            @Override // androidx.paging.PagingSource.LoadParams
            @JvmName(name = "PlaceComponentResult")
            public final Key PlaceComponentResult() {
                return this.BuiltInFictitiousFunctionClassFactory;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Append(Key key, int i, boolean z) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(key, "");
                this.BuiltInFictitiousFunctionClassFactory = key;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\b\b\u0003\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00030\u0003B\u001f\u0012\u0006\u0010\t\u001a\u00028\u0003\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00028\u00038\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Prepend;", "", "Key", "Landroidx/paging/PagingSource$LoadParams;", "MyBillsEntityDataFactory", "Ljava/lang/Object;", "PlaceComponentResult", "()Ljava/lang/Object;", "getAuthRequestContext", "p0", "", "p1", "", "p2", "<init>", "(Ljava/lang/Object;IZ)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Prepend<Key> extends LoadParams<Key> {

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            private final Key getAuthRequestContext;

            @Override // androidx.paging.PagingSource.LoadParams
            @JvmName(name = "PlaceComponentResult")
            public final Key PlaceComponentResult() {
                return this.getAuthRequestContext;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Prepend(Key key, int i, boolean z) {
                super(i, z, null);
                Intrinsics.checkNotNullParameter(key, "");
                this.getAuthRequestContext = key;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00030\n\"\b\b\u0003\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/paging/PagingSource$LoadParams$Companion;", "", "Key", "Landroidx/paging/LoadType;", "p0", "p1", "", "p2", "", "p3", "Landroidx/paging/PagingSource$LoadParams;", "getAuthRequestContext", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZ)Landroidx/paging/PagingSource$LoadParams;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {

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

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static <Key> LoadParams<Key> getAuthRequestContext(LoadType p0, Key p1, int p2, boolean p3) {
                Intrinsics.checkNotNullParameter(p0, "");
                int i = WhenMappings.getAuthRequestContext[p0.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        if (p1 != null) {
                            return new Prepend(p1, p2, p3);
                        }
                        throw new IllegalArgumentException("key cannot be null for prepend".toString());
                    } else if (i == 3) {
                        if (p1 != null) {
                            return new Append(p1, p2, p3);
                        }
                        throw new IllegalArgumentException("key cannot be null for append".toString());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return new Refresh(p1, p2, p3);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001:\u0003\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b"}, d2 = {"Landroidx/paging/PagingSource$LoadResult;", "", "Key", "Value", "<init>", "()V", "Error", "Invalid", "Page", "Landroidx/paging/PagingSource$LoadResult$Error;", "Landroidx/paging/PagingSource$LoadResult$Invalid;", "Landroidx/paging/PagingSource$LoadResult$Page;"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class LoadResult<Key, Value> {

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0086\b\u0018\u0000*\b\b\u0004\u0010\u0002*\u00020\u0001*\b\b\u0005\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0004J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Error;", "", "Key", "Value", "Landroidx/paging/PagingSource$LoadResult;", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Throwable;", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final /* data */ class Error<Key, Value> extends LoadResult<Key, Value> {

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            final Throwable BuiltInFictitiousFunctionClassFactory;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                return (p0 instanceof Error) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((Error) p0).BuiltInFictitiousFunctionClassFactory);
            }

            public final int hashCode() {
                return this.BuiltInFictitiousFunctionClassFactory.hashCode();
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Error(BuiltInFictitiousFunctionClassFactory=");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append(')');
                return sb.toString();
            }
        }

        public /* synthetic */ LoadResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private LoadResult() {
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0004\u0010\u0002*\u00020\u0001*\b\b\u0005\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Invalid;", "", "Key", "Value", "Landroidx/paging/PagingSource$LoadResult;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Invalid<Key, Value> extends LoadResult<Key, Value> {
            public Invalid() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u001f*\b\b\u0004\u0010\u0002*\u00020\u0001*\b\b\u0005\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u0004:\u0001\u001fB+\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00050\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0004¢\u0006\u0004\b\u001a\u0010\u001bB=\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00050\u000f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00018\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00018\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001eJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00050\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00018\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0013\u0010\u0013\u001a\u0004\u0018\u00018\u0004X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Page;", "", "Key", "Value", "Landroidx/paging/PagingSource$LoadResult;", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "PlaceComponentResult", "Ljava/util/List;", "MyBillsEntityDataFactory", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Object;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "<init>", "(Ljava/util/List;Ljava/lang/Object;)V", "p3", "p4", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final /* data */ class Page<Key, Value> extends LoadResult<Key, Value> {

            /* renamed from: Companion  reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private static final Page scheduleImpl = new Page(CollectionsKt.emptyList(), null, null, 0, 0);
            final int BuiltInFictitiousFunctionClassFactory;

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            final Key getAuthRequestContext;

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            final Key KClassImpl$Data$declaredNonStaticMembers$2;

            /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
            final List<Value> MyBillsEntityDataFactory;

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            final int PlaceComponentResult;

            public final boolean equals(Object p0) {
                if (this == p0) {
                    return true;
                }
                if (p0 instanceof Page) {
                    Page page = (Page) p0;
                    return Intrinsics.areEqual(this.MyBillsEntityDataFactory, page.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, page.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, page.KClassImpl$Data$declaredNonStaticMembers$2) && this.BuiltInFictitiousFunctionClassFactory == page.BuiltInFictitiousFunctionClassFactory && this.PlaceComponentResult == page.PlaceComponentResult;
                }
                return false;
            }

            public final int hashCode() {
                int hashCode = this.MyBillsEntityDataFactory.hashCode();
                Key key = this.getAuthRequestContext;
                int hashCode2 = key == null ? 0 : key.hashCode();
                Key key2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                return (((((((hashCode * 31) + hashCode2) * 31) + (key2 != null ? key2.hashCode() : 0)) * 31) + this.BuiltInFictitiousFunctionClassFactory) * 31) + this.PlaceComponentResult;
            }

            public final String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("Page(MyBillsEntityDataFactory=");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append(", getAuthRequestContext=");
                sb.append(this.getAuthRequestContext);
                sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(", BuiltInFictitiousFunctionClassFactory=");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append(", PlaceComponentResult=");
                sb.append(this.PlaceComponentResult);
                sb.append(')');
                return sb.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Page(List<? extends Value> list, Key key, Key key2, int i, int i2) {
                super(null);
                Intrinsics.checkNotNullParameter(list, "");
                this.MyBillsEntityDataFactory = list;
                this.getAuthRequestContext = key;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = key2;
                this.BuiltInFictitiousFunctionClassFactory = i;
                this.PlaceComponentResult = i2;
                if (!(i == Integer.MIN_VALUE || i >= 0)) {
                    throw new IllegalArgumentException("itemsBefore cannot be negative".toString());
                }
                if (!(i2 == Integer.MIN_VALUE || i2 >= 0)) {
                    throw new IllegalArgumentException("itemsAfter cannot be negative".toString());
                }
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public Page(List<? extends Value> list, Key key) {
                this(list, null, key, Integer.MIN_VALUE, Integer.MIN_VALUE);
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroidx/paging/PagingSource$LoadResult$Page$Companion;", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "", "scheduleImpl", "Landroidx/paging/PagingSource$LoadResult$Page;", "MyBillsEntityDataFactory", "()Landroidx/paging/PagingSource$LoadResult$Page;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* loaded from: classes3.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }

                @JvmName(name = "MyBillsEntityDataFactory")
                public static Page MyBillsEntityDataFactory() {
                    return Page.scheduleImpl;
                }
            }
        }
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final boolean MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory.getMyBillsEntityDataFactory();
    }
}
