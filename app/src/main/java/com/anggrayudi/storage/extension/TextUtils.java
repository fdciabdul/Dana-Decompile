package com.anggrayudi.storage.extension;

import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.file.DocumentFileCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0011\u0010\u0006\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a!\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\u0003\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\n\u0010\u0007"}, d2 = {"", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)Z", "MyBillsEntityDataFactory", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "PlaceComponentResult", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class TextUtils {
    public static final String getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        DocumentFileCompat documentFileCompat = DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2;
        return KClassImpl$Data$declaredNonStaticMembers$2(DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2(str));
    }

    public static final String BuiltInFictitiousFunctionClassFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.trim(str, '/');
    }

    public static final String BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
        String str4;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        String str5 = str;
        do {
            str5 = StringsKt.replace$default(str5, str2, str3, false, 4, (Object) null);
            str4 = str5;
            if (!(str4.length() > 0)) {
                break;
            }
        } while (StringsKt.contains$default((CharSequence) str4, (CharSequence) str2, false, 2, (Object) null));
        return str5;
    }

    public static final boolean MyBillsEntityDataFactory(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        List<String> split$default = StringsKt.split$default((CharSequence) str2, new char[]{'/'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str3 : split$default) {
            Intrinsics.checkNotNullParameter(str3, "");
            arrayList.add(StringsKt.trim(str3, '/'));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        List<String> split$default2 = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default2, 10));
        for (String str4 : split$default2) {
            Intrinsics.checkNotNullParameter(str4, "");
            arrayList4.add(StringsKt.trim(str4, '/'));
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList4) {
            if (((String) obj2).length() > 0) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = arrayList5;
        return arrayList3.size() <= arrayList6.size() && Intrinsics.areEqual(CollectionsKt.take(arrayList6, arrayList3.size()), arrayList3);
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        List<String> split$default = StringsKt.split$default((CharSequence) str2, new char[]{'/'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str3 : split$default) {
            Intrinsics.checkNotNullParameter(str3, "");
            arrayList.add(StringsKt.trim(str3, '/'));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        List<String> split$default2 = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default2, 10));
        for (String str4 : split$default2) {
            Intrinsics.checkNotNullParameter(str4, "");
            arrayList4.add(StringsKt.trim(str4, '/'));
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList4) {
            if (((String) obj2).length() > 0) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = arrayList5;
        return arrayList6.size() > arrayList3.size() && Intrinsics.areEqual(CollectionsKt.take(arrayList6, arrayList3.size()), arrayList3);
    }

    public static final String PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        List<String> split$default = StringsKt.split$default((CharSequence) str, new char[]{'/'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str2 : split$default) {
            Intrinsics.checkNotNullParameter(str2, "");
            arrayList.add(StringsKt.trim(str2, '/'));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return "";
        }
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.take(arrayList3, arrayList3.size() - 1), "/", "/", null, 0, null, null, 60, null);
        SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
        return (Intrinsics.areEqual(joinToString$default, SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2()) || new Regex("/storage/[A-Z0-9]{4}-[A-Z0-9]{4}").matches(joinToString$default)) ? "" : joinToString$default;
    }

    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = str;
        int length = str2.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            char charAt = str2.charAt(!z ? i : length);
            boolean z2 = Intrinsics.compare((int) charAt, 32) <= 0 || charAt == '/';
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return StringsKt.trimEnd(str2.subSequence(i, length + 1).toString(), '.');
    }
}
