package id.dana.domain.paylater.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/domain/paylater/model/LoanWhitelist;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "isLoanWhitelisted", "()Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "lastFetchTime", "J", "getLastFetchTime", "()J", "setLastFetchTime", "(J)V", "", "Lid/dana/domain/paylater/model/LoanInfo;", "loanInfo", "Ljava/util/List;", "getLoanInfo", "()Ljava/util/List;", "setLoanInfo", "(Ljava/util/List;)V", "<init>", "(Ljava/util/List;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoanWhitelist implements Parcelable {
    public static final Parcelable.Creator<LoanWhitelist> CREATOR = new Creator();
    public long lastFetchTime;
    public List<LoanInfo> loanInfo;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<LoanWhitelist> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoanWhitelist createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(LoanInfo.CREATOR.createFromParcel(parcel));
            }
            return new LoanWhitelist(arrayList, parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LoanWhitelist[] newArray(int i) {
            return new LoanWhitelist[i];
        }
    }

    public /* synthetic */ LoanWhitelist() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        List<LoanInfo> list = this.loanInfo;
        parcel.writeInt(list.size());
        Iterator<LoanInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        parcel.writeLong(this.lastFetchTime);
    }

    public LoanWhitelist(List<LoanInfo> list, long j) {
        Intrinsics.checkNotNullParameter(list, "");
        this.loanInfo = list;
        this.lastFetchTime = j;
    }

    @JvmName(name = "getLoanInfo")
    public final List<LoanInfo> getLoanInfo() {
        return this.loanInfo;
    }

    @JvmName(name = "setLoanInfo")
    public final void setLoanInfo(List<LoanInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.loanInfo = list;
    }

    @JvmName(name = "getLastFetchTime")
    public final long getLastFetchTime() {
        return this.lastFetchTime;
    }

    @JvmName(name = "setLastFetchTime")
    public final void setLastFetchTime(long j) {
        this.lastFetchTime = j;
    }

    public final boolean isLoanWhitelisted() {
        Object obj;
        Iterator<T> it = this.loanInfo.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((LoanInfo) obj).getWhitelist()) {
                break;
            }
        }
        LoanInfo loanInfo = (LoanInfo) obj;
        return loanInfo != null && loanInfo.getWhitelist();
    }
}
