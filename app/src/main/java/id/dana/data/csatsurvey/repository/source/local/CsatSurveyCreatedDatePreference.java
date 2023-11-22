package id.dana.data.csatsurvey.repository.source.local;

import android.content.Context;
import id.dana.data.csatsurvey.repository.source.CsatSurveyCreatedDateEntityData;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000b"}, d2 = {"Lid/dana/data/csatsurvey/repository/source/local/CsatSurveyCreatedDatePreference;", "Lid/dana/data/csatsurvey/repository/source/CsatSurveyCreatedDateEntityData;", "Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CsatSurveyCreatedDatePreference implements CsatSurveyCreatedDateEntityData {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final PreferenceFacade BuiltInFictitiousFunctionClassFactory;

    @Inject
    public CsatSurveyCreatedDatePreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("CsatSurveyPreferenceproduction")).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.BuiltInFictitiousFunctionClassFactory = createData;
    }

    @Override // id.dana.data.csatsurvey.repository.source.CsatSurveyCreatedDateEntityData
    public final Observable<String> KClassImpl$Data$declaredNonStaticMembers$2() {
        String string = this.BuiltInFictitiousFunctionClassFactory.getString("csat_survey_created_date");
        if (string == null) {
            string = "";
        }
        Observable<String> just = Observable.just(string);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.csatsurvey.repository.source.CsatSurveyCreatedDateEntityData
    public final Observable<Boolean> MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.saveData("csat_survey_created_date", p0);
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
