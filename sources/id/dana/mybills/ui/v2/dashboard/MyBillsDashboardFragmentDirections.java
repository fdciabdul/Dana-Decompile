package id.dana.mybills.ui.v2.dashboard;

import android.os.Bundle;
import androidx.view.ActionOnlyNavDirections;
import androidx.view.NavDirections;
import id.dana.mybills.R;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0005\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragmentDirections;", "", "<init>", "()V", "Companion", "ActionToMyBillsPaymentConfirmationFragment"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyBillsDashboardFragmentDirections {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00078\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0011R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragmentDirections$ActionToMyBillsPaymentConfirmationFragment;", "Landroidx/navigation/NavDirections;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "PlaceComponentResult", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "getAuthRequestContext", "", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "MyBillsEntityDataFactory", "[Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "BuiltInFictitiousFunctionClassFactory", "<init>", "([Lid/dana/mybills/ui/model/BillPaymentStatusModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    static final /* data */ class ActionToMyBillsPaymentConfirmationFragment implements NavDirections {
        private final int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final BillPaymentStatusModel[] BuiltInFictitiousFunctionClassFactory;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.mybills.ui.model.BillPaymentStatusModel[]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ActionToMyBillsPaymentConfirmationFragment() {
            /*
                r2 = this;
                r0 = 0
                r1 = 1
                r2.<init>(r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragmentDirections.ActionToMyBillsPaymentConfirmationFragment.<init>():void");
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof ActionToMyBillsPaymentConfirmationFragment) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, ((ActionToMyBillsPaymentConfirmationFragment) p0).BuiltInFictitiousFunctionClassFactory);
        }

        public final int hashCode() {
            BillPaymentStatusModel[] billPaymentStatusModelArr = this.BuiltInFictitiousFunctionClassFactory;
            if (billPaymentStatusModelArr == null) {
                return 0;
            }
            return Arrays.hashCode(billPaymentStatusModelArr);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ActionToMyBillsPaymentConfirmationFragment(BuiltInFictitiousFunctionClassFactory=");
            sb.append(Arrays.toString(this.BuiltInFictitiousFunctionClassFactory));
            sb.append(')');
            return sb.toString();
        }

        public ActionToMyBillsPaymentConfirmationFragment(BillPaymentStatusModel[] billPaymentStatusModelArr) {
            this.BuiltInFictitiousFunctionClassFactory = billPaymentStatusModelArr;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = R.id.action_to_myBillsPaymentConfirmationFragment;
        }

        public /* synthetic */ ActionToMyBillsPaymentConfirmationFragment(BillPaymentStatusModel[] billPaymentStatusModelArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : billPaymentStatusModelArr);
        }

        @Override // androidx.view.NavDirections
        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final int getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Override // androidx.view.NavDirections
        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2 */
        public final Bundle getKClassImpl$Data$declaredNonStaticMembers$2() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("mybills_bulk_pay", this.BuiltInFictitiousFunctionClassFactory);
            return bundle;
        }
    }

    private MyBillsDashboardFragmentDirections() {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u001d\u0010\u0003\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\u0003\u0010\u000b"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragmentDirections$Companion;", "", "Landroidx/navigation/NavDirections;", "getAuthRequestContext", "()Landroidx/navigation/NavDirections;", "MyBillsEntityDataFactory", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "p0", "([Lid/dana/mybills/ui/model/BillPaymentStatusModel;)Landroidx/navigation/NavDirections;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static NavDirections BuiltInFictitiousFunctionClassFactory() {
            return new ActionOnlyNavDirections(R.id.res_0x7f0a005f_networkuserentitydata_externalsyntheticlambda8);
        }

        public static NavDirections PlaceComponentResult() {
            return new ActionOnlyNavDirections(R.id.action_myBillsDashboardPage_to_manageBillsFragment);
        }

        public static NavDirections getAuthRequestContext(BillPaymentStatusModel[] p0) {
            return new ActionToMyBillsPaymentConfirmationFragment(p0);
        }

        public static NavDirections getAuthRequestContext() {
            return new ActionOnlyNavDirections(R.id.action_allPaidFragment_to_addNewBillsPage);
        }

        public static NavDirections MyBillsEntityDataFactory() {
            return new ActionOnlyNavDirections(R.id.action_allPaidFragment_to_manageBillsFragment);
        }
    }
}
