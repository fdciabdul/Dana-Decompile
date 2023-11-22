package com.airbnb.lottie;

import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import java.io.File;

/* loaded from: classes6.dex */
public class LottieConfig {

    /* loaded from: classes6.dex */
    public static final class Builder {
        private boolean BuiltInFictitiousFunctionClassFactory = false;

        /* renamed from: com.airbnb.lottie.LottieConfig$Builder$1  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass1 implements LottieNetworkCacheProvider {
            final /* synthetic */ File BuiltInFictitiousFunctionClassFactory;

            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
            public final File MyBillsEntityDataFactory() {
                if (!this.BuiltInFictitiousFunctionClassFactory.isDirectory()) {
                    throw new IllegalArgumentException("cache file must be a directory");
                }
                return this.BuiltInFictitiousFunctionClassFactory;
            }
        }

        /* renamed from: com.airbnb.lottie.LottieConfig$Builder$2  reason: invalid class name */
        /* loaded from: classes6.dex */
        class AnonymousClass2 implements LottieNetworkCacheProvider {
            final /* synthetic */ LottieNetworkCacheProvider KClassImpl$Data$declaredNonStaticMembers$2;

            @Override // com.airbnb.lottie.network.LottieNetworkCacheProvider
            public final File MyBillsEntityDataFactory() {
                File MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                if (MyBillsEntityDataFactory.isDirectory()) {
                    return MyBillsEntityDataFactory;
                }
                throw new IllegalArgumentException("cache file must be a directory");
            }
        }
    }
}
