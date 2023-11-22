package id.dana.data.announcement.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.gson.reflect.TypeToken;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.utils.extension.JSONExtKt;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/data/announcement/repository/source/local/AnnouncementPreference;", "", "", "", "getAnnouncementGnIds", "()Ljava/util/List;", "getTrackedAnnouncementGnIds", "announcementId", "", "saveAnnouncementGnId", "(Ljava/lang/String;)Z", "saveTrackedAnnouncementGnId", "announcementPreference", "Ljava/lang/String;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/data/storage/Serializer;", "serializer", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnouncementPreference {
    private static final String ANNOUNCEMENT_GN_NOTIFICATION = "announcement_gn_notification";
    private static final String TRACKED_ANNOUNCEMENT_GN_NOTIFICATION = "tracked_announcement_gn_notification";
    private final String announcementPreference;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public AnnouncementPreference(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.announcementPreference = "AnnouncementPreferenceproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("AnnouncementPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = createData2;
    }

    public final List<String> getAnnouncementGnIds() {
        ArrayList arrayList = new ArrayList();
        String string = this.preferenceFacade.getString(ANNOUNCEMENT_GN_NOTIFICATION);
        if (string != null) {
            Type type = new TypeToken<List<? extends String>>() { // from class: id.dana.data.announcement.repository.source.local.AnnouncementPreference$getAnnouncementGnIds$listType$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type, "");
            Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(string, type);
            if (fromJson != null) {
                return (List) fromJson;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        }
        return arrayList;
    }

    public final boolean saveAnnouncementGnId(String announcementId) {
        Intrinsics.checkNotNullParameter(announcementId, "");
        List mutableList = CollectionsKt.toMutableList((Collection) getAnnouncementGnIds());
        mutableList.add(announcementId);
        this.preferenceFacade.saveData(ANNOUNCEMENT_GN_NOTIFICATION, JSONExtKt.PlaceComponentResult().toJson(CollectionsKt.toList(mutableList)));
        return true;
    }

    public final List<String> getTrackedAnnouncementGnIds() {
        ArrayList arrayList = new ArrayList();
        String string = this.preferenceFacade.getString(TRACKED_ANNOUNCEMENT_GN_NOTIFICATION);
        if (string != null) {
            Type type = new TypeToken<List<? extends String>>() { // from class: id.dana.data.announcement.repository.source.local.AnnouncementPreference$getTrackedAnnouncementGnIds$listType$1
            }.getType();
            Intrinsics.checkNotNullExpressionValue(type, "");
            Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(string, type);
            if (fromJson != null) {
                return (List) fromJson;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        }
        return arrayList;
    }

    public final boolean saveTrackedAnnouncementGnId(String announcementId) {
        Intrinsics.checkNotNullParameter(announcementId, "");
        List mutableList = CollectionsKt.toMutableList((Collection) getAnnouncementGnIds());
        mutableList.add(announcementId);
        this.preferenceFacade.saveData(TRACKED_ANNOUNCEMENT_GN_NOTIFICATION, JSONExtKt.PlaceComponentResult().toJson(CollectionsKt.toList(mutableList)));
        return true;
    }
}
