package id.dana.cashier.mapper;

import id.dana.R;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.data.base.BaseMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001)B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020#¢\u0006\u0004\b'\u0010(JK\u0010\r\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u0014JO\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00152\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0019J)\u0010\r\u001a\u00020\u001b*\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u0007\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u001cJE\u0010\u0012\u001a\u00020\u001b*\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u001dJ)\u0010\u0017\u001a\u00020\u001b*\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u0007\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u001cJ+\u0010\u000f\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u001eJ%\u0010\r\u001a\u00020\u000b*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\r\u0010\u001fJ%\u0010\u0017\u001a\u00020\u000b*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u001fJ\u0013\u0010\r\u001a\u00020\u000b*\u00020\u0011H\u0002¢\u0006\u0004\b\r\u0010 J'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010!J\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\r\u0010\"J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\"R\u0014\u0010\u0012\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010$R\u0012\u0010\u000f\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010%R\u0012\u0010&\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010%"}, d2 = {"Lid/dana/cashier/mapper/CashierPayMethodModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/model/CashierCheckoutModel;", "", "Lid/dana/cashier/model/CashierPayMethodModel;", "", "p0", "p1", "Lid/dana/cashier/model/AssetCardModel;", "p2", "p3", "", "p4", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Z)Z", "getAuthRequestContext", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "Lid/dana/cashier/model/AttributeModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/model/AttributeModel;)Ljava/util/List;", "(Ljava/lang/String;)Z", "Lid/dana/cashier/model/CashierPayChannelModel;", "p5", "MyBillsEntityDataFactory", "(ZLid/dana/cashier/model/CashierPayChannelModel;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Z", "()Z", "", "", "(Lid/dana/cashier/model/AttributeModel;Ljava/util/List;Z)V", "(Lid/dana/cashier/model/CashierPayMethodModel;Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)V", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Z", "(Ljava/util/List;Ljava/lang/String;)Z", "(Lid/dana/cashier/model/AttributeModel;)Z", "(Ljava/util/List;Z)Ljava/util/List;", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/cashier/mapper/CashierCheckoutModelMapper;", "Lid/dana/cashier/mapper/CashierCheckoutModelMapper;", "Z", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/cashier/mapper/CashierCheckoutModelMapper;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayMethodModelMapper extends BaseMapper<CashierCheckoutModel, List<? extends CashierPayMethodModel>> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final CashierCheckoutModelMapper KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean getAuthRequestContext;

    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends CashierPayMethodModel> map(CashierCheckoutModel cashierCheckoutModel) {
        CashierCheckoutModel cashierCheckoutModel2 = cashierCheckoutModel;
        AttributeModel attributeModel = cashierCheckoutModel2 != null ? cashierCheckoutModel2.getAuthRequestContext : null;
        List<CashierPayMethodModel> KClassImpl$Data$declaredNonStaticMembers$2 = attributeModel != null ? KClassImpl$Data$declaredNonStaticMembers$2(attributeModel) : null;
        return KClassImpl$Data$declaredNonStaticMembers$2 == null ? CollectionsKt.emptyList() : KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Inject
    public CashierPayMethodModelMapper(CashierCheckoutModelMapper cashierCheckoutModelMapper) {
        Intrinsics.checkNotNullParameter(cashierCheckoutModelMapper, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = cashierCheckoutModelMapper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x031b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x031b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x031b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0269  */
    /* JADX WARN: Type inference failed for: r1v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.domain.investment.model.DanaPlusMethodConfig] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v23, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(id.dana.cashier.model.AttributeModel r29, java.util.List<id.dana.cashier.model.CashierPayMethodModel> r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 827
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.mapper.CashierPayMethodModelMapper.PlaceComponentResult(id.dana.cashier.model.AttributeModel, java.util.List, boolean):void");
    }

    public final List<CashierPayMethodModel> KClassImpl$Data$declaredNonStaticMembers$2(AttributeModel p0) {
        ArrayList arrayList = new ArrayList();
        if (Intrinsics.areEqual(p0.TypeProjectionImpl, Boolean.TRUE)) {
            String str = p0.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str == null) {
                str = "";
            }
            arrayList.add(new CashierPayMethodModel.SmartPayActivation(str));
        }
        PlaceComponentResult(p0, arrayList, PlaceComponentResult(p0));
        MyBillsEntityDataFactory(p0, arrayList, false);
        String str2 = p0.NetworkUserEntityData$$ExternalSyntheticLambda7;
        return getAuthRequestContext(arrayList, str2 != null ? str2 : "");
    }

    private static boolean PlaceComponentResult(String p0) {
        return Intrinsics.areEqual(p0, "CREDIT_CARD") || Intrinsics.areEqual(p0, "DEBIT_CARD") || Intrinsics.areEqual(p0, "DIRECT_DEBIT_CREDIT_CARD") || Intrinsics.areEqual(p0, "DIRECT_DEBIT_DEBIT_CARD") || Intrinsics.areEqual(p0, "NET_BANKING");
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return !this.getAuthRequestContext && this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean MyBillsEntityDataFactory(boolean r3, id.dana.cashier.model.CashierPayChannelModel r4, java.util.List<id.dana.cashier.model.AssetCardModel> r5, java.util.List<id.dana.cashier.model.AssetCardModel> r6, java.lang.String r7, boolean r8) {
        /*
            r2 = this;
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L25
            boolean r3 = r2.BuiltInFictitiousFunctionClassFactory
            if (r3 == 0) goto L11
            if (r6 == 0) goto L21
            java.lang.String r3 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            boolean r3 = getAuthRequestContext(r6, r7, r3)
            goto L22
        L11:
            if (r5 == 0) goto L1a
            java.lang.String r3 = r4.NetworkUserEntityData$$ExternalSyntheticLambda7
            boolean r3 = getAuthRequestContext(r5, r7, r3)
            goto L1b
        L1a:
            r3 = 0
        L1b:
            if (r3 == 0) goto L21
            if (r8 == 0) goto L21
            r3 = 1
            goto L22
        L21:
            r3 = 0
        L22:
            if (r3 == 0) goto L25
            goto L26
        L25:
            r0 = 0
        L26:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.mapper.CashierPayMethodModelMapper.MyBillsEntityDataFactory(boolean, id.dana.cashier.model.CashierPayChannelModel, java.util.List, java.util.List, java.lang.String, boolean):boolean");
    }

    private static boolean getAuthRequestContext(List<AssetCardModel> list, String str, String str2) {
        for (AssetCardModel assetCardModel : list) {
            if (!Intrinsics.areEqual(assetCardModel.getSupportButtonTintMode, "COUPON")) {
                return Intrinsics.areEqual(assetCardModel.getSupportButtonTintMode, str) && Intrinsics.areEqual(assetCardModel.whenAvailable, str2);
            }
        }
        return false;
    }

    private final boolean PlaceComponentResult(String p0, String p1, List<AssetCardModel> p2, List<AssetCardModel> p3, boolean p4) {
        if (this.BuiltInFictitiousFunctionClassFactory) {
            return MyBillsEntityDataFactory(p3, p1);
        }
        return PlaceComponentResult(p2, p0) && p4;
    }

    private static boolean PlaceComponentResult(List<AssetCardModel> list, String str) {
        List<AssetCardModel> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return false;
        }
        return Intrinsics.areEqual(str, ((AssetCardModel) CollectionsKt.first((List) list)).scheduleImpl);
    }

    private static boolean MyBillsEntityDataFactory(List<AssetCardModel> list, String str) {
        List<AssetCardModel> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return false;
        }
        return Intrinsics.areEqual(str, ((AssetCardModel) CollectionsKt.first((List) list)).KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<id.dana.cashier.model.CashierPayMethodModel> getAuthRequestContext(java.util.List<? extends id.dana.cashier.model.CashierPayMethodModel> r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = r8
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r1 = r0.iterator()
        Lf:
            boolean r2 = r1.hasNext()
            r3 = 0
            if (r2 == 0) goto L24
            java.lang.Object r2 = r1.next()
            r4 = r2
            id.dana.cashier.model.CashierPayMethodModel r4 = (id.dana.cashier.model.CashierPayMethodModel) r4
            boolean r4 = r4.getNetworkUserEntityData$$ExternalSyntheticLambda0()
            if (r4 == 0) goto Lf
            goto L25
        L24:
            r2 = r3
        L25:
            id.dana.cashier.model.CashierPayMethodModel r2 = (id.dana.cashier.model.CashierPayMethodModel) r2
            r1 = 0
            if (r2 != 0) goto L8e
            boolean r2 = r7.BuiltInFictitiousFunctionClassFactory
            r4 = 1
            if (r2 == 0) goto L33
            KClassImpl$Data$declaredNonStaticMembers$2(r8)
            goto L5e
        L33:
            java.util.Iterator r0 = r0.iterator()
        L37:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L56
            java.lang.Object r2 = r0.next()
            r5 = r2
            id.dana.cashier.model.CashierPayMethodModel r5 = (id.dana.cashier.model.CashierPayMethodModel) r5
            boolean r6 = id.dana.cashier.model.CashierPayMethodModelKt.MyBillsEntityDataFactory(r5, r9)
            if (r6 != 0) goto L52
            boolean r5 = id.dana.cashier.model.CashierPayMethodModelKt.getAuthRequestContext(r5, r9)
            if (r5 != 0) goto L52
            r5 = 0
            goto L53
        L52:
            r5 = 1
        L53:
            if (r5 == 0) goto L37
            r3 = r2
        L56:
            id.dana.cashier.model.CashierPayMethodModel r3 = (id.dana.cashier.model.CashierPayMethodModel) r3
            if (r3 == 0) goto L5e
            r3.NetworkUserEntityData$$ExternalSyntheticLambda0 = r4
            r0 = 1
            goto L5f
        L5e:
            r0 = 0
        L5f:
            if (r0 != 0) goto L6c
            boolean r2 = id.dana.cashier.model.CashierPayMethodModelKt.MyBillsEntityDataFactory(r8)
            if (r2 == 0) goto L6c
            java.util.List r8 = PlaceComponentResult(r8)
            goto L96
        L6c:
            if (r0 == 0) goto L72
            boolean r0 = r7.BuiltInFictitiousFunctionClassFactory
            if (r0 == 0) goto L96
        L72:
            r0 = r9
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L7d
            r0 = 1
            goto L7e
        L7d:
            r0 = 0
        L7e:
            if (r0 == 0) goto L89
            java.lang.String r0 = "BALANCE"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
            if (r9 != 0) goto L89
            r1 = 1
        L89:
            java.util.List r8 = KClassImpl$Data$declaredNonStaticMembers$2(r8, r1)
            goto L96
        L8e:
            boolean r9 = r7.BuiltInFictitiousFunctionClassFactory
            if (r9 == 0) goto L96
            java.util.List r8 = KClassImpl$Data$declaredNonStaticMembers$2(r8, r1)
        L96:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.mapper.CashierPayMethodModelMapper.getAuthRequestContext(java.util.List, java.lang.String):java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List<CashierPayMethodModel> KClassImpl$Data$declaredNonStaticMembers$2(List<? extends CashierPayMethodModel> list, boolean z) {
        boolean z2 = false;
        CashierPayMethodModel cashierPayMethodModel = null;
        for (CashierPayMethodModel cashierPayMethodModel2 : list) {
            if (CashierPayMethodModelKt.DatabaseTableConfigUtil(cashierPayMethodModel2)) {
                cashierPayMethodModel = cashierPayMethodModel2;
            }
            if (!CashierPayMethodModelKt.DatabaseTableConfigUtil(cashierPayMethodModel2) || !cashierPayMethodModel2.PlaceComponentResult()) {
                if (!CashierPayMethodModelKt.PrepareContext(cashierPayMethodModel2) || !cashierPayMethodModel2.PlaceComponentResult() || !cashierPayMethodModel2.getAuthRequestContext() || z2) {
                    if (CashierPayMethodModelKt.GetContactSyncConfig(cashierPayMethodModel2) && !z2) {
                        if (cashierPayMethodModel2.getBuiltInFictitiousFunctionClassFactory()) {
                            cashierPayMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                        } else if (cashierPayMethodModel != null) {
                            cashierPayMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                        }
                    }
                } else {
                    cashierPayMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                }
            } else {
                cashierPayMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                CashierPayMethodModel.BalancePayMethod KClassImpl$Data$declaredNonStaticMembers$2 = CashierPayMethodModelKt.KClassImpl$Data$declaredNonStaticMembers$2(cashierPayMethodModel2);
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = z;
                }
            }
            z2 = true;
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List<CashierPayMethodModel> KClassImpl$Data$declaredNonStaticMembers$2(List<? extends CashierPayMethodModel> list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
            if (!CashierPayMethodModelKt.DatabaseTableConfigUtil(cashierPayMethodModel) && cashierPayMethodModel.PlaceComponentResult() && cashierPayMethodModel.getAuthRequestContext()) {
                break;
            }
        }
        CashierPayMethodModel cashierPayMethodModel2 = (CashierPayMethodModel) obj;
        if (cashierPayMethodModel2 != null) {
            cashierPayMethodModel2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List<CashierPayMethodModel> PlaceComponentResult(List<? extends CashierPayMethodModel> list) {
        boolean z = false;
        for (CashierPayMethodModel cashierPayMethodModel : list) {
            if (!CashierPayMethodModelKt.DatabaseTableConfigUtil(cashierPayMethodModel) || !cashierPayMethodModel.PlaceComponentResult()) {
                if (!CashierPayMethodModelKt.NetworkUserEntityData$$ExternalSyntheticLambda8(cashierPayMethodModel) || !cashierPayMethodModel.PlaceComponentResult() || z) {
                    if (!CashierPayMethodModelKt.PrepareContext(cashierPayMethodModel) || !cashierPayMethodModel.PlaceComponentResult() || !cashierPayMethodModel.getAuthRequestContext() || z) {
                        if (CashierPayMethodModelKt.GetContactSyncConfig(cashierPayMethodModel) && !z) {
                            cashierPayMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                        }
                    } else {
                        cashierPayMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                    }
                } else {
                    cashierPayMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                }
            } else {
                cashierPayMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            }
            z = true;
        }
        return list;
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel cashierPayMethodModel, List<CashierPayMethodModel> list, List<CashierPayMethodModel> list2, List<CashierPayMethodModel> list3, boolean z) {
        if (z) {
            if (cashierPayMethodModel.PlaceComponentResult()) {
                list.add(cashierPayMethodModel);
                return;
            } else {
                list2.add(cashierPayMethodModel);
                return;
            }
        }
        list3.add(cashierPayMethodModel);
    }

    public static void MyBillsEntityDataFactory(AttributeModel attributeModel, List<CashierPayMethodModel> list, boolean z) {
        boolean z2;
        List<CashierPayChannelModel> list2 = attributeModel.SummaryVoucherView$$ExternalSyntheticLambda1;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list2.iterator();
            while (true) {
                z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CashierPayChannelModel cashierPayChannelModel = (CashierPayChannelModel) next;
                if (cashierPayChannelModel.lookAheadTest() && Intrinsics.areEqual(cashierPayChannelModel.getErrorConfigVersion, Boolean.TRUE)) {
                    z2 = true;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            if ((!arrayList.isEmpty()) != false && Intrinsics.areEqual(attributeModel.b, Boolean.FALSE)) {
                z2 = true;
            }
            if (!z) {
                CashierPayMethodModel.HelperPayMethod helperPayMethod = new CashierPayMethodModel.HelperPayMethod(1, R.drawable.ic_chip_add_new_card, "");
                helperPayMethod.BuiltInFictitiousFunctionClassFactory = z2;
                list.add(helperPayMethod);
            } else if (z && z2) {
                CashierPayMethodModel.HelperPayMethod helperPayMethod2 = new CashierPayMethodModel.HelperPayMethod(1, R.drawable.ic_chip_add_new_card, "");
                helperPayMethod2.BuiltInFictitiousFunctionClassFactory = true;
                list.add(helperPayMethod2);
            }
        }
    }

    private static boolean PlaceComponentResult(AttributeModel attributeModel) {
        List<AssetCardModel> list = attributeModel.moveToNextValue;
        return (list != null && (list.isEmpty() ^ true)) && Intrinsics.areEqual(attributeModel.TypeProjectionImpl, Boolean.FALSE);
    }
}
