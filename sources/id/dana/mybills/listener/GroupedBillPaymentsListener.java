package id.dana.mybills.listener;

import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.mybills.model.BillPaymentAdapterModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\nJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\u000eJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0007\u0010\u0011J\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/listener/GroupedBillPaymentsListener;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "Lid/dana/mybills/model/BillPaymentAdapterModel;", "p0", "", "p1", "", "PlaceComponentResult", "(Lid/dana/mybills/model/BillPaymentAdapterModel;Z)V", "", "(IZ)V", "(Lid/dana/mybills/model/BillPaymentAdapterModel;)V", "position", "onItemClick", "(I)V", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/mybills/model/BillPaymentAdapterModel;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface GroupedBillPaymentsListener extends BaseRecyclerViewHolder.OnItemClickListener {
    void KClassImpl$Data$declaredNonStaticMembers$2(int p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(BillPaymentAdapterModel p0, RecyclerView.ViewHolder p1);

    void MyBillsEntityDataFactory(int p0);

    void PlaceComponentResult(int p0, boolean p1);

    void PlaceComponentResult(BillPaymentAdapterModel p0);

    void PlaceComponentResult(BillPaymentAdapterModel p0, RecyclerView.ViewHolder p1);

    void PlaceComponentResult(BillPaymentAdapterModel p0, boolean p1);

    @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
    void onItemClick(int position);
}
