package id.dana.data.csatsurvey.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.csatsurvey.repository.source.network.NetworkDismissCsatSurveyEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/csatsurvey/repository/source/DismissCsatSurveyDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/csatsurvey/repository/source/DismissCsatSurveyEntityData;", "Lid/dana/data/csatsurvey/repository/source/network/NetworkDismissCsatSurveyEntityData;", "getAuthRequestContext", "Lid/dana/data/csatsurvey/repository/source/network/NetworkDismissCsatSurveyEntityData;", "p0", "<init>", "(Lid/dana/data/csatsurvey/repository/source/network/NetworkDismissCsatSurveyEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DismissCsatSurveyDataFactory extends AbstractEntityDataFactory<DismissCsatSurveyEntityData> {
    public final NetworkDismissCsatSurveyEntityData getAuthRequestContext;

    @Inject
    public DismissCsatSurveyDataFactory(NetworkDismissCsatSurveyEntityData networkDismissCsatSurveyEntityData) {
        Intrinsics.checkNotNullParameter(networkDismissCsatSurveyEntityData, "");
        this.getAuthRequestContext = networkDismissCsatSurveyEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* bridge */ /* synthetic */ DismissCsatSurveyEntityData createData2(String str) {
        return this.getAuthRequestContext;
    }
}
