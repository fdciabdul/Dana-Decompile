package io.branch.indexing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes6.dex */
class HashHelper {
    MessageDigest MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashHelper() {
        try {
            this.MyBillsEntityDataFactory = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String BuiltInFictitiousFunctionClassFactory(String str) {
        MessageDigest messageDigest = this.MyBillsEntityDataFactory;
        if (messageDigest != null) {
            messageDigest.reset();
            this.MyBillsEntityDataFactory.update(str.getBytes());
            return new String(this.MyBillsEntityDataFactory.digest());
        }
        return "";
    }
}
