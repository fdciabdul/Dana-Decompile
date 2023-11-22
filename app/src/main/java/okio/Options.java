package okio;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] MyBillsEntityDataFactory;
    final int[] getAuthRequestContext;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.MyBillsEntityDataFactory = byteStringArr;
        this.getAuthRequestContext = iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bb, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static okio.Options getAuthRequestContext(okio.ByteString... r10) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Options.getAuthRequestContext(okio.ByteString[]):okio.Options");
    }

    private static void BuiltInFictitiousFunctionClassFactory(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        int i6;
        Buffer buffer2;
        int i7 = i2;
        if (i7 >= i3) {
            throw new AssertionError();
        }
        for (int i8 = i7; i8 < i3; i8++) {
            if (list.get(i8).size() < i) {
                throw new AssertionError();
            }
        }
        ByteString byteString = list.get(i2);
        ByteString byteString2 = list.get(i3 - 1);
        int i9 = -1;
        if (i == byteString.size()) {
            i9 = list2.get(i7).intValue();
            i7++;
            byteString = list.get(i7);
        }
        int i10 = i7;
        long j2 = 4;
        if (byteString.getByte(i) == byteString2.getByte(i)) {
            int i11 = 0;
            int min = Math.min(byteString.size(), byteString2.size());
            for (int i12 = i; i12 < min && byteString.getByte(i12) == byteString2.getByte(i12); i12++) {
                i11++;
            }
            long j3 = 1 + j + ((int) (buffer.getAuthRequestContext / 4)) + 2 + i11;
            buffer.BuiltInFictitiousFunctionClassFactory(-i11);
            buffer.BuiltInFictitiousFunctionClassFactory(i9);
            int i13 = i;
            while (true) {
                i4 = i + i11;
                if (i13 >= i4) {
                    break;
                }
                buffer.BuiltInFictitiousFunctionClassFactory(byteString.getByte(i13) & 255);
                i13++;
            }
            if (i10 + 1 == i3) {
                if (i4 != list.get(i10).size()) {
                    throw new AssertionError();
                }
                buffer.BuiltInFictitiousFunctionClassFactory(list2.get(i10).intValue());
                return;
            }
            Buffer buffer3 = new Buffer();
            buffer.BuiltInFictitiousFunctionClassFactory((int) ((((int) (buffer3.getAuthRequestContext / 4)) + j3) * (-1)));
            BuiltInFictitiousFunctionClassFactory(j3, buffer3, i4, list, i10, i3, list2);
            buffer.write(buffer3, buffer3.getAuthRequestContext);
            return;
        }
        int i14 = 1;
        for (int i15 = i10 + 1; i15 < i3; i15++) {
            if (list.get(i15 - 1).getByte(i) != list.get(i15).getByte(i)) {
                i14++;
            }
        }
        long j4 = j + ((int) (buffer.getAuthRequestContext / 4)) + 2 + (i14 * 2);
        buffer.BuiltInFictitiousFunctionClassFactory(i14);
        buffer.BuiltInFictitiousFunctionClassFactory(i9);
        for (int i16 = i10; i16 < i3; i16++) {
            byte b = list.get(i16).getByte(i);
            if (i16 == i10 || b != list.get(i16 - 1).getByte(i)) {
                buffer.BuiltInFictitiousFunctionClassFactory(b & 255);
            }
        }
        Buffer buffer4 = new Buffer();
        int i17 = i10;
        while (i17 < i3) {
            byte b2 = list.get(i17).getByte(i);
            int i18 = i17 + 1;
            int i19 = i18;
            while (true) {
                if (i19 >= i3) {
                    i5 = i3;
                    break;
                } else if (b2 != list.get(i19).getByte(i)) {
                    i5 = i19;
                    break;
                } else {
                    i19++;
                }
            }
            if (i18 == i5 && i + 1 == list.get(i17).size()) {
                buffer.BuiltInFictitiousFunctionClassFactory(list2.get(i17).intValue());
                i6 = i5;
                buffer2 = buffer4;
            } else {
                buffer.BuiltInFictitiousFunctionClassFactory((int) ((((int) (buffer4.getAuthRequestContext / j2)) + j4) * (-1)));
                i6 = i5;
                buffer2 = buffer4;
                BuiltInFictitiousFunctionClassFactory(j4, buffer4, i + 1, list, i17, i5, list2);
            }
            buffer4 = buffer2;
            i17 = i6;
            j2 = 4;
        }
        Buffer buffer5 = buffer4;
        buffer.write(buffer5, buffer5.getAuthRequestContext);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.MyBillsEntityDataFactory.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        return this.MyBillsEntityDataFactory[i];
    }
}
