package id.dana.sendmoney_v2.landing.viewholder.recent;

import android.view.View;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney_v2.landing.view.RecipientHoldClickActionListener;

/* loaded from: classes5.dex */
public final /* synthetic */ class TransactionViewHolder$$ExternalSyntheticLambda0 implements View.OnLongClickListener {
    public final /* synthetic */ RecipientHoldClickActionListener KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ TransactionViewHolder MyBillsEntityDataFactory;
    public final /* synthetic */ RecentRecipientModel PlaceComponentResult;

    public /* synthetic */ TransactionViewHolder$$ExternalSyntheticLambda0(TransactionViewHolder transactionViewHolder, RecipientHoldClickActionListener recipientHoldClickActionListener, RecentRecipientModel recentRecipientModel) {
        this.MyBillsEntityDataFactory = transactionViewHolder;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recipientHoldClickActionListener;
        this.PlaceComponentResult = recentRecipientModel;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        boolean MyBillsEntityDataFactory;
        MyBillsEntityDataFactory = TransactionViewHolder.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
        return MyBillsEntityDataFactory;
    }
}
