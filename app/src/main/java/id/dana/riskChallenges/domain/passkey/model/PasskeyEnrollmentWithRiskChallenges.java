package id.dana.riskChallenges.domain.passkey.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.riskChallenges.ui.resetpin.model.SecurityInfoModel;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/model/PasskeyEnrollmentWithRiskChallenges;", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "Landroid/os/Parcelable;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "getAuthRequestContext", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PasskeyEnrollmentWithRiskChallenges extends BasicRiskChallengesModel implements Parcelable {
    public static final Parcelable.Creator<PasskeyEnrollmentWithRiskChallenges> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final List<VerificationMethodModel> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel, android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        List<VerificationMethodModel> list = this.BuiltInFictitiousFunctionClassFactory;
        p0.writeInt(list.size());
        Iterator<VerificationMethodModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    @JvmName(name = "getAuthRequestContext")
    public final List<VerificationMethodModel> getAuthRequestContext() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasskeyEnrollmentWithRiskChallenges(String str, List<VerificationMethodModel> list) {
        super("", new SecurityInfoModel(str, "", ""), list);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.BuiltInFictitiousFunctionClassFactory = list;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<PasskeyEnrollmentWithRiskChallenges> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PasskeyEnrollmentWithRiskChallenges createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(VerificationMethodModel.CREATOR.createFromParcel(parcel));
            }
            return new PasskeyEnrollmentWithRiskChallenges(readString, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PasskeyEnrollmentWithRiskChallenges[] newArray(int i) {
            return new PasskeyEnrollmentWithRiskChallenges[i];
        }
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PasskeyEnrollmentWithRiskChallenges) {
            PasskeyEnrollmentWithRiskChallenges passkeyEnrollmentWithRiskChallenges = (PasskeyEnrollmentWithRiskChallenges) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, passkeyEnrollmentWithRiskChallenges.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, passkeyEnrollmentWithRiskChallenges.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    public final int hashCode() {
        return (this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode();
    }

    @Override // id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PasskeyEnrollmentWithRiskChallenges(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }
}
