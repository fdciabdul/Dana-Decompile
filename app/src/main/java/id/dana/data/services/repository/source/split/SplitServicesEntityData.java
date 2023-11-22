package id.dana.data.services.repository.source.split;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.danah5.DanaH5;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.services.repository.source.ServicesEntityData;
import id.dana.data.services.repository.source.model.CategoryHighlightedFeature;
import id.dana.data.services.repository.source.model.CategoryServices;
import id.dana.data.services.repository.source.model.DefaultServiceCategory;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.domain.services.Category;
import id.dana.utils.exception.CallableReturnNullError;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import org.json.JSONArray;
import org.json.JSONObject;

@Singleton
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b*\u0010+J'\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H\u0016¢\u0006\u0004\b\r\u0010\bJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u001b\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00050\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u000bJ\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\"\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00038CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/data/services/repository/source/split/SplitServicesEntityData;", "Lid/dana/data/services/repository/source/ServicesEntityData;", "Lio/reactivex/Observable;", "", "", "", "Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "getAllServices", "()Lio/reactivex/Observable;", "category", "getCategories", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/services/repository/source/model/CategoryHighlightedFeature;", "getCategoryHighlightedFeature", "Lid/dana/data/toggle/traffictype/BaseTrafficType;", "ttUser", "getListOfServices", "(Lid/dana/data/toggle/traffictype/BaseTrafficType;)Ljava/util/List;", "getRawServices", "Lid/dana/data/services/repository/source/model/CategoryServices;", "getSections", DanaH5.SERVICE_KEY, "getService", "categoryKey", "getServicesByCategoryKey", "(Lid/dana/data/toggle/traffictype/BaseTrafficType;Ljava/lang/String;)Ljava/lang/String;", "Lorg/json/JSONArray;", "getServicesByCategoryKeyFromLocal", "(Ljava/lang/String;)Lorg/json/JSONArray;", "getThirdPartyEntity", "(Lid/dana/data/toggle/traffictype/BaseTrafficType;Ljava/lang/String;)Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "getThirdPartyEntityFromLocal", "(Ljava/lang/String;)Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "getListOfServiceEntity", "()Ljava/util/List;", "listOfServiceEntity", "getServiceMap", "()Ljava/util/Map;", "serviceMap", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitServicesEntityData implements ServicesEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private final SplitFacade splitFacade;
    private static char[] MyBillsEntityDataFactory = {39856, 39858, 39841, 39854, 39852, 39844, 39843, 39834, 39860, 39853, 39850, 39849, 39857, 39855, 39838, 39744, 39839, 39840};
    private static boolean PlaceComponentResult = true;
    private static boolean getAuthRequestContext = true;
    private static int BuiltInFictitiousFunctionClassFactory = 909155093;

    public static /* synthetic */ List $r8$lambda$6Fx2lK6JoyaZSVasL3MPBncqrGM(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        try {
            if (i % 2 == 0) {
                return m2028getSections$lambda6(baseTrafficType);
            }
            List m2028getSections$lambda6 = m2028getSections$lambda6(baseTrafficType);
            Object[] objArr = null;
            int length = objArr.length;
            return m2028getSections$lambda6;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$8xulcRRP1KUf7rTcxI7Vy-Oo894 */
    public static /* synthetic */ List m2021$r8$lambda$8xulcRRP1KUf7rTcxI7VyOo894(SplitServicesEntityData splitServicesEntityData, BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        List m2027getRawServices$lambda10 = m2027getRawServices$lambda10(splitServicesEntityData, baseTrafficType);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return m2027getRawServices$lambda10;
    }

    public static /* synthetic */ ThirdPartyEntity $r8$lambda$DVGJMfynbrbC23XslpYwZmd_Uts(BaseTrafficType baseTrafficType, String str) {
        ThirdPartyEntity m2032getThirdPartyEntity$lambda32;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 117;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        try {
            if (!(i % 2 == 0)) {
                m2032getThirdPartyEntity$lambda32 = m2032getThirdPartyEntity$lambda32(baseTrafficType, str);
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                m2032getThirdPartyEntity$lambda32 = m2032getThirdPartyEntity$lambda32(baseTrafficType, str);
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            int i3 = i2 % 2;
            return m2032getThirdPartyEntity$lambda32;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ Map $r8$lambda$EZlxn7t4hqany63drqTC7Ar2gt0(SplitServicesEntityData splitServicesEntityData, BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 71;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Map m2024getAllServices$lambda26 = m2024getAllServices$lambda26(splitServicesEntityData, baseTrafficType);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 == 0 ? ';' : 'C') != ';') {
            return m2024getAllServices$lambda26;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return m2024getAllServices$lambda26;
    }

    /* renamed from: $r8$lambda$Sv_7wA5SV_eA5f-JejC8hY1b2-8 */
    public static /* synthetic */ List m2022$r8$lambda$Sv_7wA5SV_eA5fJejC8hY1b28(String str, BaseTrafficType baseTrafficType) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            List m2025getCategories$lambda7 = m2025getCategories$lambda7(str, baseTrafficType);
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 41;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                int i4 = i3 % 2;
                return m2025getCategories$lambda7;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$jzmik-NsB9p1o1oxbFYa9bVFPzQ */
    public static /* synthetic */ ObservableSource m2023$r8$lambda$jzmikNsB9p1o1oxbFYa9bVFPzQ(SplitServicesEntityData splitServicesEntityData, String str, Throwable th) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        ObservableSource m2033getThirdPartyEntity$lambda33 = m2033getThirdPartyEntity$lambda33(splitServicesEntityData, str, th);
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            if (!(i3 % 2 != 0)) {
                int i4 = 70 / 0;
                return m2033getThirdPartyEntity$lambda33;
            }
            return m2033getThirdPartyEntity$lambda33;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$lnnNU7Iuw24ltuPW_EsmnSF_eIQ(String str, SplitServicesEntityData splitServicesEntityData, Throwable th) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        ObservableSource m2031getServicesByCategoryKey$lambda31 = m2031getServicesByCategoryKey$lambda31(str, splitServicesEntityData, th);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 45;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 23 : (char) 0) != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return m2031getServicesByCategoryKey$lambda31;
        }
        return m2031getServicesByCategoryKey$lambda31;
    }

    public static /* synthetic */ CategoryHighlightedFeature $r8$lambda$uIC4MkxLrwoTB9Kr_rpeLZYleGc(BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        boolean z = i % 2 == 0;
        CategoryHighlightedFeature m2026getCategoryHighlightedFeature$lambda29 = m2026getCategoryHighlightedFeature$lambda29(baseTrafficType);
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m2026getCategoryHighlightedFeature$lambda29;
    }

    public static /* synthetic */ String $r8$lambda$yF_JhyS7G58VvskFbh0fo4YzkM4(BaseTrafficType baseTrafficType, String str) {
        String m2030getServicesByCategoryKey$lambda30;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if ((i % 2 == 0 ? ']' : '\t') != '\t') {
            try {
                m2030getServicesByCategoryKey$lambda30 = m2030getServicesByCategoryKey$lambda30(baseTrafficType, str);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            m2030getServicesByCategoryKey$lambda30 = m2030getServicesByCategoryKey$lambda30(baseTrafficType, str);
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        return m2030getServicesByCategoryKey$lambda30;
    }

    public static /* synthetic */ ThirdPartyEntity $r8$lambda$zcugg84IiHK52sjulwYsty4ixMY(String str, BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 23;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        ThirdPartyEntity m2029getService$lambda28 = m2029getService$lambda28(str, baseTrafficType);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 13;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return m2029getService$lambda28;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x000d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @javax.inject.Inject
    public SplitServicesEntityData(id.dana.data.toggle.SplitFacade r2) {
        /*
            r1 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)     // Catch: java.lang.Exception -> Lb
            r1.<init>()     // Catch: java.lang.Exception -> Lb
            r1.splitFacade = r2     // Catch: java.lang.Exception -> Lb
            return
        Lb:
            r2 = move-exception
            throw r2
        Ld:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.split.SplitServicesEntityData.<init>(id.dana.data.toggle.SplitFacade):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0062 A[SYNTHETIC] */
    @kotlin.jvm.JvmName(name = "getServiceMap")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Map<java.lang.String, id.dana.data.homeinfo.model.ThirdPartyEntity> getServiceMap() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.split.SplitServicesEntityData.getServiceMap():java.util.Map");
    }

    @JvmName(name = "getListOfServiceEntity")
    private final List<ThirdPartyEntity> getListOfServiceEntity() {
        Map emptyMap;
        Object obj;
        ConfigCenter configCenter = ConfigCenter.getInstance();
        Object[] objArr = new Object[1];
        Object[] objArr2 = null;
        a(126 - TextUtils.lastIndexOf("", '0', 0), new byte[]{-110, -124, -127, -117, -111, -121, -124, -112}, null, null, objArr);
        JSONObject sectionConfig = configCenter.getSectionConfig(((String) objArr[0]).intern());
        Intrinsics.checkNotNull(sectionConfig);
        try {
            Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.getAuthRequestContext(sectionConfig), new TypeToken<Map<String, ? extends String>>() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$special$$inlined$toMap$default$2
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "");
            emptyMap = (Map) fromJson;
        } catch (Exception unused) {
            emptyMap = MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        for (Map.Entry entry : emptyMap.entrySet()) {
            if (StringsKt.startsWith$default((String) entry.getKey(), "service_", false, 2, (Object) null)) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (i3 % 2 != 0) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                    int i4 = 83 / 0;
                } else {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (true) {
            if ((it.hasNext() ? (char) 22 : 'M') == 'M') {
                return arrayList;
            }
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 47;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            int i6 = i5 % 2;
            Map.Entry entry2 = (Map.Entry) it.next();
            try {
                obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2((String) entry2.getValue(), null), (Class<Object>) ThirdPartyEntity.class);
            } catch (Exception unused2) {
                obj = null;
            }
            ThirdPartyEntity thirdPartyEntity = (ThirdPartyEntity) obj;
            if (thirdPartyEntity != null) {
                thirdPartyEntity.setKey((String) entry2.getKey());
            } else {
                thirdPartyEntity = null;
            }
            if ((thirdPartyEntity != null ? '7' : 'F') == '7') {
                int i7 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 89;
                KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                if ((i7 % 2 != 0 ? '9' : 'M') != '9') {
                    arrayList.add(thirdPartyEntity);
                } else {
                    arrayList.add(thirdPartyEntity);
                    int length = objArr2.length;
                }
            }
        }
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<List<CategoryServices>> getSections() {
        Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitServicesEntityData.$r8$lambda$6Fx2lK6JoyaZSVasL3MPBncqrGM((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return map;
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<List<String>> getCategories(final String category) {
        Intrinsics.checkNotNullParameter(category, "");
        Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitServicesEntityData.m2022$r8$lambda$Sv_7wA5SV_eA5fJejC8hY1b28(category, (BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 75;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? (char) 14 : '!') != 14) {
                return map;
            }
            Object obj = null;
            obj.hashCode();
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<List<ThirdPartyEntity>> getRawServices() {
        try {
            Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitServicesEntityData.m2021$r8$lambda$8xulcRRP1KUf7rTcxI7VyOo894(SplitServicesEntityData.this, (BaseTrafficType) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 87;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if ((i % 2 == 0 ? 'E' : Typography.quote) != '\"') {
                int i2 = 37 / 0;
                return map;
            }
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<Map<String, List<ThirdPartyEntity>>> getAllServices() {
        Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitServicesEntityData.$r8$lambda$EZlxn7t4hqany63drqTC7Ar2gt0(SplitServicesEntityData.this, (BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 33;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:207:0x0145, code lost:
    
        if (((id.dana.data.homeinfo.model.ThirdPartyEntity) r7).getName() != null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0156, code lost:
    
        if (r9 != null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0158, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x015a, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x00a4 A[SYNTHETIC] */
    /* renamed from: getAllServices$lambda-26 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.Map m2024getAllServices$lambda26(id.dana.data.services.repository.source.split.SplitServicesEntityData r11, id.dana.data.toggle.traffictype.BaseTrafficType r12) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.split.SplitServicesEntityData.m2024getAllServices$lambda26(id.dana.data.services.repository.source.split.SplitServicesEntityData, id.dana.data.toggle.traffictype.BaseTrafficType):java.util.Map");
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<ThirdPartyEntity> getService(final String r4) {
        try {
            Intrinsics.checkNotNullParameter(r4, "");
            Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitServicesEntityData.$r8$lambda$zcugg84IiHK52sjulwYsty4ixMY(r4, (BaseTrafficType) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if (!(i % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
                return map;
            }
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.services.repository.source.ServicesEntityData
    public final Observable<CategoryHighlightedFeature> getCategoryHighlightedFeature() {
        try {
            try {
                Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$$ExternalSyntheticLambda3
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return SplitServicesEntityData.$r8$lambda$uIC4MkxLrwoTB9Kr_rpeLZYleGc((BaseTrafficType) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(map, "");
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
                return map;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final String getServicesByCategoryKey(final BaseTrafficType ttUser, final String categoryKey) {
        try {
            try {
                Object blockingFirst = Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$$ExternalSyntheticLambda5
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return SplitServicesEntityData.$r8$lambda$yF_JhyS7G58VvskFbh0fo4YzkM4(BaseTrafficType.this, categoryKey);
                    }
                }).onErrorResumeNext(new Function() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$$ExternalSyntheticLambda6
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return SplitServicesEntityData.$r8$lambda$lnnNU7Iuw24ltuPW_EsmnSF_eIQ(categoryKey, this, (Throwable) obj);
                    }
                }).blockingFirst();
                Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
                String str = (String) blockingFirst;
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 5;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 != 0 ? 'O' : '6') != 'O') {
                    return str;
                }
                Object obj = null;
                obj.hashCode();
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x002f, code lost:
    
        if ((java.lang.String.class.isAssignableFrom(java.lang.String.class) ? 4 : 'D') != 4) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0044, code lost:
    
        if (java.lang.String.class.isAssignableFrom(java.lang.String.class) != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0046, code lost:
    
        r5 = id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
        id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0050, code lost:
    
        if (r4 != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0053, code lost:
    
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0054, code lost:
    
        if (r3 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x005c, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.String");
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x005d, code lost:
    
        if (r4 == null) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0061, code lost:
    
        r5 = id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0065, code lost:
    
        id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0067, code lost:
    
        r5 = r5 % 2;
        r5 = id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 + 39;
        id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
        r5 = r5 % 2;
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0079, code lost:
    
        if (r3 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x007b, code lost:
    
        r5 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x007e, code lost:
    
        r5 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0080, code lost:
    
        if (r5 == 'O') goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0082, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x008a, code lost:
    
        throw new id.dana.utils.exception.CallableReturnNullError("SplitServicesEntityData#getServicesByCategoryKey");
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0090, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type kotlin.String");
     */
    /* renamed from: getServicesByCategoryKey$lambda-30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.String m2030getServicesByCategoryKey$lambda30(id.dana.data.toggle.traffictype.BaseTrafficType r4, java.lang.String r5) {
        /*
            int r0 = id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L91
            int r0 = r0 + 83
            int r1 = r0 % 128
            id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1     // Catch: java.lang.Exception -> L91
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
            java.lang.String r3 = ""
            if (r0 == r1) goto L32
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            java.lang.String r4 = r4.getAuthRequestContext(r5, r1)
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            boolean r5 = r5.isAssignableFrom(r0)
            r0 = 4
            if (r5 == 0) goto L2d
            r5 = 4
            goto L2f
        L2d:
            r5 = 68
        L2f:
            if (r5 == r0) goto L46
            goto L5d
        L32:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            java.lang.String r4 = r4.getAuthRequestContext(r5, r1)
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            boolean r5 = r5.isAssignableFrom(r0)
            if (r5 == 0) goto L5d
        L46:
            int r5 = id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r5 = r5 + 123
            int r0 = r5 % 128
            id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r5 = r5 % 2
            if (r4 != 0) goto L53
            goto L54
        L53:
            r3 = r4
        L54:
            if (r3 == 0) goto L57
            goto L74
        L57:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            r4.<init>(r2)
            throw r4
        L5d:
            if (r4 == 0) goto L8b
            int r5 = id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L91
            int r5 = r5 + 105
            int r0 = r5 % 128
            id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L91
            int r5 = r5 % 2
            int r5 = id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r5 = r5 + 39
            int r0 = r5 % 128
            id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r5 = r5 % 2
            r3 = r4
        L74:
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            r4 = 79
            if (r3 == 0) goto L7e
            r5 = 64
            goto L80
        L7e:
            r5 = 79
        L80:
            if (r5 == r4) goto L83
            return r3
        L83:
            id.dana.utils.exception.CallableReturnNullError r4 = new id.dana.utils.exception.CallableReturnNullError
            java.lang.String r5 = "SplitServicesEntityData#getServicesByCategoryKey"
            r4.<init>(r5)
            throw r4
        L8b:
            java.lang.NullPointerException r4 = new java.lang.NullPointerException
            r4.<init>(r2)
            throw r4
        L91:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.split.SplitServicesEntityData.m2030getServicesByCategoryKey$lambda30(id.dana.data.toggle.traffictype.BaseTrafficType, java.lang.String):java.lang.String");
    }

    /* renamed from: getServicesByCategoryKey$lambda-31 */
    private static final ObservableSource m2031getServicesByCategoryKey$lambda31(String str, SplitServicesEntityData splitServicesEntityData, Throwable th) {
        Observable just;
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if (!(i % 2 != 0)) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(splitServicesEntityData, "");
                Intrinsics.checkNotNullParameter(th, "");
                just = Observable.just(String.valueOf(ConfigCenter.getInstance().getJSONArrayConfig(str, splitServicesEntityData.getServicesByCategoryKeyFromLocal(str))));
                Object obj = null;
                obj.hashCode();
            } else {
                try {
                    Intrinsics.checkNotNullParameter(str, "");
                    Intrinsics.checkNotNullParameter(splitServicesEntityData, "");
                    Intrinsics.checkNotNullParameter(th, "");
                    just = Observable.just(String.valueOf(ConfigCenter.getInstance().getJSONArrayConfig(str, splitServicesEntityData.getServicesByCategoryKeyFromLocal(str))));
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 59;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            return just;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final org.json.JSONArray getServicesByCategoryKeyFromLocal(java.lang.String r4) {
        /*
            r3 = this;
            id.dana.data.services.repository.source.model.DefaultServiceCategory r0 = id.dana.data.services.repository.source.model.DefaultServiceCategory.INSTANCE
            java.util.HashMap r0 = r0.getDefaultCategory()
            java.lang.Object r4 = r0.get(r4)
            java.util.List r4 = (java.util.List) r4
            java.util.Collection r4 = (java.util.Collection) r4
            r0 = 88
            r1 = 94
            if (r4 == 0) goto L17
            r2 = 88
            goto L19
        L17:
            r2 = 94
        L19:
            if (r2 == r1) goto L2a
            boolean r1 = r4.isEmpty()     // Catch: java.lang.Exception -> L4f
            r2 = 82
            if (r1 != 0) goto L24
            goto L26
        L24:
            r0 = 82
        L26:
            if (r0 == r2) goto L2a
            r0 = 0
            goto L35
        L2a:
            r0 = 1
            int r1 = id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L4f
            int r1 = r1 + 97
            int r2 = r1 % 128
            id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2     // Catch: java.lang.Exception -> L4d
            int r1 = r1 % 2
        L35:
            if (r0 == 0) goto L3d
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>(r4)
            goto L4c
        L3d:
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            int r4 = id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r4 = r4 + 117
            int r1 = r4 % 128
            id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r4 = r4 % 2
        L4c:
            return r0
        L4d:
            r4 = move-exception
            throw r4
        L4f:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.split.SplitServicesEntityData.getServicesByCategoryKeyFromLocal(java.lang.String):org.json.JSONArray");
    }

    private final ThirdPartyEntity getThirdPartyEntity(final BaseTrafficType ttUser, final String r3) {
        Object blockingFirst = Observable.fromCallable(new Callable() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return SplitServicesEntityData.$r8$lambda$DVGJMfynbrbC23XslpYwZmd_Uts(BaseTrafficType.this, r3);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.services.repository.source.split.SplitServicesEntityData$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitServicesEntityData.m2023$r8$lambda$jzmikNsB9p1o1oxbFYa9bVFPzQ(SplitServicesEntityData.this, r3, (Throwable) obj);
            }
        }).blockingFirst();
        ThirdPartyEntity thirdPartyEntity = (ThirdPartyEntity) blockingFirst;
        thirdPartyEntity.setKey(r3);
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        return thirdPartyEntity;
    }

    /* renamed from: getThirdPartyEntity$lambda-33 */
    private static final ObservableSource m2033getThirdPartyEntity$lambda33(SplitServicesEntityData splitServicesEntityData, String str, Throwable th) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(splitServicesEntityData, "");
            Intrinsics.checkNotNullParameter(str, "");
            try {
                Intrinsics.checkNotNullParameter(th, "");
                ThirdPartyEntity thirdPartyEntity = splitServicesEntityData.getServiceMap().get(str);
                if (thirdPartyEntity == null) {
                    thirdPartyEntity = splitServicesEntityData.getThirdPartyEntityFromLocal(str);
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 37;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                    int i4 = i3 % 2;
                }
                return Observable.just(thirdPartyEntity);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final ThirdPartyEntity getThirdPartyEntityFromLocal(String r41) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
                ThirdPartyEntity thirdPartyEntity = DefaultServiceCategory.INSTANCE.getDefaultServices().get(r41);
                if (thirdPartyEntity == null) {
                    thirdPartyEntity = new ThirdPartyEntity(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, null, null, false, null, null, null, null, false, null, null, null, null, null, null, -8193, 7, null);
                }
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 49;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? 'X' : 'D') != 'D') {
                    int i4 = 9 / 0;
                    return thirdPartyEntity;
                }
                return thirdPartyEntity;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x012b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<id.dana.data.homeinfo.model.ThirdPartyEntity> getListOfServices(id.dana.data.toggle.traffictype.BaseTrafficType r11) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.split.SplitServicesEntityData.getListOfServices(id.dana.data.toggle.traffictype.BaseTrafficType):java.util.List");
    }

    /* renamed from: getSections$lambda-6 */
    private static final List m2028getSections$lambda6(BaseTrafficType baseTrafficType) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            List<CategoryServices> list = CategoryServices.INSTANCE.getDefault();
            String authRequestContext = baseTrafficType.getAuthRequestContext(Category.SERVICES, true);
            if (!(authRequestContext == null)) {
                try {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    List<CategoryServices> list2 = (List) JSONExtKt.PlaceComponentResult().fromJson(authRequestContext, TypeToken.getParameterized(List.class, CategoryServices.class).getType());
                    if ((list2 == null ? Typography.greater : (char) 28) != '>') {
                        list = list2;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
            KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
            if (i5 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
                return list;
            }
            return list;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: getCategories$lambda-7 */
    private static final List m2025getCategories$lambda7(String str, BaseTrafficType baseTrafficType) {
        String str2 = "";
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        String authRequestContext = baseTrafficType.getAuthRequestContext(str, true);
        try {
            if (String.class.isAssignableFrom(String.class)) {
                if (authRequestContext == null) {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                    int i2 = i % 2;
                } else {
                    str2 = authRequestContext;
                }
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                authRequestContext = str2;
            } else {
                if (authRequestContext == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 83;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            }
            String str3 = authRequestContext;
            List<String> KClassImpl$Data$declaredNonStaticMembers$22 = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(new JSONArray(authRequestContext));
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
            if ((i5 % 2 == 0 ? (char) 3 : ']') != 3) {
                return KClassImpl$Data$declaredNonStaticMembers$22;
            }
            int i6 = 17 / 0;
            return KClassImpl$Data$declaredNonStaticMembers$22;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x003f, code lost:
    
        if ((r4 == null) != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0058, code lost:
    
        if ((((id.dana.data.homeinfo.model.ThirdPartyEntity) r0).getName() != null ? 'B' : 21) != 'B') goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x005a, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x005c, code lost:
    
        r1 = true;
     */
    /* renamed from: getRawServices$lambda-10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.List m2027getRawServices$lambda10(id.dana.data.services.repository.source.split.SplitServicesEntityData r7, id.dana.data.toggle.traffictype.BaseTrafficType r8) {
        /*
            Method dump skipped, instructions count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.split.SplitServicesEntityData.m2027getRawServices$lambda10(id.dana.data.services.repository.source.split.SplitServicesEntityData, id.dana.data.toggle.traffictype.BaseTrafficType):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0026, code lost:
    
        if ((id.dana.data.homeinfo.model.ThirdPartyEntity.class.isAssignableFrom(org.json.JSONArray.class)) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003e, code lost:
    
        if ((id.dana.data.homeinfo.model.ThirdPartyEntity.class.isAssignableFrom(org.json.JSONArray.class)) != true) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0040, code lost:
    
        if (r7 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0042, code lost:
    
        r7 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult().fromJson(id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r7, null), (java.lang.Class<java.lang.Object>) id.dana.data.homeinfo.model.ThirdPartyEntity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0050, code lost:
    
        r0 = id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2 + 87;
        id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0 % 128;
        r0 = r0 % 2;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x005b, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0067, code lost:
    
        if (r7 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0069, code lost:
    
        r1 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x006c, code lost:
    
        r1 = 'C';
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x006e, code lost:
    
        if (r1 == 14) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0070, code lost:
    
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0071, code lost:
    
        r2 = (id.dana.data.homeinfo.model.ThirdPartyEntity) new org.json.JSONArray(r4);
     */
    /* renamed from: getService$lambda-28 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final id.dana.data.homeinfo.model.ThirdPartyEntity m2029getService$lambda28(java.lang.String r6, id.dana.data.toggle.traffictype.BaseTrafficType r7) {
        /*
            int r0 = id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 25
            int r1 = r0 % 128
            id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            java.lang.String r4 = ""
            if (r0 != 0) goto L29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r4)
            java.lang.String r7 = r7.getAuthRequestContext(r6, r1)
            java.lang.Class<id.dana.data.homeinfo.model.ThirdPartyEntity> r0 = id.dana.data.homeinfo.model.ThirdPartyEntity.class
            java.lang.Class<org.json.JSONArray> r5 = org.json.JSONArray.class
            boolean r0 = r0.isAssignableFrom(r5)
            if (r0 == 0) goto L26
            r1 = 1
        L26:
            if (r1 == 0) goto L40
            goto L65
        L29:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r4)
            java.lang.String r7 = r7.getAuthRequestContext(r6, r3)
            java.lang.Class<id.dana.data.homeinfo.model.ThirdPartyEntity> r0 = id.dana.data.homeinfo.model.ThirdPartyEntity.class
            java.lang.Class<org.json.JSONArray> r5 = org.json.JSONArray.class
            boolean r0 = r0.isAssignableFrom(r5)
            if (r0 == 0) goto L3e
            r1 = 1
        L3e:
            if (r1 == r3) goto L65
        L40:
            if (r7 == 0) goto L61
            com.google.gson.Gson r0 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult()     // Catch: java.lang.Exception -> L5b
            java.lang.String r7 = id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r7, r2)     // Catch: java.lang.Exception -> L5b
            java.lang.Class<id.dana.data.homeinfo.model.ThirdPartyEntity> r1 = id.dana.data.homeinfo.model.ThirdPartyEntity.class
            java.lang.Object r7 = r0.fromJson(r7, r1)     // Catch: java.lang.Exception -> L5b
            int r0 = id.dana.data.services.repository.source.split.SplitServicesEntityData.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.data.services.repository.source.split.SplitServicesEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            int r0 = r0 % 2
            goto L5c
        L5b:
            r7 = r2
        L5c:
            if (r7 != 0) goto L5f
            goto L61
        L5f:
            r2 = r7
            goto L79
        L61:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            goto L79
        L65:
            r0 = 14
            if (r7 != 0) goto L6c
            r1 = 14
            goto L6e
        L6c:
            r1 = 67
        L6e:
            if (r1 == r0) goto L71
            r4 = r7
        L71:
            org.json.JSONArray r7 = new org.json.JSONArray
            r7.<init>(r4)
            r2 = r7
            id.dana.data.homeinfo.model.ThirdPartyEntity r2 = (id.dana.data.homeinfo.model.ThirdPartyEntity) r2
        L79:
            id.dana.data.homeinfo.model.ThirdPartyEntity r2 = (id.dana.data.homeinfo.model.ThirdPartyEntity) r2
            r2.setKey(r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.services.repository.source.split.SplitServicesEntityData.m2029getService$lambda28(java.lang.String, id.dana.data.toggle.traffictype.BaseTrafficType):id.dana.data.homeinfo.model.ThirdPartyEntity");
    }

    /* renamed from: getCategoryHighlightedFeature$lambda-29 */
    private static final CategoryHighlightedFeature m2026getCategoryHighlightedFeature$lambda29(BaseTrafficType baseTrafficType) {
        String str = "";
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Object categoryHighlightedFeature = new CategoryHighlightedFeature(null, 0, false, 0, 15, null);
        Object[] objArr = new Object[1];
        Object obj = null;
        a(126 - TextUtils.indexOf((CharSequence) "", '0', 0), new byte[]{-124, -121, -113, -125, -126, -124, -114, -119, -115, -124, -125, -118, -123, -117, -116, -118, -123, -117, -118, -119, -120, -121, -122, -123, -124, -125, -126, -127}, null, null, objArr);
        String authRequestContext = baseTrafficType.getAuthRequestContext(((String) objArr[0]).intern(), false);
        if (CategoryHighlightedFeature.class.isAssignableFrom(JSONArray.class)) {
            if ((authRequestContext == null ? 'F' : '7') != '7') {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
            } else {
                str = authRequestContext;
            }
            categoryHighlightedFeature = (CategoryHighlightedFeature) new JSONArray(str);
        } else {
            if (!(authRequestContext == null)) {
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 15;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                try {
                    obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) CategoryHighlightedFeature.class);
                } catch (Exception unused) {
                }
                if ((obj == null ? 'R' : '7') == '7') {
                    categoryHighlightedFeature = obj;
                }
            }
        }
        CategoryHighlightedFeature categoryHighlightedFeature2 = (CategoryHighlightedFeature) categoryHighlightedFeature;
        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 39;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        int i6 = i5 % 2;
        return categoryHighlightedFeature2;
    }

    /* renamed from: getThirdPartyEntity$lambda-32 */
    private static final ThirdPartyEntity m2032getThirdPartyEntity$lambda32(BaseTrafficType baseTrafficType, String str) {
        Object obj;
        String str2 = "";
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Intrinsics.checkNotNullParameter(str, "");
        String authRequestContext = baseTrafficType.getAuthRequestContext(str, true);
        Object obj2 = null;
        if (ThirdPartyEntity.class.isAssignableFrom(JSONArray.class)) {
            if (authRequestContext == null) {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                int i2 = i % 2;
            } else {
                str2 = authRequestContext;
            }
            obj2 = (ThirdPartyEntity) new JSONArray(str2);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
            int i4 = i3 % 2;
        } else {
            if ((authRequestContext != null ? '8' : '+') == '8') {
                try {
                    int i5 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 3;
                    try {
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        try {
                            if (i5 % 2 != 0) {
                                int i6 = 40 / 0;
                                obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) ThirdPartyEntity.class);
                            } else {
                                obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) ThirdPartyEntity.class);
                            }
                        } catch (Exception unused) {
                            obj = null;
                        }
                        if (obj != null) {
                            obj2 = obj;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            Intrinsics.checkNotNull(null);
        }
        ThirdPartyEntity thirdPartyEntity = (ThirdPartyEntity) obj2;
        if (thirdPartyEntity == null) {
            throw new CallableReturnNullError("SplitServicesEntityData#getThirdPartyEntity");
        }
        int i7 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i7 % 128;
        int i8 = i7 % 2;
        return thirdPartyEntity;
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = MyBillsEntityDataFactory;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        try {
            int i4 = (int) (4571606982258105150L ^ BuiltInFictitiousFunctionClassFactory);
            if (getAuthRequestContext) {
                int i5 = $11 + 37;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        String str = new String(cArr4);
                        int i7 = $11 + 27;
                        $10 = i7 % 128;
                        int i8 = i7 % 2;
                        objArr[0] = str;
                        return;
                    }
                    int i9 = $11 + 87;
                    $10 = i9 % 128;
                    int i10 = i9 % 2;
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i4);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    int i11 = $11 + 17;
                    $10 = i11 % 128;
                    int i12 = i11 % 2;
                }
            } else {
                if (PlaceComponentResult) {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                    char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        try {
                            cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    objArr[0] = new String(cArr5);
                    return;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                        objArr[0] = new String(cArr6);
                        return;
                    }
                    int i13 = $11 + 31;
                    $10 = i13 % 128;
                    if ((i13 % 2 != 0 ? 'B' : (char) 21) != 'B') {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult << 0) % bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] / i] % i4);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory % 0;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
