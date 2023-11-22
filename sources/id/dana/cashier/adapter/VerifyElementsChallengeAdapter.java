package id.dana.cashier.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.cashier.viewholder.AddNewCardEmptyViewHolder;
import id.dana.cashier.viewholder.BankAccountNumberBoxViewHolder;
import id.dana.cashier.viewholder.BankPhoneNumberBoxViewHolder;
import id.dana.cashier.viewholder.DailyLimitBoxViewHolder;
import id.dana.cashier.viewholder.EktpNumberBoxViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/adapter/VerifyElementsChallengeAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "", "p0", "getItemViewType", "(I)I", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "PlaceComponentResult", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "getAuthRequestContext", "<init>", "(Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyElementsChallengeAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<QueryCardVerifyElementModel>, QueryCardVerifyElementModel> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final OnInsertVerifyElementsListener getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        BankPhoneNumberBoxViewHolder bankPhoneNumberBoxViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            bankPhoneNumberBoxViewHolder = new BankPhoneNumberBoxViewHolder(viewGroup, this.getAuthRequestContext);
        } else if (i == 5) {
            bankPhoneNumberBoxViewHolder = new BankAccountNumberBoxViewHolder(viewGroup, this.getAuthRequestContext);
        } else if (i == 2) {
            bankPhoneNumberBoxViewHolder = new EktpNumberBoxViewHolder(viewGroup, this.getAuthRequestContext);
        } else if (i == 3) {
            bankPhoneNumberBoxViewHolder = new DailyLimitBoxViewHolder(viewGroup, this.getAuthRequestContext);
        } else {
            bankPhoneNumberBoxViewHolder = new AddNewCardEmptyViewHolder(viewGroup);
        }
        return bankPhoneNumberBoxViewHolder;
    }

    public VerifyElementsChallengeAdapter(OnInsertVerifyElementsListener onInsertVerifyElementsListener) {
        Intrinsics.checkNotNullParameter(onInsertVerifyElementsListener, "");
        this.getAuthRequestContext = onInsertVerifyElementsListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        QueryCardVerifyElementModel item = getItem(p0);
        if (item != null) {
            return item.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return 0;
    }
}
