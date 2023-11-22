package id.dana.core.ui.extension;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.alipay.mobile.rome.syncsdk.transport.connection.f;
import com.alipay.mobile.zebra.data.ZebraData;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.util.Executors;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010\u0005\u001a(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u000e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0001\u001a:\u0010\u0012\u001a\u00020\u0007\"\b\b\u0000\u0010\u0013*\u00020\r*\u0002H\u00132\u0019\b\u0004\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00070\u0015¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0007*\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u001a\u001c\u0010\u001b\u001a\u00020\u0007*\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0001\u001a\u0014\u0010\u001f\u001a\u00020 *\u00020 2\b\b\u0001\u0010!\u001a\u00020\u0001\u001a\u0093\u0001\u0010\"\u001a\u00020\u0007*\u0004\u0018\u00010\r2\b\b\u0002\u0010#\u001a\u00020\u001d2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010.\u001a\n\u0010/\u001a\u00020\u0007*\u000200\u001a\u001c\u00101\u001a\u000202*\u0002022\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0001H\u0002\u001a\u0012\u00105\u001a\u00020\u0007*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u00105\u001a\u00020\u0007*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0012\u00106\u001a\u00020\u0007*\u0002072\u0006\u00108\u001a\u00020\u001d\u001a\u001c\u00109\u001a\u00020\u0007*\u00020\r2\u0006\u0010:\u001a\u00020\u001d2\b\b\u0002\u0010;\u001a\u00020\u001a\u001a\u000e\u0010<\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\r\u001a\n\u0010=\u001a\u00020\u0007*\u00020>\u001a\u0012\u0010?\u001a\u00020\u0007*\u00020>2\u0006\u0010@\u001a\u000202\u001a1\u0010A\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0013*\u00020>2\u0006\u0010B\u001a\u0002H\u00132\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u0001¢\u0006\u0002\u0010C\u001a\n\u0010D\u001a\u00020\u0007*\u00020\r\u001a\n\u0010E\u001a\u00020\u0007*\u00020>\u001a\u0014\u0010F\u001a\u00020\u0007*\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\r\u001a\u0014\u0010F\u001a\u00020\u0007*\u00020I2\b\u0010H\u001a\u0004\u0018\u00010\r\u001a\u0014\u0010J\u001a\u00020\u0007*\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M\u001a\u0012\u0010N\u001a\u00020\u0007*\u00020>2\u0006\u0010O\u001a\u00020\u001d\u001a?\u0010P\u001a\u00020\u0007*\u00020\r2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010U\u001a?\u0010P\u001a\u00020\u0007*\u00020\r2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010V\u001a\u0012\u0010W\u001a\u00020\u0007*\u00020\r2\u0006\u0010:\u001a\u00020\u0001\u001a\u0014\u0010X\u001a\u00020>*\u00020>2\b\b\u0001\u0010!\u001a\u00020\u0001\u001a?\u0010Y\u001a\u00020\u0007*\u00020\r2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010U\u001a?\u0010Y\u001a\u00020\u0007*\u00020\r2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010V\u001a*\u0010Z\u001a\u00020\u0007*\u00020[2\u0006\u0010\\\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u00032\u0006\u0010_\u001a\u00020\u0003\u001a*\u0010`\u001a\u00020\u0007*\u00020[2\u0006\u0010a\u001a\u00020\u00032\u0006\u0010b\u001a\u00020\u00032\u0006\u0010c\u001a\u00020\u00032\u0006\u0010d\u001a\u00020\u0003\u001a'\u0010e\u001a\u00020\u0007*\u00020\r2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010h\u001a'\u0010e\u001a\u00020\u0007*\u00020\r2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010i\u001a\u0012\u0010j\u001a\u00020\u0007*\u00020k2\u0006\u0010\u001c\u001a\u00020\u001d\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006l"}, d2 = {"dpToPx", "", "dp", "", "dpToPxOrNull", "(Ljava/lang/Float;)Ljava/lang/Integer;", "getDeepChildOffset", "", "mainParent", "Landroid/view/ViewGroup;", "parent", "Landroid/view/ViewParent;", "child", "Landroid/view/View;", "accumulatedOffset", "Landroid/graphics/Point;", "pxToDp", "px", "afterMeasured", "T", f.f7258a, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "animateRotation", "duration", "", "animateScaleLeftToRight", MaintenanceBroadcastResult.KEY_VISIBLE, "", "visibilityView", "applyTint", "Landroid/graphics/drawable/Drawable;", "color", "changeConstraint", "isUseCurrentConstraint", "startToStartOf", "startToEndOf", "topToTopOf", "topToBottomOf", "endToStartOf", "endToEndOf", "bottomToTopOf", "bottomToBottomOf", "viewHorizontalBias", "viewVerticalBias", "(Landroid/view/View;ZLandroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;)V", "clearConstraint", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "createBitmapWithBorder", "Landroid/graphics/Bitmap;", "borderSize", "borderColor", "elevate", "enableCollapse", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "enable", "fadeVisibility", "visibility", "durationTime", "getParentView", "greyscaleImage", "Landroid/widget/ImageView;", "loadImageBitmap", "bitmap", "loadImageUrl", H5GetLogInfoBridge.RESULT_MODEL, "(Landroid/widget/ImageView;Ljava/lang/Object;FI)V", "removeExtraPadding", "removeGreyscale", "scrollToView", "Landroidx/core/widget/NestedScrollView;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "setAllOnClickListener", "Landroidx/constraintlayout/widget/Group;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/View$OnClickListener;", "setGreyscale", "isDisabled", "setMargins", "left", "top", "right", "bottom", "(Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setMotionLayoutChildVisibility", "setOverlay", "setPaddings", "setRoundedCorner", "Lcom/google/android/material/card/MaterialCardView;", "topLeftRadius", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "setRoundedCornerInDp", "topLeftRadiusInDp", "topRightRadiusInDp", "bottomLeftRadiusInDp", "bottomRightRadiusInDp", "setSize", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "(Landroid/view/View;Ljava/lang/Float;Ljava/lang/Float;)V", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;)V", "toggleVisibility", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "core-ui_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ViewExtKt {
    public static /* synthetic */ void PlaceComponentResult(View view, Integer num, Integer num2, Integer num3, int i) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 4) != 0) {
            num3 = null;
        }
        MyBillsEntityDataFactory(view, num, num2, num3, (Integer) null);
    }

    private static void MyBillsEntityDataFactory(View view, Integer num, Integer num2, Integer num3, Integer num4) {
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

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(View view, Float f, Float f2, Float f3, Float f4) {
        Intrinsics.checkNotNullParameter(view, "");
        MyBillsEntityDataFactory(view, KClassImpl$Data$declaredNonStaticMembers$2(f), KClassImpl$Data$declaredNonStaticMembers$2(f2), KClassImpl$Data$declaredNonStaticMembers$2(f3), KClassImpl$Data$declaredNonStaticMembers$2(f4));
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(View view, Integer num, Integer num2, Integer num3, int i) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        if ((i & 8) != 0) {
            num3 = null;
        }
        KClassImpl$Data$declaredNonStaticMembers$2(view, num, num2, (Integer) null, num3);
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(View view, Integer num, Integer num2, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(view, "");
        view.setPadding(num != null ? num.intValue() : view.getPaddingLeft(), num2 != null ? num2.intValue() : view.getPaddingTop(), num3 != null ? num3.intValue() : view.getPaddingRight(), num4 != null ? num4.intValue() : view.getPaddingBottom());
    }

    public static final void MyBillsEntityDataFactory(View view, Float f, Float f2, Float f3, Float f4) {
        Intrinsics.checkNotNullParameter(view, "");
        KClassImpl$Data$declaredNonStaticMembers$2(view, KClassImpl$Data$declaredNonStaticMembers$2(f), KClassImpl$Data$declaredNonStaticMembers$2(f2), KClassImpl$Data$declaredNonStaticMembers$2(f3), KClassImpl$Data$declaredNonStaticMembers$2(f4));
    }

    public static final void getAuthRequestContext(View view, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(view, "");
        if (num != null) {
            view.getLayoutParams().width = num.intValue();
        }
        if (num2 != null) {
            view.getLayoutParams().height = num2.intValue();
        }
        view.requestLayout();
    }

    private static final Integer KClassImpl$Data$declaredNonStaticMembers$2(Float f) {
        if (f != null) {
            return Integer.valueOf((int) TypedValue.applyDimension(1, f.floatValue(), Resources.getSystem().getDisplayMetrics()));
        }
        return null;
    }

    public static final int getAuthRequestContext(float f) {
        return (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public static final void MyBillsEntityDataFactory(ImageView imageView, boolean z) {
        Intrinsics.checkNotNullParameter(imageView, "");
        if (z) {
            Intrinsics.checkNotNullParameter(imageView, "");
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            imageView.setImageAlpha(200);
            return;
        }
        Intrinsics.checkNotNullParameter(imageView, "");
        imageView.setColorFilter((ColorFilter) null);
        imageView.setImageAlpha(255);
    }

    public static final void BuiltInFictitiousFunctionClassFactory(NestedScrollView nestedScrollView, View view) {
        Intrinsics.checkNotNullParameter(nestedScrollView, "");
        if (view == null) {
            return;
        }
        Point point = new Point();
        NestedScrollView nestedScrollView2 = nestedScrollView;
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "");
        while (true) {
            ViewGroup viewGroup = (ViewGroup) parent;
            point.x += view.getLeft();
            point.y += view.getTop();
            if (Intrinsics.areEqual(viewGroup, nestedScrollView2)) {
                nestedScrollView.smoothScrollTo(0, point.y);
                return;
            }
            ViewParent parent2 = viewGroup.getParent();
            Intrinsics.checkNotNullExpressionValue(parent2, "");
            ViewGroup viewGroup2 = viewGroup;
            parent = parent2;
            view = viewGroup2;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "");
        Fade fade = new Fade();
        fade.setDuration(200L);
        fade.addTarget(view);
        ViewParent parent = view.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        TransitionManager.getAuthRequestContext((ViewGroup) parent, fade);
        view.setVisibility(z ? 0 : 8);
    }

    public static final void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        view.setPadding(0, 0, 0, 0);
        ViewCompat.MyBillsEntityDataFactory(view, new OnApplyWindowInsetsListener() { // from class: id.dana.core.ui.extension.ViewExtKt$$ExternalSyntheticLambda0
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return ViewExtKt.MyBillsEntityDataFactory(view2, windowInsetsCompat);
            }
        });
        MyBillsEntityDataFactory(view, (Integer) 0, (Integer) 0, (Integer) 0, (Integer) 0);
    }

    public static final View getAuthRequestContext(View view) {
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    public static final <T> void BuiltInFictitiousFunctionClassFactory(ImageView imageView, T t, float f, int i) {
        Executor executor;
        Intrinsics.checkNotNullParameter(imageView, "");
        GlideRequest<Bitmap> BuiltInFictitiousFunctionClassFactory = GlideApp.getAuthRequestContext(imageView.getContext()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(t).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) RequestOptions.KClassImpl$Data$declaredNonStaticMembers$2());
        BitmapImageViewTarget bitmapImageViewTarget = new BitmapImageViewTarget(imageView, f, i) { // from class: id.dana.core.ui.extension.ViewExtKt$loadImageUrl$1
            final /* synthetic */ float BuiltInFictitiousFunctionClassFactory;
            final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
            final /* synthetic */ ImageView getAuthRequestContext;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(imageView);
                this.getAuthRequestContext = imageView;
                this.BuiltInFictitiousFunctionClassFactory = f;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            }

            @Override // com.bumptech.glide.request.target.BitmapImageViewTarget, com.bumptech.glide.request.target.ImageViewTarget
            /* renamed from: getAuthRequestContext */
            public final void MyBillsEntityDataFactory(Bitmap p0) {
                RoundedBitmapDrawable roundedBitmapDrawable;
                ImageView imageView2 = this.getAuthRequestContext;
                if (p0 != null) {
                    float f2 = this.BuiltInFictitiousFunctionClassFactory;
                    int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    Resources resources = imageView2.getResources();
                    if (f2 > 0.0f) {
                        p0 = ViewExtKt.getAuthRequestContext(p0, f2, i2);
                    }
                    roundedBitmapDrawable = RoundedBitmapDrawableFactory.MyBillsEntityDataFactory(resources, p0);
                    roundedBitmapDrawable.getAuthRequestContext(true);
                } else {
                    roundedBitmapDrawable = null;
                }
                imageView2.setImageDrawable(roundedBitmapDrawable);
            }
        };
        executor = Executors.PlaceComponentResult;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(bitmapImageViewTarget, null, BuiltInFictitiousFunctionClassFactory, executor);
    }

    public static final void PlaceComponentResult(View view, int i) {
        int[] constraintSetIds;
        Intrinsics.checkNotNullParameter(view, "");
        ViewParent parent = view.getParent();
        MotionLayout motionLayout = parent instanceof MotionLayout ? (MotionLayout) parent : null;
        if (motionLayout == null || (constraintSetIds = motionLayout.getConstraintSetIds()) == null) {
            return;
        }
        for (int i2 : constraintSetIds) {
            ConstraintSet constraintSet = motionLayout.getConstraintSet(i2);
            if (constraintSet != null) {
                Intrinsics.checkNotNullExpressionValue(constraintSet, "");
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(view.getId()).scheduleImpl.MyBillsEntityDataFactory = i;
                constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(motionLayout);
            }
        }
    }

    public static final void PlaceComponentResult(ImageView imageView, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageView, "");
        Intrinsics.checkNotNullParameter(bitmap, "");
        GlideApp.getAuthRequestContext(imageView.getContext()).getAuthRequestContext(bitmap).MyBillsEntityDataFactory(imageView);
    }

    public static /* synthetic */ WindowInsetsCompat MyBillsEntityDataFactory(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), 0);
        return windowInsetsCompat;
    }

    public static final /* synthetic */ Bitmap getAuthRequestContext(Bitmap bitmap, float f, int i) {
        int i2 = (int) (2.0f * f);
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        float min = Math.min(width, height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() + i2, bitmap.getHeight() + i2, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "");
        float f2 = width + f;
        float f3 = height + f;
        Paint paint = new Paint();
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f2, f3, min, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, f, f, paint);
        paint.setXfermode(null);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        paint.setStrokeWidth(f);
        canvas.drawCircle(f2, f3, min, paint);
        return createBitmap;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(View view, boolean z, View view2, View view3, View view4, View view5, View view6, View view7, Float f, int i) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            view2 = null;
        }
        if ((i & 4) != 0) {
            view3 = null;
        }
        if ((i & 8) != 0) {
            view4 = null;
        }
        if ((i & 16) != 0) {
            view5 = null;
        }
        if ((i & 32) != 0) {
            view6 = null;
        }
        if ((i & 64) != 0) {
            view7 = null;
        }
        if ((i & 1024) != 0) {
            f = null;
        }
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? (ConstraintLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                if (!z) {
                    Intrinsics.checkNotNullParameter(layoutParams2, "");
                    layoutParams2.I = -1;
                    layoutParams2.G = -1;
                    layoutParams2.V = -1;
                    layoutParams2.X = -1;
                    layoutParams2.Y = -1;
                    layoutParams2.W = -1;
                    layoutParams2.isAuto = -1;
                    layoutParams2.Z = -1;
                    layoutParams2.PrepareContext = -1;
                    layoutParams2.NetworkUserEntityData$$ExternalSyntheticLambda7 = -1;
                    layoutParams2.lookAheadTest = -1;
                    layoutParams2.KClassImpl$Data$declaredNonStaticMembers$2 = -1;
                }
                if (view2 != null) {
                    layoutParams2.Y = view2.getId();
                }
                if (view3 != null) {
                    layoutParams2.W = view3.getId();
                }
                if (view4 != null) {
                    layoutParams2.isAuto = view4.getId();
                }
                if (view5 != null) {
                    layoutParams2.Z = view5.getId();
                }
                if (view6 != null) {
                    layoutParams2.PrepareContext = view6.getId();
                }
                if (view7 != null) {
                    layoutParams2.NetworkUserEntityData$$ExternalSyntheticLambda7 = view7.getId();
                }
                if (f != null) {
                    layoutParams2.flip = f.floatValue();
                }
            }
            view.requestLayout();
        }
    }
}
