package id.dana.kyb.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.data.constant.DanaUrl;
import id.dana.kyb.adapter.KybTransactionHistoryAdapter;
import id.dana.kyb.helper.KybUrlsDataManager;
import id.dana.kyb.model.KybOrderTypeModel;
import id.dana.kyb.model.KybTransactionModel;
import id.dana.kyb.view.MyBusinessFragment;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000b2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000b\fB\u0013\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/kyb/adapter/KybTransactionHistoryAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/kyb/model/KybTransactionModel;", "Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;", "MyBillsEntityDataFactory", "Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;)V", "Companion", "ViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybTransactionHistoryAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<KybTransactionModel>, KybTransactionModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public MyBusinessFragment.KybOpenH5Listener PlaceComponentResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.kyb.view.MyBusinessFragment$KybOpenH5Listener] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KybTransactionHistoryAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.adapter.KybTransactionHistoryAdapter.<init>():void");
    }

    public /* synthetic */ KybTransactionHistoryAdapter(MyBusinessFragment.KybOpenH5Listener kybOpenH5Listener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kybOpenH5Listener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new ViewHolder(this.PlaceComponentResult, viewGroup);
    }

    private KybTransactionHistoryAdapter(MyBusinessFragment.KybOpenH5Listener kybOpenH5Listener) {
        this.PlaceComponentResult = kybOpenH5Listener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/kyb/adapter/KybTransactionHistoryAdapter$ViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/kyb/model/KybTransactionModel;", "Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;", "PlaceComponentResult", "p0", "Landroid/view/ViewGroup;", "p1", "<init>", "(Lid/dana/kyb/view/MyBusinessFragment$KybOpenH5Listener;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ViewHolder extends BaseRecyclerViewHolder<KybTransactionModel> {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final MyBusinessFragment.KybOpenH5Listener PlaceComponentResult;

        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(KybTransactionModel kybTransactionModel) {
            final KybTransactionModel kybTransactionModel2 = kybTransactionModel;
            TextView textView = (TextView) this.itemView.findViewById(R.id.tv_kyb_order_type);
            TextView textView2 = (TextView) this.itemView.findViewById(R.id.tv_kyb_order_title);
            TextView textView3 = (TextView) this.itemView.findViewById(R.id.tv_kyb_order_amount);
            TextView textView4 = (TextView) this.itemView.findViewById(R.id.tv_kyb_order_time);
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.iv_kyb_order_type);
            ViewGroup viewGroup = (ViewGroup) this.itemView.findViewById(R.id.vg_offus_status);
            if (kybTransactionModel2 != null) {
                textView2.setText(kybTransactionModel2.scheduleImpl);
                textView3.setText(kybTransactionModel2.BuiltInFictitiousFunctionClassFactory);
                textView4.setText(kybTransactionModel2.getAuthRequestContext);
                KybOrderTypeModel kybOrderTypeModel = kybTransactionModel2.lookAheadTest;
                textView.setText(kybOrderTypeModel.getAuthRequestContext);
                appCompatImageView.setImageDrawable(kybOrderTypeModel.BuiltInFictitiousFunctionClassFactory);
                Integer num = kybOrderTypeModel.PlaceComponentResult;
                if (num != null) {
                    appCompatImageView.setContentDescription(getContext().getString(num.intValue()));
                }
                Intrinsics.checkNotNullExpressionValue(viewGroup, "");
                viewGroup.setVisibility(kybTransactionModel2.getKClassImpl$Data$declaredNonStaticMembers$2() && Intrinsics.areEqual(kybTransactionModel2.getErrorConfigVersion, "WAIT_FOR_TRANSFER") ? 0 : 8);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.adapter.KybTransactionHistoryAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KybTransactionHistoryAdapter.ViewHolder.BuiltInFictitiousFunctionClassFactory(KybTransactionModel.this, this);
                }
            });
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(MyBusinessFragment.KybOpenH5Listener kybOpenH5Listener, ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_kyb_transaction_history, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            this.PlaceComponentResult = kybOpenH5Listener;
        }

        public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(KybTransactionModel kybTransactionModel, ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "");
            if (Intrinsics.areEqual(kybTransactionModel != null ? kybTransactionModel.PlaceComponentResult : null, "SUCCESS")) {
                String str = kybTransactionModel.MyBillsEntityDataFactory;
                MyBusinessFragment.KybOpenH5Listener kybOpenH5Listener = viewHolder.PlaceComponentResult;
                if (kybOpenH5Listener != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(DanaUrl.KYB_DETAIL_TRANSACTION_HISTORY, Arrays.copyOf(new Object[]{str}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    kybOpenH5Listener.BuiltInFictitiousFunctionClassFactory(KybUrlsDataManager.getAuthRequestContext(format));
                }
            }
        }
    }
}
