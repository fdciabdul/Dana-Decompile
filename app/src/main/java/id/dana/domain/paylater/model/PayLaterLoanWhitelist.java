package id.dana.domain.paylater.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b6\u00107J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0013J\r\u0010\u001d\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010 J\r\u0010!\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\u001eJ\r\u0010\"\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010\u001eJ\u0010\u0010#\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b#\u0010\u001bJ \u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b(\u0010)R\"\u0010\f\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010*\u001a\u0004\b+\u0010\u0004\"\u0004\b,\u0010-R\"\u0010\u000e\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010.\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u00101R(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u00102\u001a\u0004\b3\u0010\b\"\u0004\b4\u00105"}, d2 = {"Lid/dana/domain/paylater/model/PayLaterLoanWhitelist;", "Landroid/os/Parcelable;", "Lid/dana/domain/paylater/model/LoanWhitelist;", "component1", "()Lid/dana/domain/paylater/model/LoanWhitelist;", "", "Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "component2", "()Ljava/util/List;", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "component3", "()Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "loanWhitelist", "statusWhitelist", "paylaterCicilConfig", "copy", "(Lid/dana/domain/paylater/model/LoanWhitelist;Ljava/util/List;Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;)Lid/dana/domain/paylater/model/PayLaterLoanWhitelist;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "getLoanTypeWithStatusDueOrOverdue", "()Ljava/lang/String;", "hashCode", "isLoanStatusWhitelistAlwaysConsult", "()Z", "type", "(Ljava/lang/String;)Z", "isLoanTypeDueOrOverdue", "isLoanTypeUnregistered", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lid/dana/domain/paylater/model/LoanWhitelist;", "getLoanWhitelist", "setLoanWhitelist", "(Lid/dana/domain/paylater/model/LoanWhitelist;)V", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "getPaylaterCicilConfig", "setPaylaterCicilConfig", "(Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;)V", "Ljava/util/List;", "getStatusWhitelist", "setStatusWhitelist", "(Ljava/util/List;)V", "<init>", "(Lid/dana/domain/paylater/model/LoanWhitelist;Ljava/util/List;Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PayLaterLoanWhitelist implements Parcelable {
    public static final Parcelable.Creator<PayLaterLoanWhitelist> CREATOR = new Creator();
    private LoanWhitelist loanWhitelist;
    private PaylaterCicilMethodConfig paylaterCicilConfig;
    private List<LoanStatusWhitelist> statusWhitelist;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<PayLaterLoanWhitelist> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PayLaterLoanWhitelist createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            LoanWhitelist createFromParcel = LoanWhitelist.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(LoanStatusWhitelist.CREATOR.createFromParcel(parcel));
            }
            return new PayLaterLoanWhitelist(createFromParcel, arrayList, PaylaterCicilMethodConfig.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PayLaterLoanWhitelist[] newArray(int i) {
            return new PayLaterLoanWhitelist[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayLaterLoanWhitelist copy$default(PayLaterLoanWhitelist payLaterLoanWhitelist, LoanWhitelist loanWhitelist, List list, PaylaterCicilMethodConfig paylaterCicilMethodConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            loanWhitelist = payLaterLoanWhitelist.loanWhitelist;
        }
        if ((i & 2) != 0) {
            list = payLaterLoanWhitelist.statusWhitelist;
        }
        if ((i & 4) != 0) {
            paylaterCicilMethodConfig = payLaterLoanWhitelist.paylaterCicilConfig;
        }
        return payLaterLoanWhitelist.copy(loanWhitelist, list, paylaterCicilMethodConfig);
    }

    /* renamed from: component1  reason: from getter */
    public final LoanWhitelist getLoanWhitelist() {
        return this.loanWhitelist;
    }

    public final List<LoanStatusWhitelist> component2() {
        return this.statusWhitelist;
    }

    /* renamed from: component3  reason: from getter */
    public final PaylaterCicilMethodConfig getPaylaterCicilConfig() {
        return this.paylaterCicilConfig;
    }

    public final PayLaterLoanWhitelist copy(LoanWhitelist loanWhitelist, List<LoanStatusWhitelist> statusWhitelist, PaylaterCicilMethodConfig paylaterCicilConfig) {
        Intrinsics.checkNotNullParameter(loanWhitelist, "");
        Intrinsics.checkNotNullParameter(statusWhitelist, "");
        Intrinsics.checkNotNullParameter(paylaterCicilConfig, "");
        return new PayLaterLoanWhitelist(loanWhitelist, statusWhitelist, paylaterCicilConfig);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PayLaterLoanWhitelist) {
            PayLaterLoanWhitelist payLaterLoanWhitelist = (PayLaterLoanWhitelist) other;
            return Intrinsics.areEqual(this.loanWhitelist, payLaterLoanWhitelist.loanWhitelist) && Intrinsics.areEqual(this.statusWhitelist, payLaterLoanWhitelist.statusWhitelist) && Intrinsics.areEqual(this.paylaterCicilConfig, payLaterLoanWhitelist.paylaterCicilConfig);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.loanWhitelist.hashCode() * 31) + this.statusWhitelist.hashCode()) * 31) + this.paylaterCicilConfig.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayLaterLoanWhitelist(loanWhitelist=");
        sb.append(this.loanWhitelist);
        sb.append(", statusWhitelist=");
        sb.append(this.statusWhitelist);
        sb.append(", paylaterCicilConfig=");
        sb.append(this.paylaterCicilConfig);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        this.loanWhitelist.writeToParcel(parcel, flags);
        List<LoanStatusWhitelist> list = this.statusWhitelist;
        parcel.writeInt(list.size());
        Iterator<LoanStatusWhitelist> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
        this.paylaterCicilConfig.writeToParcel(parcel, flags);
    }

    public PayLaterLoanWhitelist(LoanWhitelist loanWhitelist, List<LoanStatusWhitelist> list, PaylaterCicilMethodConfig paylaterCicilMethodConfig) {
        Intrinsics.checkNotNullParameter(loanWhitelist, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(paylaterCicilMethodConfig, "");
        this.loanWhitelist = loanWhitelist;
        this.statusWhitelist = list;
        this.paylaterCicilConfig = paylaterCicilMethodConfig;
    }

    @JvmName(name = "getLoanWhitelist")
    public final LoanWhitelist getLoanWhitelist() {
        return this.loanWhitelist;
    }

    @JvmName(name = "setLoanWhitelist")
    public final void setLoanWhitelist(LoanWhitelist loanWhitelist) {
        Intrinsics.checkNotNullParameter(loanWhitelist, "");
        this.loanWhitelist = loanWhitelist;
    }

    @JvmName(name = "getStatusWhitelist")
    public final List<LoanStatusWhitelist> getStatusWhitelist() {
        return this.statusWhitelist;
    }

    @JvmName(name = "setStatusWhitelist")
    public final void setStatusWhitelist(List<LoanStatusWhitelist> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.statusWhitelist = list;
    }

    @JvmName(name = "getPaylaterCicilConfig")
    public final PaylaterCicilMethodConfig getPaylaterCicilConfig() {
        return this.paylaterCicilConfig;
    }

    @JvmName(name = "setPaylaterCicilConfig")
    public final void setPaylaterCicilConfig(PaylaterCicilMethodConfig paylaterCicilMethodConfig) {
        Intrinsics.checkNotNullParameter(paylaterCicilMethodConfig, "");
        this.paylaterCicilConfig = paylaterCicilMethodConfig;
    }

    public final String getLoanTypeWithStatusDueOrOverdue() {
        Object obj;
        Iterator<T> it = this.statusWhitelist.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            LoanStatusWhitelist loanStatusWhitelist = (LoanStatusWhitelist) obj;
            boolean z = true;
            if (!StringsKt.equals(loanStatusWhitelist.getStatus(), "overdue", true) && !StringsKt.contains((CharSequence) loanStatusWhitelist.getStatus(), (CharSequence) "due", true) && !StringsKt.equals(loanStatusWhitelist.getStatus(), "unregistered", true)) {
                z = false;
            }
        }
        LoanStatusWhitelist loanStatusWhitelist2 = (LoanStatusWhitelist) obj;
        String type = loanStatusWhitelist2 != null ? loanStatusWhitelist2.getType() : null;
        return type == null ? "" : type;
    }

    public final boolean isLoanTypeUnregistered() {
        Object obj;
        Iterator<T> it = this.statusWhitelist.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.equals(((LoanStatusWhitelist) obj).getStatus(), "unregistered", true)) {
                break;
            }
        }
        return obj != null;
    }

    public final boolean isLoanTypeDueOrOverdue() {
        Object obj;
        Iterator<T> it = this.statusWhitelist.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            LoanStatusWhitelist loanStatusWhitelist = (LoanStatusWhitelist) obj;
            if (StringsKt.equals(loanStatusWhitelist.getStatus(), "overdue", true) || StringsKt.contains((CharSequence) loanStatusWhitelist.getStatus(), (CharSequence) "due", true)) {
                break;
            }
        }
        return obj != null;
    }

    public final boolean isLoanStatusWhitelistAlwaysConsult() {
        Object obj;
        Iterator<T> it = this.statusWhitelist.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((LoanStatusWhitelist) obj).getAlwaysConsult(), Boolean.TRUE)) {
                break;
            }
        }
        return obj != null;
    }

    public final boolean isLoanStatusWhitelistAlwaysConsult(String type) {
        Object obj;
        Intrinsics.checkNotNullParameter(type, "");
        Iterator<T> it = this.statusWhitelist.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((LoanStatusWhitelist) obj).getType(), type)) {
                break;
            }
        }
        LoanStatusWhitelist loanStatusWhitelist = (LoanStatusWhitelist) obj;
        if (loanStatusWhitelist != null) {
            return Intrinsics.areEqual(loanStatusWhitelist.getAlwaysConsult(), Boolean.TRUE);
        }
        return false;
    }
}
