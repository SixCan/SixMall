package ca.six.mall.devonly;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class Temp extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public Temp(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj){

    }
}
