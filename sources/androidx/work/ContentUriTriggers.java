package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class ContentUriTriggers {
    public final Set<Trigger> PlaceComponentResult = new HashSet();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.PlaceComponentResult.equals(((ContentUriTriggers) obj).PlaceComponentResult);
    }

    public final int hashCode() {
        return this.PlaceComponentResult.hashCode();
    }

    /* loaded from: classes3.dex */
    public static final class Trigger {
        private final boolean BuiltInFictitiousFunctionClassFactory;
        public final Uri KClassImpl$Data$declaredNonStaticMembers$2;

        public Trigger(Uri uri, boolean z) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = uri;
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.BuiltInFictitiousFunctionClassFactory;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Trigger trigger = (Trigger) obj;
            return this.BuiltInFictitiousFunctionClassFactory == trigger.BuiltInFictitiousFunctionClassFactory && this.KClassImpl$Data$declaredNonStaticMembers$2.equals(trigger.KClassImpl$Data$declaredNonStaticMembers$2);
        }

        public final int hashCode() {
            return (this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + (this.BuiltInFictitiousFunctionClassFactory ? 1 : 0);
        }
    }
}
