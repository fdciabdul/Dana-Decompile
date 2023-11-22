package com.google.zxing.common;

import android.os.Process;
import com.google.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;
import o.getCallingPid;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'UTF8' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class CharacterSetECI {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final /* synthetic */ CharacterSetECI[] $VALUES;
    public static final CharacterSetECI ASCII;
    public static final CharacterSetECI Big5;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    public static final CharacterSetECI Cp1250;
    public static final CharacterSetECI Cp1251;
    public static final CharacterSetECI Cp1252;
    public static final CharacterSetECI Cp1256;
    public static final CharacterSetECI Cp437;
    public static final CharacterSetECI EUC_KR;
    public static final CharacterSetECI GB18030;
    public static final CharacterSetECI ISO8859_1;
    public static final CharacterSetECI ISO8859_10;
    public static final CharacterSetECI ISO8859_11;
    public static final CharacterSetECI ISO8859_13;
    public static final CharacterSetECI ISO8859_14;
    public static final CharacterSetECI ISO8859_15;
    public static final CharacterSetECI ISO8859_16;
    public static final CharacterSetECI ISO8859_2;
    public static final CharacterSetECI ISO8859_3;
    public static final CharacterSetECI ISO8859_4;
    public static final CharacterSetECI ISO8859_5;
    public static final CharacterSetECI ISO8859_6;
    public static final CharacterSetECI ISO8859_7;
    public static final CharacterSetECI ISO8859_8;
    public static final CharacterSetECI ISO8859_9;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2;
    private static char MyBillsEntityDataFactory;
    private static final Map<String, CharacterSetECI> NAME_TO_ECI;
    public static final CharacterSetECI SJIS;
    public static final CharacterSetECI UTF8;
    public static final CharacterSetECI UnicodeBigUnmarked;
    private static final Map<Integer, CharacterSetECI> VALUE_TO_ECI;
    private static int getAuthRequestContext;
    private final String[] otherEncodingNames;
    private final int[] values;

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        MyBillsEntityDataFactory = (char) 42070;
        KClassImpl$Data$declaredNonStaticMembers$2 = new char[]{37274, 37254, 37253, 37367, 37257, 37252, 37255, 37346, 37275};
    }

    public static CharacterSetECI valueOf(String str) {
        CharacterSetECI characterSetECI;
        int i = getAuthRequestContext + 13;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 != 0) {
            characterSetECI = (CharacterSetECI) Enum.valueOf(CharacterSetECI.class, str);
        } else {
            characterSetECI = (CharacterSetECI) Enum.valueOf(CharacterSetECI.class, str);
            int i2 = 14 / 0;
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 9;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return characterSetECI;
    }

    public static CharacterSetECI[] values() {
        int i = BuiltInFictitiousFunctionClassFactory + 117;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        CharacterSetECI[] characterSetECIArr = (CharacterSetECI[]) $VALUES.clone();
        try {
            int i3 = getAuthRequestContext + 49;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return characterSetECIArr;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        CharacterSetECI characterSetECI = new CharacterSetECI("Cp437", 0, new int[]{0, 2}, new String[0]);
        Cp437 = characterSetECI;
        CharacterSetECI characterSetECI2 = new CharacterSetECI("ISO8859_1", 1, new int[]{1, 3}, "ISO-8859-1");
        ISO8859_1 = characterSetECI2;
        CharacterSetECI characterSetECI3 = new CharacterSetECI("ISO8859_2", 2, 4, "ISO-8859-2");
        ISO8859_2 = characterSetECI3;
        CharacterSetECI characterSetECI4 = new CharacterSetECI("ISO8859_3", 3, 5, "ISO-8859-3");
        ISO8859_3 = characterSetECI4;
        CharacterSetECI characterSetECI5 = new CharacterSetECI("ISO8859_4", 4, 6, "ISO-8859-4");
        ISO8859_4 = characterSetECI5;
        CharacterSetECI characterSetECI6 = new CharacterSetECI("ISO8859_5", 5, 7, "ISO-8859-5");
        ISO8859_5 = characterSetECI6;
        CharacterSetECI characterSetECI7 = new CharacterSetECI("ISO8859_6", 6, 8, "ISO-8859-6");
        ISO8859_6 = characterSetECI7;
        CharacterSetECI characterSetECI8 = new CharacterSetECI("ISO8859_7", 7, 9, "ISO-8859-7");
        ISO8859_7 = characterSetECI8;
        CharacterSetECI characterSetECI9 = new CharacterSetECI("ISO8859_8", 8, 10, "ISO-8859-8");
        ISO8859_8 = characterSetECI9;
        CharacterSetECI characterSetECI10 = new CharacterSetECI("ISO8859_9", 9, 11, "ISO-8859-9");
        ISO8859_9 = characterSetECI10;
        CharacterSetECI characterSetECI11 = new CharacterSetECI("ISO8859_10", 10, 12, "ISO-8859-10");
        ISO8859_10 = characterSetECI11;
        CharacterSetECI characterSetECI12 = new CharacterSetECI("ISO8859_11", 11, 13, "ISO-8859-11");
        ISO8859_11 = characterSetECI12;
        CharacterSetECI characterSetECI13 = new CharacterSetECI("ISO8859_13", 12, 15, "ISO-8859-13");
        ISO8859_13 = characterSetECI13;
        CharacterSetECI characterSetECI14 = new CharacterSetECI("ISO8859_14", 13, 16, "ISO-8859-14");
        ISO8859_14 = characterSetECI14;
        CharacterSetECI characterSetECI15 = new CharacterSetECI("ISO8859_15", 14, 17, "ISO-8859-15");
        ISO8859_15 = characterSetECI15;
        CharacterSetECI characterSetECI16 = new CharacterSetECI("ISO8859_16", 15, 18, "ISO-8859-16");
        ISO8859_16 = characterSetECI16;
        CharacterSetECI characterSetECI17 = new CharacterSetECI(StringUtils.SHIFT_JIS, 16, 20, "Shift_JIS");
        SJIS = characterSetECI17;
        CharacterSetECI characterSetECI18 = new CharacterSetECI("Cp1250", 17, 21, "windows-1250");
        Cp1250 = characterSetECI18;
        CharacterSetECI characterSetECI19 = new CharacterSetECI("Cp1251", 18, 22, "windows-1251");
        Cp1251 = characterSetECI19;
        CharacterSetECI characterSetECI20 = new CharacterSetECI("Cp1252", 19, 23, "windows-1252");
        Cp1252 = characterSetECI20;
        CharacterSetECI characterSetECI21 = new CharacterSetECI("Cp1256", 20, 24, "windows-1256");
        Cp1256 = characterSetECI21;
        CharacterSetECI characterSetECI22 = new CharacterSetECI("UnicodeBigUnmarked", 21, 25, "UTF-16BE", "UnicodeBig");
        UnicodeBigUnmarked = characterSetECI22;
        Object[] objArr = new Object[1];
        a(new char[]{2, 6, 7, 1, 13735}, (byte) (6 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 5 - ((Process.getThreadPriority(0) + 20) >> 6), objArr);
        CharacterSetECI characterSetECI23 = new CharacterSetECI("UTF8", 22, 26, ((String) objArr[0]).intern());
        UTF8 = characterSetECI23;
        CharacterSetECI characterSetECI24 = new CharacterSetECI("ASCII", 23, new int[]{27, 170}, "US-ASCII");
        ASCII = characterSetECI24;
        CharacterSetECI characterSetECI25 = new CharacterSetECI("Big5", 24, 28);
        Big5 = characterSetECI25;
        CharacterSetECI characterSetECI26 = new CharacterSetECI("GB18030", 25, 29, StringUtils.GB2312, "EUC_CN", "GBK");
        GB18030 = characterSetECI26;
        CharacterSetECI characterSetECI27 = new CharacterSetECI("EUC_KR", 26, 30, "EUC-KR");
        EUC_KR = characterSetECI27;
        $VALUES = new CharacterSetECI[]{characterSetECI, characterSetECI2, characterSetECI3, characterSetECI4, characterSetECI5, characterSetECI6, characterSetECI7, characterSetECI8, characterSetECI9, characterSetECI10, characterSetECI11, characterSetECI12, characterSetECI13, characterSetECI14, characterSetECI15, characterSetECI16, characterSetECI17, characterSetECI18, characterSetECI19, characterSetECI20, characterSetECI21, characterSetECI22, characterSetECI23, characterSetECI24, characterSetECI25, characterSetECI26, characterSetECI27};
        VALUE_TO_ECI = new HashMap();
        NAME_TO_ECI = new HashMap();
        CharacterSetECI[] values = values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return;
            }
            CharacterSetECI characterSetECI28 = values[i];
            int[] iArr = characterSetECI28.values;
            int length2 = iArr.length;
            int i2 = getAuthRequestContext + 109;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            int i4 = 0;
            while (true) {
                if ((i4 < length2 ? 'M' : (char) 4) == 4) {
                    break;
                }
                VALUE_TO_ECI.put(Integer.valueOf(iArr[i4]), characterSetECI28);
                i4++;
            }
            NAME_TO_ECI.put(characterSetECI28.name(), characterSetECI28);
            String[] strArr = characterSetECI28.otherEncodingNames;
            int length3 = strArr.length;
            int i5 = 0;
            while (true) {
                if ((i5 < length3 ? '6' : 'V') != 'V') {
                    NAME_TO_ECI.put(strArr[i5], characterSetECI28);
                    i5++;
                    int i6 = BuiltInFictitiousFunctionClassFactory + 107;
                    getAuthRequestContext = i6 % 128;
                    int i7 = i6 % 2;
                }
            }
            i++;
        }
    }

    private CharacterSetECI(String str, int i, int i2) {
        this(str, i, new int[]{i2}, new String[0]);
    }

    private CharacterSetECI(String str, int i, int i2, String... strArr) {
        this.values = new int[]{i2};
        this.otherEncodingNames = strArr;
    }

    private CharacterSetECI(String str, int i, int[] iArr, String... strArr) {
        this.values = iArr;
        this.otherEncodingNames = strArr;
    }

    public final int getValue() {
        int i = BuiltInFictitiousFunctionClassFactory + 113;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? 'B' : (char) 11) != 'B') {
            try {
                return this.values[0];
            } catch (Exception e) {
                throw e;
            }
        }
        return this.values[0];
    }

    public static CharacterSetECI getCharacterSetECIByValue(int i) throws FormatException {
        if (i >= 0) {
            try {
                int i2 = BuiltInFictitiousFunctionClassFactory + 115;
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                if (!(i >= 900)) {
                    int i4 = getAuthRequestContext + 17;
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    if (i4 % 2 == 0) {
                        CharacterSetECI characterSetECI = VALUE_TO_ECI.get(Integer.valueOf(i));
                        Object obj = null;
                        obj.hashCode();
                        return characterSetECI;
                    }
                    return VALUE_TO_ECI.get(Integer.valueOf(i));
                }
            } catch (Exception e) {
                throw e;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public static CharacterSetECI getCharacterSetECIByName(String str) {
        CharacterSetECI characterSetECI;
        int i = BuiltInFictitiousFunctionClassFactory + 41;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            characterSetECI = NAME_TO_ECI.get(str);
        } else {
            try {
                try {
                    characterSetECI = NAME_TO_ECI.get(str);
                    int i2 = 77 / 0;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 111;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return characterSetECI;
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        try {
            char[] cArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
            if (cArr2 != null) {
                int length = cArr2.length;
                char[] cArr3 = new char[length];
                int i3 = $11 + 9;
                $10 = i3 % 128;
                int i4 = i3 % 2;
                for (int i5 = 0; i5 < length; i5++) {
                    cArr3[i5] = (char) (cArr2[i5] ^ (-1549216646985767851L));
                }
                cArr2 = cArr3;
            }
            char c = (char) ((-1549216646985767851L) ^ MyBillsEntityDataFactory);
            char[] cArr4 = new char[i];
            if (i % 2 != 0) {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            } else {
                i2 = i;
            }
            if (i2 > 1) {
                getcallingpid.getAuthRequestContext = 0;
                while (true) {
                    if (!(getcallingpid.getAuthRequestContext < i2)) {
                        break;
                    }
                    getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                    getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                    if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    } else {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                        getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                        getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                        if (!(getcallingpid.scheduleImpl != getcallingpid.lookAheadTest)) {
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i6 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i7 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i6];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i7];
                        } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                            try {
                                int i10 = $11 + 49;
                                $10 = i10 % 128;
                                int i11 = i10 % 2;
                            } catch (Exception e) {
                                throw e;
                            }
                        } else {
                            int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                        }
                    }
                    getcallingpid.getAuthRequestContext += 2;
                }
            }
            int i14 = 0;
            while (i14 < i) {
                int i15 = $10 + 111;
                $11 = i15 % 128;
                if (i15 % 2 == 0) {
                    cArr4[i14] = (char) (cArr4[i14] & 32024);
                    i14 += 9;
                } else {
                    cArr4[i14] = (char) (cArr4[i14] ^ 13722);
                    i14++;
                }
            }
            objArr[0] = new String(cArr4);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
