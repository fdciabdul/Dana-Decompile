package androidx.paging;

import kotlin.Metadata;
import kotlin.collections.ArrayDeque;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R \u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0004\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Landroidx/paging/FlattenedPageEventStorage;", "", "T", "Landroidx/paging/LoadStates;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/LoadStates;", "getAuthRequestContext", "Lkotlin/collections/ArrayDeque;", "Landroidx/paging/TransformablePage;", "MyBillsEntityDataFactory", "Lkotlin/collections/ArrayDeque;", "", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "", "Z", "Landroidx/paging/MutableLoadStateCollection;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/paging/MutableLoadStateCollection;", "moveToNextValue", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FlattenedPageEventStorage<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    LoadStates getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    boolean BuiltInFictitiousFunctionClassFactory;
    final ArrayDeque<TransformablePage<T>> MyBillsEntityDataFactory = new ArrayDeque<>();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    final MutableLoadStateCollection moveToNextValue = new MutableLoadStateCollection();
    int PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    int KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[LoadType.values().length];
            iArr[LoadType.PREPEND.ordinal()] = 1;
            iArr[LoadType.APPEND.ordinal()] = 2;
            iArr[LoadType.REFRESH.ordinal()] = 3;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }
}
