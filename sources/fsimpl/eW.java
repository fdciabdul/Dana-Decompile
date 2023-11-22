package fsimpl;

import android.text.TextUtils;
import java.io.StringWriter;

/* loaded from: classes.dex */
public class eW {
    /* JADX WARN: Multi-variable type inference failed */
    public static eZ a(Throwable th) {
        String str;
        eZ eZVar;
        String[] strArr;
        StringWriter stringWriter;
        Throwable th2;
        eY eYVar;
        Throwable th3;
        String obj;
        eX eXVar = null;
        if (th == 0) {
            return null;
        }
        try {
            try {
                stringWriter = new StringWriter();
                try {
                    eYVar = new eY(stringWriter);
                    try {
                        th.printStackTrace(eYVar);
                        obj = stringWriter.toString();
                    } catch (Throwable th4) {
                        th3 = th4;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                }
            } catch (Throwable unused) {
                str = th;
            }
        } catch (Throwable unused2) {
            str = null;
            eZVar = null;
        }
        try {
            if (obj != null) {
                try {
                    if (obj.trim().equals(TextUtils.join(System.lineSeparator(), eYVar.f7963a))) {
                        eZVar = new eZ(obj, (String[]) eYVar.f7963a.toArray(new String[eYVar.f7963a.size()]));
                        eYVar.close();
                        stringWriter.close();
                        str = obj;
                        if (eZVar != null && str != null) {
                            try {
                                strArr = str.split(System.lineSeparator());
                            } catch (Throwable unused3) {
                                strArr = new String[0];
                            }
                            return new eZ(str, strArr);
                        }
                    }
                } catch (Throwable th6) {
                    th3 = th6;
                    try {
                        eYVar.close();
                    } catch (Throwable unused4) {
                    }
                    try {
                        throw th3;
                    } catch (Throwable th7) {
                        th2 = th7;
                        try {
                            stringWriter.close();
                        } catch (Throwable unused5) {
                        }
                        throw th2;
                    }
                }
            }
            eYVar.close();
            stringWriter.close();
            str = obj;
            return eZVar != null ? eZVar : eZVar;
        } catch (Throwable th8) {
            th2 = th8;
            stringWriter.close();
            throw th2;
        }
        eZVar = null;
    }
}
