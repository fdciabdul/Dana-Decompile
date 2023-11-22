package id.dana.danah5.contact;

import android.app.Activity;
import android.app.Application;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.sync_engine.domain.interactor.GetContactByPhoneNumber;
import id.dana.sync_engine.domain.model.UserContact;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b'\u0010\u0013J9\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0015*\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&"}, d2 = {"Lid/dana/danah5/contact/ContactBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "Lcom/alibaba/ariver/app/api/Page;", "page", "", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/fastjson/JSONObject;", "info", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", "contacts", "(Lcom/alibaba/ariver/app/api/Page;Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "phoneNumber", "", "limitContact", "getContacts", "(Ljava/lang/String;I)V", "onInitialized", "()V", "requestPermissionsAccess", "", "Lid/dana/sync_engine/domain/model/UserContact;", "Lid/dana/danah5/contact/ContactBridge$ContactsFilter;", "toContactsFilter", "(Ljava/util/List;)Ljava/util/List;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "event", "Ljava/lang/String;", "Lid/dana/sync_engine/domain/interactor/GetContactByPhoneNumber;", "getContactByPhoneNumber", "Lid/dana/sync_engine/domain/interactor/GetContactByPhoneNumber;", "getGetContactByPhoneNumber", "()Lid/dana/sync_engine/domain/interactor/GetContactByPhoneNumber;", "setGetContactByPhoneNumber", "(Lid/dana/sync_engine/domain/interactor/GetContactByPhoneNumber;)V", "<init>", "Companion", "ContactsFilter"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactBridge extends BaseBridge {
    private static final String EVENT_CHECK_CONTACT_PERMISSION = "checkContactPermission";
    private static final String EVENT_FILTER_CONTACT = "filterContacts";
    private static final String EVENT_REQUEST_CONTACT_PERMISSION = "requestContactPermission";
    private static final String KEY_INFO_MAX_CONTACTS = "maxContacts";
    private static final String KEY_INFO_NUMBER = "number";
    private static final String KEY_REQUEST_CONTACTS = "contacts";
    private static final String KEY_REQUEST_PERMISSION_STATUS = "permissionStatus";
    private static final String KEY_REQUEST_SUCCESS = "success";
    private static final String TAG = "ContactBridge";
    private Activity activity;
    private BridgeCallback bridgeCallback;
    private String event;
    @Inject
    public GetContactByPhoneNumber getContactByPhoneNumber;

    @JvmName(name = "getGetContactByPhoneNumber")
    public final GetContactByPhoneNumber getGetContactByPhoneNumber() {
        GetContactByPhoneNumber getContactByPhoneNumber = this.getContactByPhoneNumber;
        if (getContactByPhoneNumber != null) {
            return getContactByPhoneNumber;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetContactByPhoneNumber")
    public final void setGetContactByPhoneNumber(GetContactByPhoneNumber getContactByPhoneNumber) {
        Intrinsics.checkNotNullParameter(getContactByPhoneNumber, "");
        this.getContactByPhoneNumber = getContactByPhoneNumber;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void contacts(@BindingNode(Page.class) Page page, @BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(page, "");
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        this.event = eventName;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        int KClassImpl$Data$declaredNonStaticMembers$2 = ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(activity, "android.permission.READ_CONTACTS");
        String str = this.event;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == -2112029888) {
                if (str.equals(EVENT_REQUEST_CONTACT_PERMISSION)) {
                    requestPermissionsAccess();
                }
            } else if (hashCode != -769026069) {
                if (hashCode == 1090398695 && str.equals(EVENT_CHECK_CONTACT_PERMISSION)) {
                    Pair[] pairArr = new Pair[2];
                    pairArr[0] = new Pair(KEY_REQUEST_PERMISSION_STATUS, Boolean.valueOf(KClassImpl$Data$declaredNonStaticMembers$2 == 0));
                    pairArr[1] = new Pair("success", Boolean.valueOf(KClassImpl$Data$declaredNonStaticMembers$2 == 0));
                    bridgeCallback.sendJSONResponse(new JSONObject(MapsKt.hashMapOf(pairArr)));
                }
            } else if (str.equals(EVENT_FILTER_CONTACT) && KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                String string = info != null ? info.getString(KEY_INFO_NUMBER) : null;
                String str2 = string != null ? string : "";
                Integer integer = info != null ? info.getInteger(KEY_INFO_MAX_CONTACTS) : null;
                getContacts(str2, integer == null ? 3 : integer.intValue());
            }
        }
    }

    private final void requestPermissionsAccess() {
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        requestPermissions(activity, new String[]{"android.permission.READ_CONTACTS"}, new PermissionCallback() { // from class: id.dana.danah5.contact.ContactBridge$requestPermissionsAccess$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult result, boolean fromSystemDialog) {
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(result, "");
                HashMap hashMapOf = MapsKt.hashMapOf(new Pair("permissionStatus", Boolean.valueOf(result.MyBillsEntityDataFactory())), new Pair("success", Boolean.valueOf(result.MyBillsEntityDataFactory())));
                bridgeCallback = ContactBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                bridgeCallback.sendJSONResponse(new JSONObject(hashMapOf));
            }
        });
    }

    static /* synthetic */ void getContacts$default(ContactBridge contactBridge, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 3;
        }
        contactBridge.getContacts(str, i);
    }

    private final void getContacts(String phoneNumber, int limitContact) {
        getGetContactByPhoneNumber().execute(new GetContactByPhoneNumber.Params(phoneNumber, limitContact), new Function1<List<? extends UserContact>, Unit>() { // from class: id.dana.danah5.contact.ContactBridge$getContacts$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UserContact> list) {
                invoke2((List<UserContact>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UserContact> list) {
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(list, "");
                HashMap hashMapOf = MapsKt.hashMapOf(new Pair("contacts", ContactBridge.this.toContactsFilter(list)), new Pair("success", Boolean.TRUE));
                bridgeCallback = ContactBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                bridgeCallback.sendJSONResponse(new JSONObject(hashMapOf));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.contact.ContactBridge$getContacts$2
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
                BridgeCallback bridgeCallback;
                Intrinsics.checkNotNullParameter(th, "");
                HashMap hashMapOf = MapsKt.hashMapOf(new Pair("success", Boolean.FALSE));
                bridgeCallback = ContactBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                bridgeCallback.sendJSONResponse(new JSONObject(hashMapOf));
                DanaLog.BuiltInFictitiousFunctionClassFactory("ContactBridge", ExceptionsKt.stackTraceToString(th));
            }
        });
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/danah5/contact/ContactBridge$ContactsFilter;", "", "", "component1", "()Ljava/lang/String;", "component2", "name", "phoneNumber", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/danah5/contact/ContactBridge$ContactsFilter;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getName", "getPhoneNumber", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ContactsFilter {
        private final String name;
        private final String phoneNumber;

        public static /* synthetic */ ContactsFilter copy$default(ContactsFilter contactsFilter, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = contactsFilter.name;
            }
            if ((i & 2) != 0) {
                str2 = contactsFilter.phoneNumber;
            }
            return contactsFilter.copy(str, str2);
        }

        /* renamed from: component1  reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2  reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final ContactsFilter copy(String name, String phoneNumber) {
            Intrinsics.checkNotNullParameter(name, "");
            Intrinsics.checkNotNullParameter(phoneNumber, "");
            return new ContactsFilter(name, phoneNumber);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof ContactsFilter) {
                ContactsFilter contactsFilter = (ContactsFilter) other;
                return Intrinsics.areEqual(this.name, contactsFilter.name) && Intrinsics.areEqual(this.phoneNumber, contactsFilter.phoneNumber);
            }
            return false;
        }

        public final int hashCode() {
            return (this.name.hashCode() * 31) + this.phoneNumber.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ContactsFilter(name=");
            sb.append(this.name);
            sb.append(", phoneNumber=");
            sb.append(this.phoneNumber);
            sb.append(')');
            return sb.toString();
        }

        public ContactsFilter(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.name = str;
            this.phoneNumber = str2;
        }

        @JvmName(name = "getName")
        public final String getName() {
            return this.name;
        }

        @JvmName(name = "getPhoneNumber")
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }
    }

    public final List<ContactsFilter> toContactsFilter(List<UserContact> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<UserContact> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (UserContact userContact : list2) {
            String str = userContact.scheduleImpl;
            if (str == null) {
                str = "";
            }
            arrayList.add(new ContactsFilter(str, StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(userContact.NetworkUserEntityData$$ExternalSyntheticLambda0, "62-", "0", false, 4, (Object) null), "+62", "0", false, 4, (Object) null), "-", "", false, 4, (Object) null)));
        }
        return arrayList;
    }
}
