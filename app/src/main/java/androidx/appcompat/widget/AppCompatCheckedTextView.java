package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCheckedTextView;
import androidx.core.widget.TintableCompoundDrawablesView;

/* loaded from: classes3.dex */
public class AppCompatCheckedTextView extends CheckedTextView implements TintableCheckedTextView, TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {
    private final AppCompatTextHelper BuiltInFictitiousFunctionClassFactory;
    private final AppCompatBackgroundHelper KClassImpl$Data$declaredNonStaticMembers$2;
    private final AppCompatCheckedTextViewHelper MyBillsEntityDataFactory;
    private AppCompatEmojiTextHelper getAuthRequestContext;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.NetworkUserEntityData$$ExternalSyntheticLambda4);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.getAuthRequestContext(context), attributeSet, i);
        ThemeUtils.getAuthRequestContext(this, getContext());
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.BuiltInFictitiousFunctionClassFactory = appCompatTextHelper;
        appCompatTextHelper.KClassImpl$Data$declaredNonStaticMembers$2(attributeSet, i);
        appCompatTextHelper.MyBillsEntityDataFactory();
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatBackgroundHelper;
        appCompatBackgroundHelper.getAuthRequestContext(attributeSet, i);
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = new AppCompatCheckedTextViewHelper(this);
        this.MyBillsEntityDataFactory = appCompatCheckedTextViewHelper;
        appCompatCheckedTextViewHelper.KClassImpl$Data$declaredNonStaticMembers$2(attributeSet, i);
        getAuthRequestContext().getAuthRequestContext(attributeSet, i);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.MyBillsEntityDataFactory;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.PlaceComponentResult();
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        Drawable BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), i);
        setCheckMarkDrawable(BuiltInFictitiousFunctionClassFactory);
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.MyBillsEntityDataFactory;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.KClassImpl$Data$declaredNonStaticMembers$2(colorStateList);
        }
    }

    public ColorStateList getSupportCheckMarkTintList() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.MyBillsEntityDataFactory;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.BuiltInFictitiousFunctionClassFactory();
        }
        return null;
    }

    @Override // androidx.core.widget.TintableCheckedTextView
    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.MyBillsEntityDataFactory;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.PlaceComponentResult(mode);
        }
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.MyBillsEntityDataFactory;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.MyBillsEntityDataFactory(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.MyBillsEntityDataFactory();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.BuiltInFictitiousFunctionClassFactory(mode);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getAuthRequestContext();
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.PlaceComponentResult(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.PlaceComponentResult(context, i);
        }
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.MyBillsEntityDataFactory();
        }
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.MyBillsEntityDataFactory;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.getAuthRequestContext();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.PlaceComponentResult(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.BuiltInFictitiousFunctionClassFactory(this, callback));
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.getAuthRequestContext(super.getCustomSelectionActionModeCallback());
    }

    private AppCompatEmojiTextHelper getAuthRequestContext() {
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new AppCompatEmojiTextHelper(this);
        }
        return this.getAuthRequestContext;
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getAuthRequestContext().getAuthRequestContext(z);
    }

    public void setEmojiCompatEnabled(boolean z) {
        getAuthRequestContext().MyBillsEntityDataFactory(z);
    }

    public boolean isEmojiCompatEnabled() {
        return getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.GetContactSyncConfig();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.BuiltInFictitiousFunctionClassFactory;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.GetContactSyncConfig();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.BuiltInFictitiousFunctionClassFactory.lookAheadTest();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(colorStateList);
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(mode);
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
    }
}
