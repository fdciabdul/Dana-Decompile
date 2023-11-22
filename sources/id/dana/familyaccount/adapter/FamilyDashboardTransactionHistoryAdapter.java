package id.dana.familyaccount.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.databinding.ItemListCheckHistoryTransactionBinding;
import id.dana.familyaccount.adapter.FamilyDashboardTransactionHistoryAdapter;
import id.dana.familyaccount.model.TransactionHistoryModel;
import id.dana.familyaccount.view.dashboard.FamilyCheckboxHistoryTransactionListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\n\u0010\u0006J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\b"}, d2 = {"Lid/dana/familyaccount/adapter/FamilyDashboardTransactionHistoryAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/familyaccount/model/TransactionHistoryModel;", "Lid/dana/familyaccount/adapter/FamilyDashboardTransactionHistoryAdapter$FamilyTransactionHistoryViewHolder;", "", "getAuthRequestContext", "()V", "Lid/dana/familyaccount/view/dashboard/FamilyCheckboxHistoryTransactionListener;", "Lid/dana/familyaccount/view/dashboard/FamilyCheckboxHistoryTransactionListener;", "MyBillsEntityDataFactory", "<init>", "FamilyTransactionHistoryViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyDashboardTransactionHistoryAdapter extends BaseRecyclerViewDiffUtilAdapter<TransactionHistoryModel, FamilyTransactionHistoryViewHolder> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public FamilyCheckboxHistoryTransactionListener MyBillsEntityDataFactory;

    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final /* synthetic */ FamilyTransactionHistoryViewHolder PlaceComponentResult(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemListCheckHistoryTransactionBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemListCheckHistoryTransactionBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return new FamilyTransactionHistoryViewHolder(KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/familyaccount/adapter/FamilyDashboardTransactionHistoryAdapter$FamilyTransactionHistoryViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/familyaccount/model/TransactionHistoryModel;", "Lid/dana/databinding/ItemListCheckHistoryTransactionBinding;", "getAuthRequestContext", "Lid/dana/databinding/ItemListCheckHistoryTransactionBinding;", "Lid/dana/familyaccount/view/dashboard/FamilyCheckboxHistoryTransactionListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/familyaccount/view/dashboard/FamilyCheckboxHistoryTransactionListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Lid/dana/databinding/ItemListCheckHistoryTransactionBinding;Lid/dana/familyaccount/view/dashboard/FamilyCheckboxHistoryTransactionListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class FamilyTransactionHistoryViewHolder extends BaseViewBindingViewHolder<TransactionHistoryModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final FamilyCheckboxHistoryTransactionListener KClassImpl$Data$declaredNonStaticMembers$2;
        private final ItemListCheckHistoryTransactionBinding getAuthRequestContext;

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TransactionHistoryModel transactionHistoryModel, int i) {
            final TransactionHistoryModel transactionHistoryModel2 = transactionHistoryModel;
            Intrinsics.checkNotNullParameter(transactionHistoryModel2, "");
            DanaCheckboxButtonView danaCheckboxButtonView = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            danaCheckboxButtonView.setText(transactionHistoryModel2.getAuthRequestContext);
            danaCheckboxButtonView.setChecked(transactionHistoryModel2.getBuiltInFictitiousFunctionClassFactory());
            danaCheckboxButtonView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.familyaccount.adapter.FamilyDashboardTransactionHistoryAdapter$FamilyTransactionHistoryViewHolder$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    FamilyDashboardTransactionHistoryAdapter.FamilyTransactionHistoryViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(TransactionHistoryModel.this, this, z);
                }
            });
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public FamilyTransactionHistoryViewHolder(id.dana.databinding.ItemListCheckHistoryTransactionBinding r4, id.dana.familyaccount.view.dashboard.FamilyCheckboxHistoryTransactionListener r5) {
            /*
                r3 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r0 = r4
                androidx.viewbinding.ViewBinding r0 = (androidx.viewbinding.ViewBinding) r0
                r1 = 0
                r2 = 2
                r3.<init>(r0, r1, r2, r1)
                r3.getAuthRequestContext = r4
                r3.KClassImpl$Data$declaredNonStaticMembers$2 = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.adapter.FamilyDashboardTransactionHistoryAdapter.FamilyTransactionHistoryViewHolder.<init>(id.dana.databinding.ItemListCheckHistoryTransactionBinding, id.dana.familyaccount.view.dashboard.FamilyCheckboxHistoryTransactionListener):void");
        }

        public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TransactionHistoryModel transactionHistoryModel, FamilyTransactionHistoryViewHolder familyTransactionHistoryViewHolder, boolean z) {
            Intrinsics.checkNotNullParameter(transactionHistoryModel, "");
            Intrinsics.checkNotNullParameter(familyTransactionHistoryViewHolder, "");
            transactionHistoryModel.BuiltInFictitiousFunctionClassFactory = z;
            FamilyCheckboxHistoryTransactionListener familyCheckboxHistoryTransactionListener = familyTransactionHistoryViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
            if (familyCheckboxHistoryTransactionListener != null) {
                familyCheckboxHistoryTransactionListener.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
    }

    public final void getAuthRequestContext() {
        Iterable<TransactionHistoryModel> iterable = this.getAuthRequestContext;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TransactionHistoryModel transactionHistoryModel : iterable) {
            if (!transactionHistoryModel.getBuiltInFictitiousFunctionClassFactory()) {
                transactionHistoryModel = TransactionHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2(transactionHistoryModel, true);
            }
            arrayList.add(transactionHistoryModel);
        }
        BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(this, arrayList);
    }
}
