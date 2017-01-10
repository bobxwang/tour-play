package utils

/**
  * Created by bob on 16/10/12.
  */
class IdWorker(val workerId: Long, val datacenterId: Long, var sequence: Long = 0L) {

  // 自定义开始时间纪元
  val twepoch = 1288834974657L
  // 机器位标识
  private[this] val workerIdBits = 5L
  // 机器ID最大值
  private[this] val maxWorkerId = -1L ^ (-1L << workerIdBits)
  // 数据中心位标识
  private[this] val datacenterIdBits = 5L
  // 数据中心最大值
  private[this] val maxDatacenterId = -1L ^ (-1L << datacenterIdBits)
  // 毫秒内自增位
  private[this] val sequenceBits = 12L
  // 毫秒内最大值,即2的12次方
  private[this] val sequenceMask = -1L ^ (-1L << sequenceBits)
  // 机器ID左移12位
  private[this] val workerIdShift = sequenceBits
  // 数据中心ID左移17位
  private[this] val datacenterIdShift = sequenceBits + workerIdBits
  // 时间毫秒左移22位
  private[this] val timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits

  private[this] var lastTimestamp = -1L

  if (workerId > maxWorkerId || workerId < 0) {
    throw new IllegalArgumentException("worker Id can't be greater than %d or less than 0".format(maxWorkerId))
  }

  if (datacenterId > maxDatacenterId || datacenterId < 0) {
    throw new IllegalArgumentException("datacenter Id can't be greater than %d or less than 0".format(maxDatacenterId))
  }

  def get_id(): Long = {
    nextId()
  }

  protected def nextId(): Long = synchronized {
    var timestamp = timeGen()

    if (timestamp < lastTimestamp) {
      throw new Exception("Clock moved backwards.  Refusing to generate id for %d milliseconds".format(
        lastTimestamp - timestamp))
    }

    if (lastTimestamp == timestamp) {
      sequence = (sequence + 1) & sequenceMask
      if (sequence == 0) {
        timestamp = tilNextMillis(lastTimestamp)
      }
    } else {
      sequence = 0
    }

    lastTimestamp = timestamp
    val timestamptwepoch = timestamp - twepoch
    val a = ((timestamptwepoch) << timestampLeftShift)
    val b = (datacenterId << datacenterIdShift)
    val c = (workerId << workerIdShift)
    val d = a | b | c | sequence
    d
  }

  protected def tilNextMillis(lastTimestamp: Long): Long = {
    var timestamp = timeGen()
    while (timestamp <= lastTimestamp) {
      timestamp = timeGen()
    }
    timestamp
  }

  protected def timeGen(): Long = System.currentTimeMillis()
}