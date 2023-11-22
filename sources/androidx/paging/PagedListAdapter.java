package androidx.paging;

import androidx.paging.AsyncPagedListDiffer;
import androidx.paging.LoadState;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Deprecated(message = "PagedListAdapter is deprecated and has been replaced by PagingDataAdapter", replaceWith = @ReplaceWith(expression = "PagingDataAdapter<T, VH>", imports = {"androidx.paging.PagingDataAdapter"}))
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u0005B\u0017\b\u0014\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0000¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R6\u0010\u000f\u001a$\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u0012\u0004\u0012\u00020\u000b0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Landroidx/paging/PagedListAdapter;", "", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "getItemCount", "()I", "Landroidx/paging/PagedList;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/PagedList;)V", "Landroidx/paging/AsyncPagedListDiffer;", "PlaceComponentResult", "Landroidx/paging/AsyncPagedListDiffer;", "Lkotlin/Function2;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function2;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final AsyncPagedListDiffer<T> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Function2<PagedList<T>, PagedList<T>, Unit> PlaceComponentResult;

    public PagedListAdapter(DiffUtil.ItemCallback<T> itemCallback) {
        Intrinsics.checkNotNullParameter(itemCallback, "");
        Function2<PagedList<T>, PagedList<T>, Unit> function2 = new Function2<PagedList<T>, PagedList<T>, Unit>(this) { // from class: androidx.paging.PagedListAdapter$listener$1
            final /* synthetic */ PagedListAdapter<T, VH> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.this$0 = this;
            }

            public final void invoke(PagedList<T> pagedList, PagedList<T> pagedList2) {
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                invoke((PagedList) ((PagedList) obj), (PagedList) ((PagedList) obj2));
                return Unit.INSTANCE;
            }
        };
        this.PlaceComponentResult = function2;
        AsyncPagedListDiffer<T> asyncPagedListDiffer = new AsyncPagedListDiffer<>(this, itemCallback);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = asyncPagedListDiffer;
        Intrinsics.checkNotNullParameter(function2, "");
        asyncPagedListDiffer.KClassImpl$Data$declaredNonStaticMembers$2.add(new AsyncPagedListDiffer.OnCurrentListChangedWrapper(function2));
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(final PagedList<T> p0) {
        final AsyncPagedListDiffer<T> asyncPagedListDiffer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        final int i = asyncPagedListDiffer.lookAheadTest + 1;
        asyncPagedListDiffer.lookAheadTest = i;
        PagedList<T> pagedList = asyncPagedListDiffer.moveToNextValue;
        if (p0 != pagedList) {
            if (pagedList != null && (p0 instanceof InitialPagedList)) {
                final PagedList.Callback callback = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullParameter(callback, "");
                CollectionsKt.removeAll((List) pagedList.getAuthRequestContext, (Function1) new Function1<WeakReference<PagedList.Callback>, Boolean>() { // from class: androidx.paging.PagedList$removeWeakCallback$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(WeakReference<PagedList.Callback> weakReference) {
                        Intrinsics.checkNotNullParameter(weakReference, "");
                        return Boolean.valueOf(weakReference.get() == null || weakReference.get() == PagedList.Callback.this);
                    }
                });
                final Function2 function2 = (Function2) asyncPagedListDiffer.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter(function2, "");
                CollectionsKt.removeAll((List) pagedList.moveToNextValue, (Function1) new Function1<WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>>, Boolean>() { // from class: androidx.paging.PagedList$removeWeakLoadStateListener$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final Boolean invoke2(WeakReference<Function2<LoadType, LoadState, Unit>> weakReference) {
                        Intrinsics.checkNotNullParameter(weakReference, "");
                        return Boolean.valueOf(weakReference.get() == null || weakReference.get() == function2);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>> weakReference) {
                        return invoke2((WeakReference<Function2<LoadType, LoadState, Unit>>) weakReference);
                    }
                });
                asyncPagedListDiffer.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(LoadType.REFRESH, LoadState.Loading.INSTANCE);
                asyncPagedListDiffer.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(LoadType.PREPEND, new LoadState.NotLoading(false));
                asyncPagedListDiffer.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(LoadType.APPEND, new LoadState.NotLoading(false));
                return;
            }
            PagedList<T> pagedList2 = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (pagedList2 == null) {
                pagedList2 = asyncPagedListDiffer.moveToNextValue;
            }
            if (p0 == null) {
                int authRequestContext = asyncPagedListDiffer.getAuthRequestContext();
                if (pagedList != null) {
                    final PagedList.Callback callback2 = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    Intrinsics.checkNotNullParameter(callback2, "");
                    CollectionsKt.removeAll((List) pagedList.getAuthRequestContext, (Function1) new Function1<WeakReference<PagedList.Callback>, Boolean>() { // from class: androidx.paging.PagedList$removeWeakCallback$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(WeakReference<PagedList.Callback> weakReference) {
                            Intrinsics.checkNotNullParameter(weakReference, "");
                            return Boolean.valueOf(weakReference.get() == null || weakReference.get() == PagedList.Callback.this);
                        }
                    });
                    final Function2 function22 = (Function2) asyncPagedListDiffer.BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullParameter(function22, "");
                    CollectionsKt.removeAll((List) pagedList.moveToNextValue, (Function1) new Function1<WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>>, Boolean>() { // from class: androidx.paging.PagedList$removeWeakLoadStateListener$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final Boolean invoke2(WeakReference<Function2<LoadType, LoadState, Unit>> weakReference) {
                            Intrinsics.checkNotNullParameter(weakReference, "");
                            return Boolean.valueOf(weakReference.get() == null || weakReference.get() == function22);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>> weakReference) {
                            return invoke2((WeakReference<Function2<LoadType, LoadState, Unit>>) weakReference);
                        }
                    });
                    asyncPagedListDiffer.moveToNextValue = null;
                } else if (asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) {
                    asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
                }
                ListUpdateCallback listUpdateCallback = asyncPagedListDiffer.DatabaseTableConfigUtil;
                if (listUpdateCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    listUpdateCallback = null;
                }
                listUpdateCallback.KClassImpl$Data$declaredNonStaticMembers$2(0, authRequestContext);
                asyncPagedListDiffer.KClassImpl$Data$declaredNonStaticMembers$2(pagedList2, null, null);
                return;
            }
            PagedList<T> pagedList3 = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (pagedList3 == null) {
                pagedList3 = asyncPagedListDiffer.moveToNextValue;
            }
            if (pagedList3 == null) {
                asyncPagedListDiffer.moveToNextValue = p0;
                p0.getAuthRequestContext((Function2) asyncPagedListDiffer.BuiltInFictitiousFunctionClassFactory);
                p0.KClassImpl$Data$declaredNonStaticMembers$2(asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda0);
                ListUpdateCallback listUpdateCallback2 = asyncPagedListDiffer.DatabaseTableConfigUtil;
                if (listUpdateCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    listUpdateCallback2 = null;
                }
                listUpdateCallback2.PlaceComponentResult(0, p0.size());
                asyncPagedListDiffer.KClassImpl$Data$declaredNonStaticMembers$2(null, p0, null);
                return;
            }
            PagedList<T> pagedList4 = asyncPagedListDiffer.moveToNextValue;
            if (pagedList4 != null) {
                final PagedList.Callback callback3 = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda0;
                Intrinsics.checkNotNullParameter(callback3, "");
                CollectionsKt.removeAll((List) pagedList4.getAuthRequestContext, (Function1) new Function1<WeakReference<PagedList.Callback>, Boolean>() { // from class: androidx.paging.PagedList$removeWeakCallback$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(WeakReference<PagedList.Callback> weakReference) {
                        Intrinsics.checkNotNullParameter(weakReference, "");
                        return Boolean.valueOf(weakReference.get() == null || weakReference.get() == PagedList.Callback.this);
                    }
                });
                final Function2 function23 = (Function2) asyncPagedListDiffer.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullParameter(function23, "");
                CollectionsKt.removeAll((List) pagedList4.moveToNextValue, (Function1) new Function1<WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>>, Boolean>() { // from class: androidx.paging.PagedList$removeWeakLoadStateListener$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final Boolean invoke2(WeakReference<Function2<LoadType, LoadState, Unit>> weakReference) {
                        Intrinsics.checkNotNullParameter(weakReference, "");
                        return Boolean.valueOf(weakReference.get() == null || weakReference.get() == function23);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>> weakReference) {
                        return invoke2((WeakReference<Function2<LoadType, LoadState, Unit>>) weakReference);
                    }
                });
                asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1 = pagedList4.getBuiltInFictitiousFunctionClassFactory() ? pagedList4 : new SnapshotPagedList(pagedList4);
                asyncPagedListDiffer.moveToNextValue = null;
            }
            final PagedList<T> pagedList5 = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (pagedList5 == null || asyncPagedListDiffer.moveToNextValue != null) {
                throw new IllegalStateException("must be in snapshot state to diff");
            }
            final PagedList snapshotPagedList = p0.getBuiltInFictitiousFunctionClassFactory() ? p0 : new SnapshotPagedList(p0);
            final RecordingCallback recordingCallback = new RecordingCallback();
            p0.KClassImpl$Data$declaredNonStaticMembers$2(recordingCallback);
            asyncPagedListDiffer.getAuthRequestContext.getAuthRequestContext.execute(new Runnable() { // from class: androidx.paging.AsyncPagedListDiffer$submitList$2
                final /* synthetic */ Runnable PlaceComponentResult = null;

                @Override // java.lang.Runnable
                public final void run() {
                    NullPaddedList nullPaddedList = pagedList5.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    NullPaddedList nullPaddedList2 = snapshotPagedList.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    DiffUtil.ItemCallback<T> itemCallback = asyncPagedListDiffer.getAuthRequestContext.PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(itemCallback, "");
                    final NullPaddedDiffResult BuiltInFictitiousFunctionClassFactory = NullPaddedListDiffHelperKt.BuiltInFictitiousFunctionClassFactory(nullPaddedList, nullPaddedList2, itemCallback);
                    Executor executor = asyncPagedListDiffer.scheduleImpl;
                    final AsyncPagedListDiffer<T> asyncPagedListDiffer2 = asyncPagedListDiffer;
                    final int i2 = i;
                    final PagedList<T> pagedList6 = p0;
                    final PagedList<T> pagedList7 = snapshotPagedList;
                    final RecordingCallback recordingCallback2 = recordingCallback;
                    final PagedList<T> pagedList8 = pagedList5;
                    final Runnable runnable = this.PlaceComponentResult;
                    executor.execute(new Runnable() { // from class: androidx.paging.AsyncPagedListDiffer$submitList$2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (asyncPagedListDiffer2.lookAheadTest == i2) {
                                AsyncPagedListDiffer<T> asyncPagedListDiffer3 = asyncPagedListDiffer2;
                                PagedList<T> pagedList9 = pagedList6;
                                PagedList<T> pagedList10 = pagedList7;
                                NullPaddedDiffResult nullPaddedDiffResult = BuiltInFictitiousFunctionClassFactory;
                                RecordingCallback recordingCallback3 = recordingCallback2;
                                PagedStorage<T> pagedStorage = pagedList8.NetworkUserEntityData$$ExternalSyntheticLambda2;
                                int i3 = pagedStorage.getErrorConfigVersion + pagedStorage.getAuthRequestContext;
                                Runnable runnable2 = runnable;
                                Intrinsics.checkNotNullParameter(pagedList9, "");
                                Intrinsics.checkNotNullParameter(pagedList10, "");
                                Intrinsics.checkNotNullParameter(nullPaddedDiffResult, "");
                                Intrinsics.checkNotNullParameter(recordingCallback3, "");
                                PagedList<T> pagedList11 = asyncPagedListDiffer3.NetworkUserEntityData$$ExternalSyntheticLambda1;
                                if (pagedList11 == 0 || asyncPagedListDiffer3.moveToNextValue != null) {
                                    throw new IllegalStateException("must be in snapshot state to apply diff");
                                }
                                asyncPagedListDiffer3.moveToNextValue = pagedList9;
                                pagedList9.getAuthRequestContext((Function2) asyncPagedListDiffer3.BuiltInFictitiousFunctionClassFactory);
                                ListUpdateCallback listUpdateCallback3 = null;
                                asyncPagedListDiffer3.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
                                NullPaddedList nullPaddedList3 = pagedList11.NetworkUserEntityData$$ExternalSyntheticLambda2;
                                ListUpdateCallback listUpdateCallback4 = asyncPagedListDiffer3.DatabaseTableConfigUtil;
                                if (listUpdateCallback4 != null) {
                                    listUpdateCallback3 = listUpdateCallback4;
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                }
                                NullPaddedListDiffHelperKt.PlaceComponentResult(nullPaddedList3, listUpdateCallback3, pagedList10.NetworkUserEntityData$$ExternalSyntheticLambda2, nullPaddedDiffResult);
                                PagedList.Callback callback4 = asyncPagedListDiffer3.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                Intrinsics.checkNotNullParameter(callback4, "");
                                IntProgression step = RangesKt.step(RangesKt.until(0, recordingCallback3.BuiltInFictitiousFunctionClassFactory.size()), 3);
                                int first = step.getFirst();
                                int last = step.getLast();
                                int step2 = step.getStep();
                                int i4 = 1;
                                if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                                    while (true) {
                                        int intValue = recordingCallback3.BuiltInFictitiousFunctionClassFactory.get(first).intValue();
                                        if (intValue == 0) {
                                            callback4.BuiltInFictitiousFunctionClassFactory(recordingCallback3.BuiltInFictitiousFunctionClassFactory.get(first + 1).intValue(), recordingCallback3.BuiltInFictitiousFunctionClassFactory.get(first + 2).intValue());
                                        } else if (intValue == i4) {
                                            callback4.PlaceComponentResult(recordingCallback3.BuiltInFictitiousFunctionClassFactory.get(first + 1).intValue(), recordingCallback3.BuiltInFictitiousFunctionClassFactory.get(first + 2).intValue());
                                        } else if (intValue == 2) {
                                            callback4.getAuthRequestContext(recordingCallback3.BuiltInFictitiousFunctionClassFactory.get(first + 1).intValue(), recordingCallback3.BuiltInFictitiousFunctionClassFactory.get(first + 2).intValue());
                                        } else {
                                            throw new IllegalStateException("Unexpected recording value");
                                        }
                                        if (first == last) {
                                            break;
                                        }
                                        first += step2;
                                        i4 = 1;
                                    }
                                }
                                recordingCallback3.BuiltInFictitiousFunctionClassFactory.clear();
                                pagedList9.KClassImpl$Data$declaredNonStaticMembers$2(asyncPagedListDiffer3.NetworkUserEntityData$$ExternalSyntheticLambda0);
                                if (!pagedList9.isEmpty()) {
                                    pagedList9.getAuthRequestContext(RangesKt.coerceIn(NullPaddedListDiffHelperKt.KClassImpl$Data$declaredNonStaticMembers$2(pagedList11.NetworkUserEntityData$$ExternalSyntheticLambda2, nullPaddedDiffResult, pagedList10.NetworkUserEntityData$$ExternalSyntheticLambda2, i3), 0, pagedList9.size() - 1));
                                }
                                asyncPagedListDiffer3.KClassImpl$Data$declaredNonStaticMembers$2(pagedList11, asyncPagedListDiffer3.moveToNextValue, runnable2);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
    }
}
