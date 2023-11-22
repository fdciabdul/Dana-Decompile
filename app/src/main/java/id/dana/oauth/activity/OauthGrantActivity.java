package id.dana.oauth.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.core.GriverParams;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.ChallengeControl;
import id.dana.component.buttoncomponent.BaseDanaButton;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.oauth.OauthGrantContract;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danah5.DanaH5;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.OauthGrantComponent;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.DialogWithImage;
import id.dana.domain.featureconfig.model.ShowAlipayConnectBrandConfig;
import id.dana.network.exception.NetworkException;
import id.dana.oauth.OauthConstant;
import id.dana.oauth.OauthLoginManager;
import id.dana.oauth.OauthTargetManager;
import id.dana.oauth.ScopeAdapter;
import id.dana.oauth.adapter.AgreementScopeAdapter;
import id.dana.oauth.adapter.BindingBenefitAdapter;
import id.dana.oauth.model.BindingBenefitModel;
import id.dana.oauth.model.OauthInitModel;
import id.dana.oauth.model.OauthParamsModel;
import id.dana.oauth.model.ScopeModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.TagFormat;
import id.dana.utils.TextUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.log.CrashlyticsLogUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.A;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ¯\u00012\u00020\u00012\u00020\u0002:\u0002¯\u0001B\b¢\u0006\u0005\b®\u0001\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0006\u0010\u0017J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0004\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u001d\u0010\u001b\u001a\u0006*\u00020\u001a0\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u001aH\u0002¢\u0006\u0004\b!\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\"\u0010\u001eJ\u000f\u0010#\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010\u0005J\u0019\u0010\u001b\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b\u001b\u0010%J\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u000f\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0002¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\u0003H\u0002¢\u0006\u0004\b(\u0010\u0005J)\u0010*\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u001a2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010)H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b,\u0010\u0005J\u000f\u0010-\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010.\u001a\u00020\u0003H\u0002¢\u0006\u0004\b.\u0010\u0005J\u000f\u0010/\u001a\u00020\u0003H\u0002¢\u0006\u0004\b/\u0010\u0005J\u000f\u00100\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u0010\u0005J\u000f\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u0010\u0005J\u001d\u0010\u0004\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002020)H\u0002¢\u0006\u0004\b\u0004\u00103J\u001d\u0010*\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002040)H\u0002¢\u0006\u0004\b*\u00103J\u000f\u00105\u001a\u00020\u0003H\u0002¢\u0006\u0004\b5\u0010\u0005J\u000f\u00106\u001a\u00020\u0003H\u0002¢\u0006\u0004\b6\u0010\u0005J\u000f\u00107\u001a\u00020\u0003H\u0002¢\u0006\u0004\b7\u0010\u0005J\u000f\u00108\u001a\u00020\u0003H\u0002¢\u0006\u0004\b8\u0010\u0005J\u000f\u00109\u001a\u00020\u0003H\u0002¢\u0006\u0004\b9\u0010\u0005J\u000f\u0010:\u001a\u00020\u0003H\u0002¢\u0006\u0004\b:\u0010\u0005J\u000f\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020;H\u0002¢\u0006\u0004\b>\u0010=J\u000f\u0010?\u001a\u00020\u0003H\u0002¢\u0006\u0004\b?\u0010\u0005J)\u0010D\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010BH\u0014¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u0003H\u0016¢\u0006\u0004\bF\u0010\u0005J\u0019\u0010H\u001a\u00020\u00032\b\u0010G\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\bH\u0010IJ#\u0010L\u001a\u00020\u00032\b\u0010J\u001a\u0004\u0018\u00010\u001a2\b\u0010K\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\bL\u0010MJ\u0019\u0010O\u001a\u00020\u00032\b\u0010N\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\bO\u0010&J)\u0010R\u001a\u00020\u00032\b\u0010P\u001a\u0004\u0018\u00010\u001a2\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010)H\u0016¢\u0006\u0004\bR\u0010+J\u0017\u0010T\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\u0016H\u0016¢\u0006\u0004\bT\u0010\u0017J\u001f\u0010V\u001a\u00020\u00032\u000e\u0010U\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010)H\u0016¢\u0006\u0004\bV\u00103J\u0019\u0010Y\u001a\u00020\u00032\b\u0010X\u001a\u0004\u0018\u00010WH\u0016¢\u0006\u0004\bY\u0010ZJ\u0019\u0010\\\u001a\u00020\u00032\b\u0010[\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\\\u0010&J#\u0010`\u001a\u00020\u00032\b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010_\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\u0003H\u0014¢\u0006\u0004\bb\u0010\u0005J\u000f\u0010c\u001a\u00020\u0003H\u0016¢\u0006\u0004\bc\u0010\u0005J\u000f\u0010d\u001a\u00020\u0003H\u0002¢\u0006\u0004\bd\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u0006\u0010&J!\u0010g\u001a\u00020\u00032\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010f\u001a\u00020eH\u0016¢\u0006\u0004\bg\u0010hJ\u0019\u0010j\u001a\u00020\u00032\b\u0010i\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\bj\u0010&J\u000f\u0010k\u001a\u00020\u0003H\u0002¢\u0006\u0004\bk\u0010\u0005J\u000f\u0010l\u001a\u00020\u0003H\u0002¢\u0006\u0004\bl\u0010\u0005J\u000f\u0010m\u001a\u00020\u0003H\u0016¢\u0006\u0004\bm\u0010\u0005J\u000f\u0010n\u001a\u00020\u0003H\u0016¢\u0006\u0004\bn\u0010\u0005J\u000f\u0010o\u001a\u00020\u0003H\u0002¢\u0006\u0004\bo\u0010\u0005J-\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010)H\u0002¢\u0006\u0004\b\u000f\u0010+J\u000f\u0010p\u001a\u00020\u0003H\u0002¢\u0006\u0004\bp\u0010\u0005R\u0016\u0010\u001b\u001a\u00020q8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\b\u0010rR\u0016\u0010\u000f\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010sR\u0018\u0010*\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010vR\u0018\u0010\u0006\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010xR\u0018\u0010\u0007\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010vR\u0018\u0010\u0014\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u0013\u001a\u00020|8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010}R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010~R\u001d\u0010\b\u001a\u00020\u007f8CX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b(\u0010\u0080\u0001\u001a\u0005\bz\u0010\u0081\u0001R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010tR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010tR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010tR\u001a\u0010z\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b/\u0010\u0083\u0001R\u001a\u0010!\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b.\u0010\u0085\u0001R\u001a\u0010\"\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b5\u0010\u0083\u0001R\u001a\u0010'\u001a\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b0\u0010\u0083\u0001R\u0019\u0010#\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b1\u0010\u0086\u0001R\u0019\u0010,\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b6\u0010\u0086\u0001R\u001a\u0010(\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b7\u0010\u0088\u0001R\u0016\u00105\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b8\u0010sR\u0016\u00101\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u0010sR\u001a\u0010/\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b:\u0010\u008a\u0001R\u001a\u0010.\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b?\u0010\u008c\u0001R\u0016\u00100\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bd\u0010tR*\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R*\u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001a\u0010:\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bk\u0010\u009c\u0001R\u001a\u00109\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b>\u0010\u009c\u0001R\u0016\u00106\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010tR*\u0010\u009e\u0001\u001a\u00030\u009d\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\"\u00108\u001a\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010¤\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bo\u0010¥\u0001R\u001b\u00107\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001b\u0010k\u001a\u0005\u0018\u00010©\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u001a\u0010?\u001a\u0005\u0018\u00010©\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bl\u0010«\u0001R\u001a\u0010>\u001a\u0005\u0018\u00010©\u00018\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\bp\u0010«\u0001R\u001b\u0010<\u001a\u0005\u0018\u00010©\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010«\u0001R\u001b\u0010d\u001a\u0005\u0018\u00010©\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010«\u0001R\u0019\u0010l\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b~\u0010\u0086\u0001"}, d2 = {"Lid/dana/oauth/activity/OauthGrantActivity;", "Lid/dana/base/BaseActivity;", "Lid/dana/contract/oauth/OauthGrantContract$View;", "", "PlaceComponentResult", "()V", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "configToolbar", "Landroid/view/View;", "p0", "", "p1", "Lcom/ethanhua/skeleton/SkeletonScreen;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/View;I)Lcom/ethanhua/skeleton/SkeletonScreen;", "dismissConfirmProgress", "dismissProgress", "moveToNextValue", "lookAheadTest", "getErrorConfigVersion", "Lid/dana/oauth/model/AuthCodeModel;", "(Lid/dana/oauth/model/AuthCodeModel;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "()Ljava/lang/String;", "getLayout", "()I", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "(Ljava/lang/String;)V", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda7", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/util/List;)V", "newProxyInstance", IAPSyncCommand.COMMAND_INIT, "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda6", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/oauth/model/BindingBenefitModel;", "(Ljava/util/List;)V", "Lid/dana/oauth/model/ScopeModel;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "getCallingPid", "readMicros", "SubSequence", "getSupportButtonTintMode", "whenAvailable", "", DiskFormatter.B, "()Z", "BottomSheetCardBindingView$watcherCardNumberView$1", "VerifyPinStateManager$executeRiskChallenge$2$1", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onBackPressed", "view", "onClickLeftMenuButton", "(Landroid/view/View;)V", OauthConstant.PathParams.MOBILE_AUTH_CODE, OauthConstant.PathParams.SERVER_AUTH_CODE, "onConfirmOauthScopeSuccess", "(Ljava/lang/String;Ljava/lang/String;)V", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, BioUtilityBridge.SECURITY_ID, "verificationMethods", "onGetAuthCodeRiskFailed", "authCodeModel", "onGetAuthCodeSuccess", "bindingBenefitModelList", "onGetBindingBenefitsSuccess", "Lid/dana/oauth/model/OauthInitModel;", "oauthInitModel", "onGetOauthScopeSuccess", "(Lid/dana/oauth/model/OauthInitModel;)V", "phoneNumber", "onGetPhoneNumberSuccess", "", "throwable", "errorPath", "onOauthError", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "onPause", "onQrBindingError", "A", "Lid/dana/domain/featureconfig/model/ShowAlipayConnectBrandConfig;", "showAlipayConnectBrandConfig", "showAlipayConnectBrand", "(Lid/dana/oauth/model/OauthInitModel;Lid/dana/domain/featureconfig/model/ShowAlipayConnectBrandConfig;)V", GriverParams.ShareParams.IMAGE_URL, "showAvatar", "C", SummaryActivity.DAYS, "showConfirmProgress", "showProgress", "getValueOfTouchPositionAbsolute", "getOnBoardingScenario", "Lid/dana/oauth/adapter/AgreementScopeAdapter;", "Lid/dana/oauth/adapter/AgreementScopeAdapter;", "Z", "Ljava/lang/String;", "Lid/dana/component/buttoncomponent/BaseDanaButton;", "Lid/dana/component/buttoncomponent/BaseDanaButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/widget/Button;", "GetContactSyncConfig", "Landroid/widget/Button;", "Lid/dana/challenge/ChallengeControl;", "Lid/dana/challenge/ChallengeControl;", "I", "Lid/dana/dialog/DanaLoadingDialog;", "Lkotlin/Lazy;", "()Lid/dana/dialog/DanaLoadingDialog;", "Lcom/google/android/material/imageview/ShapeableImageView;", "Lcom/google/android/material/imageview/ShapeableImageView;", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "Landroid/view/View;", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "Lid/dana/di/component/OauthGrantComponent;", "Lid/dana/di/component/OauthGrantComponent;", "Lid/dana/oauth/model/OauthParamsModel;", "Lid/dana/oauth/model/OauthParamsModel;", "Lid/dana/contract/oauth/OauthGrantContract$Presenter;", "presenter", "Lid/dana/contract/oauth/OauthGrantContract$Presenter;", "getPresenter", "()Lid/dana/contract/oauth/OauthGrantContract$Presenter;", "setPresenter", "(Lid/dana/contract/oauth/OauthGrantContract$Presenter;)V", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lid/dana/oauth/ScopeAdapter;", "scopeAdapter", "Lid/dana/oauth/ScopeAdapter;", "getScopeAdapter", "()Lid/dana/oauth/ScopeAdapter;", "setScopeAdapter", "(Lid/dana/oauth/ScopeAdapter;)V", "", "[Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/view/ViewStub;", "E", "Landroid/view/ViewStub;", "Landroid/widget/TextView;", "VerifyPinStateManager$executeRiskChallenge$2$2", "Landroid/widget/TextView;", LogConstants.RESULT_FALSE, "AppCompatEmojiTextHelper", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OauthGrantActivity extends BaseActivity implements OauthGrantContract.View {
    private static int $10 = 0;
    private static int $11 = 1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int G;
    private static int M;
    private static final String scheduleImpl;

    /* renamed from: A  reason: from kotlin metadata */
    private String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: AppCompatEmojiTextHelper  reason: from kotlin metadata */
    private TextView A;

    /* renamed from: B */
    private String getCallingPid;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private RecyclerView getSupportButtonTintMode;

    /* renamed from: C  reason: from kotlin metadata */
    private RecyclerView whenAvailable;

    /* renamed from: D */
    private TextView VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private AppCompatImageView BuiltInFictitiousFunctionClassFactory;

    /* renamed from: E  reason: from kotlin metadata */
    private ViewStub readMicros;

    /* renamed from: F */
    private TextView B;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private ShapeableImageView isLayoutRequested;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Button lookAheadTest;

    /* renamed from: I  reason: from kotlin metadata */
    private View id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private AgreementScopeAdapter getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private BaseDanaButton PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private BaseDanaButton scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private ShapeableImageView NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private ImageView DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private View PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private ShapeableImageView GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private String initRecordTimeStamp;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private OauthParamsModel NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private TextView C;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private View newProxyInstance;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private TextView BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private SkeletonScreen[] SubSequence;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private ChallengeControl moveToNextValue;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private int getErrorConfigVersion;
    @Inject
    public OauthGrantContract.Presenter presenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private LinearLayout NetworkUserEntityData$$ExternalSyntheticLambda7;
    @Inject
    public ScopeAdapter scopeAdapter;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private OauthGrantComponent NetworkUserEntityData$$ExternalSyntheticLambda6;
    public static final byte[] $$a = {105, Ascii.NAK, -43, 101, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 242;
    private static int getNameOrBuilderList = 0;
    private static long H = -1885649530062989109L;
    public static final byte[] getAuthRequestContext = {112, 91, -28, 61, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 225;

    public static /* synthetic */ void $r8$lambda$GtuA8Qzg7ncte3uVgoY6RGtXJf8(OauthGrantActivity oauthGrantActivity, View view) {
        try {
            int i = getNameOrBuilderList + 11;
            M = i % 128;
            if (!(i % 2 == 0)) {
                MyBillsEntityDataFactory(oauthGrantActivity);
                return;
            }
            try {
                MyBillsEntityDataFactory(oauthGrantActivity);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void $r8$lambda$HlMep9OhvqEp245Au1uqiQR_4iA(OauthGrantActivity oauthGrantActivity, DialogInterface dialogInterface, int i) {
        int i2 = getNameOrBuilderList + 17;
        M = i2 % 128;
        int i3 = i2 % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(oauthGrantActivity, dialogInterface);
        int i4 = M + 55;
        getNameOrBuilderList = i4 % 128;
        int i5 = i4 % 2;
    }

    /* renamed from: $r8$lambda$N-HSE6ifnKMunrSLzkcw5hOyIDU */
    public static /* synthetic */ void m2756$r8$lambda$NHSE6ifnKMunrSLzkcw5hOyIDU(OauthGrantActivity oauthGrantActivity, View view) {
        int i = M + 41;
        getNameOrBuilderList = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(oauthGrantActivity);
        int i3 = M + 101;
        getNameOrBuilderList = i3 % 128;
        if ((i3 % 2 != 0 ? 'U' : 'T') != 'U') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static /* synthetic */ void $r8$lambda$VlONScI8C_fhFEv8ygIhtQ_VYhM(OauthGrantActivity oauthGrantActivity, DialogInterface dialogInterface, int i) {
        try {
            int i2 = getNameOrBuilderList + 61;
            try {
                M = i2 % 128;
                if ((i2 % 2 == 0 ? 'S' : 'D') != 'S') {
                    MyBillsEntityDataFactory(oauthGrantActivity, dialogInterface);
                    return;
                }
                MyBillsEntityDataFactory(oauthGrantActivity, dialogInterface);
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void $r8$lambda$at4wYEHlpeJReGq5wENyLRoqmyc(OauthGrantActivity oauthGrantActivity, View view) {
        try {
            int i = M + 33;
            try {
                getNameOrBuilderList = i % 128;
                char c = i % 2 != 0 ? '\'' : (char) 11;
                BuiltInFictitiousFunctionClassFactory(oauthGrantActivity);
                if (c != 11) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void $r8$lambda$xMl6PKdZ4Dd27zRT6nhwXP5V05I(OauthGrantActivity oauthGrantActivity, View view) {
        try {
            int i = M + 45;
            getNameOrBuilderList = i % 128;
            int i2 = i % 2;
            try {
                getAuthRequestContext(oauthGrantActivity);
                int i3 = getNameOrBuilderList + 55;
                M = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        int i2 = getNameOrBuilderList + 115;
        M = i2 % 128;
        int i3 = i2 % 2;
        try {
            Object[] objArr = null;
            if ((appCompatImageView instanceof ImageView ? (char) 14 : (char) 11) != 14) {
                appCompatImageView.setImageResource(i);
                int i4 = M + 47;
                getNameOrBuilderList = i4 % 128;
                if (i4 % 2 != 0) {
                    int length = objArr.length;
                    return;
                }
                return;
            }
            int i5 = M + 101;
            getNameOrBuilderList = i5 % 128;
            boolean z = i5 % 2 != 0;
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            if (!z) {
                return;
            }
            int length2 = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0057  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x003a -> B:57:0x0048). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 + 97
            byte[] r0 = id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext     // Catch: java.lang.Exception -> L5b
            int r8 = r8 + 16
            int r7 = 56 - r7
            byte[] r1 = new byte[r8]     // Catch: java.lang.Exception -> L5b
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L10
            r4 = 1
            goto L11
        L10:
            r4 = 0
        L11:
            if (r4 == r3) goto L1b
            r4 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L48
        L1b:
            int r4 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r4 = r4 + 97
            int r5 = r4 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L29
            r4 = 0
            goto L2a
        L29:
            r4 = 1
        L2a:
            if (r4 == r3) goto L33
            r4 = 0
            r4.hashCode()     // Catch: java.lang.Throwable -> L31
            goto L33
        L31:
            r7 = move-exception
            throw r7
        L33:
            r4 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
        L3a:
            int r10 = r10 + r7
            int r8 = r8 + r3
            int r10 = r10 + (-4)
            int r7 = id.dana.oauth.activity.OauthGrantActivity.M
            int r7 = r7 + 101
            int r6 = r7 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r6
            int r7 = r7 % 2
        L48:
            byte r7 = (byte) r10
            int r6 = r5 + 1
            r4[r5] = r7
            if (r6 != r9) goto L57
            java.lang.String r7 = new java.lang.String
            r7.<init>(r4, r2)
            r0[r2] = r7
            return
        L57:
            r7 = r1[r8]
            r5 = r6
            goto L3a
        L5b:
            r7 = move-exception
            goto L5e
        L5d:
            throw r7
        L5e:
            goto L5d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.b(short, short, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createOauthGrantLoadingIntent(Context context) {
        Intent PlaceComponentResult2;
        try {
            int i = M + 59;
            try {
                getNameOrBuilderList = i % 128;
                Object[] objArr = null;
                if (i % 2 != 0) {
                    PlaceComponentResult2 = Companion.PlaceComponentResult(context);
                    int length = objArr.length;
                } else {
                    PlaceComponentResult2 = Companion.PlaceComponentResult(context);
                }
                int i2 = getNameOrBuilderList + 37;
                M = i2 % 128;
                if (i2 % 2 != 0) {
                    return PlaceComponentResult2;
                }
                int length2 = objArr.length;
                return PlaceComponentResult2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(int r5, byte r6, byte r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = id.dana.oauth.activity.OauthGrantActivity.$$a
            int r6 = r6 + 4
            int r5 = r5 * 3
            int r5 = 42 - r5
            int r7 = r7 * 2
            int r7 = 103 - r7
            byte[] r1 = new byte[r5]
            r2 = -1
            int r5 = r5 + r2
            if (r0 != 0) goto L18
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r6
            goto L36
        L18:
            r4 = r7
            r7 = r6
            r6 = r4
        L1b:
            int r2 = r2 + 1
            byte r3 = (byte) r6
            r1[r2] = r3
            if (r2 != r5) goto L2b
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2b:
            int r7 = r7 + 1
            r3 = r0[r7]
            r4 = r8
            r8 = r7
            r7 = r3
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r4
        L36:
            int r6 = r6 + r7
            int r6 = r6 + (-7)
            r7 = r8
            r8 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.g(int, byte, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        int i = M + 83;
        getNameOrBuilderList = i % 128;
        char c = i % 2 != 0 ? (char) 2 : '7';
        Object obj = null;
        G = 269894770;
        if (c != '7') {
            obj.hashCode();
        }
        int i2 = M + 3;
        getNameOrBuilderList = i2 % 128;
        if ((i2 % 2 != 0 ? '3' : 'N') != 'N') {
            obj.hashCode();
        }
    }

    public final void _$_clearFindViewByIdCache() {
        try {
            int i = getNameOrBuilderList + 19;
            try {
                M = i % 128;
                if (!(i % 2 == 0)) {
                    this._$_findViewCache.clear();
                } else {
                    this._$_findViewCache.clear();
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = M + 61;
                getNameOrBuilderList = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x001c, code lost:
    
        if (r2 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0034, code lost:
    
        if ((r2 == null) != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0036, code lost:
    
        r2 = findViewById(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003c, code lost:
    
        if (r2 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003e, code lost:
    
        r4 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0041, code lost:
    
        r4 = 'S';
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0043, code lost:
    
        if (r4 == 16) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0046, code lost:
    
        r0.put(java.lang.Integer.valueOf(r6), r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x004f, code lost:
    
        r6 = id.dana.oauth.activity.OauthGrantActivity.M + 57;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0058, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r6) {
        /*
            r5 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 119
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L23
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5._$_findViewCache
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            java.lang.Object r2 = r0.get(r2)
            android.view.View r2 = (android.view.View) r2
            r1.hashCode()     // Catch: java.lang.Throwable -> L21
            if (r2 != 0) goto L1f
            goto L36
        L1f:
            r1 = r2
            goto L58
        L21:
            r6 = move-exception
            throw r6
        L23:
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5._$_findViewCache     // Catch: java.lang.Exception -> L5b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L5b
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Exception -> L59
            android.view.View r2 = (android.view.View) r2     // Catch: java.lang.Exception -> L5b
            if (r2 != 0) goto L33
            r3 = 1
            goto L34
        L33:
            r3 = 0
        L34:
            if (r3 == 0) goto L1f
        L36:
            android.view.View r2 = r5.findViewById(r6)
            r3 = 16
            if (r2 == 0) goto L41
            r4 = 16
            goto L43
        L41:
            r4 = 83
        L43:
            if (r4 == r3) goto L46
            goto L58
        L46:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.put(r6, r2)
            int r6 = id.dana.oauth.activity.OauthGrantActivity.M     // Catch: java.lang.Exception -> L59
            int r6 = r6 + 57
            int r0 = r6 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r0
            int r6 = r6 % 2
            goto L1f
        L58:
            return r1
        L59:
            r6 = move-exception
            throw r6
        L5b:
            r6 = move-exception
            goto L5e
        L5d:
            throw r6
        L5e:
            goto L5d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity._$_findCachedViewById(int):android.view.View");
    }

    /* JADX WARN: Code restructure failed: missing block: B:326:0x0093, code lost:
    
        if (r1 > 99999) goto L327;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void attachBaseContext(android.content.Context r25) {
        /*
            Method dump skipped, instructions count: 3154
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        try {
            int i = M + 111;
            try {
                getNameOrBuilderList = i % 128;
                if (i % 2 != 0) {
                    Context applicationContext = super.getApplicationContext();
                    Object[] objArr = null;
                    int length = objArr.length;
                    return applicationContext;
                }
                return super.getApplicationContext();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        int i = M + 5;
        getNameOrBuilderList = i % 128;
        int i2 = i % 2;
        Context baseContext = super.getBaseContext();
        try {
            int i3 = M + 41;
            getNameOrBuilderList = i3 % 128;
            int i4 = i3 % 2;
            return baseContext;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        try {
            int i = getNameOrBuilderList + 65;
            M = i % 128;
            int i2 = i % 2;
            String authRequestContext = AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            int i3 = M + 123;
            getNameOrBuilderList = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object[] objArr = null;
                int length = objArr.length;
                return authRequestContext;
            }
            return authRequestContext;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        int i = getNameOrBuilderList + 73;
        M = i % 128;
        int i2 = i % 2;
        int i3 = getNameOrBuilderList + 67;
        M = i3 % 128;
        if ((i3 % 2 == 0 ? '6' : '2') != '6') {
            return R.layout.activity_oauth_grant;
        }
        Object obj = null;
        obj.hashCode();
        return R.layout.activity_oauth_grant;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = M + 125;
        getNameOrBuilderList = i % 128;
        int i2 = i % 2;
        Resources resources = super.getResources();
        int i3 = getNameOrBuilderList + 83;
        M = i3 % 128;
        if ((i3 % 2 == 0 ? 'D' : '1') != '1') {
            Object obj = null;
            obj.hashCode();
            return resources;
        }
        return resources;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2;
        int i = M + 35;
        getNameOrBuilderList = i % 128;
        int i2 = i % 2;
        int i3 = M + 63;
        getNameOrBuilderList = i3 % 128;
        int i4 = i3 % 2;
        int i5 = getNameOrBuilderList + 103;
        M = i5 % 128;
        int i6 = i5 % 2;
        try {
            Object[] objArr3 = new Object[1];
            b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr3);
            Class<?> cls = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), objArr4);
            Object[] objArr5 = new Object[1];
            c(false, ((ApplicationInfo) cls.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 153, super.getResources().getString(R.string.send_money_rename_saved_bank_account).substring(12, 13).codePointAt(0) - 94, super.getResources().getString(R.string.referral_tracker_hidden_button_play).substring(4, 15).codePointAt(9) - 83, new char[]{2, 16, 16, 65534, 11, 1, 15, '\f', 6, 1, 65483, '\f', 16, 65483, 65517, 15, '\f', 0}, objArr5);
            Class<?> cls2 = Class.forName((String) objArr5[0]);
            int i7 = (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 190;
            int i8 = M + 75;
            getNameOrBuilderList = i8 % 128;
            int i9 = i8 % 2;
            try {
                Object[] objArr6 = new Object[1];
                b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr6);
                Class<?> cls3 = Class.forName((String) objArr6[0]);
                b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
                Object[] objArr7 = new Object[1];
                c(false, i7, ((ApplicationInfo) cls3.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 28, super.getResources().getString(R.string.add_and_use_this_card).substring(4, 5).length() + 4, new char[]{5, 17, 65517, 1, 65532}, objArr7);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if ((intValue < 99000) || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (!(baseContext != null)) {
                        Object[] objArr8 = new Object[1];
                        c(false, 186 - TextUtils.getCapsMode("", 0, 0), getPackageName().codePointAt(1) - 96, getPackageName().codePointAt(1) - 74, new char[]{15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5}, objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        c(true, super.getResources().getString(R.string.roll_dice_error).substring(22, 23).codePointAt(0) + 83, super.getResources().getString(R.string.loyalty_tooltip_title).substring(1, 2).codePointAt(0) - 110, Color.red(0) + 18, new char[]{65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11}, objArr9);
                        baseContext = (Context) cls4.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
                    }
                    if ((baseContext != null ? 'S' : (char) 17) == 'S') {
                        int i10 = M + 43;
                        getNameOrBuilderList = i10 % 128;
                        int i11 = i10 % 2;
                        baseContext = baseContext.getApplicationContext();
                        if (i11 != 0) {
                            Object[] objArr10 = null;
                            int length = objArr10.length;
                        }
                    }
                    if ((baseContext != null ? '@' : '2') != '2') {
                        int i12 = getNameOrBuilderList + 17;
                        M = i12 % 128;
                        int i13 = i12 % 2;
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), ExpandableListView.getPackedPositionGroup(0L) + 35, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(objArr, objArr);
                            try {
                                Object[] objArr11 = new Object[1];
                                b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr11);
                                Class<?> cls5 = Class.forName((String) objArr11[0]);
                                Object[] objArr12 = new Object[1];
                                b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), objArr12);
                                Object[] objArr13 = new Object[1];
                                c(false, ((ApplicationInfo) cls5.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 125, super.getResources().getString(R.string.social_feed_no_network_message).substring(14, 15).codePointAt(0) - 63, super.getResources().getString(R.string.referral_tracker_empty).substring(16, 17).codePointAt(0) - 62, new char[]{28, 31, 30, 65515, 65514, 65519, 65514, 65514, 65519, JSONLexer.EOI, 29, 28, 28, 65519, 29, 65516, 65521, 29, 65515, 29, JSONLexer.EOI, 30, 65522, 65519, 65515, 65522, 31, 65522, 65521, 65513, 65520, 31, 65517, 65519, 27, 65516, 65519, 30, 65520, 28, 65519, 65521, 65513, 29, 65522, 65521, 65520, 30}, objArr13);
                                String str = (String) objArr13[0];
                                int codePointAt = getPackageName().codePointAt(2) + 107;
                                int i14 = M + 65;
                                getNameOrBuilderList = i14 % 128;
                                int i15 = i14 % 2;
                                try {
                                    Object[] objArr14 = new Object[1];
                                    b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr14);
                                    Class<?> cls6 = Class.forName((String) objArr14[0]);
                                    Object[] objArr15 = new Object[1];
                                    b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), objArr15);
                                    Object[] objArr16 = new Object[1];
                                    c(true, codePointAt, ((ApplicationInfo) cls6.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 24, getPackageName().length() + 57, new char[]{65518, 65519, 65518, 65525, 65527, 65527, 65525, 65521, 65521, 65525, 65519, 65525, '!', 65519, '#', 65518, 65523, 65521, 65518, '!', '!', 65526, 65522, Typography.quote, '!', 65520, 65520, Typography.quote, 65526, '#', 65527, InputCardNumberView.DIVIDER, 65524, 65521, 65524, 65519, Typography.quote, 65519, Typography.dollar, 65520, 65520, 65522, 65519, 65519, Typography.quote, 65523, 65527, '!', Typography.quote, 65526, 65518, 65527, Typography.dollar, Typography.quote, 65524, 65523, 31, 65521, Typography.quote, 65526, 65519, InputCardNumberView.DIVIDER, '!', 65519}, objArr16);
                                    String str2 = (String) objArr16[0];
                                    Object[] objArr17 = new Object[1];
                                    c(false, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + TarHeader.USTAR_FILENAME_PREFIX, (ViewConfiguration.getWindowTouchSlop() >> 8) + 13, 64 - (Process.myPid() >> 22), new char[]{'!', 65518, 65517, Typography.quote, 65521, 65523, 65521, 65525, 65522, Typography.quote, 65521, 65521, 65525, 65518, 65517, '!', 30, 65525, 65523, 65518, 65520, 65524, 65524, 65524, 65517, 65517, 65519, 65516, 65523, 29, '!', 65520, InputCardNumberView.DIVIDER, 65518, 30, 29, 65519, 65523, Typography.quote, 65525, 65524, Typography.quote, Typography.quote, 65523, 31, 65523, InputCardNumberView.DIVIDER, 65518, 65524, 30, 65523, 65522, 65524, 65524, Typography.quote, 65517, 65520, 65524, 65516, 29, 30, Typography.quote, 65525, 31}, objArr17);
                                    String str3 = (String) objArr17[0];
                                    Object[] objArr18 = new Object[1];
                                    c(true, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 183, super.getResources().getString(R.string.my_bills_label_top_up).substring(0, 6).length() + 18, super.getResources().getString(R.string.promo_discovery_error_network_description).substring(0, 1).length() + 59, new char[]{65485, 19, 18, 0, 2, 19, 0, 4, 17, 7, 19, 65485, 0, '\r', 0, 3, 65486, 65486, 65497, 18, 15, 19, 19, 7, 18, 19, '\r', 4, 21, 4, 65486, 65489, 21, 65486, 19, 18, 4, 6, '\r', '\b', 65486, '\b', 15, 0, 65486, '\f', 14, 2, 65485, 4, 17, 0, 20, 16, 18, 3, 17, 0, 20, 6}, objArr18);
                                    String str4 = (String) objArr18[0];
                                    Object[] objArr19 = new Object[1];
                                    c(false, super.getResources().getString(R.string.promo_applied_desc).substring(36, 37).length() + 136, getPackageName().codePointAt(5) - 108, getPackageName().length() - 1, new char[]{0, 65535, 7, 65532, 2, 65532}, objArr19);
                                    try {
                                        Object[] objArr20 = {baseContext, str, str2, str3, str4, true, (String) objArr19[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myTid() >> 22), 18 - (Process.myPid() >> 22), (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr20);
                                    } catch (Throwable th) {
                                        Throwable cause = th.getCause();
                                        if (cause == null) {
                                            throw th;
                                        }
                                        throw cause;
                                    }
                                } catch (Throwable th2) {
                                    Throwable cause2 = th2.getCause();
                                    if (cause2 == null) {
                                        throw th2;
                                    }
                                    throw cause2;
                                }
                            } catch (Throwable th3) {
                                Throwable cause3 = th3.getCause();
                                if (cause3 == null) {
                                    throw th3;
                                }
                                throw cause3;
                            }
                        } catch (Throwable th4) {
                            Throwable cause4 = th4.getCause();
                            if (cause4 == null) {
                                throw th4;
                            }
                            throw cause4;
                        }
                    }
                }
                try {
                    Object[] objArr21 = new Object[1];
                    b(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr21);
                    Class<?> cls7 = Class.forName((String) objArr21[0]);
                    byte b = (byte) (getAuthRequestContext[34] + 1);
                    byte b2 = getAuthRequestContext[25];
                    Object[] objArr22 = new Object[1];
                    b(b, b2, (byte) (b2 | 8), objArr22);
                    try {
                        Object[] objArr23 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr22[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.getTrimmedLength(""), 4 - View.MeasureSpec.getMode(0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                            Object[] objArr24 = new Object[1];
                            g((byte) ($$a[78] - 1), (byte) (-$$a[40]), $$a[9], objArr24);
                            obj3 = cls8.getMethod((String) objArr24[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr25 = (Object[]) ((Method) obj3).invoke(null, objArr23);
                        int i16 = ((int[]) objArr25[1])[0];
                        if (((int[]) objArr25[0])[0] != i16) {
                            long j = ((r3 ^ i16) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr2 = null;
                                } else {
                                    objArr2 = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr2, objArr2);
                                try {
                                    Object[] objArr26 = {543347372, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, View.resolveSize(0, 0) + 18, (char) Color.blue(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr26);
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            } catch (Throwable th6) {
                                Throwable cause6 = th6.getCause();
                                if (cause6 == null) {
                                    throw th6;
                                }
                                throw cause6;
                            }
                        }
                        super.onCreate(bundle);
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        } catch (Throwable th10) {
            Throwable cause10 = th10.getCause();
            if (cause10 == null) {
                throw th10;
            }
            throw cause10;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String str) {
        try {
            int i = getNameOrBuilderList + 19;
            M = i % 128;
            if ((i % 2 == 0 ? '\b' : (char) 30) != 30) {
                int i2 = 36 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Class<?> cls;
        int i = getNameOrBuilderList + 115;
        M = i % 128;
        int i2 = i % 2;
        Context baseContext = getBaseContext();
        Object[] objArr = null;
        if (baseContext == null) {
            int codePointAt = getPackageName().codePointAt(1) + 86;
            int i3 = (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 4;
            int i4 = M + 79;
            getNameOrBuilderList = i4 % 128;
            int i5 = i4 % 2;
            try {
                Object[] objArr2 = new Object[1];
                b((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr2);
                cls = Class.forName((String) objArr2[0]);
                b(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr3 = new Object[1];
                c(false, codePointAt, i3, ((ApplicationInfo) cls.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                c(true, 193 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), getPackageName().codePointAt(4) - 96, super.getResources().getString(R.string.bottom_on_boarding_subtitle_saving_goal_second).substring(12, 13).codePointAt(0) - 79, new char[]{65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            } catch (Throwable th2) {
                th = th2;
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            int i6 = M + 65;
            getNameOrBuilderList = i6 % 128;
            if (i6 % 2 == 0) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), 36 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr5 = {baseContext};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + 911, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr5);
                    } catch (Throwable th3) {
                        Throwable cause2 = th3.getCause();
                        if (cause2 == null) {
                            throw th3;
                        }
                        throw cause2;
                    }
                } catch (Throwable th4) {
                    Throwable cause3 = th4.getCause();
                    if (cause3 == null) {
                        throw th4;
                    }
                    throw cause3;
                }
            } else {
                try {
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj3 == null) {
                        obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myPid() >> 22), 35 - Gravity.getAbsoluteGravity(0, 0), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, null);
                    try {
                        Object[] objArr6 = {baseContext};
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, 'B' - AndroidCharacter.getMirror('0'), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj4);
                        }
                        ((Method) obj4).invoke(invoke2, objArr6);
                        int length = objArr.length;
                    } catch (Throwable th5) {
                        Throwable cause4 = th5.getCause();
                        if (cause4 == null) {
                            throw th5;
                        }
                        throw cause4;
                    }
                } catch (Throwable th6) {
                    Throwable cause5 = th6.getCause();
                    if (cause5 == null) {
                        throw th6;
                    }
                    throw cause5;
                }
            }
        }
        super.onResume();
        int i7 = M + 43;
        getNameOrBuilderList = i7 % 128;
        int i8 = i7 % 2;
    }

    public OauthGrantActivity() {
        try {
            this._$_findViewCache = new LinkedHashMap();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.oauth.activity.OauthGrantActivity$danaLoadingDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DanaLoadingDialog invoke() {
                    return new DanaLoadingDialog(OauthGrantActivity.this);
                }
            });
            this.getCallingPid = "";
            this.FragmentBottomSheetPaymentSettingBinding = "";
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ OauthParamsModel access$getOauthParamsModel$p(OauthGrantActivity oauthGrantActivity) {
        int i = getNameOrBuilderList + 65;
        M = i % 128;
        int i2 = i % 2;
        OauthParamsModel oauthParamsModel = oauthGrantActivity.NetworkUserEntityData$$ExternalSyntheticLambda4;
        try {
            int i3 = M + 43;
            getNameOrBuilderList = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 79 / 0;
                return oauthParamsModel;
            }
            return oauthParamsModel;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void access$submitAuthApply(OauthGrantActivity oauthGrantActivity, String str, List list) {
        int i = getNameOrBuilderList + 31;
        M = i % 128;
        boolean z = i % 2 == 0;
        Object[] objArr = null;
        oauthGrantActivity.KClassImpl$Data$declaredNonStaticMembers$2(str, list);
        if (z) {
            int length = objArr.length;
        }
        try {
            int i2 = getNameOrBuilderList + 65;
            try {
                M = i2 % 128;
                if (i2 % 2 == 0) {
                    int length2 = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0019, code lost:
    
        if ((r0 != null ? '^' : '9') != '^') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0029, code lost:
    
        if ((r0 != null ? 'L' : '.') != '.') goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x002b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x002c, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList + 71;
        id.dana.oauth.activity.OauthGrantActivity.M = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x003b, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "getPresenter")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.oauth.OauthGrantContract.Presenter getPresenter() {
        /*
            r4 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList     // Catch: java.lang.Exception -> L3c
            int r0 = r0 + 23
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1     // Catch: java.lang.Exception -> L3c
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L1e
            id.dana.contract.oauth.OauthGrantContract$Presenter r0 = r4.presenter
            int r2 = r1.length     // Catch: java.lang.Throwable -> L1c
            r2 = 94
            if (r0 == 0) goto L17
            r3 = 94
            goto L19
        L17:
            r3 = 57
        L19:
            if (r3 == r2) goto L2b
            goto L2c
        L1c:
            r0 = move-exception
            throw r0
        L1e:
            id.dana.contract.oauth.OauthGrantContract$Presenter r0 = r4.presenter
            r2 = 46
            if (r0 == 0) goto L27
            r3 = 76
            goto L29
        L27:
            r3 = 46
        L29:
            if (r3 == r2) goto L2c
        L2b:
            return r0
        L2c:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 71
            int r2 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r2
            int r0 = r0 % 2
            return r1
        L3c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.getPresenter():id.dana.contract.oauth.OauthGrantContract$Presenter");
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(OauthGrantContract.Presenter presenter) {
        int i = getNameOrBuilderList + 25;
        M = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(presenter, "");
            this.presenter = presenter;
            int i2 = 51 / 0;
        } else {
            try {
                Intrinsics.checkNotNullParameter(presenter, "");
                this.presenter = presenter;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = getNameOrBuilderList + 45;
        M = i3 % 128;
        if ((i3 % 2 == 0 ? 'L' : (char) 31) != 31) {
            Object obj = null;
            obj.hashCode();
        }
    }

    @JvmName(name = "getReadLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        try {
            int i = getNameOrBuilderList + 73;
            try {
                M = i % 128;
                int i2 = i % 2;
                ReadLinkPropertiesContract.Presenter presenter = this.readLinkPropertiesPresenter;
                if ((presenter != null ? 'H' : 'b') == 'b') {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    return null;
                }
                int i3 = M + 85;
                getNameOrBuilderList = i3 % 128;
                int i4 = i3 % 2;
                return presenter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        try {
            int i = getNameOrBuilderList + 59;
            M = i % 128;
            if ((i % 2 == 0 ? ',' : 'S') != ',') {
                Intrinsics.checkNotNullParameter(presenter, "");
                this.readLinkPropertiesPresenter = presenter;
                return;
            }
            Intrinsics.checkNotNullParameter(presenter, "");
            this.readLinkPropertiesPresenter = presenter;
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getScopeAdapter")
    public final ScopeAdapter getScopeAdapter() {
        try {
            int i = M + 41;
            getNameOrBuilderList = i % 128;
            int i2 = i % 2;
            ScopeAdapter scopeAdapter = this.scopeAdapter;
            Object[] objArr = null;
            if ((scopeAdapter != null ? (char) 21 : '_') != '_') {
                int i3 = getNameOrBuilderList + 63;
                M = i3 % 128;
                if (i3 % 2 == 0) {
                    int length = objArr.length;
                }
                return scopeAdapter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("");
            int i4 = getNameOrBuilderList + 61;
            M = i4 % 128;
            int i5 = i4 % 2;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "setScopeAdapter")
    public final void setScopeAdapter(ScopeAdapter scopeAdapter) {
        int i = getNameOrBuilderList + 87;
        M = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(scopeAdapter, "");
        this.scopeAdapter = scopeAdapter;
        try {
            int i3 = getNameOrBuilderList + 75;
            M = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "GetContactSyncConfig")
    private final DanaLoadingDialog GetContactSyncConfig() {
        try {
            int i = M + 51;
            getNameOrBuilderList = i % 128;
            int i2 = i % 2;
            DanaLoadingDialog danaLoadingDialog = (DanaLoadingDialog) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
            int i3 = M + 67;
            getNameOrBuilderList = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return danaLoadingDialog;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return danaLoadingDialog;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        int i = M + 93;
        getNameOrBuilderList = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? (char) 15 : 'X') != 'X') {
            setCenterTitle(getString(R.string.confirmation_oauth));
            objArr.hashCode();
        } else {
            setCenterTitle(getString(R.string.confirmation_oauth));
        }
        int i2 = getNameOrBuilderList + 73;
        M = i2 % 128;
        if (i2 % 2 == 0) {
            int length = objArr.length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x002a, code lost:
    
        if (r0 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0035, code lost:
    
        if (r0 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0037, code lost:
    
        com.bumptech.glide.Glide.getAuthRequestContext((androidx.fragment.app.FragmentActivity) r5).getAuthRequestContext(java.lang.Integer.valueOf((int) id.dana.R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2)).MyBillsEntityDataFactory((android.widget.ImageView) r0);
        r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList + 59;
        id.dana.oauth.activity.OauthGrantActivity.M = r0 % 128;
        r0 = r0 % 2;
     */
    @Override // id.dana.base.BaseActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void init() {
        /*
            r5 = this;
            r5.NetworkUserEntityData$$ExternalSyntheticLambda6()
            r5.FragmentBottomSheetPaymentSettingBinding()
            r5.readMicros()
            boolean r0 = r5.B()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5b
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 53
            int r3 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L1f
            r0 = 0
            goto L20
        L1f:
            r0 = 1
        L20:
            r3 = 2131232241(0x7f0805f1, float:1.8080586E38)
            if (r0 == 0) goto L2d
            r5.setMenuLeftButton(r3)
            com.google.android.material.imageview.ShapeableImageView r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8
            if (r0 == 0) goto L61
            goto L37
        L2d:
            r5.setMenuLeftButton(r3)
            com.google.android.material.imageview.ShapeableImageView r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8
            r3 = 28
            int r3 = r3 / r1
            if (r0 == 0) goto L61
        L37:
            r3 = r5
            androidx.fragment.app.FragmentActivity r3 = (androidx.fragment.app.FragmentActivity) r3
            com.bumptech.glide.RequestManager r3 = com.bumptech.glide.Glide.getAuthRequestContext(r3)
            r4 = 2131232307(0x7f080633, float:1.808072E38)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            com.bumptech.glide.RequestBuilder r3 = r3.getAuthRequestContext(r4)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r3.MyBillsEntityDataFactory(r0)
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 59
            int r3 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r3
            int r0 = r0 % 2
            goto L61
        L59:
            r0 = move-exception
            throw r0
        L5b:
            r0 = 2131232850(0x7f080852, float:1.808182E38)
            r5.setMenuLeftButton(r0)
        L61:
            boolean r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda3
            if (r0 == 0) goto L66
            r1 = 1
        L66:
            if (r1 == r2) goto L6f
            r5.NetworkUserEntityData$$ExternalSyntheticLambda5()
            r5.NetworkUserEntityData$$ExternalSyntheticLambda7()
            goto Lb0
        L6f:
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1
            int r0 = r0 % 2
            id.dana.oauth.OauthLoginManager r0 = id.dana.oauth.OauthLoginManager.INSTANCE
            boolean r0 = id.dana.oauth.OauthLoginManager.initRecordTimeStamp()
            if (r0 == 0) goto L92
            android.content.Intent r0 = new android.content.Intent
            r1 = r5
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<id.dana.onboarding.splash.LocalConfigSplashActivity> r2 = id.dana.onboarding.splash.LocalConfigSplashActivity.class
            r0.<init>(r1, r2)
            r5.startActivity(r0)
            r5.finish()
            return
        L92:
            r0 = 2131365105(0x7f0a0cf1, float:1.8350066E38)
            android.view.View r0 = r5.findViewById(r0)
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = 8
            r0.setVisibility(r1)
            android.view.View r0 = r5.PrepareContext
            if (r0 == 0) goto Laa
            r0.setVisibility(r1)
        Laa:
            r5.showConfirmProgress()
            r5.A()
        Lb0:
            r5.getOnBoardingScenario()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.init():void");
    }

    @Override // id.dana.base.BaseActivity
    public final void onClickLeftMenuButton(View view) {
        try {
            int i = M + 73;
            getNameOrBuilderList = i % 128;
            int i2 = i % 2;
            super.onClickLeftMenuButton(view);
            this.getErrorConfigVersion = 0;
            int i3 = M + 103;
            getNameOrBuilderList = i3 % 128;
            if ((i3 % 2 != 0 ? 'E' : '9') != 'E') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x014f, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0150, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x001e, code lost:
    
        if (r0 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0028, code lost:
    
        if (r0 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x002b, code lost:
    
        r12 = new java.lang.Object[1];
        b((byte) (id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[59] + 1), (byte) (-id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[30]), id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[25], r12);
        r0 = java.lang.Class.forName((java.lang.String) r12[0]);
        r13 = new java.lang.Object[1];
        b(id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[25], id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[56], (byte) (-id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[5]), r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0075, code lost:
    
        r0 = new java.lang.Object[1];
        c(false, ((android.content.pm.ApplicationInfo) r0.getMethod((java.lang.String) r13[0], null).invoke(r20, null)).targetSdkVersion + 153, android.text.TextUtils.getCapsMode("", 0, 0) + 4, super.getResources().getString(id.dana.R.string.result_pending_timer).substring(0, 5).length() + 21, new char[]{15, 2, 65534, 1, 65534, 11, 1, 15, '\f', 6, 1, 65483, 65534, '\r', '\r', 65483, 65502, 0, 17, 6, 19, 6, 17, 22, 65521, 5}, r0);
        r0 = java.lang.Class.forName((java.lang.String) r0[0]);
        r10 = id.dana.oauth.activity.OauthGrantActivity.M + 117;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r10 % 128;
        r10 = r10 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00b6, code lost:
    
        r13 = new java.lang.Object[1];
        b((byte) (id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[59] + 1), (byte) (-id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[30]), id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[25], r13);
        r10 = java.lang.Class.forName((java.lang.String) r13[0]);
        r14 = new java.lang.Object[1];
        b(id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[25], id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[56], (byte) (-id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext[5]), r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00f7, code lost:
    
        r15 = new java.lang.Object[1];
        c(true, ((android.content.pm.ApplicationInfo) r10.getMethod((java.lang.String) r14[0], null).invoke(r20, null)).targetSdkVersion + com.alipay.zoloz.toyger.blob.BlobStatic.MONITOR_IMAGE_WIDTH, super.getResources().getString(id.dana.R.string.csat_survey_title).substring(0, 7).length() - 6, (android.widget.ExpandableListView.getPackedPositionForGroup(0) > 0 ? 1 : (android.widget.ExpandableListView.getPackedPositionForGroup(0) == 0 ? 0 : -1)) + 18, new char[]{65529, 4, 5, 65535, '\n', 65527, 65529, 65535, 2, 6, 6, 65495, '\n', 4, 65531, '\b', '\b', 11}, r15);
        r0 = (android.content.Context) r0.getMethod((java.lang.String) r15[0], new java.lang.Class[0]).invoke(null, null);
        r9 = id.dana.oauth.activity.OauthGrantActivity.M + 29;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x013f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0140, code lost:
    
        r2 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0144, code lost:
    
        if (r2 != null) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0146, code lost:
    
        throw r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0147, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0148, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0149, code lost:
    
        r2 = r0.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x014d, code lost:
    
        if (r2 != null) goto L100;
     */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onPause() {
        /*
            Method dump skipped, instructions count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.onPause():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0023, code lost:
    
        if ((r4.NetworkUserEntityData$$ExternalSyntheticLambda3 ? 27 : '2') != '2') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002d, code lost:
    
        if (r4.NetworkUserEntityData$$ExternalSyntheticLambda3 != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x002f, code lost:
    
        r0 = id.dana.oauth.activity.OauthGrantActivity.M + 67;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0039, code lost:
    
        if ((r0 % 2) == 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003c, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x003d, code lost:
    
        if (r2 == true) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x003f, code lost:
    
        finishAffinity();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0042, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0043, code lost:
    
        r0 = r0.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0047, code lost:
    
        finishAffinity();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x004a, code lost:
    
        super.onBackPressed();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x004d, code lost:
    
        return;
     */
    @Override // androidx.view.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onBackPressed() {
        /*
            r4 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 15
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == 0) goto L26
            r4.PlaceComponentResult()
            r4.getErrorConfigVersion = r2
            boolean r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda3
            r3 = 50
            if (r0 == 0) goto L21
            r0 = 27
            goto L23
        L21:
            r0 = 50
        L23:
            if (r0 == r3) goto L4a
            goto L2f
        L26:
            r4.PlaceComponentResult()
            r4.getErrorConfigVersion = r2     // Catch: java.lang.Exception -> L50
            boolean r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda3     // Catch: java.lang.Exception -> L4e
            if (r0 == 0) goto L4a
        L2f:
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 67
            int r3 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L3c
            goto L3d
        L3c:
            r2 = 1
        L3d:
            if (r2 == r1) goto L47
            r4.finishAffinity()     // Catch: java.lang.Exception -> L4e
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L45
            goto L4a
        L45:
            r0 = move-exception
            throw r0
        L47:
            r4.finishAffinity()
        L4a:
            super.onBackPressed()
            return
        L4e:
            r0 = move-exception
            throw r0
        L50:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.onBackPressed():void");
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.View
    public final void onQrBindingError() {
        try {
            int i = M + 123;
            getNameOrBuilderList = i % 128;
            int i2 = i % 2;
            C();
            int i3 = getNameOrBuilderList + 125;
            try {
                M = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.View
    public final void onOauthError(Throwable throwable, String errorPath) {
        String str = null;
        NetworkException networkException = throwable instanceof NetworkException ? (NetworkException) throwable : null;
        this.initRecordTimeStamp = networkException == null ? null : networkException.getErrorCode();
        if ((throwable != null ? (char) 4 : 'D') != 'D') {
            int i = getNameOrBuilderList + 105;
            M = i % 128;
            int i2 = i % 2;
            try {
                str = throwable.getMessage();
            } catch (Exception e) {
                throw e;
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = errorPath;
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        View view = this.newProxyInstance;
        if (view != null) {
            int i3 = getNameOrBuilderList + 67;
            M = i3 % 128;
            int i4 = i3 % 2;
            view.setVisibility(0);
        }
        View view2 = this.PrepareContext;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.View
    public final void onConfirmOauthScopeSuccess(String r5, String r6) {
        OauthTargetManager oauthTargetManager = new OauthTargetManager(this.getCallingPid);
        OauthParamsModel oauthParamsModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        StringBuilder sb = new StringBuilder();
        sb.append(oauthParamsModel.PlaceComponentResult(oauthTargetManager.BuiltInFictitiousFunctionClassFactory));
        sb.append(TagFormat.MyBillsEntityDataFactory(DanaUrl.OAUTH_SUCCESS).PlaceComponentResult(OauthConstant.PathParams.MOBILE_AUTH_CODE, r5).PlaceComponentResult(OauthConstant.PathParams.SERVER_AUTH_CODE, r6).PlaceComponentResult(OauthConstant.PathParams.STATE_CODE, oauthParamsModel.newProxyInstance).MyBillsEntityDataFactory());
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        KClassImpl$Data$declaredNonStaticMembers$2(obj);
        try {
            int i = getNameOrBuilderList + 19;
            M = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x003b, code lost:
    
        if ((r0) != true) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0046, code lost:
    
        if (r0 == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0048, code lost:
    
        r0 = id.dana.oauth.activity.OauthGrantActivity.M + 25;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r0 % 128;
        r0 = r0 % 2;
        PlaceComponentResult(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0055, code lost:
    
        return;
     */
    @Override // id.dana.contract.oauth.OauthGrantContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onGetAuthCodeSuccess(id.dana.oauth.model.AuthCodeModel r5) {
        /*
            r4 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)     // Catch: java.lang.Exception -> L72
            boolean r0 = r4.BottomSheetCardBindingView$watcherCardNumberView$1()     // Catch: java.lang.Exception -> L72
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            if (r0 == r1) goto L5c
            boolean r0 = r4.B()
            if (r0 != 0) goto L58
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M     // Catch: java.lang.Exception -> L56
            int r0 = r0 + 13
            int r3 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r3     // Catch: java.lang.Exception -> L56
            int r0 = r0 % 2
            if (r0 == 0) goto L40
            id.dana.oauth.OauthLoginManager r0 = id.dana.oauth.OauthLoginManager.INSTANCE     // Catch: java.lang.Exception -> L56
            boolean r0 = id.dana.oauth.OauthLoginManager.NetworkUserEntityData$$ExternalSyntheticLambda7()     // Catch: java.lang.Exception -> L56
            r3 = 30
            int r3 = r3 / r2
            if (r0 != 0) goto L3a
            goto L3b
        L3a:
            r2 = 1
        L3b:
            if (r2 == r1) goto L58
            goto L48
        L3e:
            r5 = move-exception
            throw r5
        L40:
            id.dana.oauth.OauthLoginManager r0 = id.dana.oauth.OauthLoginManager.INSTANCE
            boolean r0 = id.dana.oauth.OauthLoginManager.NetworkUserEntityData$$ExternalSyntheticLambda7()
            if (r0 != 0) goto L58
        L48:
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 25
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1
            int r0 = r0 % 2
            r4.PlaceComponentResult(r5)
            return
        L56:
            r5 = move-exception
            throw r5
        L58:
            r4.BuiltInFictitiousFunctionClassFactory(r5)
            return
        L5c:
            int r5 = id.dana.oauth.activity.OauthGrantActivity.M
            int r5 = r5 + 27
            int r0 = r5 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r0
            int r5 = r5 % 2
            r4.D()
            if (r5 == 0) goto L71
            r5 = 29
            int r5 = r5 / r2
            goto L71
        L6f:
            r5 = move-exception
            throw r5
        L71:
            return
        L72:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.onGetAuthCodeSuccess(id.dana.oauth.model.AuthCodeModel):void");
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.View
    public final void onGetAuthCodeRiskFailed(String r3, List<String> verificationMethods) {
        int i = M + 87;
        getNameOrBuilderList = i % 128;
        char c = i % 2 != 0 ? (char) 5 : 'R';
        MyBillsEntityDataFactory(r3, verificationMethods);
        if (c != 'R') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int r6, int resultCode, Intent data) {
        int i = getNameOrBuilderList + 45;
        M = i % 128;
        int i2 = i % 2;
        ChallengeControl challengeControl = this.moveToNextValue;
        if (!(challengeControl == null)) {
            int i3 = M + 115;
            getNameOrBuilderList = i3 % 128;
            int i4 = i3 % 2;
            if (challengeControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                challengeControl = null;
            }
            try {
                if (challengeControl.MyBillsEntityDataFactory(r6, resultCode, data)) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        super.onActivityResult(r6, resultCode, data);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0019, code lost:
    
        if (r0 == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0022, code lost:
    
        if (r0.isEmpty() == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0024, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0033  */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(final java.lang.String r8, final java.util.List<java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 180
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.MyBillsEntityDataFactory(java.lang.String, java.util.List):void");
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.View
    public final void onGetPhoneNumberSuccess(String phoneNumber) {
        String str;
        int i = getNameOrBuilderList + 43;
        M = i % 128;
        int i2 = i % 2;
        String authRequestContext = getAuthRequestContext(phoneNumber);
        TextView textView = this.B;
        Object[] objArr = null;
        if ((textView != null ? 'E' : '=') == 'E') {
            if (BottomSheetCardBindingView$watcherCardNumberView$1()) {
                int i3 = getNameOrBuilderList + 39;
                M = i3 % 128;
                str = authRequestContext;
                if ((i3 % 2 == 0 ? Typography.amp : '`') == '&') {
                    objArr.hashCode();
                }
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getString(R.string.dana_id_s);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String format = String.format(string, Arrays.copyOf(new Object[]{authRequestContext}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                str = format;
            }
            textView.setText(str);
        }
        int i4 = M + 99;
        getNameOrBuilderList = i4 % 128;
        if (i4 % 2 != 0) {
            int length = objArr.length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0014, code lost:
    
        if (r0 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0026, code lost:
    
        if ((B() ? '-' : 'G') != '-') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0028, code lost:
    
        r3 = id.dana.utils.MaskedTextUtil.PlaceComponentResult(r3, "****");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x002e, code lost:
    
        r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList + 99;
        id.dana.oauth.activity.OauthGrantActivity.M = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0039, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003a, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x003b, code lost:
    
        r3 = id.dana.utils.MaskedTextUtil.PlaceComponentResult(r3, "••••");
        r0 = id.dana.oauth.activity.OauthGrantActivity.M + 35;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x004b, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String getAuthRequestContext(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 91
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L19
            boolean r0 = r2.B()
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L28
            goto L3b
        L17:
            r3 = move-exception
            throw r3
        L19:
            boolean r0 = r2.B()
            r1 = 45
            if (r0 == 0) goto L24
            r0 = 45
            goto L26
        L24:
            r0 = 71
        L26:
            if (r0 == r1) goto L3b
        L28:
            java.lang.String r0 = "****"
            java.lang.String r3 = id.dana.utils.MaskedTextUtil.PlaceComponentResult(r3, r0)     // Catch: java.lang.Exception -> L39
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 99
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            goto L4b
        L39:
            r3 = move-exception
            throw r3
        L3b:
            java.lang.String r0 = "••••"
            java.lang.String r3 = id.dana.utils.MaskedTextUtil.PlaceComponentResult(r3, r0)
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 35
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1
            int r0 = r0 % 2
        L4b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.getAuthRequestContext(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0051 A[RETURN] */
    @Override // id.dana.contract.oauth.OauthGrantContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onGetBindingBenefitsSuccess(java.util.List<id.dana.oauth.model.BindingBenefitModel> r6) {
        /*
            r5 = this;
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = 0
        La:
            r4 = 61
            if (r3 == 0) goto L28
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L17
            r0 = 61
            goto L19
        L17:
            r0 = 62
        L19:
            if (r0 == r4) goto L1c
            goto L28
        L1c:
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 55
            int r3 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r3
            int r0 = r0 % 2
            r0 = 0
            goto L29
        L28:
            r0 = 1
        L29:
            if (r0 != 0) goto L2c
            goto L2d
        L2c:
            r1 = 1
        L2d:
            if (r1 == r2) goto L3e
            r5.scheduleImpl()
            r5.PlaceComponentResult(r6)
            int r6 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r6 = r6 + r4
            int r0 = r6 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r0
            int r6 = r6 % 2
        L3e:
            int r6 = id.dana.oauth.activity.OauthGrantActivity.M     // Catch: java.lang.Exception -> L52
            int r6 = r6 + 85
            int r0 = r6 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r0     // Catch: java.lang.Exception -> L52
            int r6 = r6 % 2
            if (r6 == 0) goto L51
            r6 = 0
            r6.hashCode()     // Catch: java.lang.Throwable -> L4f
            return
        L4f:
            r6 = move-exception
            throw r6
        L51:
            return
        L52:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.onGetBindingBenefitsSuccess(java.util.List):void");
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.View
    public final void showAlipayConnectBrand(OauthInitModel oauthInitModel, ShowAlipayConnectBrandConfig showAlipayConnectBrandConfig) {
        Intrinsics.checkNotNullParameter(showAlipayConnectBrandConfig, "");
        if (oauthInitModel == null) {
            return;
        }
        int i = M + 107;
        getNameOrBuilderList = i % 128;
        int i2 = i % 2;
        List<ScopeModel> list = oauthInitModel.BuiltInFictitiousFunctionClassFactory;
        if (list != null) {
            try {
                int i3 = M + 23;
                getNameOrBuilderList = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    if ((!list.isEmpty()) == false) {
                        return;
                    }
                } else if (!(false ^ list.isEmpty())) {
                    return;
                }
                if ((B() ? '-' : 'Q') != '-') {
                    return;
                }
                int i4 = getNameOrBuilderList + 59;
                M = i4 % 128;
                if (i4 % 2 == 0) {
                    boolean show = showAlipayConnectBrandConfig.getShow();
                    Object[] objArr = null;
                    int length = objArr.length;
                    if (!show) {
                        return;
                    }
                } else if (!showAlipayConnectBrandConfig.getShow()) {
                    return;
                }
                list.add(new ScopeModel("Item Powered By Alipay", showAlipayConnectBrandConfig.getImageUrl()));
                int i5 = getNameOrBuilderList + 119;
                try {
                    M = i5 % 128;
                    int i6 = i5 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.View
    public final void showAvatar(String r4) {
        ShapeableImageView shapeableImageView = this.GetContactSyncConfig;
        if ((shapeableImageView != null ? 'M' : '=') == 'M') {
            int i = getNameOrBuilderList + 93;
            M = i % 128;
            int i2 = i % 2;
            GlideApp.PlaceComponentResult(this).PlaceComponentResult(r4).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.avatar_placeholder).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) shapeableImageView);
        }
        int i3 = M + 93;
        getNameOrBuilderList = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        try {
            int i = M + 73;
            getNameOrBuilderList = i % 128;
            int i2 = i % 2;
            getValueOfTouchPositionAbsolute();
            int i3 = M + 33;
            getNameOrBuilderList = i3 % 128;
            if ((i3 % 2 != 0 ? 'A' : '5') != '5') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        int i = M + 51;
        getNameOrBuilderList = i % 128;
        if (i % 2 == 0) {
            newProxyInstance();
            return;
        }
        newProxyInstance();
        int i2 = 69 / 0;
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.View
    public final void showConfirmProgress() {
        int i = M + 65;
        getNameOrBuilderList = i % 128;
        int i2 = i % 2;
        DanaLoadingDialog GetContactSyncConfig = GetContactSyncConfig();
        if ((!GetContactSyncConfig.MyBillsEntityDataFactory.isShowing() ? '\b' : (char) 0) != 0) {
            int i3 = getNameOrBuilderList + 119;
            M = i3 % 128;
            int i4 = i3 % 2;
            try {
                GetContactSyncConfig.MyBillsEntityDataFactory.show();
                GetContactSyncConfig.getAuthRequestContext.startRefresh();
                int i5 = getNameOrBuilderList + 63;
                M = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    @Override // id.dana.contract.oauth.OauthGrantContract.View
    public final void dismissConfirmProgress() {
        int i = M + 35;
        getNameOrBuilderList = i % 128;
        if ((i % 2 != 0 ? 'K' : 'C') != 'C') {
            try {
                GetContactSyncConfig().PlaceComponentResult();
                int i2 = 12 / 0;
            } catch (Exception e) {
                throw e;
            }
        } else {
            GetContactSyncConfig().PlaceComponentResult();
        }
        try {
            int i3 = getNameOrBuilderList + 63;
            M = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x002d, code lost:
    
        if ((r1 != null ? '\\' : 'R') != '\\') goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x003b, code lost:
    
        if (r1 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0043, code lost:
    
        if (r1.length() == 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0045, code lost:
    
        r1 = 21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0048, code lost:
    
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x004a, code lost:
    
        if (r1 == 21) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x004d, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x004f, code lost:
    
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A() {
        /*
            r7 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 109
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            r1 = 86
            if (r0 != 0) goto L11
            r0 = 35
            goto L13
        L11:
            r0 = 86
        L13:
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L32
            id.dana.oauth.OauthLoginManager r0 = id.dana.oauth.OauthLoginManager.INSTANCE
            java.lang.String r0 = id.dana.oauth.OauthLoginManager.PlaceComponentResult()
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r4.hashCode()     // Catch: java.lang.Throwable -> L30
            r5 = 92
            if (r1 == 0) goto L2b
            r6 = 92
            goto L2d
        L2b:
            r6 = 82
        L2d:
            if (r6 == r5) goto L3d
            goto L4f
        L30:
            r0 = move-exception
            throw r0
        L32:
            id.dana.oauth.OauthLoginManager r0 = id.dana.oauth.OauthLoginManager.INSTANCE
            java.lang.String r0 = id.dana.oauth.OauthLoginManager.PlaceComponentResult()
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L4f
        L3d:
            int r1 = r1.length()
            r5 = 21
            if (r1 == 0) goto L48
            r1 = 21
            goto L4a
        L48:
            r1 = 16
        L4a:
            if (r1 == r5) goto L4d
            goto L4f
        L4d:
            r1 = 0
            goto L50
        L4f:
            r1 = 1
        L50:
            if (r1 == 0) goto L80
            id.dana.oauth.OauthLoginManager r1 = id.dana.oauth.OauthLoginManager.INSTANCE
            boolean r1 = id.dana.oauth.OauthLoginManager.GetContactSyncConfig()
            if (r1 == 0) goto L80
            android.content.Intent r0 = new android.content.Intent
            r1 = r7
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<id.dana.onboarding.splash.LocalConfigSplashActivity> r3 = id.dana.onboarding.splash.LocalConfigSplashActivity.class
            r0.<init>(r1, r3)
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r0 = r0.addFlags(r1)
            r7.startActivity(r0)
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 45
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L7f
            r0 = 77
            int r0 = r0 / r2
            return
        L7d:
            r0 = move-exception
            throw r0
        L7f:
            return
        L80:
            if (r0 == 0) goto L83
            r2 = 1
        L83:
            if (r2 == r3) goto L86
            goto Lad
        L86:
            int r1 = id.dana.oauth.activity.OauthGrantActivity.M
            int r1 = r1 + 19
            int r2 = r1 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r2
            int r1 = r1 % 2
            r2 = 75
            if (r1 == 0) goto L97
            r1 = 75
            goto L99
        L97:
            r1 = 68
        L99:
            if (r1 == r2) goto La3
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r1 = r7.getReadLinkPropertiesPresenter()
            r1.PlaceComponentResult(r0)
            goto Lad
        La3:
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r1 = r7.getReadLinkPropertiesPresenter()
            r1.PlaceComponentResult(r0)
            r4.hashCode()     // Catch: java.lang.Throwable -> Lb3
        Lad:
            id.dana.oauth.OauthLoginManager r0 = id.dana.oauth.OauthLoginManager.INSTANCE
            id.dana.oauth.OauthLoginManager.getAuthRequestContext(r4)
            return
        Lb3:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.A():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0018, code lost:
    
        if (r15.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0020, code lost:
    
        if (r15.NetworkUserEntityData$$ExternalSyntheticLambda6 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0022, code lost:
    
        r0 = id.dana.di.component.DaggerOauthGrantComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = (id.dana.di.component.ApplicationComponent) dagger.internal.Preconditions.getAuthRequestContext(getApplicationComponent());
        r0.BuiltInFictitiousFunctionClassFactory = (id.dana.di.modules.OauthGrantModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.di.modules.OauthGrantModule(r15));
        r2 = id.dana.contract.deeplink.DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        r4 = r15;
        r2.MyBillsEntityDataFactory = r4;
        r2.KClassImpl$Data$declaredNonStaticMembers$2 = new id.dana.oauth.activity.OauthGrantActivity$initInjector$1();
        r0.getAuthRequestContext = (id.dana.contract.deeplink.DeepLinkModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.contract.deeplink.DeepLinkModule(r2, r3));
        r2 = id.dana.contract.staticqr.ScanQrModule.getAuthRequestContext();
        r2.MyBillsEntityDataFactory = r4;
        r0.NetworkUserEntityData$$ExternalSyntheticLambda0 = (id.dana.contract.staticqr.ScanQrModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.contract.staticqr.ScanQrModule(r2, r3));
        r2 = id.dana.contract.shortener.RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        r2.getAuthRequestContext = r4;
        r0.scheduleImpl = (id.dana.contract.shortener.RestoreUrlModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.contract.shortener.RestoreUrlModule(r2, r3));
        r2 = id.dana.contract.deeplink.FeatureModule.MyBillsEntityDataFactory();
        r2.BuiltInFictitiousFunctionClassFactory = r4;
        r0.MyBillsEntityDataFactory = (id.dana.contract.deeplink.FeatureModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.contract.deeplink.FeatureModule(r2, r3));
        r2 = id.dana.di.modules.OauthModule.BuiltInFictitiousFunctionClassFactory();
        r2.BuiltInFictitiousFunctionClassFactory = r4;
        r0.PlaceComponentResult = (id.dana.di.modules.OauthModule) dagger.internal.Preconditions.getAuthRequestContext(new id.dana.di.modules.OauthModule(r2, r3));
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.BuiltInFictitiousFunctionClassFactory, id.dana.di.modules.OauthGrantModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.getAuthRequestContext, id.dana.contract.deeplink.DeepLinkModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.NetworkUserEntityData$$ExternalSyntheticLambda0, id.dana.contract.staticqr.ScanQrModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.scheduleImpl, id.dana.contract.shortener.RestoreUrlModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.MyBillsEntityDataFactory, id.dana.contract.deeplink.FeatureModule.class);
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.PlaceComponentResult, id.dana.di.modules.OauthModule.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d9, code lost:
    
        if (r0.lookAheadTest != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00db, code lost:
    
        r0.lookAheadTest = new id.dana.contract.services.ServicesModule();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e2, code lost:
    
        dagger.internal.Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(r0.KClassImpl$Data$declaredNonStaticMembers$2, id.dana.di.component.ApplicationComponent.class);
        r15.NetworkUserEntityData$$ExternalSyntheticLambda6 = new id.dana.di.component.DaggerOauthGrantComponent.OauthGrantComponentImpl(r0.BuiltInFictitiousFunctionClassFactory, r0.getAuthRequestContext, r0.NetworkUserEntityData$$ExternalSyntheticLambda0, r0.scheduleImpl, r0.MyBillsEntityDataFactory, r0.PlaceComponentResult, r0.lookAheadTest, r0.KClassImpl$Data$declaredNonStaticMembers$2, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0102, code lost:
    
        r0 = r15.NetworkUserEntityData$$ExternalSyntheticLambda6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0106, code lost:
    
        if (r0 == null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0108, code lost:
    
        r4 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x010b, code lost:
    
        r4 = 'a';
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x010d, code lost:
    
        if (r4 == 14) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0110, code lost:
    
        r0.getAuthRequestContext(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0115, code lost:
    
        r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList + 77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0119, code lost:
    
        id.dana.oauth.activity.OauthGrantActivity.M = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x011c, code lost:
    
        r0 = new id.dana.base.AbstractContract.AbstractPresenter[2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011e, code lost:
    
        r0[0] = getPresenter();
        r0[1] = getReadLinkPropertiesPresenter();
        registerPresenter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0132, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0133, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0134, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0135, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0136, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.NetworkUserEntityData$$ExternalSyntheticLambda6():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x001a, code lost:
    
        if (r0 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x002b, code lost:
    
        if ((r0 == null) != true) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x002d, code lost:
    
        r4.readMicros = (android.view.ViewStub) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0035, code lost:
    
        if (BottomSheetCardBindingView$watcherCardNumberView$1() == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0038, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0039, code lost:
    
        if (r1 == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x003f, code lost:
    
        if (B() == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0041, code lost:
    
        r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList + 71;
        id.dana.oauth.activity.OauthGrantActivity.M = r0 % 128;
        r0 = r0 % 2;
        SubSequence();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x004e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x004f, code lost:
    
        getSupportButtonTintMode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0052, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0053, code lost:
    
        r0 = id.dana.oauth.activity.OauthGrantActivity.M + 101;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r0 % 128;
        r0 = r0 % 2;
        whenAvailable();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0060, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0068, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type android.view.ViewStub");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void readMicros() {
        /*
            r4 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 23
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 2131365078(0x7f0a0cd6, float:1.8350011E38)
            r3 = 1
            if (r0 == 0) goto L1f
            r4.NetworkUserEntityData$$ExternalSyntheticLambda4()
            android.view.View r0 = r4.findViewById(r2)
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L61
            goto L2d
        L1d:
            r0 = move-exception
            throw r0
        L1f:
            r4.NetworkUserEntityData$$ExternalSyntheticLambda4()
            android.view.View r0 = r4.findViewById(r2)
            if (r0 == 0) goto L2a
            r2 = 0
            goto L2b
        L2a:
            r2 = 1
        L2b:
            if (r2 == r3) goto L61
        L2d:
            android.view.ViewStub r0 = (android.view.ViewStub) r0
            r4.readMicros = r0
            boolean r0 = r4.BottomSheetCardBindingView$watcherCardNumberView$1()
            if (r0 == 0) goto L38
            goto L39
        L38:
            r1 = 1
        L39:
            if (r1 == 0) goto L53
            boolean r0 = r4.B()
            if (r0 == 0) goto L4f
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 71
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            r4.SubSequence()
            return
        L4f:
            r4.getSupportButtonTintMode()
            return
        L53:
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1
            int r0 = r0 % 2
            r4.whenAvailable()
            return
        L61:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type android.view.ViewStub"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.readMicros():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x001c, code lost:
    
        if ((r0 != null) != true) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0026, code lost:
    
        if ((r0 == null) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0029, code lost:
    
        r0.setLayoutResource(id.dana.R.layout.layout_agreement_page_from_qr);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x002f, code lost:
    
        r0 = r4.readMicros;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0031, code lost:
    
        if (r0 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0033, code lost:
    
        r0 = r0.inflate();
        r1 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList + 87;
        id.dana.oauth.activity.OauthGrantActivity.M = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x003f, code lost:
    
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0042, code lost:
    
        r0 = null;
        r1 = id.dana.oauth.activity.OauthGrantActivity.M + 57;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x004c, code lost:
    
        r4.PrepareContext = r0;
        setCenterTitle(getString(id.dana.R.string.qr_binding_title));
        r4.NetworkUserEntityData$$ExternalSyntheticLambda8 = (com.google.android.material.imageview.ShapeableImageView) findViewById(id.dana.R.id.iv_dana_logo);
        r4.isLayoutRequested = (com.google.android.material.imageview.ShapeableImageView) findViewById(id.dana.R.id.f3916iv_merchant_logo);
        r4.GetContactSyncConfig = (com.google.android.material.imageview.ShapeableImageView) findViewById(id.dana.R.id.tv_user_avatar);
        r4.getSupportButtonTintMode = (androidx.recyclerview.widget.RecyclerView) findViewById(id.dana.R.id.rv_scope);
        r4.DatabaseTableConfigUtil = (android.widget.ImageView) findViewById(id.dana.R.id.iv_banner_agreement);
        r4.B = (android.widget.TextView) findViewById(id.dana.R.id.tv_phone_number);
        r4.PlaceComponentResult = (id.dana.component.buttoncomponent.BaseDanaButton) findViewById(id.dana.R.id.f3507btn_allow);
        r4.C = (android.widget.TextView) findViewById(id.dana.R.id.tv_agreement_detail);
        r4.A = (android.widget.TextView) findViewById(id.dana.R.id.MissingMainCoroutineDispatcher);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00bb, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void whenAvailable() {
        /*
            r4 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 11
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            r1 = 38
            if (r0 != 0) goto L11
            r0 = 38
            goto L13
        L11:
            r0 = 29
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L1f
            android.view.ViewStub r0 = r4.readMicros
            if (r0 == 0) goto L1c
            r3 = 1
        L1c:
            if (r3 == r2) goto L29
            goto L2f
        L1f:
            android.view.ViewStub r0 = r4.readMicros
            r1 = 5
            int r1 = r1 / r3
            if (r0 == 0) goto L26
            r2 = 0
        L26:
            if (r2 == 0) goto L29
            goto L2f
        L29:
            r1 = 2131559313(0x7f0d0391, float:1.8743967E38)
            r0.setLayoutResource(r1)
        L2f:
            android.view.ViewStub r0 = r4.readMicros
            if (r0 == 0) goto L42
            android.view.View r0 = r0.inflate()
            int r1 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r1 = r1 + 87
            int r2 = r1 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r2
        L3f:
            int r1 = r1 % 2
            goto L4c
        L42:
            r0 = 0
            int r1 = id.dana.oauth.activity.OauthGrantActivity.M
            int r1 = r1 + 57
            int r2 = r1 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r2
            goto L3f
        L4c:
            r4.PrepareContext = r0
            r0 = 2131956380(0x7f13129c, float:1.9549314E38)
            java.lang.String r0 = r4.getString(r0)
            r4.setCenterTitle(r0)
            r0 = 2131364578(0x7f0a0ae2, float:1.8348997E38)
            android.view.View r0 = r4.findViewById(r0)
            com.google.android.material.imageview.ShapeableImageView r0 = (com.google.android.material.imageview.ShapeableImageView) r0
            r4.NetworkUserEntityData$$ExternalSyntheticLambda8 = r0
            r0 = 2131364752(0x7f0a0b90, float:1.834935E38)
            android.view.View r0 = r4.findViewById(r0)
            com.google.android.material.imageview.ShapeableImageView r0 = (com.google.android.material.imageview.ShapeableImageView) r0
            r4.isLayoutRequested = r0
            r0 = 2131368295(0x7f0a1967, float:1.8356536E38)
            android.view.View r0 = r4.findViewById(r0)
            com.google.android.material.imageview.ShapeableImageView r0 = (com.google.android.material.imageview.ShapeableImageView) r0
            r4.GetContactSyncConfig = r0
            r0 = 2131366285(0x7f0a118d, float:1.835246E38)
            android.view.View r0 = r4.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            r4.getSupportButtonTintMode = r0
            r0 = 2131364495(0x7f0a0a8f, float:1.8348829E38)
            android.view.View r0 = r4.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r4.DatabaseTableConfigUtil = r0
            r0 = 2131367991(0x7f0a1837, float:1.835592E38)
            android.view.View r0 = r4.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4.B = r0
            r0 = 2131362229(0x7f0a01b5, float:1.8344233E38)
            android.view.View r0 = r4.findViewById(r0)
            id.dana.component.buttoncomponent.BaseDanaButton r0 = (id.dana.component.buttoncomponent.BaseDanaButton) r0
            r4.PlaceComponentResult = r0
            r0 = 2131367442(0x7f0a1612, float:1.8354806E38)
            android.view.View r0 = r4.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4.C = r0
            r0 = 2131368259(0x7f0a1943, float:1.8356463E38)
            android.view.View r0 = r4.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4.A = r0
            return
        Lbc:
            r0 = move-exception
            goto Lbf
        Lbe:
            throw r0
        Lbf:
            goto Lbe
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.whenAvailable():void");
    }

    private final void getSupportButtonTintMode() {
        ViewStub viewStub = this.readMicros;
        if (viewStub != null) {
            int i = getNameOrBuilderList + 21;
            M = i % 128;
            int i2 = i % 2;
            viewStub.setLayoutResource(R.layout.layout_agreement_page);
            int i3 = getNameOrBuilderList + 69;
            M = i3 % 128;
            int i4 = i3 % 2;
        }
        ViewStub viewStub2 = this.readMicros;
        this.PrepareContext = viewStub2 == null ? null : viewStub2.inflate();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = (LinearLayout) findViewById(R.id.ll_benefit_title);
        this.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = findViewById(R.id.v_divider1);
        this.whenAvailable = (RecyclerView) findViewById(R.id.rv_binding_benefit);
        this.BuiltInFictitiousFunctionClassFactory = (AppCompatImageView) findViewById(R.id.btn_dropdown);
        this.scheduleImpl = (BaseDanaButton) findViewById(R.id.btn_no);
        this.getSupportButtonTintMode = (RecyclerView) findViewById(R.id.rv_scope);
        this.DatabaseTableConfigUtil = (ImageView) findViewById(R.id.iv_banner_agreement);
        this.B = (TextView) findViewById(R.id.tv_phone_number);
        this.PlaceComponentResult = (BaseDanaButton) findViewById(R.id.f3507btn_allow);
        this.C = (TextView) findViewById(R.id.tv_agreement_detail);
        this.A = (TextView) findViewById(R.id.MissingMainCoroutineDispatcher);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.view.View] */
    private final void SubSequence() {
        ViewStub viewStub = this.readMicros;
        ?? r1 = 0;
        if (viewStub != null) {
            int i = getNameOrBuilderList + 95;
            M = i % 128;
            if (!(i % 2 != 0)) {
                viewStub.setLayoutResource(R.layout.layout_agreement_page_google);
                int length = r1.length;
            } else {
                viewStub.setLayoutResource(R.layout.layout_agreement_page_google);
            }
        }
        ViewStub viewStub2 = this.readMicros;
        if ((viewStub2 != null ? 'a' : '6') != '6') {
            int i2 = M + 27;
            getNameOrBuilderList = i2 % 128;
            int i3 = i2 % 2;
            r1 = viewStub2.inflate();
        }
        this.PrepareContext = r1;
        setCenterTitle("");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = (ShapeableImageView) findViewById(R.id.iv_dana_logo);
        this.isLayoutRequested = (ShapeableImageView) findViewById(R.id.f3916iv_merchant_logo);
        this.scheduleImpl = (BaseDanaButton) findViewById(R.id.btn_no);
        this.getSupportButtonTintMode = (RecyclerView) findViewById(R.id.rv_scope);
        this.DatabaseTableConfigUtil = (ImageView) findViewById(R.id.iv_banner_agreement);
        this.B = (TextView) findViewById(R.id.tv_phone_number);
        this.PlaceComponentResult = (BaseDanaButton) findViewById(R.id.f3507btn_allow);
        this.C = (TextView) findViewById(R.id.tv_agreement_detail);
        this.A = (TextView) findViewById(R.id.MissingMainCoroutineDispatcher);
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda4() {
        int i = getNameOrBuilderList + 5;
        M = i % 128;
        int i2 = i % 2;
        this.newProxyInstance = findViewById(R.id.layout_failed_oauth);
        this.lookAheadTest = (Button) findViewById(R.id.btn_try_again_oauth);
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = (TextView) findViewById(R.id.getFeatureForcedFirstCard);
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = (TextView) findViewById(R.id.f4393tv_error_description);
        int i3 = M + 25;
        getNameOrBuilderList = i3 % 128;
        int i4 = i3 % 2;
    }

    private static final void MyBillsEntityDataFactory(OauthGrantActivity oauthGrantActivity) {
        int i = getNameOrBuilderList + 115;
        M = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
            oauthGrantActivity.lookAheadTest();
            int i3 = M + 49;
            getNameOrBuilderList = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void getOnBoardingScenario() {
        try {
            int i = getNameOrBuilderList + 115;
            M = i % 128;
            int i2 = i % 2;
            try {
                AppCompatImageView appCompatImageView = this.BuiltInFictitiousFunctionClassFactory;
                if (appCompatImageView != null) {
                    appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.oauth.activity.OauthGrantActivity$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            OauthGrantActivity.$r8$lambda$GtuA8Qzg7ncte3uVgoY6RGtXJf8(OauthGrantActivity.this, view);
                        }
                    });
                    int i3 = getNameOrBuilderList + 125;
                    M = i3 % 128;
                    int i4 = i3 % 2;
                }
                BaseDanaButton baseDanaButton = this.PlaceComponentResult;
                if (baseDanaButton != null) {
                    baseDanaButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.oauth.activity.OauthGrantActivity$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            OauthGrantActivity.$r8$lambda$at4wYEHlpeJReGq5wENyLRoqmyc(OauthGrantActivity.this, view);
                        }
                    });
                    int i5 = getNameOrBuilderList + 97;
                    M = i5 % 128;
                    int i6 = i5 % 2;
                }
                BaseDanaButton baseDanaButton2 = this.scheduleImpl;
                if (baseDanaButton2 != null) {
                    baseDanaButton2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.oauth.activity.OauthGrantActivity$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            OauthGrantActivity.$r8$lambda$xMl6PKdZ4Dd27zRT6nhwXP5V05I(OauthGrantActivity.this, view);
                        }
                    });
                }
                Button button = this.lookAheadTest;
                if (button != null) {
                    button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.oauth.activity.OauthGrantActivity$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            OauthGrantActivity.m2756$r8$lambda$NHSE6ifnKMunrSLzkcw5hOyIDU(OauthGrantActivity.this, view);
                        }
                    });
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final void BuiltInFictitiousFunctionClassFactory(OauthGrantActivity oauthGrantActivity) {
        int i = getNameOrBuilderList + 125;
        M = i % 128;
        if ((i % 2 == 0 ? Typography.quote : (char) 24) != '\"') {
            Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
            oauthGrantActivity.moveToNextValue();
            return;
        }
        Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
        oauthGrantActivity.moveToNextValue();
        Object[] objArr = null;
        int length = objArr.length;
    }

    private static final void getAuthRequestContext(OauthGrantActivity oauthGrantActivity) {
        int i = M + 39;
        getNameOrBuilderList = i % 128;
        if ((i % 2 != 0 ? '5' : (char) 4) != 4) {
            Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
            oauthGrantActivity.getErrorConfigVersion();
            Object obj = null;
            obj.hashCode();
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
            oauthGrantActivity.getErrorConfigVersion();
        } catch (Exception e) {
            throw e;
        }
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantActivity oauthGrantActivity) {
        int i = getNameOrBuilderList + 71;
        M = i % 128;
        if ((i % 2 == 0 ? 'O' : (char) 16) == 16) {
            Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
            oauthGrantActivity.NetworkUserEntityData$$ExternalSyntheticLambda1();
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
            oauthGrantActivity.NetworkUserEntityData$$ExternalSyntheticLambda1();
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0020, code lost:
    
        if ((r0 != null ? kotlin.text.Typography.amp : kotlin.text.Typography.greater) != '>') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0029, code lost:
    
        if (r0 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002b, code lost:
    
        r1 = r0.BuiltInFictitiousFunctionClassFactory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0031, code lost:
    
        r0 = id.dana.oauth.activity.OauthGrantActivity.M + 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0035, code lost:
    
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0037, code lost:
    
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0039, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean B() {
        /*
            r4 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 49
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            if (r0 == 0) goto L27
            id.dana.oauth.model.OauthParamsModel r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda4     // Catch: java.lang.Exception -> L25
            r2 = 81
            int r2 = r2 / r1
            r2 = 62
            if (r0 == 0) goto L1e
            r3 = 38
            goto L20
        L1e:
            r3 = 62
        L20:
            if (r3 == r2) goto L2f
            goto L2b
        L23:
            r0 = move-exception
            throw r0
        L25:
            r0 = move-exception
            goto L3a
        L27:
            id.dana.oauth.model.OauthParamsModel r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda4
            if (r0 == 0) goto L2f
        L2b:
            boolean r1 = r0.BuiltInFictitiousFunctionClassFactory()
        L2f:
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M     // Catch: java.lang.Exception -> L25
            int r0 = r0 + 19
            int r2 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r2     // Catch: java.lang.Exception -> L25
            int r0 = r0 % 2
            return r1
        L3a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.B():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0016, code lost:
    
        if ((r0 != null) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0020, code lost:
    
        if ((r0 == null) != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0023, code lost:
    
        r2 = r0.getBooleanExtra("EX_QR_BIND", false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x002b, code lost:
    
        r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList + 19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x002f, code lost:
    
        id.dana.oauth.activity.OauthGrantActivity.M = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0034, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0035, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0036, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0037, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean BottomSheetCardBindingView$watcherCardNumberView$1() {
        /*
            r3 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 43
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L19
            android.content.Intent r0 = r3.getIntent()
            if (r0 == 0) goto L15
            goto L16
        L15:
            r1 = 0
        L16:
            if (r1 == 0) goto L33
            goto L23
        L19:
            android.content.Intent r0 = r3.getIntent()
            if (r0 == 0) goto L20
            r1 = 0
        L20:
            if (r1 == 0) goto L23
            goto L33
        L23:
            java.lang.String r1 = "EX_QR_BIND"
            boolean r2 = r0.getBooleanExtra(r1, r2)
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList     // Catch: java.lang.Exception -> L36
            int r0 = r0 + 19
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1     // Catch: java.lang.Exception -> L34
            int r0 = r0 % 2
        L33:
            return r2
        L34:
            r0 = move-exception
            throw r0
        L36:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.BottomSheetCardBindingView$watcherCardNumberView$1():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0035, code lost:
    
        if ((kotlin.jvm.internal.Intrinsics.areEqual(r1, id.dana.oauth.OauthConstant.BindingType.SDK)) != true) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0049, code lost:
    
        if ((!r1) != true) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x004b, code lost:
    
        r6.FragmentBottomSheetPaymentSettingBinding = id.dana.oauth.OauthConstant.OauthType.SDK_TYPE;
        getPresenter().PlaceComponentResult(r0, r6.MyBillsEntityDataFactory);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0059, code lost:
    
        r6.FragmentBottomSheetPaymentSettingBinding = id.dana.oauth.OauthConstant.OauthType.ONLINE_MERCHANT_TYPE;
        getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(r0, r6.MyBillsEntityDataFactory);
        getPresenter().getAuthRequestContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x006e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x006f, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        /*
            r6 = this;
            id.dana.oauth.model.OauthParamsModel r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda4
            r1 = 67
            if (r0 == 0) goto L9
            r2 = 65
            goto Lb
        L9:
            r2 = 67
        Lb:
            r3 = 0
            r4 = 1
            if (r2 == r1) goto L72
            int r1 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r1 = r1 + 51
            int r2 = r1 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r2
            int r1 = r1 % 2
            r2 = 32
            if (r1 != 0) goto L20
            r1 = 32
            goto L22
        L20:
            r1 = 70
        L22:
            java.lang.String r5 = "SDK"
            if (r1 == r2) goto L38
            java.lang.String r1 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2()
            r6.MyBillsEntityDataFactory = r1
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            if (r1 == 0) goto L34
            r1 = 1
            goto L35
        L34:
            r1 = 0
        L35:
            if (r1 == r4) goto L4b
            goto L59
        L38:
            java.lang.String r1 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2()
            r6.MyBillsEntityDataFactory = r1
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r5)
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L70
            if (r1 == 0) goto L48
            r1 = 0
            goto L49
        L48:
            r1 = 1
        L49:
            if (r1 == r4) goto L59
        L4b:
            java.lang.String r1 = "sdk"
            r6.FragmentBottomSheetPaymentSettingBinding = r1
            id.dana.contract.oauth.OauthGrantContract$Presenter r1 = r6.getPresenter()
            java.lang.String r2 = r6.MyBillsEntityDataFactory
            r1.PlaceComponentResult(r0, r2)
            goto L72
        L59:
            java.lang.String r1 = "online_merchant"
            r6.FragmentBottomSheetPaymentSettingBinding = r1     // Catch: java.lang.Exception -> L6e
            id.dana.contract.oauth.OauthGrantContract$Presenter r1 = r6.getPresenter()     // Catch: java.lang.Exception -> L6e
            java.lang.String r2 = r6.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L6e
            r1.KClassImpl$Data$declaredNonStaticMembers$2(r0, r2)     // Catch: java.lang.Exception -> L6e
            id.dana.contract.oauth.OauthGrantContract$Presenter r0 = r6.getPresenter()     // Catch: java.lang.Exception -> L6e
            r0.getAuthRequestContext()     // Catch: java.lang.Exception -> L6e
            goto L72
        L6e:
            r0 = move-exception
            throw r0
        L70:
            r0 = move-exception
            throw r0
        L72:
            id.dana.contract.oauth.OauthGrantContract$Presenter r0 = r6.getPresenter()
            r0.MyBillsEntityDataFactory()
            boolean r0 = r6.B()
            r1 = 93
            if (r0 != 0) goto L84
            r0 = 41
            goto L86
        L84:
            r0 = 93
        L86:
            if (r0 == r1) goto Lb4
            boolean r0 = r6.BottomSheetCardBindingView$watcherCardNumberView$1()
            if (r0 != 0) goto L8f
            goto L90
        L8f:
            r4 = 0
        L90:
            if (r4 == 0) goto Lb4
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 97
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            if (r0 != 0) goto Lad
            id.dana.contract.oauth.OauthGrantContract$Presenter r0 = r6.getPresenter()     // Catch: java.lang.Exception -> Lab
            r0.KClassImpl$Data$declaredNonStaticMembers$2()     // Catch: java.lang.Exception -> Lab
            r0 = 72
            int r0 = r0 / r3
            goto Lb4
        La9:
            r0 = move-exception
            throw r0
        Lab:
            r0 = move-exception
            throw r0
        Lad:
            id.dana.contract.oauth.OauthGrantContract$Presenter r0 = r6.getPresenter()
            r0.KClassImpl$Data$declaredNonStaticMembers$2()
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.NetworkUserEntityData$$ExternalSyntheticLambda5():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.String] */
    private final String NetworkUserEntityData$$ExternalSyntheticLambda2() {
        String str;
        OauthParamsModel oauthParamsModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        String str2 = 0;
        if ((oauthParamsModel != null ? 'H' : 'Y') != 'H') {
            str = null;
        } else {
            int i = M + 19;
            getNameOrBuilderList = i % 128;
            if (i % 2 != 0) {
                str = oauthParamsModel.MyBillsEntityDataFactory;
                int length = str2.length;
            } else {
                str = oauthParamsModel.MyBillsEntityDataFactory;
            }
        }
        String str3 = str;
        char c = !(str3 == null || str3.length() == 0) ? (char) 17 : '\f';
        String str4 = OauthConstant.BindingType.IPG;
        if (c != '\f') {
            int i2 = getNameOrBuilderList + 67;
            M = i2 % 128;
            int i3 = i2 % 2;
            str4 = OauthConstant.BindingType.SDK;
        } else {
            OauthParamsModel oauthParamsModel2 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if ((oauthParamsModel2 != null ? 'V' : 'U') != 'U') {
                int i4 = getNameOrBuilderList + 61;
                M = i4 % 128;
                int i5 = i4 % 2;
                str2 = oauthParamsModel2.getAuthRequestContext;
            }
            if (!StringsKt.equals(str2, OauthConstant.BindingType.IPG, true)) {
                Object[] objArr = new Object[1];
                a(super.getResources().getString(R.string.promo_try_again_button).substring(6, 7).length() + 25980, new char[]{18895, 11451}, objArr);
                str4 = ((String) objArr[0]).intern();
            }
        }
        int i6 = getNameOrBuilderList + 41;
        M = i6 % 128;
        int i7 = i6 % 2;
        return str4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x003e, code lost:
    
        if (r6.KClassImpl$Data$declaredNonStaticMembers$2 != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x004c, code lost:
    
        if ((r6.KClassImpl$Data$declaredNonStaticMembers$2 ? '-' : 5) != 5) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x004e, code lost:
    
        r1 = id.dana.oauth.activity.OauthGrantActivity.M + 15;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1 % 128;
        r1 = r1 % 2;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0059, code lost:
    
        r0.setVisibility(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void lookAheadTest() {
        /*
            r6 = this;
            boolean r0 = r6.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L62
            r1 = 1
            r0 = r0 ^ r1
            r6.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L62
            android.view.View r2 = r6.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String     // Catch: java.lang.Exception -> L60
            r3 = 8
            r4 = 0
            if (r2 == 0) goto L1f
            r5 = 40
            if (r0 == 0) goto L14
            r0 = 37
            goto L16
        L14:
            r0 = 40
        L16:
            if (r0 == r5) goto L1a
            r0 = 0
            goto L1c
        L1a:
            r0 = 8
        L1c:
            r2.setVisibility(r0)     // Catch: java.lang.Exception -> L62
        L1f:
            androidx.recyclerview.widget.RecyclerView r0 = r6.whenAvailable
            if (r0 == 0) goto L25
            r2 = 0
            goto L26
        L25:
            r2 = 1
        L26:
            if (r2 == 0) goto L29
            goto L5c
        L29:
            int r2 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r2 = r2 + 39
            int r5 = r2 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r5
            int r2 = r2 % 2
            if (r2 != 0) goto L36
            goto L37
        L36:
            r1 = 0
        L37:
            if (r1 == 0) goto L43
            boolean r1 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            r2 = 85
            int r2 = r2 / r4
            if (r1 == 0) goto L59
            goto L4e
        L41:
            r0 = move-exception
            throw r0
        L43:
            boolean r1 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            r2 = 5
            if (r1 == 0) goto L4b
            r1 = 45
            goto L4c
        L4b:
            r1 = 5
        L4c:
            if (r1 == r2) goto L59
        L4e:
            int r1 = id.dana.oauth.activity.OauthGrantActivity.M
            int r1 = r1 + 15
            int r2 = r1 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r2
            int r1 = r1 % 2
            r3 = 0
        L59:
            r0.setVisibility(r3)     // Catch: java.lang.Exception -> L60
        L5c:
            r6.scheduleImpl()
            return
        L60:
            r0 = move-exception
            throw r0
        L62:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.lookAheadTest():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x001c, code lost:
    
        if ((r4.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) != true) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0028, code lost:
    
        if ((r4.NetworkUserEntityData$$ExternalSyntheticLambda1 != null) != true) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x002a, code lost:
    
        r4.NetworkUserEntityData$$ExternalSyntheticLambda5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0034, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r4.FragmentBottomSheetPaymentSettingBinding, id.dana.oauth.OauthConstant.OauthType.ONLINE_MERCHANT_TYPE) == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0036, code lost:
    
        r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList + 37;
        id.dana.oauth.activity.OauthGrantActivity.M = r0 % 128;
        r0 = r0 % 2;
        KClassImpl$Data$declaredNonStaticMembers$2$default(r4, null, null, 3, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0045, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0046, code lost:
    
        r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0048, code lost:
    
        if (r0 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x004a, code lost:
    
        r1 = id.dana.oauth.activity.OauthGrantActivity.M + 31;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0054, code lost:
    
        getPresenter().MyBillsEntityDataFactory(r0, r4.MyBillsEntityDataFactory);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x005d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x005e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x005f, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0060, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0061, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0062, code lost:
    
        isLayoutRequested();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0065, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void moveToNextValue() {
        /*
            r4 = this;
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 71
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            r1 = 32
            if (r0 != 0) goto L11
            r0 = 32
            goto L13
        L11:
            r0 = 66
        L13:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1f
            java.lang.String r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda1
            if (r0 != 0) goto L1c
            r2 = 1
        L1c:
            if (r2 == r3) goto L2a
            goto L62
        L1f:
            java.lang.String r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda1
            r1 = 82
            int r1 = r1 / r2
            if (r0 != 0) goto L27
            goto L28
        L27:
            r2 = 1
        L28:
            if (r2 == r3) goto L62
        L2a:
            r4.NetworkUserEntityData$$ExternalSyntheticLambda5 = r3     // Catch: java.lang.Exception -> L60
            java.lang.String r0 = r4.FragmentBottomSheetPaymentSettingBinding     // Catch: java.lang.Exception -> L5e
            java.lang.String r1 = "online_merchant"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch: java.lang.Exception -> L5e
            if (r0 == 0) goto L46
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + 37
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r1
            int r0 = r0 % 2
            r0 = 3
            r1 = 0
            KClassImpl$Data$declaredNonStaticMembers$2$default(r4, r1, r1, r0, r1)
            return
        L46:
            id.dana.oauth.model.OauthParamsModel r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda4
            if (r0 == 0) goto L65
            int r1 = id.dana.oauth.activity.OauthGrantActivity.M     // Catch: java.lang.Exception -> L5e
            int r1 = r1 + 31
            int r2 = r1 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r2     // Catch: java.lang.Exception -> L5e
            int r1 = r1 % 2
            id.dana.contract.oauth.OauthGrantContract$Presenter r1 = r4.getPresenter()
            java.lang.String r2 = r4.MyBillsEntityDataFactory
            r1.MyBillsEntityDataFactory(r0, r2)
            return
        L5e:
            r0 = move-exception
            throw r0
        L60:
            r0 = move-exception
            throw r0
        L62:
            r4.isLayoutRequested()
        L65:
            return
        L66:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.moveToNextValue():void");
    }

    private final void getErrorConfigVersion() {
        int i = getNameOrBuilderList + 75;
        M = i % 128;
        char c = i % 2 == 0 ? '3' : '8';
        PlaceComponentResult();
        if (c != '3') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        setCenterTitle(getString(R.string.confirmation_oauth));
        View view = this.newProxyInstance;
        if (view != null) {
            int i = M + 29;
            getNameOrBuilderList = i % 128;
            int i2 = i % 2;
            view.setVisibility(8);
            int i3 = getNameOrBuilderList + 7;
            M = i3 % 128;
            int i4 = i3 % 2;
        }
        View view2 = this.PrepareContext;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        if ((this.NetworkUserEntityData$$ExternalSyntheticLambda5 ? 'L' : (char) 1) == 'L') {
            moveToNextValue();
        } else {
            NetworkUserEntityData$$ExternalSyntheticLambda5();
        }
        int i5 = this.getErrorConfigVersion + 1;
        this.getErrorConfigVersion = i5;
        if (!(i5 < 3)) {
            int i6 = getNameOrBuilderList + 81;
            M = i6 % 128;
            int i7 = i6 % 2;
            Button button = this.lookAheadTest;
            if (button != null) {
                button.setVisibility(8);
            }
        }
    }

    private final void PlaceComponentResult() {
        try {
            int i = M + 33;
            getNameOrBuilderList = i % 128;
            int i2 = i % 2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = OauthConstant.ErrorPathOauth.CANCEL;
            OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
            OauthLoginManager.MyBillsEntityDataFactory(true);
            if (!(!Intrinsics.areEqual(this.FragmentBottomSheetPaymentSettingBinding, OauthConstant.OauthType.SDK_TYPE))) {
                int i3 = getNameOrBuilderList + 31;
                M = i3 % 128;
                int i4 = i3 % 2;
                initRecordTimeStamp();
                return;
            }
            if ((B() ? '/' : '_') == '/') {
                int i5 = getNameOrBuilderList + 103;
                M = i5 % 128;
                int i6 = i5 % 2;
                VerifyPinStateManager$executeRiskChallenge$2$1();
            }
            finishAffinity();
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2$default(OauthGrantActivity oauthGrantActivity, String str, List list, int i, Object obj) {
        try {
            int i2 = M + 49;
            getNameOrBuilderList = i2 % 128;
            int i3 = i2 % 2;
            Object obj2 = null;
            if (((i & 1) != 0 ? '\'' : ']') != ']') {
                int i4 = getNameOrBuilderList + 29;
                M = i4 % 128;
                if (i4 % 2 == 0) {
                    obj2.hashCode();
                }
                try {
                    int i5 = M + 85;
                    getNameOrBuilderList = i5 % 128;
                    int i6 = i5 % 2;
                    str = null;
                } catch (Exception e) {
                    throw e;
                }
            }
            if ((i & 2) != 0) {
                list = null;
            }
            oauthGrantActivity.KClassImpl$Data$declaredNonStaticMembers$2(str, list);
            int i7 = M + 7;
            getNameOrBuilderList = i7 % 128;
            int i8 = i7 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, List<String> p1) {
        OauthParamsModel oauthParamsModel;
        int i = M + 87;
        getNameOrBuilderList = i % 128;
        if ((i % 2 != 0 ? 'U' : '0') != 'U') {
            oauthParamsModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (oauthParamsModel == null) {
                return;
            }
        } else {
            oauthParamsModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            int i2 = 42 / 0;
            if ((oauthParamsModel != null ? 'L' : '8') != 'L') {
                return;
            }
        }
        getPresenter().PlaceComponentResult(oauthParamsModel, this.MyBillsEntityDataFactory, BottomSheetCardBindingView$watcherCardNumberView$1(), p0, p1);
        int i3 = M + 59;
        getNameOrBuilderList = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void isLayoutRequested() {
        int i = M + 113;
        getNameOrBuilderList = i % 128;
        int i2 = i % 2;
        if ((Intrinsics.areEqual(this.FragmentBottomSheetPaymentSettingBinding, OauthConstant.OauthType.SDK_TYPE) ? Typography.dollar : (char) 4) != 4) {
            initRecordTimeStamp();
            return;
        }
        try {
            KClassImpl$Data$declaredNonStaticMembers$2$default(this, null, null, 3, null);
            int i3 = M + 117;
            getNameOrBuilderList = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void initRecordTimeStamp() {
        int i = getNameOrBuilderList + 101;
        M = i % 128;
        int i2 = i % 2;
        if (Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, OauthConstant.ErrorPathOauth.CANCEL)) {
            String MyBillsEntityDataFactory = new OauthTargetManager(this.getCallingPid).MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda4, OauthConstant.LocalErrorCode.ACCESS_CANCEL, getString(R.string.cancel_message));
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
            return;
        }
        String MyBillsEntityDataFactory2 = new OauthTargetManager(this.getCallingPid).MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2);
        int i3 = M + 9;
        getNameOrBuilderList = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x002e, code lost:
    
        if (r0 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0035, code lost:
    
        if (r0 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0037, code lost:
    
        r0 = r0.getAuthRequestContext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x003a, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        /*
            r8 = this;
            id.dana.oauth.model.OauthParamsModel r0 = r8.NetworkUserEntityData$$ExternalSyntheticLambda4
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L8
            r3 = 1
            goto L9
        L8:
            r3 = 0
        L9:
            r4 = 0
            if (r3 == r2) goto Le
            r0 = r4
            goto L10
        Le:
            java.lang.String r0 = r0.NetworkUserEntityData$$ExternalSyntheticLambda7
        L10:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L1c
            int r0 = r0.length()
            if (r0 == 0) goto L1c
            r0 = 0
            goto L1d
        L1c:
            r0 = 1
        L1d:
            if (r0 == 0) goto L9c
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 9
            int r3 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r3
            r3 = 2
            int r0 = r0 % r3
            if (r0 == 0) goto L33
            id.dana.oauth.model.OauthParamsModel r0 = r8.NetworkUserEntityData$$ExternalSyntheticLambda4
            int r5 = r4.length     // Catch: java.lang.Throwable -> L31
            if (r0 == 0) goto L3a
            goto L37
        L31:
            r0 = move-exception
            throw r0
        L33:
            id.dana.oauth.model.OauthParamsModel r0 = r8.NetworkUserEntityData$$ExternalSyntheticLambda4
            if (r0 == 0) goto L3a
        L37:
            java.lang.String r0 = r0.getAuthRequestContext
            goto L3b
        L3a:
            r0 = r4
        L3b:
            android.content.res.Resources r5 = super.getResources()
            r6 = 2131955639(0x7f130fb7, float:1.9547811E38)
            java.lang.String r5 = r5.getString(r6)
            r6 = 5
            r7 = 6
            java.lang.String r5 = r5.substring(r6, r7)
            int r5 = r5.length()
            int r5 = r5 + 25980
            char[] r6 = new char[r3]
            r6 = {x009e: FILL_ARRAY_DATA , data: [18895, 11451} // fill-array
            java.lang.Object[] r7 = new java.lang.Object[r2]
            a(r5, r6, r7)
            r1 = r7[r1]
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = r1.intern()
            boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r2)
            if (r0 == 0) goto L9c
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1
            int r0 = r0 % r3
            r1 = 45
            if (r0 == 0) goto L7a
            r0 = 45
            goto L7c
        L7a:
            r0 = 97
        L7c:
            java.lang.String r2 = ""
            if (r0 == r1) goto L87
            r0 = r8
            id.dana.contract.oauth.OauthGrantContract$View r0 = (id.dana.contract.oauth.OauthGrantContract.View) r0
            id.dana.contract.oauth.OauthGrantContract.View.CC.getAuthRequestContext(r0, r2)
            goto L90
        L87:
            r0 = r8
            id.dana.contract.oauth.OauthGrantContract$View r0 = (id.dana.contract.oauth.OauthGrantContract.View) r0
            id.dana.contract.oauth.OauthGrantContract.View.CC.getAuthRequestContext(r0, r2)
            r4.hashCode()     // Catch: java.lang.Throwable -> L9a
        L90:
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1
            int r0 = r0 % r3
            goto L9c
        L9a:
            r0 = move-exception
            throw r0
        L9c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.NetworkUserEntityData$$ExternalSyntheticLambda7():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x009a, code lost:
    
        if ((r4.length() == 0 ? 'T' : '3') != 'T') goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00a1, code lost:
    
        if (r4.length() == 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00a4, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void PlaceComponentResult(id.dana.oauth.model.AuthCodeModel r9) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.PlaceComponentResult(id.dana.oauth.model.AuthCodeModel):void");
    }

    private final void MyBillsEntityDataFactory(List<? extends ScopeModel> p0) {
        int i = getNameOrBuilderList + 73;
        M = i % 128;
        int i2 = i % 2;
        try {
            RecyclerView recyclerView = this.getSupportButtonTintMode;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(this) { // from class: id.dana.oauth.activity.OauthGrantActivity$initRecyclerViewScope$1
                    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public final boolean canScrollVertically() {
                        return false;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(this);
                    }
                });
            }
            if (!BottomSheetCardBindingView$watcherCardNumberView$1()) {
                getScopeAdapter().getAuthRequestContext = B();
                RecyclerView recyclerView2 = this.getSupportButtonTintMode;
                if (recyclerView2 != null) {
                    recyclerView2.setAdapter(getScopeAdapter());
                    int i3 = getNameOrBuilderList + 87;
                    M = i3 % 128;
                    int i4 = i3 % 2;
                }
                getScopeAdapter().setItems(p0);
                return;
            }
            AgreementScopeAdapter agreementScopeAdapter = new AgreementScopeAdapter();
            this.getAuthRequestContext = agreementScopeAdapter;
            RecyclerView recyclerView3 = this.getSupportButtonTintMode;
            if (!(recyclerView3 == null)) {
                recyclerView3.setAdapter(agreementScopeAdapter);
            }
            AgreementScopeAdapter agreementScopeAdapter2 = this.getAuthRequestContext;
            if ((agreementScopeAdapter2 == null ? 'J' : (char) 24) == 'J') {
                Intrinsics.throwUninitializedPropertyAccessException("");
                agreementScopeAdapter2 = null;
            }
            try {
                agreementScopeAdapter2.setItems(p0);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        int i = M + 123;
        getNameOrBuilderList = i % 128;
        int i2 = i % 2;
        if ((!B() ? '\t' : (char) 18) == '\t') {
            int i3 = M + 81;
            getNameOrBuilderList = i3 % 128;
            int i4 = i3 % 2;
            if (!BottomSheetCardBindingView$watcherCardNumberView$1()) {
                ImageView imageView = this.DatabaseTableConfigUtil;
                if (imageView != null) {
                    GlideApp.getAuthRequestContext(getApplicationContext()).PlaceComponentResult(DanaUrl.IPG_AGREEMENT_BANNER_URL).MyBillsEntityDataFactory(DiskCacheStrategy.MyBillsEntityDataFactory).getSupportButtonTintMode().getErrorConfigVersion((int) R.drawable.ipg_banner_agreement).PlaceComponentResult((int) R.drawable.ipg_banner_agreement).MyBillsEntityDataFactory(imageView);
                }
            }
        }
        getCallingPid();
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0) {
        if (p0 != null) {
            int i = getNameOrBuilderList + 47;
            M = i % 128;
            int i2 = i % 2;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(DatabaseTableConfigUtil(), Arrays.copyOf(new Object[]{p0}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            SpannableStringBuilder PlaceComponentResult2 = TextUtil.PlaceComponentResult(format, p0, getString(R.string.dana_name_oauth));
            TextView textView = this.C;
            if (!(textView == null)) {
                int i3 = M + 125;
                getNameOrBuilderList = i3 % 128;
                boolean z = i3 % 2 != 0;
                textView.setText(PlaceComponentResult2);
                if (z) {
                    int i4 = 81 / 0;
                }
                int i5 = getNameOrBuilderList + 53;
                M = i5 % 128;
                int i6 = i5 % 2;
            }
        }
    }

    private final void getCallingPid() {
        int i;
        TextView textView = this.A;
        ClickableSpan clickableSpan = new ClickableSpan() { // from class: id.dana.oauth.activity.OauthGrantActivity$initTermsAndCondition$1
            @Override // android.text.style.ClickableSpan
            public final void onClick(View p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                DanaH5.startContainerFullUrl(authRequestContext);
            }
        };
        int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.azure);
        String NetworkUserEntityData$$ExternalSyntheticLambda8 = NetworkUserEntityData$$ExternalSyntheticLambda8();
        if (BottomSheetCardBindingView$watcherCardNumberView$1()) {
            int i2 = getNameOrBuilderList + 17;
            M = i2 % 128;
            int i3 = i2 % 2;
            i = R.string.qr_binding_tnc_span;
        } else {
            i = R.string.gn_tnc_span;
            int i4 = getNameOrBuilderList + 27;
            M = i4 % 128;
            int i5 = i4 % 2;
        }
        TextUtil.MyBillsEntityDataFactory(textView, clickableSpan, BuiltInFictitiousFunctionClassFactory, NetworkUserEntityData$$ExternalSyntheticLambda8, getString(i));
        int i6 = getNameOrBuilderList + 5;
        M = i6 % 128;
        int i7 = i6 % 2;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        TextUtil.MyBillsEntityDataFactory(this.A, new ClickableSpan() { // from class: id.dana.oauth.activity.OauthGrantActivity$initSdkTermsAndCondition$1
            @Override // android.text.style.ClickableSpan
            public final void onClick(View p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                String authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION);
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                DanaH5.startContainerFullUrl(authRequestContext);
            }
        }, ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.azure), getString(R.string.tnc_oauth), getString(R.string.tnc_span));
        int i = M + 79;
        getNameOrBuilderList = i % 128;
        if (!(i % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private final String DatabaseTableConfigUtil() {
        int i;
        int i2 = M + 53;
        getNameOrBuilderList = i2 % 128;
        int i3 = i2 % 2;
        if ((B() ? Typography.dollar : (char) 0) != 0) {
            int i4 = getNameOrBuilderList + 55;
            M = i4 % 128;
            int i5 = i4 % 2;
            i = R.string.oauth_linking_merchant;
        } else {
            if ((BottomSheetCardBindingView$watcherCardNumberView$1() ? 'X' : '-') != 'X') {
                i = R.string.oauth_connect_merchant;
            } else {
                int i6 = M + 73;
                getNameOrBuilderList = i6 % 128;
                if (!(i6 % 2 == 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                i = R.string.qr_binding_agreement_detail;
                int i7 = M + 85;
                getNameOrBuilderList = i7 % 128;
                int i8 = i7 % 2;
            }
        }
        String string = getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    private final String NetworkUserEntityData$$ExternalSyntheticLambda8() {
        int i;
        if ((B() ? InputCardNumberView.DIVIDER : Typography.amp) == '&') {
            if (!(BottomSheetCardBindingView$watcherCardNumberView$1() ? false : true)) {
                int i2 = getNameOrBuilderList + 71;
                M = i2 % 128;
                int i3 = i2 % 2;
                i = R.string.qr_binding_tnc;
            } else {
                i = R.string.gn_tnc_oauth;
            }
        } else {
            int i4 = M + 47;
            getNameOrBuilderList = i4 % 128;
            if (!(i4 % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
            }
            i = R.string.gn_google_tnc_oauth;
            int i5 = getNameOrBuilderList + 101;
            M = i5 % 128;
            int i6 = i5 % 2;
        }
        String string = getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(p0)));
            finish();
            int i = M + 61;
            getNameOrBuilderList = i % 128;
            int i2 = i % 2;
        } catch (ActivityNotFoundException e) {
            CrashlyticsLogUtil.PlaceComponentResult(scheduleImpl, e.getMessage(), e);
            showWarningDialog(getString(R.string.redirect_not_found));
        }
    }

    private final void getAuthRequestContext(Uri p0) {
        startActivity(new Intent("android.intent.action.VIEW", p0));
        finish();
        int i = getNameOrBuilderList + 57;
        M = i % 128;
        if ((i % 2 == 0 ? '2' : 'V') != 'V') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int i;
        int i2;
        if (B()) {
            int i3 = M + 35;
            getNameOrBuilderList = i3 % 128;
            int i4 = i3 % 2;
            setMenuLeftButton(R.drawable.ic_close);
        }
        if (B()) {
            int i5 = M + 51;
            getNameOrBuilderList = i5 % 128;
            int i6 = i5 % 2;
            i = R.string.google_error_title_page;
        } else {
            i = R.string.oauth_failed;
        }
        setCenterTitle(getString(i));
        TextView textView = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        if (textView != null) {
            int i7 = M + 55;
            getNameOrBuilderList = i7 % 128;
            int i8 = i7 % 2;
            textView.setText(getString(R.string.error_oauth_title));
        }
        if (B() ? false : true) {
            i2 = R.string.error_oauth_description;
        } else {
            int i9 = getNameOrBuilderList + 99;
            M = i9 % 128;
            int i10 = i9 % 2;
            i2 = R.string.error_google_oauth_description;
            int i11 = M + 123;
            getNameOrBuilderList = i11 % 128;
            int i12 = i11 % 2;
        }
        TextView textView2 = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        if ((textView2 != null ? 'T' : 'a') != 'a') {
            textView2.setText(getString(i2));
        }
    }

    private final void D() {
        String str;
        DialogWithImage.Builder builder = new DialogWithImage.Builder();
        builder.MyBillsEntityDataFactory = R.drawable.ic_binding_dialog_success;
        Object[] objArr = new Object[1];
        OauthParamsModel oauthParamsModel = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        byte b = 0;
        if (oauthParamsModel != null) {
            int i = M + 47;
            getNameOrBuilderList = i % 128;
            if (i % 2 != 0) {
                str = oauthParamsModel.lookAheadTest;
                int i2 = 29 / 0;
            } else {
                str = oauthParamsModel.lookAheadTest;
            }
        } else {
            str = null;
        }
        if (!(str != null)) {
            int i3 = M + 79;
            getNameOrBuilderList = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 24 : Typography.quote) == 24) {
                int i4 = 45 / 0;
            }
            int i5 = getNameOrBuilderList + 87;
            M = i5 % 128;
            int i6 = i5 % 2;
            str = "";
        }
        objArr[0] = str;
        builder.moveToNextValue = getString(R.string.account_succes_linked, objArr);
        builder.PlaceComponentResult = getString(R.string.account_succes_linked_desc);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = getString(R.string.ok_got_it);
        builder.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnClickListener() { // from class: id.dana.oauth.activity.OauthGrantActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i7) {
                OauthGrantActivity.$r8$lambda$VlONScI8C_fhFEv8ygIhtQ_VYhM(OauthGrantActivity.this, dialogInterface, i7);
            }
        };
        new DialogWithImage(this, builder.lookAheadTest, builder, b).MyBillsEntityDataFactory();
    }

    private static final void MyBillsEntityDataFactory(OauthGrantActivity oauthGrantActivity, DialogInterface dialogInterface) {
        try {
            int i = getNameOrBuilderList + 95;
            M = i % 128;
            if (i % 2 != 0) {
                Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
                dialogInterface.dismiss();
                oauthGrantActivity.PrepareContext();
            } else {
                Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
                dialogInterface.dismiss();
                oauthGrantActivity.PrepareContext();
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = getNameOrBuilderList + 51;
            M = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return;
            }
            int i3 = 58 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void C() {
        DialogWithImage.Builder builder = new DialogWithImage.Builder();
        builder.MyBillsEntityDataFactory = R.drawable.ic_binding_failed;
        builder.moveToNextValue = getString(R.string.account_link_fail);
        builder.PlaceComponentResult = getString(R.string.account_link_fail_info);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = getString(R.string.ok_got_it);
        builder.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnClickListener() { // from class: id.dana.oauth.activity.OauthGrantActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                OauthGrantActivity.$r8$lambda$HlMep9OhvqEp245Au1uqiQR_4iA(OauthGrantActivity.this, dialogInterface, i);
            }
        };
        new DialogWithImage(this, builder.lookAheadTest, builder, (byte) 0).MyBillsEntityDataFactory();
        int i = M + 79;
        getNameOrBuilderList = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        int i2 = 61 / 0;
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(OauthGrantActivity oauthGrantActivity, DialogInterface dialogInterface) {
        int i = getNameOrBuilderList + 29;
        M = i % 128;
        if ((i % 2 == 0 ? (char) 30 : '\t') == '\t') {
            Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
            dialogInterface.dismiss();
            oauthGrantActivity.PrepareContext();
            return;
        }
        Intrinsics.checkNotNullParameter(oauthGrantActivity, "");
        dialogInterface.dismiss();
        oauthGrantActivity.PrepareContext();
        Object obj = null;
        obj.hashCode();
    }

    private final void scheduleImpl() {
        int i;
        int i2 = getNameOrBuilderList + 53;
        M = i2 % 128;
        int i3 = i2 % 2;
        AppCompatImageView appCompatImageView = this.BuiltInFictitiousFunctionClassFactory;
        if ((appCompatImageView != null ? Typography.amp : 'W') != 'W') {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                int i4 = M + 65;
                getNameOrBuilderList = i4 % 128;
                int i5 = i4 % 2;
                i = R.drawable.ic_up_chevron;
            } else {
                i = R.drawable.ic_down_chevron;
            }
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, i);
            int i6 = getNameOrBuilderList + 19;
            M = i6 % 128;
            int i7 = i6 % 2;
        }
    }

    private final void PlaceComponentResult(List<BindingBenefitModel> p0) {
        RecyclerView recyclerView;
        int i = getNameOrBuilderList + 91;
        M = i % 128;
        if ((i % 2 == 0 ? 'D' : '1') != 'D') {
            recyclerView = this.whenAvailable;
            if (recyclerView == null) {
                return;
            }
        } else {
            recyclerView = this.whenAvailable;
            Object[] objArr = null;
            int length = objArr.length;
            if (recyclerView == null) {
                return;
            }
        }
        BindingBenefitAdapter bindingBenefitAdapter = new BindingBenefitAdapter();
        bindingBenefitAdapter.setItems(p0);
        recyclerView.setAdapter(bindingBenefitAdapter);
        try {
            int i2 = getNameOrBuilderList + 101;
            M = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0012, code lost:
    
        if (r0 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x001e, code lost:
    
        if ((r0 != null) != true) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0021, code lost:
    
        r0.setVisibility(8);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getValueOfTouchPositionAbsolute() {
        /*
            Method dump skipped, instructions count: 184
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.getValueOfTouchPositionAbsolute():void");
    }

    private final void newProxyInstance() {
        LinearLayout linearLayout;
        try {
            int i = getNameOrBuilderList + 53;
            try {
                M = i % 128;
                if ((i % 2 == 0 ? ';' : Typography.amp) == ';' ? (linearLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda7) != null : (linearLayout = this.NetworkUserEntityData$$ExternalSyntheticLambda7) != null) {
                    linearLayout.setVisibility(0);
                }
                SkeletonScreen[] skeletonScreenArr = this.SubSequence;
                if (skeletonScreenArr != null) {
                    int i2 = getNameOrBuilderList + 27;
                    M = i2 % 128;
                    int i3 = i2 % 2;
                    int length = skeletonScreenArr.length;
                    int i4 = getNameOrBuilderList + 57;
                    M = i4 % 128;
                    int i5 = i4 % 2;
                    for (int i6 = 0; i6 < length; i6++) {
                        SkeletonScreen skeletonScreen = skeletonScreenArr[i6];
                        if (skeletonScreen != null) {
                            int i7 = M + 97;
                            getNameOrBuilderList = i7 % 128;
                            int i8 = i7 % 2;
                            skeletonScreen.PlaceComponentResult();
                        }
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2(View p0, int p1) {
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(p0);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = p1;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(viewSkeletonScreen, "");
        ViewSkeletonScreen viewSkeletonScreen2 = viewSkeletonScreen;
        int i = getNameOrBuilderList + 123;
        M = i % 128;
        int i2 = i % 2;
        return viewSkeletonScreen2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x002d, code lost:
    
        if (r0 != null) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void VerifyPinStateManager$executeRiskChallenge$2$1() {
        /*
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M
            int r0 = r0 + 3
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == r1) goto L20
            com.alipay.iap.android.wallet.acl.WalletServiceManager r0 = com.alipay.iap.android.wallet.acl.WalletServiceManager.getInstance()     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
            java.lang.Class<com.alipay.iap.android.wallet.acl.oauth.OAuthService> r1 = com.alipay.iap.android.wallet.acl.oauth.OAuthService.class
            com.alipay.iap.android.wallet.acl.base.BaseService r0 = r0.getService(r1)     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
            if (r0 == 0) goto L46
            goto L2f
        L20:
            com.alipay.iap.android.wallet.acl.WalletServiceManager r0 = com.alipay.iap.android.wallet.acl.WalletServiceManager.getInstance()     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
            java.lang.Class<com.alipay.iap.android.wallet.acl.oauth.OAuthService> r1 = com.alipay.iap.android.wallet.acl.oauth.OAuthService.class
            com.alipay.iap.android.wallet.acl.base.BaseService r0 = r0.getService(r1)     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
            r1 = 63
            int r1 = r1 / r2
            if (r0 == 0) goto L46
        L2f:
            id.dana.miniprogram.provider.OauthServiceProvider r0 = (id.dana.miniprogram.provider.OauthServiceProvider) r0     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
            com.alipay.iap.android.wallet.acl.oauth.OAuthResult r1 = new com.alipay.iap.android.wallet.acl.oauth.OAuthResult     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
            r1.<init>()     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
            r0.getAuthRequestContext(r1)     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
            int r0 = id.dana.oauth.activity.OauthGrantActivity.M     // Catch: java.lang.Exception -> L44
            int r0 = r0 + 85
            int r1 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r1     // Catch: java.lang.Exception -> L44
            int r0 = r0 % 2
            return
        L44:
            r0 = move-exception
            throw r0
        L46:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
            java.lang.String r1 = "null cannot be cast to non-null type id.dana.miniprogram.provider.OauthServiceProvider"
            r0.<init>(r1)     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
            throw r0     // Catch: com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L50
        L4e:
            r0 = move-exception
            throw r0
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.VerifyPinStateManager$executeRiskChallenge$2$1():void");
    }

    private final void PrepareContext() {
        Intent intent = new Intent(this, HomeTabActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        finish();
        int i = getNameOrBuilderList + 119;
        M = i % 128;
        if (i % 2 == 0) {
            int i2 = 31 / 0;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0006*\u00020\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/oauth/activity/OauthGrantActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/oauth/model/OauthParamsModel;", "p1", "", "p2", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;Lid/dana/oauth/model/OauthParamsModel;Z)Landroid/content/Intent;", "PlaceComponentResult", "(Landroid/content/Context;)Landroid/content/Intent;", "", "scheduleImpl", "Ljava/lang/String;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent MyBillsEntityDataFactory(Context p0, OauthParamsModel p1, boolean p2) {
            Intent intent = new Intent(p0, OauthGrantActivity.class);
            intent.putExtra("oauth", p1);
            intent.putExtra("EX_QR_BIND", p2);
            intent.setFlags(268468224);
            return intent;
        }

        @JvmStatic
        public static Intent PlaceComponentResult(Context p0) {
            OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
            OauthLoginManager.PrepareContext();
            Intent intent = new Intent(p0, OauthGrantActivity.class);
            intent.putExtra("oauth_loading", true);
            intent.setFlags(268468224);
            return intent;
        }
    }

    static {
        M = 1;
        getAuthRequestContext();
        INSTANCE = new Companion(null);
        scheduleImpl = "OauthGrantActivity";
        int i = getNameOrBuilderList + 71;
        M = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 24 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0050, code lost:
    
        if ((r0 != null ? '3' : '2') == '3') goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void FragmentBottomSheetPaymentSettingBinding() {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.FragmentBottomSheetPaymentSettingBinding():void");
    }

    @JvmStatic
    public static final Intent createOauthGrantIntent(Context context, OauthParamsModel oauthParamsModel) {
        Intent MyBillsEntityDataFactory;
        try {
            int i = M + 89;
            getNameOrBuilderList = i % 128;
            if ((i % 2 != 0 ? 'A' : (char) 2) != 'A') {
                OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
                OauthLoginManager.PrepareContext();
                MyBillsEntityDataFactory = Companion.MyBillsEntityDataFactory(context, oauthParamsModel, false);
            } else {
                OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
                OauthLoginManager.PrepareContext();
                MyBillsEntityDataFactory = Companion.MyBillsEntityDataFactory(context, oauthParamsModel, true);
            }
            int i2 = getNameOrBuilderList + 3;
            M = i2 % 128;
            if (i2 % 2 == 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return MyBillsEntityDataFactory;
            }
            return MyBillsEntityDataFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmStatic
    public static final Intent createOauthGrantIntent(Context context, OauthParamsModel oauthParamsModel, boolean z) {
        try {
            int i = M + 71;
            getNameOrBuilderList = i % 128;
            if ((i % 2 != 0 ? JSONLexer.EOI : (char) 11) != 11) {
                OauthLoginManager oauthLoginManager = OauthLoginManager.INSTANCE;
                OauthLoginManager.PrepareContext();
                Intent MyBillsEntityDataFactory = Companion.MyBillsEntityDataFactory(context, oauthParamsModel, z);
                int i2 = 77 / 0;
                return MyBillsEntityDataFactory;
            }
            OauthLoginManager oauthLoginManager2 = OauthLoginManager.INSTANCE;
            OauthLoginManager.PrepareContext();
            return Companion.MyBillsEntityDataFactory(context, oauthParamsModel, z);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0043, code lost:
    
        if (r6 == true) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0045, code lost:
    
        r6 = id.dana.oauth.activity.OauthGrantActivity.M + 45;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0051, code lost:
    
        if ((r6 % 2) == 0) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0053, code lost:
    
        r6 = kotlin.text.Typography.amp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0056, code lost:
    
        r6 = '`';
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0058, code lost:
    
        if (r6 == '&') goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x005a, code lost:
    
        r2 = r5.DatabaseTableConfigUtil;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x005d, code lost:
    
        r5 = r5.DatabaseTableConfigUtil;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x005f, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0062, code lost:
    
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0066, code lost:
    
        r0.setAuthRedirectUrl(r2);
        r0.setAuthCode(r9.BuiltInFictitiousFunctionClassFactory);
        r0.setAuthState(r9.KClassImpl$Data$declaredNonStaticMembers$2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0073, code lost:
    
        r9 = com.alipay.iap.android.wallet.acl.WalletServiceManager.getInstance().getService(com.alipay.iap.android.wallet.acl.oauth.OAuthService.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x007d, code lost:
    
        if (r9 == null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x007f, code lost:
    
        ((id.dana.miniprogram.provider.OauthServiceProvider) r9).getAuthRequestContext(r0);
        r9 = id.dana.oauth.OauthLoginManager.INSTANCE;
        id.dana.oauth.OauthLoginManager.BuiltInFictitiousFunctionClassFactory(true);
        finish();
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0094, code lost:
    
        throw new java.lang.NullPointerException("null cannot be cast to non-null type id.dana.miniprogram.provider.OauthServiceProvider");
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0095, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0097, code lost:
    
        onOauthError(null, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x00a3, code lost:
    
        r0 = id.dana.oauth.OauthLoginManager.INSTANCE;
        id.dana.oauth.OauthLoginManager.lookAheadTest = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00a8, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x002e, code lost:
    
        if (r0 != null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0035, code lost:
    
        if (r9.KClassImpl$Data$declaredNonStaticMembers$2 != null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0037, code lost:
    
        r0 = new com.alipay.iap.android.wallet.acl.oauth.OAuthResult();
        r5 = r8.NetworkUserEntityData$$ExternalSyntheticLambda4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x003e, code lost:
    
        if (r5 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0040, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0042, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(id.dana.oauth.model.AuthCodeModel r9) {
        /*
            r8 = this;
            java.lang.String r0 = r9.BuiltInFictitiousFunctionClassFactory
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 90
            if (r0 == 0) goto Lb
            r2 = 90
            goto Ld
        Lb:
            r2 = 13
        Ld:
            r3 = 0
            r4 = 1
            if (r2 == r1) goto L12
            goto L1a
        L12:
            int r0 = r0.length()
            if (r0 == 0) goto L1a
            r0 = 0
            goto L1b
        L1a:
            r0 = 1
        L1b:
            java.lang.String r1 = ""
            if (r0 != 0) goto La9
            int r0 = id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList
            int r0 = r0 + r4
            int r2 = r0 % 128
            id.dana.oauth.activity.OauthGrantActivity.M = r2
            int r0 = r0 % 2
            r2 = 0
            if (r0 != 0) goto L33
            java.lang.String r0 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            int r5 = r2.length     // Catch: java.lang.Throwable -> L31
            if (r0 == 0) goto La9
            goto L37
        L31:
            r9 = move-exception
            throw r9
        L33:
            java.lang.String r0 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            if (r0 == 0) goto La9
        L37:
            com.alipay.iap.android.wallet.acl.oauth.OAuthResult r0 = new com.alipay.iap.android.wallet.acl.oauth.OAuthResult
            r0.<init>()
            id.dana.oauth.model.OauthParamsModel r5 = r8.NetworkUserEntityData$$ExternalSyntheticLambda4
            if (r5 == 0) goto L42
            r6 = 0
            goto L43
        L42:
            r6 = 1
        L43:
            if (r6 == r4) goto L66
            int r6 = id.dana.oauth.activity.OauthGrantActivity.M
            int r6 = r6 + 45
            int r7 = r6 % 128
            id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r7
            int r6 = r6 % 2
            r7 = 38
            if (r6 == 0) goto L56
            r6 = 38
            goto L58
        L56:
            r6 = 96
        L58:
            if (r6 == r7) goto L5d
            java.lang.String r2 = r5.DatabaseTableConfigUtil
            goto L66
        L5d:
            java.lang.String r5 = r5.DatabaseTableConfigUtil
            r2.hashCode()     // Catch: java.lang.Throwable -> L64
            r2 = r5
            goto L66
        L64:
            r9 = move-exception
            throw r9
        L66:
            r0.setAuthRedirectUrl(r2)
            java.lang.String r2 = r9.BuiltInFictitiousFunctionClassFactory
            r0.setAuthCode(r2)
            java.lang.String r9 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            r0.setAuthState(r9)
            com.alipay.iap.android.wallet.acl.WalletServiceManager r9 = com.alipay.iap.android.wallet.acl.WalletServiceManager.getInstance()     // Catch: java.lang.Throwable -> L95 com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L97
            java.lang.Class<com.alipay.iap.android.wallet.acl.oauth.OAuthService> r2 = com.alipay.iap.android.wallet.acl.oauth.OAuthService.class
            com.alipay.iap.android.wallet.acl.base.BaseService r9 = r9.getService(r2)     // Catch: java.lang.Throwable -> L95 com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L97
            if (r9 == 0) goto L8d
            id.dana.miniprogram.provider.OauthServiceProvider r9 = (id.dana.miniprogram.provider.OauthServiceProvider) r9     // Catch: java.lang.Throwable -> L95 com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L97
            r9.getAuthRequestContext(r0)     // Catch: java.lang.Throwable -> L95 com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L97
            id.dana.oauth.OauthLoginManager r9 = id.dana.oauth.OauthLoginManager.INSTANCE     // Catch: java.lang.Throwable -> L95 com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L97
            id.dana.oauth.OauthLoginManager.BuiltInFictitiousFunctionClassFactory(r4)     // Catch: java.lang.Throwable -> L95 com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L97
            r8.finish()     // Catch: java.lang.Throwable -> L95 com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L97
            goto L9d
        L8d:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L95 com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L97
            java.lang.String r0 = "null cannot be cast to non-null type id.dana.miniprogram.provider.OauthServiceProvider"
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L95 com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L97
            throw r9     // Catch: java.lang.Throwable -> L95 com.alipay.iap.android.wallet.acl.WalletServiceManager.ServiceNotFoundException -> L97
        L95:
            r9 = move-exception
            goto La3
        L97:
            r9 = r8
            id.dana.contract.oauth.OauthGrantContract$View r9 = (id.dana.contract.oauth.OauthGrantContract.View) r9     // Catch: java.lang.Throwable -> L95
            id.dana.contract.oauth.OauthGrantContract.View.CC.getAuthRequestContext(r9, r1)     // Catch: java.lang.Throwable -> L95
        L9d:
            id.dana.oauth.OauthLoginManager r9 = id.dana.oauth.OauthLoginManager.INSTANCE
            id.dana.oauth.OauthLoginManager.KClassImpl$Data$declaredNonStaticMembers$2(r3)
            return
        La3:
            id.dana.oauth.OauthLoginManager r0 = id.dana.oauth.OauthLoginManager.INSTANCE
            id.dana.oauth.OauthLoginManager.KClassImpl$Data$declaredNonStaticMembers$2(r3)
            throw r9
        La9:
            r9 = r8
            id.dana.contract.oauth.OauthGrantContract$View r9 = (id.dana.contract.oauth.OauthGrantContract.View) r9     // Catch: java.lang.Exception -> Lb7
            id.dana.contract.oauth.OauthGrantContract.View.CC.getAuthRequestContext(r9, r1)     // Catch: java.lang.Exception -> Lb7
            id.dana.oauth.OauthLoginManager r9 = id.dana.oauth.OauthLoginManager.INSTANCE     // Catch: java.lang.Exception -> Lb5
            id.dana.oauth.OauthLoginManager.KClassImpl$Data$declaredNonStaticMembers$2(r3)     // Catch: java.lang.Exception -> Lb5
            return
        Lb5:
            r9 = move-exception
            throw r9
        Lb7:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.BuiltInFictitiousFunctionClassFactory(id.dana.oauth.model.AuthCodeModel):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:157:0x00d1, code lost:
    
        if ((r9 != null ? '\\' : 'J') != '\\') goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x00e4, code lost:
    
        if ((r9 != null ? 'U' : '!') != '!') goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x00e6, code lost:
    
        r2 = id.dana.oauth.activity.OauthGrantActivity.M + 33;
        id.dana.oauth.activity.OauthGrantActivity.getNameOrBuilderList = r2 % 128;
        r2 = r2 % 2;
        r2 = r9.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00f3, code lost:
    
        if (r2 != null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00f5, code lost:
    
        r4 = kotlin.text.Typography.amp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x00f8, code lost:
    
        r4 = 'E';
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x00fa, code lost:
    
        if (r4 == 'E') goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x00fd, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x00fe, code lost:
    
        r3.getAuthRequestContext(r1).MyBillsEntityDataFactory(r5).BuiltInFictitiousFunctionClassFactory(r5).MyBillsEntityDataFactory((android.widget.ImageView) r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0113, code lost:
    
        return;
     */
    @Override // id.dana.contract.oauth.OauthGrantContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onGetOauthScopeSuccess(id.dana.oauth.model.OauthInitModel r9) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.oauth.activity.OauthGrantActivity.onGetOauthScopeSuccess(id.dana.oauth.model.OauthInitModel):void");
    }

    private static void c(boolean z, int i, int i2, int i3, char[] cArr, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i3];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if ((a2.MyBillsEntityDataFactory < i3 ? (char) 2 : '*') != 2) {
                break;
            }
            int i4 = $10 + 81;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i6 = a2.MyBillsEntityDataFactory;
            cArr2[i6] = (char) (cArr2[i6] - ((int) (G ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i2 > 0) {
            int i7 = $10 + 95;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            a2.BuiltInFictitiousFunctionClassFactory = i2;
            char[] cArr3 = new char[i3];
            System.arraycopy(cArr2, 0, cArr3, 0, i3);
            System.arraycopy(cArr3, 0, cArr2, i3 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
            System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i3 - a2.BuiltInFictitiousFunctionClassFactory);
        }
        if (z) {
            char[] cArr4 = new char[i3];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if (a2.MyBillsEntityDataFactory >= i3) {
                    break;
                }
                cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i3 - a2.MyBillsEntityDataFactory) - 1];
                a2.MyBillsEntityDataFactory++;
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            try {
                int i2 = $10 + 109;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (H ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? '\n' : Typography.dollar) != '\n') {
                objArr[0] = new String(cArr2);
                return;
            }
            int i4 = $11 + 101;
            $10 = i4 % 128;
            if (!(i4 % 2 != 0)) {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            } else {
                try {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext >>>= 0;
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
    }
}
