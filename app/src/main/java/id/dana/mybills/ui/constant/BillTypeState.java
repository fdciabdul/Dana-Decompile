package id.dana.mybills.ui.constant;

import id.dana.mybills.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011"}, d2 = {"Lid/dana/mybills/ui/constant/BillTypeState;", "", "", "BuiltInFictitiousFunctionClassFactory", "I", "p0", "<init>", "(I)V", "BillGNMerchant", "BillNotIssued", "BillNullAmount", "BillSchedule", "BillTrxInProgress", "Lid/dana/mybills/ui/constant/BillTypeState$BillSchedule;", "Lid/dana/mybills/ui/constant/BillTypeState$BillNotIssued;", "Lid/dana/mybills/ui/constant/BillTypeState$BillGNMerchant;", "Lid/dana/mybills/ui/constant/BillTypeState$BillNullAmount;", "Lid/dana/mybills/ui/constant/BillTypeState$BillTrxInProgress;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BillTypeState {
    public final int BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ BillTypeState(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private BillTypeState(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/constant/BillTypeState$BillSchedule;", "Lid/dana/mybills/ui/constant/BillTypeState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class BillSchedule extends BillTypeState {
        public static final BillSchedule INSTANCE = new BillSchedule();

        private BillSchedule() {
            super(R.string.mybills_tooltip_description_schedule, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/constant/BillTypeState$BillNotIssued;", "Lid/dana/mybills/ui/constant/BillTypeState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class BillNotIssued extends BillTypeState {
        public static final BillNotIssued INSTANCE = new BillNotIssued();

        private BillNotIssued() {
            super(R.string.mybills_tooltip_description_not_issued, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/constant/BillTypeState$BillGNMerchant;", "Lid/dana/mybills/ui/constant/BillTypeState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class BillGNMerchant extends BillTypeState {
        public static final BillGNMerchant INSTANCE = new BillGNMerchant();

        private BillGNMerchant() {
            super(R.string.mybills_tooltip_description_gn_merchant, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/constant/BillTypeState$BillNullAmount;", "Lid/dana/mybills/ui/constant/BillTypeState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class BillNullAmount extends BillTypeState {
        public static final BillNullAmount INSTANCE = new BillNullAmount();

        private BillNullAmount() {
            super(R.string.mybills_tooltip_description_null_amount, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/constant/BillTypeState$BillTrxInProgress;", "Lid/dana/mybills/ui/constant/BillTypeState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class BillTrxInProgress extends BillTypeState {
        public static final BillTrxInProgress INSTANCE = new BillTrxInProgress();

        private BillTrxInProgress() {
            super(R.string.mybills_tooltip_description_trx_in_progress, null);
        }
    }
}
