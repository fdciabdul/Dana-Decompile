package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class LayoutInflaterCompat {
    private static boolean MyBillsEntityDataFactory;
    private static Field getAuthRequestContext;

    /* loaded from: classes.dex */
    static class Factory2Wrapper implements LayoutInflater.Factory2 {
        final LayoutInflaterFactory BuiltInFictitiousFunctionClassFactory;

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append("{");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append("}");
            return sb.toString();
        }
    }

    private static void getAuthRequestContext(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!MyBillsEntityDataFactory) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                getAuthRequestContext = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                sb.append(LayoutInflater.class.getName());
                sb.append("; inflation may have unexpected results.");
                InstrumentInjector.log_e("LayoutInflaterCompatHC", sb.toString(), e);
            }
            MyBillsEntityDataFactory = true;
        }
        Field field = getAuthRequestContext;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                sb2.append(layoutInflater);
                sb2.append("; inflation may have unexpected results.");
                InstrumentInjector.log_e("LayoutInflaterCompatHC", sb2.toString(), e2);
            }
        }
    }

    private LayoutInflaterCompat() {
    }

    public static void BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                getAuthRequestContext(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                getAuthRequestContext(layoutInflater, factory2);
            }
        }
    }
}
