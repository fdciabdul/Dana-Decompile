package id.dana.social.contract.reaction;

import id.dana.feeds.domain.reactions.model.DeleteReactionResult;
import id.dana.feeds.ui.reaction.model.ReactionModel;
import id.dana.social.model.ReactionResultModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/reaction/ReactionsContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ReactionsContract {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/reaction/ReactionsContract$Presenter;", "", "", "p0", "p1", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter {
        void BuiltInFictitiousFunctionClassFactory(String p0, String p1);

        void MyBillsEntityDataFactory(String p0, String p1);

        void getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0016\u0010\u000f\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u0016\u0010\u0013\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/reaction/ReactionsContract$View;", "", "getShownErrorMessage", "", "Lid/dana/utils/DisplayedErrorMessage;", "getSource", "onDeleteReactionFailed", "", "onDeleteReactionSuccess", "deleteReactionResult", "Lid/dana/feeds/domain/reactions/model/DeleteReactionResult;", "onReactionAdded", "reactionResultModel", "Lid/dana/social/model/ReactionResultModel;", "onReactionFailToAdd", "onReactionsLoadError", "localReactions", "", "Lid/dana/feeds/ui/reaction/model/ReactionModel;", "onReactionsLoaded", "reactions", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View {

        /* renamed from: id.dana.social.contract.reaction.ReactionsContract$View$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void getAuthRequestContext() {
            }

            public static void getAuthRequestContext(ReactionResultModel reactionResultModel) {
                Intrinsics.checkNotNullParameter(reactionResultModel, "");
            }
        }

        String BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(DeleteReactionResult deleteReactionResult);

        void BuiltInFictitiousFunctionClassFactory(List<ReactionModel> list);

        void MyBillsEntityDataFactory();

        void PlaceComponentResult();

        void PlaceComponentResult(List<ReactionModel> list);

        void getAuthRequestContext(ReactionResultModel reactionResultModel);

        String getShownErrorMessage();
    }
}
