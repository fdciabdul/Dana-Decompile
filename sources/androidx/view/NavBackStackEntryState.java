package androidx.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.view.Lifecycle;
import androidx.view.NavBackStackEntry;
import androidx.view.SavedStateRegistryController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0010¢\u0006\u0004\b\u001d\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0015\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0019X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016"}, d2 = {"Landroidx/navigation/NavBackStackEntryState;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/content/Context;", "p0", "Landroidx/navigation/NavDestination;", "p1", "Landroidx/lifecycle/Lifecycle$State;", "p2", "Landroidx/navigation/NavControllerViewModel;", "p3", "Landroidx/navigation/NavBackStackEntry;", "PlaceComponentResult", "(Landroid/content/Context;Landroidx/navigation/NavDestination;Landroidx/lifecycle/Lifecycle$State;Landroidx/navigation/NavControllerViewModel;)Landroidx/navigation/NavBackStackEntry;", "Landroid/os/Parcel;", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "Landroid/os/Bundle;", "MyBillsEntityDataFactory", "I", "", "getAuthRequestContext", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Landroidx/navigation/NavBackStackEntry;)V", "(Landroid/os/Parcel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavBackStackEntryState implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Bundle MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Bundle KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final String PlaceComponentResult;
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new Parcelable.Creator<NavBackStackEntryState>() { // from class: androidx.navigation.NavBackStackEntryState$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ NavBackStackEntryState createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            return new NavBackStackEntryState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ NavBackStackEntryState[] newArray(int i) {
            return new NavBackStackEntryState[i];
        }
    };

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public NavBackStackEntryState(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "");
        this.PlaceComponentResult = navBackStackEntry.getErrorConfigVersion;
        this.BuiltInFictitiousFunctionClassFactory = navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
        this.MyBillsEntityDataFactory = navBackStackEntry.getAuthRequestContext;
        Bundle bundle = new Bundle();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bundle;
        Intrinsics.checkNotNullParameter(bundle, "");
        SavedStateRegistryController savedStateRegistryController = navBackStackEntry.initRecordTimeStamp;
        Intrinsics.checkNotNullParameter(bundle, "");
        savedStateRegistryController.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(bundle);
    }

    public NavBackStackEntryState(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        this.PlaceComponentResult = readString;
        this.BuiltInFictitiousFunctionClassFactory = parcel.readInt();
        this.MyBillsEntityDataFactory = parcel.readBundle(getClass().getClassLoader());
        Bundle readBundle = parcel.readBundle(getClass().getClassLoader());
        Intrinsics.checkNotNull(readBundle);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = readBundle;
    }

    public final NavBackStackEntry PlaceComponentResult(Context p0, NavDestination p1, Lifecycle.State p2, NavControllerViewModel p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Bundle bundle = this.MyBillsEntityDataFactory;
        if (bundle != null) {
            bundle.setClassLoader(p0.getClassLoader());
        } else {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        NavBackStackEntry.Companion companion = NavBackStackEntry.INSTANCE;
        return NavBackStackEntry.Companion.BuiltInFictitiousFunctionClassFactory(p0, p1, bundle2, p2, p3, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.PlaceComponentResult);
        p0.writeInt(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeBundle(this.MyBillsEntityDataFactory);
        p0.writeBundle(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
