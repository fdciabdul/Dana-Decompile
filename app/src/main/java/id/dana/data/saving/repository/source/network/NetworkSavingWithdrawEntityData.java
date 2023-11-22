package id.dana.data.saving.repository.source.network;

import android.text.TextUtils;
import android.view.View;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.saving.repository.SavingWithdrawEntityData;
import id.dana.data.storage.Serializer;
import id.dana.data.util.ConfigCenterHelper;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.D;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0003\u001a\u0006*\u00020\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/data/saving/repository/source/network/NetworkSavingWithdrawEntityData;", "Lid/dana/data/saving/repository/SavingWithdrawEntityData;", "Lid/dana/data/config/source/ConfigEntityData;", "createSplitConfigData", "()Lid/dana/data/config/source/ConfigEntityData;", "", "", "getFromAmcs", "()Ljava/util/List;", "Lorg/json/JSONObject;", "getSavingSection", "()Lorg/json/JSONObject;", "Lio/reactivex/Observable;", "getWithdrawOption", "()Lio/reactivex/Observable;", "config", "getWithdrawOptionString", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "configEntityDataFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "<init>", "(Lid/dana/data/storage/Serializer;Lid/dana/data/config/source/ConfigEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkSavingWithdrawEntityData implements SavingWithdrawEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = -5537807145409399139L;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final Serializer serializer;

    /* renamed from: $r8$lambda$A2X-wQMK65PxvM26FiWZ8lK-M5s  reason: not valid java name */
    public static /* synthetic */ List m1893$r8$lambda$A2XwQMK65PxvM26FiWZ8lKM5s(NetworkSavingWithdrawEntityData networkSavingWithdrawEntityData, Throwable th) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 == 0)) {
            try {
                return m1894getWithdrawOption$lambda0(networkSavingWithdrawEntityData, th);
            } catch (Exception e) {
                throw e;
            }
        }
        List m1894getWithdrawOption$lambda0 = m1894getWithdrawOption$lambda0(networkSavingWithdrawEntityData, th);
        Object obj = null;
        obj.hashCode();
        return m1894getWithdrawOption$lambda0;
    }

    @Inject
    public NetworkSavingWithdrawEntityData(Serializer serializer, ConfigEntityDataFactory configEntityDataFactory) {
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        this.serializer = serializer;
        this.configEntityDataFactory = configEntityDataFactory;
    }

    /* renamed from: getWithdrawOption$lambda-0  reason: not valid java name */
    private static final List m1894getWithdrawOption$lambda0(NetworkSavingWithdrawEntityData networkSavingWithdrawEntityData, Throwable th) {
        List<String> fromAmcs;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? 'R' : '5') != 'R') {
            Intrinsics.checkNotNullParameter(networkSavingWithdrawEntityData, "");
            Intrinsics.checkNotNullParameter(th, "");
            fromAmcs = networkSavingWithdrawEntityData.getFromAmcs();
        } else {
            Intrinsics.checkNotNullParameter(networkSavingWithdrawEntityData, "");
            Intrinsics.checkNotNullParameter(th, "");
            fromAmcs = networkSavingWithdrawEntityData.getFromAmcs();
            Object obj = null;
            obj.hashCode();
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        return fromAmcs;
    }

    @Override // id.dana.data.saving.repository.SavingWithdrawEntityData
    public final Observable<List<String>> getWithdrawOption() {
        Observable<List<String>> onErrorReturn = createSplitConfigData().getSavingWithdrawOptionsConfig().onErrorReturn(new Function() { // from class: id.dana.data.saving.repository.source.network.NetworkSavingWithdrawEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return NetworkSavingWithdrawEntityData.m1893$r8$lambda$A2XwQMK65PxvM26FiWZ8lKM5s(NetworkSavingWithdrawEntityData.this, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        int i = MyBillsEntityDataFactory + 55;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return onErrorReturn;
    }

    private final List<String> getFromAmcs() {
        ArrayList arrayList = new ArrayList();
        JSONObject savingSection = getSavingSection();
        if (savingSection != null) {
            String jSONObject = savingSection.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "");
            List<String> deserializeList = this.serializer.deserializeList(getWithdrawOptionString(jSONObject));
            Intrinsics.checkNotNullExpressionValue(deserializeList, "");
            Iterator<T> it = deserializeList.iterator();
            while (true) {
                if (!(!it.hasNext())) {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
                    MyBillsEntityDataFactory = i % 128;
                    if (i % 2 == 0) {
                        arrayList.add((String) it.next());
                        Object obj = null;
                        obj.hashCode();
                    } else {
                        arrayList.add((String) it.next());
                    }
                }
            }
        }
        try {
            ArrayList arrayList2 = arrayList;
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return arrayList2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final String getWithdrawOptionString(String config) {
        Map.Entry<String, String> next;
        int i = MyBillsEntityDataFactory + 117;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Map<String, String> deserializeMap = this.serializer.deserializeMap(config);
        Intrinsics.checkNotNullExpressionValue(deserializeMap, "");
        Iterator<Map.Entry<String, String>> it = deserializeMap.entrySet().iterator();
        while (true) {
            if (!(it.hasNext())) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 125;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 73 / 0;
                    return "[]";
                }
                return "[]";
            }
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 11;
            MyBillsEntityDataFactory = i5 % 128;
            if (i5 % 2 != 0) {
                next = it.next();
                String key = next.getKey();
                Object[] objArr = new Object[1];
                a(View.MeasureSpec.getSize(0) + 1, new char[]{42884, 42999, 26852, 37872, 55590, 49011, 12218, 19781, 19006, 33226, 15815, 24375, 31813, 49037, 3036, 28944, 28298, 44148, 6455, 1271, 4283, 55889, 30568, 5813, 719, 51219}, objArr);
                if ((Intrinsics.areEqual(key, ((String) objArr[0]).intern()) ? '8' : (char) 7) == '8') {
                    break;
                }
            } else {
                next = it.next();
                String key2 = next.getKey();
                Object[] objArr2 = new Object[1];
                a(View.MeasureSpec.getSize(0) + 1, new char[]{42884, 42999, 26852, 37872, 55590, 49011, 12218, 19781, 19006, 33226, 15815, 24375, 31813, 49037, 3036, 28944, 28298, 44148, 6455, 1271, 4283, 55889, 30568, 5813, 719, 51219}, objArr2);
                if (Intrinsics.areEqual(key2, ((String) objArr2[0]).intern())) {
                    break;
                }
            }
        }
        String value = next.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        return value;
    }

    private final JSONObject getSavingSection() {
        Object obj;
        int i = MyBillsEntityDataFactory + 39;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = new Object[1];
            a(TextUtils.getOffsetAfter("", 0) + 1, new char[]{32029, 32078, 51826, 12646, 47753, 5621, 19477, 59331, 37031, 9052}, objArr);
            obj = objArr[0];
        } else {
            Object[] objArr2 = new Object[1];
            a(0 >> TextUtils.getOffsetAfter("", 0), new char[]{32029, 32078, 51826, 12646, 47753, 5621, 19477, 59331, 37031, 9052}, objArr2);
            obj = objArr2[0];
        }
        JSONObject section = ConfigCenterHelper.getSection(((String) obj).intern());
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        return section;
    }

    private final ConfigEntityData createSplitConfigData() {
        int i = MyBillsEntityDataFactory + 77;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        ConfigEntityData createData2 = this.configEntityDataFactory.createData2("split");
        int i3 = MyBillsEntityDataFactory + 111;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? '\b' : '-') != '\b') {
            return createData2;
        }
        int i4 = 95 / 0;
        return createData2;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            if (!(d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length)) {
                objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                return;
            }
            int i2 = $10 + 55;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            try {
                try {
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (BuiltInFictitiousFunctionClassFactory ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                    int i4 = $11 + 119;
                    $10 = i4 % 128;
                    int i5 = i4 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }
}
