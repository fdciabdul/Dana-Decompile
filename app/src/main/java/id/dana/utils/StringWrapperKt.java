package id.dana.utils;

import android.content.Context;
import android.content.res.Resources;
import id.dana.utils.StringWrapper;
import id.dana.utils.extension.LanguageExtKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/content/Context;", "Lid/dana/utils/StringWrapper;", "p0", "", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/utils/StringWrapper;)Ljava/lang/String;", "MyBillsEntityDataFactory", "(Lid/dana/utils/StringWrapper;)Lid/dana/utils/StringWrapper;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StringWrapperKt {
    public static final StringWrapper MyBillsEntityDataFactory(StringWrapper stringWrapper) {
        StringWrapper.StringValue stringValue;
        if (stringWrapper == null) {
            StringWrapper.Companion companion = StringWrapper.INSTANCE;
            stringValue = StringWrapper.PlaceComponentResult;
            return stringValue;
        }
        return stringWrapper;
    }

    public static final String getAuthRequestContext(Context context, StringWrapper stringWrapper) {
        String quantityString;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(stringWrapper, "");
        if (stringWrapper instanceof StringWrapper.StringValue) {
            quantityString = ((StringWrapper.StringValue) stringWrapper).PlaceComponentResult;
            if (quantityString == null) {
                return "";
            }
        } else if (stringWrapper instanceof StringWrapper.ResValue) {
            StringWrapper.ResValue resValue = (StringWrapper.ResValue) stringWrapper;
            int i = resValue.PlaceComponentResult;
            List<Object> list = resValue.BuiltInFictitiousFunctionClassFactory;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Object obj : list) {
                if (obj instanceof StringWrapper) {
                    obj = getAuthRequestContext(context, (StringWrapper) obj);
                }
                arrayList.add(obj);
            }
            Object[] array = arrayList.toArray(new Object[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            quantityString = context.getString(i, Arrays.copyOf(array, array.length));
            Intrinsics.checkNotNullExpressionValue(quantityString, "");
        } else if (stringWrapper instanceof StringWrapper.StringLocaleValue) {
            StringWrapper.StringLocaleValue stringLocaleValue = (StringWrapper.StringLocaleValue) stringWrapper;
            if (LanguageExtKt.getAuthRequestContext()) {
                quantityString = stringLocaleValue.getAuthRequestContext;
                if (quantityString == null) {
                    return "";
                }
            } else {
                quantityString = stringLocaleValue.BuiltInFictitiousFunctionClassFactory;
                if (quantityString == null) {
                    return "";
                }
            }
        } else if (!(stringWrapper instanceof StringWrapper.ResValuePlurals)) {
            throw new NoWhenBranchMatchedException();
        } else {
            Resources resources = context.getResources();
            StringWrapper.ResValuePlurals resValuePlurals = (StringWrapper.ResValuePlurals) stringWrapper;
            int i2 = resValuePlurals.getAuthRequestContext;
            int i3 = resValuePlurals.BuiltInFictitiousFunctionClassFactory;
            List<Object> list2 = resValuePlurals.MyBillsEntityDataFactory;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (Object obj2 : list2) {
                if (obj2 instanceof StringWrapper) {
                    obj2 = getAuthRequestContext(context, (StringWrapper) obj2);
                }
                arrayList2.add(obj2);
            }
            Object[] array2 = arrayList2.toArray(new Object[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            quantityString = resources.getQuantityString(i2, i3, Arrays.copyOf(array2, array2.length));
            Intrinsics.checkNotNullExpressionValue(quantityString, "");
        }
        return quantityString;
    }
}
