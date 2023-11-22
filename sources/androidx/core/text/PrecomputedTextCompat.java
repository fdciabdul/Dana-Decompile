package androidx.core.text;

import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.os.TraceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public class PrecomputedTextCompat implements Spannable {
    private static final Object KClassImpl$Data$declaredNonStaticMembers$2 = new Object();
    private final PrecomputedText BuiltInFictitiousFunctionClassFactory;
    private final int[] MyBillsEntityDataFactory;
    private final Spannable PlaceComponentResult;
    private final Params getAuthRequestContext;

    /* loaded from: classes.dex */
    public static final class Params {
        private final TextPaint BuiltInFictitiousFunctionClassFactory;
        final PrecomputedText.Params KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;
        private final int PlaceComponentResult;
        private final TextDirectionHeuristic getAuthRequestContext;

        /* loaded from: classes.dex */
        public static class Builder {
            private int KClassImpl$Data$declaredNonStaticMembers$2;
            private int MyBillsEntityDataFactory;
            private TextDirectionHeuristic PlaceComponentResult;
            private final TextPaint getAuthRequestContext;

            public Builder(TextPaint textPaint) {
                this.getAuthRequestContext = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                    this.MyBillsEntityDataFactory = 1;
                } else {
                    this.MyBillsEntityDataFactory = 0;
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
                }
                if (Build.VERSION.SDK_INT >= 18) {
                    this.PlaceComponentResult = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                } else {
                    this.PlaceComponentResult = null;
                }
            }

            public Builder PlaceComponentResult(int i) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                return this;
            }

            public Builder KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                this.MyBillsEntityDataFactory = i;
                return this;
            }

            public Builder KClassImpl$Data$declaredNonStaticMembers$2(TextDirectionHeuristic textDirectionHeuristic) {
                this.PlaceComponentResult = textDirectionHeuristic;
                return this;
            }

            public Params KClassImpl$Data$declaredNonStaticMembers$2() {
                return new Params(this.getAuthRequestContext, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
            }
        }

        Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
            this.BuiltInFictitiousFunctionClassFactory = textPaint;
            this.getAuthRequestContext = textDirectionHeuristic;
            this.PlaceComponentResult = i;
            this.MyBillsEntityDataFactory = i2;
        }

        public Params(PrecomputedText.Params params) {
            this.BuiltInFictitiousFunctionClassFactory = params.getTextPaint();
            this.getAuthRequestContext = params.getTextDirection();
            this.PlaceComponentResult = params.getBreakStrategy();
            this.MyBillsEntityDataFactory = params.getHyphenationFrequency();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public final TextPaint KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public final TextDirectionHeuristic MyBillsEntityDataFactory() {
            return this.getAuthRequestContext;
        }

        public final int getAuthRequestContext() {
            return this.PlaceComponentResult;
        }

        public final int BuiltInFictitiousFunctionClassFactory() {
            return this.MyBillsEntityDataFactory;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory(Params params) {
            if ((Build.VERSION.SDK_INT < 23 || (this.PlaceComponentResult == params.getAuthRequestContext() && this.MyBillsEntityDataFactory == params.BuiltInFictitiousFunctionClassFactory())) && this.BuiltInFictitiousFunctionClassFactory.getTextSize() == params.KClassImpl$Data$declaredNonStaticMembers$2().getTextSize() && this.BuiltInFictitiousFunctionClassFactory.getTextScaleX() == params.KClassImpl$Data$declaredNonStaticMembers$2().getTextScaleX() && this.BuiltInFictitiousFunctionClassFactory.getTextSkewX() == params.KClassImpl$Data$declaredNonStaticMembers$2().getTextSkewX()) {
                if ((Build.VERSION.SDK_INT < 21 || (this.BuiltInFictitiousFunctionClassFactory.getLetterSpacing() == params.KClassImpl$Data$declaredNonStaticMembers$2().getLetterSpacing() && TextUtils.equals(this.BuiltInFictitiousFunctionClassFactory.getFontFeatureSettings(), params.KClassImpl$Data$declaredNonStaticMembers$2().getFontFeatureSettings()))) && this.BuiltInFictitiousFunctionClassFactory.getFlags() == params.KClassImpl$Data$declaredNonStaticMembers$2().getFlags()) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        if (!this.BuiltInFictitiousFunctionClassFactory.getTextLocales().equals(params.KClassImpl$Data$declaredNonStaticMembers$2().getTextLocales())) {
                            return false;
                        }
                    } else if (Build.VERSION.SDK_INT >= 17 && !this.BuiltInFictitiousFunctionClassFactory.getTextLocale().equals(params.KClassImpl$Data$declaredNonStaticMembers$2().getTextLocale())) {
                        return false;
                    }
                    return this.BuiltInFictitiousFunctionClassFactory.getTypeface() == null ? params.KClassImpl$Data$declaredNonStaticMembers$2().getTypeface() == null : this.BuiltInFictitiousFunctionClassFactory.getTypeface().equals(params.KClassImpl$Data$declaredNonStaticMembers$2().getTypeface());
                }
                return false;
            }
            return false;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Params) {
                Params params = (Params) obj;
                if (BuiltInFictitiousFunctionClassFactory(params)) {
                    return Build.VERSION.SDK_INT < 18 || this.getAuthRequestContext == params.MyBillsEntityDataFactory();
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return ObjectsCompat.PlaceComponentResult(Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextSize()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextScaleX()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextSkewX()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getLetterSpacing()), Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.getFlags()), this.BuiltInFictitiousFunctionClassFactory.getTextLocales(), this.BuiltInFictitiousFunctionClassFactory.getTypeface(), Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.isElegantTextHeight()), this.getAuthRequestContext, Integer.valueOf(this.PlaceComponentResult), Integer.valueOf(this.MyBillsEntityDataFactory));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                return ObjectsCompat.PlaceComponentResult(Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextSize()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextScaleX()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextSkewX()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getLetterSpacing()), Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.getFlags()), this.BuiltInFictitiousFunctionClassFactory.getTextLocale(), this.BuiltInFictitiousFunctionClassFactory.getTypeface(), Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.isElegantTextHeight()), this.getAuthRequestContext, Integer.valueOf(this.PlaceComponentResult), Integer.valueOf(this.MyBillsEntityDataFactory));
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return ObjectsCompat.PlaceComponentResult(Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextSize()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextScaleX()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextSkewX()), Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.getFlags()), this.BuiltInFictitiousFunctionClassFactory.getTextLocale(), this.BuiltInFictitiousFunctionClassFactory.getTypeface(), this.getAuthRequestContext, Integer.valueOf(this.PlaceComponentResult), Integer.valueOf(this.MyBillsEntityDataFactory));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                return ObjectsCompat.PlaceComponentResult(Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextSize()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextScaleX()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextSkewX()), Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.getFlags()), this.BuiltInFictitiousFunctionClassFactory.getTextLocale(), this.BuiltInFictitiousFunctionClassFactory.getTypeface(), this.getAuthRequestContext, Integer.valueOf(this.PlaceComponentResult), Integer.valueOf(this.MyBillsEntityDataFactory));
            }
            return ObjectsCompat.PlaceComponentResult(Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextSize()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextScaleX()), Float.valueOf(this.BuiltInFictitiousFunctionClassFactory.getTextSkewX()), Integer.valueOf(this.BuiltInFictitiousFunctionClassFactory.getFlags()), this.BuiltInFictitiousFunctionClassFactory.getTypeface(), this.getAuthRequestContext, Integer.valueOf(this.PlaceComponentResult), Integer.valueOf(this.MyBillsEntityDataFactory));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("textSize=");
            sb2.append(this.BuiltInFictitiousFunctionClassFactory.getTextSize());
            sb.append(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(", textScaleX=");
            sb3.append(this.BuiltInFictitiousFunctionClassFactory.getTextScaleX());
            sb.append(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(", textSkewX=");
            sb4.append(this.BuiltInFictitiousFunctionClassFactory.getTextSkewX());
            sb.append(sb4.toString());
            if (Build.VERSION.SDK_INT >= 21) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(", letterSpacing=");
                sb5.append(this.BuiltInFictitiousFunctionClassFactory.getLetterSpacing());
                sb.append(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(", elegantTextHeight=");
                sb6.append(this.BuiltInFictitiousFunctionClassFactory.isElegantTextHeight());
                sb.append(sb6.toString());
            }
            if (Build.VERSION.SDK_INT >= 24) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(", textLocale=");
                sb7.append(this.BuiltInFictitiousFunctionClassFactory.getTextLocales());
                sb.append(sb7.toString());
            } else if (Build.VERSION.SDK_INT >= 17) {
                StringBuilder sb8 = new StringBuilder();
                sb8.append(", textLocale=");
                sb8.append(this.BuiltInFictitiousFunctionClassFactory.getTextLocale());
                sb.append(sb8.toString());
            }
            StringBuilder sb9 = new StringBuilder();
            sb9.append(", typeface=");
            sb9.append(this.BuiltInFictitiousFunctionClassFactory.getTypeface());
            sb.append(sb9.toString());
            if (Build.VERSION.SDK_INT >= 26) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(", variationSettings=");
                sb10.append(this.BuiltInFictitiousFunctionClassFactory.getFontVariationSettings());
                sb.append(sb10.toString());
            }
            StringBuilder sb11 = new StringBuilder();
            sb11.append(", textDir=");
            sb11.append(this.getAuthRequestContext);
            sb.append(sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            sb12.append(", breakStrategy=");
            sb12.append(this.PlaceComponentResult);
            sb.append(sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(", hyphenationFrequency=");
            sb13.append(this.MyBillsEntityDataFactory);
            sb.append(sb13.toString());
            sb.append("}");
            return sb.toString();
        }
    }

    public static PrecomputedTextCompat MyBillsEntityDataFactory(CharSequence charSequence, Params params) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(charSequence);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(params);
        try {
            TraceCompat.BuiltInFictitiousFunctionClassFactory("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && params.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, params.KClassImpl$Data$declaredNonStaticMembers$2), params);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                int indexOf = TextUtils.indexOf(charSequence, '\n', i, length);
                i = indexOf < 0 ? length : indexOf + 1;
                arrayList.add(Integer.valueOf(i));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.KClassImpl$Data$declaredNonStaticMembers$2(), Integer.MAX_VALUE).setBreakStrategy(params.getAuthRequestContext()).setHyphenationFrequency(params.BuiltInFictitiousFunctionClassFactory()).setTextDirection(params.MyBillsEntityDataFactory()).build();
            } else if (Build.VERSION.SDK_INT >= 21) {
                new StaticLayout(charSequence, params.KClassImpl$Data$declaredNonStaticMembers$2(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            }
            return new PrecomputedTextCompat(charSequence, params, iArr);
        } finally {
            TraceCompat.BuiltInFictitiousFunctionClassFactory();
        }
    }

    private PrecomputedTextCompat(CharSequence charSequence, Params params, int[] iArr) {
        this.PlaceComponentResult = new SpannableString(charSequence);
        this.getAuthRequestContext = params;
        this.MyBillsEntityDataFactory = iArr;
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    private PrecomputedTextCompat(PrecomputedText precomputedText, Params params) {
        this.PlaceComponentResult = precomputedText;
        this.getAuthRequestContext = params;
        this.MyBillsEntityDataFactory = null;
        this.BuiltInFictitiousFunctionClassFactory = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    public PrecomputedText PlaceComponentResult() {
        Spannable spannable = this.PlaceComponentResult;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public Params BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }

    /* loaded from: classes.dex */
    static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        /* loaded from: classes6.dex */
        static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {
            private Params MyBillsEntityDataFactory;
            private CharSequence PlaceComponentResult;

            @Override // java.util.concurrent.Callable
            /* renamed from: getAuthRequestContext  reason: merged with bridge method [inline-methods] */
            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.MyBillsEntityDataFactory(this.PlaceComponentResult, this.MyBillsEntityDataFactory);
            }
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.BuiltInFictitiousFunctionClassFactory.setSpan(obj, i, i2, i3);
        } else {
            this.PlaceComponentResult.setSpan(obj, i, i2, i3);
        }
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.BuiltInFictitiousFunctionClassFactory.removeSpan(obj);
        } else {
            this.PlaceComponentResult.removeSpan(obj);
        }
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return (T[]) this.BuiltInFictitiousFunctionClassFactory.getSpans(i, i2, cls);
        }
        return (T[]) this.PlaceComponentResult.getSpans(i, i2, cls);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.PlaceComponentResult.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.PlaceComponentResult.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.PlaceComponentResult.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.PlaceComponentResult.nextSpanTransition(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.PlaceComponentResult.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.PlaceComponentResult.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.PlaceComponentResult.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.PlaceComponentResult.toString();
    }
}
