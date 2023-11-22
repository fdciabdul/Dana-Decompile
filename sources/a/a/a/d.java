package a.a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes3.dex */
public final class d {
    private int BuiltInFictitiousFunctionClassFactory;
    private char MyBillsEntityDataFactory;
    private Reader PlaceComponentResult;
    private boolean getAuthRequestContext;

    private d(Reader reader) {
        this.PlaceComponentResult = reader.markSupported() ? reader : new BufferedReader(reader);
        this.getAuthRequestContext = false;
        this.BuiltInFictitiousFunctionClassFactory = 0;
    }

    public d(String str) {
        this(new StringReader(str));
    }

    public final void MyBillsEntityDataFactory() {
        int i;
        if (this.getAuthRequestContext || (i = this.BuiltInFictitiousFunctionClassFactory) <= 0) {
            throw new b("Stepping back two steps is not supported");
        }
        this.BuiltInFictitiousFunctionClassFactory = i - 1;
        this.getAuthRequestContext = true;
    }

    public final char PlaceComponentResult() {
        if (this.getAuthRequestContext) {
            this.getAuthRequestContext = false;
            char c = this.MyBillsEntityDataFactory;
            if (c != 0) {
                this.BuiltInFictitiousFunctionClassFactory++;
            }
            return c;
        }
        try {
            int read = this.PlaceComponentResult.read();
            if (read <= 0) {
                this.MyBillsEntityDataFactory = (char) 0;
                return (char) 0;
            }
            this.BuiltInFictitiousFunctionClassFactory++;
            char c2 = (char) read;
            this.MyBillsEntityDataFactory = c2;
            return c2;
        } catch (IOException e) {
            throw new b(e);
        }
    }

    private String PlaceComponentResult(int i) {
        if (i == 0) {
            return "";
        }
        char[] cArr = new char[i];
        int i2 = 0;
        if (this.getAuthRequestContext) {
            this.getAuthRequestContext = false;
            cArr[0] = this.MyBillsEntityDataFactory;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int read = this.PlaceComponentResult.read(cArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            } catch (IOException e) {
                throw new b(e);
            }
        }
        this.BuiltInFictitiousFunctionClassFactory += i2;
        if (i2 < i) {
            throw BuiltInFictitiousFunctionClassFactory("Substring bounds error");
        }
        this.MyBillsEntityDataFactory = cArr[i - 1];
        return new String(cArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0053, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final char KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            r5 = this;
        L0:
            char r0 = r5.PlaceComponentResult()
            r1 = 13
            r2 = 10
            r3 = 47
            if (r0 != r3) goto L3e
            char r0 = r5.PlaceComponentResult()
            r4 = 42
            if (r0 == r4) goto L25
            if (r0 == r3) goto L1a
            r5.MyBillsEntityDataFactory()
            return r3
        L1a:
            char r0 = r5.PlaceComponentResult()
            if (r0 == r2) goto L0
            if (r0 == r1) goto L0
            if (r0 != 0) goto L1a
            goto L0
        L25:
            char r0 = r5.PlaceComponentResult()
            if (r0 == 0) goto L37
            if (r0 != r4) goto L25
            char r0 = r5.PlaceComponentResult()
            if (r0 == r3) goto L0
            r5.MyBillsEntityDataFactory()
            goto L25
        L37:
            java.lang.String r0 = "Unclosed comment"
            a.a.a.b r0 = r5.BuiltInFictitiousFunctionClassFactory(r0)
            throw r0
        L3e:
            r3 = 35
            if (r0 != r3) goto L4d
        L42:
            char r0 = r5.PlaceComponentResult()
            if (r0 == r2) goto L0
            if (r0 == r1) goto L0
            if (r0 != 0) goto L42
            goto L0
        L4d:
            if (r0 == 0) goto L53
            r1 = 32
            if (r0 <= r1) goto L0
        L53:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.d.KClassImpl$Data$declaredNonStaticMembers$2():char");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x015c, code lost:
    
        throw BuiltInFictitiousFunctionClassFactory("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAuthRequestContext() {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.a.d.getAuthRequestContext():java.lang.Object");
    }

    public final b BuiltInFictitiousFunctionClassFactory(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(toString());
        return new b(sb.toString());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" at character ");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        return sb.toString();
    }
}
