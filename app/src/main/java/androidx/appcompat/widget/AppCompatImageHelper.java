package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

/* loaded from: classes.dex */
public class AppCompatImageHelper {
    private TintInfo BuiltInFictitiousFunctionClassFactory;
    private TintInfo KClassImpl$Data$declaredNonStaticMembers$2;
    private TintInfo MyBillsEntityDataFactory;
    private int PlaceComponentResult = 0;
    private final ImageView getAuthRequestContext;

    public AppCompatImageHelper(ImageView imageView) {
        this.getAuthRequestContext = imageView;
    }

    public void getAuthRequestContext(AttributeSet attributeSet, int i) {
        TintTypedArray authRequestContext = TintTypedArray.getAuthRequestContext(this.getAuthRequestContext.getContext(), attributeSet, R.styleable.AppCompatEmojiTextHelper, i, 0);
        ImageView imageView = this.getAuthRequestContext;
        ViewCompat.MyBillsEntityDataFactory(imageView, imageView.getContext(), R.styleable.AppCompatEmojiTextHelper, attributeSet, authRequestContext.BuiltInFictitiousFunctionClassFactory, i, 0);
        try {
            Drawable drawable = this.getAuthRequestContext.getDrawable();
            if (drawable == null) {
                int resourceId = authRequestContext.BuiltInFictitiousFunctionClassFactory.getResourceId(R.styleable.F, -1);
                if (resourceId != -1 && (drawable = AppCompatResources.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.getContext(), resourceId)) != null) {
                    this.getAuthRequestContext.setImageDrawable(drawable);
                }
            }
            if (drawable != null) {
                DrawableUtils.KClassImpl$Data$declaredNonStaticMembers$2(drawable);
            }
            if (authRequestContext.getAuthRequestContext(R.styleable.getNameOrBuilderList)) {
                ImageViewCompat.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, authRequestContext.PlaceComponentResult(R.styleable.getNameOrBuilderList));
            }
            if (authRequestContext.getAuthRequestContext(R.styleable.L)) {
                ImageViewCompat.getAuthRequestContext(this.getAuthRequestContext, DrawableUtils.MyBillsEntityDataFactory(authRequestContext.BuiltInFictitiousFunctionClassFactory.getInt(R.styleable.L, -1), null));
            }
        } finally {
            authRequestContext.BuiltInFictitiousFunctionClassFactory.recycle();
        }
    }

    public void getAuthRequestContext(int i) {
        if (i != 0) {
            Drawable KClassImpl$Data$declaredNonStaticMembers$2 = AppCompatResources.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.getContext(), i);
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                DrawableUtils.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2);
            }
            this.getAuthRequestContext.setImageDrawable(KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            this.getAuthRequestContext.setImageDrawable(null);
        }
        PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getAuthRequestContext() {
        return Build.VERSION.SDK_INT < 21 || !(this.getAuthRequestContext.getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BuiltInFictitiousFunctionClassFactory(ColorStateList colorStateList) {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new TintInfo();
        }
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = colorStateList;
        this.MyBillsEntityDataFactory.PlaceComponentResult = true;
        PlaceComponentResult();
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
    public void MyBillsEntityDataFactory(PorterDuff.Mode mode) {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new TintInfo();
        }
        this.MyBillsEntityDataFactory.getAuthRequestContext = mode;
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory = true;
        PlaceComponentResult();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode KClassImpl$Data$declaredNonStaticMembers$2() {
        TintInfo tintInfo = this.MyBillsEntityDataFactory;
        if (tintInfo != null) {
            return tintInfo.getAuthRequestContext;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PlaceComponentResult() {
        Drawable drawable = this.getAuthRequestContext.getDrawable();
        if (drawable != null) {
            DrawableUtils.KClassImpl$Data$declaredNonStaticMembers$2(drawable);
        }
        if (drawable != null) {
            if (moveToNextValue() && getAuthRequestContext(drawable)) {
                return;
            }
            TintInfo tintInfo = this.MyBillsEntityDataFactory;
            if (tintInfo != null) {
                AppCompatDrawableManager.BuiltInFictitiousFunctionClassFactory(drawable, tintInfo, this.getAuthRequestContext.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.BuiltInFictitiousFunctionClassFactory(drawable, tintInfo2, this.getAuthRequestContext.getDrawableState());
            }
        }
    }

    private boolean moveToNextValue() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.KClassImpl$Data$declaredNonStaticMembers$2 != null : i == 21;
    }

    private boolean getAuthRequestContext(Drawable drawable) {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new TintInfo();
        }
        TintInfo tintInfo = this.BuiltInFictitiousFunctionClassFactory;
        tintInfo.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        tintInfo.PlaceComponentResult = false;
        tintInfo.getAuthRequestContext = null;
        tintInfo.MyBillsEntityDataFactory = false;
        ColorStateList PlaceComponentResult = ImageViewCompat.PlaceComponentResult(this.getAuthRequestContext);
        if (PlaceComponentResult != null) {
            tintInfo.PlaceComponentResult = true;
            tintInfo.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
        }
        PorterDuff.Mode MyBillsEntityDataFactory = ImageViewCompat.MyBillsEntityDataFactory(this.getAuthRequestContext);
        if (MyBillsEntityDataFactory != null) {
            tintInfo.MyBillsEntityDataFactory = true;
            tintInfo.getAuthRequestContext = MyBillsEntityDataFactory;
        }
        if (tintInfo.PlaceComponentResult || tintInfo.MyBillsEntityDataFactory) {
            AppCompatDrawableManager.BuiltInFictitiousFunctionClassFactory(drawable, tintInfo, this.getAuthRequestContext.getDrawableState());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(Drawable drawable) {
        this.PlaceComponentResult = drawable.getLevel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void BuiltInFictitiousFunctionClassFactory() {
        if (this.getAuthRequestContext.getDrawable() != null) {
            this.getAuthRequestContext.getDrawable().setLevel(this.PlaceComponentResult);
        }
    }
}
