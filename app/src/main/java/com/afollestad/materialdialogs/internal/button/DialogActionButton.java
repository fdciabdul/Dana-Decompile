package com.afollestad.materialdialogs.internal.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.ThemeKt;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001b\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lcom/afollestad/materialdialogs/internal/button/DialogActionButton;", "Landroidx/appcompat/widget/AppCompatButton;", "", "enabled", "", "setEnabled", "(Z)V", "Landroid/content/Context;", "baseContext", "appContext", "stacked", "update$core", "(Landroid/content/Context;Landroid/content/Context;Z)V", "", "color", "updateTextColor", "(I)V", "disabledColor", "I", "enabledColor", "enabledColorOverride", "Ljava/lang/Integer;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DialogActionButton extends AppCompatButton {
    private static final int CASING_UPPER = 1;
    private int disabledColor;
    private int enabledColor;
    private Integer enabledColorOverride;

    public /* synthetic */ DialogActionButton(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "");
        setClickable(true);
        setFocusable(true);
    }

    public final void update$core(Context baseContext, final Context appContext, boolean stacked) {
        int i;
        Intrinsics.checkParameterIsNotNull(baseContext, "");
        Intrinsics.checkParameterIsNotNull(appContext, "");
        setSupportAllCaps(MDUtil.INSTANCE.resolveInt(appContext, R.attr.md_button_casing, 1) == 1);
        boolean inferThemeIsLight = ThemeKt.inferThemeIsLight(appContext);
        this.enabledColor = MDUtil.resolveColor$default(MDUtil.INSTANCE, appContext, null, Integer.valueOf(R.attr.md_color_button_text), new Function0<Integer>() { // from class: com.afollestad.materialdialogs.internal.button.DialogActionButton$update$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return MDUtil.resolveColor$default(MDUtil.INSTANCE, appContext, null, Integer.valueOf(R.attr.colorPrimary), null, 10, null);
            }
        }, 2, null);
        if (inferThemeIsLight) {
            i = R.color.md_disabled_text_light_theme;
        } else {
            i = R.color.md_disabled_text_dark_theme;
        }
        this.disabledColor = MDUtil.resolveColor$default(MDUtil.INSTANCE, baseContext, Integer.valueOf(i), null, null, 12, null);
        Integer num = this.enabledColorOverride;
        setTextColor(num != null ? num.intValue() : this.enabledColor);
        Drawable resolveDrawable$default = MDUtil.resolveDrawable$default(MDUtil.INSTANCE, baseContext, null, Integer.valueOf(R.attr.md_button_selector), null, 10, null);
        if (Build.VERSION.SDK_INT >= 21 && (resolveDrawable$default instanceof RippleDrawable)) {
            MDUtil mDUtil = MDUtil.INSTANCE;
            int resolveColor$default = MDUtil.resolveColor$default(MDUtil.INSTANCE, baseContext, null, Integer.valueOf(R.attr.md_ripple_color), new Function0<Integer>() { // from class: com.afollestad.materialdialogs.internal.button.DialogActionButton$update$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* synthetic */ Integer invoke() {
                    return Integer.valueOf(invoke2());
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final int invoke2() {
                    return ColorsKt.adjustAlpha(MDUtil.resolveColor$default(MDUtil.INSTANCE, appContext, null, Integer.valueOf(R.attr.colorPrimary), null, 10, null), 0.12f);
                }
            }, 2, null);
            if (resolveColor$default != 0) {
                ((RippleDrawable) resolveDrawable$default).setColor(ColorStateList.valueOf(resolveColor$default));
            }
        }
        setBackground(resolveDrawable$default);
        if (stacked) {
            ViewsKt.setGravityEndCompat(this);
        } else {
            setGravity(17);
        }
        setEnabled(isEnabled());
    }

    public final void updateTextColor(int color) {
        this.enabledColor = color;
        this.enabledColorOverride = Integer.valueOf(color);
        setEnabled(isEnabled());
    }

    @Override // android.widget.TextView, android.view.View
    public final void setEnabled(boolean enabled) {
        int i;
        super.setEnabled(enabled);
        if (enabled) {
            Integer num = this.enabledColorOverride;
            i = num != null ? num.intValue() : this.enabledColor;
        } else {
            i = this.disabledColor;
        }
        setTextColor(i);
    }
}
