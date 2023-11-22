package id.dana.data.util;

import android.graphics.Color;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import id.dana.data.foundation.utils.JsonUtil;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import o.getCallingPid;

/* loaded from: classes2.dex */
public class FeatureSwitch {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static char MyBillsEntityDataFactory = 42065;
    private static char[] getAuthRequestContext = {37276, 37306, 37309, 37290, 37304, 37292, 37287, 37294, 37275, 37286, 37273, 37278, 37272, 37257, 37307, 37279};

    private FeatureSwitch() {
    }

    public static <T> Observable<T> getFeatureSwitch(final String str, final T t) {
        Observable<T> onErrorReturnItem = Observable.fromCallable(new Callable() { // from class: id.dana.data.util.FeatureSwitch$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FeatureSwitch.lambda$getFeatureSwitch$0(str, t);
            }
        }).onErrorReturnItem(t);
        int i = BuiltInFictitiousFunctionClassFactory + 61;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return onErrorReturnItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$getFeatureSwitch$0(String str, Object obj) throws Exception {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 53;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                Object featureSwitchObject = getFeatureSwitchObject(str, obj);
                int i3 = BuiltInFictitiousFunctionClassFactory + 79;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return featureSwitchObject;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static <T> T getFeatureSwitchObject(String str, T t) {
        JSONObject featureSwitchSection = getFeatureSwitchSection();
        if (featureSwitchSection != null) {
            T t2 = (T) featureSwitchSection.get(str);
            if (t2 != null) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                return t2;
            }
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 != 0 ? '@' : (char) 29) != 29) {
            Object obj = null;
            obj.hashCode();
            return t;
        }
        return t;
    }

    public static JSONArray getFeatureSwitchJSONArray(String str) {
        JSONObject featureSwitchSection = getFeatureSwitchSection();
        if ((featureSwitchSection != null ? (char) 22 : '%') != '%') {
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                try {
                    JSONArray jSONArray = featureSwitchSection.getJSONArray(str);
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    int i4 = i3 % 2;
                    return jSONArray;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return null;
    }

    public static JSONObject getFeatureSwitchJSONObject(String str) {
        JSONObject featureSwitchSection = getFeatureSwitchSection();
        if ((featureSwitchSection != null ? (char) 27 : '2') != 27) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 != 0) {
                int i2 = 2 / 0;
                return null;
            }
            return null;
        }
        JSONObject jSONObject = featureSwitchSection.getJSONObject(str);
        int i3 = BuiltInFictitiousFunctionClassFactory + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 67 / 0;
            return jSONObject;
        }
        return jSONObject;
    }

    private static JSONObject getFeatureSwitchSection() {
        JSONObject MyBillsEntityDataFactory2;
        Object[] objArr = new Object[1];
        a(new char[]{15, 1, 6, 15, 2, 3, 0, 1, 5, '\b', '\r', 6, 13847}, (byte) (Color.green(0) + 37), ExpandableListView.getPackedPositionGroup(0L) + 13, objArr);
        org.json.JSONObject section = ConfigCenterHelper.getSection(((String) objArr[0]).intern());
        Object[] objArr2 = null;
        if (!(section != null)) {
            return null;
        }
        int i = BuiltInFictitiousFunctionClassFactory + 45;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            MyBillsEntityDataFactory2 = JsonUtil.MyBillsEntityDataFactory(section);
            int length = objArr2.length;
        } else {
            MyBillsEntityDataFactory2 = JsonUtil.MyBillsEntityDataFactory(section);
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 67;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        return MyBillsEntityDataFactory2;
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = getAuthRequestContext;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = 0;
            while (i3 < length) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                i3++;
                int i4 = $10 + 19;
                $11 = i4 % 128;
                int i5 = i4 % 2;
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ MyBillsEntityDataFactory);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            try {
                int i6 = $10 + 85;
                try {
                    $11 = i6 % 128;
                    if (i6 % 2 != 0) {
                        i2 = i - 1;
                        cArr4[i2] = (char) (cArr[i2] - b);
                    } else {
                        i2 = i + 77;
                        cArr4[i2] = (char) (cArr[i2] >> b);
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (true) {
                if (getcallingpid.getAuthRequestContext >= i2) {
                    break;
                }
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i7 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i8 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i7];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i8];
                    } else {
                        if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                            int i9 = $10 + 71;
                            $11 = i9 % 128;
                            int i10 = i9 % 2;
                            getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                            getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                            int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i11];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i12];
                        } else {
                            int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i13];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i14];
                        }
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        int i15 = 0;
        while (true) {
            if (!(i15 >= i)) {
                cArr4[i15] = (char) (cArr4[i15] ^ 13722);
                i15++;
                int i16 = $10 + 111;
                $11 = i16 % 128;
                int i17 = i16 % 2;
            } else {
                objArr[0] = new String(cArr4);
                return;
            }
        }
    }
}
