package id.dana.danapoly.ui.board;

import android.content.Context;
import android.media.MediaPlayer;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.danapoly.R;
import id.dana.danapoly.ui.board.BaseDanapolyAudioActivity;
import id.dana.danapoly.ui.sound.DanapolyAudioPlayer;
import id.dana.danapoly.ui.sound.DanapolyAudioServiceHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\b&\u0018\u0000 \u0016*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0016B\u0007¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\f8\u0017X\u0096\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0013\u0010\u0014\u001a\u00020\u0011X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/danapoly/ui/board/BaseDanapolyAudioFragment;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lid/dana/core/ui/BaseViewBindingFragment;", "", "onResume", "()V", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/ui/sound/DanapolyAudioPlayer;", "getErrorConfigVersion", "Lid/dana/danapoly/ui/sound/DanapolyAudioPlayer;", "", "Z", "MyBillsEntityDataFactory", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "", "scheduleImpl", "Lkotlin/Lazy;", "getAuthRequestContext", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseDanapolyAudioFragment<VB extends ViewBinding> extends BaseViewBindingFragment<VB> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    DanapolyAudioPlayer PlaceComponentResult;
    DanapolyAudioPlayer MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private DanapolyAudioPlayer BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<Float>(this) { // from class: id.dana.danapoly.ui.board.BaseDanapolyAudioFragment$volumeByRingerMode$2
        final /* synthetic */ BaseDanapolyAudioFragment<VB> this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            float f;
            Context context = this.this$0.getContext();
            if (context != null) {
                DanapolyAudioServiceHelper danapolyAudioServiceHelper = DanapolyAudioServiceHelper.INSTANCE;
                f = DanapolyAudioServiceHelper.MyBillsEntityDataFactory(context);
            } else {
                f = 1.0f;
            }
            return Float.valueOf(f);
        }
    });

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        DanapolyAudioPlayer danapolyAudioPlayer;
        if (getContext() == null || (danapolyAudioPlayer = this.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        danapolyAudioPlayer.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getKClassImpl$Data$declaredNonStaticMembers$2()) {
            FragmentActivity activity = getActivity();
            BaseDanapolyAudioActivity baseDanapolyAudioActivity = activity instanceof BaseDanapolyAudioActivity ? (BaseDanapolyAudioActivity) activity : null;
            if (baseDanapolyAudioActivity != null) {
                baseDanapolyAudioActivity.setNeedStartMusicBackground(true);
            }
            FragmentActivity activity2 = getActivity();
            BaseDanapolyAudioActivity baseDanapolyAudioActivity2 = activity2 instanceof BaseDanapolyAudioActivity ? (BaseDanapolyAudioActivity) activity2 : null;
            if (baseDanapolyAudioActivity2 != null) {
                baseDanapolyAudioActivity2.startBackgroundMusic();
            }
        }
    }

    public final void PlaceComponentResult() {
        Context context = getContext();
        if (context != null) {
            DanapolyAudioPlayer.Builder builder = new DanapolyAudioPlayer.Builder(context, R.raw.getAuthRequestContext_res_0x7f120002);
            builder.lookAheadTest = ((Number) this.getAuthRequestContext.getValue()).floatValue();
            builder.BuiltInFictitiousFunctionClassFactory = true;
            this.MyBillsEntityDataFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        Context context2 = getContext();
        if (context2 != null) {
            DanapolyAudioPlayer.Builder builder2 = new DanapolyAudioPlayer.Builder(context2, R.raw.res_0x7f120003_kclassimpl_data_declarednonstaticmembers_2);
            builder2.lookAheadTest = ((Number) this.getAuthRequestContext.getValue()).floatValue();
            this.PlaceComponentResult = builder2.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        Context context3 = getContext();
        if (context3 != null) {
            DanapolyAudioPlayer.Builder builder3 = new DanapolyAudioPlayer.Builder(context3, R.raw.PlaceComponentResult_res_0x7f120019);
            builder3.lookAheadTest = ((Number) this.getAuthRequestContext.getValue()).floatValue();
            this.BuiltInFictitiousFunctionClassFactory = builder3.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        FragmentActivity activity = getActivity();
        BaseDanapolyAudioActivity baseDanapolyAudioActivity = activity instanceof BaseDanapolyAudioActivity ? (BaseDanapolyAudioActivity) activity : null;
        if (baseDanapolyAudioActivity != null) {
            baseDanapolyAudioActivity.setRingerModeListener(new BaseDanapolyAudioActivity.RingerModeListener(this) { // from class: id.dana.danapoly.ui.board.BaseDanapolyAudioFragment$initRingerModeListener$1
                final /* synthetic */ BaseDanapolyAudioFragment<VB> BuiltInFictitiousFunctionClassFactory;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.BuiltInFictitiousFunctionClassFactory = this;
                }

                @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity.RingerModeListener
                public final void getAuthRequestContext() {
                    DanapolyAudioPlayer danapolyAudioPlayer;
                    DanapolyAudioPlayer danapolyAudioPlayer2;
                    DanapolyAudioPlayer danapolyAudioPlayer3;
                    MediaPlayer mediaPlayer;
                    MediaPlayer mediaPlayer2;
                    MediaPlayer mediaPlayer3;
                    danapolyAudioPlayer = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
                    if (danapolyAudioPlayer != null && (mediaPlayer3 = danapolyAudioPlayer.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                        mediaPlayer3.setVolume(1.0f, 1.0f);
                    }
                    danapolyAudioPlayer2 = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                    if (danapolyAudioPlayer2 != null && (mediaPlayer2 = danapolyAudioPlayer2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                        mediaPlayer2.setVolume(1.0f, 1.0f);
                    }
                    danapolyAudioPlayer3 = ((BaseDanapolyAudioFragment) this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory;
                    if (danapolyAudioPlayer3 == null || (mediaPlayer = danapolyAudioPlayer3.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                        return;
                    }
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }

                @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity.RingerModeListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    DanapolyAudioPlayer danapolyAudioPlayer;
                    DanapolyAudioPlayer danapolyAudioPlayer2;
                    DanapolyAudioPlayer danapolyAudioPlayer3;
                    MediaPlayer mediaPlayer;
                    MediaPlayer mediaPlayer2;
                    MediaPlayer mediaPlayer3;
                    danapolyAudioPlayer = this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
                    if (danapolyAudioPlayer != null && (mediaPlayer3 = danapolyAudioPlayer.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                        mediaPlayer3.setVolume(0.0f, 0.0f);
                    }
                    danapolyAudioPlayer2 = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
                    if (danapolyAudioPlayer2 != null && (mediaPlayer2 = danapolyAudioPlayer2.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                        mediaPlayer2.setVolume(0.0f, 0.0f);
                    }
                    danapolyAudioPlayer3 = ((BaseDanapolyAudioFragment) this.BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory;
                    if (danapolyAudioPlayer3 == null || (mediaPlayer = danapolyAudioPlayer3.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                        return;
                    }
                    mediaPlayer.setVolume(0.0f, 0.0f);
                }
            });
            Unit unit = Unit.INSTANCE;
        }
    }
}
