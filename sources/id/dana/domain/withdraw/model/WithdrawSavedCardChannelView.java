package id.dana.domain.withdraw.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes5.dex */
public class WithdrawSavedCardChannelView implements Parcelable {
    public static final Parcelable.Creator<WithdrawSavedCardChannelView> CREATOR = new Parcelable.Creator<WithdrawSavedCardChannelView>() { // from class: id.dana.domain.withdraw.model.WithdrawSavedCardChannelView.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ WithdrawSavedCardChannelView createFromParcel(Parcel parcel) {
            return new WithdrawSavedCardChannelView(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WithdrawSavedCardChannelView[] newArray(int i) {
            return new WithdrawSavedCardChannelView[i];
        }
    };
    private String bindingId;
    private String cardIndexNo;
    private int cardNoLength;
    private boolean disable;
    private String formattedHolderName;
    private String formattedMaskedCardNo;
    private String instId;
    private String instLocalName;
    private String instName;
    private String payMethod;
    private String payOption;
    private boolean validData;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private WithdrawSavedCardChannelView() {
    }

    protected WithdrawSavedCardChannelView(Parcel parcel) {
        this.bindingId = parcel.readString();
        this.cardIndexNo = parcel.readString();
        this.cardNoLength = parcel.readInt();
        this.disable = parcel.readByte() != 0;
        this.formattedHolderName = parcel.readString();
        this.formattedMaskedCardNo = parcel.readString();
        this.instId = parcel.readString();
        this.instLocalName = parcel.readString();
        this.instName = parcel.readString();
        this.payMethod = parcel.readString();
        this.payOption = parcel.readString();
        this.validData = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bindingId);
        parcel.writeString(this.cardIndexNo);
        parcel.writeInt(this.cardNoLength);
        parcel.writeByte(this.disable ? (byte) 1 : (byte) 0);
        parcel.writeString(this.formattedHolderName);
        parcel.writeString(this.formattedMaskedCardNo);
        parcel.writeString(this.instId);
        parcel.writeString(this.instLocalName);
        parcel.writeString(this.instName);
        parcel.writeString(this.payMethod);
        parcel.writeString(this.payOption);
        parcel.writeByte(this.validData ? (byte) 1 : (byte) 0);
    }

    public String getBindingId() {
        return this.bindingId;
    }

    public String getCardIndexNo() {
        return this.cardIndexNo;
    }

    public int getCardNoLength() {
        return this.cardNoLength;
    }

    public boolean isDisable() {
        return this.disable;
    }

    public String getFormattedHolderName() {
        return this.formattedHolderName;
    }

    public String getFormattedMaskedCardNo() {
        return this.formattedMaskedCardNo;
    }

    public String getInstId() {
        return this.instId;
    }

    public String getInstLocalName() {
        return this.instLocalName;
    }

    public String getInstName() {
        return this.instName;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public String getPayOption() {
        return this.payOption;
    }

    public boolean isValidData() {
        return this.validData;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private String bindingId;
        private String cardIndexNo;
        private int cardNoLength;
        private boolean disable;
        private String formattedHolderName;
        private String formattedMaskedCardNo;
        private String instId;
        private String instLocalName;
        private String instName;
        private String payMethod;
        private String payOption;
        private boolean validData;

        public Builder bindingId(String str) {
            this.bindingId = str;
            return this;
        }

        public Builder cardIndexNo(String str) {
            this.cardIndexNo = str;
            return this;
        }

        public Builder cardNoLength(int i) {
            this.cardNoLength = i;
            return this;
        }

        public Builder disable(boolean z) {
            this.disable = z;
            return this;
        }

        public Builder formattedHolderName(String str) {
            this.formattedHolderName = str;
            return this;
        }

        public Builder formattedMaskedCardNo(String str) {
            this.formattedMaskedCardNo = str;
            return this;
        }

        public Builder instId(String str) {
            this.instId = str;
            return this;
        }

        public Builder instName(String str) {
            this.instName = str;
            return this;
        }

        public Builder instLocalName(String str) {
            this.instLocalName = str;
            return this;
        }

        public Builder payMethod(String str) {
            this.payMethod = str;
            return this;
        }

        public Builder payOption(String str) {
            this.payOption = str;
            return this;
        }

        public Builder validData(boolean z) {
            this.validData = z;
            return this;
        }

        public WithdrawSavedCardChannelView build() {
            WithdrawSavedCardChannelView withdrawSavedCardChannelView = new WithdrawSavedCardChannelView();
            withdrawSavedCardChannelView.bindingId = this.bindingId;
            withdrawSavedCardChannelView.cardIndexNo = this.cardIndexNo;
            withdrawSavedCardChannelView.cardNoLength = this.cardNoLength;
            withdrawSavedCardChannelView.disable = this.disable;
            withdrawSavedCardChannelView.formattedHolderName = this.formattedHolderName;
            withdrawSavedCardChannelView.formattedMaskedCardNo = this.formattedMaskedCardNo;
            withdrawSavedCardChannelView.instId = this.instId;
            withdrawSavedCardChannelView.instLocalName = this.instLocalName;
            withdrawSavedCardChannelView.instName = this.instName;
            withdrawSavedCardChannelView.payMethod = this.payMethod;
            withdrawSavedCardChannelView.payOption = this.payOption;
            withdrawSavedCardChannelView.validData = this.validData;
            return withdrawSavedCardChannelView;
        }
    }
}
