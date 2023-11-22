package id.dana.sendmoney_v2.landing.viewholder.recent;

import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.griver.api.constants.GriverEvents;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.richview.CircleImageSelectionView;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney_v2.landing.view.RecipientHoldClickActionListener;
import id.dana.utils.showcase.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J%\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0004¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0004J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0004J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\tH\u0004¨\u0006\u0016"}, d2 = {"Lid/dana/sendmoney_v2/landing/viewholder/recent/TransactionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecentRecipientModel;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "loadImage", "", "url", "", "placeholder", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "onHoldItemClicked", "recentRecipientModel", "recipientHoldClickActionListener", "Lid/dana/sendmoney_v2/landing/view/RecipientHoldClickActionListener;", "setFavoriteOutline", TrackerKey.SendMoneyProperties.IS_FAVORITE, "", GriverEvents.EVENT_SET_TITLE, "title", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class TransactionViewHolder extends BaseRecyclerViewHolder<RecentRecipientModel> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransactionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_recent_transaction, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MyBillsEntityDataFactory(TransactionViewHolder transactionViewHolder, RecipientHoldClickActionListener recipientHoldClickActionListener, RecentRecipientModel recentRecipientModel) {
        Intrinsics.checkNotNullParameter(transactionViewHolder, "");
        Intrinsics.checkNotNullParameter(recipientHoldClickActionListener, "");
        Intrinsics.checkNotNullParameter(recentRecipientModel, "");
        Utils.getAuthRequestContext(transactionViewHolder.getContext(), 100L);
        recipientHoldClickActionListener.PlaceComponentResult(recentRecipientModel);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.getLogSourceName);
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(TransactionViewHolder transactionViewHolder, String str, Integer num, int i) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            num = Integer.valueOf((int) R.drawable.ic_avatar_grey_default);
        }
        transactionViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(str, num);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            CircleImageSelectionView circleImageSelectionView = (CircleImageSelectionView) this.itemView.findViewById(R.id.CheckPromoQuestFeature_res_0x7f0a0308);
            if (circleImageSelectionView != null) {
                circleImageSelectionView.loadImage(str, intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void MyBillsEntityDataFactory(boolean z) {
        if (z) {
            ((CircleImageSelectionView) this.itemView.findViewById(R.id.CheckPromoQuestFeature_res_0x7f0a0308)).setYellowBorderWithStar();
        } else {
            ((CircleImageSelectionView) this.itemView.findViewById(R.id.CheckPromoQuestFeature_res_0x7f0a0308)).removeYellowBorderWithStar();
        }
    }
}
