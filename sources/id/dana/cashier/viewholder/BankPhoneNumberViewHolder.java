package id.dana.cashier.viewholder;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.databinding.ItemBankPhoneNumberBinding;
import id.dana.utils.KeyboardHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/viewholder/BankPhoneNumberViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "Lid/dana/databinding/ItemBankPhoneNumberBinding;", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "PlaceComponentResult", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankPhoneNumberViewHolder extends ViewBindingRecyclerViewHolder<QueryCardVerifyElementModel, ItemBankPhoneNumberBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final OnInsertVerifyElementsListener MyBillsEntityDataFactory;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemBankPhoneNumberBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemBankPhoneNumberBinding authRequestContext = ItemBankPhoneNumberBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BankPhoneNumberViewHolder(android.view.ViewGroup r4, id.dana.cashier.adapter.OnInsertVerifyElementsListener r5) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2 = 2131559049(0x7f0d0289, float:1.8743431E38)
            r3.<init>(r1, r2, r4)
            r3.MyBillsEntityDataFactory = r5
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemBankPhoneNumberBinding r4 = (id.dana.databinding.ItemBankPhoneNumberBinding) r4
            com.google.android.material.textfield.TextInputEditText r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            r5 = 0
            r4.setTransformationMethod(r5)
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemBankPhoneNumberBinding r4 = (id.dana.databinding.ItemBankPhoneNumberBinding) r4
            com.google.android.material.textfield.TextInputEditText r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            android.widget.EditText r4 = (android.widget.EditText) r4
            id.dana.textbehavior.TextBehavior$EditTextBehaviorBuilder r4 = id.dana.textbehavior.TextBehavior.Builder.PlaceComponentResult(r4)
            id.dana.cashier.viewholder.BankPhoneNumberViewHolder$createMinimumInputValidator$1 r5 = new id.dana.cashier.viewholder.BankPhoneNumberViewHolder$createMinimumInputValidator$1
            r5.<init>()
            id.dana.textbehavior.validate.Validator r5 = (id.dana.textbehavior.validate.Validator) r5
            java.util.List<id.dana.textbehavior.validate.Validator> r1 = r4.BuiltInFictitiousFunctionClassFactory
            if (r1 != 0) goto L43
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r4.BuiltInFictitiousFunctionClassFactory = r1
        L43:
            java.util.List<id.dana.textbehavior.validate.Validator> r1 = r4.BuiltInFictitiousFunctionClassFactory
            r1.add(r5)
            id.dana.cashier.viewholder.BankPhoneNumberViewHolder$createOnInputValidatedListener$1 r5 = new id.dana.cashier.viewholder.BankPhoneNumberViewHolder$createOnInputValidatedListener$1
            r5.<init>()
            id.dana.textbehavior.OnValidatedListener r5 = (id.dana.textbehavior.OnValidatedListener) r5
            r4.MyBillsEntityDataFactory = r5
            r4.KClassImpl$Data$declaredNonStaticMembers$2()
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemBankPhoneNumberBinding r4 = (id.dana.databinding.ItemBankPhoneNumberBinding) r4
            com.google.android.material.textfield.TextInputLayout r4 = r4.getAuthRequestContext
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemBankPhoneNumberBinding r4 = (id.dana.databinding.ItemBankPhoneNumberBinding) r4
            com.google.android.material.textfield.TextInputLayout r4 = r4.getAuthRequestContext
            android.widget.EditText r5 = r4.getEditText()
            if (r5 == 0) goto L75
            id.dana.cashier.viewholder.BankPhoneNumberViewHolder$$ExternalSyntheticLambda1 r0 = new id.dana.cashier.viewholder.BankPhoneNumberViewHolder$$ExternalSyntheticLambda1
            r0.<init>()
            r5.setOnFocusChangeListener(r0)
        L75:
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemBankPhoneNumberBinding r4 = (id.dana.databinding.ItemBankPhoneNumberBinding) r4
            com.google.android.material.textfield.TextInputLayout r4 = r4.getAuthRequestContext
            android.widget.EditText r5 = r4.getEditText()
            if (r5 == 0) goto L8d
            id.dana.cashier.viewholder.BankPhoneNumberViewHolder$$ExternalSyntheticLambda0 r0 = new id.dana.cashier.viewholder.BankPhoneNumberViewHolder$$ExternalSyntheticLambda0
            r0.<init>()
            r5.setOnEditorActionListener(r0)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.BankPhoneNumberViewHolder.<init>(android.view.ViewGroup, id.dana.cashier.adapter.OnInsertVerifyElementsListener):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(TextInputLayout textInputLayout, int i) {
        Intrinsics.checkNotNullParameter(textInputLayout, "");
        if (i == 6) {
            textInputLayout.clearFocus();
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(textInputLayout);
            return true;
        }
        return false;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TextInputLayout textInputLayout, boolean z) {
        String string;
        Intrinsics.checkNotNullParameter(textInputLayout, "");
        if (!z) {
            EditText editText = textInputLayout.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            if (text == null || text.length() == 0) {
                string = textInputLayout.getContext().getString(R.string.registered_phone_number_in_bank);
                textInputLayout.setHint(string);
            }
        }
        string = textInputLayout.getContext().getString(R.string.phone_number);
        textInputLayout.setHint(string);
    }
}
