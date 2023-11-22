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
import id.dana.databinding.ItemEktpNumberBoxBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u000b8\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f"}, d2 = {"Lid/dana/cashier/viewholder/EktpNumberBoxViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "Lid/dana/databinding/ItemEktpNumberBoxBinding;", "", "PlaceComponentResult", "()V", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "MyBillsEntityDataFactory", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "BuiltInFictitiousFunctionClassFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "", "Z", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EktpNumberBoxViewHolder extends ViewBindingRecyclerViewHolder<QueryCardVerifyElementModel, ItemEktpNumberBoxBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final OnInsertVerifyElementsListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemEktpNumberBoxBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemEktpNumberBoxBinding authRequestContext = ItemEktpNumberBoxBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public EktpNumberBoxViewHolder(android.view.ViewGroup r4, id.dana.cashier.adapter.OnInsertVerifyElementsListener r5) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2 = 2131559093(0x7f0d02b5, float:1.874352E38)
            r3.<init>(r1, r2, r4)
            r3.BuiltInFictitiousFunctionClassFactory = r5
            r3.PlaceComponentResult = r0
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemEktpNumberBoxBinding r4 = (id.dana.databinding.ItemEktpNumberBoxBinding) r4
            com.google.android.material.textfield.TextInputLayout r4 = r4.getAuthRequestContext
            android.widget.EditText r4 = r4.getEditText()
            if (r4 == 0) goto L2f
            id.dana.cashier.viewholder.EktpNumberBoxViewHolder$$ExternalSyntheticLambda0 r5 = new id.dana.cashier.viewholder.EktpNumberBoxViewHolder$$ExternalSyntheticLambda0
            r5.<init>()
            r4.setOnFocusChangeListener(r5)
        L2f:
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemEktpNumberBoxBinding r4 = (id.dana.databinding.ItemEktpNumberBoxBinding) r4
            com.google.android.material.textfield.TextInputEditText r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            com.afollestad.materialdialogs.utils.MDUtil r5 = com.afollestad.materialdialogs.utils.MDUtil.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r0 = r4
            android.widget.EditText r0 = (android.widget.EditText) r0
            id.dana.cashier.viewholder.EktpNumberBoxViewHolder$listenEktpNumber$1$1 r1 = new id.dana.cashier.viewholder.EktpNumberBoxViewHolder$listenEktpNumber$1$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r5.textChanged(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.EktpNumberBoxViewHolder.<init>(android.view.ViewGroup, id.dana.cashier.adapter.OnInsertVerifyElementsListener):void");
    }

    private final void PlaceComponentResult() {
        Integer valueOf;
        Integer valueOf2;
        Resources resources;
        if (this.PlaceComponentResult.length() > 0) {
            valueOf = Integer.valueOf((int) R.style.f49812132017435);
            valueOf2 = Integer.valueOf((int) R.drawable.bg_rounded_red_50);
        } else if (this.getAuthRequestContext) {
            valueOf = Integer.valueOf((int) R.style.f49822132017436);
            valueOf2 = Integer.valueOf((int) R.drawable.bg_rounded_yellow_50);
        } else {
            valueOf = Integer.valueOf((int) R.style.f49862132017440);
            valueOf2 = Integer.valueOf((int) R.drawable.bg_rounded_grey_20);
        }
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().PlaceComponentResult, valueOf.intValue());
        TextInputEditText textInputEditText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Context context = getContext();
        Drawable drawable = null;
        if (context != null && (resources = context.getResources()) != null) {
            drawable = ResourcesCompat.BuiltInFictitiousFunctionClassFactory(resources, valueOf2.intValue(), null);
        }
        textInputEditText.setBackground(drawable);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(EktpNumberBoxViewHolder ektpNumberBoxViewHolder, boolean z) {
        Intrinsics.checkNotNullParameter(ektpNumberBoxViewHolder, "");
        ektpNumberBoxViewHolder.getAuthRequestContext = z;
        ektpNumberBoxViewHolder.PlaceComponentResult();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(EktpNumberBoxViewHolder ektpNumberBoxViewHolder, String str) {
        ektpNumberBoxViewHolder.PlaceComponentResult = str;
        AppCompatTextView appCompatTextView = ektpNumberBoxViewHolder.getBinding().PlaceComponentResult;
        String str2 = str;
        appCompatTextView.setText(str2);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(str2.length() == 0 ? 4 : 0);
        ektpNumberBoxViewHolder.PlaceComponentResult();
    }
}
