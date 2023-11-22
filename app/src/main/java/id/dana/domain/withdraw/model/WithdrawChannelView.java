package id.dana.domain.withdraw.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class WithdrawChannelView implements Parcelable {
    public static final Parcelable.Creator<WithdrawChannelView> CREATOR = new Parcelable.Creator<WithdrawChannelView>() { // from class: id.dana.domain.withdraw.model.WithdrawChannelView.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ WithdrawChannelView createFromParcel(Parcel parcel) {
            return new WithdrawChannelView(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WithdrawChannelView[] newArray(int i) {
            return new WithdrawChannelView[i];
        }
    };
    private String channelIndex;
    private boolean enableStatus;
    private String instId;
    private String instLocalName;
    private String instName;
    private String payMethod;
    private String payOption;
    private List<PayOptionDTOResponse> payOptionDTOResponses;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private WithdrawChannelView() {
    }

    protected WithdrawChannelView(Parcel parcel) {
        this.payOptionDTOResponses = new ArrayList();
        this.channelIndex = parcel.readString();
        this.enableStatus = parcel.readByte() != 0;
        this.instId = parcel.readString();
        this.instLocalName = parcel.readString();
        this.instName = parcel.readString();
        this.payMethod = parcel.readString();
        this.payOption = parcel.readString();
        parcel.readList(this.payOptionDTOResponses, PayOptionDTOResponse.class.getClassLoader());
    }

    public String getChannelIndex() {
        return this.channelIndex;
    }

    public boolean isEnableStatus() {
        return this.enableStatus;
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

    public List<PayOptionDTOResponse> getPayOptionDTOResponses() {
        return this.payOptionDTOResponses;
    }

    public void setPayOptionDTOResponses(List<PayOptionDTOResponse> list) {
        this.payOptionDTOResponses = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.channelIndex);
        parcel.writeByte(this.enableStatus ? (byte) 1 : (byte) 0);
        parcel.writeString(this.instId);
        parcel.writeString(this.instLocalName);
        parcel.writeString(this.instName);
        parcel.writeString(this.payMethod);
        parcel.writeString(this.payOption);
        parcel.writeList(this.payOptionDTOResponses);
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private String channelIndex;
        private boolean enableStatus;
        private String instId;
        private String instLocalName;
        private String instName;
        private String payMethod;
        private String payOption;
        private List<PayOptionDTOResponse> payOptionDTOResponses;

        public Builder channelIndex(String str) {
            this.channelIndex = str;
            return this;
        }

        public Builder enableStatus(boolean z) {
            this.enableStatus = z;
            return this;
        }

        public Builder instId(String str) {
            this.instId = str;
            return this;
        }

        public Builder instLocalName(String str) {
            this.instLocalName = str;
            return this;
        }

        public Builder instName(String str) {
            this.instName = str;
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

        public Builder payMethodInfos(List<PayOptionDTOResponse> list) {
            this.payOptionDTOResponses = list;
            return this;
        }

        public WithdrawChannelView build() {
            WithdrawChannelView withdrawChannelView = new WithdrawChannelView();
            withdrawChannelView.channelIndex = this.channelIndex;
            withdrawChannelView.enableStatus = this.enableStatus;
            withdrawChannelView.instId = this.instId;
            withdrawChannelView.instLocalName = this.instLocalName;
            withdrawChannelView.instName = this.instName;
            withdrawChannelView.payMethod = this.payMethod;
            withdrawChannelView.payOption = this.payOption;
            withdrawChannelView.payOptionDTOResponses = this.payOptionDTOResponses;
            return withdrawChannelView;
        }
    }
}
