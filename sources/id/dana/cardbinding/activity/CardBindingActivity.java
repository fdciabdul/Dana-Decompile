package id.dana.cardbinding.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cardbinding.di.component.DaggerCardBindingComponent;
import id.dana.cardbinding.di.module.ViewModelFactory;
import id.dana.cardbinding.model.CashierPayParamModel;
import id.dana.cardbinding.model.SupportedCardValidationExtKt;
import id.dana.cardbinding.tracker.AddCardExecutionProperties;
import id.dana.cardbinding.tracker.AddCardOpenProperties;
import id.dana.cardbinding.tracker.AddCardResultProperties;
import id.dana.cardbinding.tracker.CardBindingAnalyticTracker;
import id.dana.cardbinding.tracker.CardBindingTrackerUtil;
import id.dana.cardbinding.tracker.ThirdPartyRiskChallengeProperties;
import id.dana.cardbinding.view.CardBindingDialogExtKt;
import id.dana.cardbinding.view.CardView;
import id.dana.cardbinding.view.DisclaimerView;
import id.dana.cardbinding.viewmodel.CardBindingViewModel;
import id.dana.cardbinding.viewmodel.OtpCardBindingViewModel;
import id.dana.cashier.CashierRisk3dsActivity;
import id.dana.cashier.RiskParamsFactory;
import id.dana.cashier.adapter.AddNewCardAdapter;
import id.dana.cashier.adapter.OnInsertVerifyElementsListener;
import id.dana.cashier.addCard.factory.CashierAddCardVerifyElementsFactory;
import id.dana.cashier.addCard.model.QueryCardVerifyElementModel;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.AttributeCashierPayModel;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierAgreementModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierPayChannelModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import id.dana.cashier.model.SendBankOtpModel;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.challenge.ChallengeControl;
import id.dana.challenge.ChallengeScenario;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.data.usereducation.repository.source.UserEducationScenarioKt;
import id.dana.databinding.ActivityCardBindingBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.domain.payasset.model.CardScheme;
import id.dana.domain.payasset.model.Institution;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.HelpListView;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.usereducation.adapter.HelpListAdapter;
import id.dana.usereducation.model.ContentOnBoardingModel;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function4;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u009a\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u009a\u0001B\b¢\u0006\u0005\b\u0099\u0001\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0006\u0010\fJ\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\rH\u0002¢\u0006\u0004\b\t\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0005J)\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0016¢\u0006\u0004\b \u0010\u0005J\u0017\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u000eJ\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010\u0005J#\u0010\u0014\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010'\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010(J\u000f\u0010)\u001a\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010*J/\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\t\u0010,J#\u0010\u0006\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0006\u0010-J#\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b!\u0010-J\u0017\u0010!\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010*J\u001d\u0010\u0014\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002¢\u0006\u0004\b\u0014\u00100R\u0018\u0010\u0013\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00102R\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u0006\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u00104R\"\u00106\u001a\u0002058\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010@\u001a\u00020<8GX\u0087\u0084\u0002¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\b>\u0010?R\u0018\u0010\t\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u00104R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070B8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010L\u001a\u0004\u0018\u00010E8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0014\u00103\u001a\u00020M8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020P0.8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bS\u00104R\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bT\u00104R\u0013\u0010)\u001a\u00020UX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bV\u0010=R\u0016\u0010A\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bW\u00104R\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bX\u00104R\u0016\u0010C\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bY\u00104R\u0016\u0010N\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010F\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\\\u0010[R$\u0010S\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078\u0002@CX\u0083\u000e¢\u0006\f\n\u0004\b]\u0010[\"\u0004\b\u0014\u0010\nR\"\u0010_\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010[\u001a\u0004\b_\u0010`\"\u0004\ba\u0010\nR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00070B8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bb\u0010DR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00070B8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bc\u0010DR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00070B8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bd\u0010DR\"\u0010f\u001a\u00020\u00078\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010[\u001a\u0004\bf\u0010`\"\u0004\bg\u0010\nR\u0016\u0010T\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bh\u0010[R\u0016\u0010\\\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bi\u0010[R\u001c\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00070B8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bj\u0010DR\u0014\u0010Y\u001a\u00020k8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010^\u001a\u00020k8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bn\u0010mR\u001b\u0010s\u001a\u00020o8GX\u0087\u0084\u0002¢\u0006\f\n\u0004\bp\u0010=\u001a\u0004\bq\u0010rR\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00180t8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bu\u0010vR$\u0010~\u001a\u0004\u0018\u00010w8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R+\u0010b\u001a\u0004\u0018\u00010\u007f2\b\u0010\b\u001a\u0004\u0018\u00010\u007f8\u0002@CX\u0083\u000e¢\u0006\u000f\n\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0005\b\t\u0010\u0082\u0001R\u0019\u0010e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0083\u0001\u00104R,\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R3\u0010d\u001a\t\u0012\u0004\u0012\u00020\u00150\u008c\u00012\r\u0010\b\u001a\t\u0012\u0004\u0012\u00020\u00150\u008c\u00018\u0002@CX\u0083\u000e¢\u0006\r\n\u0005\b\u008d\u0001\u0010R\"\u0004\b\u0013\u00100R6\u0010h\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u008e\u0001j\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007`\u008f\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R*\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001"}, d2 = {"Lid/dana/cardbinding/activity/CardBindingActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityCardBindingBinding;", "", "configToolbar", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p0", "MyBillsEntityDataFactory", "(Z)V", "", "(Ljava/lang/String;)Z", "Lid/dana/cashier/model/CashierPayModel;", "(Lid/dana/cashier/model/CashierPayModel;)V", "inflateViewBinding", "()Lid/dana/databinding/ActivityCardBindingBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDetachedFromWindow", "PlaceComponentResult", "Lio/reactivex/disposables/Disposable;", "getErrorConfigVersion", "()Lio/reactivex/disposables/Disposable;", "moveToNextValue", "scheduleImpl", "p1", "(Ljava/lang/String;Z)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Ljava/lang/String;)V", "p2", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "", "Lid/dana/cashier/addCard/model/QueryCardVerifyElementModel;", "(Ljava/util/List;)V", "Lid/dana/cashier/adapter/AddNewCardAdapter;", "Lid/dana/cashier/adapter/AddNewCardAdapter;", "lookAheadTest", "Ljava/lang/String;", "Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;", "cardBindingAnalyticTracker", "Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;", "getCardBindingAnalyticTracker", "()Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;", "setCardBindingAnalyticTracker", "(Lid/dana/cardbinding/tracker/CardBindingAnalyticTracker;)V", "Lid/dana/cardbinding/viewmodel/CardBindingViewModel;", "Lkotlin/Lazy;", "getCardBindingVm", "()Lid/dana/cardbinding/viewmodel/CardBindingViewModel;", "cardBindingVm", "initRecordTimeStamp", "Lio/reactivex/subjects/Subject;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lio/reactivex/subjects/Subject;", "Lid/dana/cashier/model/CashierCheckoutModel;", "GetContactSyncConfig", "Lid/dana/cashier/model/CashierCheckoutModel;", "getCashierMainResult", "()Lid/dana/cashier/model/CashierCheckoutModel;", "setCashierMainResult", "(Lid/dana/cashier/model/CashierCheckoutModel;)V", "cashierMainResult", "Lio/reactivex/disposables/CompositeDisposable;", "DatabaseTableConfigUtil", "Lio/reactivex/disposables/CompositeDisposable;", "Lid/dana/usereducation/model/ContentOnBoardingModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "PrepareContext", "Lid/dana/dialog/DanaLoadingDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda5", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda3", "isDirectDebit", "()Z", "setDirectDebit", "getSupportButtonTintMode", "readMicros", "getCallingPid", "whenAvailable", "isGpn", "setGpn", "SubSequence", "VerifyPinStateManager$executeRiskChallenge$2$1", DiskFormatter.B, "Lkotlinx/coroutines/Job;", "A", "Lkotlinx/coroutines/Job;", "C", "Lid/dana/cardbinding/viewmodel/OtpCardBindingViewModel;", "BottomSheetCardBindingView$watcherCardNumberView$1", "getOtpVm", "()Lid/dana/cardbinding/viewmodel/OtpCardBindingViewModel;", "otpVm", "Landroidx/activity/result/ActivityResultLauncher;", "getOnBoardingScenario", "Landroidx/activity/result/ActivityResultLauncher;", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "VerifyPinStateManager$executeRiskChallenge$2$2", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "getPayMethod", "()Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "setPayMethod", "(Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;)V", "payMethod", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "E", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "(Lid/dana/cashier/model/QueryCardPolicyInfoModel;)V", SummaryActivity.DAYS, "Lid/dana/cashier/model/SendBankOtpModel;", "getValueOfTouchPositionAbsolute", "Lid/dana/cashier/model/SendBankOtpModel;", "getSendBankOtpModel", "()Lid/dana/cashier/model/SendBankOtpModel;", "setSendBankOtpModel", "(Lid/dana/cashier/model/SendBankOtpModel;)V", "sendBankOtpModel", "", "I", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", SummaryActivity.HOURS, "Ljava/util/HashMap;", "Lid/dana/cardbinding/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/cardbinding/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/cardbinding/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/cardbinding/di/module/ViewModelFactory;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CardBindingActivity extends BaseViewBindingActivity<ActivityCardBindingBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static long F;

    /* renamed from: A  reason: from kotlin metadata */
    private final Job NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: B */
    private Subject<Boolean> FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private final Lazy otpVm;

    /* renamed from: C  reason: from kotlin metadata */
    private final Job NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: D */
    private String whenAvailable;

    /* renamed from: E  reason: from kotlin metadata */
    private QueryCardPolicyInfoModel getSupportButtonTintMode;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private CashierCheckoutModel cashierMainResult;

    /* renamed from: H */
    private HashMap<String, Boolean> SubSequence;

    /* renamed from: I  reason: from kotlin metadata */
    private List<Integer> getCallingPid;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Subject<Boolean> PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private List<ContentOnBoardingModel> scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private boolean isDirectDebit;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private boolean DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private boolean GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private String getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private AddNewCardAdapter getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private String moveToNextValue;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private boolean PrepareContext;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$1  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    private CashierPayMethodModel.CardPayMethod payMethod;
    @Inject
    public CardBindingAnalyticTracker cardBindingAnalyticTracker;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private Subject<Boolean> isLayoutRequested;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy cardBindingVm;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    private ActivityResultLauncher<Intent> NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private Subject<Boolean> newProxyInstance;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    private SendBankOtpModel sendBankOtpModel;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private String initRecordTimeStamp;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private Subject<Boolean> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public ViewModelFactory viewModelFactory;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private boolean isGpn;
    public static final byte[] $$a = {76, 9, -56, 93, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 165;
    public static final byte[] getAuthRequestContext = {0, Byte.MIN_VALUE, -111, -10, 6, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 216;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final CompositeDisposable lookAheadTest = new CompositeDisposable();

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        F = -5025474599920585703L;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = 57 - r7
            byte[] r0 = id.dana.cardbinding.activity.CardBindingActivity.getAuthRequestContext
            int r8 = 23 - r8
            int r6 = r6 + 97
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L30
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L24
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L30:
            int r6 = r6 + r7
            int r6 = r6 + (-4)
            int r7 = r8 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.activity.CardBindingActivity.a(short, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r6 = r6 * 3
            int r6 = r6 + 21
            int r8 = 46 - r8
            byte[] r0 = id.dana.cardbinding.activity.CardBindingActivity.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1b:
            r3 = 0
        L1c:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.activity.CardBindingActivity.c(int, short, int, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final Intent createCardBindingActivityIntent(Context context, String str) {
        return Companion.MyBillsEntityDataFactory(context, str);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(-TextUtils.indexOf((CharSequence) "", '0'), new char[]{12348, 12381, 45428, 46308, 51435, 18274, 30657, 6752, 55191, 43319, 40096, 8824, 65499, 33249, 33830, 19146, 34562, 63929, 60463, 21179, 44895, 53657}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(1 - TextUtils.indexOf("", "", 0), new char[]{44673, 44780, 26894, 42573, 4230, 22010, 46338, 55480, 18721}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(1 - Color.blue(0), new char[]{5471, 5480, 61380, 5934, 38486, 58618, 37027, 64840, 62123, 63367, 16229, 50444, 56032, 57162, 10227, 44446, 41590, 42841, 20453, 46474, 35454, 36710, 30270, 39969, 37871, 38640, 40495, 25650, 31651, 32492, 34488, 19628, 17201, 18047, 44709, 21737, 11078, 11889, 54986, 15209, 12509, 2490, 64772, 804, 6336, 4521, 58692, 60398, 57425, 63800, 3458, 62457}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(1 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{13682, 13587, 21002, 10035, 11214, 54503, 58536, 35103, 53968, 19010, 3953, 45319, 64158, 25300, 6068, 55750, 33370, 6850, 32760, 49539, 43600, 13053, 18035, 59514, 46018, 11066, 44647, 4156, 23516, 49957, 46756, 14502, 25366, 64487, 40683, 8373, 2865, 37819, 59089, 20323, 4341, 46200, 52497, 30508, 14575, 44135, 54536, 40930, 49277, 17572, 15768, 34720, 59505, 31964, 1474, 44946, 61887, 5404, 27649, 54878, 39418, 3414, 29726, 65089, 41279, 9627, 23773, 59092}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((KeyEvent.getMaxKeyCode() >> 16) + 1, new char[]{20662, 20612, 22350, 55819, 11918, 10636, 26117, 2996, 46923, 20236, 61976, 13222, 40710, 26575, 60126, 23407, 59339, 8064, 33426, 17197, 53191, 14314, 47946, 27266, 54864, 11817, 21339, 37521, 15897, 50785, 19407, 47702, 1676, 65189, 25477, 41545, 28321, 38651, 7100, 52686, 30000, 45420, 12412, 62858, 23846, 43377, 10295, 7498, 42466, 16867, 49315, 1368, 36320, 31126, 63741, 11619, 38000, 4186, 37180, 21751, 64569, 2066, 35119, 31928, 50348, 8406, 41447, 25715}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(-TextUtils.indexOf((CharSequence) "", '0'), new char[]{47809, 47785, 60072, 4588, 37677, 57978, 8777, 20458, 23926, 62114, 14835, 30705, 29997, 55861, 8574, 8051, 3491, 41572, 18748, 1828, 9652, 35405, 28924, 11977, 15476, 37787, 39096, 54976, 54334, 31697, 32865, 65104, 60665, 17171, 43061, 58899, 33920, 11086, 53277, 35220, 40774, 3223, 64465, 45521, 46856, 5316, 58265, 22813, 20420, 64542, 2899, 16659, 26498, 50296, 13127, 26940, 32263, 44519, 23241, 4344, 5660, 46570, 17044, 14513}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(1 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{48672, 48665, 9839, 65013, 24496, 3619, 54835, 48078, 22998, 15924}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0, 0), 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
            }
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr13 = new Object[1];
                a(getAuthRequestContext[33], getAuthRequestContext[32], (byte) (-getAuthRequestContext[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 46);
                Object[] objArr14 = new Object[1];
                a(b, (byte) (b | 22), (byte) (-getAuthRequestContext[31]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 55, 2 - TextUtils.lastIndexOf("", '0'), (char) TextUtils.getTrimmedLength(""));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[12], $$a[53], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 800, 15 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.indexOf("", "", 0, 0), 15 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) Color.argb(0, 0, 0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ViewConfiguration.getTapTimeout() >> 16), Color.argb(0, 0, 0, 0) + 29, (char) ((-16719222) - Color.rgb(0, 0, 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - ImageFormat.getBitsPerPixel(0), 15 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.keyCodeFromString("") + 35, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1718627509, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, (-16777198) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
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
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr19 = new Object[1];
                a(getAuthRequestContext[33], getAuthRequestContext[32], (byte) (-getAuthRequestContext[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 46);
                Object[] objArr20 = new Object[1];
                a(b2, (byte) (b2 | 22), (byte) (-getAuthRequestContext[31]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getEdgeSlop() >> 16), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 45, (char) TextUtils.indexOf("", "", 0, 0));
                        byte b3 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        c(b3, b3, $$a[84], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1718627509, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) + 18, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr25 = new Object[1];
                a(getAuthRequestContext[33], getAuthRequestContext[32], (byte) (-getAuthRequestContext[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 46);
                Object[] objArr26 = new Object[1];
                a(b4, (byte) (b4 | 22), (byte) (-getAuthRequestContext[31]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 119, ImageFormat.getBitsPerPixel(0) + 4, (char) (ImageFormat.getBitsPerPixel(0) + 38969));
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        c(b5, b5, $$a[84], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 35 - TextUtils.indexOf("", "", 0, 0), (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1718627509, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 18 - TextUtils.indexOf("", ""), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr31 = new Object[1];
                a(getAuthRequestContext[33], getAuthRequestContext[32], (byte) (-getAuthRequestContext[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b6 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 46);
                Object[] objArr32 = new Object[1];
                a(b6, (byte) (b6 | 22), (byte) (-getAuthRequestContext[31]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 4, (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))));
                        Object[] objArr34 = new Object[1];
                        c($$a[8], $$a[9], (byte) ($$a[78] - 1), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), (Process.myTid() >> 22) + 35, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1718627509, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), 18 - (Process.myTid() >> 22), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = getAuthRequestContext[0];
                Object[] objArr = new Object[1];
                a(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[0], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[4], getAuthRequestContext[0], getAuthRequestContext[28], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{27392, 27489, 55118, 20039, 44753, 48577, 39726, 63119, 36011, 53005, 26115, 52887, 42217, 59352, 32475, 42587, 56333, 40847, 5787, 48728, 62566, 47033, 12103, 38836, 60800, 44668, 50949, 28652, 1529, 17980}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(-((byte) KeyEvent.getModifierMetaStateMask()), new char[]{22386, 22289, 31109, 6931, 1, 59523, 10471, 17734, 45267, 25050, 13137, 32049, 39050, 18696, 11141, 5589, 57437, 12637, 17369, 3473, 51213, 6510}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th) {
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
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.resolveSize(0, 0), (-16777181) - Color.rgb(0, 0, 0), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 911, Color.green(0) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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
        }
        super.onPause();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(super.getResources().getString(R.string.request_money_display_name_desc).substring(8, 9).length() + 0, new char[]{27392, 27489, 55118, 20039, 44753, 48577, 39726, 63119, 36011, 53005, 26115, 52887, 42217, 59352, 32475, 42587, 56333, 40847, 5787, 48728, 62566, 47033, 12103, 38836, 60800, 44668, 50949, 28652, 1529, 17980}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(getPackageName().length() - 6, new char[]{22386, 22289, 31109, 6931, 1, 59523, 10471, 17734, 45267, 25050, 13137, 32049, 39050, 18696, 11141, 5589, 57437, 12637, 17369, 3473, 51213, 6510}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), 34 - ImageFormat.getBitsPerPixel(0), (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) View.resolveSizeAndState(0, 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        }
        super.onResume();
    }

    public CardBindingActivity() {
        Job launch$default;
        Job launch$default2;
        final CardBindingActivity cardBindingActivity = this;
        final Function0 function0 = null;
        this.cardBindingVm = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CardBindingViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.cardbinding.activity.CardBindingActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.cardbinding.activity.CardBindingActivity$cardBindingVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return CardBindingActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.cardbinding.activity.CardBindingActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = cardBindingActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
        this.otpVm = new ViewModelLazy(Reflection.getOrCreateKotlinClass(OtpCardBindingViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.cardbinding.activity.CardBindingActivity$special$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.cardbinding.activity.CardBindingActivity$otpVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return CardBindingActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.cardbinding.activity.CardBindingActivity$special$$inlined$viewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = cardBindingActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
        PublishSubject PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.isLayoutRequested = PlaceComponentResult;
        PublishSubject PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.FragmentBottomSheetPaymentSettingBinding = PlaceComponentResult2;
        PublishSubject PlaceComponentResult3 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
        this.newProxyInstance = PlaceComponentResult3;
        PublishSubject PlaceComponentResult4 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult4, "");
        this.PlaceComponentResult = PlaceComponentResult4;
        PublishSubject PlaceComponentResult5 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult5, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = PlaceComponentResult5;
        this.SubSequence = new HashMap<>();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
        this.getErrorConfigVersion = "";
        this.initRecordTimeStamp = "";
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
        this.moveToNextValue = "";
        this.BuiltInFictitiousFunctionClassFactory = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<DanaLoadingDialog>() { // from class: id.dana.cardbinding.activity.CardBindingActivity$danaLoadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaLoadingDialog invoke() {
                return new DanaLoadingDialog(CardBindingActivity.this);
            }
        });
        this.getCallingPid = new ArrayList();
        CardBindingActivity cardBindingActivity2 = this;
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(cardBindingActivity2), null, null, new CardBindingActivity$observeCardBindingUiState$1(this, null), 3, null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = launch$default;
        launch$default2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(cardBindingActivity2), null, null, new CardBindingActivity$observeOtpUiState$1(this, null), 3, null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = launch$default2;
    }

    @JvmName(name = "getViewModelFactory")
    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setViewModelFactory")
    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "");
        this.viewModelFactory = viewModelFactory;
    }

    @JvmName(name = "getCardBindingAnalyticTracker")
    public final CardBindingAnalyticTracker getCardBindingAnalyticTracker() {
        CardBindingAnalyticTracker cardBindingAnalyticTracker = this.cardBindingAnalyticTracker;
        if (cardBindingAnalyticTracker != null) {
            return cardBindingAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCardBindingAnalyticTracker")
    public final void setCardBindingAnalyticTracker(CardBindingAnalyticTracker cardBindingAnalyticTracker) {
        Intrinsics.checkNotNullParameter(cardBindingAnalyticTracker, "");
        this.cardBindingAnalyticTracker = cardBindingAnalyticTracker;
    }

    @JvmName(name = "getCardBindingVm")
    public final CardBindingViewModel getCardBindingVm() {
        return (CardBindingViewModel) this.cardBindingVm.getValue();
    }

    @JvmName(name = "getOtpVm")
    public final OtpCardBindingViewModel getOtpVm() {
        return (OtpCardBindingViewModel) this.otpVm.getValue();
    }

    @JvmName(name = "getSendBankOtpModel")
    public final SendBankOtpModel getSendBankOtpModel() {
        return this.sendBankOtpModel;
    }

    @JvmName(name = "setSendBankOtpModel")
    public final void setSendBankOtpModel(SendBankOtpModel sendBankOtpModel) {
        this.sendBankOtpModel = sendBankOtpModel;
    }

    @JvmName(name = "isDirectDebit")
    /* renamed from: isDirectDebit  reason: from getter */
    public final boolean getIsDirectDebit() {
        return this.isDirectDebit;
    }

    @JvmName(name = "setDirectDebit")
    public final void setDirectDebit(boolean z) {
        this.isDirectDebit = z;
    }

    @JvmName(name = "isGpn")
    /* renamed from: isGpn  reason: from getter */
    public final boolean getIsGpn() {
        return this.isGpn;
    }

    @JvmName(name = "setGpn")
    public final void setGpn(boolean z) {
        this.isGpn = z;
    }

    @JvmName(name = "getPayMethod")
    public final CashierPayMethodModel.CardPayMethod getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "setPayMethod")
    public final void setPayMethod(CashierPayMethodModel.CardPayMethod cardPayMethod) {
        this.payMethod = cardPayMethod;
    }

    @JvmName(name = "getCashierMainResult")
    public final CashierCheckoutModel getCashierMainResult() {
        return this.cashierMainResult;
    }

    @JvmName(name = "setCashierMainResult")
    public final void setCashierMainResult(CashierCheckoutModel cashierCheckoutModel) {
        this.cashierMainResult = cashierCheckoutModel;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    private final void BuiltInFictitiousFunctionClassFactory(boolean z) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != z) {
            this.DatabaseTableConfigUtil = false;
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = z;
        RecyclerView recyclerView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(this.NetworkUserEntityData$$ExternalSyntheticLambda7 ^ true ? 0 : 8);
        ConstraintLayout constraintLayout = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(this.NetworkUserEntityData$$ExternalSyntheticLambda7 ? 0 : 8);
    }

    @JvmName(name = "getAuthRequestContext")
    private final void getAuthRequestContext(List<Integer> list) {
        this.getCallingPid = list;
        CashierAddCardVerifyElementsFactory cashierAddCardVerifyElementsFactory = CashierAddCardVerifyElementsFactory.INSTANCE;
        List<Integer> list2 = this.getCallingPid;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.getSupportButtonTintMode;
        BuiltInFictitiousFunctionClassFactory(CashierAddCardVerifyElementsFactory.PlaceComponentResult(list2, queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.NetworkUserEntityData$$ExternalSyntheticLambda0 : null));
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityCardBindingBinding inflateViewBinding() {
        ActivityCardBindingBinding authRequestContext = ActivityCardBindingBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        try {
            byte b = getAuthRequestContext[0];
            Object[] objArr2 = new Object[1];
            a(b, (byte) (b | TarHeader.LF_BLK), getAuthRequestContext[0], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            a(getAuthRequestContext[4], getAuthRequestContext[0], getAuthRequestContext[28], new Object[1]);
            Object[] objArr3 = new Object[1];
            b(((ApplicationInfo) cls.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{12348, 12381, 45428, 46308, 51435, 18274, 30657, 6752, 55191, 43319, 40096, 8824, 65499, 33249, 33830, 19146, 34562, 63929, 60463, 21179, 44895, 53657}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            b(-TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{44673, 44780, 26894, 42573, 4230, 22010, 46338, 55480, 18721}, objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    b((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{27392, 27489, 55118, 20039, 44753, 48577, 39726, 63119, 36011, 53005, 26115, 52887, 42217, 59352, 32475, 42587, 56333, 40847, 5787, 48728, 62566, 47033, 12103, 38836, 60800, 44668, 50949, 28652, 1529, 17980}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(super.getResources().getString(R.string.updates_ready_to_install).substring(9, 12).codePointAt(2) - 111, new char[]{22386, 22289, 31109, 6931, 1, 59523, 10471, 17734, 45267, 25050, 13137, 32049, 39050, 18696, 11141, 5589, 57437, 12637, 17369, 3473, 51213, 6510}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), 35 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr7 = new Object[1];
                        b(getPackageName().codePointAt(2) - 45, new char[]{5471, 5480, 61380, 5934, 38486, 58618, 37027, 64840, 62123, 63367, 16229, 50444, 56032, 57162, 10227, 44446, 41590, 42841, 20453, 46474, 35454, 36710, 30270, 39969, 37871, 38640, 40495, 25650, 31651, 32492, 34488, 19628, 17201, 18047, 44709, 21737, 11078, 11889, 54986, 15209, 12509, 2490, 64772, 804, 6336, 4521, 58692, 60398, 57425, 63800, 3458, 62457}, objArr7);
                        String str = (String) objArr7[0];
                        try {
                            byte b2 = getAuthRequestContext[0];
                            Object[] objArr8 = new Object[1];
                            a(b2, (byte) (b2 | TarHeader.LF_BLK), getAuthRequestContext[0], objArr8);
                            Class<?> cls4 = Class.forName((String) objArr8[0]);
                            a(getAuthRequestContext[4], getAuthRequestContext[0], getAuthRequestContext[28], new Object[1]);
                            Object[] objArr9 = new Object[1];
                            b(((ApplicationInfo) cls4.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{13682, 13587, 21002, 10035, 11214, 54503, 58536, 35103, 53968, 19010, 3953, 45319, 64158, 25300, 6068, 55750, 33370, 6850, 32760, 49539, 43600, 13053, 18035, 59514, 46018, 11066, 44647, 4156, 23516, 49957, 46756, 14502, 25366, 64487, 40683, 8373, 2865, 37819, 59089, 20323, 4341, 46200, 52497, 30508, 14575, 44135, 54536, 40930, 49277, 17572, 15768, 34720, 59505, 31964, 1474, 44946, 61887, 5404, 27649, 54878, 39418, 3414, 29726, 65089, 41279, 9627, 23773, 59092}, objArr9);
                            String str2 = (String) objArr9[0];
                            Object[] objArr10 = new Object[1];
                            b(getPackageName().length() - 6, new char[]{20662, 20612, 22350, 55819, 11918, 10636, 26117, 2996, 46923, 20236, 61976, 13222, 40710, 26575, 60126, 23407, 59339, 8064, 33426, 17197, 53191, 14314, 47946, 27266, 54864, 11817, 21339, 37521, 15897, 50785, 19407, 47702, 1676, 65189, 25477, 41545, 28321, 38651, 7100, 52686, 30000, 45420, 12412, 62858, 23846, 43377, 10295, 7498, 42466, 16867, 49315, 1368, 36320, 31126, 63741, 11619, 38000, 4186, 37180, 21751, 64569, 2066, 35119, 31928, 50348, 8406, 41447, 25715}, objArr10);
                            String str3 = (String) objArr10[0];
                            try {
                                byte b3 = getAuthRequestContext[0];
                                Object[] objArr11 = new Object[1];
                                a(b3, (byte) (b3 | TarHeader.LF_BLK), getAuthRequestContext[0], objArr11);
                                Class<?> cls5 = Class.forName((String) objArr11[0]);
                                a(getAuthRequestContext[4], getAuthRequestContext[0], getAuthRequestContext[28], new Object[1]);
                                Object[] objArr12 = new Object[1];
                                b(((ApplicationInfo) cls5.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 32, new char[]{47809, 47785, 60072, 4588, 37677, 57978, 8777, 20458, 23926, 62114, 14835, 30705, 29997, 55861, 8574, 8051, 3491, 41572, 18748, 1828, 9652, 35405, 28924, 11977, 15476, 37787, 39096, 54976, 54334, 31697, 32865, 65104, 60665, 17171, 43061, 58899, 33920, 11086, 53277, 35220, 40774, 3223, 64465, 45521, 46856, 5316, 58265, 22813, 20420, 64542, 2899, 16659, 26498, 50296, 13127, 26940, 32263, 44519, 23241, 4344, 5660, 46570, 17044, 14513}, objArr12);
                                String str4 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                b(super.getResources().getString(R.string.dana_plus_term_and_condition_remark).substring(5, 6).codePointAt(0) - 109, new char[]{48672, 48665, 9839, 65013, 24496, 3619, 54835, 48078, 22998, 15924}, objArr13);
                                try {
                                    Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), 18 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr14);
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
                Object[] objArr15 = new Object[1];
                a(getAuthRequestContext[33], getAuthRequestContext[32], (byte) (-getAuthRequestContext[31]), objArr15);
                Class<?> cls6 = Class.forName((String) objArr15[0]);
                byte b4 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 46);
                Object[] objArr16 = new Object[1];
                a(b4, (byte) (b4 | 22), (byte) (-getAuthRequestContext[31]), objArr16);
                try {
                    Object[] objArr17 = {Integer.valueOf(((Integer) cls6.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getDoubleTapTimeout() >> 16), ExpandableListView.getPackedPositionType(0L) + 4, (char) Color.blue(0));
                        Object[] objArr18 = new Object[1];
                        c($$a[8], $$a[9], (byte) ($$a[78] - 1), objArr18);
                        obj3 = cls7.getMethod((String) objArr18[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                    int i = ((int[]) objArr19[1])[0];
                    if (((int[]) objArr19[0])[0] != i) {
                        long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr20 = {698464992, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), 18 - ExpandableListView.getPackedPositionType(0L), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr20);
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
                    CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
                    CardBindingTrackerUtil.getAuthRequestContext();
                    CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
                    CardBindingTrackerUtil.moveToNextValue();
                    super.onCreate(savedInstanceState);
                    ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.cardbinding.activity.CardBindingActivity$$ExternalSyntheticLambda1
                        @Override // androidx.view.result.ActivityResultCallback
                        public final void onActivityResult(Object obj6) {
                            CardBindingActivity.m477$r8$lambda$1vLrHkwLEcJSkXKjVTs_3qcKOE(CardBindingActivity.this, (ActivityResult) obj6);
                        }
                    });
                    Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
                    this.NetworkUserEntityData$$ExternalSyntheticLambda4 = registerForActivityResult;
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        Toolbar toolbar = getBinding().scheduleImpl.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        toolbar2.setNavigationIcon(ContextCompat.PlaceComponentResult(toolbar2.getContext(), (int) R.drawable.arrow_left_white));
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.activity.CardBindingActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardBindingActivity.$r8$lambda$RFGhMDLiREMQH6n4nNBSEOzmHJM(CardBindingActivity.this, view);
            }
        });
        getBinding().scheduleImpl.initRecordTimeStamp.setText(getString(R.string.card_binding_add_card_title));
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerCardBindingComponent.Builder MyBillsEntityDataFactory = DaggerCardBindingComponent.MyBillsEntityDataFactory();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext(this);
    }

    private final void getAuthRequestContext() {
        this.getAuthRequestContext = new AddNewCardAdapter(new OnInsertVerifyElementsListener() { // from class: id.dana.cardbinding.activity.CardBindingActivity$initRecyclerView$1
            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
                Subject subject;
                HashMap hashMap;
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                CardBindingActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda1 = p1;
                CardBindingActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
                subject = CardBindingActivity.this.FragmentBottomSheetPaymentSettingBinding;
                hashMap = CardBindingActivity.this.SubSequence;
                subject.onNext(Boolean.valueOf(!hashMap.containsValue(Boolean.FALSE)));
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CardBindingActivity.this.getErrorConfigVersion = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void PlaceComponentResult(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p1 != -1) {
                    CardBindingActivity.this.moveToNextValue = p0;
                }
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void MyBillsEntityDataFactory(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                CardBindingActivity.this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void BuiltInFictitiousFunctionClassFactory(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                CardBindingActivity.this.initRecordTimeStamp = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                CardBindingActivity.this.BuiltInFictitiousFunctionClassFactory = p0;
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void lookAheadTest(boolean p0) {
                ActivityCardBindingBinding binding;
                Subject subject;
                binding = CardBindingActivity.this.getBinding();
                CardBindingActivity.this.BuiltInFictitiousFunctionClassFactory(binding.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.getCardNumberOCR());
                subject = CardBindingActivity.this.isLayoutRequested;
                subject.onNext(Boolean.valueOf(p0));
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                CardBindingActivity.access$setVerifyElementsValidation(CardBindingActivity.this, "cvv2", p0);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void PlaceComponentResult(boolean p0) {
                CardBindingActivity.access$setVerifyElementsValidation(CardBindingActivity.this, "limitAmountDaily", p0);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void getAuthRequestContext(boolean p0) {
                CardBindingActivity.access$setVerifyElementsValidation(CardBindingActivity.this, "bankPhoneNo", p0);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void moveToNextValue(boolean p0) {
                CardBindingActivity.access$setVerifyElementsValidation(CardBindingActivity.this, "ektp", p0);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void MyBillsEntityDataFactory(boolean p0) {
                CardBindingActivity.access$setVerifyElementsValidation(CardBindingActivity.this, "bankAccountNo", p0);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                ActivityCardBindingBinding binding;
                ActivityCardBindingBinding binding2;
                ActivityCardBindingBinding binding3;
                ActivityCardBindingBinding binding4;
                ActivityCardBindingBinding binding5;
                ActivityCardBindingBinding binding6;
                if (p0) {
                    binding4 = CardBindingActivity.this.getBinding();
                    CardView cardView = binding4.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
                    CardBindingActivity cardBindingActivity = CardBindingActivity.this;
                    CardBindingActivity cardBindingActivity2 = cardBindingActivity;
                    binding5 = cardBindingActivity.getBinding();
                    View findViewById = binding5.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.getRootView().findViewById(R.id.supportMultipleWindows);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "");
                    binding6 = CardBindingActivity.this.getBinding();
                    View findViewById2 = binding6.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.getRootView().findViewById(R.id.getMissionActiveImage);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "");
                    cardView.flipCard(cardBindingActivity2, findViewById, findViewById2);
                    return;
                }
                binding = CardBindingActivity.this.getBinding();
                CardView cardView2 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
                CardBindingActivity cardBindingActivity3 = CardBindingActivity.this;
                CardBindingActivity cardBindingActivity4 = cardBindingActivity3;
                binding2 = cardBindingActivity3.getBinding();
                View findViewById3 = binding2.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.getRootView().findViewById(R.id.getMissionActiveImage);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "");
                binding3 = CardBindingActivity.this.getBinding();
                View findViewById4 = binding3.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.getRootView().findViewById(R.id.supportMultipleWindows);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "");
                cardView2.flipCard(cardBindingActivity4, findViewById3, findViewById4);
            }

            @Override // id.dana.cashier.adapter.OnInsertVerifyElementsListener
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                ActivityCardBindingBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                binding = CardBindingActivity.this.getBinding();
                binding.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.setTextViewCardDate(p0);
            }
        });
        RecyclerView recyclerView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.setAdapter(this.getAuthRequestContext);
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        final CardView cardView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
        final QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.getSupportButtonTintMode;
        if (queryCardPolicyInfoModel != null) {
            String str = queryCardPolicyInfoModel.moveToNextValue;
            if (str != null) {
                cardView.setCardBankTextColor(str.length() == 0);
                cardView.setCardBankLogo(str);
            }
            if (!cardView.getHasPerfromCardAnimate()) {
                cardView.performCardAnimation(false, new Function0<Unit>() { // from class: id.dana.cardbinding.activity.CardBindingActivity$setupCardBankPreview$1$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        CardView.this.setCardBankBackground(queryCardPolicyInfoModel);
                    }
                });
                cardView.setHasPerfromCardAnimate(true);
            }
            cardView.setCardType(String.valueOf(queryCardPolicyInfoModel.getAuthRequestContext));
            cardView.setCardScheme(queryCardPolicyInfoModel.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            AppCompatImageView appCompatImageView = (AppCompatImageView) cardView._$_findCachedViewById(R.id.getMissionActiveImage).findViewById(R.id.res_0x7f0a0a34_camera_onzoomchangelistener);
            if (appCompatImageView != null) {
                String string = cardView.getContext().getString(R.string.cardbind_icon_card_preview_scheme);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String format = String.format(string, Arrays.copyOf(new Object[]{queryCardPolicyInfoModel.BuiltInFictitiousFunctionClassFactory}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                appCompatImageView.setContentDescription(format);
            }
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(List<? extends QueryCardVerifyElementModel> p0) {
        AddNewCardAdapter addNewCardAdapter = this.getAuthRequestContext;
        if (addNewCardAdapter != null) {
            addNewCardAdapter.setItems(p0);
            QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.getSupportButtonTintMode;
            addNewCardAdapter.BuiltInFictitiousFunctionClassFactory = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.MyBillsEntityDataFactory() : false;
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        Subject<Boolean> subject = this.isLayoutRequested;
        Boolean bool = Boolean.FALSE;
        subject.onNext(bool);
        this.FragmentBottomSheetPaymentSettingBinding.onNext(bool);
        this.PlaceComponentResult.onNext(bool);
        this.newProxyInstance.onNext(bool);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.onNext(bool);
    }

    private final void MyBillsEntityDataFactory(final boolean p0) {
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().PlaceComponentResult;
        danaButtonPrimaryView.setEnabled(p0);
        danaButtonPrimaryView.setClickable(p0);
        Context context = danaButtonPrimaryView.getContext();
        danaButtonPrimaryView.setDanaButtonView(p0 ? 1 : 0, context != null ? context.getString(R.string.card_binding_add_new_card_button) : null, "", null);
        danaButtonPrimaryView.setContentDescription(danaButtonPrimaryView.getContext().getString(R.string.btn_continue_cashier));
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.activity.CardBindingActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardBindingActivity.$r8$lambda$2vQzSbvak9wo54Dhs2KMLMHZqLY(p0, this, view);
            }
        });
    }

    private final void scheduleImpl() {
        SendBankOtpModel sendBankOtpModel = this.sendBankOtpModel;
        if (sendBankOtpModel != null) {
            if (this.isDirectDebit) {
                getOtpVm().BuiltInFictitiousFunctionClassFactory(sendBankOtpModel);
            } else {
                OtpCardBindingViewModel.PlaceComponentResult(getOtpVm(), sendBankOtpModel);
            }
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        ChallengeControl.Builder builder = new ChallengeControl.Builder(this);
        builder.scheduleImpl = "card_binding_pin";
        ChallengeControl.Builder PlaceComponentResult = builder.PlaceComponentResult("PASSWORD", p0, this.PrepareContext, this.payMethod, p1);
        PlaceComponentResult.VerifyPinStateManager$executeRiskChallenge$2$1 = "card_binding_pin";
        new ChallengeControl(PlaceComponentResult, null).getAuthRequestContext();
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.getErrorConfigVersion();
    }

    static /* synthetic */ void MyBillsEntityDataFactory$default(CardBindingActivity cardBindingActivity, String str, Integer num, Integer num2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        cardBindingActivity.MyBillsEntityDataFactory(str, num, num2);
    }

    public final void MyBillsEntityDataFactory(String p0, Integer p1, Integer p2) {
        if (p1 != null && p1.intValue() == 0) {
            CardBindingDialogExtKt.BuiltInFictitiousFunctionClassFactory(this);
            return;
        }
        ChallengeControl.Builder builder = new ChallengeControl.Builder(this);
        builder.scheduleImpl = ChallengeScenario.CARD_BINDING_OTP;
        new ChallengeControl(builder.KClassImpl$Data$declaredNonStaticMembers$2(p0, this.sendBankOtpModel, this.PrepareContext, this.isDirectDebit, this.payMethod).KClassImpl$Data$declaredNonStaticMembers$2(p2 != null ? p2.intValue() : 0, p1 != null ? p1.intValue() : 4, null, false), null).getAuthRequestContext();
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.getErrorConfigVersion();
    }

    public static /* synthetic */ void PlaceComponentResult$default(CardBindingActivity cardBindingActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        cardBindingActivity.PlaceComponentResult(str, str2);
    }

    public final void PlaceComponentResult(String p0, String p1) {
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.getAuthRequestContext = CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2(CardBindingTrackerUtil.PlaceComponentResult);
        CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
        CardBindingAnalyticTracker cardBindingAnalyticTracker = getCardBindingAnalyticTracker();
        CashierCheckoutModel cashierCheckoutModel = this.cashierMainResult;
        CardBindingTrackerUtil.PlaceComponentResult(cardBindingAnalyticTracker, new AddCardResultProperties(false, cashierCheckoutModel != null ? cashierCheckoutModel.PlaceComponentResult : null, p0, this.getSupportButtonTintMode, null, null, null, null, p1, 240, null));
    }

    public final void PlaceComponentResult(String p0) {
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.getAuthRequestContext = CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2(CardBindingTrackerUtil.PlaceComponentResult);
        CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
        CardBindingAnalyticTracker cardBindingAnalyticTracker = getCardBindingAnalyticTracker();
        CashierCheckoutModel cashierCheckoutModel = this.cashierMainResult;
        CardBindingTrackerUtil.PlaceComponentResult(cardBindingAnalyticTracker, new AddCardResultProperties(true, cashierCheckoutModel != null ? cashierCheckoutModel.PlaceComponentResult : null, p0, this.getSupportButtonTintMode, null, null, null, null, null, 496, null));
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory$default(CardBindingActivity cardBindingActivity, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        cardBindingActivity.BuiltInFictitiousFunctionClassFactory(str, z);
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, boolean p1) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            getBinding().BuiltInFictitiousFunctionClassFactory.setDataBankCard(p0, p1);
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setDataBankCard(null, p1);
        } else {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setDataBankCard(p0, p1);
            getBinding().BuiltInFictitiousFunctionClassFactory.setDataBankCard(null, p1);
        }
        if (p0 != null) {
            getBinding().getErrorConfigVersion.showSupportedCardsView(false);
            getBinding().getErrorConfigVersion.setVisibility(8);
        }
    }

    private final void MyBillsEntityDataFactory() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setCheckboxListener(new DisclaimerView.OnCheckboxListener() { // from class: id.dana.cardbinding.activity.CardBindingActivity$initDisclaimerView$1
            @Override // id.dana.cardbinding.view.DisclaimerView.OnCheckboxListener
            public final void PlaceComponentResult(boolean p0) {
                Subject subject;
                subject = CardBindingActivity.this.newProxyInstance;
                subject.onNext(Boolean.valueOf(p0));
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.setCheckboxListener(new DisclaimerView.OnCheckboxListener() { // from class: id.dana.cardbinding.activity.CardBindingActivity$initDisclaimerView$2
            @Override // id.dana.cardbinding.view.DisclaimerView.OnCheckboxListener
            public final void PlaceComponentResult(boolean p0) {
                Subject subject;
                subject = CardBindingActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                subject.onNext(Boolean.valueOf(p0));
            }
        });
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        AttributeModel attributeModel;
        List<CashierPayChannelModel> list;
        CashierCheckoutModel cashierCheckoutModel = this.cashierMainResult;
        Object obj = null;
        if (cashierCheckoutModel != null && (attributeModel = cashierCheckoutModel.getAuthRequestContext) != null && (list = attributeModel.SummaryVoucherView$$ExternalSyntheticLambda1) != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                CashierPayChannelModel cashierPayChannelModel = (CashierPayChannelModel) next;
                if (Intrinsics.areEqual(cashierPayChannelModel.B, p0) && cashierPayChannelModel.lookAheadTest() && Intrinsics.areEqual(cashierPayChannelModel.getErrorConfigVersion, Boolean.TRUE)) {
                    obj = next;
                    break;
                }
            }
            obj = (CashierPayChannelModel) obj;
        }
        return obj != null;
    }

    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        if (p0.length() < 6 || this.DatabaseTableConfigUtil) {
            return;
        }
        this.lookAheadTest.MyBillsEntityDataFactory();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7) {
            this.lookAheadTest.getAuthRequestContext(moveToNextValue());
        } else {
            this.lookAheadTest.getAuthRequestContext(getErrorConfigVersion());
        }
        this.DatabaseTableConfigUtil = true;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        List<String> list;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.getSupportButtonTintMode;
        if (queryCardPolicyInfoModel == null || (list = queryCardPolicyInfoModel.GetContactSyncConfig) == null) {
            return;
        }
        CashierAddCardVerifyElementsFactory cashierAddCardVerifyElementsFactory = CashierAddCardVerifyElementsFactory.INSTANCE;
        getAuthRequestContext(CashierAddCardVerifyElementsFactory.getAuthRequestContext(list));
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            this.SubSequence.put((String) it.next(), Boolean.FALSE);
            arrayList.add(Unit.INSTANCE);
        }
    }

    private final Disposable moveToNextValue() {
        Disposable subscribe = Observable.combineLatest(this.PlaceComponentResult, this.NetworkUserEntityData$$ExternalSyntheticLambda8, new BiFunction() { // from class: id.dana.cardbinding.activity.CardBindingActivity$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                ((Boolean) obj).booleanValue();
                ((Boolean) obj2).booleanValue();
                valueOf = Boolean.valueOf(r0 && r1);
                return valueOf;
            }
        }).subscribe(new Consumer() { // from class: id.dana.cardbinding.activity.CardBindingActivity$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CardBindingActivity.$r8$lambda$WHsOm45yXFqXV9ZkPCZFCqYdhpc(CardBindingActivity.this, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        return subscribe;
    }

    private final Disposable getErrorConfigVersion() {
        Disposable subscribe = Observable.combineLatest(this.FragmentBottomSheetPaymentSettingBinding, this.isLayoutRequested, this.PlaceComponentResult, this.newProxyInstance, new Function4() { // from class: id.dana.cardbinding.activity.CardBindingActivity$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function4
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                Boolean valueOf;
                ((Boolean) obj).booleanValue();
                ((Boolean) obj2).booleanValue();
                ((Boolean) obj3).booleanValue();
                ((Boolean) obj4).booleanValue();
                valueOf = Boolean.valueOf(r2 && r1 && r0 && r3);
                return valueOf;
            }
        }).subscribe(new Consumer() { // from class: id.dana.cardbinding.activity.CardBindingActivity$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CardBindingActivity.$r8$lambda$ay9WHuvPGdvz0_cSsZyuOm4DORM(CardBindingActivity.this, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        return subscribe;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public final void onActivityResult(int r4, int resultCode, Intent data) {
        AttributeCashierPayModel attributeCashierPayModel;
        Bundle extras;
        Bundle extras2;
        Bundle extras3;
        super.onActivityResult(r4, resultCode, data);
        if ((r4 == 1013 || r4 == 1014) && resultCode == -1) {
            CashierPayModel cashierPayModel = (data == null || (extras3 = data.getExtras()) == null) ? null : (CashierPayModel) extras3.getParcelable(ChallengeControl.Key.CASHIER_PAY_MODEL);
            CashierAgreementModel cashierAgreementModel = (data == null || (extras2 = data.getExtras()) == null) ? null : (CashierAgreementModel) extras2.getParcelable(ChallengeControl.Key.CASHIER_AGREEMENT_MODEL);
            boolean z = false;
            this.PrepareContext = (data == null || (extras = data.getExtras()) == null) ? false : extras.getBoolean(ChallengeControl.Key.IS_RISK_PHASE_2);
            this.MyBillsEntityDataFactory = (cashierPayModel == null || (attributeCashierPayModel = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : attributeCashierPayModel.scheduleImpl;
            if (cashierPayModel != null) {
                AttributeCashierPayModel attributeCashierPayModel2 = cashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2;
                if (attributeCashierPayModel2 != null && attributeCashierPayModel2.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    z = true;
                }
                if (z) {
                    MyBillsEntityDataFactory(cashierPayModel);
                    return;
                }
                CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
                CardBindingTrackerUtil.PlaceComponentResult();
                CardBindingDialogExtKt.KClassImpl$Data$declaredNonStaticMembers$2(this, this.MyBillsEntityDataFactory);
                String str = cashierAgreementModel != null ? cashierAgreementModel.scheduleImpl : null;
                if (str == null) {
                    str = "";
                }
                PlaceComponentResult(str);
                getCardBindingVm().BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lookAheadTest.dispose();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cardbinding/activity/CardBindingActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Intent MyBillsEntityDataFactory(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, CardBindingActivity.class);
            intent.putExtra("source", p1);
            return intent;
        }
    }

    /* renamed from: $r8$lambda$1vLr-HkwLEcJSkXKjVTs_3qcKOE */
    public static /* synthetic */ void m477$r8$lambda$1vLrHkwLEcJSkXKjVTs_3qcKOE(CardBindingActivity cardBindingActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(cardBindingActivity, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory != -1) {
            CardBindingDialogExtKt.PlaceComponentResult(r15, r15.getString(R.string.card_binding_save_card_dialog_server_error_title), cardBindingActivity.getString(R.string.card_binding_save_card_dialog_desc), R.drawable.ic_save_card_server_failed);
            QueryCardPolicyInfoModel queryCardPolicyInfoModel = cardBindingActivity.getSupportButtonTintMode;
            String str = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.initRecordTimeStamp : null;
            cardBindingActivity.PlaceComponentResult(str != null ? str : "", "3DS Failed");
            return;
        }
        Intent intent = activityResult.MyBillsEntityDataFactory;
        String stringExtra = intent != null ? intent.getStringExtra(CashierRisk3dsActivity.URL_PARAMS) : null;
        CashierCheckoutModel cashierCheckoutModel = cardBindingActivity.cashierMainResult;
        if (cashierCheckoutModel != null) {
            String str2 = cashierCheckoutModel.PlaceComponentResult;
            cardBindingActivity.getCardBindingVm().KClassImpl$Data$declaredNonStaticMembers$2(new CashierPayParamModel(str2 == null ? "" : str2, stringExtra, null, false, null, null, null, cardBindingActivity.NetworkUserEntityData$$ExternalSyntheticLambda7, 124, null));
        }
    }

    /* JADX WARN: Type inference failed for: r17v0, types: [id.dana.cashier.model.CashierPayChannelModel, java.lang.String] */
    /* JADX WARN: Type inference failed for: r20v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    public static /* synthetic */ void $r8$lambda$2vQzSbvak9wo54Dhs2KMLMHZqLY(boolean z, CardBindingActivity cardBindingActivity, View view) {
        CashierPayMethodModel.NewCardData newCardData;
        CashierPayMethodModel.NewCardData newCardData2;
        Intrinsics.checkNotNullParameter(cardBindingActivity, "");
        if (z) {
            String str = cardBindingActivity.NetworkUserEntityData$$ExternalSyntheticLambda2;
            StringBuilder sb = new StringBuilder();
            sb.append("20");
            sb.append(cardBindingActivity.NetworkUserEntityData$$ExternalSyntheticLambda1);
            String obj = sb.toString();
            String cleanCardNumber = cardBindingActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.getCleanCardNumber();
            String str2 = cardBindingActivity.getErrorConfigVersion;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel = cardBindingActivity.getSupportButtonTintMode;
            String str3 = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.MyBillsEntityDataFactory : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel2 = cardBindingActivity.getSupportButtonTintMode;
            CashierPayMethodModel.NewCardData newCardData3 = new CashierPayMethodModel.NewCardData(cleanCardNumber, str, obj, str2, str3, queryCardPolicyInfoModel2 != null ? queryCardPolicyInfoModel2.getAuthRequestContext : null, true, null, null, 384, null);
            QueryCardPolicyInfoModel queryCardPolicyInfoModel3 = cardBindingActivity.getSupportButtonTintMode;
            String str4 = queryCardPolicyInfoModel3 != null ? queryCardPolicyInfoModel3.PlaceComponentResult : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel4 = cardBindingActivity.getSupportButtonTintMode;
            String str5 = queryCardPolicyInfoModel4 != null ? queryCardPolicyInfoModel4.BuiltInFictitiousFunctionClassFactory : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel5 = cardBindingActivity.getSupportButtonTintMode;
            String str6 = queryCardPolicyInfoModel5 != null ? queryCardPolicyInfoModel5.getAuthRequestContext : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel6 = cardBindingActivity.getSupportButtonTintMode;
            Boolean bool = queryCardPolicyInfoModel6 != null ? queryCardPolicyInfoModel6.scheduleImpl : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel7 = cardBindingActivity.getSupportButtonTintMode;
            String str7 = queryCardPolicyInfoModel7 != null ? queryCardPolicyInfoModel7.moveToNextValue : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel8 = cardBindingActivity.getSupportButtonTintMode;
            String str8 = queryCardPolicyInfoModel8 != null ? queryCardPolicyInfoModel8.getErrorConfigVersion : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel9 = cardBindingActivity.getSupportButtonTintMode;
            String str9 = queryCardPolicyInfoModel9 != null ? queryCardPolicyInfoModel9.NetworkUserEntityData$$ExternalSyntheticLambda1 : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel10 = cardBindingActivity.getSupportButtonTintMode;
            String str10 = queryCardPolicyInfoModel10 != null ? queryCardPolicyInfoModel10.initRecordTimeStamp : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel11 = cardBindingActivity.getSupportButtonTintMode;
            List<String> list = queryCardPolicyInfoModel11 != null ? queryCardPolicyInfoModel11.GetContactSyncConfig : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel12 = cardBindingActivity.getSupportButtonTintMode;
            ?? r17 = 0;
            ?? r20 = 0;
            CashierPayMethodModel.CardPayMethod cardPayMethod = new CashierPayMethodModel.CardPayMethod(new AssetCardModel(r17, null, null, r20, str4, null, null, str5, null, null, bool, null, null, newCardData3.getAuthRequestContext, newCardData3.KClassImpl$Data$declaredNonStaticMembers$2, str7, str8, null, null, null, null, null, str10, str9, null, null, null, str6, list, null, queryCardPolicyInfoModel12 != null ? queryCardPolicyInfoModel12.NetworkUserEntityData$$ExternalSyntheticLambda0 : null, null, null, null, null, null, null, null, -1489101969, 63, null), r17, newCardData3, 2, r20);
            cardBindingActivity.payMethod = cardPayMethod;
            CashierPayMethodModel.NewCardData newCardData4 = cardPayMethod.getAuthRequestContext;
            String str11 = newCardData4 != null ? newCardData4.PlaceComponentResult : null;
            CashierPayMethodModel.CardPayMethod cardPayMethod2 = cardBindingActivity.payMethod;
            String str12 = (cardPayMethod2 == null || (newCardData2 = cardPayMethod2.getAuthRequestContext) == null) ? null : newCardData2.getAuthRequestContext;
            String str13 = str12 == null ? "" : str12;
            CashierPayMethodModel.CardPayMethod cardPayMethod3 = cardBindingActivity.payMethod;
            String str14 = (cardPayMethod3 == null || (newCardData = cardPayMethod3.getAuthRequestContext) == null) ? null : newCardData.KClassImpl$Data$declaredNonStaticMembers$2;
            String str15 = str14 == null ? "" : str14;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel13 = cardBindingActivity.getSupportButtonTintMode;
            String str16 = queryCardPolicyInfoModel13 != null ? queryCardPolicyInfoModel13.getAuthRequestContext : null;
            QueryCardPolicyInfoModel queryCardPolicyInfoModel14 = cardBindingActivity.getSupportButtonTintMode;
            String str17 = queryCardPolicyInfoModel14 != null ? queryCardPolicyInfoModel14.moveToNextValue : null;
            String str18 = cardBindingActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            CashierCheckoutModel cashierCheckoutModel = cardBindingActivity.cashierMainResult;
            cardBindingActivity.sendBankOtpModel = new SendBankOtpModel(null, cashierCheckoutModel != null ? cashierCheckoutModel.PlaceComponentResult : null, null, str18, cardBindingActivity.initRecordTimeStamp, str11, str16, str17, str13, str15, cardBindingActivity.moveToNextValue, null, null, cardBindingActivity.BuiltInFictitiousFunctionClassFactory, 6144, null);
            if (cardBindingActivity.NetworkUserEntityData$$ExternalSyntheticLambda7) {
                cardBindingActivity.getCardBindingVm().KClassImpl$Data$declaredNonStaticMembers$2(cardBindingActivity);
            } else {
                QueryCardPolicyInfoModel queryCardPolicyInfoModel15 = cardBindingActivity.getSupportButtonTintMode;
                if (queryCardPolicyInfoModel15 != null && queryCardPolicyInfoModel15.BuiltInFictitiousFunctionClassFactory()) {
                    if (cardBindingActivity.sendBankOtpModel != null) {
                        cardBindingActivity.scheduleImpl();
                    }
                } else {
                    CashierPayMethodModel.CardPayMethod cardPayMethod4 = cardBindingActivity.payMethod;
                    if (cardPayMethod4 != null) {
                        CashierCheckoutModel cashierCheckoutModel2 = cardBindingActivity.cashierMainResult;
                        String str19 = cashierCheckoutModel2 != null ? cashierCheckoutModel2.PlaceComponentResult : null;
                        cardBindingActivity.getCardBindingVm().MyBillsEntityDataFactory(new CashierPayParamModel(str19 == null ? "" : str19, null, null, false, null, null, cardPayMethod4, false, 190, null));
                    }
                }
            }
            MixPanelTracker.getAuthRequestContext(TrackerKey.Event.ADD_CARD_RESULT);
            CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
            CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2();
            CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
            CardBindingAnalyticTracker cardBindingAnalyticTracker = cardBindingActivity.getCardBindingAnalyticTracker();
            CashierCheckoutModel cashierCheckoutModel3 = cardBindingActivity.cashierMainResult;
            CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2(cardBindingAnalyticTracker, new AddCardExecutionProperties(cashierCheckoutModel3 != null ? cashierCheckoutModel3.PlaceComponentResult : null, cardBindingActivity.getSupportButtonTintMode, null, null, 12, null));
            CardBindingTrackerUtil cardBindingTrackerUtil3 = CardBindingTrackerUtil.INSTANCE;
            CardBindingTrackerUtil.MyBillsEntityDataFactory();
        }
    }

    public static /* synthetic */ void $r8$lambda$J3pPUuRM0Ab8oQW4Rkk8OuhOKcY(CardBindingActivity cardBindingActivity, View view) {
        Intrinsics.checkNotNullParameter(cardBindingActivity, "");
        ConstraintLayout constraintLayout = cardBindingActivity.getBinding().lookAheadTest.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
        LinearLayout linearLayout = cardBindingActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(0);
        cardBindingActivity.getCardBindingVm().getAuthRequestContext(UserEducationScenarioKt.CARD_BINDING_ONBOARDING);
    }

    public static /* synthetic */ void $r8$lambda$RFGhMDLiREMQH6n4nNBSEOzmHJM(CardBindingActivity cardBindingActivity, View view) {
        Intrinsics.checkNotNullParameter(cardBindingActivity, "");
        cardBindingActivity.onBackPressed();
    }

    public static /* synthetic */ void $r8$lambda$WHsOm45yXFqXV9ZkPCZFCqYdhpc(CardBindingActivity cardBindingActivity, boolean z) {
        Intrinsics.checkNotNullParameter(cardBindingActivity, "");
        cardBindingActivity.MyBillsEntityDataFactory(z);
    }

    public static /* synthetic */ void $r8$lambda$ay9WHuvPGdvz0_cSsZyuOm4DORM(CardBindingActivity cardBindingActivity, boolean z) {
        Intrinsics.checkNotNullParameter(cardBindingActivity, "");
        cardBindingActivity.MyBillsEntityDataFactory(z);
    }

    public static final /* synthetic */ DanaLoadingDialog access$getDanaLoadingDialog(CardBindingActivity cardBindingActivity) {
        return (DanaLoadingDialog) cardBindingActivity.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue();
    }

    public static final /* synthetic */ CashierPayChannelModel access$getFirstPayMethod(CardBindingActivity cardBindingActivity, AttributeCashierPayModel attributeCashierPayModel) {
        List<CashierPayChannelModel> list;
        if (attributeCashierPayModel == null || (list = attributeCashierPayModel.I) == null) {
            return null;
        }
        return list.get(0);
    }

    public static final /* synthetic */ void access$getQueryCardPolicy(CardBindingActivity cardBindingActivity, String str) {
        CardBindingViewModel cardBindingVm = cardBindingActivity.getCardBindingVm();
        CashierCheckoutModel cashierCheckoutModel = cardBindingActivity.cashierMainResult;
        cardBindingVm.PlaceComponentResult(str, String.valueOf(cashierCheckoutModel != null ? cashierCheckoutModel.PlaceComponentResult : null));
    }

    public static final /* synthetic */ void access$handleQueryCardResult(CardBindingActivity cardBindingActivity, QueryCardPolicyInfoModel queryCardPolicyInfoModel, String str) {
        String str2 = queryCardPolicyInfoModel.initRecordTimeStamp;
        if (str2 == null) {
            str2 = queryCardPolicyInfoModel.getAuthRequestContext;
        }
        if (str2 == null) {
            str2 = "";
        }
        cardBindingActivity.NetworkUserEntityData$$ExternalSyntheticLambda5 = cardBindingActivity.KClassImpl$Data$declaredNonStaticMembers$2(str2);
        if (Intrinsics.areEqual(queryCardPolicyInfoModel.moveToNextValue, Institution.BCA_ONEKLIK)) {
            cardBindingActivity.BuiltInFictitiousFunctionClassFactory(true);
            BuiltInFictitiousFunctionClassFactory$default(cardBindingActivity, "BCA_ONE_KLIK", false, 2, null);
        }
        cardBindingActivity.MyBillsEntityDataFactory(queryCardPolicyInfoModel);
        cardBindingActivity.BuiltInFictitiousFunctionClassFactory(str);
        if (!cardBindingActivity.NetworkUserEntityData$$ExternalSyntheticLambda7 && !cardBindingActivity.isDirectDebit) {
            cardBindingActivity.KClassImpl$Data$declaredNonStaticMembers$2();
            BuiltInFictitiousFunctionClassFactory$default(cardBindingActivity, queryCardPolicyInfoModel.getAuthRequestContext, false, 2, null);
        }
        if (cardBindingActivity.isDirectDebit) {
            cardBindingActivity.KClassImpl$Data$declaredNonStaticMembers$2();
            cardBindingActivity.BuiltInFictitiousFunctionClassFactory(DisclaimerView.DIRECT_DEBIT, cardBindingActivity.isGpn);
        }
        cardBindingActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.getIconCardErrorHandlingListener().invoke(str);
    }

    public static final /* synthetic */ void access$resetAllState(CardBindingActivity cardBindingActivity) {
        cardBindingActivity.lookAheadTest.MyBillsEntityDataFactory();
        cardBindingActivity.MyBillsEntityDataFactory(false);
        cardBindingActivity.DatabaseTableConfigUtil = false;
        cardBindingActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.clearCardIcon();
        cardBindingActivity.getBinding().getErrorConfigVersion.showSupportedCardsView(true);
        cardBindingActivity.getBinding().getErrorConfigVersion.setVisibility(0);
        cardBindingActivity.MyBillsEntityDataFactory((QueryCardPolicyInfoModel) null);
        cardBindingActivity.BuiltInFictitiousFunctionClassFactory();
        cardBindingActivity.getAuthRequestContext = null;
        cardBindingActivity.getAuthRequestContext();
        cardBindingActivity.getErrorConfigVersion = "";
        cardBindingActivity.NetworkUserEntityData$$ExternalSyntheticLambda2 = "";
        cardBindingActivity.NetworkUserEntityData$$ExternalSyntheticLambda1 = "";
        cardBindingActivity.KClassImpl$Data$declaredNonStaticMembers$2 = "";
        cardBindingActivity.moveToNextValue = "";
        cardBindingActivity.initRecordTimeStamp = "";
        cardBindingActivity.BuiltInFictitiousFunctionClassFactory = "";
        cardBindingActivity.SubSequence.clear();
        BuiltInFictitiousFunctionClassFactory$default(cardBindingActivity, null, false, 2, null);
        cardBindingActivity.MyBillsEntityDataFactory();
        cardBindingActivity.BuiltInFictitiousFunctionClassFactory(false);
    }

    public static final /* synthetic */ void access$setVerifyElementsValidation(CardBindingActivity cardBindingActivity, String str, boolean z) {
        cardBindingActivity.SubSequence.put(str, Boolean.valueOf(z));
        cardBindingActivity.FragmentBottomSheetPaymentSettingBinding.onNext(Boolean.valueOf(!cardBindingActivity.SubSequence.containsValue(Boolean.FALSE)));
    }

    public static final /* synthetic */ void access$showOnboarding(CardBindingActivity cardBindingActivity) {
        ConstraintLayout constraintLayout = cardBindingActivity.getBinding().lookAheadTest.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(0);
        constraintLayout.setFocusable(true);
        constraintLayout.setClickable(true);
        LinearLayout linearLayout = cardBindingActivity.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
        String string = cardBindingActivity.getString(R.string.card_binding_onboarding_title_trusted_security);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = cardBindingActivity.getString(R.string.card_binding_onboarding_content_trusted_security);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = cardBindingActivity.getString(R.string.card_binding_onboarding_title_hassle_free);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = cardBindingActivity.getString(R.string.card_binding_onboarding_content_hassle_free);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = cardBindingActivity.getString(R.string.card_binding_onboarding_title_easy_to_manage);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = cardBindingActivity.getString(R.string.card_binding_onboarding_content_easy_to_manage);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        cardBindingActivity.scheduleImpl = CollectionsKt.arrayListOf(new ContentOnBoardingModel((int) R.drawable.ic_trusted_security, string, string2), new ContentOnBoardingModel((int) R.drawable.ic_hassle_free, string3, string4), new ContentOnBoardingModel((int) R.drawable.ic_easy_to_manage, string5, string6));
        HelpListView helpListView = cardBindingActivity.getBinding().lookAheadTest.MyBillsEntityDataFactory;
        List<ContentOnBoardingModel> list = cardBindingActivity.scheduleImpl;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list = null;
        }
        helpListView.setAdapter(new HelpListAdapter(list));
    }

    public static final /* synthetic */ void access$trackAddCardOpenIfNeeded(CardBindingActivity cardBindingActivity) {
        Bundle extras;
        if (cardBindingActivity.GetContactSyncConfig) {
            return;
        }
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingAnalyticTracker cardBindingAnalyticTracker = cardBindingActivity.getCardBindingAnalyticTracker();
        Intent intent = cardBindingActivity.getIntent();
        CardBindingTrackerUtil.BuiltInFictitiousFunctionClassFactory(cardBindingAnalyticTracker, new AddCardOpenProperties((intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("source"), null, null, 6, null));
        cardBindingActivity.GetContactSyncConfig = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x006e, code lost:
    
        if (r0 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0071, code lost:
    
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x009c, code lost:
    
        if (r0 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00ba, code lost:
    
        if (r0.equals(id.dana.cashier.VerificationMethod.BANK_OTP) != false) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00bc, code lost:
    
        scheduleImpl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x004d, code lost:
    
        if (r0.equals(id.dana.cashier.VerificationMethod.SEND_OTP) == false) goto L138;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(id.dana.cashier.model.CashierPayModel r11) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.activity.CardBindingActivity.MyBillsEntityDataFactory(id.dana.cashier.model.CashierPayModel):void");
    }

    private final void PlaceComponentResult(CashierPayModel p0) {
        Bundle KClassImpl$Data$declaredNonStaticMembers$22 = new RiskParamsFactory(p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.MyBillsEntityDataFactory, null, false, null, null, null, null, null, null, null, null, null, null, null, 32764, null).KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.putBoolean(CashierRisk3dsActivity.IS_CARD_BINDING, true);
        CashierRisk3dsActivity.Companion companion = CashierRisk3dsActivity.INSTANCE;
        Intent authRequestContext = CashierRisk3dsActivity.Companion.getAuthRequestContext(this, KClassImpl$Data$declaredNonStaticMembers$22);
        ActivityResultLauncher<Intent> activityResultLauncher = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activityResultLauncher = null;
        }
        activityResultLauncher.MyBillsEntityDataFactory(authRequestContext, null);
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingAnalyticTracker cardBindingAnalyticTracker = getCardBindingAnalyticTracker();
        CashierCheckoutModel cashierCheckoutModel = this.cashierMainResult;
        CardBindingTrackerUtil.getAuthRequestContext(cardBindingAnalyticTracker, new ThirdPartyRiskChallengeProperties(cashierCheckoutModel != null ? cashierCheckoutModel.PlaceComponentResult : null, this.getSupportButtonTintMode, null, null, 12, null));
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    private final void MyBillsEntityDataFactory(QueryCardPolicyInfoModel queryCardPolicyInfoModel) {
        String str = queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.PlaceComponentResult : null;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel2 = this.getSupportButtonTintMode;
        if (!Intrinsics.areEqual(str, queryCardPolicyInfoModel2 != null ? queryCardPolicyInfoModel2.PlaceComponentResult : null) || queryCardPolicyInfoModel == null) {
            this.getSupportButtonTintMode = queryCardPolicyInfoModel;
            if (queryCardPolicyInfoModel != null) {
                NetworkUserEntityData$$ExternalSyntheticLambda0();
                Boolean bool = queryCardPolicyInfoModel.scheduleImpl;
                this.isDirectDebit = bool != null ? bool.booleanValue() : false;
                this.isGpn = Intrinsics.areEqual(queryCardPolicyInfoModel.BuiltInFictitiousFunctionClassFactory, CardScheme.GPN);
            }
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        getCardBindingVm().getAuthRequestContext();
        CardBindingTrackerUtil cardBindingTrackerUtil = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.BuiltInFictitiousFunctionClassFactory();
        getCardBindingVm().MyBillsEntityDataFactory();
        getAuthRequestContext();
        InputCardNumberView inputCardNumberView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory;
        String string = getString(R.string.card_binding_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        inputCardNumberView.setTitle(string);
        InputCardNumberView inputCardNumberView2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory;
        String string2 = getString(R.string.card_binding_hint);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        inputCardNumberView2.setCardHint(string2);
        CardView cardView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
        QueryCardPolicyInfoModel queryCardPolicyInfoModel = this.getSupportButtonTintMode;
        cardView.setCardBankLogo(queryCardPolicyInfoModel != null ? queryCardPolicyInfoModel.moveToNextValue : null);
        getBinding().lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.activity.CardBindingActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardBindingActivity.$r8$lambda$J3pPUuRM0Ab8oQW4Rkk8OuhOKcY(CardBindingActivity.this, view);
            }
        });
        CardBindingTrackerUtil cardBindingTrackerUtil2 = CardBindingTrackerUtil.INSTANCE;
        CardBindingTrackerUtil.NetworkUserEntityData$$ExternalSyntheticLambda0 = CardBindingTrackerUtil.KClassImpl$Data$declaredNonStaticMembers$2(CardBindingTrackerUtil.moveToNextValue);
        getCardBindingVm().MyBillsEntityDataFactory(UserEducationScenarioKt.CARD_BINDING_ONBOARDING);
        BuiltInFictitiousFunctionClassFactory();
        AppCompatEditText appCompatEditText = (AppCompatEditText) getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory._$_findCachedViewById(R.id.GetFriendsFeedWithInitFeedAndFeatureCheck_res_0x7f0a0671);
        if (appCompatEditText != null) {
            appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.cardbinding.activity.CardBindingActivity$watcherCardNumberView$1
                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    ActivityCardBindingBinding binding;
                    binding = CardBindingActivity.this.getBinding();
                    CardView cardView2 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2;
                    String valueOf = String.valueOf(p0);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < valueOf.length(); i++) {
                        char charAt = valueOf.charAt(i);
                        if (!CharsKt.isWhitespace(charAt)) {
                            sb.append(charAt);
                        }
                    }
                    String obj = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    cardView2.setTextViewCardNumber(obj);
                }
            });
        }
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.addInputCardListener(LifecycleOwnerKt.PlaceComponentResult(this), new Function1<String, Unit>() { // from class: id.dana.cardbinding.activity.CardBindingActivity$initCardNumberListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                CardBindingActivity.access$getQueryCardPolicy(CardBindingActivity.this, str);
            }
        });
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory.setIconCardErrorHandlingListener(new Function1<String, Unit>() { // from class: id.dana.cardbinding.activity.CardBindingActivity$setCardErrorHandlingListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Subject subject;
                QueryCardPolicyInfoModel queryCardPolicyInfoModel2;
                ActivityCardBindingBinding binding;
                Subject subject2;
                boolean z;
                ActivityCardBindingBinding binding2;
                ActivityCardBindingBinding binding3;
                Intrinsics.checkNotNullParameter(str, "");
                if (str.length() >= 6) {
                    subject = CardBindingActivity.this.PlaceComponentResult;
                    subject.onNext(Boolean.TRUE);
                } else {
                    CardBindingActivity.access$resetAllState(CardBindingActivity.this);
                    if (str.length() < 6) {
                        binding2 = CardBindingActivity.this.getBinding();
                        if (binding2.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.getCurrentBankBackground().length() > 0) {
                            binding3 = CardBindingActivity.this.getBinding();
                            binding3.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.setCardBankToDefault();
                        }
                    }
                }
                queryCardPolicyInfoModel2 = CardBindingActivity.this.getSupportButtonTintMode;
                binding = CardBindingActivity.this.getBinding();
                InputCardNumberView inputCardNumberView3 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory;
                CardBindingActivity cardBindingActivity = CardBindingActivity.this;
                subject2 = cardBindingActivity.PlaceComponentResult;
                z = CardBindingActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                SupportedCardValidationExtKt.BuiltInFictitiousFunctionClassFactory(str, queryCardPolicyInfoModel2, inputCardNumberView3, cardBindingActivity, subject2, z);
            }
        });
        MyBillsEntityDataFactory();
        getBinding().getErrorConfigVersion.initRvAdapter(false);
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(F ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (F ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
    }
}
