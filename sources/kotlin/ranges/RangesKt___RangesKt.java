package kotlin.ranges;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.CharProgression;
import kotlin.ranges.IntProgression;
import kotlin.ranges.LongProgression;

@Metadata(d1 = {"\u0000~\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b8\u001a)\u0010\u0003\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u0019\u0010\u0003\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\b\u001a\u0019\u0010\u0003\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\t¢\u0006\u0004\b\u0003\u0010\n\u001a\u0019\u0010\u0003\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b¢\u0006\u0004\b\u0003\u0010\f\u001a\u0019\u0010\u0003\u001a\u00020\r*\u00020\r2\u0006\u0010\u0002\u001a\u00020\r¢\u0006\u0004\b\u0003\u0010\u000e\u001a\u0019\u0010\u0003\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f¢\u0006\u0004\b\u0003\u0010\u0010\u001a)\u0010\u0012\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0004\u001a\u0019\u0010\u0012\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0006\u001a\u0019\u0010\u0012\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\b\u001a\u0019\u0010\u0012\u001a\u00020\t*\u00020\t2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\n\u001a\u0019\u0010\u0012\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\f\u001a\u0019\u0010\u0012\u001a\u00020\r*\u00020\r2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u000e\u001a\u0019\u0010\u0012\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0010\u001a5\u0010\u0013\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u00002\b\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0013\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0004\b\u0013\u0010\u0017\u001a/\u0010\u0013\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u0013\u0010\u0019\u001a!\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u001a\u001a!\u0010\u0013\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u001b\u001a!\u0010\u0013\u001a\u00020\t*\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u001c\u001a!\u0010\u0013\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u001d\u001a\u001f\u0010\u0013\u001a\u00020\u000b*\u00020\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0004\b\u0013\u0010\u001e\u001a!\u0010\u0013\u001a\u00020\r*\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u001f\u001a\u001f\u0010\u0013\u001a\u00020\r*\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0018¢\u0006\u0004\b\u0013\u0010 \u001a!\u0010\u0013\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010!\u001a\u001e\u0010&\u001a\u00020%*\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010#H\u0086\n¢\u0006\u0004\b&\u0010'\u001a\"\u0010)\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b)\u0010*\u001a\"\u0010)\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010(\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b)\u0010+\u001a\"\u0010)\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010(\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b)\u0010,\u001a\"\u0010)\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010(\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b)\u0010-\u001a\"\u0010)\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00050\u00182\u0006\u0010(\u001a\u00020\u000fH\u0086\u0002¢\u0006\u0004\b)\u0010.\u001a\"\u0010/\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010(\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b/\u00100\u001a\"\u0010/\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010(\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b/\u0010+\u001a\"\u0010/\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010(\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b/\u0010,\u001a\"\u0010/\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010(\u001a\u00020\rH\u0087\u0002¢\u0006\u0004\b/\u0010-\u001a\"\u0010/\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010(\u001a\u00020\u000fH\u0087\u0002¢\u0006\u0004\b/\u0010.\u001a\"\u00101\u001a\u00020%*\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010(\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\b1\u00100\u001a\"\u00101\u001a\u00020%*\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010(\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b1\u0010*\u001a\"\u00101\u001a\u00020%*\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010(\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\b1\u0010,\u001a\"\u00101\u001a\u00020%*\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010(\u001a\u00020\rH\u0087\u0002¢\u0006\u0004\b1\u0010-\u001a\"\u00101\u001a\u00020%*\b\u0012\u0004\u0012\u00020\t0\u00182\u0006\u0010(\u001a\u00020\u000fH\u0087\u0002¢\u0006\u0004\b1\u0010.\u001a\"\u00102\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010(\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\b2\u00100\u001a\"\u00102\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b2\u0010*\u001a\"\u00102\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010(\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b2\u0010+\u001a\"\u00102\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010(\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b2\u0010-\u001a\"\u00102\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010(\u001a\u00020\u000fH\u0086\u0002¢\u0006\u0004\b2\u0010.\u001a\"\u00103\u001a\u00020%*\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010(\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\b3\u00100\u001a\"\u00103\u001a\u00020%*\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b3\u0010*\u001a\"\u00103\u001a\u00020%*\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010(\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b3\u0010+\u001a\"\u00103\u001a\u00020%*\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010(\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b3\u0010,\u001a\"\u00103\u001a\u00020%*\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010(\u001a\u00020\u000fH\u0086\u0002¢\u0006\u0004\b3\u0010.\u001a\"\u00104\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010(\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\b4\u00100\u001a\"\u00104\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010(\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0004\b4\u0010*\u001a\"\u00104\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010(\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b4\u0010+\u001a\"\u00104\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010(\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b4\u0010,\u001a\"\u00104\u001a\u00020%*\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010(\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b4\u0010-\u001a\u001e\u0010&\u001a\u00020%*\u0002052\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0086\n¢\u0006\u0004\b&\u00106\u001a\u001e\u0010&\u001a\u00020%*\u0002072\b\u0010$\u001a\u0004\u0018\u00010\rH\u0086\n¢\u0006\u0004\b&\u00108\u001a\u001c\u0010;\u001a\u00020:*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b;\u0010<\u001a\u001c\u0010;\u001a\u00020:*\u00020\u00052\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\b;\u0010=\u001a\u001c\u0010;\u001a\u00020>*\u00020\u00052\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\b;\u0010?\u001a\u001c\u0010;\u001a\u00020:*\u00020\u00052\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\b;\u0010@\u001a\u001c\u0010;\u001a\u00020A*\u00020#2\u0006\u00109\u001a\u00020#H\u0086\u0004¢\u0006\u0004\b;\u0010B\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000b2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b;\u0010C\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\b;\u0010D\u001a\u001c\u0010;\u001a\u00020>*\u00020\u000b2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\b;\u0010E\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000b2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\b;\u0010F\u001a\u001c\u0010;\u001a\u00020>*\u00020\r2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b;\u0010G\u001a\u001c\u0010;\u001a\u00020>*\u00020\r2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\b;\u0010H\u001a\u001c\u0010;\u001a\u00020>*\u00020\r2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\b;\u0010I\u001a\u001c\u0010;\u001a\u00020>*\u00020\r2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\b;\u0010J\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000f2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\b;\u0010K\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000f2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\b;\u0010L\u001a\u001c\u0010;\u001a\u00020>*\u00020\u000f2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\b;\u0010M\u001a\u001c\u0010;\u001a\u00020:*\u00020\u000f2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\b;\u0010N\u001a\u0014\u0010O\u001a\u00020#*\u00020\"H\u0086\b¢\u0006\u0004\bO\u0010P\u001a\u0019\u0010O\u001a\u00020#*\u00020\"2\u0006\u0010O\u001a\u00020Q¢\u0006\u0004\bO\u0010R\u001a\u0014\u0010O\u001a\u00020\u000b*\u000205H\u0086\b¢\u0006\u0004\bO\u0010S\u001a\u0019\u0010O\u001a\u00020\u000b*\u0002052\u0006\u0010O\u001a\u00020Q¢\u0006\u0004\bO\u0010T\u001a\u0014\u0010O\u001a\u00020\r*\u000207H\u0086\b¢\u0006\u0004\bO\u0010U\u001a\u0019\u0010O\u001a\u00020\r*\u0002072\u0006\u0010O\u001a\u00020Q¢\u0006\u0004\bO\u0010V\u001a\u0016\u0010W\u001a\u0004\u0018\u00010#*\u00020\"H\u0086\b¢\u0006\u0004\bW\u0010X\u001a\u001b\u0010W\u001a\u0004\u0018\u00010#*\u00020\"2\u0006\u0010O\u001a\u00020Q¢\u0006\u0004\bW\u0010Y\u001a\u0016\u0010W\u001a\u0004\u0018\u00010\u000b*\u000205H\u0086\b¢\u0006\u0004\bW\u0010Z\u001a\u001b\u0010W\u001a\u0004\u0018\u00010\u000b*\u0002052\u0006\u0010O\u001a\u00020Q¢\u0006\u0004\bW\u0010[\u001a\u0016\u0010W\u001a\u0004\u0018\u00010\r*\u000207H\u0086\b¢\u0006\u0004\bW\u0010\\\u001a\u001b\u0010W\u001a\u0004\u0018\u00010\r*\u0002072\u0006\u0010O\u001a\u00020Q¢\u0006\u0004\bW\u0010]\u001a\u0011\u0010^\u001a\u00020A*\u00020A¢\u0006\u0004\b^\u0010_\u001a\u0011\u0010^\u001a\u00020:*\u00020:¢\u0006\u0004\b^\u0010`\u001a\u0011\u0010^\u001a\u00020>*\u00020>¢\u0006\u0004\b^\u0010a\u001a\u001c\u0010b\u001a\u00020A*\u00020A2\u0006\u0010b\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\bb\u0010c\u001a\u001c\u0010b\u001a\u00020:*\u00020:2\u0006\u0010b\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\bb\u0010d\u001a\u001c\u0010b\u001a\u00020>*\u00020>2\u0006\u0010b\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\bb\u0010e\u001a\u0015\u0010f\u001a\u0004\u0018\u00010\u0005*\u00020\u0007H\u0000¢\u0006\u0004\bf\u0010g\u001a\u0015\u0010f\u001a\u0004\u0018\u00010\u0005*\u00020\tH\u0000¢\u0006\u0004\bf\u0010h\u001a\u0015\u0010f\u001a\u0004\u0018\u00010\u0005*\u00020\u000bH\u0000¢\u0006\u0004\bf\u0010i\u001a\u0015\u0010f\u001a\u0004\u0018\u00010\u0005*\u00020\rH\u0000¢\u0006\u0004\bf\u0010j\u001a\u0015\u0010f\u001a\u0004\u0018\u00010\u0005*\u00020\u000fH\u0000¢\u0006\u0004\bf\u0010k\u001a\u0015\u0010l\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0000¢\u0006\u0004\bl\u0010m\u001a\u0015\u0010l\u001a\u0004\u0018\u00010\u000b*\u00020\tH\u0000¢\u0006\u0004\bl\u0010n\u001a\u0015\u0010l\u001a\u0004\u0018\u00010\u000b*\u00020\rH\u0000¢\u0006\u0004\bl\u0010o\u001a\u0015\u0010p\u001a\u0004\u0018\u00010\r*\u00020\u0007H\u0000¢\u0006\u0004\bp\u0010q\u001a\u0015\u0010p\u001a\u0004\u0018\u00010\r*\u00020\tH\u0000¢\u0006\u0004\bp\u0010r\u001a\u0015\u0010s\u001a\u0004\u0018\u00010\u000f*\u00020\u0007H\u0000¢\u0006\u0004\bs\u0010t\u001a\u0015\u0010s\u001a\u0004\u0018\u00010\u000f*\u00020\tH\u0000¢\u0006\u0004\bs\u0010u\u001a\u0015\u0010s\u001a\u0004\u0018\u00010\u000f*\u00020\u000bH\u0000¢\u0006\u0004\bs\u0010v\u001a\u0015\u0010s\u001a\u0004\u0018\u00010\u000f*\u00020\rH\u0000¢\u0006\u0004\bs\u0010w\u001a\u001c\u0010x\u001a\u000205*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\bx\u0010y\u001a\u001c\u0010x\u001a\u000205*\u00020\u00052\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\bx\u0010z\u001a\u001c\u0010x\u001a\u000207*\u00020\u00052\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\bx\u0010{\u001a\u001c\u0010x\u001a\u000205*\u00020\u00052\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0004\bx\u0010|\u001a\u001c\u0010x\u001a\u00020\"*\u00020#2\u0006\u00109\u001a\u00020#H\u0086\u0004¢\u0006\u0004\bx\u0010}\u001a\u001c\u0010x\u001a\u000205*\u00020\u000b2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0004\bx\u0010~\u001a\u001c\u0010x\u001a\u000205*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0004\bx\u0010\u007f\u001a\u001d\u0010x\u001a\u000207*\u00020\u000b2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0005\bx\u0010\u0080\u0001\u001a\u001d\u0010x\u001a\u000205*\u00020\u000b2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0005\bx\u0010\u0081\u0001\u001a\u001d\u0010x\u001a\u000207*\u00020\r2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0005\bx\u0010\u0082\u0001\u001a\u001d\u0010x\u001a\u000207*\u00020\r2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0005\bx\u0010\u0083\u0001\u001a\u001d\u0010x\u001a\u000207*\u00020\r2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0005\bx\u0010\u0084\u0001\u001a\u001d\u0010x\u001a\u000207*\u00020\r2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0005\bx\u0010\u0085\u0001\u001a\u001d\u0010x\u001a\u000205*\u00020\u000f2\u0006\u00109\u001a\u00020\u0005H\u0086\u0004¢\u0006\u0005\bx\u0010\u0086\u0001\u001a\u001d\u0010x\u001a\u000205*\u00020\u000f2\u0006\u00109\u001a\u00020\u000bH\u0086\u0004¢\u0006\u0005\bx\u0010\u0087\u0001\u001a\u001d\u0010x\u001a\u000207*\u00020\u000f2\u0006\u00109\u001a\u00020\rH\u0086\u0004¢\u0006\u0005\bx\u0010\u0088\u0001\u001a\u001d\u0010x\u001a\u000205*\u00020\u000f2\u0006\u00109\u001a\u00020\u000fH\u0086\u0004¢\u0006\u0005\bx\u0010\u0089\u0001"}, d2 = {"", "T", "minimumValue", "coerceAtLeast", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "(BB)B", "", "(DD)D", "", "(FF)F", "", "(II)I", "", "(JJ)J", "", "(SS)S", "maximumValue", "coerceAtMost", "coerceIn", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedFloatingPointRange;", "range", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "Lkotlin/ranges/ClosedRange;", "(Ljava/lang/Comparable;Lkotlin/ranges/ClosedRange;)Ljava/lang/Comparable;", "(BBB)B", "(DDD)D", "(FFF)F", "(III)I", "(ILkotlin/ranges/ClosedRange;)I", "(JJJ)J", "(JLkotlin/ranges/ClosedRange;)J", "(SSS)S", "Lkotlin/ranges/CharRange;", "", LottieParams.KEY_ELEMENT_ID, "", "contains", "(Lkotlin/ranges/CharRange;Ljava/lang/Character;)Z", "value", "byteRangeContains", "(Lkotlin/ranges/ClosedRange;D)Z", "(Lkotlin/ranges/ClosedRange;F)Z", "(Lkotlin/ranges/ClosedRange;I)Z", "(Lkotlin/ranges/ClosedRange;J)Z", "(Lkotlin/ranges/ClosedRange;S)Z", "doubleRangeContains", "(Lkotlin/ranges/ClosedRange;B)Z", "floatRangeContains", "intRangeContains", "longRangeContains", "shortRangeContains", "Lkotlin/ranges/IntRange;", "(Lkotlin/ranges/IntRange;Ljava/lang/Integer;)Z", "Lkotlin/ranges/LongRange;", "(Lkotlin/ranges/LongRange;Ljava/lang/Long;)Z", LoginTrackingConstants.LoginParam.TO, "Lkotlin/ranges/IntProgression;", "downTo", "(BB)Lkotlin/ranges/IntProgression;", "(BI)Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/LongProgression;", "(BJ)Lkotlin/ranges/LongProgression;", "(BS)Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/CharProgression;", "(CC)Lkotlin/ranges/CharProgression;", "(IB)Lkotlin/ranges/IntProgression;", "(II)Lkotlin/ranges/IntProgression;", "(IJ)Lkotlin/ranges/LongProgression;", "(IS)Lkotlin/ranges/IntProgression;", "(JB)Lkotlin/ranges/LongProgression;", "(JI)Lkotlin/ranges/LongProgression;", "(JJ)Lkotlin/ranges/LongProgression;", "(JS)Lkotlin/ranges/LongProgression;", "(SB)Lkotlin/ranges/IntProgression;", "(SI)Lkotlin/ranges/IntProgression;", "(SJ)Lkotlin/ranges/LongProgression;", "(SS)Lkotlin/ranges/IntProgression;", "random", "(Lkotlin/ranges/CharRange;)C", "Lkotlin/random/Random;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)C", "(Lkotlin/ranges/IntRange;)I", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/LongRange;)J", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)J", "randomOrNull", "(Lkotlin/ranges/CharRange;)Ljava/lang/Character;", "(Lkotlin/ranges/CharRange;Lkotlin/random/Random;)Ljava/lang/Character;", "(Lkotlin/ranges/IntRange;)Ljava/lang/Integer;", "(Lkotlin/ranges/IntRange;Lkotlin/random/Random;)Ljava/lang/Integer;", "(Lkotlin/ranges/LongRange;)Ljava/lang/Long;", "(Lkotlin/ranges/LongRange;Lkotlin/random/Random;)Ljava/lang/Long;", "reversed", "(Lkotlin/ranges/CharProgression;)Lkotlin/ranges/CharProgression;", "(Lkotlin/ranges/IntProgression;)Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/LongProgression;)Lkotlin/ranges/LongProgression;", "step", "(Lkotlin/ranges/CharProgression;I)Lkotlin/ranges/CharProgression;", "(Lkotlin/ranges/IntProgression;I)Lkotlin/ranges/IntProgression;", "(Lkotlin/ranges/LongProgression;J)Lkotlin/ranges/LongProgression;", "toByteExactOrNull", "(D)Ljava/lang/Byte;", "(F)Ljava/lang/Byte;", "(I)Ljava/lang/Byte;", "(J)Ljava/lang/Byte;", "(S)Ljava/lang/Byte;", "toIntExactOrNull", "(D)Ljava/lang/Integer;", "(F)Ljava/lang/Integer;", "(J)Ljava/lang/Integer;", "toLongExactOrNull", "(D)Ljava/lang/Long;", "(F)Ljava/lang/Long;", "toShortExactOrNull", "(D)Ljava/lang/Short;", "(F)Ljava/lang/Short;", "(I)Ljava/lang/Short;", "(J)Ljava/lang/Short;", "until", "(BB)Lkotlin/ranges/IntRange;", "(BI)Lkotlin/ranges/IntRange;", "(BJ)Lkotlin/ranges/LongRange;", "(BS)Lkotlin/ranges/IntRange;", "(CC)Lkotlin/ranges/CharRange;", "(IB)Lkotlin/ranges/IntRange;", "(II)Lkotlin/ranges/IntRange;", "(IJ)Lkotlin/ranges/LongRange;", "(IS)Lkotlin/ranges/IntRange;", "(JB)Lkotlin/ranges/LongRange;", "(JI)Lkotlin/ranges/LongRange;", "(JJ)Lkotlin/ranges/LongRange;", "(JS)Lkotlin/ranges/LongRange;", "(SB)Lkotlin/ranges/IntRange;", "(SI)Lkotlin/ranges/IntRange;", "(SJ)Lkotlin/ranges/LongRange;", "(SS)Lkotlin/ranges/IntRange;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/ranges/RangesKt")
/* loaded from: classes.dex */
public class RangesKt___RangesKt extends RangesKt__RangesKt {
    public static final byte coerceAtLeast(byte b, byte b2) {
        return b < b2 ? b2 : b;
    }

