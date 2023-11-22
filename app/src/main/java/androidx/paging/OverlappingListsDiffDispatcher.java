package androidx.paging;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher;", "", "T", "Landroidx/paging/NullPaddedList;", "p0", "p1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "p2", "Landroidx/paging/NullPaddedDiffResult;", "p3", "", "getAuthRequestContext", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;Landroidx/paging/NullPaddedDiffResult;)V", "<init>", "()V", "PlaceholderUsingUpdateCallback"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class OverlappingListsDiffDispatcher {
    public static final OverlappingListsDiffDispatcher INSTANCE = new OverlappingListsDiffDispatcher();

    private OverlappingListsDiffDispatcher() {
    }

    public static <T> void getAuthRequestContext(NullPaddedList<T> p0, NullPaddedList<T> p1, ListUpdateCallback p2, NullPaddedDiffResult p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        PlaceholderUsingUpdateCallback placeholderUsingUpdateCallback = new PlaceholderUsingUpdateCallback(p0, p1, p2);
        p3.MyBillsEntityDataFactory.MyBillsEntityDataFactory(placeholderUsingUpdateCallback);
        int min = Math.min(placeholderUsingUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(), placeholderUsingUpdateCallback.getErrorConfigVersion);
        int KClassImpl$Data$declaredNonStaticMembers$2 = placeholderUsingUpdateCallback.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2() - placeholderUsingUpdateCallback.getErrorConfigVersion;
        if (KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
            if (min > 0) {
                placeholderUsingUpdateCallback.PlaceComponentResult.getAuthRequestContext(0, min, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            }
            placeholderUsingUpdateCallback.PlaceComponentResult.PlaceComponentResult(0, KClassImpl$Data$declaredNonStaticMembers$2);
        } else if (KClassImpl$Data$declaredNonStaticMembers$2 < 0) {
            placeholderUsingUpdateCallback.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(0, -KClassImpl$Data$declaredNonStaticMembers$2);
            int i = min + KClassImpl$Data$declaredNonStaticMembers$2;
            if (i > 0) {
                placeholderUsingUpdateCallback.PlaceComponentResult.getAuthRequestContext(0, i, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            }
        }
        placeholderUsingUpdateCallback.getErrorConfigVersion = placeholderUsingUpdateCallback.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        int min2 = Math.min(placeholderUsingUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(), placeholderUsingUpdateCallback.BuiltInFictitiousFunctionClassFactory);
        int authRequestContext = placeholderUsingUpdateCallback.getAuthRequestContext.getAuthRequestContext();
        int i2 = placeholderUsingUpdateCallback.BuiltInFictitiousFunctionClassFactory;
        int i3 = authRequestContext - i2;
        int i4 = placeholderUsingUpdateCallback.getErrorConfigVersion + placeholderUsingUpdateCallback.NetworkUserEntityData$$ExternalSyntheticLambda0 + i2;
        int i5 = i4 - min2;
        boolean z = i5 != placeholderUsingUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory() - min2;
        if (i3 > 0) {
            placeholderUsingUpdateCallback.PlaceComponentResult.PlaceComponentResult(i4, i3);
        } else if (i3 < 0) {
            placeholderUsingUpdateCallback.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(i4 + i3, -i3);
            min2 += i3;
        }
        if (min2 > 0 && z) {
            placeholderUsingUpdateCallback.PlaceComponentResult.getAuthRequestContext(i5, min2, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
        }
        placeholderUsingUpdateCallback.BuiltInFictitiousFunctionClassFactory = placeholderUsingUpdateCallback.getAuthRequestContext.getAuthRequestContext();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \u001b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001bB+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\bJ)\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\t\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0017"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback;", "T", "Landroidx/recyclerview/widget/ListUpdateCallback;", "", "p0", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(II)Z", "MyBillsEntityDataFactory", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "p2", "", "getAuthRequestContext", "(IILjava/lang/Object;)V", "PlaceComponentResult", "(II)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/recyclerview/widget/ListUpdateCallback;", "Landroidx/paging/NullPaddedList;", "Landroidx/paging/NullPaddedList;", "I", "moveToNextValue", "<init>", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    static final class PlaceholderUsingUpdateCallback<T> implements ListUpdateCallback {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        int getErrorConfigVersion;
        final NullPaddedList<T> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        private int moveToNextValue;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final NullPaddedList<T> getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final ListUpdateCallback PlaceComponentResult;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        int NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        private int MyBillsEntityDataFactory;

        public PlaceholderUsingUpdateCallback(NullPaddedList<T> nullPaddedList, NullPaddedList<T> nullPaddedList2, ListUpdateCallback listUpdateCallback) {
            Intrinsics.checkNotNullParameter(nullPaddedList, "");
            Intrinsics.checkNotNullParameter(nullPaddedList2, "");
            Intrinsics.checkNotNullParameter(listUpdateCallback, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = nullPaddedList;
            this.getAuthRequestContext = nullPaddedList2;
            this.PlaceComponentResult = listUpdateCallback;
            this.getErrorConfigVersion = nullPaddedList.KClassImpl$Data$declaredNonStaticMembers$2();
            this.BuiltInFictitiousFunctionClassFactory = nullPaddedList.getAuthRequestContext();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = nullPaddedList.scheduleImpl();
            this.moveToNextValue = 1;
            this.MyBillsEntityDataFactory = 1;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void PlaceComponentResult(int p0, int p1) {
            if (!BuiltInFictitiousFunctionClassFactory(p0, p1) && !MyBillsEntityDataFactory(p0, p1)) {
                this.PlaceComponentResult.PlaceComponentResult(p0 + this.getErrorConfigVersion, p1);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 += p1;
        }

        private final boolean MyBillsEntityDataFactory(int p0, int p1) {
            if (p0 <= 0 && this.moveToNextValue != 2) {
                int min = Math.min(p1, this.getErrorConfigVersion);
                if (min > 0) {
                    this.moveToNextValue = 3;
                    this.PlaceComponentResult.getAuthRequestContext((0 - min) + this.getErrorConfigVersion, min, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                    this.getErrorConfigVersion -= min;
                }
                int i = p1 - min;
                if (i > 0) {
                    this.PlaceComponentResult.PlaceComponentResult(this.getErrorConfigVersion + 0, i);
                    return true;
                }
                return true;
            }
            return false;
        }

        private final boolean BuiltInFictitiousFunctionClassFactory(int p0, int p1) {
            if (p0 >= this.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.MyBillsEntityDataFactory != 2) {
                int min = Math.min(p1, this.BuiltInFictitiousFunctionClassFactory);
                if (min > 0) {
                    this.MyBillsEntityDataFactory = 3;
                    this.PlaceComponentResult.getAuthRequestContext(this.getErrorConfigVersion + p0, min, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                    this.BuiltInFictitiousFunctionClassFactory -= min;
                }
                int i = p1 - min;
                if (i > 0) {
                    this.PlaceComponentResult.PlaceComponentResult(p0 + min + this.getErrorConfigVersion, i);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
            if (!getErrorConfigVersion(p0, p1) && !NetworkUserEntityData$$ExternalSyntheticLambda0(p0, p1)) {
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(p0 + this.getErrorConfigVersion, p1);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 -= p1;
        }

        private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0(int p0, int p1) {
            if (p0 <= 0 && this.moveToNextValue != 3) {
                int coerceAtLeast = RangesKt.coerceAtLeast(Math.min(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2() - this.getErrorConfigVersion, p1), 0);
                int i = p1 - coerceAtLeast;
                if (i > 0) {
                    this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.getErrorConfigVersion + 0, i);
                }
                if (coerceAtLeast > 0) {
                    this.moveToNextValue = 2;
                    this.PlaceComponentResult.getAuthRequestContext(this.getErrorConfigVersion + 0, coerceAtLeast, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                    this.getErrorConfigVersion += coerceAtLeast;
                    return true;
                }
                return true;
            }
            return false;
        }

        private final boolean getErrorConfigVersion(int p0, int p1) {
            if (p0 + p1 >= this.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.MyBillsEntityDataFactory != 3) {
                int coerceAtLeast = RangesKt.coerceAtLeast(Math.min(this.getAuthRequestContext.getAuthRequestContext() - this.BuiltInFictitiousFunctionClassFactory, p1), 0);
                int i = p1 - coerceAtLeast;
                if (coerceAtLeast > 0) {
                    this.MyBillsEntityDataFactory = 2;
                    this.PlaceComponentResult.getAuthRequestContext(this.getErrorConfigVersion + p0, coerceAtLeast, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                    this.BuiltInFictitiousFunctionClassFactory += coerceAtLeast;
                }
                if (i > 0) {
                    this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(p0 + coerceAtLeast + this.getErrorConfigVersion, i);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void getAuthRequestContext(int p0, int p1) {
            ListUpdateCallback listUpdateCallback = this.PlaceComponentResult;
            int i = this.getErrorConfigVersion;
            listUpdateCallback.getAuthRequestContext(p0 + i, p1 + i);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public final void getAuthRequestContext(int p0, int p1, Object p2) {
            this.PlaceComponentResult.getAuthRequestContext(p0 + this.getErrorConfigVersion, p1, p2);
        }
    }
}
