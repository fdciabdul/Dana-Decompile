package id.dana.social.base;

import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.social.adapter.BaseSocialFeedInteraction;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.adapter.SocialProfileHeaderViewHolder;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b2\u0010\nJ\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u000eH\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0010\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0010\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u0018J\u001d\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\nJ\r\u0010 \u001a\u00020\u0006¢\u0006\u0004\b \u0010\nJ\u001d\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010!J\u001d\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020#¢\u0006\u0004\b\u0012\u0010$J\u001d\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020#¢\u0006\u0004\b\u0010\u0010%J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020&0\u0004H&¢\u0006\u0004\b\u0007\u0010'J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010(R&\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010)X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010*R\u001a\u0010\u0010\u001a\u00020\u00178\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u00178\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b-\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\u00178\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u0010\u0010+\u001a\u0004\b.\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00178\u0007X\u0087\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b/\u0010\u0018R\u0012\u0010\t\u001a\u000200X\u0087\u0002¢\u0006\u0006\n\u0004\b-\u00101"}, d2 = {"Lid/dana/social/base/BaseSocialFeedsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)V", "getErrorConfigVersion", "()V", "", "getItemViewType", "(I)I", "Landroidx/recyclerview/widget/RecyclerView;", "Lid/dana/social/adapter/SocialProfileHeaderViewHolder;", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/recyclerview/widget/RecyclerView;)Lid/dana/social/adapter/SocialProfileHeaderViewHolder;", "PlaceComponentResult", "()Lid/dana/social/model/FeedViewHolderModel;", "", "getAuthRequestContext", "()Ljava/util/List;", "", "()Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "DatabaseTableConfigUtil", "GetContactSyncConfig", "(II)V", "Lid/dana/social/model/FeedModel;", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "(Lid/dana/social/model/FeedModel;Lid/dana/feeds/domain/timeline/enums/FeedActivityState;)V", "(ILid/dana/feeds/domain/timeline/enums/FeedActivityState;)V", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;)V", "(Lid/dana/social/model/FeedViewHolderModel;)V", "Lkotlin/Triple;", "Lkotlin/Triple;", "Z", "scheduleImpl", "moveToNextValue", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/adapter/SocialFeedClickListener;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseSocialFeedsAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<FeedViewHolderModel>, FeedViewHolderModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Triple<FeedViewHolderModel, FeedViewHolderModel, Integer> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public SocialFeedClickListener getErrorConfigVersion = new BaseSocialFeedInteraction();

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(RecyclerView p0, List<ProfileCtaConfig> p1);

    public abstract FeedViewHolderModel PlaceComponentResult();

    public abstract List<FeedViewHolderModel> getAuthRequestContext();

    public abstract void getAuthRequestContext(FeedViewHolderModel p0);

    @JvmName(name = "lookAheadTest")
    /* renamed from: lookAheadTest  reason: from getter */
    public final boolean getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "moveToNextValue")
    /* renamed from: moveToNextValue  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @JvmName(name = "scheduleImpl")
    /* renamed from: scheduleImpl  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SocialProfileHeaderViewHolder BuiltInFictitiousFunctionClassFactory(RecyclerView p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<FeedViewHolderModel> items = getItems();
        int i = -1;
        if (items != null) {
            Iterator<FeedViewHolderModel> it = items.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().getErrorConfigVersion == 8) {
                    i = i2;
                    break;
                }
                i2++;
            }
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = p0.findViewHolderForLayoutPosition(i);
        if (findViewHolderForLayoutPosition instanceof SocialProfileHeaderViewHolder) {
            return (SocialProfileHeaderViewHolder) findViewHolderForLayoutPosition;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int p0) {
        return getItem(p0).getErrorConfigVersion;
    }

    public final void getErrorConfigVersion() {
        List<FeedViewHolderModel> items = getItems();
        if (items == null || items.isEmpty()) {
            setItems(new ArrayList());
        }
        List<FeedViewHolderModel> items2 = getItems();
        Intrinsics.checkNotNullExpressionValue(items2, "");
        setItems(CollectionsKt.toMutableList((Collection) items2));
        getItems().addAll(getAuthRequestContext());
        notifyDataSetChanged();
    }

    public void DatabaseTableConfigUtil() {
        List<FeedViewHolderModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        if (CollectionsKt.removeAll((List) items, (Function1) new Function1<FeedViewHolderModel, Boolean>() { // from class: id.dana.social.base.BaseSocialFeedsAdapter$removeShimmer$removed$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FeedViewHolderModel feedViewHolderModel) {
                return Boolean.valueOf(feedViewHolderModel.getErrorConfigVersion == 0);
            }
        })) {
            notifyDataSetChanged();
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<FeedViewHolderModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<FeedViewHolderModel> items = getItems();
        Unit unit = null;
        if (items != null) {
            List<FeedViewHolderModel> list = items;
            boolean z = false;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((FeedViewHolderModel) it.next()).getErrorConfigVersion != 0) {
                        z = true;
                        break;
                    }
                }
            }
            Boolean valueOf = Boolean.valueOf(z);
            if (!valueOf.booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                appendItems(p0);
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            setItems(p0);
        }
    }

    public final void PlaceComponentResult(int p0, int p1) {
        if (BuiltInFictitiousFunctionClassFactory() || getItem(getItemCount() - 1).getErrorConfigVersion != p0) {
            return;
        }
        List<FeedViewHolderModel> items = getItems();
        List<FeedViewHolderModel> items2 = getItems();
        Intrinsics.checkNotNullExpressionValue(items2, "");
        items.remove(CollectionsKt.getLastIndex(items2));
        getItems().add(new FeedViewHolderModel(p1, null, null, null, null, false, 62, null));
        notifyDataSetChanged();
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return !BuiltInFictitiousFunctionClassFactory() && getItem(getItemCount() - 1).getErrorConfigVersion == 7;
    }

    public final void GetContactSyncConfig() {
        List<FeedViewHolderModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        Iterator<FeedViewHolderModel> it = items.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (it.next().getErrorConfigVersion == 12) {
                break;
            }
            i++;
        }
        if (i != -1) {
            removeItem(i);
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return getItemCount() <= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046 A[LOOP:0: B:3:0x0015->B:21:0x0046, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004a A[EDGE_INSN: B:32:0x004a->B:23:0x004a BREAK  A[LOOP:0: B:3:0x0015->B:21:0x0046], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(id.dana.social.model.FeedModel r9, id.dana.feeds.domain.timeline.enums.FeedActivityState r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.List r1 = r8.getItems()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r3 = 0
        L15:
            boolean r4 = r1.hasNext()
            r5 = -1
            if (r4 == 0) goto L49
            java.lang.Object r4 = r1.next()
            id.dana.social.model.FeedViewHolderModel r4 = (id.dana.social.model.FeedViewHolderModel) r4
            int r6 = r4.getErrorConfigVersion
            r7 = 9
            if (r6 != r7) goto L43
            id.dana.social.model.FeedModel r4 = r4.MyBillsEntityDataFactory
            if (r4 == 0) goto L3e
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r9.lookAheadTest
            if (r6 == 0) goto L35
            java.lang.String r6 = id.dana.domain.social.ExtendInfoUtilKt.getShareFeedRequestId(r6)
            goto L36
        L35:
            r6 = 0
        L36:
            if (r6 != 0) goto L39
            r6 = r0
        L39:
            boolean r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2(r6)
            goto L3f
        L3e:
            r4 = 0
        L3f:
            if (r4 == 0) goto L43
            r4 = 1
            goto L44
        L43:
            r4 = 0
        L44:
            if (r4 != 0) goto L4a
            int r3 = r3 + 1
            goto L15
        L49:
            r3 = -1
        L4a:
            if (r3 == r5) goto L80
            java.util.List r1 = r8.getItems()
            java.lang.Object r1 = r1.get(r3)
            id.dana.social.model.FeedViewHolderModel r1 = (id.dana.social.model.FeedViewHolderModel) r1
            id.dana.social.model.FeedModel r1 = r1.MyBillsEntityDataFactory
            if (r1 == 0) goto L5f
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r1.NetworkUserEntityData$$ExternalSyntheticLambda6 = r10
        L5f:
            java.util.List r10 = r8.getItems()
            java.lang.Object r10 = r10.get(r3)
            id.dana.social.model.FeedViewHolderModel r10 = (id.dana.social.model.FeedViewHolderModel) r10
            id.dana.social.model.FeedModel r10 = r10.MyBillsEntityDataFactory
            if (r10 == 0) goto L71
            java.lang.String r9 = r9.moveToNextValue
            r10.moveToNextValue = r9
        L71:
            java.util.List r9 = r8.getItems()
            java.lang.Object r9 = r9.get(r3)
            id.dana.social.model.FeedViewHolderModel r9 = (id.dana.social.model.FeedViewHolderModel) r9
            r9.PlaceComponentResult = r2
            r8.notifyItemChanged(r3)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.base.BaseSocialFeedsAdapter.PlaceComponentResult(id.dana.social.model.FeedModel, id.dana.feeds.domain.timeline.enums.FeedActivityState):void");
    }

    public final void BuiltInFictitiousFunctionClassFactory(int p0, FeedActivityState p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        FeedViewHolderModel feedViewHolderModel = getItems().get(p0);
        if (feedViewHolderModel == null || feedViewHolderModel.getErrorConfigVersion != 9) {
            return;
        }
        FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
        if (feedModel != null) {
            Intrinsics.checkNotNullParameter(p1, "");
            feedModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = p1;
        }
        feedViewHolderModel.PlaceComponentResult = false;
        notifyItemChanged(p0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003a A[LOOP:0: B:3:0x0015->B:15:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003e A[EDGE_INSN: B:30:0x003e->B:17:0x003e BREAK  A[LOOP:0: B:3:0x0015->B:15:0x003a], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.List r1 = r8.getItems()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            java.util.Iterator r0 = r1.iterator()
            r1 = 0
            r2 = 0
        L15:
            boolean r3 = r0.hasNext()
            r4 = -1
            r5 = 1
            if (r3 == 0) goto L3d
            java.lang.Object r3 = r0.next()
            id.dana.social.model.FeedViewHolderModel r3 = (id.dana.social.model.FeedViewHolderModel) r3
            int r6 = r3.getErrorConfigVersion
            r7 = 9
            if (r6 != r7) goto L37
            id.dana.social.model.FeedModel r3 = r3.MyBillsEntityDataFactory
            if (r3 == 0) goto L32
            boolean r3 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r9)
            goto L33
        L32:
            r3 = 0
        L33:
            if (r3 == 0) goto L37
            r3 = 1
            goto L38
        L37:
            r3 = 0
        L38:
            if (r3 != 0) goto L3e
            int r2 = r2 + 1
            goto L15
        L3d:
            r2 = -1
        L3e:
            if (r2 == r4) goto L8e
            java.util.List r9 = r8.getItems()
            java.lang.Object r9 = r9.get(r2)
            id.dana.social.model.FeedViewHolderModel r9 = (id.dana.social.model.FeedViewHolderModel) r9
            int r0 = r2 + (-1)
            if (r0 == r4) goto L8b
            int r1 = r2 + 1
            java.util.List r3 = r8.getItems()
            int r3 = r3.size()
            if (r1 >= r3) goto L8b
            java.util.List r3 = r8.getItems()
            java.lang.Object r3 = r3.get(r0)
            id.dana.social.model.FeedViewHolderModel r3 = (id.dana.social.model.FeedViewHolderModel) r3
            java.util.List r4 = r8.getItems()
            java.lang.Object r1 = r4.get(r1)
            id.dana.social.model.FeedViewHolderModel r1 = (id.dana.social.model.FeedViewHolderModel) r1
            boolean r10 = r3.getAuthRequestContext(r10)
            if (r10 == 0) goto L8b
            int r10 = r1.getErrorConfigVersion
            if (r10 != r5) goto L8b
            java.util.List r10 = r8.getItems()
            r10.remove(r3)
            java.util.List r10 = r8.getItems()
            r10.remove(r9)
            r9 = 2
            r8.notifyItemRangeRemoved(r0, r9)
            return
        L8b:
            r8.removeItem(r2)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.base.BaseSocialFeedsAdapter.MyBillsEntityDataFactory(java.lang.String, java.lang.String):void");
    }

    public final boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        FeedViewHolderModel item = getItem(getItemCount() - 1);
        return item != null && (item.getErrorConfigVersion == 5 || item.getErrorConfigVersion == 9 || item.getErrorConfigVersion == 11);
    }
}
