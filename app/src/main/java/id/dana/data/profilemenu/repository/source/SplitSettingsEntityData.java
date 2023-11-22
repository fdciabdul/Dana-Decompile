package id.dana.data.profilemenu.repository.source;

import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import id.dana.data.profilemenu.model.SettingEntity;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.whenAvailable;

@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\n\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\t0\t0\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0007J)\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\t0\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/profilemenu/repository/source/SplitSettingsEntityData;", "Lid/dana/data/profilemenu/repository/source/SettingsEntityData;", "", "settingKey", "Lio/reactivex/Observable;", "Lid/dana/data/profilemenu/model/SettingEntity;", "getSettingByKey", "(Ljava/lang/String;)Lio/reactivex/Observable;", "collectionName", "Ljava/util/LinkedHashMap;", "getSettingCollection", "categoryKey", "getSettingKeyByCategoryKey", "", "isSettingSplitNeedtoMigrate", "()Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitSettingsEntityData implements SettingsEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int getAuthRequestContext;
    private final SplitFacade splitFacade;
    private static char[] PlaceComponentResult = {7007, 57816, 61008, 62657, 61788, 65503, 50244, 49914, 53098, 54776, 53861, 55521, 42336, 41955, 43110, 46810, 45834, 47501, 34333, 35996, 35101, 38834, 39948, 39564, 26430, 28079, 27184, 28833, 32032, 31650, 16431};
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 1945476558887651786L;

    /* renamed from: $r8$lambda$-vuZOvhfEQ2X8N3iB4P8YJA1pEg  reason: not valid java name */
    public static /* synthetic */ LinkedHashMap m1597$r8$lambda$vuZOvhfEQ2X8N3iB4P8YJA1pEg(List list) {
        int i = BuiltInFictitiousFunctionClassFactory + 81;
        getAuthRequestContext = i % 128;
        boolean z = i % 2 != 0;
        LinkedHashMap m1602getSettingCollection$lambda2 = m1602getSettingCollection$lambda2(list);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        return m1602getSettingCollection$lambda2;
    }

    public static /* synthetic */ SettingEntity $r8$lambda$2BPkO00jr7WikiUnhNXrcS8zMc8(String str, BaseTrafficType baseTrafficType) {
        int i = getAuthRequestContext + 123;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        boolean z = i % 2 == 0;
        SettingEntity m1600getSettingByKey$lambda6 = m1600getSettingByKey$lambda6(str, baseTrafficType);
        if (z) {
            int i2 = 31 / 0;
        }
        return m1600getSettingByKey$lambda6;
    }

    /* renamed from: $r8$lambda$Leu7NHbchdi93AGRMsrHhMuWo-g  reason: not valid java name */
    public static /* synthetic */ List m1598$r8$lambda$Leu7NHbchdi93AGRMsrHhMuWog(String str, BaseTrafficType baseTrafficType) {
        try {
            int i = getAuthRequestContext + 73;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            List m1603getSettingKeyByCategoryKey$lambda3 = m1603getSettingKeyByCategoryKey$lambda3(str, baseTrafficType);
            try {
                int i3 = getAuthRequestContext + 77;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 6 : (char) 30) != 30) {
                    Object obj = null;
                    obj.hashCode();
                    return m1603getSettingKeyByCategoryKey$lambda3;
                }
                return m1603getSettingKeyByCategoryKey$lambda3;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ Boolean $r8$lambda$NQEj8TtV8rZjgZwpHZMLnAH383s(BaseTrafficType baseTrafficType) {
        int i = getAuthRequestContext + 121;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        char c = i % 2 == 0 ? (char) 21 : '4';
        Boolean m1605isSettingSplitNeedtoMigrate$lambda7 = m1605isSettingSplitNeedtoMigrate$lambda7(baseTrafficType);
        if (c == 21) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m1605isSettingSplitNeedtoMigrate$lambda7;
    }

    public static /* synthetic */ LinkedHashMap $r8$lambda$UEcOMO9ZGU5FD9MQ96LewYVKFC4(List list) {
        LinkedHashMap m1604getSettingKeyByCategoryKey$lambda5;
        int i = BuiltInFictitiousFunctionClassFactory + 105;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            m1604getSettingKeyByCategoryKey$lambda5 = m1604getSettingKeyByCategoryKey$lambda5(list);
        } else {
            try {
                m1604getSettingKeyByCategoryKey$lambda5 = m1604getSettingKeyByCategoryKey$lambda5(list);
                int i2 = 42 / 0;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 99;
        getAuthRequestContext = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 32 / 0;
            return m1604getSettingKeyByCategoryKey$lambda5;
        }
        return m1604getSettingKeyByCategoryKey$lambda5;
    }

    /* renamed from: $r8$lambda$_HJ7Pj_Hs-JN9DPjywhfJMXQgNU  reason: not valid java name */
    public static /* synthetic */ List m1599$r8$lambda$_HJ7Pj_HsJN9DPjywhfJMXQgNU(String str, BaseTrafficType baseTrafficType) {
        int i = getAuthRequestContext + 17;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        List m1601getSettingCollection$lambda0 = m1601getSettingCollection$lambda0(str, baseTrafficType);
        int i3 = getAuthRequestContext + 123;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return m1601getSettingCollection$lambda0;
    }

    @Inject
    public SplitSettingsEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.profilemenu.repository.source.SettingsEntityData
    public final Observable<LinkedHashMap<String, LinkedHashMap<String, SettingEntity>>> getSettingCollection(final String collectionName) {
        Intrinsics.checkNotNullParameter(collectionName, "");
        Observable<LinkedHashMap<String, LinkedHashMap<String, SettingEntity>>> map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.profilemenu.repository.source.SplitSettingsEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitSettingsEntityData.m1599$r8$lambda$_HJ7Pj_HsJN9DPjywhfJMXQgNU(collectionName, (BaseTrafficType) obj);
            }
        }).map(new Function() { // from class: id.dana.data.profilemenu.repository.source.SplitSettingsEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitSettingsEntityData.m1597$r8$lambda$vuZOvhfEQ2X8N3iB4P8YJA1pEg((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = getAuthRequestContext + 71;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? 'S' : '6') != '6') {
            int i2 = 49 / 0;
            return map;
        }
        return map;
    }

    /* renamed from: getSettingCollection$lambda-0  reason: not valid java name */
    private static final List m1601getSettingCollection$lambda0(String str, BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        String authRequestContext = baseTrafficType.getAuthRequestContext(str, true);
        if (String.class.isAssignableFrom(String.class)) {
            String str2 = authRequestContext == null ? "" : authRequestContext;
            if (str2 == null) {
                try {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                } catch (Exception e) {
                    throw e;
                }
            }
            authRequestContext = str2;
        } else if (authRequestContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else {
            int i = getAuthRequestContext + 3;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 == 0) {
                Object obj = null;
                obj.hashCode();
            }
            int i2 = getAuthRequestContext + 27;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
        }
        return JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
    }

    /* renamed from: getSettingCollection$lambda-2  reason: not valid java name */
    private static final LinkedHashMap m1602getSettingCollection$lambda2(List list) {
        try {
            Intrinsics.checkNotNullParameter(list, "");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator it = list.iterator();
            int i = getAuthRequestContext + 39;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            while (it.hasNext()) {
                linkedHashMap.put((String) it.next(), new LinkedHashMap());
            }
            int i3 = getAuthRequestContext + 105;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return linkedHashMap;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.profilemenu.repository.source.SettingsEntityData
    public final Observable<LinkedHashMap<String, SettingEntity>> getSettingKeyByCategoryKey(final String categoryKey) {
        Intrinsics.checkNotNullParameter(categoryKey, "");
        Observable<LinkedHashMap<String, SettingEntity>> map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.profilemenu.repository.source.SplitSettingsEntityData$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitSettingsEntityData.m1598$r8$lambda$Leu7NHbchdi93AGRMsrHhMuWog(categoryKey, (BaseTrafficType) obj);
            }
        }).map(new Function() { // from class: id.dana.data.profilemenu.repository.source.SplitSettingsEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitSettingsEntityData.$r8$lambda$UEcOMO9ZGU5FD9MQ96LewYVKFC4((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = BuiltInFictitiousFunctionClassFactory + 105;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return map;
    }

    /* renamed from: getSettingKeyByCategoryKey$lambda-5  reason: not valid java name */
    private static final LinkedHashMap m1604getSettingKeyByCategoryKey$lambda5(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        int i = getAuthRequestContext + 85;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        while (it.hasNext()) {
            linkedHashMap.put((String) it.next(), new SettingEntity());
        }
        return linkedHashMap;
    }

    @Override // id.dana.data.profilemenu.repository.source.SettingsEntityData
    public final Observable<SettingEntity> getSettingByKey(final String settingKey) {
        Intrinsics.checkNotNullParameter(settingKey, "");
        Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.profilemenu.repository.source.SplitSettingsEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitSettingsEntityData.$r8$lambda$2BPkO00jr7WikiUnhNXrcS8zMc8(settingKey, (BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = BuiltInFictitiousFunctionClassFactory + 97;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return map;
    }

    @Override // id.dana.data.profilemenu.repository.source.SettingsEntityData
    public final Observable<Boolean> isSettingSplitNeedtoMigrate() {
        Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.profilemenu.repository.source.SplitSettingsEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitSettingsEntityData.$r8$lambda$NQEj8TtV8rZjgZwpHZMLnAH383s((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = getAuthRequestContext + 7;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        return map;
    }

    /* renamed from: isSettingSplitNeedtoMigrate$lambda-7  reason: not valid java name */
    private static final Boolean m1605isSettingSplitNeedtoMigrate$lambda7(BaseTrafficType baseTrafficType) {
        boolean authRequestContext;
        int i = BuiltInFictitiousFunctionClassFactory + 49;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? 'L' : 'H') != 'H') {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Object[] objArr = new Object[1];
            a(1 / (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 113 / (ViewConfiguration.getScrollDefaultDelay() + 17), (char) (59511 >> (ViewConfiguration.getMaximumFlingVelocity() + 117)), objArr);
            authRequestContext = baseTrafficType.getAuthRequestContext(((String) objArr[0]).intern(), true, true);
        } else {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Object[] objArr2 = new Object[1];
            a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 31, (char) (59511 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), objArr2);
            authRequestContext = baseTrafficType.getAuthRequestContext(((String) objArr2[0]).intern(), false, false);
        }
        Boolean valueOf = Boolean.valueOf(authRequestContext);
        int i2 = getAuthRequestContext + 7;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        return valueOf;
    }

    /* renamed from: getSettingKeyByCategoryKey$lambda-3  reason: not valid java name */
    private static final List m1603getSettingKeyByCategoryKey$lambda3(String str, BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        String authRequestContext = baseTrafficType.getAuthRequestContext(str, true);
        try {
            if ((String.class.isAssignableFrom(String.class) ? (char) 24 : (char) 20) == 24) {
                try {
                    int i = BuiltInFictitiousFunctionClassFactory + 45;
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                    String str2 = (authRequestContext == null ? (char) 27 : ':') != 27 ? authRequestContext : "";
                    if (str2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    authRequestContext = str2;
                } catch (Exception e) {
                    throw e;
                }
            } else if (authRequestContext == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            } else {
                int i3 = BuiltInFictitiousFunctionClassFactory + 115;
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 != 0) {
                    int i4 = 52 / 0;
                }
            }
            List<String> KClassImpl$Data$declaredNonStaticMembers$22 = JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
            int i5 = getAuthRequestContext + 123;
            BuiltInFictitiousFunctionClassFactory = i5 % 128;
            int i6 = i5 % 2;
            return KClassImpl$Data$declaredNonStaticMembers$22;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
    
        if ((!id.dana.data.profilemenu.model.SettingEntity.class.isAssignableFrom(org.json.JSONArray.class)) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if (r5 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (r1 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        r6 = id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.BuiltInFictitiousFunctionClassFactory + 19;
        id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.getAuthRequestContext = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
    
        r5 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult().fromJson(id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r5, null), (java.lang.Class<java.lang.Object>) id.dana.data.profilemenu.model.SettingEntity.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        if (r5 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        r0 = '+';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006f, code lost:
    
        r0 = 'Q';
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        if (r0 == '+') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
    
        r5 = id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.getAuthRequestContext + 117;
        id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.BuiltInFictitiousFunctionClassFactory = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007f, code lost:
    
        if ((r5 % 2) != 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
    
        r5 = 48 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        r2 = (id.dana.data.profilemenu.model.SettingEntity) new org.json.JSONArray(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
    
        if (id.dana.data.profilemenu.model.SettingEntity.class.isAssignableFrom(org.json.JSONArray.class) != false) goto L24;
     */
    /* renamed from: getSettingByKey$lambda-6  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final id.dana.data.profilemenu.model.SettingEntity m1600getSettingByKey$lambda6(java.lang.String r5, id.dana.data.toggle.traffictype.BaseTrafficType r6) {
        /*
            int r0 = id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.getAuthRequestContext
            int r0 = r0 + 19
            int r1 = r0 % 128
            id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            r3 = 0
            java.lang.String r4 = ""
            if (r0 != 0) goto L26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r4)
            java.lang.String r5 = r6.getAuthRequestContext(r5, r3)
            java.lang.Class<id.dana.data.profilemenu.model.SettingEntity> r6 = id.dana.data.profilemenu.model.SettingEntity.class
            java.lang.Class<org.json.JSONArray> r0 = org.json.JSONArray.class
            boolean r6 = r6.isAssignableFrom(r0)
            if (r6 == 0) goto L3f
            goto L68
        L26:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)     // Catch: java.lang.Exception -> L92
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r4)     // Catch: java.lang.Exception -> L92
            java.lang.String r5 = r6.getAuthRequestContext(r5, r1)     // Catch: java.lang.Exception -> L92
            java.lang.Class<id.dana.data.profilemenu.model.SettingEntity> r6 = id.dana.data.profilemenu.model.SettingEntity.class
            java.lang.Class<org.json.JSONArray> r0 = org.json.JSONArray.class
            boolean r6 = r6.isAssignableFrom(r0)     // Catch: java.lang.Exception -> L92
            if (r6 == 0) goto L3c
            r6 = 0
            goto L3d
        L3c:
            r6 = 1
        L3d:
            if (r6 == 0) goto L68
        L3f:
            if (r5 == 0) goto L42
            goto L43
        L42:
            r1 = 0
        L43:
            if (r1 == 0) goto L64
            int r6 = id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 19
            int r0 = r6 % 128
            id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.getAuthRequestContext = r0
            int r6 = r6 % 2
            com.google.gson.Gson r6 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult()     // Catch: java.lang.Exception -> L5e
            java.lang.String r5 = id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r5, r2)     // Catch: java.lang.Exception -> L5e
            java.lang.Class<id.dana.data.profilemenu.model.SettingEntity> r0 = id.dana.data.profilemenu.model.SettingEntity.class
            java.lang.Object r5 = r6.fromJson(r5, r0)     // Catch: java.lang.Exception -> L5e
            goto L5f
        L5e:
            r5 = r2
        L5f:
            if (r5 != 0) goto L62
            goto L64
        L62:
            r2 = r5
            goto L8f
        L64:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            goto L8f
        L68:
            r6 = 43
            if (r5 != 0) goto L6f
            r0 = 43
            goto L71
        L6f:
            r0 = 81
        L71:
            if (r0 == r6) goto L75
            r4 = r5
            goto L87
        L75:
            int r5 = id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.getAuthRequestContext
            int r5 = r5 + 117
            int r6 = r5 % 128
            id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.BuiltInFictitiousFunctionClassFactory = r6
            int r5 = r5 % 2
            if (r5 != 0) goto L87
            r5 = 48
            int r5 = r5 / r3
            goto L87
        L85:
            r5 = move-exception
            throw r5
        L87:
            org.json.JSONArray r5 = new org.json.JSONArray
            r5.<init>(r4)
            r2 = r5
            id.dana.data.profilemenu.model.SettingEntity r2 = (id.dana.data.profilemenu.model.SettingEntity) r2
        L8f:
            id.dana.data.profilemenu.model.SettingEntity r2 = (id.dana.data.profilemenu.model.SettingEntity) r2
            return r2
        L92:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.profilemenu.repository.source.SplitSettingsEntityData.m1600getSettingByKey$lambda6(java.lang.String, id.dana.data.toggle.traffictype.BaseTrafficType):id.dana.data.profilemenu.model.SettingEntity");
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        int i3 = $11 + 125;
        $10 = i3 % 128;
        int i4 = i3 % 2;
        while (true) {
            if (whenavailable.BuiltInFictitiousFunctionClassFactory >= i2) {
                break;
            }
            int i5 = $10 + 7;
            $11 = i5 % 128;
            int i6 = i5 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ KClassImpl$Data$declaredNonStaticMembers$2))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        try {
            int i7 = $11 + 13;
            $10 = i7 % 128;
            int i8 = i7 % 2;
            while (true) {
                if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '\f' : '/') == '/') {
                    objArr[0] = new String(cArr);
                    return;
                } else {
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
