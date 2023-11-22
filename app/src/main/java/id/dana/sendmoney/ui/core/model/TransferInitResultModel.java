package id.dana.sendmoney.ui.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.core.ui.model.MoneyViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0006\u001a\u00020\u0013\u0012\u0006\u0010\u000f\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u0019¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\u0019X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0016\u001a\u00020\u0019X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u001b"}, d2 = {"Lid/dana/sendmoney/ui/core/model/TransferInitResultModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/core/ui/model/MoneyViewModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/model/MoneyViewModel;", "getAuthRequestContext", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/ui/core/model/TransferUserInfoModel;", "PlaceComponentResult", "Lid/dana/sendmoney/ui/core/model/TransferUserInfoModel;", "p2", "p3", "p4", "<init>", "(Lid/dana/core/ui/model/MoneyViewModel;Lid/dana/core/ui/model/MoneyViewModel;Lid/dana/core/ui/model/MoneyViewModel;Lid/dana/sendmoney/ui/core/model/TransferUserInfoModel;Lid/dana/sendmoney/ui/core/model/TransferUserInfoModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TransferInitResultModel implements Parcelable {
    public static final Parcelable.Creator<TransferInitResultModel> CREATOR = new Creator();
    public final MoneyViewModel BuiltInFictitiousFunctionClassFactory;
    public final MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final TransferUserInfoModel getAuthRequestContext;
    public final TransferUserInfoModel PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final MoneyViewModel MyBillsEntityDataFactory;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TransferInitResultModel) {
            TransferInitResultModel transferInitResultModel = (TransferInitResultModel) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, transferInitResultModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, transferInitResultModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, transferInitResultModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, transferInitResultModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, transferInitResultModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransferInitResultModel(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeParcelable(this.KClassImpl$Data$declaredNonStaticMembers$2, p1);
        p0.writeParcelable(this.MyBillsEntityDataFactory, p1);
        p0.writeParcelable(this.BuiltInFictitiousFunctionClassFactory, p1);
        this.getAuthRequestContext.writeToParcel(p0, p1);
        this.PlaceComponentResult.writeToParcel(p0, p1);
    }

    public TransferInitResultModel(MoneyViewModel moneyViewModel, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3, TransferUserInfoModel transferUserInfoModel, TransferUserInfoModel transferUserInfoModel2) {
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        Intrinsics.checkNotNullParameter(moneyViewModel2, "");
        Intrinsics.checkNotNullParameter(moneyViewModel3, "");
        Intrinsics.checkNotNullParameter(transferUserInfoModel, "");
        Intrinsics.checkNotNullParameter(transferUserInfoModel2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = moneyViewModel;
        this.MyBillsEntityDataFactory = moneyViewModel2;
        this.BuiltInFictitiousFunctionClassFactory = moneyViewModel3;
        this.getAuthRequestContext = transferUserInfoModel;
        this.PlaceComponentResult = transferUserInfoModel2;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<TransferInitResultModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TransferInitResultModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new TransferInitResultModel((MoneyViewModel) parcel.readParcelable(TransferInitResultModel.class.getClassLoader()), (MoneyViewModel) parcel.readParcelable(TransferInitResultModel.class.getClassLoader()), (MoneyViewModel) parcel.readParcelable(TransferInitResultModel.class.getClassLoader()), TransferUserInfoModel.CREATOR.createFromParcel(parcel), TransferUserInfoModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TransferInitResultModel[] newArray(int i) {
            return new TransferInitResultModel[i];
        }
    }
}
