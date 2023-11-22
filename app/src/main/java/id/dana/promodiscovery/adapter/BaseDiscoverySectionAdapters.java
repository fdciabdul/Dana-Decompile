package id.dana.promodiscovery.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import id.dana.promodiscovery.model.SectionState;
import id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012 \u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u0011J#\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0011J\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017"}, d2 = {"Lid/dana/promodiscovery/adapter/BaseDiscoverySectionAdapters;", "T", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/DiscoverySectionModel;", "Landroid/view/ViewGroup;", "p0", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)V", "()V", "Lid/dana/promodiscovery/model/SectionState;", "MyBillsEntityDataFactory", "(Lid/dana/promodiscovery/model/SectionState;)V", "PlaceComponentResult", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseDiscoverySectionAdapters<T> extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<DiscoverySectionModel<T>>, DiscoverySectionModel<T>> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Function0<Unit> getAuthRequestContext = new Function0<Unit>() { // from class: id.dana.promodiscovery.adapter.BaseDiscoverySectionAdapters$onErrorButtonClicked$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };

    public abstract BaseRecyclerViewHolder<DiscoverySectionModel<T>> getAuthRequestContext(ViewGroup p0);

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((BaseDiscoverySectionAdapters<T>) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return getAuthRequestContext(viewGroup);
    }

    public BaseDiscoverySectionAdapters() {
        getItems().add((T) new DiscoverySectionModel(null, CollectionsKt.emptyList(), SectionState.LOADING, 1, null));
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<? extends T> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<T> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        DiscoverySectionModel discoverySectionModel = (DiscoverySectionModel) CollectionsKt.first((List) items);
        Intrinsics.checkNotNullParameter(p0, "");
        discoverySectionModel.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        notifyItemChanged(0);
    }

    public final void MyBillsEntityDataFactory() {
        List<T> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        DiscoverySectionModel discoverySectionModel = (DiscoverySectionModel) CollectionsKt.first((List) items);
        SectionState sectionState = SectionState.LOADING;
        Intrinsics.checkNotNullParameter(sectionState, "");
        discoverySectionModel.BuiltInFictitiousFunctionClassFactory = sectionState;
        notifyItemChanged(0);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        List<T> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        DiscoverySectionModel discoverySectionModel = (DiscoverySectionModel) CollectionsKt.first((List) items);
        SectionState sectionState = SectionState.ACTIVE;
        Intrinsics.checkNotNullParameter(sectionState, "");
        discoverySectionModel.BuiltInFictitiousFunctionClassFactory = sectionState;
        notifyItemChanged(0);
    }

    public final void PlaceComponentResult() {
        List<T> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        DiscoverySectionModel discoverySectionModel = (DiscoverySectionModel) CollectionsKt.first((List) items);
        SectionState sectionState = SectionState.HIDDEN;
        Intrinsics.checkNotNullParameter(sectionState, "");
        discoverySectionModel.BuiltInFictitiousFunctionClassFactory = sectionState;
        notifyItemChanged(0);
    }

    public final void MyBillsEntityDataFactory(SectionState p0) {
        List<T> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        DiscoverySectionModel discoverySectionModel = (DiscoverySectionModel) CollectionsKt.first((List) items);
        Intrinsics.checkNotNullParameter(p0, "");
        discoverySectionModel.BuiltInFictitiousFunctionClassFactory = p0;
        notifyItemChanged(0);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void onBindViewHolder(BaseRecyclerViewHolder<DiscoverySectionModel<T>> p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onBindViewHolder((BaseDiscoverySectionAdapters<T>) p0, p1);
        BaseDiscoverySectionViewHolder baseDiscoverySectionViewHolder = p0 instanceof BaseDiscoverySectionViewHolder ? (BaseDiscoverySectionViewHolder) p0 : null;
        if (baseDiscoverySectionViewHolder != null) {
            final Function0<Unit> function0 = new Function0<Unit>(this) { // from class: id.dana.promodiscovery.adapter.BaseDiscoverySectionAdapters$onBindViewHolder$1
                final /* synthetic */ BaseDiscoverySectionAdapters<T> this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.this$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function0 function02;
                    function02 = this.this$0.getAuthRequestContext;
                    function02.invoke();
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            BaseDiscoveryItemAdapter<T> MyBillsEntityDataFactory = baseDiscoverySectionViewHolder.MyBillsEntityDataFactory();
            Function1<SectionState, Unit> function1 = new Function1<SectionState, Unit>() { // from class: id.dana.promodiscovery.viewholder.BaseDiscoverySectionViewHolder$setOnErrorButtonClicked$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(SectionState sectionState) {
                    invoke2(sectionState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(SectionState sectionState) {
                    Intrinsics.checkNotNullParameter(sectionState, "");
                    function0.invoke();
                }
            };
            Intrinsics.checkNotNullParameter(function1, "");
            MyBillsEntityDataFactory.PlaceComponentResult = function1;
        }
    }
}
