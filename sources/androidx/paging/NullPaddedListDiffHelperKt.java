package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a?\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\f\u0010\r\u001a3\u0010\u000f\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"", "T", "Landroidx/paging/NullPaddedList;", "p0", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "p1", "Landroidx/paging/NullPaddedDiffResult;", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)Landroidx/paging/NullPaddedDiffResult;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "p2", "", "PlaceComponentResult", "(Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedDiffResult;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedDiffResult;Landroidx/paging/NullPaddedList;I)I"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NullPaddedListDiffHelperKt {
    public static final <T> NullPaddedDiffResult BuiltInFictitiousFunctionClassFactory(final NullPaddedList<T> nullPaddedList, final NullPaddedList<T> nullPaddedList2, final DiffUtil.ItemCallback<T> itemCallback) {
        Intrinsics.checkNotNullParameter(nullPaddedList, "");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "");
        Intrinsics.checkNotNullParameter(itemCallback, "");
        final int lookAheadTest = nullPaddedList.getLookAheadTest();
        final int lookAheadTest2 = nullPaddedList2.getLookAheadTest();
        DiffUtil.DiffResult BuiltInFictitiousFunctionClassFactory = DiffUtil.BuiltInFictitiousFunctionClassFactory(new DiffUtil.Callback() { // from class: androidx.paging.NullPaddedListDiffHelperKt$computeDiff$diffResult$1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public final Object PlaceComponentResult(int p0, int p1) {
                if (nullPaddedList.getAuthRequestContext(p0) == nullPaddedList2.getAuthRequestContext(p1)) {
                    return Boolean.TRUE;
                }
                return DiffUtil.ItemCallback.getAuthRequestContext();
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            /* renamed from: getAuthRequestContext  reason: from getter */
            public final int getMyBillsEntityDataFactory() {
                return lookAheadTest;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            /* renamed from: PlaceComponentResult  reason: from getter */
            public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
                return lookAheadTest2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
                Object authRequestContext = nullPaddedList.getAuthRequestContext(p0);
                Object authRequestContext2 = nullPaddedList2.getAuthRequestContext(p1);
                if (authRequestContext == authRequestContext2) {
                    return true;
                }
                return itemCallback.getAuthRequestContext(authRequestContext, authRequestContext2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public final boolean MyBillsEntityDataFactory(int p0, int p1) {
                Object authRequestContext = nullPaddedList.getAuthRequestContext(p0);
                Object authRequestContext2 = nullPaddedList2.getAuthRequestContext(p1);
                if (authRequestContext == authRequestContext2) {
                    return true;
                }
                return itemCallback.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, authRequestContext2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        boolean z = false;
        IntRange until = RangesKt.until(0, nullPaddedList.getLookAheadTest());
        if (!(until instanceof Collection) || !((Collection) until).isEmpty()) {
            Iterator<Integer> it = until.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(((IntIterator) it).nextInt()) != -1) {
                    z = true;
                    break;
                }
            }
        }
        return new NullPaddedDiffResult(BuiltInFictitiousFunctionClassFactory, z);
    }

    public static final <T> void PlaceComponentResult(NullPaddedList<T> nullPaddedList, ListUpdateCallback listUpdateCallback, NullPaddedList<T> nullPaddedList2, NullPaddedDiffResult nullPaddedDiffResult) {
        Intrinsics.checkNotNullParameter(nullPaddedList, "");
        Intrinsics.checkNotNullParameter(listUpdateCallback, "");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "");
        Intrinsics.checkNotNullParameter(nullPaddedDiffResult, "");
        if (nullPaddedDiffResult.getPlaceComponentResult()) {
            OverlappingListsDiffDispatcher overlappingListsDiffDispatcher = OverlappingListsDiffDispatcher.INSTANCE;
            OverlappingListsDiffDispatcher.getAuthRequestContext(nullPaddedList, nullPaddedList2, listUpdateCallback, nullPaddedDiffResult);
            return;
        }
        DistinctListsDiffDispatcher distinctListsDiffDispatcher = DistinctListsDiffDispatcher.INSTANCE;
        Intrinsics.checkNotNullParameter(listUpdateCallback, "");
        Intrinsics.checkNotNullParameter(nullPaddedList, "");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "");
        int max = Math.max(nullPaddedList.getGetErrorConfigVersion(), nullPaddedList2.getGetErrorConfigVersion());
        int min = Math.min(nullPaddedList.getGetErrorConfigVersion() + nullPaddedList.getLookAheadTest(), nullPaddedList2.getGetErrorConfigVersion() + nullPaddedList2.getLookAheadTest());
        int i = min - max;
        if (i > 0) {
            listUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2(max, i);
            listUpdateCallback.PlaceComponentResult(max, i);
        }
        int min2 = Math.min(max, min);
        int max2 = Math.max(max, min);
        DistinctListsDiffDispatcher.KClassImpl$Data$declaredNonStaticMembers$2(listUpdateCallback, min2, max2, RangesKt.coerceAtMost(nullPaddedList.getGetErrorConfigVersion(), nullPaddedList2.MyBillsEntityDataFactory()), RangesKt.coerceAtMost(nullPaddedList.getGetErrorConfigVersion() + nullPaddedList.getLookAheadTest(), nullPaddedList2.MyBillsEntityDataFactory()), DiffingChangePayload.ITEM_TO_PLACEHOLDER);
        DistinctListsDiffDispatcher.KClassImpl$Data$declaredNonStaticMembers$2(listUpdateCallback, min2, max2, RangesKt.coerceAtMost(nullPaddedList2.getGetErrorConfigVersion(), nullPaddedList.MyBillsEntityDataFactory()), RangesKt.coerceAtMost(nullPaddedList2.getGetErrorConfigVersion() + nullPaddedList2.getLookAheadTest(), nullPaddedList.MyBillsEntityDataFactory()), DiffingChangePayload.PLACEHOLDER_TO_ITEM);
        int MyBillsEntityDataFactory = nullPaddedList2.MyBillsEntityDataFactory() - nullPaddedList.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory > 0) {
            listUpdateCallback.PlaceComponentResult(nullPaddedList.MyBillsEntityDataFactory(), MyBillsEntityDataFactory);
        } else if (MyBillsEntityDataFactory < 0) {
            listUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2(nullPaddedList.MyBillsEntityDataFactory() + MyBillsEntityDataFactory, -MyBillsEntityDataFactory);
        }
    }

    public static final int KClassImpl$Data$declaredNonStaticMembers$2(NullPaddedList<?> nullPaddedList, NullPaddedDiffResult nullPaddedDiffResult, NullPaddedList<?> nullPaddedList2, int i) {
        int authRequestContext;
        Intrinsics.checkNotNullParameter(nullPaddedList, "");
        Intrinsics.checkNotNullParameter(nullPaddedDiffResult, "");
        Intrinsics.checkNotNullParameter(nullPaddedList2, "");
        if (!nullPaddedDiffResult.getPlaceComponentResult()) {
            return RangesKt.coerceIn(i, (ClosedRange<Integer>) RangesKt.until(0, nullPaddedList2.MyBillsEntityDataFactory()));
        }
        int getErrorConfigVersion = i - nullPaddedList.getGetErrorConfigVersion();
        if (getErrorConfigVersion >= 0 && getErrorConfigVersion < nullPaddedList.getLookAheadTest()) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                int i4 = ((i2 / 2) * (i2 % 2 == 1 ? -1 : 1)) + getErrorConfigVersion;
                if (i4 >= 0 && i4 < nullPaddedList.getLookAheadTest() && (authRequestContext = nullPaddedDiffResult.MyBillsEntityDataFactory.getAuthRequestContext(i4)) != -1) {
                    return authRequestContext + nullPaddedList2.getGetErrorConfigVersion();
                }
                if (i3 > 29) {
                    break;
                }
                i2 = i3;
            }
        }
        return RangesKt.coerceIn(i, (ClosedRange<Integer>) RangesKt.until(0, nullPaddedList2.MyBillsEntityDataFactory()));
    }
}
