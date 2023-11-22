package id.dana.mybills.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\bQ\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\bB\b\u0086\b\u0018\u0000 Ë\u00012\u00020\u0001:\u0002Ë\u0001B\u0085\u0005\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010E\u001a\u00020\u0015\u0012\b\b\u0002\u0010F\u001a\u00020\u0015\u0012\b\b\u0002\u0010G\u001a\u00020\u0015\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010g\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010*\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\bJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010\bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0010\u0010\"\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b\"\u0010\u0017J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0004J\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u0004J\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u0004J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u0004J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\u0004J\u0018\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010*HÆ\u0003¢\u0006\u0004\b+\u0010,J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u0004J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u0004J\u0010\u0010/\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b/\u0010\u0017J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010\u0004J\u0012\u00101\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b1\u0010\u0004J\u0012\u00102\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b2\u0010\u0004J\u0012\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b3\u0010\u0004J\u0012\u00104\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b4\u0010\u0017J\u0012\u00105\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b5\u0010\u0017J\u0012\u00106\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b6\u0010\u0004J\u0012\u00107\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b7\u0010\u0004J\u0012\u00108\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b8\u0010\u0004J\u0012\u00109\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b9\u0010\u0004J\u0010\u0010:\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b:\u0010\u0017J\u0012\u0010;\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b;\u0010\u0017J\u0012\u0010<\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b<\u0010\u0004J\u0012\u0010=\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b=\u0010\u0004J\u0012\u0010>\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b>\u0010\u0004J\u0012\u0010?\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b?\u0010\u0004J\u0012\u0010@\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b@\u0010\u0004J\u0012\u0010A\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bA\u0010\u0004J\u0012\u0010B\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bB\u0010\u0004J\u008c\u0005\u0010x\u001a\u00020\u00002\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010E\u001a\u00020\u00152\b\b\u0002\u0010F\u001a\u00020\u00152\b\b\u0002\u0010G\u001a\u00020\u00152\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010g\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010*2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\bx\u0010yJ\u0010\u0010z\u001a\u00020\tHÖ\u0001¢\u0006\u0004\bz\u0010{J\u001a\u0010~\u001a\u00020\f2\b\u0010}\u001a\u0004\u0018\u00010|HÖ\u0003¢\u0006\u0004\b~\u0010\u007fJ\u000f\u0010\u0080\u0001\u001a\u00020\u0015¢\u0006\u0005\b\u0080\u0001\u0010\u0017J\u0012\u0010\u0081\u0001\u001a\u00020\tHÖ\u0001¢\u0006\u0005\b\u0081\u0001\u0010{J\u0010\u0010\u0082\u0001\u001a\u00020\f¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0010\u0010\u0084\u0001\u001a\u00020\f¢\u0006\u0006\b\u0084\u0001\u0010\u0083\u0001J\u0012\u0010\u0085\u0001\u001a\u00020\u0002HÖ\u0001¢\u0006\u0005\b\u0085\u0001\u0010\u0004J'\u0010\u008a\u0001\u001a\u00030\u0089\u00012\b\u0010\u0087\u0001\u001a\u00030\u0086\u00012\u0007\u0010\u0088\u0001\u001a\u00020\tHÖ\u0001¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010S\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\u000e\n\u0005\bS\u0010\u008c\u0001\u001a\u0005\b\u008d\u0001\u0010\u0004R\u001c\u0010E\u001a\u00020\u00158\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bE\u0010\u008e\u0001\u001a\u0005\b\u008f\u0001\u0010\u0017R\u001e\u0010W\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bW\u0010\u008c\u0001\u001a\u0005\b\u0090\u0001\u0010\u0004R\u001c\u0010F\u001a\u00020\u00158\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bF\u0010\u008e\u0001\u001a\u0005\b\u0091\u0001\u0010\u0017R\u001e\u0010H\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bH\u0010\u008c\u0001\u001a\u0005\b\u0092\u0001\u0010\u0004R(\u0010C\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bC\u0010\u008c\u0001\u001a\u0005\b\u0093\u0001\u0010\u0004\"\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001e\u0010`\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b`\u0010\u008c\u0001\u001a\u0005\b\u0096\u0001\u0010\u0004R\u001e\u0010o\u001a\u0004\u0018\u00010\u00158\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bo\u0010\u008e\u0001\u001a\u0005\b\u0097\u0001\u0010\u0017R\u001e\u0010^\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b^\u0010\u008c\u0001\u001a\u0005\b\u0098\u0001\u0010\u0004R\u001e\u0010I\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bI\u0010\u008c\u0001\u001a\u0005\b\u0099\u0001\u0010\u0004R\u001e\u0010J\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bJ\u0010\u008c\u0001\u001a\u0005\b\u009a\u0001\u0010\u0004R\u001e\u0010K\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bK\u0010\u008c\u0001\u001a\u0005\b\u009b\u0001\u0010\u0004R\u001e\u0010n\u001a\u0004\u0018\u00010\u00158\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bn\u0010\u008e\u0001\u001a\u0005\b\u009c\u0001\u0010\u0017R\u001e\u0010L\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bL\u0010\u008c\u0001\u001a\u0005\b\u009d\u0001\u0010\u0004R\u001e\u0010M\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bM\u0010\u009e\u0001\u001a\u0005\b\u009f\u0001\u0010\bR\u001e\u0010]\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b]\u0010\u009e\u0001\u001a\u0005\b \u0001\u0010\bR\u001e\u0010m\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bm\u0010\u008c\u0001\u001a\u0005\b¡\u0001\u0010\u0004R\u001e\u0010Q\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bQ\u0010\u008c\u0001\u001a\u0005\b¢\u0001\u0010\u0004R\u001e\u0010P\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bP\u0010\u008c\u0001\u001a\u0005\b£\u0001\u0010\u0004R\u001e\u0010Y\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bY\u0010\u008c\u0001\u001a\u0005\b¤\u0001\u0010\u0004R\u001c\u0010G\u001a\u00020\u00158\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bG\u0010\u008e\u0001\u001a\u0005\b¥\u0001\u0010\u0017R\u001e\u0010c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bc\u0010\u008c\u0001\u001a\u0005\b¦\u0001\u0010\u0004R\u001e\u0010w\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bw\u0010\u008c\u0001\u001a\u0005\b§\u0001\u0010\u0004R\u001e\u0010v\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bv\u0010\u008c\u0001\u001a\u0005\b¨\u0001\u0010\u0004R\u001e\u0010u\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bu\u0010\u008c\u0001\u001a\u0005\b©\u0001\u0010\u0004R\u001e\u0010p\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bp\u0010\u008c\u0001\u001a\u0005\bª\u0001\u0010\u0004R\u001e\u0010U\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bU\u0010\u008c\u0001\u001a\u0005\b«\u0001\u0010\u0004R\u001e\u0010b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bb\u0010\u008c\u0001\u001a\u0005\b¬\u0001\u0010\u0004R\u001e\u0010X\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bX\u0010\u008c\u0001\u001a\u0005\b\u00ad\u0001\u0010\u0004R\u001e\u0010a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\ba\u0010\u008c\u0001\u001a\u0005\b®\u0001\u0010\u0004R\u001e\u0010e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\be\u0010\u008c\u0001\u001a\u0005\b¯\u0001\u0010\u0004R\u001e\u0010q\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bq\u0010\u008c\u0001\u001a\u0005\b°\u0001\u0010\u0004R\u001e\u0010_\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b_\u0010\u008c\u0001\u001a\u0005\b±\u0001\u0010\u0004R\u001e\u0010O\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bO\u0010²\u0001\u001a\u0005\b³\u0001\u0010\u000eR\u001e\u0010N\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bN\u0010´\u0001\u001a\u0005\bµ\u0001\u0010\u000bR\u001e\u0010f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bf\u0010\u008c\u0001\u001a\u0005\b¶\u0001\u0010\u0004R$\u0010g\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010*8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bg\u0010·\u0001\u001a\u0005\b¸\u0001\u0010,R\u001e\u0010R\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bR\u0010\u008c\u0001\u001a\u0005\b¹\u0001\u0010\u0004R\u001e\u0010h\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bh\u0010\u008c\u0001\u001a\u0005\bº\u0001\u0010\u0004R\u001e\u0010t\u001a\u0004\u0018\u00010\u00158\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bt\u0010\u008e\u0001\u001a\u0005\b»\u0001\u0010\u0017R\u001e\u0010r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\br\u0010\u008c\u0001\u001a\u0005\b¼\u0001\u0010\u0004R\u001e\u0010s\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bs\u0010\u008c\u0001\u001a\u0005\b½\u0001\u0010\u0004R\u001e\u0010i\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bi\u0010\u008c\u0001\u001a\u0005\b¾\u0001\u0010\u0004R\u001e\u0010j\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bj\u0010\u008c\u0001\u001a\u0005\b¿\u0001\u0010\u0004R\u001e\u0010T\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bT\u0010\u008c\u0001\u001a\u0005\bÀ\u0001\u0010\u0004R\u001e\u0010\\\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b\\\u0010\u009e\u0001\u001a\u0005\bÁ\u0001\u0010\bR\u001e\u0010V\u001a\u0004\u0018\u00010\u00158\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bV\u0010\u008e\u0001\u001a\u0005\bÂ\u0001\u0010\u0017R\u001e\u0010D\u001a\u0004\u0018\u00010\u00158\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bD\u0010\u008e\u0001\u001a\u0005\bÃ\u0001\u0010\u0017R\u001e\u0010Z\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bZ\u0010\u008c\u0001\u001a\u0005\bÄ\u0001\u0010\u0004R\u001e\u0010k\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bk\u0010\u008c\u0001\u001a\u0005\bÅ\u0001\u0010\u0004R\u001e\u0010[\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b[\u0010\u008c\u0001\u001a\u0005\bÆ\u0001\u0010\u0004R\u001e\u0010l\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bl\u0010\u008c\u0001\u001a\u0005\bÇ\u0001\u0010\u0004R\u001e\u0010d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bd\u0010\u008c\u0001\u001a\u0005\bÈ\u0001\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/BizProductDestination;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component10", "", "component11", "()Ljava/lang/Long;", "", "component12", "()Ljava/lang/Integer;", "", "component13", "()Ljava/lang/Boolean;", "component14", "component15", "component16", "component17", "component18", "component19", "Lid/dana/domain/nearbyme/model/MoneyView;", "component2", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "", "component37", "()Ljava/util/List;", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component6", "component7", "component8", "component9", "billId", "totalAmount", "adminFee", "baseAmount", "fineAmount", "billCycle", "customerName", "customerType", "dateTime", "description", "dueDate", "paymentCount", "payPartialSupport", "familyNumber", "familyCount", "policeNumber", "address", "standMeter", "load", "tagNonAir", "amount", "meterNumber", "fare", "totalEnergy", "type", "startDate", "endDate", "customerIdNumber", "owned", H5GetLogInfoBridge.RESULT_BRAND, H5GetLogInfoBridge.RESULT_MODEL, "machineNumber", "frameNumber", "yearOfProduction", "newTaxExpirationDate", "paymentReference", "period", "providerName", "standBegin", "standFinal", "totalPeriod", "usage", "extendInfo", "debtAmount", "currentNeedRepayAmount", "issueDate", "overdueDay", "repaymentDate", "repaymentMonth", "repaidAmount", "inquiryStatus", "inquiryMessage", "inquiryCode", "copy", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/domain/model/BizProductDestination;", "describeContents", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "getUsageMoneyView", "hashCode", "isInquiryGot25And26", "()Z", "isInquirySuccess", "toString", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getAddress", "Lid/dana/domain/nearbyme/model/MoneyView;", "getAdminFee", "getAmount", "getBaseAmount", "getBillCycle", "getBillId", "setBillId", "(Ljava/lang/String;)V", "getBrand", "getCurrentNeedRepayAmount", "getCustomerIdNumber", "getCustomerName", "getCustomerType", "getDateTime", "getDebtAmount", "getDescription", "Ljava/lang/Long;", "getDueDate", "getEndDate", "getExtendInfo", "getFamilyCount", "getFamilyNumber", "getFare", "getFineAmount", "getFrameNumber", "getInquiryCode", "getInquiryMessage", "getInquiryStatus", "getIssueDate", "getLoad", "getMachineNumber", "getMeterNumber", "getModel", "getNewTaxExpirationDate", "getOverdueDay", "getOwned", "Ljava/lang/Boolean;", "getPayPartialSupport", "Ljava/lang/Integer;", "getPaymentCount", "getPaymentReference", "Ljava/util/List;", "getPeriod", "getPoliceNumber", "getProviderName", "getRepaidAmount", "getRepaymentDate", "getRepaymentMonth", "getStandBegin", "getStandFinal", "getStandMeter", "getStartDate", "getTagNonAir", "getTotalAmount", "getTotalEnergy", "getTotalPeriod", "getType", "getUsage", "getYearOfProduction", "<init>", "(Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BizProductDestination implements Parcelable {
    public static final String INQUIRY_FAILED = "FAILED";
    public static final String INQUIRY_SUCCESS = "SUCCESS";
    private final String address;
    private final MoneyView adminFee;
    private final String amount;
    private final MoneyView baseAmount;
    private final String billCycle;
    private String billId;
    private final String brand;
    private final MoneyView currentNeedRepayAmount;
    private final String customerIdNumber;
    private final String customerName;
    private final String customerType;
    private final String dateTime;
    private final MoneyView debtAmount;
    private final String description;
    private final Long dueDate;
    private final Long endDate;
    private final String extendInfo;
    private final String familyCount;
    private final String familyNumber;
    private final String fare;
    private final MoneyView fineAmount;
    private final String frameNumber;
    private final String inquiryCode;
    private final String inquiryMessage;
    private final String inquiryStatus;
    private final String issueDate;
    private final String load;
    private final String machineNumber;
    private final String meterNumber;
    private final String model;
    private final String newTaxExpirationDate;
    private final String overdueDay;
    private final String owned;
    private final Boolean payPartialSupport;
    private final Integer paymentCount;
    private final String paymentReference;
    private final List<Long> period;
    private final String policeNumber;
    private final String providerName;
    private final MoneyView repaidAmount;
    private final String repaymentDate;
    private final String repaymentMonth;
    private final String standBegin;
    private final String standFinal;
    private final String standMeter;
    private final Long startDate;
    private final MoneyView tagNonAir;
    private final MoneyView totalAmount;
    private final String totalEnergy;
    private final String totalPeriod;
    private final String type;
    private final String usage;
    private final String yearOfProduction;
    public static final Parcelable.Creator<BizProductDestination> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<BizProductDestination> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BizProductDestination createFromParcel(Parcel parcel) {
            Boolean valueOf;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            MoneyView moneyView = (MoneyView) parcel.readSerializable();
            MoneyView moneyView2 = (MoneyView) parcel.readSerializable();
            MoneyView moneyView3 = (MoneyView) parcel.readSerializable();
            MoneyView moneyView4 = (MoneyView) parcel.readSerializable();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            Long valueOf2 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            MoneyView moneyView5 = (MoneyView) parcel.readSerializable();
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            String readString16 = parcel.readString();
            String readString17 = parcel.readString();
            Long valueOf4 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            Long valueOf5 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            String readString18 = parcel.readString();
            String readString19 = parcel.readString();
            String readString20 = parcel.readString();
            String readString21 = parcel.readString();
            String readString22 = parcel.readString();
            String readString23 = parcel.readString();
            String readString24 = parcel.readString();
            String readString25 = parcel.readString();
            String readString26 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                int i = 0;
                while (i != readInt) {
                    arrayList.add(Long.valueOf(parcel.readLong()));
                    i++;
                    readInt = readInt;
                }
            } else {
                arrayList = null;
            }
            return new BizProductDestination(readString, moneyView, moneyView2, moneyView3, moneyView4, readString2, readString3, readString4, readString5, readString6, valueOf2, valueOf3, valueOf, readString7, readString8, readString9, readString10, readString11, readString12, moneyView5, readString13, readString14, readString15, readString16, readString17, valueOf4, valueOf5, readString18, readString19, readString20, readString21, readString22, readString23, readString24, readString25, readString26, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (MoneyView) parcel.readSerializable(), (MoneyView) parcel.readSerializable(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (MoneyView) parcel.readSerializable(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final BizProductDestination[] newArray(int i) {
            return new BizProductDestination[i];
        }
    }

    public BizProductDestination() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2097151, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBillId() {
        return this.billId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component11  reason: from getter */
    public final Long getDueDate() {
        return this.dueDate;
    }

    /* renamed from: component12  reason: from getter */
    public final Integer getPaymentCount() {
        return this.paymentCount;
    }

    /* renamed from: component13  reason: from getter */
    public final Boolean getPayPartialSupport() {
        return this.payPartialSupport;
    }

    /* renamed from: component14  reason: from getter */
    public final String getFamilyNumber() {
        return this.familyNumber;
    }

    /* renamed from: component15  reason: from getter */
    public final String getFamilyCount() {
        return this.familyCount;
    }

    /* renamed from: component16  reason: from getter */
    public final String getPoliceNumber() {
        return this.policeNumber;
    }

    /* renamed from: component17  reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component18  reason: from getter */
    public final String getStandMeter() {
        return this.standMeter;
    }

    /* renamed from: component19  reason: from getter */
    public final String getLoad() {
        return this.load;
    }

    /* renamed from: component2  reason: from getter */
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component20  reason: from getter */
    public final MoneyView getTagNonAir() {
        return this.tagNonAir;
    }

    /* renamed from: component21  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component22  reason: from getter */
    public final String getMeterNumber() {
        return this.meterNumber;
    }

    /* renamed from: component23  reason: from getter */
    public final String getFare() {
        return this.fare;
    }

    /* renamed from: component24  reason: from getter */
    public final String getTotalEnergy() {
        return this.totalEnergy;
    }

    /* renamed from: component25  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component26  reason: from getter */
    public final Long getStartDate() {
        return this.startDate;
    }

    /* renamed from: component27  reason: from getter */
    public final Long getEndDate() {
        return this.endDate;
    }

    /* renamed from: component28  reason: from getter */
    public final String getCustomerIdNumber() {
        return this.customerIdNumber;
    }

    /* renamed from: component29  reason: from getter */
    public final String getOwned() {
        return this.owned;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyView getAdminFee() {
        return this.adminFee;
    }

    /* renamed from: component30  reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* renamed from: component31  reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component32  reason: from getter */
    public final String getMachineNumber() {
        return this.machineNumber;
    }

    /* renamed from: component33  reason: from getter */
    public final String getFrameNumber() {
        return this.frameNumber;
    }

    /* renamed from: component34  reason: from getter */
    public final String getYearOfProduction() {
        return this.yearOfProduction;
    }

    /* renamed from: component35  reason: from getter */
    public final String getNewTaxExpirationDate() {
        return this.newTaxExpirationDate;
    }

    /* renamed from: component36  reason: from getter */
    public final String getPaymentReference() {
        return this.paymentReference;
    }

    public final List<Long> component37() {
        return this.period;
    }

    /* renamed from: component38  reason: from getter */
    public final String getProviderName() {
        return this.providerName;
    }

    /* renamed from: component39  reason: from getter */
    public final String getStandBegin() {
        return this.standBegin;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyView getBaseAmount() {
        return this.baseAmount;
    }

    /* renamed from: component40  reason: from getter */
    public final String getStandFinal() {
        return this.standFinal;
    }

    /* renamed from: component41  reason: from getter */
    public final String getTotalPeriod() {
        return this.totalPeriod;
    }

    /* renamed from: component42  reason: from getter */
    public final String getUsage() {
        return this.usage;
    }

    /* renamed from: component43  reason: from getter */
    public final String getExtendInfo() {
        return this.extendInfo;
    }

    /* renamed from: component44  reason: from getter */
    public final MoneyView getDebtAmount() {
        return this.debtAmount;
    }

    /* renamed from: component45  reason: from getter */
    public final MoneyView getCurrentNeedRepayAmount() {
        return this.currentNeedRepayAmount;
    }

    /* renamed from: component46  reason: from getter */
    public final String getIssueDate() {
        return this.issueDate;
    }

    /* renamed from: component47  reason: from getter */
    public final String getOverdueDay() {
        return this.overdueDay;
    }

    /* renamed from: component48  reason: from getter */
    public final String getRepaymentDate() {
        return this.repaymentDate;
    }

    /* renamed from: component49  reason: from getter */
    public final String getRepaymentMonth() {
        return this.repaymentMonth;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getFineAmount() {
        return this.fineAmount;
    }

    /* renamed from: component50  reason: from getter */
    public final MoneyView getRepaidAmount() {
        return this.repaidAmount;
    }

    /* renamed from: component51  reason: from getter */
    public final String getInquiryStatus() {
        return this.inquiryStatus;
    }

    /* renamed from: component52  reason: from getter */
    public final String getInquiryMessage() {
        return this.inquiryMessage;
    }

    /* renamed from: component53  reason: from getter */
    public final String getInquiryCode() {
        return this.inquiryCode;
    }

    /* renamed from: component6  reason: from getter */
    public final String getBillCycle() {
        return this.billCycle;
    }

    /* renamed from: component7  reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCustomerType() {
        return this.customerType;
    }

    /* renamed from: component9  reason: from getter */
    public final String getDateTime() {
        return this.dateTime;
    }

    public final BizProductDestination copy(String billId, MoneyView totalAmount, MoneyView adminFee, MoneyView baseAmount, MoneyView fineAmount, String billCycle, String customerName, String customerType, String dateTime, String description, Long dueDate, Integer paymentCount, Boolean payPartialSupport, String familyNumber, String familyCount, String policeNumber, String address, String standMeter, String load, MoneyView tagNonAir, String amount, String meterNumber, String fare, String totalEnergy, String type, Long startDate, Long endDate, String customerIdNumber, String owned, String brand, String model, String machineNumber, String frameNumber, String yearOfProduction, String newTaxExpirationDate, String paymentReference, List<Long> period, String providerName, String standBegin, String standFinal, String totalPeriod, String usage, String extendInfo, MoneyView debtAmount, MoneyView currentNeedRepayAmount, String issueDate, String overdueDay, String repaymentDate, String repaymentMonth, MoneyView repaidAmount, String inquiryStatus, String inquiryMessage, String inquiryCode) {
        Intrinsics.checkNotNullParameter(adminFee, "");
        Intrinsics.checkNotNullParameter(baseAmount, "");
        Intrinsics.checkNotNullParameter(fineAmount, "");
        return new BizProductDestination(billId, totalAmount, adminFee, baseAmount, fineAmount, billCycle, customerName, customerType, dateTime, description, dueDate, paymentCount, payPartialSupport, familyNumber, familyCount, policeNumber, address, standMeter, load, tagNonAir, amount, meterNumber, fare, totalEnergy, type, startDate, endDate, customerIdNumber, owned, brand, model, machineNumber, frameNumber, yearOfProduction, newTaxExpirationDate, paymentReference, period, providerName, standBegin, standFinal, totalPeriod, usage, extendInfo, debtAmount, currentNeedRepayAmount, issueDate, overdueDay, repaymentDate, repaymentMonth, repaidAmount, inquiryStatus, inquiryMessage, inquiryCode);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizProductDestination) {
            BizProductDestination bizProductDestination = (BizProductDestination) other;
            return Intrinsics.areEqual(this.billId, bizProductDestination.billId) && Intrinsics.areEqual(this.totalAmount, bizProductDestination.totalAmount) && Intrinsics.areEqual(this.adminFee, bizProductDestination.adminFee) && Intrinsics.areEqual(this.baseAmount, bizProductDestination.baseAmount) && Intrinsics.areEqual(this.fineAmount, bizProductDestination.fineAmount) && Intrinsics.areEqual(this.billCycle, bizProductDestination.billCycle) && Intrinsics.areEqual(this.customerName, bizProductDestination.customerName) && Intrinsics.areEqual(this.customerType, bizProductDestination.customerType) && Intrinsics.areEqual(this.dateTime, bizProductDestination.dateTime) && Intrinsics.areEqual(this.description, bizProductDestination.description) && Intrinsics.areEqual(this.dueDate, bizProductDestination.dueDate) && Intrinsics.areEqual(this.paymentCount, bizProductDestination.paymentCount) && Intrinsics.areEqual(this.payPartialSupport, bizProductDestination.payPartialSupport) && Intrinsics.areEqual(this.familyNumber, bizProductDestination.familyNumber) && Intrinsics.areEqual(this.familyCount, bizProductDestination.familyCount) && Intrinsics.areEqual(this.policeNumber, bizProductDestination.policeNumber) && Intrinsics.areEqual(this.address, bizProductDestination.address) && Intrinsics.areEqual(this.standMeter, bizProductDestination.standMeter) && Intrinsics.areEqual(this.load, bizProductDestination.load) && Intrinsics.areEqual(this.tagNonAir, bizProductDestination.tagNonAir) && Intrinsics.areEqual(this.amount, bizProductDestination.amount) && Intrinsics.areEqual(this.meterNumber, bizProductDestination.meterNumber) && Intrinsics.areEqual(this.fare, bizProductDestination.fare) && Intrinsics.areEqual(this.totalEnergy, bizProductDestination.totalEnergy) && Intrinsics.areEqual(this.type, bizProductDestination.type) && Intrinsics.areEqual(this.startDate, bizProductDestination.startDate) && Intrinsics.areEqual(this.endDate, bizProductDestination.endDate) && Intrinsics.areEqual(this.customerIdNumber, bizProductDestination.customerIdNumber) && Intrinsics.areEqual(this.owned, bizProductDestination.owned) && Intrinsics.areEqual(this.brand, bizProductDestination.brand) && Intrinsics.areEqual(this.model, bizProductDestination.model) && Intrinsics.areEqual(this.machineNumber, bizProductDestination.machineNumber) && Intrinsics.areEqual(this.frameNumber, bizProductDestination.frameNumber) && Intrinsics.areEqual(this.yearOfProduction, bizProductDestination.yearOfProduction) && Intrinsics.areEqual(this.newTaxExpirationDate, bizProductDestination.newTaxExpirationDate) && Intrinsics.areEqual(this.paymentReference, bizProductDestination.paymentReference) && Intrinsics.areEqual(this.period, bizProductDestination.period) && Intrinsics.areEqual(this.providerName, bizProductDestination.providerName) && Intrinsics.areEqual(this.standBegin, bizProductDestination.standBegin) && Intrinsics.areEqual(this.standFinal, bizProductDestination.standFinal) && Intrinsics.areEqual(this.totalPeriod, bizProductDestination.totalPeriod) && Intrinsics.areEqual(this.usage, bizProductDestination.usage) && Intrinsics.areEqual(this.extendInfo, bizProductDestination.extendInfo) && Intrinsics.areEqual(this.debtAmount, bizProductDestination.debtAmount) && Intrinsics.areEqual(this.currentNeedRepayAmount, bizProductDestination.currentNeedRepayAmount) && Intrinsics.areEqual(this.issueDate, bizProductDestination.issueDate) && Intrinsics.areEqual(this.overdueDay, bizProductDestination.overdueDay) && Intrinsics.areEqual(this.repaymentDate, bizProductDestination.repaymentDate) && Intrinsics.areEqual(this.repaymentMonth, bizProductDestination.repaymentMonth) && Intrinsics.areEqual(this.repaidAmount, bizProductDestination.repaidAmount) && Intrinsics.areEqual(this.inquiryStatus, bizProductDestination.inquiryStatus) && Intrinsics.areEqual(this.inquiryMessage, bizProductDestination.inquiryMessage) && Intrinsics.areEqual(this.inquiryCode, bizProductDestination.inquiryCode);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.billId;
        int hashCode = str == null ? 0 : str.hashCode();
        MoneyView moneyView = this.totalAmount;
        int hashCode2 = moneyView == null ? 0 : moneyView.hashCode();
        int hashCode3 = this.adminFee.hashCode();
        int hashCode4 = this.baseAmount.hashCode();
        int hashCode5 = this.fineAmount.hashCode();
        String str2 = this.billCycle;
        int hashCode6 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.customerName;
        int hashCode7 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.customerType;
        int hashCode8 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.dateTime;
        int hashCode9 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.description;
        int hashCode10 = str6 == null ? 0 : str6.hashCode();
        Long l = this.dueDate;
        int hashCode11 = l == null ? 0 : l.hashCode();
        Integer num = this.paymentCount;
        int hashCode12 = num == null ? 0 : num.hashCode();
        Boolean bool = this.payPartialSupport;
        int hashCode13 = bool == null ? 0 : bool.hashCode();
        String str7 = this.familyNumber;
        int hashCode14 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.familyCount;
        int hashCode15 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.policeNumber;
        int hashCode16 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.address;
        int hashCode17 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.standMeter;
        int hashCode18 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.load;
        int hashCode19 = str12 == null ? 0 : str12.hashCode();
        MoneyView moneyView2 = this.tagNonAir;
        int hashCode20 = moneyView2 == null ? 0 : moneyView2.hashCode();
        String str13 = this.amount;
        int hashCode21 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.meterNumber;
        int hashCode22 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.fare;
        int hashCode23 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.totalEnergy;
        int hashCode24 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.type;
        int hashCode25 = str17 == null ? 0 : str17.hashCode();
        Long l2 = this.startDate;
        int hashCode26 = l2 == null ? 0 : l2.hashCode();
        Long l3 = this.endDate;
        int hashCode27 = l3 == null ? 0 : l3.hashCode();
        String str18 = this.customerIdNumber;
        int hashCode28 = str18 == null ? 0 : str18.hashCode();
        String str19 = this.owned;
        int hashCode29 = str19 == null ? 0 : str19.hashCode();
        String str20 = this.brand;
        int hashCode30 = str20 == null ? 0 : str20.hashCode();
        String str21 = this.model;
        int hashCode31 = str21 == null ? 0 : str21.hashCode();
        String str22 = this.machineNumber;
        int hashCode32 = str22 == null ? 0 : str22.hashCode();
        String str23 = this.frameNumber;
        int hashCode33 = str23 == null ? 0 : str23.hashCode();
        String str24 = this.yearOfProduction;
        int hashCode34 = str24 == null ? 0 : str24.hashCode();
        String str25 = this.newTaxExpirationDate;
        int hashCode35 = str25 == null ? 0 : str25.hashCode();
        String str26 = this.paymentReference;
        int hashCode36 = str26 == null ? 0 : str26.hashCode();
        List<Long> list = this.period;
        int hashCode37 = list == null ? 0 : list.hashCode();
        String str27 = this.providerName;
        int hashCode38 = str27 == null ? 0 : str27.hashCode();
        String str28 = this.standBegin;
        int hashCode39 = str28 == null ? 0 : str28.hashCode();
        String str29 = this.standFinal;
        int hashCode40 = str29 == null ? 0 : str29.hashCode();
        String str30 = this.totalPeriod;
        int hashCode41 = str30 == null ? 0 : str30.hashCode();
        String str31 = this.usage;
        int hashCode42 = str31 == null ? 0 : str31.hashCode();
        String str32 = this.extendInfo;
        int hashCode43 = str32 == null ? 0 : str32.hashCode();
        MoneyView moneyView3 = this.debtAmount;
        int hashCode44 = moneyView3 == null ? 0 : moneyView3.hashCode();
        MoneyView moneyView4 = this.currentNeedRepayAmount;
        int hashCode45 = moneyView4 == null ? 0 : moneyView4.hashCode();
        String str33 = this.issueDate;
        int hashCode46 = str33 == null ? 0 : str33.hashCode();
        String str34 = this.overdueDay;
        int hashCode47 = str34 == null ? 0 : str34.hashCode();
        String str35 = this.repaymentDate;
        int hashCode48 = str35 == null ? 0 : str35.hashCode();
        String str36 = this.repaymentMonth;
        int hashCode49 = str36 == null ? 0 : str36.hashCode();
        MoneyView moneyView5 = this.repaidAmount;
        int hashCode50 = moneyView5 == null ? 0 : moneyView5.hashCode();
        String str37 = this.inquiryStatus;
        int hashCode51 = str37 == null ? 0 : str37.hashCode();
        String str38 = this.inquiryMessage;
        int hashCode52 = str38 == null ? 0 : str38.hashCode();
        String str39 = this.inquiryCode;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + hashCode36) * 31) + hashCode37) * 31) + hashCode38) * 31) + hashCode39) * 31) + hashCode40) * 31) + hashCode41) * 31) + hashCode42) * 31) + hashCode43) * 31) + hashCode44) * 31) + hashCode45) * 31) + hashCode46) * 31) + hashCode47) * 31) + hashCode48) * 31) + hashCode49) * 31) + hashCode50) * 31) + hashCode51) * 31) + hashCode52) * 31) + (str39 != null ? str39.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizProductDestination(billId=");
        sb.append(this.billId);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", adminFee=");
        sb.append(this.adminFee);
        sb.append(", baseAmount=");
        sb.append(this.baseAmount);
        sb.append(", fineAmount=");
        sb.append(this.fineAmount);
        sb.append(", billCycle=");
        sb.append(this.billCycle);
        sb.append(", customerName=");
        sb.append(this.customerName);
        sb.append(", customerType=");
        sb.append(this.customerType);
        sb.append(", dateTime=");
        sb.append(this.dateTime);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", dueDate=");
        sb.append(this.dueDate);
        sb.append(", paymentCount=");
        sb.append(this.paymentCount);
        sb.append(", payPartialSupport=");
        sb.append(this.payPartialSupport);
        sb.append(", familyNumber=");
        sb.append(this.familyNumber);
        sb.append(", familyCount=");
        sb.append(this.familyCount);
        sb.append(", policeNumber=");
        sb.append(this.policeNumber);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", standMeter=");
        sb.append(this.standMeter);
        sb.append(", load=");
        sb.append(this.load);
        sb.append(", tagNonAir=");
        sb.append(this.tagNonAir);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", meterNumber=");
        sb.append(this.meterNumber);
        sb.append(", fare=");
        sb.append(this.fare);
        sb.append(", totalEnergy=");
        sb.append(this.totalEnergy);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", startDate=");
        sb.append(this.startDate);
        sb.append(", endDate=");
        sb.append(this.endDate);
        sb.append(", customerIdNumber=");
        sb.append(this.customerIdNumber);
        sb.append(", owned=");
        sb.append(this.owned);
        sb.append(", brand=");
        sb.append(this.brand);
        sb.append(", model=");
        sb.append(this.model);
        sb.append(", machineNumber=");
        sb.append(this.machineNumber);
        sb.append(", frameNumber=");
        sb.append(this.frameNumber);
        sb.append(", yearOfProduction=");
        sb.append(this.yearOfProduction);
        sb.append(", newTaxExpirationDate=");
        sb.append(this.newTaxExpirationDate);
        sb.append(", paymentReference=");
        sb.append(this.paymentReference);
        sb.append(", period=");
        sb.append(this.period);
        sb.append(", providerName=");
        sb.append(this.providerName);
        sb.append(", standBegin=");
        sb.append(this.standBegin);
        sb.append(", standFinal=");
        sb.append(this.standFinal);
        sb.append(", totalPeriod=");
        sb.append(this.totalPeriod);
        sb.append(", usage=");
        sb.append(this.usage);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", debtAmount=");
        sb.append(this.debtAmount);
        sb.append(", currentNeedRepayAmount=");
        sb.append(this.currentNeedRepayAmount);
        sb.append(", issueDate=");
        sb.append(this.issueDate);
        sb.append(", overdueDay=");
        sb.append(this.overdueDay);
        sb.append(", repaymentDate=");
        sb.append(this.repaymentDate);
        sb.append(", repaymentMonth=");
        sb.append(this.repaymentMonth);
        sb.append(", repaidAmount=");
        sb.append(this.repaidAmount);
        sb.append(", inquiryStatus=");
        sb.append(this.inquiryStatus);
        sb.append(", inquiryMessage=");
        sb.append(this.inquiryMessage);
        sb.append(", inquiryCode=");
        sb.append(this.inquiryCode);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.billId);
        parcel.writeSerializable(this.totalAmount);
        parcel.writeSerializable(this.adminFee);
        parcel.writeSerializable(this.baseAmount);
        parcel.writeSerializable(this.fineAmount);
        parcel.writeString(this.billCycle);
        parcel.writeString(this.customerName);
        parcel.writeString(this.customerType);
        parcel.writeString(this.dateTime);
        parcel.writeString(this.description);
        Long l = this.dueDate;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        Integer num = this.paymentCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Boolean bool = this.payPartialSupport;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.familyNumber);
        parcel.writeString(this.familyCount);
        parcel.writeString(this.policeNumber);
        parcel.writeString(this.address);
        parcel.writeString(this.standMeter);
        parcel.writeString(this.load);
        parcel.writeSerializable(this.tagNonAir);
        parcel.writeString(this.amount);
        parcel.writeString(this.meterNumber);
        parcel.writeString(this.fare);
        parcel.writeString(this.totalEnergy);
        parcel.writeString(this.type);
        Long l2 = this.startDate;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        Long l3 = this.endDate;
        if (l3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        }
        parcel.writeString(this.customerIdNumber);
        parcel.writeString(this.owned);
        parcel.writeString(this.brand);
        parcel.writeString(this.model);
        parcel.writeString(this.machineNumber);
        parcel.writeString(this.frameNumber);
        parcel.writeString(this.yearOfProduction);
        parcel.writeString(this.newTaxExpirationDate);
        parcel.writeString(this.paymentReference);
        List<Long> list = this.period;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                parcel.writeLong(it.next().longValue());
            }
        }
        parcel.writeString(this.providerName);
        parcel.writeString(this.standBegin);
        parcel.writeString(this.standFinal);
        parcel.writeString(this.totalPeriod);
        parcel.writeString(this.usage);
        parcel.writeString(this.extendInfo);
        parcel.writeSerializable(this.debtAmount);
        parcel.writeSerializable(this.currentNeedRepayAmount);
        parcel.writeString(this.issueDate);
        parcel.writeString(this.overdueDay);
        parcel.writeString(this.repaymentDate);
        parcel.writeString(this.repaymentMonth);
        parcel.writeSerializable(this.repaidAmount);
        parcel.writeString(this.inquiryStatus);
        parcel.writeString(this.inquiryMessage);
        parcel.writeString(this.inquiryCode);
    }

    public BizProductDestination(String str, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, MoneyView moneyView4, String str2, String str3, String str4, String str5, String str6, Long l, Integer num, Boolean bool, String str7, String str8, String str9, String str10, String str11, String str12, MoneyView moneyView5, String str13, String str14, String str15, String str16, String str17, Long l2, Long l3, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, List<Long> list, String str27, String str28, String str29, String str30, String str31, String str32, MoneyView moneyView6, MoneyView moneyView7, String str33, String str34, String str35, String str36, MoneyView moneyView8, String str37, String str38, String str39) {
        Intrinsics.checkNotNullParameter(moneyView2, "");
        Intrinsics.checkNotNullParameter(moneyView3, "");
        Intrinsics.checkNotNullParameter(moneyView4, "");
        this.billId = str;
        this.totalAmount = moneyView;
        this.adminFee = moneyView2;
        this.baseAmount = moneyView3;
        this.fineAmount = moneyView4;
        this.billCycle = str2;
        this.customerName = str3;
        this.customerType = str4;
        this.dateTime = str5;
        this.description = str6;
        this.dueDate = l;
        this.paymentCount = num;
        this.payPartialSupport = bool;
        this.familyNumber = str7;
        this.familyCount = str8;
        this.policeNumber = str9;
        this.address = str10;
        this.standMeter = str11;
        this.load = str12;
        this.tagNonAir = moneyView5;
        this.amount = str13;
        this.meterNumber = str14;
        this.fare = str15;
        this.totalEnergy = str16;
        this.type = str17;
        this.startDate = l2;
        this.endDate = l3;
        this.customerIdNumber = str18;
        this.owned = str19;
        this.brand = str20;
        this.model = str21;
        this.machineNumber = str22;
        this.frameNumber = str23;
        this.yearOfProduction = str24;
        this.newTaxExpirationDate = str25;
        this.paymentReference = str26;
        this.period = list;
        this.providerName = str27;
        this.standBegin = str28;
        this.standFinal = str29;
        this.totalPeriod = str30;
        this.usage = str31;
        this.extendInfo = str32;
        this.debtAmount = moneyView6;
        this.currentNeedRepayAmount = moneyView7;
        this.issueDate = str33;
        this.overdueDay = str34;
        this.repaymentDate = str35;
        this.repaymentMonth = str36;
        this.repaidAmount = moneyView8;
        this.inquiryStatus = str37;
        this.inquiryMessage = str38;
        this.inquiryCode = str39;
    }

    @JvmName(name = "getBillId")
    public final String getBillId() {
        return this.billId;
    }

    @JvmName(name = "setBillId")
    public final void setBillId(String str) {
        this.billId = str;
    }

    @JvmName(name = "getTotalAmount")
    public final MoneyView getTotalAmount() {
        return this.totalAmount;
    }

    public /* synthetic */ BizProductDestination(String str, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, MoneyView moneyView4, String str2, String str3, String str4, String str5, String str6, Long l, Integer num, Boolean bool, String str7, String str8, String str9, String str10, String str11, String str12, MoneyView moneyView5, String str13, String str14, String str15, String str16, String str17, Long l2, Long l3, String str18, String str19, String str20, String str21, String str22, String str23, String str24, String str25, String str26, List list, String str27, String str28, String str29, String str30, String str31, String str32, MoneyView moneyView6, MoneyView moneyView7, String str33, String str34, String str35, String str36, MoneyView moneyView8, String str37, String str38, String str39, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : moneyView, (i & 4) != 0 ? new MoneyView("0", "Rp", null, 4, null) : moneyView2, (i & 8) != 0 ? new MoneyView("0", "Rp", null, 4, null) : moneyView3, (i & 16) != 0 ? new MoneyView("0", "Rp", null, 4, null) : moneyView4, (i & 32) != 0 ? "" : str2, (i & 64) != 0 ? "" : str3, (i & 128) != 0 ? "" : str4, (i & 256) != 0 ? "" : str5, (i & 512) != 0 ? "" : str6, (i & 1024) != 0 ? null : l, (i & 2048) != 0 ? null : num, (i & 4096) != 0 ? null : bool, (i & 8192) != 0 ? "" : str7, (i & 16384) != 0 ? "" : str8, (i & 32768) != 0 ? "" : str9, (i & 65536) != 0 ? "" : str10, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? "" : str11, (i & 262144) != 0 ? "" : str12, (i & 524288) != 0 ? null : moneyView5, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? "" : str13, (i & 2097152) != 0 ? "" : str14, (i & 4194304) != 0 ? "" : str15, (i & 8388608) != 0 ? "" : str16, (i & 16777216) != 0 ? "" : str17, (i & 33554432) != 0 ? null : l2, (i & 67108864) != 0 ? null : l3, (i & 134217728) != 0 ? "" : str18, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? "" : str19, (i & 536870912) != 0 ? "" : str20, (i & 1073741824) != 0 ? "" : str21, (i & Integer.MIN_VALUE) != 0 ? "" : str22, (i2 & 1) != 0 ? "" : str23, (i2 & 2) != 0 ? "" : str24, (i2 & 4) != 0 ? "" : str25, (i2 & 8) != 0 ? "" : str26, (i2 & 16) != 0 ? null : list, (i2 & 32) != 0 ? "" : str27, (i2 & 64) != 0 ? "" : str28, (i2 & 128) != 0 ? "" : str29, (i2 & 256) != 0 ? "" : str30, (i2 & 512) != 0 ? "" : str31, (i2 & 1024) != 0 ? "" : str32, (i2 & 2048) != 0 ? null : moneyView6, (i2 & 4096) != 0 ? null : moneyView7, (i2 & 8192) != 0 ? "" : str33, (i2 & 16384) != 0 ? "" : str34, (i2 & 32768) != 0 ? "" : str35, (i2 & 65536) != 0 ? "" : str36, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : moneyView8, (i2 & 262144) != 0 ? "" : str37, (i2 & 524288) != 0 ? null : str38, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? "" : str39);
    }

    @JvmName(name = "getAdminFee")
    public final MoneyView getAdminFee() {
        return this.adminFee;
    }

    @JvmName(name = "getBaseAmount")
    public final MoneyView getBaseAmount() {
        return this.baseAmount;
    }

    @JvmName(name = "getFineAmount")
    public final MoneyView getFineAmount() {
        return this.fineAmount;
    }

    @JvmName(name = "getBillCycle")
    public final String getBillCycle() {
        return this.billCycle;
    }

    @JvmName(name = "getCustomerName")
    public final String getCustomerName() {
        return this.customerName;
    }

    @JvmName(name = "getCustomerType")
    public final String getCustomerType() {
        return this.customerType;
    }

    @JvmName(name = "getDateTime")
    public final String getDateTime() {
        return this.dateTime;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "getDueDate")
    public final Long getDueDate() {
        return this.dueDate;
    }

    @JvmName(name = "getPaymentCount")
    public final Integer getPaymentCount() {
        return this.paymentCount;
    }

    @JvmName(name = "getPayPartialSupport")
    public final Boolean getPayPartialSupport() {
        return this.payPartialSupport;
    }

    @JvmName(name = "getFamilyNumber")
    public final String getFamilyNumber() {
        return this.familyNumber;
    }

    @JvmName(name = "getFamilyCount")
    public final String getFamilyCount() {
        return this.familyCount;
    }

    @JvmName(name = "getPoliceNumber")
    public final String getPoliceNumber() {
        return this.policeNumber;
    }

    @JvmName(name = "getAddress")
    public final String getAddress() {
        return this.address;
    }

    @JvmName(name = "getStandMeter")
    public final String getStandMeter() {
        return this.standMeter;
    }

    @JvmName(name = "getLoad")
    public final String getLoad() {
        return this.load;
    }

    @JvmName(name = "getTagNonAir")
    public final MoneyView getTagNonAir() {
        return this.tagNonAir;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getMeterNumber")
    public final String getMeterNumber() {
        return this.meterNumber;
    }

    @JvmName(name = "getFare")
    public final String getFare() {
        return this.fare;
    }

    @JvmName(name = "getTotalEnergy")
    public final String getTotalEnergy() {
        return this.totalEnergy;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getStartDate")
    public final Long getStartDate() {
        return this.startDate;
    }

    @JvmName(name = "getEndDate")
    public final Long getEndDate() {
        return this.endDate;
    }

    @JvmName(name = "getCustomerIdNumber")
    public final String getCustomerIdNumber() {
        return this.customerIdNumber;
    }

    @JvmName(name = "getOwned")
    public final String getOwned() {
        return this.owned;
    }

    @JvmName(name = "getBrand")
    public final String getBrand() {
        return this.brand;
    }

    @JvmName(name = "getModel")
    public final String getModel() {
        return this.model;
    }

    @JvmName(name = "getMachineNumber")
    public final String getMachineNumber() {
        return this.machineNumber;
    }

    @JvmName(name = "getFrameNumber")
    public final String getFrameNumber() {
        return this.frameNumber;
    }

    @JvmName(name = "getYearOfProduction")
    public final String getYearOfProduction() {
        return this.yearOfProduction;
    }

    @JvmName(name = "getNewTaxExpirationDate")
    public final String getNewTaxExpirationDate() {
        return this.newTaxExpirationDate;
    }

    @JvmName(name = "getPaymentReference")
    public final String getPaymentReference() {
        return this.paymentReference;
    }

    @JvmName(name = "getPeriod")
    public final List<Long> getPeriod() {
        return this.period;
    }

    @JvmName(name = "getProviderName")
    public final String getProviderName() {
        return this.providerName;
    }

    @JvmName(name = "getStandBegin")
    public final String getStandBegin() {
        return this.standBegin;
    }

    @JvmName(name = "getStandFinal")
    public final String getStandFinal() {
        return this.standFinal;
    }

    @JvmName(name = "getTotalPeriod")
    public final String getTotalPeriod() {
        return this.totalPeriod;
    }

    @JvmName(name = "getUsage")
    public final String getUsage() {
        return this.usage;
    }

    @JvmName(name = "getExtendInfo")
    public final String getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getDebtAmount")
    public final MoneyView getDebtAmount() {
        return this.debtAmount;
    }

    @JvmName(name = "getCurrentNeedRepayAmount")
    public final MoneyView getCurrentNeedRepayAmount() {
        return this.currentNeedRepayAmount;
    }

    @JvmName(name = "getIssueDate")
    public final String getIssueDate() {
        return this.issueDate;
    }

    @JvmName(name = "getOverdueDay")
    public final String getOverdueDay() {
        return this.overdueDay;
    }

    @JvmName(name = "getRepaymentDate")
    public final String getRepaymentDate() {
        return this.repaymentDate;
    }

    @JvmName(name = "getRepaymentMonth")
    public final String getRepaymentMonth() {
        return this.repaymentMonth;
    }

    @JvmName(name = "getRepaidAmount")
    public final MoneyView getRepaidAmount() {
        return this.repaidAmount;
    }

    @JvmName(name = "getInquiryStatus")
    public final String getInquiryStatus() {
        return this.inquiryStatus;
    }

    @JvmName(name = "getInquiryMessage")
    public final String getInquiryMessage() {
        return this.inquiryMessage;
    }

    @JvmName(name = "getInquiryCode")
    public final String getInquiryCode() {
        return this.inquiryCode;
    }

    public final MoneyView getUsageMoneyView() {
        String str = this.usage;
        if (str == null) {
            str = "0";
        }
        return new MoneyView(str, null, null, 6, null);
    }

    public final boolean isInquirySuccess() {
        return Intrinsics.areEqual(this.inquiryStatus, "SUCCESS");
    }

    public final boolean isInquiryGot25And26() {
        return Intrinsics.areEqual(this.inquiryCode, "25") || Intrinsics.areEqual(this.inquiryStatus, "26");
    }
}
