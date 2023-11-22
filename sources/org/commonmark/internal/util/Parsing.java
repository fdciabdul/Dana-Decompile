package org.commonmark.internal.util;

/* loaded from: classes6.dex */
public class Parsing {
    public static int KClassImpl$Data$declaredNonStaticMembers$2 = 4;

    public static int getAuthRequestContext(int i) {
        return 4 - (i % 4);
    }

    public static int BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, int i) {
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            if (charAt == '\n' || charAt == '\r') {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean getAuthRequestContext(CharSequence charSequence, int i) {
        return Character.isLetter(Character.codePointAt(charSequence, i));
    }

    public static boolean MyBillsEntityDataFactory(CharSequence charSequence, int i) {
        if (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            return charAt == '\t' || charAt == ' ';
        }
        return false;
    }

    public static CharSequence PlaceComponentResult(CharSequence charSequence) {
        StringBuilder sb = null;
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charSequence.charAt(i) == 0) {
                if (sb == null) {
                    sb = new StringBuilder(charSequence.length());
                    sb.append(charSequence, 0, i);
                }
                sb.append((char) 65533);
            } else if (sb != null) {
                sb.append(charAt);
            }
        }
        return sb != null ? sb.toString() : charSequence;
    }

    public static boolean getAuthRequestContext(CharSequence charSequence) {
        int i = 0;
        while (true) {
            if (i < charSequence.length()) {
                char charAt = charSequence.charAt(i);
                if (charAt != ' ') {
                    switch (charAt) {
                    }
                }
                i++;
            } else {
                i = -1;
            }
        }
        return i == -1;
    }
}
