package id.dana.data.contactinjection;

import android.content.Context;
import id.dana.domain.contactinjection.ContactInjectionRepository;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/contactinjection/ContactInjectionEntityRepository;", "Lid/dana/domain/contactinjection/ContactInjectionRepository;", "", "p0", "", "p1", "Lio/reactivex/Observable;", "", "injectContact", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "PlaceComponentResult", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactInjectionEntityRepository implements ContactInjectionRepository {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    @Inject
    public ContactInjectionEntityRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.domain.contactinjection.ContactInjectionRepository
    public final Observable<Boolean> injectContact(final String p0, final List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<Boolean> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.contactinjection.ContactInjectionEntityRepository$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ContactInjectionEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(ContactInjectionEntityRepository.this, p0, p1);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    public static /* synthetic */ Boolean KClassImpl$Data$declaredNonStaticMembers$2(ContactInjectionEntityRepository contactInjectionEntityRepository, String str, List list) {
        Intrinsics.checkNotNullParameter(contactInjectionEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        AddContact addContact = AddContact.INSTANCE;
        return Boolean.valueOf(AddContact.getAuthRequestContext(contactInjectionEntityRepository.PlaceComponentResult, str, list));
    }
}
