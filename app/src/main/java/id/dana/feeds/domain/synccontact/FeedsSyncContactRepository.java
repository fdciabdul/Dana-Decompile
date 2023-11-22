package id.dana.feeds.domain.synccontact;

import id.dana.feeds.domain.synccontact.model.FeedsContact;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\t\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\fJ\u0013\u0010\u000e\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\fJ\u0013\u0010\u000f\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\fJ1\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u000bH&¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0005\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\fJ\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\fJ\u001b\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0013J#\u0010\t\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u001cJ\u001b\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u001dJ!\u0010\t\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/domain/synccontact/FeedsSyncContactRepository;", "", "", "Lid/dana/feeds/domain/synccontact/model/FeedsContact;", "p0", "MyBillsEntityDataFactory", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(II)Ljava/lang/Object;", "", "()Ljava/lang/Object;", "", "moveToNextValue", "getErrorConfigVersion", "p2", "getAuthRequestContext", "(IILjava/lang/String;)Ljava/lang/Object;", "(Ljava/lang/String;)Ljava/lang/Object;", "lookAheadTest", "scheduleImpl", "()Z", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILjava/lang/String;)Ljava/lang/Object;", "(I)Ljava/lang/Object;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FeedsSyncContactRepository {
    Object BuiltInFictitiousFunctionClassFactory();

    Object BuiltInFictitiousFunctionClassFactory(int p0, int p1);

    Object BuiltInFictitiousFunctionClassFactory(int p0, String p1);

    Object BuiltInFictitiousFunctionClassFactory(List<FeedsContact> list, Continuation<? super Integer> continuation);

    Object KClassImpl$Data$declaredNonStaticMembers$2(String p0);

    Object MyBillsEntityDataFactory(String p0);

    Object MyBillsEntityDataFactory(List<FeedsContact> list, Continuation<? super List<FeedsContact>> continuation);

    Object MyBillsEntityDataFactory(Continuation<? super Boolean> continuation);

    Object NetworkUserEntityData$$ExternalSyntheticLambda1();

    Object NetworkUserEntityData$$ExternalSyntheticLambda2();

    Object getAuthRequestContext(int p0);

    Object getAuthRequestContext(int p0, int p1, String p2);

    Object getErrorConfigVersion();

    Object lookAheadTest();

    Object moveToNextValue();

    boolean scheduleImpl();
}
