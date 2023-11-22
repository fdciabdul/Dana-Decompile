package id.dana.social.view.activity;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.base.BaseSocialFeedsAdapter;
import id.dana.social.contract.SocialProfileContract;
import id.dana.social.model.FeedViewHolderModel;
import j$.util.Collection;
import j$.util.function.Predicate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", BridgeDSL.INVOKE, "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialProfileActivity$onRefresh$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SocialProfileActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialProfileActivity$onRefresh$1(SocialProfileActivity socialProfileActivity) {
        super(0);
        this.this$0 = socialProfileActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BaseSocialFeedsAdapter baseSocialFeedsAdapter;
        BaseSocialFeedsAdapter baseSocialFeedsAdapter2;
        RelationshipItemModel relationshipItemModel;
        baseSocialFeedsAdapter = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda2;
        RelationshipItemModel relationshipItemModel2 = null;
        if (baseSocialFeedsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter = null;
        }
        List<FeedViewHolderModel> items = baseSocialFeedsAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        Collection.EL.BuiltInFictitiousFunctionClassFactory(CollectionsKt.toMutableList((java.util.Collection) items), new Predicate() { // from class: id.dana.social.view.activity.SocialProfileActivity$onRefresh$1$$ExternalSyntheticLambda0
            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate and(Predicate predicate) {
                return Predicate.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate negate() {
                return Predicate.CC.PlaceComponentResult(this);
            }

            @Override // j$.util.function.Predicate
            public final /* synthetic */ Predicate or(Predicate predicate) {
                return Predicate.CC.BuiltInFictitiousFunctionClassFactory(this, predicate);
            }

            @Override // j$.util.function.Predicate
            public final boolean test(Object obj) {
                boolean m2969invoke$lambda0;
                m2969invoke$lambda0 = SocialProfileActivity$onRefresh$1.m2969invoke$lambda0((FeedViewHolderModel) obj);
                return m2969invoke$lambda0;
            }
        });
        baseSocialFeedsAdapter2 = this.this$0.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (baseSocialFeedsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseSocialFeedsAdapter2 = null;
        }
        baseSocialFeedsAdapter2.getErrorConfigVersion();
        SocialProfileContract.Presenter socialProfilePresenter = this.this$0.getSocialProfilePresenter();
        relationshipItemModel = this.this$0.lookAheadTest;
        if (relationshipItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            relationshipItemModel2 = relationshipItemModel;
        }
        socialProfilePresenter.moveToNextValue(relationshipItemModel2.GetContactSyncConfig);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final boolean m2969invoke$lambda0(FeedViewHolderModel feedViewHolderModel) {
        return feedViewHolderModel.getErrorConfigVersion != 8;
    }
}
