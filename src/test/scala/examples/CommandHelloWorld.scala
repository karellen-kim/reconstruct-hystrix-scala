package examples

import com.netflix.hystrix.HystrixCommand
import org.scalatest.{Matchers, WordSpec}

/**
  * Created by karellen.kim on 2018. 9. 17...
  */
class CommandHelloWorld(val name: String) extends HystrixCommand[String] {
  override def run(): String = "Hello " + name
}

class CommandHelloWorldApp extends WordSpec with Matchers {
  "HystrixCommand" should {
    "execute" in {
      new CommandHelloWorld("World").execute() shouldBe "Hello World"
    }
    "observe" in {
      val fWorld = new CommandHelloWorld("World").observe()
      fWorld.toBlocking().single() shouldBe "Hello World"
      fWorld.subscribe { str =>
        println(str)
      }
    }
  }
}