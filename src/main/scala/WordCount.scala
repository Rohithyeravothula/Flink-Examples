import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.api.scala._

/**
  * Created by rohith on 26/12/16.
  */

object WordCount {
  def runExample(): Unit = {
    val eEnv =  ExecutionEnvironment.getExecutionEnvironment
    val text = eEnv.fromElements("hello flink this is a test to sample sentence to see how does wordcount example work on flink. Things seem" +
      "pretty awesome so far. Lets also see how does the streaming on flink work after this exaple")
    val counts = text.flatMap{ sent => sent.toLowerCase().split("\\W+")}.map((_, 1)).groupBy(0).sum(1)
    counts.print()
  }
}
