package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatBackgroundHelper {
    private TintInfo BuiltInFictitiousFunctionClassFactory;
    private TintInfo MyBillsEntityDataFactory;
    private TintInfo getAuthRequestContext;
    private final View getErrorConfigVersion;
    private int PlaceComponentResult = -1;
    private final AppCompatDrawableManager KClassImpl$Data$declaredNonStaticMembers$2 = AppCompatDrawableManager.KClassImpl$Data$declaredNonStaticMembers$2();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatBackgroundHelper(View view) {
        this.getErrorConfigVersion = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getAuthRequestContext(AttributeSet attributeSet, int i) {
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(this.getErrorConfigVersion.getContext(), attributeSet, R.styleable.SightCameraView$ICameraFrameListener, i, 0);
        View view = this.getErrorConfigVersion;
        ViewCompat.MyBillsEntityDataFactory(view, view.getContext(), R.styleable.SightCameraView$ICameraFrameListener, attributeSet, authRequestContext.BuiltInFictitiousFunctionClassFactory, i, 0);
        try {
            if (authRequestContext.getAuthRequestContext(R.styleable.SubmitReceiptRequest)) {
                this.PlaceComponentResult = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.SubmitReceiptRequest, -1);
                ColorStateList PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.getErrorConfigVersion.getContext(), this.PlaceComponentResult);
                if (PlaceComponentResult != null) {
                    getAuthRequestContext(PlaceComponentResult);
                }
            }
            if (authRequestContext.getAuthRequestContext(R.styleable.SearchConditionEntityKt)) {
                ViewCompat.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, authRequestContext.PlaceComponentResult(R.styleable.SearchConditionEntityKt));
            }
            if (authRequestContext.getAuthRequestContext(R.styleable.HttpClientAttributesExtractorBuilder)) {
                ViewCompat.getAuthRequestContext(this.getErrorConfigVersion, DrawableUtils.MyBillsEntityDataFactory(authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.HttpClientAttributesExtractorBuilder, -1), null));
            }
        } finally {
            authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.PlaceComponentResult = i;
        AppCompatDrawableManager appCompatDrawableManager = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getAuthRequestContext(appCompatDrawableManager != null ? appCompatDrawableManager.PlaceComponentResult(this.getErrorConfigVersion.getContext(), i) : null);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PlaceComponentResult(Drawable drawable) {
        this.PlaceComponentResult = -1;
        getAuthRequestContext(null);
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void MyBillsEntityDataFactory(ColorStateList colorStateList) {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new TintInfo();
        }
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = colorStateList;
        this.MyBillsEntityDataFactory.PlaceComponentResult = true;
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList MyBillsEntityDataFactory() {
        TintInfo tintInfo = this.MyBillsEntityDataFactory;
        if (tintInfo != null) {
            return tintInfo.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BuiltInFictitiousFunctionClassFactory(PorterDuff.Mode mode) {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new TintInfo();
        }
        this.MyBillsEntityDataFactory.getAuthRequestContext = mode;
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory = true;
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getAuthRequestContext() {
        TintInfo tintInfo = this.MyBillsEntityDataFactory;
        if (tintInfo != null) {
            return tintInfo.getAuthRequestContext;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KClassImpl$Data$declaredNonStaticMembers$2() {
        Drawable background = this.getErrorConfigVersion.getBackground();
        if (background != null) {
            if (BuiltInFictitiousFunctionClassFactory() && KClassImpl$Data$declaredNonStaticMembers$2(background)) {
                return;
            }
            TintInfo tintInfo = this.MyBillsEntityDataFactory;
            if (tintInfo != null) {
                AppCompatDrawableManager.BuiltInFictitiousFunctionClassFactory(background, tintInfo, this.getErrorConfigVersion.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.BuiltInFictitiousFunctionClassFactory;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.BuiltInFictitiousFunctionClassFactory(background, tintInfo2, this.getErrorConfigVersion.getDrawableState());
            }
        }
    }

    void getAuthRequestContext(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                this.BuiltInFictitiousFunctionClassFactory = new TintInfo();
            }
            this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = colorStateList;
            this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        } else {
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.BuiltInFictitiousFunctionClassFactory != null : i == 21;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = new TintInfo();
        }
        TintInfo tintInfo = this.getAuthRequestContext;
        tintInfo.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        tintInfo.PlaceComponentResult = false;
        tintInfo.getAuthRequestContext = null;
        tintInfo.MyBillsEntityDataFactory = false;
        ColorStateList moveToNextValue = ViewCompat.moveToNextValue(this.getErrorConfigVersion);
        if (moveToNextValue != null) {
            tintInfo.PlaceComponentResult = true;
            tintInfo.KClassImpl$Data$declaredNonStaticMembers$2 = moveToNextValue;
        }
        PorterDuff.Mode NetworkUserEntityData$$ExternalSyntheticLambda0 = ViewCompat.NetworkUserEntityData$$ExternalSyntheticLambda0(this.getErrorConfigVersion);
        if (NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            tintInfo.MyBillsEntityDataFactory = true;
            tintInfo.getAuthRequestContext = NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        if (tintInfo.PlaceComponentResult || tintInfo.MyBillsEntityDataFactory) {
            AppCompatDrawableManager.BuiltInFictitiousFunctionClassFactory(drawable, tintInfo, this.getErrorConfigVersion.getDrawableState());
            return true;
        }
        return false;
    }
}
