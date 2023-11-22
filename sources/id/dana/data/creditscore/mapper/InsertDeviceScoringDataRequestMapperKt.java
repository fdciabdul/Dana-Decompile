package id.dana.data.creditscore.mapper;

import id.dana.data.creditscore.repository.source.network.request.InsertDeviceScoringDataRequest;
import id.dana.domain.creditscore.model.InsertInstalledAppsScoringData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData;", "Lid/dana/data/creditscore/repository/source/network/request/InsertDeviceScoringDataRequest;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/creditscore/model/InsertInstalledAppsScoringData;)Lid/dana/data/creditscore/repository/source/network/request/InsertDeviceScoringDataRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InsertDeviceScoringDataRequestMapperKt {
    public static final InsertDeviceScoringDataRequest BuiltInFictitiousFunctionClassFactory(InsertInstalledAppsScoringData insertInstalledAppsScoringData) {
        Intrinsics.checkNotNullParameter(insertInstalledAppsScoringData, "");
        String scheme = insertInstalledAppsScoringData.getScheme();
        String type = insertInstalledAppsScoringData.getType();
        List<InsertInstalledAppsScoringData.InstalledAppDataInfo> value = insertInstalledAppsScoringData.getValue();
        Intrinsics.checkNotNullParameter(value, "");
        List<InsertInstalledAppsScoringData.InstalledAppDataInfo> list = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InsertInstalledAppsScoringData.InstalledAppDataInfo installedAppDataInfo : list) {
            arrayList.add(new InsertDeviceScoringDataRequest.ScoringDataInfo(installedAppDataInfo.getTimestamp(), installedAppDataInfo.getData(), installedAppDataInfo.getPhase()));
        }
        return new InsertDeviceScoringDataRequest(scheme, type, arrayList);
    }
}
