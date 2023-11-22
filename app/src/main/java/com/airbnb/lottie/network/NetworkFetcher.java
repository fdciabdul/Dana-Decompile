package com.airbnb.lottie.network;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes3.dex */
public class NetworkFetcher {
    private final LottieNetworkFetcher BuiltInFictitiousFunctionClassFactory;
    public final NetworkCache MyBillsEntityDataFactory;

    public NetworkFetcher(NetworkCache networkCache, LottieNetworkFetcher lottieNetworkFetcher) {
        this.MyBillsEntityDataFactory = networkCache;
        this.BuiltInFictitiousFunctionClassFactory = lottieNetworkFetcher;
    }

    public final LottieResult<LottieComposition> KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        FileExtension fileExtension;
        LottieResult<LottieComposition> KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append("Fetching ");
        sb.append(str);
        Logger.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
        LottieFetchResult lottieFetchResult = null;
        try {
            try {
                LottieFetchResult MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(str);
                try {
                    if (!MyBillsEntityDataFactory.getAuthRequestContext()) {
                        LottieResult<LottieComposition> lottieResult = new LottieResult<>(new IllegalArgumentException(MyBillsEntityDataFactory.PlaceComponentResult()));
                        try {
                            MyBillsEntityDataFactory.close();
                        } catch (IOException e) {
                            Logger.getAuthRequestContext("LottieFetchResult close failed ", e);
                        }
                        return lottieResult;
                    }
                    InputStream KClassImpl$Data$declaredNonStaticMembers$22 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                    String BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
                    if (BuiltInFictitiousFunctionClassFactory == null) {
                        BuiltInFictitiousFunctionClassFactory = "application/json";
                    }
                    if (BuiltInFictitiousFunctionClassFactory.contains("application/zip") || BuiltInFictitiousFunctionClassFactory.contains("application/x-zip") || BuiltInFictitiousFunctionClassFactory.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
                        Logger.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2("Handling zip response.");
                        fileExtension = FileExtension.ZIP;
                        KClassImpl$Data$declaredNonStaticMembers$2 = str2 == null ? LottieCompositionFactory.KClassImpl$Data$declaredNonStaticMembers$2(new ZipInputStream(KClassImpl$Data$declaredNonStaticMembers$22), (String) null) : LottieCompositionFactory.KClassImpl$Data$declaredNonStaticMembers$2(new ZipInputStream(new FileInputStream(this.MyBillsEntityDataFactory.getAuthRequestContext(str, KClassImpl$Data$declaredNonStaticMembers$22, FileExtension.ZIP))), str);
                    } else {
                        Logger.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2("Received json response.");
                        fileExtension = FileExtension.JSON;
                        KClassImpl$Data$declaredNonStaticMembers$2 = str2 == null ? LottieCompositionFactory.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22, (String) null) : LottieCompositionFactory.PlaceComponentResult(new FileInputStream(this.MyBillsEntityDataFactory.getAuthRequestContext(str, KClassImpl$Data$declaredNonStaticMembers$22, FileExtension.JSON).getAbsolutePath()), str);
                    }
                    if (str2 != null && KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult != null) {
                        File file = new File(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(), NetworkCache.getAuthRequestContext(str, fileExtension, true));
                        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
                        boolean renameTo = file.renameTo(file2);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Copying temp file to real file (");
                        sb2.append(file2);
                        sb2.append(")");
                        Logger.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(sb2.toString());
                        if (!renameTo) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Unable to rename cache file ");
                            sb3.append(file.getAbsolutePath());
                            sb3.append(" to ");
                            sb3.append(file2.getAbsolutePath());
                            sb3.append(".");
                            Logger.getAuthRequestContext(sb3.toString());
                        }
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Completed fetch from network. Success: ");
                    sb4.append(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult != null);
                    Logger.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(sb4.toString());
                    try {
                        MyBillsEntityDataFactory.close();
                    } catch (IOException e2) {
                        Logger.getAuthRequestContext("LottieFetchResult close failed ", e2);
                    }
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                } catch (Exception e3) {
                    e = e3;
                    lottieFetchResult = MyBillsEntityDataFactory;
                    LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(e);
                    if (lottieFetchResult != null) {
                        try {
                            lottieFetchResult.close();
                        } catch (IOException e4) {
                            Logger.getAuthRequestContext("LottieFetchResult close failed ", e4);
                        }
                    }
                    return lottieResult2;
                } catch (Throwable th) {
                    th = th;
                    lottieFetchResult = MyBillsEntityDataFactory;
                    if (lottieFetchResult != null) {
                        try {
                            lottieFetchResult.close();
                        } catch (IOException e5) {
                            Logger.getAuthRequestContext("LottieFetchResult close failed ", e5);
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
