package id.dana.globalsearch.view.sku.model;

import com.iap.ac.android.mpm.base.model.hook.HookConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dBA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0011\u0010\u0011\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u0015\u001a\u00020\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/globalsearch/view/sku/model/SKUModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "PlaceComponentResult", "Lid/dana/globalsearch/view/sku/model/SKUModel$MerchantState;", "moveToNextValue", "Lid/dana/globalsearch/view/sku/model/SKUModel$MerchantState;", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/globalsearch/view/sku/model/SKUModel$MerchantState;)V", "MerchantState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SKUModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final MerchantState lookAheadTest;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/globalsearch/view/sku/model/SKUModel$MerchantState;", "", "<init>", "(Ljava/lang/String;I)V", HookConstants.HookAction.HOOK_ACTION_OPEN, "CLOSED", "OUT_OF_STOCK"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum MerchantState {
        OPEN,
        CLOSED,
        OUT_OF_STOCK
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SKUModel) {
            SKUModel sKUModel = (SKUModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, sKUModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, sKUModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, sKUModel.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, sKUModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, sKUModel.PlaceComponentResult) && this.lookAheadTest == sKUModel.lookAheadTest;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((this.MyBillsEntityDataFactory.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.lookAheadTest.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SKUModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(')');
        return sb.toString();
    }

    public SKUModel(String str, String str2, String str3, String str4, String str5, MerchantState merchantState) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(merchantState, "");
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.getAuthRequestContext = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
        this.PlaceComponentResult = str5;
        this.lookAheadTest = merchantState;
    }
}
