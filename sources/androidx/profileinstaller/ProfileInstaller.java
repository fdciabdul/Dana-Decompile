package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.credentials.CredentialManager$$ExternalSyntheticLambda0;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public class ProfileInstaller {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {11, -83, -14, 91, 15, -8, 16, -1, -4, -3, -52, TarHeader.LF_CONTIG, 14, 1, 8, -13, 11, 8, -68, Ascii.ETB, 46, 1, 8, -13, Ascii.NAK, -2, -2, 8, -1, -13, 4, -31, 39, 11, 0, 17, -49, TarHeader.LF_LINK, 2, -2, -1, -4, 0, Ascii.NAK, -9, 8, 1, -35, 39, -6, 11, 15, -8, 16, -1, -4, -3, -52, TarHeader.LF_CONTIG, 14, 1, 8, -13, 11, 8, -68, 68, -1, -61, Ascii.NAK, TarHeader.LF_LINK, 2, -2, -1, -4, 0, Ascii.NAK, -9, 8, 1, -35, 39, -6, 11};
    public static final int getAuthRequestContext = 131;
    private static final DiagnosticsCallback PlaceComponentResult = new DiagnosticsCallback() { // from class: androidx.profileinstaller.ProfileInstaller.1
        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, Object obj) {
        }
    };
    static final DiagnosticsCallback KClassImpl$Data$declaredNonStaticMembers$2 = new DiagnosticsCallback() { // from class: androidx.profileinstaller.ProfileInstaller.2
        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, Object obj) {
            InstrumentInjector.log_d("ProfileInstaller", i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
            String str;
            switch (i) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = "";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i == 6 || i == 7 || i == 8) {
                InstrumentInjector.log_e("ProfileInstaller", str, (Throwable) obj);
            } else {
                InstrumentInjector.log_d("ProfileInstaller", str);
            }
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface DiagnosticCode {
    }

    /* loaded from: classes6.dex */
    public interface DiagnosticsCallback {
        void BuiltInFictitiousFunctionClassFactory(int i, Object obj);

        void KClassImpl$Data$declaredNonStaticMembers$2(int i, Object obj);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ResultCode {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = androidx.profileinstaller.ProfileInstaller.BuiltInFictitiousFunctionClassFactory
            int r9 = r9 + 9
            int r7 = r7 * 6
            int r7 = 115 - r7
            int r8 = r8 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L15:
            r3 = 0
        L16:
            r6 = r9
            r9 = r7
            r7 = r6
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L31:
            int r10 = r10 + r7
            int r7 = r10 + (-2)
            int r8 = r8 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.ProfileInstaller.a(byte, short, int, java.lang.Object[]):void");
    }

    private ProfileInstaller() {
    }

    private static boolean MyBillsEntityDataFactory(PackageInfo packageInfo, File file, DiagnosticsCallback diagnosticsCallback) {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (file2.exists()) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
                try {
                    long readLong = dataInputStream.readLong();
                    dataInputStream.close();
                    boolean z = readLong == packageInfo.lastUpdateTime;
                    if (z) {
                        diagnosticsCallback.BuiltInFictitiousFunctionClassFactory(2, null);
                    }
                    return z;
                } finally {
                }
            } catch (IOException unused) {
                return false;
            }
        }
        return false;
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        if (Build.VERSION.SDK_INT >= 19) {
            DeviceProfileWriter deviceProfileWriter = new DeviceProfileWriter(assetManager, executor, diagnosticsCallback, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
            if (deviceProfileWriter.BuiltInFictitiousFunctionClassFactory() && deviceProfileWriter.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult()) {
                KClassImpl$Data$declaredNonStaticMembers$2(packageInfo, file);
                return;
            }
            return;
        }
        executor.execute(new ProfileInstaller$$ExternalSyntheticLambda0(diagnosticsCallback, 3, null));
    }

    public static void PlaceComponentResult(Context context) {
        KClassImpl$Data$declaredNonStaticMembers$2(context, new CredentialManager$$ExternalSyntheticLambda0(), PlaceComponentResult, false);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback, boolean z) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        try {
            Object[] objArr = new Object[1];
            a((byte) (-BuiltInFictitiousFunctionClassFactory[9]), BuiltInFictitiousFunctionClassFactory[34], BuiltInFictitiousFunctionClassFactory[12], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = BuiltInFictitiousFunctionClassFactory[38];
            Object[] objArr2 = new Object[1];
            a(b, (byte) (b | Ascii.FS), (byte) (-BuiltInFictitiousFunctionClassFactory[44]), objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(applicationContext, null);
            AssetManager assets = applicationContext.getAssets();
            byte b2 = (byte) (-BuiltInFictitiousFunctionClassFactory[9]);
            Object[] objArr3 = new Object[1];
            a(b2, (byte) (b2 | 44), 25, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            byte b3 = BuiltInFictitiousFunctionClassFactory[34];
            Object[] objArr4 = new Object[1];
            a(b3, (byte) (b3 | 22), r8[34], objArr4);
            String name = new File((String) cls2.getField((String) objArr4[0]).get(invoke)).getName();
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                File filesDir = context.getFilesDir();
                if (z || !MyBillsEntityDataFactory(packageInfo, filesDir, diagnosticsCallback)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Installing profile for ");
                    sb.append(context.getPackageName());
                    InstrumentInjector.log_d("ProfileInstaller", sb.toString());
                    KClassImpl$Data$declaredNonStaticMembers$2(assets, packageName, packageInfo, filesDir, name, executor, diagnosticsCallback);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Skipping profile installation for ");
                sb2.append(context.getPackageName());
                InstrumentInjector.log_d("ProfileInstaller", sb2.toString());
            } catch (PackageManager.NameNotFoundException e) {
                diagnosticsCallback.BuiltInFictitiousFunctionClassFactory(7, e);
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    public static void getAuthRequestContext(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        try {
            KClassImpl$Data$declaredNonStaticMembers$2(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            executor.execute(new ProfileInstaller$$ExternalSyntheticLambda0(diagnosticsCallback, 10, null));
        } catch (PackageManager.NameNotFoundException e) {
            executor.execute(new ProfileInstaller$$ExternalSyntheticLambda0(diagnosticsCallback, 7, e));
        }
    }

    public static void MyBillsEntityDataFactory(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        KClassImpl$Data$declaredNonStaticMembers$2(context.getFilesDir());
        executor.execute(new ProfileInstaller$$ExternalSyntheticLambda0(diagnosticsCallback, 11, null));
    }
}
