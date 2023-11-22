package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public abstract class ServiceMethod<T> {
    @Nullable
    public abstract T PlaceComponentResult(Object[] objArr);

    public static <T> ServiceMethod<T> KClassImpl$Data$declaredNonStaticMembers$2(Retrofit retrofit, Method method) {
        RequestFactory KClassImpl$Data$declaredNonStaticMembers$2 = RequestFactory.KClassImpl$Data$declaredNonStaticMembers$2(retrofit, method);
        Type genericReturnType = method.getGenericReturnType();
        if (Utils.MyBillsEntityDataFactory(genericReturnType)) {
            throw Utils.BuiltInFictitiousFunctionClassFactory(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType == Void.TYPE) {
            throw Utils.BuiltInFictitiousFunctionClassFactory(method, "Service methods cannot return void.", new Object[0]);
        }
        return HttpServiceMethod.MyBillsEntityDataFactory(retrofit, method, KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
