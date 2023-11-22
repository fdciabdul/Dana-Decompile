package id.dana.data.announcement.repository.source.mock;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.R;
import id.dana.data.announcement.AnnouncementEntityData;
import id.dana.data.announcement.repository.source.network.result.AnnouncementResult;
import id.dana.data.storage.Serializer;
import id.dana.data.util.RawUtils;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010\b\u001a\f\u0012\b\u0012\u0006*\u00020\u00070\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u0006H\u0016¢\u0006\u0004\b\r\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00138\u0007¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/data/announcement/repository/source/mock/MockAnnouncementEntityData;", "Lid/dana/data/announcement/AnnouncementEntityData;", "", "type", "", "extendInfo", "Lio/reactivex/Observable;", "Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;", "getAnnouncements", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "", "getAnnouncementsIdGNSubscription", "()Lio/reactivex/Observable;", "getTrackedAnnouncementsIdGNSubscription", "id", "", "setAnnouncementIdGNSubscription", "(Ljava/lang/String;)Lio/reactivex/Observable;", "setTrackedAnnouncementIdGNSubscription", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MockAnnouncementEntityData implements AnnouncementEntityData {
    private final Context context;
    private final Serializer serializer;

    @Inject
    public MockAnnouncementEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.context = context;
        this.serializer = serializer;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @JvmName(name = "getSerializer")
    public final Serializer getSerializer() {
        return this.serializer;
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<AnnouncementResult> getAnnouncements(String type, Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        Observable<AnnouncementResult> just = Observable.just(this.serializer.deserialize(RawUtils.jsonRawToString(this.context, R.raw.MyBillsEntityDataFactory_res_0x7f12001b), AnnouncementResult.class));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<List<String>> getAnnouncementsIdGNSubscription() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<Boolean> setAnnouncementIdGNSubscription(String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<List<String>> getTrackedAnnouncementsIdGNSubscription() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<Boolean> setTrackedAnnouncementIdGNSubscription(String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        throw new UnsupportedOperationException();
    }
}
