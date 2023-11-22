package id.dana.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes9.dex */
final class AutoValue_PopUpParcel extends C$AutoValue_PopUpParcel {
    public static final Parcelable.Creator<AutoValue_PopUpParcel> CREATOR = new Parcelable.Creator<AutoValue_PopUpParcel>() { // from class: id.dana.model.AutoValue_PopUpParcel.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ AutoValue_PopUpParcel createFromParcel(Parcel parcel) {
            return new AutoValue_PopUpParcel(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AutoValue_PopUpParcel[] newArray(int i) {
            return new AutoValue_PopUpParcel[i];
        }
    };

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    AutoValue_PopUpParcel(final String str, final int i, final int i2, final int i3, final int i4) {
        new PopUpParcel(str, i, i2, i3, i4) { // from class: id.dana.model.$AutoValue_PopUpParcel
            private final int BuiltInFictitiousFunctionClassFactory;
            private final int KClassImpl$Data$declaredNonStaticMembers$2;
            private final int MyBillsEntityDataFactory;
            private final String PlaceComponentResult;
            private final int getAuthRequestContext;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                if (str == null) {
                    throw new NullPointerException("Null phoneNumber");
                }
                this.PlaceComponentResult = str;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                this.MyBillsEntityDataFactory = i2;
                this.getAuthRequestContext = i3;
                this.BuiltInFictitiousFunctionClassFactory = i4;
            }

            @Override // id.dana.model.PopUpParcel
            public final String MyBillsEntityDataFactory() {
                return this.PlaceComponentResult;
            }

            @Override // id.dana.model.PopUpParcel
            public final int BuiltInFictitiousFunctionClassFactory() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2;
            }

            @Override // id.dana.model.PopUpParcel
            public final int getAuthRequestContext() {
                return this.MyBillsEntityDataFactory;
            }

            @Override // id.dana.model.PopUpParcel
            public final int KClassImpl$Data$declaredNonStaticMembers$2() {
                return this.getAuthRequestContext;
            }

            @Override // id.dana.model.PopUpParcel
            public final int PlaceComponentResult() {
                return this.BuiltInFictitiousFunctionClassFactory;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("PopUpParcel{phoneNumber=");
                sb.append(this.PlaceComponentResult);
                sb.append(", activityNumber=");
                sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(", otpCodeLength=");
                sb.append(this.MyBillsEntityDataFactory);
                sb.append(", retrySendSeconds=");
                sb.append(this.getAuthRequestContext);
                sb.append(", type=");
                sb.append(this.BuiltInFictitiousFunctionClassFactory);
                sb.append("}");
                return sb.toString();
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof PopUpParcel) {
                    PopUpParcel popUpParcel = (PopUpParcel) obj;
                    return this.PlaceComponentResult.equals(popUpParcel.MyBillsEntityDataFactory()) && this.KClassImpl$Data$declaredNonStaticMembers$2 == popUpParcel.BuiltInFictitiousFunctionClassFactory() && this.MyBillsEntityDataFactory == popUpParcel.getAuthRequestContext() && this.getAuthRequestContext == popUpParcel.KClassImpl$Data$declaredNonStaticMembers$2() && this.BuiltInFictitiousFunctionClassFactory == popUpParcel.PlaceComponentResult();
                }
                return false;
            }

            public int hashCode() {
                int hashCode = this.PlaceComponentResult.hashCode();
                int i5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                return ((((((((hashCode ^ 1000003) * 1000003) ^ i5) * 1000003) ^ this.MyBillsEntityDataFactory) * 1000003) ^ this.getAuthRequestContext) * 1000003) ^ this.BuiltInFictitiousFunctionClassFactory;
            }
        };
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(MyBillsEntityDataFactory());
        parcel.writeInt(BuiltInFictitiousFunctionClassFactory());
        parcel.writeInt(getAuthRequestContext());
        parcel.writeInt(KClassImpl$Data$declaredNonStaticMembers$2());
        parcel.writeInt(PlaceComponentResult());
    }
}