    public static final double coerceAtLeast(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    public static final float coerceAtLeast(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static final int coerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static final short coerceAtLeast(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    public static final byte coerceAtMost(byte b, byte b2) {
        return b > b2 ? b2 : b;
    }

    public static final double coerceAtMost(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    public static final float coerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static final int coerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final short coerceAtMost(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    private static final int random(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "");
        return RangesKt.random(intRange, Random.INSTANCE);
    }

    private static final long random(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, "");
        return RangesKt.random(longRange, Random.INSTANCE);
    }

    private static final char random(CharRange charRange) {
        Intrinsics.checkNotNullParameter(charRange, "");
        return RangesKt.random(charRange, Random.INSTANCE);
    }

    public static final int random(IntRange intRange, Random random) {
        Intrinsics.checkNotNullParameter(intRange, "");
        Intrinsics.checkNotNullParameter(random, "");
        try {
            return RandomKt.nextInt(random, intRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(LongRange longRange, Random random) {
        Intrinsics.checkNotNullParameter(longRange, "");
        Intrinsics.checkNotNullParameter(random, "");
        try {
            return RandomKt.nextLong(random, longRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final char random(CharRange charRange, Random random) {
        Intrinsics.checkNotNullParameter(charRange, "");
        Intrinsics.checkNotNullParameter(random, "");
        try {
            return (char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final Integer randomOrNull(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "");
        return RangesKt.randomOrNull(intRange, Random.INSTANCE);
    }

    private static final Long randomOrNull(LongRange longRange) {
        Intrinsics.checkNotNullParameter(longRange, "");
        return RangesKt.randomOrNull(longRange, Random.INSTANCE);
    }

    private static final Character randomOrNull(CharRange charRange) {
        Intrinsics.checkNotNullParameter(charRange, "");
        return RangesKt.randomOrNull(charRange, Random.INSTANCE);
    }

    public static final Integer randomOrNull(IntRange intRange, Random random) {
        Intrinsics.checkNotNullParameter(intRange, "");
        Intrinsics.checkNotNullParameter(random, "");
        if (intRange.isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.nextInt(random, intRange));
    }

    public static final Long randomOrNull(LongRange longRange, Random random) {
        Intrinsics.checkNotNullParameter(longRange, "");
        Intrinsics.checkNotNullParameter(random, "");
        if (longRange.isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.nextLong(random, longRange));
    }

    public static final Character randomOrNull(CharRange charRange, Random random) {
        Intrinsics.checkNotNullParameter(charRange, "");
        Intrinsics.checkNotNullParameter(random, "");
        if (charRange.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1));
    }

    private static final boolean contains(IntRange intRange, Integer num) {
        Intrinsics.checkNotNullParameter(intRange, "");
        return num != null && intRange.contains(num.intValue());
    }

    private static final boolean contains(LongRange longRange, Long l) {
        Intrinsics.checkNotNullParameter(longRange, "");
        return l != null && longRange.contains(l.longValue());
    }

    private static final boolean contains(CharRange charRange, Character ch) {
        Intrinsics.checkNotNullParameter(charRange, "");
        return ch != null && charRange.contains(ch.charValue());
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Integer.valueOf(b));
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Long.valueOf(b));
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Short.valueOf(b));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Double.valueOf(b));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Float.valueOf(b));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Integer intExactOrNull = RangesKt.toIntExactOrNull(d);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Long longExactOrNull = RangesKt.toLongExactOrNull(d);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(d);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Short shortExactOrNull = RangesKt.toShortExactOrNull(d);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final boolean floatRangeContains(ClosedRange<Float> closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Float.valueOf((float) d));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean intRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Integer intExactOrNull = RangesKt.toIntExactOrNull(f);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean longRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Long longExactOrNull = RangesKt.toLongExactOrNull(f);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean byteRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(f);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean shortRangeContains(ClosedRange closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Short shortExactOrNull = RangesKt.toShortExactOrNull(f);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    public static final boolean doubleRangeContains(ClosedRange<Double> closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Double.valueOf(f));
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Long.valueOf(i));
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(i);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Short shortExactOrNull = RangesKt.toShortExactOrNull(i);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Double.valueOf(i));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Float.valueOf(i));
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Integer intExactOrNull = RangesKt.toIntExactOrNull(j);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(j);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final boolean shortRangeContains(ClosedRange<Short> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Short shortExactOrNull = RangesKt.toShortExactOrNull(j);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Double.valueOf(j));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Float.valueOf((float) j));
    }

    public static final boolean intRangeContains(ClosedRange<Integer> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Integer.valueOf(s));
    }

    public static final boolean longRangeContains(ClosedRange<Long> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Long.valueOf(s));
    }

