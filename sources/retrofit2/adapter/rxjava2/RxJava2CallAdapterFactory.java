package retrofit2.adapter.rxjava2;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Utils;

/* loaded from: classes2.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    @Nullable
    private final Scheduler getAuthRequestContext = null;
    private final boolean MyBillsEntityDataFactory = false;

    public static RxJava2CallAdapterFactory KClassImpl$Data$declaredNonStaticMembers$2() {
        return new RxJava2CallAdapterFactory();
    }

    private RxJava2CallAdapterFactory() {
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public final CallAdapter<?, ?> KClassImpl$Data$declaredNonStaticMembers$2(Type type, Annotation[] annotationArr) {
        Type type2;
        boolean z;
        boolean z2;
        Type MyBillsEntityDataFactory;
        Class<?> BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(type);
        if (BuiltInFictitiousFunctionClassFactory == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.getAuthRequestContext, this.MyBillsEntityDataFactory, false, true, false, false, false, true);
        }
        boolean z3 = true;
        boolean z4 = BuiltInFictitiousFunctionClassFactory == Flowable.class;
        boolean z5 = BuiltInFictitiousFunctionClassFactory == Single.class;
        boolean z6 = BuiltInFictitiousFunctionClassFactory == Maybe.class;
        if (BuiltInFictitiousFunctionClassFactory == Observable.class || z4 || z5 || z6) {
            if (!(type instanceof ParameterizedType)) {
                String str = !z4 ? !z5 ? z6 ? "Maybe" : "Observable" : "Single" : "Flowable";
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" return type must be parameterized as ");
                sb.append(str);
                sb.append("<Foo> or ");
                sb.append(str);
                sb.append("<? extends Foo>");
                throw new IllegalStateException(sb.toString());
            }
            Type MyBillsEntityDataFactory2 = Utils.MyBillsEntityDataFactory(0, (ParameterizedType) type);
            Class<?> BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory2);
            if (BuiltInFictitiousFunctionClassFactory2 == Response.class) {
                if (!(MyBillsEntityDataFactory2 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                }
                MyBillsEntityDataFactory = Utils.MyBillsEntityDataFactory(0, (ParameterizedType) MyBillsEntityDataFactory2);
                z3 = false;
            } else if (BuiltInFictitiousFunctionClassFactory2 == Result.class) {
                if (!(MyBillsEntityDataFactory2 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
                MyBillsEntityDataFactory = Utils.MyBillsEntityDataFactory(0, (ParameterizedType) MyBillsEntityDataFactory2);
            } else {
                type2 = MyBillsEntityDataFactory2;
                z = false;
                z2 = true;
                return new RxJava2CallAdapter(type2, this.getAuthRequestContext, this.MyBillsEntityDataFactory, z, z2, z4, z5, z6, false);
            }
            type2 = MyBillsEntityDataFactory;
            z = z3;
            z2 = false;
            return new RxJava2CallAdapter(type2, this.getAuthRequestContext, this.MyBillsEntityDataFactory, z, z2, z4, z5, z6, false);
        }
        return null;
    }
}
