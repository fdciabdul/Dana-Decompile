package id.dana.feeds.data.activation.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.feeds.data.activation.source.FeedInitEntityData;
import id.dana.feeds.data.activation.source.network.response.InitFeedResponse;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000e\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0017X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/data/activation/source/local/PreferenceFeedInitEntityData;", "Lid/dana/feeds/data/activation/source/FeedInitEntityData;", "", "p0", "Lid/dana/feeds/data/activation/source/network/response/InitFeedResponse;", "PlaceComponentResult", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)Z", "p2", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "Ljava/lang/String;", "Lid/dana/data/storage/Serializer;", "Lid/dana/data/storage/Serializer;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferenceFeedInitEntityData implements FeedInitEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Context BuiltInFictitiousFunctionClassFactory;
    private final PreferenceFacade MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Serializer getAuthRequestContext;

    @Inject
    public PreferenceFeedInitEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.getAuthRequestContext = serializer;
        this.PlaceComponentResult = "PreferenceSocialSyncEntityDataproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("PreferenceSocialSyncEntityDataproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.MyBillsEntityDataFactory = new SimpleSecureKeyPreference(createData2);
    }

    @Override // id.dana.feeds.data.activation.source.FeedInitEntityData
    public final Object PlaceComponentResult(int i, Continuation<? super InitFeedResponse> continuation) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.feeds.data.activation.source.FeedInitEntityData
    public final void MyBillsEntityDataFactory(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        preferenceFacade.saveData(sb.toString(), Boolean.TRUE);
    }

    @Override // id.dana.feeds.data.activation.source.FeedInitEntityData
    public final boolean getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        PreferenceFacade preferenceFacade = this.MyBillsEntityDataFactory;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        Boolean bool = preferenceFacade.getBoolean(sb.toString());
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
