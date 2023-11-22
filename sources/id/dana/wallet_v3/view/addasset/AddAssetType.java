package id.dana.wallet_v3.view.addasset;

import id.dana.domain.payasset.model.PayMethod;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/wallet_v3/view/addasset/AddAssetType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes3.dex */
public @interface AddAssetType {
    public static final int ALL = 0;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int FINANCIAL = 2;
    public static final int IDENTITY = 5;
    public static final int LOYALTY = 4;
    public static final int PAYMENT = 1;
    public static final int VOUCHER = 3;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\u0004"}, d2 = {"Lid/dana/wallet_v3/view/addasset/AddAssetType$Companion;", "", "", PayMethod.ALL, "I", "FINANCIAL", "IDENTITY", "LOYALTY", "PAYMENT", "VOUCHER", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ALL = 0;
        public static final int FINANCIAL = 2;
        public static final int IDENTITY = 5;
        public static final int LOYALTY = 4;
        public static final int PAYMENT = 1;
        public static final int VOUCHER = 3;

        private Companion() {
        }
    }
}
