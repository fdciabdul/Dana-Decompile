package org.yaml.snakeyaml.scanner;

import java.util.Arrays;

/* loaded from: classes6.dex */
public final class Constant {
    private String getErrorConfigVersion;
    boolean moveToNextValue;
    boolean[] scheduleImpl;
    public static final Constant MyBillsEntityDataFactory = new Constant("\n\u0085\u2028\u2029");
    public static final Constant lookAheadTest = new Constant("\u0000\r\n\u0085\u2028\u2029");
    public static final Constant BuiltInFictitiousFunctionClassFactory = new Constant(" \u0000\r\n\u0085\u2028\u2029");
    public static final Constant KClassImpl$Data$declaredNonStaticMembers$2 = new Constant("\t \u0000\r\n\u0085\u2028\u2029");
    public static final Constant PlaceComponentResult = new Constant("\u0000 \t");
    public static final Constant NetworkUserEntityData$$ExternalSyntheticLambda0 = new Constant("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%");
    public static final Constant getAuthRequestContext = new Constant("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_");

    private Constant(String str) {
        boolean[] zArr = new boolean[128];
        this.scheduleImpl = zArr;
        this.moveToNextValue = false;
        Arrays.fill(zArr, false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt < 128) {
                this.scheduleImpl[codePointAt] = true;
            } else {
                sb.appendCodePoint(codePointAt);
            }
        }
        if (sb.length() > 0) {
            this.moveToNextValue = true;
            this.getErrorConfigVersion = sb.toString();
        }
    }

    public final boolean PlaceComponentResult(int i) {
        if (i < 128) {
            return this.scheduleImpl[i];
        }
        return this.moveToNextValue && this.getErrorConfigVersion.indexOf(i) != -1;
    }

    public final boolean MyBillsEntityDataFactory(int i) {
        return !PlaceComponentResult(i);
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int i, String str) {
        return PlaceComponentResult(i) || str.indexOf(i) != -1;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, String str) {
        return !BuiltInFictitiousFunctionClassFactory(i, str);
    }
}
