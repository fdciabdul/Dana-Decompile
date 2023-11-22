package id.dana.core.ui.custom.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.core.ui.R;
import id.dana.core.ui.custom.tooltip.Tooltip;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.util.ViewUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0002('B\u0011\b\u0002\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0003\u001a\u00020\u0005X\u0080\"¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0012\u0010\n\u001a\u00020\u0007X\u0080\"¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0012\u0010\f\u001a\u00020\u000bX\u0080\"¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u000eX\u0000¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0013X\u0001¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00168\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001eR\u0011\u0010\"\u001a\u00020 X\u0001¢\u0006\u0006\n\u0004\b\u001f\u0010!"}, d2 = {"Lid/dana/core/ui/custom/tooltip/Tooltip;", "", "Landroid/graphics/PointF;", "PlaceComponentResult", "()Landroid/graphics/PointF;", "Landroid/view/View;", "Landroid/view/View;", "Landroid/widget/ImageView;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/widget/ImageView;", "MyBillsEntityDataFactory", "Landroid/widget/LinearLayout;", "getAuthRequestContext", "Landroid/widget/LinearLayout;", "", "BuiltInFictitiousFunctionClassFactory", "I", "", "()Z", "", LogConstants.RESULT_FALSE, "getErrorConfigVersion", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "moveToNextValue", "Landroid/view/View$OnAttachStateChangeListener;", "lookAheadTest", "Landroid/view/View$OnAttachStateChangeListener;", "scheduleImpl", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/widget/PopupWindow;", "Landroid/widget/PopupWindow;", "DatabaseTableConfigUtil", "Lid/dana/core/ui/custom/tooltip/Tooltip$Builder;", "p0", "<init>", "(Lid/dana/core/ui/custom/tooltip/Tooltip$Builder;)V", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Tooltip {
    final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public ImageView MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final float getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final PopupWindow DatabaseTableConfigUtil;
    public View PlaceComponentResult;
    public LinearLayout getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final ViewTreeObserver.OnGlobalLayoutListener moveToNextValue;
    final View.OnAttachStateChangeListener lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    final ViewTreeObserver.OnGlobalLayoutListener scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ViewTreeObserver.OnScrollChangedListener NetworkUserEntityData$$ExternalSyntheticLambda0;

    public /* synthetic */ Tooltip(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private Tooltip(final Builder builder) {
        int i;
        ArrowDrawable arrowDrawable;
        LinearLayout.LayoutParams layoutParams;
        View view = builder.getAuthRequestContext;
        if (view != null) {
            i = Gravity.getAbsoluteGravity(builder.scheduleImpl, ViewCompat.initRecordTimeStamp(view));
        } else {
            i = 48;
        }
        this.BuiltInFictitiousFunctionClassFactory = i;
        PopupWindow popupWindow = new PopupWindow(builder.getErrorConfigVersion);
        this.DatabaseTableConfigUtil = popupWindow;
        this.getErrorConfigVersion = builder.NetworkUserEntityData$$ExternalSyntheticLambda1;
        View view2 = builder.getAuthRequestContext;
        if (view2 != null) {
            Intrinsics.checkNotNullParameter(view2, "");
            this.PlaceComponentResult = view2;
        }
        popupWindow.setClippingEnabled(false);
        popupWindow.setWidth(-1);
        popupWindow.setHeight(-2);
        TextView textView = new TextView(builder.getErrorConfigVersion);
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, builder.NetworkUserEntityData$$ExternalSyntheticLambda7);
        LinearLayout linearLayout = null;
        TextViewCompat.MyBillsEntityDataFactory(textView, (Drawable) null, (Drawable) null, builder.NetworkUserEntityData$$ExternalSyntheticLambda0, (Drawable) null);
        textView.setText(builder.NetworkUserEntityData$$ExternalSyntheticLambda5);
        textView.setPadding(builder.newProxyInstance, builder.getErrorConfigVersion.getResources().getDimensionPixelSize(R.dimen.BuiltInFictitiousFunctionClassFactory_res_0x7f070055), builder.newProxyInstance, builder.getErrorConfigVersion.getResources().getDimensionPixelSize(R.dimen.BuiltInFictitiousFunctionClassFactory_res_0x7f070055));
        textView.setLineSpacing(builder.initRecordTimeStamp, builder.DatabaseTableConfigUtil);
        textView.setTypeface(builder.FragmentBottomSheetPaymentSettingBinding, builder.NetworkUserEntityData$$ExternalSyntheticLambda3);
        textView.setCompoundDrawablePadding(builder.moveToNextValue);
        if (builder.isLayoutRequested >= 0) {
            textView.setMaxWidth(builder.isLayoutRequested);
        }
        if (builder.NetworkUserEntityData$$ExternalSyntheticLambda6 >= 0.0f) {
            textView.setTextSize(0, builder.NetworkUserEntityData$$ExternalSyntheticLambda6);
        }
        if (builder.PrepareContext != null) {
            textView.setTextColor(builder.PrepareContext);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2, 0.0f);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(builder.PlaceComponentResult);
        gradientDrawable.setCornerRadius(builder.lookAheadTest);
        TextView textView2 = textView;
        ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView2, gradientDrawable);
        LinearLayout linearLayout2 = new LinearLayout(builder.getErrorConfigVersion);
        Intrinsics.checkNotNullParameter(linearLayout2, "");
        this.getAuthRequestContext = linearLayout2;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            linearLayout2 = null;
        }
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        LinearLayout linearLayout3 = this.getAuthRequestContext;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            linearLayout3 = null;
        }
        linearLayout3.setOrientation(!Gravity.isHorizontal(this.BuiltInFictitiousFunctionClassFactory) ? 1 : 0);
        if (builder.getGetContactSyncConfig()) {
            ImageView imageView = new ImageView(builder.getErrorConfigVersion);
            Intrinsics.checkNotNullParameter(imageView, "");
            this.MyBillsEntityDataFactory = imageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imageView = null;
            }
            if (builder.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                arrowDrawable = new ArrowDrawable(builder.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
            } else {
                arrowDrawable = builder.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            imageView.setImageDrawable(arrowDrawable);
            if (Gravity.isVertical(this.BuiltInFictitiousFunctionClassFactory)) {
                layoutParams = new LinearLayout.LayoutParams((int) builder.BuiltInFictitiousFunctionClassFactory, (int) builder.MyBillsEntityDataFactory, 0.0f);
            } else {
                layoutParams = new LinearLayout.LayoutParams((int) builder.MyBillsEntityDataFactory, (int) builder.BuiltInFictitiousFunctionClassFactory, 0.0f);
            }
            layoutParams.gravity = 17;
            ImageView imageView2 = this.MyBillsEntityDataFactory;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imageView2 = null;
            }
            imageView2.setLayoutParams(layoutParams);
            int i2 = this.BuiltInFictitiousFunctionClassFactory;
            if (i2 != 48) {
                View view3 = this.PlaceComponentResult;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    view3 = null;
                }
                if (i2 != Gravity.getAbsoluteGravity(8388611, ViewCompat.initRecordTimeStamp(view3))) {
                    LinearLayout linearLayout4 = this.getAuthRequestContext;
                    if (linearLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        linearLayout4 = null;
                    }
                    ImageView imageView3 = this.MyBillsEntityDataFactory;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        imageView3 = null;
                    }
                    linearLayout4.addView(imageView3);
                    LinearLayout linearLayout5 = this.getAuthRequestContext;
                    if (linearLayout5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        linearLayout5 = null;
                    }
                    linearLayout5.addView(textView2);
                }
            }
            LinearLayout linearLayout6 = this.getAuthRequestContext;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                linearLayout6 = null;
            }
            linearLayout6.addView(textView2);
            LinearLayout linearLayout7 = this.getAuthRequestContext;
            if (linearLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                linearLayout7 = null;
            }
            ImageView imageView4 = this.MyBillsEntityDataFactory;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imageView4 = null;
            }
            linearLayout7.addView(imageView4);
        } else {
            LinearLayout linearLayout8 = this.getAuthRequestContext;
            if (linearLayout8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                linearLayout8 = null;
            }
            linearLayout8.addView(textView2);
        }
        int authRequestContext = ViewExtKt.getAuthRequestContext(16.0f);
        int i3 = this.BuiltInFictitiousFunctionClassFactory;
        if (i3 == 48 || i3 == 80) {
            LinearLayout linearLayout9 = this.getAuthRequestContext;
            if (linearLayout9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                linearLayout9 = null;
            }
            linearLayout9.setPadding(authRequestContext, 0, authRequestContext, 0);
        } else if (i3 == 8388611) {
            LinearLayout linearLayout10 = this.getAuthRequestContext;
            if (linearLayout10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                linearLayout10 = null;
            }
            linearLayout10.setPadding(authRequestContext, 0, 0, 0);
        } else if (i3 == 8388613) {
            LinearLayout linearLayout11 = this.getAuthRequestContext;
            if (linearLayout11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                linearLayout11 = null;
            }
            linearLayout11.setPadding(0, 0, authRequestContext, 0);
        }
        LinearLayout linearLayout12 = this.getAuthRequestContext;
        if (linearLayout12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            linearLayout12 = null;
        }
        linearLayout12.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.custom.tooltip.Tooltip$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                Tooltip.getAuthRequestContext(Tooltip.Builder.this, this);
            }
        });
        LinearLayout linearLayout13 = this.getAuthRequestContext;
        if (linearLayout13 != null) {
            linearLayout = linearLayout13;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        popupWindow.setContentView(linearLayout);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(builder.getNetworkUserEntityData$$ExternalSyntheticLambda2());
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: id.dana.core.ui.custom.tooltip.Tooltip$$ExternalSyntheticLambda0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                Tooltip.PlaceComponentResult(Tooltip.this);
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ViewTreeObserver.OnScrollChangedListener() { // from class: id.dana.core.ui.custom.tooltip.Tooltip$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                Tooltip.getAuthRequestContext(Tooltip.this);
            }
        };
        this.scheduleImpl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.core.ui.custom.tooltip.Tooltip$onGlobalLayoutListener$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
                PointF PlaceComponentResult;
                ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
                ViewTreeObserverCompat viewTreeObserverCompat = ViewTreeObserverCompat.INSTANCE;
                LinearLayout linearLayout14 = Tooltip.this.getAuthRequestContext;
                LinearLayout linearLayout15 = null;
                if (linearLayout14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    linearLayout14 = null;
                }
                ViewTreeObserver viewTreeObserver = linearLayout14.getViewTreeObserver();
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "");
                ViewTreeObserverCompat.getAuthRequestContext(viewTreeObserver, this);
                View view4 = Tooltip.this.PlaceComponentResult;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    view4 = null;
                }
                ViewTreeObserver viewTreeObserver2 = view4.getViewTreeObserver();
                if (viewTreeObserver2 != null) {
                    onScrollChangedListener = Tooltip.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    viewTreeObserver2.addOnScrollChangedListener(onScrollChangedListener);
                }
                LinearLayout linearLayout16 = Tooltip.this.getAuthRequestContext;
                if (linearLayout16 != null) {
                    linearLayout15 = linearLayout16;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                ViewTreeObserver viewTreeObserver3 = linearLayout15.getViewTreeObserver();
                onGlobalLayoutListener = Tooltip.this.moveToNextValue;
                viewTreeObserver3.addOnGlobalLayoutListener(onGlobalLayoutListener);
                PlaceComponentResult = Tooltip.this.PlaceComponentResult();
                Tooltip.this.DatabaseTableConfigUtil.setClippingEnabled(true);
                Tooltip.this.DatabaseTableConfigUtil.update((int) PlaceComponentResult.x, (int) PlaceComponentResult.y, Tooltip.this.DatabaseTableConfigUtil.getWidth(), Tooltip.this.DatabaseTableConfigUtil.getHeight());
            }
        };
        this.moveToNextValue = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.core.ui.custom.tooltip.Tooltip$onArrowLayoutListener$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                float f;
                float left;
                ViewTreeObserverCompat viewTreeObserverCompat = ViewTreeObserverCompat.INSTANCE;
                LinearLayout linearLayout14 = Tooltip.this.getAuthRequestContext;
                ImageView imageView5 = null;
                if (linearLayout14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    linearLayout14 = null;
                }
                ViewTreeObserver viewTreeObserver = linearLayout14.getViewTreeObserver();
                Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "");
                ViewTreeObserverCompat.getAuthRequestContext(viewTreeObserver, this);
                ViewUtil viewUtil = ViewUtil.INSTANCE;
                View view4 = Tooltip.this.PlaceComponentResult;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    view4 = null;
                }
                RectF PlaceComponentResult = ViewUtil.PlaceComponentResult(view4);
                ViewUtil viewUtil2 = ViewUtil.INSTANCE;
                LinearLayout linearLayout15 = Tooltip.this.getAuthRequestContext;
                if (linearLayout15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    linearLayout15 = null;
                }
                RectF PlaceComponentResult2 = ViewUtil.PlaceComponentResult(linearLayout15);
                if (Gravity.isVertical(Tooltip.this.BuiltInFictitiousFunctionClassFactory)) {
                    LinearLayout linearLayout16 = Tooltip.this.getAuthRequestContext;
                    if (linearLayout16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        linearLayout16 = null;
                    }
                    left = linearLayout16.getPaddingLeft() + ViewExtKt.getAuthRequestContext(2.0f);
                    float width = PlaceComponentResult2.width() / 2.0f;
                    ImageView imageView6 = Tooltip.this.MyBillsEntityDataFactory;
                    if (imageView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        imageView6 = null;
                    }
                    float width2 = (width - (imageView6.getWidth() / 2.0f)) - (PlaceComponentResult2.centerX() - PlaceComponentResult.centerX());
                    if (width2 > left) {
                        ImageView imageView7 = Tooltip.this.MyBillsEntityDataFactory;
                        if (imageView7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            imageView7 = null;
                        }
                        if (imageView7.getWidth() + width2 + left > PlaceComponentResult2.width()) {
                            float width3 = PlaceComponentResult2.width();
                            ImageView imageView8 = Tooltip.this.MyBillsEntityDataFactory;
                            if (imageView8 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                imageView8 = null;
                            }
                            left = (width3 - imageView8.getWidth()) - left;
                        } else {
                            left = width2;
                        }
                    }
                    ImageView imageView9 = Tooltip.this.MyBillsEntityDataFactory;
                    if (imageView9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        imageView9 = null;
                    }
                    f = imageView9.getTop() + (Tooltip.this.BuiltInFictitiousFunctionClassFactory != 48 ? 1 : -1);
                } else {
                    LinearLayout linearLayout17 = Tooltip.this.getAuthRequestContext;
                    if (linearLayout17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        linearLayout17 = null;
                    }
                    float paddingTop = linearLayout17.getPaddingTop() + ViewExtKt.getAuthRequestContext(2.0f);
                    float height = PlaceComponentResult2.height() / 2.0f;
                    ImageView imageView10 = Tooltip.this.MyBillsEntityDataFactory;
                    if (imageView10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        imageView10 = null;
                    }
                    float height2 = (height - (imageView10.getHeight() / 2.0f)) - (PlaceComponentResult2.centerY() - PlaceComponentResult.centerY());
                    if (height2 > paddingTop) {
                        ImageView imageView11 = Tooltip.this.MyBillsEntityDataFactory;
                        if (imageView11 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            imageView11 = null;
                        }
                        if (imageView11.getHeight() + height2 + paddingTop > PlaceComponentResult2.height()) {
                            float height3 = PlaceComponentResult2.height();
                            ImageView imageView12 = Tooltip.this.MyBillsEntityDataFactory;
                            if (imageView12 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                imageView12 = null;
                            }
                            height2 = (height3 - imageView12.getHeight()) - paddingTop;
                        }
                        f = height2;
                    } else {
                        f = paddingTop;
                    }
                    ImageView imageView13 = Tooltip.this.MyBillsEntityDataFactory;
                    if (imageView13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        imageView13 = null;
                    }
                    left = (Tooltip.this.BuiltInFictitiousFunctionClassFactory != 8388611 ? 1 : -1) + imageView13.getLeft();
                }
                ImageView imageView14 = Tooltip.this.MyBillsEntityDataFactory;
                if (imageView14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    imageView14 = null;
                }
                imageView14.setX(left);
                ImageView imageView15 = Tooltip.this.MyBillsEntityDataFactory;
                if (imageView15 != null) {
                    imageView5 = imageView15;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                imageView5.setY(f);
            }
        };
        this.lookAheadTest = new View.OnAttachStateChangeListener() { // from class: id.dana.core.ui.custom.tooltip.Tooltip$onAttachStateChangeListener$1
            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                Tooltip.this.DatabaseTableConfigUtil.dismiss();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PointF PlaceComponentResult() {
        PointF pointF = new PointF();
        ViewUtil viewUtil = ViewUtil.INSTANCE;
        View view = this.PlaceComponentResult;
        LinearLayout linearLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view = null;
        }
        RectF MyBillsEntityDataFactory = ViewUtil.MyBillsEntityDataFactory(view);
        PointF pointF2 = new PointF(MyBillsEntityDataFactory.centerX(), MyBillsEntityDataFactory.centerY());
        int i = this.BuiltInFictitiousFunctionClassFactory;
        if (i == 48) {
            float f = pointF2.x;
            LinearLayout linearLayout2 = this.getAuthRequestContext;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                linearLayout2 = null;
            }
            pointF.x = f - (linearLayout2.getWidth() / 2.0f);
            float f2 = MyBillsEntityDataFactory.top;
            LinearLayout linearLayout3 = this.getAuthRequestContext;
            if (linearLayout3 != null) {
                linearLayout = linearLayout3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            pointF.y = (f2 - linearLayout.getHeight()) - this.getErrorConfigVersion;
        } else if (i == 80) {
            float f3 = pointF2.x;
            LinearLayout linearLayout4 = this.getAuthRequestContext;
            if (linearLayout4 != null) {
                linearLayout = linearLayout4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            pointF.x = f3 - (linearLayout.getWidth() / 2.0f);
            pointF.y = MyBillsEntityDataFactory.bottom + this.getErrorConfigVersion;
        } else if (i == 8388611) {
            float f4 = MyBillsEntityDataFactory.left;
            LinearLayout linearLayout5 = this.getAuthRequestContext;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                linearLayout5 = null;
            }
            pointF.x = (f4 - linearLayout5.getWidth()) - this.getErrorConfigVersion;
            float f5 = pointF2.y;
            LinearLayout linearLayout6 = this.getAuthRequestContext;
            if (linearLayout6 != null) {
                linearLayout = linearLayout6;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            pointF.y = f5 - (linearLayout.getHeight() / 2.0f);
        } else if (i == 8388613) {
            pointF.x = MyBillsEntityDataFactory.right + this.getErrorConfigVersion;
            float f6 = pointF2.y;
            LinearLayout linearLayout7 = this.getAuthRequestContext;
            if (linearLayout7 != null) {
                linearLayout = linearLayout7;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            pointF.y = f6 - (linearLayout.getHeight() / 2.0f);
        }
        return pointF;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final boolean MyBillsEntityDataFactory() {
        return this.DatabaseTableConfigUtil.isShowing();
    }

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u00107\u001a\u00020\u0005\u0012\b\b\u0002\u00108\u001a\u00020\u000f¢\u0006\u0004\b9\u0010:J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0012\u0010\r\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\u0003\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0012\u0010\u0006\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0012\u0010\u0014\u001a\u00020\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0016\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0012\u0010\u0017\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0012\u0010\u0015\u001a\u00020\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\u00188\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\n\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u00188\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u0006\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u000eR\u0012\u0010\u001e\u001a\u00020\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u000eR\u0012\u0010\u001f\u001a\u00020\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u000eR\u0012\u0010!\u001a\u00020\u000fX\u0087\u0002¢\u0006\u0006\n\u0004\b \u0010\u0010R-\u0010'\u001a\u001d\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\b#\u0012\u0004\u0012\u00020$\u0018\u00010\"j\u0004\u0018\u0001`%X\u0087\u0002¢\u0006\u0006\n\u0004\b!\u0010&R\u0012\u0010 \u001a\u00020\u000fX\u0087\u0002¢\u0006\u0006\n\u0004\b'\u0010\u0010R\u0012\u0010(\u001a\u00020\u000fX\u0087\u0002¢\u0006\u0006\n\u0004\b(\u0010\u0010R\u0014\u0010*\u001a\u0004\u0018\u00010)X\u0087\u0002¢\u0006\u0006\n\u0004\b*\u0010+R\u0012\u0010,\u001a\u00020\fX\u0087\u0002¢\u0006\u0006\n\u0004\b,\u0010\u000eR\u0012\u0010-\u001a\u00020\u000fX\u0087\u0002¢\u0006\u0006\n\u0004\b-\u0010\u0010R\u0014\u00101\u001a\u0004\u0018\u00010.X\u0087\u0002¢\u0006\u0006\n\u0004\b/\u00100R\u0012\u00104\u001a\u000202X\u0087\u0002¢\u0006\u0006\n\u0004\b1\u00103R\u0016\u0010/\u001a\u0006*\u00020505X\u0087\u0002¢\u0006\u0006\n\u0004\b4\u00106"}, d2 = {"Lid/dana/core/ui/custom/tooltip/Tooltip$Builder;", "", "Lid/dana/core/ui/custom/tooltip/Tooltip;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/core/ui/custom/tooltip/Tooltip;", "Landroid/view/View;", "PlaceComponentResult", "Landroid/view/View;", "getAuthRequestContext", "Landroid/graphics/drawable/Drawable;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/graphics/drawable/Drawable;", "", "MyBillsEntityDataFactory", LogConstants.RESULT_FALSE, "", "I", "Landroid/content/Context;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/content/Context;", "getErrorConfigVersion", "scheduleImpl", "lookAheadTest", "moveToNextValue", "", "GetContactSyncConfig", "Z", "()Z", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "newProxyInstance", "isLayoutRequested", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "", "Lid/dana/core/ui/custom/tooltip/OnIconClickListener;", "Lkotlin/jvm/functions/Function1;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Landroid/content/res/ColorStateList;", "PrepareContext", "Landroid/content/res/ColorStateList;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda3", "", "FragmentBottomSheetPaymentSettingBinding", "Ljava/lang/CharSequence;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "", "J", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Landroid/graphics/Typeface;", "Landroid/graphics/Typeface;", "p0", "p1", "<init>", "(Landroid/view/View;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {
        public static final byte[] getSupportButtonTintMode = {112, Ascii.US, -51, -82, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
        public static final int whenAvailable = 196;

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public int PlaceComponentResult;

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        float initRecordTimeStamp;

        /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
        public CharSequence NetworkUserEntityData$$ExternalSyntheticLambda5;
        public boolean GetContactSyncConfig;
        Drawable KClassImpl$Data$declaredNonStaticMembers$2;
        public float MyBillsEntityDataFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public Context getErrorConfigVersion;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        float DatabaseTableConfigUtil;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public float NetworkUserEntityData$$ExternalSyntheticLambda1;
        int NetworkUserEntityData$$ExternalSyntheticLambda3;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
        Typeface FragmentBottomSheetPaymentSettingBinding;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
        public long NetworkUserEntityData$$ExternalSyntheticLambda4;
        public float NetworkUserEntityData$$ExternalSyntheticLambda6;
        int NetworkUserEntityData$$ExternalSyntheticLambda7;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
        public int newProxyInstance;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        View getAuthRequestContext;
        public ColorStateList PrepareContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public float BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public Drawable NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: isLayoutRequested  reason: from kotlin metadata */
        public Function1<? super Tooltip, Unit> NetworkUserEntityData$$ExternalSyntheticLambda8;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public int scheduleImpl;
        public int moveToNextValue;

        /* renamed from: newProxyInstance  reason: from kotlin metadata */
        int isLayoutRequested;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public float lookAheadTest;

        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0028). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(java.lang.Object[] r8) {
            /*
                byte[] r0 = id.dana.core.ui.custom.tooltip.Tooltip.Builder.getSupportButtonTintMode
                r1 = 23
                byte[] r1 = new byte[r1]
                r2 = 4
                r3 = 97
                r4 = 0
                if (r0 != 0) goto L11
                r3 = 4
                r5 = 97
                r7 = 0
                goto L28
            L11:
                r2 = 97
                r3 = 4
                r5 = 0
            L15:
                byte r6 = (byte) r2
                r1[r5] = r6
                r6 = 22
                int r7 = r5 + 1
                if (r5 != r6) goto L26
                java.lang.String r0 = new java.lang.String
                r0.<init>(r1, r4)
                r8[r4] = r0
                return
            L26:
                r5 = r0[r3]
            L28:
                int r2 = r2 + r5
                int r2 = r2 + (-8)
                int r3 = r3 + 1
                r5 = r7
                goto L15
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.custom.tooltip.Tooltip.Builder.a(java.lang.Object[]):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0129, code lost:
        
            if (r7 != null) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private Builder(android.view.View r6, int r7) {
            /*
                Method dump skipped, instructions count: 323
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.custom.tooltip.Tooltip.Builder.<init>(android.view.View, int):void");
        }

        public /* synthetic */ Builder(View view, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, (i2 & 2) != 0 ? 0 : i);
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getGetContactSyncConfig() {
            return this.GetContactSyncConfig;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getNetworkUserEntityData$$ExternalSyntheticLambda2() {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        }

        public final Tooltip BuiltInFictitiousFunctionClassFactory() {
            if (this.MyBillsEntityDataFactory == -1.0f) {
                this.MyBillsEntityDataFactory = this.getErrorConfigVersion.getResources().getDimension(R.dimen.getAuthRequestContext_res_0x7f070052);
            }
            if (this.BuiltInFictitiousFunctionClassFactory == -1.0f) {
                this.BuiltInFictitiousFunctionClassFactory = this.getErrorConfigVersion.getResources().getDimension(R.dimen.BuiltInFictitiousFunctionClassFactory_res_0x7f070055);
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == -1.0f) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = this.getErrorConfigVersion.getResources().getDimension(R.dimen.MyBillsEntityDataFactory_res_0x7f07005f);
            }
            if (this.newProxyInstance == -1) {
                this.newProxyInstance = this.getErrorConfigVersion.getResources().getDimensionPixelSize(R.dimen.MyBillsEntityDataFactory_res_0x7f07005f);
            }
            final Tooltip tooltip = new Tooltip(this, null);
            long j = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (!tooltip.MyBillsEntityDataFactory()) {
                LinearLayout linearLayout = tooltip.getAuthRequestContext;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    linearLayout = null;
                }
                linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(tooltip.scheduleImpl);
                View view = tooltip.PlaceComponentResult;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    view = null;
                }
                view.addOnAttachStateChangeListener(tooltip.lookAheadTest);
                View view2 = tooltip.PlaceComponentResult;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    view2 = null;
                }
                view2.post(new Runnable() { // from class: id.dana.core.ui.custom.tooltip.Tooltip$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Tooltip.MyBillsEntityDataFactory(Tooltip.this);
                    }
                });
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new Tooltip$show$2(j, tooltip, null), 3, null);
            return tooltip;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Tooltip tooltip) {
        Intrinsics.checkNotNullParameter(tooltip, "");
        View view = tooltip.PlaceComponentResult;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view = null;
        }
        if (view.isShown()) {
            PopupWindow popupWindow = tooltip.DatabaseTableConfigUtil;
            View view3 = tooltip.PlaceComponentResult;
            if (view3 != null) {
                view2 = view3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            popupWindow.showAsDropDown(view2);
            return;
        }
        DanaLog.BuiltInFictitiousFunctionClassFactory("Tooltip", "Tooltip cannot be shown, root view is invalid or has been closed");
    }

    public static /* synthetic */ void PlaceComponentResult(Tooltip tooltip) {
        Intrinsics.checkNotNullParameter(tooltip, "");
        View view = tooltip.PlaceComponentResult;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view = null;
        }
        view.getViewTreeObserver().removeOnScrollChangedListener(tooltip.NetworkUserEntityData$$ExternalSyntheticLambda0);
        View view3 = tooltip.PlaceComponentResult;
        if (view3 != null) {
            view2 = view3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        view2.removeOnAttachStateChangeListener(tooltip.lookAheadTest);
    }

    public static /* synthetic */ void getAuthRequestContext(Tooltip tooltip) {
        Intrinsics.checkNotNullParameter(tooltip, "");
        PointF PlaceComponentResult = tooltip.PlaceComponentResult();
        tooltip.DatabaseTableConfigUtil.update((int) PlaceComponentResult.x, (int) PlaceComponentResult.y, tooltip.DatabaseTableConfigUtil.getWidth(), tooltip.DatabaseTableConfigUtil.getHeight());
    }

    public static /* synthetic */ void getAuthRequestContext(Builder builder, Tooltip tooltip) {
        Intrinsics.checkNotNullParameter(builder, "");
        Intrinsics.checkNotNullParameter(tooltip, "");
        Function1<? super Tooltip, Unit> function1 = builder.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (function1 != null) {
            function1.invoke(tooltip);
        }
    }
}
