package id.dana.sendmoney_v2.landing.adapter;

import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.sendmoney_v2.landing.view.ShowMoreView;
import id.dana.sendmoney_v2.landing.viewholder.MoreTransactionViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0010\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0001*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B)\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0004¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\nR\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0012\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0016R%\u0010\f\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\b\u0018\u0012\u0004\u0012\u00020\u000f0\u0017X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00058\u0005X\u0085\u0004¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0015\u0010\u0007"}, d2 = {"Lid/dana/sendmoney_v2/landing/adapter/ExpandableAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "VH", "T", "Lid/dana/base/BaseRecyclerViewAdapter;", "", "getItemCount", "()I", "", "MyBillsEntityDataFactory", "()Z", "p0", "getAuthRequestContext", "(I)Z", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "BuiltInFictitiousFunctionClassFactory", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "I", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "Lkotlin/jvm/functions/Function1;", "lookAheadTest", "p2", "p3", "<init>", "(IIZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ExpandableAdapter<VH extends BaseRecyclerViewHolder<T>, T> extends BaseRecyclerViewAdapter<VH, T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Function1<? super Boolean, Unit> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final int lookAheadTest;

    public /* synthetic */ ExpandableAdapter(int i, int i2, boolean z, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, z, (i3 & 8) != 0 ? false : z2);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ExpandableAdapter<VH, T>) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final int getLookAheadTest() {
        return this.lookAheadTest;
    }

    public ExpandableAdapter(int i, int i2, boolean z, boolean z2) {
        this.PlaceComponentResult = i;
        this.lookAheadTest = i2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.MyBillsEntityDataFactory = z2;
        this.getAuthRequestContext = new Function1<Boolean, Unit>() { // from class: id.dana.sendmoney_v2.landing.adapter.ExpandableAdapter$onExpand$1
            public final void invoke(boolean z3) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return !MyBillsEntityDataFactory() && getItems().size() > this.PlaceComponentResult * this.lookAheadTest;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void onBindViewHolder(VH p0, int p1) {
        super.onBindViewHolder((ExpandableAdapter<VH, T>) p0, p1);
        MoreTransactionViewHolder moreTransactionViewHolder = p0 instanceof MoreTransactionViewHolder ? (MoreTransactionViewHolder) p0 : null;
        if (moreTransactionViewHolder != null) {
            boolean z = this.MyBillsEntityDataFactory;
            ShowMoreView showMoreView = (ShowMoreView) moreTransactionViewHolder.itemView.findViewById(R.id.res_0x7f0a1225_lambda_observersecurityproviderupdate_4_id_dana_onboarding_splash_localconfigsplashactivity);
            if (showMoreView != null) {
                showMoreView.setExpanded(z);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        int size;
        int i;
        if (MyBillsEntityDataFactory()) {
            return 1;
        }
        if (getItems().size() <= this.PlaceComponentResult * this.lookAheadTest) {
            return getItems().size();
        }
        int size2 = getItems().size();
        int i2 = this.PlaceComponentResult;
        int i3 = this.lookAheadTest;
        if (size2 <= i2 * i3 || this.MyBillsEntityDataFactory) {
            size = getItems().size();
            i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            size = i2 * i3;
            i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return i + size;
    }

    public final boolean getAuthRequestContext(int p0) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2 && BuiltInFictitiousFunctionClassFactory() && getPlaceComponentResult() - 1 == p0;
    }

    public final boolean MyBillsEntityDataFactory() {
        List<T> items = getItems();
        if (items != null) {
            return items.isEmpty();
        }
        return true;
    }

    public final boolean getAuthRequestContext() {
        boolean z = !this.MyBillsEntityDataFactory;
        this.MyBillsEntityDataFactory = z;
        this.getAuthRequestContext.invoke(Boolean.valueOf(z));
        if (BuiltInFictitiousFunctionClassFactory()) {
            int size = getItems().size();
            int i = this.PlaceComponentResult;
            int i2 = this.lookAheadTest;
            int i3 = size - (i * i2);
            if (this.MyBillsEntityDataFactory) {
                notifyItemRangeInserted(i * i2, i3);
            } else {
                notifyItemRangeRemoved(i * i2, i3);
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                notifyItemChanged(getPlaceComponentResult() - 1, null);
            }
        } else {
            notifyDataSetChanged();
        }
        return this.MyBillsEntityDataFactory;
    }
}
