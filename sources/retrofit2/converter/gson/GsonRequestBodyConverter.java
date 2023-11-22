package retrofit2.converter.gson;

import android.view.ViewConfiguration;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import o.C;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.ByteString;
import retrofit2.Converter;

/* loaded from: classes6.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static final MediaType BuiltInFictitiousFunctionClassFactory;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static final Charset PlaceComponentResult;
    private static char getErrorConfigVersion;
    private static int lookAheadTest;
    private static char moveToNextValue;
    private static char scheduleImpl;
    private final Gson MyBillsEntityDataFactory;
    private final TypeAdapter<T> getAuthRequestContext;

    static void getAuthRequestContext() {
        scheduleImpl = (char) 41704;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 58293;
        moveToNextValue = (char) 7668;
        getErrorConfigVersion = (char) 46144;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public final /* synthetic */ RequestBody getAuthRequestContext(Object obj) throws IOException {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 41;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        RequestBody BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(obj);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 1;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 != 0 ? '5' : '!') != '!') {
            int i4 = 95 / 0;
            return BuiltInFictitiousFunctionClassFactory2;
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }

    static {
        getAuthRequestContext();
        BuiltInFictitiousFunctionClassFactory = MediaType.get("application/json; charset=UTF-8");
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 5, new char[]{65431, 43810, 60601, 3629, 53709, 53764}, objArr);
        PlaceComponentResult = Charset.forName(((String) objArr[0]).intern());
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 115;
        lookAheadTest = i % 128;
        if ((i % 2 != 0 ? 'T' : ')') != ')') {
            Object obj = null;
            obj.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        try {
            this.MyBillsEntityDataFactory = gson;
            this.getAuthRequestContext = typeAdapter;
        } catch (Exception e) {
            throw e;
        }
    }

    private RequestBody BuiltInFictitiousFunctionClassFactory(T t) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.MyBillsEntityDataFactory.newJsonWriter(new OutputStreamWriter(new Buffer.AnonymousClass1(), PlaceComponentResult));
        this.getAuthRequestContext.write(newJsonWriter, t);
        newJsonWriter.close();
        RequestBody create = RequestBody.create(BuiltInFictitiousFunctionClassFactory, new ByteString(buffer.NetworkUserEntityData$$ExternalSyntheticLambda1()));
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 53;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        return create;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? '\t' : '(') == '\t') {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i2 = 58224;
                int i3 = 0;
                while (true) {
                    if (!(i3 >= 16)) {
                        cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (getErrorConfigVersion ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (moveToNextValue ^ 6353485791441662354L)))));
                        cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (scheduleImpl ^ 6353485791441662354L)))));
                        i2 -= 40503;
                        i3++;
                        int i4 = $10 + 29;
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                    }
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
                int i6 = $11 + 7;
                $10 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
