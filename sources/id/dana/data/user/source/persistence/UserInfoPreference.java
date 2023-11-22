package id.dana.data.user.source.persistence;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\u0006*\u00020\u00050\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0083D¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/data/user/source/persistence/UserInfoPreference;", "", "", "clearAll", "()V", "Lid/dana/data/storage/LocalStorageFactory$Builder;", "createBuilder", "()Lid/dana/data/storage/LocalStorageFactory$Builder;", "", "key", "", "getLastFetchUserInfo", "(Ljava/lang/String;)J", "time", "", "setLastFetchUserInfo", "(Ljava/lang/String;J)Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "userInfoPreferences", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserInfoPreference {
    private final Context context;
    private PreferenceFacade preferenceFacade;
    private final Serializer serializer;
    private final String userInfoPreferences;

    @Inject
    public UserInfoPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
        this.userInfoPreferences = "UserInfoPreference production";
        PreferenceFacade createData2 = new LocalStorageFactory(createBuilder()).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = createData2;
    }

    private final LocalStorageFactory.Builder createBuilder() {
        return new LocalStorageFactory.Builder(this.context).setPreferenceGroup(this.userInfoPreferences).setSerializerFacade(this.serializer);
    }

    public final boolean setLastFetchUserInfo(String key, long time) {
        Intrinsics.checkNotNullParameter(key, "");
        this.preferenceFacade.saveData(key, Long.valueOf(time));
        return true;
    }

    public final long getLastFetchUserInfo(String key) {
        Intrinsics.checkNotNullParameter(key, "");
        Long l = this.preferenceFacade.getLong(key);
        Intrinsics.checkNotNullExpressionValue(l, "");
        return l.longValue();
    }

    public final void clearAll() {
        this.preferenceFacade.clearAllData();
    }
}
