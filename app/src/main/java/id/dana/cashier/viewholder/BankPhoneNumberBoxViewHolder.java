package id.dana.cashier.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.textfield.TextInputEditText;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.databinding.ItemBankPhoneNumberBoxBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e"}, d2 = {"Lid/dana/cashier/viewholder/BankPhoneNumberBoxViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "Lid/dana/databinding/ItemBankPhoneNumberBoxBinding;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "", "getAuthRequestContext", "Ljava/lang/String;", "", "Z", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankPhoneNumberBoxViewHolder extends ViewBindingRecyclerViewHolder<QueryCardVerifyElementModel, ItemBankPhoneNumberBoxBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final OnInsertVerifyElementsListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    private String getAuthRequestContext;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemBankPhoneNumberBoxBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemBankPhoneNumberBoxBinding authRequestContext = ItemBankPhoneNumberBoxBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BankPhoneNumberBoxViewHolder(android.view.ViewGroup r4, id.dana.cashier.adapter.OnInsertVerifyElementsListener r5) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2 = 2131559050(0x7f0d028a, float:1.8743433E38)
            r3.<init>(r1, r2, r4)
            r3.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            r3.getAuthRequestContext = r0
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemBankPhoneNumberBoxBinding r4 = (id.dana.databinding.ItemBankPhoneNumberBoxBinding) r4
            com.google.android.material.textfield.TextInputEditText r4 = r4.getAuthRequestContext
            r5 = 0
            r4.setTransformationMethod(r5)
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemBankPhoneNumberBoxBinding r4 = (id.dana.databinding.ItemBankPhoneNumberBoxBinding) r4
            com.google.android.material.textfield.TextInputEditText r4 = r4.getAuthRequestContext
            android.widget.EditText r4 = (android.widget.EditText) r4
            id.dana.textbehavior.TextBehavior$EditTextBehaviorBuilder r4 = id.dana.textbehavior.TextBehavior.Builder.PlaceComponentResult(r4)
            id.dana.cashier.viewholder.BankPhoneNumberBoxViewHolder$createMinimumInputValidator$1 r5 = new id.dana.cashier.viewholder.BankPhoneNumberBoxViewHolder$createMinimumInputValidator$1
            r5.<init>()
            id.dana.textbehavior.validate.Validator r5 = (id.dana.textbehavior.validate.Validator) r5
            java.util.List<id.dana.textbehavior.validate.Validator> r0 = r4.BuiltInFictitiousFunctionClassFactory
            if (r0 != 0) goto L45
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4.BuiltInFictitiousFunctionClassFactory = r0
        L45:
            java.util.List<id.dana.textbehavior.validate.Validator> r0 = r4.BuiltInFictitiousFunctionClassFactory
            r0.add(r5)
            id.dana.cashier.viewholder.BankPhoneNumberBoxViewHolder$createOnInputValidatedListener$1 r5 = new id.dana.cashier.viewholder.BankPhoneNumberBoxViewHolder$createOnInputValidatedListener$1
            r5.<init>()
            id.dana.textbehavior.OnValidatedListener r5 = (id.dana.textbehavior.OnValidatedListener) r5
            r4.MyBillsEntityDataFactory = r5
            r4.KClassImpl$Data$declaredNonStaticMembers$2()
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemBankPhoneNumberBoxBinding r4 = (id.dana.databinding.ItemBankPhoneNumberBoxBinding) r4
            com.google.android.material.textfield.TextInputLayout r4 = r4.PlaceComponentResult
            android.widget.EditText r4 = r4.getEditText()
            if (r4 == 0) goto L6c
            id.dana.cashier.viewholder.BankPhoneNumberBoxViewHolder$$ExternalSyntheticLambda0 r5 = new id.dana.cashier.viewholder.BankPhoneNumberBoxViewHolder$$ExternalSyntheticLambda0
            r5.<init>()
            r4.setOnFocusChangeListener(r5)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.BankPhoneNumberBoxViewHolder.<init>(android.view.ViewGroup, id.dana.cashier.adapter.OnInsertVerifyElementsListener):void");
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        Integer valueOf;
        Integer valueOf2;
        Resources resources;
        if (this.getAuthRequestContext.length() > 0) {
            valueOf = Integer.valueOf((int) R.style.f49812132017435);
            valueOf2 = Integer.valueOf((int) R.drawable.bg_rounded_red_50);
        } else if (this.MyBillsEntityDataFactory) {
            valueOf = Integer.valueOf((int) R.style.f49822132017436);
            valueOf2 = Integer.valueOf((int) R.drawable.bg_rounded_yellow_50);
        } else {
            valueOf = Integer.valueOf((int) R.style.f49862132017440);
            valueOf2 = Integer.valueOf((int) R.drawable.bg_rounded_grey_20);
        }
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().KClassImpl$Data$declaredNonStaticMembers$2, valueOf.intValue());
        TextInputEditText textInputEditText = getBinding().getAuthRequestContext;
        Context context = getContext();
        Drawable drawable = null;
        if (context != null && (resources = context.getResources()) != null) {
            drawable = ResourcesCompat.BuiltInFictitiousFunctionClassFactory(resources, valueOf2.intValue(), null);
        }
        textInputEditText.setBackground(drawable);
    }

    public static /* synthetic */ void getAuthRequestContext(BankPhoneNumberBoxViewHolder bankPhoneNumberBoxViewHolder, boolean z) {
        Intrinsics.checkNotNullParameter(bankPhoneNumberBoxViewHolder, "");
        bankPhoneNumberBoxViewHolder.MyBillsEntityDataFactory = z;
        bankPhoneNumberBoxViewHolder.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void getAuthRequestContext(BankPhoneNumberBoxViewHolder bankPhoneNumberBoxViewHolder, String str) {
        bankPhoneNumberBoxViewHolder.getAuthRequestContext = str;
        AppCompatTextView appCompatTextView = bankPhoneNumberBoxViewHolder.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        String str2 = str;
        appCompatTextView.setText(str2);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(str2.length() == 0 ? 4 : 0);
        bankPhoneNumberBoxViewHolder.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
