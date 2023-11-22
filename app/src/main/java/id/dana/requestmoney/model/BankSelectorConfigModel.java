package id.dana.requestmoney.model;

import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.sendmoney.model.BankModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b \u0010!Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u000b\u0012\u0006\u0010#\u001a\u00020\u0006\u0012\u0006\u0010$\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u0006\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010(\u001a\u00020\u0003\u0012\b\b\u0002\u0010)\u001a\u00020\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b \u0010+J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0017\u0010\u0010\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0014\u0010\nR\u0012\u0010\t\u001a\u00020\u0003X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00038\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u0016\u0010\nR\u0012\u0010\u001c\u001a\u00020\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001eX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001f"}, d2 = {"Lid/dana/requestmoney/model/BankSelectorConfigModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "MyBillsEntityDataFactory", "()Z", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/sendmoney/model/BankModel;", "getAuthRequestContext", "Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/model/BankModel;", "BuiltInFictitiousFunctionClassFactory", "I", "PlaceComponentResult", "getErrorConfigVersion", "Z", "scheduleImpl", "lookAheadTest", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "Lid/dana/domain/sendmoney/model/TransferInit;", "Lid/dana/domain/sendmoney/model/TransferInit;", "<init>", "()V", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "(ZLjava/lang/String;IIILjava/util/List;Lid/dana/sendmoney/model/BankModel;ZZLid/dana/domain/sendmoney/model/TransferInit;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BankSelectorConfigModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final BankModel BuiltInFictitiousFunctionClassFactory;
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<BankModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final int getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public boolean lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public TransferInit moveToNextValue;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof BankSelectorConfigModel) {
            BankSelectorConfigModel bankSelectorConfigModel = (BankSelectorConfigModel) p0;
            return this.MyBillsEntityDataFactory == bankSelectorConfigModel.MyBillsEntityDataFactory && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, bankSelectorConfigModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && this.getErrorConfigVersion == bankSelectorConfigModel.getErrorConfigVersion && this.PlaceComponentResult == bankSelectorConfigModel.PlaceComponentResult && this.scheduleImpl == bankSelectorConfigModel.scheduleImpl && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, bankSelectorConfigModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, bankSelectorConfigModel.BuiltInFictitiousFunctionClassFactory) && this.getAuthRequestContext == bankSelectorConfigModel.getAuthRequestContext && this.lookAheadTest == bankSelectorConfigModel.lookAheadTest && Intrinsics.areEqual(this.moveToNextValue, bankSelectorConfigModel.moveToNextValue);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r9v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.MyBillsEntityDataFactory;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
        int i = this.getErrorConfigVersion;
        int i2 = this.PlaceComponentResult;
        int i3 = this.scheduleImpl;
        int hashCode2 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        BankModel bankModel = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode3 = bankModel == null ? 0 : bankModel.hashCode();
        ?? r9 = this.getAuthRequestContext;
        int i4 = r9;
        if (r9 != 0) {
            i4 = 1;
        }
        boolean z2 = this.lookAheadTest;
        int i5 = z2 ? 1 : z2 ? 1 : 0;
        TransferInit transferInit = this.moveToNextValue;
        return (((((((((((((((((r0 * 31) + hashCode) * 31) + i) * 31) + i2) * 31) + i3) * 31) + hashCode2) * 31) + hashCode3) * 31) + i4) * 31) + i5) * 31) + (transferInit != null ? transferInit.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BankSelectorConfigModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BankSelectorConfigModel(boolean z, String str, int i, int i2, int i3, List<? extends BankModel> list, BankModel bankModel, boolean z2, boolean z3, TransferInit transferInit) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.MyBillsEntityDataFactory = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
        this.getErrorConfigVersion = i;
        this.PlaceComponentResult = i2;
        this.scheduleImpl = i3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = list;
        this.BuiltInFictitiousFunctionClassFactory = bankModel;
        this.getAuthRequestContext = z2;
        this.lookAheadTest = z3;
        this.moveToNextValue = transferInit;
    }

    public /* synthetic */ BankSelectorConfigModel(boolean z, String str, int i, int i2, int i3, List list, BankModel bankModel, boolean z2, boolean z3, TransferInit transferInit, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i4 & 2) != 0 ? "" : str, i, i2, i3, list, bankModel, (i4 & 128) != 0 ? false : z2, (i4 & 256) != 0 ? false : z3, transferInit);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getLookAheadTest() {
        return this.lookAheadTest;
    }

    public BankSelectorConfigModel() {
        this(false, "", 0, 0, 0, CollectionsKt.emptyList(), null, true, false, null, 256, null);
    }

    public final boolean MyBillsEntityDataFactory() {
        return !this.getAuthRequestContext && this.MyBillsEntityDataFactory;
    }
}
