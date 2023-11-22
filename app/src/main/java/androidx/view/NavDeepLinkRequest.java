package androidx.view;

import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0013B'\b\u0016\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0011¢\u0006\u0004\b\u000f\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0017¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0017¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\nX\u0017¢\u0006\u0006\n\u0004\b\t\u0010\u000b"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest;", "", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "Landroid/net/Uri;", "Landroid/net/Uri;", "p0", "p1", "p2", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class NavDeepLinkRequest {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final Uri PlaceComponentResult;

    private NavDeepLinkRequest(Uri uri, String str, String str2) {
        this.PlaceComponentResult = uri;
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = str2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDeepLinkRequest(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
        Intrinsics.checkNotNullParameter(intent, "");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (this.PlaceComponentResult != null) {
            sb.append(" uri=");
            sb.append(String.valueOf(this.PlaceComponentResult));
        }
        if (this.MyBillsEntityDataFactory != null) {
            sb.append(" action=");
            sb.append(this.MyBillsEntityDataFactory);
        }
        if (this.getAuthRequestContext != null) {
            sb.append(" mimetype=");
            sb.append(this.getAuthRequestContext);
        }
        sb.append(" }");
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/navigation/NavDeepLinkRequest$Builder;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Builder {
        private Builder() {
        }
    }
}
