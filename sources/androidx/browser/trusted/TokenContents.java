package androidx.browser.trusted;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes6.dex */
final class TokenContents {
    String MyBillsEntityDataFactory;
    private final byte[] PlaceComponentResult;
    private List<byte[]> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TokenContents MyBillsEntityDataFactory(String str, List<byte[]> list) throws IOException {
        return new TokenContents(KClassImpl$Data$declaredNonStaticMembers$2(str, list), str, list);
    }

    private TokenContents(byte[] bArr, String str, List<byte[]> list) {
        this.PlaceComponentResult = bArr;
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = new ArrayList(list.size());
        for (byte[] bArr2 : list) {
            this.getAuthRequestContext.add(Arrays.copyOf(bArr2, bArr2.length));
        }
    }

    public final byte[] BuiltInFictitiousFunctionClassFactory() throws IOException {
        getAuthRequestContext();
        List<byte[]> list = this.getAuthRequestContext;
        if (list == null) {
            throw new IllegalStateException();
        }
        return Arrays.copyOf(list.get(0), this.getAuthRequestContext.get(0).length);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.PlaceComponentResult, ((TokenContents) obj).PlaceComponentResult);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.PlaceComponentResult);
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(String str, List<byte[]> list) throws IOException {
        Collections.sort(list, new Comparator() { // from class: androidx.browser.trusted.TokenContents$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return TokenContents.KClassImpl$Data$declaredNonStaticMembers$2((byte[]) obj, (byte[]) obj2);
            }
        });
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF(str);
        dataOutputStream.writeInt(list.size());
        for (byte[] bArr : list) {
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext() throws IOException {
        if (this.MyBillsEntityDataFactory != null) {
            return;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.PlaceComponentResult));
        this.MyBillsEntityDataFactory = dataInputStream.readUTF();
        int readInt = dataInputStream.readInt();
        this.getAuthRequestContext = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            int readInt2 = dataInputStream.readInt();
            byte[] bArr = new byte[readInt2];
            if (dataInputStream.read(bArr) != readInt2) {
                throw new IllegalStateException("Could not read fingerprint");
            }
            this.getAuthRequestContext.add(bArr);
        }
    }

    public static /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2) {
            if (bArr == null) {
                return -1;
            }
            if (bArr2 == null) {
                return 1;
            }
            for (int i = 0; i < Math.min(bArr.length, bArr2.length); i++) {
                byte b = bArr[i];
                byte b2 = bArr2[i];
                if (b != b2) {
                    return b - b2;
                }
            }
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
        }
        return 0;
    }
}
