package id.dana.data.announcement.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.announcement.AnnouncementEntityData;
import id.dana.data.announcement.repository.source.network.result.AnnouncementResult;
import id.dana.data.storage.Serializer;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\"\u0010#J1\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n0\n0\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u0006H\u0016¢\u0006\u0004\b\r\u0010\fJ!\u0010\u0010\u001a\f\u0012\b\u0012\u0006*\u00020\u000f0\u000f0\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00138\u0007¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u00188\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u00020\u001d8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!"}, d2 = {"Lid/dana/data/announcement/repository/source/local/LocalAnnouncementEntityData;", "Lid/dana/data/announcement/AnnouncementEntityData;", "", "type", "", "extendInfo", "Lio/reactivex/Observable;", "Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;", "getAnnouncements", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "", "getAnnouncementsIdGNSubscription", "()Lio/reactivex/Observable;", "getTrackedAnnouncementsIdGNSubscription", "id", "", "setAnnouncementIdGNSubscription", "(Ljava/lang/String;)Lio/reactivex/Observable;", "setTrackedAnnouncementIdGNSubscription", "Lid/dana/data/announcement/repository/source/local/AnnouncementPreference;", "announcementPreference", "Lid/dana/data/announcement/repository/source/local/AnnouncementPreference;", "getAnnouncementPreference", "()Lid/dana/data/announcement/repository/source/local/AnnouncementPreference;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "getSerializer", "()Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;Lid/dana/data/announcement/repository/source/local/AnnouncementPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalAnnouncementEntityData implements AnnouncementEntityData {
    private final AnnouncementPreference announcementPreference;
    private final Context context;
    private final Serializer serializer;

    @Inject
    public LocalAnnouncementEntityData(Context context, Serializer serializer, AnnouncementPreference announcementPreference) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(announcementPreference, "");
        this.context = context;
        this.serializer = serializer;
        this.announcementPreference = announcementPreference;
    }

    @JvmName(name = "getContext")
    public final Context getContext() {
        return this.context;
    }

    @JvmName(name = "getSerializer")
    public final Serializer getSerializer() {
        return this.serializer;
    }

    @JvmName(name = "getAnnouncementPreference")
    public final AnnouncementPreference getAnnouncementPreference() {
        return this.announcementPreference;
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<AnnouncementResult> getAnnouncements(String type, Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<List<String>> getAnnouncementsIdGNSubscription() {
        Observable<List<String>> just = Observable.just(this.announcementPreference.getAnnouncementGnIds());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<Boolean> setAnnouncementIdGNSubscription(String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.announcementPreference.saveAnnouncementGnId(id2)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<List<String>> getTrackedAnnouncementsIdGNSubscription() {
        Observable<List<String>> just = Observable.just(this.announcementPreference.getTrackedAnnouncementGnIds());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.announcement.AnnouncementEntityData
    public final Observable<Boolean> setTrackedAnnouncementIdGNSubscription(String id2) {
        Intrinsics.checkNotNullParameter(id2, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.announcementPreference.saveTrackedAnnouncementGnId(id2)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
