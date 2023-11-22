package id.dana.data.qriscrossborder;

import id.dana.data.qriscrossborder.source.QrisCrossBorderEntityDataFactory;
import id.dana.domain.qriscrossborder.QrisCrossBorderRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/qriscrossborder/QrisCrossBorderEntityRepository;", "Lid/dana/domain/qriscrossborder/QrisCrossBorderRepository;", "Lio/reactivex/Observable;", "", "getCurrentCountry", "()Lio/reactivex/Observable;", "getOriginCountry", "p0", "", "saveCurrentCountry", "(Ljava/lang/String;)Lio/reactivex/Observable;", "saveOriginCountry", "Lid/dana/data/qriscrossborder/source/QrisCrossBorderEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/qriscrossborder/source/QrisCrossBorderEntityDataFactory;", "getAuthRequestContext", "<init>", "(Lid/dana/data/qriscrossborder/source/QrisCrossBorderEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QrisCrossBorderEntityRepository implements QrisCrossBorderRepository {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final QrisCrossBorderEntityDataFactory getAuthRequestContext;

    @Inject
    public QrisCrossBorderEntityRepository(QrisCrossBorderEntityDataFactory qrisCrossBorderEntityDataFactory) {
        Intrinsics.checkNotNullParameter(qrisCrossBorderEntityDataFactory, "");
        this.getAuthRequestContext = qrisCrossBorderEntityDataFactory;
    }

    @Override // id.dana.domain.qriscrossborder.QrisCrossBorderRepository
    public final Observable<String> getCurrentCountry() {
        QrisCrossBorderEntityDataFactory qrisCrossBorderEntityDataFactory = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter("local", "");
        return qrisCrossBorderEntityDataFactory.getAuthRequestContext.getAuthRequestContext();
    }

    @Override // id.dana.domain.qriscrossborder.QrisCrossBorderRepository
    public final Observable<String> getOriginCountry() {
        QrisCrossBorderEntityDataFactory qrisCrossBorderEntityDataFactory = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter("local", "");
        return qrisCrossBorderEntityDataFactory.getAuthRequestContext.MyBillsEntityDataFactory();
    }

    @Override // id.dana.domain.qriscrossborder.QrisCrossBorderRepository
    public final Observable<Boolean> saveCurrentCountry(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        QrisCrossBorderEntityDataFactory qrisCrossBorderEntityDataFactory = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter("local", "");
        return qrisCrossBorderEntityDataFactory.getAuthRequestContext.getAuthRequestContext(p0);
    }

    @Override // id.dana.domain.qriscrossborder.QrisCrossBorderRepository
    public final Observable<Boolean> saveOriginCountry(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        QrisCrossBorderEntityDataFactory qrisCrossBorderEntityDataFactory = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter("local", "");
        return qrisCrossBorderEntityDataFactory.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }
}
