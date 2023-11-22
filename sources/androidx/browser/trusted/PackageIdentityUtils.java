package androidx.browser.trusted;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class PackageIdentityUtils {

    /* loaded from: classes6.dex */
    interface SignaturesCompat {
        boolean PlaceComponentResult(String str, PackageManager packageManager, TokenContents tokenContents) throws IOException, PackageManager.NameNotFoundException;
    }

    private PackageIdentityUtils() {
    }

    /* loaded from: classes6.dex */
    static class Api28Implementation implements SignaturesCompat {
        Api28Implementation() {
        }

        public List<byte[]> MyBillsEntityDataFactory(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
            ArrayList arrayList = new ArrayList();
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (signingInfo.hasMultipleSigners()) {
                for (Signature signature : signingInfo.getApkContentsSigners()) {
                    arrayList.add(PackageIdentityUtils.BuiltInFictitiousFunctionClassFactory(signature));
                }
            } else {
                arrayList.add(PackageIdentityUtils.BuiltInFictitiousFunctionClassFactory(signingInfo.getSigningCertificateHistory()[0]));
            }
            return arrayList;
        }

        @Override // androidx.browser.trusted.PackageIdentityUtils.SignaturesCompat
        public boolean PlaceComponentResult(String str, PackageManager packageManager, TokenContents tokenContents) throws PackageManager.NameNotFoundException, IOException {
            List<byte[]> MyBillsEntityDataFactory;
            tokenContents.getAuthRequestContext();
            String str2 = tokenContents.MyBillsEntityDataFactory;
            if (str2 != null) {
                if (str2.equals(str) && (MyBillsEntityDataFactory = MyBillsEntityDataFactory(str, packageManager)) != null) {
                    if (MyBillsEntityDataFactory.size() == 1) {
                        return packageManager.hasSigningCertificate(str, tokenContents.BuiltInFictitiousFunctionClassFactory(), 1);
                    }
                    return tokenContents.equals(TokenContents.MyBillsEntityDataFactory(str, MyBillsEntityDataFactory));
                }
                return false;
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes6.dex */
    static class Pre28Implementation implements SignaturesCompat {
        Pre28Implementation() {
        }

        @Override // androidx.browser.trusted.PackageIdentityUtils.SignaturesCompat
        public boolean PlaceComponentResult(String str, PackageManager packageManager, TokenContents tokenContents) throws IOException, PackageManager.NameNotFoundException {
            tokenContents.getAuthRequestContext();
            String str2 = tokenContents.MyBillsEntityDataFactory;
            if (str2 != null) {
                if (str.equals(str2)) {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
                    ArrayList arrayList = new ArrayList(packageInfo.signatures.length);
                    Signature[] signatureArr = packageInfo.signatures;
                    int length = signatureArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        byte[] BuiltInFictitiousFunctionClassFactory = PackageIdentityUtils.BuiltInFictitiousFunctionClassFactory(signatureArr[i]);
                        if (BuiltInFictitiousFunctionClassFactory == null) {
                            arrayList = null;
                            break;
                        }
                        arrayList.add(BuiltInFictitiousFunctionClassFactory);
                        i++;
                    }
                    if (arrayList == null) {
                        return false;
                    }
                    return tokenContents.equals(TokenContents.MyBillsEntityDataFactory(str, arrayList));
                }
                return false;
            }
            throw new IllegalStateException();
        }
    }

    static byte[] BuiltInFictitiousFunctionClassFactory(Signature signature) {
        try {
            return MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getAuthRequestContext(String str, PackageManager packageManager, TokenContents tokenContents) {
        SignaturesCompat pre28Implementation;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                pre28Implementation = new Api28Implementation();
            } else {
                pre28Implementation = new Pre28Implementation();
            }
            return pre28Implementation.PlaceComponentResult(str, packageManager, tokenContents);
        } catch (PackageManager.NameNotFoundException | IOException e) {
            InstrumentInjector.log_e("PackageIdentity", "Could not check if package matches token.", e);
            return false;
        }
    }
}
