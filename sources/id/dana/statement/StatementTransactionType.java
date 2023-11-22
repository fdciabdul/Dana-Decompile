package id.dana.statement;

import id.dana.R;
import id.dana.domain.promoquest.model.PrizeType;
import id.dana.promoquest.handler.PromoQuestRedirectType;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016"}, d2 = {"Lid/dana/statement/StatementTransactionType;", "", "", "getDrawableIcon", "()I", "getLocalizedTitle", "", "bizType", "Ljava/lang/String;", "getBizType", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "TOPUP", PrizeType.CASHBACK, "RECEIVEMONEY", "DANAKAGET", PromoQuestRedirectType.SERVICES, "MERCHANT", "SENDMONEY", "CASHOUT", "DEFAULT"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum StatementTransactionType {
    TOPUP { // from class: id.dana.statement.StatementTransactionType.TOPUP
        @Override // id.dana.statement.StatementTransactionType
        public final int getDrawableIcon() {
            return R.drawable.ic_topup;
        }

        @Override // id.dana.statement.StatementTransactionType
        public final int getLocalizedTitle() {
            return R.string.topup;
        }
    },
    CASHBACK { // from class: id.dana.statement.StatementTransactionType.CASHBACK
        @Override // id.dana.statement.StatementTransactionType
        public final int getDrawableIcon() {
            return R.drawable.ic_gift_orange_filled;
        }

        @Override // id.dana.statement.StatementTransactionType
        public final int getLocalizedTitle() {
            return R.string.cashback;
        }
    },
    RECEIVEMONEY { // from class: id.dana.statement.StatementTransactionType.RECEIVEMONEY
        @Override // id.dana.statement.StatementTransactionType
        public final int getDrawableIcon() {
            return R.drawable.ic_receiver_orange;
        }

        @Override // id.dana.statement.StatementTransactionType
        public final int getLocalizedTitle() {
            return R.string.receive_money;
        }
    },
    DANAKAGET { // from class: id.dana.statement.StatementTransactionType.DANAKAGET
        @Override // id.dana.statement.StatementTransactionType
        public final int getDrawableIcon() {
            return R.drawable.icon_dana_kaget_filled;
        }

        @Override // id.dana.statement.StatementTransactionType
        public final int getLocalizedTitle() {
            return R.string.dana_kaget;
        }
    },
    SERVICES { // from class: id.dana.statement.StatementTransactionType.SERVICES
        @Override // id.dana.statement.StatementTransactionType
        public final int getDrawableIcon() {
            return R.drawable.icon_mobile_recharge_filled;
        }

        @Override // id.dana.statement.StatementTransactionType
        public final int getLocalizedTitle() {
            return R.string.services;
        }
    },
    MERCHANT { // from class: id.dana.statement.StatementTransactionType.MERCHANT
        @Override // id.dana.statement.StatementTransactionType
        public final int getDrawableIcon() {
            return R.drawable.ic_merchant_orange;
        }

        @Override // id.dana.statement.StatementTransactionType
        public final int getLocalizedTitle() {
            return R.string.merchant;
        }
    },
    SENDMONEY { // from class: id.dana.statement.StatementTransactionType.SENDMONEY
        @Override // id.dana.statement.StatementTransactionType
        public final int getDrawableIcon() {
            return R.drawable.ic_sender_blue;
        }

        @Override // id.dana.statement.StatementTransactionType
        public final int getLocalizedTitle() {
            return R.string.send_money_statement;
        }
    },
    CASHOUT { // from class: id.dana.statement.StatementTransactionType.CASHOUT
        @Override // id.dana.statement.StatementTransactionType
        public final int getDrawableIcon() {
            return R.drawable.icon_cashout_filled;
        }

        @Override // id.dana.statement.StatementTransactionType
        public final int getLocalizedTitle() {
            return R.string.cashout;
        }
    },
    DEFAULT { // from class: id.dana.statement.StatementTransactionType.DEFAULT
        @Override // id.dana.statement.StatementTransactionType
        public final int getDrawableIcon() {
            return R.drawable.greyish_square_rounded_skeleton;
        }

        @Override // id.dana.statement.StatementTransactionType
        public final int getLocalizedTitle() {
            return R.string.default_type;
        }
    };


    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bizType;

    /* synthetic */ StatementTransactionType(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @JvmStatic
    public static final StatementTransactionType getStatementTransactionType(String str) {
        return Companion.BuiltInFictitiousFunctionClassFactory(str);
    }

    public abstract int getDrawableIcon();

    public abstract int getLocalizedTitle();

    StatementTransactionType(String str) {
        this.bizType = str;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/statement/StatementTransactionType$Companion;", "", "", "p0", "Lid/dana/statement/StatementTransactionType;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/statement/StatementTransactionType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static StatementTransactionType BuiltInFictitiousFunctionClassFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return Intrinsics.areEqual(p0, StatementTransactionType.TOPUP.getBizType()) ? StatementTransactionType.TOPUP : Intrinsics.areEqual(p0, StatementTransactionType.CASHBACK.getBizType()) ? StatementTransactionType.CASHBACK : Intrinsics.areEqual(p0, StatementTransactionType.RECEIVEMONEY.getBizType()) ? StatementTransactionType.RECEIVEMONEY : Intrinsics.areEqual(p0, StatementTransactionType.DANAKAGET.getBizType()) ? StatementTransactionType.DANAKAGET : Intrinsics.areEqual(p0, StatementTransactionType.SERVICES.getBizType()) ? StatementTransactionType.SERVICES : Intrinsics.areEqual(p0, StatementTransactionType.MERCHANT.getBizType()) ? StatementTransactionType.MERCHANT : Intrinsics.areEqual(p0, StatementTransactionType.SENDMONEY.getBizType()) ? StatementTransactionType.SENDMONEY : Intrinsics.areEqual(p0, StatementTransactionType.CASHOUT.getBizType()) ? StatementTransactionType.CASHOUT : StatementTransactionType.DEFAULT;
        }
    }
}
