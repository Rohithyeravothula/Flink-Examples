import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time.Time
/**
  * Created by rohith on 26/12/16.
  */
/*
* This is a word count example for streaming input of text
 * run this example, then try publishing text from socket using netcat
 *
 * command: nc -lk 9999
 *
 * you can see the work count for a window of 5 seconds
* */
object StreamingWordCount {
  def runExample(): Unit = {
    val sEn = StreamExecutionEnvironment.getExecutionEnvironment
    val textStream = sEn.socketTextStream("localhost", 9999)
    val counts =  textStream
                  .flatMap(_.toLowerCase().split("\\W+").filter(_.nonEmpty)).map{(_, 1)}.keyBy(0)
                    .timeWindow(Time.seconds(5)).sum(1)
    counts.print()
    sEn.execute("socket streaming word count example")
  }
}
