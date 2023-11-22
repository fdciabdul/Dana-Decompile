package id.dana.sendmoney.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0016\u001a\u00020\u0005X\u0096\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/sendmoney/model/RecentBankModel;", "Lid/dana/sendmoney/model/BankModel;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "p0", "", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "newProxyInstance", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda8", "BuiltInFictitiousFunctionClassFactory", "", "isLayoutRequested", "Ljava/lang/Long;", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda4", "I", "MyBillsEntityDataFactory", "p2", "p3", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecentBankModel extends BankModel implements Parcelable {
    public static final Parcelable.Creator<RecentBankModel> CREATOR = new Creator();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    public Long PlaceComponentResult;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    public RecentBankModel() {
        this(0, null, null, null, 15, null);
    }

    @Override // id.dana.sendmoney.model.BankModel, android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeInt(this.MyBillsEntityDataFactory);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        Long l = this.PlaceComponentResult;
        if (l == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeLong(l.longValue());
    }

    public /* synthetic */ RecentBankModel(int i, String str, String str2, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? 0L : l);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public RecentBankModel(int r22, java.lang.String r23, java.lang.String r24, java.lang.Long r25) {
        /*
            r21 = this;
            r15 = r21
            r0 = r21
            r1 = r22
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r15 = r16
            r17 = 0
            r18 = 0
            r19 = 262142(0x3fffe, float:3.67339E-40)
            r20 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r0.MyBillsEntityDataFactory = r1
            r1 = r23
            r0.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            r1 = r24
            r0.BuiltInFictitiousFunctionClassFactory = r1
            r1 = r25
            r0.PlaceComponentResult = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.model.RecentBankModel.<init>(int, java.lang.String, java.lang.String, java.lang.Long):void");
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<RecentBankModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RecentBankModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new RecentBankModel(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RecentBankModel[] newArray(int i) {
            return new RecentBankModel[i];
        }
    }
}
