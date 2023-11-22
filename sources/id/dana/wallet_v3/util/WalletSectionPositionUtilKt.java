package id.dana.wallet_v3.util;

import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u0017\u0010\b\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\b\u0010\u0004\u001a\u0017\u0010\n\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\f\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\f\u0010\u000b\u001a\u0017\u0010\r\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\r\u0010\u000b\u001a\u0017\u0010\u000e\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0017\u0010\u000f\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u000f\u0010\u000b"}, d2 = {"", "", "", "indexOfIdentitySection", "(Ljava/util/List;)I", "indexOfInvestmentSection", "indexOfLoyaltySection", "indexOfPaymentSection", "indexOfVoucherAndTicketSection", "", "isContainIdentitySection", "(Ljava/util/List;)Z", "isContainInvestmentSection", "isContainLoyaltySection", "isContainPaymentSection", "isContainVoucherSection"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletSectionPositionUtilKt {
    public static final int indexOfPaymentSection(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String lowerCase = "PAYMENT".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return list.indexOf(lowerCase);
    }

    public static final int indexOfInvestmentSection(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String lowerCase = "FINANCIAL".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return list.indexOf(lowerCase);
    }

    public static final int indexOfVoucherAndTicketSection(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String lowerCase = "VOUCHER_AND_TICKET".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return list.indexOf(lowerCase);
    }

    public static final int indexOfLoyaltySection(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String lowerCase = "LOYALTY".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return list.indexOf(lowerCase);
    }

    public static final int indexOfIdentitySection(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String lowerCase = "IDENTITY".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return list.indexOf(lowerCase);
    }

    public static final boolean isContainPaymentSection(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String lowerCase = "PAYMENT".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return list.contains(lowerCase);
    }

    public static final boolean isContainInvestmentSection(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String lowerCase = "FINANCIAL".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return list.contains(lowerCase);
    }

    public static final boolean isContainVoucherSection(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String lowerCase = "VOUCHER_AND_TICKET".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return list.contains(lowerCase);
    }

    public static final boolean isContainLoyaltySection(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String lowerCase = "LOYALTY".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return list.contains(lowerCase);
    }

    public static final boolean isContainIdentitySection(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        String lowerCase = "IDENTITY".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return list.contains(lowerCase);
    }
}
