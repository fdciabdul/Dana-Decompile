package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.graphics.Color;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ConfigStorageClient {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static final String JSON_STRING_ENCODING;
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Map<String, ConfigStorageClient> clientInstances;
    private static int[] getAuthRequestContext;
    private final Context context;
    private final String fileName;

    static void PlaceComponentResult() {
        getAuthRequestContext = new int[]{-107344192, 1033917263, 39247165, -1109129615, 414267897, -1135648993, 1815093406, 2102431415, -763172710, 1629700908, -554984739, -135457165, -889606286, 7166078, 1041271517, 1429757022, 1613961639, 1758208702};
    }

    static {
        PlaceComponentResult();
        Object[] objArr = new Object[1];
        a(Color.red(0) + 5, new int[]{1881620565, 1189332847, 484418775, -716119701}, objArr);
        JSON_STRING_ENCODING = ((String) objArr[0]).intern();
        clientInstances = new HashMap();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
    }

    private ConfigStorageClient(Context context, String str) {
        this.context = context;
        this.fileName = str;
    }

    public Void write(ConfigContainer configContainer) throws IOException {
        synchronized (this) {
            FileOutputStream openFileOutput = this.context.openFileOutput(this.fileName, 0);
            try {
                String obj = configContainer.toString();
                Object[] objArr = new Object[1];
                a(AndroidCharacter.getMirror('0') - '+', new int[]{1881620565, 1189332847, 484418775, -716119701}, objArr);
                openFileOutput.write(obj.getBytes(((String) objArr[0]).intern()));
            } finally {
                openFileOutput.close();
            }
        }
        return null;
    }

    @Nullable
    public ConfigContainer read() throws IOException {
        FileInputStream fileInputStream;
        synchronized (this) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = this.context.openFileInput(this.fileName);
                try {
                    int available = fileInputStream.available();
                    byte[] bArr = new byte[available];
                    fileInputStream.read(bArr, 0, available);
                    Object[] objArr = new Object[1];
                    a(5 - TextUtils.indexOf("", ""), new int[]{1881620565, 1189332847, 484418775, -716119701}, objArr);
                    ConfigContainer copyOf = ConfigContainer.copyOf(new JSONObject(new String(bArr, ((String) objArr[0]).intern())));
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return copyOf;
                } catch (FileNotFoundException | JSONException unused) {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException | JSONException unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public Void clear() {
        synchronized (this) {
            this.context.deleteFile(this.fileName);
        }
        return null;
    }

    public static ConfigStorageClient getInstance(Context context, String str) {
        ConfigStorageClient configStorageClient;
        synchronized (ConfigStorageClient.class) {
            Map<String, ConfigStorageClient> map = clientInstances;
            if (!map.containsKey(str)) {
                map.put(str, new ConfigStorageClient(context, str));
            }
            configStorageClient = map.get(str);
        }
        return configStorageClient;
    }

    public static void clearInstancesForTest() {
        synchronized (ConfigStorageClient.class) {
            clientInstances.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getFileName() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? 'H' : '+') != 'H') {
            return this.fileName;
        }
        int i2 = 22 / 0;
        return this.fileName;
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int length;
        int[] iArr2;
        int i2;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr3 = getAuthRequestContext;
        if (iArr3 != null) {
            int i3 = $10 + 61;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            int length2 = iArr3.length;
            int[] iArr4 = new int[length2];
            int i5 = 0;
            while (i5 < length2) {
                iArr4[i5] = (int) (iArr3[i5] ^ (-3152031022165484798L));
                i5++;
                int i6 = $10 + 89;
                $11 = i6 % 128;
                int i7 = i6 % 2;
            }
            iArr3 = iArr4;
        }
        int length3 = iArr3.length;
        int[] iArr5 = new int[length3];
        int[] iArr6 = getAuthRequestContext;
        if (iArr6 != null) {
            try {
                int i8 = $10 + 91;
                try {
                    $11 = i8 % 128;
                    if (i8 % 2 == 0) {
                        length = iArr6.length;
                        iArr2 = new int[length];
                        i2 = 1;
                    } else {
                        length = iArr6.length;
                        iArr2 = new int[length];
                        i2 = 0;
                    }
                    while (i2 < length) {
                        iArr2[i2] = (int) (iArr6[i2] ^ (-3152031022165484798L));
                        i2++;
                        length = length;
                    }
                    iArr6 = iArr2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        System.arraycopy(iArr6, 0, iArr5, 0, length3);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length ? 'a' : 'F') == 'F') {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
            int i9 = $11 + 23;
            $10 = i9 % 128;
            int i10 = i9 % 2;
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
            int i11 = 0;
            while (true) {
                if (!(i11 < 16)) {
                    break;
                }
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[i11];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
                i11++;
            }
            int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i13;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr5[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr5[17];
            int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i15 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr5);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
    }
}
