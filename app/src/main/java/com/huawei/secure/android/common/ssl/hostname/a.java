package com.huawei.secure.android.common.ssl.hostname;

import javax.security.auth.x500.X500Principal;

/* loaded from: classes8.dex */
public class a {
    final int BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    int NetworkUserEntityData$$ExternalSyntheticLambda0;
    final String PlaceComponentResult;
    int getAuthRequestContext;
    char[] lookAheadTest;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.PlaceComponentResult = name;
        this.BuiltInFictitiousFunctionClassFactory = name.length();
    }

    private char getAuthRequestContext() {
        int i;
        int i2;
        int MyBillsEntityDataFactory = MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.KClassImpl$Data$declaredNonStaticMembers$2++;
        if (MyBillsEntityDataFactory < 128) {
            return (char) MyBillsEntityDataFactory;
        }
        if (MyBillsEntityDataFactory < 192 || MyBillsEntityDataFactory > 247) {
            return '?';
        }
        if (MyBillsEntityDataFactory <= 223) {
            i2 = MyBillsEntityDataFactory & 31;
            i = 1;
        } else if (MyBillsEntityDataFactory <= 239) {
            i = 2;
            i2 = MyBillsEntityDataFactory & 15;
        } else {
            i = 3;
            i2 = MyBillsEntityDataFactory & 7;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i4;
            if (i4 == this.BuiltInFictitiousFunctionClassFactory || this.lookAheadTest[i4] != '\\') {
                return '?';
            }
            int i5 = i4 + 1;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i5;
            int MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(i5);
            this.KClassImpl$Data$declaredNonStaticMembers$2++;
            if ((MyBillsEntityDataFactory2 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (MyBillsEntityDataFactory2 & 63);
        }
        return (char) i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String BuiltInFictitiousFunctionClassFactory() {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        char c2;
        char c3;
        int i5;
        int i6;
        char c4;
        char c5;
        while (true) {
            i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            i2 = this.BuiltInFictitiousFunctionClassFactory;
            if (i >= i2 || this.lookAheadTest[i] != ' ') {
                break;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.getAuthRequestContext = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
        while (true) {
            i3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            i4 = this.BuiltInFictitiousFunctionClassFactory;
            if (i3 >= i4 || (c5 = this.lookAheadTest[i3]) == '=' || c5 == ' ') {
                break;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i3 + 1;
        }
        if (i3 < i4) {
            this.MyBillsEntityDataFactory = i3;
            if (this.lookAheadTest[i3] == ' ') {
                while (true) {
                    i5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    i6 = this.BuiltInFictitiousFunctionClassFactory;
                    if (i5 >= i6 || (c4 = this.lookAheadTest[i5]) == '=' || c4 != ' ') {
                        break;
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = i5 + 1;
                }
                if (this.lookAheadTest[i5] != '=' || i5 == i6) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Unexpected end of DN: ");
                    sb.append(this.PlaceComponentResult);
                    throw new IllegalStateException(sb.toString());
                }
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2++;
            while (true) {
                int i7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (i7 >= this.BuiltInFictitiousFunctionClassFactory || this.lookAheadTest[i7] != ' ') {
                    break;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i7 + 1;
            }
            int i8 = this.MyBillsEntityDataFactory;
            int i9 = this.getAuthRequestContext;
            if (i8 - i9 > 4) {
                char[] cArr = this.lookAheadTest;
                if (cArr[i9 + 3] == '.' && (((c = cArr[i9]) == 'O' || c == 'o') && (((c2 = cArr[i9 + 1]) == 'I' || c2 == 'i') && ((c3 = cArr[i9 + 2]) == 'D' || c3 == 'd')))) {
                    this.getAuthRequestContext = i9 + 4;
                }
            }
            char[] cArr2 = this.lookAheadTest;
            int i10 = this.getAuthRequestContext;
            return new String(cArr2, i10, i8 - i10);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unexpected end of DN: ");
        sb2.append(this.PlaceComponentResult);
        throw new IllegalStateException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2 + 1;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        if (i != this.BuiltInFictitiousFunctionClassFactory) {
            char c = this.lookAheadTest[i];
            if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
                return c;
            }
            switch (c) {
                case '*':
                case '+':
                case ',':
                    return c;
                default:
                    switch (c) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            return c;
                        default:
                            return getAuthRequestContext();
                    }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected end of DN: ");
        sb.append(this.PlaceComponentResult);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int MyBillsEntityDataFactory(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.BuiltInFictitiousFunctionClassFactory) {
            char[] cArr = this.lookAheadTest;
            char c = cArr[i];
            if (c >= '0' && c <= '9') {
                i2 = c - '0';
            } else if (c >= 'a' && c <= 'f') {
                i2 = c - 'W';
            } else if (c < 'A' || c > 'F') {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed DN: ");
                sb.append(this.PlaceComponentResult);
                throw new IllegalStateException(sb.toString());
            } else {
                i2 = c - '7';
            }
            char c2 = cArr[i4];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Malformed DN: ");
                sb2.append(this.PlaceComponentResult);
                throw new IllegalStateException(sb2.toString());
            } else {
                i3 = c2 - '7';
            }
            return (i2 << 4) + i3;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Malformed DN: ");
        sb3.append(this.PlaceComponentResult);
        throw new IllegalStateException(sb3.toString());
    }
}
