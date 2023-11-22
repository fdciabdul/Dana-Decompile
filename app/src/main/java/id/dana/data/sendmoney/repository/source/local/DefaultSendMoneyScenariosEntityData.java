package id.dana.data.sendmoney.repository.source.local;

import android.content.Context;
import android.os.SystemClock;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.sendmoney.model.SendMoneyScenarioEntity;
import id.dana.data.sendmoney.repository.source.SendMoneyScenariosEntityData;
import id.dana.data.storage.Serializer;
import id.dana.utils.exception.CallableReturnNullError;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import o.C;

@Singleton
/* loaded from: classes2.dex */
public class DefaultSendMoneyScenariosEntityData implements SendMoneyScenariosEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 43573;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 41164;
    private static char MyBillsEntityDataFactory = 42469;
    private static char PlaceComponentResult = 13106;
    private static final String RECIPIENT_HOME_MENU_JSON = "json/amcs-sendmoney-home-menu-default.json";
    private static final String RECIPIENT_HOME_MENU_LIST = "json/amcs-sendmoney-home-menu-category.json";
    private static int getAuthRequestContext = 0;
    private static int lookAheadTest = 1;
    private final Context context;
    private final Serializer serializer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$convertJsonToMenuItem$1(Map map, List list) throws Exception {
        int i = getAuthRequestContext + 101;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            int i3 = lookAheadTest + 11;
            getAuthRequestContext = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return map;
            }
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public DefaultSendMoneyScenariosEntityData(Context context, Serializer serializer) {
        this.context = context;
        this.serializer = serializer;
    }

    private Observable<Map<String, SendMoneyScenarioEntity>> getSendMoneyMenuItems() {
        Observable<Map<String, SendMoneyScenarioEntity>> flatMap = Observable.fromCallable(new Callable() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultSendMoneyScenariosEntityData.this.m1925x78b93f1();
            }
        }).flatMap(convertJsonToMenuItem());
        int i = lookAheadTest + 57;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSendMoneyMenuItems$0$id-dana-data-sendmoney-repository-source-local-DefaultSendMoneyScenariosEntityData  reason: not valid java name */
    public /* synthetic */ Set m1925x78b93f1() throws Exception {
        int i = getAuthRequestContext + 125;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Set<Map.Entry<String, String>> call = getMenuItemsFromFile().call();
        if ((call != null ? (char) 4 : 'b') != 'b') {
            int i3 = lookAheadTest + 37;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 != 0 ? 'B' : '2') == 'B') {
                Object obj = null;
                obj.hashCode();
            }
            return call;
        }
        throw new CallableReturnNullError("DefaultSendMoneyScenariosEntityData#getSendMoneyMenuItems");
    }

    private Function<Set<Map.Entry<String, String>>, ObservableSource<Map<String, SendMoneyScenarioEntity>>> convertJsonToMenuItem() {
        Function<Set<Map.Entry<String, String>>, ObservableSource<Map<String, SendMoneyScenarioEntity>>> function = new Function() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultSendMoneyScenariosEntityData.this.m1920x5bf0066((Set) obj);
            }
        };
        try {
            int i = lookAheadTest + 67;
            try {
                getAuthRequestContext = i % 128;
                if ((i % 2 != 0 ? 'K' : 'Y') != 'K') {
                    return function;
                }
                int i2 = 65 / 0;
                return function;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$convertJsonToMenuItem$2$id-dana-data-sendmoney-repository-source-local-DefaultSendMoneyScenariosEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1920x5bf0066(Set set) throws Exception {
        Observable BuiltInFictitiousFunctionClassFactory2;
        final HashMap hashMap = new HashMap();
        Single list = Observable.fromIterable(set).map(deserializeToSendMoneyScenarioEntity(hashMap)).toList();
        if ((list instanceof FuseToObservable ? (char) 21 : 'V') != 'V') {
            int i = getAuthRequestContext + 69;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            BuiltInFictitiousFunctionClassFactory2 = ((FuseToObservable) list).getAuthRequestContext();
            int i3 = getAuthRequestContext + 109;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
        } else {
            BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        try {
            Observable map = BuiltInFictitiousFunctionClassFactory2.map(new Function() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return DefaultSendMoneyScenariosEntityData.lambda$convertJsonToMenuItem$1(hashMap, (List) obj);
                }
            });
            int i5 = getAuthRequestContext + 53;
            lookAheadTest = i5 % 128;
            int i6 = i5 % 2;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    private Function<Map.Entry<String, String>, SendMoneyScenarioEntity> deserializeToSendMoneyScenarioEntity(final Map<String, SendMoneyScenarioEntity> map) {
        Function<Map.Entry<String, String>, SendMoneyScenarioEntity> function = new Function() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultSendMoneyScenariosEntityData.this.m1921xe83b9302(map, (Map.Entry) obj);
            }
        };
        try {
            int i = getAuthRequestContext + 69;
            lookAheadTest = i % 128;
            if ((i % 2 == 0 ? (char) 5 : 'T') != 5) {
                return function;
            }
            Object obj = null;
            obj.hashCode();
            return function;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$deserializeToSendMoneyScenarioEntity$3$id-dana-data-sendmoney-repository-source-local-DefaultSendMoneyScenariosEntityData  reason: not valid java name */
    public /* synthetic */ SendMoneyScenarioEntity m1921xe83b9302(Map map, Map.Entry entry) throws Exception {
        int i = lookAheadTest + 61;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            String str = (String) entry.getKey();
            SendMoneyScenarioEntity sendMoneyScenarioEntity = (SendMoneyScenarioEntity) this.serializer.deserialize((String) entry.getValue(), SendMoneyScenarioEntity.class);
            sendMoneyScenarioEntity.key = str;
            map.put(str, sendMoneyScenarioEntity);
            Object[] objArr = null;
            int length = objArr.length;
            return sendMoneyScenarioEntity;
        }
        try {
            String str2 = (String) entry.getKey();
            try {
                SendMoneyScenarioEntity sendMoneyScenarioEntity2 = (SendMoneyScenarioEntity) this.serializer.deserialize((String) entry.getValue(), SendMoneyScenarioEntity.class);
                sendMoneyScenarioEntity2.key = str2;
                map.put(str2, sendMoneyScenarioEntity2);
                return sendMoneyScenarioEntity2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private Callable<Set<Map.Entry<String, String>>> getMenuItemsFromFile() {
        Callable<Set<Map.Entry<String, String>>> callable = new Callable() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultSendMoneyScenariosEntityData.this.m1924x727c321();
            }
        };
        int i = getAuthRequestContext + 117;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        return callable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMenuItemsFromFile$4$id-dana-data-sendmoney-repository-source-local-DefaultSendMoneyScenariosEntityData  reason: not valid java name */
    public /* synthetic */ Set m1924x727c321() throws Exception {
        int i = lookAheadTest + 31;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            try {
                Set<Map.Entry<String, String>> entrySet = this.serializer.deserializeMap(JsonUtil.PlaceComponentResult(this.context, RECIPIENT_HOME_MENU_JSON)).entrySet();
                Object[] objArr = null;
                int length = objArr.length;
                return entrySet;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.serializer.deserializeMap(JsonUtil.PlaceComponentResult(this.context, RECIPIENT_HOME_MENU_JSON)).entrySet();
    }

    @Override // id.dana.data.sendmoney.repository.source.SendMoneyScenariosEntityData
    public Observable<List<SendMoneyScenarioEntity>> getSendMoneyScenarios() {
        try {
            Observable<List<SendMoneyScenarioEntity>> flatMap = Observable.fromCallable(new Callable() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData$$ExternalSyntheticLambda4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return DefaultSendMoneyScenariosEntityData.this.m1926xf22d9fca();
                }
            }).flatMap(getMenuItemForEachCategory());
            int i = getAuthRequestContext + 87;
            lookAheadTest = i % 128;
            if ((i % 2 == 0 ? 'A' : '3') != '3') {
                Object[] objArr = null;
                int length = objArr.length;
                return flatMap;
            }
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getSendMoneyScenarios$5$id-dana-data-sendmoney-repository-source-local-DefaultSendMoneyScenariosEntityData  reason: not valid java name */
    public /* synthetic */ List m1926xf22d9fca() throws Exception {
        List<String> call = getMenuCategories().call();
        if (call != null) {
            int i = getAuthRequestContext + 25;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            try {
                int i3 = getAuthRequestContext + 37;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                return call;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            throw new CallableReturnNullError("DefaultSendMoneyScenariosEntityData#getSendMoneyScenarios");
        } catch (Exception e2) {
            throw e2;
        }
    }

    private Function<List<String>, ObservableSource<List<SendMoneyScenarioEntity>>> getMenuItemForEachCategory() {
        Function<List<String>, ObservableSource<List<SendMoneyScenarioEntity>>> function = new Function() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultSendMoneyScenariosEntityData.this.m1923xa608d1cf((List) obj);
            }
        };
        int i = getAuthRequestContext + 25;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        return function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMenuItemForEachCategory$7$id-dana-data-sendmoney-repository-source-local-DefaultSendMoneyScenariosEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1923xa608d1cf(final List list) throws Exception {
        ObservableSource flatMap = getSendMoneyMenuItems().flatMap(new Function() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DefaultSendMoneyScenariosEntityData.lambda$getMenuItemForEachCategory$6(list, (Map) obj);
            }
        });
        try {
            int i = getAuthRequestContext + 101;
            lookAheadTest = i % 128;
            if ((i % 2 == 0 ? 'L' : 'Q') != 'Q') {
                Object obj = null;
                obj.hashCode();
                return flatMap;
            }
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$getMenuItemForEachCategory$6(List list, Map map) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i = getAuthRequestContext + 27;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        while (true) {
            if (it.hasNext()) {
                SendMoneyScenarioEntity sendMoneyScenarioEntity = (SendMoneyScenarioEntity) map.get((String) it.next());
                if (!(sendMoneyScenarioEntity == null)) {
                    int i3 = getAuthRequestContext + 79;
                    lookAheadTest = i3 % 128;
                    if (i3 % 2 == 0) {
                        arrayList.add(sendMoneyScenarioEntity);
                        Object obj = null;
                        obj.hashCode();
                    } else {
                        arrayList.add(sendMoneyScenarioEntity);
                    }
                }
            } else {
                return Observable.just(arrayList);
            }
        }
    }

    private Callable<List<String>> getMenuCategories() {
        Callable<List<String>> callable = new Callable() { // from class: id.dana.data.sendmoney.repository.source.local.DefaultSendMoneyScenariosEntityData$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultSendMoneyScenariosEntityData.this.m1922x5d6dab37();
            }
        };
        int i = lookAheadTest + 77;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return callable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getMenuCategories$8$id-dana-data-sendmoney-repository-source-local-DefaultSendMoneyScenariosEntityData  reason: not valid java name */
    public /* synthetic */ List m1922x5d6dab37() throws Exception {
        int i = getAuthRequestContext + 13;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        Map<String, String> deserializeMap = this.serializer.deserializeMap(JsonUtil.PlaceComponentResult(this.context, RECIPIENT_HOME_MENU_LIST));
        Object[] objArr = new Object[1];
        a(21 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new char[]{18850, 47310, 12288, 39013, 11251, 16235, 53196, 35365, 5412, 20187, 55320, 676, 12713, 62852, 31736, 2621, 4158, 2416, 50127, 30276}, objArr);
        List<String> deserializeList = this.serializer.deserializeList(deserializeMap.get(((String) objArr[0]).intern()));
        int i3 = lookAheadTest + 79;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 != 0 ? '*' : '\n') != '*') {
            return deserializeList;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
        return deserializeList;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? (char) 29 : (char) 14) == 29) {
                int i2 = $11 + 25;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i4 = 58224;
                int i5 = 0;
                while (true) {
                    if (!(i5 < 16)) {
                        break;
                    }
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                    i4 -= 40503;
                    i5++;
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
                int i6 = $11 + 1;
                $10 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
