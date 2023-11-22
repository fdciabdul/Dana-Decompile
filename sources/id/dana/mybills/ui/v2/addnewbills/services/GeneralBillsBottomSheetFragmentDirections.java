package id.dana.mybills.ui.v2.addnewbills.services;

import androidx.view.ActionOnlyNavDirections;
import androidx.view.NavDirections;
import id.dana.mybills.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/services/GeneralBillsBottomSheetFragmentDirections;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class GeneralBillsBottomSheetFragmentDirections {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/services/GeneralBillsBottomSheetFragmentDirections$Companion;", "", "Landroidx/navigation/NavDirections;", "getAuthRequestContext", "()Landroidx/navigation/NavDirections;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static NavDirections getAuthRequestContext() {
            return new ActionOnlyNavDirections(R.id.action_generalBillsPage_to_myBillsDashboardPage);
        }
    }

    private GeneralBillsBottomSheetFragmentDirections() {
    }
}
