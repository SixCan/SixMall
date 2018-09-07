package ca.six.mall.util;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;
import android.util.Log;

import java.lang.reflect.Method;

import ca.six.mall.BuildConfig;


public class JUnitJacocoTestRunner extends AndroidJUnitRunner {

    static {
        final String path = "/data/data/" + BuildConfig.APPLICATION_ID + "/coverage.ec";
        System.setProperty("jacoco-agent.destfile", path);
    }

    @Override
    public void finish(int resultCode, Bundle results) {
        try {
            Class rt = Class.forName("org.jacoco.agent.rt.RT");
            Method getAgent = rt.getMethod("getAgent");
            Method dump = getAgent.getReturnType().getMethod("dump", boolean.class);
            Object agent = getAgent.invoke(null);
            dump.invoke(agent, false);
        } catch (Exception e) {
            Log.e("szw JUnitJacocoTestRunner", e.getMessage());
            e.printStackTrace();
        }
        super.finish(resultCode, results);
    }
}
