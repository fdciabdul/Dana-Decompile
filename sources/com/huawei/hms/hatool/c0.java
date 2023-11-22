package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;
import java.io.IOException;

/* loaded from: classes8.dex */
public class c0 {
    public String BuiltInFictitiousFunctionClassFactory = b.lookAheadTest().getFilesDir().getPath();

    private void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        File file = new File(MyBillsEntityDataFactory(str));
        String MyBillsEntityDataFactory = MyBillsEntityDataFactory(str);
        StringBuilder sb = new StringBuilder();
        sb.append("hianalytics_");
        sb.append(str);
        File file2 = new File(MyBillsEntityDataFactory, sb.toString());
        if (!file.exists() && file.mkdirs()) {
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "file directory is mkdirs");
        }
        if (getAuthRequestContext(file2)) {
            t0.PlaceComponentResult(file2, str2);
        } else {
            y.moveToNextValue("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    private static char[] BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3, String str4) {
        byte[] authRequestContext = HexUtil.getAuthRequestContext(str);
        byte[] authRequestContext2 = HexUtil.getAuthRequestContext(str2);
        byte[] authRequestContext3 = HexUtil.getAuthRequestContext(str3);
        byte[] authRequestContext4 = HexUtil.getAuthRequestContext(str4);
        int length = authRequestContext.length;
        if (length > authRequestContext2.length) {
            length = authRequestContext2.length;
        }
        if (length > authRequestContext3.length) {
            length = authRequestContext3.length;
        }
        if (length > authRequestContext4.length) {
            length = authRequestContext4.length;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (((authRequestContext[i] ^ authRequestContext2[i]) ^ authRequestContext3[i]) ^ authRequestContext4[i]);
        }
        return cArr;
    }

    private String MyBillsEntityDataFactory(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append("/hms/component/".replace("component", str));
        return sb.toString();
    }

    public static boolean MyBillsEntityDataFactory() {
        StringBuilder sb = new StringBuilder();
        sb.append(b.lookAheadTest().getFilesDir().getPath());
        sb.append("/");
        sb.append("hms");
        return PlaceComponentResult(new File(sb.toString()));
    }

    private static boolean PlaceComponentResult() {
        long authRequestContext = g0.getAuthRequestContext(b.lookAheadTest(), "Privacy_MY", "assemblyFlash");
        if (-1 != authRequestContext) {
            return System.currentTimeMillis() - authRequestContext > 31536000000L;
        }
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "First init components");
        return true;
    }

    private static boolean PlaceComponentResult(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("delete file failed : ");
                    sb.append(file2.getName());
                    y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb.toString());
                }
            } else if (file2.isDirectory()) {
                PlaceComponentResult(file2);
            }
        }
        return file.delete();
    }

    private String getAuthRequestContext(String str) {
        String MyBillsEntityDataFactory = MyBillsEntityDataFactory(str);
        StringBuilder sb = new StringBuilder();
        sb.append("hianalytics_");
        sb.append(str);
        File file = new File(MyBillsEntityDataFactory, sb.toString());
        if (getAuthRequestContext(file)) {
            return t0.MyBillsEntityDataFactory(file);
        }
        String MyBillsEntityDataFactory2 = EncryptUtil.MyBillsEntityDataFactory(128);
        t0.PlaceComponentResult(file, MyBillsEntityDataFactory2);
        return MyBillsEntityDataFactory2;
    }

    private static boolean getAuthRequestContext(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            y.moveToNextValue("hmsSdk", "create new file error!");
            return false;
        }
    }

    public final String getAuthRequestContext() {
        String authRequestContext;
        String authRequestContext2;
        String authRequestContext3;
        String authRequestContext4;
        if (PlaceComponentResult()) {
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "refresh components");
            authRequestContext = EncryptUtil.MyBillsEntityDataFactory(128);
            BuiltInFictitiousFunctionClassFactory("aprpap", authRequestContext);
            authRequestContext2 = EncryptUtil.MyBillsEntityDataFactory(128);
            BuiltInFictitiousFunctionClassFactory("febdoc", authRequestContext2);
            authRequestContext3 = EncryptUtil.MyBillsEntityDataFactory(128);
            BuiltInFictitiousFunctionClassFactory("marfil", authRequestContext3);
            authRequestContext4 = EncryptUtil.MyBillsEntityDataFactory(128);
            BuiltInFictitiousFunctionClassFactory("maywnj", authRequestContext4);
            g0.MyBillsEntityDataFactory(b.lookAheadTest(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            authRequestContext = getAuthRequestContext("aprpap");
            authRequestContext2 = getAuthRequestContext("febdoc");
            authRequestContext3 = getAuthRequestContext("marfil");
            authRequestContext4 = getAuthRequestContext("maywnj");
        }
        return HexUtil.getAuthRequestContext(PBKDF2.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(authRequestContext, authRequestContext2, authRequestContext3, "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc"), HexUtil.getAuthRequestContext(authRequestContext4), 16));
    }
}
