package id.dana.sync_engine.data.source.device;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import androidx.core.app.ActivityCompat;
import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sync_engine.data.entity.DeviceContactEntity;
import id.dana.sync_engine.data.entity.SyncContactType;
import id.dana.sync_engine.data.source.ContactEntityData;
import id.dana.sync_engine.domain.model.UserContact;
import id.dana.sync_engine.exception.SyncEngineException;
import id.dana.utils.exception.CallableReturnNullError;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Singleton
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u000202\u0012\u0006\u0010\n\u001a\u000200¢\u0006\u0004\b4\u00105J#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0007\u0010\u0011J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\f\u0010\u0014J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ+\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0007\u0010\u001aJ\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\u000fJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005H\u0016¢\u0006\u0004\b\f\u0010\u000fJ\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u001cJ\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u000fJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\u0006\u0010\u0004\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0007\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\"\u0010\u000fJA\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020$0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0#2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010%J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b&\u0010\u000fJ+\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\b\b\u0000\u0010(*\u00020'2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000)¢\u0006\u0004\b\u0007\u0010*J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0007\u0010+J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010,J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010-J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u0016\u0010.J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\f\u0010/J\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u000e\u0010.J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000e\u0010-J#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\bJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\bJ\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u0015\u0010.R\u0014\u0010\u000e\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u00101R\u0014\u0010\u0016\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00103"}, d2 = {"Lid/dana/sync_engine/data/source/device/ContactEntityDataDevice;", "Lid/dana/sync_engine/data/source/ContactEntityData;", "", "Lid/dana/sync_engine/domain/model/UserContact;", "p0", "Lio/reactivex/Observable;", "", "getAuthRequestContext", "(Ljava/util/List;)Lio/reactivex/Observable;", "", "p1", "", "MyBillsEntityDataFactory", "(Ljava/util/List;Z)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "()Lio/reactivex/Observable;", "", "(Ljava/lang/String;I)Lio/reactivex/Observable;", "Lid/dana/sync_engine/data/entity/SyncContactType;", "Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "(II)Lio/reactivex/Observable;", "p2", "p3", "(IILjava/lang/Boolean;I)Lio/reactivex/Observable;", "", "(Lid/dana/sync_engine/data/entity/SyncContactType;)Lio/reactivex/Observable;", "scheduleImpl", "getErrorConfigVersion", "()I", "moveToNextValue", "()Z", "lookAheadTest", "", "Lid/dana/sync_engine/data/entity/DeviceContactEntity;", "([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "T", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/Observable;", "(Lid/dana/sync_engine/data/entity/SyncContactType;Lid/dana/data/config/source/amcs/result/ContactSyncConfigResult;)V", "(Z)V", "(I)V", "(Lid/dana/sync_engine/data/entity/SyncContactType;J)V", "(J)V", "Landroid/content/ContentResolver;", "Landroid/content/ContentResolver;", "Landroid/content/Context;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;Landroid/content/ContentResolver;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactEntityDataDevice implements ContactEntityData {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ContentResolver BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;
    public static final String[] BuiltInFictitiousFunctionClassFactory = {ContactProvider.Column.CONTACT_ID, ContactProvider.Column.DISPLAY_NAME, ContactProvider.Column.DISPLAY_PHOTO, ContactProvider.Column.PHONENUMBER, ContactProvider.Column.MIMETYPE, ContactProvider.ColumnSpecial.LAST_UPDATED_TIME};
    public static final String[] PlaceComponentResult = {ContactProvider.Column.MIMETYPE_PHONENUMBER};

    @Inject
    public ContactEntityDataDevice(Context context, ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(contentResolver, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.BuiltInFictitiousFunctionClassFactory = contentResolver;
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Integer> PlaceComponentResult() {
        return getAuthRequestContext(new Function0<Integer>() { // from class: id.dana.sync_engine.data.source.device.ContactEntityDataDevice$getContactSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Integer authRequestContext = ContactEntityDataDevice.getAuthRequestContext(ContactEntityDataDevice.this);
                return Integer.valueOf(authRequestContext != null ? authRequestContext.intValue() : 0);
            }
        });
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<UserContact>> KClassImpl$Data$declaredNonStaticMembers$2(final int p0, final int p1) {
        Observable<List<UserContact>> map = getAuthRequestContext(new Function0<List<? extends DeviceContactEntity>>() { // from class: id.dana.sync_engine.data.source.device.ContactEntityDataDevice$getContacts$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends DeviceContactEntity> invoke() {
                return ContactEntityDataDevice.KClassImpl$Data$declaredNonStaticMembers$2(ContactEntityDataDevice.this, p0, p1);
            }
        }).map(new Function() { // from class: id.dana.sync_engine.data.source.device.ContactEntityDataDevice$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityDataDevice.NetworkUserEntityData$$ExternalSyntheticLambda0((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<UserContact>> getAuthRequestContext(int p0, int p1, Boolean p2, int p3) {
        ?? r2 = 0;
        throw new NotImplementedError(r2, 1, r2);
    }

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<UserContact> KClassImpl$Data$declaredNonStaticMembers$2() {
        return getAuthRequestContext(new Function0<UserContact>() { // from class: id.dana.sync_engine.data.source.device.ContactEntityDataDevice$getLatestUpdatedContact$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UserContact invoke() {
                DeviceContactEntity PlaceComponentResult2 = ContactEntityDataDevice.PlaceComponentResult(ContactEntityDataDevice.this);
                if (PlaceComponentResult2 != null) {
                    DeviceContactEntity.Companion companion = DeviceContactEntity.INSTANCE;
                    return DeviceContactEntity.Companion.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2);
                }
                UserContact.Companion companion2 = UserContact.INSTANCE;
                return UserContact.Companion.PlaceComponentResult();
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Unit> KClassImpl$Data$declaredNonStaticMembers$2(List<UserContact> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<String>> MyBillsEntityDataFactory(List<UserContact> p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory(List<UserContact> p0) {
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

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<Boolean> getAuthRequestContext() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
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

    @Override // id.dana.sync_engine.data.source.ContactEntityData
    public final Observable<List<UserContact>> getAuthRequestContext(final String p0, final int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<List<UserContact>> map = getAuthRequestContext(new Function0<List<? extends DeviceContactEntity>>() { // from class: id.dana.sync_engine.data.source.device.ContactEntityDataDevice$getContactByPhoneNumber$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends DeviceContactEntity> invoke() {
                return ContactEntityDataDevice.BuiltInFictitiousFunctionClassFactory(ContactEntityDataDevice.this, p0, p1);
            }
        }).map(new Function() { // from class: id.dana.sync_engine.data.source.device.ContactEntityDataDevice$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ContactEntityDataDevice.PlaceComponentResult((List) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    private <T> Observable<T> getAuthRequestContext(final Function0<? extends T> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (!moveToNextValue()) {
            Observable<T> error = Observable.error(SyncEngineException.NoContactPermission.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        }
        Observable<T> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.sync_engine.data.source.device.ContactEntityDataDevice$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ContactEntityDataDevice.KClassImpl$Data$declaredNonStaticMembers$2(Function0.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    private final boolean moveToNextValue() {
        return ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, "android.permission.READ_CONTACTS") == 0;
    }

    private final List<DeviceContactEntity> PlaceComponentResult(String[] p0, String p1, String[] p2, String p3) {
        ArrayList arrayList = new ArrayList();
        Cursor query = this.BuiltInFictitiousFunctionClassFactory.query(ContactsContract.Data.CONTENT_URI, p0, p1, p2, p3);
        if (query != null) {
            if (query.getCount() > 0) {
                query.moveToFirst();
                do {
                    long j = query.getLong(query.getColumnIndex(ContactProvider.Column.CONTACT_ID));
                    String string = query.getString(query.getColumnIndex(ContactProvider.Column.DISPLAY_NAME));
                    if (string == null) {
                        string = "";
                    }
                    String string2 = query.getString(query.getColumnIndex(ContactProvider.Column.PHONENUMBER));
                    String str = string2 == null ? "" : string2;
                    String string3 = query.getString(query.getColumnIndex(ContactProvider.ColumnSpecial.LAST_UPDATED_TIME));
                    String string4 = query.getString(query.getColumnIndex(ContactProvider.Column.DISPLAY_PHOTO));
                    byte[] bytes = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "");
                    String normalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(str);
                    Intrinsics.checkNotNullExpressionValue(normalizeDigitsOnly, "");
                    String replaceIndoPhonePrefixWithRegionDash = PhoneNumberUtilKt.replaceIndoPhonePrefixWithRegionDash(normalizeDigitsOnly);
                    Charset charset = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(charset, "");
                    arrayList.add(new DeviceContactEntity(j, replaceIndoPhonePrefixWithRegionDash, str, new String(bytes, charset), string3, string4));
                } while (query.moveToNext());
            }
            query.close();
        }
        return arrayList;
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

    public static /* synthetic */ List PlaceComponentResult(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<DeviceContactEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DeviceContactEntity deviceContactEntity : list2) {
            DeviceContactEntity.Companion companion = DeviceContactEntity.INSTANCE;
            arrayList.add(DeviceContactEntity.Companion.BuiltInFictitiousFunctionClassFactory(deviceContactEntity));
        }
        return arrayList;
    }

    public static /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        Object invoke = function0.invoke();
        if (invoke != null) {
            return invoke;
        }
        throw new CallableReturnNullError("ContactEntityDataDevice#safeExecuteDeviceContact");
    }

    public static /* synthetic */ List NetworkUserEntityData$$ExternalSyntheticLambda0(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<DeviceContactEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DeviceContactEntity deviceContactEntity : list2) {
            DeviceContactEntity.Companion companion = DeviceContactEntity.INSTANCE;
            arrayList.add(DeviceContactEntity.Companion.BuiltInFictitiousFunctionClassFactory(deviceContactEntity));
        }
        return arrayList;
    }

    public static final /* synthetic */ Integer getAuthRequestContext(ContactEntityDataDevice contactEntityDataDevice) {
        String format = String.format("%s, %s COLLATE NOCASE ASC", Arrays.copyOf(new Object[]{ContactProvider.Column.DISPLAY_NAME, ContactProvider.Column.PHONENUMBER}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "");
        Cursor query = contactEntityDataDevice.BuiltInFictitiousFunctionClassFactory.query(ContactsContract.Data.CONTENT_URI, BuiltInFictitiousFunctionClassFactory, ContactProvider.Selection.SELECT_ALL, PlaceComponentResult, format);
        if (query != null) {
            int count = query.getCount();
            query.close();
            return Integer.valueOf(count);
        }
        return null;
    }

    public static final /* synthetic */ DeviceContactEntity PlaceComponentResult(ContactEntityDataDevice contactEntityDataDevice) {
        String format = String.format("%s COLLATE NOCASE DESC LIMIT %s", Arrays.copyOf(new Object[]{ContactProvider.ColumnSpecial.LAST_UPDATED_TIME, 1}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return (DeviceContactEntity) CollectionsKt.firstOrNull((List) contactEntityDataDevice.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, ContactProvider.Selection.SELECT_ALL, PlaceComponentResult, format));
    }

    public static final /* synthetic */ List KClassImpl$Data$declaredNonStaticMembers$2(ContactEntityDataDevice contactEntityDataDevice, int i, int i2) {
        String format = String.format("%s, %s COLLATE NOCASE ASC LIMIT %s OFFSET %s", Arrays.copyOf(new Object[]{ContactProvider.Column.DISPLAY_NAME, ContactProvider.Column.PHONENUMBER, Integer.valueOf(i), Integer.valueOf(i2)}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return contactEntityDataDevice.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, ContactProvider.Selection.SELECT_ALL, PlaceComponentResult, format);
    }

    public static final /* synthetic */ List BuiltInFictitiousFunctionClassFactory(ContactEntityDataDevice contactEntityDataDevice, String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("data1 DESC LIMIT ");
        sb.append(i);
        String obj = sb.toString();
        String[] strArr = BuiltInFictitiousFunctionClassFactory;
        StringBuilder sb2 = new StringBuilder();
        sb2.append('%');
        sb2.append(str);
        sb2.append('%');
        return contactEntityDataDevice.PlaceComponentResult(strArr, "data1 LIKE ?", new String[]{sb2.toString()}, obj);
    }
}
