package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class SpannableBuilder extends SpannableStringBuilder {
    private final Class<?> BuiltInFictitiousFunctionClassFactory;
    private final List<WatcherWrapper> getAuthRequestContext;

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
        this.getAuthRequestContext = new ArrayList();
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(cls, "watcherClass cannot be null");
        this.BuiltInFictitiousFunctionClassFactory = cls;
    }

    private SpannableBuilder(Class<?> cls, CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
        this.getAuthRequestContext = new ArrayList();
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(cls, "watcherClass cannot be null");
        this.BuiltInFictitiousFunctionClassFactory = cls;
    }

    public static SpannableBuilder getAuthRequestContext(Class<?> cls, CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    private boolean MyBillsEntityDataFactory(Object obj) {
        return obj != null && KClassImpl$Data$declaredNonStaticMembers$2(obj.getClass());
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(Class<?> cls) {
        return this.BuiltInFictitiousFunctionClassFactory == cls;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new SpannableBuilder(this.BuiltInFictitiousFunctionClassFactory, this, i, i2);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object obj, int i, int i2, int i3) {
        if (MyBillsEntityDataFactory(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.getAuthRequestContext.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, i, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(cls)) {
            WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i, i2, WatcherWrapper.class);
            T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, watcherWrapperArr.length));
            for (int i3 = 0; i3 < watcherWrapperArr.length; i3++) {
                tArr[i3] = watcherWrapperArr[i3].PlaceComponentResult;
            }
            return tArr;
        }
        return (T[]) super.getSpans(i, i2, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object obj) {
        WatcherWrapper watcherWrapper;
        if (MyBillsEntityDataFactory(obj)) {
            watcherWrapper = BuiltInFictitiousFunctionClassFactory(obj);
            if (watcherWrapper != null) {
                obj = watcherWrapper;
            }
        } else {
            watcherWrapper = null;
        }
        super.removeSpan(obj);
        if (watcherWrapper != null) {
            this.getAuthRequestContext.remove(watcherWrapper);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object obj) {
        WatcherWrapper BuiltInFictitiousFunctionClassFactory;
        if (MyBillsEntityDataFactory(obj) && (BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(obj)) != null) {
            obj = BuiltInFictitiousFunctionClassFactory;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object obj) {
        WatcherWrapper BuiltInFictitiousFunctionClassFactory;
        if (MyBillsEntityDataFactory(obj) && (BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(obj)) != null) {
            obj = BuiltInFictitiousFunctionClassFactory;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object obj) {
        WatcherWrapper BuiltInFictitiousFunctionClassFactory;
        if (MyBillsEntityDataFactory(obj) && (BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(obj)) != null) {
            obj = BuiltInFictitiousFunctionClassFactory;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int i, int i2, Class cls) {
        if (cls == null || KClassImpl$Data$declaredNonStaticMembers$2(cls)) {
            cls = WatcherWrapper.class;
        }
        return super.nextSpanTransition(i, i2, cls);
    }

    private WatcherWrapper BuiltInFictitiousFunctionClassFactory(Object obj) {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            WatcherWrapper watcherWrapper = this.getAuthRequestContext.get(i);
            if (watcherWrapper.PlaceComponentResult == obj) {
                return watcherWrapper;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).getAuthRequestContext.incrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void MyBillsEntityDataFactory() {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).getAuthRequestContext.decrementAndGet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult() {
        for (int i = 0; i < this.getAuthRequestContext.size(); i++) {
            this.getAuthRequestContext.get(i).onTextChanged(this, 0, length(), length());
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i2, CharSequence charSequence) {
        KClassImpl$Data$declaredNonStaticMembers$2();
        super.replace(i, i2, charSequence);
        MyBillsEntityDataFactory();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        KClassImpl$Data$declaredNonStaticMembers$2();
        super.replace(i, i2, charSequence, i3, i4);
        MyBillsEntityDataFactory();
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
    /* loaded from: classes3.dex */
    public static class WatcherWrapper implements TextWatcher, SpanWatcher {
        final Object PlaceComponentResult;
        final AtomicInteger getAuthRequestContext = new AtomicInteger(0);

        WatcherWrapper(Object obj) {
            this.PlaceComponentResult = obj;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.PlaceComponentResult).beforeTextChanged(charSequence, i, i2, i3);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ((TextWatcher) this.PlaceComponentResult).onTextChanged(charSequence, i, i2, i3);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.PlaceComponentResult).afterTextChanged(editable);
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
            if (this.getAuthRequestContext.get() <= 0 || !PlaceComponentResult(obj)) {
                ((SpanWatcher) this.PlaceComponentResult).onSpanAdded(spannable, obj, i, i2);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
            if (this.getAuthRequestContext.get() <= 0 || !PlaceComponentResult(obj)) {
                ((SpanWatcher) this.PlaceComponentResult).onSpanRemoved(spannable, obj, i, i2);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int i7;
            if (this.getAuthRequestContext.get() <= 0 || !PlaceComponentResult(obj)) {
                if (Build.VERSION.SDK_INT < 28) {
                    int i8 = i;
                    i5 = i3;
                    if (i8 > i2) {
                        i8 = 0;
                    }
                    i6 = i8;
                    if (i5 > i4) {
                        i7 = 0;
                        ((SpanWatcher) this.PlaceComponentResult).onSpanChanged(spannable, obj, i6, i2, i7, i4);
                    }
                } else {
                    i5 = i3;
                    i6 = i;
                }
                i7 = i5;
                ((SpanWatcher) this.PlaceComponentResult).onSpanChanged(spannable, obj, i6, i2, i7, i4);
            }
        }

        private static boolean PlaceComponentResult(Object obj) {
            return obj instanceof EmojiSpan;
        }
    }
}
