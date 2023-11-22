package net.sqlcipher;

/* loaded from: classes6.dex */
public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CursorIndexOutOfBoundsException(int r3, int r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Index "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = " requested, with a size of "
            r0.append(r3)
            r0.append(r4)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.CursorIndexOutOfBoundsException.<init>(int, int):void");
    }

    public CursorIndexOutOfBoundsException(String str) {
        super(str);
    }
}