    public static final boolean byteRangeContains(ClosedRange<Byte> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        Byte byteExactOrNull = RangesKt.toByteExactOrNull(s);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean doubleRangeContains(ClosedRange closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Double.valueOf(s));
    }

    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean floatRangeContains(ClosedRange closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        return closedRange.contains(Float.valueOf(s));
    }

    public static final IntProgression downTo(int i, byte b) {
        return IntProgression.INSTANCE.fromClosedRange(i, b, -1);
    }

    public static final LongProgression downTo(long j, byte b) {
        return LongProgression.INSTANCE.fromClosedRange(j, b, -1L);
    }

    public static final IntProgression downTo(byte b, byte b2) {
        return IntProgression.INSTANCE.fromClosedRange(b, b2, -1);
    }

    public static final IntProgression downTo(short s, byte b) {
        return IntProgression.INSTANCE.fromClosedRange(s, b, -1);
    }

    public static final CharProgression downTo(char c, char c2) {
        return CharProgression.INSTANCE.fromClosedRange(c, c2, -1);
    }

    public static final IntProgression downTo(int i, int i2) {
        return IntProgression.INSTANCE.fromClosedRange(i, i2, -1);
    }

    public static final LongProgression downTo(long j, int i) {
        return LongProgression.INSTANCE.fromClosedRange(j, i, -1L);
    }

