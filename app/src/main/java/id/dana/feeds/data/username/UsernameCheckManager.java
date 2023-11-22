package id.dana.feeds.data.username;

import android.content.Context;
import id.dana.data.R;
import id.dana.feeds.data.username.model.UsernameCheck;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\rX\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u000e"}, d2 = {"Lid/dana/feeds/data/username/UsernameCheckManager;", "", "Lid/dana/feeds/data/username/model/UsernameCheck;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/feeds/data/username/model/UsernameCheck;)Z", "MyBillsEntityDataFactory", "getAuthRequestContext", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "getErrorConfigVersion", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UsernameCheckManager {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Context MyBillsEntityDataFactory;

    @Inject
    public UsernameCheckManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(UsernameCheck p0) {
        return getErrorConfigVersion(p0) || PlaceComponentResult(p0) || BuiltInFictitiousFunctionClassFactory(p0) || moveToNextValue(p0) || getAuthRequestContext(p0) || MyBillsEntityDataFactory(p0);
    }

    private final boolean getAuthRequestContext(UsernameCheck p0) {
        if (new Regex("^[a-zA-Z0-9.]*$").matches(p0.PlaceComponentResult)) {
            return false;
        }
        String string = this.MyBillsEntityDataFactory.getString(R.string.error_username_space_unique_char);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullParameter(string, "");
        p0.MyBillsEntityDataFactory = string;
        return true;
    }

    private final boolean MyBillsEntityDataFactory(UsernameCheck p0) {
        if (new Regex("^.*\\.\\..*$").containsMatchIn(p0.PlaceComponentResult)) {
            String string = this.MyBillsEntityDataFactory.getString(R.string.error_username_consecutive_period);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            p0.MyBillsEntityDataFactory = string;
            return true;
        }
        return false;
    }

    private final boolean PlaceComponentResult(UsernameCheck p0) {
        if (StringsKt.endsWith$default(p0.PlaceComponentResult, ".", false, 2, (Object) null)) {
            String string = this.MyBillsEntityDataFactory.getString(R.string.error_username_start_end_period);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            p0.MyBillsEntityDataFactory = string;
            return true;
        }
        return false;
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(UsernameCheck p0) {
        int length = p0.PlaceComponentResult.length();
        if (3 <= length && length < 21) {
            return false;
        }
        String string = this.MyBillsEntityDataFactory.getString(R.string.res_0x7f130739_kclassimpl_data_declarednonstaticmembers_2);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullParameter(string, "");
        p0.MyBillsEntityDataFactory = string;
        return true;
    }

    private final boolean moveToNextValue(UsernameCheck p0) {
        try {
            Integer.parseInt(p0.PlaceComponentResult);
            String string = this.MyBillsEntityDataFactory.getString(R.string.error_username_numbers_only);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            p0.MyBillsEntityDataFactory = string;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private final boolean getErrorConfigVersion(UsernameCheck p0) {
        if (StringsKt.startsWith$default(p0.PlaceComponentResult, ".", false, 2, (Object) null)) {
            String string = this.MyBillsEntityDataFactory.getString(R.string.error_username_start_end_period);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            p0.MyBillsEntityDataFactory = string;
            return true;
        }
        return false;
    }
}
