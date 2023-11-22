package com.anggrayudi.storage.permission;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.view.ComponentActivity;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001cB1\b\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR,\u0010\u0011\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e*\b\u0012\u0004\u0012\u00020\u000e0\r0\r\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "", "check", "()V", "continueToPermissionRequest", "Landroid/app/Activity;", "BuiltInFictitiousFunctionClassFactory", "Landroid/app/Activity;", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "PlaceComponentResult", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "MyBillsEntityDataFactory", "Landroidx/activity/result/ActivityResultLauncher;", "KClassImpl$Data$declaredNonStaticMembers$2", "[Ljava/lang/String;", "", "getAuthRequestContext", "Ljava/lang/Integer;", "p0", "p1", "p2", "p3", "<init>", "(Landroid/app/Activity;[Ljava/lang/String;Ljava/lang/Integer;Lcom/anggrayudi/storage/permission/PermissionCallback;)V", "Builder"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ActivityPermissionRequest implements PermissionRequest {
    private final Activity BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final String[] MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ActivityResultLauncher<String[]> KClassImpl$Data$declaredNonStaticMembers$2;
    private final PermissionCallback PlaceComponentResult;
    private final Integer getAuthRequestContext;

    public /* synthetic */ ActivityPermissionRequest(Activity activity, String[] strArr, Integer num, PermissionCallback permissionCallback, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, strArr, num, permissionCallback);
    }

    private ActivityPermissionRequest(Activity activity, String[] strArr, Integer num, PermissionCallback permissionCallback) {
        this.BuiltInFictitiousFunctionClassFactory = activity;
        this.MyBillsEntityDataFactory = strArr;
        this.getAuthRequestContext = num;
        this.PlaceComponentResult = permissionCallback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = activity instanceof ComponentActivity ? ((ComponentActivity) activity).registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.anggrayudi.storage.permission.ActivityPermissionRequest$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ActivityPermissionRequest.getAuthRequestContext(ActivityPermissionRequest.this, (Map) obj);
            }
        }) : null;
    }

    @Override // com.anggrayudi.storage.permission.PermissionRequest
    public final void check() {
        boolean z;
        String[] strArr = this.MyBillsEntityDataFactory;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            if (!(ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, strArr[i]) == 0)) {
                z = false;
                break;
            }
            i++;
        }
        if (z) {
            PermissionCallback permissionCallback = this.PlaceComponentResult;
            String[] strArr2 = this.MyBillsEntityDataFactory;
            ArrayList arrayList = new ArrayList(strArr2.length);
            for (String str : strArr2) {
                arrayList.add(new PermissionReport(str, true, false));
            }
            permissionCallback.onPermissionsChecked(new PermissionResult(arrayList), false);
            return;
        }
        this.PlaceComponentResult.onDisplayConsentDialog(this);
    }

    @Override // com.anggrayudi.storage.permission.PermissionRequest
    public final void continueToPermissionRequest() {
        for (String str : this.MyBillsEntityDataFactory) {
            if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, str) != 0) {
                ActivityResultLauncher<String[]> activityResultLauncher = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (activityResultLauncher == null) {
                    Activity activity = this.BuiltInFictitiousFunctionClassFactory;
                    String[] strArr = this.MyBillsEntityDataFactory;
                    Integer num = this.getAuthRequestContext;
                    if (num == null) {
                        throw new IllegalStateException("Request code hasn't been set yet");
                    }
                    ActivityCompat.BuiltInFictitiousFunctionClassFactory(activity, strArr, num.intValue());
                    return;
                }
                activityResultLauncher.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, null);
                return;
            }
        }
        PermissionCallback permissionCallback = this.PlaceComponentResult;
        String[] strArr2 = this.MyBillsEntityDataFactory;
        ArrayList arrayList = new ArrayList(strArr2.length);
        for (String str2 : strArr2) {
            arrayList.add(new PermissionReport(str2, true, false));
        }
        permissionCallback.onPermissionsChecked(new PermissionResult(arrayList), false);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0015¢\u0006\u0004\b\u0013\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010"}, d2 = {"Lcom/anggrayudi/storage/permission/ActivityPermissionRequest$Builder;", "", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "PlaceComponentResult", "()Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Landroid/app/Activity;", "getAuthRequestContext", "Landroid/app/Activity;", "BuiltInFictitiousFunctionClassFactory", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "MyBillsEntityDataFactory", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "", "", "Ljava/util/Set;", "", "Ljava/lang/Integer;", "p0", "p1", "<init>", "(Landroid/app/Activity;)V", "Landroidx/activity/ComponentActivity;", "(Landroidx/activity/ComponentActivity;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final Integer MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public PermissionCallback getAuthRequestContext;
        public Set<String> PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        private final Activity BuiltInFictitiousFunctionClassFactory;

        public Builder(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "");
            this.PlaceComponentResult = SetsKt.emptySet();
            this.BuiltInFictitiousFunctionClassFactory = activity;
            this.MyBillsEntityDataFactory = 1;
        }

        public Builder(ComponentActivity componentActivity) {
            Intrinsics.checkNotNullParameter(componentActivity, "");
            this.PlaceComponentResult = SetsKt.emptySet();
            this.BuiltInFictitiousFunctionClassFactory = componentActivity;
            this.MyBillsEntityDataFactory = null;
        }

        public final ActivityPermissionRequest PlaceComponentResult() {
            Activity activity = this.BuiltInFictitiousFunctionClassFactory;
            Object[] array = this.PlaceComponentResult.toArray(new String[0]);
            if (array != null) {
                Integer num = this.MyBillsEntityDataFactory;
                PermissionCallback permissionCallback = this.getAuthRequestContext;
                Intrinsics.checkNotNull(permissionCallback);
                return new ActivityPermissionRequest(activity, (String[]) array, num, permissionCallback, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public static /* synthetic */ void getAuthRequestContext(ActivityPermissionRequest activityPermissionRequest, Map map) {
        Intrinsics.checkNotNullParameter(activityPermissionRequest, "");
        Intrinsics.checkNotNullExpressionValue(map, "");
        ArrayList arrayList = new ArrayList(map.size());
        Iterator it = map.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            boolean booleanValue = ((Boolean) entry.getValue()).booleanValue();
            if (((Boolean) entry.getValue()).booleanValue() || ActivityCompat.MyBillsEntityDataFactory(activityPermissionRequest.BuiltInFictitiousFunctionClassFactory, (String) entry.getKey())) {
                z = false;
            }
            arrayList.add(new PermissionReport(str, booleanValue, z));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (((PermissionReport) obj).getGetAuthRequestContext()) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            activityPermissionRequest.PlaceComponentResult.onPermissionsChecked(new PermissionResult(arrayList2), true);
        } else {
            activityPermissionRequest.PlaceComponentResult.onShouldRedirectToSystemSettings(arrayList4);
        }
    }
}
