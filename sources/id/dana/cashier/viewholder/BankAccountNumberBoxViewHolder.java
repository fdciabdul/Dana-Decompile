package id.dana.cashier.viewholder;

import android.view.View;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.databinding.ItemBankAccountNumberBoxBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/viewholder/BankAccountNumberBoxViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "Lid/dana/databinding/ItemBankAccountNumberBoxBinding;", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankAccountNumberBoxViewHolder extends ViewBindingRecyclerViewHolder<QueryCardVerifyElementModel, ItemBankAccountNumberBoxBinding> {
    private final OnInsertVerifyElementsListener BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
    
        if ((r2.length() > 0) == true) goto L13;
     */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void bindData(java.lang.Object r4) {
        /*
            r3 = this;
            id.dana.cashier.addCard.model.QueryCardVerifyElementModel r4 = (id.dana.cashier.addCard.model.QueryCardVerifyElementModel) r4
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L18
            java.lang.String r2 = r4.MyBillsEntityDataFactory
            if (r2 == 0) goto L18
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 <= 0) goto L14
            r2 = 1
            goto L15
        L14:
            r2 = 0
        L15:
            if (r2 != r0) goto L18
            goto L19
        L18:
            r0 = 0
        L19:
            if (r0 == 0) goto L31
            java.lang.Object r0 = r3.getBinding()
            id.dana.databinding.ItemBankAccountNumberBoxBinding r0 = (id.dana.databinding.ItemBankAccountNumberBoxBinding) r0
            id.dana.cashier.view.BankAccountNumberBoxView r0 = r0.BuiltInFictitiousFunctionClassFactory
            java.lang.String r4 = r4.MyBillsEntityDataFactory
            if (r4 != 0) goto L29
            java.lang.String r4 = ""
        L29:
            r0.setErrorMessage(r4)
            id.dana.cashier.adapter.OnInsertVerifyElementsListener r4 = r3.BuiltInFictitiousFunctionClassFactory
            r4.MyBillsEntityDataFactory(r1)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.BankAccountNumberBoxViewHolder.bindData(java.lang.Object):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemBankAccountNumberBoxBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemBankAccountNumberBoxBinding MyBillsEntityDataFactory = ItemBankAccountNumberBoxBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BankAccountNumberBoxViewHolder(android.view.ViewGroup r3, id.dana.cashier.adapter.OnInsertVerifyElementsListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131559048(0x7f0d0288, float:1.874343E38)
            r2.<init>(r1, r0, r3)
            r2.BuiltInFictitiousFunctionClassFactory = r4
            java.lang.Object r3 = r2.getBinding()
            id.dana.databinding.ItemBankAccountNumberBoxBinding r3 = (id.dana.databinding.ItemBankAccountNumberBoxBinding) r3
            id.dana.cashier.view.BankAccountNumberBoxView r3 = r3.BuiltInFictitiousFunctionClassFactory
            id.dana.cashier.viewholder.BankAccountNumberBoxViewHolder$listenAccountNumber$1$1 r4 = new id.dana.cashier.viewholder.BankAccountNumberBoxViewHolder$listenAccountNumber$1$1
            r4.<init>()
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r3.setInputBankNumberChangedListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.BankAccountNumberBoxViewHolder.<init>(android.view.ViewGroup, id.dana.cashier.adapter.OnInsertVerifyElementsListener):void");
    }
}
