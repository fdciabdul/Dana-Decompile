package com.afollestad.materialdialogs.internal.list;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0010\u0010\bJ/\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R>\u0010\u001b\u001a*\u0012\u000b\u0012\t\u0018\u00010\n¢\u0006\u0002\b\u0019\u0012\u000b\u0012\t\u0018\u00010\n¢\u0006\u0002\b\u0019\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0018j\u0004\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "dialog", "", "attach", "(Lcom/afollestad/materialdialogs/MaterialDialog;)V", "invalidateDividers", "()V", "invalidateOverScroll", "", "isAtBottom", "()Z", "isAtTop", "isScrollable", "onAttachedToWindow", "onDetachedFromWindow", "", "left", "top", "oldl", "oldt", "onScrollChanged", "(IIII)V", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Lcom/afollestad/materialdialogs/internal/list/InvalidateDividersDelegate;", "invalidateDividersDelegate", "Lkotlin/jvm/functions/Function2;", "Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView$scrollListeners$1;", "scrollListeners", "Lcom/afollestad/materialdialogs/internal/list/DialogRecyclerView$scrollListeners$1;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DialogRecyclerView extends RecyclerView {
    private Function2<? super Boolean, ? super Boolean, Unit> invalidateDividersDelegate;
    private final DialogRecyclerView$scrollListeners$1 scrollListeners;

    public /* synthetic */ DialogRecyclerView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.afollestad.materialdialogs.internal.list.DialogRecyclerView$scrollListeners$1] */
    public DialogRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "");
        this.scrollListeners = new RecyclerView.OnScrollListener() { // from class: com.afollestad.materialdialogs.internal.list.DialogRecyclerView$scrollListeners$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkParameterIsNotNull(recyclerView, "");
                super.onScrolled(recyclerView, dx, dy);
                DialogRecyclerView.this.invalidateDividers();
            }
        };
    }

    public final void attach(MaterialDialog dialog) {
        Intrinsics.checkParameterIsNotNull(dialog, "");
        this.invalidateDividersDelegate = new DialogRecyclerView$attach$1(dialog);
    }

    public final void invalidateDividers() {
        Function2<? super Boolean, ? super Boolean, Unit> function2;
        if (getChildCount() == 0 || getMeasuredHeight() == 0 || (function2 = this.invalidateDividersDelegate) == null) {
            return;
        }
        function2.invoke(Boolean.valueOf(!isAtTop()), Boolean.valueOf(!isAtBottom()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MDUtil.INSTANCE.waitForWidth(this, new Function1<DialogRecyclerView, Unit>() { // from class: com.afollestad.materialdialogs.internal.list.DialogRecyclerView$onAttachedToWindow$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DialogRecyclerView dialogRecyclerView) {
                invoke2(dialogRecyclerView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DialogRecyclerView dialogRecyclerView) {
                Intrinsics.checkParameterIsNotNull(dialogRecyclerView, "");
                dialogRecyclerView.invalidateDividers();
                dialogRecyclerView.invalidateOverScroll();
            }
        });
        addOnScrollListener(this.scrollListeners);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeOnScrollListener(this.scrollListeners);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected final void onScrollChanged(int left, int top, int oldl, int oldt) {
        super.onScrollChanged(left, top, oldl, oldt);
        invalidateDividers();
    }

    private final boolean isAtTop() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        return !(layoutManager instanceof LinearLayoutManager) ? !((layoutManager instanceof GridLayoutManager) && ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0) : ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() != 0;
    }

    private final boolean isAtBottom() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(adapter, "");
        int placeComponentResult = adapter.getPlaceComponentResult() - 1;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == placeComponentResult) {
                return true;
            }
        } else if ((layoutManager instanceof GridLayoutManager) && ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition() == placeComponentResult) {
            return true;
        }
        return false;
    }

    private final boolean isScrollable() {
        return isAtBottom() && isAtTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateOverScroll() {
        int i = 2;
        if (getChildCount() != 0 && getMeasuredHeight() != 0 && !isScrollable()) {
            i = 1;
        }
        setOverScrollMode(i);
    }
}
