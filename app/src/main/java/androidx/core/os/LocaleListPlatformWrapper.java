package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class LocaleListPlatformWrapper implements LocaleListInterface {
    private final LocaleList MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocaleListPlatformWrapper(Object obj) {
        this.MyBillsEntityDataFactory = (LocaleList) obj;
    }

    @Override // androidx.core.os.LocaleListInterface
    public final Object getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // androidx.core.os.LocaleListInterface
    public final Locale MyBillsEntityDataFactory(int i) {
        return this.MyBillsEntityDataFactory.get(i);
    }

    public final boolean equals(Object obj) {
        return this.MyBillsEntityDataFactory.equals(((LocaleListInterface) obj).getAuthRequestContext());
    }

    public final int hashCode() {
        return this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        return this.MyBillsEntityDataFactory.toString();
    }

    @Override // androidx.core.os.LocaleListInterface
    public final String PlaceComponentResult() {
        return this.MyBillsEntityDataFactory.toLanguageTags();
    }
}
