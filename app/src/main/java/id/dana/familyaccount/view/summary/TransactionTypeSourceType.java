package id.dana.familyaccount.view.summary;

import id.dana.R;
import id.dana.familyaccount.constants.FamilyAccountTransactionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u0000 \f2\u00020\u0001:\u0003\f\r\u000eB\u0019\b\u0004\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0007\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u0082\u0001\u0002\u000f\u0010"}, d2 = {"Lid/dana/familyaccount/view/summary/TransactionTypeSourceType;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "MyBillsEntityDataFactory", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(II)V", "Companion", "P2B", "P2P", "Lid/dana/familyaccount/view/summary/TransactionTypeSourceType$P2B;", "Lid/dana/familyaccount/view/summary/TransactionTypeSourceType$P2P;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class TransactionTypeSourceType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final int MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final int BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ TransactionTypeSourceType(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    private TransactionTypeSourceType(int i, int i2) {
        this.MyBillsEntityDataFactory = i;
        this.BuiltInFictitiousFunctionClassFactory = i2;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/summary/TransactionTypeSourceType$P2B;", "Lid/dana/familyaccount/view/summary/TransactionTypeSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class P2B extends TransactionTypeSourceType {
        public static final P2B INSTANCE = new P2B();

        private P2B() {
            super(R.drawable.ic_x2b_gold, R.string.family_account_text_organizer_summary_title_p2b, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/view/summary/TransactionTypeSourceType$P2P;", "Lid/dana/familyaccount/view/summary/TransactionTypeSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class P2P extends TransactionTypeSourceType {
        public static final P2P INSTANCE = new P2P();

        private P2P() {
            super(R.drawable.ic_x2p_48dp, R.string.family_account_text_organizer_summary_title_p2p, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/familyaccount/view/summary/TransactionTypeSourceType$Companion;", "", "", "p0", "Lid/dana/familyaccount/view/summary/TransactionTypeSourceType;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/familyaccount/view/summary/TransactionTypeSourceType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static TransactionTypeSourceType KClassImpl$Data$declaredNonStaticMembers$2(@FamilyAccountTransactionType String p0) {
            if (Intrinsics.areEqual(p0, FamilyAccountTransactionType.TRANSFER_X2B)) {
                return P2B.INSTANCE;
            }
            if (Intrinsics.areEqual(p0, FamilyAccountTransactionType.TRANSFER_X2P)) {
                return P2P.INSTANCE;
            }
            throw new IllegalStateException("Invalid transaction type");
        }
    }
}
