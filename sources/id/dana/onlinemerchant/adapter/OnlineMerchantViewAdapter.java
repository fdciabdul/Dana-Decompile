package id.dana.onlinemerchant.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.onlinemerchant.adapter.OnlineMerchantViewAdapter;
import id.dana.onlinemerchant.view.OnlineMerchantListView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00192\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0006\u001a\u0019\u001b\u001c\u001d\u001eB\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eX\u0086\"¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015"}, d2 = {"Lid/dana/onlinemerchant/adapter/OnlineMerchantViewAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Lkotlin/Function0;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "I", "getAuthRequestContext", "<init>", "(I)V", "Companion", "BaseOnlineMerchantViewHolder", "MerchantStaticBannerViewHolder", "OnlineMerchantLoadMoreViewHolder", "OnlineMerchantViewHolder", "TrendingMerchantViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OnlineMerchantViewAdapter extends BaseRecyclerViewAdapter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final int getAuthRequestContext;
    public OnlineMerchantListView.OnlineMerchantItemListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    public OnlineMerchantViewAdapter() {
        this(0, 1, null);
    }

    public /* synthetic */ OnlineMerchantViewAdapter(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 4 : i);
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((OnlineMerchantViewAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantStaticBannerViewHolder merchantStaticBannerViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            merchantStaticBannerViewHolder = new MerchantStaticBannerViewHolder(viewGroup);
        } else if (i == 1) {
            merchantStaticBannerViewHolder = new TrendingMerchantViewHolder(viewGroup);
        } else if (i == 2) {
            OnlineMerchantViewHolder onlineMerchantViewHolder = new OnlineMerchantViewHolder(viewGroup);
            String string = onlineMerchantViewHolder.getContext().getString(R.string.all_merchant);
            Intrinsics.checkNotNullExpressionValue(string, "");
            onlineMerchantViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(string);
            String string2 = onlineMerchantViewHolder.getContext().getString(R.string.lbl_all_OM_title);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            onlineMerchantViewHolder.MyBillsEntityDataFactory(string2);
            merchantStaticBannerViewHolder = onlineMerchantViewHolder;
        } else if (i == 3) {
            Function0<Unit> function0 = this.BuiltInFictitiousFunctionClassFactory;
            if (function0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                function0 = null;
            }
            merchantStaticBannerViewHolder = new OnlineMerchantLoadMoreViewHolder(viewGroup, function0);
        } else if (i == 4) {
            OnlineMerchantViewHolder onlineMerchantViewHolder2 = new OnlineMerchantViewHolder(viewGroup);
            String string3 = onlineMerchantViewHolder2.getContext().getString(R.string.search_results);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            onlineMerchantViewHolder2.KClassImpl$Data$declaredNonStaticMembers$2(string3);
            String string4 = onlineMerchantViewHolder2.getContext().getString(R.string.lbl_search_results);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            onlineMerchantViewHolder2.MyBillsEntityDataFactory(string4);
            merchantStaticBannerViewHolder = onlineMerchantViewHolder2;
        } else {
            merchantStaticBannerViewHolder = new MerchantStaticBannerViewHolder(viewGroup);
        }
        return merchantStaticBannerViewHolder;
    }

    public OnlineMerchantViewAdapter(int i) {
        this.getAuthRequestContext = i;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0 instanceof BaseOnlineMerchantViewHolder) {
            ((BaseOnlineMerchantViewHolder) p0).getAuthRequestContext = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        super.onBindViewHolder((OnlineMerchantViewAdapter) p0, p1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return this.getAuthRequestContext == 2 ? p0 == 0 ? 4 : 3 : p0;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount  reason: from getter */
    public final int getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/onlinemerchant/adapter/OnlineMerchantViewAdapter$MerchantStaticBannerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MerchantStaticBannerViewHolder extends BaseRecyclerViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MerchantStaticBannerViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.view_online_merchant_banner, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/onlinemerchant/adapter/OnlineMerchantViewAdapter$BaseOnlineMerchantViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/Void;)V", "Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/onlinemerchant/view/OnlineMerchantListView$OnlineMerchantItemListener;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static class BaseOnlineMerchantViewHolder extends BaseRecyclerViewHolder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        OnlineMerchantListView.OnlineMerchantItemListener getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseOnlineMerchantViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.view_online_merchant_list_section, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }

        @Override // id.dana.base.BaseRecyclerViewHolder
        /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
        public void bindData(Void p0) {
            OnlineMerchantListView onlineMerchantListView = (OnlineMerchantListView) this.itemView.findViewById(R.id.rv_list_online_merchant);
            if (onlineMerchantListView != null) {
                onlineMerchantListView.setOnlineMerchantItemListener(this.getAuthRequestContext);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/onlinemerchant/adapter/OnlineMerchantViewAdapter$TrendingMerchantViewHolder;", "Lid/dana/onlinemerchant/adapter/OnlineMerchantViewAdapter$BaseOnlineMerchantViewHolder;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/Void;)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class TrendingMerchantViewHolder extends BaseOnlineMerchantViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TrendingMerchantViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }

        @Override // id.dana.onlinemerchant.adapter.OnlineMerchantViewAdapter.BaseOnlineMerchantViewHolder, id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(Object obj) {
            bindData((Void) obj);
        }

        @Override // id.dana.onlinemerchant.adapter.OnlineMerchantViewAdapter.BaseOnlineMerchantViewHolder
        /* renamed from: PlaceComponentResult */
        public final void bindData(Void p0) {
            super.bindData(p0);
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.tv_title_online_merchant);
            if (appCompatTextView != null) {
                appCompatTextView.setText(appCompatTextView.getContext().getString(R.string.trending_merchant));
                appCompatTextView.setContentDescription(appCompatTextView.getContext().getString(R.string.lbl_popular_OM_title));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/onlinemerchant/adapter/OnlineMerchantViewAdapter$OnlineMerchantViewHolder;", "Lid/dana/onlinemerchant/adapter/OnlineMerchantViewAdapter$BaseOnlineMerchantViewHolder;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnlineMerchantViewHolder extends BaseOnlineMerchantViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnlineMerchantViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.tv_title_online_merchant);
            if (appCompatTextView != null) {
                appCompatTextView.setText(p0);
            }
        }

        public final void MyBillsEntityDataFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.tv_title_online_merchant);
            if (appCompatTextView != null) {
                appCompatTextView.setContentDescription(p0);
            }
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/onlinemerchant/adapter/OnlineMerchantViewAdapter$OnlineMerchantLoadMoreViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "", "Lkotlin/Function0;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class OnlineMerchantLoadMoreViewHolder extends BaseRecyclerViewHolder {
        private final Function0<Unit> PlaceComponentResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OnlineMerchantLoadMoreViewHolder(ViewGroup viewGroup, Function0<Unit> function0) {
            super(viewGroup.getContext(), R.layout.view_online_merchant_load_more, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            Intrinsics.checkNotNullParameter(function0, "");
            this.PlaceComponentResult = function0;
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.btnLoadMoreMerchant);
            if (appCompatTextView != null) {
                appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onlinemerchant.adapter.OnlineMerchantViewAdapter$OnlineMerchantLoadMoreViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder.BuiltInFictitiousFunctionClassFactory(OnlineMerchantViewAdapter.OnlineMerchantLoadMoreViewHolder.this);
                    }
                });
            }
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(OnlineMerchantLoadMoreViewHolder onlineMerchantLoadMoreViewHolder) {
            Intrinsics.checkNotNullParameter(onlineMerchantLoadMoreViewHolder, "");
            onlineMerchantLoadMoreViewHolder.PlaceComponentResult.invoke();
        }
    }
}
