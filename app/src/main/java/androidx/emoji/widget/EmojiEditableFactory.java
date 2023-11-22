package androidx.emoji.widget;

import android.text.Editable;

/* loaded from: classes6.dex */
final class EmojiEditableFactory extends Editable.Factory {
    private static final Object BuiltInFictitiousFunctionClassFactory = new Object();
    private static Class<?> MyBillsEntityDataFactory;
    private static volatile Editable.Factory getAuthRequestContext;

    private EmojiEditableFactory() {
        try {
            MyBillsEntityDataFactory = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, getClass().getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory MyBillsEntityDataFactory() {
        if (getAuthRequestContext == null) {
            synchronized (BuiltInFictitiousFunctionClassFactory) {
                if (getAuthRequestContext == null) {
                    getAuthRequestContext = new EmojiEditableFactory();
                }
            }
        }
        return getAuthRequestContext;
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class<?> cls = MyBillsEntityDataFactory;
        if (cls != null) {
            return SpannableBuilder.MyBillsEntityDataFactory(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
