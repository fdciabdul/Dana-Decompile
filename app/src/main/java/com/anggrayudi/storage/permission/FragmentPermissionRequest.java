package com.anggrayudi.storage.permission;

import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001cB1\b\u0002\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR*\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f*\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "", "check", "()V", "continueToPermissionRequest", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "getAuthRequestContext", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "MyBillsEntityDataFactory", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/core/app/ActivityOptionsCompat;", "Landroidx/core/app/ActivityOptionsCompat;", "PlaceComponentResult", "[Ljava/lang/String;", "p0", "p1", "p2", "p3", "<init>", "(Landroidx/fragment/app/Fragment;[Ljava/lang/String;Landroidx/core/app/ActivityOptionsCompat;Lcom/anggrayudi/storage/permission/PermissionCallback;)V", "Builder"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class FragmentPermissionRequest implements PermissionRequest {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Fragment MyBillsEntityDataFactory;
    private final ActivityResultLauncher<String[]> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ActivityOptionsCompat PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String[] getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final PermissionCallback BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ FragmentPermissionRequest(Fragment fragment, String[] strArr, ActivityOptionsCompat activityOptionsCompat, PermissionCallback permissionCallback, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, strArr, activityOptionsCompat, permissionCallback);
    }

    private FragmentPermissionRequest(Fragment fragment, String[] strArr, ActivityOptionsCompat activityOptionsCompat, PermissionCallback permissionCallback) {
        this.MyBillsEntityDataFactory = fragment;
        this.getAuthRequestContext = strArr;
        this.PlaceComponentResult = activityOptionsCompat;
        this.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        ActivityResultLauncher<String[]> registerForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.anggrayudi.storage.permission.FragmentPermissionRequest$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FragmentPermissionRequest.getAuthRequestContext(FragmentPermissionRequest.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = registerForActivityResult;
    }

    @Override // com.anggrayudi.storage.permission.PermissionRequest
    public final void check() {
        boolean z;
        Context requireContext = this.MyBillsEntityDataFactory.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        String[] strArr = this.getAuthRequestContext;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            if (!(ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(requireContext, strArr[i]) == 0)) {
                z = false;
                break;
            }
            i++;
        }
        if (z) {
            PermissionCallback permissionCallback = this.BuiltInFictitiousFunctionClassFactory;
            String[] strArr2 = this.getAuthRequestContext;
            ArrayList arrayList = new ArrayList(strArr2.length);
            for (String str : strArr2) {
                arrayList.add(new PermissionReport(str, true, false));
            }
            permissionCallback.onPermissionsChecked(new PermissionResult(arrayList), false);
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.onDisplayConsentDialog(this);
    }

    @Override // com.anggrayudi.storage.permission.PermissionRequest
    public final void continueToPermissionRequest() {
        FragmentActivity requireActivity = this.MyBillsEntityDataFactory.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        for (String str : this.getAuthRequestContext) {
            if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(requireActivity, str) != 0) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.getAuthRequestContext, this.PlaceComponentResult);
                return;
            }
        }
        PermissionCallback permissionCallback = this.BuiltInFictitiousFunctionClassFactory;
        String[] strArr = this.getAuthRequestContext;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            arrayList.add(new PermissionReport(str2, true, false));
        }
        permissionCallback.onPermissionsChecked(new PermissionResult(arrayList), false);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lcom/anggrayudi/storage/permission/FragmentPermissionRequest$Builder;", "", "Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "PlaceComponentResult", "()Lcom/anggrayudi/storage/permission/FragmentPermissionRequest;", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "MyBillsEntityDataFactory", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/core/app/ActivityOptionsCompat;", "Landroidx/core/app/ActivityOptionsCompat;", "", "", "getAuthRequestContext", "Ljava/util/Set;", "p0", "<init>", "(Landroidx/fragment/app/Fragment;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final Fragment KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public PermissionCallback BuiltInFictitiousFunctionClassFactory;
        private ActivityOptionsCompat PlaceComponentResult;
        public Set<String> getAuthRequestContext;

        public Builder(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = fragment;
            this.getAuthRequestContext = SetsKt.emptySet();
        }

        public final FragmentPermissionRequest PlaceComponentResult() {
            Fragment fragment = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Object[] array = this.getAuthRequestContext.toArray(new String[0]);
            if (array != null) {
                ActivityOptionsCompat activityOptionsCompat = this.PlaceComponentResult;
                PermissionCallback permissionCallback = this.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNull(permissionCallback);
                return new FragmentPermissionRequest(fragment, (String[]) array, activityOptionsCompat, permissionCallback, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    public static /* synthetic */ void getAuthRequestContext(FragmentPermissionRequest fragmentPermissionRequest, Map map) {
        Intrinsics.checkNotNullParameter(fragmentPermissionRequest, "");
        Intrinsics.checkNotNullExpressionValue(map, "");
        FragmentActivity requireActivity = fragmentPermissionRequest.MyBillsEntityDataFactory.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
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
            if (((Boolean) entry.getValue()).booleanValue() || ActivityCompat.MyBillsEntityDataFactory(requireActivity, (String) entry.getKey())) {
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
            fragmentPermissionRequest.BuiltInFictitiousFunctionClassFactory.onPermissionsChecked(new PermissionResult(arrayList2), true);
        } else {
            fragmentPermissionRequest.BuiltInFictitiousFunctionClassFactory.onShouldRedirectToSystemSettings(arrayList4);
        }
    }
}
