package id.dana.core.ui.util.connectivity.model;

import id.dana.core.ui.util.connectivity.InternetConnectionStatus;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007"}, d2 = {"Lid/dana/core/ui/util/connectivity/model/ConnectivityModel;", "", "<init>", "()V", "ConnectionStatus", "SignalStatus", "Lid/dana/core/ui/util/connectivity/model/ConnectivityModel$SignalStatus;", "Lid/dana/core/ui/util/connectivity/model/ConnectivityModel$ConnectionStatus;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ConnectivityModel {
    public /* synthetic */ ConnectivityModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ConnectivityModel() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/core/ui/util/connectivity/model/ConnectivityModel$SignalStatus;", "Lid/dana/core/ui/util/connectivity/model/ConnectivityModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class SignalStatus extends ConnectivityModel {
        public final String MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof SignalStatus) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((SignalStatus) p0).MyBillsEntityDataFactory);
        }

        public final int hashCode() {
            return this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SignalStatus(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignalStatus(@InternetConnectionStatus String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = str;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/core/ui/util/connectivity/model/ConnectivityModel$ConnectionStatus;", "Lid/dana/core/ui/util/connectivity/model/ConnectivityModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Z", "MyBillsEntityDataFactory", "()Z", "getAuthRequestContext", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class ConnectionStatus extends ConnectivityModel {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean getAuthRequestContext;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            return (p0 instanceof ConnectionStatus) && this.getAuthRequestContext == ((ConnectionStatus) p0).getAuthRequestContext;
        }

        public final int hashCode() {
            boolean z = this.getAuthRequestContext;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ConnectionStatus(getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        public ConnectionStatus(boolean z) {
            super(null);
            this.getAuthRequestContext = z;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }
    }
}
