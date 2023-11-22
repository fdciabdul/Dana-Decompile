package id.dana.cashier.model;

import id.dana.cashier.model.constants.QrisBizType;
import id.dana.domain.investment.model.DanaPlusMethodConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b \u0010!J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0015\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0014\u0010\r\u001a\u0004\u0018\u00010\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0012\u0010\u000f\u001a\u00020\u001aX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u001b"}, d2 = {"Lid/dana/cashier/model/CashierCheckoutModel;", "", "", "PlaceComponentResult", "()Z", "p0", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Z", "MyBillsEntityDataFactory", "toString", "()Ljava/lang/String;", "Lid/dana/cashier/model/AttributeModel;", "Lid/dana/cashier/model/AttributeModel;", "getAuthRequestContext", "Ljava/lang/String;", "Lid/dana/cashier/model/ConfigCheckoutModel;", "Lid/dana/cashier/model/ConfigCheckoutModel;", "Lid/dana/domain/investment/model/DanaPlusMethodConfig;", "Lid/dana/domain/investment/model/DanaPlusMethodConfig;", "Lid/dana/cashier/model/PaylaterCicilCheckoutModel;", "Lid/dana/cashier/model/PaylaterCicilCheckoutModel;", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/cashier/model/AttributeModel;Ljava/lang/String;Lid/dana/cashier/model/ConfigCheckoutModel;Lid/dana/cashier/model/PaylaterCicilCheckoutModel;Lid/dana/domain/investment/model/DanaPlusMethodConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CashierCheckoutModel {
    public DanaPlusMethodConfig BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public AttributeModel getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public ConfigCheckoutModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public PaylaterCicilCheckoutModel MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof CashierCheckoutModel) {
            CashierCheckoutModel cashierCheckoutModel = (CashierCheckoutModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, cashierCheckoutModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, cashierCheckoutModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, cashierCheckoutModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, cashierCheckoutModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, cashierCheckoutModel.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        AttributeModel attributeModel = this.getAuthRequestContext;
        int hashCode = attributeModel == null ? 0 : attributeModel.hashCode();
        String str = this.PlaceComponentResult;
        int hashCode2 = str == null ? 0 : str.hashCode();
        ConfigCheckoutModel configCheckoutModel = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = configCheckoutModel == null ? 0 : configCheckoutModel.hashCode();
        int hashCode4 = this.MyBillsEntityDataFactory.hashCode();
        DanaPlusMethodConfig danaPlusMethodConfig = this.BuiltInFictitiousFunctionClassFactory;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (danaPlusMethodConfig != null ? danaPlusMethodConfig.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierCheckoutModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    private CashierCheckoutModel(AttributeModel attributeModel, String str, ConfigCheckoutModel configCheckoutModel, PaylaterCicilCheckoutModel paylaterCicilCheckoutModel, DanaPlusMethodConfig danaPlusMethodConfig) {
        Intrinsics.checkNotNullParameter(paylaterCicilCheckoutModel, "");
        this.getAuthRequestContext = attributeModel;
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = configCheckoutModel;
        this.MyBillsEntityDataFactory = paylaterCicilCheckoutModel;
        this.BuiltInFictitiousFunctionClassFactory = danaPlusMethodConfig;
    }

    public /* synthetic */ CashierCheckoutModel(AttributeModel attributeModel, String str, ConfigCheckoutModel configCheckoutModel, PaylaterCicilCheckoutModel paylaterCicilCheckoutModel, DanaPlusMethodConfig danaPlusMethodConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(attributeModel, str, configCheckoutModel, (i & 8) != 0 ? new PaylaterCicilCheckoutModel(false, null, null, null, null, 31, null) : paylaterCicilCheckoutModel, (i & 16) != 0 ? null : danaPlusMethodConfig);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[LOOP:0: B:7:0x0011->B:29:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean PlaceComponentResult() {
        /*
            r8 = this;
            id.dana.cashier.model.AttributeModel r0 = r8.getAuthRequestContext
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L3c
            java.util.List<id.dana.cashier.model.CashierPayChannelModel> r0 = r0.SummaryVoucherView$$ExternalSyntheticLambda1
            if (r0 == 0) goto L3c
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L11:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r0.next()
            r5 = r4
            id.dana.cashier.model.CashierPayChannelModel r5 = (id.dana.cashier.model.CashierPayChannelModel) r5
            java.lang.String r6 = r5.PrepareContext
            java.lang.String r7 = "BCAC1ID01"
            boolean r6 = kotlin.text.StringsKt.equals(r6, r7, r1)
            if (r6 == 0) goto L36
            java.lang.Boolean r5 = r5.getErrorConfigVersion
            if (r5 == 0) goto L31
            boolean r5 = r5.booleanValue()
            goto L32
        L31:
            r5 = 0
        L32:
            if (r5 == 0) goto L36
            r5 = 1
            goto L37
        L36:
            r5 = 0
        L37:
            if (r5 == 0) goto L11
            r3 = r4
        L3a:
            id.dana.cashier.model.CashierPayChannelModel r3 = (id.dana.cashier.model.CashierPayChannelModel) r3
        L3c:
            if (r3 == 0) goto L3f
            goto L40
        L3f:
            r1 = 0
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.model.CashierCheckoutModel.PlaceComponentResult():boolean");
    }

    public final boolean MyBillsEntityDataFactory() {
        Boolean bool;
        AttributeModel attributeModel = this.getAuthRequestContext;
        if (attributeModel == null || (bool = attributeModel.BottomSheetCardBindingView$watcherCardNumberView$1) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        AttributeModel attributeModel = this.getAuthRequestContext;
        if (attributeModel != null) {
            return Intrinsics.areEqual(attributeModel.getSupportButtonTintMode, Boolean.TRUE);
        }
        return false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        AttributeModel attributeModel = this.getAuthRequestContext;
        return Intrinsics.areEqual(attributeModel != null ? attributeModel.isAuto : null, QrisBizType.QRIS_CROSSBORDER.getBizType());
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(p0);
    }
}
