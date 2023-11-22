package id.dana.sync_engine.data.source.network;

import android.content.Context;
import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.synccontact.repository.source.network.request.BizTransferSyncContactRequest;
import id.dana.data.synccontact.repository.source.network.result.BizTransferSyncContactResult;
import id.dana.feeds.data.synccontact.source.network.request.FeedsSyncRequest;
import id.dana.feeds.data.synccontact.source.network.response.FeedsSyncResponse;
import id.dana.feeds.data.synccontact.source.network.response.FeedsUserContact;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.sync_engine.data.entity.SyncContactType;
import id.dana.sync_engine.data.source.ContactEntityData;
import id.dana.sync_engine.domain.model.UserContact;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020,\u0012\u0006\u0010\f\u001a\u00020-\u0012\u0006\u0010\u001a\u001a\u00020.\u0012\u0006\u0010\u001b\u001a\u00020/¢\u0006\u0004\b0\u00101J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ1\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00072\u0006\u0010\u0006\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\t\u0010\u0013J\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u000e\u0010\u0016J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0011J+\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00072\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J=\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00072\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\t\u0010\u001cJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016¢\u0006\u0004\b\t\u0010\u0011J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0011J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020 0\u00072\u0006\u0010\u0006\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010!J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0011J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u0007H\u0016¢\u0006\u0004\b\"\u0010\u0011J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020 0\u00072\u0006\u0010\u0006\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\t\u0010!J\u000f\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016¢\u0006\u0004\b%\u0010\u0011J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\nJ\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b&\u0010\u0011J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\t\u0010'J\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010(J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010)J\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020 H\u0016¢\u0006\u0004\b\u0018\u0010*J\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020 H\u0016¢\u0006\u0004\b\u000e\u0010+J\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020 H\u0016¢\u0006\u0004\b\u0010\u0010*J\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0010\u0010)J#\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\nJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020 0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u001f\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020 H\u0016¢\u0006\u0004\b\u0017\u0010*"}, d2 = {"Lid/dana/sync_engine/data/source/network/ContactEntityDataNetwork;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/sync_engine/data/source/network/ContactSyncFacade;", "Lid/dana/sync_engine/data/source/ContactEntityData;", "", "Lid/dana/sync_engine/domain/model/UserContact;", "p0", "Lio/reactivex/Observable;", "", "getAuthRequestContext", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "p1", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Z)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "", "(Ljava/lang/String;I)Lio/reactivex/Observable;", "Lid/dana/sync_engine/data/entity/SyncContactType;", "Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "(II)Lio/reactivex/Observable;", "p2", "p3", "(IILjava/lang/Boolean;I)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Lio/reactivex/Observable;", "scheduleImpl", "getErrorConfigVersion", "()I", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Lid/dana/sync_engine/data/entity/SyncContactType;Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;)V", "(Z)V", "(I)V", "(Lid/dana/sync_engine/data/entity/SyncContactType;J)V", "(J)V", "Landroid/content/Context;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactEntityDataNetwork extends SecureBaseNetwork<ContactSyncFacade> implements ContactEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<ContactSyncFacade> getFacadeClass() {
        return ContactSyncFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ContactEntityDataNetwork(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Integer> PlaceComponentResult() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<UserContact>> KClassImpl$Data$declaredNonStaticMembers$2(int p0, int p1) {
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<UserContact>> getAuthRequestContext(int p0, int p1, Boolean p2, int p3) {
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<UserContact> KClassImpl$Data$declaredNonStaticMembers$2() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Unit> KClassImpl$Data$declaredNonStaticMembers$2(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Long> KClassImpl$Data$declaredNonStaticMembers$2(SyncContactType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void KClassImpl$Data$declaredNonStaticMembers$2(SyncContactType p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Long> getAuthRequestContext(SyncContactType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void BuiltInFictitiousFunctionClassFactory(SyncContactType p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void PlaceComponentResult(SyncContactType p0, long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Boolean> lookAheadTest() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Integer> MyBillsEntityDataFactory() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Boolean> getAuthRequestContext() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Long> scheduleImpl() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void MyBillsEntityDataFactory(long p0) {
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Unit> getAuthRequestContext(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Long> MyBillsEntityDataFactory(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final ContactSyncConfigResult MyBillsEntityDataFactory(SyncContactType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void getAuthRequestContext(SyncContactType p0, ContactSyncConfigResult p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<String>> MyBillsEntityDataFactory(List<UserContact> p0, boolean p1) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList arrayList2 = null;
        if (p1) {
            List<UserContact> list = p0;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (UserContact userContact : list) {
                String str = userContact.scheduleImpl;
                arrayList3.add(new id.dana.domain.sendmoney.model.UserContact(userContact.NetworkUserEntityData$$ExternalSyntheticLambda0, str == null ? "" : str, null, 4, null));
            }
            arrayList = arrayList3;
        } else {
            List<UserContact> list2 = p0;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList4.add(((UserContact) it.next()).NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
            arrayList2 = arrayList4;
            arrayList = null;
        }
        final BizTransferSyncContactRequest bizTransferSyncContactRequest = new BizTransferSyncContactRequest();
        bizTransferSyncContactRequest.phoneNumbers = arrayList2;
        bizTransferSyncContactRequest.phoneNumbersWithName = arrayList;
        bizTransferSyncContactRequest.envInfo = generateMobileEnvInfo();
        Observable<List<String>> map = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.sync_engine.data.source.network.ContactEntityDataNetwork$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return ContactEntityDataNetwork.MyBillsEntityDataFactory(BizTransferSyncContactRequest.this, (ContactSyncFacade) obj);
            }
        }).map(new Function() { // from class: id.dana.sync_engine.data.source.network.ContactEntityDataNetwork$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityDataNetwork.getAuthRequestContext((BizTransferSyncContactResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        List<UserContact> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (UserContact userContact : list) {
            String str = userContact.NetworkUserEntityData$$ExternalSyntheticLambda0;
            String str2 = userContact.scheduleImpl;
            if (str2 == null) {
                str2 = "";
            }
            arrayList.add(new FeedsUserContact(str, str2));
        }
        final FeedsSyncRequest feedsSyncRequest = new FeedsSyncRequest(arrayList);
        feedsSyncRequest.envInfo = generateMobileEnvInfo();
        Observable<Boolean> map = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.sync_engine.data.source.network.ContactEntityDataNetwork$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return ContactEntityDataNetwork.KClassImpl$Data$declaredNonStaticMembers$2(FeedsSyncRequest.this, (ContactSyncFacade) obj);
            }
        }).map(new Function() { // from class: id.dana.sync_engine.data.source.network.ContactEntityDataNetwork$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityDataNetwork.KClassImpl$Data$declaredNonStaticMembers$2((FeedsSyncResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Unit> BuiltInFictitiousFunctionClassFactory() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Unit> NetworkUserEntityData$$ExternalSyntheticLambda0() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final void BuiltInFictitiousFunctionClassFactory(int p0) {
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final int getErrorConfigVersion() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<UserContact>> getAuthRequestContext(String p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    public static /* synthetic */ List getAuthRequestContext(BizTransferSyncContactResult bizTransferSyncContactResult) {
        Intrinsics.checkNotNullParameter(bizTransferSyncContactResult, "");
        return bizTransferSyncContactResult.registeredUsers;
    }

    public static /* synthetic */ Boolean KClassImpl$Data$declaredNonStaticMembers$2(FeedsSyncResponse feedsSyncResponse) {
        Intrinsics.checkNotNullParameter(feedsSyncResponse, "");
        return Boolean.valueOf(feedsSyncResponse.success);
    }

    public static /* synthetic */ FeedsSyncResponse KClassImpl$Data$declaredNonStaticMembers$2(FeedsSyncRequest feedsSyncRequest, ContactSyncFacade contactSyncFacade) {
        Intrinsics.checkNotNullParameter(feedsSyncRequest, "");
        return contactSyncFacade.syncSocialContact(feedsSyncRequest);
    }

    public static /* synthetic */ BizTransferSyncContactResult MyBillsEntityDataFactory(BizTransferSyncContactRequest bizTransferSyncContactRequest, ContactSyncFacade contactSyncFacade) {
        Intrinsics.checkNotNullParameter(bizTransferSyncContactRequest, "");
        return contactSyncFacade.checkDanaUser(bizTransferSyncContactRequest);
    }
}
