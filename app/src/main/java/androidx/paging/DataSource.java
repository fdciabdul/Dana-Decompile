package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \u001f*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001:\u0006 \u001f!\"#$B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H ¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\fH @ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000eJE\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0000\"\b\b\u0002\u0010\u000f*\u00020\u00012\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\n\u0010\u0012J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0012\u0010\u0007\u001a\u00020\u0016X\u0090@¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0017\u001a\u00020\u00168WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0019R\u0012\u0010\n\u001a\u00020\u0016X\u0091@¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u001aX\u0001¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/DataSource;", "", "Key", "Value", "Landroidx/paging/DataSource$InvalidatedCallback;", "p0", "", "PlaceComponentResult", "(Landroidx/paging/DataSource$InvalidatedCallback;)V", "(Ljava/lang/Object;)Ljava/lang/Object;", "MyBillsEntityDataFactory", "()V", "Landroidx/paging/DataSource$Params;", "Landroidx/paging/DataSource$BaseResult;", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ToValue", "Landroidx/arch/core/util/Function;", "", "(Landroidx/arch/core/util/Function;)Landroidx/paging/DataSource;", "Landroidx/paging/InvalidateCallbackTracker;", "Landroidx/paging/InvalidateCallbackTracker;", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "()Z", "Landroidx/paging/DataSource$KeyType;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/DataSource$KeyType;", "<init>", "(Landroidx/paging/DataSource$KeyType;)V", "Companion", "BaseResult", "Factory", "InvalidatedCallback", "KeyType", "Params"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DataSource<Key, Value> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    final KeyType BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final boolean PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final InvalidateCallbackTracker<InvalidatedCallback> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final boolean MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u0001*\b\b\u0003\u0010\u0003*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/paging/DataSource$Factory;", "", "Key", "Value", "Landroidx/paging/DataSource;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/paging/DataSource;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Factory<Key, Value> {
        public abstract DataSource<Key, Value> BuiltInFictitiousFunctionClassFactory();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/paging/DataSource$InvalidatedCallback;", "", "", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface InvalidatedCallback {
        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Landroidx/paging/DataSource$KeyType;", "", "<init>", "(Ljava/lang/String;I)V", "POSITIONAL", "PAGE_KEYED", "ITEM_KEYED"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public enum KeyType {
        POSITIONAL,
        PAGE_KEYED,
        ITEM_KEYED
    }

    public abstract Object MyBillsEntityDataFactory(Params<Key> params, Continuation<? super BaseResult<Value>> continuation);

    public abstract Key PlaceComponentResult(Value p0);

    public DataSource(KeyType keyType) {
        Intrinsics.checkNotNullParameter(keyType, "");
        this.BuiltInFictitiousFunctionClassFactory = keyType;
        this.getAuthRequestContext = new InvalidateCallbackTracker<>(new Function1<InvalidatedCallback, Unit>() { // from class: androidx.paging.DataSource$invalidateCallbackTracker$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DataSource.InvalidatedCallback invalidatedCallback) {
                invoke2(invalidatedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DataSource.InvalidatedCallback invalidatedCallback) {
                Intrinsics.checkNotNullParameter(invalidatedCallback, "");
                invalidatedCallback.getAuthRequestContext();
            }
        }, new Function0<Boolean>(this) { // from class: androidx.paging.DataSource$invalidateCallbackTracker$2
            final /* synthetic */ DataSource<Key, Value> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(this.this$0.PlaceComponentResult());
            }
        });
        this.PlaceComponentResult = true;
        this.MyBillsEntityDataFactory = true;
    }

    @JvmName(name = "PlaceComponentResult")
    public boolean PlaceComponentResult() {
        return this.getAuthRequestContext.getMyBillsEntityDataFactory();
    }

    public <ToValue> DataSource<Key, ToValue> MyBillsEntityDataFactory(Function<List<Value>, List<ToValue>> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new WrapperDataSource(this, p0);
    }

    public void PlaceComponentResult(InvalidatedCallback p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    public void MyBillsEntityDataFactory(InvalidatedCallback p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.MyBillsEntityDataFactory(p0);
    }

    public void MyBillsEntityDataFactory() {
        this.getAuthRequestContext.getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001B3\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00018\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0017\u0010\f\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u000eX\u0001¢\u0006\u0006\n\u0004\b\f\u0010\u000f"}, d2 = {"Landroidx/paging/DataSource$Params;", "", DiskFormatter.KB, "", "MyBillsEntityDataFactory", "I", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Object;", "getAuthRequestContext", "PlaceComponentResult", "", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadType;", "p0", "p1", "p2", "p3", "p4", "<init>", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZI)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Params<K> {
        final K BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final LoadType getAuthRequestContext;
        final int MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final int PlaceComponentResult;

        public Params(LoadType loadType, K k, int i, boolean z, int i2) {
            Intrinsics.checkNotNullParameter(loadType, "");
            this.getAuthRequestContext = loadType;
            this.BuiltInFictitiousFunctionClassFactory = k;
            this.MyBillsEntityDataFactory = i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.PlaceComponentResult = i2;
            if (loadType != LoadType.REFRESH && k == null) {
                throw new IllegalArgumentException("Key must be non-null for prepend/append");
            }
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0000\u0018\u0000 \u0017*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u0017B?\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00078\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0001X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u0010"}, d2 = {"Landroidx/paging/DataSource$BaseResult;", "", "Value", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "MyBillsEntityDataFactory", "PlaceComponentResult", "getAuthRequestContext", "Ljava/lang/Object;", "p1", "p2", "p3", "p4", "<init>", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class BaseResult<Value> {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public final List<Value> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final int MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final Object KClassImpl$Data$declaredNonStaticMembers$2;
        final int PlaceComponentResult;
        final Object getAuthRequestContext;

        /* JADX WARN: Multi-variable type inference failed */
        public BaseResult(List<? extends Value> list, Object obj, Object obj2, int i, int i2) {
            Intrinsics.checkNotNullParameter(list, "");
            this.BuiltInFictitiousFunctionClassFactory = list;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
            this.getAuthRequestContext = obj2;
            this.PlaceComponentResult = i;
            this.MyBillsEntityDataFactory = i2;
            if (i < 0 && i != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("Position must be non-negative");
            }
            if (list.isEmpty() && (i > 0 || i2 > 0)) {
                throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            }
            if (i2 < 0 && i2 != Integer.MIN_VALUE) {
                throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            }
        }

        public /* synthetic */ BaseResult(List list, Object obj, Object obj2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, obj, obj2, (i3 & 8) != 0 ? Integer.MIN_VALUE : i, (i3 & 16) != 0 ? Integer.MIN_VALUE : i2);
        }

        public final boolean equals(Object p0) {
            if (p0 instanceof BaseResult) {
                BaseResult baseResult = (BaseResult) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, baseResult.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, baseResult.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, baseResult.getAuthRequestContext) && this.PlaceComponentResult == baseResult.PlaceComponentResult && this.MyBillsEntityDataFactory == baseResult.MyBillsEntityDataFactory;
            }
            return false;
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJW\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00040\u0004\"\b\b\u0003\u0010\u0002*\u00020\u0001\"\b\b\u0004\u0010\u0003*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00030\u00042\u001e\u0010\b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u00070\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00030\u0004\"\b\b\u0003\u0010\u000b*\u00020\u0001H\u0000¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Landroidx/paging/DataSource$BaseResult$Companion;", "", "ToValue", "Value", "Landroidx/paging/DataSource$BaseResult;", "p0", "Landroidx/arch/core/util/Function;", "", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/DataSource$BaseResult;Landroidx/arch/core/util/Function;)Landroidx/paging/DataSource$BaseResult;", "T", "PlaceComponentResult", "()Landroidx/paging/DataSource$BaseResult;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public static <T> BaseResult<T> PlaceComponentResult() {
                return new BaseResult<>(CollectionsKt.emptyList(), null, null, 0, 0);
            }

            public static <ToValue, Value> BaseResult<Value> KClassImpl$Data$declaredNonStaticMembers$2(BaseResult<ToValue> p0, Function<List<ToValue>, List<Value>> p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Companion companion = DataSource.INSTANCE;
                return new BaseResult<>(Companion.PlaceComponentResult(p1, p0.BuiltInFictitiousFunctionClassFactory), p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.getAuthRequestContext, p0.PlaceComponentResult, p0.MyBillsEntityDataFactory);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJO\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00030\u0005\"\u0004\b\u0002\u0010\u0002\"\u0004\b\u0003\u0010\u00032\u001e\u0010\u0006\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroidx/paging/DataSource$Companion;", "", "A", DiskFormatter.B, "Landroidx/arch/core/util/Function;", "", "p0", "p1", "PlaceComponentResult", "(Landroidx/arch/core/util/Function;Ljava/util/List;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <A, B> List<B> PlaceComponentResult(Function<List<A>, List<B>> p0, List<? extends A> p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            List<B> authRequestContext = p0.getAuthRequestContext(p1);
            if (authRequestContext.size() != p1.size()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid Function ");
                sb.append(p0);
                sb.append(" changed return size. This is not supported.");
                throw new IllegalStateException(sb.toString());
            }
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            return authRequestContext;
        }
    }
}
