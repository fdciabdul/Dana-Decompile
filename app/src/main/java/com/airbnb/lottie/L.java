package com.airbnb.lottie;

import android.content.Context;
import androidx.core.os.TraceCompat;
import com.airbnb.lottie.network.DefaultLottieNetworkFetcher;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.LottieNetworkFetcher;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import java.io.File;

/* loaded from: classes3.dex */
public class L {
    private static LottieNetworkFetcher BuiltInFictitiousFunctionClassFactory = null;
    private static volatile NetworkCache KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static LottieNetworkCacheProvider MyBillsEntityDataFactory = null;
    private static volatile NetworkFetcher NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private static int PlaceComponentResult = 0;
    public static boolean getAuthRequestContext = false;
    private static boolean getErrorConfigVersion;
    private static long[] lookAheadTest;
    private static String[] moveToNextValue;
    private static int scheduleImpl;

    private L() {
    }

    public static void getAuthRequestContext(String str) {
        if (getErrorConfigVersion) {
            int i = scheduleImpl;
            if (i == 20) {
                PlaceComponentResult++;
                return;
            }
            moveToNextValue[i] = str;
            lookAheadTest[i] = System.nanoTime();
            TraceCompat.BuiltInFictitiousFunctionClassFactory(str);
            scheduleImpl++;
        }
    }

    public static float MyBillsEntityDataFactory(String str) {
        int i = PlaceComponentResult;
        if (i > 0) {
            PlaceComponentResult = i - 1;
            return 0.0f;
        } else if (getErrorConfigVersion) {
            int i2 = scheduleImpl - 1;
            scheduleImpl = i2;
            if (i2 == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(moveToNextValue[i2])) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unbalanced trace call ");
                sb.append(str);
                sb.append(". Expected ");
                sb.append(moveToNextValue[scheduleImpl]);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
            TraceCompat.BuiltInFictitiousFunctionClassFactory();
            return ((float) (System.nanoTime() - lookAheadTest[scheduleImpl])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }

    public static NetworkFetcher KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        NetworkFetcher networkFetcher;
        NetworkFetcher networkFetcher2 = NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (networkFetcher2 == null) {
            synchronized (NetworkFetcher.class) {
                networkFetcher = NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (networkFetcher == null) {
                    NetworkCache PlaceComponentResult2 = PlaceComponentResult(context);
                    LottieNetworkFetcher lottieNetworkFetcher = BuiltInFictitiousFunctionClassFactory;
                    if (lottieNetworkFetcher == null) {
                        lottieNetworkFetcher = new DefaultLottieNetworkFetcher();
                    }
                    networkFetcher = new NetworkFetcher(PlaceComponentResult2, lottieNetworkFetcher);
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = networkFetcher;
                }
            }
            return networkFetcher;
        }
        return networkFetcher2;
    }

    private static NetworkCache PlaceComponentResult(Context context) {
        NetworkCache networkCache;
        final Context applicationContext = context.getApplicationContext();
        NetworkCache networkCache2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (networkCache2 == null) {
            synchronized (NetworkCache.class) {
                networkCache = KClassImpl$Data$declaredNonStaticMembers$2;
                if (networkCache == null) {
                    LottieNetworkCacheProvider lottieNetworkCacheProvider = MyBillsEntityDataFactory;
                    if (lottieNetworkCacheProvider == null) {
                        lottieNetworkCacheProvider = new LottieNetworkCacheProvider() { // from class: com.airbnb.lottie.L.1
                            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
                            public final File MyBillsEntityDataFactory() {
                                return new File(applicationContext.getCacheDir(), "lottie_network_cache");
                            }
                        };
                    }
                    networkCache = new NetworkCache(lottieNetworkCacheProvider);
                    KClassImpl$Data$declaredNonStaticMembers$2 = networkCache;
                }
            }
            return networkCache;
        }
        return networkCache2;
    }
}
