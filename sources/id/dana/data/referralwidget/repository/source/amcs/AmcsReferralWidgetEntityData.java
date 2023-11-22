package id.dana.data.referralwidget.repository.source.amcs;

import android.os.SystemClock;
import android.view.ViewConfiguration;
import com.alibaba.fastjson.JSONObject;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.referralwidget.model.ReferralWidgetResult;
import id.dana.data.referralwidget.repository.source.ReferralWidgetEntityData;
import id.dana.data.storage.Serializer;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import o.getCallingPid;

@Singleton
/* loaded from: classes8.dex */
public class AmcsReferralWidgetEntityData implements ReferralWidgetEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = {37290, 37272, 37463, 37289, 37294, 37457, 37291, 37307, 37460, 37286, 37462, 37283, 37309, 37461, 37288, 37277};
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static char PlaceComponentResult = 42065;
    private final Serializer serializer;

    @Inject
    public AmcsReferralWidgetEntityData(Serializer serializer) {
        this.serializer = serializer;
    }

    @Override // id.dana.data.referralwidget.repository.source.ReferralWidgetEntityData
    public Observable<Map<String, ReferralWidgetResult>> getReferralWidgets() {
        try {
            Observable<Map<String, ReferralWidgetResult>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.referralwidget.repository.source.amcs.AmcsReferralWidgetEntityData$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return AmcsReferralWidgetEntityData.this.m1791x4a1dc859();
                }
            });
            int i = MyBillsEntityDataFactory + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if (i % 2 != 0) {
                int i2 = 44 / 0;
                return fromCallable;
            }
            return fromCallable;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getReferralWidgets$0$id-dana-data-referralwidget-repository-source-amcs-AmcsReferralWidgetEntityData  reason: not valid java name */
    public /* synthetic */ Map m1791x4a1dc859() throws Exception {
        ConfigCenter configCenter = ConfigCenter.getInstance();
        Object[] objArr = new Object[1];
        a(new char[]{'\f', 3, 0, 1, 13887, 13887, 7, '\b', 5, '\r', '\n', 2, 3, 4}, (byte) (87 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), 15 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr);
        JSONObject MyBillsEntityDataFactory2 = JsonUtil.MyBillsEntityDataFactory(configCenter.getSectionConfig(((String) objArr[0]).intern()));
        if (!(MyBillsEntityDataFactory2 != null)) {
            return null;
        }
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (MyBillsEntityDataFactory2.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<String, Object>> it = MyBillsEntityDataFactory2.entrySet().iterator();
        while (true) {
            if ((it.hasNext() ? 'W' : (char) 7) == 7) {
                return hashMap;
            }
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            Map.Entry<String, Object> next = it.next();
            String key = next.getKey();
            Object value = next.getValue();
            if (!(!(value instanceof JSONObject))) {
                hashMap.put(key, (ReferralWidgetResult) this.serializer.deserialize(((JSONObject) value).toJSONString(), ReferralWidgetResult.class));
                int i5 = MyBillsEntityDataFactory + 93;
                KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                int i6 = i5 % 2;
            }
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
        if (cArr2 != null) {
            int i3 = $10 + 103;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr3[i5] = (char) (cArr2[i5] ^ (-1549216646985767851L));
            }
            int i6 = $10 + 39;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ PlaceComponentResult);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            int i8 = $10 + 65;
            $11 = i8 % 128;
            if (i8 % 2 == 0) {
                i2 = i + 21;
                cArr4[i2] = (char) (cArr[i2] % b);
            } else {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            }
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            int i9 = $10 + 123;
            $11 = i9 % 128;
            if (i9 % 2 == 0) {
            }
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if ((getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult ? (char) 24 : (char) 0) != 24) {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i10 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i11 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i10];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i11];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory != getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                    } else {
                        try {
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            try {
                                int i14 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                int i15 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i14];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i15];
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                } else {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    int i16 = $10 + 79;
                    $11 = i16 % 128;
                    int i17 = i16 % 2;
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i18 = 0; i18 < i; i18++) {
            int i19 = $10 + 23;
            $11 = i19 % 128;
            int i20 = i19 % 2;
            cArr4[i18] = (char) (cArr4[i18] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