    public static final IntProgression downTo(byte b, int i) {
        return IntProgression.INSTANCE.fromClosedRange(b, i, -1);
    }

    public static final IntProgression downTo(short s, int i) {
        return IntProgression.INSTANCE.fromClosedRange(s, i, -1);
    }

    public static final LongProgression downTo(int i, long j) {
        return LongProgression.INSTANCE.fromClosedRange(i, j, -1L);
    }

    public static final LongProgression downTo(long j, long j2) {
        return LongProgression.INSTANCE.fromClosedRange(j, j2, -1L);
    }

    public static final LongProgression downTo(byte b, long j) {
        return LongProgression.INSTANCE.fromClosedRange(b, j, -1L);
    }

    public static final LongProgression downTo(short s, long j) {
        return LongProgression.INSTANCE.fromClosedRange(s, j, -1L);
    }

    public static final IntProgression downTo(int i, short s) {
        return IntProgression.INSTANCE.fromClosedRange(i, s, -1);
    }

    public static final LongProgression downTo(long j, short s) {
        return LongProgression.INSTANCE.fromClosedRange(j, s, -1L);
    }

    public static final IntProgression downTo(byte b, short s) {
        return IntProgression.INSTANCE.fromClosedRange(b, s, -1);
    }

    public static final IntProgression downTo(short s, short s2) {
        return IntProgression.INSTANCE.fromClosedRange(s, s2, -1);
    }

