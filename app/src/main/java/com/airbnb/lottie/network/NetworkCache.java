package com.airbnb.lottie.network;

import android.util.Pair;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class NetworkCache {
    private final LottieNetworkCacheProvider BuiltInFictitiousFunctionClassFactory;

    public NetworkCache(LottieNetworkCacheProvider lottieNetworkCacheProvider) {
        this.BuiltInFictitiousFunctionClassFactory = lottieNetworkCacheProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File getAuthRequestContext(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(KClassImpl$Data$declaredNonStaticMembers$2(), getAuthRequestContext(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final File KClassImpl$Data$declaredNonStaticMembers$2() {
        File MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory.isFile()) {
            MyBillsEntityDataFactory.delete();
        }
        if (!MyBillsEntityDataFactory.exists()) {
            MyBillsEntityDataFactory.mkdirs();
        }
        return MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAuthRequestContext(String str, FileExtension fileExtension, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? fileExtension.tempExtension() : fileExtension.extension);
        return sb.toString();
    }

    public final Pair<FileExtension, InputStream> PlaceComponentResult(String str) {
        FileExtension fileExtension;
        try {
            File file = new File(KClassImpl$Data$declaredNonStaticMembers$2(), getAuthRequestContext(str, FileExtension.JSON, false));
            if (!file.exists()) {
                file = new File(KClassImpl$Data$declaredNonStaticMembers$2(), getAuthRequestContext(str, FileExtension.ZIP, false));
                if (!file.exists()) {
                    file = null;
                }
            }
            if (file == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            if (file.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.ZIP;
            } else {
                fileExtension = FileExtension.JSON;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cache hit for ");
            sb.append(str);
            sb.append(" at ");
            sb.append(file.getAbsolutePath());
            Logger.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
            return new Pair<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }
}
