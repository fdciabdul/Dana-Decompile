package androidx.core.app;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes3.dex */
public class Person {
    CharSequence BuiltInFictitiousFunctionClassFactory;
    boolean KClassImpl$Data$declaredNonStaticMembers$2;
    String MyBillsEntityDataFactory;
    IconCompat PlaceComponentResult;
    boolean getAuthRequestContext;
    String scheduleImpl;

    /* loaded from: classes6.dex */
    public static class Builder {
    }

    public final Bundle PlaceComponentResult() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.BuiltInFictitiousFunctionClassFactory);
        IconCompat iconCompat = this.PlaceComponentResult;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.scheduleImpl() : null);
        bundle.putString("uri", this.scheduleImpl);
        bundle.putString("key", this.MyBillsEntityDataFactory);
        bundle.putBoolean("isBot", this.getAuthRequestContext);
        bundle.putBoolean("isImportant", this.KClassImpl$Data$declaredNonStaticMembers$2);
        return bundle;
    }

    public final boolean getAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* loaded from: classes3.dex */
    public static class Api22Impl {
        private Api22Impl() {
        }

        public static PersistableBundle PlaceComponentResult(Person person) {
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("name", person.BuiltInFictitiousFunctionClassFactory != null ? person.BuiltInFictitiousFunctionClassFactory.toString() : null);
            persistableBundle.putString("uri", person.scheduleImpl);
            persistableBundle.putString("key", person.MyBillsEntityDataFactory);
            persistableBundle.putBoolean("isBot", person.getAuthRequestContext);
            persistableBundle.putBoolean("isImportant", person.KClassImpl$Data$declaredNonStaticMembers$2);
            return persistableBundle;
        }
    }

    /* loaded from: classes3.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }
    }
}
