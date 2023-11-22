package id.dana.promocenter.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promocenter.model.PromoModel;
import id.dana.promocenter.views.PromoView;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class RegularPromoAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<PromoModel>, PromoModel> {
    public PromoView.Listener KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean BuiltInFictitiousFunctionClassFactory = false;
    public boolean getAuthRequestContext = false;

    /* loaded from: classes9.dex */
    public class PromoViewHolder_ViewBinding implements Unbinder {
        private PromoViewHolder BuiltInFictitiousFunctionClassFactory;

        public PromoViewHolder_ViewBinding(PromoViewHolder promoViewHolder, View view) {
            this.BuiltInFictitiousFunctionClassFactory = promoViewHolder;
            promoViewHolder.pvPromo = (PromoView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.pv_promo, "field 'pvPromo'", PromoView.class);
        }

        @Override // butterknife.Unbinder
        public final void getAuthRequestContext() {
            PromoViewHolder promoViewHolder = this.BuiltInFictitiousFunctionClassFactory;
            if (promoViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.BuiltInFictitiousFunctionClassFactory = null;
            promoViewHolder.pvPromo = null;
        }
    }

    @Inject
    public RegularPromoAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return getItem(i) != null ? 1 : 2;
    }

    public final void getAuthRequestContext(boolean z) {
        if (z) {
            getItems().add(null);
            notifyItemInserted(getItems().size());
            return;
        }
        removeItem(getItems().size() - 1);
    }

    /* loaded from: classes5.dex */
    static class PromoViewHolder extends BaseRecyclerViewHolder<PromoModel> {
        private final boolean MyBillsEntityDataFactory;
        private PromoView.Listener PlaceComponentResult;
        private final boolean getAuthRequestContext;
        @BindView(R.id.pv_promo)
        PromoView pvPromo;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public /* synthetic */ void bindData(PromoModel promoModel) {
            this.pvPromo.setShowCountdown(this.getAuthRequestContext);
            this.pvPromo.setShowMerchantLogo(this.MyBillsEntityDataFactory);
            this.pvPromo.setPromo(promoModel);
            this.pvPromo.setListener(this.PlaceComponentResult);
        }

        public PromoViewHolder(ViewGroup viewGroup, PromoView.Listener listener, boolean z, boolean z2) {
            super(viewGroup.getContext(), R.layout.view_promo_holder, viewGroup);
            this.PlaceComponentResult = listener;
            this.getAuthRequestContext = z;
            this.MyBillsEntityDataFactory = z2;
        }
    }

    /* loaded from: classes5.dex */
    static class PromoSkeletonViewHolder extends BaseRecyclerViewHolder<PromoModel> {
        public PromoSkeletonViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.view_promo_center_load_more_skeleton, viewGroup);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new PromoViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
        }
        return new PromoSkeletonViewHolder(viewGroup);
    }
}
