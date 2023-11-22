package id.dana.sendmoney_v2.x2l.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import id.dana.utils.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u0017"}, d2 = {"Lid/dana/sendmoney_v2/x2l/model/SocialLinkModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/content/Context;", "", "p1", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "hashCode", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SocialLinkModel implements Parcelable {
    public static final Parcelable.Creator<SocialLinkModel> CREATOR = new Creator();
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final String PlaceComponentResult;
    public final String getAuthRequestContext;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SocialLinkModel) {
            SocialLinkModel socialLinkModel = (SocialLinkModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, socialLinkModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, socialLinkModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, socialLinkModel.getAuthRequestContext) && Intrinsics.areEqual(this.PlaceComponentResult, socialLinkModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.MyBillsEntityDataFactory.hashCode() * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.PlaceComponentResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SocialLinkModel(MyBillsEntityDataFactory=");
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
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.PlaceComponentResult);
    }

    public SocialLinkModel(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.getAuthRequestContext = str3;
        this.PlaceComponentResult = str4;
    }

    public static String MyBillsEntityDataFactory(Context p0, String p1) {
        return ResourceUtils.PlaceComponentResult(p0, p1, p1);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<SocialLinkModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ SocialLinkModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new SocialLinkModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ SocialLinkModel[] newArray(int i) {
            return new SocialLinkModel[i];
        }
    }
}
