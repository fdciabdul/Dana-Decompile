package com.afollestad.materialdialogs.utils;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\b\u001a\u001d\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0000*\u00020\t*\u00028\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\r\u001a\u00020\n\"\b\b\u0000\u0010\u0000*\u00020\t*\u00028\u0000H\u0000¢\u0006\u0004\b\r\u0010\f\u001a\u001d\u0010\u000e\u001a\u00020\n\"\b\b\u0000\u0010\u0000*\u00020\t*\u00028\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\f\u001a\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u00020\u0010*\u00020\u000fH\u0000¢\u0006\u0004\b\u0013\u0010\u0012"}, d2 = {"T", "Landroid/view/ViewGroup;", "", "res", "root", "inflate", "(Landroid/view/ViewGroup;ILandroid/view/ViewGroup;)Ljava/lang/Object;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "(Lcom/afollestad/materialdialogs/MaterialDialog;ILandroid/view/ViewGroup;)Ljava/lang/Object;", "Landroid/view/View;", "", "isNotVisible", "(Landroid/view/View;)Z", "isRtl", "isVisible", "Landroid/widget/TextView;", "", "setGravityEndCompat", "(Landroid/widget/TextView;)V", "setGravityStartCompat"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class ViewsKt {
    public static /* synthetic */ Object inflate$default(MaterialDialog materialDialog, int i, ViewGroup viewGroup, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            viewGroup = null;
        }
        return inflate(materialDialog, i, viewGroup);
    }

    public static final <T> T inflate(MaterialDialog materialDialog, int i, ViewGroup viewGroup) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        return (T) LayoutInflater.from(materialDialog.getWindowContext()).inflate(i, viewGroup, false);
    }

    public static /* synthetic */ Object inflate$default(ViewGroup viewGroup, int i, ViewGroup viewGroup2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            viewGroup2 = viewGroup;
        }
        return inflate(viewGroup, i, viewGroup2);
    }

    public static final <T> T inflate(ViewGroup viewGroup, int i, ViewGroup viewGroup2) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "");
        return (T) LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup2, false);
    }

    public static final <T extends View> boolean isVisible(T t) {
        Intrinsics.checkParameterIsNotNull(t, "");
        if (t instanceof Button) {
            Button button = (Button) t;
            if (button.getVisibility() == 0) {
                Intrinsics.checkExpressionValueIsNotNull(button.getText(), "");
                if ((!StringsKt.isBlank(StringsKt.trim(r4))) != false) {
                    return true;
                }
            }
        } else if (t.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public static final <T extends View> boolean isNotVisible(T t) {
        Intrinsics.checkParameterIsNotNull(t, "");
        return !isVisible(t);
    }

    public static final <T extends View> boolean isRtl(T t) {
        Intrinsics.checkParameterIsNotNull(t, "");
        if (Build.VERSION.SDK_INT >= 17) {
            Resources resources = t.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "");
            Configuration configuration = resources.getConfiguration();
            Intrinsics.checkExpressionValueIsNotNull(configuration, "");
            if (configuration.getLayoutDirection() == 1) {
                return true;
            }
        }
        return false;
    }

    public static final void setGravityStartCompat(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "");
        if (Build.VERSION.SDK_INT >= 17) {
            textView.setTextAlignment(5);
        }
        textView.setGravity(8388627);
    }

    public static final void setGravityEndCompat(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "");
        if (Build.VERSION.SDK_INT >= 17) {
            textView.setTextAlignment(6);
        }
        textView.setGravity(8388629);
    }
}
