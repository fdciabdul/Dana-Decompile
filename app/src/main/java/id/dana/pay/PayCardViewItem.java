package id.dana.pay;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.R;

/* loaded from: classes5.dex */
public class PayCardViewItem implements Parcelable {
    public static final Parcelable.Creator<PayCardViewItem> CREATOR = new Parcelable.Creator<PayCardViewItem>() { // from class: id.dana.pay.PayCardViewItem.1
        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PayCardViewItem createFromParcel(Parcel parcel) {
            return new PayCardViewItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PayCardViewItem[] newArray(int i) {
            return new PayCardViewItem[i];
        }
    };
    public final int BuiltInFictitiousFunctionClassFactory;
    public final int KClassImpl$Data$declaredNonStaticMembers$2;
    public final int MyBillsEntityDataFactory;
    public final int PlaceComponentResult;
    public final int getAuthRequestContext;
    final int getErrorConfigVersion;
    public final int scheduleImpl;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ PayCardViewItem(int i, int i2, int i3, int i4, int i5, int i6, int i7, byte b) {
        this(i, i2, i3, i4, i5, i6, i7);
    }

    private PayCardViewItem(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.getErrorConfigVersion = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i3;
        this.MyBillsEntityDataFactory = i4;
        this.scheduleImpl = i5;
        if (i6 == 0) {
            this.PlaceComponentResult = i5;
        } else {
            this.PlaceComponentResult = i6;
        }
        this.getAuthRequestContext = i7;
    }

    protected PayCardViewItem(Parcel parcel) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = parcel.readInt();
        this.PlaceComponentResult = parcel.readInt();
        this.getAuthRequestContext = parcel.readInt();
        this.MyBillsEntityDataFactory = parcel.readInt();
        this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        this.scheduleImpl = parcel.readInt();
        this.getErrorConfigVersion = parcel.readInt();
    }

    public static Builder PlaceComponentResult() {
        return new Builder((byte) 0);
    }

    public static Builder MyBillsEntityDataFactory() {
        Builder builder = new Builder((byte) 0);
        builder.getErrorConfigVersion = R.drawable.bg_bank_card_vertical_default;
        builder.PlaceComponentResult = R.drawable.bg_bank_card_horizontal_default;
        builder.MyBillsEntityDataFactory = R.drawable.ic_default_bank_logo;
        builder.lookAheadTest = R.color.f24002131099997;
        builder.BuiltInFictitiousFunctionClassFactory = R.color.f26822131100404;
        return builder;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
        parcel.writeInt(this.PlaceComponentResult);
        parcel.writeInt(this.getAuthRequestContext);
        parcel.writeInt(this.MyBillsEntityDataFactory);
        parcel.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        parcel.writeInt(this.scheduleImpl);
        parcel.writeInt(this.getErrorConfigVersion);
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        int BuiltInFictitiousFunctionClassFactory;
        public int KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public int PlaceComponentResult;
        public int getAuthRequestContext;
        public int getErrorConfigVersion;
        public int lookAheadTest;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }

        public final PayCardViewItem PlaceComponentResult() {
            return new PayCardViewItem(this.getErrorConfigVersion, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, (byte) 0);
        }
    }
}
