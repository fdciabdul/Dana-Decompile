package id.dana.domain.payasset.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.sendmoney.model.AddPayMethod;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public class PayMethodView implements Parcelable {
    public static final Parcelable.Creator<PayMethodView> CREATOR = new Parcelable.Creator<PayMethodView>() { // from class: id.dana.domain.payasset.model.PayMethodView.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PayMethodView createFromParcel(Parcel parcel) {
            return new PayMethodView(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PayMethodView[] newArray(int i) {
            return new PayMethodView[i];
        }
    };
    private List<AddPayMethod> addPayMethods;
    private List<PayCardOptionView> payCardOptionViews;
    private List<PayChannelOptionView> payChannelOptionViews;
    private String payMethod;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected PayMethodView(Parcel parcel) {
        this.payCardOptionViews = parcel.createTypedArrayList(PayCardOptionView.CREATOR);
        this.payChannelOptionViews = parcel.createTypedArrayList(PayChannelOptionView.CREATOR);
        this.payMethod = parcel.readString();
    }

    public PayMethodView() {
    }

    public List<PayCardOptionView> getPayCardOptionViews() {
        return this.payCardOptionViews;
    }

    public void setPayCardOptionViews(List<PayCardOptionView> list) {
        this.payCardOptionViews = list;
    }

    public List<PayChannelOptionView> getPayChannelOptionViews() {
        return this.payChannelOptionViews;
    }

    public void setPayChannelOptionViews(List<PayChannelOptionView> list) {
        this.payChannelOptionViews = list;
    }

    public List<AddPayMethod> getAddPayMethods() {
        return this.addPayMethods;
    }

    public void setAddPayMethods(List<AddPayMethod> list) {
        this.addPayMethods = list;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public int hashCode() {
        List<PayCardOptionView> list = this.payCardOptionViews;
        int hashCode = list != null ? list.hashCode() : 0;
        List<PayChannelOptionView> list2 = this.payChannelOptionViews;
        int hashCode2 = list2 != null ? list2.hashCode() : 0;
        List<AddPayMethod> list3 = this.addPayMethods;
        int hashCode3 = list3 != null ? list3.hashCode() : 0;
        String str = this.payMethod;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str != null ? str.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayMethodView) {
            PayMethodView payMethodView = (PayMethodView) obj;
            if (Objects.equals(this.payCardOptionViews, payMethodView.payCardOptionViews) && Objects.equals(this.payChannelOptionViews, payMethodView.payChannelOptionViews) && Objects.equals(this.addPayMethods, payMethodView.addPayMethods)) {
                return Objects.equals(this.payMethod, payMethodView.payMethod);
            }
            return false;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.payCardOptionViews);
        parcel.writeTypedList(this.payChannelOptionViews);
        parcel.writeString(this.payMethod);
    }
}
