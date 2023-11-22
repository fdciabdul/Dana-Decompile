package androidx.paging;

import androidx.paging.PageEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\u00020\u0001J'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\tJ-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\n\"\b\b\u0002\u0010\u0003*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u00020\u000e\"\b\b\u0002\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\u0005\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u000b\u001a\u00020\u000e\"\b\b\u0002\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00020\b2\u0006\u0010\u0005\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u000e8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0006\u0010\u0014RF\u0010\u001a\u001a4\b\u0001\u0012\u000b\u0012\t\u0018\u00018\u0001¢\u0006\u0002\b\u0017\u0012\u000b\u0012\t\u0018\u00018\u0001¢\u0006\u0002\b\u0017\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016X\u0007ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0006\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u000e8\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u001cX\u0087\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\u001eX\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0012\u0010#\u001a\u00020!X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\"R\u0012\u0010\u001b\u001a\u00020!X\u0087\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0011\u0010\u0015\u001a\u00020$X\u0007¢\u0006\u0006\n\u0004\b#\u0010%R\u001a\u0010\u0011\u001a\u00020\u000e8\u0007X\u0087\u0006¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b\u000b\u0010\u0014R\u0011\u0010(\u001a\u00020\rX\u0007¢\u0006\u0006\n\u0004\b \u0010'\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/SeparatorState;", "", "R", "T", "Landroidx/paging/PageEvent;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/PageEvent$Insert;", "(Landroidx/paging/PageEvent$Insert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/TransformablePage;", "PlaceComponentResult", "(Landroidx/paging/TransformablePage;)Landroidx/paging/TransformablePage;", "Landroidx/paging/TerminalSeparatorType;", "", "getAuthRequestContext", "(Landroidx/paging/PageEvent$Insert;Landroidx/paging/TerminalSeparatorType;)Z", "getErrorConfigVersion", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "moveToNextValue", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "Lkotlin/coroutines/Continuation;", "Lkotlin/jvm/functions/Function3;", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/paging/LoadStates;", "Landroidx/paging/LoadStates;", "", "Ljava/util/List;", "scheduleImpl", "", "I", "lookAheadTest", "Landroidx/paging/MutableLoadStateCollection;", "Landroidx/paging/MutableLoadStateCollection;", "GetContactSyncConfig", "Landroidx/paging/TerminalSeparatorType;", "initRecordTimeStamp"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SeparatorState<R, T extends R> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<TransformablePage<T>> scheduleImpl;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Function3<T, T, Continuation<? super R>, Object> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public int lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public int NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public LoadStates PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final MutableLoadStateCollection moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final TerminalSeparatorType initRecordTimeStamp;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[TerminalSeparatorType.values().length];
            iArr[TerminalSeparatorType.FULLY_COMPLETE.ordinal()] = 1;
            iArr[TerminalSeparatorType.SOURCE_COMPLETE.ordinal()] = 2;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    private boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    private boolean getGetErrorConfigVersion() {
        return this.getErrorConfigVersion;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    private boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    private boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e4, code lost:
    
        if (r3 != false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0167 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(androidx.paging.PageEvent<T> r8, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r9) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.KClassImpl$Data$declaredNonStaticMembers$2(androidx.paging.PageEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x045a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x053e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x05d4  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x066e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0681  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06e4  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06f3  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0754 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0763  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0766  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x076e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0778  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0781  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x07c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x07c4  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x07cd  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x07d5  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x07f4  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x07fc  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0829  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02e6  */
    /* JADX WARN: Type inference failed for: r1v55, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v10, types: [int[]] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:139:0x045b -> B:140:0x0460). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:206:0x066f -> B:17:0x00db). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:232:0x0755 -> B:233:0x0756). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(androidx.paging.PageEvent.Insert<T> r24, kotlin.coroutines.Continuation<? super androidx.paging.PageEvent.Insert<R>> r25) {
        /*
            Method dump skipped, instructions count: 2132
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.KClassImpl$Data$declaredNonStaticMembers$2(androidx.paging.PageEvent$Insert, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static <T> TransformablePage<T> PlaceComponentResult(TransformablePage<T> p0) {
        Integer num;
        int[] iArr = p0.MyBillsEntityDataFactory;
        List listOf = CollectionsKt.listOf(CollectionsKt.first((List) p0.PlaceComponentResult), CollectionsKt.last((List) p0.PlaceComponentResult));
        int i = p0.getAuthRequestContext;
        Integer[] numArr = new Integer[2];
        List<Integer> list = p0.BuiltInFictitiousFunctionClassFactory;
        numArr[0] = Integer.valueOf((list == null || (num = (Integer) CollectionsKt.first((List) list)) == null) ? 0 : num.intValue());
        List<Integer> list2 = p0.BuiltInFictitiousFunctionClassFactory;
        Integer num2 = list2 == null ? null : (Integer) CollectionsKt.last((List) list2);
        numArr[1] = Integer.valueOf(num2 == null ? CollectionsKt.getLastIndex(p0.PlaceComponentResult) : num2.intValue());
        return new TransformablePage<>(iArr, listOf, i, CollectionsKt.listOf((Object[]) numArr));
    }

    private <T> boolean getAuthRequestContext(PageEvent.Insert<T> insert, TerminalSeparatorType terminalSeparatorType) {
        LoadState loadState;
        Intrinsics.checkNotNullParameter(insert, "");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "");
        if (insert.MyBillsEntityDataFactory == LoadType.PREPEND) {
            return this.BuiltInFictitiousFunctionClassFactory;
        }
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[terminalSeparatorType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return insert.getErrorConfigVersion.MyBillsEntityDataFactory.getMyBillsEntityDataFactory();
            }
            throw new NoWhenBranchMatchedException();
        } else if (insert.getErrorConfigVersion.MyBillsEntityDataFactory.getMyBillsEntityDataFactory()) {
            LoadStates loadStates = insert.BuiltInFictitiousFunctionClassFactory;
            return !(loadStates != null && (loadState = loadStates.MyBillsEntityDataFactory) != null && !loadState.getMyBillsEntityDataFactory());
        } else {
            return false;
        }
    }

    private <T> boolean PlaceComponentResult(PageEvent.Insert<T> insert, TerminalSeparatorType terminalSeparatorType) {
        LoadState loadState;
        Intrinsics.checkNotNullParameter(insert, "");
        Intrinsics.checkNotNullParameter(terminalSeparatorType, "");
        if (insert.MyBillsEntityDataFactory == LoadType.APPEND) {
            return this.getErrorConfigVersion;
        }
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[terminalSeparatorType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return insert.getErrorConfigVersion.PlaceComponentResult.getMyBillsEntityDataFactory();
            }
            throw new NoWhenBranchMatchedException();
        } else if (insert.getErrorConfigVersion.PlaceComponentResult.getMyBillsEntityDataFactory()) {
            LoadStates loadStates = insert.BuiltInFictitiousFunctionClassFactory;
            return !(loadStates != null && (loadState = loadStates.PlaceComponentResult) != null && !loadState.getMyBillsEntityDataFactory());
        } else {
            return false;
        }
    }
}
