package id.dana.sendmoney_v2.paymethod.viewholder;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.danah5.DanaH5;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney.paymethod.PayMethodAdapter;
import id.dana.utils.TagFormat;
import id.dana.utils.danah5.DanaH5Listener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/sendmoney_v2/paymethod/viewholder/BalanceViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/model/PayMethodModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "", "BuiltInFictitiousFunctionClassFactory", "Z", "getAuthRequestContext", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "PlaceComponentResult", "Lid/dana/sendmoney/paymethod/PayMethodAdapter$TopUpButtonListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/paymethod/PayMethodAdapter$TopUpButtonListener;", "Landroid/view/ViewGroup;", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;ZLid/dana/sendmoney/paymethod/PayMethodAdapter$TopUpButtonListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BalanceViewHolder extends BaseRecyclerViewHolder<PayMethodModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final boolean getAuthRequestContext;
    private final PayMethodAdapter.TopUpButtonListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private BaseRecyclerViewHolder.OnItemClickListener PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(PayMethodModel payMethodModel) {
        PayMethodModel payMethodModel2 = payMethodModel;
        if (payMethodModel2 != null) {
            ((RadioButton) this.itemView.findViewById(R.id.rb_selected_card)).setChecked(payMethodModel2.lookAheadTest());
            ((TextView) this.itemView.findViewById(R.id.setDrawValueAboveBar)).setText(payMethodModel2.PlaceComponentResult(getContext()));
            ((TextView) this.itemView.findViewById(R.id.SendRiskEventEntityRepository$$ExternalSyntheticLambda1)).setText(payMethodModel2.getAuthRequestContext(getContext()));
            ((RadioButton) this.itemView.findViewById(R.id.rb_selected_card)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.paymethod.viewholder.BalanceViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BalanceViewHolder.MyBillsEntityDataFactory(BalanceViewHolder.this);
                }
            });
            Button button = (Button) this.itemView.findViewById(R.id.JsonParseException_res_0x7f0a023e);
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.paymethod.viewholder.BalanceViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BalanceViewHolder.getAuthRequestContext(BalanceViewHolder.this);
                    }
                });
            }
            if (this.getAuthRequestContext) {
                return;
            }
            Button button2 = (Button) this.itemView.findViewById(R.id.TypeProjectionImpl_res_0x7f0a01a2);
            if (button2 != null) {
                button2.setVisibility(0);
            }
            ((Button) this.itemView.findViewById(R.id.TypeProjectionImpl_res_0x7f0a01a2)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.paymethod.viewholder.BalanceViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BalanceViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(BalanceViewHolder.this);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BalanceViewHolder(ViewGroup viewGroup, boolean z, PayMethodAdapter.TopUpButtonListener topUpButtonListener) {
        super(viewGroup.getContext(), R.layout.item_paymethod_balance_v2, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(topUpButtonListener, "");
        this.getAuthRequestContext = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = topUpButtonListener;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.setOnItemClickListener(p0);
        this.PlaceComponentResult = p0;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BalanceViewHolder balanceViewHolder) {
        Intrinsics.checkNotNullParameter(balanceViewHolder, "");
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = balanceViewHolder.PlaceComponentResult;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(balanceViewHolder.getAdapterPosition());
        }
    }

    public static /* synthetic */ void getAuthRequestContext(final BalanceViewHolder balanceViewHolder) {
        Intrinsics.checkNotNullParameter(balanceViewHolder, "");
        String MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory("https://m.dana.id/m/portal/topup?entryPoint={entryPoint}").MyBillsEntityDataFactory("entryPoint", "sendMoney").MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        DanaH5.startContainerFullUrl(MyBillsEntityDataFactory, new DanaH5Listener() { // from class: id.dana.sendmoney_v2.paymethod.viewholder.BalanceViewHolder$createH5AppListener$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                PayMethodAdapter.TopUpButtonListener topUpButtonListener;
                topUpButtonListener = BalanceViewHolder.this.KClassImpl$Data$declaredNonStaticMembers$2;
                topUpButtonListener.getAuthRequestContext();
            }
        });
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(BalanceViewHolder balanceViewHolder) {
        Intrinsics.checkNotNullParameter(balanceViewHolder, "");
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = balanceViewHolder.PlaceComponentResult;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(balanceViewHolder.getAdapterPosition());
        }
    }
}
