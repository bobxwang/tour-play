package others

import java.util.concurrent.atomic.AtomicLong

import com.google.inject.Singleton

trait Counter {

  def nextLong(): Long
}

@Singleton
class AtomicCounter extends Counter {

  private val atomicCounter = new AtomicLong()

  override def nextLong(): Long = atomicCounter.getAndIncrement
}