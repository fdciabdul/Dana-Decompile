package id.dana.utils;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

/* loaded from: classes9.dex */
public class RandomString {
    public static final String BuiltInFictitiousFunctionClassFactory;
    public static final String KClassImpl$Data$declaredNonStaticMembers$2;
    private final char[] MyBillsEntityDataFactory;
    private final Random PlaceComponentResult;
    private final char[] getAuthRequestContext;

    static {
        String lowerCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase(Locale.ROOT);
        KClassImpl$Data$declaredNonStaticMembers$2 = lowerCase;
        StringBuilder sb = new StringBuilder();
        sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        sb.append(lowerCase);
        sb.append("0123456789");
        BuiltInFictitiousFunctionClassFactory = sb.toString();
    }

    private RandomString(int i, Random random, String str) {
        if (str.length() < 2) {
            throw new IllegalArgumentException();
        }
        this.PlaceComponentResult = (Random) Objects.requireNonNull(random);
        this.MyBillsEntityDataFactory = str.toCharArray();
        this.getAuthRequestContext = new char[21];
    }

    private RandomString(Random random) {
        this(21, random, BuiltInFictitiousFunctionClassFactory);
    }

    private RandomString(byte b) {
        this(new SecureRandom());
    }

    public RandomString() {
        this((byte) 0);
    }
}
