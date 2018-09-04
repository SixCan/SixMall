package ca.six.mall.devonly;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ca.six.mall.view.rv.one_binding_types.BindingTypesRow;

public class Temp {
    public Temp(int a){
        this(""+a);
    }

    public Temp(String a){
        System.out.println("szw "+a);
    }

}


