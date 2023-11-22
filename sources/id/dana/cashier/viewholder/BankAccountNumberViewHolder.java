package id.dana.cashier.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.databinding.ItemBankAccountBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/viewholder/BankAccountNumberViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "Lid/dana/databinding/ItemBankAccountBinding;", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankAccountNumberViewHolder extends ViewBindingRecyclerViewHolder<QueryCardVerifyElementModel, ItemBankAccountBinding> {
    public final OnInsertVerifyElementsListener BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemBankAccountBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemBankAccountBinding authRequestContext = ItemBankAccountBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BankAccountNumberViewHolder(android.view.ViewGroup r3, id.dana.cashier.adapter.OnInsertVerifyElementsListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559047(0x7f0d0287, float:1.8743427E38)
            r2.<init>(r1, r0, r3)
            r2.BuiltInFictitiousFunctionClassFactory = r4
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemBankAccountBinding r3 = (id.dana.databinding.ItemBankAccountBinding) r3
            id.dana.cashier.view.BankAccountNumberView r3 = r3.getAuthRequestContext
            id.dana.cashier.viewholder.BankAccountNumberViewHolder$listenAccountNumber$1$1 r4 = new id.dana.cashier.viewholder.BankAccountNumberViewHolder$listenAccountNumber$1$1
            r4.<init>()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r3.setInputBankNumberChangedListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.BankAccountNumberViewHolder.<init>(android.view.ViewGroup, id.dana.cashier.adapter.OnInsertVerifyElementsListener):void");
    }
}
