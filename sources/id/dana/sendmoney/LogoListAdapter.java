package id.dana.sendmoney;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.ShimmerImageAttacherFactory;
import id.dana.domain.promotion.CdpContent;

/* loaded from: classes5.dex */
public class LogoListAdapter extends BaseRecyclerViewAdapter<LogoViewHolder, CdpContent> {

    /* loaded from: classes9.dex */
    public class LogoViewHolder_ViewBinding implements Unbinder {
        private LogoViewHolder KClassImpl$Data$declaredNonStaticMembers$2;

        public LogoViewHolder_ViewBinding(LogoViewHolder logoViewHolder, View view) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = logoViewHolder;
            logoViewHolder.ivLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, id.dana.R.id.SendMoneyHomePresenter, "field 'ivLogo'", ImageView.class);
        }

        @Override // butterknife.Unbinder
        public final void getAuthRequestContext() {
            LogoViewHolder logoViewHolder = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (logoViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            logoViewHolder.ivLogo = null;
        }
    }

    /* loaded from: classes5.dex */
    public class LogoViewHolder extends BaseRecyclerViewHolder<CdpContent> {
        private final ShimmerImageAttacherFactory PlaceComponentResult;
        @BindView(id.dana.R.id.SendMoneyHomePresenter)
        ImageView ivLogo;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public /* synthetic */ void bindData(CdpContent cdpContent) {
            CdpContent cdpContent2 = cdpContent;
            if (cdpContent2 != null) {
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(getContext(), this.ivLogo, cdpContent2.getContentValue(), 0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        LogoViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), id.dana.R.layout.item_logo, viewGroup);
            LogoListAdapter.this = r2;
            this.PlaceComponentResult = new ShimmerImageAttacherFactory((byte) 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new LogoViewHolder(viewGroup);
    }
}
