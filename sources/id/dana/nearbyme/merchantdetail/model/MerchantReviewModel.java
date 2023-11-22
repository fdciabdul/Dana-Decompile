package id.dana.nearbyme.merchantdetail.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.nearbyme.model.Tag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u0000 @2\u00020\u0001:\u0001@BÇ\u0001\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010/\u001a\u00020\u000b\u0012\b\b\u0002\u00100\u001a\u00020\u000b\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\u0016\u0012\b\b\u0002\u00103\u001a\u00020\u0016\u0012\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\b\b\u0002\u00105\u001a\u00020\u000b\u0012\b\b\u0002\u00106\u001a\u00020\u000b\u0012\b\b\u0002\u00107\u001a\u00020\u0007\u0012\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001c\u0012\u0010\b\u0002\u00109\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001c\u0012\b\b\u0002\u0010:\u001a\u00020\u000b\u0012\b\b\u0002\u0010;\u001a\u00020\u000b\u0012\b\b\u0002\u0010<\u001a\u00020\u000b\u0012\b\b\u0002\u0010=\u001a\u00020\u000b¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0016X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0013\u001a\u00020\u00078\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0013\u0010\u001bR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0011\u0010!\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b \u0010\u0014R\u0011\u0010#\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\"\u0010\u0014R\u0011\u0010$\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b#\u0010\u0014R\u0011\u0010 \u001a\u00020\u0016X\u0007¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0019\u0010\"\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001cX\u0007¢\u0006\u0006\n\u0004\b!\u0010\u001eR\u0019\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001cX\u0007¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u0011\u0010)\u001a\u00020\u0002X\u0007¢\u0006\u0006\n\u0004\b'\u0010(R\u0011\u0010'\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b*\u0010\u0014R\u0011\u0010*\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b)\u0010\u0014R\u0011\u0010+\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b+\u0010\u0014R\u0011\u0010-\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b,\u0010\u0014R\u0011\u0010,\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b.\u0010\u0014"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "MyBillsEntityDataFactory", "", "PlaceComponentResult", "J", "getAuthRequestContext", "Z", "()Z", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "getErrorConfigVersion", "lookAheadTest", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/nearbyme/model/Tag;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "I", "initRecordTimeStamp", "DatabaseTableConfigUtil", "GetContactSyncConfig", "PrepareContext", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLjava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MerchantReviewModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final String GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final List<MerchantImageModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final long moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final int initRecordTimeStamp;
    public final List<Tag> NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public final String PrepareContext;
    public final long PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final String isLayoutRequested;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final List<Tag> lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<MerchantReviewModel> CREATOR = new Creator();

    public MerchantReviewModel() {
        this(null, null, null, null, 0, 0L, 0L, null, null, null, false, null, null, null, null, null, null, 131071, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MerchantReviewModel) {
            MerchantReviewModel merchantReviewModel = (MerchantReviewModel) p0;
            return Intrinsics.areEqual(this.isLayoutRequested, merchantReviewModel.isLayoutRequested) && Intrinsics.areEqual(this.PrepareContext, merchantReviewModel.PrepareContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, merchantReviewModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && this.initRecordTimeStamp == merchantReviewModel.initRecordTimeStamp && this.moveToNextValue == merchantReviewModel.moveToNextValue && this.PlaceComponentResult == merchantReviewModel.PlaceComponentResult && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, merchantReviewModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.scheduleImpl, merchantReviewModel.scheduleImpl) && this.KClassImpl$Data$declaredNonStaticMembers$2 == merchantReviewModel.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.lookAheadTest, merchantReviewModel.lookAheadTest) && Intrinsics.areEqual(this.GetContactSyncConfig, merchantReviewModel.GetContactSyncConfig) && Intrinsics.areEqual(this.getErrorConfigVersion, merchantReviewModel.getErrorConfigVersion) && Intrinsics.areEqual(this.getAuthRequestContext, merchantReviewModel.getAuthRequestContext) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, merchantReviewModel.DatabaseTableConfigUtil);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.isLayoutRequested.hashCode();
        int hashCode2 = this.PrepareContext.hashCode();
        int hashCode3 = this.MyBillsEntityDataFactory.hashCode();
        int hashCode4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1.hashCode();
        int i = this.initRecordTimeStamp;
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.moveToNextValue);
        int m2 = Cbor$Arg$$ExternalSyntheticBackport0.m(this.PlaceComponentResult);
        int hashCode5 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode6 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
        int hashCode7 = this.scheduleImpl.hashCode();
        boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        List<Tag> list = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode8 = list == null ? 0 : list.hashCode();
        List<Tag> list2 = this.lookAheadTest;
        return (((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i) * 31) + m) * 31) + m2) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + i2) * 31) + hashCode8) * 31) + (list2 != null ? list2.hashCode() : 0)) * 31) + this.GetContactSyncConfig.hashCode()) * 31) + this.getErrorConfigVersion.hashCode()) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.DatabaseTableConfigUtil.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MerchantReviewModel(isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.isLayoutRequested);
        p0.writeString(this.PrepareContext);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        p0.writeInt(this.initRecordTimeStamp);
        p0.writeLong(this.moveToNextValue);
        p0.writeLong(this.PlaceComponentResult);
        List<MerchantImageModel> list = this.BuiltInFictitiousFunctionClassFactory;
        p0.writeInt(list.size());
        Iterator<MerchantImageModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(p0, p1);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.scheduleImpl);
        p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0);
        List<Tag> list2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (list2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list2.size());
            Iterator<Tag> it2 = list2.iterator();
            while (it2.hasNext()) {
                p0.writeParcelable(it2.next(), p1);
            }
        }
        List<Tag> list3 = this.lookAheadTest;
        if (list3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list3.size());
            Iterator<Tag> it3 = list3.iterator();
            while (it3.hasNext()) {
                p0.writeParcelable(it3.next(), p1);
            }
        }
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.DatabaseTableConfigUtil);
    }

    public MerchantReviewModel(String str, String str2, String str3, String str4, int i, long j, long j2, List<MerchantImageModel> list, String str5, String str6, boolean z, List<Tag> list2, List<Tag> list3, String str7, String str8, String str9, String str10) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        this.isLayoutRequested = str;
        this.PrepareContext = str2;
        this.MyBillsEntityDataFactory = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str4;
        this.initRecordTimeStamp = i;
        this.moveToNextValue = j;
        this.PlaceComponentResult = j2;
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str5;
        this.scheduleImpl = str6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = list2;
        this.lookAheadTest = list3;
        this.GetContactSyncConfig = str7;
        this.getErrorConfigVersion = str8;
        this.getAuthRequestContext = str9;
        this.DatabaseTableConfigUtil = str10;
    }

    public /* synthetic */ MerchantReviewModel(String str, String str2, String str3, String str4, int i, long j, long j2, List list, String str5, String str6, boolean z, List list2, List list3, String str7, String str8, String str9, String str10, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? 0L : j, (i2 & 64) == 0 ? j2 : 0L, (i2 & 128) != 0 ? CollectionsKt.emptyList() : list, (i2 & 256) != 0 ? "" : str5, (i2 & 512) != 0 ? "" : str6, (i2 & 1024) == 0 ? z : false, (i2 & 2048) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 4096) != 0 ? CollectionsKt.emptyList() : list3, (i2 & 8192) != 0 ? "" : str7, (i2 & 16384) != 0 ? "" : str8, (i2 & 32768) != 0 ? "" : str9, (i2 & 65536) != 0 ? "" : str10);
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\bJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\bJ!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\t\u0010\fJ\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0006J\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\b"}, d2 = {"Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel$Companion;", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "p0", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "PlaceComponentResult", "()Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "getAuthRequestContext", "MyBillsEntityDataFactory", "", "(Ljava/util/List;)Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [id.dana.nearbyme.merchantdetail.model.MerchantReviewModel, kotlin.jvm.internal.DefaultConstructorMarker] */
        public static MerchantReviewViewModel KClassImpl$Data$declaredNonStaticMembers$2() {
            ?? r1 = 0;
            int i = 2;
            return new MerchantReviewViewModel(i, r1, i, r1);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [id.dana.nearbyme.merchantdetail.model.MerchantReviewModel, kotlin.jvm.internal.DefaultConstructorMarker] */
        public static MerchantReviewViewModel getAuthRequestContext() {
            ?? r1 = 0;
            return new MerchantReviewViewModel(3, r1, 2, r1);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [id.dana.nearbyme.merchantdetail.model.MerchantReviewModel, kotlin.jvm.internal.DefaultConstructorMarker] */
        public static MerchantReviewViewModel MyBillsEntityDataFactory() {
            ?? r1 = 0;
            return new MerchantReviewViewModel(4, r1, 2, r1);
        }

        public static MerchantReviewViewModel getAuthRequestContext(MerchantReviewModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new MerchantReviewViewModel(0, p0);
        }

        public static MerchantReviewViewModel BuiltInFictitiousFunctionClassFactory(MerchantReviewModel p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new MerchantReviewViewModel(1, p0);
        }

        public static List<MerchantReviewViewModel> getAuthRequestContext(List<MerchantReviewModel> p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            List<MerchantReviewModel> list = p0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (MerchantReviewModel merchantReviewModel : list) {
                Companion companion = MerchantReviewModel.INSTANCE;
                arrayList.add(new MerchantReviewViewModel(5, merchantReviewModel));
            }
            return arrayList;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [id.dana.nearbyme.merchantdetail.model.MerchantReviewModel, kotlin.jvm.internal.DefaultConstructorMarker] */
        public static MerchantReviewViewModel BuiltInFictitiousFunctionClassFactory() {
            ?? r1 = 0;
            return new MerchantReviewViewModel(7, r1, 2, r1);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [id.dana.nearbyme.merchantdetail.model.MerchantReviewModel, kotlin.jvm.internal.DefaultConstructorMarker] */
        public static MerchantReviewViewModel PlaceComponentResult() {
            ?? r1 = 0;
            return new MerchantReviewViewModel(8, r1, 2, r1);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<MerchantReviewModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MerchantReviewModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            for (int i = 0; i != readInt2; i++) {
                arrayList2.add(MerchantImageModel.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList3 = arrayList2;
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            ArrayList arrayList4 = null;
            if (parcel.readInt() == 0) {
                z = z2;
                arrayList = null;
            } else {
                int readInt3 = parcel.readInt();
                arrayList = new ArrayList(readInt3);
                z = z2;
                int i2 = 0;
                while (i2 != readInt3) {
                    arrayList.add(parcel.readParcelable(MerchantReviewModel.class.getClassLoader()));
                    i2++;
                    readInt3 = readInt3;
                }
            }
            ArrayList arrayList5 = arrayList;
            if (parcel.readInt() != 0) {
                int readInt4 = parcel.readInt();
                ArrayList arrayList6 = new ArrayList(readInt4);
                int i3 = 0;
                while (i3 != readInt4) {
                    arrayList6.add(parcel.readParcelable(MerchantReviewModel.class.getClassLoader()));
                    i3++;
                    readInt4 = readInt4;
                }
                arrayList4 = arrayList6;
            }
            return new MerchantReviewModel(readString, readString2, readString3, readString4, readInt, readLong, readLong2, arrayList3, readString5, readString6, z, arrayList5, arrayList4, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MerchantReviewModel[] newArray(int i) {
            return new MerchantReviewModel[i];
        }
    }
}
