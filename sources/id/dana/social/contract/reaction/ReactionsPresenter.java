package id.dana.social.contract.reaction;

import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.feeds.domain.reactions.interactor.AddReactions;
import id.dana.feeds.domain.reactions.interactor.DeleteReaction;
import id.dana.feeds.domain.reactions.interactor.GetReactions;
import id.dana.feeds.domain.reactions.model.DeleteReactionResult;
import id.dana.feeds.domain.reactions.model.Reaction;
import id.dana.feeds.domain.reactions.model.ReactionResult;
import id.dana.feeds.ui.reaction.model.ReactionModel;
import id.dana.social.contract.reaction.ReactionsContract;
import id.dana.social.model.ReactionModificationRequest;
import id.dana.social.model.ReactionResultModel;
import id.dana.social.model.mapper.ReactionModelMapperKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\b\u0010\fR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0011R\u0014\u0010\b\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/social/contract/reaction/ReactionsPresenter;", "Lid/dana/social/contract/reaction/ReactionsContract$Presenter;", "", "p0", "p1", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "()V", "Lid/dana/social/model/ReactionModificationRequest;", "(Lid/dana/social/model/ReactionModificationRequest;)V", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/subjects/PublishSubject;", "PlaceComponentResult", "Lid/dana/feeds/domain/reactions/interactor/AddReactions;", "Lid/dana/feeds/domain/reactions/interactor/AddReactions;", "Lid/dana/feeds/domain/reactions/interactor/DeleteReaction;", "Lid/dana/feeds/domain/reactions/interactor/DeleteReaction;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/reactions/interactor/GetReactions;", "Lid/dana/feeds/domain/reactions/interactor/GetReactions;", "Lid/dana/social/contract/reaction/ReactionsContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/social/contract/reaction/ReactionsContract$View;", "getErrorConfigVersion", "p2", "p3", "<init>", "(Lid/dana/social/contract/reaction/ReactionsContract$View;Lid/dana/feeds/domain/reactions/interactor/GetReactions;Lid/dana/feeds/domain/reactions/interactor/AddReactions;Lid/dana/feeds/domain/reactions/interactor/DeleteReaction;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReactionsPresenter implements ReactionsContract.Presenter {
    private final DeleteReaction BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private PublishSubject<ReactionModificationRequest> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private PublishSubject<ReactionModificationRequest> PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final ReactionsContract.View getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetReactions KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AddReactions MyBillsEntityDataFactory;

    @Inject
    public ReactionsPresenter(ReactionsContract.View view, GetReactions getReactions, AddReactions addReactions, DeleteReaction deleteReaction) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getReactions, "");
        Intrinsics.checkNotNullParameter(addReactions, "");
        Intrinsics.checkNotNullParameter(deleteReaction, "");
        this.getErrorConfigVersion = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getReactions;
        this.MyBillsEntityDataFactory = addReactions;
        this.BuiltInFictitiousFunctionClassFactory = deleteReaction;
        PublishSubject<ReactionModificationRequest> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.PlaceComponentResult = PlaceComponentResult;
        Observable<ReactionModificationRequest> observeOn = PlaceComponentResult.debounce(800L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult());
        final Function1<ReactionModificationRequest, Unit> function1 = new Function1<ReactionModificationRequest, Unit>() { // from class: id.dana.social.contract.reaction.ReactionsPresenter$observeAddReaction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ReactionModificationRequest reactionModificationRequest) {
                invoke2(reactionModificationRequest);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ReactionModificationRequest reactionModificationRequest) {
                Intrinsics.checkNotNullParameter(reactionModificationRequest, "");
                r0.MyBillsEntityDataFactory.executeJava1(new AddReactions.Params(null, reactionModificationRequest.getAuthRequestContext, reactionModificationRequest.MyBillsEntityDataFactory, 1, null), new Function1<ReactionResult, Unit>() { // from class: id.dana.social.contract.reaction.ReactionsPresenter$proceedAddReaction$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(ReactionResult reactionResult) {
                        invoke2(reactionResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(ReactionResult reactionResult) {
                        ReactionsContract.View view2;
                        Intrinsics.checkNotNullParameter(reactionResult, "");
                        view2 = ReactionsPresenter.this.getErrorConfigVersion;
                        view2.getAuthRequestContext(new ReactionResultModel(reactionResult.getActivityId(), reactionResult.getKind()));
                    }
                }, new Function1<Throwable, String>() { // from class: id.dana.social.contract.reaction.ReactionsPresenter$proceedAddReaction$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Throwable th) {
                        ReactionsContract.View view2;
                        ReactionsContract.View view3;
                        Intrinsics.checkNotNullParameter(th, "");
                        view2 = ReactionsPresenter.this.getErrorConfigVersion;
                        view2.PlaceComponentResult();
                        StringBuilder sb = new StringBuilder();
                        sb.append("onError: ");
                        sb.append(th.getMessage());
                        DanaLog.BuiltInFictitiousFunctionClassFactory("ReactionsPresenter", sb.toString(), th);
                        view3 = ReactionsPresenter.this.getErrorConfigVersion;
                        return view3.getShownErrorMessage();
                    }
                }, ReactionsPresenter.this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory());
            }
        };
        observeOn.subscribe(new DefaultObserver<ReactionModificationRequest>() { // from class: id.dana.social.contract.reaction.ReactionsPresenter$createSubscriber$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ReactionModificationRequest reactionModificationRequest = (ReactionModificationRequest) obj;
                Intrinsics.checkNotNullParameter(reactionModificationRequest, "");
                function1.invoke(reactionModificationRequest);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(p0.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory("ReactionsPresenter", sb.toString(), p0);
            }
        });
        PublishSubject<ReactionModificationRequest> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.getAuthRequestContext = PlaceComponentResult2;
        Observable<ReactionModificationRequest> observeOn2 = PlaceComponentResult2.debounce(800L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult());
        final Function1<ReactionModificationRequest, Unit> function12 = new Function1<ReactionModificationRequest, Unit>() { // from class: id.dana.social.contract.reaction.ReactionsPresenter$observeDeleteReaction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ReactionModificationRequest reactionModificationRequest) {
                invoke2(reactionModificationRequest);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ReactionModificationRequest reactionModificationRequest) {
                Intrinsics.checkNotNullParameter(reactionModificationRequest, "");
                ReactionsPresenter.this.BuiltInFictitiousFunctionClassFactory(reactionModificationRequest);
            }
        };
        observeOn2.subscribe(new DefaultObserver<ReactionModificationRequest>() { // from class: id.dana.social.contract.reaction.ReactionsPresenter$createSubscriber$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                ReactionModificationRequest reactionModificationRequest = (ReactionModificationRequest) obj;
                Intrinsics.checkNotNullParameter(reactionModificationRequest, "");
                function12.invoke(reactionModificationRequest);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                StringBuilder sb = new StringBuilder();
                sb.append("onError: ");
                sb.append(p0.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory("ReactionsPresenter", sb.toString(), p0);
            }
        });
    }

    @Override // id.dana.social.contract.reaction.ReactionsContract.Presenter
    public final void getAuthRequestContext() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1<List<? extends Reaction>, Unit>() { // from class: id.dana.social.contract.reaction.ReactionsPresenter$getReactions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends Reaction> list) {
                invoke2((List<Reaction>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<Reaction> list) {
                ReactionsContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                view = ReactionsPresenter.this.getErrorConfigVersion;
                List<Reaction> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (Reaction reaction : list2) {
                    arrayList.add(new ReactionModel(reaction.getKind(), reaction.getName()));
                }
                view.BuiltInFictitiousFunctionClassFactory(arrayList);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.contract.reaction.ReactionsPresenter$getReactions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ReactionsContract.View view;
                GetReactions getReactions;
                Intrinsics.checkNotNullParameter(th, "");
                view = ReactionsPresenter.this.getErrorConfigVersion;
                getReactions = ReactionsPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                view.PlaceComponentResult(ReactionModelMapperKt.PlaceComponentResult(getReactions.getAuthRequestContext.getAuthRequestContext()));
            }
        });
    }

    @Override // id.dana.social.contract.reaction.ReactionsContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0.length() == 0) {
            return;
        }
        if (p1.length() == 0) {
            return;
        }
        PublishSubject<ReactionModificationRequest> publishSubject = this.PlaceComponentResult;
        if (publishSubject == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            publishSubject = null;
        }
        publishSubject.onNext(new ReactionModificationRequest(false, p0, null, p1, 5, null));
    }

    @Override // id.dana.social.contract.reaction.ReactionsContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p1.length() == 0) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory(new ReactionModificationRequest(false, p1, p0, null, 9, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(ReactionModificationRequest p0) {
        StringBuilder sb = new StringBuilder();
        sb.append("modifRequest: ");
        sb.append(p0);
        System.out.println((Object) sb.toString());
        DeleteReaction deleteReaction = this.BuiltInFictitiousFunctionClassFactory;
        String str = p0.BuiltInFictitiousFunctionClassFactory;
        if (str == null) {
            str = "";
        }
        deleteReaction.executeJava1(new DeleteReaction.Params(str, p0.getAuthRequestContext), new Function1<DeleteReactionResult, Unit>() { // from class: id.dana.social.contract.reaction.ReactionsPresenter$proceedDeleteReaction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DeleteReactionResult deleteReactionResult) {
                invoke2(deleteReactionResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DeleteReactionResult deleteReactionResult) {
                ReactionsContract.View view;
                Intrinsics.checkNotNullParameter(deleteReactionResult, "");
                view = ReactionsPresenter.this.getErrorConfigVersion;
                view.BuiltInFictitiousFunctionClassFactory(deleteReactionResult);
            }
        }, new Function1<Throwable, String>() { // from class: id.dana.social.contract.reaction.ReactionsPresenter$proceedDeleteReaction$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Throwable th) {
                ReactionsContract.View view;
                ReactionsContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = ReactionsPresenter.this.getErrorConfigVersion;
                view.MyBillsEntityDataFactory();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onError: ");
                sb2.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory("ReactionsPresenter", sb2.toString(), th);
                view2 = ReactionsPresenter.this.getErrorConfigVersion;
                return view2.getShownErrorMessage();
            }
        }, this.getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory());
    }
}
