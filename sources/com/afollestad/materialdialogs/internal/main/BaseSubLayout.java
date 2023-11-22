package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00058\u0005X\u0085\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R*\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a"}, d2 = {"Lcom/afollestad/materialdialogs/internal/main/BaseSubLayout;", "Landroid/view/ViewGroup;", "Landroid/graphics/Paint;", "dividerPaint", "()Landroid/graphics/Paint;", "", "getDividerColor", "()I", "Lcom/afollestad/materialdialogs/MaterialDialog;", "dialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "getDialog", "()Lcom/afollestad/materialdialogs/MaterialDialog;", "setDialog", "(Lcom/afollestad/materialdialogs/MaterialDialog;)V", "dividerHeight", "I", "getDividerHeight", "Landroid/graphics/Paint;", "", "value", "drawDivider", "Z", "getDrawDivider", "()Z", "setDrawDivider", "(Z)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public abstract class BaseSubLayout extends ViewGroup {
    public MaterialDialog dialog;
    private final int dividerHeight;
    private final Paint dividerPaint;
    private boolean drawDivider;

    public /* synthetic */ BaseSubLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSubLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "");
        Paint paint = new Paint();
        this.dividerPaint = paint;
        this.dividerHeight = MDUtil.INSTANCE.dimenPx(this, R.dimen.md_divider_height);
        setWillNotDraw(false);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(context.getResources().getDimension(R.dimen.md_divider_height));
        paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getDividerHeight")
    public final int getDividerHeight() {
        return this.dividerHeight;
    }

    @JvmName(name = "getDialog")
    public final MaterialDialog getDialog() {
        MaterialDialog materialDialog = this.dialog;
        if (materialDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        return materialDialog;
    }

    @JvmName(name = "setDialog")
    public final void setDialog(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        this.dialog = materialDialog;
    }

    @JvmName(name = "getDrawDivider")
    public final boolean getDrawDivider() {
        return this.drawDivider;
    }

    @JvmName(name = "setDrawDivider")
    public final void setDrawDivider(boolean z) {
        this.drawDivider = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Paint dividerPaint() {
        this.dividerPaint.setColor(getDividerColor());
        return this.dividerPaint;
    }

    private final int getDividerColor() {
        MDUtil mDUtil = MDUtil.INSTANCE;
        MaterialDialog materialDialog = this.dialog;
        if (materialDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        Context context = materialDialog.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "");
        return MDUtil.resolveColor$default(mDUtil, context, null, Integer.valueOf(R.attr.md_divider_color), null, 10, null);
    }
}
