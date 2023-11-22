package id.dana.wallet_v3.vouchersandtickets.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.util.SwipeHelper;
import id.dana.wallet_v3.vouchersandtickets.adapter.VouchersAndTicketsAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/wallet_v3/vouchersandtickets/view/VouchersAndTicketsDetailFragment$initView$2;", "Lid/dana/wallet_v3/util/SwipeHelper;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "Lid/dana/wallet_v3/util/SwipeHelper$UnderlayButton;", "underlayButtons", "", "instantiateUnderlayButton", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VouchersAndTicketsDetailFragment$initView$2 extends SwipeHelper {
    final /* synthetic */ VouchersAndTicketsDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VouchersAndTicketsDetailFragment$initView$2(VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment, Context context, RecyclerView recyclerView, List<? extends VoucherAndTicketCardModel> list, VouchersAndTicketsDetailFragment$initView$3 vouchersAndTicketsDetailFragment$initView$3) {
        super(context, recyclerView, list, vouchersAndTicketsDetailFragment$initView$3);
        this.this$0 = vouchersAndTicketsDetailFragment;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
    }

    @Override // id.dana.wallet_v3.util.SwipeHelper
    public final void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, List<SwipeHelper.UnderlayButton> underlayButtons) {
        Drawable BuiltInFictitiousFunctionClassFactory;
        if (underlayButtons != null) {
            BaseActivity baseActivity = this.this$0.getBaseActivity();
            String string = baseActivity != null ? baseActivity.getString(R.string.wallet_btn_delete_voucher) : null;
            BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(this.this$0.requireContext(), R.drawable.ic_delete_voucher);
            int BuiltInFictitiousFunctionClassFactory2 = ContextCompat.BuiltInFictitiousFunctionClassFactory(this.this$0.requireContext(), R.color.f23942131099989);
            final VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment = this.this$0;
            underlayButtons.add(new SwipeHelper.UnderlayButton(string, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, new SwipeHelper.UnderlayButtonClickListener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$initView$2$$ExternalSyntheticLambda0
                @Override // id.dana.wallet_v3.util.SwipeHelper.UnderlayButtonClickListener
                public final void onClick(int i) {
                    VouchersAndTicketsDetailFragment$initView$2.m3148instantiateUnderlayButton$lambda0(VouchersAndTicketsDetailFragment.this, i);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: instantiateUnderlayButton$lambda-0  reason: not valid java name */
    public static final void m3148instantiateUnderlayButton$lambda0(final VouchersAndTicketsDetailFragment vouchersAndTicketsDetailFragment, int i) {
        VouchersAndTicketsAdapter vouchersAndTicketsAdapter;
        Intrinsics.checkNotNullParameter(vouchersAndTicketsDetailFragment, "");
        vouchersAndTicketsAdapter = vouchersAndTicketsDetailFragment.getVouchersAndTicketsAdapter();
        WalletV3CardModel item = vouchersAndTicketsAdapter.getItem(i);
        vouchersAndTicketsDetailFragment.deleteVoucherConfirmationDialog(i, item instanceof VoucherAndTicketCardModel ? (VoucherAndTicketCardModel) item : null, new Function0<Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment$initView$2$instantiateUnderlayButton$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VouchersAndTicketsAdapter vouchersAndTicketsAdapter2;
                vouchersAndTicketsAdapter2 = VouchersAndTicketsDetailFragment.this.getVouchersAndTicketsAdapter();
                vouchersAndTicketsAdapter2.notifyDataSetChanged();
            }
        });
    }
}
