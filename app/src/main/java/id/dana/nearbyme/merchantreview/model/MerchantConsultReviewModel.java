package id.dana.nearbyme.merchantreview.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.nearbyme.model.ShopModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0006\u001a\u00020\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\u0006\u0010#\u001a\u00020\u000b\u0012\b\b\u0002\u0010$\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0012\u0010\u0017\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001a\u001a\u00020\u001dX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0012\u0010 \u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014"}, d2 = {"Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Ljava/lang/String;", "", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewTagModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "PlaceComponentResult", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "I", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/nearbyme/model/ShopModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/nearbyme/model/ShopModel;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantConsultReviewModel implements Parcelable {
    public static final Parcelable.Creator<MerchantConsultReviewModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public List<MerchantReviewTagModel> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<MerchantReviewTagModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final ShopModel MyBillsEntityDataFactory;
    public final String getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MerchantConsultReviewModel) {
            MerchantConsultReviewModel merchantConsultReviewModel = (MerchantConsultReviewModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, merchantConsultReviewModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, merchantConsultReviewModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, merchantConsultReviewModel.PlaceComponentResult) && Intrinsics.areEqual(this.scheduleImpl, merchantConsultReviewModel.scheduleImpl) && Intrinsics.areEqual(this.getAuthRequestContext, merchantConsultReviewModel.getAuthRequestContext) && this.KClassImpl$Data$declaredNonStaticMembers$2 == merchantConsultReviewModel.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((this.MyBillsEntityDataFactory.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.scheduleImpl.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantConsultReviewModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeParcelable(this.MyBillsEntityDataFactory, p1);
        List<MerchantReviewTagModel> list = this.BuiltInFictitiousFunctionClassFactory;
        p0.writeInt(list.size());
        Iterator<MerchantReviewTagModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
        List<MerchantReviewTagModel> list2 = this.PlaceComponentResult;
        p0.writeInt(list2.size());
        Iterator<MerchantReviewTagModel> it2 = list2.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(p0, p1);
        }
        p0.writeString(this.scheduleImpl);
        p0.writeString(this.getAuthRequestContext);
        p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public MerchantConsultReviewModel(ShopModel shopModel, List<MerchantReviewTagModel> list, List<MerchantReviewTagModel> list2, String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.MyBillsEntityDataFactory = shopModel;
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.PlaceComponentResult = list2;
        this.scheduleImpl = str;
        this.getAuthRequestContext = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    public /* synthetic */ MerchantConsultReviewModel(ShopModel shopModel, List list, List list2, String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(shopModel, list, list2, str, str2, (i2 & 32) != 0 ? 0 : i);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<MerchantConsultReviewModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MerchantConsultReviewModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            ShopModel shopModel = (ShopModel) parcel.readParcelable(MerchantConsultReviewModel.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(MerchantReviewTagModel.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList2 = arrayList;
            int readInt2 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                arrayList3.add(MerchantReviewTagModel.CREATOR.createFromParcel(parcel));
            }
            return new MerchantConsultReviewModel(shopModel, arrayList2, arrayList3, parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MerchantConsultReviewModel[] newArray(int i) {
            return new MerchantConsultReviewModel[i];
        }
    }
}
