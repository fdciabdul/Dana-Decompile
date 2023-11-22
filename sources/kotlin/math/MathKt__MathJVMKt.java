package kotlin.math;

import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\bC\u001a\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0018\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u0018\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b\u0002\u0010\b\u001a\u0018\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u0002\u0010\n\u001a\u0018\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\u0003\u001a\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\f\u0010\u0005\u001a\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\r\u0010\u0003\u001a\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\r\u0010\u0005\u001a\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u0003\u001a\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u000e\u0010\u0005\u001a\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0005\u001a \u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0011\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0003\u001a\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0005\u001a\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0003\u001a\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0005\u001a\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0003\u001a\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0016\u0010\u0005\u001a\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0003\u001a\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0005\u001a\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0003\u001a\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0005\u001a\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0019\u0010\u0003\u001a\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0019\u0010\u0005\u001a\u0018\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u001a\u0010\u0003\u001a\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u001a\u0010\u0005\u001a \u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u001b\u0010\u0012\u001a \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u001b\u0010\u0013\u001a\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u001c\u0010\u0003\u001a\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u001c\u0010\u0005\u001a\u0018\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u001d\u0010\u0003\u001a\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u001d\u0010\u0005\u001a\u001d\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000¢\u0006\u0004\b\u001f\u0010\u0012\u001a\u001d\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010\u0013\u001a\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b \u0010\u0003\u001a\u0018\u0010 \u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b \u0010\u0005\u001a\u0015\u0010!\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b!\u0010\u0003\u001a\u0015\u0010!\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\u0005\u001a \u0010$\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b$\u0010\u0012\u001a \u0010$\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b$\u0010\u0013\u001a \u0010$\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b$\u0010%\u001a \u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0086\b¢\u0006\u0004\b$\u0010&\u001a \u0010'\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b'\u0010\u0012\u001a \u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b'\u0010\u0013\u001a \u0010'\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b'\u0010%\u001a \u0010'\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0086\b¢\u0006\u0004\b'\u0010&\u001a\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b(\u0010\u0003\u001a\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b(\u0010\u0005\u001a\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b)\u0010\u0003\u001a\u0018\u0010)\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b)\u0010\u0005\u001a\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b*\u0010\u0003\u001a\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b*\u0010\u0005\u001a\u0018\u0010+\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b+\u0010\u0003\u001a\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b+\u0010\u0005\u001a\u0018\u0010,\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b,\u0010\u0003\u001a\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b,\u0010\u0005\u001a\u0018\u0010-\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b-\u0010\u0003\u001a\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b-\u0010\u0005\u001a\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b.\u0010\u0003\u001a\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b.\u0010\u0005\u001a\u0015\u0010/\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b/\u0010\u0003\u001a\u0015\u0010/\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004¢\u0006\u0004\b/\u0010\u0005\u001a\u001c\u00101\u001a\u00020\u0000*\u00020\u00002\u0006\u00100\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b1\u0010\u0012\u001a\u001c\u00101\u001a\u00020\u0004*\u00020\u00042\u0006\u00100\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b1\u0010\u0013\u001a\u0014\u00102\u001a\u00020\u0000*\u00020\u0000H\u0086\b¢\u0006\u0004\b2\u0010\u0003\u001a\u0014\u00102\u001a\u00020\u0004*\u00020\u0004H\u0086\b¢\u0006\u0004\b2\u0010\u0005\u001a\u001c\u00104\u001a\u00020\u0000*\u00020\u00002\u0006\u00103\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b4\u0010\u0012\u001a\u001c\u00104\u001a\u00020\u0004*\u00020\u00042\u0006\u00103\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b4\u0010\u0013\u001a\u0014\u00105\u001a\u00020\u0000*\u00020\u0000H\u0086\b¢\u0006\u0004\b5\u0010\u0003\u001a\u0014\u00105\u001a\u00020\u0004*\u00020\u0004H\u0086\b¢\u0006\u0004\b5\u0010\u0005\u001a\u001c\u00106\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b6\u0010\u0012\u001a\u001c\u00106\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b6\u00107\u001a\u001c\u00106\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b6\u0010\u0013\u001a\u001c\u00106\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b6\u00108\u001a\u0011\u00109\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b9\u0010:\u001a\u0011\u00109\u001a\u00020\u0006*\u00020\u0004¢\u0006\u0004\b9\u0010;\u001a\u0011\u0010<\u001a\u00020\t*\u00020\u0000¢\u0006\u0004\b<\u0010=\u001a\u0011\u0010<\u001a\u00020\t*\u00020\u0004¢\u0006\u0004\b<\u0010>\u001a\u001c\u0010?\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b?\u0010\u0012\u001a\u001c\u0010?\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b?\u00107\u001a\u001c\u0010?\u001a\u00020\u0004*\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b?\u0010\u0013\u001a\u001c\u0010?\u001a\u00020\u0004*\u00020\u00042\u0006\u0010)\u001a\u00020\u0006H\u0086\b¢\u0006\u0004\b?\u00108\"\u001c\u0010C\u001a\u00020\u0000*\u00020\u00008Ç\u0002¢\u0006\f\u0012\u0004\bA\u0010B\u001a\u0004\b@\u0010\u0003\"\u001c\u0010C\u001a\u00020\u0004*\u00020\u00048Ç\u0002¢\u0006\f\u0012\u0004\bA\u0010D\u001a\u0004\b@\u0010\u0005\"\u001c\u0010C\u001a\u00020\u0006*\u00020\u00068Ç\u0002¢\u0006\f\u0012\u0004\bA\u0010E\u001a\u0004\b@\u0010\b\"\u001c\u0010C\u001a\u00020\t*\u00020\t8Ç\u0002¢\u0006\f\u0012\u0004\bA\u0010F\u001a\u0004\b@\u0010\n\"\u001c\u0010)\u001a\u00020\u0000*\u00020\u00008Ç\u0002¢\u0006\f\u0012\u0004\bH\u0010B\u001a\u0004\bG\u0010\u0003\"\u001c\u0010)\u001a\u00020\u0004*\u00020\u00048Ç\u0002¢\u0006\f\u0012\u0004\bH\u0010D\u001a\u0004\bG\u0010\u0005\"\u001b\u0010)\u001a\u00020\u0006*\u00020\u00068G¢\u0006\f\u0012\u0004\bH\u0010E\u001a\u0004\bG\u0010\b\"\u001b\u0010)\u001a\u00020\u0006*\u00020\t8G¢\u0006\f\u0012\u0004\bH\u0010F\u001a\u0004\bG\u0010I\"\u001c\u0010L\u001a\u00020\u0000*\u00020\u00008Ç\u0002¢\u0006\f\u0012\u0004\bK\u0010B\u001a\u0004\bJ\u0010\u0003\"\u001c\u0010L\u001a\u00020\u0004*\u00020\u00048Ç\u0002¢\u0006\f\u0012\u0004\bK\u0010D\u001a\u0004\bJ\u0010\u0005"}, d2 = {"", "x", "abs", "(D)D", "", "(F)F", "", "n", "(I)I", "", "(J)J", "acos", "acosh", "asin", "asinh", "atan", "y", "atan2", "(DD)D", "(FF)F", "atanh", "ceil", "cos", "cosh", "exp", "expm1", "floor", "hypot", "ln", "ln1p", "base", "log", "log10", "log2", "a", "b", LottieConstants.PARAM_MAX_VALUE, "(II)I", "(JJ)J", LottieConstants.PARAM_MIN_VALUE, "round", "sign", "sin", "sinh", "sqrt", "tan", "tanh", "truncate", "divisor", "IEEErem", "nextDown", LoginTrackingConstants.LoginParam.TO, "nextTowards", "nextUp", "pow", "(DI)D", "(FI)F", "roundToInt", "(D)I", "(F)I", "roundToLong", "(D)J", "(F)J", "withSign", "getAbsoluteValue", "getAbsoluteValue$annotations", "(D)V", "absoluteValue", "(F)V", "(I)V", "(J)V", "getSign", "getSign$annotations", "(J)I", "getUlp", "getUlp$annotations", "ulp"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/math/MathKt")
/* loaded from: classes3.dex */
public class MathKt__MathJVMKt extends MathKt__MathHKt {
    public static /* synthetic */ void getAbsoluteValue$annotations(double d) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(float f) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(int i) {
    }

