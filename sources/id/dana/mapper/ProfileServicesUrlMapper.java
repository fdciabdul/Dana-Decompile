package id.dana.mapper;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/mapper/ProfileServicesUrlMapper;", "", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileServicesUrlMapper {
    public static final ProfileServicesUrlMapper INSTANCE = new ProfileServicesUrlMapper();

    private ProfileServicesUrlMapper() {
    }

    @JvmStatic
    public static final String MyBillsEntityDataFactory(String p0) {
        if (p0 == null) {
            return "";
        }
        Uri.Builder buildUpon = Uri.parse(p0).buildUpon();
        if (StringsKt.contains$default((CharSequence) p0, (CharSequence) "lifestyle-subscription-list", false, 2, (Object) null)) {
            String obj = buildUpon.appendQueryParameter("entryPoint", "profilepage").build().toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return obj;
        }
        return p0;
    }
}
