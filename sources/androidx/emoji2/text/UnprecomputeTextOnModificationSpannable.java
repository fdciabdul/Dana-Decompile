package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.core.text.PrecomputedTextCompat;
import j$.util.stream.IntStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class UnprecomputeTextOnModificationSpannable implements Spannable {
    private boolean BuiltInFictitiousFunctionClassFactory = false;
    Spannable KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnprecomputeTextOnModificationSpannable(Spannable spannable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = spannable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UnprecomputeTextOnModificationSpannable(CharSequence charSequence) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new SpannableString(charSequence);
    }

    private void getAuthRequestContext() {
        Spannable spannable = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!this.BuiltInFictitiousFunctionClassFactory) {
            if ((Build.VERSION.SDK_INT < 28 ? new PrecomputedTextDetector() : new PrecomputedTextDetector_28()).KClassImpl$Data$declaredNonStaticMembers$2(spannable)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = new SpannableString(spannable);
            }
        }
        this.BuiltInFictitiousFunctionClassFactory = true;
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        getAuthRequestContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2.setSpan(obj, i, i2, i3);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        getAuthRequestContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2.removeSpan(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return (T[]) this.KClassImpl$Data$declaredNonStaticMembers$2.getSpans(i, i2, cls);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.nextSpanTransition(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.toString();
    }

    /* loaded from: classes6.dex */
    static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        static IntStream KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
            IntStream KClassImpl$Data$declaredNonStaticMembers$2;
            KClassImpl$Data$declaredNonStaticMembers$2 = IntStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(charSequence.codePoints());
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }

        static IntStream PlaceComponentResult(CharSequence charSequence) {
            IntStream KClassImpl$Data$declaredNonStaticMembers$2;
            KClassImpl$Data$declaredNonStaticMembers$2 = IntStream.VivifiedWrapper.KClassImpl$Data$declaredNonStaticMembers$2(charSequence.chars());
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class PrecomputedTextDetector {
        PrecomputedTextDetector() {
        }

        boolean KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        final boolean KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof PrecomputedTextCompat);
        }
    }

    @Override // java.lang.CharSequence
    public /* synthetic */ java.util.stream.IntStream chars() {
        return IntStream.Wrapper.BuiltInFictitiousFunctionClassFactory(CharSequenceHelper_API24.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    @Override // java.lang.CharSequence
    public /* synthetic */ java.util.stream.IntStream codePoints() {
        return IntStream.Wrapper.BuiltInFictitiousFunctionClassFactory(CharSequenceHelper_API24.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
