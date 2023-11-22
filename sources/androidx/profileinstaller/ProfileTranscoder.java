package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class ProfileTranscoder {
    static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {112, 114, 111, 0};
    static final byte[] BuiltInFictitiousFunctionClassFactory = {112, 114, 109, 0};

    private ProfileTranscoder() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] getAuthRequestContext(InputStream inputStream, byte[] bArr) throws IOException {
        if (!Arrays.equals(bArr, Encoding.BuiltInFictitiousFunctionClassFactory(inputStream, bArr.length))) {
            throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Invalid magic");
        }
        return Encoding.BuiltInFictitiousFunctionClassFactory(inputStream, ProfileVersion.lookAheadTest.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(KClassImpl$Data$declaredNonStaticMembers$2);
        outputStream.write(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getAuthRequestContext(OutputStream outputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        int length;
        if (!Arrays.equals(bArr, ProfileVersion.moveToNextValue)) {
            if (!Arrays.equals(bArr, ProfileVersion.lookAheadTest)) {
                if (!Arrays.equals(bArr, ProfileVersion.getAuthRequestContext)) {
                    if (!Arrays.equals(bArr, ProfileVersion.PlaceComponentResult)) {
                        if (Arrays.equals(bArr, ProfileVersion.BuiltInFictitiousFunctionClassFactory)) {
                            Encoding.MyBillsEntityDataFactory(outputStream, dexProfileDataArr.length);
                            for (DexProfileData dexProfileData : dexProfileDataArr) {
                                String MyBillsEntityDataFactory = MyBillsEntityDataFactory(dexProfileData.BuiltInFictitiousFunctionClassFactory, dexProfileData.MyBillsEntityDataFactory, ProfileVersion.BuiltInFictitiousFunctionClassFactory);
                                Encoding.MyBillsEntityDataFactory(outputStream, Encoding.getAuthRequestContext(MyBillsEntityDataFactory));
                                Encoding.MyBillsEntityDataFactory(outputStream, dexProfileData.scheduleImpl.size());
                                Encoding.MyBillsEntityDataFactory(outputStream, dexProfileData.getAuthRequestContext.length);
                                Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, dexProfileData.KClassImpl$Data$declaredNonStaticMembers$2, 4);
                                outputStream.write(MyBillsEntityDataFactory.getBytes(StandardCharsets.UTF_8));
                                Iterator<Integer> it = dexProfileData.scheduleImpl.keySet().iterator();
                                while (it.hasNext()) {
                                    Encoding.MyBillsEntityDataFactory(outputStream, it.next().intValue());
                                }
                                for (int i : dexProfileData.getAuthRequestContext) {
                                    Encoding.MyBillsEntityDataFactory(outputStream, i);
                                }
                            }
                            return true;
                        }
                        return false;
                    }
                    byte[] KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(dexProfileDataArr, ProfileVersion.PlaceComponentResult);
                    Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, dexProfileDataArr.length);
                    Encoding.KClassImpl$Data$declaredNonStaticMembers$2(outputStream, KClassImpl$Data$declaredNonStaticMembers$22);
                    return true;
                }
                Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, dexProfileDataArr.length);
                for (DexProfileData dexProfileData2 : dexProfileDataArr) {
                    int size = dexProfileData2.scheduleImpl.size();
                    String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(dexProfileData2.BuiltInFictitiousFunctionClassFactory, dexProfileData2.MyBillsEntityDataFactory, ProfileVersion.getAuthRequestContext);
                    Encoding.MyBillsEntityDataFactory(outputStream, Encoding.getAuthRequestContext(MyBillsEntityDataFactory2));
                    Encoding.MyBillsEntityDataFactory(outputStream, dexProfileData2.getAuthRequestContext.length);
                    Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, size * 4, 4);
                    Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, dexProfileData2.KClassImpl$Data$declaredNonStaticMembers$2, 4);
                    outputStream.write(MyBillsEntityDataFactory2.getBytes(StandardCharsets.UTF_8));
                    Iterator<Integer> it2 = dexProfileData2.scheduleImpl.keySet().iterator();
                    while (it2.hasNext()) {
                        Encoding.MyBillsEntityDataFactory(outputStream, it2.next().intValue());
                        Encoding.MyBillsEntityDataFactory(outputStream, 0);
                    }
                    for (int i2 : dexProfileData2.getAuthRequestContext) {
                        Encoding.MyBillsEntityDataFactory(outputStream, i2);
                    }
                }
                return true;
            }
            byte[] KClassImpl$Data$declaredNonStaticMembers$23 = KClassImpl$Data$declaredNonStaticMembers$2(dexProfileDataArr, ProfileVersion.lookAheadTest);
            Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, dexProfileDataArr.length);
            Encoding.KClassImpl$Data$declaredNonStaticMembers$2(outputStream, KClassImpl$Data$declaredNonStaticMembers$23);
            return true;
        }
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(PlaceComponentResult(dexProfileDataArr));
        arrayList.add(BuiltInFictitiousFunctionClassFactory(dexProfileDataArr));
        arrayList.add(KClassImpl$Data$declaredNonStaticMembers$2(dexProfileDataArr));
        long length2 = ProfileVersion.moveToNextValue.length + KClassImpl$Data$declaredNonStaticMembers$2.length + 4 + (arrayList.size() * 16);
        Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, arrayList.size(), 4);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            WritableFileSection writableFileSection = (WritableFileSection) arrayList.get(i3);
            Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, writableFileSection.KClassImpl$Data$declaredNonStaticMembers$2.getValue(), 4);
            Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, length2, 4);
            if (writableFileSection.PlaceComponentResult) {
                long length3 = writableFileSection.getAuthRequestContext.length;
                byte[] authRequestContext = Encoding.getAuthRequestContext(writableFileSection.getAuthRequestContext);
                arrayList2.add(authRequestContext);
                Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, authRequestContext.length, 4);
                Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, length3, 4);
                length = authRequestContext.length;
            } else {
                arrayList2.add(writableFileSection.getAuthRequestContext);
                Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, writableFileSection.getAuthRequestContext.length, 4);
                Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, 0L, 4);
                length = writableFileSection.getAuthRequestContext.length;
            }
            length2 += length;
        }
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            outputStream.write((byte[]) arrayList2.get(i4));
        }
        return true;
    }

    private static WritableFileSection PlaceComponentResult(DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Encoding.MyBillsEntityDataFactory(byteArrayOutputStream, dexProfileDataArr.length);
            int i = 2;
            for (DexProfileData dexProfileData : dexProfileDataArr) {
                Encoding.BuiltInFictitiousFunctionClassFactory(byteArrayOutputStream, dexProfileData.KClassImpl$Data$declaredNonStaticMembers$2, 4);
                Encoding.BuiltInFictitiousFunctionClassFactory(byteArrayOutputStream, dexProfileData.moveToNextValue, 4);
                Encoding.BuiltInFictitiousFunctionClassFactory(byteArrayOutputStream, dexProfileData.NetworkUserEntityData$$ExternalSyntheticLambda0, 4);
                String MyBillsEntityDataFactory = MyBillsEntityDataFactory(dexProfileData.BuiltInFictitiousFunctionClassFactory, dexProfileData.MyBillsEntityDataFactory, ProfileVersion.moveToNextValue);
                int authRequestContext = Encoding.getAuthRequestContext(MyBillsEntityDataFactory);
                Encoding.MyBillsEntityDataFactory(byteArrayOutputStream, authRequestContext);
                i = i + 4 + 4 + 4 + 2 + (authRequestContext * 1);
                byteArrayOutputStream.write(MyBillsEntityDataFactory.getBytes(StandardCharsets.UTF_8));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i != byteArray.length) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected size ");
                sb.append(i);
                sb.append(", does not match actual size ");
                sb.append(byteArray.length);
                throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            }
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.DEX_FILES, i, byteArray, false);
            byteArrayOutputStream.close();
            return writableFileSection;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static WritableFileSection BuiltInFictitiousFunctionClassFactory(DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        for (int i2 = 0; i2 < dexProfileDataArr.length; i2++) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i2];
                Encoding.MyBillsEntityDataFactory(byteArrayOutputStream, i2);
                Encoding.MyBillsEntityDataFactory(byteArrayOutputStream, dexProfileData.PlaceComponentResult);
                i = i + 2 + 2 + (dexProfileData.PlaceComponentResult * 2);
                BuiltInFictitiousFunctionClassFactory(byteArrayOutputStream, dexProfileData);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i != byteArray.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected size ");
            sb.append(i);
            sb.append(", does not match actual size ");
            sb.append(byteArray.length);
            throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
        }
        WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.CLASSES, i, byteArray, true);
        byteArrayOutputStream.close();
        return writableFileSection;
    }

    private static WritableFileSection KClassImpl$Data$declaredNonStaticMembers$2(DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        for (int i2 = 0; i2 < dexProfileDataArr.length; i2++) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i2];
                Iterator<Map.Entry<Integer, Integer>> it = dexProfileData.scheduleImpl.entrySet().iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    i3 |= it.next().getValue().intValue();
                }
                byte[] BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(dexProfileData);
                byte[] KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(dexProfileData);
                Encoding.MyBillsEntityDataFactory(byteArrayOutputStream, i2);
                int length = BuiltInFictitiousFunctionClassFactory2.length + 2 + KClassImpl$Data$declaredNonStaticMembers$22.length;
                Encoding.BuiltInFictitiousFunctionClassFactory(byteArrayOutputStream, length, 4);
                Encoding.MyBillsEntityDataFactory(byteArrayOutputStream, i3);
                byteArrayOutputStream.write(BuiltInFictitiousFunctionClassFactory2);
                byteArrayOutputStream.write(KClassImpl$Data$declaredNonStaticMembers$22);
                i = i + 2 + 4 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i != byteArray.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected size ");
            sb.append(i);
            sb.append(", does not match actual size ");
            sb.append(byteArray.length);
            throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
        }
        WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.METHODS, i, byteArray, true);
        byteArrayOutputStream.close();
        return writableFileSection;
    }

    private static byte[] BuiltInFictitiousFunctionClassFactory(DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            getAuthRequestContext(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            KClassImpl$Data$declaredNonStaticMembers$2(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] KClassImpl$Data$declaredNonStaticMembers$2(DexProfileData[] dexProfileDataArr, byte[] bArr) throws IOException {
        int i = 0;
        int i2 = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            i2 += Encoding.getAuthRequestContext(MyBillsEntityDataFactory(dexProfileData.BuiltInFictitiousFunctionClassFactory, dexProfileData.MyBillsEntityDataFactory, bArr)) + 16 + (dexProfileData.PlaceComponentResult * 2) + dexProfileData.getErrorConfigVersion + (((((dexProfileData.NetworkUserEntityData$$ExternalSyntheticLambda0 * 2) + 8) - 1) & (-8)) / 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        if (Arrays.equals(bArr, ProfileVersion.PlaceComponentResult)) {
            int length = dexProfileDataArr.length;
            while (i < length) {
                DexProfileData dexProfileData2 = dexProfileDataArr[i];
                PlaceComponentResult(byteArrayOutputStream, dexProfileData2, MyBillsEntityDataFactory(dexProfileData2.BuiltInFictitiousFunctionClassFactory, dexProfileData2.MyBillsEntityDataFactory, bArr));
                KClassImpl$Data$declaredNonStaticMembers$2(byteArrayOutputStream, dexProfileData2);
                BuiltInFictitiousFunctionClassFactory(byteArrayOutputStream, dexProfileData2);
                getAuthRequestContext(byteArrayOutputStream, dexProfileData2);
                i++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                PlaceComponentResult(byteArrayOutputStream, dexProfileData3, MyBillsEntityDataFactory(dexProfileData3.BuiltInFictitiousFunctionClassFactory, dexProfileData3.MyBillsEntityDataFactory, bArr));
            }
            int length2 = dexProfileDataArr.length;
            while (i < length2) {
                DexProfileData dexProfileData4 = dexProfileDataArr[i];
                KClassImpl$Data$declaredNonStaticMembers$2(byteArrayOutputStream, dexProfileData4);
                BuiltInFictitiousFunctionClassFactory(byteArrayOutputStream, dexProfileData4);
                getAuthRequestContext(byteArrayOutputStream, dexProfileData4);
                i++;
            }
        }
        if (byteArrayOutputStream.size() != i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("The bytes saved do not match expectation. actual=");
            sb.append(byteArrayOutputStream.size());
            sb.append(" expected=");
            sb.append(i2);
            throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static void PlaceComponentResult(OutputStream outputStream, DexProfileData dexProfileData, String str) throws IOException {
        Encoding.MyBillsEntityDataFactory(outputStream, Encoding.getAuthRequestContext(str));
        Encoding.MyBillsEntityDataFactory(outputStream, dexProfileData.PlaceComponentResult);
        Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, dexProfileData.getErrorConfigVersion, 4);
        Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, dexProfileData.KClassImpl$Data$declaredNonStaticMembers$2, 4);
        Encoding.BuiltInFictitiousFunctionClassFactory(outputStream, dexProfileData.NetworkUserEntityData$$ExternalSyntheticLambda0, 4);
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : dexProfileData.scheduleImpl.entrySet()) {
            int intValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                Encoding.MyBillsEntityDataFactory(outputStream, intValue - i);
                Encoding.MyBillsEntityDataFactory(outputStream, 0);
                i = intValue;
            }
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        int i = 0;
        for (int i2 : dexProfileData.getAuthRequestContext) {
            Integer valueOf = Integer.valueOf(i2);
            Encoding.MyBillsEntityDataFactory(outputStream, valueOf.intValue() - i);
            i = valueOf.intValue();
        }
    }

    private static void getAuthRequestContext(OutputStream outputStream, DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[((((dexProfileData.NetworkUserEntityData$$ExternalSyntheticLambda0 * 2) + 8) - 1) & (-8)) / 8];
        for (Map.Entry<Integer, Integer> entry : dexProfileData.scheduleImpl.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            if ((intValue2 & 2) != 0) {
                int BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(2, intValue, dexProfileData.NetworkUserEntityData$$ExternalSyntheticLambda0);
                int i = BuiltInFictitiousFunctionClassFactory2 / 8;
                bArr[i] = (byte) ((1 << (BuiltInFictitiousFunctionClassFactory2 % 8)) | bArr[i]);
            }
            if ((intValue2 & 4) != 0) {
                int BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(4, intValue, dexProfileData.NetworkUserEntityData$$ExternalSyntheticLambda0);
                int i2 = BuiltInFictitiousFunctionClassFactory3 / 8;
                bArr[i2] = (byte) ((1 << (BuiltInFictitiousFunctionClassFactory3 % 8)) | bArr[i2]);
            }
        }
        outputStream.write(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DexProfileData[] MyBillsEntityDataFactory(InputStream inputStream, byte[] bArr, String str) throws IOException {
        DexProfileData[] dexProfileDataArr;
        if (!Arrays.equals(bArr, ProfileVersion.lookAheadTest)) {
            throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Unsupported version");
        }
        int authRequestContext = Encoding.getAuthRequestContext(inputStream);
        byte[] authRequestContext2 = Encoding.getAuthRequestContext(inputStream, (int) Encoding.PlaceComponentResult(inputStream), (int) Encoding.PlaceComponentResult(inputStream));
        if (inputStream.read() > 0) {
            throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(authRequestContext2);
        try {
            if (byteArrayInputStream.available() == 0) {
                dexProfileDataArr = new DexProfileData[0];
            } else {
                DexProfileData[] dexProfileDataArr2 = new DexProfileData[authRequestContext];
                for (int i = 0; i < authRequestContext; i++) {
                    int KClassImpl$Data$declaredNonStaticMembers$22 = Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream);
                    int KClassImpl$Data$declaredNonStaticMembers$23 = Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream);
                    dexProfileDataArr2[i] = new DexProfileData(str, Encoding.PlaceComponentResult(byteArrayInputStream, KClassImpl$Data$declaredNonStaticMembers$22), Encoding.PlaceComponentResult(byteArrayInputStream), KClassImpl$Data$declaredNonStaticMembers$23, (int) Encoding.PlaceComponentResult(byteArrayInputStream), (int) Encoding.PlaceComponentResult(byteArrayInputStream), new int[KClassImpl$Data$declaredNonStaticMembers$23], new TreeMap());
                }
                for (int i2 = 0; i2 < authRequestContext; i2++) {
                    DexProfileData dexProfileData = dexProfileDataArr2[i2];
                    int available = byteArrayInputStream.available() - dexProfileData.getErrorConfigVersion;
                    int i3 = 0;
                    while (byteArrayInputStream.available() > available) {
                        i3 += Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream);
                        dexProfileData.scheduleImpl.put(Integer.valueOf(i3), 1);
                        for (int KClassImpl$Data$declaredNonStaticMembers$24 = Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream); KClassImpl$Data$declaredNonStaticMembers$24 > 0; KClassImpl$Data$declaredNonStaticMembers$24--) {
                            Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream);
                            int authRequestContext3 = Encoding.getAuthRequestContext(byteArrayInputStream);
                            if (authRequestContext3 != 6 && authRequestContext3 != 7) {
                                while (authRequestContext3 > 0) {
                                    Encoding.getAuthRequestContext(byteArrayInputStream);
                                    for (int authRequestContext4 = Encoding.getAuthRequestContext(byteArrayInputStream); authRequestContext4 > 0; authRequestContext4--) {
                                        Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream);
                                    }
                                    authRequestContext3--;
                                }
                            }
                        }
                    }
                    if (byteArrayInputStream.available() == available) {
                        dexProfileData.getAuthRequestContext = PlaceComponentResult(byteArrayInputStream, dexProfileData.PlaceComponentResult);
                        BitSet valueOf = BitSet.valueOf(Encoding.BuiltInFictitiousFunctionClassFactory(byteArrayInputStream, Encoding.BuiltInFictitiousFunctionClassFactory(dexProfileData.NetworkUserEntityData$$ExternalSyntheticLambda0 * 2)));
                        for (int i4 = 0; i4 < dexProfileData.NetworkUserEntityData$$ExternalSyntheticLambda0; i4++) {
                            int i5 = dexProfileData.NetworkUserEntityData$$ExternalSyntheticLambda0;
                            int i6 = !valueOf.get(BuiltInFictitiousFunctionClassFactory(2, i4, i5)) ? 0 : 2;
                            if (valueOf.get(BuiltInFictitiousFunctionClassFactory(4, i4, i5))) {
                                i6 |= 4;
                            }
                            if (i6 != 0) {
                                Integer num = dexProfileData.scheduleImpl.get(Integer.valueOf(i4));
                                if (num == null) {
                                    num = 0;
                                }
                                dexProfileData.scheduleImpl.put(Integer.valueOf(i4), Integer.valueOf(num.intValue() | i6));
                            }
                        }
                    } else {
                        throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Read too much data during profile line parse");
                    }
                }
                dexProfileDataArr = dexProfileDataArr2;
            }
            byteArrayInputStream.close();
            return dexProfileDataArr;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DexProfileData[] BuiltInFictitiousFunctionClassFactory(InputStream inputStream, byte[] bArr, byte[] bArr2, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.KClassImpl$Data$declaredNonStaticMembers$2)) {
            if (Arrays.equals(ProfileVersion.moveToNextValue, bArr2)) {
                throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return BuiltInFictitiousFunctionClassFactory(inputStream, bArr, dexProfileDataArr);
        } else if (Arrays.equals(bArr, ProfileVersion.MyBillsEntityDataFactory)) {
            return KClassImpl$Data$declaredNonStaticMembers$2(inputStream, bArr2, dexProfileDataArr);
        } else {
            throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Unsupported meta version");
        }
    }

    private static DexProfileData[] BuiltInFictitiousFunctionClassFactory(InputStream inputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        if (!Arrays.equals(bArr, ProfileVersion.KClassImpl$Data$declaredNonStaticMembers$2)) {
            throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Unsupported meta version");
        }
        int authRequestContext = Encoding.getAuthRequestContext(inputStream);
        byte[] authRequestContext2 = Encoding.getAuthRequestContext(inputStream, (int) Encoding.PlaceComponentResult(inputStream), (int) Encoding.PlaceComponentResult(inputStream));
        if (inputStream.read() > 0) {
            throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(authRequestContext2);
        try {
            if (byteArrayInputStream.available() == 0) {
                dexProfileDataArr = new DexProfileData[0];
            } else if (authRequestContext != dexProfileDataArr.length) {
                throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Mismatched number of dex files found in metadata");
            } else {
                String[] strArr = new String[authRequestContext];
                int[] iArr = new int[authRequestContext];
                for (int i = 0; i < authRequestContext; i++) {
                    int KClassImpl$Data$declaredNonStaticMembers$22 = Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream);
                    iArr[i] = Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream);
                    strArr[i] = Encoding.PlaceComponentResult(byteArrayInputStream, KClassImpl$Data$declaredNonStaticMembers$22);
                }
                for (int i2 = 0; i2 < authRequestContext; i2++) {
                    DexProfileData dexProfileData = dexProfileDataArr[i2];
                    if (!dexProfileData.MyBillsEntityDataFactory.equals(strArr[i2])) {
                        throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Order of dexfiles in metadata did not match baseline");
                    }
                    dexProfileData.PlaceComponentResult = iArr[i2];
                    dexProfileData.getAuthRequestContext = PlaceComponentResult(byteArrayInputStream, dexProfileData.PlaceComponentResult);
                }
            }
            byteArrayInputStream.close();
            return dexProfileDataArr;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static DexProfileData[] KClassImpl$Data$declaredNonStaticMembers$2(InputStream inputStream, byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        DexProfileData dexProfileData;
        int KClassImpl$Data$declaredNonStaticMembers$22 = Encoding.KClassImpl$Data$declaredNonStaticMembers$2(inputStream);
        byte[] authRequestContext = Encoding.getAuthRequestContext(inputStream, (int) Encoding.PlaceComponentResult(inputStream), (int) Encoding.PlaceComponentResult(inputStream));
        if (inputStream.read() > 0) {
            throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(authRequestContext);
        try {
            if (byteArrayInputStream.available() == 0) {
                dexProfileDataArr = new DexProfileData[0];
            } else if (KClassImpl$Data$declaredNonStaticMembers$22 != dexProfileDataArr.length) {
                throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("Mismatched number of dex files found in metadata");
            } else {
                for (int i = 0; i < KClassImpl$Data$declaredNonStaticMembers$22; i++) {
                    Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream);
                    String PlaceComponentResult = Encoding.PlaceComponentResult(byteArrayInputStream, Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream));
                    long PlaceComponentResult2 = Encoding.PlaceComponentResult(byteArrayInputStream);
                    int KClassImpl$Data$declaredNonStaticMembers$23 = Encoding.KClassImpl$Data$declaredNonStaticMembers$2(byteArrayInputStream);
                    if (dexProfileDataArr.length > 0) {
                        int indexOf = PlaceComponentResult.indexOf("!");
                        if (indexOf < 0) {
                            indexOf = PlaceComponentResult.indexOf(":");
                        }
                        String substring = indexOf > 0 ? PlaceComponentResult.substring(indexOf + 1) : PlaceComponentResult;
                        for (int i2 = 0; i2 < dexProfileDataArr.length; i2++) {
                            if (dexProfileDataArr[i2].MyBillsEntityDataFactory.equals(substring)) {
                                dexProfileData = dexProfileDataArr[i2];
                                break;
                            }
                        }
                    }
                    dexProfileData = null;
                    if (dexProfileData == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Missing profile key: ");
                        sb.append(PlaceComponentResult);
                        throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
                    }
                    dexProfileData.moveToNextValue = PlaceComponentResult2;
                    int[] PlaceComponentResult3 = PlaceComponentResult(byteArrayInputStream, KClassImpl$Data$declaredNonStaticMembers$23);
                    if (Arrays.equals(bArr, ProfileVersion.BuiltInFictitiousFunctionClassFactory)) {
                        dexProfileData.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$23;
                        dexProfileData.getAuthRequestContext = PlaceComponentResult3;
                    }
                }
            }
            byteArrayInputStream.close();
            return dexProfileDataArr;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static String MyBillsEntityDataFactory(String str, String str2, byte[] bArr) {
        String KClassImpl$Data$declaredNonStaticMembers$22 = ProfileVersion.KClassImpl$Data$declaredNonStaticMembers$2(bArr);
        if (str.length() <= 0) {
            return getAuthRequestContext(str2, KClassImpl$Data$declaredNonStaticMembers$22);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return getAuthRequestContext(str2, KClassImpl$Data$declaredNonStaticMembers$22);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(ProfileVersion.KClassImpl$Data$declaredNonStaticMembers$2(bArr));
        sb.append(str2);
        return sb.toString();
    }

    private static String getAuthRequestContext(String str, String str2) {
        if ("!".equals(str2)) {
            return str.replace(":", "!");
        }
        return ":".equals(str2) ? str.replace("!", ":") : str;
    }

    private static int[] PlaceComponentResult(InputStream inputStream, int i) throws IOException {
        int[] iArr = new int[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += Encoding.KClassImpl$Data$declaredNonStaticMembers$2(inputStream);
            iArr[i3] = i2;
        }
        return iArr;
    }

    private static int BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3) {
        if (i != 1) {
            if (i != 2) {
                if (i == 4) {
                    return i2 + i3;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected flag: ");
                sb.append(i);
                throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            }
            return i2;
        }
        throw Encoding.KClassImpl$Data$declaredNonStaticMembers$2("HOT methods are not stored in the bitmap");
    }
}
