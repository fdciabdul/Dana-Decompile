package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView, EmojiCompatConfigurationView, TintableCompoundDrawablesView {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {114, -79, -70, 22, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int MyBillsEntityDataFactory = 13;
    private static final int[] PlaceComponentResult = {16843126};
    private final AppCompatEmojiEditTextHelper KClassImpl$Data$declaredNonStaticMembers$2;
    private final AppCompatTextHelper NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final AppCompatBackgroundHelper getAuthRequestContext;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.isLayoutRequested);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.getAuthRequestContext(context), attributeSet, i);
        ThemeUtils.getAuthRequestContext(this, getContext());
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(getContext(), attributeSet, PlaceComponentResult, i, 0);
        if (authRequestContext.getAuthRequestContext(0)) {
            setDropDownBackgroundDrawable(__fsTypeCheck_03006d36da53514240897610a74f16fc(authRequestContext, 0));
        }
        authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.getAuthRequestContext = appCompatBackgroundHelper;
        appCompatBackgroundHelper.getAuthRequestContext(attributeSet, i);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextHelper;
        appCompatTextHelper.KClassImpl$Data$declaredNonStaticMembers$2(attributeSet, i);
        appCompatTextHelper.MyBillsEntityDataFactory();
        AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper = new AppCompatEmojiEditTextHelper(this);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatEmojiEditTextHelper;
        appCompatEmojiEditTextHelper.MyBillsEntityDataFactory(attributeSet, i);
        initEmojiKeyListener(appCompatEmojiEditTextHelper);
    }

    void initEmojiKeyListener(AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper) {
        KeyListener keyListener = getKeyListener();
        if (appCompatEmojiEditTextHelper.PlaceComponentResult(keyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener KClassImpl$Data$declaredNonStaticMembers$2 = appCompatEmojiEditTextHelper.KClassImpl$Data$declaredNonStaticMembers$2(keyListener);
            if (KClassImpl$Data$declaredNonStaticMembers$2 == keyListener) {
                return;
            }
            super.setKeyListener(KClassImpl$Data$declaredNonStaticMembers$2);
            super.setRawInputType(inputType);
            super.setFocusable(isFocusable);
            super.setClickable(isClickable);
            super.setLongClickable(isLongClickable);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        Drawable BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2 = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), i);
        setDropDownBackgroundDrawable(BuiltInFictitiousFunctionClassFactory2);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.getAuthRequestContext;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.getAuthRequestContext;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.PlaceComponentResult(drawable);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.getAuthRequestContext;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.MyBillsEntityDataFactory(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.getAuthRequestContext;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.MyBillsEntityDataFactory();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.getAuthRequestContext;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.BuiltInFictitiousFunctionClassFactory(mode);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.getAuthRequestContext;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getAuthRequestContext();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.getAuthRequestContext;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        AppCompatTextHelper appCompatTextHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.MyBillsEntityDataFactory();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.PlaceComponentResult(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(AppCompatHintHelper.PlaceComponentResult(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(keyListener));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(z);
    }

    public boolean isEmojiCompatEnabled() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.GetContactSyncConfig();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.GetContactSyncConfig();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.lookAheadTest();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory(colorStateList);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.getErrorConfigVersion();
    }

    @Override // androidx.core.widget.TintableCompoundDrawablesView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory(mode);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003d -> B:15:0x0042). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray r11, int r12) {
        /*
            byte[] r0 = androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView.BuiltInFictitiousFunctionClassFactory
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 4
            r4 = 0
            if (r0 != 0) goto L13
            r6 = r2
            r5 = 4
            r7 = 23
            r9 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L42
        L13:
            r5 = 97
            r3 = r2
            r6 = 4
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1b:
            byte r8 = (byte) r5
            int r9 = r7 + 1
            r3[r7] = r8
            if (r9 != r1) goto L3d
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L38
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L38:
            android.graphics.drawable.Drawable r11 = r12.BuiltInFictitiousFunctionClassFactory(r0)
            return r11
        L3d:
            r7 = r2[r6]
            r10 = r6
            r6 = r3
            r3 = r10
        L42:
            int r3 = r3 + 1
            int r5 = r5 + r7
            int r5 = r5 + (-8)
            r7 = r9
            r10 = r6
            r6 = r3
            r3 = r10
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView.__fsTypeCheck_03006d36da53514240897610a74f16fc(androidx.appcompat.widget.TintTypedArray, int):android.graphics.drawable.Drawable");
    }
}