    public static /* synthetic */ void getAbsoluteValue$annotations(long j) {
    }

    @JvmName(name = "getSign")
    public static final int getSign(int i) {
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    @JvmName(name = "getSign")
    public static final int getSign(long j) {
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public static /* synthetic */ void getSign$annotations(double d) {
    }

    public static /* synthetic */ void getSign$annotations(float f) {
    }

    public static /* synthetic */ void getSign$annotations(int i) {
    }

    public static /* synthetic */ void getSign$annotations(long j) {
    }

    public static /* synthetic */ void getUlp$annotations(double d) {
    }

    public static /* synthetic */ void getUlp$annotations(float f) {
    }

    private static final double sin(double d) {
        return Math.sin(d);
    }

    private static final double cos(double d) {
        return Math.cos(d);
    }

    private static final double tan(double d) {
        return Math.tan(d);
    }

    private static final double asin(double d) {
        return Math.asin(d);
    }

    private static final double acos(double d) {
        return Math.acos(d);
    }

    private static final double atan(double d) {
        return Math.atan(d);
    }

    private static final double atan2(double d, double d2) {
        return Math.atan2(d, d2);
    }

    private static final double sinh(double d) {
        return Math.sinh(d);
    }

    private static final double cosh(double d) {
        return Math.cosh(d);
    }

    private static final double tanh(double d) {
        return Math.tanh(d);
    }

    public static final double asinh(double d) {
        if (d < Constants.taylor_n_bound) {
            return d <= (-Constants.taylor_n_bound) ? -MathKt.asinh(-d) : Math.abs(d) >= Constants.taylor_2_bound ? d - (((d * d) * d) / 6.0d) : d;
        } else if (d > Constants.upper_taylor_n_bound) {
            if (d > Constants.upper_taylor_2_bound) {
                return Math.log(d) + Constants.LN2;
            }
            double d2 = d * 2.0d;
            return Math.log(d2 + (1.0d / d2));
        } else {
            return Math.log(d + Math.sqrt((d * d) + 1.0d));
        }
    }

    public static final double acosh(double d) {
        if (d < 1.0d) {
            return Double.NaN;
        }
        if (d > Constants.upper_taylor_2_bound) {
            return Math.log(d) + Constants.LN2;
        }
        double d2 = d - 1.0d;
        if (d2 >= Constants.taylor_n_bound) {
            return Math.log(d + Math.sqrt((d * d) - 1.0d));
        }
        double sqrt = Math.sqrt(d2);
        if (sqrt >= Constants.taylor_2_bound) {
            sqrt -= ((sqrt * sqrt) * sqrt) / 12.0d;
        }
        return sqrt * Math.sqrt(2.0d);
    }

    public static final double atanh(double d) {
        if (Math.abs(d) < Constants.taylor_n_bound) {
            return Math.abs(d) > Constants.taylor_2_bound ? d + (((d * d) * d) / 3.0d) : d;
        }
        return Math.log((d + 1.0d) / (1.0d - d)) / 2.0d;
    }

    private static final double hypot(double d, double d2) {
        return Math.hypot(d, d2);
    }

    private static final double sqrt(double d) {
        return Math.sqrt(d);
    }

    private static final double exp(double d) {
        return Math.exp(d);
    }

    private static final double expm1(double d) {
        return Math.expm1(d);
    }

    public static final double log(double d, double d2) {
        if (d2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (d2 == 1.0d) {
                return Double.NaN;
            }
            return Math.log(d) / Math.log(d2);
        }
        return Double.NaN;
    }

    private static final double ln(double d) {
        return Math.log(d);
    }

    private static final double log10(double d) {
        return Math.log10(d);
    }

    public static final double log2(double d) {
        return Math.log(d) / Constants.LN2;
    }

    private static final double ln1p(double d) {
        return Math.log1p(d);
    }

    private static final double ceil(double d) {
        return Math.ceil(d);
    }

    private static final double floor(double d) {
        return Math.floor(d);
    }

    public static final double truncate(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            return d;
        }
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return Math.floor(d);
        }
        return Math.ceil(d);
    }

