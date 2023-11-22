package id.dana.feeds.data.synccontact;

import android.content.ContentResolver;
import android.content.Context;
import androidx.core.app.ActivityCompat;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0010\u0012\u0006\u0010\f\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0005\u0010\u000bJ\u001f\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\rR\u0014\u0010\b\u001a\u00020\u000e8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/feeds/data/synccontact/FeedsContactProvider;", "", "", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/lang/String;", "", "PlaceComponentResult", "()Z", "", "(I)Z", "p1", "(ILjava/lang/String;)Z", "Landroid/content/ContentResolver;", "Landroid/content/ContentResolver;", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "MyBillsEntityDataFactory", "<init>", "(Landroid/content/Context;Landroid/content/ContentResolver;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedsContactProvider {
    public final ContentResolver PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        return p0 <= 0;
    }

    @Inject
    public FeedsContactProvider(Context context, ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(contentResolver, "");
        this.MyBillsEntityDataFactory = context;
        this.PlaceComponentResult = contentResolver;
    }

    public final boolean PlaceComponentResult() {
        return ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, "android.permission.READ_CONTACTS") == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(int p0, String p1) {
        if (p0 > 0) {
            return p1.length() == 0;
        }
        return true;
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(List<String> p0) {
        StringBuilder sb = new StringBuilder();
        int size = p0.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append("?");
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}
