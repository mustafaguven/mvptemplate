package com.mavi.kartus.di.module.network;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;

@Qualifier @Retention(RetentionPolicy.RUNTIME) public @interface HeaderInterceptor {
}