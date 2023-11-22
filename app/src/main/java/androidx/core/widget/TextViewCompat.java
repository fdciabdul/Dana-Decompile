package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class TextViewCompat {
    private static boolean BuiltInFictitiousFunctionClassFactory;
    private static Field MyBillsEntityDataFactory;
    private static boolean PlaceComponentResult;
    private static Field getAuthRequestContext;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AutoSizeTextType {
    }

    private TextViewCompat() {
    }

    private static Field PlaceComponentResult(String str) {
        Field field;
        try {
            field = TextView.class.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            field = null;
        }
        try {
            field.setAccessible(true);
        } catch (NoSuchFieldException unused2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not retrieve ");
            sb.append(str);
            sb.append(" field.");
            InstrumentInjector.log_e("TextViewCompat", sb.toString());
            return field;
        }
        return field;
    }

    private static int MyBillsEntityDataFactory(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Could not retrieve value of ");
            sb.append(field.getName());
            sb.append(" field.");
            InstrumentInjector.log_d("TextViewCompat", sb.toString());
            return -1;
        }
    }

    public static void getAuthRequestContext(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api17Impl.MyBillsEntityDataFactory(textView, drawable, drawable2, drawable3, drawable4);
        } else if (Build.VERSION.SDK_INT >= 17) {
            boolean z = Api17Impl.PlaceComponentResult(textView) == 1;
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void MyBillsEntityDataFactory(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api17Impl.PlaceComponentResult(textView, drawable, drawable2, drawable3, drawable4);
        } else if (Build.VERSION.SDK_INT >= 17) {
            boolean z = Api17Impl.PlaceComponentResult(textView) == 1;
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable5, drawable2, drawable, drawable4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void MyBillsEntityDataFactory(TextView textView, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api17Impl.BuiltInFictitiousFunctionClassFactory(textView, i, i2, i3, i4);
        } else if (Build.VERSION.SDK_INT >= 17) {
            boolean z = Api17Impl.PlaceComponentResult(textView) == 1;
            int i5 = z ? i3 : i;
            if (!z) {
                i = i3;
            }
            textView.setCompoundDrawablesWithIntrinsicBounds(i5, i2, i, i4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
        }
    }

    public static int getAuthRequestContext(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.BuiltInFictitiousFunctionClassFactory(textView);
        }
        if (!PlaceComponentResult) {
            getAuthRequestContext = PlaceComponentResult("mMaxMode");
            PlaceComponentResult = true;
        }
        Field field = getAuthRequestContext;
        if (field == null || MyBillsEntityDataFactory(field, textView) != 1) {
            return -1;
        }
        if (!BuiltInFictitiousFunctionClassFactory) {
            MyBillsEntityDataFactory = PlaceComponentResult("mMaximum");
            BuiltInFictitiousFunctionClassFactory = true;
        }
        Field field2 = MyBillsEntityDataFactory;
        if (field2 != null) {
            return MyBillsEntityDataFactory(field2, textView);
        }
        return -1;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static Drawable[] PlaceComponentResult(TextView textView) {
        if (Build.VERSION.SDK_INT >= 18) {
            return Api17Impl.MyBillsEntityDataFactory(textView);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            boolean z = Api17Impl.PlaceComponentResult(textView) == 1;
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            if (z) {
                Drawable drawable = compoundDrawables[2];
                Drawable drawable2 = compoundDrawables[0];
                compoundDrawables[0] = drawable;
                compoundDrawables[2] = drawable2;
            }
            return compoundDrawables;
        }
        return textView.getCompoundDrawables();
    }

    public static ActionMode.Callback BuiltInFictitiousFunctionClassFactory(TextView textView, ActionMode.Callback callback) {
        return (Build.VERSION.SDK_INT < 26 || Build.VERSION.SDK_INT > 27 || (callback instanceof OreoCallback) || callback == null) ? callback : new OreoCallback(callback, textView);
    }

    public static ActionMode.Callback getAuthRequestContext(ActionMode.Callback callback) {
        return (!(callback instanceof OreoCallback) || Build.VERSION.SDK_INT < 26) ? callback : ((OreoCallback) callback).BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class OreoCallback implements ActionMode.Callback {
        private Class<?> BuiltInFictitiousFunctionClassFactory;
        private Method KClassImpl$Data$declaredNonStaticMembers$2;
        private boolean MyBillsEntityDataFactory;
        private final ActionMode.Callback PlaceComponentResult;
        private boolean getAuthRequestContext = false;
        private final TextView lookAheadTest;

        OreoCallback(ActionMode.Callback callback, TextView textView) {
            this.PlaceComponentResult = callback;
            this.lookAheadTest = textView;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.PlaceComponentResult.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            getAuthRequestContext(menu);
            return this.PlaceComponentResult.onPrepareActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.PlaceComponentResult.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.PlaceComponentResult.onDestroyActionMode(actionMode);
        }

        ActionMode.Callback BuiltInFictitiousFunctionClassFactory() {
            return this.PlaceComponentResult;
        }

        private void getAuthRequestContext(Menu menu) {
            Method declaredMethod;
            Context context = this.lookAheadTest.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.getAuthRequestContext) {
                this.getAuthRequestContext = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.BuiltInFictitiousFunctionClassFactory = cls;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.MyBillsEntityDataFactory = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.BuiltInFictitiousFunctionClassFactory = null;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    this.MyBillsEntityDataFactory = false;
                }
            }
            try {
                if (this.MyBillsEntityDataFactory && this.BuiltInFictitiousFunctionClassFactory.isInstance(menu)) {
                    declaredMethod = this.KClassImpl$Data$declaredNonStaticMembers$2;
                } else {
                    declaredMethod = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                }
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> MyBillsEntityDataFactory = MyBillsEntityDataFactory(context, packageManager);
                for (int i = 0; i < MyBillsEntityDataFactory.size(); i++) {
                    ResolveInfo resolveInfo = MyBillsEntityDataFactory.get(i);
                    menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(KClassImpl$Data$declaredNonStaticMembers$2(resolveInfo, this.lookAheadTest)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        private List<ResolveInfo> MyBillsEntityDataFactory(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity) {
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(MyBillsEntityDataFactory(), 0)) {
                    if (KClassImpl$Data$declaredNonStaticMembers$2(resolveInfo, context)) {
                        arrayList.add(resolveInfo);
                    }
                }
                return arrayList;
            }
            return arrayList;
        }

        private boolean KClassImpl$Data$declaredNonStaticMembers$2(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            if (resolveInfo.activityInfo.exported) {
                return resolveInfo.activityInfo.permission == null || context.checkSelfPermission(resolveInfo.activityInfo.permission) == 0;
            }
            return false;
        }

        private Intent KClassImpl$Data$declaredNonStaticMembers$2(ResolveInfo resolveInfo, TextView textView) {
            return MyBillsEntityDataFactory().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !BuiltInFictitiousFunctionClassFactory(textView)).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }

        private boolean BuiltInFictitiousFunctionClassFactory(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        private Intent MyBillsEntityDataFactory() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(TextView textView, int i) {
        int i2;
        Preconditions.PlaceComponentResult(i);
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.getAuthRequestContext(textView, i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || Api16Impl.getAuthRequestContext(textView)) {
            i2 = fontMetricsInt.top;
        } else {
            i2 = fontMetricsInt.ascent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void MyBillsEntityDataFactory(TextView textView, int i) {
        int i2;
        Preconditions.PlaceComponentResult(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT < 16 || Api16Impl.getAuthRequestContext(textView)) {
            i2 = fontMetricsInt.bottom;
        } else {
            i2 = fontMetricsInt.descent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int BuiltInFictitiousFunctionClassFactory(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static void getAuthRequestContext(TextView textView, int i) {
        Preconditions.PlaceComponentResult(i);
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    public static PrecomputedTextCompat.Params MyBillsEntityDataFactory(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new PrecomputedTextCompat.Params(textView.getTextMetricsParams());
        }
        PrecomputedTextCompat.Params.Builder builder = new PrecomputedTextCompat.Params.Builder(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            builder.PlaceComponentResult(Api23Impl.PlaceComponentResult(textView));
            builder.KClassImpl$Data$declaredNonStaticMembers$2(Api23Impl.BuiltInFictitiousFunctionClassFactory(textView));
        }
        if (Build.VERSION.SDK_INT >= 18) {
            builder.KClassImpl$Data$declaredNonStaticMembers$2(scheduleImpl(textView));
        }
        return builder.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static void MyBillsEntityDataFactory(TextView textView, PrecomputedTextCompat.Params params) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api17Impl.MyBillsEntityDataFactory(textView, MyBillsEntityDataFactory(params.MyBillsEntityDataFactory()));
        }
        if (Build.VERSION.SDK_INT < 23) {
            float textScaleX = params.KClassImpl$Data$declaredNonStaticMembers$2().getTextScaleX();
            textView.getPaint().set(params.KClassImpl$Data$declaredNonStaticMembers$2());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
            return;
        }
        textView.getPaint().set(params.KClassImpl$Data$declaredNonStaticMembers$2());
        Api23Impl.PlaceComponentResult(textView, params.getAuthRequestContext());
        textView.setHyphenationFrequency(params.BuiltInFictitiousFunctionClassFactory());
    }

    public static void MyBillsEntityDataFactory(TextView textView, PrecomputedTextCompat precomputedTextCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(precomputedTextCompat.PlaceComponentResult());
        } else if (!MyBillsEntityDataFactory(textView).BuiltInFictitiousFunctionClassFactory(precomputedTextCompat.BuiltInFictitiousFunctionClassFactory())) {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        } else {
            textView.setText(precomputedTextCompat);
        }
    }

    private static TextDirectionHeuristic scheduleImpl(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(Api28Impl.PlaceComponentResult(Api24Impl.MyBillsEntityDataFactory(Api17Impl.getAuthRequestContext(textView)))[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                return TextDirectionHeuristics.RTL;
            }
            return TextDirectionHeuristics.LTR;
        }
        boolean z = Api17Impl.PlaceComponentResult(textView) == 1;
        switch (Api17Impl.MyBillsEntityDataFactory((View) textView)) {
            case 2:
                return TextDirectionHeuristics.ANYRTL_LTR;
            case 3:
                return TextDirectionHeuristics.LTR;
            case 4:
                return TextDirectionHeuristics.RTL;
            case 5:
                return TextDirectionHeuristics.LOCALE;
            case 6:
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
            case 7:
                return TextDirectionHeuristics.FIRSTSTRONG_RTL;
            default:
                if (z) {
                    return TextDirectionHeuristics.FIRSTSTRONG_RTL;
                }
                return TextDirectionHeuristics.FIRSTSTRONG_LTR;
        }
    }

    private static int MyBillsEntityDataFactory(TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(TextView textView, ColorStateList colorStateList) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            Api23Impl.BuiltInFictitiousFunctionClassFactory(textView, colorStateList);
        } else if (textView instanceof TintableCompoundDrawablesView) {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    public static void MyBillsEntityDataFactory(TextView textView, PorterDuff.Mode mode) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            Api23Impl.getAuthRequestContext(textView, mode);
        } else if (textView instanceof TintableCompoundDrawablesView) {
            ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    /* loaded from: classes.dex */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static void MyBillsEntityDataFactory(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        static int PlaceComponentResult(View view) {
            return view.getLayoutDirection();
        }

        static void PlaceComponentResult(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void BuiltInFictitiousFunctionClassFactory(TextView textView, int i, int i2, int i3, int i4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
        }

        static Drawable[] MyBillsEntityDataFactory(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static void MyBillsEntityDataFactory(View view, int i) {
            view.setTextDirection(i);
        }

        static Locale getAuthRequestContext(TextView textView) {
            return textView.getTextLocale();
        }

        static int MyBillsEntityDataFactory(View view) {
            return view.getTextDirection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api16Impl {
        private Api16Impl() {
        }

        static int BuiltInFictitiousFunctionClassFactory(TextView textView) {
            return textView.getMaxLines();
        }

        static boolean getAuthRequestContext(TextView textView) {
            return textView.getIncludeFontPadding();
        }
    }

    /* loaded from: classes.dex */
    static class Api26Impl {
        private Api26Impl() {
        }
    }

    /* loaded from: classes.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        static void getAuthRequestContext(TextView textView, int i) {
            textView.setFirstBaselineToTopHeight(i);
        }

        static String[] PlaceComponentResult(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }
    }

    /* loaded from: classes.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static int PlaceComponentResult(TextView textView) {
            return textView.getBreakStrategy();
        }

        static void PlaceComponentResult(TextView textView, int i) {
            textView.setBreakStrategy(i);
        }

        static int BuiltInFictitiousFunctionClassFactory(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        static void BuiltInFictitiousFunctionClassFactory(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        static void getAuthRequestContext(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }
    }

    /* loaded from: classes.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        static DecimalFormatSymbols MyBillsEntityDataFactory(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }
}