    public static final IntProgression reversed(IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "");
        return IntProgression.INSTANCE.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    public static final LongProgression reversed(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "");
        return LongProgression.INSTANCE.fromClosedRange(longProgression.getLast(), longProgression.getFirst(), -longProgression.getStep());
    }

    public static final CharProgression reversed(CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "");
        return CharProgression.INSTANCE.fromClosedRange(charProgression.getLast(), charProgression.getFirst(), -charProgression.getStep());
    }

    public static final IntProgression step(IntProgression intProgression, int i) {
        Intrinsics.checkNotNullParameter(intProgression, "");
        RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.INSTANCE;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static final LongProgression step(LongProgression longProgression, long j) {
        Intrinsics.checkNotNullParameter(longProgression, "");
        RangesKt.checkStepIsPositive(j > 0, Long.valueOf(j));
        LongProgression.Companion companion = LongProgression.INSTANCE;
        long first = longProgression.getFirst();
        long last = longProgression.getLast();
        if (longProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.fromClosedRange(first, last, j);
    }

    public static final CharProgression step(CharProgression charProgression, int i) {
        Intrinsics.checkNotNullParameter(charProgression, "");
        RangesKt.checkStepIsPositive(i > 0, Integer.valueOf(i));
        CharProgression.Companion companion = CharProgression.INSTANCE;
        char first = charProgression.getFirst();
        char last = charProgression.getLast();
        if (charProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    public static final Byte toByteExactOrNull(int i) {
        boolean z = false;
        if (i <= 127 && -128 <= i) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) i);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(long j) {
        boolean z = false;
        if (j <= 127 && -128 <= j) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) j);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(short s) {
        boolean z = false;
        if (-128 <= s && s <= 127) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(double d) {
        boolean z = false;
        if (d <= 127.0d && -128.0d <= d) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) d);
        }
        return null;
    }

    public static final Byte toByteExactOrNull(float f) {
        boolean z = false;
        if (f <= 127.0f && -128.0f <= f) {
            z = true;
        }
        if (z) {
            return Byte.valueOf((byte) f);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(long j) {
        boolean z = false;
        if (j <= 2147483647L && -2147483648L <= j) {
            z = true;
        }
        if (z) {
            return Integer.valueOf((int) j);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(double d) {
        boolean z = false;
        if (d <= 2.147483647E9d && -2.147483648E9d <= d) {
            z = true;
        }
        if (z) {
            return Integer.valueOf((int) d);
        }
        return null;
    }

    public static final Integer toIntExactOrNull(float f) {
        boolean z = false;
        if (f <= 2.14748365E9f && -2.14748365E9f <= f) {
            z = true;
        }
        if (z) {
            return Integer.valueOf((int) f);
        }
        return null;
    }

    public static final Long toLongExactOrNull(double d) {
        boolean z = false;
        if (d <= 9.223372036854776E18d && -9.223372036854776E18d <= d) {
            z = true;
        }
        if (z) {
            return Long.valueOf((long) d);
        }
        return null;
    }

    public static final Long toLongExactOrNull(float f) {
        boolean z = false;
        if (f <= 9.223372E18f && -9.223372E18f <= f) {
            z = true;
        }
        if (z) {
            return Long.valueOf(f);
        }
        return null;
    }

    public static final Short toShortExactOrNull(int i) {
        boolean z = false;
        if (i <= 32767 && -32768 <= i) {
            z = true;
        }
        if (z) {
            return Short.valueOf((short) i);
        }
        return null;
    }

    public static final Short toShortExactOrNull(long j) {
        boolean z = false;
        if (j <= 32767 && -32768 <= j) {
            z = true;
        }
        if (z) {
            return Short.valueOf((short) j);
        }
        return null;
    }

    public static final Short toShortExactOrNull(double d) {
        boolean z = false;
        if (d <= 32767.0d && -32768.0d <= d) {
            z = true;
        }
        if (z) {
            return Short.valueOf((short) d);
        }
        return null;
    }

    public static final Short toShortExactOrNull(float f) {
        boolean z = false;
        if (f <= 32767.0f && -32768.0f <= f) {
            z = true;
        }
        if (z) {
            return Short.valueOf((short) f);
        }
        return null;
    }

    public static final IntRange until(int i, byte b) {
        return new IntRange(i, b - 1);
    }

    public static final LongRange until(long j, byte b) {
        return new LongRange(j, b - 1);
    }

    public static final IntRange until(byte b, byte b2) {
        return new IntRange(b, b2 - 1);
    }

    public static final IntRange until(short s, byte b) {
        return new IntRange(s, b - 1);
    }

    public static final CharRange until(char c, char c2) {
        return Intrinsics.compare((int) c2, 0) <= 0 ? CharRange.INSTANCE.getEMPTY() : new CharRange(c, (char) (c2 - 1));
    }

    public static final IntRange until(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(i, i2 - 1);
    }

    public static final LongRange until(long j, int i) {
        return new LongRange(j, i - 1);
    }

    public static final IntRange until(byte b, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(b, i - 1);
    }

    public static final IntRange until(short s, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.INSTANCE.getEMPTY();
        }
        return new IntRange(s, i - 1);
    }

    public static final LongRange until(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(i, j - 1);
    }

    public static final LongRange until(long j, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(j, j2 - 1);
    }

    public static final LongRange until(byte b, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(b, j - 1);
    }

    public static final LongRange until(short s, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.INSTANCE.getEMPTY();
        }
        return new LongRange(s, j - 1);
    }

    public static final IntRange until(int i, short s) {
        return new IntRange(i, s - 1);
    }

    public static final LongRange until(long j, short s) {
        return new LongRange(j, s - 1);
    }

    public static final IntRange until(byte b, short s) {
        return new IntRange(b, s - 1);
    }

    public static final IntRange until(short s, short s2) {
        return new IntRange(s, s2 - 1);
    }

    public static final <T extends Comparable<? super T>> T coerceAtLeast(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "");
        Intrinsics.checkNotNullParameter(t2, "");
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    public static final <T extends Comparable<? super T>> T coerceAtMost(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "");
        Intrinsics.checkNotNullParameter(t2, "");
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, T t2, T t3) {
        Intrinsics.checkNotNullParameter(t, "");
        if (t2 != null && t3 != null) {
            if (t2.compareTo(t3) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot coerce value to an empty range: maximum ");
                sb.append(t3);
                sb.append(" is less than minimum ");
                sb.append(t2);
                sb.append('.');
                throw new IllegalArgumentException(sb.toString());
            } else if (t.compareTo(t2) < 0) {
                return t2;
            } else {
                if (t.compareTo(t3) > 0) {
                    return t3;
                }
            }
        } else if (t2 != null && t.compareTo(t2) < 0) {
            return t2;
        } else {
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    public static final byte coerceIn(byte b, byte b2, byte b3) {
        if (b2 <= b3) {
            return b < b2 ? b2 : b > b3 ? b3 : b;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: maximum ");
        sb.append((int) b3);
        sb.append(" is less than minimum ");
        sb.append((int) b2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final short coerceIn(short s, short s2, short s3) {
        if (s2 <= s3) {
            return s < s2 ? s2 : s > s3 ? s3 : s;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: maximum ");
        sb.append((int) s3);
        sb.append(" is less than minimum ");
        sb.append((int) s2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final int coerceIn(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: maximum ");
        sb.append(i3);
        sb.append(" is less than minimum ");
        sb.append(i2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final long coerceIn(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: maximum ");
        sb.append(j3);
        sb.append(" is less than minimum ");
        sb.append(j2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final float coerceIn(float f, float f2, float f3) {
        if (f2 <= f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: maximum ");
        sb.append(f3);
        sb.append(" is less than minimum ");
        sb.append(f2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final double coerceIn(double d, double d2, double d3) {
        if (d2 <= d3) {
            return d < d2 ? d2 : d > d3 ? d3 : d;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: maximum ");
        sb.append(d3);
        sb.append(" is less than minimum ");
        sb.append(d2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(t, "");
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "");
        if (!closedFloatingPointRange.isEmpty()) {
            return (!closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getStart()) || closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), t)) ? (!closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getEndInclusive(), t) || closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getEndInclusive())) ? t : closedFloatingPointRange.getEndInclusive() : closedFloatingPointRange.getStart();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: ");
        sb.append(closedFloatingPointRange);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedRange<T> closedRange) {
        Intrinsics.checkNotNullParameter(t, "");
        Intrinsics.checkNotNullParameter(closedRange, "");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return (T) RangesKt.coerceIn((Comparable) t, (ClosedFloatingPointRange) closedRange);
        }
        if (!closedRange.isEmpty()) {
            return t.compareTo(closedRange.getStart()) < 0 ? closedRange.getStart() : t.compareTo(closedRange.getEndInclusive()) > 0 ? closedRange.getEndInclusive() : t;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: ");
        sb.append(closedRange);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final int coerceIn(int i, ClosedRange<Integer> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) RangesKt.coerceIn(Integer.valueOf(i), (ClosedFloatingPointRange<Integer>) closedRange)).intValue();
        }
        if (!closedRange.isEmpty()) {
            return i < closedRange.getStart().intValue() ? closedRange.getStart().intValue() : i > closedRange.getEndInclusive().intValue() ? closedRange.getEndInclusive().intValue() : i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: ");
        sb.append(closedRange);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }

    public static final long coerceIn(long j, ClosedRange<Long> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) RangesKt.coerceIn(Long.valueOf(j), (ClosedFloatingPointRange<Long>) closedRange)).longValue();
        }
        if (!closedRange.isEmpty()) {
            return j < closedRange.getStart().longValue() ? closedRange.getStart().longValue() : j > closedRange.getEndInclusive().longValue() ? closedRange.getEndInclusive().longValue() : j;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot coerce value to an empty range: ");
        sb.append(closedRange);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString());
    }
}
