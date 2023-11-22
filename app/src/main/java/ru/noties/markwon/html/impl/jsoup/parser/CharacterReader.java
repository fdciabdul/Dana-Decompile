package ru.noties.markwon.html.impl.jsoup.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.CharCompanionObject;
import ru.noties.markwon.html.impl.jsoup.UncheckedIOException;
import ru.noties.markwon.html.impl.jsoup.helper.Validate;

/* loaded from: classes6.dex */
public final class CharacterReader {
    int BuiltInFictitiousFunctionClassFactory;
    final char[] KClassImpl$Data$declaredNonStaticMembers$2;
    int MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    final String[] PlaceComponentResult;
    int getAuthRequestContext;
    private final Reader getErrorConfigVersion;
    private int moveToNextValue;

    private CharacterReader(Reader reader) {
        this.PlaceComponentResult = new String[128];
        Validate.MyBillsEntityDataFactory(reader);
        Validate.PlaceComponentResult(reader.markSupported());
        this.getErrorConfigVersion = reader;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new char[4096];
        NetworkUserEntityData$$ExternalSyntheticLambda2();
    }

    public CharacterReader(String str) {
        this(new StringReader(str));
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        int i = this.MyBillsEntityDataFactory;
        if (i < this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            return;
        }
        try {
            this.getErrorConfigVersion.skip(i);
            this.getErrorConfigVersion.mark(4096);
            int read = this.getErrorConfigVersion.read(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.getErrorConfigVersion.reset();
            if (read != -1) {
                this.moveToNextValue = read;
                this.getAuthRequestContext += this.MyBillsEntityDataFactory;
                this.MyBillsEntityDataFactory = 0;
                this.BuiltInFictitiousFunctionClassFactory = 0;
                if (read > 3072) {
                    read = 3072;
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = read;
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public final boolean scheduleImpl() {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        return this.MyBillsEntityDataFactory >= this.moveToNextValue;
    }

    private boolean DatabaseTableConfigUtil() {
        return this.MyBillsEntityDataFactory >= this.moveToNextValue;
    }

    public final char NetworkUserEntityData$$ExternalSyntheticLambda0() {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        return DatabaseTableConfigUtil() ? CharCompanionObject.MAX_VALUE : this.KClassImpl$Data$declaredNonStaticMembers$2[this.MyBillsEntityDataFactory];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final char MyBillsEntityDataFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        char c = DatabaseTableConfigUtil() ? CharCompanionObject.MAX_VALUE : this.KClassImpl$Data$declaredNonStaticMembers$2[this.MyBillsEntityDataFactory];
        this.MyBillsEntityDataFactory++;
        return c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r0 != r8.KClassImpl$Data$declaredNonStaticMembers$2[r1]) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        r2 = r1 + 1;
        r4 = (r9.length() + r2) - 1;
        r5 = r8.moveToNextValue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        if (r1 >= r5) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if (r4 > r5) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r5 >= r4) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        if (r9.charAt(r3) != r8.KClassImpl$Data$declaredNonStaticMembers$2[r5]) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
    
        r5 = r5 + 1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
    
        if (r5 != r4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        return r1 - r8.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0046, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
    
        if (r0 != r8.KClassImpl$Data$declaredNonStaticMembers$2[r1]) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if (r1 >= r8.moveToNextValue) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getAuthRequestContext(java.lang.CharSequence r9) {
        /*
            r8 = this;
            r8.NetworkUserEntityData$$ExternalSyntheticLambda2()
            r0 = 0
            char r0 = r9.charAt(r0)
            int r1 = r8.MyBillsEntityDataFactory
        La:
            int r2 = r8.moveToNextValue
            if (r1 >= r2) goto L48
            char[] r2 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            char r2 = r2[r1]
            r3 = 1
            if (r0 == r2) goto L20
        L15:
            int r1 = r1 + r3
            int r2 = r8.moveToNextValue
            if (r1 >= r2) goto L20
            char[] r2 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            char r2 = r2[r1]
            if (r0 != r2) goto L15
        L20:
            int r2 = r1 + 1
            int r4 = r9.length()
            int r4 = r4 + r2
            int r4 = r4 - r3
            int r5 = r8.moveToNextValue
            if (r1 >= r5) goto L46
            if (r4 > r5) goto L46
            r5 = r2
        L2f:
            if (r5 >= r4) goto L40
            char r6 = r9.charAt(r3)
            char[] r7 = r8.KClassImpl$Data$declaredNonStaticMembers$2
            char r7 = r7[r5]
            if (r6 != r7) goto L40
            int r5 = r5 + 1
            int r3 = r3 + 1
            goto L2f
        L40:
            if (r5 != r4) goto L46
            int r9 = r8.MyBillsEntityDataFactory
            int r1 = r1 - r9
            return r1
        L46:
            r1 = r2
            goto La
        L48:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.noties.markwon.html.impl.jsoup.parser.CharacterReader.getAuthRequestContext(java.lang.CharSequence):int");
    }

    public final String MyBillsEntityDataFactory(char... cArr) {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int i = this.MyBillsEntityDataFactory;
        int i2 = this.moveToNextValue;
        char[] cArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        loop0: while (this.MyBillsEntityDataFactory < i2) {
            for (char c : cArr) {
                if (cArr2[this.MyBillsEntityDataFactory] == c) {
                    break loop0;
                }
            }
            this.MyBillsEntityDataFactory++;
        }
        int i3 = this.MyBillsEntityDataFactory;
        return i3 > i ? BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, i, i3 - i) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String BuiltInFictitiousFunctionClassFactory(char... cArr) {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int i = this.MyBillsEntityDataFactory;
        int i2 = this.moveToNextValue;
        char[] cArr2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        while (true) {
            int i3 = this.MyBillsEntityDataFactory;
            if (i3 >= i2 || Arrays.binarySearch(cArr, cArr2[i3]) >= 0) {
                break;
            }
            this.MyBillsEntityDataFactory++;
        }
        int i4 = this.MyBillsEntityDataFactory;
        return i4 > i ? BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, i, i4 - i) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return BuiltInFictitiousFunctionClassFactory(r6.KClassImpl$Data$declaredNonStaticMembers$2, r6.PlaceComponentResult, r0, r3 - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            r6 = this;
            r6.NetworkUserEntityData$$ExternalSyntheticLambda2()
            int r0 = r6.MyBillsEntityDataFactory
            int r1 = r6.moveToNextValue
            char[] r2 = r6.KClassImpl$Data$declaredNonStaticMembers$2
        L9:
            int r3 = r6.MyBillsEntityDataFactory
            if (r3 >= r1) goto L1e
            char r4 = r2[r3]
            r5 = 38
            if (r4 == r5) goto L1e
            r5 = 60
            if (r4 == r5) goto L1e
            if (r4 == 0) goto L1e
            int r3 = r3 + 1
            r6.MyBillsEntityDataFactory = r3
            goto L9
        L1e:
            if (r3 <= r0) goto L2a
            char[] r1 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String[] r2 = r6.PlaceComponentResult
            int r3 = r3 - r0
            java.lang.String r0 = BuiltInFictitiousFunctionClassFactory(r1, r2, r0, r3)
            goto L2c
        L2a:
            java.lang.String r0 = ""
        L2c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.noties.markwon.html.impl.jsoup.parser.CharacterReader.KClassImpl$Data$declaredNonStaticMembers$2():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return BuiltInFictitiousFunctionClassFactory(r6.KClassImpl$Data$declaredNonStaticMembers$2, r6.PlaceComponentResult, r0, r3 - r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String moveToNextValue() {
        /*
            r6 = this;
            r6.NetworkUserEntityData$$ExternalSyntheticLambda2()
            int r0 = r6.MyBillsEntityDataFactory
            int r1 = r6.moveToNextValue
            char[] r2 = r6.KClassImpl$Data$declaredNonStaticMembers$2
        L9:
            int r3 = r6.MyBillsEntityDataFactory
            if (r3 >= r1) goto L32
            char r4 = r2[r3]
            r5 = 9
            if (r4 == r5) goto L32
            r5 = 10
            if (r4 == r5) goto L32
            r5 = 13
            if (r4 == r5) goto L32
            r5 = 12
            if (r4 == r5) goto L32
            r5 = 32
            if (r4 == r5) goto L32
            r5 = 47
            if (r4 == r5) goto L32
            r5 = 62
            if (r4 == r5) goto L32
            if (r4 == 0) goto L32
            int r3 = r3 + 1
            r6.MyBillsEntityDataFactory = r3
            goto L9
        L32:
            if (r3 <= r0) goto L3e
            char[] r1 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String[] r2 = r6.PlaceComponentResult
            int r3 = r3 - r0
            java.lang.String r0 = BuiltInFictitiousFunctionClassFactory(r1, r2, r0, r3)
            goto L40
        L3e:
            java.lang.String r0 = ""
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.noties.markwon.html.impl.jsoup.parser.CharacterReader.moveToNextValue():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String lookAheadTest() {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        char[] cArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String[] strArr = this.PlaceComponentResult;
        int i = this.MyBillsEntityDataFactory;
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(cArr, strArr, i, this.moveToNextValue - i);
        this.MyBillsEntityDataFactory = this.moveToNextValue;
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getAuthRequestContext() {
        char c;
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int i = this.MyBillsEntityDataFactory;
        while (true) {
            int i2 = this.MyBillsEntityDataFactory;
            if (i2 >= this.moveToNextValue || (((c = this.KClassImpl$Data$declaredNonStaticMembers$2[i2]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.MyBillsEntityDataFactory++;
        }
        return BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, i, this.MyBillsEntityDataFactory - i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String getErrorConfigVersion() {
        char c;
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int i = this.MyBillsEntityDataFactory;
        while (true) {
            int i2 = this.MyBillsEntityDataFactory;
            if (i2 >= this.moveToNextValue || (((c = this.KClassImpl$Data$declaredNonStaticMembers$2[i2]) < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c)))) {
                break;
            }
            this.MyBillsEntityDataFactory++;
        }
        while (!DatabaseTableConfigUtil()) {
            char[] cArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i3 = this.MyBillsEntityDataFactory;
            char c2 = cArr[i3];
            if (c2 < '0' || c2 > '9') {
                break;
            }
            this.MyBillsEntityDataFactory = i3 + 1;
        }
        return BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, i, this.MyBillsEntityDataFactory - i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String BuiltInFictitiousFunctionClassFactory() {
        int i;
        char c;
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int i2 = this.MyBillsEntityDataFactory;
        while (true) {
            i = this.MyBillsEntityDataFactory;
            if (i >= this.moveToNextValue || (((c = this.KClassImpl$Data$declaredNonStaticMembers$2[i]) < '0' || c > '9') && ((c < 'A' || c > 'F') && (c < 'a' || c > 'f')))) {
                break;
            }
            this.MyBillsEntityDataFactory = i + 1;
        }
        return BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, i2, i - i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String PlaceComponentResult() {
        int i;
        char c;
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int i2 = this.MyBillsEntityDataFactory;
        while (true) {
            i = this.MyBillsEntityDataFactory;
            if (i >= this.moveToNextValue || (c = this.KClassImpl$Data$declaredNonStaticMembers$2[i]) < '0' || c > '9') {
                break;
            }
            this.MyBillsEntityDataFactory = i + 1;
        }
        return BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, i2, i - i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(char c) {
        return !scheduleImpl() && this.KClassImpl$Data$declaredNonStaticMembers$2[this.MyBillsEntityDataFactory] == c;
    }

    private boolean getAuthRequestContext(String str) {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int length = str.length();
        if (length > this.moveToNextValue - this.MyBillsEntityDataFactory) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != this.KClassImpl$Data$declaredNonStaticMembers$2[this.MyBillsEntityDataFactory + i]) {
                return false;
            }
        }
        return true;
    }

    private boolean PlaceComponentResult(String str) {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int length = str.length();
        if (length > this.moveToNextValue - this.MyBillsEntityDataFactory) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(this.KClassImpl$Data$declaredNonStaticMembers$2[this.MyBillsEntityDataFactory + i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult(char... cArr) {
        if (scheduleImpl()) {
            return false;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        char c = this.KClassImpl$Data$declaredNonStaticMembers$2[this.MyBillsEntityDataFactory];
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext(char[] cArr) {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        return !scheduleImpl() && Arrays.binarySearch(cArr, this.KClassImpl$Data$declaredNonStaticMembers$2[this.MyBillsEntityDataFactory]) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean GetContactSyncConfig() {
        if (scheduleImpl()) {
            return false;
        }
        char c = this.KClassImpl$Data$declaredNonStaticMembers$2[this.MyBillsEntityDataFactory];
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || Character.isLetter(c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        char c;
        return !scheduleImpl() && (c = this.KClassImpl$Data$declaredNonStaticMembers$2[this.MyBillsEntityDataFactory]) >= '0' && c <= '9';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        if (getAuthRequestContext(str)) {
            this.MyBillsEntityDataFactory += str.length();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(String str) {
        if (PlaceComponentResult(str)) {
            this.MyBillsEntityDataFactory += str.length();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory(String str) {
        return getAuthRequestContext((CharSequence) str.toLowerCase(Locale.ENGLISH)) >= 0 || getAuthRequestContext((CharSequence) str.toUpperCase(Locale.ENGLISH)) >= 0;
    }

    public final String toString() {
        char[] cArr = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = this.MyBillsEntityDataFactory;
        return new String(cArr, i, this.moveToNextValue - i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String BuiltInFictitiousFunctionClassFactory(char[] cArr, String[] strArr, int i, int i2) {
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        if (i2 <= 0) {
            return "";
        }
        int i3 = 0;
        int i4 = i;
        int i5 = 0;
        while (i3 < i2) {
            i5 = (i5 * 31) + cArr[i4];
            i3++;
            i4++;
        }
        int length = (strArr.length - 1) & i5;
        String str = strArr[length];
        if (str == null) {
            String str2 = new String(cArr, i, i2);
            strArr[length] = str2;
            return str2;
        } else if (MyBillsEntityDataFactory(cArr, i, i2, str)) {
            return str;
        } else {
            String str3 = new String(cArr, i, i2);
            strArr[length] = str3;
            return str3;
        }
    }

    private static boolean MyBillsEntityDataFactory(char[] cArr, int i, int i2, String str) {
        if (i2 == str.length()) {
            int i3 = 0;
            while (i2 != 0) {
                if (cArr[i] != str.charAt(i3)) {
                    return false;
                }
                i++;
                i2--;
                i3++;
            }
            return true;
        }
        return false;
    }

    public final String getAuthRequestContext(char c) {
        int i;
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int i2 = this.MyBillsEntityDataFactory;
        while (true) {
            if (i2 >= this.moveToNextValue) {
                i = -1;
                break;
            } else if (c == this.KClassImpl$Data$declaredNonStaticMembers$2[i2]) {
                i = i2 - this.MyBillsEntityDataFactory;
                break;
            } else {
                i2++;
            }
        }
        if (i != -1) {
            String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.MyBillsEntityDataFactory, i);
            this.MyBillsEntityDataFactory += i;
            return BuiltInFictitiousFunctionClassFactory;
        }
        return lookAheadTest();
    }
}
