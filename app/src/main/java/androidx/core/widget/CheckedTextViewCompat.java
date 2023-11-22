package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CheckedTextView;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public final class CheckedTextViewCompat {
    private CheckedTextViewCompat() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.BuiltInFictitiousFunctionClassFactory(checkedTextView, colorStateList);
        } else if (checkedTextView instanceof TintableCheckedTextView) {
            ((TintableCheckedTextView) checkedTextView).setSupportCheckMarkTintList(colorStateList);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.getAuthRequestContext(checkedTextView, mode);
        } else if (checkedTextView instanceof TintableCheckedTextView) {
            ((TintableCheckedTextView) checkedTextView).setSupportCheckMarkTintMode(mode);
        }
    }

    public static Drawable MyBillsEntityDataFactory(CheckedTextView checkedTextView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.getAuthRequestContext(checkedTextView);
        }
        return Api14Impl.KClassImpl$Data$declaredNonStaticMembers$2(checkedTextView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static void BuiltInFictitiousFunctionClassFactory(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void getAuthRequestContext(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    /* loaded from: classes3.dex */
    static class Api16Impl {
        private Api16Impl() {
        }

        static Drawable getAuthRequestContext(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    /* loaded from: classes3.dex */
    static class Api14Impl {
        private static boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private static Field MyBillsEntityDataFactory;

        private Api14Impl() {
        }

        static Drawable KClassImpl$Data$declaredNonStaticMembers$2(CheckedTextView checkedTextView) {
            if (!KClassImpl$Data$declaredNonStaticMembers$2) {
                try {
                    Field declaredField = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                    MyBillsEntityDataFactory = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    InstrumentInjector.log_i("CheckedTextViewCompat", "Failed to retrieve mCheckMarkDrawable field", e);
                }
                KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
            Field field = MyBillsEntityDataFactory;
            if (field != null) {
                try {
                    return (Drawable) field.get(checkedTextView);
                } catch (IllegalAccessException e2) {
                    InstrumentInjector.log_i("CheckedTextViewCompat", "Failed to get check mark drawable via reflection", e2);
                    MyBillsEntityDataFactory = null;
                }
            }
            return null;
        }
    }
}
