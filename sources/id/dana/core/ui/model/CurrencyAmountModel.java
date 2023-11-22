package id.dana.core.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.core.ui.util.NumberFormatterUtil;
import id.dana.core.ui.util.NumberUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0010\u0010\u000eJ \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00058\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/core/ui/model/CurrencyAmountModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "getCurrencyAndAmountValue", "()Ljava/lang/String;", "getUnformatedAmount", "", "isAmountLessThanOne", "()Z", "value", "isLessThan", "(Lid/dana/core/ui/model/CurrencyAmountModel;)Z", "moreValue", "isMoreThan", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "amount", "Ljava/lang/String;", "getAmount", "setAmount", "(Ljava/lang/String;)V", FirebaseAnalytics.Param.CURRENCY, "getCurrency", "setCurrency", "placeholder", "Z", "getPlaceholder", "setPlaceholder", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CurrencyAmountModel implements Parcelable {
    public static final Parcelable.Creator<CurrencyAmountModel> CREATOR = new Creator();
    private String amount;
    private String currency;
    private boolean placeholder;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<CurrencyAmountModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CurrencyAmountModel createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new CurrencyAmountModel(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CurrencyAmountModel[] newArray(int i) {
            return new CurrencyAmountModel[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.amount);
        parcel.writeString(this.currency);
        parcel.writeInt(this.placeholder ? 1 : 0);
    }

    public CurrencyAmountModel(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.amount = str;
        this.currency = str2;
        this.placeholder = z;
    }

    public /* synthetic */ CurrencyAmountModel(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "setAmount")
    public final void setAmount(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.amount = str;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "setCurrency")
    public final void setCurrency(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.currency = str;
    }

    @JvmName(name = "getPlaceholder")
    public final boolean getPlaceholder() {
        return this.placeholder;
    }

    @JvmName(name = "setPlaceholder")
    public final void setPlaceholder(boolean z) {
        this.placeholder = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isMoreThan(id.dana.core.ui.model.CurrencyAmountModel r8) {
        /*
            r7 = this;
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L57
            java.lang.String r2 = r8.amount
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L10
            r2 = 1
            goto L11
        L10:
            r2 = 0
        L11:
            if (r2 != 0) goto L57
            java.lang.String r2 = r8.getUnformatedAmount()
            if (r2 == 0) goto L28
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L23
            r2 = 1
            goto L24
        L23:
            r2 = 0
        L24:
            if (r2 != r0) goto L28
            r2 = 1
            goto L29
        L28:
            r2 = 0
        L29:
            if (r2 == 0) goto L2c
            goto L57
        L2c:
            java.lang.String r2 = r7.getUnformatedAmount()
            r3 = 0
            if (r2 == 0) goto L47
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r5 = r5.length()
            if (r5 != 0) goto L3f
            r5 = 1
            goto L40
        L3f:
            r5 = 0
        L40:
            if (r5 != 0) goto L47
            long r5 = java.lang.Long.parseLong(r2)
            goto L48
        L47:
            r5 = r3
        L48:
            java.lang.String r8 = r8.getUnformatedAmount()
            if (r8 == 0) goto L52
            long r3 = java.lang.Long.parseLong(r8)
        L52:
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 <= 0) goto L57
            goto L58
        L57:
            r0 = 0
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.model.CurrencyAmountModel.isMoreThan(id.dana.core.ui.model.CurrencyAmountModel):boolean");
    }

    public final String getUnformatedAmount() {
        NumberUtil numberUtil = NumberUtil.INSTANCE;
        String str = this.amount;
        Intrinsics.checkNotNullParameter(str, "");
        return NumberUtil.KClassImpl$Data$declaredNonStaticMembers$2(NumberUtil.PlaceComponentResult(str));
    }

    public final boolean isLessThan(CurrencyAmountModel value) {
        if ((value != null ? value.amount : null) == null || TextUtils.isEmpty(value.amount)) {
            return false;
        }
        String unformatedAmount = value.getUnformatedAmount();
        long parseLong = unformatedAmount != null ? Long.parseLong(unformatedAmount) : 0L;
        String unformatedAmount2 = getUnformatedAmount();
        return (unformatedAmount2 != null ? Long.parseLong(unformatedAmount2) : 0L) < parseLong;
    }

    public final boolean isAmountLessThanOne() {
        if (this.amount.length() > 0) {
            String unformatedAmount = getUnformatedAmount();
            return (unformatedAmount != null ? Long.parseLong(unformatedAmount) : 0L) < 1;
        }
        return true;
    }

    public final String getCurrencyAndAmountValue() {
        String str = null;
        try {
            if (!TextUtils.isEmpty(this.amount) && !TextUtils.isEmpty(this.currency)) {
                if (!StringsKt.contains$default((CharSequence) this.amount, (CharSequence) ".", false, 2, (Object) null)) {
                    str = NumberFormatterUtil.MyBillsEntityDataFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), Integer.parseInt(this.amount), this.currency);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.currency);
                    sb.append(this.amount);
                    str = sb.toString();
                }
            }
        } catch (NumberFormatException unused) {
        }
        return str;
    }
}
