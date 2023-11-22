package id.dana.sendmoney_v2.recipient.bank.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.util.NumberUtil;
import id.dana.databinding.ItemSendNewAccountNumberSmartFrictionBinding;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.view.RecipientSelectedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/sendmoney_v2/recipient/bank/viewholder/SendWithNewAccountNumberSmartFrictionViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/sendmoney/model/RecipientViewModel;", "Lid/dana/databinding/ItemSendNewAccountNumberSmartFrictionBinding;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "Lid/dana/sendmoney/view/RecipientSelectedListener;", "getAuthRequestContext", "Lid/dana/sendmoney/view/RecipientSelectedListener;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/model/RecipientViewModel;", "PlaceComponentResult", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/sendmoney/view/RecipientSelectedListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendWithNewAccountNumberSmartFrictionViewHolder extends ViewBindingRecyclerViewHolder<RecipientViewModel, ItemSendNewAccountNumberSmartFrictionBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private RecipientViewModel PlaceComponentResult;
    public final ViewGroup MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final RecipientSelectedListener BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        RecipientViewModel recipientViewModel = (RecipientViewModel) obj;
        Intrinsics.checkNotNullParameter(recipientViewModel, "");
        this.PlaceComponentResult = recipientViewModel;
        TextView textView = getBinding().BuiltInFictitiousFunctionClassFactory;
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String str = recipientViewModel.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(str, "");
        textView.setText(NumberUtil.moveToNextValue(str));
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemSendNewAccountNumberSmartFrictionBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemSendNewAccountNumberSmartFrictionBinding PlaceComponentResult = ItemSendNewAccountNumberSmartFrictionBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SendWithNewAccountNumberSmartFrictionViewHolder(android.view.ViewGroup r3, id.dana.sendmoney.view.RecipientSelectedListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559254(0x7f0d0356, float:1.8743847E38)
            r2.<init>(r1, r0, r3)
            r2.MyBillsEntityDataFactory = r3
            r2.BuiltInFictitiousFunctionClassFactory = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.bank.viewholder.SendWithNewAccountNumberSmartFrictionViewHolder.<init>(android.view.ViewGroup, id.dana.sendmoney.view.RecipientSelectedListener):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.bank.viewholder.SendWithNewAccountNumberSmartFrictionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendWithNewAccountNumberSmartFrictionViewHolder.PlaceComponentResult(SendWithNewAccountNumberSmartFrictionViewHolder.this);
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(SendWithNewAccountNumberSmartFrictionViewHolder sendWithNewAccountNumberSmartFrictionViewHolder) {
        Intrinsics.checkNotNullParameter(sendWithNewAccountNumberSmartFrictionViewHolder, "");
        RecipientSelectedListener recipientSelectedListener = sendWithNewAccountNumberSmartFrictionViewHolder.BuiltInFictitiousFunctionClassFactory;
        if (recipientSelectedListener != null) {
            recipientSelectedListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
