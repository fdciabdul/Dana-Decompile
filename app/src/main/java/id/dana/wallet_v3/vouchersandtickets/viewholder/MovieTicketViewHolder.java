package id.dana.wallet_v3.vouchersandtickets.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.view.walletcardview.MovieTicketWalletV3CardView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/wallet_v3/vouchersandtickets/viewholder/MovieTicketViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "item", "", "bindData", "(Lid/dana/wallet_v3/model/WalletV3CardModel;)V", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MovieTicketViewHolder extends BaseRecyclerViewHolder<WalletV3CardModel> {
    private final WalletCardAssetClickListener walletCardAssetClickListener;

    public /* synthetic */ MovieTicketViewHolder(Context context, ViewGroup viewGroup, WalletCardAssetClickListener walletCardAssetClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, (i & 4) != 0 ? null : walletCardAssetClickListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieTicketViewHolder(Context context, ViewGroup viewGroup, WalletCardAssetClickListener walletCardAssetClickListener) {
        super(context, R.layout.wallet_card_view_holder, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.walletCardAssetClickListener = walletCardAssetClickListener;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(WalletV3CardModel item) {
        super.bindData((MovieTicketViewHolder) item);
        if (item == null || !(item instanceof VoucherAndTicketCardModel.MovieTicketCard)) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        MovieTicketWalletV3CardView movieTicketWalletV3CardView = new MovieTicketWalletV3CardView(context, (VoucherAndTicketCardModel.MovieTicketCard) item, this.walletCardAssetClickListener);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(R.id.cl_item_wallet_container);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        movieTicketWalletV3CardView.addCardViewInto(constraintLayout);
    }
}
