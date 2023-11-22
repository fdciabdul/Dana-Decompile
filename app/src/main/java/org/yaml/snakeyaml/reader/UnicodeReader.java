package org.yaml.snakeyaml.reader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* loaded from: classes9.dex */
public class UnicodeReader extends Reader {
    PushbackInputStream KClassImpl$Data$declaredNonStaticMembers$2;
    InputStreamReader MyBillsEntityDataFactory;
    private static final Charset BuiltInFictitiousFunctionClassFactory = StandardCharsets.UTF_8;
    private static final Charset getAuthRequestContext = StandardCharsets.UTF_16BE;
    private static final Charset PlaceComponentResult = StandardCharsets.UTF_16LE;

    private void PlaceComponentResult() throws IOException {
        Charset charset;
        int i;
        if (this.MyBillsEntityDataFactory != null) {
            return;
        }
        byte[] bArr = new byte[3];
        int read = this.KClassImpl$Data$declaredNonStaticMembers$2.read(bArr, 0, 3);
        byte b = bArr[0];
        if (b == -17 && bArr[1] == -69 && bArr[2] == -65) {
            charset = BuiltInFictitiousFunctionClassFactory;
            i = read - 3;
        } else {
            if (b == -2 && bArr[1] == -1) {
                charset = getAuthRequestContext;
            } else if (b == -1 && bArr[1] == -2) {
                charset = PlaceComponentResult;
            } else {
                charset = BuiltInFictitiousFunctionClassFactory;
                i = read;
            }
            i = read - 2;
        }
        if (i > 0) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.unread(bArr, read - i, i);
        }
        this.MyBillsEntityDataFactory = new InputStreamReader(this.KClassImpl$Data$declaredNonStaticMembers$2, charset.newDecoder().onUnmappableCharacter(CodingErrorAction.REPORT));
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        PlaceComponentResult();
        this.MyBillsEntityDataFactory.close();
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        PlaceComponentResult();
        return this.MyBillsEntityDataFactory.read(cArr, i, i2);
    }
}
