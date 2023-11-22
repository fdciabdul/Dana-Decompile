package org.yaml.snakeyaml.reader;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.scanner.Constant;

/* loaded from: classes6.dex */
public class StreamReader {
    public int BuiltInFictitiousFunctionClassFactory;
    public int KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    private final Reader NetworkUserEntityData$$ExternalSyntheticLambda0;
    public int PlaceComponentResult;
    public int[] getAuthRequestContext;
    private final char[] getErrorConfigVersion;
    public int lookAheadTest;
    private boolean moveToNextValue;
    private int scheduleImpl;

    private static boolean MyBillsEntityDataFactory(int i) {
        return (i >= 32 && i <= 126) || i == 9 || i == 10 || i == 13 || i == 133 || (i >= 160 && i <= 55295) || ((i >= 57344 && i <= 65533) || (i >= 65536 && i <= 1114111));
    }

    public StreamReader(String str) {
        this(new StringReader(str));
        this.MyBillsEntityDataFactory = "'string'";
    }

    private StreamReader(Reader reader) {
        this.lookAheadTest = 0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        this.PlaceComponentResult = 0;
        this.BuiltInFictitiousFunctionClassFactory = 0;
        this.MyBillsEntityDataFactory = "'reader'";
        this.getAuthRequestContext = new int[0];
        this.scheduleImpl = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = reader;
        this.moveToNextValue = false;
        this.getErrorConfigVersion = new char[1025];
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        for (int i2 = 0; i2 < i && BuiltInFictitiousFunctionClassFactory(); i2++) {
            int[] iArr = this.getAuthRequestContext;
            int i3 = this.lookAheadTest;
            this.lookAheadTest = i3 + 1;
            int i4 = iArr[i3];
            this.KClassImpl$Data$declaredNonStaticMembers$2++;
            if (Constant.MyBillsEntityDataFactory.PlaceComponentResult(i4) || (i4 == 13 && BuiltInFictitiousFunctionClassFactory() && this.getAuthRequestContext[this.lookAheadTest] != 10)) {
                this.PlaceComponentResult++;
                this.BuiltInFictitiousFunctionClassFactory = 0;
            } else if (i4 != 65279) {
                this.BuiltInFictitiousFunctionClassFactory++;
            }
        }
    }

    public final String BuiltInFictitiousFunctionClassFactory(int i) {
        if (i == 0) {
            return "";
        }
        if (getAuthRequestContext(i)) {
            return new String(this.getAuthRequestContext, this.lookAheadTest, i);
        }
        int[] iArr = this.getAuthRequestContext;
        int i2 = this.lookAheadTest;
        return new String(iArr, i2, Math.min(i, this.scheduleImpl - i2));
    }

    public final String PlaceComponentResult(int i) {
        String BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(i);
        this.lookAheadTest += i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 += i;
        this.BuiltInFictitiousFunctionClassFactory += i;
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return getAuthRequestContext(0);
    }

    public final boolean getAuthRequestContext(int i) {
        if (!this.moveToNextValue && this.lookAheadTest + i >= this.scheduleImpl) {
            try {
                int read = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read(this.getErrorConfigVersion, 0, 1024);
                if (read > 0) {
                    int i2 = this.scheduleImpl;
                    int i3 = this.lookAheadTest;
                    int i4 = i2 - i3;
                    this.getAuthRequestContext = Arrays.copyOfRange(this.getAuthRequestContext, i3, i2 + read);
                    if (Character.isHighSurrogate(this.getErrorConfigVersion[read - 1])) {
                        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.read(this.getErrorConfigVersion, read, 1) == -1) {
                            this.moveToNextValue = true;
                        } else {
                            read++;
                        }
                    }
                    int i5 = 0;
                    int i6 = 32;
                    while (i5 < read) {
                        int codePointAt = Character.codePointAt(this.getErrorConfigVersion, i5);
                        this.getAuthRequestContext[i4] = codePointAt;
                        if (MyBillsEntityDataFactory(codePointAt)) {
                            i5 += Character.charCount(codePointAt);
                        } else {
                            i5 = read;
                            i6 = codePointAt;
                        }
                        i4++;
                    }
                    this.scheduleImpl = i4;
                    this.lookAheadTest = 0;
                    if (i6 != 32) {
                        throw new ReaderException(this.MyBillsEntityDataFactory, i4 - 1, i6, "special characters are not allowed");
                    }
                } else {
                    this.moveToNextValue = true;
                }
            } catch (IOException e) {
                throw new YAMLException(e);
            }
        }
        return this.lookAheadTest + i < this.scheduleImpl;
    }
}
