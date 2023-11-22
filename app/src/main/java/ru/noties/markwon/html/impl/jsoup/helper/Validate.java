package ru.noties.markwon.html.impl.jsoup.helper;

/* loaded from: classes6.dex */
public final class Validate {
    private Validate() {
    }

    public static void MyBillsEntityDataFactory(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
    }

    public static void PlaceComponentResult(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Must be true");
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(boolean z) {
        if (z) {
            throw new IllegalArgumentException("Must be false");
        }
    }

    public static void MyBillsEntityDataFactory(boolean z, String str) {
        if (z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String must not be empty");
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        throw new IllegalArgumentException(str);
    }
}
