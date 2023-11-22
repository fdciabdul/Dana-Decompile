package id.dana.cashier.viewholder;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.textfield.TextInputEditText;
import id.dana.R;
import id.dana.base.ThrottledOnExecuteAction;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.cashier.view.ExpirationDateInputView;
import id.dana.databinding.ItemExpiryDateCvvBinding;
import id.dana.dialog.CVVInfoDialog;
import id.dana.utils.KeyboardHelper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00192\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B'\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0013\u0010\u0005\u001a\u00020\u000eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/cashier/viewholder/ExpiryDateCvvViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "Lid/dana/databinding/ItemExpiryDateCvvBinding;", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "getAuthRequestContext", "Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/dialog/CVVInfoDialog;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/dialog/CVVInfoDialog;", "", "I", "MyBillsEntityDataFactory", "Lid/dana/base/ThrottledOnExecuteAction;", "PlaceComponentResult", "Lkotlin/Lazy;", "Landroid/view/ViewGroup;", "p0", "p1", "", "p2", "p3", "<init>", "(Landroid/view/ViewGroup;Lid/dana/cashier/adapter/OnInsertVerifyElementsListener;ZI)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExpiryDateCvvViewHolder extends ViewBindingRecyclerViewHolder<QueryCardVerifyElementModel, ItemExpiryDateCvvBinding> {
    private CVVInfoDialog BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final OnInsertVerifyElementsListener KClassImpl$Data$declaredNonStaticMembers$2;

    public static /* synthetic */ void getAuthRequestContext() {
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        QueryCardVerifyElementModel queryCardVerifyElementModel = (QueryCardVerifyElementModel) obj;
        final TextInputEditText textInputEditText = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "");
        final TextInputEditText textInputEditText2 = textInputEditText;
        textInputEditText2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_info_grey_20, 0);
        textInputEditText2.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = ExpiryDateCvvViewHolder.BuiltInFictitiousFunctionClassFactory(AppCompatEditText.this, this, motionEvent);
                return BuiltInFictitiousFunctionClassFactory;
            }
        });
        textInputEditText2.addTextChangedListener(new TextWatcher() { // from class: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$addTextChangedListener$1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
            
                if ((r2.length() > 0) == true) goto L24;
             */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0014  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
            @Override // android.text.TextWatcher
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onTextChanged(java.lang.CharSequence r2, int r3, int r4, int r5) {
                /*
                    r1 = this;
                    r3 = 0
                    r4 = 1
                    if (r2 == 0) goto L11
                    int r5 = r2.length()
                    if (r5 <= 0) goto Lc
                    r5 = 1
                    goto Ld
                Lc:
                    r5 = 0
                Ld:
                    if (r5 != r4) goto L11
                    r5 = 1
                    goto L12
                L11:
                    r5 = 0
                L12:
                    if (r5 == 0) goto L45
                    int r5 = r2.length()
                    id.dana.cashier.viewholder.ExpiryDateCvvViewHolder r0 = id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.this
                    int r0 = id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.MyBillsEntityDataFactory(r0)
                    if (r5 != r0) goto L45
                    id.dana.cashier.viewholder.ExpiryDateCvvViewHolder r3 = id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.this
                    java.lang.Object r3 = r3.getBinding()
                    id.dana.databinding.ItemExpiryDateCvvBinding r3 = (id.dana.databinding.ItemExpiryDateCvvBinding) r3
                    com.google.android.material.textfield.TextInputLayout r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2
                    r5 = 0
                    r3.setError(r5)
                    id.dana.cashier.viewholder.ExpiryDateCvvViewHolder r3 = id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.this
                    id.dana.cashier.adapter.OnInsertVerifyElementsListener r3 = id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.BuiltInFictitiousFunctionClassFactory(r3)
                    java.lang.String r2 = r2.toString()
                    r3.MyBillsEntityDataFactory(r2)
                    id.dana.cashier.viewholder.ExpiryDateCvvViewHolder r2 = id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.this
                    id.dana.cashier.adapter.OnInsertVerifyElementsListener r2 = id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.BuiltInFictitiousFunctionClassFactory(r2)
                    r2.BuiltInFictitiousFunctionClassFactory(r4)
                    return
                L45:
                    if (r2 == 0) goto L53
                    int r2 = r2.length()
                    if (r2 <= 0) goto L4f
                    r2 = 1
                    goto L50
                L4f:
                    r2 = 0
                L50:
                    if (r2 != r4) goto L53
                    goto L54
                L53:
                    r4 = 0
                L54:
                    if (r4 == 0) goto L72
                    id.dana.cashier.viewholder.ExpiryDateCvvViewHolder r2 = id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.this
                    java.lang.Object r2 = r2.getBinding()
                    id.dana.databinding.ItemExpiryDateCvvBinding r2 = (id.dana.databinding.ItemExpiryDateCvvBinding) r2
                    com.google.android.material.textfield.TextInputLayout r2 = r2.KClassImpl$Data$declaredNonStaticMembers$2
                    androidx.appcompat.widget.AppCompatEditText r4 = r2
                    android.content.Context r4 = r4.getContext()
                    r5 = 2131956102(0x7f131186, float:1.954875E38)
                    java.lang.String r4 = r4.getString(r5)
                    java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                    r2.setError(r4)
                L72:
                    id.dana.cashier.viewholder.ExpiryDateCvvViewHolder r2 = id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.this
                    id.dana.cashier.adapter.OnInsertVerifyElementsListener r2 = id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.BuiltInFictitiousFunctionClassFactory(r2)
                    r2.BuiltInFictitiousFunctionClassFactory(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$addTextChangedListener$1.onTextChanged(java.lang.CharSequence, int, int, int):void");
            }
        });
        textInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$$ExternalSyntheticLambda3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ExpiryDateCvvViewHolder.getAuthRequestContext(ExpiryDateCvvViewHolder.this, z);
            }
        });
        textInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$$ExternalSyntheticLambda4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean PlaceComponentResult;
                PlaceComponentResult = ExpiryDateCvvViewHolder.PlaceComponentResult(TextInputEditText.this, this, i);
                return PlaceComponentResult;
            }
        });
        String str = queryCardVerifyElementModel != null ? queryCardVerifyElementModel.PlaceComponentResult : null;
        if (!(str == null || str.length() == 0)) {
            ExpirationDateInputView expirationDateInputView = getBinding().PlaceComponentResult;
            String str2 = queryCardVerifyElementModel != null ? queryCardVerifyElementModel.PlaceComponentResult : null;
            expirationDateInputView.setValue(str2 != null ? str2 : "");
            return;
        }
        getBinding().PlaceComponentResult.resetValue();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemExpiryDateCvvBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemExpiryDateCvvBinding BuiltInFictitiousFunctionClassFactory = ItemExpiryDateCvvBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExpiryDateCvvViewHolder(android.view.ViewGroup r4, id.dana.cashier.adapter.OnInsertVerifyElementsListener r5, boolean r6, int r7) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2 = 2131559097(0x7f0d02b9, float:1.8743528E38)
            r3.<init>(r1, r2, r4)
            r3.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2 r4 = new kotlin.jvm.functions.Function0<id.dana.base.ThrottledOnExecuteAction>() { // from class: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2
                static {
                    /*
                        id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2 r0 = new id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2) id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2.INSTANCE id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ id.dana.base.ThrottledOnExecuteAction invoke() {
                    /*
                        r1 = this;
                        id.dana.base.ThrottledOnExecuteAction r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2.invoke():java.lang.Object");
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final id.dana.base.ThrottledOnExecuteAction invoke() {
                    /*
                        r1 = this;
                        id.dana.base.ThrottledOnExecuteAction r0 = new id.dana.base.ThrottledOnExecuteAction
                        r0.<init>()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$throttledOnExecuteAction$2.invoke():id.dana.base.ThrottledOnExecuteAction");
                }
            }
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            kotlin.Lazy r4 = kotlin.LazyKt.lazy(r4)
            r3.getAuthRequestContext = r4
            r4 = 3
            r3.MyBillsEntityDataFactory = r4
            java.lang.Object r5 = r3.getBinding()
            id.dana.databinding.ItemExpiryDateCvvBinding r5 = (id.dana.databinding.ItemExpiryDateCvvBinding) r5
            id.dana.cashier.view.ExpirationDateInputView r5 = r5.PlaceComponentResult
            id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$setExpiryDateListener$1 r1 = new id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$setExpiryDateListener$1
            r1.<init>()
            id.dana.cashier.view.ExpirationDateInputView$OnInputDateListener r1 = (id.dana.cashier.view.ExpirationDateInputView.OnInputDateListener) r1
            r5.setListener(r1)
            r5 = 1
            if (r5 != r7) goto L61
            if (r6 == 0) goto L3c
            r4 = 4
        L3c:
            r3.MyBillsEntityDataFactory = r4
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemExpiryDateCvvBinding r4 = (id.dana.databinding.ItemExpiryDateCvvBinding) r4
            com.google.android.material.textfield.TextInputEditText r4 = r4.BuiltInFictitiousFunctionClassFactory
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.widget.EditText r4 = (android.widget.EditText) r4
            int r5 = r3.MyBillsEntityDataFactory
            id.dana.extension.view.InputExtKt.PlaceComponentResult(r4, r5)
            java.lang.Object r4 = r3.getBinding()
            id.dana.databinding.ItemExpiryDateCvvBinding r4 = (id.dana.databinding.ItemExpiryDateCvvBinding) r4
            com.google.android.material.textfield.TextInputLayout r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.view.View r4 = (android.view.View) r4
            r5 = 0
            r4.setVisibility(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder.<init>(android.view.ViewGroup, id.dana.cashier.adapter.OnInsertVerifyElementsListener, boolean, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlaceComponentResult(TextInputEditText textInputEditText, ExpiryDateCvvViewHolder expiryDateCvvViewHolder, int i) {
        Intrinsics.checkNotNullParameter(textInputEditText, "");
        Intrinsics.checkNotNullParameter(expiryDateCvvViewHolder, "");
        if (i == 6) {
            textInputEditText.clearFocus();
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(textInputEditText);
            expiryDateCvvViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(AppCompatEditText appCompatEditText, final ExpiryDateCvvViewHolder expiryDateCvvViewHolder, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "");
        Intrinsics.checkNotNullParameter(expiryDateCvvViewHolder, "");
        Intrinsics.checkNotNullParameter(motionEvent, "");
        if (motionEvent.getAction() != 0 || appCompatEditText.getCompoundDrawables()[2] == null || motionEvent.getX() < appCompatEditText.getRight() - appCompatEditText.getCompoundDrawables()[2].getBounds().width()) {
            appCompatEditText.performClick();
            return false;
        }
        Context context = expiryDateCvvViewHolder.getContext();
        if (context != null) {
            Context context2 = expiryDateCvvViewHolder.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "");
            CVVInfoDialog.Builder builder = new CVVInfoDialog.Builder(context2, new DialogInterface.OnDismissListener() { // from class: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ExpiryDateCvvViewHolder.getAuthRequestContext();
                }
            });
            String string = context.getString(R.string.card_binding_cvv_info_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            builder.MyBillsEntityDataFactory = string;
            String string2 = context.getString(R.string.card_binding_cvv_info_description, Integer.valueOf(expiryDateCvvViewHolder.MyBillsEntityDataFactory));
            Intrinsics.checkNotNullExpressionValue(string2, "");
            Intrinsics.checkNotNullParameter(string2, "");
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = string2;
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpiryDateCvvViewHolder.getAuthRequestContext(ExpiryDateCvvViewHolder.this);
                }
            };
            Intrinsics.checkNotNullParameter(onClickListener, "");
            builder.getAuthRequestContext = onClickListener;
            CVVInfoDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
            CVVInfoDialog cVVInfoDialog = new CVVInfoDialog(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, null);
            expiryDateCvvViewHolder.BuiltInFictitiousFunctionClassFactory = cVVInfoDialog;
            cVVInfoDialog.MyBillsEntityDataFactory();
        }
        return true;
    }

    public static /* synthetic */ void getAuthRequestContext(ExpiryDateCvvViewHolder expiryDateCvvViewHolder) {
        Intrinsics.checkNotNullParameter(expiryDateCvvViewHolder, "");
        CVVInfoDialog cVVInfoDialog = expiryDateCvvViewHolder.BuiltInFictitiousFunctionClassFactory;
        if (cVVInfoDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            cVVInfoDialog = null;
        }
        cVVInfoDialog.getAuthRequestContext();
    }

    public static /* synthetic */ void getAuthRequestContext(final ExpiryDateCvvViewHolder expiryDateCvvViewHolder, final boolean z) {
        Intrinsics.checkNotNullParameter(expiryDateCvvViewHolder, "");
        ((ThrottledOnExecuteAction) expiryDateCvvViewHolder.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(1, new Function0<Unit>() { // from class: id.dana.cashier.viewholder.ExpiryDateCvvViewHolder$setOnFocusChangeListener$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                OnInsertVerifyElementsListener onInsertVerifyElementsListener;
                OnInsertVerifyElementsListener onInsertVerifyElementsListener2;
                if (z) {
                    onInsertVerifyElementsListener2 = expiryDateCvvViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
                    onInsertVerifyElementsListener2.KClassImpl$Data$declaredNonStaticMembers$2(true);
                    return;
                }
                onInsertVerifyElementsListener = expiryDateCvvViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
                onInsertVerifyElementsListener.KClassImpl$Data$declaredNonStaticMembers$2(false);
            }
        }, 300L);
    }
}
