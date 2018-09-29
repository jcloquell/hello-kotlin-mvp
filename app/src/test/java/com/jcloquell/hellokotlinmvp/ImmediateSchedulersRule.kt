package com.jcloquell.hellokotlinmvp

import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import java.util.concurrent.TimeUnit

class ImmediateSchedulersRule : TestRule {

  override fun apply(base: Statement, description: Description): Statement =
      object : Statement() {

        override fun evaluate() {
          val immediate = object : Scheduler() {

            override fun scheduleDirect(@NonNull run: Runnable,
                delay: Long, @NonNull unit: TimeUnit): Disposable {
              return super.scheduleDirect(run, 0, unit)
            }

            override fun createWorker(): Scheduler.Worker {
              return ExecutorScheduler.ExecutorWorker { it.run() }
            }
          }
          RxJavaPlugins.setInitIoSchedulerHandler { immediate }
          RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
          RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
          RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
          RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
          try {
            base.evaluate()
          } finally {
            RxJavaPlugins.reset()
          }
        }
      }
}
