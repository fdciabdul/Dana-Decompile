package id.dana.extension.view;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewCompat;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.mobile.zebra.data.ZebraData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.utils.AnimationUtil;
import id.dana.utils.OSUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0001\u001a\u0014\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\u0001\u001a\u0012\u0010\u0016\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0016\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\u0017\u001a\u00020\u000b*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011\u001a\n\u0010\u001a\u001a\u00020\u000b*\u00020\u001b\u001a\n\u0010\u001c\u001a\u00020\u000b*\u00020\u001b\u001a\u001d\u0010\u001d\u001a\u00020\u000b*\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00010 ¢\u0006\u0002\u0010!\u001a\u0014\u0010\"\u001a\u00020\u000b*\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$\u001a\u0012\u0010%\u001a\u00020\u000b*\u00020\u001b2\u0006\u0010&\u001a\u00020\u0011\u001a?\u0010'\u001a\u00020\u000b*\u00020\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010,\u001a?\u0010'\u001a\u00020\u000b*\u00020\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010-\u001a\u0014\u0010.\u001a\u00020\u001b*\u00020\u001b2\b\b\u0001\u0010\u0015\u001a\u00020\u0001\u001a?\u0010/\u001a\u00020\u000b*\u00020\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010,\u001a?\u0010/\u001a\u00020\u000b*\u00020\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010-\u001a*\u00100\u001a\u00020\u000b*\u0002012\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003\u001a*\u00106\u001a\u00020\u000b*\u0002012\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003\u001a'\u0010;\u001a\u00020\u000b*\u00020\f2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010>\u001a'\u0010;\u001a\u00020\u000b*\u00020\f2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010?\u001a\u0012\u0010@\u001a\u00020\u000b*\u00020A2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006B"}, d2 = {"dpToPx", "", "dp", "", "dpToPxOrNull", "(Ljava/lang/Float;)Ljava/lang/Integer;", "pxToDp", "px", "spToPx", RVParams.SHOW_PROGRESS, "animateRotation", "", "Landroid/view/View;", "duration", "", "animateScaleLeftToRight", MaintenanceBroadcastResult.KEY_VISIBLE, "", "visibilityView", "applyTint", "Landroid/graphics/drawable/Drawable;", "color", "elevate", "enableCollapse", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "enable", "greyscaleImage", "Landroid/widget/ImageView;", "removeGreyscale", "removeReferenceId", "Landroidx/constraintlayout/widget/Group;", "ids", "", "(Landroidx/constraintlayout/widget/Group;[Ljava/lang/Integer;)V", "setAllOnClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setGreyscale", "isDisabled", "setMargins", "left", "top", "right", "bottom", "(Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setOverlay", "setPaddings", "setRoundedCorner", "Lcom/google/android/material/card/MaterialCardView;", "topLeftRadius", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "setRoundedCornerInDp", "topLeftRadiusInDp", "topRightRadiusInDp", "bottomLeftRadiusInDp", "bottomRightRadiusInDp", "setSize", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "(Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;)V", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;)V", "toggleVisibility", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewExtKt {
    public static /* synthetic */ void MyBillsEntityDataFactory(View view, Integer num, Integer num2, Integer num3, Integer num4, int i) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            num4 = null;
        }
        PlaceComponentResult(view, num, num2, num3, num4);
    }

    public static final void PlaceComponentResult(View view, Integer num, Integer num2, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (num != null) {
            marginLayoutParams.leftMargin = num.intValue();
        }
        if (num2 != null) {
            marginLayoutParams.topMargin = num2.intValue();
        }
        if (num3 != null) {
            marginLayoutParams.rightMargin = num3.intValue();
        }
        if (num4 != null) {
            marginLayoutParams.bottomMargin = num4.intValue();
        }
        view.requestLayout();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(View view, Float f, Float f2, Float f3, Float f4, int i) {
        if ((i & 1) != 0) {
            f = null;
        }
        if ((i & 2) != 0) {
            f2 = null;
        }
        if ((i & 4) != 0) {
            f3 = null;
        }
        if ((i & 8) != 0) {
            f4 = null;
        }
        Intrinsics.checkNotNullParameter(view, "");
        PlaceComponentResult(view, KClassImpl$Data$declaredNonStaticMembers$2(f), KClassImpl$Data$declaredNonStaticMembers$2(f2), KClassImpl$Data$declaredNonStaticMembers$2(f3), KClassImpl$Data$declaredNonStaticMembers$2(f4));
    }

    public static final void MyBillsEntityDataFactory(View view, Float f, Float f2, Float f3, Float f4) {
        Intrinsics.checkNotNullParameter(view, "");
        PlaceComponentResult(view, KClassImpl$Data$declaredNonStaticMembers$2(f), KClassImpl$Data$declaredNonStaticMembers$2(f2), KClassImpl$Data$declaredNonStaticMembers$2(f3), KClassImpl$Data$declaredNonStaticMembers$2(f4));
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(View view, Integer num, Integer num2, Integer num3, Integer num4, int i) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        if ((i & 8) != 0) {
            num4 = null;
        }
        getAuthRequestContext(view, num, num2, num3, num4);
    }

    private static void getAuthRequestContext(View view, Integer num, Integer num2, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(view, "");
        view.setPadding(num != null ? num.intValue() : view.getPaddingLeft(), num2 != null ? num2.intValue() : view.getPaddingTop(), num3 != null ? num3.intValue() : view.getPaddingRight(), num4 != null ? num4.intValue() : view.getPaddingBottom());
    }

    public static /* synthetic */ void PlaceComponentResult(View view, Float f, Float f2, Float f3, Float f4, int i) {
        if ((i & 1) != 0) {
            f = null;
        }
        if ((i & 2) != 0) {
            f2 = null;
        }
        if ((i & 4) != 0) {
            f3 = null;
        }
        if ((i & 8) != 0) {
            f4 = null;
        }
        Intrinsics.checkNotNullParameter(view, "");
        getAuthRequestContext(view, KClassImpl$Data$declaredNonStaticMembers$2(f), KClassImpl$Data$declaredNonStaticMembers$2(f2), KClassImpl$Data$declaredNonStaticMembers$2(f3), KClassImpl$Data$declaredNonStaticMembers$2(f4));
    }

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(View view, Float f, Float f2, Float f3, Float f4) {
        Intrinsics.checkNotNullParameter(view, "");
        getAuthRequestContext(view, KClassImpl$Data$declaredNonStaticMembers$2(f), KClassImpl$Data$declaredNonStaticMembers$2(f2), KClassImpl$Data$declaredNonStaticMembers$2(f3), KClassImpl$Data$declaredNonStaticMembers$2(f4));
    }

    public static void MyBillsEntityDataFactory(View view, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(view, "");
        if (num != null) {
            view.getLayoutParams().width = num.intValue();
        }
        if (num2 != null) {
            view.getLayoutParams().height = num2.intValue();
        }
        view.requestLayout();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(View view, Float f) {
        Intrinsics.checkNotNullParameter(view, "");
        MyBillsEntityDataFactory(view, KClassImpl$Data$declaredNonStaticMembers$2((Float) null), KClassImpl$Data$declaredNonStaticMembers$2(f));
    }

    private static final Integer KClassImpl$Data$declaredNonStaticMembers$2(Float f) {
        if (f != null) {
            return Integer.valueOf((int) TypedValue.applyDimension(1, f.floatValue(), Resources.getSystem().getDisplayMetrics()));
        }
        return null;
    }

    public static final int PlaceComponentResult(float f) {
        return (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public static final float MyBillsEntityDataFactory() {
        return TypedValue.applyDimension(2, 12.0f, Resources.getSystem().getDisplayMetrics());
    }

    public static final Drawable KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable, int i) {
        Intrinsics.checkNotNullParameter(drawable, "");
        drawable.mutate().setColorFilter(i, PorterDuff.Mode.SRC_IN);
        return drawable;
    }

    public static final ImageView getAuthRequestContext(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "");
        imageView.setColorFilter(i, PorterDuff.Mode.SRC_OVER);
        return imageView;
    }

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(FloatingActionButton floatingActionButton, boolean z) {
        Intrinsics.checkNotNullParameter(floatingActionButton, "");
        if (z) {
            floatingActionButton.show();
        } else {
            floatingActionButton.hide();
        }
    }

    public static /* synthetic */ void getAuthRequestContext(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    public static final void MyBillsEntityDataFactory(final View view, final boolean z, final int i) {
        Intrinsics.checkNotNullParameter(view, "");
        if (view.getVisibility() == 0 && z) {
            return;
        }
        if (view.getVisibility() != 8 || z) {
            float f = z ? 0.0f : 1.0f;
            float f2 = z ? 1.0f : 0.0f;
            ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.0f, 1, 0.5f);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(200L);
            scaleAnimation.setAnimationListener(new AnimationUtil.AnimationListener() { // from class: id.dana.extension.view.ViewExtKt$animateScaleLeftToRight$1$1
                @Override // id.dana.utils.AnimationUtil.AnimationListener, android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation p0) {
                    view.setVisibility(z ? i : 0);
                }

                @Override // id.dana.utils.AnimationUtil.AnimationListener, android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation p0) {
                    view.setVisibility(z ? 0 : i);
                }
            });
            view.startAnimation(scaleAnimation);
        }
    }

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(ImageView imageView, boolean z) {
        Intrinsics.checkNotNullParameter(imageView, "");
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2(imageView);
            return;
        }
        Intrinsics.checkNotNullParameter(imageView, "");
        imageView.setColorFilter((ColorFilter) null);
        imageView.setImageAlpha(255);
    }

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "");
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        imageView.setImageAlpha(200);
    }

    public static final void getAuthRequestContext(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "");
        imageView.setColorFilter((ColorFilter) null);
        imageView.setImageAlpha(255);
    }

    public static final void getAuthRequestContext(Group group, View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(group, "");
        int[] referencedIds = group.getReferencedIds();
        Intrinsics.checkNotNullExpressionValue(referencedIds, "");
        for (int i : referencedIds) {
            group.getRootView().findViewById(i).setOnClickListener(onClickListener);
        }
    }

    public static final void PlaceComponentResult(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "");
        int applyDimension = (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
        Intrinsics.checkNotNullParameter(view, "");
        if (OSUtil.scheduleImpl()) {
            view.setElevation(applyDimension);
        } else {
            ViewCompat.getAuthRequestContext(view, TypedValue.applyDimension(0, applyDimension, Resources.getSystem().getDisplayMetrics()));
        }
    }
}
