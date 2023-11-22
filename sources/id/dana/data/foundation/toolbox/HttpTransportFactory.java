package id.dana.data.foundation.toolbox;

import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.C;
import okhttp3.OkHttpClient;

@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lid/dana/data/foundation/toolbox/HttpTransportFactory;", "", "okHttpClient", "Lokhttp3/OkHttpClient;", "sharedPrefStartupConfig", "Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;", "(Lokhttp3/OkHttpClient;Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;)V", "createHttpTransport", "Lid/dana/data/foundation/toolbox/AbstractHttpTransport;", "enableCache", "", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HttpTransportFactory {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char MyBillsEntityDataFactory = 10884;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    private static char PlaceComponentResult = 10945;
    private static char getAuthRequestContext = 6103;
    private static char moveToNextValue = 65043;
    private static int scheduleImpl = 1;
    private final SharedPrefStartupConfig BuiltInFictitiousFunctionClassFactory;
    private final OkHttpClient KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public HttpTransportFactory(OkHttpClient okHttpClient, SharedPrefStartupConfig sharedPrefStartupConfig) {
        Intrinsics.checkNotNullParameter(okHttpClient, "");
        Intrinsics.checkNotNullParameter(sharedPrefStartupConfig, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = okHttpClient;
        this.BuiltInFictitiousFunctionClassFactory = sharedPrefStartupConfig;
    }

    public static /* synthetic */ AbstractHttpTransport PlaceComponentResult(HttpTransportFactory httpTransportFactory) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        AbstractHttpTransport BuiltInFictitiousFunctionClassFactory = httpTransportFactory.BuiltInFictitiousFunctionClassFactory();
        int i3 = scheduleImpl + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return BuiltInFictitiousFunctionClassFactory;
        }
        int i4 = 45 / 0;
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        if (r0.booleanValue() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r0.booleanValue() != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        r0 = new id.dana.data.foundation.toolbox.UrlTransport(false);
        r1 = id.dana.data.foundation.toolbox.HttpTransportFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 + 9;
        id.dana.data.foundation.toolbox.HttpTransportFactory.scheduleImpl = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008e, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return new id.dana.data.foundation.toolbox.OkHttpUrlTransport(r6.KClassImpl$Data$declaredNonStaticMembers$2, r6.BuiltInFictitiousFunctionClassFactory);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.data.foundation.toolbox.AbstractHttpTransport BuiltInFictitiousFunctionClassFactory() {
        /*
            r6 = this;
            int r0 = id.dana.data.foundation.toolbox.HttpTransportFactory.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 29
            int r1 = r0 % 128
            id.dana.data.foundation.toolbox.HttpTransportFactory.scheduleImpl = r1
            int r0 = r0 % 2
            r1 = 36
            if (r0 != 0) goto L11
            r0 = 36
            goto L13
        L11:
            r0 = 51
        L13:
            r2 = 1
            r3 = 22
            r4 = 0
            java.lang.String r5 = ""
            if (r0 == r1) goto L45
            int r0 = android.text.TextUtils.indexOf(r5, r5)
            int r0 = 21 - r0
            char[] r1 = new char[r3]
            r1 = {x0090: FILL_ARRAY_DATA , data: [-11132, -14174, 30338, -29529, 28947, 28670, 16893, -6153, 28380, 12080, -27868, 16029, 24015, -22451, -29738, -26586, 18800, 31790, 26074, -5882, 24627, 25718} // fill-array
            java.lang.Object[] r2 = new java.lang.Object[r2]
            a(r0, r1, r2)
            r0 = r2[r4]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.Object r0 = id.dana.data.util.FeatureSwitch.getFeatureSwitchObject(r0, r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L7d
            goto L6f
        L45:
            r0 = 114(0x72, float:1.6E-43)
            int r1 = android.text.TextUtils.indexOf(r5, r5)
            int r0 = r0 >> r1
            char[] r1 = new char[r3]
            r1 = {x00aa: FILL_ARRAY_DATA , data: [-11132, -14174, 30338, -29529, 28947, 28670, 16893, -6153, 28380, 12080, -27868, 16029, 24015, -22451, -29738, -26586, 18800, 31790, 26074, -5882, 24627, 25718} // fill-array
            java.lang.Object[] r2 = new java.lang.Object[r2]
            a(r0, r1, r2)
            r0 = r2[r4]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            java.lang.Object r0 = id.dana.data.util.FeatureSwitch.getFeatureSwitchObject(r0, r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L7d
        L6f:
            id.dana.data.foundation.toolbox.OkHttpUrlTransport r0 = new id.dana.data.foundation.toolbox.OkHttpUrlTransport
            okhttp3.OkHttpClient r1 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig r2 = r6.BuiltInFictitiousFunctionClassFactory
            id.dana.domain.featureconfig.StartupConfigEntityData r2 = (id.dana.domain.featureconfig.StartupConfigEntityData) r2
            r0.<init>(r1, r2)
            id.dana.data.foundation.toolbox.AbstractHttpTransport r0 = (id.dana.data.foundation.toolbox.AbstractHttpTransport) r0
            goto L8e
        L7d:
            id.dana.data.foundation.toolbox.UrlTransport r0 = new id.dana.data.foundation.toolbox.UrlTransport
            r0.<init>(r4)
            id.dana.data.foundation.toolbox.AbstractHttpTransport r0 = (id.dana.data.foundation.toolbox.AbstractHttpTransport) r0
            int r1 = id.dana.data.foundation.toolbox.HttpTransportFactory.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 9
            int r2 = r1 % 128
            id.dana.data.foundation.toolbox.HttpTransportFactory.scheduleImpl = r2
            int r1 = r1 % 2
        L8e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.toolbox.HttpTransportFactory.BuiltInFictitiousFunctionClassFactory():id.dana.data.foundation.toolbox.AbstractHttpTransport");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? '4' : (char) 29) != 29) {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i2 = 58224;
                int i3 = 0;
                while (true) {
                    if ((i3 < 16 ? (char) 18 : (char) 19) != 19) {
                        int i4 = $10 + 37;
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                        cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (moveToNextValue ^ 6353485791441662354L)))));
                        cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                        i2 -= 40503;
                        i3++;
                    }
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
                int i6 = $11 + 119;
                $10 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
