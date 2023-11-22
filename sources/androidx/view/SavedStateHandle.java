package androidx.view;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleKt;
import androidx.view.SavedStateRegistry;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u001f\b\u0016\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\t\b\u0016¢\u0006\u0004\b\u0011\u0010\u0013R(\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0006"}, d2 = {"Landroidx/lifecycle/SavedStateHandle;", "", "", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "PlaceComponentResult", "Ljava/util/Map;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "lookAheadTest", "getAuthRequestContext", "", "p0", "<init>", "(Ljava/util/Map;)V", "()V", "Companion", "SavingStateLiveData"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SavedStateHandle {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Class<? extends Object>[] getAuthRequestContext;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Map<String, SavingStateLiveData<?>> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final SavedStateRegistry.SavedStateProvider PlaceComponentResult;
    private final Map<String, Object> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Map<String, MutableStateFlow<Object>> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Map<String, SavedStateRegistry.SavedStateProvider> getAuthRequestContext;

    public SavedStateHandle(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.MyBillsEntityDataFactory = linkedHashMap;
        this.getAuthRequestContext = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = new LinkedHashMap();
        this.PlaceComponentResult = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.SavedStateHandle$$ExternalSyntheticLambda0
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
                return SavedStateHandle.BuiltInFictitiousFunctionClassFactory(SavedStateHandle.this);
            }
        };
        linkedHashMap.putAll(map);
    }

    public SavedStateHandle() {
        this.MyBillsEntityDataFactory = new LinkedHashMap();
        this.getAuthRequestContext = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = new LinkedHashMap();
        this.PlaceComponentResult = new SavedStateRegistry.SavedStateProvider() { // from class: androidx.lifecycle.SavedStateHandle$$ExternalSyntheticLambda0
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle KClassImpl$Data$declaredNonStaticMembers$2() {
                return SavedStateHandle.BuiltInFictitiousFunctionClassFactory(SavedStateHandle.this);
            }
        };
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "p0", "", "PlaceComponentResult", "(Ljava/lang/Object;)V", "Landroidx/lifecycle/SavedStateHandle;", "Landroidx/lifecycle/SavedStateHandle;", "MyBillsEntityDataFactory", "", "lookAheadTest", "Ljava/lang/String;", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        private SavedStateHandle MyBillsEntityDataFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        private String getAuthRequestContext;

        @Override // androidx.view.MutableLiveData, androidx.view.LiveData
        public final void PlaceComponentResult(T p0) {
            SavedStateHandle savedStateHandle = this.MyBillsEntityDataFactory;
            if (savedStateHandle != null) {
                savedStateHandle.MyBillsEntityDataFactory.put(this.getAuthRequestContext, p0);
                MutableStateFlow mutableStateFlow = (MutableStateFlow) savedStateHandle.BuiltInFictitiousFunctionClassFactory.get(this.getAuthRequestContext);
                if (mutableStateFlow != null) {
                    mutableStateFlow.setValue(p0);
                }
            }
            super.PlaceComponentResult((SavingStateLiveData<T>) p0);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\t\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "Landroid/os/Bundle;", "p0", "p1", "Landroidx/lifecycle/SavedStateHandle;", "MyBillsEntityDataFactory", "(Landroid/os/Bundle;Landroid/os/Bundle;)Landroidx/lifecycle/SavedStateHandle;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;)Z", "", "Ljava/lang/Class;", "getAuthRequestContext", "[Ljava/lang/Class;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static SavedStateHandle MyBillsEntityDataFactory(Bundle p0, Bundle p1) {
            if (p0 == null) {
                if (p1 == null) {
                    return new SavedStateHandle();
                }
                HashMap hashMap = new HashMap();
                for (String str : p1.keySet()) {
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    hashMap.put(str, p1.get(str));
                }
                return new SavedStateHandle(hashMap);
            }
            ArrayList parcelableArrayList = p0.getParcelableArrayList(UserMetadata.KEYDATA_FILENAME);
            ArrayList parcelableArrayList2 = p0.getParcelableArrayList("values");
            if (!((parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) ? false : true)) {
                throw new IllegalStateException("Invalid bundle passed as restored state".toString());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i = 0; i < size; i++) {
                Object obj = parcelableArrayList.get(i);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
            }
            return new SavedStateHandle(linkedHashMap);
        }

        public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Object p0) {
            if (p0 == null) {
                return true;
            }
            for (Class cls : SavedStateHandle.getAuthRequestContext) {
                Intrinsics.checkNotNull(cls);
                if (cls.isInstance(p0)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        Class<? extends Object>[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        clsArr[4] = Integer.TYPE;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        clsArr[27] = Build.VERSION.SDK_INT >= 21 ? Size.class : Integer.TYPE;
        clsArr[28] = Build.VERSION.SDK_INT >= 21 ? SizeF.class : Integer.TYPE;
        getAuthRequestContext = clsArr;
    }

    public static /* synthetic */ Bundle BuiltInFictitiousFunctionClassFactory(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "");
        for (Map.Entry entry : MapsKt.toMap(savedStateHandle.getAuthRequestContext).entrySet()) {
            String str = (String) entry.getKey();
            Bundle KClassImpl$Data$declaredNonStaticMembers$2 = ((SavedStateRegistry.SavedStateProvider) entry.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullParameter(str, "");
            if (!Companion.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Can't put value with type ");
                Intrinsics.checkNotNull(KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(KClassImpl$Data$declaredNonStaticMembers$2.getClass());
                sb.append(" into saved state");
                throw new IllegalArgumentException(sb.toString());
            }
            SavingStateLiveData<?> savingStateLiveData = savedStateHandle.KClassImpl$Data$declaredNonStaticMembers$2.get(str);
            SavingStateLiveData<?> savingStateLiveData2 = savingStateLiveData instanceof MutableLiveData ? savingStateLiveData : null;
            if (savingStateLiveData2 != null) {
                savingStateLiveData2.PlaceComponentResult((SavingStateLiveData<?>) KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                savedStateHandle.MyBillsEntityDataFactory.put(str, KClassImpl$Data$declaredNonStaticMembers$2);
            }
            MutableStateFlow<Object> mutableStateFlow = savedStateHandle.BuiltInFictitiousFunctionClassFactory.get(str);
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(KClassImpl$Data$declaredNonStaticMembers$2);
            }
        }
        Set<String> keySet = savedStateHandle.MyBillsEntityDataFactory.keySet();
        ArrayList arrayList = new ArrayList(keySet.size());
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (String str2 : keySet) {
            arrayList.add(str2);
            arrayList2.add(savedStateHandle.MyBillsEntityDataFactory.get(str2));
        }
        return BundleKt.PlaceComponentResult(TuplesKt.to(UserMetadata.KEYDATA_FILENAME, arrayList), TuplesKt.to("values", arrayList2));
    }
}
