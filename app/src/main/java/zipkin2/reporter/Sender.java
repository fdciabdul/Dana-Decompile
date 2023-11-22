package zipkin2.reporter;

import java.util.List;
import zipkin2.Call;
import zipkin2.Component;
import zipkin2.codec.Encoding;
import zipkin2.reporter.internal.InternalReporter;

/* loaded from: classes2.dex */
public abstract class Sender extends Component {
    public abstract Encoding KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract Call<Void> MyBillsEntityDataFactory(List<byte[]> list);

    public abstract int PlaceComponentResult(List<byte[]> list);

    static {
        InternalReporter.getAuthRequestContext = new InternalReporter() { // from class: zipkin2.reporter.Sender.1
        };
    }
}
