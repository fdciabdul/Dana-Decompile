package id.dana.wallet_v3.vouchersandtickets.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.wallet_v3.model.WalletV3CardModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/wallet_v3/vouchersandtickets/viewholder/LoadingSpinnerViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/wallet_v3/model/WalletV3CardModel;", "item", "", "bindData", "(Lid/dana/wallet_v3/model/WalletV3CardModel;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/view/ViewGroup;", "parent", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LoadingSpinnerViewHolder extends BaseRecyclerViewHolder<WalletV3CardModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingSpinnerViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.loading_wallet_v3_spinner, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(WalletV3CardModel item) {
        super.bindData((LoadingSpinnerViewHolder) item);
    }
}
