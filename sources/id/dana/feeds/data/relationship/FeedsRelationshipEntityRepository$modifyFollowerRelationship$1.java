package id.dana.feeds.data.relationship;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class FeedsRelationshipEntityRepository$modifyFollowerRelationship$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FeedsRelationshipEntityRepository$modifyFollowerRelationship$1(Object obj) {
        super(2, obj, FeedsRelationshipEntityRepository.class, "saveFollowerModifiedRelationship", "saveFollowerModifiedRelationship(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
        invoke2(str, str2);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        FeedsRelationshipEntityRepository.PlaceComponentResult((FeedsRelationshipEntityRepository) this.receiver, str, str2);
    }
}
