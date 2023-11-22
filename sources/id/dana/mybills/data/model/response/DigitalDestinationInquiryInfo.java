package id.dana.mybills.data.model.response;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b;\n\u0002\u0010\u0000\n\u0002\bE\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0005\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010C\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010v\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0005\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u0010y\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u001a¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0010J\u0012\u0010 \u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b \u0010\u0010J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\bJ\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u0004J\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u0004J\u0012\u0010'\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b'\u0010\u0004J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u0004J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\u0004J\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010\u0004J\u0012\u0010+\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b+\u0010\u0004J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u0004J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u0004J\u0012\u0010/\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0004\b/\u00100J\u0012\u00101\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b1\u0010\u0010J\u0012\u00102\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b2\u0010\u0010J\u0012\u00103\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b3\u0010\u0010J\u0012\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b4\u0010\u0010J\u0012\u00105\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b5\u0010\u0004J\u0018\u00106\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b6\u0010\bJ\u0012\u00108\u001a\u0004\u0018\u000107HÆ\u0003¢\u0006\u0004\b8\u00109J\u0012\u0010:\u001a\u0004\u0018\u000107HÆ\u0003¢\u0006\u0004\b:\u00109J\u0012\u0010;\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b;\u0010\u0004J\u0012\u0010<\u001a\u0004\u0018\u000107HÆ\u0003¢\u0006\u0004\b<\u00109J\u0012\u0010=\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b=\u0010\u0004J\u0012\u0010>\u001a\u0004\u0018\u000107HÆ\u0003¢\u0006\u0004\b>\u00109J\u0012\u0010?\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b?\u0010\u001cJ\u0012\u0010A\u001a\u0004\u0018\u00010@HÆ\u0003¢\u0006\u0004\bA\u0010BJ\u0012\u0010D\u001a\u0004\u0018\u00010CHÆ\u0003¢\u0006\u0004\bD\u0010EJ\u0012\u0010F\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bF\u0010\u0004J\u0012\u0010G\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bG\u0010\u0004J\u009e\u0005\u0010}\u001a\u00020\u00002\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010M\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010C2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010p\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010v\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00052\n\b\u0002\u0010w\u001a\u0004\u0018\u0001072\n\b\u0002\u0010x\u001a\u0004\u0018\u0001072\n\b\u0002\u0010y\u001a\u0004\u0018\u0001072\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010{\u001a\u0004\u0018\u0001072\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u001aHÆ\u0001¢\u0006\u0004\b}\u0010~J\u001e\u0010\u0081\u0001\u001a\u00020C2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007fHÖ\u0003¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u0013\u0010\u0083\u0001\u001a\u00020@HÖ\u0001¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u0012\u0010\u0085\u0001\u001a\u00020\u0002HÖ\u0001¢\u0006\u0005\b\u0085\u0001\u0010\u0004R\u001e\u0010S\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bS\u0010\u0086\u0001\u001a\u0005\b\u0087\u0001\u0010\u0004R\u001e\u0010y\u001a\u0004\u0018\u0001078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\by\u0010\u0088\u0001\u001a\u0005\b\u0089\u0001\u00109R\u001e\u0010X\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bX\u0010\u0086\u0001\u001a\u0005\b\u008a\u0001\u0010\u0004R\u001e\u0010H\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bH\u0010\u0086\u0001\u001a\u0005\b\u008b\u0001\u0010\u0004R\u001e\u0010x\u001a\u0004\u0018\u0001078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bx\u0010\u0088\u0001\u001a\u0005\b\u008c\u0001\u00109R\u001e\u0010I\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bI\u0010\u0086\u0001\u001a\u0005\b\u008d\u0001\u0010\u0004R$\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\be\u0010\u008e\u0001\u001a\u0005\b\u008f\u0001\u0010\bR\u001e\u0010i\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bi\u0010\u0086\u0001\u001a\u0005\b\u0090\u0001\u0010\u0004R\u001e\u0010^\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b^\u0010\u0086\u0001\u001a\u0005\b\u0091\u0001\u0010\u0004R\u001e\u0010g\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bg\u0010\u0086\u0001\u001a\u0005\b\u0092\u0001\u0010\u0004R\u001e\u0010u\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bu\u0010\u0086\u0001\u001a\u0005\b\u0093\u0001\u0010\u0004R\u001e\u0010J\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bJ\u0010\u0086\u0001\u001a\u0005\b\u0094\u0001\u0010\u0004R\u001e\u0010K\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bK\u0010\u0086\u0001\u001a\u0005\b\u0095\u0001\u0010\u0004R\u001e\u0010L\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bL\u0010\u0086\u0001\u001a\u0005\b\u0096\u0001\u0010\u0004R$\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bQ\u0010\u008e\u0001\u001a\u0005\b\u0097\u0001\u0010\bR\u001e\u0010s\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bs\u0010\u0098\u0001\u001a\u0005\b\u0099\u0001\u0010\u0010R\u001e\u0010r\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\br\u0010\u0098\u0001\u001a\u0005\b\u009a\u0001\u0010\u0010R\u001e\u0010t\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bt\u0010\u0098\u0001\u001a\u0005\b\u009b\u0001\u0010\u0010R\u001e\u0010q\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bq\u0010\u0098\u0001\u001a\u0005\b\u009c\u0001\u0010\u0010R\u001e\u0010|\u001a\u0004\u0018\u00010\u001a8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b|\u0010\u009d\u0001\u001a\u0005\b\u009e\u0001\u0010\u001cR\u001e\u0010a\u001a\u0004\u0018\u00010\u001a8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\ba\u0010\u009d\u0001\u001a\u0005\b\u009f\u0001\u0010\u001cR\u001e\u0010f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bf\u0010\u0086\u0001\u001a\u0005\b \u0001\u0010\u0004R\u001e\u0010P\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bP\u0010\u0086\u0001\u001a\u0005\b¡\u0001\u0010\u0004R\u001e\u0010O\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bO\u0010\u0086\u0001\u001a\u0005\b¢\u0001\u0010\u0004R\u001e\u0010Z\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bZ\u0010\u0086\u0001\u001a\u0005\b£\u0001\u0010\u0004R\u001e\u0010{\u001a\u0004\u0018\u0001078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b{\u0010\u0088\u0001\u001a\u0005\b¤\u0001\u00109R\u001e\u0010l\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bl\u0010\u0086\u0001\u001a\u0005\b¥\u0001\u0010\u0004R\u001e\u0010o\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bo\u0010\u0086\u0001\u001a\u0005\b¦\u0001\u0010\u0004R\u001e\u0010p\u001a\u0004\u0018\u00010.8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bp\u0010§\u0001\u001a\u0005\b¨\u0001\u00100R\u001e\u0010V\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bV\u0010\u0086\u0001\u001a\u0005\b©\u0001\u0010\u0004R\u001e\u0010k\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bk\u0010\u0086\u0001\u001a\u0005\bª\u0001\u0010\u0004R\u001e\u0010d\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bd\u0010\u0098\u0001\u001a\u0005\b«\u0001\u0010\u0010R\u001e\u0010Y\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bY\u0010\u0086\u0001\u001a\u0005\b¬\u0001\u0010\u0004R\u001e\u0010c\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bc\u0010\u0098\u0001\u001a\u0005\b\u00ad\u0001\u0010\u0010R\u001e\u0010j\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bj\u0010\u0086\u0001\u001a\u0005\b®\u0001\u0010\u0004R\u001e\u0010n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bn\u0010\u0086\u0001\u001a\u0005\b¯\u0001\u0010\u0004R\u001e\u0010h\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bh\u0010\u0086\u0001\u001a\u0005\b°\u0001\u0010\u0004R\u001e\u0010N\u001a\u0004\u0018\u00010C8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bN\u0010±\u0001\u001a\u0005\b²\u0001\u0010ER\u001e\u0010M\u001a\u0004\u0018\u00010@8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bM\u0010³\u0001\u001a\u0005\b´\u0001\u0010BR$\u0010v\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bv\u0010\u008e\u0001\u001a\u0005\bµ\u0001\u0010\bR\u001e\u0010_\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b_\u0010\u0086\u0001\u001a\u0005\b¶\u0001\u0010\u0004R\u001e\u0010R\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bR\u0010\u0086\u0001\u001a\u0005\b·\u0001\u0010\u0004R\u001e\u0010z\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bz\u0010\u0086\u0001\u001a\u0005\b¸\u0001\u0010\u0004R\u001e\u0010b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bb\u0010\u0086\u0001\u001a\u0005\b¹\u0001\u0010\u0004R\u001e\u0010\\\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b\\\u0010\u0086\u0001\u001a\u0005\bº\u0001\u0010\u0004R\u001e\u0010T\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bT\u0010\u0086\u0001\u001a\u0005\b»\u0001\u0010\u0004R\u001e\u0010`\u001a\u0004\u0018\u00010\u001a8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b`\u0010\u009d\u0001\u001a\u0005\b¼\u0001\u0010\u001cR\u001e\u0010W\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bW\u0010\u0098\u0001\u001a\u0005\b½\u0001\u0010\u0010R\u001e\u0010w\u001a\u0004\u0018\u0001078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bw\u0010\u0088\u0001\u001a\u0005\b¾\u0001\u00109R\u001e\u0010[\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b[\u0010\u0086\u0001\u001a\u0005\b¿\u0001\u0010\u0004R\u001e\u0010]\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b]\u0010\u0086\u0001\u001a\u0005\bÀ\u0001\u0010\u0004R\u001e\u0010U\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bU\u0010\u0086\u0001\u001a\u0005\bÁ\u0001\u0010\u0004R\u001e\u0010m\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bm\u0010\u0086\u0001\u001a\u0005\bÂ\u0001\u0010\u0004"}, d2 = {"Lid/dana/mybills/data/model/response/DigitalDestinationInquiryInfo;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/mybills/data/model/response/BillAmountDetail;", "component10", "()Ljava/util/List;", "component11", "component12", "component13", "component14", "component15", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component16", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "", "component25", "()Ljava/lang/Long;", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "Lid/dana/mybills/data/model/response/InquiryStatus;", "component41", "()Lid/dana/mybills/data/model/response/InquiryStatus;", "component42", "component43", "component44", "component45", "component46", "component47", "Lid/dana/mybills/data/model/response/MultiCurrencyMoney;", "component48", "()Lid/dana/mybills/data/model/response/MultiCurrencyMoney;", "component49", "component5", "component50", "component51", "component52", "component53", "", "component6", "()Ljava/lang/Integer;", "", "component7", "()Ljava/lang/Boolean;", "component8", "component9", "authKey", "billCycle", "customerType", "dateTime", "description", "paymentCount", "payPartialSupport", "familyNumber", "familyCount", "detailAmount", "policeNumber", "address", "standMeter", "usage", "load", "tagNonAir", "amount", "meterNumber", "fare", "totalEnergy", "refNumber", "type", "certifiedNumber", "phoneNumber", "startDate", "endDate", FirebaseAnalytics.Param.QUANTITY, "minimumPayAmount", "maximumPayAmount", "billerMessages", "extendInfo", "customerIdNumber", "owned", H5GetLogInfoBridge.RESULT_BRAND, H5GetLogInfoBridge.RESULT_MODEL, "machineNumber", "frameNumber", "yearOfProduction", "newTaxExpirationDate", "inquiryId", "inquiryStatus", "displayTotalAmount", "displayBaseAmount", "displayAdminFee", "displayFineAmount", "customerName", "period", "totalAmount", "baseAmount", "adminFee", "providerName", "fineAmount", "dueDate", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/data/model/response/InquiryStatus;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/util/List;Lid/dana/mybills/data/model/response/MultiCurrencyMoney;Lid/dana/mybills/data/model/response/MultiCurrencyMoney;Lid/dana/mybills/data/model/response/MultiCurrencyMoney;Ljava/lang/String;Lid/dana/mybills/data/model/response/MultiCurrencyMoney;Ljava/lang/Long;)Lid/dana/mybills/data/model/response/DigitalDestinationInquiryInfo;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAddress", "Lid/dana/mybills/data/model/response/MultiCurrencyMoney;", "getAdminFee", "getAmount", "getAuthKey", "getBaseAmount", "getBillCycle", "Ljava/util/List;", "getBillerMessages", "getBrand", "getCertifiedNumber", "getCustomerIdNumber", "getCustomerName", "getCustomerType", "getDateTime", "getDescription", "getDetailAmount", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getDisplayAdminFee", "getDisplayBaseAmount", "getDisplayFineAmount", "getDisplayTotalAmount", "Ljava/lang/Long;", "getDueDate", "getEndDate", "getExtendInfo", "getFamilyCount", "getFamilyNumber", "getFare", "getFineAmount", "getFrameNumber", "getInquiryId", "Lid/dana/mybills/data/model/response/InquiryStatus;", "getInquiryStatus", "getLoad", "getMachineNumber", "getMaximumPayAmount", "getMeterNumber", "getMinimumPayAmount", "getModel", "getNewTaxExpirationDate", "getOwned", "Ljava/lang/Boolean;", "getPayPartialSupport", "Ljava/lang/Integer;", "getPaymentCount", "getPeriod", "getPhoneNumber", "getPoliceNumber", "getProviderName", "getQuantity", "getRefNumber", "getStandMeter", "getStartDate", "getTagNonAir", "getTotalAmount", "getTotalEnergy", "getType", "getUsage", "getYearOfProduction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/data/model/response/InquiryStatus;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/util/List;Lid/dana/mybills/data/model/response/MultiCurrencyMoney;Lid/dana/mybills/data/model/response/MultiCurrencyMoney;Lid/dana/mybills/data/model/response/MultiCurrencyMoney;Ljava/lang/String;Lid/dana/mybills/data/model/response/MultiCurrencyMoney;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DigitalDestinationInquiryInfo implements Serializable {
    @SerializedName("address")
    private final String address;
    @SerializedName("adminFee")
    private final MultiCurrencyMoney adminFee;
    @SerializedName("amount")
    private final String amount;
    @SerializedName("authKey")
    private final String authKey;
    @SerializedName("baseAmount")
    private final MultiCurrencyMoney baseAmount;
    @SerializedName("billCycle")
    private final String billCycle;
    @SerializedName("billerMessages")
    private final List<String> billerMessages;
    @SerializedName(H5GetLogInfoBridge.RESULT_BRAND)
    private final String brand;
    @SerializedName("certifiedNumber")
    private final String certifiedNumber;
    @SerializedName("customerIdNumber")
    private final String customerIdNumber;
    @SerializedName("customerName")
    private final String customerName;
    @SerializedName("customerType")
    private final String customerType;
    @SerializedName("dateTime")
    private final String dateTime;
    @SerializedName("description")
    private final String description;
    @SerializedName("detailAmount")
    private final List<BillAmountDetail> detailAmount;
    @SerializedName("displayAdminFee")
    private final MoneyViewEntity displayAdminFee;
    @SerializedName("displayBaseAmount")
    private final MoneyViewEntity displayBaseAmount;
    @SerializedName("displayFineAmount")
    private final MoneyViewEntity displayFineAmount;
    @SerializedName("displayTotalAmount")
    private final MoneyViewEntity displayTotalAmount;
    @SerializedName("dueDate")
    private final Long dueDate;
    @SerializedName("endDate")
    private final Long endDate;
    @SerializedName("extendInfo")
    private final String extendInfo;
    @SerializedName("familyCount")
    private final String familyCount;
    @SerializedName("familyNumber")
    private final String familyNumber;
    @SerializedName("fare")
    private final String fare;
    @SerializedName("fineAmount")
    private final MultiCurrencyMoney fineAmount;
    @SerializedName("frameNumber")
    private final String frameNumber;
    @SerializedName("inquiryId")
    private final String inquiryId;
    @SerializedName("inquiryStatus")
    private final InquiryStatus inquiryStatus;
    @SerializedName("load")
    private final String load;
    @SerializedName("machineNumber")
    private final String machineNumber;
    @SerializedName("maximumPayAmount")
    private final MoneyViewEntity maximumPayAmount;
    @SerializedName("meterNumber")
    private final String meterNumber;
    @SerializedName("minimumPayAmount")
    private final MoneyViewEntity minimumPayAmount;
    @SerializedName(H5GetLogInfoBridge.RESULT_MODEL)
    private final String model;
    @SerializedName("newTaxExpirationDate")
    private final String newTaxExpirationDate;
    @SerializedName("owned")
    private final String owned;
    @SerializedName("payPartialSupport")
    private final Boolean payPartialSupport;
    @SerializedName("paymentCount")
    private final Integer paymentCount;
    @SerializedName("period")
    private final List<Long> period;
    @SerializedName("phoneNumber")
    private final String phoneNumber;
    @SerializedName("policeNumber")
    private final String policeNumber;
    @SerializedName("providerName")
    private final String providerName;
    @SerializedName(FirebaseAnalytics.Param.QUANTITY)
    private final String quantity;
    @SerializedName("refNumber")
    private final String refNumber;
    @SerializedName("standMeter")
    private final String standMeter;
    @SerializedName("startDate")
    private final Long startDate;
    @SerializedName("tagNonAir")
    private final MoneyViewEntity tagNonAir;
    @SerializedName("totalAmount")
    private final MultiCurrencyMoney totalAmount;
    @SerializedName("totalEnergy")
    private final String totalEnergy;
    @SerializedName("type")
    private final String type;
    @SerializedName("usage")
    private final String usage;
    @SerializedName("yearOfProduction")
    private final String yearOfProduction;

    public DigitalDestinationInquiryInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 2097151, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAuthKey() {
        return this.authKey;
    }

    public final List<BillAmountDetail> component10() {
        return this.detailAmount;
    }

    /* renamed from: component11  reason: from getter */
    public final String getPoliceNumber() {
        return this.policeNumber;
    }

    /* renamed from: component12  reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component13  reason: from getter */
    public final String getStandMeter() {
        return this.standMeter;
    }

    /* renamed from: component14  reason: from getter */
    public final String getUsage() {
        return this.usage;
    }

    /* renamed from: component15  reason: from getter */
    public final String getLoad() {
        return this.load;
    }

    /* renamed from: component16  reason: from getter */
    public final MoneyViewEntity getTagNonAir() {
        return this.tagNonAir;
    }

    /* renamed from: component17  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component18  reason: from getter */
    public final String getMeterNumber() {
        return this.meterNumber;
    }

    /* renamed from: component19  reason: from getter */
    public final String getFare() {
        return this.fare;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBillCycle() {
        return this.billCycle;
    }

    /* renamed from: component20  reason: from getter */
    public final String getTotalEnergy() {
        return this.totalEnergy;
    }

    /* renamed from: component21  reason: from getter */
    public final String getRefNumber() {
        return this.refNumber;
    }

    /* renamed from: component22  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component23  reason: from getter */
    public final String getCertifiedNumber() {
        return this.certifiedNumber;
    }

    /* renamed from: component24  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component25  reason: from getter */
    public final Long getStartDate() {
        return this.startDate;
    }

    /* renamed from: component26  reason: from getter */
    public final Long getEndDate() {
        return this.endDate;
    }

    /* renamed from: component27  reason: from getter */
    public final String getQuantity() {
        return this.quantity;
    }

    /* renamed from: component28  reason: from getter */
    public final MoneyViewEntity getMinimumPayAmount() {
        return this.minimumPayAmount;
    }

    /* renamed from: component29  reason: from getter */
    public final MoneyViewEntity getMaximumPayAmount() {
        return this.maximumPayAmount;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCustomerType() {
        return this.customerType;
    }

    public final List<String> component30() {
        return this.billerMessages;
    }

    /* renamed from: component31  reason: from getter */
    public final String getExtendInfo() {
        return this.extendInfo;
    }

    /* renamed from: component32  reason: from getter */
    public final String getCustomerIdNumber() {
        return this.customerIdNumber;
    }

    /* renamed from: component33  reason: from getter */
    public final String getOwned() {
        return this.owned;
    }

    /* renamed from: component34  reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* renamed from: component35  reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component36  reason: from getter */
    public final String getMachineNumber() {
        return this.machineNumber;
    }

    /* renamed from: component37  reason: from getter */
    public final String getFrameNumber() {
        return this.frameNumber;
    }

    /* renamed from: component38  reason: from getter */
    public final String getYearOfProduction() {
        return this.yearOfProduction;
    }

    /* renamed from: component39  reason: from getter */
    public final String getNewTaxExpirationDate() {
        return this.newTaxExpirationDate;
    }

    /* renamed from: component4  reason: from getter */
    public final String getDateTime() {
        return this.dateTime;
    }

    /* renamed from: component40  reason: from getter */
    public final String getInquiryId() {
        return this.inquiryId;
    }

    /* renamed from: component41  reason: from getter */
    public final InquiryStatus getInquiryStatus() {
        return this.inquiryStatus;
    }

    /* renamed from: component42  reason: from getter */
    public final MoneyViewEntity getDisplayTotalAmount() {
        return this.displayTotalAmount;
    }

    /* renamed from: component43  reason: from getter */
    public final MoneyViewEntity getDisplayBaseAmount() {
        return this.displayBaseAmount;
    }

    /* renamed from: component44  reason: from getter */
    public final MoneyViewEntity getDisplayAdminFee() {
        return this.displayAdminFee;
    }

    /* renamed from: component45  reason: from getter */
    public final MoneyViewEntity getDisplayFineAmount() {
        return this.displayFineAmount;
    }

    /* renamed from: component46  reason: from getter */
    public final String getCustomerName() {
        return this.customerName;
    }

    public final List<Long> component47() {
        return this.period;
    }

    /* renamed from: component48  reason: from getter */
    public final MultiCurrencyMoney getTotalAmount() {
        return this.totalAmount;
    }

    /* renamed from: component49  reason: from getter */
    public final MultiCurrencyMoney getBaseAmount() {
        return this.baseAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component50  reason: from getter */
    public final MultiCurrencyMoney getAdminFee() {
        return this.adminFee;
    }

    /* renamed from: component51  reason: from getter */
    public final String getProviderName() {
        return this.providerName;
    }

    /* renamed from: component52  reason: from getter */
    public final MultiCurrencyMoney getFineAmount() {
        return this.fineAmount;
    }

    /* renamed from: component53  reason: from getter */
    public final Long getDueDate() {
        return this.dueDate;
    }

    /* renamed from: component6  reason: from getter */
    public final Integer getPaymentCount() {
        return this.paymentCount;
    }

    /* renamed from: component7  reason: from getter */
    public final Boolean getPayPartialSupport() {
        return this.payPartialSupport;
    }

    /* renamed from: component8  reason: from getter */
    public final String getFamilyNumber() {
        return this.familyNumber;
    }

    /* renamed from: component9  reason: from getter */
    public final String getFamilyCount() {
        return this.familyCount;
    }

    public final DigitalDestinationInquiryInfo copy(String authKey, String billCycle, String customerType, String dateTime, String description, Integer paymentCount, Boolean payPartialSupport, String familyNumber, String familyCount, List<BillAmountDetail> detailAmount, String policeNumber, String address, String standMeter, String usage, String load, MoneyViewEntity tagNonAir, String amount, String meterNumber, String fare, String totalEnergy, String refNumber, String type, String certifiedNumber, String phoneNumber, Long startDate, Long endDate, String quantity, MoneyViewEntity minimumPayAmount, MoneyViewEntity maximumPayAmount, List<String> billerMessages, String extendInfo, String customerIdNumber, String owned, String brand, String model, String machineNumber, String frameNumber, String yearOfProduction, String newTaxExpirationDate, String inquiryId, InquiryStatus inquiryStatus, MoneyViewEntity displayTotalAmount, MoneyViewEntity displayBaseAmount, MoneyViewEntity displayAdminFee, MoneyViewEntity displayFineAmount, String customerName, List<Long> period, MultiCurrencyMoney totalAmount, MultiCurrencyMoney baseAmount, MultiCurrencyMoney adminFee, String providerName, MultiCurrencyMoney fineAmount, Long dueDate) {
        return new DigitalDestinationInquiryInfo(authKey, billCycle, customerType, dateTime, description, paymentCount, payPartialSupport, familyNumber, familyCount, detailAmount, policeNumber, address, standMeter, usage, load, tagNonAir, amount, meterNumber, fare, totalEnergy, refNumber, type, certifiedNumber, phoneNumber, startDate, endDate, quantity, minimumPayAmount, maximumPayAmount, billerMessages, extendInfo, customerIdNumber, owned, brand, model, machineNumber, frameNumber, yearOfProduction, newTaxExpirationDate, inquiryId, inquiryStatus, displayTotalAmount, displayBaseAmount, displayAdminFee, displayFineAmount, customerName, period, totalAmount, baseAmount, adminFee, providerName, fineAmount, dueDate);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof DigitalDestinationInquiryInfo) {
            DigitalDestinationInquiryInfo digitalDestinationInquiryInfo = (DigitalDestinationInquiryInfo) other;
            return Intrinsics.areEqual(this.authKey, digitalDestinationInquiryInfo.authKey) && Intrinsics.areEqual(this.billCycle, digitalDestinationInquiryInfo.billCycle) && Intrinsics.areEqual(this.customerType, digitalDestinationInquiryInfo.customerType) && Intrinsics.areEqual(this.dateTime, digitalDestinationInquiryInfo.dateTime) && Intrinsics.areEqual(this.description, digitalDestinationInquiryInfo.description) && Intrinsics.areEqual(this.paymentCount, digitalDestinationInquiryInfo.paymentCount) && Intrinsics.areEqual(this.payPartialSupport, digitalDestinationInquiryInfo.payPartialSupport) && Intrinsics.areEqual(this.familyNumber, digitalDestinationInquiryInfo.familyNumber) && Intrinsics.areEqual(this.familyCount, digitalDestinationInquiryInfo.familyCount) && Intrinsics.areEqual(this.detailAmount, digitalDestinationInquiryInfo.detailAmount) && Intrinsics.areEqual(this.policeNumber, digitalDestinationInquiryInfo.policeNumber) && Intrinsics.areEqual(this.address, digitalDestinationInquiryInfo.address) && Intrinsics.areEqual(this.standMeter, digitalDestinationInquiryInfo.standMeter) && Intrinsics.areEqual(this.usage, digitalDestinationInquiryInfo.usage) && Intrinsics.areEqual(this.load, digitalDestinationInquiryInfo.load) && Intrinsics.areEqual(this.tagNonAir, digitalDestinationInquiryInfo.tagNonAir) && Intrinsics.areEqual(this.amount, digitalDestinationInquiryInfo.amount) && Intrinsics.areEqual(this.meterNumber, digitalDestinationInquiryInfo.meterNumber) && Intrinsics.areEqual(this.fare, digitalDestinationInquiryInfo.fare) && Intrinsics.areEqual(this.totalEnergy, digitalDestinationInquiryInfo.totalEnergy) && Intrinsics.areEqual(this.refNumber, digitalDestinationInquiryInfo.refNumber) && Intrinsics.areEqual(this.type, digitalDestinationInquiryInfo.type) && Intrinsics.areEqual(this.certifiedNumber, digitalDestinationInquiryInfo.certifiedNumber) && Intrinsics.areEqual(this.phoneNumber, digitalDestinationInquiryInfo.phoneNumber) && Intrinsics.areEqual(this.startDate, digitalDestinationInquiryInfo.startDate) && Intrinsics.areEqual(this.endDate, digitalDestinationInquiryInfo.endDate) && Intrinsics.areEqual(this.quantity, digitalDestinationInquiryInfo.quantity) && Intrinsics.areEqual(this.minimumPayAmount, digitalDestinationInquiryInfo.minimumPayAmount) && Intrinsics.areEqual(this.maximumPayAmount, digitalDestinationInquiryInfo.maximumPayAmount) && Intrinsics.areEqual(this.billerMessages, digitalDestinationInquiryInfo.billerMessages) && Intrinsics.areEqual(this.extendInfo, digitalDestinationInquiryInfo.extendInfo) && Intrinsics.areEqual(this.customerIdNumber, digitalDestinationInquiryInfo.customerIdNumber) && Intrinsics.areEqual(this.owned, digitalDestinationInquiryInfo.owned) && Intrinsics.areEqual(this.brand, digitalDestinationInquiryInfo.brand) && Intrinsics.areEqual(this.model, digitalDestinationInquiryInfo.model) && Intrinsics.areEqual(this.machineNumber, digitalDestinationInquiryInfo.machineNumber) && Intrinsics.areEqual(this.frameNumber, digitalDestinationInquiryInfo.frameNumber) && Intrinsics.areEqual(this.yearOfProduction, digitalDestinationInquiryInfo.yearOfProduction) && Intrinsics.areEqual(this.newTaxExpirationDate, digitalDestinationInquiryInfo.newTaxExpirationDate) && Intrinsics.areEqual(this.inquiryId, digitalDestinationInquiryInfo.inquiryId) && Intrinsics.areEqual(this.inquiryStatus, digitalDestinationInquiryInfo.inquiryStatus) && Intrinsics.areEqual(this.displayTotalAmount, digitalDestinationInquiryInfo.displayTotalAmount) && Intrinsics.areEqual(this.displayBaseAmount, digitalDestinationInquiryInfo.displayBaseAmount) && Intrinsics.areEqual(this.displayAdminFee, digitalDestinationInquiryInfo.displayAdminFee) && Intrinsics.areEqual(this.displayFineAmount, digitalDestinationInquiryInfo.displayFineAmount) && Intrinsics.areEqual(this.customerName, digitalDestinationInquiryInfo.customerName) && Intrinsics.areEqual(this.period, digitalDestinationInquiryInfo.period) && Intrinsics.areEqual(this.totalAmount, digitalDestinationInquiryInfo.totalAmount) && Intrinsics.areEqual(this.baseAmount, digitalDestinationInquiryInfo.baseAmount) && Intrinsics.areEqual(this.adminFee, digitalDestinationInquiryInfo.adminFee) && Intrinsics.areEqual(this.providerName, digitalDestinationInquiryInfo.providerName) && Intrinsics.areEqual(this.fineAmount, digitalDestinationInquiryInfo.fineAmount) && Intrinsics.areEqual(this.dueDate, digitalDestinationInquiryInfo.dueDate);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.authKey;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.billCycle;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.customerType;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.dateTime;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.description;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        Integer num = this.paymentCount;
        int hashCode6 = num == null ? 0 : num.hashCode();
        Boolean bool = this.payPartialSupport;
        int hashCode7 = bool == null ? 0 : bool.hashCode();
        String str6 = this.familyNumber;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.familyCount;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        List<BillAmountDetail> list = this.detailAmount;
        int hashCode10 = list == null ? 0 : list.hashCode();
        String str8 = this.policeNumber;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.address;
        int hashCode12 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.standMeter;
        int hashCode13 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.usage;
        int hashCode14 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.load;
        int hashCode15 = str12 == null ? 0 : str12.hashCode();
        MoneyViewEntity moneyViewEntity = this.tagNonAir;
        int hashCode16 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        String str13 = this.amount;
        int hashCode17 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.meterNumber;
        int hashCode18 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.fare;
        int hashCode19 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.totalEnergy;
        int hashCode20 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.refNumber;
        int hashCode21 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.type;
        int hashCode22 = str18 == null ? 0 : str18.hashCode();
        String str19 = this.certifiedNumber;
        int hashCode23 = str19 == null ? 0 : str19.hashCode();
        String str20 = this.phoneNumber;
        int hashCode24 = str20 == null ? 0 : str20.hashCode();
        Long l = this.startDate;
        int hashCode25 = l == null ? 0 : l.hashCode();
        Long l2 = this.endDate;
        int hashCode26 = l2 == null ? 0 : l2.hashCode();
        String str21 = this.quantity;
        int hashCode27 = str21 == null ? 0 : str21.hashCode();
        MoneyViewEntity moneyViewEntity2 = this.minimumPayAmount;
        int hashCode28 = moneyViewEntity2 == null ? 0 : moneyViewEntity2.hashCode();
        MoneyViewEntity moneyViewEntity3 = this.maximumPayAmount;
        int hashCode29 = moneyViewEntity3 == null ? 0 : moneyViewEntity3.hashCode();
        List<String> list2 = this.billerMessages;
        int hashCode30 = list2 == null ? 0 : list2.hashCode();
        String str22 = this.extendInfo;
        int hashCode31 = str22 == null ? 0 : str22.hashCode();
        String str23 = this.customerIdNumber;
        int hashCode32 = str23 == null ? 0 : str23.hashCode();
        String str24 = this.owned;
        int hashCode33 = str24 == null ? 0 : str24.hashCode();
        String str25 = this.brand;
        int hashCode34 = str25 == null ? 0 : str25.hashCode();
        String str26 = this.model;
        int hashCode35 = str26 == null ? 0 : str26.hashCode();
        String str27 = this.machineNumber;
        int hashCode36 = str27 == null ? 0 : str27.hashCode();
        String str28 = this.frameNumber;
        int hashCode37 = str28 == null ? 0 : str28.hashCode();
        String str29 = this.yearOfProduction;
        int hashCode38 = str29 == null ? 0 : str29.hashCode();
        String str30 = this.newTaxExpirationDate;
        int hashCode39 = str30 == null ? 0 : str30.hashCode();
        String str31 = this.inquiryId;
        int hashCode40 = str31 == null ? 0 : str31.hashCode();
        InquiryStatus inquiryStatus = this.inquiryStatus;
        int hashCode41 = inquiryStatus == null ? 0 : inquiryStatus.hashCode();
        MoneyViewEntity moneyViewEntity4 = this.displayTotalAmount;
        int hashCode42 = moneyViewEntity4 == null ? 0 : moneyViewEntity4.hashCode();
        MoneyViewEntity moneyViewEntity5 = this.displayBaseAmount;
        int hashCode43 = moneyViewEntity5 == null ? 0 : moneyViewEntity5.hashCode();
        MoneyViewEntity moneyViewEntity6 = this.displayAdminFee;
        int hashCode44 = moneyViewEntity6 == null ? 0 : moneyViewEntity6.hashCode();
        MoneyViewEntity moneyViewEntity7 = this.displayFineAmount;
        int hashCode45 = moneyViewEntity7 == null ? 0 : moneyViewEntity7.hashCode();
        String str32 = this.customerName;
        int hashCode46 = str32 == null ? 0 : str32.hashCode();
        List<Long> list3 = this.period;
        int hashCode47 = list3 == null ? 0 : list3.hashCode();
        MultiCurrencyMoney multiCurrencyMoney = this.totalAmount;
        int hashCode48 = multiCurrencyMoney == null ? 0 : multiCurrencyMoney.hashCode();
        MultiCurrencyMoney multiCurrencyMoney2 = this.baseAmount;
        int hashCode49 = multiCurrencyMoney2 == null ? 0 : multiCurrencyMoney2.hashCode();
        MultiCurrencyMoney multiCurrencyMoney3 = this.adminFee;
        int hashCode50 = multiCurrencyMoney3 == null ? 0 : multiCurrencyMoney3.hashCode();
        String str33 = this.providerName;
        int hashCode51 = str33 == null ? 0 : str33.hashCode();
        MultiCurrencyMoney multiCurrencyMoney4 = this.fineAmount;
        int hashCode52 = multiCurrencyMoney4 == null ? 0 : multiCurrencyMoney4.hashCode();
        Long l3 = this.dueDate;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + hashCode36) * 31) + hashCode37) * 31) + hashCode38) * 31) + hashCode39) * 31) + hashCode40) * 31) + hashCode41) * 31) + hashCode42) * 31) + hashCode43) * 31) + hashCode44) * 31) + hashCode45) * 31) + hashCode46) * 31) + hashCode47) * 31) + hashCode48) * 31) + hashCode49) * 31) + hashCode50) * 31) + hashCode51) * 31) + hashCode52) * 31) + (l3 != null ? l3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DigitalDestinationInquiryInfo(authKey=");
        sb.append(this.authKey);
        sb.append(", billCycle=");
        sb.append(this.billCycle);
        sb.append(", customerType=");
        sb.append(this.customerType);
        sb.append(", dateTime=");
        sb.append(this.dateTime);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", paymentCount=");
        sb.append(this.paymentCount);
        sb.append(", payPartialSupport=");
        sb.append(this.payPartialSupport);
        sb.append(", familyNumber=");
        sb.append(this.familyNumber);
        sb.append(", familyCount=");
        sb.append(this.familyCount);
        sb.append(", detailAmount=");
        sb.append(this.detailAmount);
        sb.append(", policeNumber=");
        sb.append(this.policeNumber);
        sb.append(", address=");
        sb.append(this.address);
        sb.append(", standMeter=");
        sb.append(this.standMeter);
        sb.append(", usage=");
        sb.append(this.usage);
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
        sb.append(", refNumber=");
        sb.append(this.refNumber);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", certifiedNumber=");
        sb.append(this.certifiedNumber);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", startDate=");
        sb.append(this.startDate);
        sb.append(", endDate=");
        sb.append(this.endDate);
        sb.append(", quantity=");
        sb.append(this.quantity);
        sb.append(", minimumPayAmount=");
        sb.append(this.minimumPayAmount);
        sb.append(", maximumPayAmount=");
        sb.append(this.maximumPayAmount);
        sb.append(", billerMessages=");
        sb.append(this.billerMessages);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
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
        sb.append(", inquiryId=");
        sb.append(this.inquiryId);
        sb.append(", inquiryStatus=");
        sb.append(this.inquiryStatus);
        sb.append(", displayTotalAmount=");
        sb.append(this.displayTotalAmount);
        sb.append(", displayBaseAmount=");
        sb.append(this.displayBaseAmount);
        sb.append(", displayAdminFee=");
        sb.append(this.displayAdminFee);
        sb.append(", displayFineAmount=");
        sb.append(this.displayFineAmount);
        sb.append(", customerName=");
        sb.append(this.customerName);
        sb.append(", period=");
        sb.append(this.period);
        sb.append(", totalAmount=");
        sb.append(this.totalAmount);
        sb.append(", baseAmount=");
        sb.append(this.baseAmount);
        sb.append(", adminFee=");
        sb.append(this.adminFee);
        sb.append(", providerName=");
        sb.append(this.providerName);
        sb.append(", fineAmount=");
        sb.append(this.fineAmount);
        sb.append(", dueDate=");
        sb.append(this.dueDate);
        sb.append(')');
        return sb.toString();
    }

    public DigitalDestinationInquiryInfo(String str, String str2, String str3, String str4, String str5, Integer num, Boolean bool, String str6, String str7, List<BillAmountDetail> list, String str8, String str9, String str10, String str11, String str12, MoneyViewEntity moneyViewEntity, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, Long l, Long l2, String str21, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, List<String> list2, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, InquiryStatus inquiryStatus, MoneyViewEntity moneyViewEntity4, MoneyViewEntity moneyViewEntity5, MoneyViewEntity moneyViewEntity6, MoneyViewEntity moneyViewEntity7, String str32, List<Long> list3, MultiCurrencyMoney multiCurrencyMoney, MultiCurrencyMoney multiCurrencyMoney2, MultiCurrencyMoney multiCurrencyMoney3, String str33, MultiCurrencyMoney multiCurrencyMoney4, Long l3) {
        this.authKey = str;
        this.billCycle = str2;
        this.customerType = str3;
        this.dateTime = str4;
        this.description = str5;
        this.paymentCount = num;
        this.payPartialSupport = bool;
        this.familyNumber = str6;
        this.familyCount = str7;
        this.detailAmount = list;
        this.policeNumber = str8;
        this.address = str9;
        this.standMeter = str10;
        this.usage = str11;
        this.load = str12;
        this.tagNonAir = moneyViewEntity;
        this.amount = str13;
        this.meterNumber = str14;
        this.fare = str15;
        this.totalEnergy = str16;
        this.refNumber = str17;
        this.type = str18;
        this.certifiedNumber = str19;
        this.phoneNumber = str20;
        this.startDate = l;
        this.endDate = l2;
        this.quantity = str21;
        this.minimumPayAmount = moneyViewEntity2;
        this.maximumPayAmount = moneyViewEntity3;
        this.billerMessages = list2;
        this.extendInfo = str22;
        this.customerIdNumber = str23;
        this.owned = str24;
        this.brand = str25;
        this.model = str26;
        this.machineNumber = str27;
        this.frameNumber = str28;
        this.yearOfProduction = str29;
        this.newTaxExpirationDate = str30;
        this.inquiryId = str31;
        this.inquiryStatus = inquiryStatus;
        this.displayTotalAmount = moneyViewEntity4;
        this.displayBaseAmount = moneyViewEntity5;
        this.displayAdminFee = moneyViewEntity6;
        this.displayFineAmount = moneyViewEntity7;
        this.customerName = str32;
        this.period = list3;
        this.totalAmount = multiCurrencyMoney;
        this.baseAmount = multiCurrencyMoney2;
        this.adminFee = multiCurrencyMoney3;
        this.providerName = str33;
        this.fineAmount = multiCurrencyMoney4;
        this.dueDate = l3;
    }

    public /* synthetic */ DigitalDestinationInquiryInfo(String str, String str2, String str3, String str4, String str5, Integer num, Boolean bool, String str6, String str7, List list, String str8, String str9, String str10, String str11, String str12, MoneyViewEntity moneyViewEntity, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, Long l, Long l2, String str21, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, List list2, String str22, String str23, String str24, String str25, String str26, String str27, String str28, String str29, String str30, String str31, InquiryStatus inquiryStatus, MoneyViewEntity moneyViewEntity4, MoneyViewEntity moneyViewEntity5, MoneyViewEntity moneyViewEntity6, MoneyViewEntity moneyViewEntity7, String str32, List list3, MultiCurrencyMoney multiCurrencyMoney, MultiCurrencyMoney multiCurrencyMoney2, MultiCurrencyMoney multiCurrencyMoney3, String str33, MultiCurrencyMoney multiCurrencyMoney4, Long l3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? "" : str6, (i & 256) != 0 ? "" : str7, (i & 512) != 0 ? null : list, (i & 1024) != 0 ? "" : str8, (i & 2048) != 0 ? "" : str9, (i & 4096) != 0 ? "" : str10, (i & 8192) != 0 ? "" : str11, (i & 16384) != 0 ? "" : str12, (i & 32768) != 0 ? null : moneyViewEntity, (i & 65536) != 0 ? "" : str13, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? "" : str14, (i & 262144) != 0 ? "" : str15, (i & 524288) != 0 ? "" : str16, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? "" : str17, (i & 2097152) != 0 ? "" : str18, (i & 4194304) != 0 ? "" : str19, (i & 8388608) != 0 ? "" : str20, (i & 16777216) != 0 ? null : l, (i & 33554432) != 0 ? null : l2, (i & 67108864) != 0 ? "" : str21, (i & 134217728) != 0 ? null : moneyViewEntity2, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : moneyViewEntity3, (i & 536870912) != 0 ? null : list2, (i & 1073741824) != 0 ? "" : str22, (i & Integer.MIN_VALUE) != 0 ? "" : str23, (i2 & 1) != 0 ? "" : str24, (i2 & 2) != 0 ? "" : str25, (i2 & 4) != 0 ? "" : str26, (i2 & 8) != 0 ? "" : str27, (i2 & 16) != 0 ? "" : str28, (i2 & 32) != 0 ? "" : str29, (i2 & 64) != 0 ? "" : str30, (i2 & 128) != 0 ? "" : str31, (i2 & 256) != 0 ? null : inquiryStatus, (i2 & 512) != 0 ? null : moneyViewEntity4, (i2 & 1024) != 0 ? null : moneyViewEntity5, (i2 & 2048) != 0 ? null : moneyViewEntity6, (i2 & 4096) != 0 ? null : moneyViewEntity7, (i2 & 8192) != 0 ? "" : str32, (i2 & 16384) != 0 ? null : list3, (i2 & 32768) != 0 ? null : multiCurrencyMoney, (i2 & 65536) != 0 ? null : multiCurrencyMoney2, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : multiCurrencyMoney3, (i2 & 262144) != 0 ? "" : str33, (i2 & 524288) != 0 ? null : multiCurrencyMoney4, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : l3);
    }

    @JvmName(name = "getAuthKey")
    public final String getAuthKey() {
        return this.authKey;
    }

    @JvmName(name = "getBillCycle")
    public final String getBillCycle() {
        return this.billCycle;
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

    @JvmName(name = "getDetailAmount")
    public final List<BillAmountDetail> getDetailAmount() {
        return this.detailAmount;
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

    @JvmName(name = "getUsage")
    public final String getUsage() {
        return this.usage;
    }

    @JvmName(name = "getLoad")
    public final String getLoad() {
        return this.load;
    }

    @JvmName(name = "getTagNonAir")
    public final MoneyViewEntity getTagNonAir() {
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

    @JvmName(name = "getRefNumber")
    public final String getRefNumber() {
        return this.refNumber;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getCertifiedNumber")
    public final String getCertifiedNumber() {
        return this.certifiedNumber;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getStartDate")
    public final Long getStartDate() {
        return this.startDate;
    }

    @JvmName(name = "getEndDate")
    public final Long getEndDate() {
        return this.endDate;
    }

    @JvmName(name = "getQuantity")
    public final String getQuantity() {
        return this.quantity;
    }

    @JvmName(name = "getMinimumPayAmount")
    public final MoneyViewEntity getMinimumPayAmount() {
        return this.minimumPayAmount;
    }

    @JvmName(name = "getMaximumPayAmount")
    public final MoneyViewEntity getMaximumPayAmount() {
        return this.maximumPayAmount;
    }

    @JvmName(name = "getBillerMessages")
    public final List<String> getBillerMessages() {
        return this.billerMessages;
    }

    @JvmName(name = "getExtendInfo")
    public final String getExtendInfo() {
        return this.extendInfo;
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

    @JvmName(name = "getInquiryId")
    public final String getInquiryId() {
        return this.inquiryId;
    }

    @JvmName(name = "getInquiryStatus")
    public final InquiryStatus getInquiryStatus() {
        return this.inquiryStatus;
    }

    @JvmName(name = "getDisplayTotalAmount")
    public final MoneyViewEntity getDisplayTotalAmount() {
        return this.displayTotalAmount;
    }

    @JvmName(name = "getDisplayBaseAmount")
    public final MoneyViewEntity getDisplayBaseAmount() {
        return this.displayBaseAmount;
    }

    @JvmName(name = "getDisplayAdminFee")
    public final MoneyViewEntity getDisplayAdminFee() {
        return this.displayAdminFee;
    }

    @JvmName(name = "getDisplayFineAmount")
    public final MoneyViewEntity getDisplayFineAmount() {
        return this.displayFineAmount;
    }

    @JvmName(name = "getCustomerName")
    public final String getCustomerName() {
        return this.customerName;
    }

    @JvmName(name = "getPeriod")
    public final List<Long> getPeriod() {
        return this.period;
    }

    @JvmName(name = "getTotalAmount")
    public final MultiCurrencyMoney getTotalAmount() {
        return this.totalAmount;
    }

    @JvmName(name = "getBaseAmount")
    public final MultiCurrencyMoney getBaseAmount() {
        return this.baseAmount;
    }

    @JvmName(name = "getAdminFee")
    public final MultiCurrencyMoney getAdminFee() {
        return this.adminFee;
    }

    @JvmName(name = "getProviderName")
    public final String getProviderName() {
        return this.providerName;
    }

    @JvmName(name = "getFineAmount")
    public final MultiCurrencyMoney getFineAmount() {
        return this.fineAmount;
    }

    @JvmName(name = "getDueDate")
    public final Long getDueDate() {
        return this.dueDate;
    }
}
