package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class AbsActionBarView extends ViewGroup {
    private boolean PlaceComponentResult;
    private boolean getAuthRequestContext;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener;
    protected ViewPropertyAnimatorCompat mVisibilityAnim;

    /* JADX INFO: Access modifiers changed from: protected */
    public static int next(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    AbsActionBarView(Context context) {
        this(context, null);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVisAnimListener = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.BuiltInFictitiousFunctionClassFactory, typedValue, true) && typedValue.resourceId != 0) {
            this.mPopupContext = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.mPopupContext = context;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.KClassImpl$Data$declaredNonStaticMembers$2, R.attr.KClassImpl$Data$declaredNonStaticMembers$2, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda1, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.getErrorConfigVersion();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.PlaceComponentResult = false;
        }
        if (!this.PlaceComponentResult) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.PlaceComponentResult = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.PlaceComponentResult = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.getAuthRequestContext = false;
        }
        if (!this.getAuthRequestContext) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.getAuthRequestContext = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.getAuthRequestContext = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.mContentHeight = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public int getAnimatedVisibility() {
        if (this.mVisibilityAnim != null) {
            return this.mVisAnimListener.getAuthRequestContext;
        }
        return getVisibility();
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.BuiltInFictitiousFunctionClassFactory();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            ViewPropertyAnimatorCompat authRequestContext = ViewCompat.MyBillsEntityDataFactory(this).getAuthRequestContext(1.0f);
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(j);
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.mVisAnimListener.BuiltInFictitiousFunctionClassFactory(authRequestContext, i));
            return authRequestContext;
        }
        ViewPropertyAnimatorCompat authRequestContext2 = ViewCompat.MyBillsEntityDataFactory(this).getAuthRequestContext(0.0f);
        authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2(j);
        authRequestContext2.KClassImpl$Data$declaredNonStaticMembers$2(this.mVisAnimListener.BuiltInFictitiousFunctionClassFactory(authRequestContext2, i));
        return authRequestContext2;
    }

    public void animateToVisibility(int i) {
        setupAnimatorToVisibility(i, 200L).PlaceComponentResult();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.BuiltInFictitiousFunctionClassFactory();
            }
            super.setVisibility(i);
        }
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.scheduleImpl();
        }
        return false;
    }

    public void postShowOverflowMenu() {
        post(new Runnable() { // from class: androidx.appcompat.widget.AbsActionBarView.1
            @Override // java.lang.Runnable
            public void run() {
                AbsActionBarView.this.showOverflowMenu();
            }
        });
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.PlaceComponentResult();
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.BuiltInFictitiousFunctionClassFactory();
        }
        return false;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.getAuthRequestContext();
        }
        return false;
    }

    public boolean isOverflowReserved() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        return actionMenuPresenter != null && actionMenuPresenter.moveToNextValue();
    }

    public boolean canShowOverflowMenu() {
        return isOverflowReserved() && getVisibility() == 0;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.MyBillsEntityDataFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int measureChildView(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int positionChild(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        private boolean PlaceComponentResult = false;
        int getAuthRequestContext;

        protected VisibilityAnimListener() {
        }

        public final VisibilityAnimListener BuiltInFictitiousFunctionClassFactory(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            AbsActionBarView.this.mVisibilityAnim = viewPropertyAnimatorCompat;
            this.getAuthRequestContext = i;
            return this;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void MyBillsEntityDataFactory(View view) {
            AbsActionBarView.super.setVisibility(0);
            this.PlaceComponentResult = false;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void getAuthRequestContext(View view) {
            if (this.PlaceComponentResult) {
                return;
            }
            AbsActionBarView.this.mVisibilityAnim = null;
            AbsActionBarView.super.setVisibility(this.getAuthRequestContext);
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void KClassImpl$Data$declaredNonStaticMembers$2(View view) {
            this.PlaceComponentResult = true;
        }
    }
}
