package id.dana.domain.model.rpc.response;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class LoginAuthenticationOptionResponse implements Parcelable {
    public static final Parcelable.Creator<LoginAuthenticationOptionResponse> CREATOR = new Parcelable.Creator<LoginAuthenticationOptionResponse>() { // from class: id.dana.domain.model.rpc.response.LoginAuthenticationOptionResponse.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ LoginAuthenticationOptionResponse createFromParcel(Parcel parcel) {
            return new LoginAuthenticationOptionResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LoginAuthenticationOptionResponse[] newArray(int i) {
            return new LoginAuthenticationOptionResponse[i];
        }
    };
    private String authenticationMethod;
    private boolean enrollFlag;
    private boolean kycFlag;
    private boolean riskFlag;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LoginAuthenticationOptionResponse() {
    }

    public LoginAuthenticationOptionResponse(String str) {
        this.authenticationMethod = str;
    }

    public String getAuthenticationMethod() {
        return this.authenticationMethod;
    }

    public void setAuthenticationMethod(String str) {
        this.authenticationMethod = str;
    }

    public boolean isEnrollFlag() {
        return this.enrollFlag;
    }

    public void setEnrollFlag(boolean z) {
        this.enrollFlag = z;
    }

    public boolean isKycFlag() {
        return this.kycFlag;
    }

    public void setKycFlag(boolean z) {
        this.kycFlag = z;
    }

    public boolean isRiskFlag() {
        return this.riskFlag;
    }

    public void setRiskFlag(boolean z) {
        this.riskFlag = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.authenticationMethod);
        parcel.writeByte(this.enrollFlag ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.kycFlag ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.riskFlag ? (byte) 1 : (byte) 0);
    }

    protected LoginAuthenticationOptionResponse(Parcel parcel) {
        this.authenticationMethod = parcel.readString();
        this.enrollFlag = parcel.readByte() != 0;
        this.kycFlag = parcel.readByte() != 0;
        this.riskFlag = parcel.readByte() != 0;
    }
}
