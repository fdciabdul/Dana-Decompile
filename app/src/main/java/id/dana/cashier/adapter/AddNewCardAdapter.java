package id.dana.cashier.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.cashier.viewholder.AddNewCardEmptyViewHolder;
import id.dana.cashier.viewholder.BankAccountNumberViewHolder;
import id.dana.cashier.viewholder.BankPhoneNumberViewHolder;
import id.dana.cashier.viewholder.DailyLimitViewHolder;
import id.dana.cashier.viewholder.EktpNumberViewHolder;
import id.dana.cashier.viewholder.ExpiryDateCvvViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0012\u0010\t\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/cashier/adapter/AddNewCardAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "", "p0", "getItemViewType", "(I)I", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "getAuthRequestContext", "", "MyBillsEntityDataFactory", "Z", "<init>", "(Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddNewCardAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<QueryCardVerifyElementModel>, QueryCardVerifyElementModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final OnInsertVerifyElementsListener getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        BaseRecyclerViewHolder baseRecyclerViewHolder = (BaseRecyclerViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(baseRecyclerViewHolder, "");
        Intrinsics.checkNotNullParameter(list, "");
        if ((baseRecyclerViewHolder instanceof BankAccountNumberViewHolder) && (!list.isEmpty()) != false) {
            QueryCardVerifyElementModel item = getItem(i);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next(), "ERROR_MESSAGE")) {
                    BankAccountNumberViewHolder bankAccountNumberViewHolder = (BankAccountNumberViewHolder) baseRecyclerViewHolder;
                    String str = item.MyBillsEntityDataFactory;
                    if (str == null) {
                        str = "";
                    }
                    Intrinsics.checkNotNullParameter(str, "");
                    bankAccountNumberViewHolder.getBinding().getAuthRequestContext.setErrorMessage(str);
                    bankAccountNumberViewHolder.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(false);
                }
            }
            return;
        }
        super.onBindViewHolder(baseRecyclerViewHolder, i, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        BankPhoneNumberViewHolder bankPhoneNumberViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    bankPhoneNumberViewHolder = new EktpNumberViewHolder(viewGroup, this.getAuthRequestContext);
                } else if (i == 3) {
                    bankPhoneNumberViewHolder = new DailyLimitViewHolder(viewGroup, this.getAuthRequestContext);
                } else if (i != 4) {
                    if (i == 5) {
                        bankPhoneNumberViewHolder = new BankAccountNumberViewHolder(viewGroup, this.getAuthRequestContext);
                    } else {
                        bankPhoneNumberViewHolder = new AddNewCardEmptyViewHolder(viewGroup);
                    }
                }
            }
            bankPhoneNumberViewHolder = new ExpiryDateCvvViewHolder(viewGroup, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, i);
        } else {
            bankPhoneNumberViewHolder = new BankPhoneNumberViewHolder(viewGroup, this.getAuthRequestContext);
        }
        return bankPhoneNumberViewHolder;
    }

    public AddNewCardAdapter(OnInsertVerifyElementsListener onInsertVerifyElementsListener) {
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
