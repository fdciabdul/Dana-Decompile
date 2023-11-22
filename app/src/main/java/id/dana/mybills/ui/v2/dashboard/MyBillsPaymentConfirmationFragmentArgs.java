package id.dana.mybills.ui.v2.dashboard;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.view.NavArgs;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/MyBillsPaymentConfirmationFragmentArgs;", "Landroidx/navigation/NavArgs;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "MyBillsEntityDataFactory", "[Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "getAuthRequestContext", "<init>", "([Lid/dana/mybills/ui/model/BillPaymentStatusModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class MyBillsPaymentConfirmationFragmentArgs implements NavArgs {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final BillPaymentStatusModel[] getAuthRequestContext;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.mybills.ui.model.BillPaymentStatusModel[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MyBillsPaymentConfirmationFragmentArgs() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragmentArgs.<init>():void");
    }

    @JvmStatic
    public static final MyBillsPaymentConfirmationFragmentArgs fromBundle(Bundle bundle) {
        return Companion.PlaceComponentResult(bundle);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        return (p0 instanceof MyBillsPaymentConfirmationFragmentArgs) && Intrinsics.areEqual(this.getAuthRequestContext, ((MyBillsPaymentConfirmationFragmentArgs) p0).getAuthRequestContext);
    }

    public final int hashCode() {
        BillPaymentStatusModel[] billPaymentStatusModelArr = this.getAuthRequestContext;
        if (billPaymentStatusModelArr == null) {
            return 0;
        }
        return Arrays.hashCode(billPaymentStatusModelArr);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyBillsPaymentConfirmationFragmentArgs(getAuthRequestContext=");
        sb.append(Arrays.toString(this.getAuthRequestContext));
        sb.append(')');
        return sb.toString();
    }

    public MyBillsPaymentConfirmationFragmentArgs(BillPaymentStatusModel[] billPaymentStatusModelArr) {
        this.getAuthRequestContext = billPaymentStatusModelArr;
    }

    public /* synthetic */ MyBillsPaymentConfirmationFragmentArgs(BillPaymentStatusModel[] billPaymentStatusModelArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : billPaymentStatusModelArr);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/MyBillsPaymentConfirmationFragmentArgs$Companion;", "", "Landroid/os/Bundle;", "p0", "Lid/dana/mybills/ui/v2/dashboard/MyBillsPaymentConfirmationFragmentArgs;", "PlaceComponentResult", "(Landroid/os/Bundle;)Lid/dana/mybills/ui/v2/dashboard/MyBillsPaymentConfirmationFragmentArgs;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static MyBillsPaymentConfirmationFragmentArgs PlaceComponentResult(Bundle p0) {
            Parcelable[] parcelableArray;
            Intrinsics.checkNotNullParameter(p0, "");
            p0.setClassLoader(MyBillsPaymentConfirmationFragmentArgs.class.getClassLoader());
            BillPaymentStatusModel[] billPaymentStatusModelArr = null;
            if (p0.containsKey("mybills_bulk_pay") && (parcelableArray = p0.getParcelableArray("mybills_bulk_pay")) != null) {
                ArrayList arrayList = new ArrayList(parcelableArray.length);
                for (Parcelable parcelable : parcelableArray) {
                    if (parcelable == null) {
                        throw new NullPointerException("null cannot be cast to non-null type id.dana.mybills.ui.model.BillPaymentStatusModel");
                    }
                    arrayList.add((BillPaymentStatusModel) parcelable);
                }
                Object[] array = arrayList.toArray(new BillPaymentStatusModel[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
                billPaymentStatusModelArr = (BillPaymentStatusModel[]) array;
            }
            return new MyBillsPaymentConfirmationFragmentArgs(billPaymentStatusModelArr);
        }
    }
}
