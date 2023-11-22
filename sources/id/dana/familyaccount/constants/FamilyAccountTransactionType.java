package id.dana.familyaccount.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/familyaccount/constants/FamilyAccountTransactionType;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public @interface FamilyAccountTransactionType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.getAuthRequestContext;
    public static final String TRANSFER_X2B = "TRANSFER_X2B";
    public static final String TRANSFER_X2P = "TRANSFER_X2P";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/familyaccount/constants/FamilyAccountTransactionType$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion getAuthRequestContext = new Companion();

        private Companion() {
        }
    }
}