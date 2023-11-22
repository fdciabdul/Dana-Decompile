package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.Preconditions;

/* loaded from: classes3.dex */
public final class LocusIdCompat {
    private final LocusId BuiltInFictitiousFunctionClassFactory;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;

    public LocusIdCompat(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (String) Preconditions.BuiltInFictitiousFunctionClassFactory(str, "id cannot be empty");
        if (Build.VERSION.SDK_INT >= 29) {
            this.BuiltInFictitiousFunctionClassFactory = Api29Impl.getAuthRequestContext(str);
        } else {
            this.BuiltInFictitiousFunctionClassFactory = null;
        }
    }

    public final String MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final int hashCode() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            LocusIdCompat locusIdCompat = (LocusIdCompat) obj;
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str == null) {
                return locusIdCompat.KClassImpl$Data$declaredNonStaticMembers$2 == null;
            }
            return str.equals(locusIdCompat.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocusIdCompat[");
        sb.append(KClassImpl$Data$declaredNonStaticMembers$2());
        sb.append("]");
        return sb.toString();
    }

    public final LocusId BuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    private String KClassImpl$Data$declaredNonStaticMembers$2() {
        int length = this.KClassImpl$Data$declaredNonStaticMembers$2.length();
        StringBuilder sb = new StringBuilder();
        sb.append(length);
        sb.append("_chars");
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    static class Api29Impl {
        private Api29Impl() {
        }

        static LocusId getAuthRequestContext(String str) {
            return new LocusId(str);
        }
    }
}
