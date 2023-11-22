package com.apiguard3.internal;

import java.lang.reflect.Field;
import java.util.Locale;

/* loaded from: classes7.dex */
public enum setLongClickable implements setAccessibilityHeading {
    IDENTITY { // from class: com.apiguard3.internal.setLongClickable.3
        private static int APIGuard = 1;
        private static int getSharedInstance;

        @Override // com.apiguard3.internal.setAccessibilityHeading
        public final String APIGuard(Field field) {
            int i = getSharedInstance + 41;
            APIGuard = i % 128;
            boolean z = i % 2 != 0;
            String name = field.getName();
            if (!z) {
                throw new ArithmeticException();
            }
            getSharedInstance = (APIGuard + 91) % 128;
            return name;
        }
    },
    UPPER_CAMEL_CASE { // from class: com.apiguard3.internal.setLongClickable.1
        private static int getSharedInstance = 1;
        private static int values;

        @Override // com.apiguard3.internal.setAccessibilityHeading
        public final String APIGuard(Field field) {
            values = (getSharedInstance + 109) % 128;
            String sharedInstance = getSharedInstance(field.getName());
            values = (getSharedInstance + 33) % 128;
            return sharedInstance;
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.apiguard3.internal.setLongClickable.4
        private static int APIGuard = 0;
        private static int valueOf = 1;

        @Override // com.apiguard3.internal.setAccessibilityHeading
        public final String APIGuard(Field field) {
            APIGuard = (valueOf + 61) % 128;
            String sharedInstance = getSharedInstance(APIGuard(field.getName(), " "));
            valueOf = (APIGuard + 3) % 128;
            return sharedInstance;
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.apiguard3.internal.setLongClickable.5
        private static int valueOf = 1;
        private static int values;

        @Override // com.apiguard3.internal.setAccessibilityHeading
        public final String APIGuard(Field field) {
            valueOf = (values + 85) % 128;
            String lowerCase = APIGuard(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            valueOf = (values + 55) % 128;
            return lowerCase;
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.apiguard3.internal.setLongClickable.2
        private static int valueOf = 0;
        private static int values = 1;

        @Override // com.apiguard3.internal.setAccessibilityHeading
        public final String APIGuard(Field field) {
            int i = values + 65;
            valueOf = i % 128;
            boolean z = i % 2 == 0;
            String APIGuard = APIGuard(field.getName(), "-");
            if (z) {
                return APIGuard.toLowerCase(Locale.ENGLISH);
            }
            throw new ArithmeticException();
        }
    },
    LOWER_CASE_WITH_DOTS { // from class: com.apiguard3.internal.setLongClickable.6
        private static int APIGuard = 1;
        private static int valueOf;

        @Override // com.apiguard3.internal.setAccessibilityHeading
        public final String APIGuard(Field field) {
            APIGuard = (valueOf + 91) % 128;
            String lowerCase = APIGuard(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            int i = APIGuard + 53;
            valueOf = i % 128;
            if ((i % 2 != 0 ? (char) 24 : (char) 22) == 22) {
                return lowerCase;
            }
            throw new NullPointerException();
        }
    };

    private static int getRequestHeaders = 1;
    private static int parseResponseHeaders;

    /* synthetic */ setLongClickable(byte b) {
        this();
    }

    public static setLongClickable valueOf(String str) {
        parseResponseHeaders = (getRequestHeaders + 81) % 128;
        setLongClickable setlongclickable = (setLongClickable) Enum.valueOf(setLongClickable.class, str);
        int i = parseResponseHeaders + 37;
        getRequestHeaders = i % 128;
        if (!(i % 2 == 0)) {
            return setlongclickable;
        }
        throw new NullPointerException();
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static setLongClickable[] valuesCustom() {
        int i = parseResponseHeaders + 119;
        getRequestHeaders = i % 128;
        if (!(i % 2 != 0)) {
            setLongClickable[] setlongclickableArr = (setLongClickable[]) values().clone();
            throw new NullPointerException();
        }
        setLongClickable[] setlongclickableArr2 = (setLongClickable[]) values().clone();
        parseResponseHeaders = (getRequestHeaders + 103) % 128;
        return setlongclickableArr2;
    }

    static {
        int i = getRequestHeaders + 117;
        parseResponseHeaders = i % 128;
        if ((i % 2 != 0 ? '6' : '(') == '(') {
            return;
        }
        throw null;
    }

    static String APIGuard(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                int i2 = getRequestHeaders + 59;
                parseResponseHeaders = i2 % 128;
                if ((i2 % 2 != 0 ? 'D' : (char) 19) != 19) {
                    throw new NullPointerException();
                }
                if ((sb.length() != 0 ? '*' : '(') != '(') {
                    sb.append(str2);
                    getRequestHeaders = (parseResponseHeaders + 75) % 128;
                }
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String getSharedInstance(String str) {
        getRequestHeaders = (parseResponseHeaders + 39) % 128;
        int length = str.length();
        int i = 0;
        while (!Character.isLetter(str.charAt(i))) {
            if ((i < length + (-1) ? 'A' : ',') == ',') {
                break;
            }
            i++;
            parseResponseHeaders = (getRequestHeaders + 79) % 128;
        }
        char charAt = str.charAt(i);
        if ((!Character.isUpperCase(charAt)) != true) {
            int i2 = getRequestHeaders + 67;
            parseResponseHeaders = i2 % 128;
            if ((i2 % 2 != 0 ? (char) 28 : '4') != 28) {
                return str;
            }
            throw null;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(upperCase);
            sb.append(str.substring(1));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str.substring(0, i));
        sb2.append(upperCase);
        sb2.append(str.substring(i + 1));
        return sb2.toString();
    }
}
