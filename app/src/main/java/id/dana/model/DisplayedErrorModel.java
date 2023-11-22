package id.dana.model;

import id.dana.data.foundation.RpcException;
import id.dana.network.exception.NetworkException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB7\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004"}, d2 = {"Lid/dana/model/DisplayedErrorModel;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DisplayedErrorModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    public DisplayedErrorModel() {
        this(null, null, null, null, 15, null);
    }

    public DisplayedErrorModel(String str, String str2, String str3, String str4) {
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.getAuthRequestContext = str4;
    }

    public /* synthetic */ DisplayedErrorModel(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/model/DisplayedErrorModel$Companion;", "", "", "p0", "", "p1", "Lid/dana/model/DisplayedErrorModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/Throwable;Ljava/lang/String;)Lid/dana/model/DisplayedErrorModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static DisplayedErrorModel BuiltInFictitiousFunctionClassFactory(Throwable p0, String p1) {
            DisplayedErrorModel displayedErrorModel;
            Intrinsics.checkNotNullParameter(p1, "");
            if (p0 instanceof NetworkException) {
                NetworkException networkException = (NetworkException) p0;
                return new DisplayedErrorModel(networkException.getErrorCode(), networkException.getMessage(), p1, networkException.getTraceId());
            }
            if (p0 instanceof RpcException) {
                RpcException rpcException = (RpcException) p0;
                displayedErrorModel = new DisplayedErrorModel(rpcException.code, rpcException.msg, p1, null, 8, null);
            } else {
                String message = p0 != null ? p0.getMessage() : null;
                displayedErrorModel = new DisplayedErrorModel(null, message == null ? "" : message, p1, null, 9, null);
            }
            return displayedErrorModel;
        }
    }
}
