package ru.noties.markwon;

import android.text.Spanned;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class SpannableBuilder implements Appendable, CharSequence {
    public final Deque<Span> BuiltInFictitiousFunctionClassFactory;
    public final StringBuilder getAuthRequestContext;

    private static boolean PlaceComponentResult(int i, int i2, int i3) {
        return i3 > i2 && i2 >= 0 && i3 <= i;
    }

    public static void PlaceComponentResult(SpannableBuilder spannableBuilder, Object obj, int i, int i2) {
        if (obj == null || !PlaceComponentResult(spannableBuilder.length(), i, i2)) {
            return;
        }
        if (obj.getClass().isArray()) {
            for (Object obj2 : (Object[]) obj) {
                spannableBuilder.BuiltInFictitiousFunctionClassFactory.push(new Span(obj2, i, i2, 33));
            }
            return;
        }
        spannableBuilder.BuiltInFictitiousFunctionClassFactory.push(new Span(obj, i, i2, 33));
    }

    public SpannableBuilder() {
        this("");
    }

    private SpannableBuilder(CharSequence charSequence) {
        this.BuiltInFictitiousFunctionClassFactory = new ArrayDeque(8);
        this.getAuthRequestContext = new StringBuilder(charSequence);
        KClassImpl$Data$declaredNonStaticMembers$2(0, charSequence);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.getAuthRequestContext.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.getAuthRequestContext.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.getAuthRequestContext.subSequence(i, i2);
    }

    public final char PlaceComponentResult() {
        return this.getAuthRequestContext.charAt(length() - 1);
    }

    public final CharSequence PlaceComponentResult(int i) {
        Span next;
        int length = length();
        SpannableStringBuilderImpl spannableStringBuilderImpl = new SpannableStringBuilderImpl(this.getAuthRequestContext.subSequence(i, length));
        Iterator<Span> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next.BuiltInFictitiousFunctionClassFactory >= i && next.getAuthRequestContext <= length) {
                spannableStringBuilderImpl.setSpan(next.PlaceComponentResult, next.BuiltInFictitiousFunctionClassFactory - i, next.getAuthRequestContext - i, 33);
                it.remove();
            }
        }
        this.getAuthRequestContext.replace(i, length, "");
        return spannableStringBuilderImpl;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.getAuthRequestContext.toString();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, CharSequence charSequence) {
        if (!(charSequence instanceof Spanned)) {
            return;
        }
        Spanned spanned = (Spanned) charSequence;
        boolean z = spanned instanceof SpannedReversed;
        Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
        int length = spans != null ? spans.length : 0;
        if (length <= 0) {
            return;
        }
        if (!z) {
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = spans[i2];
                this.BuiltInFictitiousFunctionClassFactory.push(new Span(obj, spanned.getSpanStart(obj) + i, spanned.getSpanEnd(obj) + i, spanned.getSpanFlags(obj)));
            }
            return;
        }
        while (true) {
            length--;
            if (length < 0) {
                return;
            }
            Object obj2 = spans[length];
            this.BuiltInFictitiousFunctionClassFactory.push(new Span(obj2, spanned.getSpanStart(obj2) + i, spanned.getSpanEnd(obj2) + i, spanned.getSpanFlags(obj2)));
        }
    }

    /* loaded from: classes6.dex */
    public static class Span {
        public int BuiltInFictitiousFunctionClassFactory;
        public final int MyBillsEntityDataFactory;
        public final Object PlaceComponentResult;
        public int getAuthRequestContext;

        Span(Object obj, int i, int i2, int i3) {
            this.PlaceComponentResult = obj;
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.getAuthRequestContext = i2;
            this.MyBillsEntityDataFactory = i3;
        }
    }

    @Override // java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char c) throws IOException {
        this.getAuthRequestContext.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    public /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        KClassImpl$Data$declaredNonStaticMembers$2(length(), charSequence);
        this.getAuthRequestContext.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
        CharSequence subSequence = charSequence.subSequence(i, i2);
        KClassImpl$Data$declaredNonStaticMembers$2(length(), subSequence);
        this.getAuthRequestContext.append(subSequence);
        return this;
    }
}
