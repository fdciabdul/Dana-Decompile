package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

/* loaded from: classes3.dex */
final class EmojiEditableFactory extends Editable.Factory {
    private static Class<?> BuiltInFictitiousFunctionClassFactory;
    private static volatile Editable.Factory KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Object getAuthRequestContext = new Object();

    private EmojiEditableFactory() {
        try {
            BuiltInFictitiousFunctionClassFactory = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, getClass().getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory PlaceComponentResult() {
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            synchronized (getAuthRequestContext) {
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = new EmojiEditableFactory();
                }
            }
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class<?> cls = BuiltInFictitiousFunctionClassFactory;
        if (cls != null) {
            return SpannableBuilder.getAuthRequestContext(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
