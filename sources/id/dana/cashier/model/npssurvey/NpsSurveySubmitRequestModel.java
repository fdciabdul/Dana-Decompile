package id.dana.cashier.model.npssurvey;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0087\u0002¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\t\u001a\u0004\u0018\u00010\u000bX\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/model/npssurvey/NpsSurveySubmitRequestModel;", "", "", "getAuthRequestContext", "Z", "PlaceComponentResult", "()Z", "", "Lid/dana/cashier/model/npssurvey/NpsSurveySubmitAnswerModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "Lid/dana/cashier/model/npssurvey/NpsSurveySubmitIdentifierModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/model/npssurvey/NpsSurveySubmitIdentifierModel;", "p0", "p1", "p2", "<init>", "(Ljava/util/List;Lid/dana/cashier/model/npssurvey/NpsSurveySubmitIdentifierModel;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NpsSurveySubmitRequestModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public NpsSurveySubmitIdentifierModel MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<NpsSurveySubmitAnswerModel> PlaceComponentResult;
    public boolean getAuthRequestContext;

    public NpsSurveySubmitRequestModel() {
        this(null, null, false, 7, null);
    }

    private NpsSurveySubmitRequestModel(List<NpsSurveySubmitAnswerModel> list, NpsSurveySubmitIdentifierModel npsSurveySubmitIdentifierModel, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = list;
        this.MyBillsEntityDataFactory = npsSurveySubmitIdentifierModel;
        this.getAuthRequestContext = z;
    }

    public /* synthetic */ NpsSurveySubmitRequestModel(List list, NpsSurveySubmitIdentifierModel npsSurveySubmitIdentifierModel, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? null : npsSurveySubmitIdentifierModel, (i & 4) != 0 ? false : z);
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }
}
