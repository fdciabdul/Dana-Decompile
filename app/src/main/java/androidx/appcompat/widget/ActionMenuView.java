package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private MenuPresenter.Callback BuiltInFictitiousFunctionClassFactory;
    private int MyBillsEntityDataFactory;
    private MenuBuilder NetworkUserEntityData$$ExternalSyntheticLambda0;
    private ActionMenuPresenter NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private boolean PlaceComponentResult;
    private int getErrorConfigVersion;
    private int lookAheadTest;
    MenuBuilder.Callback mMenuBuilderCallback;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context moveToNextValue;
    private int scheduleImpl;

    /* loaded from: classes.dex */
    public interface ActionMenuChildView {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
        boolean MyBillsEntityDataFactory(MenuItem menuItem);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.getErrorConfigVersion = (int) (56.0f * f);
        this.scheduleImpl = (int) (f * 4.0f);
        this.moveToNextValue = context;
        this.lookAheadTest = 0;
    }

    public void setPopupTheme(int i) {
        if (this.lookAheadTest != i) {
            this.lookAheadTest = i;
            if (i == 0) {
                this.moveToNextValue = getContext();
            } else {
                this.moveToNextValue = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.lookAheadTest;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = actionMenuPresenter;
        actionMenuPresenter.scheduleImpl = this;
        initialize(actionMenuPresenter.PlaceComponentResult);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.updateMenuView(false);
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.BuiltInFictitiousFunctionClassFactory()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult();
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.scheduleImpl();
            }
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v37 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        boolean z2;
        boolean z3;
        int i6;
        ?? r3;
        MenuBuilder menuBuilder;
        boolean z4 = this.PlaceComponentResult;
        boolean z5 = View.MeasureSpec.getMode(i) == 1073741824;
        this.PlaceComponentResult = z5;
        if (z4 != z5) {
            this.MyBillsEntityDataFactory = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.PlaceComponentResult && (menuBuilder = this.NetworkUserEntityData$$ExternalSyntheticLambda0) != null && size != this.MyBillsEntityDataFactory) {
            this.MyBillsEntityDataFactory = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.PlaceComponentResult || childCount <= 0) {
            for (int i7 = 0; i7 < childCount; i7++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i7).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i8 = size2 - (paddingLeft + paddingRight);
        int i9 = this.getErrorConfigVersion;
        int i10 = i8 / i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i11 = i9 + ((i8 % i9) / i10);
        int childCount2 = getChildCount();
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        boolean z6 = false;
        int i16 = 0;
        long j = 0;
        while (i15 < childCount2) {
            View childAt = getChildAt(i15);
            int i17 = size3;
            if (childAt.getVisibility() != 8) {
                boolean z7 = childAt instanceof ActionMenuItemView;
                int i18 = i12 + 1;
                if (z7) {
                    int i19 = this.scheduleImpl;
                    i6 = i18;
                    r3 = 0;
                    childAt.setPadding(i19, 0, i19, 0);
                } else {
                    i6 = i18;
                    r3 = 0;
                }
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                layoutParams2.MyBillsEntityDataFactory = r3;
                layoutParams2.PlaceComponentResult = r3;
                layoutParams2.KClassImpl$Data$declaredNonStaticMembers$2 = r3;
                layoutParams2.getAuthRequestContext = r3;
                layoutParams2.leftMargin = r3;
                layoutParams2.rightMargin = r3;
                layoutParams2.NetworkUserEntityData$$ExternalSyntheticLambda0 = z7 && ((ActionMenuItemView) childAt).hasText();
                int measureChildForCells = measureChildForCells(childAt, i11, layoutParams2.BuiltInFictitiousFunctionClassFactory ? 1 : i10, childMeasureSpec, paddingTop);
                i13 = Math.max(i13, measureChildForCells);
                if (layoutParams2.getAuthRequestContext) {
                    i16++;
                }
                if (layoutParams2.BuiltInFictitiousFunctionClassFactory) {
                    z6 = true;
                }
                i10 -= measureChildForCells;
                i14 = Math.max(i14, childAt.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    j |= 1 << i15;
                }
                i12 = i6;
            }
            i15++;
            size3 = i17;
        }
        int i20 = size3;
        boolean z8 = z6 && i12 == 2;
        boolean z9 = false;
        while (i16 > 0 && i10 > 0) {
            int i21 = Integer.MAX_VALUE;
            int i22 = 0;
            int i23 = 0;
            long j2 = 0;
            while (i22 < childCount2) {
                boolean z10 = z9;
                LayoutParams layoutParams3 = (LayoutParams) getChildAt(i22).getLayoutParams();
                int i24 = i14;
                if (layoutParams3.getAuthRequestContext) {
                    if (layoutParams3.KClassImpl$Data$declaredNonStaticMembers$2 < i21) {
                        i21 = layoutParams3.KClassImpl$Data$declaredNonStaticMembers$2;
                        j2 = 1 << i22;
                        i23 = 1;
                    } else if (layoutParams3.KClassImpl$Data$declaredNonStaticMembers$2 == i21) {
                        j2 |= 1 << i22;
                        i23++;
                    }
                }
                i22++;
                i14 = i24;
                z9 = z10;
            }
            z = z9;
            i5 = i14;
            j |= j2;
            if (i23 > i10) {
                i3 = mode;
                i4 = i8;
                break;
            }
            int i25 = 0;
            while (i25 < childCount2) {
                View childAt2 = getChildAt(i25);
                LayoutParams layoutParams4 = (LayoutParams) childAt2.getLayoutParams();
                int i26 = i8;
                int i27 = mode;
                long j3 = 1 << i25;
                if ((j2 & j3) == 0) {
                    if (layoutParams4.KClassImpl$Data$declaredNonStaticMembers$2 == i21 + 1) {
                        j |= j3;
                    }
                    z3 = z8;
                } else {
                    if (z8 && layoutParams4.NetworkUserEntityData$$ExternalSyntheticLambda0 && i10 == 1) {
                        int i28 = this.scheduleImpl;
                        z3 = z8;
                        childAt2.setPadding(i28 + i11, 0, i28, 0);
                    } else {
                        z3 = z8;
                    }
                    layoutParams4.KClassImpl$Data$declaredNonStaticMembers$2++;
                    layoutParams4.MyBillsEntityDataFactory = true;
                    i10--;
                }
                i25++;
                mode = i27;
                i8 = i26;
                z8 = z3;
            }
            i14 = i5;
            z9 = true;
        }
        i3 = mode;
        i4 = i8;
        z = z9;
        i5 = i14;
        boolean z11 = !z6 && i12 == 1;
        if (i10 <= 0 || j == 0 || (i10 >= i12 - 1 && !z11 && i13 <= 1)) {
            z2 = z;
        } else {
            float bitCount = Long.bitCount(j);
            if (!z11) {
                if ((j & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    bitCount -= 0.5f;
                }
                int i29 = childCount2 - 1;
                if ((j & (1 << i29)) != 0 && !((LayoutParams) getChildAt(i29).getLayoutParams()).NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    bitCount -= 0.5f;
                }
            }
            int i30 = bitCount > 0.0f ? (int) ((i10 * i11) / bitCount) : 0;
            boolean z12 = z;
            for (int i31 = 0; i31 < childCount2; i31++) {
                if ((j & (1 << i31)) != 0) {
                    View childAt3 = getChildAt(i31);
                    LayoutParams layoutParams5 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams5.PlaceComponentResult = i30;
                        layoutParams5.MyBillsEntityDataFactory = true;
                        if (i31 == 0 && !layoutParams5.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                            layoutParams5.leftMargin = (-i30) / 2;
                        }
                    } else if (layoutParams5.BuiltInFictitiousFunctionClassFactory) {
                        layoutParams5.PlaceComponentResult = i30;
                        layoutParams5.MyBillsEntityDataFactory = true;
                        layoutParams5.rightMargin = (-i30) / 2;
                    } else {
                        if (i31 != 0) {
                            layoutParams5.leftMargin = i30 / 2;
                        }
                        if (i31 != childCount2 - 1) {
                            layoutParams5.rightMargin = i30 / 2;
                        }
                    }
                    z12 = true;
                }
            }
            z2 = z12;
        }
        if (z2) {
            for (int i32 = 0; i32 < childCount2; i32++) {
                View childAt4 = getChildAt(i32);
                LayoutParams layoutParams6 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams6.MyBillsEntityDataFactory) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams6.KClassImpl$Data$declaredNonStaticMembers$2 * i11) + layoutParams6.PlaceComponentResult, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, i3 == 1073741824 ? i20 : i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int measureChildForCells(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.hasText();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (!layoutParams.BuiltInFictitiousFunctionClassFactory && z2) {
            z = true;
        }
        layoutParams.getAuthRequestContext = z;
        layoutParams.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int i5;
        if (!this.PlaceComponentResult) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i3 - i;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean authRequestContext = ViewUtils.getAuthRequestContext(this);
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.BuiltInFictitiousFunctionClassFactory) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (authRequestContext) {
                        i5 = getPaddingLeft() + layoutParams.leftMargin;
                        width = i5 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i5 = width - measuredWidth;
                    }
                    int i11 = i6 - (measuredHeight / 2);
                    childAt.layout(i5, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    hasSupportDividerBeforeChildAt(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int max = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (authRequestContext) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.BuiltInFictitiousFunctionClassFactory) {
                    int i16 = width2 - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i6 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.BuiltInFictitiousFunctionClassFactory) {
                int i19 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i6 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft = i19 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton = actionMenuPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        actionMenuPresenter.DatabaseTableConfigUtil = true;
        actionMenuPresenter.GetContactSyncConfig = drawable;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton = actionMenuPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (actionMenuPresenter.DatabaseTableConfigUtil) {
            return actionMenuPresenter.GetContactSyncConfig;
        }
        return null;
    }

    public boolean isOverflowReserved() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public void setOverflowReserved(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams();
        layoutParams.gravity = 16;
        return layoutParams;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams != null) {
            if (layoutParams instanceof LayoutParams) {
                layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
            } else {
                layoutParams2 = new LayoutParams(layoutParams);
            }
            if (layoutParams2.gravity <= 0) {
                layoutParams2.gravity = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.BuiltInFictitiousFunctionClassFactory = true;
        return generateDefaultLayoutParams;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.performItemAction(menuItemImpl, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = menuBuilder;
    }

    public Menu getMenu() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = menuBuilder;
            menuBuilder.setCallback(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = actionMenuPresenter;
            actionMenuPresenter.PrepareContext = true;
            actionMenuPresenter.isLayoutRequested = true;
            ActionMenuPresenter actionMenuPresenter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            MenuPresenter.Callback callback = this.BuiltInFictitiousFunctionClassFactory;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.setCallback(callback);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.addMenuPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.moveToNextValue);
            ActionMenuPresenter actionMenuPresenter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            actionMenuPresenter3.scheduleImpl = this;
            initialize(actionMenuPresenter3.PlaceComponentResult);
        }
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.BuiltInFictitiousFunctionClassFactory = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public MenuBuilder peekMenu() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return actionMenuPresenter != null && actionMenuPresenter.scheduleImpl();
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return actionMenuPresenter != null && actionMenuPresenter.PlaceComponentResult();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return actionMenuPresenter != null && actionMenuPresenter.BuiltInFictitiousFunctionClassFactory();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        return actionMenuPresenter != null && actionMenuPresenter.getAuthRequestContext();
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.MyBillsEntityDataFactory();
        }
    }

    protected boolean hasSupportDividerBeforeChildAt(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = false | ((ActionMenuChildView) childAt).needsDividerAfter();
        }
        return (i <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? z : z | ((ActionMenuChildView) childAt2).needsDividerBefore();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.NetworkUserEntityData$$ExternalSyntheticLambda0 = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.mOnMenuItemClickListener != null && ActionMenuView.this.mOnMenuItemClickListener.MyBillsEntityDataFactory(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.mMenuBuilderCallback != null) {
                ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(menuBuilder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void MyBillsEntityDataFactory(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean getAuthRequestContext(MenuBuilder menuBuilder) {
            return false;
        }

        ActionMenuPresenterCallback() {
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty
        public boolean BuiltInFictitiousFunctionClassFactory;
        @ViewDebug.ExportedProperty
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        boolean MyBillsEntityDataFactory;
        @ViewDebug.ExportedProperty
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        @ViewDebug.ExportedProperty
        public int PlaceComponentResult;
        @ViewDebug.ExportedProperty
        public boolean getAuthRequestContext;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.BuiltInFictitiousFunctionClassFactory = layoutParams.BuiltInFictitiousFunctionClassFactory;
        }

        public LayoutParams() {
            super(-2, -2);
            this.BuiltInFictitiousFunctionClassFactory = false;
        }
    }
}
