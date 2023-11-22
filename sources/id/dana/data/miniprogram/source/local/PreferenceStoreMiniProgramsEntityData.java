package id.dana.data.miniprogram.source.local;

import id.dana.data.miniprogram.source.StoreMiniProgramData;
import id.dana.utils.exception.CallableReturnNullError;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/miniprogram/source/local/PreferenceStoreMiniProgramsEntityData;", "Lid/dana/data/miniprogram/source/StoreMiniProgramData;", "Lid/dana/data/miniprogram/source/local/StoreMiniProgramPreference;", "getAuthRequestContext", "Lid/dana/data/miniprogram/source/local/StoreMiniProgramPreference;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/data/miniprogram/source/local/StoreMiniProgramPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferenceStoreMiniProgramsEntityData implements StoreMiniProgramData {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final StoreMiniProgramPreference PlaceComponentResult;

    @Inject
    public PreferenceStoreMiniProgramsEntityData(StoreMiniProgramPreference storeMiniProgramPreference) {
        Intrinsics.checkNotNullParameter(storeMiniProgramPreference, "");
        this.PlaceComponentResult = storeMiniProgramPreference;
    }

    public static /* synthetic */ HashMap MyBillsEntityDataFactory(PreferenceStoreMiniProgramsEntityData preferenceStoreMiniProgramsEntityData) {
        Intrinsics.checkNotNullParameter(preferenceStoreMiniProgramsEntityData, "");
        HashMap hashMap = (HashMap) preferenceStoreMiniProgramsEntityData.PlaceComponentResult.PlaceComponentResult.getObject("RecentMiniProgram", HashMap.class);
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        if (hashMap != null) {
            return hashMap;
        }
        throw new CallableReturnNullError("PreferenceStoreMiniProgramsEntityData#getRecentMiniPrograms");
    }

    public static /* synthetic */ Unit PlaceComponentResult(PreferenceStoreMiniProgramsEntityData preferenceStoreMiniProgramsEntityData, List list) {
        Intrinsics.checkNotNullParameter(preferenceStoreMiniProgramsEntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        StoreMiniProgramPreference storeMiniProgramPreference = preferenceStoreMiniProgramsEntityData.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(list, "");
        storeMiniProgramPreference.PlaceComponentResult.saveData("FavoriteMiniProgram", (String) list);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(PreferenceStoreMiniProgramsEntityData preferenceStoreMiniProgramsEntityData, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(preferenceStoreMiniProgramsEntityData, "");
        Intrinsics.checkNotNullParameter(hashMap, "");
        StoreMiniProgramPreference storeMiniProgramPreference = preferenceStoreMiniProgramsEntityData.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(hashMap, "");
        storeMiniProgramPreference.PlaceComponentResult.saveData("RecentMiniProgram", (String) hashMap);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ List getAuthRequestContext(PreferenceStoreMiniProgramsEntityData preferenceStoreMiniProgramsEntityData) {
        Intrinsics.checkNotNullParameter(preferenceStoreMiniProgramsEntityData, "");
        List list = (List) preferenceStoreMiniProgramsEntityData.PlaceComponentResult.PlaceComponentResult.getObject("FavoriteMiniProgram", List.class);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list != null) {
            return list;
        }
        throw new CallableReturnNullError("PreferenceStoreMiniProgramsEntityData#getFavoriteMiniPrograms");
    }
}
