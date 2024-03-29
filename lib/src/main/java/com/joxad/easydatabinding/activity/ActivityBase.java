package com.joxad.easydatabinding.activity;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

/**
 * {@link ActivityBase} will allow you to generate a basic activity that put your view model {@link B} and its {@link VM}
 */
public abstract class ActivityBase<B extends ViewDataBinding, VM extends ActivityBaseVM> extends AppCompatActivity {

    /***
     * Binding activity class generated by Android
     */

    protected B binding;
    /***
     * Your IVM class
     */

    protected VM vm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, layoutResources());
        vm = baseActivityVM(binding, savedInstanceState);
        binding.setVariable(data(), vm);
    }


    @Override
    public void onBackPressed() {
        if (vm.onBackPressed()) super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (vm != null)
            vm.onResume();
    }


    @Override
    protected void onPause() {
        if (vm != null)
            vm.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        vm.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (vm != null)
            vm.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (vm != null)
            if (vm.onOptionsItemSelected(item)) {
                return true;
            }
        return super.onOptionsItemSelected(item);
    }

    /**
     * The int value found in the {@link com.joxad.easydatabinding.BR} class generated by DataBinding
     *
     * @return
     */
    public abstract int data();

    /***
     * @return your layout resources
     */
    @LayoutRes
    public abstract int layoutResources();

    /***
     * @param binding
     * @param savedInstanceState
     * @return the {@link VM} you want to use in this activity
     */
    public abstract VM baseActivityVM(B binding, Bundle savedInstanceState);


    /***
     * Handle the permission and give it to the activity
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (vm != null)
            if (vm instanceof IPermission)
                ((IPermission) vm).onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /***
     * Handle the request code
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (vm != null)
            if (vm instanceof IResult)
                ((IResult) vm).onActivityResult(requestCode, resultCode, data);
    }

    /***
     * Handle the new intent
     *
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (vm != null)
            if (vm instanceof INewIntent)
                ((INewIntent) vm).onNewIntent(intent);
    }

    /**
     * Handle animation of sharedelement
     */
    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        if (vm != null)
            vm.onEnterAnimationComplete();
    }

}
