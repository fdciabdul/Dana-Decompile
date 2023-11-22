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
import id.dana.wallet_v3.view.walletcardview.DanaDealsWalletV3CardView;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/wallet_v3/vouchersandtickets/viewholder/DealsViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "item", "", "bindData", "(Lid/dana/wallet_v3/model/WalletV3CardModel;)V", "Lio/reactivex/subjects/PublishSubject;", "", "countdownPublishSubject", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;Lio/reactivex/subjects/PublishSubject;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DealsViewHolder extends BaseRecyclerViewHolder<WalletV3CardModel> {
    private final PublishSubject<Integer> countdownPublishSubject;
    private final WalletCardAssetClickListener walletCardAssetClickListener;

    public /* synthetic */ DealsViewHolder(Context context, ViewGroup viewGroup, WalletCardAssetClickListener walletCardAssetClickListener, PublishSubject publishSubject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, viewGroup, (i & 4) != 0 ? null : walletCardAssetClickListener, publishSubject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DealsViewHolder(Context context, ViewGroup viewGroup, WalletCardAssetClickListener walletCardAssetClickListener, PublishSubject<Integer> publishSubject) {
        super(context, R.layout.voucher_card_view_holder, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(publishSubject, "");
        this.walletCardAssetClickListener = walletCardAssetClickListener;
        this.countdownPublishSubject = publishSubject;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(WalletV3CardModel item) {
        super.bindData((DealsViewHolder) item);
        if (item == null || !(item instanceof VoucherAndTicketCardModel.DealsCard)) {
            return;
        }
        Context context = getContext();
        WalletCardAssetClickListener walletCardAssetClickListener = this.walletCardAssetClickListener;
        PublishSubject<Integer> publishSubject = this.countdownPublishSubject;
        Intrinsics.checkNotNullExpressionValue(context, "");
        DanaDealsWalletV3CardView danaDealsWalletV3CardView = new DanaDealsWalletV3CardView(context, walletCardAssetClickListener, (VoucherAndTicketCardModel.DealsCard) item, publishSubject, 0, 16, null);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(R.id.cl_item_wallet_container);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        danaDealsWalletV3CardView.addCardViewInto(constraintLayout);
    }
}
