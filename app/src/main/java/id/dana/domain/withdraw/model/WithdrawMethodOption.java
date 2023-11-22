package id.dana.domain.withdraw.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class WithdrawMethodOption implements Parcelable {
    public static final Parcelable.Creator<WithdrawMethodOption> CREATOR = new Parcelable.Creator<WithdrawMethodOption>() { // from class: id.dana.domain.withdraw.model.WithdrawMethodOption.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ WithdrawMethodOption createFromParcel(Parcel parcel) {
            return new WithdrawMethodOption(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WithdrawMethodOption[] newArray(int i) {
            return new WithdrawMethodOption[i];
        }
    };
    private List<WithdrawSavedCardChannelView> withdrawCardOptions;
    private List<WithdrawChannelView> withdrawChannelOptions;
    private String withdrawMethod;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private WithdrawMethodOption() {
    }

    public WithdrawMethodOption(Parcel parcel) {
        this.withdrawCardOptions = new ArrayList();
        this.withdrawChannelOptions = new ArrayList();
        this.withdrawMethod = parcel.readString();
        parcel.readList(this.withdrawCardOptions, WithdrawSavedCardChannelView.class.getClassLoader());
        parcel.readList(this.withdrawChannelOptions, WithdrawChannelView.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.withdrawMethod);
        parcel.writeList(this.withdrawCardOptions);
        parcel.writeList(this.withdrawChannelOptions);
    }

    public List<WithdrawSavedCardChannelView> getWithdrawCardOptions() {
        return this.withdrawCardOptions;
    }

    public List<WithdrawChannelView> getWithdrawChannelOptions() {
        return this.withdrawChannelOptions;
    }

    public String getWithdrawMethod() {
        return this.withdrawMethod;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private List<WithdrawSavedCardChannelView> withdrawCardOptions;
        private List<WithdrawChannelView> withdrawChannelOptions;
        private String withdrawMethod;

        public Builder withdrawCardOptions(List<WithdrawSavedCardChannelView> list) {
            this.withdrawCardOptions = list;
            return this;
        }

        public Builder withdrawChannelOptions(List<WithdrawChannelView> list) {
            this.withdrawChannelOptions = list;
            return this;
        }

        public Builder withdrawMethod(String str) {
            this.withdrawMethod = str;
            return this;
        }

        public WithdrawMethodOption build() {
            WithdrawMethodOption withdrawMethodOption = new WithdrawMethodOption();
            withdrawMethodOption.withdrawCardOptions = this.withdrawCardOptions;
            withdrawMethodOption.withdrawChannelOptions = this.withdrawChannelOptions;
            withdrawMethodOption.withdrawMethod = this.withdrawMethod;
            return withdrawMethodOption;
        }
    }
}
