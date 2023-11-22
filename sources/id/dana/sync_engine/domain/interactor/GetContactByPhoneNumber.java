package id.dana.sync_engine.domain.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.model.UserContact;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sync_engine/domain/interactor/GetContactByPhoneNumber;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/sync_engine/domain/model/UserContact;", "Lid/dana/sync_engine/domain/interactor/GetContactByPhoneNumber$Params;", "Lid/dana/sync_engine/domain/ContactRepository;", "MyBillsEntityDataFactory", "Lid/dana/sync_engine/domain/ContactRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/sync_engine/domain/ContactRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetContactByPhoneNumber extends BaseUseCase<List<? extends UserContact>, Params> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ContactRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<List<? extends UserContact>> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(params2.PlaceComponentResult, params2.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Inject
    public GetContactByPhoneNumber(ContactRepository contactRepository) {
        Intrinsics.checkNotNullParameter(contactRepository, "");
        this.getAuthRequestContext = contactRepository;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/sync_engine/domain/interactor/GetContactByPhoneNumber$Params;", "", "", "PlaceComponentResult", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "p0", "p1", "<init>", "(Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final int KClassImpl$Data$declaredNonStaticMembers$2;

        public Params(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "");
            this.PlaceComponentResult = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        }
    }
}
