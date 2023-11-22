package id.dana.tncsummary.model;

import id.dana.domain.useragreement.model.AgreementInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/tncsummary/model/TncSummaryEvent;", "", "", "Lid/dana/domain/useragreement/model/AgreementInfo;", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "PlaceComponentResult", "p0", "<init>", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TncSummaryEvent {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final List<AgreementInfo> PlaceComponentResult;

    public TncSummaryEvent(List<AgreementInfo> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.PlaceComponentResult = list;
    }
}
