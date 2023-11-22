package id.dana.promodiscovery.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promodiscovery.model.SectionState;
import id.dana.promodiscovery.viewholder.ErrorViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0012\u0010\u0012\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "T", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Landroid/view/ViewGroup;", "p0", "MyBillsEntityDataFactory", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "", "getItemViewType", "(I)I", "Lkotlin/Function1;", "Lid/dana/promodiscovery/model/SectionState;", "", "Lkotlin/jvm/functions/Function1;", "PlaceComponentResult", "getAuthRequestContext", "Lid/dana/promodiscovery/model/SectionState;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/promodiscovery/model/SectionState;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseDiscoveryItemAdapter<T> extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<T>, T> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public Function1<? super SectionState, Unit> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public SectionState KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.promodiscovery.model.SectionState, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BaseDiscoveryItemAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promodiscovery.adapter.BaseDiscoveryItemAdapter.<init>():void");
    }

    public abstract BaseRecyclerViewHolder<T> MyBillsEntityDataFactory(ViewGroup p0);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return (i == SectionState.ERROR_NETWORK.getStateCode() || i == SectionState.ERROR_GENERAL.getStateCode()) || i == SectionState.ERROR_LOCATION_PERMISSION.getStateCode() ? new ErrorViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult) : MyBillsEntityDataFactory(viewGroup);
    }

    public /* synthetic */ BaseDiscoveryItemAdapter(SectionState sectionState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SectionState.LOADING : sectionState);
    }

    private BaseDiscoveryItemAdapter(SectionState sectionState) {
        Intrinsics.checkNotNullParameter(sectionState, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sectionState;
        this.PlaceComponentResult = new Function1<SectionState, Unit>() { // from class: id.dana.promodiscovery.adapter.BaseDiscoveryItemAdapter$onErrorButtonClicked$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SectionState sectionState2) {
                Intrinsics.checkNotNullParameter(sectionState2, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SectionState sectionState2) {
                invoke2(sectionState2);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int p0) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getStateCode();
    }
}
