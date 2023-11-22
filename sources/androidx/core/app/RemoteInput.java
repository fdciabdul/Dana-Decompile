package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public final class RemoteInput {
    final Bundle BuiltInFictitiousFunctionClassFactory;
    final Set<String> KClassImpl$Data$declaredNonStaticMembers$2;
    final int MyBillsEntityDataFactory;
    final CharSequence[] PlaceComponentResult;
    final CharSequence getAuthRequestContext;
    private final boolean getErrorConfigVersion;
    final String moveToNextValue;

    /* loaded from: classes6.dex */
    public static final class Builder {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Source {
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        CharSequence[] charSequenceArr;
        Set<String> set;
        return (KClassImpl$Data$declaredNonStaticMembers$2() || ((charSequenceArr = this.PlaceComponentResult) != null && charSequenceArr.length != 0) || (set = this.KClassImpl$Data$declaredNonStaticMembers$2) == null || set.isEmpty()) ? false : true;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static android.app.RemoteInput[] KClassImpl$Data$declaredNonStaticMembers$2(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            remoteInputArr2[i] = Api20Impl.MyBillsEntityDataFactory(remoteInputArr[i]);
        }
        return remoteInputArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        static RemoteInput.Builder BuiltInFictitiousFunctionClassFactory(RemoteInput.Builder builder, String str, boolean z) {
            return builder.setAllowDataType(str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api20Impl {
        private Api20Impl() {
        }

        public static android.app.RemoteInput MyBillsEntityDataFactory(RemoteInput remoteInput) {
            Set<String> set;
            RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.moveToNextValue).setLabel(remoteInput.getAuthRequestContext).setChoices(remoteInput.PlaceComponentResult).setAllowFreeFormInput(remoteInput.KClassImpl$Data$declaredNonStaticMembers$2()).addExtras(remoteInput.BuiltInFictitiousFunctionClassFactory);
            if (Build.VERSION.SDK_INT >= 26 && (set = remoteInput.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    Api26Impl.BuiltInFictitiousFunctionClassFactory(addExtras, it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.getAuthRequestContext(addExtras, remoteInput.MyBillsEntityDataFactory);
            }
            return addExtras.build();
        }
    }

    /* loaded from: classes6.dex */
    static class Api16Impl {
        private Api16Impl() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        static RemoteInput.Builder getAuthRequestContext(RemoteInput.Builder builder, int i) {
            return builder.setEditChoicesBeforeSending(i);
        }
    }

    /* loaded from: classes6.dex */
    static class Api28Impl {
        private Api28Impl() {
        }
    }
}
