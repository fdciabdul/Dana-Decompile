package id.dana.data.webviewinterceptor.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004"}, d2 = {"Lid/dana/data/webviewinterceptor/model/WebviewInterceptorEntity;", "", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WebviewInterceptorEntity {
    @SerializedName("url")

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final String MyBillsEntityDataFactory;
    @SerializedName("key")

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final String PlaceComponentResult;
    @SerializedName("redirectUrlAndroid")

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final String BuiltInFictitiousFunctionClassFactory;

    public WebviewInterceptorEntity() {
        this(null, null, null, 7, null);
    }

    public WebviewInterceptorEntity(String str, String str2, String str3) {
        this.PlaceComponentResult = str;
        this.MyBillsEntityDataFactory = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
    }

    public /* synthetic */ WebviewInterceptorEntity(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
