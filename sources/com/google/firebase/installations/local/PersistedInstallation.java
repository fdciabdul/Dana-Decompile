package com.google.firebase.installations.local;

import android.graphics.Color;
import android.media.AudioTrack;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import o.B;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PersistedInstallation {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final String AUTH_TOKEN_KEY = "AuthToken";
    private static final String EXPIRES_IN_SECONDS_KEY = "ExpiresInSecs";
    private static final String FIREBASE_INSTALLATION_ID_KEY = "Fid";
    private static final String FIS_ERROR_KEY = "FisError";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1546325351;
    private static short[] MyBillsEntityDataFactory = null;
    private static final String PERSISTED_STATUS_KEY = "Status";
    private static int PlaceComponentResult = 1257195692;
    private static final String REFRESH_TOKEN_KEY = "RefreshToken";
    private static final String SETTINGS_FILE_NAME_PREFIX = "PersistedInstallation";
    private static final String TOKEN_CREATION_TIME_IN_SECONDS_KEY = "TokenCreationEpochInSecs";
    private static int moveToNextValue = 0;
    private static int scheduleImpl = 1;
    private File dataFile;
    private final FirebaseApp firebaseApp;
    private static byte[] getAuthRequestContext = {77, 34, -50, -37, -42};
    private static int BuiltInFictitiousFunctionClassFactory = -1041647573;

    /* loaded from: classes3.dex */
    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
    }

    private File getDataFile() {
        if (this.dataFile == null) {
            synchronized (this) {
                if (this.dataFile == null) {
                    File filesDir = this.firebaseApp.getApplicationContext().getFilesDir();
                    StringBuilder sb = new StringBuilder();
                    sb.append("PersistedInstallation.");
                    sb.append(this.firebaseApp.getPersistenceKey());
                    sb.append(".json");
                    this.dataFile = new File(filesDir, sb.toString());
                }
            }
        }
        return this.dataFile;
    }

    public PersistedInstallationEntry readPersistedInstallationEntryValue() {
        try {
            int i = moveToNextValue + 37;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            JSONObject readJSONFromFile = readJSONFromFile();
            String optString = readJSONFromFile.optString(FIREBASE_INSTALLATION_ID_KEY, null);
            int optInt = readJSONFromFile.optInt("Status", RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
            String optString2 = readJSONFromFile.optString(AUTH_TOKEN_KEY, null);
            String optString3 = readJSONFromFile.optString(REFRESH_TOKEN_KEY, null);
            long optLong = readJSONFromFile.optLong(TOKEN_CREATION_TIME_IN_SECONDS_KEY, 0L);
            PersistedInstallationEntry build = PersistedInstallationEntry.builder().setFirebaseInstallationId(optString).setRegistrationStatus(RegistrationStatus.values()[optInt]).setAuthToken(optString2).setRefreshToken(optString3).setTokenCreationEpochInSecs(optLong).setExpiresInSecs(readJSONFromFile.optLong(EXPIRES_IN_SECONDS_KEY, 0L)).setFisError(readJSONFromFile.optString(FIS_ERROR_KEY, null)).build();
            int i3 = scheduleImpl + 77;
            moveToNextValue = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 14 / 0;
                return build;
            }
            return build;
        } catch (Exception e) {
            throw e;
        }
    }

    private JSONObject readJSONFromFile() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(getDataFile());
            try {
                int i = scheduleImpl + 113;
                try {
                    moveToNextValue = i % 128;
                    int i2 = i % 2;
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr, 0, 16384);
                            if (read >= 0) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                                fileInputStream.close();
                                return jSONObject;
                            }
                        } finally {
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } catch (IOException | JSONException unused) {
            return new JSONObject();
        }
    }

    public PersistedInstallationEntry insertOrUpdatePersistedInstallationEntry(PersistedInstallationEntry persistedInstallationEntry) {
        File createTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(FIREBASE_INSTALLATION_ID_KEY, persistedInstallationEntry.getFirebaseInstallationId());
            jSONObject.put("Status", persistedInstallationEntry.getRegistrationStatus().ordinal());
            jSONObject.put(AUTH_TOKEN_KEY, persistedInstallationEntry.getAuthToken());
            jSONObject.put(REFRESH_TOKEN_KEY, persistedInstallationEntry.getRefreshToken());
            jSONObject.put(TOKEN_CREATION_TIME_IN_SECONDS_KEY, persistedInstallationEntry.getTokenCreationEpochInSecs());
            jSONObject.put(EXPIRES_IN_SECONDS_KEY, persistedInstallationEntry.getExpiresInSecs());
            jSONObject.put(FIS_ERROR_KEY, persistedInstallationEntry.getFisError());
            try {
                createTempFile = File.createTempFile(SETTINGS_FILE_NAME_PREFIX, "tmp", this.firebaseApp.getApplicationContext().getFilesDir());
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                String jSONObject2 = jSONObject.toString();
                Object[] objArr = new Object[1];
                a(1962479436 - Color.blue(0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 53, (short) (ViewConfiguration.getMinimumFlingVelocity() >> 16), (-381961635) - TextUtils.indexOf("", "", 0), (byte) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) - 74), objArr);
                fileOutputStream.write(jSONObject2.getBytes(((String) objArr[0]).intern()));
                fileOutputStream.close();
            } catch (IOException | JSONException unused) {
            }
        } catch (IOException | JSONException unused2) {
        }
        if (!createTempFile.renameTo(getDataFile())) {
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        }
        int i = scheduleImpl + 61;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        return persistedInstallationEntry;
    }

    public void clearForTesting() {
        int i = scheduleImpl + 33;
        moveToNextValue = i % 128;
        int i2 = i % 2;
        getDataFile().delete();
        try {
            int i3 = scheduleImpl + 19;
            moveToNextValue = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        boolean z;
        int length;
        byte[] bArr;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (PlaceComponentResult ^ 3097486228508854431L));
        boolean z2 = i4 == -1;
        if (z2) {
            byte[] bArr2 = getAuthRequestContext;
            if ((bArr2 != null ? '\'' : (char) 1) != 1) {
                int length2 = bArr2.length;
                byte[] bArr3 = new byte[length2];
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        break;
                    }
                    bArr3[i5] = (byte) (bArr2[i5] ^ 3097486228508854431L);
                    i5++;
                }
                bArr2 = bArr3;
            }
            if ((bArr2 != null ? '\r' : '4') != '4') {
                int i6 = $11 + 93;
                $10 = i6 % 128;
                i4 = (byte) (i6 % 2 != 0 ? ((byte) (getAuthRequestContext[i % ((int) (BuiltInFictitiousFunctionClassFactory * 3097486228508854431L))] - 3097486228508854431L)) >> ((int) (PlaceComponentResult ^ 3097486228508854431L)) : ((byte) (getAuthRequestContext[i + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (MyBillsEntityDataFactory[i + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (PlaceComponentResult ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            try {
                b2.getAuthRequestContext = ((i + i4) - 2) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)) + (!(z2) ? 0 : 1);
                try {
                    b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)));
                    sb.append(b2.MyBillsEntityDataFactory);
                    b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                    byte[] bArr4 = getAuthRequestContext;
                    if (bArr4 != null) {
                        int i7 = $10 + 57;
                        $11 = i7 % 128;
                        if (i7 % 2 == 0) {
                            length = bArr4.length;
                            bArr = new byte[length];
                        } else {
                            length = bArr4.length;
                            bArr = new byte[length];
                        }
                        int i8 = 0;
                        while (true) {
                            if ((i8 < length ? 'H' : '%') == '%') {
                                break;
                            }
                            int i9 = $11 + 33;
                            $10 = i9 % 128;
                            int i10 = i9 % 2;
                            bArr[i8] = (byte) (bArr4[i8] ^ 3097486228508854431L);
                            i8++;
                        }
                        bArr4 = bArr;
                    }
                    if (bArr4 != null) {
                        int i11 = $11 + 25;
                        $10 = i11 % 128;
                        int i12 = i11 % 2;
                        z = true;
                    } else {
                        z = false;
                    }
                    b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                    while (true) {
                        if (b2.KClassImpl$Data$declaredNonStaticMembers$2 >= i4) {
                            break;
                        }
                        if (z) {
                            byte[] bArr5 = getAuthRequestContext;
                            b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                            b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                        } else {
                            short[] sArr = MyBillsEntityDataFactory;
                            b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                            b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                        }
                        sb.append(b2.MyBillsEntityDataFactory);
                        b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                        b2.KClassImpl$Data$declaredNonStaticMembers$2++;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        String sb2 = sb.toString();
        int i13 = $11 + 59;
        $10 = i13 % 128;
        int i14 = i13 % 2;
        objArr[0] = sb2;
    }
}
