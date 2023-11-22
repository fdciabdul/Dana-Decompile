package androidx.emoji.widget;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.Preconditions;
import androidx.emoji.text.EmojiSpan;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public final class SpannableBuilder extends SpannableStringBuilder {
    private final List<WatcherWrapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Class<?> PlaceComponentResult;

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Editable append(char c) {
        return append(c);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Editable append(CharSequence charSequence) {
        return append(charSequence);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Editable append(CharSequence charSequence, int i, int i2) {
        return append(charSequence, i, i2);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(char c) throws IOException {
        return append(c);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        return append(charSequence);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
        return append(charSequence, i, i2);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable delete(int i, int i2) {
        return delete(i, i2);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable insert(int i, CharSequence charSequence) {
        return insert(i, charSequence);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable insert(int i, CharSequence charSequence, int i2, int i3) {
        return insert(i, charSequence, i2, i3);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i, int i2, CharSequence charSequence) {
        return replace(i, i2, charSequence);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        return replace(i, i2, charSequence, i3, i4);
    }

    private SpannableBuilder(Class<?> cls, CharSequence charSequence) {
        super(charSequence);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(cls, "watcherClass cannot be null");
        this.PlaceComponentResult = cls;
    }

    private SpannableBuilder(Class<?> cls, CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(cls, "watcherClass cannot be null");
        this.PlaceComponentResult = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpannableBuilder MyBillsEntityDataFactory(Class<?> cls, CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    private boolean BuiltInFictitiousFunctionClassFactory(Object obj) {
        return obj != null && PlaceComponentResult(obj.getClass());
    }

    private boolean PlaceComponentResult(Class<?> cls) {
        return this.PlaceComponentResult == cls;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new SpannableBuilder(this.PlaceComponentResult, this, i, i2);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i, int i2, int i3) {
        if (BuiltInFictitiousFunctionClassFactory(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.KClassImpl$Data$declaredNonStaticMembers$2.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, i, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (PlaceComponentResult((Class<?>) cls)) {
            WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i, i2, WatcherWrapper.class);
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, watcherWrapperArr.length));
            for (int i3 = 0; i3 < watcherWrapperArr.length; i3++) {
                tArr[i3] = watcherWrapperArr[i3].getAuthRequestContext;
            }
            return tArr;
        }
        return (T[]) super.getSpans(i, i2, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        WatcherWrapper watcherWrapper;
        if (BuiltInFictitiousFunctionClassFactory(obj)) {
            watcherWrapper = PlaceComponentResult(obj);
            if (watcherWrapper != null) {
                obj = watcherWrapper;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.remove(watcherWrapper);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        WatcherWrapper PlaceComponentResult;
        if (BuiltInFictitiousFunctionClassFactory(obj) && (PlaceComponentResult = PlaceComponentResult(obj)) != null) {
            obj = PlaceComponentResult;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        WatcherWrapper PlaceComponentResult;
        if (BuiltInFictitiousFunctionClassFactory(obj) && (PlaceComponentResult = PlaceComponentResult(obj)) != null) {
            obj = PlaceComponentResult;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        WatcherWrapper PlaceComponentResult;
        if (BuiltInFictitiousFunctionClassFactory(obj) && (PlaceComponentResult = PlaceComponentResult(obj)) != null) {
            obj = PlaceComponentResult;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i, int i2, Class cls) {
        if (PlaceComponentResult((Class<?>) cls)) {
            cls = WatcherWrapper.class;
        }
        return super.nextSpanTransition(i, i2, cls);
    }

    private WatcherWrapper PlaceComponentResult(Object obj) {
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
            WatcherWrapper watcherWrapper = this.KClassImpl$Data$declaredNonStaticMembers$2.get(i);
            if (watcherWrapper.getAuthRequestContext == obj) {
                return watcherWrapper;
            }
        }
        return null;
    }

    public final void MyBillsEntityDataFactory() {
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).PlaceComponentResult.incrementAndGet();
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).PlaceComponentResult.decrementAndGet();
        }
    }

    public final void PlaceComponentResult() {
        for (int i = 0; i < this.KClassImpl$Data$declaredNonStaticMembers$2.size(); i++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.get(i).onTextChanged(this, 0, length(), length());
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i2, CharSequence charSequence) {
        MyBillsEntityDataFactory();
        super.replace(i, i2, charSequence);
        KClassImpl$Data$declaredNonStaticMembers$2();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        MyBillsEntityDataFactory();
        super.replace(i, i2, charSequence, i3, i4);
        KClassImpl$Data$declaredNonStaticMembers$2();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i, CharSequence charSequence) {
        super.insert(i, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder insert(int i, CharSequence charSequence, int i2, int i3) {
        super.insert(i, charSequence, i2, i3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder delete(int i, int i2) {
        super.delete(i, i2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char c) {
        super.append(c);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(CharSequence charSequence, int i, int i2) {
        super.append(charSequence, i, i2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i) {
        super.append(charSequence, obj, i);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class WatcherWrapper implements TextWatcher, SpanWatcher {
        final AtomicInteger PlaceComponentResult = new AtomicInteger(0);
        final Object getAuthRequestContext;

        WatcherWrapper(Object obj) {
            this.getAuthRequestContext = obj;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.getAuthRequestContext).beforeTextChanged(charSequence, i, i2, i3);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.getAuthRequestContext).onTextChanged(charSequence, i, i2, i3);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.getAuthRequestContext).afterTextChanged(editable);
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if (this.PlaceComponentResult.get() <= 0 || !BuiltInFictitiousFunctionClassFactory(obj)) {
                ((SpanWatcher) this.getAuthRequestContext).onSpanAdded(spannable, obj, i, i2);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if (this.PlaceComponentResult.get() <= 0 || !BuiltInFictitiousFunctionClassFactory(obj)) {
                ((SpanWatcher) this.getAuthRequestContext).onSpanRemoved(spannable, obj, i, i2);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            if (this.PlaceComponentResult.get() <= 0 || !BuiltInFictitiousFunctionClassFactory(obj)) {
                ((SpanWatcher) this.getAuthRequestContext).onSpanChanged(spannable, obj, i, i2, i3, i4);
            }
        }

        private static boolean BuiltInFictitiousFunctionClassFactory(Object obj) {
            return obj instanceof EmojiSpan;
        }
    }
}
