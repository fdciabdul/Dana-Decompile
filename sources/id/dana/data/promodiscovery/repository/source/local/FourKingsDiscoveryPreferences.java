package id.dana.data.promodiscovery.repository.source.local;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.promodiscovery.model.FourKingsPromoModel;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/promodiscovery/repository/source/local/FourKingsDiscoveryPreferences;", "", "", "userId", "", "Lid/dana/domain/promodiscovery/model/FourKingsPromoModel;", "getDefaultFourKingsDiscovery", "(Ljava/lang/String;)Ljava/util/List;", "Lio/reactivex/Observable;", "getFourKingsDiscoveryData", "(Ljava/lang/String;)Lio/reactivex/Observable;", "fourKingsPromo", "", "setFourKingsDiscoveryData", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/data/storage/PreferenceFacade;", "preferencesFacade", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FourKingsDiscoveryPreferences {
    private static final String FOUR_KINGS_DISCOVERY = "_fourKingsDiscovery";
    private static final String FOUR_KINGS_DISCOVERY_PREFERENCES_GROUP = "Four Kings Discovery Preferences production";
    private PreferenceFacade preferencesFacade;

    @Inject
    public FourKingsDiscoveryPreferences(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(FOUR_KINGS_DISCOVERY_PREFERENCES_GROUP).setUseDrutherPreference(true).setSerializerFacade(null)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferencesFacade = createData2;
    }

    public final Observable<Unit> setFourKingsDiscoveryData(String userId, List<FourKingsPromoModel> fourKingsPromo) {
        Intrinsics.checkNotNullParameter(userId, "");
        Intrinsics.checkNotNullParameter(fourKingsPromo, "");
        PreferenceFacade preferenceFacade = this.preferencesFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append(FOUR_KINGS_DISCOVERY);
        preferenceFacade.saveData(sb.toString(), (String) fourKingsPromo);
        Observable<Unit> just = Observable.just(Unit.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    public final Observable<List<FourKingsPromoModel>> getFourKingsDiscoveryData(String userId) {
        Intrinsics.checkNotNullParameter(userId, "");
        PreferenceFacade preferenceFacade = this.preferencesFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(userId);
        sb.append(FOUR_KINGS_DISCOVERY);
        List list = (List) preferenceFacade.getObject(sb.toString(), List.class);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            arrayList.addAll(getDefaultFourKingsDiscovery(userId));
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object parseObject = JSONObject.parseObject(((JSONObject) it.next()).toJSONString(), FourKingsPromoModel.class);
                Intrinsics.checkNotNullExpressionValue(parseObject, "");
                arrayList.add(parseObject);
            }
        }
        Observable<List<FourKingsPromoModel>> just = Observable.just(arrayList);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private final List<FourKingsPromoModel> getDefaultFourKingsDiscovery(String userId) {
        List<FourKingsPromoModel> listOf = CollectionsKt.listOf((Object[]) new FourKingsPromoModel[]{new FourKingsPromoModel("POINT", 0, false), new FourKingsPromoModel("VOUCHER", 0, false), new FourKingsPromoModel("LOYALTY", 0, false), new FourKingsPromoModel("QUEST", 0, false)});
        setFourKingsDiscoveryData(userId, listOf);
        return listOf;
    }
}
