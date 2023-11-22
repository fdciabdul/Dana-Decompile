package id.dana.feeds.domain.reactions;

import id.dana.feeds.domain.reactions.model.ActivityReactions;
import id.dana.feeds.domain.reactions.model.DeleteReactionResult;
import id.dana.feeds.domain.reactions.model.Reaction;
import id.dana.feeds.domain.reactions.model.ReactionResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\tJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0006H&¢\u0006\u0004\b\u000b\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/domain/reactions/FeedsReactionRepository;", "", "", "p0", "p1", "p2", "Lio/reactivex/Observable;", "Lid/dana/feeds/domain/reactions/model/ReactionResult;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/feeds/domain/reactions/model/DeleteReactionResult;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/feeds/domain/reactions/model/ActivityReactions;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/feeds/domain/reactions/model/Reaction;", "getAuthRequestContext", "()Ljava/util/List;", "()Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FeedsReactionRepository {
    Observable<ReactionResult> BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2);

    Observable<ActivityReactions> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2);

    Observable<List<Reaction>> MyBillsEntityDataFactory();

    Observable<DeleteReactionResult> MyBillsEntityDataFactory(String p0, String p1);

    List<Reaction> getAuthRequestContext();
}
