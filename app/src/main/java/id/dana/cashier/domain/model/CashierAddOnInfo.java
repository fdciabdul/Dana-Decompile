package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/domain/model/CashierAddOnInfo;", "", "FromApi", "FromCdn", "Lid/dana/cashier/domain/model/CashierAddOnInfo$FromApi;", "Lid/dana/cashier/domain/model/CashierAddOnInfo$FromCdn;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CashierAddOnInfo {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/cashier/domain/model/CashierAddOnInfo$FromApi;", "Lid/dana/cashier/domain/model/CashierAddOnInfo;", "Lid/dana/cashier/domain/model/CashierAddOnModalContent;", "cashierAddOnModalContent", "Lid/dana/cashier/domain/model/CashierAddOnModalContent;", "getCashierAddOnModalContent", "()Lid/dana/cashier/domain/model/CashierAddOnModalContent;", "Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;", "cashierAddonModalTooltip", "Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;", "getCashierAddonModalTooltip", "()Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;", "<init>", "(Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;Lid/dana/cashier/domain/model/CashierAddOnModalContent;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class FromApi implements CashierAddOnInfo {
        private final CashierAddOnModalContent cashierAddOnModalContent;
        private final CashierAddOnModalTooltip cashierAddonModalTooltip;

        public FromApi(CashierAddOnModalTooltip cashierAddOnModalTooltip, CashierAddOnModalContent cashierAddOnModalContent) {
            Intrinsics.checkNotNullParameter(cashierAddOnModalTooltip, "");
            Intrinsics.checkNotNullParameter(cashierAddOnModalContent, "");
            this.cashierAddonModalTooltip = cashierAddOnModalTooltip;
            this.cashierAddOnModalContent = cashierAddOnModalContent;
        }

        @JvmName(name = "getCashierAddonModalTooltip")
        public final CashierAddOnModalTooltip getCashierAddonModalTooltip() {
            return this.cashierAddonModalTooltip;
        }

        @JvmName(name = "getCashierAddOnModalContent")
        public final CashierAddOnModalContent getCashierAddOnModalContent() {
            return this.cashierAddOnModalContent;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/cashier/domain/model/CashierAddOnInfo$FromCdn;", "Lid/dana/cashier/domain/model/CashierAddOnInfo;", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "image", "getImage", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class FromCdn implements CashierAddOnInfo {
        private final String content;
        private final String image;
        private final String title;

        public FromCdn(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.image = str;
            this.title = str2;
            this.content = str3;
        }

        @JvmName(name = "getImage")
        public final String getImage() {
            return this.image;
        }

        @JvmName(name = "getTitle")
        public final String getTitle() {
            return this.title;
        }

        @JvmName(name = "getContent")
        public final String getContent() {
            return this.content;
        }
    }
}
