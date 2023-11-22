package id.dana.data.referralwidget.repository.source.split;

import android.text.TextUtils;
import android.view.View;
import id.dana.data.referralwidget.model.ReferralWidgetResult;
import id.dana.data.referralwidget.repository.source.ReferralWidgetEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o.D;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/referralwidget/repository/source/split/SplitReferralWidgetEntityData;", "Lid/dana/data/referralwidget/repository/source/ReferralWidgetEntityData;", "Lio/reactivex/Observable;", "", "", "Lid/dana/data/referralwidget/model/ReferralWidgetResult;", "getReferralWidgets", "()Lio/reactivex/Observable;", "", "referralWidgetConfigKeys", "Ljava/util/List;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitReferralWidgetEntityData implements ReferralWidgetEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static long PlaceComponentResult = 3674953429397309512L;
    private final List<String> referralWidgetConfigKeys;
    private final SplitFacade splitFacade;

    public static /* synthetic */ ObservableSource $r8$lambda$IdI2rTIAdCzf4JAyBcFMtQtHKZ8(SplitReferralWidgetEntityData splitReferralWidgetEntityData, Map map, String str) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 71;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        boolean z = i % 2 == 0;
        ObservableSource m1796getReferralWidgets$lambda2 = m1796getReferralWidgets$lambda2(splitReferralWidgetEntityData, map, str);
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m1796getReferralWidgets$lambda2;
    }

    /* renamed from: $r8$lambda$Ss-_ZMyJQJ-oyAtuBayhnqXVN34  reason: not valid java name */
    public static /* synthetic */ Map m1795$r8$lambda$Ss_ZMyJQJoyAtuBayhnqXVN34(Map map, String str, BaseTrafficType baseTrafficType) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 33;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            boolean z = i % 2 != 0;
            Map m1797getReferralWidgets$lambda2$lambda1 = m1797getReferralWidgets$lambda2$lambda1(map, str, baseTrafficType);
            if (!z) {
                Object[] objArr = null;
                int length = objArr.length;
            }
            return m1797getReferralWidgets$lambda2$lambda1;
        } catch (Exception e) {
            throw e;
        }
    }

    @Inject
    public SplitReferralWidgetEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
        Object[] objArr = new Object[1];
        a(TextUtils.indexOf("", ""), new char[]{53017, 22318, 19543, 7862, 53099, 37611, 51057, 20019, 55787, 35708, 60918, 31162, 57926, 42472, 62590, 25380, 36074, 24186, 33480, 35508, 38252, 18682, 43363, 46137, 49143}, objArr);
        Object[] objArr2 = new Object[1];
        a(View.getDefaultSize(0, 0), new char[]{3659, 3720, 49944, 18156, 3641, 52045, 18494, 5737, 6329, 53978, 25273, 8672, 8980, 64603, 31549, 15215, 19876, 1990, 3516, 53971, 21545, 4445, 9772, 60536, 32420, 14534}, objArr2);
        this.referralWidgetConfigKeys = CollectionsKt.listOf((Object[]) new String[]{((String) objArr[0]).intern(), ((String) objArr2[0]).intern()});
    }

    @Override // id.dana.data.referralwidget.repository.source.ReferralWidgetEntityData
    public final Observable<Map<String, ReferralWidgetResult>> getReferralWidgets() {
        try {
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            Observable<Map<String, ReferralWidgetResult>> switchMap = Observable.fromIterable(this.referralWidgetConfigKeys).switchMap(new Function() { // from class: id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitReferralWidgetEntityData.$r8$lambda$IdI2rTIAdCzf4JAyBcFMtQtHKZ8(SplitReferralWidgetEntityData.this, linkedHashMap, (String) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(switchMap, "");
            int i = BuiltInFictitiousFunctionClassFactory + 83;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return switchMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getReferralWidgets$lambda-2  reason: not valid java name */
    private static final ObservableSource m1796getReferralWidgets$lambda2(SplitReferralWidgetEntityData splitReferralWidgetEntityData, final Map map, final String str) {
        Intrinsics.checkNotNullParameter(splitReferralWidgetEntityData, "");
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(str, "");
        ObservableSource map2 = splitReferralWidgetEntityData.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitReferralWidgetEntityData.m1795$r8$lambda$Ss_ZMyJQJoyAtuBayhnqXVN34(map, str, (BaseTrafficType) obj);
            }
        });
        int i = BuiltInFictitiousFunctionClassFactory + 119;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? (char) 17 : '\'') != 17) {
            return map2;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return map2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
    
        if (id.dana.data.referralwidget.model.ReferralWidgetResult.class.isAssignableFrom(org.json.JSONArray.class) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0049, code lost:
    
        if (r6 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        r6 = id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData.BuiltInFictitiousFunctionClassFactory + 25;
        id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
    
        if ((r6 % 2) != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0059, code lost:
    
        r6 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
    
        r6 = 'N';
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
    
        if (r6 == 'N') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        r6 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        r1 = (id.dana.data.referralwidget.model.ReferralWidgetResult) new org.json.JSONArray(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        r6 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult().fromJson(id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r6, null), (java.lang.Class<java.lang.Object>) id.dana.data.referralwidget.model.ReferralWidgetResult.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007f, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        if ((id.dana.data.referralwidget.model.ReferralWidgetResult.class.isAssignableFrom(org.json.JSONArray.class) ? '3' : 30) != '3') goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getReferralWidgets$lambda-2$lambda-1  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.Map m1797getReferralWidgets$lambda2$lambda1(java.util.Map r4, java.lang.String r5, id.dana.data.toggle.traffictype.BaseTrafficType r6) {
        /*
            int r0 = id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = ""
            if (r0 == 0) goto L31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            r0 = 0
            java.lang.String r6 = r6.getAuthRequestContext(r5, r0)
            java.lang.Class<id.dana.data.referralwidget.model.ReferralWidgetResult> r0 = id.dana.data.referralwidget.model.ReferralWidgetResult.class
            java.lang.Class<org.json.JSONArray> r3 = org.json.JSONArray.class
            boolean r0 = r0.isAssignableFrom(r3)
            r3 = 51
            if (r0 == 0) goto L2c
            r0 = 51
            goto L2e
        L2c:
            r0 = 30
        L2e:
            if (r0 == r3) goto L49
            goto L6e
        L31:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            r0 = 1
            java.lang.String r6 = r6.getAuthRequestContext(r5, r0)
            java.lang.Class<id.dana.data.referralwidget.model.ReferralWidgetResult> r0 = id.dana.data.referralwidget.model.ReferralWidgetResult.class
            java.lang.Class<org.json.JSONArray> r3 = org.json.JSONArray.class
            boolean r0 = r0.isAssignableFrom(r3)
            if (r0 == 0) goto L6e
        L49:
            if (r6 != 0) goto L64
            int r6 = id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 25
            int r0 = r6 % 128
            id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r6 = r6 % 2
            r0 = 78
            if (r6 != 0) goto L5c
            r6 = 22
            goto L5e
        L5c:
            r6 = 78
        L5e:
            if (r6 == r0) goto L65
            int r6 = r1.length     // Catch: java.lang.Throwable -> L62
            goto L65
        L62:
            r4 = move-exception
            throw r4
        L64:
            r2 = r6
        L65:
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>(r2)
            r1 = r6
            id.dana.data.referralwidget.model.ReferralWidgetResult r1 = (id.dana.data.referralwidget.model.ReferralWidgetResult) r1
            goto L88
        L6e:
            if (r6 == 0) goto L85
            com.google.gson.Gson r0 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult()     // Catch: java.lang.Exception -> L7f
            java.lang.String r6 = id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r6, r1)     // Catch: java.lang.Exception -> L7f
            java.lang.Class<id.dana.data.referralwidget.model.ReferralWidgetResult> r2 = id.dana.data.referralwidget.model.ReferralWidgetResult.class
            java.lang.Object r6 = r0.fromJson(r6, r2)     // Catch: java.lang.Exception -> L7f
            goto L80
        L7f:
            r6 = r1
        L80:
            if (r6 != 0) goto L83
            goto L85
        L83:
            r1 = r6
            goto L88
        L85:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
        L88:
            r4.put(r5, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.referralwidget.repository.source.split.SplitReferralWidgetEntityData.m1797getReferralWidgets$lambda2$lambda1(java.util.Map, java.lang.String, id.dana.data.toggle.traffictype.BaseTrafficType):java.util.Map");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            try {
                if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length ? ':' : 'Z') == ':') {
                    int i2 = $10 + 19;
                    $11 = i2 % 128;
                    int i3 = i2 % 2;
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (PlaceComponentResult ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                } else {
                    String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                    int i4 = $10 + 17;
                    $11 = i4 % 128;
                    int i5 = i4 % 2;
                    objArr[0] = str;
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
