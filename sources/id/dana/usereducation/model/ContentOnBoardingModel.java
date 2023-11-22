package id.dana.usereducation.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cB!\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001dB3\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0018\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0012\u0010\u0017\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0012\u0010\u0019\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014"}, d2 = {"Lid/dana/usereducation/model/ContentOnBoardingModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "I", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p2", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "p3", "p4", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ContentOnBoardingModel implements Parcelable {
    public static final Parcelable.Creator<ContentOnBoardingModel> CREATOR = new Creator();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String PlaceComponentResult;
    public int getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ContentOnBoardingModel) {
            ContentOnBoardingModel contentOnBoardingModel = (ContentOnBoardingModel) p0;
            return this.getAuthRequestContext == contentOnBoardingModel.getAuthRequestContext && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, contentOnBoardingModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, contentOnBoardingModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, contentOnBoardingModel.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, contentOnBoardingModel.MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((this.getAuthRequestContext * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.PlaceComponentResult.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContentOnBoardingModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(this.getAuthRequestContext);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.MyBillsEntityDataFactory);
    }

    public ContentOnBoardingModel(int i, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.PlaceComponentResult = str3;
        this.MyBillsEntityDataFactory = str4;
    }

    public /* synthetic */ ContentOnBoardingModel(int i, String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, str2, str3, str4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentOnBoardingModel(int i, String str, String str2) {
        this(i, null, str, str2, "LOCAL", 2, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentOnBoardingModel(String str, String str2, String str3) {
        this(0, str, str2, str3, "URL", 1, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<ContentOnBoardingModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ContentOnBoardingModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new ContentOnBoardingModel(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ContentOnBoardingModel[] newArray(int i) {
            return new ContentOnBoardingModel[i];
        }
    }
}
