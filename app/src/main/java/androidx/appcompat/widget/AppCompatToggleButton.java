package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundDrawablesView;

/* loaded from: classes3.dex */
public class AppCompatToggleButton extends ToggleButton implements TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {
    private AppCompatEmojiTextHelper KClassImpl$Data$declaredNonStaticMembers$2;
    private final AppCompatBackgroundHelper PlaceComponentResult;
    private final AppCompatTextHelper getAuthRequestContext;

    public AppCompatToggleButton(Context context) {
        this(context, null);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ThemeUtils.getAuthRequestContext(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.PlaceComponentResult = appCompatBackgroundHelper;
        appCompatBackgroundHelper.getAuthRequestContext(attributeSet, i);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.getAuthRequestContext = appCompatTextHelper;
        appCompatTextHelper.KClassImpl$Data$declaredNonStaticMembers$2(attributeSet, i);
        BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(attributeSet, i);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.PlaceComponentResult;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.PlaceComponentResult;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.PlaceComponentResult(drawable);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.PlaceComponentResult;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.MyBillsEntityDataFactory(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.PlaceComponentResult;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.MyBillsEntityDataFactory();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.PlaceComponentResult;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.BuiltInFictitiousFunctionClassFactory(mode);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.PlaceComponentResult;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getAuthRequestContext();
        }
        return null;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.PlaceComponentResult;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        AppCompatTextHelper appCompatTextHelper = this.getAuthRequestContext;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.MyBillsEntityDataFactory();
        }
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(inputFilterArr));
    }

    private AppCompatEmojiTextHelper BuiltInFictitiousFunctionClassFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new AppCompatEmojiTextHelper(this);
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(z);
    }

    public void setEmojiCompatEnabled(boolean z) {
        BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(z);
    }

    public boolean isEmojiCompatEnabled() {
        return BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.getAuthRequestContext;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.GetContactSyncConfig();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.getAuthRequestContext;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.GetContactSyncConfig();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.getAuthRequestContext.lookAheadTest();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.getAuthRequestContext.MyBillsEntityDataFactory(colorStateList);
        this.getAuthRequestContext.MyBillsEntityDataFactory();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.getAuthRequestContext.getErrorConfigVersion();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(mode);
        this.getAuthRequestContext.MyBillsEntityDataFactory();
    }
}
