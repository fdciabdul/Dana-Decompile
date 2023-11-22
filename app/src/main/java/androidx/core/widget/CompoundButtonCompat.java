package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public final class CompoundButtonCompat {
    private static Field BuiltInFictitiousFunctionClassFactory;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2;

    private CompoundButtonCompat() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.BuiltInFictitiousFunctionClassFactory(compoundButton, colorStateList);
        } else if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public static ColorStateList PlaceComponentResult(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.PlaceComponentResult(compoundButton);
        }
        if (compoundButton instanceof TintableCompoundButton) {
            return ((TintableCompoundButton) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    public static void getAuthRequestContext(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getAuthRequestContext(compoundButton, mode);
        } else if (compoundButton instanceof TintableCompoundButton) {
            ((TintableCompoundButton) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    public static Drawable getAuthRequestContext(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.BuiltInFictitiousFunctionClassFactory(compoundButton);
        }
        if (!KClassImpl$Data$declaredNonStaticMembers$2) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                BuiltInFictitiousFunctionClassFactory = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                InstrumentInjector.log_i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
        Field field = BuiltInFictitiousFunctionClassFactory;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                InstrumentInjector.log_i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                BuiltInFictitiousFunctionClassFactory = null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        static ColorStateList PlaceComponentResult(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        static void getAuthRequestContext(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    /* loaded from: classes3.dex */
    static class Api23Impl {
        private Api23Impl() {
        }

        static Drawable BuiltInFictitiousFunctionClassFactory(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }
}
