package id.dana.riskChallenges.ui.util.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0016\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u000b8\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0013\u001a\u00020\u00168\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0015\u0010\u001e"}, d2 = {"Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "Lid/dana/riskChallenges/ui/resetpin/model/SecurityInfoModel;", "Lid/dana/riskChallenges/ui/resetpin/model/SecurityInfoModel;", "PlaceComponentResult", "()Lid/dana/riskChallenges/ui/resetpin/model/SecurityInfoModel;", "", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "()Ljava/util/List;", "p2", "<init>", "(Ljava/lang/String;Lid/dana/riskChallenges/ui/resetpin/model/SecurityInfoModel;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class BasicRiskChallengesModel implements Parcelable {
    public static final Parcelable.Creator<BasicRiskChallengesModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final List<VerificationMethodModel> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SecurityInfoModel BuiltInFictitiousFunctionClassFactory;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.getAuthRequestContext);
        this.BuiltInFictitiousFunctionClassFactory.writeToParcel(p0, p1);
        List<VerificationMethodModel> list = this.PlaceComponentResult;
        p0.writeInt(list.size());
        Iterator<VerificationMethodModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
    }

    public BasicRiskChallengesModel(String str, SecurityInfoModel securityInfoModel, List<VerificationMethodModel> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(securityInfoModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = securityInfoModel;
        this.PlaceComponentResult = list;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public String getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public SecurityInfoModel getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "getAuthRequestContext")
    public List<VerificationMethodModel> getAuthRequestContext() {
        return this.PlaceComponentResult;
    }

    public boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof BasicRiskChallengesModel) {
            BasicRiskChallengesModel basicRiskChallengesModel = (BasicRiskChallengesModel) p0;
            return Intrinsics.areEqual(getGetAuthRequestContext(), basicRiskChallengesModel.getGetAuthRequestContext()) && Intrinsics.areEqual(getBuiltInFictitiousFunctionClassFactory(), basicRiskChallengesModel.getBuiltInFictitiousFunctionClassFactory()) && Intrinsics.areEqual(getAuthRequestContext(), basicRiskChallengesModel.getAuthRequestContext());
        }
        return false;
    }

    public int hashCode() {
        return (((getGetAuthRequestContext().hashCode() * 31) + getBuiltInFictitiousFunctionClassFactory().hashCode()) * 31) + getAuthRequestContext().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BasicRiskChallengesModel(riskToken='");
        sb.append(getGetAuthRequestContext());
        sb.append("', securityInfo=");
        sb.append(getBuiltInFictitiousFunctionClassFactory());
        sb.append(", verificationMethodModels=");
        sb.append(getAuthRequestContext());
        sb.append(')');
        return sb.toString();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<BasicRiskChallengesModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BasicRiskChallengesModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            SecurityInfoModel createFromParcel = SecurityInfoModel.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(VerificationMethodModel.CREATOR.createFromParcel(parcel));
            }
            return new BasicRiskChallengesModel(readString, createFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BasicRiskChallengesModel[] newArray(int i) {
            return new BasicRiskChallengesModel[i];
        }
    }
}
