package com.joxad.easydatabinding.fragment.v4;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by Jocelyn on 02/08/2017.
 */

public abstract class FragmentRecyclerBaseVM<T, F extends FragmentBase, B extends ViewDataBinding> extends FragmentBaseVM<F, B> {


    public ItemBinding<T> itemBinding = ItemBinding.of(itemData(), itemLayoutResource());
    public ObservableArrayList<T> items;

    /***

     * @param fragment
     * @param binding
     * @param savedInstance
     */
    public FragmentRecyclerBaseVM(F fragment, B binding, @Nullable Bundle savedInstance) {
        super(fragment, binding, savedInstance);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstance) {
        items = new ObservableArrayList<>();
    }

    /**
     * The int value found in the {@link com.joxad.easydatabinding.BR} class generated by DataBinding
     *
     * @return
     */
    public abstract int itemData();

    /***
     * @return your layout resources
     */
    @LayoutRes
    public abstract int itemLayoutResource();

}
