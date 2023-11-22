package id.dana.sendmoney_v2.landing.viewholder.recent;

import android.view.ViewGroup;
import id.dana.R;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney_v2.landing.view.RecipientHoldClickActionListener;
import id.dana.utils.MaskedTextUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney_v2/landing/viewholder/recent/BankTransactionViewHolder;", "Lid/dana/sendmoney_v2/landing/viewholder/recent/TransactionViewHolder;", "Lid/dana/sendmoney_v2/landing/view/RecipientHoldClickActionListener;", "PlaceComponentResult", "Lid/dana/sendmoney_v2/landing/view/RecipientHoldClickActionListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/sendmoney_v2/landing/view/RecipientHoldClickActionListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankTransactionViewHolder extends TransactionViewHolder {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final RecipientHoldClickActionListener KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(RecentRecipientModel recentRecipientModel) {
        RecentRecipientModel recentRecipientModel2 = recentRecipientModel;
        if (recentRecipientModel2 != null) {
            String str = recentRecipientModel2.getAuthRequestContext;
            if (str == null && (str = recentRecipientModel2.NetworkUserEntityData$$ExternalSyntheticLambda0()) == null) {
                str = "";
            }
            String PlaceComponentResult = MaskedTextUtil.PlaceComponentResult(str);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            getAuthRequestContext(PlaceComponentResult);
            String BuiltInFictitiousFunctionClassFactory = recentRecipientModel2.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory == null) {
                BuiltInFictitiousFunctionClassFactory = "";
            }
            KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory, Integer.valueOf((int) R.drawable.ic_bank_placeholder));
            RecipientHoldClickActionListener recipientHoldClickActionListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (recipientHoldClickActionListener != null) {
                Intrinsics.checkNotNullParameter(recentRecipientModel2, "");
                Intrinsics.checkNotNullParameter(recipientHoldClickActionListener, "");
                this.itemView.setOnLongClickListener(new TransactionViewHolder$$ExternalSyntheticLambda0(this, recipientHoldClickActionListener, recentRecipientModel2));
            }
            MyBillsEntityDataFactory(recentRecipientModel2.getErrorConfigVersion());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankTransactionViewHolder(ViewGroup viewGroup, RecipientHoldClickActionListener recipientHoldClickActionListener) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recipientHoldClickActionListener;
    }
}
