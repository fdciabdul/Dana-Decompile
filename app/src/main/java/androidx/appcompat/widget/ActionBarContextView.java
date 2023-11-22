package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {
    private TextView DatabaseTableConfigUtil;
    private int GetContactSyncConfig;
    private View MyBillsEntityDataFactory;
    private CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0;
    private LinearLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private View PlaceComponentResult;
    private int getAuthRequestContext;
    private int getErrorConfigVersion;
    private View lookAheadTest;
    private CharSequence moveToNextValue;
    private TextView scheduleImpl;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {75, 108, -123, 87, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 1;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int i) {
        super.animateToVisibility(i);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        return super.setupAnimatorToVisibility(i, j);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.GetContactSyncConfig);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(context, attributeSet, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda3, i, 0);
        ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this, __fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, R.styleable.whenAvailable));
        this.GetContactSyncConfig = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.readMicros, 0);
        this.getErrorConfigVersion = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.getCallingPid, 0);
        this.mContentHeight = authRequestContext.BuiltInFictitiousFunctionClassFactory.getLayoutDimension(R.styleable.getSupportButtonTintMode, 0);
        this.getAuthRequestContext = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.SubSequence, R.layout.KClassImpl$Data$declaredNonStaticMembers$2);
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.PlaceComponentResult();
            this.mActionMenuPresenter.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int i) {
        this.mContentHeight = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.lookAheadTest;
        if (view2 != null) {
            removeView(view2);
        }
        this.lookAheadTest = view;
        if (view != null && (linearLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda1) != null) {
            removeView(linearLayout);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = charSequence;
        MyBillsEntityDataFactory();
        ViewCompat.BuiltInFictitiousFunctionClassFactory(this, charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.moveToNextValue = charSequence;
        MyBillsEntityDataFactory();
    }

    public CharSequence getTitle() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public CharSequence getSubtitle() {
        return this.moveToNextValue;
    }

    private void MyBillsEntityDataFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.PlaceComponentResult, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = linearLayout;
            this.DatabaseTableConfigUtil = (TextView) linearLayout.findViewById(R.id.MyBillsEntityDataFactory);
            this.scheduleImpl = (TextView) this.NetworkUserEntityData$$ExternalSyntheticLambda1.findViewById(R.id.BuiltInFictitiousFunctionClassFactory);
            if (this.GetContactSyncConfig != 0) {
                this.DatabaseTableConfigUtil.setTextAppearance(getContext(), this.GetContactSyncConfig);
            }
            if (this.getErrorConfigVersion != 0) {
                this.scheduleImpl.setTextAppearance(getContext(), this.getErrorConfigVersion);
            }
        }
        this.DatabaseTableConfigUtil.setText(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        this.scheduleImpl.setText(this.moveToNextValue);
        boolean isEmpty = TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        boolean z = !TextUtils.isEmpty(this.moveToNextValue);
        this.scheduleImpl.setVisibility(z ? 0 : 8);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.setVisibility(((isEmpty ^ true) || z) ? 0 : 8);
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.getParent() == null) {
            addView(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
    }

    public void initForMode(final ActionMode actionMode) {
        View view = this.PlaceComponentResult;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.getAuthRequestContext, (ViewGroup) this, false);
            this.PlaceComponentResult = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.PlaceComponentResult);
        }
        View findViewById = this.PlaceComponentResult.findViewById(R.id.moveToNextValue);
        this.MyBillsEntityDataFactory = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                actionMode.BuiltInFictitiousFunctionClassFactory();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.PlaceComponentResult();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.MyBillsEntityDataFactory();
        }
        this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        actionMenuPresenter.PrepareContext = true;
        actionMenuPresenter.isLayoutRequested = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.PlaceComponentResult(this);
        ViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.mMenuView, (Drawable) null);
        addView(this.mMenuView, layoutParams);
    }

    public void closeMode() {
        if (this.PlaceComponentResult == null) {
            killMode();
        }
    }

    public void killMode() {
        removeAllViews();
        this.lookAheadTest = null;
        this.mMenuView = null;
        this.mActionMenuPresenter = null;
        View view = this.MyBillsEntityDataFactory;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.scheduleImpl();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean hideOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.PlaceComponentResult();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.BuiltInFictitiousFunctionClassFactory();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
            throw new IllegalStateException(sb.toString());
        } else if (View.MeasureSpec.getMode(i2) == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getClass().getSimpleName());
            sb2.append(" can only be used with android:layout_height=\"wrap_content\"");
            throw new IllegalStateException(sb2.toString());
        } else {
            int size = View.MeasureSpec.getSize(i);
            int size2 = this.mContentHeight > 0 ? this.mContentHeight : View.MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i3 = size2 - paddingTop;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
            View view = this.PlaceComponentResult;
            if (view != null) {
                int measureChildView = measureChildView(view, paddingLeft, makeMeasureSpec, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.PlaceComponentResult.getLayoutParams();
                paddingLeft = measureChildView - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            }
            if (this.mMenuView != null && this.mMenuView.getParent() == this) {
                paddingLeft = measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec, 0);
            }
            LinearLayout linearLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (linearLayout != null && this.lookAheadTest == null) {
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    int measuredWidth = this.NetworkUserEntityData$$ExternalSyntheticLambda1.getMeasuredWidth();
                    boolean z = measuredWidth <= paddingLeft;
                    if (z) {
                        paddingLeft -= measuredWidth;
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda1.setVisibility(z ? 0 : 8);
                } else {
                    paddingLeft = measureChildView(linearLayout, paddingLeft, makeMeasureSpec, 0);
                }
            }
            View view2 = this.lookAheadTest;
            if (view2 != null) {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                int i4 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                int i5 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
                if (layoutParams.height >= 0) {
                    i3 = Math.min(layoutParams.height, i3);
                }
                this.lookAheadTest.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(i3, i5));
            }
            if (this.mContentHeight <= 0) {
                int childCount = getChildCount();
                int i6 = 0;
                for (int i7 = 0; i7 < childCount; i7++) {
                    int measuredHeight = getChildAt(i7).getMeasuredHeight() + paddingTop;
                    if (measuredHeight > i6) {
                        i6 = measuredHeight;
                    }
                }
                setMeasuredDimension(size, i6);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean authRequestContext = ViewUtils.getAuthRequestContext(this);
        int paddingRight = authRequestContext ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.PlaceComponentResult;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.PlaceComponentResult.getLayoutParams();
            int i5 = authRequestContext ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = authRequestContext ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int next = next(paddingRight, i5, authRequestContext);
            paddingRight = next(next + positionChild(this.PlaceComponentResult, next, paddingTop, paddingTop2, authRequestContext), i6, authRequestContext);
        }
        int i7 = paddingRight;
        LinearLayout linearLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (linearLayout != null && this.lookAheadTest == null && linearLayout.getVisibility() != 8) {
            i7 += positionChild(this.NetworkUserEntityData$$ExternalSyntheticLambda1, i7, paddingTop, paddingTop2, authRequestContext);
        }
        int i8 = i7;
        View view2 = this.lookAheadTest;
        if (view2 != null) {
            positionChild(view2, i8, paddingTop, paddingTop2, authRequestContext);
        }
        int paddingLeft = authRequestContext ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.mMenuView != null) {
            positionChild(this.mMenuView, paddingLeft, paddingTop, paddingTop2, !authRequestContext);
        }
    }

    public void setTitleOptional(boolean z) {
        if (z != this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            requestLayout();
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
    }

    public boolean isTitleOptional() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004e -> B:15:0x005b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray r10, int r11) {
        /*
            int r0 = androidx.appcompat.widget.ActionBarContextView.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + (-1)
            byte r0 = (byte) r0
            byte r1 = (byte) r0
            byte r2 = (byte) r1
            int r1 = r1 * 3
            int r1 = 3 - r1
            byte[] r3 = androidx.appcompat.widget.ActionBarContextView.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 * 2
            int r0 = r0 + 97
            int r2 = r2 * 4
            int r2 = 23 - r2
            byte[] r4 = new byte[r2]
            int r2 = r2 + (-1)
            r5 = 0
            if (r3 != 0) goto L24
            r6 = r3
            r7 = r4
            r8 = 0
            r3 = r1
            r4 = r2
            r1 = r11
            r11 = r10
            goto L5b
        L24:
            r6 = r4
            r7 = 0
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r11
            r11 = r10
        L2c:
            byte r8 = (byte) r1
            int r2 = r2 + 1
            r6[r7] = r8
            if (r7 != r3) goto L4e
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6, r5)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L49
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L49:
            android.graphics.drawable.Drawable r10 = r11.BuiltInFictitiousFunctionClassFactory(r0)
            return r10
        L4e:
            r8 = r4[r2]
            int r7 = r7 + 1
            r9 = r1
            r1 = r0
            r0 = r8
            r8 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r2
            r2 = r9
        L5b:
            int r2 = r2 + r0
            int r0 = r2 + (-8)
            r2 = r3
            r3 = r4
            r4 = r6
            r6 = r7
            r7 = r8
            r9 = r1
            r1 = r0
            r0 = r9
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarContextView.__fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray, int):android.graphics.drawable.Drawable");
    }
}
