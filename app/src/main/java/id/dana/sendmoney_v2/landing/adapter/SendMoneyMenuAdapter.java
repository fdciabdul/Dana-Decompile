package id.dana.sendmoney_v2.landing.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.SendMoneyScenarioModel;
import id.dana.sendmoney.adapter.BankPromoMenuHelper;
import id.dana.sendmoney.adapter.IBankPromoMenuHelper;
import id.dana.sendmoney_v2.landing.viewholder.MoreTransactionViewHolder;
import id.dana.sendmoney_v2.landing.viewholder.menu.PlaceholderSendMoneyMenuViewHolder;
import id.dana.sendmoney_v2.landing.viewholder.menu.SendMoneyMenuViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u0017\u0018B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/sendmoney_v2/landing/adapter/SendMoneyMenuAdapter;", "Lid/dana/sendmoney_v2/landing/adapter/ExpandableAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/model/SendMoneyScenarioModel;", "Lid/dana/sendmoney/adapter/IBankPromoMenuHelper;", "", "p0", "getItemViewType", "(I)I", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Z", "", "", "setItems", "(Ljava/util/List;)V", "Lid/dana/sendmoney/adapter/BankPromoMenuHelper;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/adapter/BankPromoMenuHelper;", "getAuthRequestContext", "p1", "<init>", "(IZ)V", "Companion", "SendMoneyMenuSelectorViewType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyMenuAdapter extends ExpandableAdapter<BaseRecyclerViewHolder<SendMoneyScenarioModel>, SendMoneyScenarioModel> implements IBankPromoMenuHelper {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final BankPromoMenuHelper getAuthRequestContext;

    public /* synthetic */ SendMoneyMenuAdapter(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        PlaceholderSendMoneyMenuViewHolder placeholderSendMoneyMenuViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == -3) {
            placeholderSendMoneyMenuViewHolder = new PlaceholderSendMoneyMenuViewHolder(viewGroup);
        } else if (i == 0) {
            placeholderSendMoneyMenuViewHolder = new SendMoneyMenuViewHolder(viewGroup);
        } else {
            placeholderSendMoneyMenuViewHolder = new MoreTransactionViewHolder(viewGroup);
        }
        return placeholderSendMoneyMenuViewHolder;
    }

    private SendMoneyMenuAdapter(int i, boolean z) {
        super(2, i, z, true);
        this.getAuthRequestContext = new BankPromoMenuHelper(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        if (getAuthRequestContext(p0)) {
            return -2;
        }
        SendMoneyScenarioModel item = getItem(p0);
        return (item == null || StringsKt.isBlank(item.KClassImpl$Data$declaredNonStaticMembers$2)) ? -3 : 0;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney_v2/landing/adapter/SendMoneyMenuAdapter$SendMoneyMenuSelectorViewType;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class SendMoneyMenuSelectorViewType {
        public static final SendMoneyMenuSelectorViewType INSTANCE = new SendMoneyMenuSelectorViewType();

        private SendMoneyMenuSelectorViewType() {
        }
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        return this.getAuthRequestContext.getMyBillsEntityDataFactory();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void setItems(List<SendMoneyScenarioModel> p0) {
        int PlaceComponentResult;
        if (p0 != null && (PlaceComponentResult = getLookAheadTest() - (p0.size() % getLookAheadTest())) > 0 && PlaceComponentResult > 0) {
            int i = 1;
            while (true) {
                String str = null;
                p0.add(new SendMoneyScenarioModel(null, null, null, null, null, false, null, null, null, false, false, str, str, null, 16383, null));
                if (i == PlaceComponentResult) {
                    break;
                }
                i++;
            }
        }
        super.setItems(p0);
    }
}