    private static final double round(double d) {
        return Math.rint(d);
    }

    private static final double abs(double d) {
        return Math.abs(d);
    }

    private static final double sign(double d) {
        return Math.signum(d);
    }

    private static final double min(double d, double d2) {
        return Math.min(d, d2);
    }

    private static final double max(double d, double d2) {
        return Math.max(d, d2);
    }

    private static final double pow(double d, double d2) {
        return Math.pow(d, d2);
    }

    private static final double pow(double d, int i) {
        return Math.pow(d, i);
    }

    private static final double IEEErem(double d, double d2) {
        return Math.IEEEremainder(d, d2);
    }

    @JvmName(name = "getAbsoluteValue")
    private static final double getAbsoluteValue(double d) {
        return Math.abs(d);
    }

    @JvmName(name = "getSign")
    private static final double getSign(double d) {
        return Math.signum(d);
    }

    private static final double withSign(double d, double d2) {
        return Math.copySign(d, d2);
    }

    private static final double withSign(double d, int i) {
        return Math.copySign(d, i);
    }

    @JvmName(name = "getUlp")
    private static final double getUlp(double d) {
        return Math.ulp(d);
    }

    private static final double nextUp(double d) {
        return Math.nextUp(d);
    }

    private static final double nextDown(double d) {
        return Math.nextAfter(d, Double.NEGATIVE_INFINITY);
    }

    private static final double nextTowards(double d, double d2) {
        return Math.nextAfter(d, d2);
    }

    public static final int roundToInt(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        if (d > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        }
        if (d < -2.147483648E9d) {
            return Integer.MIN_VALUE;
        }
        return (int) Math.round(d);
    }

