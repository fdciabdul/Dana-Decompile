package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.FSDispatchDraw;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001KB\u0011\b\u0016\u0012\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CB%\b\u0016\u0012\u0006\u0010A\u001a\u00020@\u0012\b\u0010E\u001a\u0004\u0018\u00010D\u0012\b\b\u0002\u0010F\u001a\u00020\u0004¢\u0006\u0004\bB\u0010GB!\b\u0010\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bB\u0010JJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00028\u0000\"\n\b\u0000\u0010\u001c*\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010\u000eJ\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\"\u0010\u001aJ\u0017\u0010#\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b%\u0010\u001aJ\u001f\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010)J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0015H\u0000¢\u0006\u0004\b,\u0010-J\u0019\u00100\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\b2\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b6\u0010\u001aR\u0018\u00109\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010;R\u0016\u0010>\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010;"}, d2 = {"Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "child", "", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "Landroid/view/WindowInsets;", "insets", "dispatchApplyWindowInsets", "(Landroid/view/WindowInsets;)Landroid/view/WindowInsets;", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "", "drawingTime", "", "drawChild", "(Landroid/graphics/Canvas;Landroid/view/View;J)Z", "view", "endViewTransition", "(Landroid/view/View;)V", "Landroidx/fragment/app/Fragment;", LogConstants.RESULT_FALSE, "getFragment", "()Landroidx/fragment/app/Fragment;", "onApplyWindowInsets", "removeAllViewsInLayout", "()V", "removeView", "removeViewAt", "(I)V", "removeViewInLayout", "start", "count", "removeViews", "(II)V", "removeViewsInLayout", "drawDisappearingViewsFirst", "setDrawDisappearingViewsLast", "(Z)V", "Landroid/animation/LayoutTransition;", "transition", "setLayoutTransition", "(Landroid/animation/LayoutTransition;)V", "Landroid/view/View$OnApplyWindowInsetsListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnApplyWindowInsetsListener", "(Landroid/view/View$OnApplyWindowInsetsListener;)V", "startViewTransition", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View$OnApplyWindowInsetsListener;", "PlaceComponentResult", "", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Z", "getAuthRequestContext", "MyBillsEntityDataFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/fragment/app/FragmentManager;", "fm", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroidx/fragment/app/FragmentManager;)V", "Api20Impl"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout implements FSDispatchDraw {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private View.OnApplyWindowInsetsListener PlaceComponentResult;
    private final List<View> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final List<View> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void fsSuperDispatchDraw_f112575f5ff5b0924fe30960ff0b42d0(Canvas canvas) {
        if (InstrumentInjector.isRecordingDispatchDraw(this, canvas)) {
            return;
        }
        super.dispatchDraw(canvas);
    }

    public final boolean fsSuperDrawChild_f112575f5ff5b0924fe30960ff0b42d0(Canvas canvas, View view, long j) {
        if (InstrumentInjector.isRecordingDrawChild(this, canvas, view, j)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "");
        return insets;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        this.MyBillsEntityDataFactory = new ArrayList();
        this.getAuthRequestContext = true;
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        String str;
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        this.MyBillsEntityDataFactory = new ArrayList();
        this.getAuthRequestContext = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] iArr = R.styleable.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(iArr, "");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(R.styleable.BuiltInFictitiousFunctionClassFactory);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("FragmentContainerView must be within a FragmentActivity to use ");
            sb.append(str);
            sb.append("=\"");
            sb.append(classAttribute);
            sb.append(Typography.quote);
            throw new UnsupportedOperationException(sb.toString());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str = "";
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList();
        this.MyBillsEntityDataFactory = new ArrayList();
        this.getAuthRequestContext = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = R.styleable.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(iArr, "");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R.styleable.BuiltInFictitiousFunctionClassFactory) : classAttribute;
        String string = obtainStyledAttributes.getString(R.styleable.MyBillsEntityDataFactory);
        obtainStyledAttributes.recycle();
        int id2 = getId();
        Fragment findFragmentById = fragmentManager.findFragmentById(id2);
        if (classAttribute != null && findFragmentById == null) {
            if (id2 == -1) {
                if (string != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" with tag ");
                    sb.append(string);
                    str = sb.toString();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("FragmentContainerView must have an android:id to add Fragment ");
                sb2.append(classAttribute);
                sb2.append(str);
                throw new IllegalStateException(sb2.toString());
            }
            Fragment authRequestContext = fragmentManager.getFragmentFactory().getAuthRequestContext(context.getClassLoader(), classAttribute);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            authRequestContext.onInflate(context, attributeSet, (Bundle) null);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.isLayoutRequested = true;
            FragmentContainerView fragmentContainerView = this;
            authRequestContext.mContainer = fragmentContainerView;
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(fragmentContainerView.getId(), authRequestContext, string, 1);
            beginTransaction.MyBillsEntityDataFactory();
        }
        fragmentManager.onContainerAvailable(this);
    }

    @Override // android.view.ViewGroup
    public final void setLayoutTransition(LayoutTransition transition) {
        if (Build.VERSION.SDK_INT < 18) {
            super.setLayoutTransition(transition);
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public final void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.PlaceComponentResult = listener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        WindowInsetsCompat KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(insets, "");
        WindowInsetsCompat PlaceComponentResult = WindowInsetsCompat.PlaceComponentResult(insets);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        if (this.PlaceComponentResult != null) {
            Api20Impl api20Impl = Api20Impl.INSTANCE;
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.PlaceComponentResult;
            Intrinsics.checkNotNull(onApplyWindowInsetsListener);
            KClassImpl$Data$declaredNonStaticMembers$2 = WindowInsetsCompat.PlaceComponentResult(api20Impl.getAuthRequestContext(onApplyWindowInsetsListener, this, insets));
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, PlaceComponentResult);
        }
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        if (!KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewCompat.PlaceComponentResult(getChildAt(i), KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
        return insets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "");
        if (this.getAuthRequestContext) {
            Iterator<T> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                fsSuperDrawChild_f112575f5ff5b0924fe30960ff0b42d0(canvas, (View) it.next(), getDrawingTime());
            }
        }
        fsSuperDispatchDraw_f112575f5ff5b0924fe30960ff0b42d0(canvas);
    }

    @Override // android.view.ViewGroup
    protected final boolean drawChild(Canvas canvas, View child, long drawingTime) {
        Intrinsics.checkNotNullParameter(canvas, "");
        Intrinsics.checkNotNullParameter(child, "");
        if (this.getAuthRequestContext && (!this.BuiltInFictitiousFunctionClassFactory.isEmpty()) == true && this.BuiltInFictitiousFunctionClassFactory.contains(child)) {
            return false;
        }
        return fsSuperDrawChild_f112575f5ff5b0924fe30960ff0b42d0(canvas, child, drawingTime);
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        if (view.getParent() == this) {
            this.MyBillsEntityDataFactory.add(view);
        }
        super.startViewTransition(view);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory.remove(view);
        if (this.BuiltInFictitiousFunctionClassFactory.remove(view)) {
            this.getAuthRequestContext = true;
        }
        super.endViewTransition(view);
    }

    public final void setDrawDisappearingViewsLast(boolean drawDisappearingViewsFirst) {
        this.getAuthRequestContext = drawDisappearingViewsFirst;
    }

    @Override // android.view.ViewGroup
    public final void addView(View child, int index, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(child, "");
        if (FragmentManager.getViewFragment(child) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
            sb.append(child);
            sb.append(" is not associated with a Fragment.");
            throw new IllegalStateException(sb.toString().toString());
        }
        super.addView(child, index, params);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int index) {
        View childAt = getChildAt(index);
        Intrinsics.checkNotNullExpressionValue(childAt, "");
        if (this.MyBillsEntityDataFactory.contains(childAt)) {
            this.BuiltInFictitiousFunctionClassFactory.add(childAt);
        }
        super.removeViewAt(index);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int start, int count) {
        for (int i = start; i < start + count; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "");
            if (this.MyBillsEntityDataFactory.contains(childAt)) {
                this.BuiltInFictitiousFunctionClassFactory.add(childAt);
            }
        }
        super.removeViews(start, count);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int start, int count) {
        for (int i = start; i < start + count; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "");
            if (this.MyBillsEntityDataFactory.contains(childAt)) {
                this.BuiltInFictitiousFunctionClassFactory.add(childAt);
            }
        }
        super.removeViewsInLayout(start, count);
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            Intrinsics.checkNotNullExpressionValue(childAt, "");
            if (this.MyBillsEntityDataFactory.contains(childAt)) {
                this.BuiltInFictitiousFunctionClassFactory.add(childAt);
            }
        }
        super.removeAllViewsInLayout();
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.findFragmentManager(this).findFragmentById(getId());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroidx/fragment/app/FragmentContainerView$Api20Impl;", "", "Landroid/view/View$OnApplyWindowInsetsListener;", "p0", "Landroid/view/View;", "p1", "Landroid/view/WindowInsets;", "p2", "getAuthRequestContext", "(Landroid/view/View$OnApplyWindowInsetsListener;Landroid/view/View;Landroid/view/WindowInsets;)Landroid/view/WindowInsets;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Api20Impl {
        public static final Api20Impl INSTANCE = new Api20Impl();

        private Api20Impl() {
        }

        public final WindowInsets getAuthRequestContext(View.OnApplyWindowInsetsListener p0, View p1, WindowInsets p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            WindowInsets onApplyWindowInsets = p0.onApplyWindowInsets(p1, p2);
            Intrinsics.checkNotNullExpressionValue(onApplyWindowInsets, "");
            return onApplyWindowInsets;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        if (this.MyBillsEntityDataFactory.contains(view)) {
            this.BuiltInFictitiousFunctionClassFactory.add(view);
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        if (this.MyBillsEntityDataFactory.contains(view)) {
            this.BuiltInFictitiousFunctionClassFactory.add(view);
        }
        super.removeViewInLayout(view);
    }
}
