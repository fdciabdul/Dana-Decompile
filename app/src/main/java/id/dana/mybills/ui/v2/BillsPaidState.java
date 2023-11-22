package id.dana.mybills.ui.v2;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/ui/v2/BillsPaidState;", "", "AllBillsFailed", "AllBillsPaid", "SomeBillsPaid", "Lid/dana/mybills/ui/v2/BillsPaidState$AllBillsPaid;", "Lid/dana/mybills/ui/v2/BillsPaidState$AllBillsFailed;", "Lid/dana/mybills/ui/v2/BillsPaidState$SomeBillsPaid;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public interface BillsPaidState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/BillsPaidState$AllBillsPaid;", "Lid/dana/mybills/ui/v2/BillsPaidState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class AllBillsPaid implements BillsPaidState {
        public static final AllBillsPaid INSTANCE = new AllBillsPaid();

        private AllBillsPaid() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/BillsPaidState$AllBillsFailed;", "Lid/dana/mybills/ui/v2/BillsPaidState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class AllBillsFailed implements BillsPaidState {
        public static final AllBillsFailed INSTANCE = new AllBillsFailed();

        private AllBillsFailed() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/BillsPaidState$SomeBillsPaid;", "Lid/dana/mybills/ui/v2/BillsPaidState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class SomeBillsPaid implements BillsPaidState {
        public static final SomeBillsPaid INSTANCE = new SomeBillsPaid();

        private SomeBillsPaid() {
        }
    }
}
