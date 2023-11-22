package id.dana.data.csatsurvey.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.csatsurvey.repository.source.local.CsatSurveyCreatedDatePreference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/csatsurvey/repository/source/CsatSurveyCreatedDateDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/csatsurvey/repository/source/CsatSurveyCreatedDateEntityData;", "Lid/dana/data/csatsurvey/repository/source/local/CsatSurveyCreatedDatePreference;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/csatsurvey/repository/source/local/CsatSurveyCreatedDatePreference;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/data/csatsurvey/repository/source/local/CsatSurveyCreatedDatePreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CsatSurveyCreatedDateDataFactory extends AbstractEntityDataFactory<CsatSurveyCreatedDateEntityData> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final CsatSurveyCreatedDatePreference PlaceComponentResult;

    @Inject
    public CsatSurveyCreatedDateDataFactory(CsatSurveyCreatedDatePreference csatSurveyCreatedDatePreference) {
        Intrinsics.checkNotNullParameter(csatSurveyCreatedDatePreference, "");
        this.PlaceComponentResult = csatSurveyCreatedDatePreference;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    public final /* bridge */ /* synthetic */ CsatSurveyCreatedDateEntityData createData(String str) {
        return this.PlaceComponentResult;
    }
}