    public static final long roundToLong(double d) {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d);
    }

    private static final float sin(float f) {
        return (float) Math.sin(f);
    }

    private static final float cos(float f) {
        return (float) Math.cos(f);
    }

    private static final float tan(float f) {
        return (float) Math.tan(f);
    }

    private static final float asin(float f) {
        return (float) Math.asin(f);
    }

    private static final float acos(float f) {
        return (float) Math.acos(f);
    }

    private static final float atan(float f) {
        return (float) Math.atan(f);
    }

    private static final float atan2(float f, float f2) {
        return (float) Math.atan2(f, f2);
    }

    private static final float sinh(float f) {
        return (float) Math.sinh(f);
    }

    private static final float cosh(float f) {
        return (float) Math.cosh(f);
    }

    private static final float tanh(float f) {
        return (float) Math.tanh(f);
    }

    private static final float asinh(float f) {
        return (float) MathKt.asinh(f);
    }

    private static final float acosh(float f) {
        return (float) MathKt.acosh(f);
    }

    private static final float atanh(float f) {
        return (float) MathKt.atanh(f);
    }

    private static final float hypot(float f, float f2) {
        return (float) Math.hypot(f, f2);
    }

    private static final float sqrt(float f) {
        return (float) Math.sqrt(f);
    }

    private static final float exp(float f) {
        return (float) Math.exp(f);
    }

    private static final float expm1(float f) {
        return (float) Math.expm1(f);
    }

    public static final float log(float f, float f2) {
        if (f2 > 0.0f) {
            if (f2 == 1.0f) {
                return Float.NaN;
            }
            return (float) (Math.log(f) / Math.log(f2));
        }
        return Float.NaN;
    }

    private static final float ln(float f) {
        return (float) Math.log(f);
    }

    private static final float log10(float f) {
        return (float) Math.log10(f);
    }

    public static final float log2(float f) {
        return (float) (Math.log(f) / Constants.LN2);
    }

    private static final float ln1p(float f) {
        return (float) Math.log1p(f);
    }

    private static final float ceil(float f) {
        return (float) Math.ceil(f);
    }

    private static final float floor(float f) {
        return (float) Math.floor(f);
    }

    public static final float truncate(float f) {
        double ceil;
        if (Float.isNaN(f) || Float.isInfinite(f)) {
            return f;
        }
        if (f > 0.0f) {
            ceil = Math.floor(f);
        } else {
            ceil = Math.ceil(f);
        }
        return (float) ceil;
    }

    private static final float round(float f) {
        return (float) Math.rint(f);
    }

    private static final float abs(float f) {
        return Math.abs(f);
    }

    private static final float sign(float f) {
        return Math.signum(f);
    }

    private static final float min(float f, float f2) {
        return Math.min(f, f2);
    }

    private static final float max(float f, float f2) {
        return Math.max(f, f2);
    }

    private static final float pow(float f, float f2) {
        return (float) Math.pow(f, f2);
    }

    private static final float pow(float f, int i) {
        return (float) Math.pow(f, i);
    }

    private static final float IEEErem(float f, float f2) {
        return (float) Math.IEEEremainder(f, f2);
    }

    @JvmName(name = "getAbsoluteValue")
    private static final float getAbsoluteValue(float f) {
        return Math.abs(f);
    }

    @JvmName(name = "getSign")
    private static final float getSign(float f) {
        return Math.signum(f);
    }

    private static final float withSign(float f, float f2) {
        return Math.copySign(f, f2);
    }

    private static final float withSign(float f, int i) {
        return Math.copySign(f, i);
    }

    @JvmName(name = "getUlp")
    private static final float getUlp(float f) {
        return Math.ulp(f);
    }

    private static final float nextUp(float f) {
        return Math.nextUp(f);
    }

    private static final float nextDown(float f) {
        return Math.nextAfter(f, Double.NEGATIVE_INFINITY);
    }

    private static final float nextTowards(float f, float f2) {
        return Math.nextAfter(f, f2);
    }

    public static final int roundToInt(float f) {
        if (Float.isNaN(f)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f);
    }

    public static final long roundToLong(float f) {
        return MathKt.roundToLong(f);
    }

    private static final int abs(int i) {
        return Math.abs(i);
    }

    private static final int min(int i, int i2) {
        return Math.min(i, i2);
    }

    private static final int max(int i, int i2) {
        return Math.max(i, i2);
    }

    @JvmName(name = "getAbsoluteValue")
    private static final int getAbsoluteValue(int i) {
        return Math.abs(i);
    }

    private static final long abs(long j) {
        return Math.abs(j);
    }

    private static final long min(long j, long j2) {
        return Math.min(j, j2);
    }

    private static final long max(long j, long j2) {
        return Math.max(j, j2);
    }

    @JvmName(name = "getAbsoluteValue")
    private static final long getAbsoluteValue(long j) {
        return Math.abs(j);
    }
}
