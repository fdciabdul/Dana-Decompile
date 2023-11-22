package id.dana.core.ui.util.connectivity.mapper;

import id.dana.core.ui.util.connectivity.InternetConnectionStatus;
import id.dana.core.ui.util.connectivity.model.ConnectivityModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/core/ui/util/connectivity/model/ConnectivityModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/core/ui/util/connectivity/model/ConnectivityModel;)Z", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/core/ui/util/connectivity/model/ConnectivityModel;)Ljava/lang/String;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectivityModelMapperKt {
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(ConnectivityModel connectivityModel) {
        Intrinsics.checkNotNullParameter(connectivityModel, "");
        if (connectivityModel instanceof ConnectivityModel.ConnectionStatus) {
            return ((ConnectivityModel.ConnectionStatus) connectivityModel).getGetAuthRequestContext();
        }
        if (connectivityModel instanceof ConnectivityModel.SignalStatus) {
            return !Intrinsics.areEqual(((ConnectivityModel.SignalStatus) connectivityModel).MyBillsEntityDataFactory, InternetConnectionStatus.NOT_CONNECTED);
        }
        throw new NoWhenBranchMatchedException();
    }

    @InternetConnectionStatus
    public static final String BuiltInFictitiousFunctionClassFactory(ConnectivityModel connectivityModel) {
        Intrinsics.checkNotNullParameter(connectivityModel, "");
        if (connectivityModel instanceof ConnectivityModel.ConnectionStatus) {
            return ((ConnectivityModel.ConnectionStatus) connectivityModel).getGetAuthRequestContext() ? InternetConnectionStatus.FAST_CONNECTION : InternetConnectionStatus.NOT_CONNECTED;
        } else if (!(connectivityModel instanceof ConnectivityModel.SignalStatus)) {
            throw new NoWhenBranchMatchedException();
        } else {
            return ((ConnectivityModel.SignalStatus) connectivityModel).MyBillsEntityDataFactory;
        }
    }
}
