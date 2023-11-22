package id.dana.riskChallenges.ui.resetpin.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010%\u001a\u00020\u0019\u0012\u0006\u0010&\u001a\u00020\u0005\u0012\u0006\u0010'\u001a\u00020\u001d\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0004\b)\u0010*J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0005X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u000b8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u001b\u001a\u00020\u00198\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0005X\u0007¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u001dX\u0007¢\u0006\u0006\n\u0004\b\u001b\u0010\u001eR \u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0015\u0010#"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/model/ResetPinModel;", "Landroid/os/Parcelable;", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "MyBillsEntityDataFactory", "Z", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/ui/resetpin/model/SecurityInfoModel;", "Lid/dana/riskChallenges/ui/resetpin/model/SecurityInfoModel;", "PlaceComponentResult", "()Lid/dana/riskChallenges/ui/resetpin/model/SecurityInfoModel;", "Lid/dana/riskChallenges/ui/resetpin/model/UserInfoModel;", "Lid/dana/riskChallenges/ui/resetpin/model/UserInfoModel;", "", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/List;", "()Ljava/util/List;", "getErrorConfigVersion", "p2", "p3", "p4", "p5", "<init>", "(ZLjava/lang/String;Lid/dana/riskChallenges/ui/resetpin/model/SecurityInfoModel;ZLid/dana/riskChallenges/ui/resetpin/model/UserInfoModel;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ResetPinModel extends BasicRiskChallengesModel implements Parcelable {
    public static final Parcelable.Creator<ResetPinModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final boolean MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final boolean getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final List<VerificationMethodModel> getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final UserInfoModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final SecurityInfoModel PlaceComponentResult;

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel, android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(this.getAuthRequestContext ? 1 : 0);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        this.PlaceComponentResult.writeToParcel(p0, p1);
        p0.writeInt(this.MyBillsEntityDataFactory ? 1 : 0);
        this.BuiltInFictitiousFunctionClassFactory.writeToParcel(p0, p1);
        List<VerificationMethodModel> list = this.getErrorConfigVersion;
        p0.writeInt(list.size());
        Iterator<VerificationMethodModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final SecurityInfoModel getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    @JvmName(name = "getAuthRequestContext")
    public final List<VerificationMethodModel> getAuthRequestContext() {
        return this.getErrorConfigVersion;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResetPinModel(boolean z, String str, SecurityInfoModel securityInfoModel, boolean z2, UserInfoModel userInfoModel, List<VerificationMethodModel> list) {
        super(str, securityInfoModel, list);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(securityInfoModel, "");
        Intrinsics.checkNotNullParameter(userInfoModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.PlaceComponentResult = securityInfoModel;
        this.MyBillsEntityDataFactory = z2;
        this.BuiltInFictitiousFunctionClassFactory = userInfoModel;
        this.getErrorConfigVersion = list;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<ResetPinModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ResetPinModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            boolean z = parcel.readInt() != 0;
            String readString = parcel.readString();
            SecurityInfoModel createFromParcel = SecurityInfoModel.CREATOR.createFromParcel(parcel);
            boolean z2 = parcel.readInt() != 0;
            UserInfoModel createFromParcel2 = UserInfoModel.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(VerificationMethodModel.CREATOR.createFromParcel(parcel));
            }
            return new ResetPinModel(z, readString, createFromParcel, z2, createFromParcel2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ResetPinModel[] newArray(int i) {
            return new ResetPinModel[i];
        }
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ResetPinModel) {
            ResetPinModel resetPinModel = (ResetPinModel) p0;
            return this.getAuthRequestContext == resetPinModel.getAuthRequestContext && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, resetPinModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, resetPinModel.PlaceComponentResult) && this.MyBillsEntityDataFactory == resetPinModel.MyBillsEntityDataFactory && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, resetPinModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getErrorConfigVersion, resetPinModel.getErrorConfigVersion);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    public final int hashCode() {
        boolean z = this.getAuthRequestContext;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        int hashCode2 = this.PlaceComponentResult.hashCode();
        boolean z2 = this.MyBillsEntityDataFactory;
        return (((((((((r0 * 31) + hashCode) * 31) + hashCode2) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.getErrorConfigVersion.hashCode();
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResetPinModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(')');
        return sb.toString();
    }
}
