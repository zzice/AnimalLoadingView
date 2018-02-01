package work.zice.loadingview;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author Zice
 * @desc
 * @date 2018/1/31
 */
public class AnimalLoadingView extends DialogFragment {

    private Dialog mDialog;

    private RelativeLayout mLoadingLayoutRl;
    private ImageView mLoadingMouseIv;
    private ImageView mLoadingCatIv;
    private ImageView mLoadingEyeLeftIv;
    private EyelidView mLoadingEyelidLeftIv;
    private ImageView mLoadingEyeRightIv;
    private EyelidView mLoadingEyelidRightIv;
    private GraduallyTextView mGraduallyTextView;


    private Animation mOperatingAnim, mEyeLeftAnim, mEyeRightAnim;

    private int mBgResId = -1;
    private int mMsgResId = -1;
    private CharSequence mMsgText = "";


    public AnimalLoadingView() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (mDialog == null) {
            mDialog = new Dialog(getActivity(), R.style.AnimalLoadingViewStyle);
            mDialog.setContentView(R.layout.loading_view_layout);
            mDialog.setCanceledOnTouchOutside(true);
            Window dialogWindow = mDialog.getWindow();
            dialogWindow.setGravity(Gravity.CENTER);
            // 定义动画
            defineAnimation();
            View view = dialogWindow.getDecorView();
            // 实例化视图
            initView(view);
            // 配置视图
            configView();
        }
        return mDialog;
    }

    private void configView() {

        if (mBgResId != -1) {
            mLoadingLayoutRl.setBackgroundResource(mBgResId);
        }

        if (mMsgResId != -1) {
            mGraduallyTextView.setText(mMsgResId);
        } else if (!TextUtils.isEmpty(mMsgText)) {
            mGraduallyTextView.setText(mMsgText);
        }

        mLoadingEyelidLeftIv.setColor(Color.parseColor("#d0ced1"));
        mLoadingEyelidLeftIv.setFromFull(true);

        mLoadingEyelidRightIv.setColor(Color.parseColor("#d0ced1"));
        mLoadingEyelidRightIv.setFromFull(true);

        mOperatingAnim.setAnimationListener(
                new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        mLoadingEyelidLeftIv.resetAnimator();
                        mLoadingEyelidRightIv.resetAnimator();
                    }
                });

    }

    private void defineAnimation() {
        mOperatingAnim = new RotateAnimation(360f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mOperatingAnim.setRepeatCount(Animation.INFINITE);
        mOperatingAnim.setDuration(2000);

        mEyeLeftAnim = new RotateAnimation(360f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mEyeLeftAnim.setRepeatCount(Animation.INFINITE);
        mEyeLeftAnim.setDuration(2000);

        mEyeRightAnim = new RotateAnimation(360f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mEyeRightAnim.setRepeatCount(Animation.INFINITE);
        mEyeRightAnim.setDuration(2000);

        LinearInterpolator lin = new LinearInterpolator();
        mOperatingAnim.setInterpolator(lin);
        mEyeLeftAnim.setInterpolator(lin);
        mEyeRightAnim.setInterpolator(lin);
    }

    private void initView(View view) {
        mLoadingLayoutRl = (RelativeLayout) view.findViewById(R.id.loading_layout_rl);
        mLoadingMouseIv = (ImageView) view.findViewById(R.id.loading_mouse_iv);
        mLoadingCatIv = (ImageView) view.findViewById(R.id.loading_cat_iv);
        mLoadingEyeLeftIv = (ImageView) view.findViewById(R.id.loading_eye_left_iv);
        mLoadingEyelidLeftIv = (EyelidView) view.findViewById(R.id.loading_eyelid_left_iv);
        mLoadingEyeRightIv = (ImageView) view.findViewById(R.id.loading_eye_right_iv);
        mLoadingEyelidRightIv = (EyelidView) view.findViewById(R.id.loading_eyelid_right_iv);
        mGraduallyTextView = (GraduallyTextView) view.findViewById(R.id.graduallyTextView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mLoadingMouseIv.setAnimation(mOperatingAnim);
        mLoadingEyeLeftIv.setAnimation(mEyeLeftAnim);
        mLoadingEyeRightIv.setAnimation(mEyeRightAnim);
        mLoadingEyelidLeftIv.startLoading();
        mLoadingEyelidRightIv.startLoading();
        mGraduallyTextView.startLoading();
    }

    @Override
    public void onPause() {
        super.onPause();

        mOperatingAnim.reset();
        mEyeLeftAnim.reset();
        mEyeRightAnim.reset();

        mLoadingMouseIv.clearAnimation();
        mLoadingEyeLeftIv.clearAnimation();
        mLoadingEyeRightIv.clearAnimation();

        mLoadingEyelidLeftIv.stopLoading();
        mLoadingEyelidRightIv.stopLoading();
        mGraduallyTextView.stopLoading();
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mDialog = null;
        System.gc();
    }

    public void setmBgResId(@DrawableRes int mBgResId) {
        this.mBgResId = mBgResId;
    }

    public void setmMsgText(CharSequence mMsgText) {
        this.mMsgText = mMsgText;
    }

    public void setmMsgResId(@StringRes int mMsgResId) {
        this.mMsgResId = mMsgResId;
    }
}
