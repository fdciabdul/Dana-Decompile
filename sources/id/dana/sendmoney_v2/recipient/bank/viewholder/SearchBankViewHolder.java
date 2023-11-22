package id.dana.sendmoney_v2.recipient.bank.viewholder;

import android.view.ViewGroup;
import id.dana.sendmoney.bank.all.BankViewHolder;
import id.dana.sendmoney.view.RecipientSelectedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney_v2/recipient/bank/viewholder/SearchBankViewHolder;", "Lid/dana/sendmoney/bank/all/BankViewHolder;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/view/RecipientSelectedListener;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/sendmoney/view/RecipientSelectedListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchBankViewHolder extends BankViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBankViewHolder(ViewGroup viewGroup, RecipientSelectedListener recipientSelectedListener) {
        super(viewGroup, recipientSelectedListener);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.ivChangeIcon.setVisibility(8);
        this.vDividerFull.setVisibility(8);
        this.vDividerWithMargin.setVisibility(0);
    }
}
