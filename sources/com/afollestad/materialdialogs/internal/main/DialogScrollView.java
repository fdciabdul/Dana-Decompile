package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J/\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017"}, d2 = {"Lcom/afollestad/materialdialogs/internal/main/DialogScrollView;", "Landroid/widget/ScrollView;", "", "invalidateDividers", "()V", "invalidateOverScroll", "onAttachedToWindow", "", "left", "top", "oldl", "oldt", "onScrollChanged", "(IIII)V", "", "isScrollable", "()Z", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "rootView", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "getRootView", "()Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "setRootView", "(Lcom/afollestad/materialdialogs/internal/main/DialogLayout;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DialogScrollView extends ScrollView {
    private DialogLayout rootView;

    public /* synthetic */ DialogScrollView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public DialogScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    @JvmName(name = "getRootView")
    public final DialogLayout getRootView() {
        return this.rootView;
    }

    @JvmName(name = "setRootView")
    public final void setRootView(DialogLayout dialogLayout) {
        this.rootView = dialogLayout;
    }

    @JvmName(name = "isScrollable")
    private final boolean isScrollable() {
        View childAt = getChildAt(0);
        Intrinsics.checkExpressionValueIsNotNull(childAt, "");
        return childAt.getMeasuredHeight() > getHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MDUtil.INSTANCE.waitForWidth(this, new Function1<DialogScrollView, Unit>() { // from class: com.afollestad.materialdialogs.internal.main.DialogScrollView$onAttachedToWindow$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DialogScrollView dialogScrollView) {
                invoke2(dialogScrollView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DialogScrollView dialogScrollView) {
                Intrinsics.checkParameterIsNotNull(dialogScrollView, "");
                dialogScrollView.invalidateDividers();
                dialogScrollView.invalidateOverScroll();
            }
        });
    }

    @Override // android.view.View
    protected final void onScrollChanged(int left, int top, int oldl, int oldt) {
        super.onScrollChanged(left, top, oldl, oldt);
        invalidateDividers();
    }

    public final void invalidateDividers() {
        if (getChildCount() == 0 || getMeasuredHeight() == 0 || !isScrollable()) {
            DialogLayout dialogLayout = this.rootView;
            if (dialogLayout != null) {
                dialogLayout.invalidateDividers(false, false);
                return;
            }
            return;
        }
        View childAt = getChildAt(getChildCount() - 1);
        Intrinsics.checkExpressionValueIsNotNull(childAt, "");
        int bottom = childAt.getBottom();
        int measuredHeight = getMeasuredHeight();
        int scrollY = getScrollY();
        DialogLayout dialogLayout2 = this.rootView;
        if (dialogLayout2 != null) {
            dialogLayout2.invalidateDividers(getScrollY() > 0, bottom - (measuredHeight + scrollY) > 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverScroll() {
        setOverScrollMode((getChildCount() == 0 || getMeasuredHeight() == 0 || !isScrollable()) ? 2 : 1);
    }
}
