package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private ForwardingListener MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Drawable PlaceComponentResult;
    private boolean getAuthRequestContext;
    private int getErrorConfigVersion;
    MenuItemImpl mItemData;
    MenuBuilder.ItemInvoker mItemInvoker;
    PopupCallback mPopupCallback;
    private CharSequence moveToNextValue;
    private int scheduleImpl;

    /* loaded from: classes.dex */
    public static abstract class PopupCallback {
        public abstract ShowableListMenu getAuthRequestContext();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setShortcut(boolean z, char c) {
    }

    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda5, i, 0);
        this.getErrorConfigVersion = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FragmentBottomSheetPaymentSettingBinding, 0);
        obtainStyledAttributes.recycle();
        this.scheduleImpl = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory();
        getAuthRequestContext();
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    private boolean MyBillsEntityDataFactory() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        CharSequence title;
        this.mItemData = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        if (prefersCondensedTitle()) {
            title = menuItemImpl.getTitleCondensed();
        } else {
            title = menuItemImpl.getTitle();
        }
        setTitle(title);
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new ActionMenuItemForwardingListener();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (this.mItemData.hasSubMenu() && (forwardingListener = this.MyBillsEntityDataFactory) != null && forwardingListener.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.mItemInvoker;
        if (itemInvoker != null) {
            itemInvoker.invokeItem(this.mItemData);
        }
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.mItemInvoker = itemInvoker;
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.mPopupCallback = popupCallback;
    }

    public void setExpandedFormat(boolean z) {
        if (this.getAuthRequestContext != z) {
            this.getAuthRequestContext = z;
            MenuItemImpl menuItemImpl = this.mItemData;
            if (menuItemImpl != null) {
                menuItemImpl.PlaceComponentResult.onItemActionRequestChanged(menuItemImpl);
            }
        }
    }

    private void getAuthRequestContext() {
        boolean z = (!TextUtils.isEmpty(this.moveToNextValue)) & (this.PlaceComponentResult == null || (this.mItemData.NetworkUserEntityData$$ExternalSyntheticLambda1() && (this.KClassImpl$Data$declaredNonStaticMembers$2 || this.getAuthRequestContext)));
        setText(z ? this.moveToNextValue : null);
        CharSequence contentDescription = this.mItemData.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z ? null : this.mItemData.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.mItemData.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            TooltipCompat.PlaceComponentResult(this, z ? null : this.mItemData.getTitle());
        } else {
            TooltipCompat.PlaceComponentResult(this, tooltipText);
        }
    }

    public void setIcon(Drawable drawable) {
        this.PlaceComponentResult = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.scheduleImpl;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        getAuthRequestContext();
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.moveToNextValue = charSequence;
        getAuthRequestContext();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        return hasText() && this.mItemData.getIcon() == null;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        boolean hasText = hasText();
        if (hasText && (i4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(size, this.getErrorConfigVersion);
        } else {
            i3 = this.getErrorConfigVersion;
        }
        if (mode != 1073741824 && this.getErrorConfigVersion > 0 && measuredWidth < i3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
        }
        if (hasText || this.PlaceComponentResult == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.PlaceComponentResult.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    /* loaded from: classes.dex */
    class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getAuthRequestContext() {
            if (ActionMenuItemView.this.mPopupCallback != null) {
                return ActionMenuItemView.this.mPopupCallback.getAuthRequestContext();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean MyBillsEntityDataFactory() {
            ShowableListMenu authRequestContext;
            return ActionMenuItemView.this.mItemInvoker != null && ActionMenuItemView.this.mItemInvoker.invokeItem(ActionMenuItemView.this.mItemData) && (authRequestContext = getAuthRequestContext()) != null && authRequestContext.PlaceComponentResult();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
